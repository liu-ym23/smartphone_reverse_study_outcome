package com.google.common.collect;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class h0<E> extends p0<E> implements Deque<E> {
    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public abstract Deque<E> delegate();

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.Deque
    @ParametricNullness
    public E getFirst() {
        return delegate().getFirst();
    }

    @Override // java.util.Deque
    @ParametricNullness
    public E getLast() {
        return delegate().getLast();
    }

    @Override // java.util.Deque
    @CheckForNull
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @Override // java.util.Deque
    @CheckForNull
    public E peekLast() {
        return delegate().peekLast();
    }

    @Override // java.util.Deque
    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.Deque
    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // java.util.Deque
    @ParametricNullness
    public E pop() {
        return delegate().pop();
    }

    @Override // java.util.Deque
    @ParametricNullness
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @Override // java.util.Deque
    @ParametricNullness
    public E removeLast() {
        return delegate().removeLast();
    }

    public h0() {
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Queue delegate() {
        return delegate();
    }

    @Override // java.util.Deque
    public void addFirst(@ParametricNullness E r100) {
        delegate().addFirst(r100);
    }

    @Override // java.util.Deque
    public void addLast(@ParametricNullness E r100) {
        delegate().addLast(r100);
    }

    @Override // java.util.Deque
    public boolean offerFirst(@ParametricNullness E r100) {
        return delegate().offerFirst(r100);
    }

    @Override // java.util.Deque
    public boolean offerLast(@ParametricNullness E r100) {
        return delegate().offerLast(r100);
    }

    @Override // java.util.Deque
    public void push(@ParametricNullness E r100) {
        delegate().push(r100);
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(@CheckForNull Object r100) {
        return delegate().removeFirstOccurrence(r100);
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(@CheckForNull Object r100) {
        return delegate().removeLastOccurrence(r100);
    }
}
