package r19;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f535677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f535678b;

    public a(float r100, float r101) {
        this.f535677a = r100;
        this.f535678b = r101;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return MathKt.roundToInt((r100.measureText(r101, r102, r103) + this.f535677a) + this.f535678b);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r110, int r111, int r112, float r113, int r114, int r115, int r116, Paint r117) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r117, "paint");
        float r101 = (r100.getHeight() / 2.0f) - ((r117.descent() + r117.ascent()) / 2.0f);
        float r102 = r113 + this.f535677a;
        if (r110 != null) goto L5;
        CharSequence r103 = "";
    L6:
        r100.drawText(r103, r111, r112, r102, r101, r117);
        return;
    L5:
        r103 = r110;
        goto L6
    }
}
