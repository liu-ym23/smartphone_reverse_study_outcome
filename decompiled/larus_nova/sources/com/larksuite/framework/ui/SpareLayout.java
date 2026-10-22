package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes24.dex */
public class SpareLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f285828a;

    public SpareLayout(Context r100) {
        super(r100);
        this.f285828a = 0;
    }

    public void setFirstViewMinWidth(int r100) {
        this.f285828a = r100;
    }

    public SpareLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f285828a = 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r210, int r211) {
        int r100 = r210;
        if (getChildCount() > 0) goto L6;
        super.onMeasure(r210, r211);
        return;
    L6:
        int r101 = View.MeasureSpec.getSize(r210);
        int r102 = getPaddingLeft() + getPaddingRight();
        int r103 = getPaddingTop() + getPaddingBottom();
        int r104 = r101 - r102;
        View r105 = getChildAt(0);
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105.getLayoutParams();
        int r110 = r106.leftMargin + r106.rightMargin;
        int r111 = r106.topMargin + r106.bottomMargin;
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if (r107 != null) goto L9;
    L12:
        int r108 = Integer.MIN_VALUE;
    L13:
        int r112 = 8;
        if (this.f285828a > 0) goto L16;
    L18:
        int r113 = Math.min(this.f285828a, r105.getMeasuredWidth()) + r110;
        int r114 = 1;
        int r115 = 0;
        int r116 = 0;
    L20:
        if (r114 >= getChildCount()) goto L34;
        View r109 = getChildAt(r114);
        if (r109.getVisibility() != r112) goto L24;
        int r117 = r103;
        int r212 = r111;
    L33:
        r114 = r114 + 1;
        r100 = r210;
        r103 = r117;
        r111 = r212;
        r112 = 8;
        goto L20
    L24:
        measureChild(r109, r100, r211);
        FrameLayout.LayoutParams r118 = (FrameLayout.LayoutParams) r109.getLayoutParams();
        int r119 = r118.leftMargin + r118.rightMargin;
        r117 = r103;
        int r120 = r118.topMargin + r118.bottomMargin;
        int r121 = r109.getMeasuredWidth() + r119;
        r212 = r111;
        if (this.f285828a <= 0) goto L32;
        int r122 = r104 - r115;
        if ((r122 - r121) >= r113) goto L32;
        measureChild(r109, View.MeasureSpec.makeMeasureSpec((r122 - r113) - r118.leftMargin, 1073741824), r211);
        r115 = r115 + (r109.getMeasuredWidth() + r118.leftMargin);
        int r123 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        int r124 = r114 + 1;
    L30:
        if (r124 >= (getChildCount() - 1)) goto L35;
        measureChild(getChildAt(r124), r123, r211);
        r124 = r124 + 1;
    L35:
        int r125 = r116;
        if (r105.getVisibility() == 8) goto L38;
        measureChild(r105, View.MeasureSpec.makeMeasureSpec(((r101 - r115) - r110) - r102, r108), r211);
        int r126 = Math.max(r105.getMeasuredHeight() + r212, r125);
    L39:
        setMeasuredDimension(Math.min((r115 + r105.getMeasuredWidth()) + r102, r101), r126 + r117);
        return;
    L38:
        r126 = r125;
    L32:
        r115 = r115 + (r109.getMeasuredWidth() + r119);
        int r127 = r109.getMeasuredHeight() + r120;
        r116 = Math.max(r116, r127);
        goto L33
    L34:
        r117 = r103;
        r212 = r111;
        goto L35
    L16:
        if (r105.getVisibility() == 8) goto L18;
        measureChild(r105, r100, r211);
        goto L18
    L9:
        if (r107.width == (-2)) goto L12;
        r108 = 1073741824;
        goto L13
    }

    public SpareLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f285828a = 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= getChildCount()) goto L22;
        View r106 = getChildAt(r104);
        if (r106.getVisibility() == 8) goto L21;
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106.getLayoutParams();
        int r108 = (r107.leftMargin + r105) + getPaddingLeft();
        int r109 = r107.gravity & 112;
        if (r109 != 16) goto L11;
        int r111 = ((((((getPaddingTop() + r102) + r107.topMargin) + r110) - getPaddingBottom()) - r107.bottomMargin) - r106.getMeasuredHeight()) / 2;
    L19:
        int r112 = r111 - r102;
    L20:
        r106.layout(r108, r112, r106.getMeasuredWidth() + r108, r106.getMeasuredHeight() + r112);
        r105 = r105 + ((r106.getMeasuredWidth() + r107.leftMargin) + r107.rightMargin);
        goto L21
    L11:
        if (r109 != 48) goto L13;
        int r113 = r107.topMargin;
        int r114 = getPaddingTop();
    L17:
        r112 = r113 + r114;
        goto L20
    L13:
        if (r109 == 80) goto L15;
        r113 = r107.topMargin;
        r114 = getPaddingTop();
        goto L17
    L15:
        r111 = ((r110 - r107.bottomMargin) - getPaddingBottom()) - r106.getMeasuredHeight();
    L21:
        r104 = r104 + 1;
        goto L4
    }
}
