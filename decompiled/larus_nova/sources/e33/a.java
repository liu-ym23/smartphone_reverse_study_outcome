package e33;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes12.dex */
public final class a<E> implements com.bytedance.android.scope.a<E>, Collection<E>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection<E> f470904a;

    @Override // java.util.Collection
    public final boolean add(E r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "element");
        return this.f470904a.contains(r100);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f470904a.containsAll(r100);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f470904a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return this.f470904a.iterator();
    }

    @Override // java.util.Collection
    public final boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate<? super E> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f470904a.size();
    }

    public final String toString() {
        return this.f470904a.toString();
    }

    public a(Collection<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "collection");
        this.f470904a = r100;
    }
}
