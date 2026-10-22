package com.bytedance.android.shopping.store.router.hybridpage.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public c(View r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Float) == true) goto L5;
        r3 = null;
    L5:
        Float r4 = (Float) r3;
        if (r4 == null) goto L9;
        float r5 = r4.floatValue();
        this.a.setAlpha(r5);
        return;
    }
}
