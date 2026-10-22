package com.bytedance.assem.arch.threadpool;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SerialExecutor implements Executor {
    public static final Lazy c = null;
    public final LinkedBlockingQueue<Runnable> a;
    public Runnable b;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SerialExecutor a;
        public final /* synthetic */ Runnable b;

        public b(SerialExecutor r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.run();     // Catch: Throwable -> L4
            this.a.a();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L4:
            th = move-exception;
            this.a.a();     // Catch: Throwable -> L7
            throw th;     // Catch: Throwable -> L7
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        Runnable r0 = this.a.poll();     // Catch: Throwable -> L10
        if (r0 == null) goto L6;
        ((ExecutorService) c.getValue()).execute(r0);     // Catch: Throwable -> L10
    L7:
        this.b = r0;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = null;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.NONE, SerialExecutor$Companion$WORKER$2.INSTANCE);
    }

    public SerialExecutor() {
        this.a = new LinkedBlockingQueue();
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable r3) {
        monitor-enter(this);
        this.a.offer(new b(this, r3));     // Catch: Throwable -> L8
        if (this.b != null) goto L6;
        a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
