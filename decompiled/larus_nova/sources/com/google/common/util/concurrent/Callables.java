package com.google.common.util.concurrent;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Callables {
    private Callables() {
    }

    public static /* synthetic */ Object a(com.google.common.base.t r100, Callable r101) {
        return lambda$threadRenaming$2(r100, r101);
    }

    public static /* synthetic */ void b(com.google.common.base.t r100, Runnable r101) {
        lambda$threadRenaming$3(r100, r101);
    }

    public static /* synthetic */ Object c(Object r100) {
        return lambda$returning$0(r100);
    }

    public static /* synthetic */ ListenableFuture d(ListeningExecutorService r100, Callable r101) {
        return lambda$asAsyncCallable$1(r100, r101);
    }

    private static /* synthetic */ Object lambda$returning$0(Object r100) throws Exception {
        return r100;
    }

    public static <T> Callable<T> returning(@ParametricNullness final T r100) {
        return new m(r100);
    }

    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> r100, final ListeningExecutorService r101) {
        r100.getClass();
        r101.getClass();
        return new p(r101, r100);
    }

    private static /* synthetic */ ListenableFuture lambda$asAsyncCallable$1(ListeningExecutorService r100, Callable r101) throws Exception {
        return r100.submit(r101);
    }

    private static /* synthetic */ Object lambda$threadRenaming$2(com.google.common.base.t r100, Callable r101) throws Exception {
        Thread r102 = ThreadMethodProxy.currentThread();
        String r103 = r102.getName();
        boolean r104 = trySetName((String) r100.get(), r102);
        Object r105 = r101.call();     // Catch: Throwable -> L7
        if (r104 == false) goto L6;
        trySetName(r103, r102);
    L6:
        return r105;
    L7:
        th = move-exception;
        if (r104 == false) goto L10;
        trySetName(r103, r102);
    L10:
        throw th;
    }

    private static /* synthetic */ void lambda$threadRenaming$3(com.google.common.base.t r100, Runnable r101) {
        Thread r102 = ThreadMethodProxy.currentThread();
        String r103 = r102.getName();
        boolean r104 = trySetName((String) r100.get(), r102);
        r101.run();     // Catch: Throwable -> L7
        if (r104 == false) goto L13;
        trySetName(r103, r102);
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r104 == false) goto L10;
        trySetName(r103, r102);
    L10:
        throw th;
    }

    public static Runnable threadRenaming(final Runnable r100, final com.google.common.base.t<String> r101) {
        r101.getClass();
        r100.getClass();
        return new n(r101, r100);
    }

    private static boolean trySetName(String r100, Thread r101) {
        ThreadMethodProxy.setName(r101, r100);     // Catch: SecurityException -> L5
        return true;
    L5:
        return false;
    }

    public static <T> Callable<T> threadRenaming(final Callable<T> r100, final com.google.common.base.t<String> r101) {
        r101.getClass();
        r100.getClass();
        return new o(r101, r100);
    }
}
