package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class OutputTransform {
    final Matrix mMatrix;
    final Size mViewPortSize;

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Size getViewPortSize() {
        return this.mViewPortSize;
    }

    public OutputTransform(Matrix r1, Size r2) {
        this.mMatrix = r1;
        this.mViewPortSize = r2;
    }
}
