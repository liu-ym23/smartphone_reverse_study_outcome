package com.larus.bmhome.chat.layout.item;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f304564a;

    public q(Drawable r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100);
        this.f304564a = r101;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.descent;
        int r108 = r106.ascent;
        int r109 = r108 + ((r107 - r108) / 2);
        int r110 = (r105.bottom - r105.top) / 2;
        int r111 = r109 - r110;
        r104.ascent = r111;
        r104.top = r111;
        int r112 = r109 + r110;
        r104.bottom = r112;
        r104.descent = r112;
    L6:
        return r105.right + this.f304564a;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Paint.FontMetricsInt r109 = r108.getFontMetricsInt();
        int r110 = ((((r109.descent + r106) + r106) + r109.ascent) / 2) - (getDrawable().getBounds().bottom / 2);
        r100.save();
        r100.translate(r104, r110);
        getDrawable().draw(r100);
        r100.restore();
    }
}
