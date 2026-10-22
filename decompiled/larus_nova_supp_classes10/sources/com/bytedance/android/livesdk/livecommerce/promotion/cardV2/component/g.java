package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PromotionCardImageComponent a;

    public g(PromotionCardImageComponent r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        TextView r0 = this.a.g;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        PromotionCardImageComponent.e(r0, ((Integer) r3).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
