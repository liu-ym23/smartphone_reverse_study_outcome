package com.bytedance.ies.bullet.forest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f<K, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ConcurrentHashMap<K, T>> f246743a;

    public f() {
        this.f246743a = new LinkedHashMap();
    }

    public final ConcurrentHashMap<K, T> a(String r100) {
        monitor-enter(this);
        Map<String, ConcurrentHashMap<K, T>> r101 = this.f246743a;     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        ConcurrentHashMap<K, T> r102 = (ConcurrentHashMap) TypeIntrinsics.asMutableMap(r101).remove(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r102;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static Map b(Map r100, String r101, boolean r102) {
        if (r101 == null) goto L13;
        monitor-enter(r100);
        ConcurrentHashMap r103 = (ConcurrentHashMap) ((LinkedHashMap) r100).get(r101);     // Catch: Throwable -> L10
        if (r102 == false) goto L8;
        if (r103 != null) goto L8;
        r103 = new ConcurrentHashMap();     // Catch: Throwable -> L10
        r100.put(r101, r103);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
        return r103;
    L10:
        th = move-exception;
        throw th;
    L13:
        return null;
    }

    public final void c(String r100, K r101, T r102) {
        Map r103 = b(this.f246743a, r100, true);
        if (r103 == null) goto L6;
        r103.put(r101, r102);
        return;
    }
}
