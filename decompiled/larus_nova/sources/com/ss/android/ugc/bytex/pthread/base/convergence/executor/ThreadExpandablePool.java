package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ThreadExpandablePool;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ExpandablePool;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "isCacheExecutor", "", "(Ljava/util/concurrent/ThreadPoolExecutor;Z)V", "getConsumeCount", "", "getMaxPoolSize", "", "getPendingCount", "getPoolSize", "setMaxPoolSize", "", "maxPoolSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadExpandablePool implements ExpandablePool {
    private final ThreadPoolExecutor executor;
    private final boolean isCacheExecutor;

    public ThreadExpandablePool(ThreadPoolExecutor r100, boolean r101) {
        this.executor = r100;
        this.isCacheExecutor = r101;
    }

    public /* synthetic */ ThreadExpandablePool(ThreadPoolExecutor r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public long getConsumeCount() {
        return this.executor.getCompletedTaskCount();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public int getMaxPoolSize() {
        if (this.isCacheExecutor == false) goto L6;
        return this.executor.getMaximumPoolSize();
    L6:
        return this.executor.getCorePoolSize();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public int getPendingCount() {
        return this.executor.getQueue().size();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public int getPoolSize() {
        return this.executor.getPoolSize();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public void setMaxPoolSize(int r100) {
        if (this.isCacheExecutor == false) goto L5;
        this.executor.setMaximumPoolSize(r100);
        return;
    L5:
        this.executor.setCorePoolSize(r100);
    }
}
