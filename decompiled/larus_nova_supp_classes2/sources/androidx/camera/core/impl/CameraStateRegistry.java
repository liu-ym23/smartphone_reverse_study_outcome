package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraStateRegistry implements CameraCoordinator.ConcurrentCameraModeListener {
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_CONCURRENT_MODE = 2;
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_SINGLE_MODE = 1;
    private static final String TAG = "CameraStateRegistry";
    private int mAvailableCameras;
    private final CameraCoordinator mCameraCoordinator;
    private final Map<Camera, CameraRegistration> mCameraStates;
    private final StringBuilder mDebugString;
    private final Object mLock;
    private int mMaxAllowedOpenedCameras;

    public static class CameraRegistration {
        private final Executor mNotifyExecutor;
        private final OnConfigureAvailableListener mOnConfigureAvailableListener;
        private final OnOpenAvailableListener mOnOpenAvailableListener;
        private CameraInternal.State mState;

        public void notifyOnConfigureAvailableListener() {
            Executor r0 = this.mNotifyExecutor;     // Catch: RejectedExecutionException -> L4
            final OnConfigureAvailableListener r1 = this.mOnConfigureAvailableListener;     // Catch: RejectedExecutionException -> L4
            Objects.requireNonNull(r1);     // Catch: RejectedExecutionException -> L4
            r0.execute(new h(r1));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to configure.", e);
        }

        public void notifyOnOpenAvailableListener() {
            Executor r0 = this.mNotifyExecutor;     // Catch: RejectedExecutionException -> L4
            final OnOpenAvailableListener r1 = this.mOnOpenAvailableListener;     // Catch: RejectedExecutionException -> L4
            Objects.requireNonNull(r1);     // Catch: RejectedExecutionException -> L4
            r0.execute(new g(r1));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to open.", e);
        }

        public CameraInternal.State getState() {
            return this.mState;
        }

        public CameraInternal.State setState(CameraInternal.State r2) {
            CameraInternal.State r0 = this.mState;
            this.mState = r2;
            return r0;
        }

        public CameraRegistration(CameraInternal.State r1, Executor r2, OnConfigureAvailableListener r3, OnOpenAvailableListener r4) {
            this.mState = r1;
            this.mNotifyExecutor = r2;
            this.mOnConfigureAvailableListener = r3;
            this.mOnOpenAvailableListener = r4;
        }
    }

    public interface OnConfigureAvailableListener {
        void onConfigureAvailable();
    }

    public interface OnOpenAvailableListener {
        void onOpenAvailable();
    }

    private void recalculateAvailableCameras() {
        if (Logger.isDebugEnabled(TAG) == false) goto L5;
        this.mDebugString.setLength(0);
        this.mDebugString.append("Recalculating open cameras:\n");
        this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{"Camera", "State"}));
        this.mDebugString.append("-------------------------------------------------------------------\n");
    L5:
        Iterator<Map.Entry<Camera, CameraRegistration>> r1 = this.mCameraStates.entrySet().iterator();
        int r7 = 0;
    L7:
        if (r1.hasNext() == false) goto L19;
        Map.Entry<Camera, CameraRegistration> r8 = r1.next();
        if (Logger.isDebugEnabled(TAG) == false) goto L16;
        if (r8.getValue().getState() == null) goto L13;
        String r9 = r8.getValue().getState().toString();
    L14:
        this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{r8.getKey().toString(), r9}));
        goto L16
    L13:
        r9 = "UNKNOWN";
    L16:
        if (isOpen(r8.getValue().getState()) == false) goto L7;
        r7 = r7 + 1;
        goto L7
    L19:
        if (Logger.isDebugEnabled(TAG) == false) goto L21;
        this.mDebugString.append("-------------------------------------------------------------------\n");
        this.mDebugString.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", new Object[]{Integer.valueOf(r7), Integer.valueOf(this.mMaxAllowedOpenedCameras)}));
        Logger.d(TAG, this.mDebugString.toString());
    L21:
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - r7, 0);
    }

    public boolean isCameraClosing() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Map.Entry<Camera, CameraRegistration>> r1 = this.mCameraStates.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r1.hasNext() == false) goto L12;
        if (r1.next().getValue().getState() != CameraInternal.State.CLOSING) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    private CameraRegistration getCameraRegistration(String r4) {
        Iterator<Camera> r0 = this.mCameraStates.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Camera r1 = r0.next();
        if (r4.equals(((CameraInfoInternal) r1.getCameraInfo()).getCameraId()) == false) goto L4;
        return this.mCameraStates.get(r1);
    L9:
        return null;
    }

    private static boolean isOpen(CameraInternal.State r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.holdsCameraSlot() == false) goto L6;
        return true;
    }

    private CameraInternal.State unregisterCamera(Camera r2) {
        CameraRegistration r3 = this.mCameraStates.remove(r2);
        if (r3 == null) goto L6;
        recalculateAvailableCameras();
        return r3.getState();
    L6:
        return null;
    }

    public boolean tryOpenCamera(Camera r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CameraRegistration r1 = (CameraRegistration) Preconditions.checkNotNull(this.mCameraStates.get(r11), "Camera must first be registered with registerCamera()");     // Catch: Throwable -> L25
        if (Logger.isDebugEnabled(TAG) == false) goto L8;
        this.mDebugString.setLength(0);     // Catch: Throwable -> L25
        this.mDebugString.append(String.format(Locale.US, "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]", new Object[]{r11, Integer.valueOf(this.mAvailableCameras), Boolean.valueOf(isOpen(r1.getState())), r1.getState()}));     // Catch: Throwable -> L25
    L8:
        if (this.mAvailableCameras <= 0) goto L10;
    L13:
        CameraInternal.State r2 = CameraInternal.State.OPENING;     // Catch: Throwable -> L25
        r1.setState(r2);     // Catch: Throwable -> L25
        traceState(r11, r2);     // Catch: Throwable -> L25
        boolean r12 = true;
    L15:
        if (Logger.isDebugEnabled(TAG) == false) goto L21;
        StringBuilder r3 = this.mDebugString;     // Catch: Throwable -> L25
        Locale r4 = Locale.US;     // Catch: Throwable -> L25
        Object[] r5 = new Object[1];     // Catch: Throwable -> L25
        if (r12 == false) goto L19;
        String r6 = "SUCCESS";
    L20:
        r5[0] = r6;     // Catch: Throwable -> L25
        r3.append(String.format(r4, " --> %s", r5));     // Catch: Throwable -> L25
        Logger.d(TAG, this.mDebugString.toString());     // Catch: Throwable -> L25
        goto L21
    L19:
        r6 = "FAIL";
    L21:
        if (r12 == false) goto L23;
        recalculateAvailableCameras();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return r12;
    L10:
        if (isOpen(r1.getState()) == true) goto L13;
        r12 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public CameraStateRegistry(CameraCoordinator r3, int r4) {
        this.mDebugString = new StringBuilder();
        Object r0 = new Object();
        this.mLock = r0;
        this.mCameraStates = new HashMap();
        this.mMaxAllowedOpenedCameras = r4;
        monitor-enter(r0);
        this.mCameraCoordinator = r3;     // Catch: Throwable -> L7
        this.mAvailableCameras = this.mMaxAllowedOpenedCameras;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void traceState(Camera r2, CameraInternal.State r3) {
        if (Trace.isEnabled() == false) goto L6;
        Trace.setCounter("CX:State[" + r2 + "]", r3.ordinal());
        return;
    }

    private CameraInternal.State updateAndVerifyState(Camera r4, CameraInternal.State r5) {
        CameraInternal.State r0 = ((CameraRegistration) Preconditions.checkNotNull(this.mCameraStates.get(r4), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(r5);
        CameraInternal.State r1 = CameraInternal.State.OPENING;
        if (r5 == r1) goto L5;
    L11:
        if (r0 == r5) goto L13;
        traceState(r4, r5);
        recalculateAvailableCameras();
    L13:
        return r0;
    L5:
        if (isOpen(r5) == true) goto L9;
        if (r0 == r1) goto L9;
        boolean r2 = false;
    L10:
        Preconditions.checkState(r2, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
    L9:
        r2 = true;
        goto L10
    }

    public void markCameraState(Camera r2, CameraInternal.State r3) {
        markCameraState(r2, r3, true);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator.ConcurrentCameraModeListener
    public void onCameraOperatingModeUpdated(int r6, int r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = true;
        if (r7 != 2) goto L7;
        int r3 = 2;
    L25:
        this.mMaxAllowedOpenedCameras = r3;     // Catch: Throwable -> L22
        if (r6 == 2) goto L12;
        if (r7 != 2) goto L12;
        boolean r4 = true;
    L13:
        if (r6 != 2) goto L16;
        if (r7 == 2) goto L16;
    L17:
        if (r4 == true) goto L19;
        if (r1 == true) goto L19;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L19:
        recalculateAvailableCameras();     // Catch: Throwable -> L22
    L16:
        r1 = false;
    L12:
        r4 = false;
    L22:
        th = move-exception;
        throw th;
    L7:
        r3 = 1;
        goto L25
    }

    public boolean tryOpenCaptureSession(String r6, String r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r3 = true;
        if (this.mCameraCoordinator.getCameraOperatingMode() == 2) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L37
        return true;
    L8:
        CameraRegistration r8 = getCameraRegistration(r6);     // Catch: Throwable -> L37
        CameraInternal.State r1 = null;
        if (r8 == null) goto L11;
        CameraInternal.State r9 = r8.getState();     // Catch: Throwable -> L37
    L12:
        if (r7 == null) goto L14;
        CameraRegistration r10 = getCameraRegistration(r7);     // Catch: Throwable -> L37
    L15:
        if (r10 == null) goto L17;
        r1 = r10.getState();     // Catch: Throwable -> L37
    L17:
        CameraInternal.State r11 = CameraInternal.State.OPEN;     // Catch: Throwable -> L37
        if (r11.equals(r9) == false) goto L20;
    L23:
        boolean r12 = true;
    L25:
        if (r11.equals(r1) == false) goto L27;
    L30:
        boolean r13 = true;
    L31:
        if (r12 == false) goto L34;
        if (r13 == false) goto L34;
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L37
        return r3;
    L34:
        r3 = false;
        goto L35
    L27:
        if (CameraInternal.State.CONFIGURED.equals(r1) == true) goto L30;
        r13 = false;
        goto L31
    L20:
        if (CameraInternal.State.CONFIGURED.equals(r9) == true) goto L23;
        r12 = false;
        goto L25
    L14:
        r10 = null;
        goto L15
    L11:
        r9 = null;
    L37:
        th = move-exception;
        throw th;
    }

    public void markCameraState(Camera r7, CameraInternal.State r8, boolean r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mAvailableCameras;     // Catch: Throwable -> L46
        if (r8 != CameraInternal.State.RELEASED) goto L7;
        CameraInternal.State r2 = unregisterCamera(r7);     // Catch: Throwable -> L46
    L8:
        if (r2 != r8) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L46
        return;
    L11:
        HashMap r4 = null;
        if (this.mCameraCoordinator.getCameraOperatingMode() == 2) goto L14;
    L18:
        CameraRegistration r3 = null;
    L20:
        if (r1 >= 1) goto L30;
        if (this.mAvailableCameras <= 0) goto L30;
        r4 = new HashMap();     // Catch: Throwable -> L46
        Iterator<Map.Entry<Camera, CameraRegistration>> r10 = this.mCameraStates.entrySet().iterator();     // Catch: Throwable -> L46
    L25:
        if (r10.hasNext() == false) goto L34;
        Map.Entry<Camera, CameraRegistration> r5 = r10.next();     // Catch: Throwable -> L46
        if (r5.getValue().getState() != CameraInternal.State.PENDING_OPEN) goto L25;
        r4.put(r5.getKey(), r5.getValue());     // Catch: Throwable -> L46
    L34:
        if (r4 == null) goto L37;
        if (r9 == true) goto L37;
        r4.remove(r7);     // Catch: Throwable -> L46
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L46
        if (r4 == null) goto L43;
        Iterator r11 = r4.values().iterator();
    L41:
        if (r11.hasNext() == false) goto L43;
        ((CameraRegistration) r11.next()).notifyOnOpenAvailableListener();
    L43:
        if (r3 == null) goto L56;
        r3.notifyOnConfigureAvailableListener();
        return;
    L56:
        return;
    L30:
        if (r8 != CameraInternal.State.PENDING_OPEN) goto L34;
        if (this.mAvailableCameras <= 0) goto L34;
        r4 = new HashMap();     // Catch: Throwable -> L46
        r4.put(r7, this.mCameraStates.get(r7));     // Catch: Throwable -> L46
        goto L34
    L14:
        if (r8 != CameraInternal.State.CONFIGURED) goto L18;
        String r6 = this.mCameraCoordinator.getPairedConcurrentCameraId(((CameraInfoInternal) r7.getCameraInfo()).getCameraId());     // Catch: Throwable -> L46
        if (r6 == null) goto L18;
        r3 = getCameraRegistration(r6);     // Catch: Throwable -> L46
        goto L20
    L7:
        r2 = updateAndVerifyState(r7, r8);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public void registerCamera(Camera r5, Executor r6, OnConfigureAvailableListener r7, OnOpenAvailableListener r8) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameraStates.containsKey(r5) == true) goto L7;
        boolean r2 = true;
    L8:
        Preconditions.checkState(r2, "Camera is already registered: " + r5);     // Catch: Throwable -> L11
        this.mCameraStates.put(r5, new CameraRegistration(null, r6, r7, r8));     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        r2 = false;
        goto L8
    }
}
