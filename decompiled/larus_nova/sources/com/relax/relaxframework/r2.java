package com.relax.relaxframework;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class r2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RxListItemElement f405246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f405247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super Function1<? super T, ? extends T>, Unit> f405248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f405249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Function1<? super Integer, Integer>, Unit> f405250e;

    public r2(RxListItemElement r100, T r101, Function1<? super Function1<? super T, ? extends T>, Unit> r102, int r103, Function1<? super Function1<? super Integer, Integer>, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Intrinsics.checkNotNullParameter(r102, "itemSetter");
        Intrinsics.checkNotNullParameter(r104, "indexSetter");
        this.f405246a = r100;
        this.f405247b = r101;
        this.f405248c = r102;
        this.f405249d = r103;
        this.f405250e = r104;
    }
}
