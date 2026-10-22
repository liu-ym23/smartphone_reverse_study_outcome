package com.ss.ugc.effectplatform.task.algorithm;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0.a f457727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.f f457728b;

    public f() {
        this.f457727a = new c0.a(false);
        this.f457728b = new c0.f();
    }

    public final void a(Function0<Unit> r100) {
        this.f457727a.b(true);
        r100.invoke();
        c0.f r101 = this.f457728b;
        Object r102 = r101.f21901a;
        monitor-enter(r102);
        r101.f21901a.notifyAll();     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(Function0<Unit> r100) {
        if (this.f457727a.a() == false) goto L5;
        return;
    L5:
        r100.invoke();
        c0.f r101 = this.f457728b;
        Object r102 = r101.f21901a;
        monitor-enter(r102);
        r101.f21901a.wait();     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
