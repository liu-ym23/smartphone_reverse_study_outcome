package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e2 extends ECEventV3 {
    public e2() {
        super("livesdk_influence_entrance_show");
        f("anchor_id", l0.i("anchor_id"));
        f("room_id", l0.i("room_id"));
        f("follow_status", l0.f());
        f("group_id", l0.i("group_id"));
        f("enter_from", "live");
        f("enter_method", l0.e());
        f("enter_from_merge", l0.d());
    }
}
