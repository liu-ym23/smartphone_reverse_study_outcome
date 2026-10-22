package com.bytedance.awemeopen.apps.framework.base.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b extends ImageSpan {
    public b(Drawable r1) {
        super(r1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Rect r6 = getDrawable().getBounds();
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r7 = r1.getFontMetricsInt();
        int r8 = r7.bottom - r7.top;
        int r9 = (r6.bottom - r6.top) / 2;
        int r10 = r8 / 4;
        int r11 = r9 - r10;
        int r12 = -(r9 + r10);
        r5.ascent = r12;
        r5.top = r12;
        r5.bottom = r11;
        r5.descent = r11;
    L6:
        return r6.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Drawable r10 = getDrawable();
        Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
        int r12 = ((((r11.descent + r7) + r7) + r11.ascent) / 2) - (r10.getBounds().bottom / 2);
        r1.save();
        r1.translate(r5, r12);
        r10.draw(r1);
        r1.restore();
    }
}
