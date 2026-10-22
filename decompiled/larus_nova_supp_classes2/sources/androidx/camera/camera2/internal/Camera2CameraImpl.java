package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera2CameraImpl";
    final CameraAvailability mCameraAvailability;
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    private CameraConfig mCameraConfig;
    final CameraConfigureAvailable mCameraConfigureAvailable;
    private final Camera2CameraControlImpl mCameraControlInternal;
    final CameraCoordinator mCameraCoordinator;
    CameraDevice mCameraDevice;
    int mCameraDeviceError;
    final Camera2CameraInfoImpl mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateMachine mCameraStateMachine;
    final CameraStateRegistry mCameraStateRegistry;
    CaptureSessionInterface mCaptureSession;
    private final SynchronizedCaptureSession.OpenerBuilder mCaptureSessionOpenerBuilder;
    private final CaptureSessionRepository mCaptureSessionRepository;
    private final boolean mCloseCameraBeforeCreateNewSessionQuirk;
    private final boolean mConfigAndCloseQuirk;
    private final DisplayInfoManager mDisplayInfoManager;
    private final DynamicRangesCompat mDynamicRangesCompat;
    private final ErrorTimeoutReopenScheduler mErrorTimeoutReopenScheduler;
    private final Executor mExecutor;
    boolean mIsActiveResumingMode;
    private boolean mIsConfigAndCloseRequired;
    private boolean mIsConfiguringForClose;
    private boolean mIsPrimary;
    final Object mLock;
    private MeteringRepeatingSession mMeteringRepeatingSession;
    private final Set<String> mNotifyStateAttachedSet;
    private final LiveDataObservable<CameraInternal.State> mObservableState;
    final AtomicInteger mReleaseRequestCount;
    final Map<CaptureSessionInterface, ListenableFuture<Void>> mReleasedCaptureSessions;
    private final ScheduledExecutorService mScheduledExecutorService;
    private SessionProcessor mSessionProcessor;
    volatile InternalState mState;
    private final StateCallback mStateCallback;
    private final SupportedSurfaceCombination mSupportedSurfaceCombination;
    private int mTraceStateErrorCount;
    private final UseCaseAttachState mUseCaseAttachState;
    ListenableFuture<Void> mUserReleaseFuture;
    CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;

    public final class CameraAvailability extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {
        private boolean mCameraAvailable;
        private final String mCameraId;
        final /* synthetic */ Camera2CameraImpl this$0;

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnOpenAvailableListener
        public void onOpenAvailable() {
            if (this.this$0.mState != InternalState.PENDING_OPEN) goto L6;
            this.this$0.tryOpenCameraDevice(false);
            return;
        }

        public boolean isCameraAvailable() {
            return this.mCameraAvailable;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String r2) {
            if (this.mCameraId.equals(r2) == true) goto L5;
            return;
        L5:
            this.mCameraAvailable = true;
            if (this.this$0.mState != InternalState.PENDING_OPEN) goto L9;
            this.this$0.tryOpenCameraDevice(false);
            return;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String r2) {
            if (this.mCameraId.equals(r2) == true) goto L5;
            return;
        L5:
            this.mCameraAvailable = false;
        }

        public CameraAvailability(Camera2CameraImpl r1, String r2) {
            this.this$0 = r1;
            this.mCameraAvailable = true;
            this.mCameraId = r2;
        }
    }

    public final class CameraConfigureAvailable implements CameraStateRegistry.OnConfigureAvailableListener {
        final /* synthetic */ Camera2CameraImpl this$0;

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnConfigureAvailableListener
        public void onConfigureAvailable() {
            if (this.this$0.mState != InternalState.OPENED) goto L6;
            this.this$0.openCaptureSession();
            return;
        }

        public CameraConfigureAvailable(Camera2CameraImpl r1) {
            this.this$0 = r1;
        }
    }

    public final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        final /* synthetic */ Camera2CameraImpl this$0;

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlUpdateSessionConfig() {
            this.this$0.updateCaptureSessionConfig();
        }

        public ControlUpdateListenerInternal(Camera2CameraImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlCaptureRequests(List<CaptureConfig> r2) {
            this.this$0.submitCaptureRequests((List) Preconditions.checkNotNull(r2));
        }
    }

    public class ErrorTimeoutReopenScheduler {
        private static final long ERROR_TIMEOUT_MILLIS = 2000;
        private ScheduleNode mScheduleNode;
        final /* synthetic */ Camera2CameraImpl this$0;

        public class ScheduleNode {
            private final AtomicBoolean mIsDone;
            private final ScheduledFuture<?> mScheduledFuture;
            final /* synthetic */ ErrorTimeoutReopenScheduler this$1;

            public static /* synthetic */ void a(ScheduleNode r0) {
                r0.execute();
            }

            public static /* synthetic */ void b(ScheduleNode r0) {
                r0.executeInternal();
            }

            private void execute() {
                if (this.mIsDone.getAndSet(true) == false) goto L5;
                return;
            L5:
                Camera2CameraImpl.access$200(this.this$1.this$0).execute(new m0(this));
            }

            private void executeInternal() {
                if (this.this$1.this$0.mState == InternalState.OPENING) goto L6;
                this.this$1.this$0.debugLog("Camera skip reopen at state: " + this.this$1.this$0.mState);
                return;
            L6:
                this.this$1.this$0.debugLog("Camera onError timeout, reopen it.");
                this.this$1.this$0.setState(InternalState.REOPENING);
                Camera2CameraImpl.access$300(this.this$1.this$0).scheduleCameraReopen();
            }

            public void cancel() {
                this.mIsDone.set(true);
                this.mScheduledFuture.cancel(true);
            }

            public boolean isDone() {
                return this.mIsDone.get();
            }

            public ScheduleNode(ErrorTimeoutReopenScheduler r5) {
                this.this$1 = r5;
                this.mIsDone = new AtomicBoolean(false);
                this.mScheduledFuture = Camera2CameraImpl.access$100(r5.this$0).schedule(new n0(this), ErrorTimeoutReopenScheduler.ERROR_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            }
        }

        public void cancel() {
            ScheduleNode r0 = this.mScheduleNode;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.mScheduleNode = null;
        }

        public void deviceOnError() {
            this.this$0.debugLog("Camera receive onErrorCallback");
            cancel();
        }

        public boolean isErrorHandling() {
            ScheduleNode r0 = this.mScheduleNode;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isDone() == true) goto L7;
            return true;
        }

        public void start() {
            if (this.this$0.mState == InternalState.OPENING) goto L6;
            this.this$0.debugLog("Don't need the onError timeout handler.");
            return;
        L6:
            this.this$0.debugLog("Camera waiting for onError.");
            cancel();
            this.mScheduleNode = new ScheduleNode(this);
        }

        private ErrorTimeoutReopenScheduler(Camera2CameraImpl r1) {
            this.this$0 = r1;
            this.mScheduleNode = null;
        }

        public /* synthetic */ ErrorTimeoutReopenScheduler(Camera2CameraImpl r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static final enum InternalState extends Enum<InternalState> {
        private static final /* synthetic */ InternalState[] $VALUES = null;
        public static final InternalState CLOSING = null;
        public static final InternalState CONFIGURED = null;
        public static final InternalState INITIALIZED = null;
        public static final InternalState OPENED = null;
        public static final InternalState OPENING = null;
        public static final InternalState PENDING_OPEN = null;
        public static final InternalState RELEASED = null;
        public static final InternalState RELEASING = null;
        public static final InternalState REOPENING = null;
        public static final InternalState REOPENING_QUIRK = null;

        private static /* synthetic */ InternalState[] $values() {
            return new InternalState[]{RELEASED, RELEASING, INITIALIZED, PENDING_OPEN, CLOSING, REOPENING_QUIRK, REOPENING, OPENING, OPENED, CONFIGURED};
        }

        static {
            RELEASED = new InternalState("RELEASED", 0);
            RELEASING = new InternalState("RELEASING", 1);
            INITIALIZED = new InternalState("INITIALIZED", 2);
            PENDING_OPEN = new InternalState("PENDING_OPEN", 3);
            CLOSING = new InternalState("CLOSING", 4);
            REOPENING_QUIRK = new InternalState("REOPENING_QUIRK", 5);
            REOPENING = new InternalState("REOPENING", 6);
            OPENING = new InternalState("OPENING", 7);
            OPENED = new InternalState("OPENED", 8);
            CONFIGURED = new InternalState("CONFIGURED", 9);
            $VALUES = $values();
        }

        public static InternalState[] values() {
            return (InternalState[]) $VALUES.clone();
        }

        public static InternalState valueOf(String r1) {
            return (InternalState) r27.a.a(InternalState.class, r1);
        }

        private InternalState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final class StateCallback extends CameraDevice.StateCallback {
        private final CameraReopenMonitor mCameraReopenMonitor;
        private final Executor mExecutor;
        ScheduledFuture<?> mScheduledReopenHandle;
        private ScheduledReopen mScheduledReopenRunnable;
        private final ScheduledExecutorService mScheduler;
        final /* synthetic */ Camera2CameraImpl this$0;

        public class CameraReopenMonitor {
            static final int ACTIVE_REOPEN_DELAY_BASE_MS = 1000;
            static final int ACTIVE_REOPEN_LIMIT_MS = 1800000;
            static final int INVALID_TIME = -1;
            static final int REOPEN_DELAY_MS = 700;
            static final int REOPEN_LIMIT_MS = 10000;
            private final long mCameraOpenRetryMaxTimeoutInMs;
            private long mFirstReopenTime;
            final /* synthetic */ StateCallback this$1;

            public int getReopenDelayMs() {
                if (this.this$1.shouldActiveResume() == true) goto L6;
                return REOPEN_DELAY_MS;
            L6:
                long r0 = getElapsedTime();
                if (r0 > 120000) goto L11;
                return 1000;
            L11:
                if (r0 > 300000) goto L14;
                return 2000;
            L14:
                return 4000;
            }

            public int getReopenLimitMs() {
                if (this.this$1.shouldActiveResume() == true) goto L8;
                long r3 = this.mCameraOpenRetryMaxTimeoutInMs;
                if (r3 > 0) goto L7;
                return REOPEN_LIMIT_MS;
            L7:
                return Math.min((int) r3, REOPEN_LIMIT_MS);
            L8:
                long r4 = this.mCameraOpenRetryMaxTimeoutInMs;
                if (r4 > 0) goto L11;
                return ACTIVE_REOPEN_LIMIT_MS;
            L11:
                return Math.min((int) r4, ACTIVE_REOPEN_LIMIT_MS);
            }

            public void reset() {
                this.mFirstReopenTime = -1;
            }

            public boolean canScheduleCameraReopen() {
                if (getElapsedTime() < getReopenLimitMs()) goto L5;
                boolean r0 = true;
            L6:
                if (r0 == false) goto L9;
                reset();
                return false;
            L9:
                return true;
            L5:
                r0 = false;
                goto L6
            }

            public long getElapsedTime() {
                long r0 = SystemClock.uptimeMillis();
                if (this.mFirstReopenTime != (-1)) goto L6;
                this.mFirstReopenTime = r0;
            L6:
                return r0 - this.mFirstReopenTime;
            }

            public CameraReopenMonitor(StateCallback r3, long r4) {
                this.this$1 = r3;
                this.mFirstReopenTime = -1;
                this.mCameraOpenRetryMaxTimeoutInMs = r4;
            }
        }

        public class ScheduledReopen implements Runnable {
            private boolean mCancelled;
            private Executor mExecutor;
            final /* synthetic */ StateCallback this$1;

            public static /* synthetic */ void a(ScheduledReopen r0) {
                r0.lambda$run$0();
            }

            public void cancel() {
                this.mCancelled = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback$ScheduledReopen_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            private /* synthetic */ void lambda$run$0() {
                if (this.mCancelled == false) goto L5;
                return;
            L5:
                if (this.this$1.this$0.mState != InternalState.REOPENING) goto L7;
            L10:
                boolean r0 = true;
            L11:
                Preconditions.checkState(r0);
                if (this.this$1.shouldActiveResume() == false) goto L14;
                this.this$1.this$0.tryForceOpenCameraDevice(true);
                return;
            L14:
                this.this$1.this$0.tryOpenCameraDevice(true);
                return;
            L7:
                if (this.this$1.this$0.mState == InternalState.REOPENING_QUIRK) goto L10;
                r0 = false;
                goto L11
            }

            public void androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback$ScheduledReopen__run$___twin___() {
                this.mExecutor.execute(new o0(this));
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback$ScheduledReopen_com_larus_apm_impl_protector_RunnableLancet_run(ScheduledReopen r1) {
                r1.androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback$ScheduledReopen__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public ScheduledReopen(StateCallback r1, Executor r2) {
                this.this$1 = r1;
                this.mCancelled = false;
                this.mExecutor = r2;
            }
        }

        public boolean cancelScheduledReopen() {
            if (this.mScheduledReopenHandle == null) goto L6;
            this.this$0.debugLog("Cancelling scheduled re-open: " + this.mScheduledReopenRunnable);
            this.mScheduledReopenRunnable.cancel();
            this.mScheduledReopenRunnable = null;
            this.mScheduledReopenHandle.cancel(false);
            this.mScheduledReopenHandle = null;
            return true;
        L6:
            return false;
        }

        public void resetReopenMonitor() {
            this.mCameraReopenMonitor.reset();
        }

        public void scheduleCameraReopen() {
            boolean r1 = true;
            if (this.mScheduledReopenRunnable != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            if (this.mScheduledReopenHandle == null) goto L10;
            r1 = false;
        L10:
            Preconditions.checkState(r1);
            if (this.mCameraReopenMonitor.canScheduleCameraReopen() == false) goto L13;
            this.mScheduledReopenRunnable = new ScheduledReopen(this, this.mExecutor);
            this.this$0.debugLog("Attempting camera re-open in " + this.mCameraReopenMonitor.getReopenDelayMs() + "ms: " + this.mScheduledReopenRunnable + " activeResuming = " + this.this$0.mIsActiveResumingMode);
            this.mScheduledReopenHandle = this.mScheduler.schedule(this.mScheduledReopenRunnable, (long) this.mCameraReopenMonitor.getReopenDelayMs(), TimeUnit.MILLISECONDS);
            return;
        L13:
            Logger.e(Camera2CameraImpl.TAG, "Camera reopening attempted for " + this.mCameraReopenMonitor.getReopenLimitMs() + "ms without success.");
            this.this$0.setState(InternalState.PENDING_OPEN, null, false);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public boolean shouldActiveResume() {
            Camera2CameraImpl r0 = this.this$0;
            if (r0.mIsActiveResumingMode == false) goto L9;
            int r1 = r0.mCameraDeviceError;
            if (r1 != 1) goto L7;
            return true;
        L7:
            if (r1 != 2) goto L9;
            return true;
        L9:
            return false;
        }

        public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback_com_obric_performance_power_monitor_camera_CameraLancet_close(CameraDevice r1) {
            if (fna.g.d() == true) goto L6;
            androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback_android_hardware_camera2_CameraDevice_close(r1);
            return;
        L6:
            androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback_android_hardware_camera2_CameraDevice_close(r1);
            if ((r1 instanceof CameraDevice) == false) goto L10;
            jna.a.a(r1.getId());
            return;
        }

        private static void androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback_android_hardware_camera2_CameraDevice_close(CameraDevice r12) {
            f06.c r8 = new f06.c();
            Object[] r9 = new Object[0];
            f06.b r10 = new f06.b();
            if (r8.b(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, "void", r10).a == false) goto L6;
            r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, false);
            return;
        L6:
            r12.close();
            r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, true);
        }

        private void reopenCameraAfterError(int r5) {
            int r2 = 1;
            if (this.this$0.mCameraDeviceError == 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (r5 == 1) goto L10;
            if (r5 == 2) goto L11;
            r2 = 3;
        L11:
            this.this$0.setState(InternalState.REOPENING, CameraState.StateError.create(r2));
            this.this$0.closeCamera(false);
            return;
        L10:
            r2 = 2;
            goto L11
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice r6) {
            this.this$0.debugLog("CameraDevice.onClosed()");
            if (this.this$0.mCameraDevice != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "Unexpected onClose callback on camera device: " + r6);
            int r7 = this.this$0.mState.ordinal();
            if (r7 != 1) goto L9;
        L21:
            Preconditions.checkState(this.this$0.isSessionCloseComplete());
            Camera2CameraImpl.access$400(this.this$0);
            return;
        L9:
            if (r7 == 4) goto L21;
            if (r7 != 5) goto L13;
        L17:
            Camera2CameraImpl r8 = this.this$0;
            if (r8.mCameraDeviceError == 0) goto L20;
            r8.debugLog("Camera closed due to error: " + Camera2CameraImpl.getErrorMessage(this.this$0.mCameraDeviceError));
            scheduleCameraReopen();
            return;
        L20:
            r8.tryOpenCameraDevice(false);
            return;
        L13:
            if (r7 == 6) goto L17;
            throw new IllegalStateException("Camera closed while in state: " + this.this$0.mState);
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r3) {
            this.this$0.debugLog("CameraDevice.onDisconnected()");
            onError(r3, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice r22) {
            ArrayList r10 = new ArrayList();
            Object[] r12 = {r22};
            f06.b r14 = new f06.b();
            g06.a r0 = (g06.a) ApiHookConfig.b.get(100200);
            if (r0 == null) goto L5;
            f06.a[] r1 = r0.i;
        L6:
            f06.a[] r7 = r1;
            int r6 = r7.length;
            int r5 = 0;
        L8:
            if (r5 >= r6) goto L15;
            f06.a r3 = r7[r5];
            int r18 = r5;
            int r19 = r6;
            f06.a[] r20 = r7;
            f06.d r2 = r3.preInvoke(100200, "androidx/camera/camera2/internal/Camera2CameraImpl$StateCallback", "onOpened", this, r12, "void", r14);     // Catch: Exception -> L37
            if (r2.a == true) goto L12;
            r10.add(r3);     // Catch: Exception -> L37
            goto L14
        L12:
            CameraDevice r4 = null;
        L17:
            if (r2.a == false) goto L19;
            return;
        L19:
            this.this$0.debugLog("CameraDevice.onOpened()");
            Camera2CameraImpl r8 = this.this$0;
            r8.mCameraDevice = r22;
            r8.mCameraDeviceError = 0;
            resetReopenMonitor();
            int r9 = this.this$0.mState.ordinal();
            if (r9 != 1) goto L22;
        L35:
            Preconditions.checkState(this.this$0.isSessionCloseComplete());
            INVOKEVIRTUAL_androidx_camera_camera2_internal_Camera2CameraImpl$StateCallback_com_obric_performance_power_monitor_camera_CameraLancet_close(this.this$0.mCameraDevice);
            this.this$0.mCameraDevice = r4;
            return;
        L22:
            if (r9 == 4) goto L35;
            if (r9 != 5) goto L26;
        L32:
            this.this$0.setState(InternalState.OPENED);
            CameraStateRegistry r11 = this.this$0.mCameraStateRegistry;
            String r13 = r22.getId();
            Camera2CameraImpl r15 = this.this$0;
            if (r11.tryOpenCaptureSession(r13, r15.mCameraCoordinator.getPairedConcurrentCameraId(r15.mCameraDevice.getId())) == false) goto L43;
            this.this$0.openCaptureSession();
            return;
        L43:
            return;
        L26:
            if (r9 == 6) goto L32;
            if (r9 == 7) goto L32;
            throw new IllegalStateException("onOpened() should not be possible from state: " + this.this$0.mState);
        L14:
            r5 = r18 + 1;
            r6 = r19;
            r7 = r20;
            goto L8
        L15:
            r4 = null;
            r2 = new f06.d(false, null);
            goto L17
        L5:
            r1 = ApiHookConfig.d;
            goto L6
        }

        private void handleErrorOnOpen(CameraDevice r6, int r7) {
            if (this.this$0.mState != InternalState.OPENING) goto L5;
        L14:
            boolean r0 = true;
        L15:
            Preconditions.checkState(r0, "Attempt to handle open error from non open state: " + this.this$0.mState);
            if (r7 == 1) goto L25;
            if (r7 == 2) goto L25;
            if (r7 == 4) goto L25;
            Logger.e(Camera2CameraImpl.TAG, "Error observed on open (or opening) camera device " + r6.getId() + ": " + Camera2CameraImpl.getErrorMessage(r7) + " closing camera.");
            if (r7 != 3) goto L23;
            int r8 = 5;
        L24:
            this.this$0.setState(InternalState.CLOSING, CameraState.StateError.create(r8));
            this.this$0.closeCamera(false);
            return;
        L23:
            r8 = 6;
        L25:
            Logger.d(Camera2CameraImpl.TAG, String.format("Attempt to reopen camera[%s] after error[%s]", new Object[]{r6.getId(), Camera2CameraImpl.getErrorMessage(r7)}));
            reopenCameraAfterError(r7);
            return;
        L5:
            if (this.this$0.mState == InternalState.OPENED) goto L14;
            if (this.this$0.mState == InternalState.CONFIGURED) goto L14;
            if (this.this$0.mState == InternalState.REOPENING) goto L14;
            if (this.this$0.mState == InternalState.REOPENING_QUIRK) goto L14;
            r0 = false;
            goto L15
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r7, int r8) {
            Camera2CameraImpl r0 = this.this$0;
            r0.mCameraDevice = r7;
            r0.mCameraDeviceError = r8;
            Camera2CameraImpl.access$500(r0).deviceOnError();
            int r1 = this.this$0.mState.ordinal();
            if (r1 == 1) goto L8;
            switch(r1) {
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L7;
                case 7: goto L7;
                case 8: goto L7;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            Logger.d(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", new Object[]{r7.getId(), Camera2CameraImpl.getErrorMessage(r8), this.this$0.mState.name()}));
            handleErrorOnOpen(r7, r8);
            return;
        L6:
            throw new IllegalStateException("onError() should not be possible from state: " + this.this$0.mState);
        L8:
            Logger.e(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", new Object[]{r7.getId(), Camera2CameraImpl.getErrorMessage(r8), this.this$0.mState.name()}));
            this.this$0.closeCamera(false);
        }

        public StateCallback(Camera2CameraImpl r1, Executor r2, ScheduledExecutorService r3, long r4) {
            this.this$0 = r1;
            this.mExecutor = r2;
            this.mScheduler = r3;
            this.mCameraReopenMonitor = new CameraReopenMonitor(this, r4);
        }
    }

    public static abstract class UseCaseInfo {
        public UseCaseInfo() {
        }

        public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

        public abstract SessionConfig getSessionConfig();

        public abstract StreamSpec getStreamSpec();

        public abstract Size getSurfaceResolution();

        public abstract UseCaseConfig<?> getUseCaseConfig();

        public abstract String getUseCaseId();

        public abstract Class<?> getUseCaseType();

        public static UseCaseInfo from(UseCase r7, boolean r8) {
            String r0 = Camera2CameraImpl.getUseCaseId(r7);
            Class<?> r1 = r7.getClass();
            if (r8 == false) goto L5;
            SessionConfig r9 = r7.getSessionConfig();
        L7:
            return create(r0, r1, r9, r7.getCurrentConfig(), r7.getAttachedSurfaceResolution(), r7.getAttachedStreamSpec(), Camera2CameraImpl.getCaptureTypes(r7));
        L5:
            r9 = r7.getSecondarySessionConfig();
            goto L7
        }

        public static UseCaseInfo create(String r9, Class<?> r10, SessionConfig r11, UseCaseConfig<?> r12, Size r13, StreamSpec r14, List<UseCaseConfigFactory.CaptureType> r15) {
            return new AutoValue_Camera2CameraImpl_UseCaseInfo(r9, r10, r11, r12, r13, r14, r15);
        }
    }

    public static /* synthetic */ Object a(Camera2CameraImpl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$openCameraConfigAndClose$1(r1);
    }

    public static /* synthetic */ void b(Camera2CameraImpl r0, CallbackToFutureAdapter.Completer r1, String r2) {
        r0.lambda$isUseCaseAttached$11(r1, r2);
    }

    public static /* synthetic */ Object c(Camera2CameraImpl r0, String r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$isUseCaseAttached$12(r1, r2);
    }

    public static /* synthetic */ void d(Camera2CameraImpl r0) {
        r0.openInternal();
    }

    public static /* synthetic */ void e(Surface r0, SurfaceTexture r1) {
        lambda$configAndClose$2(r0, r1);
    }

    public static /* synthetic */ Object f(Camera2CameraImpl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$getOrCreateUserReleaseFuture$6(r1);
    }

    public static /* synthetic */ Object g(Camera2CameraImpl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$release$5(r1);
    }

    public static String getErrorMessage(int r1) {
        if (r1 != 0) goto L4;
        return "ERROR_NONE";
    L4:
        if (r1 != 1) goto L6;
        return "ERROR_CAMERA_IN_USE";
    L6:
        if (r1 != 2) goto L8;
        return "ERROR_MAX_CAMERAS_IN_USE";
    L8:
        if (r1 != 3) goto L10;
        return "ERROR_CAMERA_DISABLED";
    L10:
        if (r1 != 4) goto L12;
        return "ERROR_CAMERA_DEVICE";
    L12:
        if (r1 == 5) goto L15;
        return "UNKNOWN ERROR";
    L15:
        return "ERROR_CAMERA_SERVICE";
    }

    public static /* synthetic */ void h(Camera2CameraImpl r0, String r1) {
        r0.lambda$onUseCaseInactive$8(r1);
    }

    public static /* synthetic */ void i(Camera2CameraImpl r0, List r1) {
        r0.lambda$detachUseCases$16(r1);
    }

    public static /* synthetic */ void j(Camera2CameraImpl r0, String r1, SessionConfig r2, UseCaseConfig r3, StreamSpec r4, List r5) {
        r0.lambda$onUseCaseUpdated$9(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void k(Camera2CameraImpl r0, boolean r1) {
        r0.lambda$setActiveResumingMode$18(r1);
    }

    public static /* synthetic */ void l(Camera2CameraImpl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$isMeteringRepeatingAttached$13(r1);
    }

    private /* synthetic */ void lambda$configAndCloseIfNeeded$0() {
        this.mIsConfiguringForClose = false;
        this.mIsConfigAndCloseRequired = false;
        debugLog("OpenCameraConfigAndClose is done, state: " + this.mState);
        int r1 = this.mState.ordinal();
        if (r1 != 1) goto L5;
    L13:
        Preconditions.checkState(isSessionCloseComplete());
        finishClose();
        return;
    L5:
        if (r1 == 4) goto L13;
        if (r1 == 6) goto L10;
        debugLog("OpenCameraConfigAndClose finished while in state: " + this.mState);
        return;
    L10:
        if (this.mCameraDeviceError == 0) goto L12;
        debugLog("OpenCameraConfigAndClose in error: " + getErrorMessage(this.mCameraDeviceError));
        this.mStateCallback.scheduleCameraReopen();
        return;
    L12:
        tryOpenCameraDevice(false);
    }

    public static /* synthetic */ void m(Camera2CameraImpl r0) {
        r0.lambda$addOrRemoveMeteringRepeatingUseCase$17();
    }

    public static /* synthetic */ void n(Camera2CameraImpl r0) {
        r0.closeInternal();
    }

    public static /* synthetic */ void o(Camera2CameraImpl r0) {
        r0.lambda$configAndCloseIfNeeded$0();
    }

    public static /* synthetic */ void p(Camera2CameraImpl r0, String r1, SessionConfig r2, UseCaseConfig r3, StreamSpec r4, List r5) {
        r0.lambda$resetUseCase$10(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void q(Camera2CameraImpl r0, List r1) {
        r0.lambda$attachUseCases$15(r1);
    }

    public static /* synthetic */ ListenableFuture r(CaptureSession r0, DeferrableSurface r1, Void r2) {
        return lambda$configAndClose$3(r0, r1, r2);
    }

    public static /* synthetic */ void s(Camera2CameraImpl r0, String r1, SessionConfig r2, UseCaseConfig r3, StreamSpec r4, List r5) {
        r0.lambda$onUseCaseActive$7(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Object t(Camera2CameraImpl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$isMeteringRepeatingAttached$14(r1);
    }

    public static /* synthetic */ void u(SessionConfig.ErrorListener r0, SessionConfig r1) {
        lambda$postSurfaceClosedError$19(r0, r1);
    }

    public static /* synthetic */ void v(Camera2CameraImpl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$release$4(r1);
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final /* synthetic */ CameraControl getCameraControl() {
        return CameraInternal.CC.$default$getCameraControl(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final /* synthetic */ CameraInfo getCameraInfo() {
        return CameraInternal.CC.$default$getCameraInfo(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ boolean getHasTransform() {
        return CameraInternal.CC.$default$getHasTransform(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ boolean isFrontFacing() {
        return CameraInternal.CC.$default$isFrontFacing(this);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(boolean r1, UseCase... r2) {
        return Camera.CC.$default$isUseCasesCombinationSupported(this, r1, r2);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... r1) {
        return Camera.CC.$default$isUseCasesCombinationSupported(this, r1);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... r1) {
        return Camera.CC.$default$isUseCasesCombinationSupportedByFramework(this, r1);
    }

    private void addMeteringRepeating() {
        MeteringRepeatingSession r0 = this.mMeteringRepeatingSession;
        if (r0 == null) goto L6;
        String r1 = getMeteringRepeatingId(r0);
        UseCaseAttachState r2 = this.mUseCaseAttachState;
        SessionConfig r3 = this.mMeteringRepeatingSession.getSessionConfig();
        UseCaseConfig<?> r4 = this.mMeteringRepeatingSession.getUseCaseConfig();
        UseCaseConfigFactory.CaptureType r7 = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        r2.setUseCaseAttached(r1, r3, r4, null, Collections.singletonList(r7));
        this.mUseCaseAttachState.setUseCaseActive(r1, this.mMeteringRepeatingSession.getSessionConfig(), this.mMeteringRepeatingSession.getUseCaseConfig(), null, Collections.singletonList(r7));
        return;
    }

    private void addOrRemoveMeteringRepeatingUseCase() {
        SessionConfig r0 = this.mUseCaseAttachState.getAttachedBuilder().build();
        CaptureConfig r1 = r0.getRepeatingCaptureConfig();
        int r2 = r1.getSurfaces().size();
        int r3 = r0.getSurfaces().size();
        if (r0.getSurfaces().isEmpty() == false) goto L5;
        return;
    L5:
        if (r1.getSurfaces().isEmpty() == false) goto L14;
        if (this.mMeteringRepeatingSession != null) goto L10;
        this.mMeteringRepeatingSession = new MeteringRepeatingSession(this.mCameraInfoInternal.getCameraCharacteristicsCompat(), this.mDisplayInfoManager, new y(this));
    L10:
        if (isSurfaceCombinationWithMeteringRepeatingSupported() == false) goto L12;
        addMeteringRepeating();
        return;
    L12:
        Logger.e(TAG, "Failed to add a repeating surface, CameraControl and ImageCapture may encounter issues due to the absence of repeating surface. Please add a UseCase (Preview or ImageAnalysis) that can provide a repeating surface for CameraControl and ImageCapture to function properly.");
        return;
    L14:
        if (r3 != 1) goto L18;
        if (r2 != 1) goto L18;
        removeMeteringRepeating();
        return;
    L18:
        if (r2 < 2) goto L21;
        removeMeteringRepeating();
        return;
    L21:
        if (this.mMeteringRepeatingSession != null) goto L23;
    L25:
        Logger.d(TAG, "No need to remove a previous mMeteringRepeating, SessionConfig Surfaces: " + r3 + ", CaptureConfig Surfaces: " + r2);
        return;
    L23:
        if (isSurfaceCombinationWithMeteringRepeatingSupported() == true) goto L25;
        removeMeteringRepeating();
    }

    private void closeInternal() {
        debugLog("Closing camera.");
        boolean r1 = true;
        switch(this.mState.ordinal()) {
            case 3: goto L16;
            case 4: goto L4;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L5;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        debugLog("close() ignored due to being in state: " + this.mState);
        return;
    L5:
        setState(InternalState.CLOSING);
        closeCamera(false);
        return;
    L7:
        if (this.mStateCallback.cancelScheduledReopen() == false) goto L9;
    L12:
        this.mErrorTimeoutReopenScheduler.cancel();
        setState(InternalState.CLOSING);
        if (r1 == false) goto L23;
        Preconditions.checkState(isSessionCloseComplete());
        configAndCloseIfNeeded();
        return;
    L23:
        return;
    L9:
        if (this.mErrorTimeoutReopenScheduler.isErrorHandling() == true) goto L12;
        r1 = false;
        goto L12
    L16:
        if (this.mCameraDevice == null) goto L19;
        r1 = false;
    L19:
        Preconditions.checkState(r1);
        setState(InternalState.INITIALIZED);
    }

    private void configAndCloseIfNeeded() {
        if (this.mState != InternalState.RELEASING) goto L5;
    L8:
        boolean r0 = true;
    L9:
        Preconditions.checkState(r0);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        if (this.mIsConfigAndCloseRequired == true) goto L14;
        finishClose();
        return;
    L14:
        if (this.mIsConfiguringForClose == false) goto L18;
        debugLog("Ignored since configAndClose is processing");
        return;
    L18:
        if (this.mCameraAvailability.isCameraAvailable() == true) goto L21;
        this.mIsConfigAndCloseRequired = false;
        finishClose();
        debugLog("Ignore configAndClose and finish the close flow directly since camera is unavailable.");
        return;
    L21:
        debugLog("Open camera to configAndClose");
        ListenableFuture<Void> r1 = openCameraConfigAndClose();
        this.mIsConfiguringForClose = true;
        r1.addListener(new h0(this), this.mExecutor);
        return;
    L5:
        if (this.mState == InternalState.CLOSING) goto L8;
        r0 = false;
        goto L9
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList r1 = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
        r1.add(this.mCaptureSessionRepository.getCameraStateCallback());
        r1.add(this.mStateCallback);
        return CameraDeviceStateCallbacks.createComboCallback(r1);
    }

    private int getCameraMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameraCoordinator.getCameraOperatingMode() != 2) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 0;
    }

    private ListenableFuture<Void> getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture != null) goto L9;
        if (this.mState == InternalState.RELEASED) goto L7;
        this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new f0(this));
        goto L9
    L7:
        this.mUserReleaseFuture = Futures.immediateFuture(null);
    L9:
        return this.mUserReleaseFuture;
    }

    private boolean isSurfaceCombinationWithMeteringRepeatingSupported() {
        ArrayList r4 = new ArrayList();
        int r3 = getCameraMode();
        Iterator<UseCaseAttachState.UseCaseAttachInfo> r0 = this.mUseCaseAttachState.getAttachedUseCaseInfo().iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        UseCaseAttachState.UseCaseAttachInfo r2 = r0.next();
        if (r2.getCaptureTypes() == null) goto L11;
        if (ListProtector.get(r2.getCaptureTypes(), 0) == UseCaseConfigFactory.CaptureType.METERING_REPEATING) goto L4;
    L11:
        if (r2.getStreamSpec() == null) goto L19;
        if (r2.getCaptureTypes() == null) goto L19;
        SessionConfig r5 = r2.getSessionConfig();
        UseCaseConfig<?> r6 = r2.getUseCaseConfig();
        Iterator<DeferrableSurface> r7 = r5.getSurfaces().iterator();
    L17:
        if (r7.hasNext() == false) goto L4;
        DeferrableSurface r8 = r7.next();
        r4.add(AttachedSurfaceInfo.create(this.mSupportedSurfaceCombination.transformSurfaceConfig(r3, r6.getInputFormat(), r8.getPrescribedSize()), r6.getInputFormat(), r8.getPrescribedSize(), r2.getStreamSpec().getDynamicRange(), r2.getCaptureTypes(), r2.getStreamSpec().getImplementationOptions(), r6.getTargetFrameRate(null)));
    L19:
        Logger.w(TAG, "Invalid stream spec or capture types in " + r2);
        return false;
    L21:
        Preconditions.checkNotNull(this.mMeteringRepeatingSession);
        HashMap r9 = new HashMap();
        r9.put(this.mMeteringRepeatingSession.getUseCaseConfig(), Collections.singletonList(this.mMeteringRepeatingSession.getMeteringRepeatingSize()));
        this.mSupportedSurfaceCombination.getSuggestedStreamSpecifications(r3, r4, r9, false, false);     // Catch: IllegalArgumentException -> L25
        debugLog("Surface combination with metering repeating supported!");
        return true;
    L25:
        e = move-exception;
        debugLog("Surface combination with metering repeating  not supported!", e);
        return false;
    }

    private CaptureSessionInterface newCaptureSession() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionProcessor != null) goto L9;
        CaptureSession r1 = new CaptureSession(this.mDynamicRangesCompat, this.mCameraInfoInternal.getCameraQuirks());     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L9:
        ProcessingCaptureSession r2 = new ProcessingCaptureSession(this.mSessionProcessor, this.mCameraInfoInternal, this.mDynamicRangesCompat, this.mExecutor, this.mScheduledExecutorService);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    private ListenableFuture<Void> openCameraConfigAndClose() {
        return CallbackToFutureAdapter.getFuture(new j0(this));
    }

    private void openInternal() {
        int r0 = this.mState.ordinal();
        boolean r2 = false;
        if (r0 != 2) goto L5;
    L19:
        tryForceOpenCameraDevice(false);
        return;
    L5:
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L9;
        debugLog("open() ignored due to being in state: " + this.mState);
        return;
    L9:
        setState(InternalState.REOPENING);
        if (isSessionCloseComplete() == false) goto L12;
        return;
    L12:
        if (this.mIsConfiguringForClose == false) goto L14;
        return;
    L14:
        if (this.mCameraDeviceError == 0) goto L16;
        return;
    L16:
        if (this.mCameraDevice == null) goto L18;
        r2 = true;
    L18:
        Preconditions.checkState(r2, "Camera Device should be open if session close is not complete");
        setState(InternalState.OPENED);
        openCaptureSession();
    }

    private void removeMeteringRepeating() {
        if (this.mMeteringRepeatingSession == null) goto L6;
        this.mUseCaseAttachState.setUseCaseDetached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
        this.mUseCaseAttachState.setUseCaseInactive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
        this.mMeteringRepeatingSession.clear();
        this.mMeteringRepeatingSession = null;
        return;
    }

    private void updateZslDisabledByUseCaseConfigStatus() {
        Iterator<UseCaseConfig<?>> r0 = this.mUseCaseAttachState.getAttachedUseCaseConfigs().iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = r2 | r0.next().isZslDisabled(false);
        goto L4
    L6:
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(r2);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        this.mExecutor.execute(new b0(this));
    }

    public void finishClose() {
        if (this.mState != InternalState.RELEASING) goto L5;
    L8:
        boolean r0 = true;
    L9:
        Preconditions.checkState(r0);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState != InternalState.CLOSING) goto L12;
        setState(InternalState.INITIALIZED);
        return;
    L12:
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        setState(InternalState.RELEASED);
        CallbackToFutureAdapter.Completer<Void> r1 = this.mUserReleaseNotifier;
        if (r1 == null) goto L17;
        r1.set(null);
        this.mUserReleaseNotifier = null;
        return;
    L17:
        return;
    L5:
        if (this.mState == InternalState.CLOSING) goto L8;
        r0 = false;
        goto L9
    }

    public boolean isMeteringRepeatingAttached() {
        return ((Boolean) CallbackToFutureAdapter.getFuture(new g0(this)).get()).booleanValue();
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e);
    }

    public boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        this.mExecutor.execute(new w(this));
    }

    public void openCaptureSession() {
        if (this.mState != InternalState.OPENED) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        SessionConfig.ValidatingBuilder r1 = this.mUseCaseAttachState.getAttachedBuilder();
        if (r1.isValid() == true) goto L11;
        debugLog("Unable to create capture session due to conflicting configurations");
        return;
    L11:
        if (this.mCameraStateRegistry.tryOpenCaptureSession(this.mCameraDevice.getId(), this.mCameraCoordinator.getPairedConcurrentCameraId(this.mCameraDevice.getId())) == true) goto L14;
        debugLog("Unable to create capture session in camera operating mode = " + this.mCameraCoordinator.getCameraOperatingMode());
        return;
    L14:
        HashMap r2 = new HashMap();
        StreamUseCaseUtil.populateSurfaceToStreamUseCaseMapping(this.mUseCaseAttachState.getAttachedSessionConfigs(), this.mUseCaseAttachState.getAttachedUseCaseConfigs(), r2);
        this.mCaptureSession.setStreamUseCaseMap(r2);
        final CaptureSessionInterface r3 = this.mCaptureSession;
        Futures.addCallback(r3.open(r1.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()), new AnonymousClass4(this, r3), this.mExecutor);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new k0(this));
    }

    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", new Object[]{Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId()});
    }

    public void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder r0 = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
        if (r0.isValid() == false) goto L5;
        SessionConfig r1 = r0.build();
        this.mCameraControlInternal.setTemplate(r1.getTemplateType());
        r0.add(this.mCameraControlInternal.getSessionConfig());
        SessionConfig r2 = r0.build();
        this.mCaptureSession.setSessionConfig(r2);
        return;
    L5:
        this.mCameraControlInternal.resetTemplate();
        this.mCaptureSession.setSessionConfig(this.mCameraControlInternal.getSessionConfig());
    }

    private /* synthetic */ void lambda$addOrRemoveMeteringRepeatingUseCase$17() {
        if (isMeteringRepeatingAttached() == true) goto L5;
        return;
    L5:
        SessionConfig r3 = this.mMeteringRepeatingSession.getSessionConfig();
        UseCaseConfig<?> r4 = this.mMeteringRepeatingSession.getUseCaseConfig();
        resetUseCase(getMeteringRepeatingId(this.mMeteringRepeatingSession), r3, r4, null, Collections.singletonList(UseCaseConfigFactory.CaptureType.METERING_REPEATING));
    }

    private ListenableFuture<Void> releaseInternal() {
        ListenableFuture<Void> r0 = getOrCreateUserReleaseFuture();
        boolean r2 = true;
        switch(this.mState.ordinal()) {
            case 1: goto L12;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L5;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        debugLog("release() ignored due to being in state: " + this.mState);
    L20:
        return r0;
    L5:
        setState(InternalState.RELEASING);
        closeCamera(false);
        goto L20
    L7:
        if (this.mCameraDevice == null) goto L10;
        r2 = false;
    L10:
        Preconditions.checkState(r2);
        setState(InternalState.RELEASING);
        Preconditions.checkState(isSessionCloseComplete());
        configAndCloseIfNeeded();
        goto L20
    L12:
        if (this.mStateCallback.cancelScheduledReopen() == false) goto L14;
    L17:
        this.mErrorTimeoutReopenScheduler.cancel();
        setState(InternalState.RELEASING);
        if (r2 == false) goto L20;
        Preconditions.checkState(isSessionCloseComplete());
        configAndCloseIfNeeded();
        goto L20
    L14:
        if (this.mErrorTimeoutReopenScheduler.isErrorHandling() == true) goto L17;
        r2 = false;
        goto L17
    }

    public CameraAvailability getCameraAvailability() {
        return this.mCameraAvailability;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public CameraConfig getExtendedConfig() {
        return this.mCameraConfig;
    }

    public static /* synthetic */ ScheduledExecutorService access$100(Camera2CameraImpl r0) {
        return r0.mScheduledExecutorService;
    }

    public static /* synthetic */ Executor access$200(Camera2CameraImpl r0) {
        return r0.mExecutor;
    }

    public static /* synthetic */ StateCallback access$300(Camera2CameraImpl r0) {
        return r0.mStateCallback;
    }

    public static /* synthetic */ void access$400(Camera2CameraImpl r0) {
        r0.configAndCloseIfNeeded();
    }

    public static /* synthetic */ ErrorTimeoutReopenScheduler access$500(Camera2CameraImpl r0) {
        return r0.mErrorTimeoutReopenScheduler;
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder r7) {
        if (r7.getSurfaces().isEmpty() == true) goto L6;
        Logger.w(TAG, "The capture config builder already has surface inside.");
        return false;
    L6:
        Iterator<SessionConfig> r0 = this.mUseCaseAttachState.getActiveAndAttachedSessionConfigs().iterator();
    L8:
        if (r0.hasNext() == false) goto L22;
        CaptureConfig r3 = r0.next().getRepeatingCaptureConfig();
        List<DeferrableSurface> r4 = r3.getSurfaces();
        if (r4.isEmpty() == true) goto L8;
        if (r3.getPreviewStabilizationMode() == 0) goto L15;
        r7.setPreviewStabilization(r3.getPreviewStabilizationMode());
    L15:
        if (r3.getVideoStabilizationMode() == 0) goto L17;
        r7.setVideoStabilization(r3.getVideoStabilizationMode());
    L17:
        Iterator<DeferrableSurface> r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L8;
        r7.addSurface(r5.next());
        goto L19
    L22:
        if (r7.getSurfaces().isEmpty() == false) goto L25;
        Logger.w(TAG, "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    L25:
        return true;
    }

    private ListenableFuture<Void> configAndClose(CameraDevice r7) {
        final CaptureSession r0 = new CaptureSession(this.mDynamicRangesCompat);
        final SurfaceTexture r1 = new SurfaceTexture(0);
        r1.setDefaultBufferSize(640, 480);
        final Surface r2 = new Surface(r1);
        final ImmediateSurface r3 = new ImmediateSurface(r2);
        r3.getTerminationFuture().addListener(new a0(r2, r1), CameraXExecutors.directExecutor());
        SessionConfig.Builder r4 = new SessionConfig.Builder();
        r4.addNonRepeatingSurface(r3);
        r4.setTemplateType(1);
        debugLog("Start configAndClose.");
        return FutureChain.from(Futures.transformAsyncOnCompletion(r0.open(r4.build(), r7, this.mCaptureSessionOpenerBuilder.build()))).transformAsync(new d0(r0, r3), this.mExecutor);
    }

    public static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase r1) {
        if (r1.getCamera() != null) goto L7;
        return null;
    L7:
        return StreamSharing.getCaptureTypes(r1);
    }

    public static String getMeteringRepeatingId(MeteringRepeatingSession r2) {
        return r2.getName() + r2.hashCode();
    }

    public static String getUseCaseId(UseCase r2) {
        return r2.getName() + r2.hashCode();
    }

    private /* synthetic */ void lambda$attachUseCases$15(List r2) {
        tryAttachUseCases(r2);     // Catch: Throwable -> L5
        this.mCameraControlInternal.decrementUseCount();
        return;
    L5:
        th = move-exception;
        this.mCameraControlInternal.decrementUseCount();
        throw th;
    }

    private /* synthetic */ void lambda$detachUseCases$16(List r1) {
        tryDetachUseCases(r1);
    }

    private /* synthetic */ Object lambda$getOrCreateUserReleaseFuture$6(CallbackToFutureAdapter.Completer r3) throws Exception {
        if (this.mUserReleaseNotifier != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "Camera can only be released once, so release completer should be null on creation.");
        this.mUserReleaseNotifier = r3;
        return "Release[camera=" + this + "]";
    L5:
        r0 = false;
        goto L6
    }

    private /* synthetic */ void lambda$isMeteringRepeatingAttached$13(CallbackToFutureAdapter.Completer r3) {
        MeteringRepeatingSession r0 = this.mMeteringRepeatingSession;
        if (r0 != null) goto L6;
        r3.set(Boolean.FALSE);
        return;
    L6:
        String r1 = getMeteringRepeatingId(r0);
        r3.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(r1)));
    }

    private /* synthetic */ Object lambda$isMeteringRepeatingAttached$14(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new i0(this, r3));     // Catch: RejectedExecutionException -> L4
        return "isMeteringRepeatingAttached";
    L4:
        r3.setException(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
        return "isMeteringRepeatingAttached";
    }

    private /* synthetic */ void lambda$onUseCaseInactive$8(String r3) {
        debugLog("Use case " + r3 + " INACTIVE");
        this.mUseCaseAttachState.setUseCaseInactive(r3);
        updateCaptureSessionConfig();
    }

    private /* synthetic */ Object lambda$openCameraConfigAndClose$1(final CallbackToFutureAdapter.Completer r5) throws Exception {
        ArrayList r1 = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());     // Catch: SecurityException -> L4 Throwable -> L6
        r1.add(this.mCaptureSessionRepository.getCameraStateCallback());     // Catch: SecurityException -> L4 Throwable -> L6
        r1.add(new AnonymousClass2(this, r5));     // Catch: SecurityException -> L4 Throwable -> L6
        this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, CameraDeviceStateCallbacks.createComboCallback(r1));     // Catch: SecurityException -> L4 Throwable -> L6
        return "configAndCloseTask";
    L6:
        e = move-exception;
        debugLog("Unable to open camera for configAndClose: " + e.getMessage(), e);
        r5.setException(e);
        return "configAndCloseTask";
    }

    private /* synthetic */ void lambda$release$4(CallbackToFutureAdapter.Completer r2) {
        Futures.propagate(releaseInternal(), r2);
    }

    private /* synthetic */ Object lambda$release$5(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new s(this, r3));
        return "Release[request=" + this.mReleaseRequestCount.getAndIncrement() + "]";
    }

    private /* synthetic */ void lambda$setActiveResumingMode$18(boolean r2) {
        this.mIsActiveResumingMode = r2;
        if (r2 == true) goto L5;
        return;
    L5:
        if (this.mState != InternalState.PENDING_OPEN) goto L9;
        tryForceOpenCameraDevice(false);
        return;
    }

    private void notifyStateAttachedAndCameraControlReady(List<UseCase> r4) {
        Iterator<UseCase> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        UseCase r0 = r5.next();
        String r1 = getUseCaseId(r0);
        if (this.mNotifyStateAttachedSet.contains(r1) == true) goto L4;
        this.mNotifyStateAttachedSet.add(r1);
        r0.onStateAttached();
        r0.onCameraControlReady();
        goto L4
    }

    private void notifyStateDetachedToUseCases(List<UseCase> r4) {
        Iterator<UseCase> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        UseCase r0 = r5.next();
        String r1 = getUseCaseId(r0);
        if (this.mNotifyStateAttachedSet.contains(r1) == false) goto L4;
        r0.onStateDetached();
        this.mNotifyStateAttachedSet.remove(r1);
        goto L4
    }

    private void openCameraDevice(boolean r5) {
        if (r5 == true) goto L5;
        this.mStateCallback.resetReopenMonitor();
    L5:
        this.mStateCallback.cancelScheduledReopen();
        this.mErrorTimeoutReopenScheduler.cancel();
        debugLog("Opening camera.");
        setState(InternalState.OPENING);
        this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());     // Catch: SecurityException -> L8 CameraAccessExceptionCompat -> L10
    L20:
        return;
    L10:
        e = move-exception;
        debugLog("Unable to open camera due to " + e.getMessage());
        if (e.getReason() == 10001) goto L14;
        this.mErrorTimeoutReopenScheduler.start();
        return;
    L14:
        setState(InternalState.INITIALIZED, CameraState.StateError.create(7, e));
        return;
    L8:
        e = move-exception;
        debugLog("Unable to open camera due to " + e.getMessage());
        setState(InternalState.REOPENING);
        this.mStateCallback.scheduleCameraReopen();
    }

    private Collection<UseCaseInfo> toUseCaseInfos(Collection<UseCase> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<UseCase> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(UseCaseInfo.from(r5.next(), this.mIsPrimary));
        goto L4
    L6:
        return r0;
    }

    private void tryAttachUseCases(Collection<UseCaseInfo> r12) {
        boolean r0 = this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty();
        ArrayList r1 = new ArrayList();
        Iterator<UseCaseInfo> r13 = r12.iterator();
        Rational r2 = null;
    L4:
        if (r13.hasNext() == false) goto L13;
        UseCaseInfo r3 = r13.next();
        if (this.mUseCaseAttachState.isUseCaseAttached(r3.getUseCaseId()) == true) goto L4;
        this.mUseCaseAttachState.setUseCaseAttached(r3.getUseCaseId(), r3.getSessionConfig(), r3.getUseCaseConfig(), r3.getStreamSpec(), r3.getCaptureTypes());
        r1.add(r3.getUseCaseId());
        if (r3.getUseCaseType() != Preview.class) goto L4;
        Size r4 = r3.getSurfaceResolution();
        if (r4 == null) goto L4;
        r2 = new Rational(r4.getWidth(), r4.getHeight());
        goto L4
    L13:
        if (r1.isEmpty() == false) goto L15;
        return;
    L15:
        debugLog("Use cases [" + TextUtils.join(", ", r1) + "] now ATTACHED");
        if (r0 == false) goto L18;
        this.mCameraControlInternal.setActive(true);
        this.mCameraControlInternal.incrementUseCount();
    L18:
        addOrRemoveMeteringRepeatingUseCase();
        updateZslDisabledByUseCaseConfigStatus();
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState != InternalState.OPENED) goto L21;
        openCaptureSession();
    L22:
        if (r2 == null) goto L34;
        this.mCameraControlInternal.setPreviewAspectRatio(r2);
        return;
    L34:
        return;
    L21:
        openInternal();
        goto L22
    }

    private void tryDetachUseCases(Collection<UseCaseInfo> r7) {
        ArrayList r0 = new ArrayList();
        Iterator<UseCaseInfo> r8 = r7.iterator();
        boolean r2 = false;
    L4:
        if (r8.hasNext() == false) goto L11;
        UseCaseInfo r3 = r8.next();
        if (this.mUseCaseAttachState.isUseCaseAttached(r3.getUseCaseId()) == false) goto L4;
        this.mUseCaseAttachState.removeUseCase(r3.getUseCaseId());
        r0.add(r3.getUseCaseId());
        if (r3.getUseCaseType() != Preview.class) goto L4;
        r2 = true;
        goto L4
    L11:
        if (r0.isEmpty() == false) goto L13;
        return;
    L13:
        debugLog("Use cases [" + TextUtils.join(", ", r0) + "] now DETACHED for camera");
        if (r2 == false) goto L16;
        this.mCameraControlInternal.setPreviewAspectRatio(null);
    L16:
        addOrRemoveMeteringRepeatingUseCase();
        if (this.mUseCaseAttachState.getAttachedUseCaseConfigs().isEmpty() == false) goto L19;
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(false);
    L21:
        if (this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty() == false) goto L23;
        this.mCameraControlInternal.decrementUseCount();
        resetCaptureSession(false);
        this.mCameraControlInternal.setActive(false);
        this.mCaptureSession = newCaptureSession();
        closeInternal();
        return;
    L23:
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState != InternalState.OPENED) goto L35;
        openCaptureSession();
        return;
    L35:
        return;
    L19:
        updateZslDisabledByUseCaseConfigStatus();
        goto L21
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(Collection<UseCase> r3) {
        ArrayList r0 = new ArrayList(r3);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        this.mCameraControlInternal.incrementUseCount();
        notifyStateAttachedAndCameraControlReady(new ArrayList(r0));
        final ArrayList r4 = new ArrayList(toUseCaseInfos(r0));
        this.mExecutor.execute(new c0(this, r4));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        debugLog("Unable to attach use cases.", e);
        this.mCameraControlInternal.decrementUseCount();
    }

    public void closeCamera(boolean r4) {
        if (this.mState != InternalState.CLOSING) goto L5;
    L12:
        boolean r0 = true;
    L13:
        Preconditions.checkState(r0, "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.mState + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")");
        resetCaptureSession(r4);
        this.mCaptureSession.cancelIssuedCaptureRequests();
        return;
    L5:
        if (this.mState == InternalState.RELEASING) goto L12;
        if (this.mState == InternalState.REOPENING) goto L9;
    L11:
        r0 = false;
        goto L13
    L9:
        if (this.mCameraDeviceError == 0) goto L11;
        goto L11
    }

    public void debugLog(String r2) {
        debugLog(r2, null);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(Collection<UseCase> r3) {
        ArrayList r0 = new ArrayList(r3);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        final ArrayList r4 = new ArrayList(toUseCaseInfos(r0));
        notifyStateDetachedToUseCases(new ArrayList(r0));
        this.mExecutor.execute(new z(this, r4));
    }

    public SessionConfig findSessionConfigForSurface(DeferrableSurface r4) {
        Iterator<SessionConfig> r0 = this.mUseCaseAttachState.getAttachedSessionConfigs().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        SessionConfig r1 = r0.next();
        if (r1.getSurfaces().contains(r4) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public boolean isUseCaseAttached(UseCase r3) {
        final String r4 = getUseCaseId(r3);     // Catch: Throwable -> L4 InterruptedException -> L6
        return ((Boolean) CallbackToFutureAdapter.getFuture(new u(this, r4)).get()).booleanValue();
    L4:
        e = move-exception;
        throw new RuntimeException("Unable to check if use case is attached.", e);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(UseCase r9) {
        Preconditions.checkNotNull(r9);
        final String r2 = getUseCaseId(r9);
        if (this.mIsPrimary == false) goto L5;
        SessionConfig r0 = r9.getSessionConfig();
    L6:
        final SessionConfig r3 = r0;
        final UseCaseConfig<?> r4 = r9.getCurrentConfig();
        final StreamSpec r5 = r9.getAttachedStreamSpec();
        final List<UseCaseConfigFactory.CaptureType> r6 = getCaptureTypes(r9);
        this.mExecutor.execute(new q(this, r2, r3, r4, r5, r6));
        return;
    L5:
        r0 = r9.getSecondarySessionConfig();
        goto L6
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(UseCase r3) {
        Preconditions.checkNotNull(r3);
        final String r4 = getUseCaseId(r3);
        this.mExecutor.execute(new p(this, r4));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(UseCase r8) {
        Preconditions.checkNotNull(r8);
        if (this.mIsPrimary == false) goto L5;
        SessionConfig r0 = r8.getSessionConfig();
    L6:
        UseCaseConfig<?> r4 = r8.getCurrentConfig();
        StreamSpec r5 = r8.getAttachedStreamSpec();
        List<UseCaseConfigFactory.CaptureType> r6 = getCaptureTypes(r8);
        String r2 = getUseCaseId(r8);
        resetUseCase(r2, r0, r4, r5, r6);
        return;
    L5:
        r0 = r8.getSecondarySessionConfig();
        goto L6
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(UseCase r9) {
        Preconditions.checkNotNull(r9);
        final String r2 = getUseCaseId(r9);
        if (this.mIsPrimary == false) goto L5;
        SessionConfig r0 = r9.getSessionConfig();
    L6:
        final SessionConfig r3 = r0;
        final UseCaseConfig<?> r4 = r9.getCurrentConfig();
        final StreamSpec r5 = r9.getAttachedStreamSpec();
        final List<UseCaseConfigFactory.CaptureType> r6 = getCaptureTypes(r9);
        this.mExecutor.execute(new t(this, r2, r3, r4, r5, r6));
        return;
    L5:
        r0 = r9.getSecondarySessionConfig();
        goto L6
    }

    public void postSurfaceClosedError(final SessionConfig r5) {
        ScheduledExecutorService r0 = CameraXExecutors.mainThreadExecutor();
        final SessionConfig.ErrorListener r1 = r5.getErrorListener();
        if (r1 == null) goto L6;
        debugLog("Posting surface closed", new Throwable());
        r0.execute(new r(r1, r5));
        return;
    }

    public void resetCaptureSession(boolean r6) {
        if (this.mCaptureSession == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        debugLog("Resetting Capture Session");
        CaptureSessionInterface r1 = this.mCaptureSession;
        SessionConfig r2 = r1.getSessionConfig();
        List<CaptureConfig> r3 = r1.getCaptureConfigs();
        CaptureSessionInterface r4 = newCaptureSession();
        this.mCaptureSession = r4;
        r4.setSessionConfig(r2);
        this.mCaptureSession.issueCaptureRequests(r3);
        if (this.mState.ordinal() == 8) goto L10;
        debugLog("Skipping Capture Session state check due to current camera state: " + this.mState + " and previous session status: " + r1.isInOpenState());
    L15:
        if (this.mConfigAndCloseQuirk == true) goto L17;
    L19:
        releaseSession(r1, r6);
        return;
    L17:
        if (r1.isInOpenState() == false) goto L19;
        debugLog("ConfigAndClose is required when close the camera.");
        this.mIsConfigAndCloseRequired = true;
        goto L19
    L10:
        if (this.mCloseCameraBeforeCreateNewSessionQuirk == false) goto L15;
        if (r1.isInOpenState() == false) goto L15;
        debugLog("Close camera before creating new session");
        setState(InternalState.REOPENING_QUIRK);
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setActiveResumingMode(final boolean r3) {
        this.mExecutor.execute(new e0(this, r3));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setExtendedConfig(CameraConfig r2) {
        if (r2 != null) goto L5;
        r2 = CameraConfigs.defaultConfig();
    L5:
        SessionProcessor r0 = r2.getSessionProcessor(null);
        this.mCameraConfig = r2;
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mSessionProcessor = r0;     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setPrimary(boolean r1) {
        this.mIsPrimary = r1;
    }

    public void setState(InternalState r2) {
        setState(r2, null);
    }

    public void submitCaptureRequests(List<CaptureConfig> r6) {
        ArrayList r0 = new ArrayList();
        Iterator<CaptureConfig> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L18;
        CaptureConfig r1 = r7.next();
        CaptureConfig.Builder r2 = CaptureConfig.Builder.from(r1);
        if (r1.getTemplateType() != 5) goto L11;
        if (r1.getCameraCaptureResult() == null) goto L11;
        r2.setCameraCaptureResult(r1.getCameraCaptureResult());
    L11:
        if (r1.getSurfaces().isEmpty() == false) goto L17;
        if (r1.isUseRepeatingSurface() == false) goto L17;
        if (checkAndAttachRepeatingSurface(r2) == false) goto L4;
    L17:
        r0.add(r2.build());
        goto L4
    L18:
        debugLog("Issue capture request");
        this.mCaptureSession.issueCaptureRequests(r0);
    }

    public void tryForceOpenCameraDevice(boolean r2) {
        debugLog("Attempting to force open the camera.");
        if (this.mCameraStateRegistry.tryOpenCamera(this) == true) goto L6;
        debugLog("No cameras available. Waiting for available camera before opening camera.");
        setState(InternalState.PENDING_OPEN);
        return;
    L6:
        openCameraDevice(r2);
    }

    public void tryOpenCameraDevice(boolean r2) {
        debugLog("Attempting to open the camera.");
        if (this.mCameraAvailability.isCameraAvailable() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L11;
        debugLog("No cameras available. Waiting for available camera before opening camera.");
        setState(InternalState.PENDING_OPEN);
        return;
    L11:
        openCameraDevice(r2);
        return;
    L5:
        if (this.mCameraStateRegistry.tryOpenCamera(this) == false) goto L7;
        r0 = true;
        goto L8
    }

    public static /* synthetic */ ListenableFuture access$600(Camera2CameraImpl r0, CameraDevice r1) {
        return r0.configAndClose(r1);
    }

    private void debugLog(String r4, Throwable r5) {
        Logger.d(TAG, String.format("{%s} %s", new Object[]{toString(), r4}), r5);
    }

    private static /* synthetic */ void lambda$configAndClose$2(Surface r0, SurfaceTexture r1) {
        r0.release();
        r1.release();
    }

    private /* synthetic */ void lambda$isUseCaseAttached$11(CallbackToFutureAdapter.Completer r2, String r3) {
        r2.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(r3)));
    }

    private /* synthetic */ Object lambda$isUseCaseAttached$12(final String r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mExecutor.execute(new x(this, r4, r3));     // Catch: RejectedExecutionException -> L4
        return "isUseCaseAttached";
    L4:
        r4.setException(new RuntimeException("Unable to check if use case is attached. Camera executor shut down."));
        return "isUseCaseAttached";
    }

    private static /* synthetic */ void lambda$postSurfaceClosedError$19(SessionConfig.ErrorListener r1, SessionConfig r2) {
        r1.onError(r2, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }

    public ListenableFuture<Void> releaseSession(final CaptureSessionInterface r3, boolean r4) {
        r3.close();
        ListenableFuture<Void> r5 = r3.release(r4);
        debugLog("Releasing session in state " + this.mState.name());
        this.mReleasedCaptureSessions.put(r3, r5);
        Futures.addCallback(r5, new AnonymousClass3(this, r3), CameraXExecutors.directExecutor());
        return r5;
    }

    public void setState(InternalState r2, CameraState.StateError r3) {
        setState(r2, r3, true);
    }

    public void traceInternalState(InternalState r3, CameraState.StateError r4) {
        if (Trace.isEnabled() == false) goto L15;
        Trace.setCounter("CX:C2State[" + this + "]", r3.ordinal());
        if (r4 == null) goto L8;
        this.mTraceStateErrorCount++;
    L8:
        if (this.mTraceStateErrorCount <= 0) goto L16;
        String r5 = "CX:C2StateErrorCode[" + this + "]";
        if (r4 == null) goto L12;
        int r6 = r4.getCode();
    L13:
        Trace.setCounter(r5, r6);
        return;
    L12:
        r6 = 0;
        goto L13
    L16:
        return;
    }

    private static /* synthetic */ ListenableFuture lambda$configAndClose$3(CaptureSession r0, DeferrableSurface r1, Void r2) throws Exception {
        r0.close();
        r1.close();
        return r0.release(false);
    }

    public void setState(InternalState r3, CameraState.StateError r4, boolean r5) {
        debugLog("Transitioning camera internal state: " + this.mState + " --> " + r3);
        traceInternalState(r3, r4);
        this.mState = r3;
        switch(r3.ordinal()) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        CameraInternal.State r6 = CameraInternal.State.CONFIGURED;
    L14:
        this.mCameraStateRegistry.markCameraState(this, r6, r5);
        this.mObservableState.postValue(r6);
        this.mCameraStateMachine.updateState(r6, r4);
        return;
    L7:
        r6 = CameraInternal.State.OPEN;
        goto L14
    L8:
        r6 = CameraInternal.State.OPENING;
        goto L14
    L9:
        r6 = CameraInternal.State.CLOSING;
        goto L14
    L10:
        r6 = CameraInternal.State.PENDING_OPEN;
        goto L14
    L11:
        r6 = CameraInternal.State.CLOSED;
        goto L14
    L12:
        r6 = CameraInternal.State.RELEASING;
        goto L14
    L13:
        r6 = CameraInternal.State.RELEASED;
        goto L14
    L5:
        throw new IllegalStateException("Unknown state: " + r3);
    }

    private /* synthetic */ void lambda$onUseCaseActive$7(String r9, SessionConfig r10, UseCaseConfig r11, StreamSpec r12, List r13) {
        debugLog("Use case " + r9 + " ACTIVE");
        this.mUseCaseAttachState.setUseCaseActive(r9, r10, r11, r12, r13);
        this.mUseCaseAttachState.updateUseCase(r9, r10, r11, r12, r13);
        updateCaptureSessionConfig();
    }

    private /* synthetic */ void lambda$onUseCaseUpdated$9(String r8, SessionConfig r9, UseCaseConfig r10, StreamSpec r11, List r12) {
        debugLog("Use case " + r8 + " UPDATED");
        this.mUseCaseAttachState.updateUseCase(r8, r9, r10, r11, r12);
        updateCaptureSessionConfig();
    }

    private /* synthetic */ void lambda$resetUseCase$10(String r8, SessionConfig r9, UseCaseConfig r10, StreamSpec r11, List r12) {
        debugLog("Use case " + r8 + " RESET");
        this.mUseCaseAttachState.updateUseCase(r8, r9, r10, r11, r12);
        addOrRemoveMeteringRepeatingUseCase();
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        if (this.mState != InternalState.OPENED) goto L6;
        openCaptureSession();
        return;
    }

    private void resetUseCase(final String r10, final SessionConfig r11, final UseCaseConfig<?> r12, final StreamSpec r13, final List<UseCaseConfigFactory.CaptureType> r14) {
        this.mExecutor.execute(new v(this, r10, r11, r12, r13, r14));
    }

    public Camera2CameraImpl(Context r20, CameraManagerCompat r21, String r22, Camera2CameraInfoImpl r23, CameraCoordinator r24, CameraStateRegistry r25, Executor r26, Handler r27, DisplayInfoManager r28, long r29) throws CameraUnavailableException {
        this.mState = InternalState.INITIALIZED;
        LiveDataObservable<CameraInternal.State> r11 = new LiveDataObservable();
        this.mObservableState = r11;
        this.mCameraDeviceError = 0;
        this.mReleaseRequestCount = new AtomicInteger(0);
        this.mReleasedCaptureSessions = new LinkedHashMap();
        this.mTraceStateErrorCount = 0;
        this.mIsConfigAndCloseRequired = false;
        this.mIsConfiguringForClose = false;
        this.mIsPrimary = true;
        this.mNotifyStateAttachedSet = new HashSet();
        this.mCameraConfig = CameraConfigs.defaultConfig();
        this.mLock = new Object();
        this.mIsActiveResumingMode = false;
        this.mErrorTimeoutReopenScheduler = new ErrorTimeoutReopenScheduler(this, null);
        this.mCameraManager = r21;
        this.mCameraCoordinator = r24;
        this.mCameraStateRegistry = r25;
        ScheduledExecutorService r14 = CameraXExecutors.newHandlerExecutor(r27);
        this.mScheduledExecutorService = r14;
        Executor r15 = CameraXExecutors.newSequentialExecutor(r26);
        this.mExecutor = r15;
        this.mStateCallback = new StateCallback(this, r15, r14, r29);
        this.mUseCaseAttachState = new UseCaseAttachState(r22);
        r11.postValue(CameraInternal.State.CLOSED);
        CameraStateMachine r12 = new CameraStateMachine(r25);
        this.mCameraStateMachine = r12;
        CaptureSessionRepository r13 = new CaptureSessionRepository(r15);
        this.mCaptureSessionRepository = r13;
        this.mDisplayInfoManager = r28;
        CameraCharacteristicsCompat r16 = r21.getCameraCharacteristicsCompat(r22);     // Catch: CameraAccessExceptionCompat -> L6
        this.mCameraCharacteristicsCompat = r16;     // Catch: CameraAccessExceptionCompat -> L6
        Camera2CameraControlImpl r6 = new Camera2CameraControlImpl(r16, r14, r15, new ControlUpdateListenerInternal(this), r23.getCameraQuirks());     // Catch: CameraAccessExceptionCompat -> L6
        this.mCameraControlInternal = r6;     // Catch: CameraAccessExceptionCompat -> L6
        this.mCameraInfoInternal = r23;     // Catch: CameraAccessExceptionCompat -> L6
        r23.linkWithCameraControl(r6);     // Catch: CameraAccessExceptionCompat -> L6
        r23.setCameraStateSource(r12.getStateLiveData());     // Catch: CameraAccessExceptionCompat -> L6
        this.mDynamicRangesCompat = DynamicRangesCompat.fromCameraCharacteristics(r16);
        this.mCaptureSession = newCaptureSession();
        this.mCaptureSessionOpenerBuilder = new SynchronizedCaptureSession.OpenerBuilder(r15, r14, r27, r13, r23.getCameraQuirks(), DeviceQuirks.getAll());
        this.mCloseCameraBeforeCreateNewSessionQuirk = r23.getCameraQuirks().contains(LegacyCameraOutputConfigNullPointerQuirk.class);
        this.mConfigAndCloseQuirk = r23.getCameraQuirks().contains(LegacyCameraSurfaceCleanupQuirk.class);
        CameraAvailability r1 = new CameraAvailability(this, r22);
        this.mCameraAvailability = r1;
        CameraConfigureAvailable r2 = new CameraConfigureAvailable(this);
        this.mCameraConfigureAvailable = r2;
        r25.registerCamera(this, r15, r2, r1);
        r21.registerAvailabilityCallback(r15, r1);
        this.mSupportedSurfaceCombination = new SupportedSurfaceCombination(r20, r22, r21, new AnonymousClass1(this));
        return;
    L6:
        e = move-exception;
        throw CameraUnavailableExceptionHelper.createFrom(e);
    }
}
