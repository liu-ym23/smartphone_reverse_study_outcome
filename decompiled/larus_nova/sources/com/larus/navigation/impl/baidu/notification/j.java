package com.larus.navigation.impl.baidu.notification;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f359814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f359815b;

    public j() {
    }

    public final synchronized void a(Function1<? super T, Unit> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "action");     // Catch: Throwable -> L6
        T r101 = this.f359814a;     // Catch: Throwable -> L6
        this.f359815b++;     // Catch: Throwable -> L6
        this.f359814a = null;     // Catch: Throwable -> L6
        r100.invoke(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
