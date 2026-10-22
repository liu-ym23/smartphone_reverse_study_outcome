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

/* JADX INFO: loaded from: classes18.dex */
public class ShadowLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f236990a;

    public int getHideRadiusSide() {
        return this.f236990a.B;
    }

    public int getRadius() {
        return this.f236990a.A;
    }

    public float getShadowAlpha() {
        return this.f236990a.N;
    }

    public int getShadowColor() {
        return this.f236990a.O;
    }

    public int getShadowElevation() {
        return this.f236990a.M;
    }

    public ShadowLinearLayout(Context r100) {
        super(r100);
        this.f236990a = new a(r100, null, 0, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        super.dispatchDraw(r110);
        a r100 = this.f236990a;
        int r101 = getWidth();
        int r102 = getHeight();
        View r103 = r100.I.get();
        if (r103 != null) goto L6;
    L41:
        a r104 = this.f236990a;
        View r105 = r104.I.get();
        if (r105 == null) goto L86;
        int r106 = r104.a();
        if (r104.G > 0) goto L47;
    L49:
        boolean r107 = false;
    L50:
        if (r107 == true) goto L53;
        return;
    L53:
        if (r104.L == true) goto L55;
    L57:
        int r108 = r110.getWidth();
        int r109 = r110.getHeight();
        r110.save();
        r110.translate(r105.getScrollX(), r105.getScrollY());
        float r111 = r104.G / 2.0f;
        if (r104.f499639J == false) goto L60;
        r104.E.set(r105.getPaddingLeft() + r111, r105.getPaddingTop() + r111, (r108 - r105.getPaddingRight()) - r111, (r109 - r105.getPaddingBottom()) - r111);
    L62:
        if (r104.D == true) goto L64;
    L77:
        if (r107 == false) goto L84;
        r104.f499665z.setColor(r104.F);
        r104.f499665z.setStrokeWidth(r104.G);
        r104.f499665z.setStyle(Paint.Style.STROKE);
        if (r104.D == false) goto L81;
        RectF r112 = r104.E;
        float[] r113 = r104.C;
        Paint r114 = r104.f499665z;
        r104.K.reset();
        r104.K.addRoundRect(r112, r113, Path.Direction.CW);
        r110.drawPath(r104.K, r114);
        goto L84
    L81:
        if (r106 > 0) goto L83;
        r110.drawRect(r104.E, r104.f499665z);
        goto L84
    L83:
        float r115 = r106;
        r110.drawRoundRect(r104.E, r115, r115, r104.f499665z);
    L84:
        r110.restore();
        return;
    L64:
        if (r104.C != null) goto L66;
        r104.C = new float[8];
    L66:
        int r116 = r104.B;
        if (r116 != 1) goto L70;
        float[] r117 = r104.C;
        float r118 = r106;
        r117[4] = r118;
        r117[5] = r118;
        r117[6] = r118;
        r117[7] = r118;
        goto L77
    L70:
        if (r116 != 2) goto L73;
        float[] r119 = r104.C;
        float r120 = r106;
        r119[0] = r120;
        r119[1] = r120;
        r119[6] = r120;
        r119[7] = r120;
        goto L77
    L73:
        if (r116 != 3) goto L75;
        float[] r121 = r104.C;
        float r122 = r106;
        r121[0] = r122;
        r121[1] = r122;
        r121[2] = r122;
        r121[3] = r122;
        goto L77
    L75:
        if (r116 != 4) goto L77;
        float[] r123 = r104.C;
        float r124 = r106;
        r123[2] = r124;
        r123[3] = r124;
        r123[4] = r124;
        r123[5] = r124;
        goto L77
    L60:
        r104.E.set(r111, r111, r108 - r111, r109 - r111);
        goto L62
    L55:
        if (r104.M == 0) goto L57;
        return;
    L47:
        if (r104.F == 0) goto L49;
        r107 = true;
        goto L50
    L86:
        return;
    L6:
        if (r100.f499664y == null) goto L8;
    L16:
        r110.save();
        r110.translate(r103.getScrollX(), r103.getScrollY());
        int r125 = r100.f499644e;
        if (r125 <= 0) goto L22;
        r100.f499664y.setStrokeWidth(r125);
        r100.f499664y.setColor(r100.f499647h);
        int r126 = r100.f499648i;
        if (r126 >= 255) goto L21;
        r100.f499664y.setAlpha(r126);
    L21:
        float r127 = r100.f499644e / 2.0f;
        r110.drawLine(r100.f499645f, r127, r101 - r100.f499646g, r127, r100.f499664y);
    L22:
        int r128 = r100.f499649j;
        if (r128 <= 0) goto L28;
        r100.f499664y.setStrokeWidth(r128);
        r100.f499664y.setColor(r100.f499652m);
        int r129 = r100.f499653n;
        if (r129 >= 255) goto L27;
        r100.f499664y.setAlpha(r129);
    L27:
        float r130 = (float) Math.floor(r102 - (r100.f499649j / 2.0f));
        r110.drawLine(r100.f499650k, r130, r101 - r100.f499651l, r130, r100.f499664y);
    L28:
        int r131 = r100.f499654o;
        if (r131 <= 0) goto L34;
        r100.f499664y.setStrokeWidth(r131);
        r100.f499664y.setColor(r100.f499657r);
        int r132 = r100.f499658s;
        if (r132 >= 255) goto L33;
        r100.f499664y.setAlpha(r132);
    L33:
        float r133 = r100.f499654o / 2.0f;
        r110.drawLine(r133, r100.f499655p, r133, r102 - r100.f499656q, r100.f499664y);
    L34:
        int r134 = r100.f499659t;
        if (r134 <= 0) goto L40;
        r100.f499664y.setStrokeWidth(r134);
        r100.f499664y.setColor(r100.f499662w);
        int r135 = r100.f499663x;
        if (r135 >= 255) goto L39;
        r100.f499664y.setAlpha(r135);
    L39:
        float r136 = (float) Math.floor(r101 - (r100.f499659t / 2.0f));
        r110.drawLine(r136, r100.f499660u, r136, r102 - r100.f499661v, r100.f499664y);
    L40:
        r110.restore();
        goto L41
    L8:
        if (r100.f499644e <= 0) goto L10;
    L15:
        r100.f499664y = new Paint();
        goto L16
    L10:
        if (r100.f499649j > 0) goto L15;
        if (r100.f499654o > 0) goto L15;
        if (r100.f499659t <= 0) goto L16;
        goto L15
    }

    public void setBorderColor(int r100) {
        this.f236990a.F = r100;
        invalidate();
    }

    public void setBorderWidth(int r100) {
        this.f236990a.G = r100;
        invalidate();
    }

    public void setBottomDividerAlpha(int r100) {
        this.f236990a.f499653n = r100;
        invalidate();
    }

    public void setHideRadiusSide(int r100) {
        a r101 = this.f236990a;
        if (r101.B == r100) goto L7;
        int r102 = r101.A;
        int r103 = r101.M;
        float r104 = r101.N;
        r101.b(r102, r100, r103, r101.O, r104);
        return;
    }

    public void setLeftDividerAlpha(int r100) {
        this.f236990a.f499658s = r100;
        invalidate();
    }

    public void setOuterNormalColor(int r100) {
        a r101 = this.f236990a;
        r101.H = r100;
        View r102 = r101.I.get();
        if (r102 == null) goto L6;
        r102.invalidate();
        return;
    }

    public void setOutlineExcludePadding(boolean r100) {
        a r101 = this.f236990a;
        View r102 = r101.I.get();
        if (r102 == null) goto L7;
        r101.f499639J = r100;
        r102.invalidateOutline();
        return;
    }

    public void setRadius(int r100) {
        a r101 = this.f236990a;
        if (r101.A == r100) goto L6;
        int r102 = r101.M;
        float r103 = r101.N;
        r101.b(r100, r101.B, r102, r101.O, r103);
        return;
    }

    public void setRightDividerAlpha(int r100) {
        this.f236990a.f499663x = r100;
        invalidate();
    }

    public void setShadowAlpha(float r100) {
        a r101 = this.f236990a;
        if (r101.N == r100) goto L14;
        r101.N = r100;
        View r102 = r101.I.get();
        if (r102 == null) goto L15;
        int r103 = r101.M;
        if (r103 != 0) goto L11;
        r102.setElevation(0.0f);
    L12:
        r102.invalidateOutline();
        return;
    L11:
        r102.setElevation(r103);
        goto L12
    L15:
        return;
    }

    public void setShadowColor(int r100) {
        a r101 = this.f236990a;
        if (r101.O == r100) goto L13;
        r101.O = r100;
        if (Build.VERSION.SDK_INT < 28) goto L12;
        View r102 = r101.I.get();
        if (r102 == null) goto L14;
        r102.setOutlineAmbientShadowColor(r100);
        r102.setOutlineSpotShadowColor(r100);
        return;
    L14:
        return;
    L12:
        return;
    }

    public void setShadowElevation(int r100) {
        a r101 = this.f236990a;
        if (r101.M == r100) goto L14;
        r101.M = r100;
        View r102 = r101.I.get();
        if (r102 == null) goto L15;
        int r103 = r101.M;
        if (r103 != 0) goto L11;
        r102.setElevation(0.0f);
    L12:
        r102.invalidateOutline();
        return;
    L11:
        r102.setElevation(r103);
        goto L12
    L15:
        return;
    }

    public void setShowBorderOnlyBeforeL(boolean r100) {
        a r101 = this.f236990a;
        r101.L = r100;
        View r102 = r101.I.get();
        if (r102 == null) goto L6;
        r102.invalidate();
    L6:
        invalidate();
    }

    public void setTopDividerAlpha(int r100) {
        this.f236990a.f499648i = r100;
        invalidate();
    }

    public ShadowLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f236990a = new a(r100, r101, 0, this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        a r102 = this.f236990a;
        if (r102.f499640a > 0) goto L5;
    L10:
        a r103 = this.f236990a;
        if (r103.f499641b > 0) goto L13;
    L18:
        super.onMeasure(r100, r101);
        a r104 = this.f236990a;
        int r105 = getMeasuredWidth();
        r104.getClass();
        if (View.MeasureSpec.getMode(r100) == 1073741824) goto L23;
        int r106 = r104.f499642c;
        if (r105 >= r106) goto L23;
        int r107 = View.MeasureSpec.makeMeasureSpec(r106, 1073741824);
    L24:
        a r108 = this.f236990a;
        int r109 = getMeasuredHeight();
        r108.getClass();
        if (View.MeasureSpec.getMode(r101) == 1073741824) goto L29;
        int r110 = r108.f499643d;
        if (r109 >= r110) goto L29;
        int r111 = View.MeasureSpec.makeMeasureSpec(r110, 1073741824);
    L30:
        if (r100 != r107) goto L32;
        if (r101 != r111) goto L32;
        return;
    L32:
        super.onMeasure(r107, r111);
        return;
    L29:
        r111 = r101;
    L23:
        r107 = r100;
        goto L24
    L13:
        if (View.MeasureSpec.getSize(r101) <= r103.f499641b) goto L18;
        if (View.MeasureSpec.getMode(r101) != Integer.MIN_VALUE) goto L17;
        r101 = View.MeasureSpec.makeMeasureSpec(r103.f499640a, Integer.MIN_VALUE);
        goto L18
    L17:
        r101 = View.MeasureSpec.makeMeasureSpec(r103.f499640a, 1073741824);
        goto L18
    L5:
        if (View.MeasureSpec.getSize(r100) <= r102.f499640a) goto L10;
        if (View.MeasureSpec.getMode(r100) != Integer.MIN_VALUE) goto L9;
        r100 = View.MeasureSpec.makeMeasureSpec(r102.f499640a, Integer.MIN_VALUE);
        goto L10
    L9:
        r100 = View.MeasureSpec.makeMeasureSpec(r102.f499640a, 1073741824);
        goto L10
    }

    public ShadowLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f236990a = new a(r100, r101, r102, this);
    }
}
