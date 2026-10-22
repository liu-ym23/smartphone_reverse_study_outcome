package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DoubleColorBallAnimationView extends View {
    public int a;
    public int b;
    public Paint c;
    public final PorterDuffXfermode d;
    public float e;
    public boolean f;
    public boolean g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public long l;
    public int m;
    public float n;
    public float o;
    public float p;
    public float q;

    public final void d() {
        this.k = false;
        this.g = false;
        this.e = 0.0f;
    }

    public final void a() {
        this.l = -1;
        if (this.m > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(2131165312));
    L5:
        int r0 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.m <= r0) goto L10;
        if (r0 <= 0) goto L10;
        setProgressBarInfo(r0);
    L10:
        if (this.c != null) goto L12;
        Paint r1 = new Paint();
        r1.setAntiAlias(true);
        r1.setDither(true);
        r1.setStyle(Paint.Style.FILL);
        this.c = r1;
    L12:
        this.g = true;
    }

    public final void c() {
        a();
        this.k = true;
        this.f = true;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i == true) goto L5;
        return;
    L5:
        if (this.j == false) goto L9;
        c();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j = this.k;
        d();
    }

    public DoubleColorBallAnimationView(Context r2) {
        this(r2, null);
        b(r2);
    }

    public final void b(Context r2) {
        this.a = ContextCompat.getColor(r2, 2131100232);
        this.b = ContextCompat.getColor(r2, 2131100233);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        super.onDraw(r13);
        if (this.k == true) goto L7;
        if (this.f == false) goto L7;
        return;
    L7:
        if (this.g == false) goto L36;
        boolean r1 = false;
        if (this.f == false) goto L18;
        long r2 = System.nanoTime() / 1000000;
        if (this.l >= 0) goto L14;
        this.l = r2;
    L14:
        float r0 = (r2 - this.l) / 400.0f;
        this.e = r0;
        int r3 = (int) r0;
        if (((this.h + r3) & 1) != 1) goto L17;
        r1 = true;
    L17:
        this.e = r0 - r3;
    L18:
        float r4 = this.e;
        if (r4 >= 0.5f) goto L21;
        float r5 = (r4 * 2.0f) * r4;
    L22:
        int r6 = this.m;
        int r7 = r13.saveLayer(0.0f, 0.0f, r6, r6, this.c, 31);
        float r8 = (this.q * r5) + this.p;
        if (r5 >= 0.5f) goto L25;
        float r9 = r5 * 2.0f;
    L26:
        float r10 = this.o;
        float r11 = ((0.25f * r9) * r10) + r10;
        Paint r12 = this.c;
        if (r1 == false) goto L29;
        int r14 = this.b;
    L30:
        r12.setColor(r14);
        r13.drawCircle(r8, this.n, r11, this.c);
        float r15 = this.m - r8;
        float r16 = this.o;
        float r17 = r16 - ((r9 * 0.375f) * r16);
        Paint r18 = this.c;
        if (r1 == false) goto L33;
        int r19 = this.a;
    L34:
        r18.setColor(r19);
        this.c.setXfermode(this.d);
        r13.drawCircle(r15, this.n, r17, this.c);
        this.c.setXfermode(null);
        r13.restoreToCount(r7);
        postInvalidateDelayed(17);
        return;
    L33:
        r19 = this.b;
        goto L34
    L29:
        r14 = this.a;
        goto L30
    L25:
        r9 = 2.0f - (r5 * 2.0f);
        goto L26
    L21:
        r5 = ((r4 * 2.0f) * (2.0f - r4)) - 1.0f;
        goto L22
    }

    public void setCycleBias(int r1) {
        this.h = r1;
    }

    public void setProgress(float r2) {
        if (this.g == true) goto L5;
        a();
    L5:
        this.e = r2;
        this.k = false;
        this.f = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int r5) {
        if (r5 <= 0) goto L5;
        this.m = r5;
        this.n = r5 / 2.0f;
        float r0 = (r5 >> 1) * 0.32f;
        this.o = r0;
        float r3 = (r5 * 0.16f) + r0;
        this.p = r3;
        this.q = r5 - (r3 * 2.0f);
        return;
    }

    public void setResumeWhenAttached(boolean r1) {
        this.i = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        c();
        return;
    L5:
        d();
    }

    public DoubleColorBallAnimationView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
        b(r2);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        int r3 = Math.min(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
        if (this.m <= r3) goto L7;
        if (r3 <= 0) goto L8;
        setProgressBarInfo(r3);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f = false;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = -1;
        this.m = -1;
        b(r1);
    }
}
