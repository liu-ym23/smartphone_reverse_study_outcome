package com.google.common.util.concurrent;

import com.google.common.collect.p0;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingQueue<E> extends p0<E> implements BlockingQueue<E> {
    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public abstract BlockingQueue<E> delegate();

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }

    public ForwardingBlockingQueue() {
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Queue delegate() {
        return delegate();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r100) {
        return delegate().drainTo(r100);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E r100) throws InterruptedException {
        delegate().put(r100);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r100, int r101) {
        return delegate().drainTo(r100, r101);
    }

    @Override // java.util.concurrent.BlockingQueue
    @CheckForNull
    public E poll(long r100, TimeUnit r101) throws InterruptedException {
        return delegate().poll(r100, r101);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E r100, long r101, TimeUnit r102) throws InterruptedException {
        return delegate().offer(r100, r101, r102);
    }
}
