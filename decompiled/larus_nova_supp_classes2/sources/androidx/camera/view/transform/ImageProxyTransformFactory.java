package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.compose.material3.MenuKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageProxyTransformFactory {
    private boolean mUsingCropRect;
    private boolean mUsingRotationDegrees;

    public ImageProxyTransformFactory() {
    }

    public boolean isUsingCropRect() {
        return this.mUsingCropRect;
    }

    public boolean isUsingRotationDegrees() {
        return this.mUsingRotationDegrees;
    }

    private RectF getCropRect(ImageProxy r4) {
        if (this.mUsingCropRect == false) goto L7;
        return new RectF(r4.getCropRect());
    L7:
        return new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r4.getWidth(), r4.getHeight());
    }

    private int getRotationDegrees(ImageProxy r2) {
        if (this.mUsingRotationDegrees == true) goto L5;
        return 0;
    L5:
        return r2.getImageInfo().getRotationDegrees();
    }

    public OutputTransform getOutputTransform(ImageProxy r4) {
        int r0 = getRotationDegrees(r4);
        RectF r1 = getCropRect(r4);
        Matrix r2 = TransformUtils.getRectToRect(r1, getRotatedCropRect(r1, r0), r0);
        r2.preConcat(TransformUtils.getNormalizedToBuffer(r4.getCropRect()));
        return new OutputTransform(r2, TransformUtils.rectToSize(r4.getCropRect()));
    }

    public void setUsingCropRect(boolean r1) {
        this.mUsingCropRect = r1;
    }

    public void setUsingRotationDegrees(boolean r1) {
        this.mUsingRotationDegrees = r1;
    }

    public static RectF getRotatedCropRect(RectF r2, int r3) {
        if (TransformUtils.is90or270(r3) == false) goto L7;
        return new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r2.height(), r2.width());
    L7:
        return new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r2.width(), r2.height());
    }
}
