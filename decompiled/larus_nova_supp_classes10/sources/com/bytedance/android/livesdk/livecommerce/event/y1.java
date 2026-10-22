package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y1 extends u0 {
    public y1(RoomContextController r2) {
        super(r2, "livesdk_popup_card_show_duration");
        f("page_name", "live_list");
        f("source_page", l0.n());
        f("anchor_id", l0.i("anchor_id"));
        f("group_id", l0.i("group_id"));
        f("carrier_source", l0.d());
        f("source_method", l0.e());
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f("room_id", l0.i("room_id"));
    }
}
