package com.bytedance.applet.jsb;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.o2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements b88.a {
    public static final a a = null;
    public static final ConcurrentHashMap<String, JSONObject> b = null;

    /* JADX INFO: renamed from: com.bytedance.applet.jsb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0057a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UrlAudioPlayStatus.values().length];
            r0[UrlAudioPlayStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UrlAudioPlayStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UrlAudioPlayStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new ConcurrentHashMap();
    }

    public final void d(String r7, String r8, int r9, UrlAudioPlayStatus r10) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r10, "status");
        int r11 = e.a;
        String r12 = r10.getValue();
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r12, "status");
        AppletEvent$BizEvent r1 = AppletEvent$BizEvent.AUDIO_PLAY_STATUS_CHANGE;
        String r2 = r1.getEventName();
        long r3 = System.currentTimeMillis();
        JSONObject r5 = new JSONObject();
        r5.put("url", r7);
        r5.put("status", r12);
        Unit r13 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event(r2, r3, new f66.d(r5)));
        Lazy r14 = l3.d.a;
        String r15 = r1.getEventName();
        JsonObject r0 = new JsonObject();
        r0.addProperty(r7, r7);
        r0.addProperty(r12, r12);
        l3.d.c(new l3.a(r15, r0, 4));
        String r16 = r10.getValue();
        HashSet r17 = AppletRuntime.c.a;
        JavaOnlyMap r18 = new JavaOnlyMap();
        r18.put("url", r7);
        r18.put("status", r16);
        AppletRuntime.c.a("audioPlayStatusChanged", r18);
        ConcurrentHashMap<String, JSONObject> r19 = b;
        JSONObject r20 = r19.get(r7);
        if (r20 == null) goto L30;
        monitor-enter(r20);
        int r110 = C0057a.a[r10.ordinal()];     // Catch: Throwable -> L26
        if (r110 != 1) goto L9;
        long r21 = System.currentTimeMillis();     // Catch: Throwable -> L26
        r20.remove("start_time");     // Catch: Throwable -> L26
        o2.b(r20);     // Catch: Throwable -> L26
        r20.put("start_time", r21);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r20);
        return;
    L9:
        if (r110 == 2) goto L19;
        if (r110 != 3) goto L24;
        r19.remove(r7);     // Catch: Throwable -> L26
        if (r20.has("start_time") == true) goto L17;
        monitor-exit(r20);
        return;
    L17:
        long r22 = r20.optLong("start_time", 0);     // Catch: Throwable -> L26
        r20.remove("start_time");     // Catch: Throwable -> L26
        o2.a(Long.valueOf(System.currentTimeMillis() - r22), r20);     // Catch: Throwable -> L26
        r20.remove("duration");     // Catch: Throwable -> L26
        goto L24
    L19:
        if (r20.has("start_time") == true) goto L22;
        monitor-exit(r20);
        return;
    L22:
        long r23 = r20.optLong("start_time", 0);     // Catch: Throwable -> L26
        r20.remove("start_time");     // Catch: Throwable -> L26
        o2.a(Long.valueOf(System.currentTimeMillis() - r23), r20);     // Catch: Throwable -> L26
        r20.remove("duration");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
