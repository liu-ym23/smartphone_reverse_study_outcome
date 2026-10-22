package io.ktor.util;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes41.dex */
public final class l<From, To> implements Set<To>, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<From> f491962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<From, To> f491963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<To, From> f491964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f491965d;

    public static final class a implements Iterator<To>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<From> f491966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<From, To> f491967b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f491966a.hasNext();
        }

        @Override // java.util.Iterator
        public final To next() {
            return (To) this.f491967b.f491963b.invoke(this.f491966a.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f491966a.remove();
        }

        public a(l<From, To> r100) {
            this.f491967b = r100;
            this.f491966a = r100.f491962a.iterator();
        }
    }

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
        this.f491962a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f491962a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f491962a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<To> iterator() {
        return new a(this);
    }

    public final String toString() {
        return c(this.f491962a).toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f491965d;
    }

    public final Collection<From> a(Collection<? extends To> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Collection<? extends To> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        r102.add(this.f491964c.invoke((To) r104));
        goto L4
    L6:
        return r102;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(To r100) {
        return this.f491962a.add(this.f491964c.invoke(r100));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection<? extends To> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f491962a.addAll(a(r100));
    }

    public final Collection<To> c(Collection<? extends From> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Collection<? extends From> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        r102.add(this.f491963b.invoke((From) r104));
        goto L4
    L6:
        return r102;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object r100) {
        return this.f491962a.contains(this.f491964c.invoke(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f491962a.containsAll(a(r100));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof Set) == false) goto L16;
        Collection<To> r101 = c(this.f491962a);
        if (((Set) r100).containsAll(r101) == true) goto L10;
        return false;
    L10:
        if (r101.containsAll((Collection) r100) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object r100) {
        return this.f491962a.remove(this.f491964c.invoke(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f491962a.removeAll(a(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f491962a.retainAll(a(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Set<From> r100, Function1<? super From, ? extends To> r101, Function1<? super To, ? extends From> r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "convertTo");
        Intrinsics.checkNotNullParameter(r102, "convert");
        this.f491962a = r100;
        this.f491963b = r101;
        this.f491964c = r102;
        this.f491965d = r100.size();
    }
}
