package com.bytedance.android.livesdk.locallife;

import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    static {
    }

    @JvmStatic
    public static final Map<String, String> a(Room r7, String r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r7 == null) goto L5;
        String r1 = r7.lifeShareId;
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L31;
        JSONObject r5 = new JSONObject();
        r5.put("life_share_id", r1);     // Catch: Exception -> L20
        r5.put("enter_from", "livebroadcasting");     // Catch: Exception -> L20
        r5.put("enter_from_merge", g4.d());     // Catch: Exception -> L20
        String r9 = String.valueOf(r7.getRoomId());     // Catch: Exception -> L20
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        r5.put("room_id", r9);     // Catch: Exception -> L20
        r5.put("enter_method", g4.e());     // Catch: Exception -> L20
        r5.put("action_type", g4.c());     // Catch: Exception -> L20
    L22:
        r0.put("life_share_ext", r5.toString());
        if (r8 != null) goto L25;
    L26:
        r2 = true;
    L27:
        if (r2 == false) goto L29;
        String r10 = "group";
    L30:
        r0.put("chat_type", r10);
        goto L31
    L29:
        r10 = "private";
        goto L30
    L25:
        if (r8.length() != 0) goto L27;
    L20:
        e = move-exception;
        e.printStackTrace();
    L31:
        return r0;
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
