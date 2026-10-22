package com.bytedance.android.livesdk.livecommerce.dynamic.compose.router;

import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.j;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionItemComponentUIConfig {
    static {
    }

    public static void a(com.bytedance.android.livesdk.livecommerce.promotion.card.b r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionCard");
        final PromotionItemComponentUIConfig$updateUI$1 r0 = new PromotionItemComponentUIConfig$updateUI$1(r4);
        r3.w2(new j(((k) IPromotionUIConfig.a.getValue()).a).a(PromotionCardModuleName.InfoAreaModule, new PromotionItemComponentUIConfig$updateUI$2(r0)).a(PromotionCardModuleName.BottomModule, new PromotionItemComponentUIConfig$updateUI$3(r0)).a(PromotionCardModuleName.ImageAreaBottomTip, new PromotionItemComponentUIConfig$updateUI$4(r0)).a(PromotionCardModuleName.Parent, PromotionItemComponentUIConfig$updateUI$5.INSTANCE).a);
    }
}
