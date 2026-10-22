package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2$containerAbility$1$eventAction$1;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends AnimatorListenerAdapter {
    public final /* synthetic */ PromotionCardImageComponent a;

    public i(PromotionCardImageComponent r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        PromotionCardImageComponent r4 = this.a;
        r4.u = false;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r5 = r4.b;
        if (r5 == null) goto L7;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r6 = r5.b();
        if (r6 == null) goto L7;
        r6.a(MapsKt.mapOf(TuplesKt.to("seen_cover_animation_icon", "1")));
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r7 = this.a.b;
        if (r7 == null) goto L13;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r8 = r7.b();
        if (r8 == null) goto L14;
        r8.f();
        return;
    L14:
        return;
    }
}
