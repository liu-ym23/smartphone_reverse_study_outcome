package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends r {
    public final Rect k;
    public boolean l;
    public final RectF m;
    public Bitmap n;
    public String o;
    public final Paint p;

    public final void c() {
        Bitmap r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L9;
        r0.recycle();
        return;
    }

    public c() {
        this.k = new Rect();
        this.m = new RectF();
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        Unit r1 = Unit.INSTANCE;
        this.p = r0;
    }

    public final void b(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Bitmap r0 = this.n;
        if (this.g == false) goto L37;
        int r2 = 0;
        if (this.a <= 0) goto L38;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isRecycled() == true) goto L40;
        this.p.setAlpha((int) (this.a * 255));
        this.m.set(this.h);
        if (this.l == false) goto L20;
        float r1 = this.h.width();
        float r4 = this.h.height();
        int r5 = r0.getWidth();
        int r6 = r0.getHeight();
        if (r1 == 0.0f) goto L20;
        if (r5 == 0) goto L20;
        float r7 = r4 / r1;
        float r8 = r6 / r5;
        if (r7 == r8) goto L20;
        if (r7 <= r8) goto L19;
        float r3 = r1 * r8;
        RectF r10 = this.h;
        float r11 = r10.top + ((r10.height() - r3) / 2.0f);
        RectF r12 = this.h;
        float r13 = r12.bottom - ((r12.height() - r3) / 2.0f);
        RectF r14 = this.m;
        r14.top = r11;
        r14.bottom = r13;
        goto L20
    L19:
        float r15 = r4 / r8;
        RectF r16 = this.h;
        float r17 = r16.left + ((r16.width() - r15) / 2.0f);
        RectF r18 = this.h;
        float r19 = r18.right - ((r18.width() - r15) / 2.0f);
        RectF r20 = this.m;
        r20.left = r17;
        r20.right = r19;
    L20:
        this.j.reset();
        if (this.d == 0.0f) goto L23;
    L24:
        this.j.setTranslate(this.d, this.e);
    L25:
        this.j.mapRect(this.i, this.m);
        if (this.b == 1.0f) goto L28;
    L29:
        this.j.reset();
        this.j.setScale(this.b, this.c, this.i.centerX(), this.i.centerY());
        Matrix r21 = this.j;
        RectF r22 = this.i;
        r21.mapRect(r22, r22);
    L31:
        if (this.f == 0.0f) goto L33;
        r2 = r9.save();
        r9.rotate(this.f, this.i.centerX(), this.i.centerY());
    L33:
        r9.drawBitmap(r0, this.k, this.i, this.p);
        if (r2 <= 0) goto L41;
        r9.restoreToCount(r2);
        return;
    L41:
        return;
    L28:
        if (this.c == 1.0f) goto L31;
    L23:
        if (this.e == 0.0f) goto L25;
    L40:
        return;
    L38:
        return;
    }

    public final void d(Bitmap r4) {
        this.n = r4;
        if (r4 == null) goto L6;
        this.k.set(0, 0, r4.getWidth(), r4.getHeight());
        return;
    }
}
