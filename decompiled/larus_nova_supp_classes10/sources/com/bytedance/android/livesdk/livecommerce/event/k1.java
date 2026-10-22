package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k1 extends ECEventV3 {
    public k1(String r3, String r4) {
        super("livesdk_product_card_stop");
        this.c.c("anchor_id", r3);
        this.c.c("room_id", r4);
    }
}
