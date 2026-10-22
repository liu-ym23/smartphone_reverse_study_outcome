package com.bytedance.android.livesdk.log.filter;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a<T> implements o<T> {
    public final Map<String, String> b;

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void setData(T r1) {
    }

    public a() {
        this.b = Collections.synchronizedMap(new HashMap());
    }

    private static boolean H() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final Map<String, String> getMap() {
        return this.b;
    }

    public final void I(Map<String, String> r7) {
        if (r7 == null) goto L19;
        Map<String, String> r0 = this.b;
        monitor-enter(r0);
        Iterator<Map.Entry<String, String>> r1 = this.b.entrySet().iterator();     // Catch: Throwable -> L16
    L7:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r1.next();     // Catch: Throwable -> L16
        String r3 = r2.getKey();     // Catch: Throwable -> L16
        String r4 = r2.getValue();     // Catch: Throwable -> L16
        String r5 = r7.get(r3);     // Catch: Throwable -> L16
        if (r7.containsKey(r3) == false) goto L13;
        if (r5 == null) goto L13;
        if (r5.isEmpty() == false) goto L7;
    L13:
        r7.put(r3, r4);     // Catch: Throwable -> L16
        goto L7
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void a(Map<String, String> r4) {
        if (com.bytedance.android.livesdk.log.u.j() == true) goto L8;
        if (H() == true) goto L8;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L8:
        if (((Boolean) com.bytedance.android.livesdk.d0.a.getValue()).booleanValue() == false) goto L10;
        I(r4);
        return;
    L10:
        if (r4 == null) goto L14;
        r4.putAll(this.b);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void putAll(Map<String, String> r4) {
        if (com.bytedance.android.livesdk.log.u.j() == false) goto L5;
    L7:
        this.b.putAll(r4);
        return;
    L5:
        if (H() == true) goto L7;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void remove(String r2) {
        this.b.remove(r2);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void c(String r4, String r5) {
        if (com.bytedance.android.livesdk.log.u.j() == false) goto L5;
    L7:
        this.b.put(r4, r5);
        return;
    L5:
        if (H() == true) goto L7;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void u(Map<String, String> r3, T r4) {
        if (com.bytedance.android.livesdk.log.u.j() == true) goto L8;
        if (H() == true) goto L8;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L8:
        if (((Boolean) com.bytedance.android.livesdk.d0.a.getValue()).booleanValue() == false) goto L10;
        I(r3);
        return;
    L10:
        if (r3 == null) goto L14;
        r3.putAll(this.b);
        return;
    }
}
