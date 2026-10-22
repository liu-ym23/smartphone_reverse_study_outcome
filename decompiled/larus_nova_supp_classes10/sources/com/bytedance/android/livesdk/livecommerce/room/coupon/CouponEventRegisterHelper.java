package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CouponEventRegisterHelper {
    public static boolean a;

    public static void a() {
        if (a == false) goto L5;
        return;
    L5:
        a = true;
        ECLiveHybridUtil.m("ecom.coupon.short_touch_coupon_msg", new c(CouponEventRegisterHelper$registerSubscriber$1.INSTANCE));
    }

    static {
    }
}
