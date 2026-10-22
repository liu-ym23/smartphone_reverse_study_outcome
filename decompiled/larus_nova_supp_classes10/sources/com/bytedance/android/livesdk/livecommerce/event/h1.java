package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h1 extends ECEventV3 {
    public h1(String r2, String r3, String r4, int r5) {
        super("livesdk_present_coupon");
        f("room_id", r2);
        f("coupon_id", r3);
        f("shop_id", r4);
        f("self_shop", String.valueOf(r5));
    }
}
