package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u extends r {
    public CharSequence k;
    public Typeface l;
    public final TextPaint m;
    public float n;

    public u() {
        this.l = Typeface.DEFAULT;
        TextPaint r0 = new TextPaint();
        r0.setAntiAlias(true);
        Unit r1 = Unit.INSTANCE;
        this.m = r0;
    }

    public final void b(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        CharSequence r2 = this.k;
        this.m.setTextAlign(Paint.Align.CENTER);
        this.m.setTypeface(this.l);
        int r0 = 0;
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (this.g == true) goto L13;
        return;
    L13:
        if (this.a <= 0) goto L37;
        this.m.setAlpha((int) (this.a * 255));
        this.j.reset();
        if (this.f == 0.0f) goto L18;
        r0 = r9.save();
        r9.rotate(this.f);
    L18:
        if (this.d == 0.0f) goto L20;
    L23:
        this.j.setTranslate(this.d, this.e);
        this.j.mapRect(this.i, this.h);
    L25:
        if (this.b == 1.0f) goto L27;
    L30:
        this.j.reset();
        this.j.setScale(this.b, this.c, this.i.centerX(), this.i.centerY());
        this.m.setTextSize(this.n * Math.max(this.b, this.c));
        Matrix r3 = this.j;
        RectF r4 = this.i;
        r3.mapRect(r4, r4);
    L31:
        int r5 = r2.length();
        Paint.FontMetrics r6 = this.m.getFontMetrics();
        float r7 = this.i.centerX();
        RectF r8 = this.i;
        r9.drawText(r2, 0, r5, r7, ((r8.top + (r8.height() / 2.0f)) - (r6.top / 2.0f)) - (r6.bottom / 2.0f), this.m);
        if (r0 <= 0) goto L38;
        r9.restoreToCount(r0);
        return;
    L38:
        return;
    L27:
        if (this.c != 1.0f) goto L30;
        this.m.setTextSize(this.n);
        goto L31
    L20:
        if (this.e != 0.0f) goto L23;
        this.i.set(this.h);
        goto L25
    L37:
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
