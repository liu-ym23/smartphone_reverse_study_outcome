package com.bytedance.android.livesdk.log;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 extends com.bytedance.android.live.core.log.g {
    public static b0 a;

    public static synchronized b0 o() {
        monitor-enter(b0.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new b0();     // Catch: Throwable -> L10
    L7:
        b0 r1 = a;     // Catch: Throwable -> L10
        monitor-exit(b0.class);
        return r1;
    }

    public final JSONObject h() {
        JSONObject r0 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(IRoom.class);
        String r5 = "";
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L12;
        com.bytedance.android.livesdk.log.filter.u r2 = (com.bytedance.android.livesdk.log.filter.u) r1;
        if (r2.getMap().containsKey("room_id") == false) goto L7;
        String r3 = r2.getMap().get("room_id");
    L9:
        if (r2.getMap().containsKey("anchor_id") == false) goto L11;
        r5 = r2.getMap().get("anchor_id");
    L11:
        String r7 = r5;
        r5 = r2.n();
        String r4 = r7;
    L18:
        r0.put("user_id", r5);     // Catch: JSONException -> L15
        r0.put("room_id", r3);     // Catch: JSONException -> L15
        r0.put("anchor_id", r4);     // Catch: JSONException -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L7:
        r3 = "";
        goto L9
    L12:
        r4 = "";
        r3 = r4;
        goto L18
    }

    public b0() {
    }
}
