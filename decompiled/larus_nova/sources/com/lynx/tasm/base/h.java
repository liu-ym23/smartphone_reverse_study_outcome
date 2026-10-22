package com.lynx.tasm.base;

import androidx.core.util.Consumer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public final class h<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f381870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FutureTask<T> f381871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Consumer<Exception> f381872c;

    public final T a() {
        return this.f381871b.get();
    L4:
        e = move-exception;
        LLog.e("OnceTask", "Get result from OnceTask failed since: " + e.toString());
        Consumer<Exception> r100 = this.f381872c;
        if (r100 == null) goto L12;
        r100.accept(e);
        return null;
    L12:
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f381870a.compareAndSet(false, true) == false) goto L9;
        this.f381871b.run();     // Catch: Throwable -> L6
        return;
    }

    public h(Callable<T> r100, Consumer<Exception> r101) {
        this.f381870a = new AtomicBoolean(false);
        this.f381872c = null;
        this.f381871b = new FutureTask(r100);
        this.f381872c = r101;
    }
}
