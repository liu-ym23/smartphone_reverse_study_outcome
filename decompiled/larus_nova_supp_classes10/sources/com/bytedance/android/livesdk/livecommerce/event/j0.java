package com.bytedance.android.livesdk.livecommerce.event;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0 extends ECEventV3 {

    public static final class a {
    }

    static {
    }

    public j0(String r5) {
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

    public final void n(Map r3) {
        if (r3 == null) goto L7;
        Iterator r4 = r3.entrySet().iterator();
    L5:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) r4.next();
        f((String) r0.getKey(), (String) r0.getValue());
        goto L5
    L9:
        return;
    }
}
