package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.BusyLevel;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\rH\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerThreadPool;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerThreadPool;", "()V", "pool", "", "", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/ReuseHandlerThread;", "[Ljava/util/List;", "threadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "createNewThread", "queue", "level", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/BusyLevel;", "name", "", "obtain", "Landroid/os/HandlerThread;", "getThreadQueue", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerThreadPool implements IHandlerThreadPool {
    private final List<ReuseHandlerThread>[] pool;
    private final AtomicInteger threadCount;

    public HandlerThreadPool() {
        this.threadCount = new AtomicInteger();
        this.pool = new List[BusyLevel.values().length];
    }

    private final ReuseHandlerThread createNewThread(List<ReuseHandlerThread> r100, BusyLevel r101, String r102) {
        ReuseHandlerThread r103 = new ReuseHandlerThread("#Reuse-" + r101.name() + '-' + this.threadCount.incrementAndGet(), r101.getReuseCount());
        r103.start();
        monitor-enter(r100);
        r100.add(r103);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    private final List<ReuseHandlerThread> getThreadQueue(BusyLevel r100) {
        List<ReuseHandlerThread> r101 = this.pool[r100.ordinal()];
        if (r101 == null) goto L5;
        return r101;
    L5:
        ArrayList r102 = new ArrayList();
        List<ReuseHandlerThread>[] r103 = this.pool;
        monitor-enter(r103);
        List<ReuseHandlerThread> r104 = this.pool[r100.ordinal()];     // Catch: Throwable -> L14
        if (r104 == null) goto L11;
        monitor-exit(r103);
        return r104;
    L11:
        this.pool[r100.ordinal()] = r102;     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r103);
        return r102;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerThreadPool
    public HandlerThread obtain(BusyLevel r100, String r101) {
        List<ReuseHandlerThread> r102 = getThreadQueue(r100);
        monitor-enter(r102);
        Iterator<T> r103 = r102.iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L11;
        ReuseHandlerThread r104 = (ReuseHandlerThread) r103.next();     // Catch: Throwable -> L15
        if (r104.reuse(r101) == false) goto L6;
        monitor-exit(r102);
        return r104;
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r102);
        return createNewThread(r102, r100, r101);
    L15:
        th = move-exception;
        throw th;
    }
}
