package com.larus.chat.search.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes26.dex */
public class SpareLayout extends FrameLayout {
    public SpareLayout(Context r100) {
        super(r100);
    }

    public SpareLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (getChildCount() > 0) goto L6;
        super.onMeasure(r110, r111);
        return;
    L6:
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = getChildCount() - 1;
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r101 <= 0) goto L14;
        View r104 = getChildAt(r101);
        if (r104.getVisibility() == 8) goto L13;
        measureChild(r104, r110, r111);
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104.getLayoutParams();
        int r106 = r105.leftMargin + r105.rightMargin;
        int r107 = r105.topMargin + r105.bottomMargin;
        r102 = r102 + (r104.getMeasuredWidth() + r106);
        r103 = Math.max(r103, r104.getMeasuredHeight() + r107);
    L13:
        r101 = r101 - 1;
        goto L8
    L14:
        View r112 = getChildAt(0);
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r112.getLayoutParams();
        int r109 = r108.leftMargin + r108.rightMargin;
        int r113 = r108.topMargin + r108.bottomMargin;
        ViewGroup.LayoutParams r114 = r112.getLayoutParams();
        if (r114 != null) goto L17;
    L20:
        int r115 = Integer.MIN_VALUE;
    L21:
        int r116 = getPaddingLeft() + getPaddingRight();
        int r117 = getPaddingTop() + getPaddingBottom();
        if (r112.getVisibility() == 8) goto L24;
        measureChild(r112, View.MeasureSpec.makeMeasureSpec(((r100 - r102) - r109) - r116, r115), r111);
        r103 = Math.max(r112.getMeasuredHeight() + r113, r103);
    L24:
        setMeasuredDimension((r102 + r112.getMeasuredWidth()) + r116, r103 + r117);
        return;
    L17:
        if (r114.width == (-2)) goto L20;
        r115 = 1073741824;
        goto L21
    }

    public SpareLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        int r114 = 0;
        int r115 = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r101 = true;
    L6:
        int r102 = getChildCount();
        if (r101 == false) goto L9;
        int r103 = r102 - 1;
        r115 = -1;
    L10:
        int r104 = 0;
    L11:
        if (r114 >= r102) goto L29;
        View r105 = getChildAt((r115 * r114) + r103);
        if (r105.getVisibility() == 8) goto L28;
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105.getLayoutParams();
        int r107 = (r106.leftMargin + r104) + getPaddingLeft();
        int r108 = r106.gravity & 112;
        if (r108 != 16) goto L18;
        int r109 = ((((((getPaddingTop() + r111) + r106.topMargin) + r113) - getPaddingBottom()) - r106.bottomMargin) - r105.getMeasuredHeight()) / 2;
    L26:
        int r116 = r109 - r111;
    L27:
        r105.layout(r107, r116, r105.getMeasuredWidth() + r107, r105.getMeasuredHeight() + r116);
        r104 = r104 + ((r105.getMeasuredWidth() + r106.leftMargin) + r106.rightMargin);
        goto L28
    L18:
        if (r108 != 48) goto L20;
        int r117 = r106.topMargin;
        int r118 = getPaddingTop();
    L24:
        r116 = r117 + r118;
        goto L27
    L20:
        if (r108 == 80) goto L22;
        r117 = r106.topMargin;
        r118 = getPaddingTop();
        goto L24
    L22:
        r109 = ((r113 - r106.bottomMargin) - getPaddingBottom()) - r105.getMeasuredHeight();
    L28:
        r114 = r114 + 1;
        goto L11
    L29:
        return;
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = false;
        goto L6
    }
}
