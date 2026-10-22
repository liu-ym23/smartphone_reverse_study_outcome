package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static y f277471b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f277472a;

    private y() {
        this.f277472a = new HashMap();
    }

    private p0 a(String r100) {
        if (this.f277472a.containsKey(r100) == true) goto L6;
        p0 r101 = new p0();
        this.f277472a.put(r100, r101);
    L6:
        return this.f277472a.get(r100);
    }

    public static y a() {
        if (f277471b != null) goto L6;
        b();
    L6:
        return f277471b;
    }

    private static synchronized void b() {
        monitor-enter(y.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f277471b != null) goto L7;
        f277471b = new y();     // Catch: Throwable -> L9
    L7:
        monitor-exit(y.class);
    }

    public p0 a(String r100, long r101) {
        p0 r102 = a(r100);
        r102.a(r101);
        return r102;
    }
}
