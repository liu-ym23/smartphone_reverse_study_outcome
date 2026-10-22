package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ ExplainProductCardWithBuyButtonView a;
    public final /* synthetic */ Function0 b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.g.setVisibility(8);
        Function0 r3 = this.b;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke();
        return;
    }

    public d(ExplainProductCardWithBuyButtonView r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
