package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient EnumSet<E> f275059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @LazyInit
    public transient int f275060d;

    public static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> delegate;

        public Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone(), null);
        }

        public EnumSerializedForm(EnumSet<E> r100) {
            this.delegate = r100;
        }
    }

    public static /* synthetic */ class a {
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int r100 = this.f275060d;
        if (r100 != 0) goto L6;
        int r101 = this.f275059c.hashCode();
        this.f275060d = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f275059c.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public z2<E> iterator() {
        return Iterators.i(this.f275059c.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f275059c.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f275059c.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new EnumSerializedForm(this.f275059c);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public ImmutableEnumSet(EnumSet<E> r100) {
        this.f275059c = r100;
    }

    public static <E extends Enum<E>> ImmutableSet<E> asImmutable(EnumSet<E> r100) {
        int r101 = r100.size();
        if (r101 == 0) goto L11;
        if (r101 == 1) goto L9;
        return new ImmutableEnumSet(r100);
    L9:
        return ImmutableSet.of((Enum) a1.b(r100));
    L11:
        return ImmutableSet.of();
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        return this.f275059c.contains(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r100) {
        if ((r100 instanceof ImmutableEnumSet) == false) goto L6;
        r100 = ((ImmutableEnumSet) r100).f275059c;
    L6:
        return this.f275059c.containsAll(r100);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableEnumSet) == false) goto L9;
        r100 = ((ImmutableEnumSet) r100).f275059c;
    L9:
        return this.f275059c.equals(r100);
    }

    public /* synthetic */ ImmutableEnumSet(EnumSet r100, a r101) {
        this(r100);
    }
}
