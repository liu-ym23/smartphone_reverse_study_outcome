package com.bytedance.bdnavigationsdk;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y implements x, com.bytedance.bdnavigationsdk.network.route.o.b {
    public final Object b;
    public com.bytedance.bdnavigationsdk.network.route.o c;
    public z d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.bdnavigationsdk.x
    public final void destroy() {
        Object r0 = this.b;
        monitor-enter(r0);
        com.bytedance.bdnavigationsdk.network.route.o r1 = this.c;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        JobKt.cancel$default(r1.c.getCoroutineContext(), null, 1, null);     // Catch: Throwable -> L12
        c r2 = r1.a;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.close();     // Catch: Throwable -> L12
    L9:
        this.c = null;     // Catch: Throwable -> L12
        this.d = null;     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public y() {
        this.b = new Object();
        com.bytedance.bdnavigationsdk.network.route.o r0 = new com.bytedance.bdnavigationsdk.network.route.o();
        this.c = r0;
        Intrinsics.checkNotNull(r0);
        r0.d = this;
    }

    @Override // com.bytedance.bdnavigationsdk.network.route.o.b
    public final void a(com.bytedance.bdnavigationsdk.network.route.p r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        Object r0 = this.b;
        monitor-enter(r0);
        r84.a.d(null, "路径规划回调处理成功", 5);     // Catch: Throwable -> L10
        z r1 = this.d;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.a(r5);     // Catch: Throwable -> L10
    L7:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdnavigationsdk.x
    public final void b(com.bytedance.navigation.kmp.capability.navigation.g r2) {
        Object r0 = this.b;
        monitor-enter(r0);
        this.d = r2;     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdnavigationsdk.network.route.o.b
    public final void c(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        Object r0 = this.b;
        monitor-enter(r0);
        r84.a.b("路径规划回调处理失败", r4, 1);     // Catch: Throwable -> L10
        z r1 = this.d;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.b(r4);     // Catch: Throwable -> L10
    L7:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdnavigationsdk.x
    public final void d(com.bytedance.bdnavigationsdk.network.route.j r6) {
        Object r0 = this.b;
        monitor-enter(r0);
        b r1 = d.a;     // Catch: Exception -> L13 Throwable -> L17
        if (d.c == false) goto L12;
        final com.bytedance.bdnavigationsdk.network.route.o r2 = this.c;     // Catch: Exception -> L13 Throwable -> L17
        if (r2 == null) goto L10;
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L13 Throwable -> L17
        r2.e(r6, "", new com.bytedance.bdnavigationsdk.network.route.m(r2), new com.bytedance.bdnavigationsdk.network.route.n(r2));     // Catch: Exception -> L13 Throwable -> L17
    L19:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L10:
        throw new Exception("路径规划服务未初始化");     // Catch: Exception -> L13 Throwable -> L17
    L12:
        throw new Exception("BDNAInit尚未初始化");     // Catch: Exception -> L13 Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        r84.a.b("路径规划回调处理失败", e, 1);     // Catch: Throwable -> L17
        z r3 = this.d;     // Catch: Throwable -> L17
        if (r3 == null) goto L19;
        r3.b(e);     // Catch: Throwable -> L17
        goto L19
    }
}
