package com.ss.android.ugc.route_monitor.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public final class q<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<? extends T> f454779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f454780b;

    public q(Function0<? extends T> r100) {
        this.f454779a = r100;
        this.f454780b = w.f454785a;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        T r102 = (T) this.f454780b;
        w r103 = w.f454785a;
        if (r102 == r103) goto L5;
        return r102;
    L5:
        monitor-enter(this);
        T r104 = (T) this.f454780b;
        if (r104 != r103) goto L13;
        Function0<? extends T> r105 = this.f454779a;     // Catch: Throwable -> L15
        if (r105 != null) goto L12;
        Intrinsics.throwNpe();     // Catch: Throwable -> L15
    L12:
        r104 = r105.invoke();     // Catch: Throwable -> L15
        this.f454780b = r104;     // Catch: Throwable -> L15
        this.f454779a = null;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r104;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty<?> r101, T r102) {
        this.f454780b = r102;
    }
}
