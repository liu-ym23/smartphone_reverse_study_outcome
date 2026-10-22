package com.bytedance.android.livesdk.log;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public static void a(long r3) {
        HashMap r0 = new HashMap();
        r0.put("anchor_id", String.valueOf(r3));
        r0.put("entrance_type", "live_room");
        u.l().sendLog("livesdk_anchor_challenge_show", r0, new Object[]{new am2.x(), Room.class});
    }
}
