package com.bytedance.applog.monitor.v3.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.n;
import ex3.b;
import ex3.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c implements Handler.Callback {
    public static final List<String> f = null;
    public boolean a;
    public Handler b;
    public final Map<String, a> c;
    public SharedPreferences d;
    public final b e;

    static {
        f = Collections.singletonList("NetworkMonitor");
    }

    public final void c() {
        SharedPreferences r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        Map<String, ?> r1 = r0.getAll();
        if (r1.isEmpty() == false) goto L8;
        return;
    L8:
        Map<String, a> r2 = this.c;
        monitor-enter(r2);
        Iterator<Map.Entry<String, ?>> r3 = r1.entrySet().iterator();     // Catch: Throwable -> L26
    L12:
        if (r3.hasNext() == false) goto L21;
        Map.Entry<String, ?> r4 = r3.next();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r4.getKey()) == true) goto L12;
        if ("uptime".equals(r4.getKey()) == true) goto L12;
        a r5 = a.a((String) r4.getValue());     // Catch: Throwable -> L26
        if (r5 == null) goto L12;
        Map<String, a> r6 = this.c;     // Catch: Throwable -> L26
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;     // Catch: Throwable -> L26
        r7.put(r5.a, r5);     // Catch: Throwable -> L26
        goto L12
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L26
        Handler r8 = this.b;
        if (r8 == null) goto L41;
        r8.removeMessages(8);
        this.b.sendEmptyMessageDelayed(8, 500);
        return;
    L41:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public c(b r2) {
        this.a = false;
        this.c = new ConcurrentHashMap();
        this.e = r2;
    }

    public final Pair<Map<String, a>, Long> b(long r10) {
        if (((ConcurrentHashMap) this.c).isEmpty() == true) goto L5;
        HashMap r0 = new HashMap();
        Map<String, a> r1 = this.c;
        monitor-enter(r1);
        Iterator r2 = ((ConcurrentHashMap) this.c).entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Throwable -> L21
        String r4 = (String) r3.getKey();     // Catch: Throwable -> L21
        a r5 = (a) r3.getValue();     // Catch: Throwable -> L21
        if (r5 == null) goto L10;
        r10 = r10 - (((long) ((r5.a.length() + r5.b.length()) + r5.h.length())) + 200);     // Catch: Throwable -> L21
        if (r10 <= 0) goto L18;
        r0.put(r4, r5);     // Catch: Throwable -> L21
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return new Pair(r0, Long.valueOf(r10));
    L21:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r10));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r7) {
        int r0 = r7.what;
        if (r0 != 8) goto L5;
        SharedPreferences.Editor r8 = this.d.edit();
        Map<String, a> r1 = this.c;
        monitor-enter(r1);
    L26:
        th = move-exception;
        throw th;
    L16:
        if (((ConcurrentHashMap) this.c).size() <= 200) goto L18;
        r8.clear();     // Catch: Throwable -> L26
        ((ConcurrentHashMap) this.c).clear();     // Catch: Throwable -> L26
    L18:
        Iterator r2 = ((ConcurrentHashMap) this.c).entrySet().iterator();     // Catch: Throwable -> L26
    L20:
        if (r2.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Throwable -> L26
        r8.putString((String) r3.getKey(), ((a) r3.getValue()).c().toString());     // Catch: Throwable -> L26
        goto L20
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L26
        r8.apply();
        return false;
    L5:
        if (r0 != 16) goto L7;
        a r9 = (a) r7.obj;
        ((ConcurrentHashMap) this.c).put(r9.a, r9);
        Handler r10 = this.b;
        if (r10 == null) goto L33;
        r10.removeMessages(8);
        this.b.sendEmptyMessageDelayed(8, 500);
        return false;
    L33:
        return false;
    L7:
        if (r0 != 24) goto L35;
        c();
        return false;
    L35:
        return false;
    }

    public static void a(Map r6, JSONArray r7) {
        if (r6.isEmpty() == false) goto L15;
        return;
    L15:
        Iterator r8 = r6.entrySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r8.hasNext() == false) goto L22;
        a r0 = (a) ((Map.Entry) r8.next()).getValue();     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L12
        r1.put("event", "sdk_network");     // Catch: Throwable -> L12
        r1.put("params", r0.b());     // Catch: Throwable -> L12
        r1.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L12
        r1.put("event_id", g.b.incrementAndGet());     // Catch: Throwable -> L12
        r1.put("datetime", g.a());     // Catch: Throwable -> L12
        r7.put(r1);     // Catch: Throwable -> L12
        goto L7
    L22:
        return;
    L12:
        th = move-exception;
        n.w().r(8, f, "appendMapToJSONArray failed", th, new Object[0]);
    }

    public final void d(String r17, String r18, long r19, boolean r21, int r22, int r23, long r24, String r26, long r28, JSONObject r29) {
        if (this.a == true) goto L5;
        return;
    L5:
        n.w().k(8, f, "onRequestFinished {} -> {}, {}, {}, {}, {}, {}, {}, {}", new Object[]{r17, r18, Long.valueOf(r19), Boolean.valueOf(r21), Integer.valueOf(r22), Integer.valueOf(r23), Long.valueOf(r24), r26, Long.valueOf(r28), r29});
        a r12 = new a(r17, r18, r19, r21, r22, r23, r24, r26, r28, r29);
        Handler r1 = this.b;
        if (r1 == null) goto L8;
        r1.sendMessage(r1.obtainMessage(16, r12));
        return;
    L8:
        ((ConcurrentHashMap) this.c).put(r17, r12);
        Handler r2 = this.b;
        if (r2 == null) goto L13;
        r2.removeMessages(8);
        this.b.sendEmptyMessageDelayed(8, 500);
        return;
    }
}
