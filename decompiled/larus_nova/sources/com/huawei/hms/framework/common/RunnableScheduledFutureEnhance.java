package com.huawei.hms.framework.common;

import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
public class RunnableScheduledFutureEnhance<T> implements RunnableScheduledFuture<T> {
    private String parentName;
    private RunnableScheduledFuture<T> proxy;

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return (T) this.proxy.get();
    }

    public int hashCode() {
        return this.proxy.hashCode();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.proxy.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.proxy.isDone();
    }

    @Override // java.util.concurrent.RunnableScheduledFuture
    public boolean isPeriodic() {
        return this.proxy.isPeriodic();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.proxy.run();
    }

    public String getParentName() {
        return this.parentName;
    }

    public RunnableScheduledFutureEnhance(RunnableScheduledFuture<T> r100) {
        this.parentName = Thread.currentThread().getName();
        this.proxy = r100;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        return this.proxy.cancel(r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Delayed r100) {
        return compareTo2(r100);
    }

    public boolean equals(Object r100) {
        return this.proxy.equals(r100);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit r100) {
        return this.proxy.getDelay(r100);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Delayed r100) {
        return this.proxy.compareTo(r100);
    }

    @Override // java.util.concurrent.Future
    public T get(long r100, TimeUnit r101) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.proxy.get(r100, r101);
    }
}
