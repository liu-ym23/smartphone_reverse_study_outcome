package com.google.common.util.concurrent;

import com.google.common.collect.h0;
import java.util.Collection;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingDeque<E> extends h0<E> implements BlockingDeque<E> {
    @Override // com.google.common.collect.h0, com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public abstract BlockingDeque<E> delegate();

    @Override // com.google.common.collect.h0, com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        return delegate().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        return delegate().takeLast();
    }

    public ForwardingBlockingDeque() {
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Deque delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Queue delegate() {
        return delegate();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r100) {
        return delegate().drainTo(r100);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E r100) throws InterruptedException {
        delegate().put(r100);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E r100) throws InterruptedException {
        delegate().putFirst(r100);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E r100) throws InterruptedException {
        delegate().putLast(r100);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r100, int r101) {
        return delegate().drainTo(r100, r101);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    @CheckForNull
    public E poll(long r100, TimeUnit r101) throws InterruptedException {
        return delegate().poll(r100, r101);
    }

    @Override // java.util.concurrent.BlockingDeque
    @CheckForNull
    public E pollFirst(long r100, TimeUnit r101) throws InterruptedException {
        return delegate().pollFirst(r100, r101);
    }

    @Override // java.util.concurrent.BlockingDeque
    @CheckForNull
    public E pollLast(long r100, TimeUnit r101) throws InterruptedException {
        return delegate().pollLast(r100, r101);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E r100, long r101, TimeUnit r102) throws InterruptedException {
        return delegate().offer(r100, r101, r102);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E r100, long r101, TimeUnit r102) throws InterruptedException {
        return delegate().offerFirst(r100, r101, r102);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E r100, long r101, TimeUnit r102) throws InterruptedException {
        return delegate().offerLast(r100, r101, r102);
    }
}
