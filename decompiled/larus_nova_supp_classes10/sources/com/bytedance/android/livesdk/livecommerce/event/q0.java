package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q0 extends ECEventV3 {
    public q0(String r2, String r3) {
        super("livesdk_show_guide_bubble");
        f("room_id", r2);
        f("anchor_id", r3);
        f("page_name", "within_live");
        f("bubble_type", "coupon_detail");
    }
}
