package pp9;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements b {
    public a() {
    }

    @Override // pp9.b
    public final Matrix a(RectF r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "previewBaseRect");
        Intrinsics.checkNotNullParameter(r101, "fromRect");
        Matrix r102 = new Matrix();
        float r103 = 1.0f / Math.min(r100.width() / r101.width(), r100.height() / r101.height());
        r102.setScale(r103, r103, r100.centerX(), r100.centerY());
        r102.postTranslate(r101.centerX() - r100.centerX(), r101.centerY() - r100.centerY());
        return r102;
    }
}
