package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CoordinateTransform {
    private static final String MISMATCH_MSG = "The source viewport (%s) does not match the target viewport (%s). Please make sure they are associated with the same Viewport.";
    private static final String TAG = "CoordinateTransform";
    private final Matrix mMatrix;

    public void mapPoint(PointF r5) {
        float[] r0 = {r5.x, r5.y};
        this.mMatrix.mapPoints(r0);
        r5.x = r0[0];
        r5.y = r0[1];
    }

    public void mapPoints(float[] r2) {
        this.mMatrix.mapPoints(r2);
    }

    public void mapRect(RectF r2) {
        this.mMatrix.mapRect(r2);
    }

    public void transform(Matrix r2) {
        r2.set(this.mMatrix);
    }

    public CoordinateTransform(OutputTransform r4, OutputTransform r5) {
        if (TransformUtils.isAspectRatioMatchingWithRoundingError(r4.getViewPortSize(), r5.getViewPortSize()) == true) goto L5;
        Logger.w(TAG, String.format(MISMATCH_MSG, new Object[]{r4.getViewPortSize(), r5.getViewPortSize()}));
    L5:
        Matrix r0 = new Matrix();
        this.mMatrix = r0;
        Preconditions.checkState(r4.getMatrix().invert(r0), "The source transform cannot be inverted");
        r0.postConcat(r5.getMatrix());
    }
}
