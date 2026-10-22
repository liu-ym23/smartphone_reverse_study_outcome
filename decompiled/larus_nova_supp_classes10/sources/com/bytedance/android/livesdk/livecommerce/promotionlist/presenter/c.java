package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;

    public c(b r1, View r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L11;
        float r5 = ((Float) r4).floatValue();
        this.b.setAlpha(r5);
        if (this.c == 0) goto L7;
        return;
    L7:
        if (this.a.s == false) goto L13;
        this.b.setTranslationY((1 - r5) * UtilityKotlinExtentionsKt.c(40));
        return;
    L13:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
