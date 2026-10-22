package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i1 extends u0 {

    public static final class a {
    }

    static {
    }

    public i1(ECUIPromotion r7, RoomContextController r8) {
        super(r8, "livesdk_show_product_info");
        String r1 = l0.j("room_id", r8);
        String r2 = l0.i("room_unique_key");
        f("enter_method", l0.j("enter_method", r8));
        f("anchor_id", l0.j("anchor_id", r8));
        f("room_id", r1);
        f("action_type", l0.j("action_type", r8));
        f("request_id", l0.j("request_id", r8));
        f("enter_from_merge", l0.j("enter_from_merge", r8));
        f("follow_status", l0.j("follow_status", r8));
        f("screen_type", l0.m(r1, r2));
        f("group_id", l0.j("group_id", r8));
        f("ecom_group_type", l0.j("group_type", r8));
        f("enter_from", "live");
        f("EVENT_ORIGIN_FEATURE", "TEMAI");
        f("click_method", l0.j("click_method", r8));
        if (r7 == null) goto L15;
        g(r7.getEventParams());
        f("product_id", r7.getProductId());
        if (r7.isOnExplain() == false) goto L7;
        String r9 = "1";
    L8:
        f("is_explaining", r9);
        int r3 = 1;
        d("with_sku", !r7.getSingleSku() ? 1 : 0);
        d("local_num", r7.getLocalNum());
        ECUIAskExplainInfo r10 = r7.getAskExplainInfo();
        if (r10 != null) goto L11;
    L13:
        r3 = 0;
    L14:
        d("is_explain_apply", r3);
        goto L15
    L11:
        if (r10.isAsked() != true) goto L13;
    L7:
        r9 = BDLocationException.ERROR_TIMEOUT;
    L15:
        k0 r11 = this.c;
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.g("source_page").booleanValue() == true) goto L25;
        String r0 = r11.f("enter_from_merge");
        String r12 = r11.f("enter_method");
        if (r0 == null) goto L26;
        if (r12 == null) goto L27;
        f("source_page", r0 + "_temai_" + r12);
        return;
    L27:
        return;
    L26:
        return;
    }
}
