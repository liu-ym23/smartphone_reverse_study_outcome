package com.bytedance.android.shopping.monitor;

import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GuessULikeResponseDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(GuessULikeResponseDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        PromotionLogPbData r0 = r2.getLogPb();
        if (r0 == null) goto L5;
        String r1 = r0.getImprId();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        List r3 = r2.getProductList();
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L18;
        com.bytedance.android.ec.core.monitor.d.a("/aweme/v2/commerce/favorite/feed/", r1, "item_cards");
        return;
    L18:
        return;
    L11:
        if (r3.isEmpty() == true) goto L14;
        r4 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public static void b(PromotionPackResponse r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        PromotionLogPbData r0 = r4.getLogPb();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getImprId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        List r3 = r4.getPromotions();
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        com.bytedance.android.ec.core.monitor.d.a("/shop/promotion/pack/", r2, "promotions");
        return;
    L18:
        List r6 = r4.getPromotions();
        if (r6 == null) goto L23;
        PromotionProductStruct r7 = (PromotionProductStruct) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L23;
        PromotionProductPriceStruct r8 = r7.getProductPrice();
    L24:
        if (r8 != null) goto L26;
        com.bytedance.android.ec.core.monitor.d.a("/shop/promotion/pack/", r2, "promotions[0].product_price");
    L26:
        List r9 = r4.getPromotions();
        if (r9 == null) goto L33;
        PromotionProductStruct r10 = (PromotionProductStruct) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L33;
        PromotionProductBaseStruct r11 = r10.getBaseInfo();
        if (r11 == null) goto L33;
        r1 = r11.getProductId();
    L33:
        if (r1 != null) goto L37;
        com.bytedance.android.ec.core.monitor.d.a("/shop/promotion/pack/", r2, "promotions[0].base_info.product_id");
        return;
    L37:
        return;
    L23:
        r8 = null;
        goto L24
    L11:
        if (r3.isEmpty() == true) goto L14;
        r5 = false;
        goto L16
    L5:
        r2 = null;
        goto L6
    }
}
