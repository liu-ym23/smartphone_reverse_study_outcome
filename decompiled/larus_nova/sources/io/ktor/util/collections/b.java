package io.ktor.util.collections;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Set<Object>, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<Object, Unit> f491950a;

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
        this.f491950a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f491950a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return this.f491950a.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f491950a.size();
    }

    public b() {
        this.f491950a = new ConcurrentMap();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (this.f491950a.containsKey(r100) == false) goto L6;
        return false;
    L6:
        this.f491950a.put(r100, Unit.INSTANCE);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Collection<Object> r101 = r100;
        if (r101.isEmpty() == true) goto L15;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        if (add(r102.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.f491950a.containsKey(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return r100.containsAll(this.f491950a.keySet());
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f491950a.remove(r100) == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Collection<? extends Object> r101 = r100;
        if (r101.isEmpty() == true) goto L15;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        if (remove(r102.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<Object> r102 = this.f491950a.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if (r100.contains(r103) == true) goto L4;
        r101.add(r103);
        goto L4
    L9:
        return removeAll(r101);
    }
}
