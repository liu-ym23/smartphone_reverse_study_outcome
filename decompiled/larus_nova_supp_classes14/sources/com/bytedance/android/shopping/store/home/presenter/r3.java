package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;
    public final /* synthetic */ Animator.AnimatorListener b;

    public r3(ECShopTopMarqueeUDSlidePresenter r1, Animator.AnimatorListener r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.getAnimatedValue();
    L7:
        if ((r4 instanceof Integer) == false) goto L10;
        r0 = r4;
    L10:
        Integer r1 = (Integer) r0;
        if (r1 == null) goto L16;
        int r5 = r1.intValue();
        View r2 = this.a.u;
        if (r2 == null) goto L17;
        wg.a.f(r2, 0, r5, 0, 0);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
