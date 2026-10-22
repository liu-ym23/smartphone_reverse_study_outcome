package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends ImageSpan {
    public c(Context r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        super(r2, r3);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
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
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = getDrawable();
        r1.save();
        int r11 = r8 - r10.getBounds().bottom;
        if (((ImageSpan) this).mVerticalAlignment != 1) goto L5;
        int r12 = r11 - r9.getFontMetricsInt().descent;
    L6:
        r1.translate(r5, r12);
        r10.draw(r1);
        r1.restore();
        return;
    L5:
        Paint.FontMetricsInt r13 = r9.getFontMetricsInt();
        r12 = ((((r13.descent + r7) + r7) + r13.ascent) / 2) - (r10.getBounds().bottom / 2);
        goto L6
    }
}
