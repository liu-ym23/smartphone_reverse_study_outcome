package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiCoverCoordinatorLayout extends CoordinatorLayout {
    public b a;
    public a b;
    public float c;

    public interface a {
    }

    public interface b {
    }

    public WikiCoverCoordinatorLayout(Context r1) {
        super(r1);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        boolean r1 = false;
        if (r0 != 0) goto L5;
        r4.getX();
        this.c = r4.getY();
        a r2 = this.b;
        if (r2 == null) goto L14;
        r1 = ((h) r2).a(r4);
    L14:
        if (r1 == false) goto L18;
        return true;
    L18:
        return super.onInterceptTouchEvent(r4);
    L5:
        if (r0 != 2) goto L14;
        a r3 = this.b;
        if (r3 == null) goto L10;
        r1 = ((h) r3).a(r4);
    L10:
        r4.getX();
        this.c = r4.getY();
        goto L14
    }

    public final boolean onTouchEvent(MotionEvent r7) {
        int r0 = r7.getAction();
        if (r0 == 1) goto L21;
        if (r0 != 2) goto L6;
        b r1 = this.a;
        if (r1 == null) goto L20;
        r7.getX();
        float r2 = r7.getY() - this.c;
        k r3 = (k) r1;
        CollapsingToolbarLayout.LayoutParams r4 = r3.a.e.getLayoutParams();
        if (r2 <= r3.a.h.getScaledTouchSlop()) goto L15;
    L16:
        int r5 = (int) (((FrameLayout.LayoutParams) r4).height + (r2 / 2.0f));
        ((FrameLayout.LayoutParams) r4).height = r5;
        l r6 = r3.a;
        int r8 = r6.j;
        if (r5 >= r8) goto L19;
        ((FrameLayout.LayoutParams) r4).height = r8;
    L19:
        r6.e.requestLayout();
        goto L20
    L15:
        if (((FrameLayout.LayoutParams) r4).height > r3.a.j) goto L16;
    L20:
        r7.getX();
        this.c = r7.getY();
    L26:
        return true;
    L6:
        if (r0 == 3) goto L21;
        if (r0 != 4) goto L26;
    L21:
        b r9 = this.a;
        if (r9 == null) goto L26;
        final k r10 = (k) r9;
        final CollapsingToolbarLayout.LayoutParams r11 = r10.a.e.getLayoutParams();
        int r12 = ((FrameLayout.LayoutParams) r11).height;
        int r13 = r10.a.j;
        if (r12 <= r13) goto L26;
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{r12, r13}).setDuration(200);
        r14.addUpdateListener(new j(r10, r11));
        r14.setInterpolator(new DecelerateInterpolator());
        r14.start();
        goto L26
    }

    public void setInterceptTouchEventListener(a r1) {
        this.b = r1;
    }

    public void setOnScrollListener(b r1) {
        this.a = r1;
    }

    public WikiCoverCoordinatorLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public WikiCoverCoordinatorLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
