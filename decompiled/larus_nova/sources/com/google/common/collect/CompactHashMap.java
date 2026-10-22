package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f274960g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient Object f274961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f274962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f274963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @CheckForNull
    public transient Set<K> f274964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    public transient Set<Map.Entry<K, V>> f274965e;

    @CheckForNull
    transient int[] entries;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @CheckForNull
    public transient Collection<V> f274966f;

    @CheckForNull
    transient Object[] keys;

    @CheckForNull
    transient Object[] values;

    public class a extends CompactHashMap<K, V>.e<K> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274967e;

        public a(CompactHashMap r100) {
            this.f274967e = r100;
            super(r100);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        @ParametricNullness
        public final K a(int r100) {
            return (K) CompactHashMap.access$100(this.f274967e, r100);
        }
    }

    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274968e;

        public b(CompactHashMap r100) {
            this.f274968e = r100;
            super(r100);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public final Object a(int r100) {
            return new g(this.f274968e, r100);
        }
    }

    public class c extends CompactHashMap<K, V>.e<V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274969e;

        public c(CompactHashMap r100) {
            this.f274969e = r100;
            super(r100);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        @ParametricNullness
        public final V a(int r100) {
            return (V) CompactHashMap.access$600(this.f274969e, r100);
        }
    }

    public class d extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274970a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f274970a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return this.f274970a.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f274970a.size();
        }

        public d(CompactHashMap r100) {
            this.f274970a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            Map<K, V> r101 = this.f274970a.delegateOrNull();
            if (r101 == null) goto L7;
            return r101.entrySet().contains(r100);
        L7:
            if ((r100 instanceof Map.Entry) == false) goto L14;
            Map.Entry r102 = (Map.Entry) r100;
            int r103 = CompactHashMap.access$500(this.f274970a, r102.getKey());
            if (r103 != (-1)) goto L11;
            return false;
        L11:
            if (com.google.common.base.k.a(CompactHashMap.access$600(this.f274970a, r103), r102.getValue()) == false) goto L16;
            return true;
        L16:
            return false;
        L14:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r110) {
            Map<K, V> r100 = this.f274970a.delegateOrNull();
            if (r100 == null) goto L7;
            return r100.entrySet().remove(r110);
        L7:
            if ((r110 instanceof Map.Entry) == false) goto L16;
            Map.Entry r111 = (Map.Entry) r110;
            if (this.f274970a.needsAllocArrays() == false) goto L11;
            return false;
        L11:
            int r101 = CompactHashMap.access$700(this.f274970a);
            int r112 = q.b(r111.getKey(), r111.getValue(), r101, CompactHashMap.access$800(this.f274970a), CompactHashMap.access$900(this.f274970a), CompactHashMap.access$1000(this.f274970a), CompactHashMap.access$1100(this.f274970a));
            if (r112 != (-1)) goto L14;
            return false;
        L14:
            this.f274970a.moveLastEntry(r112, r101);
            CompactHashMap.access$1210(this.f274970a);
            this.f274970a.incrementModCount();
            return true;
        L16:
            return false;
        }
    }

    public abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f274973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274974d;

        @ParametricNullness
        public abstract T a(int r100);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f274972b < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final T next() {
            if (CompactHashMap.access$000(this.f274974d) != this.f274971a) goto L11;
            if (hasNext() == false) goto L9;
            int r100 = this.f274972b;
            this.f274973c = r100;
            T r101 = a(r100);
            this.f274972b = this.f274974d.getSuccessor(this.f274972b);
            return r101;
        L9:
            throw new NoSuchElementException();
        L11:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (CompactHashMap.access$000(this.f274974d) != this.f274971a) goto L11;
            if (this.f274973c < 0) goto L7;
            boolean r100 = true;
        L8:
            o.e(r100);
            this.f274971a += 32;
            CompactHashMap r101 = this.f274974d;
            r101.remove(CompactHashMap.access$100(r101, this.f274973c));
            this.f274972b = this.f274974d.adjustAfterRemove(this.f274972b, this.f274973c);
            this.f274973c = -1;
            return;
        L7:
            r100 = false;
            goto L8
        L11:
            throw new ConcurrentModificationException();
        }

        public e(CompactHashMap r100) {
            this.f274974d = r100;
            this.f274971a = CompactHashMap.access$000(r100);
            this.f274972b = r100.firstEntryIndex();
            this.f274973c = -1;
        }
    }

    public class f extends AbstractSet<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274975a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f274975a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return this.f274975a.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f274975a.size();
        }

        public f(CompactHashMap r100) {
            this.f274975a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            return this.f274975a.containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            Map<K, V> r101 = this.f274975a.delegateOrNull();
            if (r101 == null) goto L6;
            return r101.keySet().remove(r100);
        L6:
            if (CompactHashMap.access$200(this.f274975a, r100) == CompactHashMap.access$300()) goto L8;
            return true;
        L8:
            return false;
        }
    }

    public final class g extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f274976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274978c;

        public final void a() {
            int r100 = this.f274977b;
            if (r100 != (-1)) goto L5;
        L8:
            this.f274977b = CompactHashMap.access$500(this.f274978c, this.f274976a);
            return;
        L5:
            if (r100 >= this.f274978c.size()) goto L8;
            if (com.google.common.base.k.a(this.f274976a, CompactHashMap.access$100(this.f274978c, this.f274977b)) == false) goto L8;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final V getValue() {
            Map<K, V> r100 = this.f274978c.delegateOrNull();
            if (r100 != null) goto L5;
            a();
            int r101 = this.f274977b;
            if (r101 != (-1)) goto L10;
            return null;
        L10:
            return (V) CompactHashMap.access$600(this.f274978c, r101);
        L5:
            return r100.get(this.f274976a);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final K getKey() {
            return this.f274976a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @ParametricNullness
        public final V setValue(@ParametricNullness V r100) {
            Map<K, V> r101 = this.f274978c.delegateOrNull();
            if (r101 != null) goto L5;
            a();
            int r102 = this.f274977b;
            if (r102 != (-1)) goto L10;
            this.f274978c.put(this.f274976a, r100);
            return null;
        L10:
            V r103 = (V) CompactHashMap.access$600(this.f274978c, r102);
            CompactHashMap.access$1300(this.f274978c, this.f274977b, r100);
            return r103;
        L5:
            return r101.put(this.f274976a, r100);
        }

        public g(CompactHashMap r100, int r101) {
            this.f274978c = r100;
            this.f274976a = (K) CompactHashMap.access$100(r100, r101);
            this.f274977b = r101;
        }
    }

    public class h extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f274979a;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f274979a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return this.f274979a.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f274979a.size();
        }

        public h(CompactHashMap r100) {
            this.f274979a = r100;
        }
    }

    public void accessEntry(int r100) {
    }

    public int adjustAfterRemove(int r100, int r101) {
        return r100 - 1;
    }

    static {
        f274960g = new Object();
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap();
    }

    public final int a() {
        return (1 << (this.f274962b & 31)) - 1;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d(this);
    }

    public Set<K> createKeySet() {
        return new f(this);
    }

    public Collection<V> createValues() {
        return new h(this);
    }

    public final int[] d() {
        int[] r100 = this.entries;
        Objects.requireNonNull(r100);
        return r100;
    }

    @CheckForNull
    public Map<K, V> delegateOrNull() {
        Object r100 = this.f274961a;
        if ((r100 instanceof Map) == true) goto L5;
        return null;
    L5:
        return (Map) r100;
    }

    public final Object[] e() {
        Object[] r100 = this.keys;
        Objects.requireNonNull(r100);
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r100 = this.f274965e;
        if (r100 != null) goto L6;
        Set<Map.Entry<K, V>> r101 = createEntrySet();
        this.f274965e = r101;
        return r101;
    L6:
        return r100;
    }

    public final Object[] f() {
        Object[] r100 = this.values;
        Objects.requireNonNull(r100);
        return r100;
    }

    public void incrementModCount() {
        this.f274962b += 32;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r100 = this.f274964d;
        if (r100 != null) goto L6;
        Set<K> r101 = createKeySet();
        this.f274964d = r101;
        return r101;
    L6:
        return r100;
    }

    public boolean needsAllocArrays() {
        if (this.f274961a != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r100 = this.f274966f;
        if (r100 != null) goto L6;
        Collection<V> r101 = createValues();
        this.f274966f = r101;
        return r101;
    L6:
        return r100;
    }

    public CompactHashMap() {
        init(3);
    }

    public int allocArrays() {
        com.google.common.base.m.p(needsAllocArrays(), "Arrays already allocated");
        int r100 = this.f274962b;
        int r101 = q.e(r100);
        this.f274961a = q.a(r101);
        this.f274962b = ((32 - Integer.numberOfLeadingZeros(r101 - 1)) & 31) | (this.f274962b & (-32));
        this.entries = new int[r100];
        this.keys = new Object[r100];
        this.values = new Object[r100];
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        incrementModCount();
        Map<K, V> r100 = delegateOrNull();
        if (r100 == null) goto L8;
        this.f274962b = Ints.b(size(), 3);
        r100.clear();
        this.f274961a = null;
        this.f274963c = 0;
        return;
    L8:
        Arrays.fill(e(), 0, this.f274963c, null);
        Arrays.fill(f(), 0, this.f274963c, null);
        Object r101 = this.f274961a;
        Objects.requireNonNull(r101);
        if ((r101 instanceof byte[]) == false) goto L12;
        Arrays.fill((byte[]) r101, (byte) 0);
    L15:
        Arrays.fill(d(), 0, this.f274963c, 0);
        this.f274963c = 0;
        return;
    L12:
        if ((r101 instanceof short[]) == false) goto L14;
        Arrays.fill((short[]) r101, 0);
        goto L15
    L14:
        Arrays.fill((int[]) r101, 0);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> r100 = createHashFloodingResistantDelegate(a() + 1);
        int r101 = firstEntryIndex();
    L3:
        if (r101 < 0) goto L5;
        r100.put(e()[r101], f()[r101]);
        r101 = getSuccessor(r101);
        goto L3
    L5:
        this.f274961a = r100;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return r100;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> r100 = delegateOrNull();
        if (r100 == null) goto L7;
        return r100.entrySet().iterator();
    L7:
        return new b(this);
    }

    public int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Iterator<K> keySetIterator() {
        Map<K, V> r100 = delegateOrNull();
        if (r100 == null) goto L7;
        return r100.keySet().iterator();
    L7:
        return new a(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> r100 = delegateOrNull();
        if (r100 == null) goto L6;
        return r100.size();
    L6:
        return this.f274963c;
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        Map<K, V> r100 = delegateOrNull();
        if (r100 == null) goto L9;
        Map<K, V> r101 = createHashFloodingResistantDelegate(size());
        r101.putAll(r100);
        this.f274961a = r101;
        return;
    L9:
        int r102 = this.f274963c;
        if (r102 >= d().length) goto L12;
        resizeEntries(r102);
    L12:
        int r103 = q.e(r102);
        int r104 = a();
        if (r103 >= r104) goto L16;
        g(r104, r103, 0, 0);
        return;
    }

    public Iterator<V> valuesIterator() {
        Map<K, V> r100 = delegateOrNull();
        if (r100 == null) goto L7;
        return r100.values().iterator();
    L7:
        return new c(this);
    }

    public static /* synthetic */ Object access$300() {
        return f274960g;
    }

    public CompactHashMap(int r100) {
        init(r100);
    }

    public static /* synthetic */ int access$000(CompactHashMap r100) {
        return r100.f274962b;
    }

    public static /* synthetic */ Object[] access$1000(CompactHashMap r100) {
        return r100.e();
    }

    public static /* synthetic */ Object[] access$1100(CompactHashMap r100) {
        return r100.f();
    }

    public static /* synthetic */ int access$1210(CompactHashMap r100) {
        int r101 = r100.f274963c;
        r100.f274963c = r101 - 1;
        return r101;
    }

    public static /* synthetic */ int access$700(CompactHashMap r100) {
        return r100.a();
    }

    public static Object access$800(CompactHashMap r100) {
        Object r101 = r100.f274961a;
        Objects.requireNonNull(r101);
        return r101;
    }

    public static /* synthetic */ int[] access$900(CompactHashMap r100) {
        return r100.d();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int r100) {
        return new CompactHashMap(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        int r101 = r100.readInt();
        if (r101 < 0) goto L9;
        init(r101);
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        put(r100.readObject(), r100.readObject());
        r102 = r102 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException("Invalid size: " + r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeInt(size());
        Iterator<Map.Entry<K, V>> r101 = entrySetIterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<K, V> r102 = r101.next();
        r100.writeObject(r102.getKey());
        r100.writeObject(r102.getValue());
        goto L4
    }

    public final int b(@CheckForNull Object r100) {
        if (needsAllocArrays() == false) goto L5;
        return -1;
    L5:
        int r101 = u0.c(r100);
        int r102 = a();
        Object r103 = this.f274961a;
        Objects.requireNonNull(r103);
        int r104 = q.c(r103, r101 & r102);
        if (r104 != 0) goto L8;
        return -1;
    L8:
        int r105 = ~r102;
        int r106 = r101 & r105;
    L9:
        int r107 = r104 - 1;
        int r108 = d()[r107];
        if ((r108 & r105) == r106) goto L12;
    L14:
        r104 = r108 & r102;
        if (r104 != 0) goto L9;
        return -1;
    L12:
        if (com.google.common.base.k.a(r100, e()[r107]) == false) goto L14;
        return r107;
    }

    public final Object c(@CheckForNull Object r110) {
        boolean r100 = needsAllocArrays();
        Object r101 = f274960g;
        if (r100 == false) goto L5;
        return r101;
    L5:
        int r102 = a();
        Object r103 = this.f274961a;
        Objects.requireNonNull(r103);
        int r111 = q.b(r110, null, r102, r103, d(), e(), null);
        if (r111 != (-1)) goto L8;
        return r101;
    L8:
        Object r104 = f()[r111];
        moveLastEntry(r111, r102);
        this.f274963c--;
        incrementModCount();
        return r104;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r100) {
        Map<K, V> r101 = delegateOrNull();
        if (r101 == null) goto L6;
        return r101.containsKey(r100);
    L6:
        if (b(r100) == (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object r100) {
        Map<K, V> r101 = delegateOrNull();
        if (r101 != null) goto L5;
        int r102 = 0;
    L8:
        if (r102 >= this.f274963c) goto L14;
        if (com.google.common.base.k.a(r100, f()[r102]) == true) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    L5:
        return r101.containsValue(r100);
    }

    public Map<K, V> createHashFloodingResistantDelegate(int r100) {
        return new LinkedHashMap(r100, 1.0f);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        Map<K, V> r101 = delegateOrNull();
        if (r101 != null) goto L5;
        int r102 = b(r100);
        if (r102 != (-1)) goto L10;
        return null;
    L10:
        accessEntry(r102);
        return (V) f()[r102];
    L5:
        return r101.get(r100);
    }

    public int getSuccessor(int r100) {
        int r101 = r100 + 1;
        if (r101 < this.f274963c) goto L7;
        return -1;
    L7:
        return r101;
    }

    public void init(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        com.google.common.base.m.c(r101, "Expected size must be >= 0");
        this.f274962b = Ints.b(r100, 1);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object r100) {
        Map<K, V> r101 = delegateOrNull();
        if (r101 != null) goto L5;
        V r102 = (V) c(r100);
        if (r102 != f274960g) goto L10;
        return null;
    L10:
        return r102;
    L5:
        return r101.remove(r100);
    }

    public void resizeEntries(int r100) {
        this.entries = Arrays.copyOf(d(), r100);
        this.keys = Arrays.copyOf(e(), r100);
        this.values = Arrays.copyOf(f(), r100);
    }

    public static Object access$100(CompactHashMap r100, int r101) {
        return r100.e()[r101];
    }

    public static /* synthetic */ Object access$200(CompactHashMap r100, Object r101) {
        return r100.c(r101);
    }

    public static /* synthetic */ int access$500(CompactHashMap r100, Object r101) {
        return r100.b(r101);
    }

    public static Object access$600(CompactHashMap r100, int r101) {
        return r100.f()[r101];
    }

    public void moveLastEntry(int r110, int r111) {
        Object r100 = this.f274961a;
        Objects.requireNonNull(r100);
        int[] r101 = d();
        Object[] r102 = e();
        Object[] r103 = f();
        int r104 = size() - 1;
        if (r110 >= r104) goto L11;
        Object r105 = r102[r104];
        r102[r110] = r105;
        r103[r110] = r103[r104];
        r102[r104] = null;
        r103[r104] = null;
        r101[r110] = r101[r104];
        r101[r104] = 0;
        int r106 = u0.c(r105) & r111;
        int r107 = q.c(r100, r106);
        int r108 = r104 + 1;
        if (r107 != r108) goto L7;
        q.d(r100, r106, r110 + 1);
        return;
    L7:
        int r109 = r107 - 1;
        int r112 = r101[r109];
        int r113 = r112 & r111;
        if (r113 == r108) goto L9;
        r107 = r113;
        goto L7
    L9:
        r101[r109] = ((r110 + 1) & r111) | (r112 & (~r111));
        return;
    L11:
        r102[r110] = null;
        r103[r110] = null;
        r101[r110] = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V put(@ParametricNullness K r110, @ParametricNullness V r210) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        Map<K, V> r100 = delegateOrNull();
        if (r100 != null) goto L8;
        int[] r101 = d();
        Object[] r102 = e();
        Object[] r103 = f();
        int r104 = this.f274963c;
        int r105 = r104 + 1;
        int r106 = u0.c(r110);
        int r107 = a();
        int r111 = r106 & r107;
        Object r112 = this.f274961a;
        Objects.requireNonNull(r112);
        int r113 = q.c(r112, r111);
        if (r113 != 0) goto L17;
        if (r105 <= r107) goto L16;
        if (r107 >= 32) goto L14;
        int r114 = 4;
    L15:
        int r108 = g(r107, r114 * (r107 + 1), r106, r104);
    L36:
        r107 = r108;
    L38:
        int r109 = d().length;
        if (r105 <= r109) goto L43;
        int r115 = Math.min(1073741823, (Math.max(1, r109 >>> 1) + r109) | 1);
        if (r115 == r109) goto L43;
        resizeEntries(r115);
    L43:
        insertEntry(r104, r110, r210, r106, r107);
        this.f274963c = r105;
        incrementModCount();
        return null;
    L14:
        r114 = 2;
        goto L15
    L16:
        Object r116 = this.f274961a;
        Objects.requireNonNull(r116);
        q.d(r116, r111, r105);
        goto L38
    L17:
        int r117 = ~r107;
        int r118 = r106 & r117;
        int r119 = 0;
    L18:
        int r120 = r113 - 1;
        int r121 = r101[r120];
        int r122 = r121 & r117;
        if (r122 == r118) goto L21;
    L24:
        int r123 = r121 & r107;
        Object[] r124 = r102;
        int r125 = r119 + 1;
        if (r123 == 0) goto L27;
        r119 = r125;
        r113 = r123;
        r102 = r124;
        goto L18
    L27:
        if (r125 >= 9) goto L29;
        if (r105 > r107) goto L32;
        r101[r120] = (r105 & r107) | r122;
        goto L38
    L32:
        if (r107 >= 32) goto L34;
        int r126 = 4;
    L35:
        r108 = g(r107, r126 * (r107 + 1), r106, r104);
        goto L36
    L34:
        r126 = 2;
        goto L35
    L29:
        return convertToHashFloodingResistantImplementation().put(r110, r210);
    L21:
        if (com.google.common.base.k.a(r110, r102[r120]) == false) goto L24;
        V r127 = (V) r103[r120];
        r103[r120] = r210;
        accessEntry(r120);
        return r127;
    L8:
        return r100.put(r110, r210);
    }

    public static void access$1300(CompactHashMap r100, int r101, Object r102) {
        r100.f()[r101] = r102;
    }

    public final int g(int r100, int r110, int r111, int r112) {
        Object r101 = q.a(r110);
        int r113 = r110 - 1;
        if (r112 == 0) goto L5;
        q.d(r101, r111 & r113, r112 + 1);
    L5:
        Object r114 = this.f274961a;
        Objects.requireNonNull(r114);
        int[] r115 = d();
        int r102 = 0;
    L6:
        if (r102 > r100) goto L11;
        int r103 = q.c(r114, r102);
    L8:
        if (r103 == 0) goto L10;
        int r104 = r103 - 1;
        int r105 = r115[r104];
        int r106 = ((~r100) & r105) | r102;
        int r107 = r106 & r113;
        int r108 = q.c(r101, r107);
        q.d(r101, r107, r103);
        r115[r104] = ((~r113) & r106) | (r108 & r113);
        r103 = r105 & r100;
        goto L8
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        this.f274961a = r101;
        this.f274962b = ((32 - Integer.numberOfLeadingZeros(r113)) & 31) | (this.f274962b & (-32));
        return r113;
    }

    public void insertEntry(int r100, @ParametricNullness K r101, @ParametricNullness V r102, int r103, int r104) {
        int r105 = (r103 & (~r104)) | (r104 & 0);
        d()[r100] = r105;
        e()[r100] = r101;
        f()[r100] = r102;
    }
}
