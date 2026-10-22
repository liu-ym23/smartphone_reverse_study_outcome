package com.bytedance.android.livesdk.log;

import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdkapi.depend.live.ILiveLogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements ILiveLogger {
    public static m a;

    public m() {
    }

    public final JSONObject getLiveAlogCommonParams() {
        JSONObject r0 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r1 = u.l().c(Room.class);
        String r5 = "";
        if ((r1 instanceof s0) == false) goto L12;
        s0 r2 = (s0) r1;
        if (r2.b.containsKey("room_id") == false) goto L7;
        String r3 = r2.b.get("room_id");
    L9:
        if (r2.b.containsKey("anchor_id") == false) goto L11;
        r5 = r2.b.get("anchor_id");
    L11:
        String r4 = r2.n();
        String r7 = r5;
        r5 = r3;
        String r6 = r7;
    L18:
        r0.put("user_id", r4);     // Catch: JSONException -> L15
        r0.put("room_id", r5);     // Catch: JSONException -> L15
        r0.put("anchor_id", r6);     // Catch: JSONException -> L15
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
        r4 = BDLocationException.ERROR_TIMEOUT;
        r6 = "";
        goto L18
    }

    public final Map<String, String> getFilterParamsByName(String r4) {
        HashMap r0 = new HashMap();
        r4.getClass();
        byte r2 = -1;
        switch(r4.hashCode()) {
            case -1310213515: goto L18;
            case -831166662: goto L14;
            case 2553083: goto L10;
            case 2041293031: goto L6;
            default: goto L21;
        };
    L21:
        switch(r2) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        com.bytedance.android.livesdk.log.filter.o r5 = null;
    L27:
        if (r5 == null) goto L29;
        r5.a(r0);
    L29:
        return r0;
    L23:
        r5 = u.l().c(am2.o.class);
        goto L27
    L24:
        r5 = u.l().c(Room.class);
        goto L27
    L25:
        r5 = u.l().c(am2.x.class);
        goto L27
    L26:
        r5 = u.l().c(am2.n.class);
        goto L27
    L6:
        if (r4.equals("LiveDrawerLog") == false) goto L21;
        r2 = 3;
        goto L21
    L10:
        if (r4.equals("Room") == false) goto L21;
        r2 = 2;
        goto L21
    L14:
        if (r4.equals("PageSourceLog") == false) goto L21;
        r2 = 1;
        goto L21
    L18:
        if (r4.equals("LiveAdLog") == false) goto L21;
        r2 = 0;
        goto L21
    }

    public final Map<String, String> getLiveLogCommonFilterParams(String r4) {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r1 = u.l().c(Room.class);
        if (r1 == null) goto L5;
        r1.a(r0);
    L5:
        com.bytedance.android.livesdk.log.filter.o r2 = u.l().c(am2.x.class);
        if (r2 == null) goto L8;
        r2.a(r0);
    L8:
        com.bytedance.android.livesdk.log.filter.o r3 = u.l().c(am2.u.class);
        if (r3 == null) goto L12;
        r3.a(r0);
    L12:
        if (r0.containsKey("enter_from") == false) goto L15;
        String r5 = (String) r0.get("enter_from");
    L15:
        if (r0.containsKey("source") == false) goto L17;
        String r6 = (String) r0.get("source");
    L17:
        Map<String, String> r7 = e0.a;
        if (r0.containsKey("_param_live_platform") == true) goto L20;
        r0.put("_param_live_platform", "live");
    L20:
        r0.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r0.put("room_orientation", u.h);
        Iterator<com.bytedance.android.livesdk.log.filter.v> r8 = u.l().getSendLogFilter().values().iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        r8.next().L9(r4, r0);
        goto L22
    L24:
        LocalTestManager.a(new Class[]{wy.a.class});
        return r0;
    }

    public final void hostDataMapping(Map<String, String> r3) {
        if (r3.containsKey("event_page") == false) goto L6;
        String r0 = r3.get("event_page");
    L6:
        if (r3.containsKey("event_module") == false) goto L8;
        String r1 = r3.get("event_module");
    L8:
        Map<String, String> r2 = e0.a;
        r3.put("_param_live_platform", "live");
    }
}
