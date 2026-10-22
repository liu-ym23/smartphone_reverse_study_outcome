package com.larksuite.component.universe_design.button;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284593b;

    public b(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100);
        this.f284592a = 0;
        this.f284593b = 0;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = Math.max(r107, r105.bottom - r105.top);
        int r109 = r106.top + (r107 / 2);
        int r110 = r108 / 2;
        int r111 = r109 - r110;
        r104.ascent = r111;
        int r112 = r109 + r110;
        r104.descent = r112;
        r104.top = r111;
        r104.bottom = r112;
    L6:
        return (r105.width() + this.f284592a) + this.f284593b;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        r100.save();
        Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
        int r111 = r110.descent;
        int r112 = ((r106 + r111) - ((r111 - r110.ascent) / 2)) - (r109.getBounds().height() / 2);
        int r113 = this.f284592a;
        if (r113 == 0) goto L5;
        r100.translate(r104 + r113, r112);
    L6:
        r109.draw(r100);
        r100.restore();
        return;
    L5:
        r100.translate(r104, r112);
        goto L6
    }
}
