package com.ss.ugc.live.sdk.msg.utils.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.g;
import com.ss.ugc.live.sdk.msg.utils.j;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f458506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<a> f458507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<a> f458508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f458509d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Future<?> f458510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<?, ?> f458511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f458512c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f458512c.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, d.b r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Intrinsics.checkNotNullParameter(r101, "taskExecute");
            this.f458511b = r100;
            this.f458512c = r101;
        }
    }

    public c(ExecutorService r100) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        this.f458509d = r100;
        this.f458506a = new ReentrantLock();
        this.f458507b = new AtomicReference();
        this.f458508c = new ConcurrentLinkedQueue();
    }

    public static final void a(c r100, a r101) {
        r100.f458506a.lock();
        if (r101 != null) goto L20;
    L5:
        a r102 = r100.f458508c.poll();     // Catch: Throwable -> L9
        if (r102 == null) goto L15;
        r100.f458507b.getAndSet(r102);     // Catch: Throwable -> L9
        r102.f458510a = r100.f458509d.submit(r102);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        if (r101 == null) goto L15;
        b<?, ?> r103 = r101.f458511b;     // Catch: Throwable -> L17
        if (r103 == null) goto L15;
        TaskState<?, ?, b<?, ?>> r104 = r103.f458504a;     // Catch: Throwable -> L17
        int r105 = g.f458477a;     // Catch: Throwable -> L17
        g.b r106 = g.a.a(new Throwable("Task cancel"));     // Catch: Throwable -> L17
        r104.getClass();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r106, "result");     // Catch: Throwable -> L17
        r104.f458488d.d(new TaskState.a.C5505a(r106));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r100.f458506a.unlock();
        throw th;
    L15:
        r100.f458506a.unlock();
        return;
    L20:
        r100.f458508c.offer(r101);     // Catch: Throwable -> L9
        goto L5
    }

    public final void b(com.ss.ugc.live.sdk.msg.utils.task.a r100, Object r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r102, "resultHandler");
        MainTaskScheduler.a(new d(this, r100, r102, r101));
    }
}
