package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Map<String, l1> f277435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static s f277436c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g1 f277437a;

    static {
        f277435b = new HashMap();
    }

    private s() {
        this.f277437a = new g1();
    }

    public static s c() {
        if (f277436c != null) goto L6;
        d();
    L6:
        return f277436c;
    }

    private static synchronized void d() {
        monitor-enter(s.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f277436c != null) goto L7;
        f277436c = new s();     // Catch: Throwable -> L9
    L7:
        monitor-exit(s.class);
    }

    public l1 a(String r100) {
        return f277435b.get(r100);
    }

    public Set<String> a() {
        return f277435b.keySet();
    }

    public void a(String r100, l1 r101) {
        f277435b.put(r100, r101);
    }

    public g1 b() {
        return this.f277437a;
    }
}
