package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class AppLayoutCenterContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f239992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f239993b;

    public AppLayoutCenterContentFrameLayout(Context r100) {
        super(r100);
    }

    public final void a(AttributeSet r100) {
        if (r100 == null) goto L5;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.appBarLayoutId, R.attr.scrollContentId}, 0, 0);
        this.f239992a = r101.getResourceId(0, 0);
        this.f239993b = r101.getResourceId(1, 0);
        r101.recycle();
        return;
    }

    public AppLayoutCenterContentFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r103 <= 0) goto L18;
        View r104 = getRootView();
        int r105 = 0;
        if (r104 == null) goto L17;
        View r106 = r104.findViewById(this.f239992a);
        View r107 = r104.findViewById(this.f239993b);
        if (r106 == null) goto L17;
        if (r107 == null) goto L17;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof CoordinatorLayout.LayoutParams) == false) goto L14;
        boolean r109 = ((CoordinatorLayout.LayoutParams) r108).getBehavior() instanceof AppBarLayout.ScrollingViewBehavior;
    L15:
        if (r109 == false) goto L17;
        r105 = r106.getMeasuredHeight();
        goto L17
    L14:
        r109 = false;
    L17:
        r101 = View.MeasureSpec.makeMeasureSpec(r103 - r105, r102);
    L18:
        super.onMeasure(r100, r101);
    }

    public AppLayoutCenterContentFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r101);
    }
}
