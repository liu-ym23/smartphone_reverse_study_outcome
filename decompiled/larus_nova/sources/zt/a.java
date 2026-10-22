package zt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f573551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f573552b;

    public a(Drawable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100, 2);
        this.f573551a = r101;
        this.f573552b = r102;
    }

    public /* synthetic */ a(Drawable r100, int r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        return (this.f573551a + super.getSize(r100, r101, r102, r103, r104)) + this.f573552b;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
        float r111 = r104 + this.f573551a;
        int r112 = ((((r110.descent + r106) + r106) + r110.ascent) / 2) - (r109.getBounds().bottom / 2);
        r100.save();
        r100.translate(r111, r112);
        r109.draw(r100);
        r100.restore();
    }
}
