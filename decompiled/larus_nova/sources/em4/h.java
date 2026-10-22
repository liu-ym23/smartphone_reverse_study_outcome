package em4;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class h extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f473063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f473064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f473065c;

    public h(float r100, int r101) {
        this.f473063a = r100;
        this.f473064b = r101;
        this.f473065c = new Rect();
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return MathKt.roundToInt(r100.measureText(r101, r102, r103) + (this.f473063a * 2));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r210, Paint r211) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r211, "paint");
        this.f473065c.set((int) r114, r115, (int) ((r211.measureText(r111, r112, r113) + r114) + (this.f473063a * 2)), r210);
        r211.setColor(0);
        r110.drawRect(this.f473065c, r211);
        r211.setColor(this.f473064b);
        float r100 = r114 + this.f473063a;
        if (r111 == null) goto L6;
        r110.drawText(r111, r112, r113, r100, r116, r211);
        return;
    }
}
