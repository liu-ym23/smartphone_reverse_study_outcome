package com.bytedance.ee.bear.sheet.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ElasticLinearLayout extends LinearLayout implements NestedScrollingParent {
    public View a;
    public boolean b;
    public a c;

    public class a extends Animation {
        public final float a;
        public final /* synthetic */ ElasticLinearLayout b;

        public a(ElasticLinearLayout r2) {
            this.b = r2;
            this.a = 1.0f;
            r2.b = true;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r3, Transformation r4) {
            float r5 = ((this.a - 0.0f) * r3) + 0.0f;
            ElasticLinearLayout r6 = this.b;
            r6.scrollBy((int) ((0 - r6.getScrollX()) * r5), 0);
            if (r5 != 1.0f) goto L6;
            this.b.b = false;
            return;
        }

        @Override // android.view.animation.Animation
        public final void initialize(int r1, int r2, int r3, int r4) {
            super.initialize(r1, r2, r3, r4);
            setDuration(260);
            setInterpolator(new AccelerateInterpolator());
        }
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = getChildAt(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r1) {
        if (this.c != null) goto L5;
        this.c = new a(this);
    L5:
        startAnimation(this.c);
    }

    public ElasticLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        setOrientation(0);
    }

    @Override // android.view.View
    public final void scrollTo(int r2, int r3) {
        if (r2 <= 600) goto L5;
        r2 = 600;
    L5:
        super.scrollTo(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        if (getScrollX() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r1, View r2, int r3) {
        if ((r2 instanceof RecyclerView) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b == true) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (r8 > 0) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r8 < 0) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r8 < 0) goto L17;
    L21:
        boolean r4 = false;
    L22:
        if (r8 > 0) goto L24;
    L26:
        boolean r5 = false;
    L27:
        if (r2 == true) goto L31;
        if (r3 == true) goto L31;
        if (r4 == true) goto L31;
        if (r5 == true) goto L31;
    L32:
        if (r8 > 0) goto L34;
    L38:
        if (r8 < 0) goto L40;
        return;
    L40:
        if (getScrollX() < 0) goto L42;
        return;
    L42:
        if (r7.canScrollHorizontally(1) == true) goto L47;
        scrollTo(0, 0);
        return;
    L47:
        return;
    L34:
        if (getScrollX() <= 0) goto L38;
        if (r7.canScrollHorizontally(-1) == true) goto L38;
        scrollTo(0, 0);
    L31:
        scrollBy(r8 / 3, 0);
        r10[0] = r8;
        goto L32
    L24:
        if (r7.canScrollHorizontally(1) == true) goto L26;
        r5 = true;
        goto L27
    L17:
        if (getScrollX() <= 0) goto L21;
        if (r7.canScrollHorizontally(1) == true) goto L21;
        r4 = true;
        goto L22
    L12:
        if (r7.canScrollHorizontally(-1) == true) goto L14;
        r3 = true;
        goto L15
    L5:
        if (getScrollX() >= 0) goto L9;
        if (r7.canScrollHorizontally(-1) == true) goto L9;
        r2 = true;
        goto L10
    }
}
