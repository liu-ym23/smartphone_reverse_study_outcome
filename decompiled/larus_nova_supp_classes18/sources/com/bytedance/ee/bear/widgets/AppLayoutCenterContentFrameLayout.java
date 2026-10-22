package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AppLayoutCenterContentFrameLayout extends FrameLayout {
    public int a;
    public int b;

    public AppLayoutCenterContentFrameLayout(Context r1) {
        super(r1);
    }

    public final void a(AttributeSet r4) {
        if (r4 == null) goto L5;
        TypedArray r5 = getContext().obtainStyledAttributes(r4, new int[]{2130968807, 2130973936}, 0, 0);
        this.a = r5.getResourceId(0, 0);
        this.b = r5.getResourceId(1, 0);
        r5.recycle();
        return;
    }

    public AppLayoutCenterContentFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r1 = View.MeasureSpec.getSize(r7);
        if (r1 <= 0) goto L18;
        View r8 = getRootView();
        int r2 = 0;
        if (r8 == null) goto L17;
        View r3 = r8.findViewById(this.a);
        View r9 = r8.findViewById(this.b);
        if (r3 == null) goto L17;
        if (r9 == null) goto L17;
        CoordinatorLayout.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.LayoutParams) == false) goto L14;
        boolean r11 = r10.getBehavior() instanceof AppBarLayout.ScrollingViewBehavior;
    L15:
        if (r11 == false) goto L17;
        r2 = r3.getMeasuredHeight();
        goto L17
    L14:
        r11 = false;
    L17:
        r7 = View.MeasureSpec.makeMeasureSpec(r1 - r2, r0);
    L18:
        super.onMeasure(r6, r7);
    }

    public AppLayoutCenterContentFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r2);
    }
}
