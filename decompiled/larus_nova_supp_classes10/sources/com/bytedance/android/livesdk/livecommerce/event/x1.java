package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x1 extends ECEventV3 {
    public x1(String r2, String r3, String r4, int r5, boolean r6) {
        super("livesdk_send_coupons");
        f("coupon_id", r2);
        f("anchor_id", r3);
        f("room_id", r4);
        d("coupon_type", r5);
        d("fans_coupon", r6 ? 1 : 0);
    }
}
