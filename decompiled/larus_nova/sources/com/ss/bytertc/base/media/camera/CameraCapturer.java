package com.ss.bytertc.base.media.camera;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes40.dex */
abstract class CameraCapturer implements CameraVideoCapturer {
    private static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
    private static final int OPEN_CAMERA_DELAY_MS = 500;
    private static final int OPEN_CAMERA_TIMEOUT = 10000;
    private static final String TAG = "CameraCapturer";
    private Context applicationContext;
    private final CameraEnumerator cameraEnumerator;
    private String cameraName;
    private final CameraSession.Events cameraSessionEventsHandler;
    private CameraVideoCapturer.CameraStatistics cameraStatistics;
    private Handler cameraThreadHandler;
    private CapturerObserver capturerObserver;
    private final CameraSession.CreateSessionCallback createSessionCallback;
    private CameraSession currentSession;
    private final CameraVideoCapturer.CameraEventsHandler eventsHandler;
    private boolean firstFrameObserved;
    private int framerate;
    private int height;
    protected boolean mEnableFollowGravity;
    private CameraVideoCapturer.ORIENTATION_MODE mOrientationMode;
    private String nativeLibraryName;
    private int openAttemptsRemaining;
    private final Runnable openCameraTimeoutRunnable;
    private boolean sessionOpening;
    private final Object stateLock;
    private SurfaceTextureHelper surfaceHelper;
    private CameraVideoCapturer.CameraSwitchHandler switchEventsHandler;
    private SwitchState switchState;
    private final Handler uiThreadHandler;
    private int width;

    public static final enum SwitchState extends Enum<SwitchState> {
        private static final /* synthetic */ SwitchState[] $VALUES = null;
        public static final SwitchState IDLE = null;
        public static final SwitchState IN_PROGRESS = null;
        public static final SwitchState PENDING = null;

        static {
            SwitchState r100 = new SwitchState("IDLE", 0);
            IDLE = r100;
            SwitchState r101 = new SwitchState("PENDING", 1);
            PENDING = r101;
            SwitchState r102 = new SwitchState("IN_PROGRESS", 2);
            IN_PROGRESS = r102;
            $VALUES = new SwitchState[]{r100, r101, r102};
        }

        public static SwitchState[] values() {
            return (SwitchState[]) $VALUES.clone();
        }

        public static SwitchState valueOf(String r100) {
            return (SwitchState) r27.a.a(SwitchState.class, r100);
        }

        private SwitchState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void a(CameraCapturer r100, float r101, AtomicInteger r102) {
        r100.lambda$setCameraZoomRatio$4(r101, r102);
    }

    public static /* synthetic */ void b(CameraCapturer r100, AtomicBoolean r101) {
        r100.lambda$isCameraFocusPointSupported$7(r101);
    }

    public static /* synthetic */ void c(CameraCapturer r100) {
        r100.lambda$turnOnFlashLight$1();
    }

    public static /* synthetic */ void d(CameraCapturer r100, AtomicInteger r101, boolean r102) {
        r100.lambda$enableCameraAutoExposureFaceMode$10(r101, r102);
    }

    public static /* synthetic */ void e(CameraCapturer r100, float r101, float r102, AtomicInteger r103) {
        r100.lambda$setCameraExposurePoint$6(r101, r102, r103);
    }

    public static /* synthetic */ void f(CameraCapturer r100, AtomicInteger r101, float r102) {
        r100.lambda$setCameraExposureCompensation$9(r101, r102);
    }

    public static /* synthetic */ void g(CameraCapturer r100, AtomicBoolean r101) {
        r100.lambda$isCameraTorchSupported$0(r101);
    }

    public static /* synthetic */ void h(CameraCapturer r100, AtomicReference r101) {
        r100.lambda$getCameraZoomMaxRatio$11(r101);
    }

    public static /* synthetic */ void i(CameraCapturer r100, boolean r101, AtomicInteger r102) {
        r100.lambda$enableFollowGravity$12(r101, r102);
    }

    public static /* synthetic */ void j(CameraCapturer r100, float r101, float r102, AtomicInteger r103) {
        r100.lambda$setCameraFocusPoint$5(r101, r102, r103);
    }

    public static /* synthetic */ void k(CameraCapturer r100, AtomicInteger r101) {
        r100.lambda$getDeviceOrientation$13(r101);
    }

    public static /* synthetic */ void l(CameraCapturer r100, AtomicBoolean r101) {
        r100.lambda$isCameraZoomSupported$3(r101);
    }

    public static /* synthetic */ void m(CameraCapturer r100, AtomicBoolean r101) {
        r100.lambda$isCameraExposurePointSupported$8(r101);
    }

    public static /* synthetic */ void n(CameraCapturer r100) {
        r100.lambda$turnOffFlashLight$2();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public final /* synthetic */ void addMediaRecorderToCamera(MediaRecorder r100, CameraVideoCapturer.MediaRecorderHandler r101) {
        CameraVideoCapturer.CC.$default$addMediaRecorderToCamera(this, r100, r101);
    }

    public abstract void createCameraSession(CameraSession.CreateSessionCallback r100, CameraSession.Events r101, Context r102, SurfaceTextureHelper r103, String r104, int r105, int r106, int r107);

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void disableDoOrientation() {
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public final /* synthetic */ void removeMediaRecorderFromCamera(CameraVideoCapturer.MediaRecorderHandler r100) {
        CameraVideoCapturer.CC.$default$removeMediaRecorderFromCamera(this, r100);
    }

    private void checkIsOnCameraThread() {
        if (this.cameraThreadHandler != null) goto L5;
    L7:
        RXLogging.e(TAG, "Check is on camera thread failed.");
        throw new RuntimeException("Not on camera thread.");
    L5:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(this.cameraThreadHandler.getLooper())) goto L7;
    }

    private /* synthetic */ void lambda$turnOffFlashLight$2() {
        CameraSession r100 = this.currentSession;
        if (r100 == null) goto L6;
        r100.turnOffFlashLight();
        return;
    }

    private /* synthetic */ void lambda$turnOnFlashLight$1() {
        CameraSession r100 = this.currentSession;
        if (r100 == null) goto L6;
        r100.turnOnFlashLight();
        return;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void dispose() {
        RXLogging.w(TAG, "dispose");
        stopCapture();
    }

    public String getCameraName() {
        Object r100 = this.stateLock;
        monitor-enter(r100);
        String r101 = this.cameraName;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public float getCameraZoomMaxRatio() {
        final AtomicReference r100 = new AtomicReference(Float.valueOf(1.0f));
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new g(this, r100));
        return ((Float) r100.get()).floatValue();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int getDeviceOrientation() {
        final AtomicInteger r100 = new AtomicInteger(0);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new m(this, r100));
        return r100.get();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraExposurePointSupported() {
        final AtomicBoolean r100 = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new q(this, r100));
        return r100.get();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraFocusPointSupported() {
        final AtomicBoolean r100 = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new n(this, r100));
        return r100.get();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraTorchSupported() {
        final AtomicBoolean r100 = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new k(this, r100));
        return r100.get();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraZoomSupported() {
        final AtomicBoolean r100 = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new p(this, r100));
        return r100.get();
    }

    public void printStackTrace() {
        Handler r100 = this.cameraThreadHandler;
        if (r100 == null) goto L5;
        Thread r101 = ThreadMethodProxy.getLooperThread(r100.getLooper());
    L6:
        if (r101 == null) goto L12;
        StackTraceElement[] r102 = r101.getStackTrace();
        if (r102.length <= 0) goto L14;
        RXLogging.w(TAG, "CameraCapturer stack trace:");
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        RXLogging.w(TAG, r102[r104].toString());
        r104 = r104 + 1;
        goto L10
    L15:
        return;
    L14:
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void stopCapture() {
        RXLogging.w(TAG, "Stop capture");
        Object r100 = this.stateLock;
        monitor-enter(r100);
    L25:
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.sessionOpening == false) goto L13;
        RXLogging.w(TAG, "Stop capture: Waiting for session to open");     // Catch: Throwable -> L22
        this.stateLock.wait();     // Catch: InterruptedException -> L9 Throwable -> L22
    L9:
        RXLogging.e(TAG, "Stop capture interrupted while waiting for the session to open.");     // Catch: Throwable -> L22
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L22
        return;
    L13:
        if (this.currentSession == null) goto L18;
        RXLogging.w(TAG, "Stop capture: Nulling session");     // Catch: Throwable -> L22
        CameraVideoCapturer.CameraStatistics r101 = this.cameraStatistics;     // Catch: Throwable -> L22
        if (r101 == null) goto L17;
        r101.release();     // Catch: Throwable -> L22
        this.cameraStatistics = null;     // Catch: Throwable -> L22
    L17:
        final CameraSession r102 = this.currentSession;     // Catch: Throwable -> L22
        this.cameraThreadHandler.post(new AnonymousClass6(this, r102));     // Catch: Throwable -> L22
        this.currentSession = null;     // Catch: Throwable -> L22
        this.capturerObserver.onCapturerStopped();     // Catch: Throwable -> L22
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L22
        RXLogging.w(TAG, "Stop capture done");
        return;
    L18:
        RXLogging.w(TAG, "Stop capture: No session open");     // Catch: Throwable -> L22
        goto L19
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOffFlashLight() {
        this.cameraThreadHandler.post(new r(this));
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOnFlashLight() {
        this.cameraThreadHandler.post(new e(this));
    }

    public static /* synthetic */ void access$000(CameraCapturer r100) {
        r100.checkIsOnCameraThread();
    }

    public static /* synthetic */ Runnable access$100(CameraCapturer r100) {
        return r100.openCameraTimeoutRunnable;
    }

    public static /* synthetic */ SurfaceTextureHelper access$1000(CameraCapturer r100) {
        return r100.surfaceHelper;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraEventsHandler access$1100(CameraCapturer r100) {
        return r100.eventsHandler;
    }

    public static /* synthetic */ boolean access$1200(CameraCapturer r100) {
        return r100.firstFrameObserved;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraSwitchHandler access$1300(CameraCapturer r100) {
        return r100.switchEventsHandler;
    }

    public static /* synthetic */ String access$1400(CameraCapturer r100) {
        return r100.cameraName;
    }

    public static /* synthetic */ CameraEnumerator access$1500(CameraCapturer r100) {
        return r100.cameraEnumerator;
    }

    public static /* synthetic */ int access$1700(CameraCapturer r100) {
        return r100.openAttemptsRemaining;
    }

    public static /* synthetic */ int access$1710(CameraCapturer r100) {
        int r101 = r100.openAttemptsRemaining;
        r100.openAttemptsRemaining = r101 - 1;
        return r101;
    }

    public static /* synthetic */ CameraSession.CreateSessionCallback access$1900(CameraCapturer r100) {
        return r100.createSessionCallback;
    }

    public static /* synthetic */ Handler access$200(CameraCapturer r100) {
        return r100.uiThreadHandler;
    }

    public static /* synthetic */ CameraSession.Events access$2000(CameraCapturer r100) {
        return r100.cameraSessionEventsHandler;
    }

    public static /* synthetic */ Context access$2100(CameraCapturer r100) {
        return r100.applicationContext;
    }

    public static /* synthetic */ int access$2200(CameraCapturer r100) {
        return r100.width;
    }

    public static /* synthetic */ int access$2300(CameraCapturer r100) {
        return r100.height;
    }

    public static /* synthetic */ int access$2400(CameraCapturer r100) {
        return r100.framerate;
    }

    public static /* synthetic */ Object access$300(CameraCapturer r100) {
        return r100.stateLock;
    }

    public static /* synthetic */ SwitchState access$400(CameraCapturer r100) {
        return r100.switchState;
    }

    public static /* synthetic */ CameraVideoCapturer.ORIENTATION_MODE access$500(CameraCapturer r100) {
        return r100.mOrientationMode;
    }

    public static /* synthetic */ CapturerObserver access$600(CameraCapturer r100) {
        return r100.capturerObserver;
    }

    public static /* synthetic */ CameraSession access$800(CameraCapturer r100) {
        return r100.currentSession;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraStatistics access$900(CameraCapturer r100) {
        return r100.cameraStatistics;
    }

    private void createSessionInternal(int r100) {
        this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, r100 + 10000);
        Handler r101 = this.cameraThreadHandler;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.postDelayed(new AnonymousClass5(this), r100);
    }

    private /* synthetic */ void lambda$getCameraZoomMaxRatio$11(AtomicReference r100) {
        CameraSession r101 = this.currentSession;
        if (r101 == null) goto L6;
        r100.set(Float.valueOf(r101.getCameraZoomMaxRatio()));
        return;
    }

    private /* synthetic */ void lambda$getDeviceOrientation$13(AtomicInteger r100) {
        CameraSession r101 = this.currentSession;
        if (r101 == null) goto L6;
        r100.set(r101.getDeviceOrientation());
        return;
    }

    private /* synthetic */ void lambda$isCameraExposurePointSupported$8(AtomicBoolean r100) {
        CameraSession r101 = this.currentSession;
        if (r101 == null) goto L6;
        r100.set(r101.isCameraExposurePointSupported());
        return;
    }

    private /* synthetic */ void lambda$isCameraFocusPointSupported$7(AtomicBoolean r100) {
        CameraSession r101 = this.currentSession;
        if (r101 == null) goto L6;
        r100.set(r101.isCameraFocusPointSupported());
        return;
    }

    private /* synthetic */ void lambda$isCameraTorchSupported$0(AtomicBoolean r100) {
        CameraSession r101 = this.currentSession;
        if (r101 == null) goto L6;
        r100.set(r101.isCameraTorchSupported());
        return;
    }

    private /* synthetic */ void lambda$isCameraZoomSupported$3(AtomicBoolean r100) {
        CameraSession r101 = this.currentSession;
        if (r101 == null) goto L6;
        r100.set(r101.isCameraZoomSupported());
        return;
    }

    private void switchCameraInternal(CameraVideoCapturer.CameraSwitchHandler r100) {
        RXLogging.w(TAG, "switchCamera internal");
        String[] r101 = this.cameraEnumerator.getDeviceNames();
        if (r101.length >= 2) goto L7;
        if (r100 == null) goto L40;
        r100.onCameraSwitchError("No camera to switch to.");
        return;
    L40:
        return;
    L7:
        Object r102 = this.stateLock;
        monitor-enter(r102);
    L36:
        th = move-exception;
        throw th;
    L10:
        if (this.switchState == SwitchState.IDLE) goto L14;
        reportCameraSwitchError("Camera switch already in progress.", r100);     // Catch: Throwable -> L36
        monitor-exit(r102);     // Catch: Throwable -> L36
        return;
    L14:
        boolean r103 = this.sessionOpening;     // Catch: Throwable -> L36
        if (r103 == false) goto L17;
    L21:
        this.switchEventsHandler = r100;     // Catch: Throwable -> L36
        if (r103 == false) goto L26;
        this.switchState = SwitchState.PENDING;     // Catch: Throwable -> L36
        monitor-exit(r102);     // Catch: Throwable -> L36
        return;
    L26:
        this.switchState = SwitchState.IN_PROGRESS;     // Catch: Throwable -> L36
        RXLogging.w(TAG, "switchCamera: Stopping session");     // Catch: Throwable -> L36
        CameraVideoCapturer.CameraStatistics r104 = this.cameraStatistics;     // Catch: Throwable -> L36
        if (r104 == null) goto L29;
        r104.release();     // Catch: Throwable -> L36
        this.cameraStatistics = null;     // Catch: Throwable -> L36
    L29:
        final CameraSession r105 = this.currentSession;     // Catch: Throwable -> L36
        Handler r106 = this.cameraThreadHandler;     // Catch: Throwable -> L36
        if (r106 == null) goto L32;
        r106.post(new AnonymousClass8(this, r105));     // Catch: Throwable -> L36
    L32:
        this.currentSession = null;     // Catch: Throwable -> L36
        this.cameraName = r101[(Arrays.asList(r101).indexOf(this.cameraName) + 1) % r101.length];     // Catch: Throwable -> L36
        this.sessionOpening = true;     // Catch: Throwable -> L36
        this.openAttemptsRemaining = 1;     // Catch: Throwable -> L36
        createSessionInternal(0);     // Catch: Throwable -> L36
        monitor-exit(r102);     // Catch: Throwable -> L36
        RXLogging.w(TAG, "switchCamera done");
        return;
    L17:
        if (this.currentSession != null) goto L21;
        reportCameraSwitchError("switchCamera: camera is not running.", r100);     // Catch: Throwable -> L36
        monitor-exit(r102);     // Catch: Throwable -> L36
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableCameraAutoExposureFaceMode(final boolean r100) {
        final AtomicInteger r101 = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new i(this, r101, r100));
        return r101.get();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableFollowGravity(final boolean r100) {
        final AtomicInteger r101 = new AtomicInteger(0);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new j(this, r100, r101));
        int r102 = r101.get();
        if (r102 != 0) goto L5;
        this.mEnableFollowGravity = r100;
    L5:
        return r102;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposureCompensation(final float r100) {
        final AtomicInteger r101 = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new f(this, r101, r100));
        return r101.get();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraZoomRatio(final float r100) {
        final AtomicInteger r101 = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new h(this, r100, r101));
        return r101.get();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public void setOrientationMode(CameraVideoCapturer.ORIENTATION_MODE r100) {
        this.mOrientationMode = r100;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public void switchCamera(final CameraVideoCapturer.CameraSwitchHandler r100) {
        RXLogging.w(TAG, "switchCamera");
        Handler r101 = this.cameraThreadHandler;
        if (r101 == null) goto L6;
        r101.post(new AnonymousClass7(this, r100));
        return;
    }

    public static /* synthetic */ boolean access$1202(CameraCapturer r100, boolean r101) {
        r100.firstFrameObserved = r101;
        return r101;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraSwitchHandler access$1302(CameraCapturer r100, CameraVideoCapturer.CameraSwitchHandler r101) {
        r100.switchEventsHandler = r101;
        return r101;
    }

    public static /* synthetic */ void access$1600(CameraCapturer r100, CameraVideoCapturer.CameraSwitchHandler r101) {
        r100.switchCameraInternal(r101);
    }

    public static /* synthetic */ void access$1800(CameraCapturer r100, int r101) {
        r100.createSessionInternal(r101);
    }

    public static /* synthetic */ SwitchState access$402(CameraCapturer r100, SwitchState r101) {
        r100.switchState = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(CameraCapturer r100, boolean r101) {
        r100.sessionOpening = r101;
        return r101;
    }

    public static /* synthetic */ CameraSession access$802(CameraCapturer r100, CameraSession r101) {
        r100.currentSession = r101;
        return r101;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraStatistics access$902(CameraCapturer r100, CameraVideoCapturer.CameraStatistics r101) {
        r100.cameraStatistics = r101;
        return r101;
    }

    private /* synthetic */ void lambda$enableCameraAutoExposureFaceMode$10(AtomicInteger r100, boolean r101) {
        CameraSession r102 = this.currentSession;
        if (r102 == null) goto L6;
        r100.set(r102.enableCameraAutoExposureFaceMode(r101));
        return;
    }

    private /* synthetic */ void lambda$enableFollowGravity$12(boolean r100, AtomicInteger r101) {
        CameraSession r102 = this.currentSession;
        if (r102 == null) goto L6;
        r101.set(r102.enableFollowGravity(r100));
        return;
    }

    private /* synthetic */ void lambda$setCameraExposureCompensation$9(AtomicInteger r100, float r101) {
        CameraSession r102 = this.currentSession;
        if (r102 == null) goto L6;
        r100.set(r102.setCameraExposureCompensation(r101));
        return;
    }

    private /* synthetic */ void lambda$setCameraZoomRatio$4(float r100, AtomicInteger r101) {
        CameraSession r102 = this.currentSession;
        if (r102 == null) goto L6;
        r102.setCameraZoomRatio(r100);
        r101.set(0);
        return;
    }

    private void reportCameraSwitchError(String r100, CameraVideoCapturer.CameraSwitchHandler r101) {
        RXLogging.e(TAG, r100);
        if (r101 == null) goto L6;
        r101.onCameraSwitchError(r100);
        return;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposurePoint(final float r100, final float r101) {
        final AtomicInteger r102 = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new l(this, r100, r101, r102));
        return r102.get();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraFocusPoint(final float r100, final float r101) {
        final AtomicInteger r102 = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new o(this, r100, r101, r102));
        return r102.get();
    }

    public CameraCapturer(String r100, CameraVideoCapturer.CameraEventsHandler r101, CameraEnumerator r102) {
        this.mOrientationMode = CameraVideoCapturer.ORIENTATION_MODE.ORIENTATION_MODE_ADAPTIVE;
        this.createSessionCallback = new AnonymousClass1(this);
        this.cameraSessionEventsHandler = new AnonymousClass2(this);
        this.openCameraTimeoutRunnable = new AnonymousClass3(this);
        this.stateLock = new Object();
        this.switchState = SwitchState.IDLE;
        this.nativeLibraryName = "bytertc";
        this.mEnableFollowGravity = false;
        if (r101 != null) goto L5;
        r101 = new AnonymousClass4(this);
    L5:
        this.eventsHandler = r101;
        this.cameraEnumerator = r102;
        this.cameraName = r100;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        String[] r103 = r102.getDeviceNames();
        if (r103.length == 0) goto L13;
        if (Arrays.asList(r103).contains(this.cameraName) == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Camera name " + this.cameraName + " does not match any known camera device.");
    L13:
        throw new RuntimeException("No cameras attached.");
    }

    private /* synthetic */ void lambda$setCameraExposurePoint$6(float r100, float r101, AtomicInteger r102) {
        CameraSession r103 = this.currentSession;
        if (r103 == null) goto L6;
        r103.setCameraExposurePoint(r100, r101);
        r102.set(0);
        return;
    }

    private /* synthetic */ void lambda$setCameraFocusPoint$5(float r100, float r101, AtomicInteger r102) {
        CameraSession r103 = this.currentSession;
        if (r103 == null) goto L6;
        r103.setCameraFocusPoint(r100, r101);
        r102.set(0);
        return;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void changeCaptureFormat(int r100, int r101, int r102) {
        RXLogging.w(TAG, "changeCaptureFormat: " + r100 + "x" + r101 + "@" + r102);
        Object r103 = this.stateLock;
        monitor-enter(r103);
        stopCapture();     // Catch: Throwable -> L7
        startCapture(r100, r101, r102);     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void initialize(SurfaceTextureHelper r100, Context r101, CapturerObserver r102) {
        this.applicationContext = r101;
        Object r103 = this.stateLock;
        monitor-enter(r103);
        this.capturerObserver = r102;     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        this.surfaceHelper = r100;
        if (r100 != null) goto L9;
        Handler r104 = null;
    L10:
        this.cameraThreadHandler = r104;
        return;
    L9:
        r104 = r100.getHandler();
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void startCapture(int r100, int r101, int r102) {
        RXLogging.w(TAG, "startCapture: " + r100 + "x" + r101 + "@" + r102);
        if (this.applicationContext == null) goto L21;
        Object r103 = this.stateLock;
        monitor-enter(r103);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.sessionOpening == false) goto L9;
    L14:
        RXLogging.w(TAG, "Session already open");     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L9:
        if (this.currentSession != null) goto L14;
        this.width = r100;     // Catch: Throwable -> L17
        this.height = r101;     // Catch: Throwable -> L17
        this.framerate = r102;     // Catch: Throwable -> L17
        this.sessionOpening = true;     // Catch: Throwable -> L17
        this.openAttemptsRemaining = 3;     // Catch: Throwable -> L17
        createSessionInternal(0);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L21:
        throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void startCapture(int r100, int r101, int r102, int r103) {
        startCapture(r100, r101, r102);
    }
}
