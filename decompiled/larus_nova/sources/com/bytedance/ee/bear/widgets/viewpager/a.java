package com.bytedance.ee.bear.widgets.viewpager;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DampLayout.b f240424a;

    public a(DampLayout.b r100) {
        this.f240424a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = ((Float) this.f240424a.getAnimatedValue()).floatValue();
        this.f240424a.f240363b.scrollTo(0, (int) r101);
        if (this.f240424a.f240363b.getScrollY() <= 0) goto L10;
        if (this.f240424a.f240362a.canScrollVertically(-1) == true) goto L10;
        if (this.f240424a.f240362a.canScrollVertically(1) == false) goto L10;
        this.f240424a.f240363b.scrollTo(0, 0);
    L10:
        if (this.f240424a.f240363b.getScrollY() < 0) goto L12;
        return;
    L12:
        if (this.f240424a.f240362a.canScrollVertically(1) == false) goto L14;
        return;
    L14:
        if (this.f240424a.f240362a.canScrollVertically(-1) == false) goto L19;
        this.f240424a.f240363b.scrollTo(0, 0);
        return;
    }
}
