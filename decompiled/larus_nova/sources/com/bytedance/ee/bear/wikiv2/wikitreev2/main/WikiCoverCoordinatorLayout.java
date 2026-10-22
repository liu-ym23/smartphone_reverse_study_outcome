package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* JADX INFO: loaded from: classes18.dex */
public class WikiCoverCoordinatorLayout extends CoordinatorLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f241486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f241487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f241488c;

    public interface a {
    }

    public interface b {
    }

    public WikiCoverCoordinatorLayout(Context r100) {
        super(r100);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 != 0) goto L5;
        r100.getX();
        this.f241488c = r100.getY();
        a r103 = this.f241487b;
        if (r103 == null) goto L14;
        r102 = ((h) r103).a(r100);
    L14:
        if (r102 == false) goto L18;
        return true;
    L18:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 2) goto L14;
        a r104 = this.f241487b;
        if (r104 == null) goto L10;
        r102 = ((h) r104).a(r100);
    L10:
        r100.getX();
        this.f241488c = r100.getY();
        goto L14
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 1) goto L21;
        if (r101 != 2) goto L6;
        b r102 = this.f241486a;
        if (r102 == null) goto L20;
        r100.getX();
        float r103 = r100.getY() - this.f241488c;
        k r104 = (k) r102;
        CollapsingToolbarLayout.LayoutParams r105 = (CollapsingToolbarLayout.LayoutParams) r104.f241566a.f241571e.getLayoutParams();
        if (r103 <= r104.f241566a.f241574h.getScaledTouchSlop()) goto L15;
    L16:
        int r106 = (int) (((FrameLayout.LayoutParams) r105).height + (r103 / 2.0f));
        ((FrameLayout.LayoutParams) r105).height = r106;
        l r107 = r104.f241566a;
        int r108 = r107.f241576j;
        if (r106 >= r108) goto L19;
        ((FrameLayout.LayoutParams) r105).height = r108;
    L19:
        r107.f241571e.requestLayout();
        goto L20
    L15:
        if (((FrameLayout.LayoutParams) r105).height > r104.f241566a.f241576j) goto L16;
    L20:
        r100.getX();
        this.f241488c = r100.getY();
    L26:
        return true;
    L6:
        if (r101 == 3) goto L21;
        if (r101 != 4) goto L26;
    L21:
        b r109 = this.f241486a;
        if (r109 == null) goto L26;
        final k r110 = (k) r109;
        final CollapsingToolbarLayout.LayoutParams r111 = (CollapsingToolbarLayout.LayoutParams) r110.f241566a.f241571e.getLayoutParams();
        int r112 = ((FrameLayout.LayoutParams) r111).height;
        int r113 = r110.f241566a.f241576j;
        if (r112 <= r113) goto L26;
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r112, r113}).setDuration(200);
        r114.addUpdateListener(new j(r110, r111));
        r114.setInterpolator(new DecelerateInterpolator());
        r114.start();
        goto L26
    }

    public void setInterceptTouchEventListener(a r100) {
        this.f241487b = r100;
    }

    public void setOnScrollListener(b r100) {
        this.f241486a = r100;
    }

    public WikiCoverCoordinatorLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public WikiCoverCoordinatorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
