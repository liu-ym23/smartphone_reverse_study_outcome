package mh2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends ImageSpan {
    public int a;

    public b(Context r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "b");
        super(r2, r3, -1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        Intrinsics.checkNotNullParameter(r2, "text");
        Rect r6 = getDrawable().getBounds();
        int r7 = r6.height();
        if (r5 == null) goto L6;
        Paint.FontMetrics r8 = r1.getFontMetrics();
        float r9 = r7;
        float r10 = ((r8.descent + r8.ascent) / 2.0f) - (r9 / 2.0f);
        int r11 = ((int) r10) - 1;
        r5.ascent = r11;
        r5.top = r11;
        int r12 = ((int) (r9 + r10)) + 1;
        r5.descent = r12;
        r5.bottom = r12;
    L6:
        return (r6.right + this.a) + 1;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = getDrawable();
        r1.save();
        int r11 = r10.getBounds().bottom;
        if (((ImageSpan) this).mVerticalAlignment != 1) goto L5;
        float r12 = (r8 - r11) - r9.getFontMetricsInt().descent;
    L6:
        r1.translate(r5, r12);
        r10.draw(r1);
        r1.restore();
        return;
    L5:
        Paint.FontMetrics r13 = r9.getFontMetrics();
        float r14 = r7;
        r12 = ((((r13.descent + r14) + r14) + r13.ascent) / 2.0f) - (r11 / 2.0f);
        goto L6
    }
}
