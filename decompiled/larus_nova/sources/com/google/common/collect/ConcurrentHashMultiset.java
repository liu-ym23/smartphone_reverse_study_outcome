package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class ConcurrentHashMultiset<E> extends com.google.common.collect.d<E> implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ConcurrentMap<E, AtomicInteger> f274994c;

    public class a extends q0<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f274995a;

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Object delegate() {
            return this.f274995a;
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Collection delegate() {
            return this.f274995a;
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Set<E> delegate() {
            return this.f274995a;
        }

        public a(Set r100) {
            this.f274995a = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            if (r100 == null) goto L13;
            Set r101 = this.f274995a;
            r101.getClass();
            boolean r102 = r101.contains(r100);     // Catch: Throwable -> L7
        L8:
            if (r102 == false) goto L14;
            return true;
        L14:
            return false;
        L7:
            r102 = false;
            goto L8
        L13:
            return false;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection<?> r100) {
            return standardContainsAll(r100);
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if (r100 == null) goto L13;
            Set r101 = this.f274995a;
            r101.getClass();
            boolean r102 = r101.remove(r100);     // Catch: Throwable -> L7
        L8:
            if (r102 == false) goto L14;
            return true;
        L14:
            return false;
        L7:
            r102 = false;
            goto L8
        L13:
            return false;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection<?> r100) {
            return standardRemoveAll(r100);
        }
    }

    public class b extends AbstractIterator<y1.a<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Iterator<Map.Entry<E, AtomicInteger>> f274996c;

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public final Object a() {
        L3:
            if (this.f274996c.hasNext() == false) goto L4;
            Map.Entry<E, AtomicInteger> r100 = this.f274996c.next();
            int r101 = r100.getValue().get();
            if (r101 == 0) goto L3;
            return new Multisets.ImmutableEntry(r100.getKey(), r101);
        L4:
            this.f274902a = AbstractIterator.State.DONE;
            return null;
        }

        public b(ConcurrentHashMultiset r100) {
            this.f274996c = ConcurrentHashMultiset.access$100(r100).entrySet().iterator();
        }
    }

    public class c extends i0<y1.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public y1.a<E> f274997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f274998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMultiset f274999c;

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f274997a == null) goto L5;
            boolean r100 = true;
        L6:
            com.google.common.base.m.p(r100, "no calls to next() since the last call to remove()");
            this.f274999c.setCount(this.f274997a.getElement(), 0);
            this.f274997a = null;
            return;
        L5:
            r100 = false;
            goto L6
        }

        @Override // com.google.common.collect.i0, java.util.Iterator
        public final Object next() {
            y1.a<E> r100 = (y1.a) super.next();
            this.f274997a = r100;
            return r100;
        }

        @Override // com.google.common.collect.o0
        public final Object delegate() {
            return this.f274998b;
        }

        public c(ConcurrentHashMultiset r100, b r101) {
            this.f274999c = r100;
            this.f274998b = r101;
        }
    }

    public class d extends com.google.common.collect.d<E>.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMultiset f275000b;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            int r100 = size();
            o.b(r100, "arraySize");
            ArrayList r101 = new ArrayList(Ints.c((((long) r100) + 5) + ((long) (r100 / 10))));
            Iterators.a(r101, iterator());
            return r101.toArray();
        }

        @Override // com.google.common.collect.d.b, com.google.common.collect.Multisets.c
        public final y1 a() {
            return this.f275000b;
        }

        public d(ConcurrentHashMultiset r100) {
            this.f275000b = r100;
            super(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] r100) {
            int r101 = size();
            o.b(r101, "arraySize");
            ArrayList r102 = new ArrayList(Ints.c((((long) r101) + 5) + ((long) (r101 / 10))));
            Iterators.a(r102, iterator());
            return (T[]) r102.toArray(r100);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j2.a<ConcurrentHashMultiset> f275001a = null;

        static {
            f275001a = j2.a(ConcurrentHashMultiset.class, "countMap");
        }
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f274994c.clear();
    }

    @Override // com.google.common.collect.d
    public Set<E> createElementSet() {
        return new a(this.f274994c.keySet());
    }

    @Override // com.google.common.collect.d
    public Set<y1.a<E>> createEntrySet() {
        return new d(this);
    }

    @Override // com.google.common.collect.d
    public int distinctElements() {
        return this.f274994c.size();
    }

    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.d
    public Iterator<y1.a<E>> entryIterator() {
        return new c(this, new b(this));
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f274994c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public int size() {
        Iterator<AtomicInteger> r100 = this.f274994c.values().iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L7;
        r101 = r101 + ((long) r100.next().get());
        goto L4
    L7:
        return Ints.c(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<E> a() {
        int r100 = size();
        o.b(r100, "arraySize");
        ArrayList r101 = new ArrayList(Ints.c((((long) r100) + 5) + ((long) (r100 / 10))));
        Iterator<E> r102 = entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        y1.a r103 = (y1.a) r102.next();
        Object r104 = r103.getElement();
        int r105 = r103.getCount();
    L6:
        if (r105 <= 0) goto L4;
        r101.add(r104);
        r105 = r105 - 1;
        goto L6
    L8:
        return r101;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.y1
    public Iterator<E> iterator() {
        return Multisets.d(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return ((ArrayList) a()).toArray();
    }

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> r100) {
        com.google.common.base.m.h(r100.isEmpty(), "the backing map (%s) must be empty", r100);
        this.f274994c = r100;
    }

    public static /* synthetic */ ConcurrentMap access$100(ConcurrentHashMultiset r100) {
        return r100.f274994c;
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> r100) {
        ConcurrentHashMultiset<E> r101 = create();
        a1.a(r101, r100);
        return r101;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        ConcurrentMap r101 = (ConcurrentMap) r100.readObject();
        e.f275001a.a(this, r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(this.f274994c);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r100) {
        return super.contains(r100);
    }

    @Override // com.google.common.collect.y1
    public int count(@CheckForNull Object r100) {
        AtomicInteger r101 = (AtomicInteger) Maps.h(this.f274994c, r100);
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) ((ArrayList) a()).toArray(r100);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> r100) {
        return new ConcurrentHashMultiset(r100);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public int add(E r100, int r101) {
        r100.getClass();
        if (r101 == 0) goto L5;
        o.d(r101, "occurrences");
    L7:
        AtomicInteger r102 = (AtomicInteger) Maps.h(this.f274994c, r100);
        if (r102 != null) goto L12;
        r102 = this.f274994c.putIfAbsent(r100, new AtomicInteger(r101));
        if (r102 != null) goto L12;
        return 0;
    L12:
        int r103 = r102.get();
        if (r103 == 0) goto L19;
        if (r102.compareAndSet(r103, com.google.common.math.c.a(r103, r101)) == false) goto L12;
        return r103;
    L18:
        throw new IllegalArgumentException("Overflow adding " + r101 + " occurrences to a count of " + r103);
    L19:
        AtomicInteger r104 = new AtomicInteger(r101);
        if (this.f274994c.putIfAbsent(r100, r104) == null) goto L23;
        if (this.f274994c.replace(r100, r102, r104) == false) goto L7;
    L23:
        return 0;
    L5:
        return count(r100);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public int remove(@CheckForNull Object r100, int r101) {
        if (r101 == 0) goto L4;
        o.d(r101, "occurrences");
        AtomicInteger r102 = (AtomicInteger) Maps.h(this.f274994c, r100);
        if (r102 != null) goto L8;
        return 0;
    L8:
        int r103 = r102.get();
        if (r103 == 0) goto L15;
        int r104 = Math.max(0, r103 - r101);
        if (r102.compareAndSet(r103, r104) == false) goto L8;
        if (r104 != 0) goto L14;
        this.f274994c.remove(r100, r102);
    L14:
        return r103;
    L15:
        return 0;
    L4:
        return count(r100);
    }

    public boolean removeExactly(@CheckForNull Object r100, int r101) {
        if (r101 != 0) goto L5;
        return true;
    L5:
        o.d(r101, "occurrences");
        AtomicInteger r102 = (AtomicInteger) Maps.h(this.f274994c, r100);
        if (r102 != null) goto L8;
        return false;
    L8:
        int r103 = r102.get();
        if (r103 < r101) goto L10;
        int r104 = r103 - r101;
        if (r102.compareAndSet(r103, r104) == false) goto L8;
        if (r104 != 0) goto L15;
        this.f274994c.remove(r100, r102);
    L15:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public int setCount(E r100, int r101) {
        r100.getClass();
        o.b(r101, "count");
    L3:
        AtomicInteger r102 = (AtomicInteger) Maps.h(this.f274994c, r100);
        if (r102 != null) goto L10;
        if (r101 == 0) goto L6;
        r102 = this.f274994c.putIfAbsent(r100, new AtomicInteger(r101));
        if (r102 != null) goto L10;
        return 0;
    L6:
        return 0;
    L10:
        int r103 = r102.get();
        if (r103 == 0) goto L12;
        if (r102.compareAndSet(r103, r101) == false) goto L10;
        if (r101 != 0) goto L23;
        this.f274994c.remove(r100, r102);
    L23:
        return r103;
    L12:
        if (r101 == 0) goto L13;
        AtomicInteger r104 = new AtomicInteger(r101);
        if (this.f274994c.putIfAbsent(r100, r104) == null) goto L18;
        if (this.f274994c.replace(r100, r102, r104) == false) goto L3;
    L18:
        return 0;
    L13:
        return 0;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public boolean setCount(E r100, int r101, int r102) {
        r100.getClass();
        o.b(r101, "oldCount");
        o.b(r102, "newCount");
        AtomicInteger r103 = (AtomicInteger) Maps.h(this.f274994c, r100);
        if (r103 != null) goto L12;
        if (r101 == 0) goto L6;
        return false;
    L6:
        if (r102 != 0) goto L9;
        return true;
    L9:
        if (this.f274994c.putIfAbsent(r100, new AtomicInteger(r102)) != null) goto L30;
        return true;
    L30:
        return false;
    L12:
        int r104 = r103.get();
        if (r104 != r101) goto L29;
        if (r104 != 0) goto L25;
        if (r102 != 0) goto L18;
        this.f274994c.remove(r100, r103);
        return true;
    L18:
        AtomicInteger r105 = new AtomicInteger(r102);
        if (this.f274994c.putIfAbsent(r100, r105) != null) goto L21;
    L22:
        return true;
    L21:
        if (this.f274994c.replace(r100, r103, r105) == true) goto L22;
        return false;
    L25:
        if (r103.compareAndSet(r104, r102) == false) goto L29;
        if (r102 != 0) goto L28;
        this.f274994c.remove(r100, r103);
    L28:
        return true;
    L29:
        return false;
    }
}
