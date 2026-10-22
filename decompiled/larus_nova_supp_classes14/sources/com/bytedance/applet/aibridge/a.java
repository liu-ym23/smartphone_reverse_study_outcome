package com.bytedance.applet.aibridge;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.o2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements b88.a {
    public static final a a = null;
    public static final ConcurrentHashMap<String, JSONObject> b = null;
    public static b88.d c;
    public static final ConcurrentHashMap<String, Pair<String, String>> d = null;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0044a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UrlAudioPlayStatus.values().length];
            r0[UrlAudioPlayStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UrlAudioPlayStatus.STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UrlAudioPlayStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public final void d(String r7, String r8, int r9, UrlAudioPlayStatus r10) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r10, "status");
        NewsUrlAudioManagerDelegate r0 = NewsUrlAudioManagerDelegate.b;
        String r1 = r0.a(r7, Integer.valueOf(r9), r8);
        Lazy r2 = l3.d.a;
        JsonObject r3 = new JsonObject();
        r3.addProperty("url", r7);
        r3.addProperty("videoModel", r8);
        r3.addProperty("sourceType", Integer.valueOf(r9));
        r3.addProperty("status", r10.getValue());
        if (r1 == null) goto L5;
        r3.addProperty("pausedReason", r1);
    L5:
        Unit r11 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.audioPlayStatusChanged", r3, 4));
        com.bytedance.applet.task.b.a.getClass();
        com.bytedance.applet.task.b.d(r10);
        ConcurrentHashMap<String, JSONObject> r12 = b;
        JSONObject r13 = r12.get(r7);
        if (r13 == null) goto L28;
        monitor-enter(r13);
        int r4 = C0044a.a[r10.ordinal()];     // Catch: Throwable -> L58
        if (r4 != 1) goto L12;
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L58
        r13.remove("start_time");     // Catch: Throwable -> L58
        o2.b(r13);     // Catch: Throwable -> L58
        r13.put("start_time", r14);     // Catch: Throwable -> L58
    L27:
        monitor-exit(r13);
        goto L28
    L12:
        if (r4 != 2) goto L14;
        r12.remove(r7);     // Catch: Throwable -> L58
        if (r13.has("start_time") == true) goto L25;
        monitor-exit(r13);
        goto L28
    L25:
        long r15 = r13.optLong("start_time", 0);     // Catch: Throwable -> L58
        r13.remove("start_time");     // Catch: Throwable -> L58
        o2.a(Long.valueOf(System.currentTimeMillis() - r15), r13);     // Catch: Throwable -> L58
        r13.remove("duration");     // Catch: Throwable -> L58
        goto L27
    L14:
        if (r4 != 3) goto L27;
        if (r13.has("start_time") == true) goto L20;
        monitor-exit(r13);
        goto L28
    L20:
        long r16 = r13.optLong("start_time", 0);     // Catch: Throwable -> L58
        r13.remove("start_time");     // Catch: Throwable -> L58
        o2.a(Long.valueOf(System.currentTimeMillis() - r16), r13);     // Catch: Throwable -> L58
        r13.remove("duration");     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    L28:
        b88.d r17 = r0.c();
        if (r17 != null) goto L33;
        r17 = c;
        if (r17 != null) goto L33;
        return;
    L33:
        c = r17;
        String r18 = r17.i;
        if (r18 != null) goto L36;
        r18 = "SYSTEM_CVS_ID";
    L36:
        String r19 = r17.k;
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.core.base.h r5 = null;
        AppletRuntime r6 = AppletRuntimeManager.i(r18, null, r19);
        if (r6 != null) goto L39;
        return;
    L39:
        String r20 = r17.k;
        if (r20 != null) goto L42;
        r20 = "PLAYING_AUDIO";
    L42:
        int r110 = C0044a.a[r10.ordinal()];
        if (r110 == 1) goto L47;
        if (r110 != 2) goto L64;
        r6.t(r18, r20);
        d.remove(r18);
        return;
    L64:
        return;
    L47:
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        Intrinsics.checkNotNullParameter(r20, "taskName");
        com.bytedance.ai.core.base.i r21 = r6.s(r18);
        if (r21 == null) goto L55;
        Intrinsics.checkNotNullParameter(r20, "taskName");
        com.bytedance.ai.core.base.h r111 = (com.bytedance.ai.core.base.h) r21.d.get(r20);
        if (r111 != null) goto L52;
        r111 = new com.bytedance.ai.core.base.h(r21.a, r20);
        r21.d.put(r20, r111);
    L52:
        r5 = r111;
        if (r5.c.get() == true) goto L55;
        r5.c.set(true);
        r6.g();
    L55:
        if (r5 == null) goto L63;
        Pair<String, String> r22 = d.putIfAbsent(r18, new Pair(r19, r5.b));
        return;
    }
}
