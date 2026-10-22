package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget.PromotionCardGuideView;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends QPresenter {
    public boolean e;
    public com.bytedance.android.livesdk.livecommerce.promotion.card.h f;
    public final LivePromotionCardArgsV2 g;

    public final void C() {
    }

    public h(LivePromotionCardArgsV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.g = r2;
    }

    public final void A(QModel r6) {
        Object r1 = null;
        if ((r6 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.h) == true) goto L5;
        r6 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r7 = (com.bytedance.android.livesdk.livecommerce.promotion.card.h) r6;
        if (r7 != null) goto L8;
        return;
    L8:
        if (this.e == true) goto L11;
        this.e = true;
        ((PromotionCardGuideView) w().b(2131377866).f()).setArgument(this.g);
    L11:
        this.f = r7;
        PromotionCardGuideView r8 = (PromotionCardGuideView) w().b(2131377866).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r0 = this.f;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L14:
        r8.f(r0.a, new PromotionCardRootPresenter$updateGuideArea$1(this));
        LottieAnimationView r9 = (ECLottieAnimationView) w().b(2131375663).f();
        ILivePromotionCardContainerHandler r2 = this.g.b;
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r4 = this.f;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L18:
        if (r2.i(r4.a.a, 1, false) == false) goto L32;
        List r3 = (List) this.g.b.n(ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackgroundRadius, Reflection.getOrCreateKotlinClass(List.class), null);
        if (r3 == null) goto L22;
        Object r5 = CollectionsKt.firstOrNull(r3);
    L24:
        if ((r5 instanceof Integer) == false) goto L27;
        r1 = r5;
    L27:
        Integer r10 = (Integer) r1;
        if (r10 == null) goto L30;
        int r11 = r10.intValue();
    L31:
        float r12 = r11;
        ViewExtensionsKt.g(r9, r12, r12, r12, r12);
        r9.setVisibility(0);
        r9.setAnimation("ec_live_list_card_enhance_effect.json");
        r9.setRepeatCount(0);
        r9.playAnimation();
        r9.postDelayed(new g(this), SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS);
    L33:
        UpdateType r13 = UpdateType.UPDATE_ALL;
        return;
    L30:
        r11 = 16;
        goto L31
    L22:
        r5 = null;
        goto L24
    L32:
        r9.setVisibility(8);
        goto L33
    }
}
