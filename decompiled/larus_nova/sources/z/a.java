package z;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes3.dex */
public final class a<V> implements List<V>, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f569576a;

    public a() {
        this(false);
    }

    @Override // java.util.List
    public final void add(int r100, V r101) {
        ListProtector.add(this.f569576a, r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(V r100) {
        return this.f569576a.add(r100);
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends V> r101) {
        return this.f569576a.addAll(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends V> r100) {
        return this.f569576a.addAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f569576a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        return this.f569576a.contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        return this.f569576a.containsAll(r100);
    }

    @Override // java.util.List
    public final V get(int r100) {
        return (V) ListProtector.get(this.f569576a, r100);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        return this.f569576a.indexOf(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f569576a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return this.f569576a.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        return this.f569576a.lastIndexOf(r100);
    }

    @Override // java.util.List
    public final ListIterator<V> listIterator() {
        return this.f569576a.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<V> listIterator(int r100) {
        return this.f569576a.listIterator(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        return this.f569576a.remove(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        return this.f569576a.removeAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        return this.f569576a.retainAll(r100);
    }

    @Override // java.util.List
    public final V set(int r100, V r101) {
        return (V) ListProtector.set(this.f569576a, r100, r101);
    }

    @Override // java.util.List
    public final List<V> subList(int r100, int r101) {
        return this.f569576a.subList(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f569576a.size();
    }

    public a(boolean r100) {
        if (r100 == false) goto L5;
        List r101 = Collections.synchronizedList(new ArrayList());
    L6:
        this.f569576a = r101;
        return;
    L5:
        r101 = new ArrayList();
        goto L6
    }

    @Override // java.util.List
    public final V remove(int r100) {
        return (V) ListProtector.remove(this.f569576a, r100);
    }
}
