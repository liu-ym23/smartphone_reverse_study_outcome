package com.bytedance.applet.jsb;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    static {
    }

    public static void a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "musicId");
        Intrinsics.checkNotNullParameter(r9, "status");
        AppletEvent$BizEvent r1 = AppletEvent$BizEvent.MUSIC_PLAY_STATUS_CHANGE;
        String r2 = r1.getEventName();
        long r3 = System.currentTimeMillis();
        JSONObject r5 = new JSONObject();
        r5.put("music_id", r8);
        r5.put("status", r9);
        Unit r7 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event(r2, r3, new f66.d(r5)));
        Lazy r4 = l3.d.a;
        String r6 = r1.getEventName();
        JsonObject r10 = new JsonObject();
        r10.addProperty("music_id", r8);
        r10.addProperty("status", r9);
        l3.d.c(new l3.a(r6, r10, 4));
    }
}
