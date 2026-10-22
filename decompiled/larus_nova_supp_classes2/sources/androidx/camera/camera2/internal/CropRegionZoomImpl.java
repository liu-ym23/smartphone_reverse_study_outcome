package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class CropRegionZoomImpl implements ZoomControl.ZoomImpl {
    public static final float MIN_DIGITAL_ZOOM = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private Rect mCurrentCropRect;
    private Rect mPendingZoomCropRegion;
    private CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return 1.0f;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
        this.mPendingZoomCropRegion = null;
        this.mCurrentCropRect = null;
        CallbackToFutureAdapter.Completer<Void> r1 = this.mPendingZoomRatioCompleter;
        if (r1 == null) goto L6;
        r1.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        this.mPendingZoomRatioCompleter = null;
        return;
    }

    private Rect getSensorRect() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public Rect getCropSensorRegion() {
        Rect r0 = this.mCurrentCropRect;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getSensorRect();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        Float r0 = (Float) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        if (r0.floatValue() >= getMinZoom()) goto L11;
        return getMinZoom();
    L11:
        return r0.floatValue();
    }

    public CropRegionZoomImpl(CameraCharacteristicsCompat r2) {
        this.mCurrentCropRect = null;
        this.mPendingZoomCropRegion = null;
        this.mCameraCharacteristics = r2;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void addRequestOption(Camera2ImplConfig.Builder r4) {
        Rect r0 = this.mCurrentCropRect;
        if (r0 == null) goto L6;
        r4.setCaptureRequestOptionWithPriority(CaptureRequest.SCALER_CROP_REGION, r0, Config.OptionPriority.REQUIRED);
        return;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(TotalCaptureResult r3) {
        if (this.mPendingZoomRatioCompleter == null) goto L14;
        CaptureRequest r4 = r3.getRequest();
        if (r4 != null) goto L7;
        Rect r5 = null;
    L8:
        Rect r1 = this.mPendingZoomCropRegion;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.equals(r5) == false) goto L16;
        this.mPendingZoomRatioCompleter.set(null);
        this.mPendingZoomRatioCompleter = null;
        this.mPendingZoomCropRegion = null;
        return;
    L16:
        return;
    L7:
        r5 = (Rect) r4.get(CaptureRequest.SCALER_CROP_REGION);
        goto L8
    }

    private static Rect getCropRectByRatio(Rect r5, float r6) {
        float r0 = r5.width() / r6;
        float r1 = r5.height() / r6;
        float r7 = (r5.width() - r0) / 2.0f;
        float r8 = (r5.height() - r1) / 2.0f;
        return new Rect((int) r7, (int) r8, (int) (r7 + r0), (int) (r8 + r1));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void setZoomRatio(float r3, CallbackToFutureAdapter.Completer<Void> r4) {
        this.mCurrentCropRect = getCropRectByRatio(getSensorRect(), r3);
        CallbackToFutureAdapter.Completer<Void> r5 = this.mPendingZoomRatioCompleter;
        if (r5 == null) goto L5;
        r5.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
    L5:
        this.mPendingZoomCropRegion = this.mCurrentCropRect;
        this.mPendingZoomRatioCompleter = r4;
    }
}
