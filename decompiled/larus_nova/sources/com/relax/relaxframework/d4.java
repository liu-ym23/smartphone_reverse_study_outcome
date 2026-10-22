package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d4<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends ArrayList<T>> f405057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<? super Function0<? extends T>, ? super Function0<Integer>, ? extends j5> f405058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<? super T, ? super Integer, String> f405059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<? super T, ? super Integer, String> f405060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f405061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l7 f405062f;

    public d4(Function0 r100, Function2 r101, Function2 r102, Integer r103, s5 r104) {
        Intrinsics.checkNotNullParameter(r100, "each");
        Intrinsics.checkNotNullParameter(r101, "renderItem");
        this.f405057a = r100;
        this.f405058b = r101;
        this.f405059c = r102;
        this.f405060d = null;
        this.f405061e = r103;
        this.f405062f = r104;
    }
}
