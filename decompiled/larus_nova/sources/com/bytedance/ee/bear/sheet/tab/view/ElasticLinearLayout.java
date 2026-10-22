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

/* JADX INFO: loaded from: classes18.dex */
public class ElasticLinearLayout extends LinearLayout implements NestedScrollingParent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f238382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f238383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f238384c;

    public class a extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f238385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ElasticLinearLayout f238386b;

        public a(ElasticLinearLayout r100) {
            this.f238386b = r100;
            this.f238385a = 1.0f;
            r100.f238383b = true;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            float r102 = ((this.f238385a - 0.0f) * r100) + 0.0f;
            ElasticLinearLayout r103 = this.f238386b;
            r103.scrollBy((int) ((0 - r103.getScrollX()) * r102), 0);
            if (r102 != 1.0f) goto L6;
            this.f238386b.f238383b = false;
            return;
        }

        @Override // android.view.animation.Animation
        public final void initialize(int r100, int r101, int r102, int r103) {
            super.initialize(r100, r101, r102, r103);
            setDuration(260);
            setInterpolator(new AccelerateInterpolator());
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
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
        this.f238382a = getChildAt(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        if (this.f238384c != null) goto L5;
        this.f238384c = new a(this);
    L5:
        startAnimation(this.f238384c);
    }

    public ElasticLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        setOrientation(0);
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        if (r100 <= 600) goto L5;
        r100 = 600;
    L5:
        super.scrollTo(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (getScrollX() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if ((r101 instanceof RecyclerView) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f238383b == true) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (r101 > 0) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r101 < 0) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r101 < 0) goto L17;
    L21:
        boolean r105 = false;
    L22:
        if (r101 > 0) goto L24;
    L26:
        boolean r106 = false;
    L27:
        if (r103 == true) goto L31;
        if (r104 == true) goto L31;
        if (r105 == true) goto L31;
        if (r106 == true) goto L31;
    L32:
        if (r101 > 0) goto L34;
    L38:
        if (r101 < 0) goto L40;
        return;
    L40:
        if (getScrollX() < 0) goto L42;
        return;
    L42:
        if (r100.canScrollHorizontally(1) == true) goto L47;
        scrollTo(0, 0);
        return;
    L47:
        return;
    L34:
        if (getScrollX() <= 0) goto L38;
        if (r100.canScrollHorizontally(-1) == true) goto L38;
        scrollTo(0, 0);
    L31:
        scrollBy(r101 / 3, 0);
        r110[0] = r101;
        goto L32
    L24:
        if (r100.canScrollHorizontally(1) == true) goto L26;
        r106 = true;
        goto L27
    L17:
        if (getScrollX() <= 0) goto L21;
        if (r100.canScrollHorizontally(1) == true) goto L21;
        r105 = true;
        goto L22
    L12:
        if (r100.canScrollHorizontally(-1) == true) goto L14;
        r104 = true;
        goto L15
    L5:
        if (getScrollX() >= 0) goto L9;
        if (r100.canScrollHorizontally(-1) == true) goto L9;
        r103 = true;
        goto L10
    }
}
