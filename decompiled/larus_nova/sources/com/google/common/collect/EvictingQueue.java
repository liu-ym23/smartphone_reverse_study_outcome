package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class EvictingQueue<E> extends p0<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return super.toArray();
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public Queue<E> delegate() {
        return this.delegate;
    }

    public EvictingQueue(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        com.google.common.base.m.d(r101, "maxSize (%s) must >= 0", r100);
        this.delegate = new ArrayDeque(r100);
        this.maxSize = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static <E> EvictingQueue<E> create(int r100) {
        return new EvictingQueue(r100);
    }

    @Override // com.google.common.collect.f0, java.util.Collection, java.util.Queue
    public boolean add(E r100) {
        r100.getClass();
        if (this.maxSize != 0) goto L6;
        return true;
    L6:
        if (size() != this.maxSize) goto L8;
        this.delegate.remove();
    L8:
        this.delegate.add(r100);
        return true;
    }

    @Override // com.google.common.collect.f0, java.util.Collection
    public boolean addAll(Collection<? extends E> r100) {
        int r101 = r100.size();
        if (r101 < this.maxSize) goto L11;
        clear();
        int r102 = r101 - this.maxSize;
        if (r102 < 0) goto L7;
        boolean r103 = true;
    L8:
        com.google.common.base.m.c(r103, "number to skip cannot be negative");
        return a1.a(this, new z0(r100, r102));
    L7:
        r103 = false;
        goto L8
    L11:
        return standardAddAll(r100);
    }

    @Override // com.google.common.collect.p0, java.util.Queue
    public boolean offer(E r100) {
        return add(r100);
    }
}
