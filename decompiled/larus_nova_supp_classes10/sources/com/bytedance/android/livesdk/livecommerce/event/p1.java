package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p1 extends ECEventV3 {
    public p1(String r3, String r4, String r5, String r6, long r7) {
        super("livesdk_product_explain_duration");
        this.c.c("room_id", r3);
        this.c.c("anchor_id", r4);
        this.c.c("commodity_id", r5);
        this.c.c("commodity_type", r6);
        this.c.b("duration", r7);
    }
}
