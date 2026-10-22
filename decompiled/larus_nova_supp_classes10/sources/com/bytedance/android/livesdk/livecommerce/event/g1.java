package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g1 extends u0 {
    public g1() {
        this(null);
    }

    public g1(String r5) {
        super(r5);
        String r0 = l0.i("room_id");
        String r1 = l0.i("room_unique_key");
        f("enter_method", l0.e());
        f("anchor_id", l0.i("anchor_id"));
        f("room_id", r0);
        f("action_type", l0.i("action_type"));
        f("request_id", l0.i("request_id"));
        f("enter_from_merge", l0.i("enter_from_merge"));
        f("follow_status", l0.i("follow_status"));
        f("screen_type", l0.m(r0, r1));
        f("group_id", l0.i("group_id"));
        f("ecom_group_type", l0.i("group_type"));
        f("enter_from", "live");
        f("EVENT_ORIGIN_FEATURE", "TEMAI");
    }
}
