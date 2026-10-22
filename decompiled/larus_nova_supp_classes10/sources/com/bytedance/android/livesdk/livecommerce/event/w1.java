package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w1 extends ECEventV3 {
    public w1(String r2, String r3, String r4, int r5, long r6) {
        super("livesdk_send_coupons_duration");
        f("coupon_id", r2);
        f("anchor_id", r3);
        f("room_id", r4);
        d("coupon_type", r5);
        f("duration", String.valueOf(r6));
        f(LocationMonitorConst.TYPE, "stop");
    }
}
