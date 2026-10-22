package psc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f530608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f530609b;

    public f(int r100, int r101) {
        this.f530608a = r100;
        this.f530609b = r101;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (r104 == null) goto L6;
        int r105 = r104.ascent;
        int r106 = this.f530609b;
        r104.ascent = r105 - r106;
        r104.top -= r106;
        r104.descent += r106;
        r104.bottom += r106;
    L6:
        return this.f530608a;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r110, int r111, int r112, float r113, int r114, int r115, int r116, Paint r117) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "text");
        Intrinsics.checkNotNullParameter(r117, "paint");
        r100.drawText(r110, r111, r112, r113, r115, r117);
    }
}
