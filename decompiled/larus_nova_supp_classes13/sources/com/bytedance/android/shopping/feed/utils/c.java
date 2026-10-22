package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionGroupBuyPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionIPActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSeckillPrice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static PromotionDiscountPrice b(PromotionProductPriceStruct r7) {
        if (r7 == null) goto L6;
        PromotionDiscountPrice r8 = r7.getDiscountPrice();
        if (r8 == null) goto L6;
        return r8;
    L6:
        return new PromotionDiscountPrice(null, null, null, null, 15, null);
    }

    public static Long c(PromotionProductPriceStruct r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getRegularPrice();
    }

    public static Long d(PromotionProductPriceStruct r7) {
        Long r0 = c(r7);
        Long r1 = b(r7).getMinPrice();
        Long r8 = e(r7);
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        if (r1 != null) goto L10;
    L14:
        if (r8 != null) goto L16;
        return r0;
    L16:
        if (r8.longValue() <= 0) goto L22;
        if (r0 == null) goto L20;
        r8 = Long.valueOf(Math.min(r0.longValue(), r8.longValue()));
    L20:
        return r8;
    L22:
        return r0;
    L10:
        if (r1.longValue() <= 0) goto L14;
        if (r0 == null) goto L13;
        r1 = Long.valueOf(Math.min(r1.longValue(), r0.longValue()));
    L13:
        r0 = r1;
        goto L14
    L5:
        if (r0.longValue() <= 0) goto L7;
        goto L7
    }

    public static Long e(PromotionProductPriceStruct r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getMinPrice();
    }

    public static long f(PromotionProductPriceStruct r2) {
        Long r0 = null;
        if (r2 == null) goto L7;
        PromotionDiscountPrice r1 = r2.getDiscountPrice();
        if (r1 == null) goto L7;
        Long r3 = r1.getMinPrice();
    L8:
        if (r3 == null) goto L13;
        if (r2 == null) goto L15;
        PromotionDiscountPrice r4 = r2.getDiscountPrice();
        if (r4 == null) goto L15;
        r0 = r4.getMinPrice();
    L15:
        if (r0 != null) goto L19;
        return 0;
    L19:
        return r0.longValue();
    L13:
        if (r2 == null) goto L15;
        r0 = r2.getMinPrice();
    L7:
        r3 = null;
        goto L8
    }

    public static long g(PromotionProductPriceStruct r2) {
        if (r2 == null) goto L8;
        PromotionDiscountPrice r3 = r2.getDiscountPrice();
        if (r3 == null) goto L8;
        Long r4 = r3.getMaxPrice();
        if (r4 == null) goto L8;
        return r4.longValue();
    L8:
        return 0;
    }

    public static long j(PromotionProductPriceStruct r2) {
        if (r2 == null) goto L8;
        PromotionDiscountPrice r3 = r2.getDiscountPrice();
        if (r3 == null) goto L8;
        Long r4 = r3.getMinPrice();
        if (r4 == null) goto L8;
        return r4.longValue();
    L8:
        return 0;
    }

    public static long k(PromotionProductPriceStruct r2) {
        Long r0 = null;
        if (r2 == null) goto L5;
        Long r1 = r2.getRegularPrice();
    L6:
        if (r1 == null) goto L9;
        if (r2 == null) goto L11;
        r0 = r2.getRegularPrice();
    L11:
        if (r0 != null) goto L15;
        return 0;
    L15:
        return r0.longValue();
    L9:
        if (r2 == null) goto L11;
        r0 = r2.getMinPrice();
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ Long i(PromotionProductPriceStruct r2, int r3) {
        return h(r2, r3, false, null, false);
    }

    public static Long h(PromotionProductPriceStruct r2, int r3, boolean r4, PromotionIPActivity r5, boolean r6) {
        if (r3 != 1) goto L12;
        if (r4 == false) goto L12;
        if (r5 == null) goto L7;
        if (r6 == false) goto L12;
    L7:
        if (r2 == null) goto L15;
        PromotionSeckillPrice r7 = r2.getSeckillPrice();
        if (r7 != null) goto L11;
        return null;
    L11:
        return r7.getSeckillMinPrice();
    L15:
        return null;
    L12:
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.getMinPrice();
    }

    public static Long a(PromotionProductPriceStruct r1, int r2, boolean r3, boolean r4, PromotionIPActivity r5, int r6) {
        if ((r6 & 8) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 16) == 0) goto L9;
        r5 = null;
    L9:
        if (r2 != 1) goto L18;
        if (r4 == false) goto L18;
        if (r5 != null) goto L18;
        if (r1 == null) goto L27;
        PromotionSeckillPrice r7 = r1.getSeckillPrice();
        if (r7 != null) goto L29;
        return null;
    L29:
        return r7.getSeckillMaxPrice();
    L27:
        return null;
    L18:
        if (r2 != 6) goto L24;
        if (r3 == false) goto L24;
        if (r1 == null) goto L30;
        PromotionGroupBuyPrice r8 = r1.getGroupBuyPrice();
        if (r8 != null) goto L32;
        return null;
    L32:
        return r8.getOriginMaxPrice();
    L30:
        return null;
    L24:
        if (r1 != null) goto L26;
        return null;
    L26:
        return r1.getMaxPrice();
    }
}
