package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Animatable;
import com.facebook.drawee.interfaces.DraweeController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ PromotionCardImageComponent a;

    public e(PromotionCardImageComponent r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        DraweeController r3 = this.a.y.getController();
        if (r3 == null) goto L8;
        Animatable r4 = r3.getAnimatable();
        if (r4 == null) goto L9;
        r4.start();
        return;
    L9:
        return;
    }
}
