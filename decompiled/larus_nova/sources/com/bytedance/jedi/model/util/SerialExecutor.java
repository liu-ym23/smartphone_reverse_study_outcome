package com.bytedance.jedi.model.util;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/model/util/SerialExecutor;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "Companion", "model_release"}, k = 1, mv = {1, 7, 1})
public final class SerialExecutor implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f251205c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<ThreadPoolExecutor> f251206d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<Runnable> f251207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Runnable> f251208b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/util/SerialExecutor$Companion;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        AtomicReference<Runnable> r100 = this.f251208b;     // Catch: Throwable -> L10
        Runnable r101 = this.f251207a.poll();     // Catch: Throwable -> L10
        if (r101 == null) goto L6;
        f251205c.getClass();     // Catch: Throwable -> L10
        f251206d.getValue().execute(r101);     // Catch: Throwable -> L10
    L7:
        r100.set(r101);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        f251205c = new Companion(0);
        f251206d = LazyKt.lazy(SerialExecutor$Companion$THREAD_POOL_EXECUTOR$2.INSTANCE);
    }

    public SerialExecutor() {
        this.f251207a = new LinkedBlockingQueue();
        this.f251208b = new AtomicReference();
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(final Runnable r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "r");     // Catch: Throwable -> L8
        this.f251207a.offer(new a(r100, this));     // Catch: Throwable -> L8
        if (this.f251208b.get() != null) goto L6;
        a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
