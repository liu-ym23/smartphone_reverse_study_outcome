package com.bytedance.applet.event;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements z2a.b {
    public static final u a = null;
    public static final Map<String, Boolean> b = null;
    public static final Map<String, Boolean> c = null;
    public static final Map<String, Boolean> d = null;

    public u() {
    }

    static {
        a = new u();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public static void a(String r7, int r8) {
        long r0 = System.currentTimeMillis();
        JSONObject r2 = new JSONObject();
        r2.put("botId", r7);
        r2.put("state", r8);
        Unit r5 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event("realtimeCallStateChanged", r0, new f66.d(new JSONObject(MapsKt.mapOf(TuplesKt.to("data", r2))))));
        Lazy r1 = l3.d.a;
        JsonObject r3 = new JsonObject();
        r3.addProperty("botId", r7);
        r3.addProperty("state", Integer.valueOf(r8));
        l3.d.c(new l3.a("realtimeCallStateChanged", r3, 4));
    }

    public final void onEnterRealtimeCall(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        boolean r1 = false;
        if (z2.a.realtimeCallAllSceneMixEnable() == true) goto L45;
    L11:
        boolean r0 = false;
    L13:
        if (r0 == false) goto L16;
        ((ConcurrentHashMap) d).put(r11, Boolean.TRUE);
        FLogger.a.i("RealtimeCallStateObserver", "onEnterRealtimeCall suppress event for call mix. botId=" + r11);
    L43:
        Map<String, Boolean> r2 = b;
        Boolean r3 = Boolean.TRUE;
        ((ConcurrentHashMap) r2).put(r11, r3);
        ((ConcurrentHashMap) c).put(r12, r3);
        return;
    L16:
        if (ObricTtsControlDelegate.b.e() == false) goto L42;
        boolean r4 = z2.a.realtimeCallAllSceneMixEnable();
        a88.e r5 = MusicPlayManagerDelegate.b.a();     // Catch: Exception -> L20
    L49:
        c88.a r6 = AudioStreamPlayerDelegate.b.f();     // Catch: Exception -> L24
    L26:
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("onEnterRealtimeCall botId=");
        r8.append(r11);
        r8.append(", mixEnable=");
        r8.append(r4);
        r8.append(", hasMusic=");
        if (r5 == null) goto L29;
        boolean r9 = true;
    L30:
        r8.append(r9);
        r8.append(", hasStream=");
        if (r6 == null) goto L33;
        r1 = true;
    L33:
        r8.append(r1);
        r7.i("RealtimeCallStateObserver", r8.toString());
        if (r5 != null) goto L47;
    L38:
        if (r6 == null) goto L42;
        AudioStreamPlayerDelegate.b.a(null, "realtime_call_enter");     // Catch: Exception -> L36
        r7.i("RealtimeCallStateObserver", "stopInAppMediaIfNeeded stopStream");     // Catch: Exception -> L36
    L36:
        e = move-exception;
        FLogger.a.e("RealtimeCallStateObserver", "stopInAppMediaIfNeeded error", e);
        goto L42
    L47:
        r7.i("RealtimeCallStateObserver", "stopInAppMediaIfNeeded stopMusic musicId=" + r5.a + ", result=" + MusicPlayManagerDelegate.b.c(r5.a));     // Catch: Exception -> L36
        goto L38
    L29:
        r9 = false;
    L24:
        e = move-exception;
        FLogger.a.e("RealtimeCallStateObserver", "onEnterRealtimeCall getCurrentAudioSteamData error", e);
        r6 = null;
    L20:
        e = move-exception;
        FLogger.a.e("RealtimeCallStateObserver", "onEnterRealtimeCall getCurrentMusic error", e);
        r5 = null;
    L42:
        a(r11, 1);
        goto L43
    L45:
        if (MusicPlayManagerDelegate.b.a() != null) goto L9;
        if (AudioStreamPlayerDelegate.b.f() == null) goto L11;
    L9:
        r0 = true;
        goto L13
    }

    public final void onExitRealtimeCall(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        if (((ConcurrentHashMap) d).remove(r4) == null) goto L5;
        FLogger.a.i("RealtimeCallStateObserver", "onExitRealtimeCall suppress event for call mix. botId=" + r4);
    L6:
        ((ConcurrentHashMap) b).remove(r4);
        ((ConcurrentHashMap) c).remove(r5);
        return;
    L5:
        a(r4, 0);
        goto L6
    }
}
