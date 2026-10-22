package com.lark.kmp.rustclient.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e0 extends BaseRustDispatcher implements hy7.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f282551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f282552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final buc.a f282553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayDeque<rpc.c> f282554j;

    public static final class a {
    }

    static {
    }

    @Override // hy7.d
    public final void a(gy7.u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // hy7.d
    public final void b(gy7.u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // hy7.d
    public final void c(gy7.u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Object r101 = this.f282552h;
        monitor-enter(r101);
        this.f282553i.d(false);     // Catch: Throwable -> L11
        Iterator<rpc.c> r102 = this.f282554j.iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        j(r102.next());     // Catch: Throwable -> L11
        goto L6
    L8:
        this.f282554j.clear();     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // hy7.d
    public final void f(gy7.u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // rpc.b
    public final void h(rpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        k(r100);
    }

    @Override // rpc.b
    public final void i(rpc.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r101 = this.f282552h;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f282553i.c() == false) goto L10;
        this.f282554j.addLast(r100);     // Catch: Throwable -> L14
    L8:
        if (this.f282554j.size() <= 1000) goto L11;
        this.f282554j.removeFirst();     // Catch: Throwable -> L14
    L11:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return;
    L10:
        j(r100);     // Catch: Throwable -> L14
        goto L11
    }

    public e0(r r100, List<? extends com.lark.kmp.rustclient.api.c> r101) {
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        super(r101, r100.c(), r100.a());
        this.f282551g = r100;
        this.f282552h = new Object();
        this.f282553i = buc.b.a(true);
        this.f282554j = new ArrayDeque();
    }
}
