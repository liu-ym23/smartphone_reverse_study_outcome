package com.bytedance.applet.aibridge;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ixigua.lib.track.TrackParams;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.audioplayer.api.utils.MusicActionUtilDelegate;
import com.larus.trace.TriggeredAudioActionEnum;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements a88.c, a88.b, a88.a {
    public static final i a = null;
    public static String b;
    public static String c;
    public static final ConcurrentHashMap<String, JSONObject> d = null;

    public i() {
    }

    static {
        i r0 = new i();
        a = r0;
        c = "stopped";
        d = new ConcurrentHashMap();
        MusicPlayManagerDelegate r1 = MusicPlayManagerDelegate.b;
        r1.l();
        r1.k(r0);
        MusicActionUtilDelegate.b.a(r0);
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        c = "prepare";
        m(r2, "prepare");
    }

    public final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "musicId");
        l(r3, 0, null);
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        m(r2, "finish");
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        c = "error";
        m(r2, "error");
    }

    public final String j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "originalResolution");
        switch(r2.hashCode()) {
            case 2249154: goto L18;
            case 68069317: goto L14;
            case 1377272541: goto L10;
            case 1670753181: goto L6;
            default: goto L21;
        };
    L21:
        return null;
    L6:
        if (r2.equals("SuperHigh") == false) goto L21;
        return "highest";
    L10:
        if (r2.equals("Standard") == false) goto L21;
        return "medium";
    L14:
        if (r2.equals("FourK") == false) goto L21;
        return "lossless";
    L18:
        if (r2.equals("High") == false) goto L21;
        return "higher";
    }

    public final String k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "mappedResolution");
        switch(r2.hashCode()) {
            case -1919475908: goto L18;
            case -1217394225: goto L14;
            case -1078030475: goto L10;
            case 915484836: goto L6;
            default: goto L21;
        };
    L21:
        return "Undefine";
    L6:
        if (r2.equals("highest") == false) goto L21;
        return "SuperHigh";
    L10:
        if (r2.equals("medium") == false) goto L21;
        return "Standard";
    L14:
        if (r2.equals("higher") == false) goto L21;
        return "High";
    L18:
        if (r2.equals("lossless") == false) goto L21;
        return "FourK";
    }

    public final void onError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        c = "error";
        m(r2, "error");
    }

    public static void m(String r5, String r6) {
        if (Intrinsics.areEqual(r6, "playing") == false) goto L17;
        ConcurrentHashMap<String, Pair<String, String>> r0 = a.d;
        if (r0.size() == 0) goto L17;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        HashMap r2 = new HashMap(r0);     // Catch: Throwable -> L15
        r0.clear();     // Catch: Throwable -> L15
        Iterator r3 = r2.entrySet().iterator();     // Catch: Throwable -> L15
    L9:
        if (r3.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r3.next();     // Catch: Throwable -> L15
        String r7 = (String) r4.getKey();     // Catch: Throwable -> L15
        String r8 = (String) ((Pair) r4.getValue()).getFirst();     // Catch: Throwable -> L15
        String r9 = (String) ((Pair) r4.getValue()).getSecond();     // Catch: Throwable -> L15
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L15
        AppletRuntime r10 = AppletRuntimeManager.i(r7, null, r8);     // Catch: Throwable -> L15
        if (r10 == null) goto L9;
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L15
        r10.t(r7, r9);     // Catch: Throwable -> L15
        goto L9
    L13:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        String r12 = MusicPlayManagerDelegate.b.h(r5);
        Lazy r13 = l3.d.a;
        JsonObject r14 = new JsonObject();
        r14.addProperty("musicId", r5);
        r14.addProperty("status", r6);
        if (r12 == null) goto L20;
        r14.addProperty("pausedReason", r12);
    L20:
        Unit r15 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.musicPlayStatusChanged", r14, 4));
    }

    public final void b(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "musicId");
        JsonObject r0 = new JsonObject();
        r0.addProperty("enterMethod", "system_button");
        Unit r1 = Unit.INSTANCE;
        l(r4, r5, r0);
    }

    public final void g(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "musicId");
        if (r9 == 0) goto L28;
        String r1 = CommentPublishScene.UNKNOWN;
        if (r9 != 1) goto L7;
        ConcurrentHashMap<String, JSONObject> r0 = d;
        JSONObject r2 = r0.get(r8);
        if (r2 != null) goto L13;
    L27:
        r1 = "playing";
    L29:
        b = r8;
        c = r1;
        com.bytedance.applet.task.b.a.getClass();
        com.bytedance.applet.task.b.c(r9);
        m(r8, r1);
        return;
    L13:
        if (Intrinsics.areEqual(MusicPlayManagerDelegate.b.b(r8), CommentConstants$CmtLongPanelStrategy.DEFAULT) == false) goto L27;
        TriggeredAudioActionEnum r3 = TriggeredAudioActionEnum.PLAY_START;
        Long r4 = Long.valueOf(System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r2.has("scene") == true) goto L19;
        r2.put("scene", CommentPublishScene.UNKNOWN);
    L19:
        if (r3 == null) goto L22;
        r2.put("action", r3.getValue());
    L24:
        if (r4 == null) goto L26;
        r2.put("trigger_time", r4.longValue());
    L26:
        TrackParams r5 = new TrackParams().merge(r2);
        by7.a r6 = new by7.a("audio_action_triggered");
        r6.a.merge(r5);
        r6.b();
        r0.remove(r8);
        goto L27
    L22:
        if (r2.has("action") == true) goto L24;
        r2.put("action", CommentPublishScene.UNKNOWN);
        goto L24
    L7:
        if (r9 != 2) goto L29;
        r1 = "paused";
        goto L29
    L28:
        r1 = "stopped";
        goto L29
    }

    public final void i(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        if (r3 != 3) goto L6;
        c = "error";
        m(r2, "error");
        return;
    }

    public static void l(String r2, int r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        Lazy r1 = l3.d.a;
        JsonObject r5 = new JsonObject();
        r5.addProperty("musicId", r2);
        r5.addProperty("actionType", Integer.valueOf(r3));
        if (r4 == null) goto L10;
        Set r6 = r4.entrySet();
        if (r6 == null) goto L10;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) r7.next();
        r5.add((String) r8.getKey(), (JsonElement) r8.getValue());
    L10:
        Unit r9 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.musicActionTriggered", r5, 4));
    }

    public final void a(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "musicId");
        Intrinsics.checkNotNullParameter(r5, "fromProgress");
        Intrinsics.checkNotNullParameter(r6, "toProgress");
        JsonObject r0 = new JsonObject();
        r0.addProperty("enterMethod", "system_button");
        r0.addProperty("musicPrevProgress", r5);
        r0.addProperty("musicProgress", r6);
        Unit r7 = Unit.INSTANCE;
        l(r4, 3, r0);
    }

    public final void c(String r3, int r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "musicId");
        Lazy r1 = l3.d.a;
        JsonObject r2 = new JsonObject();
        r2.addProperty("musicId", r3);
        r2.addProperty("actionType", Integer.valueOf(r4));
        if (r5 == null) goto L10;
        Set<Map.Entry<String, String>> r6 = r5.entrySet();
        if (r6 == null) goto L10;
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) r7.next();
        r2.addProperty((String) r8.getKey(), (String) r8.getValue());
    L10:
        Unit r9 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.doraMusicActionTriggered", r2, 4));
    }
}
