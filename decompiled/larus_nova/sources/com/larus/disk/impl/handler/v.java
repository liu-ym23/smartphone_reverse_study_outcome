package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class v implements com.larus.disk.api.d {

    public static final class a {
    }

    public static final class b {
    }

    static {
    }

    public v() {
        throw null;
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return "message_cache";
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return "message_cache";
    }

    @Override // com.larus.disk.api.d
    public final synchronized long d() {
        monitor-enter(this);
        query(l(false, true)).getClass();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.disk.api.d
    public final boolean e(boolean r100) {
        return false;
    }

    @Override // com.larus.disk.api.d
    public final boolean f() {
        return true;
    }

    @Override // com.larus.disk.api.c
    public final synchronized long getCacheSize() {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return true;
    }

    public final synchronized void k() {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        return new PolarisFileWrapper(aa9.a.f2357a.a(), ".message_cache_eviction_provider").getAbsolutePath();
    }

    @Override // com.larus.disk.api.d
    public final boolean g() {
        throw null;
    }

    private final b query(com.larus.disk.api.k r100) {
        r100.getClass();
        Lazy r101 = com.larus.disk.impl.d.f330625a;
        if (Intrinsics.areEqual(null, com.larus.disk.impl.d.c()) == true) goto L7;
        throw new IllegalStateException("Message cache account changed before query".toString());
    L7:
        throw null;
    }

    @Override // com.larus.disk.api.c
    public final synchronized long b(boolean r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (g() == true) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        query(l(r100, false)).getClass();     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    }

    public final synchronized void j(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "accountScope");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.disk.api.d
    public final synchronized boolean c(boolean r100, boolean r101) {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.larus.disk.api.c
    public final synchronized void h(boolean r100, boolean r101) {
        monitor-enter(this);
        if (r101 == true) goto L8;
        throw null;     // Catch: Throwable -> L6
    L8:
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final com.larus.disk.api.k l(boolean r100, boolean r101) {
        throw null;
    }
}
