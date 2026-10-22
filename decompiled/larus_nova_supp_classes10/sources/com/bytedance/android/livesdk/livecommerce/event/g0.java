package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 extends u0 {
    public g0(String r2, gi2.a r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
        f("source_page", l0.n());
        f("ecom_entrance_form", "live_list_card");
        f("anchor_id", l0.i("anchor_id"));
        f("group_id", l0.i("group_id"));
        f("carrier_source", l0.d());
        f("source_method", l0.e());
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f("room_id", l0.i("room_id"));
        f("action_type", l0.i("action_type"));
        f("request_id", l0.i("request_id"));
        f("screen_type", l0.m(null, null));
        if (r3 == null) goto L18;
        Function0<LivePromotionPageRoomInfo> r4 = r3.e;
        if (r4 == null) goto L19;
        LivePromotionPageRoomInfo r5 = (LivePromotionPageRoomInfo) r4.invoke();
        if (r5 == null) goto L20;
        f("room_type", String.valueOf(r5.getRoomType()));
        f("instant_room_type", String.valueOf(r5.getInstantRoomType()));
        String r6 = r5.getReceiveAddressId();
        if (r6 == null) goto L11;
        f("receive_address_id", r6);
    L11:
        String r7 = r5.getAddressType();
        if (r7 == null) goto L14;
        f("address_type", r7);
    L14:
        String r8 = r5.getAddressStrategy();
        if (r8 == null) goto L21;
        f("address_strategy_type", r8);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
