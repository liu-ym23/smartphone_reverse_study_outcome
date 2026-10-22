package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ZoomControl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private static final String TAG = "ZoomControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener;
    private final ZoomStateImpl mCurrentZoomState;
    private final Executor mExecutor;
    private boolean mIsActive;
    final ZoomImpl mZoomImpl;
    private final MutableLiveData<ZoomState> mZoomStateLiveData;

    public interface ZoomImpl {
        void addRequestOption(Camera2ImplConfig.Builder r1);

        Rect getCropSensorRegion();

        float getMaxZoom();

        float getMinZoom();

        void onCaptureResult(TotalCaptureResult r1);

        void resetZoom();

        void setZoomRatio(float r1, CallbackToFutureAdapter.Completer<Void> r2);
    }

    public static /* synthetic */ void a(ZoomControl r0, CallbackToFutureAdapter.Completer r1, ZoomState r2) {
        r0.lambda$setZoomRatio$0(r1, r2);
    }

    public static /* synthetic */ Object b(ZoomControl r0, ZoomState r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$setZoomRatio$1(r1, r2);
    }

    public static /* synthetic */ Object c(ZoomControl r0, ZoomState r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$setLinearZoom$3(r1, r2);
    }

    public static /* synthetic */ void d(ZoomControl r0, CallbackToFutureAdapter.Completer r1, ZoomState r2) {
        r0.lambda$setLinearZoom$2(r1, r2);
    }

    public Rect getCropSensorRegion() {
        return this.mZoomImpl.getCropSensorRegion();
    }

    public LiveData<ZoomState> getZoomState() {
        return this.mZoomStateLiveData;
    }

    private static ZoomImpl createZoomImpl(CameraCharacteristicsCompat r1) {
        if (isAndroidRZoomSupported(r1) == false) goto L7;
        return new AndroidRZoomImpl(r1);
    L7:
        return new CropRegionZoomImpl(r1);
    }

    public static ZoomState getDefaultZoomState(CameraCharacteristicsCompat r2) {
        ZoomImpl r3 = createZoomImpl(r2);
        ZoomStateImpl r0 = new ZoomStateImpl(r3.getMaxZoom(), r3.getMinZoom());
        r0.setZoomRatio(1.0f);
        return ImmutableZoomState.create(r0);
    }

    private static Range<Float> getZoomRatioRange(CameraCharacteristicsCompat r2) {
        return (Range) r2.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
    L4:
        e = move-exception;
        Logger.w(TAG, "AssertionError, fail to get camera characteristic.", e);
        return null;
    }

    public static boolean isAndroidRZoomSupported(CameraCharacteristicsCompat r2) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        return false;
    L5:
        if (getZoomRatioRange(r2) == null) goto L7;
        return true;
    }

    private void updateLiveData(ZoomState r3) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        this.mZoomStateLiveData.setValue(r3);
        return;
    L5:
        this.mZoomStateLiveData.postValue(r3);
    }

    public void addZoomOption(Camera2ImplConfig.Builder r2) {
        this.mZoomImpl.addRequestOption(r2);
    }

    public void setActive(boolean r3) {
        if (this.mIsActive != r3) goto L5;
        return;
    L5:
        this.mIsActive = r3;
        if (r3 == true) goto L15;
        ZoomStateImpl r4 = this.mCurrentZoomState;
        monitor-enter(r4);
        this.mCurrentZoomState.setZoomRatio(1.0f);     // Catch: Throwable -> L12
        ZoomState r0 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        updateLiveData(r0);
        this.mZoomImpl.resetZoom();
        this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public ListenableFuture<Void> setLinearZoom(float r3) {
        ZoomStateImpl r0 = this.mCurrentZoomState;
        monitor-enter(r0);
        this.mCurrentZoomState.setLinearZoom(r3);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        final ZoomState r4 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateLiveData(r4);
        return CallbackToFutureAdapter.getFuture(new t3(this, r4));
    L10:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    L8:
        th = move-exception;
        throw th;
    }

    public ListenableFuture<Void> setZoomRatio(float r3) {
        ZoomStateImpl r0 = this.mCurrentZoomState;
        monitor-enter(r0);
        this.mCurrentZoomState.setZoomRatio(r3);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        final ZoomState r4 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateLiveData(r4);
        return CallbackToFutureAdapter.getFuture(new q3(this, r4));
    L10:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setLinearZoom$2(CallbackToFutureAdapter.Completer r1, ZoomState r2) {
        submitCameraZoomRatio(r1, r2);
    }

    private /* synthetic */ Object lambda$setLinearZoom$3(final ZoomState r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mExecutor.execute(new r3(this, r4, r3));
        return "setLinearZoom";
    }

    private /* synthetic */ void lambda$setZoomRatio$0(CallbackToFutureAdapter.Completer r1, ZoomState r2) {
        submitCameraZoomRatio(r1, r2);
    }

    private /* synthetic */ Object lambda$setZoomRatio$1(final ZoomState r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mExecutor.execute(new s3(this, r4, r3));
        return "setZoomRatio";
    }

    private void submitCameraZoomRatio(CallbackToFutureAdapter.Completer<Void> r3, ZoomState r4) {
        if (this.mIsActive == true) goto L13;
        ZoomStateImpl r0 = this.mCurrentZoomState;
        monitor-enter(r0);
        this.mCurrentZoomState.setZoomRatio(1.0f);     // Catch: Throwable -> L10
        ZoomState r5 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        updateLiveData(r5);
        r3.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        this.mZoomImpl.setZoomRatio(r4.getZoomRatio(), r3);
        this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
    }

    public ZoomControl(Camera2CameraControlImpl r2, CameraCharacteristicsCompat r3, Executor r4) {
        this.mIsActive = false;
        this.mCaptureResultListener = new AnonymousClass1(this);
        this.mCamera2CameraControlImpl = r2;
        this.mExecutor = r4;
        ZoomImpl r5 = createZoomImpl(r3);
        this.mZoomImpl = r5;
        ZoomStateImpl r6 = new ZoomStateImpl(r5.getMaxZoom(), r5.getMinZoom());
        this.mCurrentZoomState = r6;
        r6.setZoomRatio(1.0f);
        this.mZoomStateLiveData = new MutableLiveData(ImmutableZoomState.create(r6));
        r2.addCaptureResultListener(this.mCaptureResultListener);
    }
}
