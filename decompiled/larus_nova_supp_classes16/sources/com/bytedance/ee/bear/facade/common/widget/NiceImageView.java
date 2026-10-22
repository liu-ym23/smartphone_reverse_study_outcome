package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NiceImageView extends AppCompatImageView {
    public final Context a;
    public final boolean b;
    public final boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final Xfermode n;
    public int o;
    public int p;
    public float q;
    public final float[] r;
    public final float[] s;
    public RectF t;
    public final RectF u;
    public final Paint v;
    public final Path w;
    public final Path x;

    public final void j() {
        if (this.b == false) goto L5;
        return;
    L5:
        int r2 = 0;
        if (this.h <= 0) goto L10;
    L7:
        float[] r1 = this.r;
        if (r2 >= r1.length) goto L13;
        int r4 = this.h;
        r1[r2] = r4;
        this.s[r2] = r4 - (this.d / 2.0f);
        r2 = r2 + 1;
        goto L7
    L13:
        return;
    L10:
        float[] r3 = this.r;
        int r5 = this.i;
        float r6 = r5;
        r3[1] = r6;
        r3[0] = r6;
        int r7 = this.j;
        float r8 = r7;
        r3[3] = r8;
        r3[2] = r8;
        int r9 = this.l;
        float r10 = r9;
        r3[5] = r10;
        r3[4] = r10;
        int r11 = this.k;
        float r13 = r11;
        r3[7] = r13;
        r3[6] = r13;
        float[] r12 = this.s;
        int r14 = this.d;
        float r16 = r5 - (r14 / 2.0f);
        r12[1] = r16;
        r12[0] = r16;
        float r17 = r7 - (r14 / 2.0f);
        r12[3] = r17;
        r12[2] = r17;
        float r18 = r9 - (r14 / 2.0f);
        r12[5] = r18;
        r12[4] = r18;
        float r19 = r11 - (r14 / 2.0f);
        r12[7] = r19;
        r12[6] = r19;
    }

    public final void m() {
        if (this.b == true) goto L6;
        RectF r0 = this.u;
        int r1 = this.d;
        r0.set(r1 / 2.0f, r1 / 2.0f, this.o - (r1 / 2.0f), this.p - (r1 / 2.0f));
        return;
    }

    public NiceImageView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(boolean r1) {
        if (r1 == false) goto L4;
        this.h = 0;
    L4:
        j();
        m();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r9) {
        r9.saveLayer(this.t, null, 31);
        if (this.c == true) goto L5;
        int r0 = this.o;
        int r3 = this.d * 2;
        int r5 = this.f * 2;
        float r4 = ((r0 - r3) - r5) * 1.0f;
        float r1 = r0;
        int r7 = this.p;
        float r6 = ((r7 - r3) - r5) * 1.0f;
        float r8 = r7;
        r9.scale(r4 / r1, r6 / r8, r1 / 2.0f, r8 / 2.0f);
    L5:
        super/*android.widget.ImageView*/.onDraw(r9);
        this.v.reset();
        this.w.reset();
        if (this.b == false) goto L8;
        this.w.addCircle(this.o / 2.0f, this.p / 2.0f, this.q, Path.Direction.CCW);
    L9:
        this.v.setAntiAlias(true);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setXfermode(this.n);
        if (Build.VERSION.SDK_INT > 27) goto L12;
        r9.drawPath(this.w, this.v);
    L13:
        this.v.setXfermode(null);
        int r2 = this.m;
        if (r2 == 0) goto L16;
        this.v.setColor(r2);
        r9.drawPath(this.w, this.v);
    L16:
        r9.restore();
        if (this.b == false) goto L24;
        int r10 = this.d;
        if (r10 <= 0) goto L21;
        int r11 = this.e;
        float r12 = r10;
        float r13 = this.q - (r12 / 2.0f);
        this.w.reset();
        this.v.setStrokeWidth(r12);
        this.v.setColor(r11);
        this.v.setStyle(Paint.Style.STROKE);
        this.w.addCircle(this.o / 2.0f, this.p / 2.0f, r13, Path.Direction.CCW);
        r9.drawPath(this.w, this.v);
    L21:
        int r14 = this.f;
        if (r14 <= 0) goto L28;
        int r16 = this.g;
        float r17 = r14;
        float r18 = (this.q - this.d) - (r17 / 2.0f);
        this.w.reset();
        this.v.setStrokeWidth(r17);
        this.v.setColor(r16);
        this.v.setStyle(Paint.Style.STROKE);
        this.w.addCircle(this.o / 2.0f, this.p / 2.0f, r18, Path.Direction.CCW);
        r9.drawPath(this.w, this.v);
        return;
    L28:
        return;
    L24:
        int r19 = this.d;
        if (r19 <= 0) goto L30;
        int r20 = this.e;
        RectF r21 = this.u;
        float[] r22 = this.r;
        this.w.reset();
        this.v.setStrokeWidth(r19);
        this.v.setColor(r20);
        this.v.setStyle(Paint.Style.STROKE);
        this.w.addRoundRect(r21, r22, Path.Direction.CCW);
        r9.drawPath(this.w, this.v);
        return;
    L30:
        return;
    L12:
        this.x.reset();
        this.x.addRect(this.t, Path.Direction.CCW);
        this.x.op(this.w, Path.Op.DIFFERENCE);
        r9.drawPath(this.x, this.v);
        goto L13
    L8:
        this.w.addRoundRect(this.t, this.s, Path.Direction.CCW);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderColor(int r1) {
        this.e = r1;
        invalidate();
    }

    public void setBorderWidth(int r2) {
        this.d = com.bytedance.ee.util.ui.n.f(this.a, r2);
        l(false);
    }

    public void setCornerBottomLeftRadius(int r2) {
        this.k = com.bytedance.ee.util.ui.n.f(this.a, r2);
        l(true);
    }

    public void setCornerBottomRightRadius(int r2) {
        this.l = com.bytedance.ee.util.ui.n.f(this.a, r2);
        l(true);
    }

    public void setCornerRadius(int r2) {
        this.h = com.bytedance.ee.util.ui.n.f(this.a, r2);
        l(false);
    }

    public void setCornerTopLeftRadius(int r2) {
        this.i = com.bytedance.ee.util.ui.n.f(this.a, r2);
        l(true);
    }

    public void setCornerTopRightRadius(int r2) {
        this.j = com.bytedance.ee.util.ui.n.f(this.a, r2);
        l(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInnerBorderColor(int r1) {
        this.g = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInnerBorderWidth(int r2) {
        this.f = com.bytedance.ee.util.ui.n.f(this.a, r2);
        if (this.b == true) goto L5;
        this.f = 0;
    L5:
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaskColor(int r1) {
        this.m = r1;
        invalidate();
    }

    public NiceImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NiceImageView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.e = -1;
        this.g = -1;
        this.a = r4;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130969033, 2130969035, 2130969644, 2130969645, 2130969646, 2130969647, 2130969648, 2130970356, 2130970357, 2130970392, 2130970393, 2130972685}, 0, 0);
        int r8 = 0;
    L4:
        if (r8 >= r7.getIndexCount()) goto L40;
        int r9 = r7.getIndex(r8);
        if (r9 != 10) goto L9;
        this.c = r7.getBoolean(r9, this.c);
    L39:
        r8 = r8 + 1;
        goto L4
    L9:
        if (r9 != 9) goto L12;
        this.b = r7.getBoolean(r9, this.b);
        goto L39
    L12:
        if (r9 != 1) goto L14;
        this.d = r7.getDimensionPixelSize(r9, this.d);
        goto L39
    L14:
        if (r9 != 0) goto L16;
        this.e = r7.getColor(r9, this.e);
        goto L39
    L16:
        if (r9 != 8) goto L19;
        this.f = r7.getDimensionPixelSize(r9, this.f);
        goto L39
    L19:
        if (r9 != 7) goto L22;
        this.g = r7.getColor(r9, this.g);
        goto L39
    L22:
        if (r9 != 4) goto L25;
        this.h = r7.getDimensionPixelSize(r9, this.h);
        goto L39
    L25:
        if (r9 != 5) goto L28;
        this.i = r7.getDimensionPixelSize(r9, this.i);
        goto L39
    L28:
        if (r9 != 6) goto L31;
        this.j = r7.getDimensionPixelSize(r9, this.j);
        goto L39
    L31:
        if (r9 != 2) goto L34;
        this.k = r7.getDimensionPixelSize(r9, this.k);
        goto L39
    L34:
        if (r9 != 3) goto L37;
        this.l = r7.getDimensionPixelSize(r9, this.l);
        goto L39
    L37:
        if (r9 != 11) goto L39;
        this.m = r7.getColor(r9, this.m);
        goto L39
    L40:
        r7.recycle();
        this.r = new float[8];
        this.s = new float[8];
        this.u = new RectF();
        this.t = new RectF();
        this.v = new Paint();
        this.w = new Path();
        if (Build.VERSION.SDK_INT > 27) goto L43;
        this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    L44:
        j();
        if (this.b == true) goto L62;
        this.f = 0;
        return;
    L62:
        return;
    L43:
        this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.x = new Path();
        goto L44
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super/*android.widget.ImageView*/.onSizeChanged(r3, r4, r5, r6);
        this.o = r3;
        this.p = r4;
        m();
        if (this.b == false) goto L5;
        float r7 = Math.min(this.o, this.p) / 2.0f;
        this.q = r7;
        RectF r8 = this.t;
        float r9 = this.o / 2.0f;
        float r1 = this.p / 2.0f;
        r8.set(r9 - r7, r1 - r7, r9 + r7, r1 + r7);
        return;
    L5:
        this.t.set(0.0f, 0.0f, this.o, this.p);
        if (this.c == false) goto L10;
        this.t = this.u;
        return;
    }
}
