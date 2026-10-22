package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f405122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f405123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super ArrayList<Object[]>, Unit> f405124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super ArrayList<Integer>, Unit> f405125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f405126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Function0<Integer>, ? extends Function0<Double>> f405127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<? super Function0<Integer>, ? extends Function0<Double>> f405128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<? super Function0<Integer>, ? extends Function0<Integer>> f405129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Integer> f405130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<? extends ArrayList<Object[]>> f405131j;

    public i2(Function1<? super Integer, Unit> r100, Function1<? super Integer, Unit> r101, Function1<? super ArrayList<Object[]>, Unit> r102, Function1<? super ArrayList<Integer>, Unit> r103, Function1<? super Integer, Unit> r104, Function1<? super Function0<Integer>, ? extends Function0<Double>> r105, Function1<? super Function0<Integer>, ? extends Function0<Double>> r106, Function1<? super Function0<Integer>, ? extends Function0<Integer>> r107, Function0<Integer> r110, Function0<? extends ArrayList<Object[]>> r111) {
        Intrinsics.checkNotNullParameter(r100, "setScrollOffset");
        Intrinsics.checkNotNullParameter(r101, "setRootSize");
        Intrinsics.checkNotNullParameter(r102, "setItems");
        Intrinsics.checkNotNullParameter(r103, "setItemSizes");
        Intrinsics.checkNotNullParameter(r104, "setOverscanCount");
        Intrinsics.checkNotNullParameter(r105, "getUpperThreshold");
        Intrinsics.checkNotNullParameter(r106, "getLowerThreshold");
        Intrinsics.checkNotNullParameter(r107, "getItemOffset___");
        Intrinsics.checkNotNullParameter(r110, "containerSize___");
        Intrinsics.checkNotNullParameter(r111, "filteredItems___");
        this.f405122a = r100;
        this.f405123b = r101;
        this.f405124c = r102;
        this.f405125d = r103;
        this.f405126e = r104;
        this.f405127f = r105;
        this.f405128g = r106;
        this.f405129h = r107;
        this.f405130i = r110;
        this.f405131j = r111;
    }
}
