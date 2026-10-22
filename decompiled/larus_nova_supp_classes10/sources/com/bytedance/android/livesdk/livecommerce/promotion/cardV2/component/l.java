package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import com.bytedance.android.ec.model.response.PriceDescriptionType;
import com.bytedance.android.ec.model.response.PromotionPriceType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PriceDescriptionType.values().length];
        a = r0;
        r0[PriceDescriptionType.TEXT.ordinal()] = 1;
        r0[PriceDescriptionType.REGULAR_PRICE.ordinal()] = 2;
        r0[PriceDescriptionType.EXCLUSIVE.ordinal()] = 3;
        int[] r1 = new int[PromotionPriceType.values().length];
        b = r1;
        r1[PromotionPriceType.SHOW_PRICE.ordinal()] = 1;
        r1[PromotionPriceType.COUNT_DOWN.ordinal()] = 2;
        r1[PromotionPriceType.SHOW_TEXT.ordinal()] = 3;
    }
}
