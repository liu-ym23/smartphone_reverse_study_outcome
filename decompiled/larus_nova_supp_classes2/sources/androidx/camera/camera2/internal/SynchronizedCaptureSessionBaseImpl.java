package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class SynchronizedCaptureSessionBaseImpl extends SynchronizedCaptureSession.StateCallback implements SynchronizedCaptureSession, SynchronizedCaptureSession.Opener {
    private static final String TAG = "SyncCaptureSessionBase";
    CameraCaptureSessionCompat mCameraCaptureSessionCompat;
    final CaptureSessionRepository mCaptureSessionRepository;
    SynchronizedCaptureSession.StateCallback mCaptureSessionStateCallback;
    private boolean mClosed;
    final Handler mCompatHandler;
    final Executor mExecutor;
    private List<DeferrableSurface> mHeldDeferrableSurfaces;
    final Object mLock;
    CallbackToFutureAdapter.Completer<Void> mOpenCaptureSessionCompleter;
    ListenableFuture<Void> mOpenCaptureSessionFuture;
    private boolean mOpenerDisabled;
    private final ScheduledExecutorService mScheduledExecutorService;
    private boolean mSessionFinished;
    private ListenableFuture<List<Surface>> mStartingSurface;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Surface getInputSurface(CameraCaptureSession r0) {
            return r0.getInputSurface();
        }
    }

    public static /* synthetic */ void a(SynchronizedCaptureSessionBaseImpl r0, SynchronizedCaptureSession r1) {
        r0.lambda$onSessionFinished$4(r1);
    }

    public static /* synthetic */ Object b(SynchronizedCaptureSessionBaseImpl r0, List r1, CameraDeviceCompat r2, SessionConfigurationCompat r3, CallbackToFutureAdapter.Completer r4) {
        return r0.lambda$openCaptureSession$0(r1, r2, r3, r4);
    }

    public static /* synthetic */ void c(SynchronizedCaptureSessionBaseImpl r0, SynchronizedCaptureSession r1) {
        r0.lambda$onClosed$3(r1);
    }

    public static /* synthetic */ ListenableFuture d(SynchronizedCaptureSessionBaseImpl r0, List r1, List r2) {
        return r0.lambda$startWithDeferrableSurface$1(r1, r2);
    }

    public static /* synthetic */ void e(SynchronizedCaptureSessionBaseImpl r0) {
        r0.lambda$close$2();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public ListenableFuture<Void> getOpeningBlocker() {
        return Futures.immediateFuture(null);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public SynchronizedCaptureSession.StateCallback getStateCallback() {
        return this;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void onCameraDeviceError(int r1) {
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public boolean stop() {
        Future r1 = null;
        Object r2 = this.mLock;     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L6:
        if (this.mOpenerDisabled == true) goto L12;
        Future r3 = this.mStartingSurface;     // Catch: Throwable -> L19
        if (r3 == null) goto L10;
        r1 = r3;
    L10:
        this.mOpenerDisabled = true;     // Catch: Throwable -> L19
    L12:
        if (isCameraCaptureSessionOpen() == true) goto L14;
        boolean r4 = true;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L19
        if (r1 == null) goto L18;
        r1.cancel(true);
    L18:
        return r4;
    L14:
        r4 = false;
    L22:
        th = move-exception;
        if (r1 == null) goto L25;
        r1.cancel(true);
    L25:
        throw th;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void abortCaptures() throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().abortCaptures();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCaptureSessionRepository.onCaptureSessionClosing(this);
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().close();
        getExecutor().execute(new g3(this));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public CameraDevice getDevice() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        return this.mCameraCaptureSessionCompat.toCameraCaptureSession().getDevice();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public Surface getInputSurface() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.getInputSurface(this.mCameraCaptureSessionCompat.toCameraCaptureSession());
    }

    public boolean isCameraCaptureSessionOpen() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mOpenCaptureSessionFuture == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void releaseDeferrableSurfaces() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<DeferrableSurface> r1 = this.mHeldDeferrableSurfaces;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        DeferrableSurfaces.decrementAll(r1);     // Catch: Throwable -> L9
        this.mHeldDeferrableSurfaces = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void stopRepeating() throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().stopRepeating();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public CameraCaptureSessionCompat toCameraCaptureSessionCompat() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        return this.mCameraCaptureSessionCompat;
    }

    private /* synthetic */ void lambda$close$2() {
        onSessionFinished(this);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void finishClose() {
        releaseDeferrableSurfaces();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public Executor getExecutor() {
        return this.mExecutor;
    }

    private /* synthetic */ void lambda$onClosed$3(SynchronizedCaptureSession r2) {
        this.mCaptureSessionRepository.onCaptureSessionClosed(this);
        onSessionFinished(r2);
        if (this.mCameraCaptureSessionCompat == null) goto L5;
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onClosed(r2);
        return;
    L5:
        Logger.w(TAG, "[" + this + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
    }

    private /* synthetic */ void lambda$onSessionFinished$4(SynchronizedCaptureSession r2) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onSessionFinished(r2);
    }

    public void createCaptureSessionCompat(CameraCaptureSession r2) {
        if (this.mCameraCaptureSessionCompat != null) goto L6;
        this.mCameraCaptureSessionCompat = CameraCaptureSessionCompat.toCameraCaptureSessionCompat(r2, this.mCompatHandler);
        return;
    }

    public void holdDeferrableSurfaces(List<DeferrableSurface> r2) throws DeferrableSurface.SurfaceClosedException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        releaseDeferrableSurfaces();     // Catch: Throwable -> L7
        DeferrableSurfaces.incrementAll(r2);     // Catch: Throwable -> L7
        this.mHeldDeferrableSurfaces = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onActive(SynchronizedCaptureSession r2) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onActive(r2);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onCaptureQueueEmpty(SynchronizedCaptureSession r2) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onCaptureQueueEmpty(r2);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(final SynchronizedCaptureSession r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == true) goto L7;
        this.mClosed = true;     // Catch: Throwable -> L13
        Preconditions.checkNotNull(this.mOpenCaptureSessionFuture, "Need to call openCaptureSession before using this API.");     // Catch: Throwable -> L13
        ListenableFuture<Void> r1 = this.mOpenCaptureSessionFuture;     // Catch: Throwable -> L13
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L13
        finishClose();
        if (r1 == null) goto L18;
        r1.addListener(new f3(this, r4), CameraXExecutors.directExecutor());
        return;
    L18:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigureFailed(SynchronizedCaptureSession r2) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        finishClose();
        this.mCaptureSessionRepository.onCaptureSessionConfigureFail(this);
        this.mCaptureSessionStateCallback.onConfigureFailed(r2);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(SynchronizedCaptureSession r2) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionRepository.onCaptureSessionCreated(this);
        this.mCaptureSessionStateCallback.onConfigured(r2);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onReady(SynchronizedCaptureSession r2) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onReady(r2);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSessionFinished(final SynchronizedCaptureSession r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionFinished == true) goto L7;
        this.mSessionFinished = true;     // Catch: Throwable -> L12
        Preconditions.checkNotNull(this.mOpenCaptureSessionFuture, "Need to call openCaptureSession before using this API.");     // Catch: Throwable -> L12
        ListenableFuture<Void> r1 = this.mOpenCaptureSessionFuture;     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r1 == null) goto L17;
        r1.addListener(new c3(this, r4), CameraXExecutors.directExecutor());
        return;
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private /* synthetic */ ListenableFuture lambda$startWithDeferrableSurface$1(List r3, List r4) throws Exception {
        Logger.d(TAG, "[" + this + "] getSurface done with results: " + r4);
        if (r4.isEmpty() == false) goto L7;
        return Futures.immediateFailedFuture(new IllegalArgumentException("Unable to open capture session without surfaces"));
    L7:
        if (r4.contains(null) == false) goto L11;
        return Futures.immediateFailedFuture(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) ListProtector.get(r3, r4.indexOf(null))));
    L11:
        return Futures.immediateFuture(r4);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureBurstRequests(List<CaptureRequest> r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureBurstRequests(r3, getExecutor(), r4);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureSingleRequest(CaptureRequest r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureSingleRequest(r3, getExecutor(), r4);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSurfacePrepared(SynchronizedCaptureSession r2, Surface r3) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onSurfacePrepared(r2, r3);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setRepeatingBurstRequests(List<CaptureRequest> r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setRepeatingBurstRequests(r3, getExecutor(), r4);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(CaptureRequest r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setSingleRepeatingRequest(r3, getExecutor(), r4);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public ListenableFuture<List<Surface>> startWithDeferrableSurface(final List<DeferrableSurface> r8, long r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mOpenerDisabled == false) goto L9;
        ListenableFuture<List<Surface>> r10 = Futures.immediateFailedFuture(new CancellationException("Opener is disabled"));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r10;
    L9:
        this.mStartingSurface = FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(r8, false, r9, getExecutor(), this.mScheduledExecutorService)).transformAsync(new d3(this, r8), getExecutor());     // Catch: Throwable -> L12
        ListenableFuture<List<Surface>> r11 = Futures.nonCancellationPropagating(this.mStartingSurface);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r11;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureBurstRequests(List<CaptureRequest> r3, Executor r4, CameraCaptureSession.CaptureCallback r5) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureBurstRequests(r3, r4, r5);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureSingleRequest(CaptureRequest r3, Executor r4, CameraCaptureSession.CaptureCallback r5) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureSingleRequest(r3, r4, r5);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public SessionConfigurationCompat createSessionConfigurationCompat(int r3, List<OutputConfigurationCompat> r4, SynchronizedCaptureSession.StateCallback r5) {
        this.mCaptureSessionStateCallback = r5;
        return new SessionConfigurationCompat(r3, r4, getExecutor(), new AnonymousClass2(this));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public ListenableFuture<Void> openCaptureSession(CameraDevice r3, final SessionConfigurationCompat r4, final List<DeferrableSurface> r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mOpenerDisabled == false) goto L9;
        ListenableFuture<Void> r6 = Futures.immediateFailedFuture(new CancellationException("Opener is disabled"));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        this.mCaptureSessionRepository.onCreateCaptureSession(this);     // Catch: Throwable -> L12
        final CameraDeviceCompat r7 = CameraDeviceCompat.toCameraDeviceCompat(r3, this.mCompatHandler);     // Catch: Throwable -> L12
        ListenableFuture<Void> r8 = CallbackToFutureAdapter.getFuture(new e3(this, r5, r7, r4));     // Catch: Throwable -> L12
        this.mOpenCaptureSessionFuture = r8;     // Catch: Throwable -> L12
        Futures.addCallback(r8, new AnonymousClass1(this), CameraXExecutors.directExecutor());     // Catch: Throwable -> L12
        ListenableFuture<Void> r9 = Futures.nonCancellationPropagating(this.mOpenCaptureSessionFuture);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r9;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setRepeatingBurstRequests(List<CaptureRequest> r3, Executor r4, CameraCaptureSession.CaptureCallback r5) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setRepeatingBurstRequests(r3, r4, r5);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(CaptureRequest r3, Executor r4, CameraCaptureSession.CaptureCallback r5) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setSingleRepeatingRequest(r3, r4, r5);
    }

    public SynchronizedCaptureSessionBaseImpl(CaptureSessionRepository r2, Executor r3, ScheduledExecutorService r4, Handler r5) {
        this.mLock = new Object();
        this.mHeldDeferrableSurfaces = null;
        this.mClosed = false;
        this.mOpenerDisabled = false;
        this.mSessionFinished = false;
        this.mCaptureSessionRepository = r2;
        this.mCompatHandler = r5;
        this.mExecutor = r3;
        this.mScheduledExecutorService = r4;
    }

    private /* synthetic */ Object lambda$openCaptureSession$0(List r4, CameraDeviceCompat r5, SessionConfigurationCompat r6, CallbackToFutureAdapter.Completer r7) throws Exception {
        Object r1 = this.mLock;
        monitor-enter(r1);
        holdDeferrableSurfaces(r4);     // Catch: Throwable -> L11
        if (this.mOpenCaptureSessionCompleter != null) goto L7;
        boolean r8 = true;
    L8:
        Preconditions.checkState(r8, "The openCaptureSessionCompleter can only set once!");     // Catch: Throwable -> L11
        this.mOpenCaptureSessionCompleter = r7;     // Catch: Throwable -> L11
        r5.createCaptureSession(r6);     // Catch: Throwable -> L11
        String r9 = "openCaptureSession[session=" + this + "]";     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r9;
    L7:
        r8 = false;
    L11:
        th = move-exception;
        throw th;
    }
}
