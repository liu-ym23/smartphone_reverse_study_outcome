package vj9;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a extends ReplacementSpan {
    public a() {
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r101 != null) goto L7;
        return 0;
    L7:
        return MathKt.roundToInt(r100.measureText(r101, r102, r103));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r110, int r111, int r112, float r113, int r114, int r115, int r116, Paint r117) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r117, "paint");
        if (r110 != null) goto L5;
        return;
    L5:
        r100.drawText(r110, r111, r112, r113, r115, r117);
    }
}
