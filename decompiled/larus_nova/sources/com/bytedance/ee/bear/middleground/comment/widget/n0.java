package com.bytedance.ee.bear.middleground.comment.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: classes18.dex */
public final class n0 extends ImageSpan {
    public n0(Drawable r100) {
        super(r100);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        r104.ascent = r106.ascent;
        r104.descent = r106.descent;
        r104.top = r106.top;
        r104.bottom = r106.bottom;
    L6:
        return r105.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Drawable r109 = getDrawable();
        r100.save();
        r100.translate(r104, ((((r107 - r105) - r109.getBounds().height()) / 2) + r105) - 3);
        r109.draw(r100);
        r100.restore();
    }
}
