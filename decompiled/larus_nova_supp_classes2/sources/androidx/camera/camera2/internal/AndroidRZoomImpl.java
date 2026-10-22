package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.params.CaptureRequestParameterCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AndroidRZoomImpl implements ZoomControl.ZoomImpl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private float mCurrentZoomRatio;
    private float mPendingZoomRatio;
    private CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;
    private boolean mShouldOverrideZoom;
    private final Range<Float> mZoomRatioRange;

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public Rect getCropSensorRegion() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        return ((Float) this.mZoomRatioRange.getUpper()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return ((Float) this.mZoomRatioRange.getLower()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
        this.mCurrentZoomRatio = 1.0f;
        CallbackToFutureAdapter.Completer<Void> r0 = this.mPendingZoomRatioCompleter;
        if (r0 == null) goto L6;
        r0.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        this.mPendingZoomRatioCompleter = null;
        return;
    }

    public AndroidRZoomImpl(CameraCharacteristicsCompat r2) {
        this.mCurrentZoomRatio = 1.0f;
        this.mPendingZoomRatio = 1.0f;
        this.mShouldOverrideZoom = false;
        this.mCameraCharacteristics = r2;
        this.mZoomRatioRange = (Range) r2.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        this.mShouldOverrideZoom = r2.isZoomOverrideAvailable();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void addRequestOption(Camera2ImplConfig.Builder r4) {
        CaptureRequest.Key r0 = CaptureRequest.CONTROL_ZOOM_RATIO;
        Float r1 = Float.valueOf(this.mCurrentZoomRatio);
        Config.OptionPriority r2 = Config.OptionPriority.REQUIRED;
        r4.setCaptureRequestOptionWithPriority(r0, r1, r2);
        if (this.mShouldOverrideZoom == false) goto L6;
        CaptureRequestParameterCompat.setSettingsOverrideZoom(r4, r2);
        return;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(TotalCaptureResult r3) {
        if (this.mPendingZoomRatioCompleter == null) goto L14;
        CaptureRequest r4 = r3.getRequest();
        if (r4 != null) goto L7;
        Float r5 = null;
    L8:
        if (r5 != null) goto L11;
        return;
    L11:
        if (this.mPendingZoomRatio != r5.floatValue()) goto L15;
        this.mPendingZoomRatioCompleter.set(null);
        this.mPendingZoomRatioCompleter = null;
        return;
    L15:
        return;
    L7:
        r5 = (Float) r4.get(CaptureRequest.CONTROL_ZOOM_RATIO);
        goto L8
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void setZoomRatio(float r3, CallbackToFutureAdapter.Completer<Void> r4) {
        this.mCurrentZoomRatio = r3;
        CallbackToFutureAdapter.Completer<Void> r5 = this.mPendingZoomRatioCompleter;
        if (r5 == null) goto L5;
        r5.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
    L5:
        this.mPendingZoomRatio = this.mCurrentZoomRatio;
        this.mPendingZoomRatioCompleter = r4;
    }
}
