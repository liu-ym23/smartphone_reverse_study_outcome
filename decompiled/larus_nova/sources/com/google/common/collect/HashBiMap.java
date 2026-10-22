package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements m<K, V>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int[] f275025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f275026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int[] f275027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int[] f275028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int f275029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int f275030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient int[] f275031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int[] f275032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @LazyInit
    public transient e f275033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @LazyInit
    public transient f f275034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @LazyInit
    public transient c f275035k;
    transient K[] keys;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient m<V, K> f275036l;
    transient int modCount;
    transient int size;
    transient V[] values;

    public static class Inverse<K, V> extends AbstractMap<V, K> implements m<V, K>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient d f275037a;
        private final HashBiMap<K, V> forward;

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            d r100 = this.f275037a;
            if (r100 != null) goto L6;
            d r101 = new d(this.forward);
            this.f275037a = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.m
        public Set<K> values() {
            return this.forward.keySet();
        }

        @Override // com.google.common.collect.m
        public m<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        public Inverse(HashBiMap<K, V> r100) {
            this.forward = r100;
        }

        private void readObject(ObjectInputStream r100) throws ClassNotFoundException, IOException {
            r100.defaultReadObject();
            HashBiMap.access$302(this.forward, this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r100) {
            return this.forward.containsValue(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@CheckForNull Object r100) {
            return this.forward.containsKey(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K get(@CheckForNull Object r100) {
            return this.forward.getInverse(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K remove(@CheckForNull Object r100) {
            return this.forward.removeInverse(r100);
        }

        @Override // com.google.common.collect.m
        @CheckForNull
        public K forcePut(@ParametricNullness V r100, @ParametricNullness K r101) {
            return this.forward.putInverse(r100, r101, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K put(@ParametricNullness V r100, @ParametricNullness K r101) {
            return this.forward.putInverse(r100, r101, false);
        }
    }

    public final class a extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f275038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashBiMap f275040c;

        public final void a() {
            int r100 = this.f275039b;
            if (r100 == (-1)) goto L8;
            HashBiMap r101 = this.f275040c;
            if (r100 > r101.size) goto L8;
            if (com.google.common.base.k.a(r101.keys[r100], this.f275038a) == false) goto L8;
            return;
        L8:
            this.f275039b = this.f275040c.findEntryByKey(this.f275038a);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final V getValue() {
            a();
            int r100 = this.f275039b;
            if (r100 != (-1)) goto L6;
            return null;
        L6:
            return this.f275040c.values[r100];
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final K getKey() {
            return this.f275038a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final V setValue(@ParametricNullness V r100) {
            a();
            int r101 = this.f275039b;
            if (r101 != (-1)) goto L6;
            this.f275040c.put(this.f275038a, r100);
            return null;
        L6:
            V r102 = this.f275040c.values[r101];
            if (com.google.common.base.k.a(r102, r100) == false) goto L9;
            return r100;
        L9:
            HashBiMap.access$200(this.f275040c, this.f275039b, r100, false);
            return r102;
        }

        public a(HashBiMap r100, int r101) {
            this.f275040c = r100;
            this.f275038a = r100.keys[r101];
            this.f275039b = r101;
        }
    }

    public static final class b<K, V> extends com.google.common.collect.b<V, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashBiMap<K, V> f275041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ParametricNullness
        public final V f275042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f275043c;

        public final void a() {
            int r100 = this.f275043c;
            if (r100 == (-1)) goto L8;
            HashBiMap<K, V> r101 = this.f275041a;
            if (r100 > r101.size) goto L8;
            if (com.google.common.base.k.a(this.f275042b, r101.values[r100]) == false) goto L8;
            return;
        L8:
            this.f275043c = this.f275041a.findEntryByValue(this.f275042b);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final K getValue() {
            a();
            int r100 = this.f275043c;
            if (r100 != (-1)) goto L6;
            return null;
        L6:
            return this.f275041a.keys[r100];
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final V getKey() {
            return this.f275042b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final K setValue(@ParametricNullness K r100) {
            a();
            int r101 = this.f275043c;
            if (r101 != (-1)) goto L6;
            this.f275041a.putInverse(this.f275042b, r100, false);
            return null;
        L6:
            K r102 = this.f275041a.keys[r101];
            if (com.google.common.base.k.a(r102, r100) == false) goto L9;
            return r100;
        L9:
            HashBiMap.access$400(this.f275041a, this.f275043c, r100, false);
            return r102;
        }

        public b(HashBiMap<K, V> r100, int r101) {
            this.f275041a = r100;
            this.f275042b = r100.values[r101];
            this.f275043c = r101;
        }
    }

    public final class c extends g<K, V, Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashBiMap f275044b;

        public c(HashBiMap r100) {
            this.f275044b = r100;
            super(r100);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public final Object a(int r100) {
            return new a(this.f275044b, r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            Object r103 = r101.getValue();
            int r104 = this.f275044b.findEntryByKey(r102);
            if (r104 != (-1)) goto L7;
            return false;
        L7:
            if (com.google.common.base.k.a(r103, this.f275044b.values[r104]) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            Object r103 = r101.getValue();
            int r104 = u0.c(r102);
            int r105 = this.f275044b.findEntryByKey(r102, r104);
            if (r105 != (-1)) goto L7;
            return false;
        L7:
            if (com.google.common.base.k.a(r103, this.f275044b.values[r105]) == false) goto L13;
            this.f275044b.removeEntryKeyHashKnown(r105, r104);
            return true;
        L13:
            return false;
        L10:
            return false;
        }
    }

    public static class d<K, V> extends g<K, V, Map.Entry<V, K>> {
        public d(HashBiMap<K, V> r100) {
            super(r100);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public final Object a(int r100) {
            return new b(this.f275047a, r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            Object r103 = r101.getValue();
            int r104 = this.f275047a.findEntryByValue(r102);
            if (r104 != (-1)) goto L7;
            return false;
        L7:
            if (com.google.common.base.k.a(this.f275047a.keys[r104], r103) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            Object r103 = r101.getValue();
            int r104 = u0.c(r102);
            int r105 = this.f275047a.findEntryByValue(r102, r104);
            if (r105 != (-1)) goto L7;
            return false;
        L7:
            if (com.google.common.base.k.a(this.f275047a.keys[r105], r103) == false) goto L13;
            this.f275047a.removeEntryValueHashKnown(r105, r104);
            return true;
        L13:
            return false;
        L10:
            return false;
        }
    }

    public final class e extends g<K, V, K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashBiMap f275045b;

        public e(HashBiMap r100) {
            this.f275045b = r100;
            super(r100);
        }

        @Override // com.google.common.collect.HashBiMap.g
        @ParametricNullness
        public final K a(int r100) {
            return this.f275045b.keys[r100];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            return this.f275045b.containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            int r101 = u0.c(r100);
            int r102 = this.f275045b.findEntryByKey(r100, r101);
            if (r102 == (-1)) goto L6;
            this.f275045b.removeEntryKeyHashKnown(r102, r101);
            return true;
        L6:
            return false;
        }
    }

    public final class f extends g<K, V, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashBiMap f275046b;

        public f(HashBiMap r100) {
            this.f275046b = r100;
            super(r100);
        }

        @Override // com.google.common.collect.HashBiMap.g
        @ParametricNullness
        public final V a(int r100) {
            return this.f275046b.values[r100];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            return this.f275046b.containsValue(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            int r101 = u0.c(r100);
            int r102 = this.f275046b.findEntryByValue(r100, r101);
            if (r102 == (-1)) goto L6;
            this.f275046b.removeEntryValueHashKnown(r102, r101);
            return true;
        L6:
            return false;
        }
    }

    public static abstract class g<K, V, T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashBiMap<K, V> f275047a;

        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f275048a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f275049b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f275050c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f275051d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ g f275052e;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                if (this.f275052e.f275047a.modCount != this.f275050c) goto L12;
                if (this.f275048a != (-2)) goto L7;
            L9:
                return false;
            L7:
                if (this.f275051d <= 0) goto L9;
                return true;
            L12:
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (this.f275052e.f275047a.modCount != this.f275050c) goto L14;
                if (this.f275049b == (-1)) goto L7;
                boolean r100 = true;
            L8:
                o.e(r100);
                this.f275052e.f275047a.removeEntry(this.f275049b);
                int r101 = this.f275048a;
                HashBiMap<K, V> r102 = this.f275052e.f275047a;
                if (r101 != r102.size) goto L11;
                this.f275048a = this.f275049b;
            L11:
                this.f275049b = -1;
                this.f275050c = r102.modCount;
                return;
            L7:
                r100 = false;
                goto L8
            L14:
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public final T next() {
                if (hasNext() == false) goto L7;
                T r100 = (T) this.f275052e.a(this.f275048a);
                this.f275049b = this.f275048a;
                this.f275048a = HashBiMap.access$100(this.f275052e.f275047a)[this.f275048a];
                this.f275051d--;
                return r100;
            L7:
                throw new NoSuchElementException();
            }

            public a(g r100) {
                this.f275052e = r100;
                this.f275048a = HashBiMap.access$000(r100.f275047a);
                this.f275049b = -1;
                HashBiMap<K, V> r101 = r100.f275047a;
                this.f275050c = r101.modCount;
                this.f275051d = r101.size;
            }
        }

        @ParametricNullness
        public abstract T a(int r100);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f275047a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<T> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f275047a.size;
        }

        public g(HashBiMap<K, V> r100) {
            this.f275047a = r100;
        }
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, null);
        Arrays.fill(this.f275025a, -1);
        Arrays.fill(this.f275026b, -1);
        Arrays.fill(this.f275027c, 0, this.size, -1);
        Arrays.fill(this.f275028d, 0, this.size, -1);
        Arrays.fill(this.f275031g, 0, this.size, -1);
        Arrays.fill(this.f275032h, 0, this.size, -1);
        this.size = 0;
        this.f275029e = -2;
        this.f275030f = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        c r100 = this.f275035k;
        if (r100 != null) goto L6;
        c r101 = new c(this);
        this.f275035k = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.m
    public m<V, K> inverse() {
        m<V, K> r100 = this.f275036l;
        if (r100 != null) goto L6;
        Inverse r101 = new Inverse(this);
        this.f275036l = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        e r100 = this.f275033i;
        if (r100 != null) goto L6;
        e r101 = new e(this);
        this.f275033i = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.m
    public Set<V> values() {
        f r100 = this.f275034j;
        if (r100 != null) goto L6;
        f r101 = new f(this);
        this.f275034j = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public HashBiMap(int r100) {
        init(r100);
    }

    public static /* synthetic */ int access$000(HashBiMap r100) {
        return r100.f275029e;
    }

    public static /* synthetic */ int[] access$100(HashBiMap r100) {
        return r100.f275032h;
    }

    public static int[] b(int r100) {
        int[] r101 = new int[r100];
        Arrays.fill(r101, -1);
        return r101;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> r100) {
        HashBiMap<K, V> r101 = create(r100.size());
        r101.putAll(r100);
        return r101;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        int r101 = r100.readInt();
        init(16);
        j2.b(this, r100, r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        j2.e(this, r100);
    }

    public final int a(int r100) {
        return r100 & (this.f275025a.length - 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r100) {
        if (findEntryByKey(r100) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object r100) {
        if (findEntryByValue(r100) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e(int r100) {
        int[] r101 = this.f275027c;
        if (r101.length >= r100) goto L6;
        int r102 = ImmutableCollection.b.a(r101.length, r100);
        this.keys = (K[]) Arrays.copyOf(this.keys, r102);
        this.values = (V[]) Arrays.copyOf(this.values, r102);
        int[] r103 = this.f275027c;
        int r104 = r103.length;
        int[] r105 = Arrays.copyOf(r103, r102);
        Arrays.fill(r105, r104, r102, -1);
        this.f275027c = r105;
        int[] r106 = this.f275028d;
        int r107 = r106.length;
        int[] r108 = Arrays.copyOf(r106, r102);
        Arrays.fill(r108, r107, r102, -1);
        this.f275028d = r108;
        int[] r109 = this.f275031g;
        int r110 = r109.length;
        int[] r111 = Arrays.copyOf(r109, r102);
        Arrays.fill(r111, r110, r102, -1);
        this.f275031g = r111;
        int[] r112 = this.f275032h;
        int r113 = r112.length;
        int[] r114 = Arrays.copyOf(r112, r102);
        Arrays.fill(r114, r113, r102, -1);
        this.f275032h = r114;
    L6:
        if (this.f275025a.length >= r100) goto L11;
        int r115 = u0.a(r100, 1.0d);
        this.f275025a = b(r115);
        this.f275026b = b(r115);
        int r116 = 0;
    L9:
        if (r116 >= this.size) goto L13;
        int r117 = a(u0.c(this.keys[r116]));
        int[] r118 = this.f275027c;
        int[] r119 = this.f275025a;
        r118[r116] = r119[r117];
        r119[r117] = r116;
        int r120 = a(u0.c(this.values[r116]));
        int[] r121 = this.f275028d;
        int[] r122 = this.f275026b;
        r121[r116] = r122[r120];
        r122[r120] = r116;
        r116 = r116 + 1;
        goto L9
    L13:
        return;
    }

    public int findEntryByKey(@CheckForNull Object r100) {
        return findEntryByKey(r100, u0.c(r100));
    }

    public int findEntryByValue(@CheckForNull Object r100) {
        return findEntryByValue(r100, u0.c(r100));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        int r101 = findEntryByKey(r100);
        if (r101 != (-1)) goto L6;
        return null;
    L6:
        return this.values[r101];
    }

    @CheckForNull
    public K getInverse(@CheckForNull Object r100) {
        int r101 = findEntryByValue(r100);
        if (r101 != (-1)) goto L6;
        return null;
    L6:
        return this.keys[r101];
    }

    public void init(int r100) {
        o.b(r100, "expectedSize");
        int r101 = u0.a(r100, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[r100];
        this.values = (V[]) new Object[r100];
        this.f275025a = b(r101);
        this.f275026b = b(r101);
        this.f275027c = b(r100);
        this.f275028d = b(r100);
        this.f275029e = -2;
        this.f275030f = -2;
        this.f275031g = b(r100);
        this.f275032h = b(r100);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object r100) {
        int r101 = u0.c(r100);
        int r102 = findEntryByKey(r100, r101);
        if (r102 != (-1)) goto L6;
        return null;
    L6:
        V r103 = this.values[r102];
        removeEntryKeyHashKnown(r102, r101);
        return r103;
    }

    public void removeEntry(int r100) {
        removeEntryKeyHashKnown(r100, u0.c(this.keys[r100]));
    }

    @CheckForNull
    public K removeInverse(@CheckForNull Object r100) {
        int r101 = u0.c(r100);
        int r102 = findEntryByValue(r100, r101);
        if (r102 != (-1)) goto L6;
        return null;
    L6:
        K r103 = this.keys[r102];
        removeEntryValueHashKnown(r102, r101);
        return r103;
    }

    public static <K, V> HashBiMap<K, V> create(int r100) {
        return new HashBiMap(r100);
    }

    public static /* synthetic */ m access$302(HashBiMap r100, m r101) {
        r100.f275036l = r101;
        return r101;
    }

    public final void c(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.b(r102);
        int r103 = a(r101);
        int[] r104 = this.f275025a;
        int r105 = r104[r103];
        if (r105 != r100) goto L10;
        int[] r106 = this.f275027c;
        r104[r103] = r106[r100];
        r106[r100] = -1;
        return;
    L10:
        int r107 = this.f275027c[r105];
    L11:
        int r108 = r105;
        r105 = r107;
        if (r105 == (-1)) goto L18;
        if (r105 == r100) goto L14;
        r107 = this.f275027c[r105];
        goto L11
    L14:
        int[] r109 = this.f275027c;
        r109[r108] = r109[r100];
        r109[r100] = -1;
        return;
    L18:
        throw new AssertionError("Expected to find entry with key " + this.keys[r100]);
    L5:
        r102 = false;
        goto L6
    }

    public final void d(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.b(r102);
        int r103 = a(r101);
        int[] r104 = this.f275026b;
        int r105 = r104[r103];
        if (r105 != r100) goto L10;
        int[] r106 = this.f275028d;
        r104[r103] = r106[r100];
        r106[r100] = -1;
        return;
    L10:
        int r107 = this.f275028d[r105];
    L11:
        int r108 = r105;
        r105 = r107;
        if (r105 == (-1)) goto L18;
        if (r105 == r100) goto L14;
        r107 = this.f275028d[r105];
        goto L11
    L14:
        int[] r109 = this.f275028d;
        r109[r108] = r109[r100];
        r109[r100] = -1;
        return;
    L18:
        throw new AssertionError("Expected to find entry with value " + this.values[r100]);
    L5:
        r102 = false;
        goto L6
    }

    public final void f(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.b(r102);
        int r103 = a(r101);
        int[] r104 = this.f275027c;
        int[] r105 = this.f275025a;
        r104[r100] = r105[r103];
        r105[r103] = r100;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public int findEntryByKey(@CheckForNull Object r100, int r101) {
        return findEntry(r100, r101, this.f275025a, this.f275027c, this.keys);
    }

    public int findEntryByValue(@CheckForNull Object r100, int r101) {
        return findEntry(r100, r101, this.f275026b, this.f275028d, this.values);
    }

    @Override // com.google.common.collect.m
    @CheckForNull
    public V forcePut(@ParametricNullness K r100, @ParametricNullness V r101) {
        return put(r100, r101, true);
    }

    public final void g(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.b(r102);
        int r103 = a(r101);
        int[] r104 = this.f275028d;
        int[] r105 = this.f275026b;
        r104[r100] = r105[r103];
        r105[r103] = r100;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void k(int r100, int r101) {
        if (r100 != (-2)) goto L5;
        this.f275029e = r101;
    L6:
        if (r101 != (-2)) goto L8;
        this.f275030f = r100;
        return;
    L8:
        this.f275031g[r101] = r100;
        return;
    L5:
        this.f275032h[r100] = r101;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V put(@ParametricNullness K r100, @ParametricNullness V r101) {
        return put(r100, r101, false);
    }

    public void removeEntryKeyHashKnown(int r100, int r101) {
        h(r100, r101, u0.c(this.values[r100]));
    }

    public void removeEntryValueHashKnown(int r100, int r101) {
        h(r100, u0.c(this.keys[r100]), r101);
    }

    public final void h(int r100, int r101, int r102) {
        if (r100 == (-1)) goto L5;
        boolean r103 = true;
    L6:
        com.google.common.base.m.b(r103);
        c(r100, r101);
        d(r100, r102);
        k(this.f275031g[r100], this.f275032h[r100]);
        int r104 = this.size - 1;
        if (r104 == r100) goto L22;
        int r105 = this.f275031g[r104];
        int r106 = this.f275032h[r104];
        k(r105, r100);
        k(r100, r106);
        K[] r107 = this.keys;
        K r108 = r107[r104];
        V[] r109 = this.values;
        V r110 = r109[r104];
        r107[r100] = r108;
        r109[r100] = r110;
        int r111 = a(u0.c(r108));
        int[] r112 = this.f275025a;
        int r113 = r112[r111];
        if (r113 != r104) goto L12;
        r112[r111] = r100;
    L15:
        int[] r114 = this.f275027c;
        r114[r100] = r114[r104];
        r114[r104] = -1;
        int r115 = a(u0.c(r110));
        int[] r116 = this.f275026b;
        int r117 = r116[r115];
        if (r117 != r104) goto L18;
        r116[r115] = r100;
    L21:
        int[] r118 = this.f275028d;
        r118[r100] = r118[r104];
        r118[r104] = -1;
        goto L22
    L18:
        int r119 = this.f275028d[r117];
    L19:
        if (r119 == r104) goto L20;
        r117 = r119;
        r119 = this.f275028d[r119];
        goto L19
    L20:
        this.f275028d[r117] = r100;
        goto L21
    L12:
        int r120 = this.f275027c[r113];
    L13:
        if (r120 == r104) goto L14;
        r113 = r120;
        r120 = this.f275027c[r120];
        goto L13
    L14:
        this.f275027c[r113] = r100;
    L22:
        K[] r121 = this.keys;
        int r122 = this.size;
        r121[r122 - 1] = null;
        this.values[r122 - 1] = null;
        this.size = r122 - 1;
        this.modCount++;
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void i(int r100, @ParametricNullness K r101, boolean r102) {
        if (r100 == (-1)) goto L5;
        boolean r103 = true;
    L6:
        com.google.common.base.m.b(r103);
        int r104 = u0.c(r101);
        int r105 = findEntryByKey(r101, r104);
        int r106 = this.f275030f;
        if (r105 == (-1)) goto L14;
        if (r102 == false) goto L13;
        r106 = this.f275031g[r105];
        int r107 = this.f275032h[r105];
        removeEntryKeyHashKnown(r105, r104);
        if (r100 != this.size) goto L15;
        r100 = r105;
    L15:
        if (r106 != r100) goto L18;
        r106 = this.f275031g[r100];
    L20:
        if (r107 != r100) goto L23;
        r105 = this.f275032h[r100];
    L26:
        k(this.f275031g[r100], this.f275032h[r100]);
        c(r100, u0.c(this.keys[r100]));
        this.keys[r100] = r101;
        f(r100, u0.c(r101));
        k(r106, r100);
        k(r100, r105);
        return;
    L23:
        if (r107 == this.size) goto L26;
        r105 = r107;
        goto L26
    L18:
        if (r106 != this.size) goto L20;
        r106 = r105;
        goto L20
    L13:
        throw new IllegalArgumentException("Key already present in map: " + r101);
    L14:
        r107 = -2;
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    public final void j(int r100, @ParametricNullness V r101, boolean r102) {
        if (r100 == (-1)) goto L5;
        boolean r103 = true;
    L6:
        com.google.common.base.m.b(r103);
        int r104 = u0.c(r101);
        int r105 = findEntryByValue(r101, r104);
        if (r105 == (-1)) goto L14;
        if (r102 == false) goto L13;
        removeEntryValueHashKnown(r105, r104);
        if (r100 != this.size) goto L14;
        r100 = r105;
        goto L14
    L13:
        throw new IllegalArgumentException("Value already present in map: " + r101);
    L14:
        d(r100, u0.c(this.values[r100]));
        this.values[r100] = r101;
        g(r100, r104);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @CheckForNull
    public V put(@ParametricNullness K r100, @ParametricNullness V r101, boolean r102) {
        int r103 = u0.c(r100);
        int r104 = findEntryByKey(r100, r103);
        if (r104 == (-1)) goto L9;
        V r105 = this.values[r104];
        if (com.google.common.base.k.a(r105, r101) == false) goto L7;
        return r101;
    L7:
        j(r104, r101, r102);
        return r105;
    L9:
        int r106 = u0.c(r101);
        int r107 = findEntryByValue(r101, r106);
        if (r102 == false) goto L13;
        if (r107 == (-1)) goto L17;
        removeEntryValueHashKnown(r107, r106);
    L17:
        e(this.size + 1);
        K[] r108 = this.keys;
        int r109 = this.size;
        r108[r109] = r100;
        this.values[r109] = r101;
        f(r109, r103);
        g(this.size, r106);
        k(this.f275030f, this.size);
        k(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    L13:
        if (r107 != (-1)) goto L15;
        boolean r110 = true;
    L16:
        com.google.common.base.m.h(r110, "Value already present: %s", r101);
        goto L17
    L15:
        r110 = false;
        goto L16
    }

    @CheckForNull
    public K putInverse(@ParametricNullness V r100, @ParametricNullness K r101, boolean r102) {
        int r103 = u0.c(r100);
        int r104 = findEntryByValue(r100, r103);
        if (r104 == (-1)) goto L9;
        K r105 = this.keys[r104];
        if (com.google.common.base.k.a(r105, r101) == false) goto L7;
        return r101;
    L7:
        i(r104, r101, r102);
        return r105;
    L9:
        int r106 = this.f275030f;
        int r107 = u0.c(r101);
        int r108 = findEntryByKey(r101, r107);
        if (r102 == false) goto L13;
        if (r108 == (-1)) goto L17;
        r106 = this.f275031g[r108];
        removeEntryKeyHashKnown(r108, r107);
    L17:
        e(this.size + 1);
        K[] r109 = this.keys;
        int r110 = this.size;
        r109[r110] = r101;
        this.values[r110] = r100;
        f(r110, r107);
        g(this.size, r103);
        if (r106 != (-2)) goto L20;
        int r111 = this.f275029e;
    L21:
        k(r106, this.size);
        k(this.size, r111);
        this.size++;
        this.modCount++;
        return null;
    L20:
        r111 = this.f275032h[r106];
        goto L21
    L13:
        if (r108 != (-1)) goto L15;
        boolean r112 = true;
    L16:
        com.google.common.base.m.h(r112, "Key already present: %s", r101);
        goto L17
    L15:
        r112 = false;
        goto L16
    }

    public static /* synthetic */ void access$200(HashBiMap r100, int r101, Object r102, boolean r103) {
        r100.j(r101, r102, r103);
    }

    public static /* synthetic */ void access$400(HashBiMap r100, int r101, Object r102, boolean r103) {
        r100.i(r101, r102, r103);
    }

    public int findEntry(@CheckForNull Object r100, int r101, int[] r102, int[] r103, Object[] r104) {
        int r105 = r102[a(r101)];
    L4:
        if (r105 == (-1)) goto L9;
        if (com.google.common.base.k.a(r104[r105], r100) == true) goto L7;
        r105 = r103[r105];
        goto L4
    L7:
        return r105;
    L9:
        return -1;
    }
}
