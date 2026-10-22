package com.bytedance.assem.arch.threadpool;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes14.dex */
public final class SerialExecutor implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f193048c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<Runnable> f193049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f193050b;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SerialExecutor f193051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f193052b;

        public b(SerialExecutor r100, Runnable r101) {
            this.f193051a = r100;
            this.f193052b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f193052b.run();     // Catch: Throwable -> L4
            this.f193051a.a();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L4:
            th = move-exception;
            this.f193051a.a();     // Catch: Throwable -> L7
            throw th;     // Catch: Throwable -> L7
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        Runnable r100 = this.f193049a.poll();     // Catch: Throwable -> L10
        if (r100 == null) goto L6;
        ((ExecutorService) f193048c.getValue()).execute(r100);     // Catch: Throwable -> L10
    L7:
        this.f193050b = r100;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r100 = null;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        f193048c = LazyKt.lazy(LazyThreadSafetyMode.NONE, SerialExecutor$Companion$WORKER$2.INSTANCE);
    }

    public SerialExecutor() {
        this.f193049a = new LinkedBlockingQueue();
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable r100) {
        monitor-enter(this);
        this.f193049a.offer(new b(this, r100));     // Catch: Throwable -> L8
        if (this.f193050b != null) goto L6;
        a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
