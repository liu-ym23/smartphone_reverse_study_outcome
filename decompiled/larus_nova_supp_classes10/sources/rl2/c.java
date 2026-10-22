package rl2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public int a;
    public int b;
    public int c;
    public int d;
    public final RectF e;
    public final float[] f;
    public final Path g;
    public final Paint h;
    public final PorterDuffXfermode i;
    public final a j;

    public c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.j = r2;
        this.e = new RectF();
        this.f = new float[8];
        this.g = new Path();
        this.h = new Paint(1);
        this.i = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public final void a(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (this.a == 0) goto L5;
    L11:
        int r0 = r6.saveLayer(this.e, this.h);
        this.g.reset();
        this.g.addRoundRect(this.e, this.f, Path.Direction.CW);
        r6.drawPath(this.g, this.h);
        this.h.setXfermode(this.i);
        r6.saveLayer(this.e, this.h);
        this.j.g(r6);
        this.h.setXfermode(null);
        this.h.setColorFilter(null);
        r6.restoreToCount(r0);
        return;
    L5:
        if (this.c != 0) goto L11;
        if (this.b != 0) goto L11;
        if (this.d != 0) goto L11;
        this.j.g(r6);
    }

    public final void c(int r3, int r4) {
        if (this.a == 0) goto L5;
    L10:
        if (r3 == 0) goto L16;
        if (r4 == 0) goto L17;
        this.e.set(0.0f, 0.0f, r3, r4);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (this.c != 0) goto L10;
        if (this.d != 0) goto L10;
        if (this.b != 0) goto L10;
    }

    public final void b(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130969905, 2130969911, 2130969912, 2130969921, 2130969922}, r6, 0);
        if (r7 == null) goto L6;
        int r8 = r7.getDimensionPixelSize(0, 0);
        d(r7.getDimensionPixelSize(2, r8), r7.getDimensionPixelSize(1, r8), r7.getDimensionPixelSize(4, r8), r7.getDimensionPixelSize(3, r8));
        r7.recycle();
        return;
    }

    public final void d(int r5, int r6, int r7, int r8) {
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        float[] r0 = this.f;
        float r1 = r5;
        r0[0] = r1;
        r0[1] = r1;
        float r2 = r7;
        r0[2] = r2;
        r0[3] = r2;
        float r3 = r8;
        r0[4] = r3;
        r0[5] = r3;
        float r4 = r6;
        r0[6] = r4;
        r0[7] = r4;
        if (r6 > 0) goto L7;
        if (r5 > 0) goto L7;
        if (r7 > 0) goto L7;
        if (r8 > 0) goto L7;
    L13:
        this.j.h();
        return;
    L7:
        Object r9 = this.j;
        if ((r9 instanceof ViewGroup) == true) goto L10;
        r9 = null;
    L10:
        ViewGroup r10 = (ViewGroup) r9;
        if (r10 == null) goto L13;
        r10.setWillNotDraw(false);
        goto L13
    }
}
