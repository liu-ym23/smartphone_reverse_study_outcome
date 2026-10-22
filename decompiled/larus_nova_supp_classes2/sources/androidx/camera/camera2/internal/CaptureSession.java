package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.internal.compat.workaround.TorchStateReset;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.SurfaceUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class CaptureSession implements CaptureSessionInterface {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    private final boolean mCanUseMultiResolutionImageReader;
    private final List<CaptureConfig> mCaptureConfigs;
    private final StateCallback mCaptureSessionStateCallback;
    List<DeferrableSurface> mConfiguredDeferrableSurfaces;
    private final Map<DeferrableSurface, Surface> mConfiguredSurfaceMap;
    private final DynamicRangesCompat mDynamicRangesCompat;
    CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;
    ListenableFuture<Void> mReleaseFuture;
    private final RequestMonitor mRequestMonitor;
    SessionConfig mSessionConfig;
    final Object mSessionLock;
    SynchronizedCaptureSession.Opener mSessionOpener;
    State mState;
    private final StillCaptureFlow mStillCaptureFlow;
    private Map<DeferrableSurface, Long> mStreamUseCaseMap;
    SynchronizedCaptureSession mSynchronizedCaptureSession;
    private final TemplateParamsOverride mTemplateParamsOverride;
    private final TorchStateReset mTorchStateReset;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CLOSED = null;
        public static final State GET_SURFACE = null;
        public static final State INITIALIZED = null;
        public static final State OPENED = null;
        public static final State OPENING = null;
        public static final State RELEASED = null;
        public static final State RELEASING = null;
        public static final State UNINITIALIZED = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{UNINITIALIZED, INITIALIZED, GET_SURFACE, OPENING, OPENED, CLOSED, RELEASING, RELEASED};
        }

        static {
            UNINITIALIZED = new State("UNINITIALIZED", 0);
            INITIALIZED = new State("INITIALIZED", 1);
            GET_SURFACE = new State("GET_SURFACE", 2);
            OPENING = new State("OPENING", 3);
            OPENED = new State("OPENED", 4);
            CLOSED = new State("CLOSED", 5);
            RELEASING = new State("RELEASING", 6);
            RELEASED = new State("RELEASED", 7);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final class StateCallback extends SynchronizedCaptureSession.StateCallback {
        final /* synthetic */ CaptureSession this$0;

        public StateCallback(CaptureSession r1) {
            this.this$0 = r1;
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigureFailed(SynchronizedCaptureSession r4) {
            Object r1 = this.this$0.mSessionLock;
            monitor-enter(r1);
        L14:
            th = move-exception;
            throw th;
        L5:
            switch(this.this$0.mState.ordinal()) {
                case 0: goto L10;
                case 1: goto L10;
                case 2: goto L10;
                case 3: goto L8;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L11;
            };     // Catch: Throwable -> L14
        L7:
            Logger.d(CaptureSession.TAG, "ConfigureFailed callback after change to RELEASED state");     // Catch: Throwable -> L14
            goto L11
        L8:
            this.this$0.finishClose();     // Catch: Throwable -> L14
        L11:
            Logger.e(CaptureSession.TAG, "CameraCaptureSession.onConfigureFailed() " + this.this$0.mState);     // Catch: Throwable -> L14
            monitor-exit(r1);     // Catch: Throwable -> L14
            return;
        L10:
            throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + this.this$0.mState);     // Catch: Throwable -> L14
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigured(SynchronizedCaptureSession r5) {
            Object r2 = this.this$0.mSessionLock;
            monitor-enter(r2);
        L15:
            th = move-exception;
            throw th;
        L5:
            switch(this.this$0.mState.ordinal()) {
                case 0: goto L11;
                case 1: goto L11;
                case 2: goto L11;
                case 3: goto L9;
                case 4: goto L11;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L11;
                default: goto L12;
            };     // Catch: Throwable -> L15
        L7:
            r5.close();     // Catch: Throwable -> L15
            goto L12
        L8:
            this.this$0.mSynchronizedCaptureSession = r5;     // Catch: Throwable -> L15
            goto L12
        L9:
            CaptureSession r0 = this.this$0;     // Catch: Throwable -> L15
            r0.mState = State.OPENED;     // Catch: Throwable -> L15
            r0.mSynchronizedCaptureSession = r5;     // Catch: Throwable -> L15
            Logger.d(CaptureSession.TAG, "Attempting to send capture request onConfigured");     // Catch: Throwable -> L15
            CaptureSession r6 = this.this$0;     // Catch: Throwable -> L15
            r6.issueRepeatingCaptureRequests(r6.mSessionConfig);     // Catch: Throwable -> L15
            this.this$0.issuePendingCaptureRequest();     // Catch: Throwable -> L15
        L12:
            Logger.d(CaptureSession.TAG, "CameraCaptureSession.onConfigured() mState=" + this.this$0.mState);     // Catch: Throwable -> L15
            monitor-exit(r2);     // Catch: Throwable -> L15
            return;
        L11:
            throw new IllegalStateException("onConfigured() should not be possible in state: " + this.this$0.mState);     // Catch: Throwable -> L15
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onReady(SynchronizedCaptureSession r4) {
            Object r1 = this.this$0.mSessionLock;
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mState.ordinal() == 0) goto L10;
            Logger.d(CaptureSession.TAG, "CameraCaptureSession.onReady() " + this.this$0.mState);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L10:
            throw new IllegalStateException("onReady() should not be possible in state: " + this.this$0.mState);     // Catch: Throwable -> L11
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSessionFinished(SynchronizedCaptureSession r4) {
            Object r0 = this.this$0.mSessionLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mState == State.UNINITIALIZED) goto L10;
            Logger.d(CaptureSession.TAG, "onSessionFinished()");     // Catch: Throwable -> L11
            this.this$0.finishClose();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L10:
            throw new IllegalStateException("onSessionFinished() should not be possible in state: " + this.this$0.mState);     // Catch: Throwable -> L11
        }
    }

    public static /* synthetic */ Object a(CaptureSession r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$release$1(r1);
    }

    public static /* synthetic */ void b(CaptureSession r0, CameraCaptureSession r1, int r2, boolean r3) {
        r0.lambda$issueBurstCaptureRequest$3(r1, r2, r3);
    }

    public static /* synthetic */ void c(CaptureSession r0) {
        r0.lambda$issuePendingCaptureRequest$2();
    }

    public static /* synthetic */ ListenableFuture d(CaptureSession r0, SessionConfig r1, CameraDevice r2, List r3) {
        return r0.lambda$open$0(r1, r2, r3);
    }

    private /* synthetic */ void lambda$issuePendingCaptureRequest$2() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mCaptureConfigs.isEmpty() == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L19:
        issueBurstCaptureRequest(this.mCaptureConfigs);     // Catch: Throwable -> L12
        this.mCaptureConfigs.clear();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        th = move-exception;
        this.mCaptureConfigs.clear();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    }

    public void abortCaptures() {
        Object r1 = this.mSessionLock;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == State.OPENED) goto L19;
        Logger.e(TAG, "Unable to abort captures. Incorrect state:" + this.mState);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L19:
        this.mSynchronizedCaptureSession.abortCaptures();     // Catch: CameraAccessException -> L11 Throwable -> L15
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L11:
        e = move-exception;
        Logger.e(TAG, "Unable to abort captures.", e);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void cancelIssuedCaptureRequests() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mCaptureConfigs.isEmpty() == true) goto L7;
        ArrayList r1 = new ArrayList(this.mCaptureConfigs);     // Catch: Throwable -> L18
        this.mCaptureConfigs.clear();     // Catch: Throwable -> L18
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L18
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L25;
        CaptureConfig r3 = (CaptureConfig) r2.next();
        Iterator<CameraCaptureCallback> r4 = r3.getCameraCaptureCallbacks().iterator();
    L15:
        if (r4.hasNext() == false) goto L12;
        r4.next().onCaptureCancelled(r3.getId());
        goto L15
    L25:
        return;
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        Object r3 = this.mSessionLock;
        monitor-enter(r3);
        int r4 = this.mState.ordinal();     // Catch: Throwable -> L22
        if (r4 == 0) goto L21;
        if (r4 != 1) goto L9;
    L17:
        this.mState = State.RELEASED;     // Catch: Throwable -> L22
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L9:
        if (r4 != 2) goto L11;
        Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:" + this.mState);     // Catch: Throwable -> L22
        this.mSessionOpener.stop();     // Catch: Throwable -> L22
        goto L17
    L11:
        if (r4 != 3) goto L13;
    L15:
        Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:" + this.mState);     // Catch: Throwable -> L22
        this.mSessionOpener.stop();     // Catch: Throwable -> L22
        this.mState = State.CLOSED;     // Catch: Throwable -> L22
        this.mRequestMonitor.stop();     // Catch: Throwable -> L22
        this.mSessionConfig = null;     // Catch: Throwable -> L22
        goto L18
    L13:
        if (r4 == 4) goto L15;
    L21:
        throw new IllegalStateException("close() should not be possible in state: " + this.mState);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public void finishClose() {
        State r0 = this.mState;
        State r1 = State.RELEASED;
        if (r0 != r1) goto L6;
        Logger.d(TAG, "Skipping finishClose due to being state RELEASED.");
        return;
    L6:
        this.mState = r1;
        this.mSynchronizedCaptureSession = null;
        CallbackToFutureAdapter.Completer<Void> r2 = this.mReleaseCompleter;
        if (r2 == null) goto L10;
        r2.set(null);
        this.mReleaseCompleter = null;
        return;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public List<CaptureConfig> getCaptureConfigs() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        List<CaptureConfig> r1 = Collections.unmodifiableList(this.mCaptureConfigs);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public SessionConfig getSessionConfig() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        SessionConfig r1 = this.mSessionConfig;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public State getState() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        State r1 = this.mState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public boolean isInOpenState() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        State r1 = this.mState;     // Catch: Throwable -> L13
        if (r1 != State.OPENED) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (r1 == State.OPENING) goto L10;
        r2 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public void issuePendingCaptureRequest() {
        this.mRequestMonitor.getRequestsProcessedFuture().addListener(new y1(this), CameraXExecutors.directExecutor());
    }

    public void stopRepeating() {
        Object r1 = this.mSessionLock;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == State.OPENED) goto L19;
        Logger.e(TAG, "Unable to stop repeating. Incorrect state:" + this.mState);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L19:
        this.mSynchronizedCaptureSession.stopRepeating();     // Catch: CameraAccessException -> L11 Throwable -> L15
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L11:
        e = move-exception;
        Logger.e(TAG, "Unable to stop repeating.", e);     // Catch: Throwable -> L15
        goto L13
    }

    public CaptureSession(DynamicRangesCompat r2) {
        this(r2, false);
    }

    public static /* synthetic */ TorchStateReset access$000(CaptureSession r0) {
        return r0.mTorchStateReset;
    }

    private List<OutputConfigurationCompat> getUniqueOutputConfigurations(List<OutputConfigurationCompat> r5) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<OutputConfigurationCompat> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        OutputConfigurationCompat r2 = r6.next();
        if (r0.contains(r2.getSurface()) == true) goto L4;
        r0.add(r2.getSurface());
        r1.add(r2);
        goto L4
    L9:
        return r1;
    }

    private static Map<Integer, List<SessionConfig.OutputConfig>> groupMrirOutputConfigs(Collection<SessionConfig.OutputConfig> r5) {
        HashMap r0 = new HashMap();
        Iterator<SessionConfig.OutputConfig> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        SessionConfig.OutputConfig r1 = r6.next();
        if (r1.getSurfaceGroupId() <= 0) goto L4;
        if (r1.getSharedSurfaces().isEmpty() == false) goto L4;
        List r2 = (List) r0.get(Integer.valueOf(r1.getSurfaceGroupId()));
        if (r2 != null) goto L13;
        r2 = new ArrayList();
        r0.put(Integer.valueOf(r1.getSurfaceGroupId()), r2);
    L13:
        r2.add(r1);
        goto L4
    L14:
        HashMap r7 = new HashMap();
        Iterator r3 = r0.keySet().iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        int r4 = ((Integer) r3.next()).intValue();
        if (((List) r0.get(Integer.valueOf(r4))).size() < 2) goto L16;
        r7.put(Integer.valueOf(r4), (List) r0.get(Integer.valueOf(r4)));
        goto L16
    L20:
        return r7;
    }

    private /* synthetic */ Object lambda$release$1(CallbackToFutureAdapter.Completer r5) throws Exception {
        Object r1 = this.mSessionLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mReleaseCompleter != null) goto L7;
        boolean r2 = true;
    L8:
        Preconditions.checkState(r2, "Release completer expected to be null");     // Catch: Throwable -> L11
        this.mReleaseCompleter = r5;     // Catch: Throwable -> L11
        String r6 = "Release[session=" + this + "]";     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r6;
    L7:
        r2 = false;
        goto L8
    }

    public int issueBurstCaptureRequest(List<CaptureConfig> r13) {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L66:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == State.OPENED) goto L10;
        Logger.d(TAG, "Skipping issueBurstCaptureRequest due to session closed");     // Catch: Throwable -> L66
        monitor-exit(r0);     // Catch: Throwable -> L66
        return -1;
    L10:
        if (r13.isEmpty() == false) goto L69;
        monitor-exit(r0);     // Catch: Throwable -> L66
        return -1;
    L69:
        CameraBurstCaptureCallback r1 = new CameraBurstCaptureCallback();     // Catch: CameraAccessException -> L62 Throwable -> L66
        ArrayList r2 = new ArrayList();     // Catch: CameraAccessException -> L62 Throwable -> L66
        Logger.d(TAG, "Issuing capture request.");     // Catch: CameraAccessException -> L62 Throwable -> L66
        Iterator<CaptureConfig> r14 = r13.iterator();     // Catch: CameraAccessException -> L62 Throwable -> L66
        boolean r5 = false;
    L15:
        if (r14.hasNext() == false) goto L50;
        CaptureConfig r6 = r14.next();     // Catch: CameraAccessException -> L62 Throwable -> L66
        if (r6.getSurfaces().isEmpty() == true) goto L18;
        Iterator<DeferrableSurface> r8 = r6.getSurfaces().iterator();     // Catch: CameraAccessException -> L62 Throwable -> L66
    L21:
        if (r8.hasNext() == false) goto L25;
        DeferrableSurface r9 = r8.next();     // Catch: CameraAccessException -> L62 Throwable -> L66
        if (this.mConfiguredSurfaceMap.containsKey(r9) == true) goto L21;
        Logger.d(TAG, "Skipping capture request with invalid surface: " + r9);     // Catch: CameraAccessException -> L62 Throwable -> L66
        boolean r10 = false;
    L26:
        if (r10 == false) goto L15;
        if (r6.getTemplateType() != 2) goto L31;
        r5 = true;
    L31:
        CaptureConfig.Builder r7 = CaptureConfig.Builder.from(r6);     // Catch: CameraAccessException -> L62 Throwable -> L66
        if (r6.getTemplateType() == 5) goto L34;
    L36:
        SessionConfig r11 = this.mSessionConfig;     // Catch: CameraAccessException -> L62 Throwable -> L66
        if (r11 == null) goto L39;
        r7.addImplementationOptions(r11.getRepeatingCaptureConfig().getImplementationOptions());     // Catch: CameraAccessException -> L62 Throwable -> L66
    L39:
        r7.addImplementationOptions(r6.getImplementationOptions());     // Catch: CameraAccessException -> L62 Throwable -> L66
        CaptureRequest r12 = Camera2CaptureRequestBuilder.build(r7.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap, false, this.mTemplateParamsOverride);     // Catch: CameraAccessException -> L62 Throwable -> L66
        if (r12 == null) goto L41;
        ArrayList r15 = new ArrayList();     // Catch: CameraAccessException -> L62 Throwable -> L66
        Iterator<CameraCaptureCallback> r16 = r6.getCameraCaptureCallbacks().iterator();     // Catch: CameraAccessException -> L62 Throwable -> L66
    L46:
        if (r16.hasNext() == false) goto L48;
        CaptureCallbackConverter.toCaptureCallback(r16.next(), r15);     // Catch: CameraAccessException -> L62 Throwable -> L66
        goto L46
    L48:
        r1.addCamera2Callbacks(r12, r15);     // Catch: CameraAccessException -> L62 Throwable -> L66
        r2.add(r12);     // Catch: CameraAccessException -> L62 Throwable -> L66
        goto L15
    L41:
        Logger.d(TAG, "Skipping issuing request without surface.");     // Catch: CameraAccessException -> L62 Throwable -> L66
        monitor-exit(r0);     // Catch: Throwable -> L66
        return -1;
    L34:
        if (r6.getCameraCaptureResult() == null) goto L36;
        r7.setCameraCaptureResult(r6.getCameraCaptureResult());     // Catch: CameraAccessException -> L62 Throwable -> L66
        goto L36
    L25:
        r10 = true;
        goto L26
    L18:
        Logger.d(TAG, "Skipping issuing empty capture request.");     // Catch: CameraAccessException -> L62 Throwable -> L66
        goto L15
    L50:
        if (r2.isEmpty() == false) goto L52;
        Logger.d(TAG, "Skipping issuing burst request due to no valid request elements");     // Catch: CameraAccessException -> L62 Throwable -> L66
    L64:
        monitor-exit(r0);     // Catch: Throwable -> L66
        return -1;
    L52:
        if (this.mStillCaptureFlow.shouldStopRepeatingBeforeCapture(r2, r5) == false) goto L55;
        this.mSynchronizedCaptureSession.stopRepeating();     // Catch: CameraAccessException -> L62 Throwable -> L66
        r1.setCaptureSequenceCallback(new x1(this));     // Catch: CameraAccessException -> L62 Throwable -> L66
    L55:
        if (this.mTorchStateReset.isTorchResetRequired(r2, r5) == false) goto L57;
        r1.addCamera2Callbacks((CaptureRequest) r2.get(r2.size() - 1), Collections.singletonList(new AnonymousClass2(this)));     // Catch: CameraAccessException -> L62 Throwable -> L66
    L57:
        int r17 = this.mSynchronizedCaptureSession.captureBurstRequests(r2, r1);     // Catch: CameraAccessException -> L62 Throwable -> L66
        monitor-exit(r0);     // Catch: Throwable -> L66
        return r17;
    L62:
        e = move-exception;
        Logger.e(TAG, "Unable to access camera: " + e.getMessage());     // Catch: Throwable -> L66
        Thread.dumpStack();     // Catch: Throwable -> L66
        goto L64
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void issueCaptureRequests(List<CaptureConfig> r4) {
        Object r1 = this.mSessionLock;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        switch(this.mState.ordinal()) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            default: goto L13;
        };     // Catch: Throwable -> L15
    L9:
        this.mCaptureConfigs.addAll(r4);     // Catch: Throwable -> L15
        issuePendingCaptureRequest();     // Catch: Throwable -> L15
        goto L13
    L10:
        this.mCaptureConfigs.addAll(r4);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L8:
        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");     // Catch: Throwable -> L15
    L12:
        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);     // Catch: Throwable -> L15
    }

    public int issueRepeatingCaptureRequests(SessionConfig r8) {
        Object r2 = this.mSessionLock;
        monitor-enter(r2);
        if (r8 != null) goto L10;
        Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no configuration case.");     // Catch: Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        return -1;
    L10:
        if (this.mState == State.OPENED) goto L14;
        Logger.d(TAG, "Skipping issueRepeatingCaptureRequests due to session closed");     // Catch: Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        return -1;
    L14:
        CaptureConfig r9 = r8.getRepeatingCaptureConfig();     // Catch: Throwable -> L35
        if (r9.getSurfaces().isEmpty() == false) goto L38;
        Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no surface.");     // Catch: Throwable -> L35
        this.mSynchronizedCaptureSession.stopRepeating();     // Catch: CameraAccessException -> L19 Throwable -> L35
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L35
        return -1;
    L19:
        e = move-exception;
        Logger.e(TAG, "Unable to access camera: " + e.getMessage());     // Catch: Throwable -> L35
        Thread.dumpStack();     // Catch: Throwable -> L35
        goto L21
    L38:
        Logger.d(TAG, "Issuing request for session.");     // Catch: CameraAccessException -> L31 Throwable -> L35
        CaptureRequest r0 = Camera2CaptureRequestBuilder.build(r9, this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap, true, this.mTemplateParamsOverride);     // Catch: CameraAccessException -> L31 Throwable -> L35
        if (r0 != null) goto L28;
        Logger.d(TAG, "Skipping issuing empty request for session.");     // Catch: CameraAccessException -> L31 Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        return -1;
    L28:
        int r10 = this.mSynchronizedCaptureSession.setSingleRepeatingRequest(r0, this.mRequestMonitor.createMonitorListener(createCamera2CaptureCallback(r9.getCameraCaptureCallbacks(), new CameraCaptureSession.CaptureCallback[0])));     // Catch: CameraAccessException -> L31 Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        return r10;
    L31:
        e = move-exception;
        Logger.e(TAG, "Unable to access camera: " + e.getMessage());     // Catch: Throwable -> L35
        Thread.dumpStack();     // Catch: Throwable -> L35
        return -1;
    L35:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> release(boolean r6) {
        Object r3 = this.mSessionLock;
        monitor-enter(r3);
    L31:
        th = move-exception;
        throw th;
    L5:
        switch(this.mState.ordinal()) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L15;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L19;
            default: goto L28;
        };     // Catch: Throwable -> L31
    L7:
        SynchronizedCaptureSession r1 = this.mSynchronizedCaptureSession;     // Catch: Throwable -> L31
        if (r1 == null) goto L15;
        if (r6 == true) goto L34;
    L14:
        this.mSynchronizedCaptureSession.close();     // Catch: Throwable -> L31
        goto L15
    L34:
        r1.abortCaptures();     // Catch: CameraAccessException -> L12 Throwable -> L31
    L12:
        e = move-exception;
        Logger.e(TAG, "Unable to abort captures.", e);     // Catch: Throwable -> L31
    L15:
        this.mState = State.RELEASING;     // Catch: Throwable -> L31
        this.mRequestMonitor.stop();     // Catch: Throwable -> L31
        Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:" + this.mState);     // Catch: Throwable -> L31
        if (this.mSessionOpener.stop() == false) goto L19;
        finishClose();     // Catch: Throwable -> L31
        goto L28
    L24:
        Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:" + this.mState);     // Catch: Throwable -> L31
        this.mSessionOpener.stop();     // Catch: Throwable -> L31
    L25:
        this.mState = State.RELEASED;     // Catch: Throwable -> L31
    L28:
        monitor-exit(r3);     // Catch: Throwable -> L31
        return Futures.immediateFuture(null);
    L19:
        if (this.mReleaseFuture != null) goto L21;
        this.mReleaseFuture = CallbackToFutureAdapter.getFuture(new z1(this));     // Catch: Throwable -> L31
    L21:
        ListenableFuture<Void> r7 = this.mReleaseFuture;     // Catch: Throwable -> L31
        monitor-exit(r3);     // Catch: Throwable -> L31
        return r7;
    L27:
        throw new IllegalStateException("release() should not be possible in state: " + this.mState);     // Catch: Throwable -> L31
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setSessionConfig(SessionConfig r4) {
        Object r1 = this.mSessionLock;
        monitor-enter(r1);
    L24:
        th = move-exception;
        throw th;
    L5:
        switch(this.mState.ordinal()) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            default: goto L22;
        };     // Catch: Throwable -> L24
    L9:
        this.mSessionConfig = r4;     // Catch: Throwable -> L24
        if (r4 != null) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L14:
        if (this.mConfiguredSurfaceMap.keySet().containsAll(r4.getSurfaces()) == true) goto L18;
        Logger.e(TAG, "Does not have the proper configured lists");     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L18:
        Logger.d(TAG, "Attempting to submit CaptureRequest after setting");     // Catch: Throwable -> L24
        issueRepeatingCaptureRequests(this.mSessionConfig);     // Catch: Throwable -> L24
        goto L22
    L19:
        this.mSessionConfig = r4;     // Catch: Throwable -> L24
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L8:
        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");     // Catch: Throwable -> L24
    L21:
        throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.mState);     // Catch: Throwable -> L24
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setStreamUseCaseMap(Map<DeferrableSurface, Long> r2) {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        this.mStreamUseCaseMap = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public CaptureSession(DynamicRangesCompat r3, boolean r4) {
        this(r3, new Quirks(Collections.emptyList()), r4);
    }

    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> r4, CameraCaptureSession.CaptureCallback... r5) {
        ArrayList r0 = new ArrayList(r4.size() + r5.length);
        Iterator<CameraCaptureCallback> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(CaptureCallbackConverter.toCaptureCallback(r6.next()));
        goto L4
    L6:
        Collections.addAll(r0, r5);
        return Camera2CaptureCallbacks.createComboCallback(r0);
    }

    private static List<OutputConfiguration> createInstancesForMultiResolutionOutput(List<MultiResolutionStreamInfo> r8, int r9) {
        return (List) OutputConfiguration.class.getMethod("createInstancesForMultiResolutionOutput", new Class[]{Collection.class, Integer.TYPE}).invoke(null, new Object[]{r8, Integer.valueOf(r9)});
    L7:
        e = move-exception;
        Logger.e(TAG, "Failed to create instances for multi-resolution output, " + e.getMessage());
        return null;
    }

    private static Map<SessionConfig.OutputConfig, OutputConfigurationCompat> createMultiResolutionOutputConfigurationCompats(Map<Integer, List<SessionConfig.OutputConfig>> r12, Map<DeferrableSurface, Surface> r13) {
        HashMap r0 = new HashMap();
        Iterator<Integer> r1 = r12.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L23;
        int r2 = r1.next().intValue();
        ArrayList r3 = new ArrayList();
        Iterator<SessionConfig.OutputConfig> r4 = r12.get(Integer.valueOf(r2)).iterator();
        int r6 = 0;
    L7:
        if (r4.hasNext() == false) goto L12;
        SessionConfig.OutputConfig r7 = r4.next();
        SurfaceUtil.SurfaceInfo r8 = SurfaceUtil.getSurfaceInfo(r13.get(r7.getSurface()));
        if (r6 != 0) goto L11;
        r6 = r8.format;
    L11:
        int r10 = r8.width;
        int r9 = r8.height;
        String r11 = r7.getPhysicalCameraId();
        Objects.requireNonNull(r11);
        r3.add(new MultiResolutionStreamInfo(r10, r9, r11));
        goto L7
    L12:
        if (r6 == 0) goto L22;
        if (r3.isEmpty() == true) goto L22;
        List<OutputConfiguration> r5 = createInstancesForMultiResolutionOutput(r3, r6);
        if (r5 == null) goto L4;
        Iterator<SessionConfig.OutputConfig> r14 = r12.get(Integer.valueOf(r2)).iterator();
    L20:
        if (r14.hasNext() == false) goto L4;
        SessionConfig.OutputConfig r15 = r14.next();
        OutputConfiguration r16 = (OutputConfiguration) ListProtector.remove(r5, 0);
        r16.addSurface(r13.get(r15.getSurface()));
        r0.put(r15, new OutputConfigurationCompat(r16));
    L22:
        Logger.e(TAG, "Skips to create instances for multi-resolution output. imageFormat: " + r6 + ", streamInfos size: " + r3.size());
        goto L4
    L23:
        return r0;
    }

    public CaptureSession(DynamicRangesCompat r2, Quirks r3) {
        this(r2, r3, false);
    }

    public CaptureSession(DynamicRangesCompat r2, Quirks r3, boolean r4) {
        this.mSessionLock = new Object();
        this.mCaptureConfigs = new ArrayList();
        this.mConfiguredSurfaceMap = new HashMap();
        this.mConfiguredDeferrableSurfaces = Collections.emptyList();
        this.mState = State.UNINITIALIZED;
        this.mStreamUseCaseMap = new HashMap();
        this.mStillCaptureFlow = new StillCaptureFlow();
        this.mTorchStateReset = new TorchStateReset();
        this.mState = State.INITIALIZED;
        this.mDynamicRangesCompat = r2;
        this.mCaptureSessionStateCallback = new StateCallback(this);
        this.mRequestMonitor = new RequestMonitor(r3.contains(CaptureNoResponseQuirk.class));
        this.mTemplateParamsOverride = new TemplateParamsOverride(r3);
        this.mCanUseMultiResolutionImageReader = r4;
    }

    private OutputConfigurationCompat getOutputConfigurationCompat(SessionConfig.OutputConfig r5, Map<DeferrableSurface, Surface> r6, String r7) {
        Surface r0 = r6.get(r5.getSurface());
        Preconditions.checkNotNull(r0, "Surface in OutputConfig not found in configuredSurfaceMap.");
        OutputConfigurationCompat r2 = new OutputConfigurationCompat(r5.getSurfaceGroupId(), r0);
        if (r7 == null) goto L5;
        r2.setPhysicalCameraId(r7);
    L7:
        if (r5.getMirrorMode() != 0) goto L10;
        r2.setMirrorMode(1);
    L13:
        if (r5.getSharedSurfaces().isEmpty() == true) goto L19;
        r2.enableSurfaceSharing();
        Iterator<DeferrableSurface> r8 = r5.getSharedSurfaces().iterator();
    L16:
        if (r8.hasNext() == false) goto L19;
        Surface r1 = r6.get(r8.next());
        Preconditions.checkNotNull(r1, "Surface in OutputConfig not found in configuredSurfaceMap.");
        r2.addSurface(r1);
    L19:
        if (Build.VERSION.SDK_INT < 33) goto L26;
        DynamicRangeProfiles r9 = this.mDynamicRangesCompat.toDynamicRangeProfiles();
        if (r9 == null) goto L26;
        DynamicRange r10 = r5.getDynamicRange();
        Long r11 = DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(r10, r9);
        if (r11 != null) goto L25;
        Logger.e(TAG, "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + r10);
        goto L26
    L25:
        long r12 = r11.longValue();
    L27:
        r2.setDynamicRangeProfile(r12);
        return r2;
    L26:
        r12 = 1;
        goto L27
    L10:
        if (r5.getMirrorMode() != 1) goto L13;
        r2.setMirrorMode(2);
        goto L13
    L5:
        r2.setPhysicalCameraId(r5.getPhysicalCameraId());
        goto L7
    }

    private /* synthetic */ void lambda$issueBurstCaptureRequest$3(CameraCaptureSession r1, int r2, boolean r3) {
        Object r4 = this.mSessionLock;
        monitor-enter(r4);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != State.OPENED) goto L7;
        issueRepeatingCaptureRequests(this.mSessionConfig);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r4);     // Catch: Throwable -> L9
    }

    private /* synthetic */ ListenableFuture lambda$open$0(SessionConfig r1, CameraDevice r2, List r3) throws Exception {
        return openCaptureSession(r3, r1, r2);
    }

    private ListenableFuture<Void> openCaptureSession(List<Surface> r13, SessionConfig r14, CameraDevice r15) {
        Object r2 = this.mSessionLock;
        monitor-enter(r2);
        int r3 = this.mState.ordinal();     // Catch: Throwable -> L56
        if (r3 != 0) goto L7;
    L53:
        ListenableFuture<Void> r16 = Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));     // Catch: Throwable -> L56
        monitor-exit(r2);     // Catch: Throwable -> L56
        return r16;
    L7:
        if (r3 == 1) goto L53;
        if (r3 != 2) goto L11;
        this.mConfiguredSurfaceMap.clear();     // Catch: Throwable -> L56
        int r1 = 0;
    L17:
        if (r1 >= r13.size()) goto L19;
        this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(r1), r13.get(r1));     // Catch: Throwable -> L56
        r1 = r1 + 1;     // Catch: Throwable -> L56
        goto L17
    L19:
        this.mState = State.OPENING;     // Catch: Throwable -> L56
        Logger.d(TAG, "Opening capture session.");     // Catch: Throwable -> L56
        SynchronizedCaptureSession.StateCallback r17 = SynchronizedCaptureSessionStateCallbacks.createComboCallback(new SynchronizedCaptureSession.StateCallback[]{this.mCaptureSessionStateCallback, new SynchronizedCaptureSessionStateCallbacks.Adapter(r14.getSessionStateCallbacks())});     // Catch: Throwable -> L56
        Camera2ImplConfig r0 = new Camera2ImplConfig(r14.getImplementationOptions());     // Catch: Throwable -> L56
        CaptureConfig.Builder r4 = CaptureConfig.Builder.from(r14.getRepeatingCaptureConfig());     // Catch: Throwable -> L56
        Map r5 = new HashMap();     // Catch: Throwable -> L56
        if (this.mCanUseMultiResolutionImageReader == true) goto L22;
    L24:
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L56
        String r7 = r0.getPhysicalCameraId(null);     // Catch: Throwable -> L56
        Iterator<SessionConfig.OutputConfig> r8 = r14.getOutputConfigs().iterator();     // Catch: Throwable -> L56
    L26:
        if (r8.hasNext() == false) goto L38;
        SessionConfig.OutputConfig r9 = r8.next();     // Catch: Throwable -> L56
        if (this.mCanUseMultiResolutionImageReader == true) goto L30;
    L32:
        OutputConfigurationCompat r10 = null;
    L33:
        if (r10 != null) goto L37;
        r10 = getOutputConfigurationCompat(r9, this.mConfiguredSurfaceMap, r7);     // Catch: Throwable -> L56
        if (this.mStreamUseCaseMap.containsKey(r9.getSurface()) == false) goto L37;
        r10.setStreamUseCase(this.mStreamUseCaseMap.get(r9.getSurface()).longValue());     // Catch: Throwable -> L56
    L37:
        r6.add(r10);     // Catch: Throwable -> L56
        goto L26
    L30:
        if (Build.VERSION.SDK_INT < 35) goto L32;
        r10 = (OutputConfigurationCompat) r5.get(r9);     // Catch: Throwable -> L56
        goto L33
    L38:
        SessionConfigurationCompat r18 = this.mSessionOpener.createSessionConfigurationCompat(r14.getSessionType(), getUniqueOutputConfigurations(r6), r17);     // Catch: Throwable -> L56
        if (r14.getTemplateType() == 5) goto L41;
    L59:
        CaptureRequest r19 = Camera2CaptureRequestBuilder.buildWithoutTarget(r4.build(), r15, this.mTemplateParamsOverride);     // Catch: CameraAccessException -> L49 Throwable -> L56
        if (r19 == null) goto L46;
        r18.setSessionParameters(r19);     // Catch: CameraAccessException -> L49 Throwable -> L56
    L46:
        ListenableFuture<Void> r110 = this.mSessionOpener.openCaptureSession(r15, r18, this.mConfiguredDeferrableSurfaces);     // Catch: Throwable -> L56
        monitor-exit(r2);     // Catch: Throwable -> L56
        return r110;
    L49:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    L41:
        if (r14.getInputConfiguration() == null) goto L59;
        r18.setInputConfiguration(InputConfigurationCompat.wrap(r14.getInputConfiguration()));     // Catch: Throwable -> L56
        goto L59
    L22:
        if (Build.VERSION.SDK_INT < 35) goto L24;
        r5 = createMultiResolutionOutputConfigurationCompats(groupMrirOutputConfigs(r14.getOutputConfigs()), this.mConfiguredSurfaceMap);     // Catch: Throwable -> L56
        goto L24
    L11:
        if (r3 == 4) goto L53;
        ListenableFuture<Void> r111 = Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));     // Catch: Throwable -> L56
        monitor-exit(r2);     // Catch: Throwable -> L56
        return r111;
    L56:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> open(final SessionConfig r6, final CameraDevice r7, SynchronizedCaptureSession.Opener r8) {
        Object r2 = this.mSessionLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mState.ordinal() == 1) goto L9;
        Logger.e(TAG, "Open not allowed in state: " + this.mState);     // Catch: Throwable -> L12
        ListenableFuture<Void> r9 = Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return r9;
    L9:
        this.mState = State.GET_SURFACE;     // Catch: Throwable -> L12
        ArrayList r0 = new ArrayList(r6.getSurfaces());     // Catch: Throwable -> L12
        this.mConfiguredDeferrableSurfaces = r0;     // Catch: Throwable -> L12
        this.mSessionOpener = r8;     // Catch: Throwable -> L12
        FutureChain r10 = FutureChain.from(r8.startWithDeferrableSurface(r0, TIMEOUT_GET_SURFACE_IN_MS)).transformAsync(new a2(this, r6, r7), this.mSessionOpener.getExecutor());     // Catch: Throwable -> L12
        Futures.addCallback(r10, new AnonymousClass1(this), this.mSessionOpener.getExecutor());     // Catch: Throwable -> L12
        ListenableFuture<Void> r11 = Futures.nonCancellationPropagating(r10);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return r11;
    }
}
