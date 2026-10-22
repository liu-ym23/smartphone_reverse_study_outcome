package com.google.common.collect;

import java.util.Collection;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class p0<E> extends f0<E> implements Queue<E> {
    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public abstract Queue<E> delegate();

    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Queue
    @ParametricNullness
    public E element() {
        return delegate().element();
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CheckForNull
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @ParametricNullness
    public E remove() {
        return delegate().remove();
    }

    @CheckForNull
    public E standardPeek() {
        return element();
    L4:
        return null;
    }

    @CheckForNull
    public E standardPoll() {
        return remove();
    L4:
        return null;
    }

    public p0() {
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    public boolean offer(@ParametricNullness E r100) {
        return delegate().offer(r100);
    }

    public boolean standardOffer(@ParametricNullness E r100) {
        return add(r100);
    L4:
        return false;
    }
}
