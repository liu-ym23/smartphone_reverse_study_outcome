package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o1 extends ECEventV3 {
    public o1(String r3, String r4, String r5, long r6) {
        super("livesdk_product_entrance_time");
        this.c.c("anchor_id", r3);
        this.c.c("room_id", r4);
        this.c.c("follow_status", r5);
        this.c.b("duration", r6);
    }
}
