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
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e implements Handler.Callback {
    public static final List<String> f = null;
    public boolean a;
    public Handler b;
    public final Map<String, Integer> c;
    public SharedPreferences d;
    public final b e;

    static {
        f = Collections.singletonList("StatsMonitor");
    }

    public final void e() {
        SharedPreferences r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = r0.getLong("uptime", 0);
        if (r1 > 0) goto L8;
    L11:
        Map<String, ?> r2 = this.d.getAll();
        if (r2.isEmpty() == false) goto L14;
        return;
    L14:
        Map<String, Integer> r3 = this.c;
        monitor-enter(r3);
        Iterator<Map.Entry<String, ?>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L37
    L18:
        if (r4.hasNext() == false) goto L32;
        Map.Entry<String, ?> r5 = r4.next();     // Catch: Throwable -> L37
        String r6 = r5.getKey();     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r6) == true) goto L18;
        if ("uptime".equals(r5.getKey()) == true) goto L18;
        if (r5.getValue() == null) goto L27;
        int r7 = ((Integer) r5.getValue()).intValue();     // Catch: Throwable -> L37
    L28:
        Integer r8 = (Integer) ((ConcurrentHashMap) this.c).get(r6);     // Catch: Throwable -> L37
        if (r8 == null) goto L30;
        ((ConcurrentHashMap) this.c).put(r6, Integer.valueOf(r7 + r8.intValue()));     // Catch: Throwable -> L37
        goto L18
    L30:
        ((ConcurrentHashMap) this.c).put(r6, Integer.valueOf(r7));     // Catch: Throwable -> L37
        goto L18
    L27:
        r7 = 0;
        goto L28
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L37
        Handler r9 = this.b;
        if (r9 == null) goto L53;
        r9.removeMessages(8);
        this.b.sendEmptyMessageDelayed(8, 500);
        return;
    L53:
        return;
    L37:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r1) <= TimeUnit.DAYS.toMillis(this.e.i)) goto L11;
        this.d.edit().clear().apply();
    }

    public e(b r2) {
        this.a = true;
        this.c = new ConcurrentHashMap();
        this.e = r2;
    }

    public final Pair<Map<String, Integer>, Long> b(long r7) {
        if (((ConcurrentHashMap) this.c).isEmpty() == false) goto L7;
        return new Pair(null, Long.valueOf(r7));
    L7:
        return new Pair(new HashMap(this.c), Long.valueOf(r7 - (((long) ((ConcurrentHashMap) this.c).size()) * 30)));
    }

    public final void d(a r4) {
        Map<String, Integer> r0 = this.c;
        monitor-enter(r0);
        Map<String, Integer> r1 = this.c;     // Catch: Throwable -> L14
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;     // Catch: Throwable -> L14
        Integer r3 = (Integer) r2.get(r4.a);     // Catch: Throwable -> L14
        if (r3 == null) goto L7;
        int r5 = r3.intValue();     // Catch: Throwable -> L14
    L8:
        int r6 = r5 + r4.b;     // Catch: Throwable -> L14
        Map<String, Integer> r7 = this.c;     // Catch: Throwable -> L14
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;     // Catch: Throwable -> L14
        r8.put(r4.a, Integer.valueOf(r6));     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Handler r9 = this.b;
        if (r9 == null) goto L19;
        r9.removeMessages(8);
        this.b.sendEmptyMessageDelayed(8, 500);
        return;
    L19:
        return;
    L7:
        r5 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    public final void f(Map<String, Integer> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L38;
        Map<String, Integer> r0 = this.c;
        monitor-enter(r0);
        Iterator<Map.Entry<String, Integer>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L24
    L10:
        if (r7.hasNext() == false) goto L21;
        Map.Entry<String, Integer> r1 = r7.next();     // Catch: Throwable -> L24
        String r2 = r1.getKey();     // Catch: Throwable -> L24
        if (r1.getValue() == null) goto L14;
        int r3 = r1.getValue().intValue();     // Catch: Throwable -> L24
    L15:
        Integer r4 = (Integer) ((ConcurrentHashMap) this.c).get(r2);     // Catch: Throwable -> L24
        if (r4 == null) goto L10;
        int r5 = Math.max(0, r4.intValue() - r3);     // Catch: Throwable -> L24
        if (r5 == 0) goto L19;
        Map<String, Integer> r8 = this.c;     // Catch: Throwable -> L24
        ConcurrentHashMap r9 = (ConcurrentHashMap) r8;     // Catch: Throwable -> L24
        r9.put(r2, Integer.valueOf(r5));     // Catch: Throwable -> L24
        goto L10
    L19:
        ((ConcurrentHashMap) this.c).remove(r2);     // Catch: Throwable -> L24
        goto L10
    L14:
        r3 = 0;
        goto L15
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L24
        this.b.removeMessages(8);
        this.b.sendEmptyMessageDelayed(8, 500);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r7) {
        int r0 = r7.what;
        if (r0 != 8) goto L5;
        SharedPreferences.Editor r8 = this.d.edit();
        r8.clear();
        Map<String, Integer> r1 = this.c;
        monitor-enter(r1);
        Iterator r2 = ((ConcurrentHashMap) this.c).entrySet().iterator();     // Catch: Throwable -> L24
    L15:
        if (r2.hasNext() == false) goto L21;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Throwable -> L24
        String r4 = (String) r3.getKey();     // Catch: Throwable -> L24
        if (r3.getValue() == null) goto L19;
        int r5 = ((Integer) r3.getValue()).intValue();     // Catch: Throwable -> L24
    L20:
        r8.putInt(r4, r5);     // Catch: Throwable -> L24
        goto L15
    L19:
        r5 = 0;
        goto L20
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L24
        r8.putLong("uptime", System.currentTimeMillis());
        r8.apply();
    L23:
        return false;
    L24:
        th = move-exception;
        throw th;
    L5:
        if (r0 != 16) goto L7;
        d((a) r7.obj);
        goto L23
    L7:
        if (r0 != 24) goto L23;
        e();
        goto L23
    }

    public static void a(Map r7, JSONArray r8) {
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("event", "sdk_stats");     // Catch: Throwable -> L16
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L16
        Iterator r9 = r7.entrySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) r9.next();     // Catch: Throwable -> L16
        Integer r3 = (Integer) r2.getValue();     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        if (r3.intValue() <= 0) goto L8;
        r1.put((String) r2.getKey(), r3);     // Catch: Throwable -> L16
        goto L8
    L14:
        r0.put("params", r1);     // Catch: Throwable -> L16
        r0.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L16
        r0.put("event_id", g.b.incrementAndGet());     // Catch: Throwable -> L16
        r0.put("datetime", g.a());     // Catch: Throwable -> L16
    L18:
        r8.put(r0);
        return;
    L16:
        th = move-exception;
        n.w().r(8, f, "appendMapToJSONArray failed", th, new Object[0]);
        goto L18
    }

    public final void c(String r3, int r4) {
        if (this.a == true) goto L5;
        return;
    L5:
        a r0 = new a(r3, r4);
        Handler r5 = this.b;
        if (r5 == null) goto L8;
        r5.sendMessageDelayed(r5.obtainMessage(16, r0), 16);
        return;
    L8:
        d(r0);
    }
}
