package com.bytedance.ee.bear.widgets.viewpager;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DampLayout.b a;

    public a(DampLayout.b r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        float r5 = ((Float) this.a.getAnimatedValue()).floatValue();
        this.a.b.scrollTo(0, (int) r5);
        if (this.a.b.getScrollY() <= 0) goto L10;
        if (this.a.a.canScrollVertically(-1) == true) goto L10;
        if (this.a.a.canScrollVertically(1) == false) goto L10;
        this.a.b.scrollTo(0, 0);
    L10:
        if (this.a.b.getScrollY() < 0) goto L12;
        return;
    L12:
        if (this.a.a.canScrollVertically(1) == false) goto L14;
        return;
    L14:
        if (this.a.a.canScrollVertically(-1) == false) goto L19;
        this.a.b.scrollTo(0, 0);
        return;
    }
}
