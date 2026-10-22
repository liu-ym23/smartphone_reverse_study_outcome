package com.bytedance.applog.monitor.v3.impl;

import android.util.Pair;
import com.bytedance.applog.monitor.v3.StageEventType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class LatencyMonitor {
    public boolean a;
    public final Map<String, a> b;

    public LatencyMonitor() {
        this.a = true;
        this.b = new ConcurrentHashMap();
    }

    public final Pair<Map<String, JSONObject>, Long> a(long r7) {
        if (this.a == false) goto L23;
        if (((ConcurrentHashMap) this.b).isEmpty() == true) goto L23;
        HashMap r0 = new HashMap();
        Map<String, a> r1 = this.b;
        monitor-enter(r1);
        Iterator r2 = ((ConcurrentHashMap) this.b).keySet().iterator();     // Catch: Throwable -> L19
    L11:
        if (r2.hasNext() == false) goto L16;
        String r3 = (String) r2.next();     // Catch: Throwable -> L19
        a r4 = (a) ((ConcurrentHashMap) this.b).remove(r3);     // Catch: Throwable -> L19
        if (r4 == null) goto L11;
        r0.put(r3, r4.a());     // Catch: Throwable -> L19
        r7 = r7 - 231;     // Catch: Throwable -> L19
        if (r7 > 0) goto L11;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return new Pair(r0, Long.valueOf(r7));
    L19:
        th = move-exception;
        throw th;
    L23:
        return new Pair(null, Long.valueOf(r7));
    }

    public final void b(int r5, StageEventType r6, int r7) {
        if (r7 > 1) goto L6;
        EventLatencyScope r8 = EventLatencyScope.l_0_1;
    L27:
        String r1 = r5 + "_" + r6.toString() + "_" + r8.toString();
        Map<String, a> r2 = this.b;
        monitor-enter(r2);
        a r3 = (a) ((ConcurrentHashMap) this.b).get(r1);     // Catch: Throwable -> L35
        if (r3 != null) goto L32;
        r3 = new a();     // Catch: Throwable -> L35
        r3.d = r8;     // Catch: Throwable -> L35
        r3.c = r6;     // Catch: Throwable -> L35
        r3.b = r5;     // Catch: Throwable -> L35
        ((ConcurrentHashMap) this.b).put(r1, r3);     // Catch: Throwable -> L35
    L32:
        r3.a++;     // Catch: Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    L6:
        if (r7 > 10) goto L9;
        r8 = EventLatencyScope.l_1_10;
        goto L27
    L9:
        if (r7 > 20) goto L12;
        r8 = EventLatencyScope.l_10_20;
        goto L27
    L12:
        if (r7 > 30) goto L15;
        r8 = EventLatencyScope.l_20_30;
        goto L27
    L15:
        if (r7 > 40) goto L18;
        r8 = EventLatencyScope.l_30_40;
        goto L27
    L18:
        if (r7 > 50) goto L21;
        r8 = EventLatencyScope.l_40_50;
        goto L27
    L21:
        if (r7 > 60) goto L24;
        r8 = EventLatencyScope.l_50_60;
        goto L27
    L24:
        if (r7 > 120) goto L26;
        r8 = EventLatencyScope.l_60_120;
        goto L27
    L26:
        r8 = EventLatencyScope.l_120_;
        goto L27
    }
}
