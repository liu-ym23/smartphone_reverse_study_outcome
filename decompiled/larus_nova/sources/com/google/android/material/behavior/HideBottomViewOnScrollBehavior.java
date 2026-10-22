package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes23.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    protected static final int ENTER_ANIMATION_DURATION = 225;
    protected static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private int height;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104) {
        if (r104 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public HideBottomViewOnScrollBehavior() {
        this.height = 0;
        this.currentState = 2;
    }

    public void slideDown(V r100) {
        ViewPropertyAnimator r101 = this.currentAnimator;
        if (r101 == null) goto L5;
        r101.cancel();
        r100.clearAnimation();
    L5:
        this.currentState = 1;
        animateChildTo(r100, this.height, 175, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    }

    public void slideUp(V r100) {
        ViewPropertyAnimator r101 = this.currentAnimator;
        if (r101 == null) goto L5;
        r101.cancel();
        r100.clearAnimation();
    L5:
        this.currentState = 2;
        animateChildTo(r100, 0, 225, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    public HideBottomViewOnScrollBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.height = 0;
        this.currentState = 2;
    }

    public static /* synthetic */ ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior r100, ViewPropertyAnimator r101) {
        r100.currentAnimator = r101;
        return r101;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        this.height = r101.getMeasuredHeight();
        return super.onLayoutChild(r100, r101, r102);
    }

    private void animateChildTo(V r100, int r101, long r102, TimeInterpolator r103) {
        this.currentAnimator = r100.animate().translationY(r101).setInterpolator(r103).setDuration(r102).setListener(new AnonymousClass1(this));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106) {
        int r107 = this.currentState;
        if (r107 == 1) goto L7;
        if (r104 <= 0) goto L7;
        slideDown(r101);
        return;
    L7:
        if (r107 == 2) goto L12;
        if (r104 >= 0) goto L13;
        slideUp(r101);
        return;
    L13:
        return;
    }
}
