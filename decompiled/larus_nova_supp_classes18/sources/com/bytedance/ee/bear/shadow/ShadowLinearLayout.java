package com.bytedance.ee.bear.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import jm5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShadowLinearLayout extends LinearLayout {
    public a a;

    public int getHideRadiusSide() {
        return this.a.B;
    }

    public int getRadius() {
        return this.a.A;
    }

    public float getShadowAlpha() {
        return this.a.N;
    }

    public int getShadowColor() {
        return this.a.O;
    }

    public int getShadowElevation() {
        return this.a.M;
    }

    public ShadowLinearLayout(Context r4) {
        super(r4);
        this.a = new a(r4, null, 0, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r15) {
        super.dispatchDraw(r15);
        a r0 = this.a;
        int r1 = getWidth();
        int r2 = getHeight();
        View r3 = r0.I.get();
        if (r3 != null) goto L6;
    L41:
        a r4 = this.a;
        View r5 = r4.I.get();
        if (r5 == null) goto L86;
        int r6 = r4.a();
        if (r4.G > 0) goto L47;
    L49:
        boolean r7 = false;
    L50:
        if (r7 == true) goto L53;
        return;
    L53:
        if (r4.L == true) goto L55;
    L57:
        int r8 = r15.getWidth();
        int r9 = r15.getHeight();
        r15.save();
        r15.translate(r5.getScrollX(), r5.getScrollY());
        float r10 = r4.G / 2.0f;
        if (r4.J == false) goto L60;
        r4.E.set(r5.getPaddingLeft() + r10, r5.getPaddingTop() + r10, (r8 - r5.getPaddingRight()) - r10, (r9 - r5.getPaddingBottom()) - r10);
    L62:
        if (r4.D == true) goto L64;
    L77:
        if (r7 == false) goto L84;
        r4.z.setColor(r4.F);
        r4.z.setStrokeWidth(r4.G);
        r4.z.setStyle(Paint.Style.STROKE);
        if (r4.D == false) goto L81;
        RectF r11 = r4.E;
        float[] r12 = r4.C;
        Paint r13 = r4.z;
        r4.K.reset();
        r4.K.addRoundRect(r11, r12, Path.Direction.CW);
        r15.drawPath(r4.K, r13);
        goto L84
    L81:
        if (r6 > 0) goto L83;
        r15.drawRect(r4.E, r4.z);
        goto L84
    L83:
        float r14 = r6;
        r15.drawRoundRect(r4.E, r14, r14, r4.z);
    L84:
        r15.restore();
        return;
    L64:
        if (r4.C != null) goto L66;
        r4.C = new float[8];
    L66:
        int r16 = r4.B;
        if (r16 != 1) goto L70;
        float[] r17 = r4.C;
        float r18 = r6;
        r17[4] = r18;
        r17[5] = r18;
        r17[6] = r18;
        r17[7] = r18;
        goto L77
    L70:
        if (r16 != 2) goto L73;
        float[] r19 = r4.C;
        float r20 = r6;
        r19[0] = r20;
        r19[1] = r20;
        r19[6] = r20;
        r19[7] = r20;
        goto L77
    L73:
        if (r16 != 3) goto L75;
        float[] r21 = r4.C;
        float r22 = r6;
        r21[0] = r22;
        r21[1] = r22;
        r21[2] = r22;
        r21[3] = r22;
        goto L77
    L75:
        if (r16 != 4) goto L77;
        float[] r23 = r4.C;
        float r24 = r6;
        r23[2] = r24;
        r23[3] = r24;
        r23[4] = r24;
        r23[5] = r24;
        goto L77
    L60:
        r4.E.set(r10, r10, r8 - r10, r9 - r10);
        goto L62
    L55:
        if (r4.M == 0) goto L57;
        return;
    L47:
        if (r4.F == 0) goto L49;
        r7 = true;
        goto L50
    L86:
        return;
    L6:
        if (r0.y == null) goto L8;
    L16:
        r15.save();
        r15.translate(r3.getScrollX(), r3.getScrollY());
        int r25 = r0.e;
        if (r25 <= 0) goto L22;
        r0.y.setStrokeWidth(r25);
        r0.y.setColor(r0.h);
        int r26 = r0.i;
        if (r26 >= 255) goto L21;
        r0.y.setAlpha(r26);
    L21:
        float r110 = r0.e / 2.0f;
        r15.drawLine(r0.f, r110, r1 - r0.g, r110, r0.y);
    L22:
        int r27 = r0.j;
        if (r27 <= 0) goto L28;
        r0.y.setStrokeWidth(r27);
        r0.y.setColor(r0.m);
        int r28 = r0.n;
        if (r28 >= 255) goto L27;
        r0.y.setAlpha(r28);
    L27:
        float r111 = (float) Math.floor(r2 - (r0.j / 2.0f));
        r15.drawLine(r0.k, r111, r1 - r0.l, r111, r0.y);
    L28:
        int r29 = r0.o;
        if (r29 <= 0) goto L34;
        r0.y.setStrokeWidth(r29);
        r0.y.setColor(r0.r);
        int r30 = r0.s;
        if (r30 >= 255) goto L33;
        r0.y.setAlpha(r30);
    L33:
        float r31 = r0.o / 2.0f;
        r15.drawLine(r31, r0.p, r31, r2 - r0.q, r0.y);
    L34:
        int r32 = r0.t;
        if (r32 <= 0) goto L40;
        r0.y.setStrokeWidth(r32);
        r0.y.setColor(r0.w);
        int r33 = r0.x;
        if (r33 >= 255) goto L39;
        r0.y.setAlpha(r33);
    L39:
        float r112 = (float) Math.floor(r1 - (r0.t / 2.0f));
        r15.drawLine(r112, r0.u, r112, r2 - r0.v, r0.y);
    L40:
        r15.restore();
        goto L41
    L8:
        if (r0.e <= 0) goto L10;
    L15:
        r0.y = new Paint();
        goto L16
    L10:
        if (r0.j > 0) goto L15;
        if (r0.o > 0) goto L15;
        if (r0.t <= 0) goto L16;
        goto L15
    }

    public void setBorderColor(int r2) {
        this.a.F = r2;
        invalidate();
    }

    public void setBorderWidth(int r2) {
        this.a.G = r2;
        invalidate();
    }

    public void setBottomDividerAlpha(int r2) {
        this.a.n = r2;
        invalidate();
    }

    public void setHideRadiusSide(int r7) {
        a r0 = this.a;
        if (r0.B == r7) goto L7;
        int r1 = r0.A;
        int r3 = r0.M;
        float r5 = r0.N;
        r0.b(r1, r7, r3, r0.O, r5);
        return;
    }

    public void setLeftDividerAlpha(int r2) {
        this.a.s = r2;
        invalidate();
    }

    public void setOuterNormalColor(int r2) {
        a r0 = this.a;
        r0.H = r2;
        View r3 = r0.I.get();
        if (r3 == null) goto L6;
        r3.invalidate();
        return;
    }

    public void setOutlineExcludePadding(boolean r3) {
        a r0 = this.a;
        View r1 = r0.I.get();
        if (r1 == null) goto L7;
        r0.J = r3;
        r1.invalidateOutline();
        return;
    }

    public void setRadius(int r7) {
        a r0 = this.a;
        if (r0.A == r7) goto L6;
        int r3 = r0.M;
        float r5 = r0.N;
        r0.b(r7, r0.B, r3, r0.O, r5);
        return;
    }

    public void setRightDividerAlpha(int r2) {
        this.a.x = r2;
        invalidate();
    }

    public void setShadowAlpha(float r3) {
        a r0 = this.a;
        if (r0.N == r3) goto L14;
        r0.N = r3;
        View r4 = r0.I.get();
        if (r4 == null) goto L15;
        int r1 = r0.M;
        if (r1 != 0) goto L11;
        r4.setElevation(0.0f);
    L12:
        r4.invalidateOutline();
        return;
    L11:
        r4.setElevation(r1);
        goto L12
    L15:
        return;
    }

    public void setShadowColor(int r4) {
        a r0 = this.a;
        if (r0.O == r4) goto L13;
        r0.O = r4;
        if (Build.VERSION.SDK_INT < 28) goto L12;
        View r1 = r0.I.get();
        if (r1 == null) goto L14;
        r1.setOutlineAmbientShadowColor(r4);
        r1.setOutlineSpotShadowColor(r4);
        return;
    L14:
        return;
    L12:
        return;
    }

    public void setShadowElevation(int r3) {
        a r0 = this.a;
        if (r0.M == r3) goto L14;
        r0.M = r3;
        View r4 = r0.I.get();
        if (r4 == null) goto L15;
        int r1 = r0.M;
        if (r1 != 0) goto L11;
        r4.setElevation(0.0f);
    L12:
        r4.invalidateOutline();
        return;
    L11:
        r4.setElevation(r1);
        goto L12
    L15:
        return;
    }

    public void setShowBorderOnlyBeforeL(boolean r2) {
        a r0 = this.a;
        r0.L = r2;
        View r3 = r0.I.get();
        if (r3 == null) goto L6;
        r3.invalidate();
    L6:
        invalidate();
    }

    public void setTopDividerAlpha(int r2) {
        this.a.i = r2;
        invalidate();
    }

    public ShadowLinearLayout(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.a = new a(r3, r4, 0, this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        a r0 = this.a;
        if (r0.a > 0) goto L5;
    L10:
        a r1 = this.a;
        if (r1.b > 0) goto L13;
    L18:
        super.onMeasure(r6, r7);
        a r2 = this.a;
        int r3 = getMeasuredWidth();
        r2.getClass();
        if (View.MeasureSpec.getMode(r6) == 1073741824) goto L23;
        int r4 = r2.c;
        if (r3 >= r4) goto L23;
        int r5 = View.MeasureSpec.makeMeasureSpec(r4, 1073741824);
    L24:
        a r8 = this.a;
        int r9 = getMeasuredHeight();
        r8.getClass();
        if (View.MeasureSpec.getMode(r7) == 1073741824) goto L29;
        int r10 = r8.d;
        if (r9 >= r10) goto L29;
        int r11 = View.MeasureSpec.makeMeasureSpec(r10, 1073741824);
    L30:
        if (r6 != r5) goto L32;
        if (r7 != r11) goto L32;
        return;
    L32:
        super.onMeasure(r5, r11);
        return;
    L29:
        r11 = r7;
    L23:
        r5 = r6;
        goto L24
    L13:
        if (View.MeasureSpec.getSize(r7) <= r1.b) goto L18;
        if (View.MeasureSpec.getMode(r7) != Integer.MIN_VALUE) goto L17;
        r7 = View.MeasureSpec.makeMeasureSpec(r1.a, Integer.MIN_VALUE);
        goto L18
    L17:
        r7 = View.MeasureSpec.makeMeasureSpec(r1.a, 1073741824);
        goto L18
    L5:
        if (View.MeasureSpec.getSize(r6) <= r0.a) goto L10;
        if (View.MeasureSpec.getMode(r6) != Integer.MIN_VALUE) goto L9;
        r6 = View.MeasureSpec.makeMeasureSpec(r0.a, Integer.MIN_VALUE);
        goto L10
    L9:
        r6 = View.MeasureSpec.makeMeasureSpec(r0.a, 1073741824);
        goto L10
    }

    public ShadowLinearLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = new a(r2, r3, r4, this);
    }
}
