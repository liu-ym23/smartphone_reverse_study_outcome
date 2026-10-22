package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends ArrayList<Object[]>> f405103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<? super Function0<? extends T>, ? super Function0<Integer>, ? extends j5> f405104b;

    public g3(Function0<? extends ArrayList<Object[]>> r100, Function2<? super Function0<? extends T>, ? super Function0<Integer>, ? extends j5> r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, "renderItem");
        this.f405103a = r100;
        this.f405104b = r101;
    }
}
