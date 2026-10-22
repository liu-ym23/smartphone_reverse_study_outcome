package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractBiMap<K, V> extends k0<K, V> implements m<K, V>, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Map<K, V> f274888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    public transient d f274889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    public transient e f274890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @CheckForNull
    public transient c f274891d;
    transient AbstractBiMap<V, K> inverse;

    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            setInverse((AbstractBiMap) r100.readObject());
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            r100.defaultWriteObject();
            r100.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        @ParametricNullness
        public K checkKey(@ParametricNullness K r100) {
            return this.inverse.checkValue(r100);
        }

        @Override // com.google.common.collect.AbstractBiMap
        @ParametricNullness
        public V checkValue(@ParametricNullness V r100) {
            return this.inverse.checkKey(r100);
        }

        public Inverse(Map<K, V> r100, AbstractBiMap<V, K> r101) {
            super(r100, r101, null);
        }
    }

    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Map.Entry<K, V> f274892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f274893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f274894c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f274893b.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Map.Entry<K, V> r100 = (Map.Entry) this.f274893b.next();
            this.f274892a = r100;
            return new b(this.f274894c, r100);
        }

        @Override // java.util.Iterator
        public final void remove() {
            Map.Entry<K, V> r100 = this.f274892a;
            if (r100 == null) goto L7;
            V r101 = r100.getValue();
            this.f274893b.remove();
            AbstractBiMap.access$600(this.f274894c, r101);
            this.f274892a = null;
            return;
        L7:
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }

        public a(AbstractBiMap r100, Iterator r101) {
            this.f274894c = r100;
            this.f274893b = r101;
        }
    }

    public class b extends l0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map.Entry<K, V> f274895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f274896b;

        @Override // com.google.common.collect.o0
        public final Object delegate() {
            return this.f274895a;
        }

        @Override // com.google.common.collect.l0
        public final Map.Entry<K, V> e() {
            return this.f274895a;
        }

        @Override // com.google.common.collect.l0, java.util.Map.Entry
        public final V setValue(V r100) {
            this.f274896b.checkValue(r100);
            com.google.common.base.m.p(this.f274896b.entrySet().contains(this), "entry no longer in map");
            if (com.google.common.base.k.a(r100, getValue()) == false) goto L5;
            return r100;
        L5:
            com.google.common.base.m.h(!this.f274896b.containsValue(r100), "value already present: %s", r100);
            V r101 = this.f274895a.setValue(r100);
            com.google.common.base.m.p(com.google.common.base.k.a(r100, this.f274896b.get(getKey())), "entry no longer in map");
            AbstractBiMap.access$500(this.f274896b, getKey(), true, r101, r100);
            return r101;
        }

        public b(AbstractBiMap r100, Map.Entry<K, V> r101) {
            this.f274896b = r100;
            this.f274895a = r101;
        }
    }

    public class c extends q0<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f274897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f274898b;

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final void clear() {
            this.f274898b.clear();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return this.f274898b.entrySetIterator();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Object delegate() {
            return this.f274897a;
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Collection delegate() {
            return this.f274897a;
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Set<Map.Entry<K, V>> delegate() {
            return this.f274897a;
        }

        public c(AbstractBiMap r100) {
            this.f274898b = r100;
            this.f274897a = AbstractBiMap.access$100(r100).entrySet();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            Set<Map.Entry<K, V>> r101 = this.f274897a;
            if ((r100 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r102 = (Map.Entry) r100;
            r102.getClass();
            return r101.contains(new l1(r102));
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection<?> r100) {
            return standardContainsAll(r100);
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if (this.f274897a.contains(r100) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof Map.Entry) == false) goto L11;
            Map.Entry r101 = (Map.Entry) r100;
            AbstractBiMap.access$100(this.f274898b.inverse).remove(r101.getValue());
            this.f274897a.remove(r101);
            return true;
        L11:
            return false;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection<?> r100) {
            return standardRemoveAll(r100);
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection<?> r100) {
            return standardRetainAll(r100);
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] r100) {
            return (T[]) standardToArray(r100);
        }
    }

    public class d extends q0<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f274899a;

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final void clear() {
            this.f274899a.clear();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Set<K> delegate() {
            return AbstractBiMap.access$100(this.f274899a).keySet();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new i1(this.f274899a.entrySet().iterator());
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        public d(AbstractBiMap r100) {
            this.f274899a = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if (contains(r100) == true) goto L6;
            return false;
        L6:
            AbstractBiMap.access$200(this.f274899a, r100);
            return true;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection<?> r100) {
            return standardRemoveAll(r100);
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection<?> r100) {
            return standardRetainAll(r100);
        }
    }

    public class e extends q0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<V> f274900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f274901b;

        @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<V> iterator() {
            return new j1(this.f274901b.entrySet().iterator());
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.o0
        public final String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Object delegate() {
            return this.f274900a;
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Collection delegate() {
            return this.f274900a;
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Set<V> delegate() {
            return this.f274900a;
        }

        public e(AbstractBiMap r100) {
            this.f274901b = r100;
            this.f274900a = r100.inverse.keySet();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] r100) {
            return (T[]) standardToArray(r100);
        }
    }

    public AbstractBiMap() {
        throw null;
    }

    @ParametricNullness
    public K checkKey(@ParametricNullness K r100) {
        return r100;
    }

    @ParametricNullness
    public V checkValue(@ParametricNullness V r100) {
        return r100;
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public void clear() {
        this.f274888a.clear();
        this.inverse.f274888a.clear();
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        c r100 = this.f274891d;
        if (r100 != null) goto L6;
        c r101 = new c(this);
        this.f274891d = r101;
        return r101;
    L6:
        return r100;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this, this.f274888a.entrySet().iterator());
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public Set<K> keySet() {
        d r100 = this.f274889b;
        if (r100 != null) goto L6;
        d r101 = new d(this);
        this.f274889b = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public Set<V> values() {
        e r100 = this.f274890c;
        if (r100 != null) goto L6;
        e r101 = new e(this);
        this.f274890c = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.m
    public m<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public Map<K, V> delegate() {
        return this.f274888a;
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static /* synthetic */ Map access$100(AbstractBiMap r100) {
        return r100.f274888a;
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public boolean containsValue(@CheckForNull Object r100) {
        return this.inverse.containsKey(r100);
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> r100) {
        return new Inverse(r100, this);
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L4
    }

    @Override // com.google.common.collect.k0, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object r100) {
        if (containsKey(r100) == false) goto L5;
        V r101 = this.f274888a.remove(r100);
        this.inverse.f274888a.remove(r101);
        return r101;
    L5:
        return null;
    }

    public void setInverse(AbstractBiMap<V, K> r100) {
        this.inverse = r100;
    }

    public AbstractBiMap(Map<K, V> r100, Map<V, K> r101) {
        setDelegates(r100, r101);
    }

    public static Object access$200(AbstractBiMap r100, Object r101) {
        V r102 = r100.f274888a.remove(r101);
        r100.inverse.f274888a.remove(r102);
        return r102;
    }

    public static void access$600(AbstractBiMap r100, Object r101) {
        r100.inverse.f274888a.remove(r101);
    }

    @Override // com.google.common.collect.m
    @CheckForNull
    public V forcePut(@ParametricNullness K r100, @ParametricNullness V r101) {
        return e(r100, r101, true);
    }

    @Override // com.google.common.collect.k0, java.util.Map
    @CheckForNull
    public V put(@ParametricNullness K r100, @ParametricNullness V r101) {
        return e(r100, r101, false);
    }

    public void setDelegates(Map<K, V> r100, Map<V, K> r101) {
        boolean r102 = true;
        if (this.f274888a != null) goto L5;
        boolean r103 = true;
    L6:
        com.google.common.base.m.o(r103);
        if (this.inverse != null) goto L9;
        boolean r104 = true;
    L10:
        com.google.common.base.m.o(r104);
        com.google.common.base.m.b(r100.isEmpty());
        com.google.common.base.m.b(r101.isEmpty());
        if (r100 != r101) goto L14;
        r102 = false;
    L14:
        com.google.common.base.m.b(r102);
        this.f274888a = r100;
        this.inverse = makeInverse(r101);
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public AbstractBiMap(Map r100, AbstractBiMap r101, a r102) {
        this.f274888a = r100;
        this.inverse = r101;
    }

    @CheckForNull
    public final V e(@ParametricNullness K r100, @ParametricNullness V r101, boolean r102) {
        checkKey(r100);
        checkValue(r101);
        boolean r103 = containsKey(r100);
        if (r103 == true) goto L5;
    L7:
        if (r102 == false) goto L9;
        inverse().remove(r101);
    L10:
        V r104 = this.f274888a.put(r100, r101);
        if (r103 == false) goto L13;
        this.inverse.f274888a.remove(r104);
    L13:
        this.inverse.f274888a.put(r101, r100);
        return r104;
    L9:
        com.google.common.base.m.h(!containsValue(r101), "value already present: %s", r101);
        goto L10
    L5:
        if (com.google.common.base.k.a(r101, get(r100)) == false) goto L7;
        return r101;
    }

    public static void access$500(AbstractBiMap r100, Object r101, boolean r102, Object r103, Object r104) {
        if (r102 == false) goto L4;
        r100.inverse.f274888a.remove(r103);
    L4:
        r100.inverse.f274888a.put(r104, r101);
    }
}
