package z;

import java.util.Iterator;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c<E> extends AbstractMutableSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<E, Boolean> f569578a;

    public c() {
        this(false);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f569578a.clear();
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        return this.f569578a.keySet().size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f569578a.keySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return this.f569578a.keySet().iterator();
    }

    public c(boolean r100) {
        this.f569578a = new b(r100);
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E r100) {
        b<E, Boolean> r101 = this.f569578a;
        Boolean r102 = Boolean.TRUE;
        return Intrinsics.areEqual(r101.put(r100, r102), r102);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r100) {
        return this.f569578a.keySet().contains(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r100) {
        return Intrinsics.areEqual(this.f569578a.remove(r100), Boolean.TRUE);
    }
}
