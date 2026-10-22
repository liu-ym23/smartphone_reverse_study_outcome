package ouc;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
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

/* JADX INFO: loaded from: classes.dex */
@Serializable(with = d.class)
public final class b extends i implements List<i>, KMappedMarker {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f526804a;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a {
        public a() {
        }

        public final juc.d<b> serializer() {
            return d.f526808a;
        }
    }

    public final i a(int r100) {
        return (i) ListProtector.get(this.f526804a, r100);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int r100, i r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends i> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends i> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f526804a.containsAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f526804a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<i> iterator() {
        return this.f526804a.iterator();
    }

    @Override // java.util.List
    public final ListIterator<i> listIterator() {
        return this.f526804a.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<i> listIterator(int r100) {
        return this.f526804a.listIterator(r100);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ i remove(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<i> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ i set(int r100, i r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void sort(Comparator<? super i> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<i> subList(int r100, int r101) {
        return this.f526804a.subList(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    static {
        Companion = new a();
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.f526804a.hashCode();
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f526804a.size();
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this.f526804a, ",", "[", "]", 0, null, null, 56, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends i> r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f526804a = r100;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "element");
        return this.f526804a.contains(r101);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object r100) {
        return Intrinsics.areEqual(this.f526804a, r100);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ i get(int r100) {
        return a(r100);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        if ((r100 instanceof i) == true) goto L6;
        return -1;
    L6:
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "element");
        return this.f526804a.indexOf(r101);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        if ((r100 instanceof i) == true) goto L6;
        return -1;
    L6:
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "element");
        return this.f526804a.lastIndexOf(r101);
    }
}
