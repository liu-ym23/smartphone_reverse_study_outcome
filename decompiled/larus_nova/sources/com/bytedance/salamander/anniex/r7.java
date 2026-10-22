package com.bytedance.salamander.anniex;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class r7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<? super T, ? super Function0<? extends ArrayList<com.relax.relaxframework.j5>>, ? extends com.relax.relaxframework.j5> f268360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f268361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f268362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0 f268363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super ppa.b, ? extends ppa.b> f268364e;

    /* JADX WARN: Multi-variable type inference failed */
    public r7(Function2 r100, Object r101, t0 r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f268360a = r100;
        this.f268361b = r101;
        this.f268362c = null;
        this.f268363d = r102;
        this.f268364e = r103;
    }
}
