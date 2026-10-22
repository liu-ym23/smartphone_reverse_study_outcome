package com.bytedance.applog.monitor.v3.impl;

import android.text.TextUtils;
import android.util.Pair;
import ex3.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public final List<a> a;
    public int b;

    public a() {
        this.a = new CopyOnWriteArrayList();
        this.b = 10000;
    }

    public final Pair<Map<String, JSONObject>, Long> a(long r10) {
        if (this.b <= 0) goto L5;
        HashMap r0 = new HashMap();
        Iterator r1 = ((CopyOnWriteArrayList) this.a).iterator();
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L26;
        a r3 = (a) r1.next();
        int r4 = r2 + 1;
        String r5 = String.valueOf(r2);
        r3.getClass();
        JSONObject r6 = new JSONObject();
        r6.put("event", "sdk_fatal");     // Catch: Throwable -> L15
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L15
        r7.put("message", r3.a);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r3.b) == true) goto L13;
        r7.put("class", r3.b);     // Catch: Throwable -> L15
        r7.put("stack", r3.c);     // Catch: Throwable -> L15
    L13:
        r6.put("params", r7);     // Catch: Throwable -> L15
        r6.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L15
        r6.put("event_id", g.b.incrementAndGet());     // Catch: Throwable -> L15
        r6.put("datetime", g.a());     // Catch: Throwable -> L15
    L17:
        r0.put(r5, r6);
        ((CopyOnWriteArrayList) this.a).remove(r3);
        if (TextUtils.isEmpty(r3.b) == false) goto L20;
        int r8 = r3.a.length() + 43;
    L21:
        r10 = r10 - ((long) r8);
        if (r10 <= 0) goto L26;
        r2 = r4;
        goto L8
    L20:
        r8 = ((r3.a.length() + 65) + r3.b.length()) + r3.c.length();
    L15:
        th = move-exception;
        th.printStackTrace();
    L26:
        return new Pair(r0, Long.valueOf(r10));
    L5:
        return new Pair(null, Long.valueOf(r10));
    }
}
