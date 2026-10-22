package com.bytedance.android.livesdk.log;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 extends com.bytedance.android.live.core.log.g {
    public static k0 a;

    public static synchronized k0 o() {
        monitor-enter(k0.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new k0();     // Catch: Throwable -> L10
    L7:
        k0 r1 = a;     // Catch: Throwable -> L10
        monitor-exit(k0.class);
        return r1;
    }

    public final JSONObject h() {
        JSONObject r0 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(IRoom.class);
        String r5 = "";
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L12;
        com.bytedance.android.livesdk.log.filter.u r2 = (com.bytedance.android.livesdk.log.filter.u) r1;
        Map<String, String> r3 = r2.getMap();
        if (r3.containsKey("room_id") == false) goto L7;
        String r6 = r3.get("room_id");
    L9:
        if (r3.containsKey("anchor_id") == false) goto L11;
        r5 = r3.get("anchor_id");
    L11:
        String r4 = r2.n();
        String r7 = r5;
        r5 = r6;
    L18:
        r0.put("user_id", r4);     // Catch: JSONException -> L15
        r0.put("room_id", r5);     // Catch: JSONException -> L15
        r0.put("anchor_id", r7);     // Catch: JSONException -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L7:
        r6 = "";
        goto L9
    L12:
        r4 = BDLocationException.ERROR_TIMEOUT;
        r7 = "";
        goto L18
    }

    public k0() {
    }
}
