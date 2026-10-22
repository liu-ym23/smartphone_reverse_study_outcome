package com.oplus.ocs.base.task;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes34.dex */
public final class q<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f404305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<b<TResult>> f404306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f404307c;

    public q() {
        this.f404305a = new Object();
    }

    public final void a(Task<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Task is not be null");
        Object r101 = this.f404305a;
        monitor-enter(r101);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.f404306b != null) goto L7;
    L23:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return;
    L7:
        if (this.f404307c == true) goto L23;
        this.f404307c = true;     // Catch: Throwable -> L25
        monitor-exit(r101);     // Catch: Throwable -> L25
    L11:
        Object r102 = this.f404305a;
        monitor-enter(r102);
        b<TResult> r103 = this.f404306b.poll();     // Catch: Throwable -> L20
        if (r103 == null) goto L15;
        monitor-exit(r102);     // Catch: Throwable -> L20
        r103.a(r100);
        goto L11
    L15:
        this.f404307c = false;     // Catch: Throwable -> L20
        monitor-exit(r102);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void a(b<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Cancellable is not be null");
        Object r101 = this.f404305a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f404306b != null) goto L7;
        this.f404306b = new ArrayDeque();     // Catch: Throwable -> L10
    L7:
        this.f404306b.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }
}
