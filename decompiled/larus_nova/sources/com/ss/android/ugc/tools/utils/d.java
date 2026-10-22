package com.ss.android.ugc.tools.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d extends PThreadPoolExecutor {
    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "callable");
        if ((r100 instanceof Comparable) == true) goto L5;
        Callable<T> r101 = null;
    L7:
        return new c(r100, (Comparable) r101);
    L5:
        r101 = r100;
        goto L7
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if ((r100 instanceof Comparable) == true) goto L5;
        Runnable r102 = null;
    L7:
        return new c(r100, r101, (Comparable) r102);
    L5:
        r102 = r100;
        goto L7
    }
}
