package com.relax.relaxframework;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<? super String, ? super Function1<Object, Unit>, Object, ? extends Function0<Unit>> f405348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<? super String, Object, Unit> f405349b;

    public x0(Function3<? super String, ? super Function1<Object, Unit>, Object, ? extends Function0<Unit>> r100, Function2<? super String, Object, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "on");
        Intrinsics.checkNotNullParameter(r101, "emit");
        this.f405348a = r100;
        this.f405349b = r101;
    }
}
