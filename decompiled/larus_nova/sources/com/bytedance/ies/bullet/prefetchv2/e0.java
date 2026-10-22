package com.bytedance.ies.bullet.prefetchv2;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, z> f247529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f247530b = null;

    static {
        f247529a = new ConcurrentHashMap(16);
        f247530b = new Object();
    }

    public static void a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Object r101 = f247530b;
        monitor-enter(r101);
        z r102 = f247529a.remove(r100.f247575l);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Object r101 = f247530b;
        monitor-enter(r101);
        z r102 = f247529a.remove(r100.f247575l);     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.a();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
