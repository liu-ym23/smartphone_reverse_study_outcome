package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes42.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504707b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504708c = null;
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue<K> f504709a;
    private volatile /* synthetic */ Object core$volatile;

    public final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f504710g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f504711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f504712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f504713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicReferenceArray f504714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicReferenceArray f504715e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ConcurrentWeakMap<K, V> f504716f;
        private volatile /* synthetic */ int load$volatile;

        /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        public final class C6587a<E> implements Iterator<E>, KMutableIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Function2<K, V, E> f504717a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f504718b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public K f504719c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public V f504720d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ConcurrentWeakMap<K, V>.a f504721e;

            public final void a() {
            L2:
                int r100 = this.f504718b + 1;
                this.f504718b = r100;
                ConcurrentWeakMap<K, V>.a r101 = this.f504721e;
                if (r100 >= r101.f504711a) goto L23;
                d r102 = (d) r101.f504714d.get(r100);
                if (r102 == null) goto L2;
                K r103 = (K) r102.get();
                if (r103 == null) goto L2;
                this.f504719c = r103;
                Object r104 = (V) this.f504721e.f504715e.get(this.f504718b);
                if ((r104 instanceof e) == false) goto L12;
                r104 = (V) ((e) r104).f504734a;
            L12:
                if (r104 == null) goto L2;
                this.f504720d = (V) r104;
                return;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                if (this.f504718b >= this.f504721e.f504711a) goto L5;
                return true;
            L5:
                return false;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.Iterator
            public final E next() {
                if (this.f504718b >= this.f504721e.f504711a) goto L13;
                Function2<K, V, E> r100 = this.f504717a;
                K r101 = this.f504719c;
                if (r101 == true) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("key");
                r101 = (K) Unit.INSTANCE;
            L7:
                V r102 = this.f504720d;
                if (r102 == true) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException("value");
                r102 = (V) Unit.INSTANCE;
            L10:
                E r103 = (E) r100.invoke(r101, r102);
                a();
                return r103;
            L13:
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                b0 r100 = kotlinx.coroutines.debug.internal.a.f504726a;
                throw new UnsupportedOperationException("not implemented");
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C6587a(a r100, Function2<? super K, ? super V, ? extends E> r101) {
                this.f504721e = r100;
                this.f504717a = r101;
                this.f504718b = -1;
                a();
            }
        }

        static {
            f504710g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load$volatile");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.a b() {
        L2:
            int r100 = Integer.highestOneBit(RangesKt.coerceAtLeast(this.f504716f.size(), 4)) * 4;
            ConcurrentWeakMap<K, V>.a r101 = (ConcurrentWeakMap<K, V>.a) new a(this.f504716f, r100);
            int r102 = this.f504711a;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L33;
            d r104 = (d) this.f504714d.get(r103);
            if (r104 == null) goto L7;
            Object r105 = r104.get();
        L8:
            if (r104 == null) goto L11;
            if (r105 != null) goto L11;
            c(r103);
        L11:
            Object r106 = this.f504715e.get(r103);
            if ((r106 instanceof e) == true) goto L13;
            AtomicReferenceArray r107 = this.f504715e;
            if (r106 != null) goto L17;
            e r108 = kotlinx.coroutines.debug.internal.a.f504727b;
        L22:
            if (r107.compareAndSet(r103, r106, r108) == true) goto L23;
            if (r107.get(r103) == r106) goto L22;
            boolean r109 = false;
        L27:
            if (r109 == false) goto L11;
        L28:
            if (r105 == null) goto L32;
            if (r106 == null) goto L32;
            if (r101.a(r105, r106, r104) == kotlinx.coroutines.debug.internal.a.f504726a) goto L2;
        L32:
            r103 = r103 + 1;
            goto L3
        L23:
            r109 = true;
            goto L27
        L17:
            b0 r110 = kotlinx.coroutines.debug.internal.a.f504726a;
            if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L20;
            r108 = kotlinx.coroutines.debug.internal.a.f504728c;
            goto L22
        L20:
            r108 = new e(r106);
            goto L22
        L13:
            r106 = ((e) r106).f504734a;
            goto L28
        L7:
            r105 = null;
            goto L8
        L33:
            return r101;
        }

        public final void c(int r100) {
        L2:
            Object r101 = this.f504715e.get(r100);
            if (r101 == null) goto L4;
            if ((r101 instanceof e) == true) goto L7;
            AtomicReferenceArray r102 = this.f504715e;
        L10:
            if (r102.compareAndSet(r100, r101, null) == true) goto L11;
            if (r102.get(r100) == r101) goto L10;
            boolean r103 = false;
        L15:
            if (r103 == false) goto L2;
            ConcurrentWeakMap<K, V> r104 = this.f504716f;
            AtomicIntegerFieldUpdater r105 = ConcurrentWeakMap.f504707b;
            r104.getClass();
            ConcurrentWeakMap.f504707b.decrementAndGet(r104);
            return;
        L11:
            r103 = true;
            goto L15
        L7:
            return;
        }

        public a(ConcurrentWeakMap r100, int r101) {
            this.f504716f = r100;
            this.f504711a = r101;
            this.f504712b = Integer.numberOfLeadingZeros(r101) + 1;
            this.f504713c = (r101 * 2) / 3;
            this.f504714d = new AtomicReferenceArray(r101);
            this.f504715e = new AtomicReferenceArray(r101);
        }

        public final Object a(K r110, V r111, d<K> r112) {
            int r100 = (r110.hashCode() * (-1640531527)) >>> this.f504712b;
            boolean r101 = false;
        L3:
            d r102 = (d) this.f504714d.get(r100);
            if (r102 == null) goto L6;
            T r103 = r102.get();
            if (Intrinsics.areEqual(r110, r103) == true) goto L31;
            if (r103 != 0) goto L48;
            c(r100);
        L48:
            if (r100 != 0) goto L50;
            r100 = this.f504711a;
        L50:
            r100 = r100 - 1;
            goto L3
        L31:
            if (r101 == false) goto L33;
            f504710g.decrementAndGet(this);
        L33:
            Object r104 = this.f504715e.get(r100);
            if ((r104 instanceof e) == true) goto L36;
            AtomicReferenceArray r105 = this.f504715e;
        L39:
            if (r105.compareAndSet(r100, r104, r111) == true) goto L40;
            if (r105.get(r100) == r104) goto L39;
            boolean r113 = false;
        L44:
            if (r113 == false) goto L33;
            return r104;
        L40:
            r113 = true;
            goto L44
        L36:
            return kotlinx.coroutines.debug.internal.a.f504726a;
        L6:
            if (r111 == null) goto L7;
            if (r101 == true) goto L17;
            AtomicIntegerFieldUpdater r106 = f504710g;
        L10:
            int r107 = r106.get(this);
            if (r107 >= this.f504713c) goto L13;
            if (r106.compareAndSet(this, r107, r107 + 1) == false) goto L10;
            boolean r108 = true;
        L18:
            if (r112 != null) goto L20;
            r112 = new d(r110, this.f504716f.f504709a);
        L20:
            d<K> r109 = r112;
            AtomicReferenceArray r114 = this.f504714d;
        L22:
            if (r114.compareAndSet(r100, null, r109) == true) goto L23;
            if (r114.get(r100) == null) goto L22;
            boolean r115 = false;
        L27:
            if (r115 == true) goto L33;
            r101 = r108;
            r112 = r109;
            goto L3
        L23:
            r115 = true;
            goto L27
        L13:
            return kotlinx.coroutines.debug.internal.a.f504726a;
        L17:
            r108 = r101;
            goto L18
        L7:
            return null;
        }
    }

    public static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f504722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f504723b;

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f504722a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f504723b;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r100) {
            b0 r101 = kotlinx.coroutines.debug.internal.a.f504726a;
            throw new UnsupportedOperationException("not implemented");
        }

        public b(K r100, V r101) {
            this.f504722a = r100;
            this.f504723b = r101;
        }
    }

    public final class c<E> extends AbstractMutableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2<K, V, E> f504724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConcurrentWeakMap<K, V> f504725b;

        @Override // kotlin.collections.AbstractMutableSet
        public final int getSize() {
            return this.f504725b.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<E> iterator() {
            a r100 = (a) ConcurrentWeakMap.f504708c.get(this.f504725b);
            Function2<K, V, E> r101 = this.f504724a;
            r100.getClass();
            return new a.C6587a(r100, r101);
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(E r100) {
            b0 r101 = kotlinx.coroutines.debug.internal.a.f504726a;
            throw new UnsupportedOperationException("not implemented");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(ConcurrentWeakMap r100, Function2<? super K, ? super V, ? extends E> r101) {
            this.f504725b = r100;
            this.f504724a = r101;
        }
    }

    static {
        f504707b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size$volatile");
        f504708c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core$volatile");
    }

    public ConcurrentWeakMap() {
        this(false);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final Set<Map.Entry<K, V>> getEntries() {
        return new c(this, ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final Set<K> getKeys() {
        return new c(this, ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final int getSize() {
        return f504707b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Iterator<K> r100 = keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        remove(r100.next());
        goto L4
    }

    public ConcurrentWeakMap(boolean r100) {
        this.core$volatile = new a(this, 16);
        if (r100 == false) goto L5;
        ReferenceQueue<K> r101 = new ReferenceQueue();
    L6:
        this.f504709a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a r101 = (a) f504708c.get(this);
        r101.getClass();
        int r102 = (r100.hashCode() * (-1640531527)) >>> r101.f504712b;
    L6:
        d r103 = (d) r101.f504714d.get(r102);
        if (r103 == null) goto L25;
        T r104 = r103.get();
        if (Intrinsics.areEqual(r100, r104) == true) goto L11;
        if (r104 != 0) goto L18;
        r101.c(r102);
    L18:
        if (r102 != 0) goto L20;
        r102 = r101.f504711a;
    L20:
        r102 = r102 - 1;
        goto L6
    L11:
        Object r105 = r101.f504715e.get(r102);
        if ((r105 instanceof e) == false) goto L15;
        r105 = ((e) r105).f504734a;
    L15:
        return (V) r105;
    L25:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object r100) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        a r101 = (a) f504708c.get(this);
        AtomicIntegerFieldUpdater r102 = a.f504710g;
        V r103 = (V) r101.a(r100, null, null);
        if (r103 != kotlinx.coroutines.debug.internal.a.f504726a) goto L8;
        r103 = a(r100, null);
    L8:
        if (r103 == null) goto L10;
        f504707b.decrementAndGet(this);
    L10:
        return r103;
    }

    public final synchronized V a(K r100, V r101) {
        monitor-enter(this);
        a r102 = (a) f504708c.get(this);     // Catch: Throwable -> L10
    L4:
        AtomicIntegerFieldUpdater r103 = a.f504710g;     // Catch: Throwable -> L10
        V r104 = (V) r102.a(r100, r101, null);
        if (r104 != kotlinx.coroutines.debug.internal.a.f504726a) goto L6;
        r102 = r102.b();     // Catch: Throwable -> L10
        f504708c.set(this, r102);     // Catch: Throwable -> L10
        goto L4
    L6:
        monitor-exit(this);
        return r104;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public final V put(K r100, V r101) {
        a r102 = (a) f504708c.get(this);
        AtomicIntegerFieldUpdater r103 = a.f504710g;
        V r104 = (V) r102.a(r100, r101, null);
        if (r104 != kotlinx.coroutines.debug.internal.a.f504726a) goto L5;
        r104 = a(r100, r101);
    L5:
        if (r104 != null) goto L7;
        f504707b.incrementAndGet(this);
    L7:
        return r104;
    }
}
