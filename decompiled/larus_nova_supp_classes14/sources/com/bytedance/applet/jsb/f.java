package com.bytedance.applet.jsb;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "musicId");
        AppletEvent$BizEvent r0 = AppletEvent$BizEvent.MUSIC_ACTION_TRIGGERED;
        String r1 = r0.getEventName();
        long r2 = System.currentTimeMillis();
        JSONObject r4 = new JSONObject();
        r4.put("music_id", r8);
        r4.put("action_type", r9);
        Unit r7 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event(r1, r2, new f66.d(r4)));
        Lazy r3 = l3.d.a;
        String r5 = r0.getEventName();
        JsonObject r6 = new JsonObject();
        r6.addProperty("music_id", r8);
        r6.addProperty("action_type", Integer.valueOf(r9));
        l3.d.c(new l3.a(r5, r6, 4));
    }
}
