package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class s0<E> extends q0<E> implements SortedSet<E> {
    @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    @CheckForNull
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E last() {
        return delegate().last();
    }

    public s0() {
    }

    @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(@ParametricNullness E r100) {
        return delegate().headSet(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f0
    public boolean standardContains(@CheckForNull Object r100) {
        E r101 = tailSet(r100).first();     // Catch: Throwable -> L7
        if (r0.unsafeCompare(comparator(), r101, r100) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f0
    public boolean standardRemove(@CheckForNull Object r100) {
        Iterator<E> r101 = tailSet(r100).iterator();     // Catch: Throwable -> L11
        if (r101.hasNext() == false) goto L10;
        E r102 = r101.next();     // Catch: Throwable -> L11
        if (r0.unsafeCompare(comparator(), r102, r100) != 0) goto L10;
        r101.remove();     // Catch: Throwable -> L11
        return true;
    L10:
        return false;
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(@ParametricNullness E r100) {
        return delegate().tailSet(r100);
    }

    public SortedSet<E> standardSubSet(@ParametricNullness E r100, @ParametricNullness E r101) {
        return tailSet(r100).headSet(r101);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(@ParametricNullness E r100, @ParametricNullness E r101) {
        return delegate().subSet(r100, r101);
    }
}
