package com.bytedance.android.livesdk.livecommerce.utils;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z0 extends a1 {
    public final boolean c;

    public z0(boolean r3, boolean r4) {
        super("toolbar");
        this.c = r3;
        JSONObject r0 = this.a;
        if (r3 == false) goto L5;
        String r5 = "show";
    L6:
        r0.put("callback_type", r5);
        r0.put("on_enter", r4 ? 1 : 0);
        return;
    L5:
        r5 = "hide";
        goto L6
    }
}
