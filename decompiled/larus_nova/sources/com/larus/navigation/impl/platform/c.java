package com.larus.navigation.impl.platform;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f359933a = null;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.navigation.impl.platform.b] */
    static {
        f359933a = new d(new b());
    }

    public static e a() {
        d r100 = f359933a;
        monitor-enter(r100);
        e r101 = new e(r100.f359934a.invoke().booleanValue());     // Catch: Throwable -> L7
        r100.f359935b = r101;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
