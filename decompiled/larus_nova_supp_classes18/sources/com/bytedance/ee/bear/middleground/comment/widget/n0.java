package com.bytedance.ee.bear.middleground.comment.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0 extends ImageSpan {
    public n0(Drawable r1) {
        super(r1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Rect r6 = getDrawable().getBounds();
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r7 = r1.getFontMetricsInt();
        r5.ascent = r7.ascent;
        r5.descent = r7.descent;
        r5.top = r7.top;
        r5.bottom = r7.bottom;
    L6:
        return r6.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Drawable r10 = getDrawable();
        r1.save();
        r1.translate(r5, ((((r8 - r6) - r10.getBounds().height()) / 2) + r6) - 3);
        r10.draw(r1);
        r1.restore();
    }
}
