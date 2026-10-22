package com.bytedance.android.livesdk.livecommerce.utils;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r0 extends a1 {
    public final int c;

    public r0(int r3, long r4) {
        super("msg");
        this.c = r3;
        JSONObject r0 = this.a;
        r0.put("msg_type", r3);
        r0.put("msg_id", r4);
    }
}
