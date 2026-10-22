package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends ReplacementSpan {
    public final Paint a;
    public final int b;
    public final int c;

    public m(int r1, int r2) {
        this.b = r1;
        this.c = r2;
        Paint r3 = new Paint();
        r3.setColor(0);
        r3.setStyle(Paint.Style.FILL);
        Unit r4 = Unit.INSTANCE;
        this.a = r3;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        Rect r7 = new Rect(0, 0, this.b, this.c);
        if (r6 == null) goto L6;
        Paint.FontMetricsInt r8 = r2.getFontMetricsInt();
        int r9 = r8.bottom - r8.top;
        int r10 = (r7.bottom - r7.top) / 2;
        int r11 = r9 / 4;
        int r12 = r10 - r11;
        int r13 = -(r10 + r11);
        r6.ascent = r13;
        r6.top = r13;
        r6.bottom = r12;
        r6.descent = r12;
    L6:
        return r7.right;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r7, CharSequence r8, int r9, int r10, float r11, int r12, int r13, int r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        r7.drawRect(r11, r12, r11 + this.b, r14, this.a);
    }
}
