package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.utils.w1;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public static void a(String r2, int r3, long r4, String r6, int r7) {
        HashMap r0 = new HashMap();
        r0.put(LocationMonitorConst.ERROR_MSG, r2);
        r0.put(LocationMonitorConst.ERROR_CODE, String.valueOf(r3));
        r0.put("error_style", "frame_fail");
        r0.put("is_vr_machine", VrUtils.o(null));
        if (r4 <= 0) goto L5;
        r0.put("room_id", String.valueOf(r4));
    L5:
        if (r6 == null) goto L8;
        r0.put("anchor_id", r6);
    L8:
        if (r7 != 2) goto L10;
        r0.put("source_room_type", "replay");
    L14:
        u.l().sendLog("livesdk_live_play_fail", r0, new Object[]{new am2.x(), Room.class});
        w1.a("ttlive_schema_room_fail", "logEnterRoomFail");
        return;
    L10:
        if (r7 == 3) goto L12;
        r0.put("source_room_type", "normal");
        goto L14
    L12:
        r0.put("source_room_type", "vs_video");
        goto L14
    }
}
