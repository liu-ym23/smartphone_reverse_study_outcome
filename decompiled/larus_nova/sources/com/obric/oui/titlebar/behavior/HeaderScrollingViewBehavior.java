package com.obric.oui.titlebar.behavior;

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

/* JADX INFO: loaded from: classes34.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f403513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f403514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f403515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f403516f;

    public abstract View findFirstDependency(List<View> r100);

    public float getOverlapRatioForOffset(View r100) {
        return 1.0f;
    }

    public HeaderScrollingViewBehavior() {
        this.f403513c = new Rect();
        this.f403514d = new Rect();
        this.f403515e = 0;
    }

    public int getScrollRange(View r100) {
        return r100.getMeasuredHeight();
    }

    public HeaderScrollingViewBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f403513c = new Rect();
        this.f403514d = new Rect();
        this.f403515e = 0;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public final void layoutChild(CoordinatorLayout r110, View r111, int r112) {
        View r100 = findFirstDependency(r110.getDependencies(r111));
        int r101 = 0;
        if (r100 == null) goto L20;
        CoordinatorLayout.LayoutParams r102 = (CoordinatorLayout.LayoutParams) r111.getLayoutParams();
        Rect r103 = this.f403513c;
        r103.set(r110.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r102).leftMargin, r100.getBottom() + ((ViewGroup.MarginLayoutParams) r102).topMargin, (r110.getWidth() - r110.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r102).rightMargin, ((r110.getHeight() + r100.getBottom()) - r110.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r102).bottomMargin);
        WindowInsetsCompat r104 = r110.getLastWindowInsets();
        if (r104 != null) goto L7;
    L11:
        Rect r113 = this.f403514d;
        int r105 = r102.gravity;
        if (r105 != 0) goto L14;
        int r106 = 8388659;
    L15:
        GravityCompat.apply(r106, r111.getMeasuredWidth(), r111.getMeasuredHeight(), r103, r113, r112);
        if (this.f403516f == 0) goto L19;
        float r114 = getOverlapRatioForOffset(r100);
        int r107 = this.f403516f;
        r101 = MathUtils.clamp((int) (r114 * r107), 0, r107);
    L19:
        r111.layout(r113.left, r113.top - r101, r113.right, r113.bottom - r101);
        this.f403515e = r113.top - r100.getBottom();
        return;
    L14:
        r106 = r105;
        goto L15
    L7:
        if (ViewCompat.getFitsSystemWindows(r110) == false) goto L11;
        if (ViewCompat.getFitsSystemWindows(r111) == true) goto L11;
        r103.left += r104.getSystemWindowInsetLeft();
        r103.right -= r104.getSystemWindowInsetRight();
        goto L11
    L20:
        r110.onLayoutChild(r111, r112);
        this.f403515e = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r100, View r101, int r110, int r111, int r112, int r113) {
        int r102 = r101.getLayoutParams().height;
        if (r102 != (-1)) goto L5;
    L6:
        View r103 = findFirstDependency(r100.getDependencies(r101));
        if (r103 == null) goto L24;
        int r114 = View.MeasureSpec.getSize(r112);
        if (r114 > 0) goto L11;
        r114 = r100.getHeight();
    L16:
        int r115 = r114 + getScrollRange(r103);
        int r104 = r103.getMeasuredHeight();
        r101.setTranslationY(0.0f);
        int r116 = r115 - r104;
        if (r102 != (-1)) goto L19;
        int r105 = 1073741824;
    L20:
        r100.onMeasureChild(r101, r110, r111, View.MeasureSpec.makeMeasureSpec(r116, r105), r113);
        return true;
    L19:
        r105 = Integer.MIN_VALUE;
        goto L20
    L11:
        if (ViewCompat.getFitsSystemWindows(r103) == false) goto L16;
        WindowInsetsCompat r106 = r100.getLastWindowInsets();
        if (r106 == null) goto L16;
        r114 = r114 + (r106.getSystemWindowInsetTop() + r106.getSystemWindowInsetBottom());
        goto L16
    L24:
        return false;
    L5:
        if (r102 == (-2)) goto L6;
        return false;
    }
}
