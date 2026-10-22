package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s0 extends u0 {

    public static final class a {
    }

    static {
    }

    public s0(String r3, RoomContextController r4) {
        Intrinsics.checkNotNullParameter("live_popup_card", "carrierType");
        super(r4, "livesdk_show_".concat(r3));
        f("room_id", l0.i("room_id"));
        f("anchor_id", l0.i("anchor_id"));
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f("ecom_group_type", l0.i("ecom_group_type"));
        f("action_type", l0.i("action_type"));
        f("label_type", "label");
        f("ecom_entrance_form", "live_popup_card");
    }
}
