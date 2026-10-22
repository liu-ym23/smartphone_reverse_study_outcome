package com.bytedance.android.livesdk.livecommerce.event;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m1 extends u0 {
    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final ECEventV3 g(Map r1) {
        super.g(r1);
        return this;
    }

    public final void o(Map r1) {
        super.g(r1);
    }

    public m1(String r2, String r3, String r4, String r5, RoomContextController r6) {
        super(r6, "livesdk_product_entrance_click");
        f("anchor_id", r2);
        f("room_id", r3);
        if (TextUtils.equals(r5, "not_report") == true) goto L5;
        f("click_area", r5);
    L5:
        f("ecom_entrance_form", r4);
    }

    public final void p(String r1, String r2, String r3, Map r4, Map r5) {
        super.g(r4);
        super.g(r5);
        f("commodity_id", r1);
        f("commodity_type", r2);
        f("product_id", r3);
    }
}
