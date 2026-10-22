package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class PreviewTransformation {
    private static final PreviewView.ScaleType DEFAULT_SCALE_TYPE = null;
    private static final String TAG = "PreviewTransform";
    private boolean mHasCameraTransform;
    private boolean mIsFrontCamera;
    private int mPreviewRotationDegrees;
    private Size mResolution;
    private PreviewView.ScaleType mScaleType;
    private Matrix mSensorToBufferTransform;
    private Rect mSurfaceCropRect;
    private int mTargetRotation;

    /* JADX INFO: renamed from: androidx.camera.view.PreviewTransformation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType = null;

        static {
            int[] r0 = new int[PreviewView.ScaleType.values().length];
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType = r0;
            r0[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        DEFAULT_SCALE_TYPE = PreviewView.ScaleType.FILL_CENTER;
    }

    private int getRemainingRotationDegrees() {
        if (this.mHasCameraTransform == true) goto L7;
        return this.mPreviewRotationDegrees;
    L7:
        return -CameraOrientationUtil.surfaceRotationToDegrees(this.mTargetRotation);
    }

    private Size getRotatedViewportSize() {
        if (TransformUtils.is90or270(this.mPreviewRotationDegrees) == false) goto L7;
        return new Size(this.mSurfaceCropRect.height(), this.mSurfaceCropRect.width());
    L7:
        return new Size(this.mSurfaceCropRect.width(), this.mSurfaceCropRect.height());
    }

    private boolean isTransformationInfoReady() {
        if (this.mHasCameraTransform == true) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (this.mSurfaceCropRect != null) goto L12;
        return false;
    L12:
        if (this.mResolution == null) goto L17;
        if (r0 == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L5:
        if (this.mTargetRotation != (-1)) goto L8;
        r0 = false;
        goto L10
    }

    public PreviewTransformation() {
        this.mScaleType = DEFAULT_SCALE_TYPE;
    }

    public Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState(isTransformationInfoReady());
        RectF r0 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, this.mResolution.getWidth(), this.mResolution.getHeight());
        return TransformUtils.getRectToRect(r0, r0, getRemainingRotationDegrees());
    }

    public PreviewView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Rect getSurfaceCropRect() {
        return this.mSurfaceCropRect;
    }

    public boolean isViewportAspectRatioMatchPreviewView(Size r4) {
        return TransformUtils.isAspectRatioMatchingWithRoundingError(r4, true, getRotatedViewportSize(), false);
    }

    public void setScaleType(PreviewView.ScaleType r1) {
        this.mScaleType = r1;
    }

    private static RectF flipHorizontally(RectF r4, float r5) {
        float r6 = r5 + r5;
        return new RectF(r6 - r4.right, r4.top, r6 - r4.left, r4.bottom);
    }

    private RectF getTransformedSurfaceRect(Size r4, int r5) {
        Preconditions.checkState(isTransformationInfoReady());
        Matrix r6 = getSurfaceToPreviewViewMatrix(r4, r5);
        RectF r7 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, this.mResolution.getWidth(), this.mResolution.getHeight());
        r6.mapRect(r7);
        return r7;
    }

    public RectF getPreviewViewViewportRectForMismatchedAspectRatios(Size r6, int r7) {
        RectF r0 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r6.getWidth(), r6.getHeight());
        Size r1 = getRotatedViewportSize();
        RectF r2 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1.getWidth(), r1.getHeight());
        Matrix r3 = new Matrix();
        setMatrixRectToRect(r3, r2, r0, this.mScaleType);
        r3.mapRect(r2);
        if (r7 == 1) goto L5;
        return r2;
    L5:
        return flipHorizontally(r2, r6.getWidth() / 2.0f);
    }

    public Matrix getSensorToViewTransform(Size r3, int r4) {
        if (isTransformationInfoReady() == true) goto L6;
        return null;
    L6:
        Matrix r0 = new Matrix(this.mSensorToBufferTransform);
        r0.postConcat(getSurfaceToPreviewViewMatrix(r3, r4));
        return r0;
    }

    public Matrix getSurfaceToPreviewViewMatrix(Size r4, int r5) {
        Preconditions.checkState(isTransformationInfoReady());
        if (isViewportAspectRatioMatchPreviewView(r4) == false) goto L5;
        RectF r6 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r4.getWidth(), r4.getHeight());
    L6:
        Matrix r7 = TransformUtils.getRectToRect(new RectF(this.mSurfaceCropRect), r6, this.mPreviewRotationDegrees);
        if (this.mIsFrontCamera == true) goto L9;
    L14:
        return r7;
    L9:
        if (this.mHasCameraTransform == false) goto L14;
        if (TransformUtils.is90or270(this.mPreviewRotationDegrees) == false) goto L13;
        r7.preScale(1.0f, -1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
        goto L14
    L13:
        r7.preScale(-1.0f, 1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
        goto L14
    L5:
        r6 = getPreviewViewViewportRectForMismatchedAspectRatios(r4, r5);
        goto L6
    }

    public void overrideWithDisplayRotation(int r2, int r3) {
        if (this.mHasCameraTransform == true) goto L5;
        return;
    L5:
        this.mPreviewRotationDegrees = r2;
        this.mTargetRotation = r3;
    }

    public Bitmap createTransformedBitmap(Bitmap r6, Size r7, int r8) {
        if (isTransformationInfoReady() == true) goto L5;
        return r6;
    L5:
        Matrix r0 = getTextureViewCorrectionMatrix();
        RectF r9 = getTransformedSurfaceRect(r7, r8);
        Bitmap r10 = Bitmap.createBitmap(r7.getWidth(), r7.getHeight(), r6.getConfig());
        Canvas r1 = new Canvas(r10);
        Matrix r2 = new Matrix();
        r2.postConcat(r0);
        r2.postScale(r9.width() / this.mResolution.getWidth(), r9.height() / this.mResolution.getHeight());
        r2.postTranslate(r9.left, r9.top);
        r1.drawBitmap(r6, r2, new Paint(7));
        return r10;
    }

    public Matrix getPreviewViewToNormalizedSensorMatrix(Size r4, int r5, Rect r6) {
        if (isTransformationInfoReady() == true) goto L6;
        return null;
    L6:
        Matrix r0 = new Matrix();
        getSensorToViewTransform(r4, r5).invert(r0);
        Matrix r7 = new Matrix();
        r7.setRectToRect(new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r6.width(), r6.height()), new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        r0.postConcat(r7);
        return r0;
    }

    public void setTransformationInfo(SurfaceRequest.TransformationInfo r3, Size r4, boolean r5) {
        Logger.d(TAG, "Transformation info set: " + r3 + " " + r4 + " " + r5);
        this.mSurfaceCropRect = r3.getCropRect();
        this.mPreviewRotationDegrees = r3.getRotationDegrees();
        this.mTargetRotation = r3.getTargetRotation();
        this.mResolution = r4;
        this.mIsFrontCamera = r5;
        this.mHasCameraTransform = r3.hasCameraTransform();
        this.mSensorToBufferTransform = r3.getSensorToBufferTransform();
    }

    public void transformView(Size r6, int r7, View r8) {
        if (r6.getHeight() != 0) goto L5;
    L31:
        Logger.w(TAG, "Transform not applied due to PreviewView size: " + r6);
        return;
    L5:
        if (r6.getWidth() == 0) goto L31;
        if (isTransformationInfoReady() == true) goto L11;
        return;
    L11:
        if ((r8 instanceof TextureView) == false) goto L13;
        ((TextureView) r8).setTransform(getTextureViewCorrectionMatrix());
    L29:
        RectF r9 = getTransformedSurfaceRect(r6, r7);
        r8.setPivotX(MenuKt.ClosedAlphaTarget);
        r8.setPivotY(MenuKt.ClosedAlphaTarget);
        r8.setScaleX(r9.width() / this.mResolution.getWidth());
        r8.setScaleY(r9.height() / this.mResolution.getHeight());
        r8.setTranslationX(r9.left - r8.getLeft());
        r8.setTranslationY(r9.top - r8.getTop());
        return;
    L13:
        Display r0 = r8.getDisplay();
        boolean r3 = true;
        if (this.mHasCameraTransform == false) goto L19;
        if (r0 == null) goto L19;
        if (r0.getRotation() == this.mTargetRotation) goto L19;
        boolean r1 = true;
    L21:
        if (this.mHasCameraTransform == false) goto L23;
    L25:
        r3 = false;
    L26:
        if (r1 == true) goto L28;
        if (r3 == false) goto L29;
    L28:
        Logger.e(TAG, "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
        goto L29
    L23:
        if (getRemainingRotationDegrees() == 0) goto L25;
    L19:
        r1 = false;
        goto L21
    }

    private static void setMatrixRectToRect(Matrix r2, RectF r3, RectF r4, PreviewView.ScaleType r5) {
        switch(AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[r5.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        Logger.e(TAG, "Unexpected crop rect: " + r5);
        Matrix.ScaleToFit r0 = Matrix.ScaleToFit.FILL;
    L9:
        if (r5 != PreviewView.ScaleType.FIT_CENTER) goto L11;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        r2.setRectToRect(r3, r4, r0);
        return;
    L19:
        r2.setRectToRect(r4, r3, r0);
        r2.invert(r2);
        return;
    L11:
        if (r5 == PreviewView.ScaleType.FIT_START) goto L16;
        if (r5 == PreviewView.ScaleType.FIT_END) goto L16;
        r6 = false;
        goto L17
    L5:
        r0 = Matrix.ScaleToFit.START;
        goto L9
    L6:
        r0 = Matrix.ScaleToFit.END;
        goto L9
    L7:
        r0 = Matrix.ScaleToFit.CENTER;
        goto L9
    }
}
