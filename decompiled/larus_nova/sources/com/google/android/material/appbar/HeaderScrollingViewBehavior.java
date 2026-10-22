package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap;

    private static int resolveGravity(int r100) {
        if (r100 != 0) goto L5;
        return 8388659;
    L5:
        return r100;
    }

    public abstract View findFirstDependency(List<View> r100);

    public float getOverlapRatioForOffset(View r100) {
        return 1.0f;
    }

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public final int getOverlapPixelsForOffset(View r100) {
        if (this.overlayTop == 0) goto L7;
        float r101 = getOverlapRatioForOffset(r100);
        int r102 = this.overlayTop;
        return MathUtils.clamp((int) (r101 * r102), 0, r102);
    L7:
        return 0;
    }

    public int getScrollRange(View r100) {
        return r100.getMeasuredHeight();
    }

    public final void setOverlayTop(int r100) {
        this.overlayTop = r100;
    }

    public HeaderScrollingViewBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void layoutChild(CoordinatorLayout r100, View r110, int r111) {
        View r101 = findFirstDependency(r100.getDependencies(r110));
        if (r101 == null) goto L12;
        CoordinatorLayout.LayoutParams r102 = (CoordinatorLayout.LayoutParams) r110.getLayoutParams();
        Rect r103 = this.tempRect1;
        r103.set(r100.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r102).leftMargin, r101.getBottom() + ((ViewGroup.MarginLayoutParams) r102).topMargin, (r100.getWidth() - r100.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r102).rightMargin, ((r100.getHeight() + r101.getBottom()) - r100.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r102).bottomMargin);
        WindowInsetsCompat r104 = r100.getLastWindowInsets();
        if (r104 != null) goto L7;
    L11:
        Rect r105 = this.tempRect2;
        GravityCompat.apply(resolveGravity(r102.gravity), r110.getMeasuredWidth(), r110.getMeasuredHeight(), r103, r105, r111);
        int r112 = getOverlapPixelsForOffset(r101);
        r110.layout(r105.left, r105.top - r112, r105.right, r105.bottom - r112);
        this.verticalLayoutGap = r105.top - r101.getBottom();
        return;
    L7:
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L11;
        if (ViewCompat.getFitsSystemWindows(r110) == true) goto L11;
        r103.left += r104.getSystemWindowInsetLeft();
        r103.right -= r104.getSystemWindowInsetRight();
        goto L11
    L12:
        super.layoutChild(r100, r110, r111);
        this.verticalLayoutGap = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout r110, View r111, int r112, int r113, int r114, int r115) {
        int r100 = r111.getLayoutParams().height;
        if (r100 != (-1)) goto L5;
    L6:
        View r101 = findFirstDependency(r110.getDependencies(r111));
        if (r101 != null) goto L9;
        return false;
    L9:
        if (ViewCompat.getFitsSystemWindows(r101) == false) goto L17;
        if (ViewCompat.getFitsSystemWindows(r111) == true) goto L17;
        ViewCompat.setFitsSystemWindows(r111, true);
        if (ViewCompat.getFitsSystemWindows(r111) == false) goto L17;
        r111.requestLayout();
        return true;
    L17:
        int r102 = View.MeasureSpec.getSize(r114);
        if (r102 != 0) goto L20;
        r102 = r110.getHeight();
    L20:
        int r103 = (r102 - r101.getMeasuredHeight()) + getScrollRange(r101);
        if (r100 != (-1)) goto L23;
        int r104 = 1073741824;
    L24:
        r110.onMeasureChild(r111, r112, r113, View.MeasureSpec.makeMeasureSpec(r103, r104), r115);
        return true;
    L23:
        r104 = Integer.MIN_VALUE;
        goto L24
    L5:
        if (r100 == (-2)) goto L6;
        return false;
    }
}
