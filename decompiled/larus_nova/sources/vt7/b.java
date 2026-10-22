package vt7;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes3.dex */
public final class b<E> implements Set<E>, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<E> f557230a;

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f557230a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f557230a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return this.f557230a.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f557230a.size();
    }

    public b() {
        this.f557230a = new CopyOnWriteArraySet();
    }

    public b(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        this();
        this.f557230a.addAll(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(E r100) {
        return this.f557230a.add(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f557230a.addAll(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object r100) {
        return this.f557230a.contains(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f557230a.containsAll(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object r100) {
        return this.f557230a.remove(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f557230a.removeAll(CollectionsKt.toSet(r100));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f557230a.retainAll(CollectionsKt.toSet(r100));
    }
}
