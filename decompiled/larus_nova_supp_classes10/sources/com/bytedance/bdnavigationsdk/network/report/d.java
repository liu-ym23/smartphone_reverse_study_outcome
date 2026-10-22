package com.bytedance.bdnavigationsdk.network.report;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements j.b {
    public static a a;
    public static final j b = null;
    public static final Object c = null;

    public d() {
    }

    static {
        d r0 = new d();
        a r1 = new a(Boolean.TRUE, 2);
        c = new Object();
        a = r1;
        j r2 = new j();
        b = r2;
        Intrinsics.checkNotNull(r2);
        r2.d = r0;
    }

    public static a c() {
        Object r0 = c;
        monitor-enter(r0);
        a r1 = a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void d(f r3) {
        Intrinsics.checkNotNullParameter(r3, "reportParam");
        Object r0 = c;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(a.a, Boolean.FALSE) == false) goto L8;
        monitor-exit(r0);
        return;
    L8:
        j r1 = b;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L11
        r1.c(r3);     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
    }

    @Override // com.bytedance.bdnavigationsdk.network.report.j.b
    public final void a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        r84.a.d(null, "上报回调处理成功", 5);
    }

    @Override // com.bytedance.bdnavigationsdk.network.report.j.b
    public final void b(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        r84.a.b("上报回调处理失败", r3, 1);
    }
}
