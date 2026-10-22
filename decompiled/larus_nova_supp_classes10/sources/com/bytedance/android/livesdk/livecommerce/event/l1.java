package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l1 extends ECEventV3 {
    public l1(String r3, String r4, long r5) {
        super("livesdk_product_card_time");
        this.c.c("anchor_id", r3);
        this.c.c("room_id", r4);
        this.c.b("duration", r5);
    }
}
