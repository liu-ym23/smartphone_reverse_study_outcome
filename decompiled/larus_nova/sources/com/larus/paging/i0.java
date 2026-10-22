package com.larus.paging;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes29.dex */
public final class i0<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow<k0<Value>> f363862a;

    public i0(j0 r100, com.larus.search.impl.global.u r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "pagingSourceFactory");
        if ((r101 instanceof c1) == false) goto L5;
        Function1 r102 = new Pager$flow$1(r101);
    L6:
        this.f363862a = new c0(r102, r100).f363792f;
        return;
    L5:
        r102 = new Pager$flow$2(r101, null);
        goto L6
    }
}
