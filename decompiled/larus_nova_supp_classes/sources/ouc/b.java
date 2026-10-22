package ouc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Serializable(with = d.class)
public final class b extends i implements List<i>, KMappedMarker {
    public static final a Companion = null;
    public final List<i> a;

    public final i a(int r2) {
        return (i) ListProtector.get(this.a, r2);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int r1, i r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r1, Collection<? extends i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        return this.a.containsAll(r2);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<i> iterator() {
        return this.a.iterator();
    }

    @Override // java.util.List
    public final ListIterator<i> listIterator() {
        return this.a.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<i> listIterator(int r2) {
        return this.a.listIterator(r2);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ i remove(int r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ i set(int r1, i r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void sort(Comparator<? super i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<i> subList(int r2, int r3) {
        return this.a.subList(r2, r3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (T[]) CollectionToArray.toArray(this, r2);
    }

    static {
        Companion = new a();
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.a.size();
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this.a, ",", "[", "]", 0, null, null, 56, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends i> r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.a = r2;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r2) {
        if ((r2 instanceof i) == true) goto L6;
        return false;
    L6:
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "element");
        return this.a.contains(r3);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object r2) {
        return Intrinsics.areEqual(this.a, r2);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ i get(int r1) {
        return a(r1);
    }

    @Override // java.util.List
    public final int indexOf(Object r2) {
        if ((r2 instanceof i) == true) goto L6;
        return -1;
    L6:
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "element");
        return this.a.indexOf(r3);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r2) {
        if ((r2 instanceof i) == true) goto L6;
        return -1;
    L6:
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "element");
        return this.a.lastIndexOf(r3);
    }
}
