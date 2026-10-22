package com.ss.android.ugc.tools.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c<V> extends FutureTask<V> implements Comparable<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable<?> f454858a;

    @Override // java.lang.Comparable
    public final int compareTo(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof c) == false) goto L5;
        r100 = ((c) r100).f454858a;
    L5:
        Comparable<?> r101 = this.f454858a;
        if (r101 == null) goto L12;
        if (r100 == null) goto L12;
        if (r101 == null) goto L11;
        return r101.compareTo(r100);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Comparable<kotlin.Any>");
    L12:
        return 0;
    }

    public c(Callable<V> r100, Comparable<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "callable");
        super(r100);
        this.f454858a = r101;
    }

    public c(Runnable r100, V r101, Comparable<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        super(r100, r101);
        this.f454858a = r102;
    }
}
