package com.bytedance.frameworks.baselib.network.http.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f244786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f244787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f244788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f244789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f244790e;

    public final synchronized void a() {
        monitor-enter(this);
        g(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized Map<K, V> c() {
        monitor-enter(this);
        Map<K, V> r100 = this.f244786a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int f() {
        monitor-enter(this);
        int r100 = this.f244787b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r100 = this.f244789d;     // Catch: Throwable -> L10
        int r101 = this.f244790e + r100;     // Catch: Throwable -> L10
        if (r101 == 0) goto L6;
        int r102 = (r100 * 100) / r101;     // Catch: Throwable -> L10
    L7:
        String r103 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f244788c), Integer.valueOf(this.f244789d), Integer.valueOf(this.f244790e), Integer.valueOf(r102)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r103;
    L6:
        r102 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public g(int r100) {
        if (r100 <= 0) goto L7;
        this.f244788c = r100;
        this.f244786a = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized V b(K r100) {
        monitor-enter(this);
        if (r100 == null) goto L16;
        V r101 = this.f244786a.get(r100);     // Catch: Throwable -> L13
        if (r101 == null) goto L9;
        this.f244789d++;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r101;
    L9:
        this.f244790e++;     // Catch: Throwable -> L13
        monitor-exit(this);
        return null;
    L16:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(Object r100) {
        monitor-enter(this);
        if (r100 == null) goto L10;
        if (this.f244786a.remove(r100) == null) goto L7;
        this.f244787b--;     // Catch: Throwable -> L11
    L7:
        monitor-exit(this);
        return;
    L10:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void g(int r100) {
    L3:
        if (this.f244787b <= r100) goto L11;
        if (this.f244786a.isEmpty() == true) goto L11;
        Map.Entry<K, V> r101 = this.f244786a.entrySet().iterator().next();
        if (r101 == null) goto L11;
        K r102 = r101.getKey();
        r101.getValue();
        this.f244786a.remove(r102);
        this.f244787b--;
    L11:
        if (this.f244787b < 0) goto L18;
        if (this.f244786a.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.f244787b != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(g.class.getName().concat(".sizeOf() is reporting inconsistent results!"));
    }

    public final synchronized void d(Object r100, Object r101) {
        monitor-enter(this);
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        this.f244787b++;     // Catch: Throwable -> L13
        if (this.f244786a.put(r100, r101) == null) goto L8;
        this.f244787b--;     // Catch: Throwable -> L13
    L8:
        g(this.f244788c);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
