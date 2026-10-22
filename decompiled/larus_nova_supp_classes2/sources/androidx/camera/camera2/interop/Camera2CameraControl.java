package androidx.camera.camera2.interop;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2CameraControl {
    private Camera2ImplConfig.Builder mBuilder;
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    CallbackToFutureAdapter.Completer<Void> mCompleter;
    final Executor mExecutor;
    private boolean mIsActive;
    final Object mLock;
    private boolean mPendingUpdate;

    public static /* synthetic */ Object a(Camera2CameraControl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$addCaptureRequestOptions$3(r1);
    }

    public static /* synthetic */ void b(Camera2CameraControl r0) {
        r0.completeInFlightUpdate();
    }

    public static /* synthetic */ void c(Camera2CameraControl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$clearCaptureRequestOptions$4(r1);
    }

    public static /* synthetic */ void d(Camera2CameraControl r0, boolean r1) {
        r0.lambda$setActive$6(r1);
    }

    public static /* synthetic */ void e(Camera2CameraControl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$setCaptureRequestOptions$0(r1);
    }

    public static /* synthetic */ Object f(Camera2CameraControl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$setCaptureRequestOptions$1(r1);
    }

    public static /* synthetic */ Object g(Camera2CameraControl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$clearCaptureRequestOptions$5(r1);
    }

    public static /* synthetic */ void h(Camera2CameraControl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$addCaptureRequestOptions$2(r1);
    }

    private void clearCaptureRequestOptionsInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBuilder = new Camera2ImplConfig.Builder();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void completeInFlightUpdate() {
        CallbackToFutureAdapter.Completer<Void> r0 = this.mCompleter;
        if (r0 == null) goto L6;
        r0.set(null);
        this.mCompleter = null;
        return;
    }

    private void updateSession() {
        this.mCamera2CameraControlImpl.updateSessionConfigAsync().addListener(new h(this), this.mExecutor);
        this.mPendingUpdate = false;
    }

    public Camera2ImplConfig getCamera2ImplConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Camera2ImplConfig r1 = this.mBuilder.build();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public CaptureRequestOptions getCaptureRequestOptions() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CaptureRequestOptions r1 = CaptureRequestOptions.Builder.from(this.mBuilder.build()).build();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ListenableFuture<Void> clearCaptureRequestOptions() {
        clearCaptureRequestOptionsInternal();
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new d(this)));
    }

    private void addCaptureRequestOptionsInternal(CaptureRequestOptions r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBuilder.insertAllOptions(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void failInFlightUpdate(Exception r3) {
        CallbackToFutureAdapter.Completer<Void> r0 = this.mCompleter;
        if (r0 == null) goto L9;
        if (r3 != null) goto L7;
        r3 = new Exception("Camera2CameraControl failed with unknown error.");
    L7:
        r0.setException(r3);
        this.mCompleter = null;
        return;
    }

    public static Camera2CameraControl from(CameraControl r2) {
        CameraControlInternal r3 = ((CameraControlInternal) r2).getImplementation();
        Preconditions.checkArgument(r3 instanceof Camera2CameraControlImpl, "CameraControl doesn't contain Camera2 implementation.");
        return ((Camera2CameraControlImpl) r3).getCamera2CameraControl();
    }

    private /* synthetic */ void lambda$addCaptureRequestOptions$2(CallbackToFutureAdapter.Completer r1) {
        updateConfig(r1);
    }

    private /* synthetic */ Object lambda$addCaptureRequestOptions$3(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new b(this, r3));
        return "addCaptureRequestOptions";
    }

    private /* synthetic */ void lambda$clearCaptureRequestOptions$4(CallbackToFutureAdapter.Completer r1) {
        updateConfig(r1);
    }

    private /* synthetic */ Object lambda$clearCaptureRequestOptions$5(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new a(this, r3));
        return "clearCaptureRequestOptions";
    }

    private /* synthetic */ void lambda$setActive$6(boolean r1) {
        setActiveInternal(r1);
    }

    private /* synthetic */ void lambda$setCaptureRequestOptions$0(CallbackToFutureAdapter.Completer r1) {
        updateConfig(r1);
    }

    private /* synthetic */ Object lambda$setCaptureRequestOptions$1(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new f(this, r3));
        return "setCaptureRequestOptions";
    }

    private void setActiveInternal(boolean r2) {
        if (this.mIsActive != r2) goto L5;
        return;
    L5:
        this.mIsActive = r2;
        if (r2 == true) goto L8;
        failInFlightUpdate(new CameraControl.OperationCanceledException("The camera control has became inactive."));
        return;
    L8:
        if (this.mPendingUpdate == false) goto L12;
        updateSession();
        return;
    }

    private void updateConfig(CallbackToFutureAdapter.Completer<Void> r3) {
        this.mPendingUpdate = true;
        failInFlightUpdate(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        this.mCompleter = r3;
        if (this.mIsActive == false) goto L6;
        updateSession();
        return;
    }

    public ListenableFuture<Void> addCaptureRequestOptions(CaptureRequestOptions r1) {
        addCaptureRequestOptionsInternal(r1);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new e(this)));
    }

    public void applyOptionsToBuilder(Camera2ImplConfig.Builder r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        r4.insertAllOptions(this.mBuilder.getMutableConfig(), Config.OptionPriority.ALWAYS_OVERRIDE);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setActive(final boolean r3) {
        this.mExecutor.execute(new c(this, r3));
    }

    public ListenableFuture<Void> setCaptureRequestOptions(CaptureRequestOptions r1) {
        clearCaptureRequestOptionsInternal();
        addCaptureRequestOptionsInternal(r1);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new g(this)));
    }

    public Camera2CameraControl(Camera2CameraControlImpl r2, Executor r3) {
        this.mIsActive = false;
        this.mPendingUpdate = false;
        this.mLock = new Object();
        this.mBuilder = new Camera2ImplConfig.Builder();
        this.mCamera2CameraControlImpl = r2;
        this.mExecutor = r3;
    }
}
