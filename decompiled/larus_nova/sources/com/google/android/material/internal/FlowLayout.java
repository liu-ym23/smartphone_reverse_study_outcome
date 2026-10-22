package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private boolean singleLine;

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    public FlowLayout(Context r100) {
        this(r100, null);
    }

    public void setItemSpacing(int r100) {
        this.itemSpacing = r100;
    }

    public void setLineSpacing(int r100) {
        this.lineSpacing = r100;
    }

    public void setSingleLine(boolean r100) {
        this.singleLine = r100;
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private void loadFromAttributes(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.itemSpacing, R.attr.lineSpacing}, 0, 0);
        this.lineSpacing = r102.getDimensionPixelSize(1, 0);
        this.itemSpacing = r102.getDimensionPixelSize(0, 0);
        r102.recycle();
    }

    @Override // android.view.View
    public void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r103 = View.MeasureSpec.getMode(r211);
        if (r101 != Integer.MIN_VALUE) goto L5;
    L8:
        int r104 = r100;
    L9:
        int r105 = getPaddingLeft();
        int r106 = getPaddingTop();
        int r107 = r104 - getPaddingRight();
        int r108 = r106;
        int r110 = 0;
        int r111 = 0;
    L11:
        if (r110 >= getChildCount()) goto L30;
        View r112 = getChildAt(r110);
        if (r112.getVisibility() == 8) goto L29;
        measureChild(r112, r210, r211);
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        int r109 = r114.leftMargin + 0;
        int r115 = r114.rightMargin + 0;
    L19:
        int r116 = r105;
        if (((r105 + r109) + r112.getMeasuredWidth()) > r107) goto L22;
    L24:
        int r117 = r116;
    L25:
        int r118 = (r117 + r109) + r112.getMeasuredWidth();
        int r119 = r108 + r112.getMeasuredHeight();
        if (r118 <= r111) goto L28;
        r111 = r118;
    L28:
        r105 = r117 + (((r109 + r115) + r112.getMeasuredWidth()) + this.itemSpacing);
        r106 = r119;
        goto L29
    L22:
        if (isSingleLine() == true) goto L24;
        r117 = getPaddingLeft();
        r108 = this.lineSpacing + r106;
        goto L25
    L18:
        r109 = 0;
        r115 = 0;
    L29:
        r110 = r110 + 1;
        goto L11
    L30:
        setMeasuredDimension(getMeasuredDimension(r100, r101, r111), getMeasuredDimension(r102, r103, r106));
        return;
    L5:
        if (r101 == 1073741824) goto L8;
        r104 = Integer.MAX_VALUE;
        goto L9
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.singleLine = false;
        loadFromAttributes(r100, r101);
    }

    private static int getMeasuredDimension(int r100, int r101, int r102) {
        if (r101 == Integer.MIN_VALUE) goto L9;
        if (r101 == 1073741824) goto L7;
        return r102;
    L7:
        return r100;
    L9:
        return Math.min(r102, r100);
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.singleLine = false;
        loadFromAttributes(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        boolean r114 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L9;
        r114 = false;
    L9:
        if (r114 == false) goto L11;
        int r101 = getPaddingRight();
    L12:
        if (r114 == false) goto L14;
        int r102 = getPaddingLeft();
    L15:
        int r103 = getPaddingTop();
        int r115 = (r112 - r110) - r102;
        int r104 = r101;
        int r116 = r103;
        int r105 = 0;
    L17:
        if (r105 >= getChildCount()) goto L35;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() == 8) goto L34;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        int r109 = MarginLayoutParamsCompat.getMarginStart(r108);
        int r117 = MarginLayoutParamsCompat.getMarginEnd(r108);
    L25:
        int r118 = (r104 + r109) + r106.getMeasuredWidth();
        if (this.singleLine == true) goto L29;
        if (r118 <= r115) goto L29;
        r116 = this.lineSpacing + r103;
        r104 = r101;
    L29:
        int r119 = r104 + r109;
        int r120 = r106.getMeasuredWidth() + r119;
        int r121 = r106.getMeasuredHeight() + r116;
        if (r114 == false) goto L32;
        r106.layout(r115 - r120, r116, (r115 - r104) - r109, r121);
    L33:
        r104 = r104 + (((r109 + r117) + r106.getMeasuredWidth()) + this.itemSpacing);
        r103 = r121;
        goto L34
    L32:
        r106.layout(r119, r116, r120, r121);
        goto L33
    L24:
        r117 = 0;
        r109 = 0;
    L34:
        r105 = r105 + 1;
        goto L17
    L35:
        return;
    L14:
        r102 = getPaddingRight();
        goto L15
    L11:
        r101 = getPaddingLeft();
        goto L12
    }
}
