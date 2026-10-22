package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class ForwardingCondition implements Condition {
    public ForwardingCondition() {
    }

    public abstract Condition delegate();

    @Override // java.util.concurrent.locks.Condition
    public void await() throws InterruptedException {
        delegate().await();
    }

    @Override // java.util.concurrent.locks.Condition
    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    @Override // java.util.concurrent.locks.Condition
    public void signal() {
        delegate().signal();
    }

    @Override // java.util.concurrent.locks.Condition
    public void signalAll() {
        delegate().signalAll();
    }

    @Override // java.util.concurrent.locks.Condition
    public long awaitNanos(long r100) throws InterruptedException {
        return delegate().awaitNanos(r100);
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean awaitUntil(Date r100) throws InterruptedException {
        return delegate().awaitUntil(r100);
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean await(long r100, TimeUnit r101) throws InterruptedException {
        return delegate().await(r100, r101);
    }
}
