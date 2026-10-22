package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q implements ml.b {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;

    public final String c() {
        return this.a.optString("broadcast_id");
    }

    public final String d() {
        return this.a.optString("broadcast_sec_id");
    }

    public final String roomId() {
        String r0 = this.a.optString("room_id");
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return this.b;
    L5:
        r1 = false;
        goto L6
    }

    public q(JSONObject r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
