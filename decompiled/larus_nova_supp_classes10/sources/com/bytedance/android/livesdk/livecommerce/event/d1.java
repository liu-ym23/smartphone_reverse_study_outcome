package com.bytedance.android.livesdk.livecommerce.event;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d1 extends ECEventV3 {
    public d1(Map<String, String> r3, int r4, int r5, String r6, String r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        super("livesdk_ecom_entrance_show_status");
        Iterator<Map.Entry<String, String>> r14 = r3.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r14.next();
        f(r0.getKey(), r0.getValue());
        goto L4
    L6:
        d("anchor_with_commerce_permission", r4);
        d("has_commerce_goods", r5);
        f("ecom_entrance_show_status", r6);
        f("extra_message", r7);
        d("report_when_enter", r8);
        d("room_cart_valid", r9);
        d("room_cart_show_cart", r10);
        d("request_live_promotions", r11);
        d("request_has_goods", r12);
        d("request_show_cart", r13);
    }
}
