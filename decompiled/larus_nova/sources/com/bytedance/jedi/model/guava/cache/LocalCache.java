package com.bytedance.jedi.model.guava.cache;

import androidx.collection.SieveCacheKt;
import com.bytedance.jedi.model.guava.annotations.MonotonicNonNullDecl;
import com.bytedance.jedi.model.guava.annotations.NullableDecl;
import com.bytedance.jedi.model.guava.base.Equivalence;
import com.bytedance.jedi.model.guava.base.MoreObjects;
import com.bytedance.jedi.model.guava.base.Ticker;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Logger f251093u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final AnonymousClass1 f251094v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Queue<?> f251095w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f251096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f251097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Segment<K, V>[] f251098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f251099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Equivalence<Object> f251100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Equivalence<Object> f251101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Strength f251102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Strength f251103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f251104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Weigher<K, V> f251105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f251106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f251107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f251108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Queue<RemovalNotification<K, V>> f251109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RemovalListener<K, V> f251110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Ticker f251111p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final EntryFactory f251112q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @MonotonicNonNullDecl
    public Set<K> f251113r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @MonotonicNonNullDecl
    public Collection<V> f251114s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @MonotonicNonNullDecl
    public Set<Map.Entry<K, V>> f251115t;

    public abstract class AbstractCacheSet<T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentMap<?, ?> f251116a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f251116a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return this.f251116a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f251116a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        public AbstractCacheSet(ConcurrentMap r100) {
            this.f251116a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final <E> E[] toArray(E[] r100) {
            return (E[]) LocalCache.a(this).toArray(r100);
        }
    }

    public static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        public AbstractReferenceEntry() {
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setAccessTime(long r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setWriteTime(long r100) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnonymousClass1 f251117a;

        /* JADX INFO: renamed from: com.bytedance.jedi.model.guava.cache.LocalCache$AccessQueue$1, reason: invalid class name */
        public class AnonymousClass1 extends AbstractReferenceEntry<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ReferenceEntry<K, V> f251118a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public ReferenceEntry<K, V> f251119b;

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final void setAccessTime(long r100) {
            }

            public AnonymousClass1() {
                this.f251118a = this;
                this.f251119b = this;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.f251118a;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.f251119b;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final void setNextInAccessQueue(ReferenceEntry<K, V> r100) {
                this.f251118a = r100;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final void setPreviousInAccessQueue(ReferenceEntry<K, V> r100) {
                this.f251119b = r100;
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            ReferenceEntry<K, V> r100 = this.f251117a.f251118a;
        L3:
            AnonymousClass1 r101 = this.f251117a;
            if (r100 == r101) goto L6;
            ReferenceEntry<K, V> r102 = r100.getNextInAccessQueue();
            Logger r103 = LocalCache.f251093u;
            NullEntry r104 = NullEntry.INSTANCE;
            r100.setNextInAccessQueue(r104);
            r100.setPreviousInAccessQueue(r104);
            r100 = r102;
            goto L3
        L6:
            r101.f251118a = r101;
            r101.f251119b = r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            AnonymousClass1 r100 = this.f251117a;
            if (r100.f251118a != r100) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<ReferenceEntry<K, V>> iterator() {
            AnonymousClass1 r100 = this.f251117a;
            final ReferenceEntry<K, V> r101 = r100.f251118a;
            if (r101 != r100) goto L6;
            r101 = null;
        L6:
            return new AnonymousClass2(this, r101);
        }

        @Override // java.util.Queue
        public final Object peek() {
            AnonymousClass1 r100 = this.f251117a;
            ReferenceEntry<K, V> r101 = r100.f251118a;
            if (r101 != r100) goto L6;
            return null;
        L6:
            return r101;
        }

        @Override // java.util.Queue
        public final Object poll() {
            AnonymousClass1 r100 = this.f251117a;
            ReferenceEntry<K, V> r101 = r100.f251118a;
            if (r101 != r100) goto L5;
            return null;
        L5:
            remove(r101);
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            ReferenceEntry<K, V> r100 = this.f251117a.f251118a;
            int r101 = 0;
        L4:
            if (r100 == this.f251117a) goto L6;
            r101 = r101 + 1;
            r100 = r100.getNextInAccessQueue();
            goto L4
        L6:
            return r101;
        }

        public AccessQueue() {
            this.f251117a = new AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object r100) {
            if (((ReferenceEntry) r100).getNextInAccessQueue() == NullEntry.INSTANCE) goto L5;
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
        @Override // java.util.Queue
        public final boolean offer(Object r100) {
            ReferenceEntry<K, V> r101 = (ReferenceEntry) r100;
            ReferenceEntry<K, V> r102 = r101.getPreviousInAccessQueue();
            ReferenceEntry<K, V> r103 = r101.getNextInAccessQueue();
            Logger r104 = LocalCache.f251093u;
            r102.setNextInAccessQueue(r103);
            r103.setPreviousInAccessQueue(r102);
            ReferenceEntry<K, V> r105 = this.f251117a.f251119b;
            r105.setNextInAccessQueue(r101);
            r101.setPreviousInAccessQueue(r105);
            AnonymousClass1 r106 = this.f251117a;
            r101.setNextInAccessQueue(r106);
            r106.f251119b = r101;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object r100) {
            ReferenceEntry r101 = (ReferenceEntry) r100;
            ReferenceEntry<K, V> r102 = r101.getPreviousInAccessQueue();
            ReferenceEntry<K, V> r103 = r101.getNextInAccessQueue();
            Logger r104 = LocalCache.f251093u;
            r102.setNextInAccessQueue(r103);
            r103.setPreviousInAccessQueue(r102);
            NullEntry r105 = NullEntry.INSTANCE;
            r101.setNextInAccessQueue(r105);
            r101.setPreviousInAccessQueue(r105);
            if (r103 == r105) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static abstract enum EntryFactory extends Enum<EntryFactory> {
        static final int ACCESS_MASK = 1;
        public static final EntryFactory STRONG = null;
        public static final EntryFactory STRONG_ACCESS = null;
        public static final EntryFactory STRONG_ACCESS_WRITE = null;
        public static final EntryFactory STRONG_WRITE = null;
        public static final EntryFactory WEAK = null;
        public static final EntryFactory WEAK_ACCESS = null;
        public static final EntryFactory WEAK_ACCESS_WRITE = null;
        static final int WEAK_MASK = 4;
        public static final EntryFactory WEAK_WRITE = null;
        static final int WRITE_MASK = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EntryFactory[] f251121a = null;
        static final EntryFactory[] factories = null;

        public EntryFactory() {
            throw null;
        }

        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> r100, K r101, int r102, @NullableDecl ReferenceEntry<K, V> r103);

        static {
            final String r100 = "STRONG";
            final int r101 = 0;
            EntryFactory r102 = new AnonymousClass1(r100, r101);
            STRONG = r102;
            final String r103 = "STRONG_ACCESS";
            final int r104 = 1;
            EntryFactory r105 = new AnonymousClass2(r103, r104);
            STRONG_ACCESS = r105;
            final String r106 = "STRONG_WRITE";
            final int r107 = 2;
            EntryFactory r108 = new AnonymousClass3(r106, r107);
            STRONG_WRITE = r108;
            final String r109 = "STRONG_ACCESS_WRITE";
            final int r110 = 3;
            EntryFactory r111 = new AnonymousClass4(r109, r110);
            STRONG_ACCESS_WRITE = r111;
            final String r112 = "WEAK";
            final int r113 = 4;
            EntryFactory r114 = new AnonymousClass5(r112, r113);
            WEAK = r114;
            final String r115 = "WEAK_ACCESS";
            final int r116 = 5;
            EntryFactory r117 = new AnonymousClass6(r115, r116);
            WEAK_ACCESS = r117;
            final String r118 = "WEAK_WRITE";
            final int r119 = 6;
            EntryFactory r120 = new AnonymousClass7(r118, r119);
            WEAK_WRITE = r120;
            final String r121 = "WEAK_ACCESS_WRITE";
            final int r122 = 7;
            EntryFactory r123 = new AnonymousClass8(r121, r122);
            WEAK_ACCESS_WRITE = r123;
            f251121a = new EntryFactory[]{r102, r105, r108, r111, r114, r117, r120, r123};
            factories = new EntryFactory[]{r102, r105, r108, r111, r114, r117, r120, r123};
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) f251121a.clone();
        }

        public static EntryFactory valueOf(String r100) {
            return (EntryFactory) a.a(EntryFactory.class, r100);
        }

        public <K, V> void copyAccessEntry(ReferenceEntry<K, V> r100, ReferenceEntry<K, V> r101) {
            r101.setAccessTime(r100.getAccessTime());
            ReferenceEntry<K, V> r102 = r100.getPreviousInAccessQueue();
            Logger r103 = LocalCache.f251093u;
            r102.setNextInAccessQueue(r101);
            r101.setPreviousInAccessQueue(r102);
            ReferenceEntry<K, V> r104 = r100.getNextInAccessQueue();
            r101.setNextInAccessQueue(r104);
            r104.setPreviousInAccessQueue(r101);
            NullEntry r105 = NullEntry.INSTANCE;
            r100.setNextInAccessQueue(r105);
            r100.setPreviousInAccessQueue(r105);
        }

        public <K, V> void copyWriteEntry(ReferenceEntry<K, V> r100, ReferenceEntry<K, V> r101) {
            r101.setWriteTime(r100.getWriteTime());
            ReferenceEntry<K, V> r102 = r100.getPreviousInWriteQueue();
            Logger r103 = LocalCache.f251093u;
            r102.setNextInWriteQueue(r101);
            r101.setPreviousInWriteQueue(r102);
            ReferenceEntry<K, V> r104 = r100.getNextInWriteQueue();
            r101.setNextInWriteQueue(r104);
            r104.setPreviousInWriteQueue(r101);
            NullEntry r105 = NullEntry.INSTANCE;
            r100.setNextInWriteQueue(r105);
            r100.setPreviousInWriteQueue(r105);
        }

        public EntryFactory(String r100, int r101, AnonymousClass1 r102) {
            super(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EntryFactory getFactory(Strength r100, boolean r101, boolean r102) {
            int r103 = 0;
            if (r100 != Strength.WEAK) goto L5;
            char r104 = 4;
        L6:
            boolean r105 = r104 | (r101 ? 1 : 0);
            if (r102 == false) goto L9;
            r103 = 2;
        L9:
            int r106 = (r105 ? 1 : 0) | r103;
            return factories[r106];
        L5:
            r104 = 0;
            goto L6
        }

        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> r100, ReferenceEntry<K, V> r101, ReferenceEntry<K, V> r102) {
            return newEntry(r100, r101.getKey(), r101.getHash(), r102);
        }
    }

    public final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        @Override // java.util.Iterator
        public final Object next() {
            return c();
        }

        public EntryIterator(LocalCache r100) {
            super(r100);
        }
    }

    public final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalCache f251122b;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.f251122b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r100) {
            if ((r100 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            if (r102 != null) goto L8;
            return false;
        L8:
            Object r103 = this.f251122b.get(r102);
            if (r103 != null) goto L11;
            return false;
        L11:
            if (this.f251122b.f251101f.equivalent(r101.getValue(), r103) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r100) {
            if ((r100 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            if (r102 != null) goto L8;
            return false;
        L8:
            if (this.f251122b.remove(r102, r101.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public EntrySet(LocalCache r100, ConcurrentMap<?, ?> r101) {
            this.f251122b = r100;
            super(r101);
        }
    }

    public abstract class HashIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f251123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f251124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @MonotonicNonNullDecl
        public Segment<K, V> f251125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @MonotonicNonNullDecl
        public AtomicReferenceArray<ReferenceEntry<K, V>> f251126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NullableDecl
        public ReferenceEntry<K, V> f251127e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NullableDecl
        public LocalCache<K, V>.WriteThroughEntry f251128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NullableDecl
        public LocalCache<K, V>.WriteThroughEntry f251129g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ LocalCache f251130h;

        public final void a() {
            this.f251128f = null;
            ReferenceEntry<K, V> r100 = this.f251127e;
            if (r100 == null) goto L10;
        L4:
            ReferenceEntry<K, V> r101 = r100.getNext();
            this.f251127e = r101;
            if (r101 == null) goto L10;
            if (b(r101) == true) goto L8;
            r100 = this.f251127e;
            goto L4
        L8:
            boolean r102 = true;
        L11:
            if (r102 == false) goto L14;
            return;
        L14:
            if (d() == false) goto L16;
            return;
        L16:
            int r103 = this.f251123a;
            if (r103 < 0) goto L22;
            Segment<K, V>[] r104 = this.f251130h.f251098c;
            this.f251123a = r103 - 1;
            Segment<K, V> r105 = r104[r103];
            this.f251125c = r105;
            if (r105.count == 0) goto L16;
            AtomicReferenceArray<ReferenceEntry<K, V>> r106 = this.f251125c.table;
            this.f251126d = r106;
            this.f251124b = r106.length() - 1;
            if (d() == false) goto L16;
            return;
        L22:
            return;
        L10:
            r102 = false;
            goto L11
        }

        public final LocalCache<K, V>.WriteThroughEntry c() {
            LocalCache<K, V>.WriteThroughEntry r100 = this.f251128f;
            if (r100 == null) goto L7;
            this.f251129g = r100;
            a();
            return this.f251129g;
        L7:
            throw new NoSuchElementException();
        }

        public final boolean d() {
        L2:
            int r100 = this.f251124b;
            boolean r101 = false;
            if (r100 < 0) goto L18;
            AtomicReferenceArray<ReferenceEntry<K, V>> r102 = this.f251126d;
            this.f251124b = r100 - 1;
            ReferenceEntry<K, V> r103 = r102.get(r100);
            this.f251127e = r103;
            if (r103 == null) goto L2;
            if (b(r103) == true) goto L17;
            ReferenceEntry<K, V> r104 = this.f251127e;
            if (r104 == null) goto L16;
        L10:
            ReferenceEntry<K, V> r105 = r104.getNext();
            this.f251127e = r105;
            if (r105 == null) goto L16;
            if (b(r105) == true) goto L14;
            r104 = this.f251127e;
            goto L10
        L14:
            r101 = true;
        L16:
            if (r101 == false) goto L2;
        L17:
            return true;
        L18:
            return false;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f251128f == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            LocalCache<K, V>.WriteThroughEntry r100 = this.f251129g;
            if (r100 == null) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            this.f251130h.remove(r100.f251177a);
            this.f251129g = null;
            return;
        L10:
            throw new IllegalStateException();
        L5:
            r101 = false;
            goto L6
        }

        public HashIterator(LocalCache r100) {
            this.f251130h = r100;
            this.f251123a = r100.f251098c.length - 1;
            this.f251124b = -1;
            a();
        }

        public final boolean b(ReferenceEntry<K, V> r100) {
            long r101 = this.f251130h.f251111p.a();     // Catch: Throwable -> L18
            K r102 = r100.getKey();     // Catch: Throwable -> L18
            LocalCache r103 = this.f251130h;     // Catch: Throwable -> L18
            r103.getClass();     // Catch: Throwable -> L18
            V r104 = null;
            if (r100.getKey() == null) goto L12;
            V r105 = r100.getValueReference().get();     // Catch: Throwable -> L18
            if (r105 == null) goto L12;
            if (r103.f(r100, r101) == true) goto L12;
            r104 = r105;
        L12:
            if (r104 == null) goto L16;
            this.f251128f = new WriteThroughEntry(this.f251130h, r102, r104);     // Catch: Throwable -> L18
            this.f251125c.postReadCleanup();
            return true;
        L16:
            this.f251125c.postReadCleanup();
            return false;
        L18:
            th = move-exception;
            this.f251125c.postReadCleanup();
            throw th;
        }
    }

    public final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        @Override // java.util.Iterator
        public final K next() {
            return c().f251177a;
        }

        public KeyIterator(LocalCache r100) {
            super(r100);
        }
    }

    public final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalCache f251131b;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new KeyIterator(this.f251131b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r100) {
            return this.f251116a.containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r100) {
            if (this.f251116a.remove(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }

        public KeySet(LocalCache r100, ConcurrentMap<?, ?> r101) {
            this.f251131b = r100;
            super(r101);
        }
    }

    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        public LocalManualCache() {
            throw null;
        }

        public void cleanUp() {
            Segment<K, V>[] r100 = this.localCache.f251098c;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            r100[r102].cleanUp();
            r102 = r102 + 1;
            goto L3
        }

        public void invalidateAll() {
            this.localCache.clear();
        }

        public long size() {
            Segment<K, V>[] r100 = this.localCache.f251098c;
            long r101 = 0;
            int r102 = 0;
        L4:
            if (r102 >= r100.length) goto L6;
            r101 = r101 + ((long) Math.max(0, r100[r102].count));
            r102 = r102 + 1;
            goto L4
        L6:
            return r101;
        }

        @Override // com.bytedance.jedi.model.guava.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> r100) {
            this.localCache = new LocalCache(r100);
        }

        @Override // com.bytedance.jedi.model.guava.cache.Cache
        @NullableDecl
        public V getIfPresent(Object r100) {
            LocalCache<K, V> r101 = this.localCache;
            Logger r102 = LocalCache.f251093u;
            r101.getClass();
            r100.getClass();
            int r103 = r101.e(r100);
            return r101.h(r103).get(r100, r103);
        }

        @Override // com.bytedance.jedi.model.guava.cache.Cache
        public void invalidate(Object r100) {
            r100.getClass();
            this.localCache.remove(r100);
        }

        public void invalidateAll(Iterable<?> r100) {
            LocalCache<K, V> r101 = this.localCache;
            r101.getClass();
            Iterator<?> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r101.remove(r102.next());
            goto L4
        }

        public void putAll(Map<? extends K, ? extends V> r100) {
            this.localCache.putAll(r100);
        }

        @Override // com.bytedance.jedi.model.guava.cache.Cache
        public void put(K r100, V r101) {
            this.localCache.put(r100, r101);
        }
    }

    public static final enum NullEntry extends Enum<NullEntry> implements ReferenceEntry<Object, Object> {
        public static final NullEntry INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NullEntry[] f251132a = null;

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return 0;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return 0;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setAccessTime(long r100) {
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> r100) {
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> r100) {
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> r100) {
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> r100) {
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> r100) {
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public void setWriteTime(long r100) {
        }

        static {
            NullEntry r100 = new NullEntry();
            INSTANCE = r100;
            f251132a = new NullEntry[]{r100};
        }

        public NullEntry() {
            super("INSTANCE", 0);
        }

        public static NullEntry[] values() {
            return (NullEntry[]) f251132a.clone();
        }

        public static NullEntry valueOf(String r100) {
            return (NullEntry) a.a(NullEntry.class, r100);
        }
    }

    public static class Segment<K, V> extends ReentrantLock {
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;

        @NullableDecl
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount;
        final Queue<ReferenceEntry<K, V>> recencyQueue;

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        long totalWeight;

        @NullableDecl
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<ReferenceEntry<K, V>> writeQueue;

        public void drainKeyReferenceQueue() {
            int r100 = 0;
        L3:
            Reference<? extends K> r101 = this.keyReferenceQueue.poll();
            if (r101 == null) goto L7;
            ReferenceEntry<K, V> r102 = (ReferenceEntry) r101;
            LocalCache<K, V> r103 = this.map;
            r103.getClass();
            int r104 = r102.getHash();
            r103.h(r104).reclaimKey(r102, r104);
            r100 = r100 + 1;
            if (r100 != 16) goto L3;
            return;
        }

        public void drainValueReferenceQueue() {
            int r100 = 0;
        L3:
            Reference<? extends V> r101 = this.valueReferenceQueue.poll();
            if (r101 == null) goto L7;
            ValueReference<K, V> r102 = (ValueReference) r101;
            LocalCache<K, V> r103 = this.map;
            r103.getClass();
            ReferenceEntry<K, V> r104 = r102.getEntry();
            int r105 = r104.getHash();
            r103.h(r105).reclaimValue(r104.getKey(), r105, r102);
            r100 = r100 + 1;
            if (r100 != 16) goto L3;
            return;
        }

        public void cleanUp() {
            runLockedCleanup(this.map.f251111p.a());
            runUnlockedCleanup();
        }

        public void clear() {
            if (this.count == 0) goto L30;
            lock();
            preWriteCleanup(this.map.f251111p.a());     // Catch: Throwable -> L27
            AtomicReferenceArray<ReferenceEntry<K, V>> r100 = this.table;     // Catch: Throwable -> L27
            int r101 = 0;
        L7:
            if (r101 >= r100.length()) goto L21;
            ReferenceEntry<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L27
        L9:
            if (r102 == null) goto L20;
            if (r102.getValueReference().isActive() == false) goto L19;
            K r103 = r102.getKey();     // Catch: Throwable -> L27
            V r104 = r102.getValueReference().get();     // Catch: Throwable -> L27
            if (r103 == null) goto L17;
            if (r104 == null) goto L17;
            RemovalCause r105 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L27
        L18:
            enqueueNotification(r103, r102.getHash(), r104, r102.getValueReference().getWeight(), r105);     // Catch: Throwable -> L27
        L17:
            r105 = RemovalCause.COLLECTED;     // Catch: Throwable -> L27
        L19:
            r102 = r102.getNext();     // Catch: Throwable -> L27
            goto L9
        L20:
            r101 = r101 + 1;     // Catch: Throwable -> L27
            goto L7
        L21:
            int r106 = 0;
        L23:
            if (r106 >= r100.length()) goto L25;
            r100.set(r106, null);     // Catch: Throwable -> L27
            r106 = r106 + 1;     // Catch: Throwable -> L27
            goto L23
        L25:
            clearReferenceQueues();     // Catch: Throwable -> L27
            this.writeQueue.clear();     // Catch: Throwable -> L27
            this.accessQueue.clear();     // Catch: Throwable -> L27
            this.readCount.set(0);     // Catch: Throwable -> L27
            this.modCount++;     // Catch: Throwable -> L27
            this.count = 0;     // Catch: Throwable -> L27
            unlock();
            postWriteCleanup();
            return;
        L27:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public void clearKeyReferenceQueue() {
        L3:
            if (this.keyReferenceQueue.poll() != null) goto L3;
        }

        public void clearReferenceQueues() {
            Strength r100 = this.map.f251102g;
            Strength r101 = Strength.STRONG;
            boolean r102 = true;
            if (r100 == r101) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L9;
            clearKeyReferenceQueue();
        L9:
            if (this.map.f251103h != r101) goto L12;
            r102 = false;
        L12:
            if (r102 == false) goto L15;
            clearValueReferenceQueue();
            return;
        L15:
            return;
        L5:
            r103 = false;
            goto L6
        }

        public void clearValueReferenceQueue() {
        L3:
            if (this.valueReferenceQueue.poll() != null) goto L3;
        }

        public void drainRecencyQueue() {
        L2:
            ReferenceEntry<K, V> r100 = this.recencyQueue.poll();
            if (r100 == null) goto L7;
            if (this.accessQueue.contains(r100) == false) goto L2;
            this.accessQueue.add(r100);
            goto L2
        }

        public void drainReferenceQueues() {
            Strength r100 = this.map.f251102g;
            Strength r101 = Strength.STRONG;
            boolean r102 = true;
            if (r100 == r101) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L9;
            drainKeyReferenceQueue();
        L9:
            if (this.map.f251103h != r101) goto L12;
            r102 = false;
        L12:
            if (r102 == false) goto L15;
            drainValueReferenceQueue();
            return;
        L15:
            return;
        L5:
            r103 = false;
            goto L6
        }

        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> r100 = this.table;
            int r101 = r100.length();
            if (r101 < 1073741824) goto L5;
            return;
        L5:
            int r102 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> r103 = newEntryArray(r101 << 1);
            this.threshold = (r103.length() * 3) / 4;
            int r104 = r103.length() - 1;
            int r105 = 0;
        L6:
            if (r105 >= r101) goto L26;
            ReferenceEntry<K, V> r106 = r100.get(r105);
            if (r106 == null) goto L25;
            ReferenceEntry<K, V> r107 = r106.getNext();
            int r108 = r106.getHash() & r104;
            if (r107 != null) goto L12;
            r103.set(r108, r106);
            goto L25
        L12:
            ReferenceEntry<K, V> r109 = r106;
        L13:
            if (r107 == null) goto L18;
            int r110 = r107.getHash() & r104;
            if (r110 == r108) goto L17;
            r109 = r107;
            r108 = r110;
        L17:
            r107 = r107.getNext();
            goto L13
        L18:
            r103.set(r108, r109);
        L19:
            if (r106 == r109) goto L25;
            int r111 = r106.getHash() & r104;
            ReferenceEntry<K, V> r112 = copyEntry(r106, r103.get(r111));
            if (r112 == null) goto L23;
            r103.set(r111, r112);
        L24:
            r106 = r106.getNext();
            goto L19
        L23:
            removeCollectedEntry(r106);
            r102 = r102 - 1;
        L25:
            r105 = r105 + 1;
            goto L6
        L26:
            this.table = r103;
            this.count = r102;
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            Iterator<ReferenceEntry<K, V>> r100 = this.accessQueue.iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            ReferenceEntry<K, V> r101 = r100.next();
            if (r101.getValueReference().getWeight() <= 0) goto L4;
            return r101;
        L9:
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            cleanUp();
            return;
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread() == true) goto L11;
            LocalCache<K, V> r100 = this.map;
        L5:
            RemovalNotification<K, V> r101 = r100.f251109n.poll();
            if (r101 == null) goto L18;
            r100.f251110o.onRemoval(r101);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            LocalCache.f251093u.log(Level.WARNING, "Exception thrown by removal listener", th);
            goto L5
        L18:
            return;
        }

        public void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        public boolean containsValue(Object r110) {
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L18;
            long r100 = this.map.f251111p.a();     // Catch: Throwable -> L20
            AtomicReferenceArray<ReferenceEntry<K, V>> r101 = this.table;     // Catch: Throwable -> L20
            int r102 = r101.length();     // Catch: Throwable -> L20
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L18;
            ReferenceEntry<K, V> r104 = r101.get(r103);     // Catch: Throwable -> L20
        L7:
            if (r104 == null) goto L17;
            V r105 = getLiveValue(r104, r100);     // Catch: Throwable -> L20
            if (r105 != null) goto L12;
        L15:
            r104 = r104.getNext();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.f251101f.equivalent(r110, r105) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r103 = r103 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        public void evictEntries(ReferenceEntry<K, V> r100) {
            if (this.map.b() == true) goto L5;
            return;
        L5:
            drainRecencyQueue();
            if (r100.getValueReference().getWeight() <= this.maxSegmentWeight) goto L13;
            if (removeEntry(r100, r100.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        L13:
            if (this.totalWeight <= this.maxSegmentWeight) goto L19;
            ReferenceEntry<K, V> r101 = getNextEvictable();
            if (removeEntry(r101, r101.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        }

        public void expireEntries(long r100) {
            drainRecencyQueue();
        L3:
            ReferenceEntry<K, V> r101 = this.writeQueue.peek();
            if (r101 == null) goto L12;
            if (this.map.f(r101, r100) == false) goto L12;
            if (removeEntry(r101, r101.getHash(), RemovalCause.EXPIRED) == true) goto L3;
            throw new AssertionError();
        L12:
            ReferenceEntry<K, V> r102 = this.accessQueue.peek();
            if (r102 == null) goto L21;
            if (this.map.f(r102, r100) == false) goto L31;
            if (removeEntry(r102, r102.getHash(), RemovalCause.EXPIRED) == true) goto L12;
            throw new AssertionError();
        L31:
            return;
        }

        public ReferenceEntry<K, V> getFirst(int r100) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r101 = this.table;
            return r101.get(r100 & (r101.length() - 1));
        }

        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> r100) {
            int r101 = (r100.length() * 3) / 4;
            this.threshold = r101;
            if (this.map.f251105j == CacheBuilder.OneWeigher.INSTANCE) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
        L10:
            this.table = r100;
            return;
        L8:
            if (r101 != this.maxSegmentWeight) goto L10;
            this.threshold = r101 + 1;
            goto L10
        L5:
            r102 = false;
            goto L6
        }

        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int r100) {
            return new AtomicReferenceArray(r100);
        }

        public void preWriteCleanup(long r100) {
            runLockedCleanup(r100);
        }

        public void removeCollectedEntry(ReferenceEntry<K, V> r100) {
            enqueueNotification(r100.getKey(), r100.getHash(), r100.getValueReference().get(), r100.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(r100);
            this.accessQueue.remove(r100);
        }

        public void runLockedCleanup(long r100) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            expireEntries(r100);     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public void tryExpireEntries(long r100) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            expireEntries(r100);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean containsKey(Object r100, int r101) {
            boolean r102 = false;
            if (this.count == 0) goto L13;
            ReferenceEntry<K, V> r103 = getLiveEntry(r100, r101, this.map.f251111p.a());     // Catch: Throwable -> L15
            if (r103 != null) goto L8;
            postReadCleanup();
            return false;
        L8:
            if (r103.getValueReference().get() == null) goto L11;
            r102 = true;
        L11:
            postReadCleanup();
            return r102;
        L13:
            postReadCleanup();
            return false;
        L15:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> r100, ReferenceEntry<K, V> r101) {
            if (r100.getKey() != null) goto L5;
            return null;
        L5:
            ValueReference<K, V> r102 = r100.getValueReference();
            V r103 = r102.get();
            if (r103 == null) goto L8;
        L10:
            ReferenceEntry<K, V> r104 = this.map.f251112q.copyEntry(this, r100, r101);
            r104.setValueReference(r102.b(this.valueReferenceQueue, r103, r104));
            return r104;
        L8:
            if (r102.isActive() == false) goto L10;
            return null;
        }

        @NullableDecl
        public V get(Object r100, int r101) {
        L16:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L14;
            long r102 = this.map.f251111p.a();     // Catch: Throwable -> L16
            ReferenceEntry<K, V> r103 = getLiveEntry(r100, r101, r102);     // Catch: Throwable -> L16
            if (r103 != null) goto L8;
            postReadCleanup();
            return null;
        L8:
            V r104 = r103.getValueReference().get();     // Catch: Throwable -> L16
            if (r104 == null) goto L13;
            recordRead(r103, r102);     // Catch: Throwable -> L16
            postReadCleanup();
            return r104;
        L13:
            tryDrainReferenceQueues();     // Catch: Throwable -> L16
        L14:
            postReadCleanup();
            return null;
        }

        @NullableDecl
        public ReferenceEntry<K, V> getEntry(Object r100, int r101) {
            ReferenceEntry<K, V> r102 = getFirst(r101);
        L3:
            if (r102 == null) goto L14;
            if (r102.getHash() != r101) goto L13;
            K r103 = r102.getKey();
            if (r103 != null) goto L11;
            tryDrainReferenceQueues();
            goto L13
        L11:
            if (this.map.f251100e.equivalent(r100, r103) == false) goto L13;
            return r102;
        L13:
            r102 = r102.getNext();
            goto L3
        L14:
            return null;
        }

        public V getLiveValue(ReferenceEntry<K, V> r100, long r101) {
            if (r100.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r102 = r100.getValueReference().get();
            if (r102 != null) goto L11;
            tryDrainReferenceQueues();
            return null;
        L11:
            if (this.map.f(r100, r101) == false) goto L14;
            tryExpireEntries(r101);
            return null;
        L14:
            return r102;
        }

        public boolean reclaimKey(ReferenceEntry<K, V> r110, int r111) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r100 = this.table;     // Catch: Throwable -> L13
            int r101 = (r100.length() - 1) & r111;     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r103 = r102;
        L4:
            if (r103 == null) goto L11;
            if (r103 == r110) goto L6;
            r103 = r103.getNext();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r112 = removeValueFromChain(r102, r103, r103.getKey(), r111, r103.getValueReference().get(), r103.getValueReference(), RemovalCause.COLLECTED);     // Catch: Throwable -> L13
            int r113 = this.count - 1;     // Catch: Throwable -> L13
            r100.set(r101, r112);     // Catch: Throwable -> L13
            this.count = r113;     // Catch: Throwable -> L13
            unlock();
            postWriteCleanup();
            return true;
        L11:
            unlock();
            postWriteCleanup();
            return false;
        L13:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public void recordLockedRead(ReferenceEntry<K, V> r100, long r101) {
            if (this.map.c() == false) goto L5;
            r100.setAccessTime(r101);
        L5:
            this.accessQueue.add(r100);
        }

        public void recordRead(ReferenceEntry<K, V> r100, long r101) {
            if (this.map.c() == false) goto L5;
            r100.setAccessTime(r101);
        L5:
            this.recencyQueue.add(r100);
        }

        @NullableDecl
        public V remove(Object r110, int r111) {
            lock();
            preWriteCleanup(this.map.f251111p.a());     // Catch: Throwable -> L25
            AtomicReferenceArray<ReferenceEntry<K, V>> r100 = this.table;     // Catch: Throwable -> L25
            int r101 = (r100.length() - 1) & r111;     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r103 = r102;
        L5:
            if (r103 == null) goto L21;
            K r104 = r103.getKey();     // Catch: Throwable -> L25
            if (r103.getHash() != r111) goto L23;
            if (r104 == null) goto L23;
            if (this.map.f251100e.equivalent(r110, r104) == false) goto L23;
            ValueReference<K, V> r105 = r103.getValueReference();     // Catch: Throwable -> L25
            V r112 = r105.get();     // Catch: Throwable -> L25
            if (r112 == null) goto L16;
            RemovalCause r106 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L25
        L14:
            RemovalCause r113 = r106;
            this.modCount++;     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r114 = removeValueFromChain(r102, r103, r104, r111, r112, r105, r113);     // Catch: Throwable -> L25
            int r107 = this.count - 1;     // Catch: Throwable -> L25
            r100.set(r101, r114);     // Catch: Throwable -> L25
            this.count = r107;     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r112;
        L16:
            if (r105.isActive() == false) goto L21;
            r106 = RemovalCause.COLLECTED;     // Catch: Throwable -> L25
        L23:
            r103 = r103.getNext();     // Catch: Throwable -> L25
        L21:
            unlock();
            postWriteCleanup();
            return null;
        L25:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        @NullableDecl
        public ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> r100, ReferenceEntry<K, V> r101) {
            int r102 = this.count;
            ReferenceEntry<K, V> r103 = r101.getNext();
        L3:
            if (r100 == r101) goto L9;
            ReferenceEntry<K, V> r104 = copyEntry(r100, r103);
            if (r104 == null) goto L7;
            r103 = r104;
        L8:
            r100 = r100.getNext();
            goto L3
        L7:
            removeCollectedEntry(r100);
            r102 = r102 - 1;
            goto L8
        L9:
            this.count = r102;
            return r103;
        }

        public Segment(LocalCache<K, V> r100, int r101, long r102) {
            this.readCount = new AtomicInteger();
            this.map = r100;
            this.maxSegmentWeight = r102;
            initTable(newEntryArray(r101));
            Strength r103 = r100.f251102g;
            Strength r104 = Strength.STRONG;
            boolean r105 = true;
            if (r103 == r104) goto L5;
            boolean r106 = true;
        L6:
            ReferenceQueue<V> r107 = null;
            if (r106 == false) goto L9;
            ReferenceQueue<K> r108 = new ReferenceQueue();
        L10:
            this.keyReferenceQueue = r108;
            if (r100.f251103h != r104) goto L14;
            r105 = false;
        L14:
            if (r105 == false) goto L16;
            r107 = new ReferenceQueue();
        L16:
            this.valueReferenceQueue = r107;
            if (r100.i() == false) goto L19;
            ConcurrentLinkedQueue r109 = new ConcurrentLinkedQueue();
        L20:
            this.recencyQueue = r109;
            if (r100.d() == false) goto L23;
            WriteQueue r110 = new WriteQueue();
        L24:
            this.writeQueue = r110;
            if (r100.i() == false) goto L27;
            AccessQueue r111 = new AccessQueue();
        L28:
            this.accessQueue = r111;
            return;
        L27:
            r111 = (Queue<ReferenceEntry<K, V>>) LocalCache.f251095w;
            goto L28
        L23:
            r110 = (Queue<ReferenceEntry<K, V>>) LocalCache.f251095w;
            goto L24
        L19:
            r109 = (Queue<ReferenceEntry<K, V>>) LocalCache.f251095w;
            goto L20
        L9:
            r108 = null;
            goto L10
        L5:
            r106 = false;
            goto L6
        }

        @NullableDecl
        public ReferenceEntry<K, V> getLiveEntry(Object r100, int r101, long r102) {
            ReferenceEntry<K, V> r103 = getEntry(r100, r101);
            if (r103 != null) goto L6;
            return null;
        L6:
            if (this.map.f(r103, r102) == false) goto L9;
            tryExpireEntries(r102);
            return null;
        L9:
            return r103;
        }

        public ReferenceEntry<K, V> newEntry(K r100, int r101, @NullableDecl ReferenceEntry<K, V> r102) {
            EntryFactory r103 = this.map.f251112q;
            r100.getClass();
            return r103.newEntry(this, r100, r101, r102);
        }

        public boolean reclaimValue(K r110, int r111, ValueReference<K, V> r112) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r100 = this.table;     // Catch: Throwable -> L28
            int r101 = (r100.length() - 1) & r111;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r103 = r102;
        L5:
            if (r103 == null) goto L24;
            K r104 = r103.getKey();     // Catch: Throwable -> L28
            if (r103.getHash() != r111) goto L22;
            if (r104 == null) goto L22;
            if (this.map.f251100e.equivalent(r110, r104) == false) goto L22;
            if (r103.getValueReference() != r112) goto L18;
            this.modCount++;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r113 = removeValueFromChain(r102, r103, r104, r111, r112.get(), r112, RemovalCause.COLLECTED);     // Catch: Throwable -> L28
            int r114 = this.count - 1;     // Catch: Throwable -> L28
            r100.set(r101, r113);     // Catch: Throwable -> L28
            this.count = r114;     // Catch: Throwable -> L28
            unlock();
            if (isHeldByCurrentThread() == true) goto L17;
            postWriteCleanup();
        L17:
            return true;
        L18:
            unlock();
            if (isHeldByCurrentThread() == true) goto L21;
            postWriteCleanup();
        L21:
            return false;
        L22:
            r103 = r103.getNext();     // Catch: Throwable -> L28
            goto L5
        L24:
            unlock();
            if (isHeldByCurrentThread() == true) goto L27;
            postWriteCleanup();
        L27:
            return false;
        L28:
            th = move-exception;
            unlock();
            if (isHeldByCurrentThread() == true) goto L32;
            postWriteCleanup();
        L32:
            throw th;
        }

        public void recordWrite(ReferenceEntry<K, V> r100, int r101, long r102) {
            drainRecencyQueue();
            this.totalWeight += (long) r101;
            if (this.map.c() == false) goto L6;
            r100.setAccessTime(r102);
        L6:
            if (this.map.g() == false) goto L8;
            r100.setWriteTime(r102);
        L8:
            this.accessQueue.add(r100);
            this.writeQueue.add(r100);
        }

        public boolean remove(Object r110, int r111, Object r112) {
            lock();
            preWriteCleanup(this.map.f251111p.a());     // Catch: Throwable -> L28
            AtomicReferenceArray<ReferenceEntry<K, V>> r100 = this.table;     // Catch: Throwable -> L28
            boolean r101 = true;
            int r102 = (r100.length() - 1) & r111;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r103 = r100.get(r102);     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r104 = r103;
        L5:
            if (r104 == null) goto L24;
            K r105 = r104.getKey();     // Catch: Throwable -> L28
            if (r104.getHash() != r111) goto L26;
            if (r105 == null) goto L26;
            if (this.map.f251100e.equivalent(r110, r105) == false) goto L26;
            ValueReference<K, V> r113 = r104.getValueReference();     // Catch: Throwable -> L28
            V r106 = r113.get();     // Catch: Throwable -> L28
            if (this.map.f251101f.equivalent(r112, r106) == false) goto L14;
            RemovalCause r114 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L28
        L18:
            this.modCount++;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r115 = removeValueFromChain(r103, r104, r105, r111, r106, r113, r114);     // Catch: Throwable -> L28
            int r116 = this.count - 1;     // Catch: Throwable -> L28
            r100.set(r102, r115);     // Catch: Throwable -> L28
            this.count = r116;     // Catch: Throwable -> L28
            if (r114 == RemovalCause.EXPLICIT) goto L22;
            r101 = false;
        L22:
            unlock();
            postWriteCleanup();
            return r101;
        L14:
            if (r106 != null) goto L24;
            if (r113.isActive() == false) goto L24;
            r114 = RemovalCause.COLLECTED;     // Catch: Throwable -> L28
        L26:
            r104 = r104.getNext();     // Catch: Throwable -> L28
        L24:
            unlock();
            postWriteCleanup();
            return false;
        L28:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public boolean removeEntry(ReferenceEntry<K, V> r110, int r111, RemovalCause r112) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r100 = this.table;
            int r101 = (r100.length() - 1) & r111;
            ReferenceEntry<K, V> r102 = r100.get(r101);
            ReferenceEntry<K, V> r103 = r102;
        L3:
            if (r103 == null) goto L8;
            if (r103 == r110) goto L5;
            r103 = r103.getNext();
            goto L3
        L5:
            this.modCount++;
            ReferenceEntry<K, V> r113 = removeValueFromChain(r102, r103, r103.getKey(), r111, r103.getValueReference().get(), r103.getValueReference(), r112);
            int r114 = this.count - 1;
            r100.set(r101, r113);
            this.count = r114;
            return true;
        L8:
            return false;
        }

        @NullableDecl
        public V replace(K r110, int r111, V r210) {
            lock();
            long r100 = this.map.f251111p.a();     // Catch: Throwable -> L24
            preWriteCleanup(r100);     // Catch: Throwable -> L24
            AtomicReferenceArray<ReferenceEntry<K, V>> r112 = this.table;     // Catch: Throwable -> L24
            int r113 = r111 & (r112.length() - 1);     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r101 = r112.get(r113);     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r114 = r101;
        L5:
            if (r114 == null) goto L16;
            K r102 = r114.getKey();     // Catch: Throwable -> L24
            if (r114.getHash() != r111) goto L22;
            if (r102 == null) goto L22;
            if (this.map.f251100e.equivalent(r110, r102) == false) goto L22;
            ValueReference<K, V> r115 = r114.getValueReference();     // Catch: Throwable -> L24
            V r116 = r115.get();     // Catch: Throwable -> L24
            if (r116 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L24
            enqueueNotification(r110, r111, r116, r115.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L24
            setValue(r114, r110, r210, r100);     // Catch: Throwable -> L24
            evictEntries(r114);     // Catch: Throwable -> L24
            unlock();
            postWriteCleanup();
            return r116;
        L14:
            if (r115.isActive() == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r103 = removeValueFromChain(r101, r114, r102, r111, r116, r115, RemovalCause.COLLECTED);     // Catch: Throwable -> L24
            int r104 = this.count - 1;     // Catch: Throwable -> L24
            r112.set(r113, r103);     // Catch: Throwable -> L24
            this.count = r104;     // Catch: Throwable -> L24
        L22:
            r114 = r114.getNext();     // Catch: Throwable -> L24
        L16:
            unlock();
            postWriteCleanup();
            return null;
        L24:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        @NullableDecl
        public V put(K r110, int r111, V r112, boolean r113) {
            lock();
            long r100 = this.map.f251111p.a();     // Catch: Throwable -> L31
            preWriteCleanup(r100);     // Catch: Throwable -> L31
            if ((this.count + 1) <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L31
        L6:
            AtomicReferenceArray<ReferenceEntry<K, V>> r114 = this.table;     // Catch: Throwable -> L31
            int r115 = r111 & (r114.length() - 1);     // Catch: Throwable -> L31
            ReferenceEntry<K, V> r101 = r114.get(r115);     // Catch: Throwable -> L31
            ReferenceEntry<K, V> r116 = r101;
        L8:
            if (r116 == null) goto L29;
            K r102 = r116.getKey();     // Catch: Throwable -> L31
            if (r116.getHash() != r111) goto L28;
            if (r102 == null) goto L28;
            if (this.map.f251100e.equivalent(r110, r102) == false) goto L28;
            ValueReference<K, V> r103 = r116.getValueReference();     // Catch: Throwable -> L31
            V r117 = r103.get();     // Catch: Throwable -> L31
            if (r117 != null) goto L23;
            this.modCount++;     // Catch: Throwable -> L31
            if (r103.isActive() == false) goto L19;
            enqueueNotification(r110, r111, r117, r103.getWeight(), RemovalCause.COLLECTED);     // Catch: Throwable -> L31
            setValue(r116, r110, r112, r100);     // Catch: Throwable -> L31
            int r104 = this.count;     // Catch: Throwable -> L31
        L20:
            this.count = r104;     // Catch: Throwable -> L31
            evictEntries(r116);     // Catch: Throwable -> L31
        L21:
            unlock();
            postWriteCleanup();
            return null;
        L19:
            setValue(r116, r110, r112, r100);     // Catch: Throwable -> L31
            r104 = this.count + 1;     // Catch: Throwable -> L31
            goto L20
        L23:
            if (r113 == false) goto L27;
            recordLockedRead(r116, r100);     // Catch: Throwable -> L31
        L25:
            unlock();
            postWriteCleanup();
            return r117;
        L27:
            this.modCount++;     // Catch: Throwable -> L31
            enqueueNotification(r110, r111, r117, r103.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L31
            setValue(r116, r110, r112, r100);     // Catch: Throwable -> L31
            evictEntries(r116);     // Catch: Throwable -> L31
        L28:
            r116 = r116.getNext();     // Catch: Throwable -> L31
            goto L8
        L29:
            this.modCount++;     // Catch: Throwable -> L31
            ReferenceEntry<K, V> r118 = newEntry(r110, r111, r101);     // Catch: Throwable -> L31
            setValue(r118, r110, r112, r100);     // Catch: Throwable -> L31
            r114.set(r115, r118);     // Catch: Throwable -> L31
            this.count++;     // Catch: Throwable -> L31
            evictEntries(r118);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public boolean replace(K r110, int r111, V r210, V r211) {
            lock();
            long r100 = this.map.f251111p.a();     // Catch: Throwable -> L27
            preWriteCleanup(r100);     // Catch: Throwable -> L27
            AtomicReferenceArray<ReferenceEntry<K, V>> r112 = this.table;     // Catch: Throwable -> L27
            int r113 = r111 & (r112.length() - 1);     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r101 = r112.get(r113);     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r114 = r101;
        L5:
            if (r114 == null) goto L16;
            K r102 = r114.getKey();     // Catch: Throwable -> L27
            if (r114.getHash() != r111) goto L25;
            if (r102 == null) goto L25;
            if (this.map.f251100e.equivalent(r110, r102) == false) goto L25;
            ValueReference<K, V> r115 = r114.getValueReference();     // Catch: Throwable -> L27
            V r103 = r115.get();     // Catch: Throwable -> L27
            if (r103 != null) goto L19;
            if (r115.isActive() == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r104 = removeValueFromChain(r101, r114, r102, r111, r103, r115, RemovalCause.COLLECTED);     // Catch: Throwable -> L27
            int r105 = this.count - 1;     // Catch: Throwable -> L27
            r112.set(r113, r104);     // Catch: Throwable -> L27
            this.count = r105;     // Catch: Throwable -> L27
            goto L16
        L19:
            if (this.map.f251101f.equivalent(r210, r103) == false) goto L23;
            this.modCount++;     // Catch: Throwable -> L27
            enqueueNotification(r110, r111, r103, r115.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L27
            setValue(r114, r110, r211, r100);     // Catch: Throwable -> L27
            evictEntries(r114);     // Catch: Throwable -> L27
            unlock();
            postWriteCleanup();
            return true;
        L23:
            recordLockedRead(r114, r100);     // Catch: Throwable -> L27
        L25:
            r114 = r114.getNext();     // Catch: Throwable -> L27
        L16:
            unlock();
            postWriteCleanup();
            return false;
        L27:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public void setValue(ReferenceEntry<K, V> r100, K r101, V r102, long r103) {
            ValueReference<K, V> r104 = r100.getValueReference();
            int r105 = this.map.f251105j.weigh(r101, r102);
            if (r105 < 0) goto L5;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L10;
            r100.setValueReference(this.map.f251103h.referenceValue(this, r100, r102, r105));
            recordWrite(r100, r105, r103);
            r104.a();
            return;
        L10:
            throw new IllegalStateException("Weights must be non-negative");
        L5:
            r106 = false;
            goto L6
        }

        public void enqueueNotification(@NullableDecl K r100, int r101, @NullableDecl V r102, int r103, RemovalCause r104) {
            this.totalWeight -= (long) r103;
            if (this.map.f251109n == LocalCache.f251095w) goto L6;
            this.map.f251109n.offer(RemovalNotification.create(r100, r102, r104));
            return;
        }

        @NullableDecl
        public ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> r100, ReferenceEntry<K, V> r101, @NullableDecl K r102, int r110, V r111, ValueReference<K, V> r112, RemovalCause r113) {
            enqueueNotification(r102, r110, r111, r112.getWeight(), r113);
            this.writeQueue.remove(r101);
            this.accessQueue.remove(r101);
            r112.isLoading();
            return removeEntryFromChain(r100, r101);
        }
    }

    public static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceEntry<K, V> f251133a;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final void a() {
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final boolean isActive() {
            return true;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final void isLoading() {
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final ReferenceEntry<K, V> getEntry() {
            return this.f251133a;
        }

        public SoftValueReference(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102) {
            super(r101, r100);
            this.f251133a = r102;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102) {
            return new SoftValueReference(r100, r101, r102);
        }
    }

    public static abstract enum Strength extends Enum<Strength> {
        public static final Strength SOFT = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Strength[] f251134a = null;

        public Strength() {
            throw null;
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> r100, ReferenceEntry<K, V> r101, V r102, int r103);

        static {
            final String r100 = "STRONG";
            final int r101 = 0;
            Strength r102 = new AnonymousClass1(r100, r101);
            STRONG = r102;
            final String r103 = "SOFT";
            final int r104 = 1;
            Strength r105 = new AnonymousClass2(r103, r104);
            SOFT = r105;
            final String r106 = "WEAK";
            final int r107 = 2;
            Strength r108 = new AnonymousClass3(r106, r107);
            WEAK = r108;
            f251134a = new Strength[]{r102, r105, r108};
        }

        public static Strength[] values() {
            return (Strength[]) f251134a.clone();
        }

        public static Strength valueOf(String r100) {
            return (Strength) a.a(Strength.class, r100);
        }

        public Strength(String r100, int r101, AnonymousClass1 r102) {
            super(r100, r101);
        }
    }

    public static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f251135e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReferenceEntry<K, V> f251136f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ReferenceEntry<K, V> f251137g;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getAccessTime() {
            return this.f251135e;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f251136f;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f251137g;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setAccessTime(long r100) {
            this.f251135e = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251136f = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251137g = r100;
        }

        public StrongAccessEntry(K r100, int r101, @NullableDecl ReferenceEntry<K, V> r102) {
            super(r100, r101, r102);
            this.f251135e = Long.MAX_VALUE;
            NullEntry r103 = NullEntry.INSTANCE;
            this.f251136f = r103;
            this.f251137g = r103;
        }
    }

    public static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f251138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReferenceEntry<K, V> f251139f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ReferenceEntry<K, V> f251140g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile long f251141h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ReferenceEntry<K, V> f251142i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ReferenceEntry<K, V> f251143j;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getAccessTime() {
            return this.f251138e;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f251139f;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f251142i;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f251140g;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f251143j;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getWriteTime() {
            return this.f251141h;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setAccessTime(long r100) {
            this.f251138e = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251139f = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251142i = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251140g = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251143j = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setWriteTime(long r100) {
            this.f251141h = r100;
        }

        public StrongAccessWriteEntry(K r100, int r101, @NullableDecl ReferenceEntry<K, V> r102) {
            super(r100, r101, r102);
            this.f251138e = Long.MAX_VALUE;
            NullEntry r103 = NullEntry.INSTANCE;
            this.f251139f = r103;
            this.f251140g = r103;
            this.f251141h = Long.MAX_VALUE;
            this.f251142i = r103;
            this.f251143j = r103;
        }
    }

    public static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f251144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f251145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NullableDecl
        public final ReferenceEntry<K, V> f251146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile ValueReference<K, V> f251147d;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final int getHash() {
            return this.f251145b;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final K getKey() {
            return this.f251144a;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNext() {
            return this.f251146c;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ValueReference<K, V> getValueReference() {
            return this.f251147d;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setValueReference(ValueReference<K, V> r100) {
            this.f251147d = r100;
        }

        public StrongEntry(K r100, int r101, @NullableDecl ReferenceEntry<K, V> r102) {
            this.f251147d = LocalCache.f251094v;
            this.f251144a = r100;
            this.f251145b = r101;
            this.f251146c = r102;
        }
    }

    public static class StrongValueReference<K, V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f251148a;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final void a() {
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final ValueReference<K, V> b(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102) {
            return this;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final boolean isActive() {
            return true;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final void isLoading() {
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final V get() {
            return this.f251148a;
        }

        public StrongValueReference(V r100) {
            this.f251148a = r100;
        }
    }

    public static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f251149e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReferenceEntry<K, V> f251150f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ReferenceEntry<K, V> f251151g;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f251150f;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f251151g;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getWriteTime() {
            return this.f251149e;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251150f = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251151g = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setWriteTime(long r100) {
            this.f251149e = r100;
        }

        public StrongWriteEntry(K r100, int r101, @NullableDecl ReferenceEntry<K, V> r102) {
            super(r100, r101, r102);
            this.f251149e = Long.MAX_VALUE;
            NullEntry r103 = NullEntry.INSTANCE;
            this.f251150f = r103;
            this.f251151g = r103;
        }
    }

    public final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        @Override // java.util.Iterator
        public final V next() {
            return c().f251178b;
        }

        public ValueIterator(LocalCache r100) {
            super(r100);
        }
    }

    public interface ValueReference<K, V> {
        void a();

        ValueReference<K, V> b(ReferenceQueue<V> r100, @NullableDecl V r101, ReferenceEntry<K, V> r102);

        @NullableDecl
        V get();

        @NullableDecl
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        void isLoading();
    }

    public final class Values extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentMap<?, ?> f251152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalCache f251153b;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f251152a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return this.f251152a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new ValueIterator(this.f251153b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f251152a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object r100) {
            return this.f251152a.containsValue(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final <E> E[] toArray(E[] r100) {
            return (E[]) LocalCache.a(this).toArray(r100);
        }

        public Values(LocalCache r100, ConcurrentMap<?, ?> r101) {
            this.f251153b = r100;
            this.f251152a = r101;
        }
    }

    public static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f251154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ReferenceEntry<K, V> f251155e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReferenceEntry<K, V> f251156f;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getAccessTime() {
            return this.f251154d;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f251155e;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f251156f;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setAccessTime(long r100) {
            this.f251154d = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251155e = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251156f = r100;
        }

        public WeakAccessEntry(ReferenceQueue<K> r100, K r101, int r102, @NullableDecl ReferenceEntry<K, V> r103) {
            super(r100, r101, r102, r103);
            this.f251154d = Long.MAX_VALUE;
            NullEntry r104 = NullEntry.INSTANCE;
            this.f251155e = r104;
            this.f251156f = r104;
        }
    }

    public static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f251157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ReferenceEntry<K, V> f251158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReferenceEntry<K, V> f251159f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile long f251160g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ReferenceEntry<K, V> f251161h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ReferenceEntry<K, V> f251162i;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getAccessTime() {
            return this.f251157d;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f251158e;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f251161h;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f251159f;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f251162i;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getWriteTime() {
            return this.f251160g;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setAccessTime(long r100) {
            this.f251157d = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251158e = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251161h = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> r100) {
            this.f251159f = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251162i = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setWriteTime(long r100) {
            this.f251160g = r100;
        }

        public WeakAccessWriteEntry(ReferenceQueue<K> r100, K r101, int r102, @NullableDecl ReferenceEntry<K, V> r103) {
            super(r100, r101, r102, r103);
            this.f251157d = Long.MAX_VALUE;
            NullEntry r104 = NullEntry.INSTANCE;
            this.f251158e = r104;
            this.f251159f = r104;
            this.f251160g = Long.MAX_VALUE;
            this.f251161h = r104;
            this.f251162i = r104;
        }
    }

    public static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f251163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NullableDecl
        public final ReferenceEntry<K, V> f251164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile ValueReference<K, V> f251165c;

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final K getKey() {
            return get();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final int getHash() {
            return this.f251163a;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNext() {
            return this.f251164b;
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ValueReference<K, V> getValueReference() {
            return this.f251165c;
        }

        public void setAccessTime(long r100) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setValueReference(ValueReference<K, V> r100) {
            this.f251165c = r100;
        }

        public void setWriteTime(long r100) {
            throw new UnsupportedOperationException();
        }

        public WeakEntry(ReferenceQueue<K> r100, K r101, int r102, @NullableDecl ReferenceEntry<K, V> r103) {
            super(r101, r100);
            this.f251165c = LocalCache.f251094v;
            this.f251163a = r102;
            this.f251164b = r103;
        }
    }

    public static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceEntry<K, V> f251166a;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final void a() {
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final boolean isActive() {
            return true;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final void isLoading() {
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final ReferenceEntry<K, V> getEntry() {
            return this.f251166a;
        }

        public WeakValueReference(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102) {
            super(r101, r100);
            this.f251166a = r102;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102) {
            return new WeakValueReference(r100, r101, r102);
        }
    }

    public static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f251167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ReferenceEntry<K, V> f251168e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReferenceEntry<K, V> f251169f;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f251168e;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f251169f;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final long getWriteTime() {
            return this.f251167d;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setNextInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251168e = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> r100) {
            this.f251169f = r100;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
        public final void setWriteTime(long r100) {
            this.f251167d = r100;
        }

        public WeakWriteEntry(ReferenceQueue<K> r100, K r101, int r102, @NullableDecl ReferenceEntry<K, V> r103) {
            super(r100, r101, r102, r103);
            this.f251167d = Long.MAX_VALUE;
            NullEntry r104 = NullEntry.INSTANCE;
            this.f251168e = r104;
            this.f251169f = r104;
        }
    }

    public static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f251170b;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.SoftValueReference, com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final int getWeight() {
            return this.f251170b;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.SoftValueReference, com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final ValueReference<K, V> b(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102) {
            return new WeightedSoftValueReference(r100, r101, r102, this.f251170b);
        }

        public WeightedSoftValueReference(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102, int r103) {
            super(r100, r101, r102);
            this.f251170b = r103;
        }
    }

    public static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f251171b;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.StrongValueReference, com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final int getWeight() {
            return this.f251171b;
        }

        public WeightedStrongValueReference(V r100, int r101) {
            super(r100);
            this.f251171b = r101;
        }
    }

    public static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f251172b;

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakValueReference, com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final int getWeight() {
            return this.f251172b;
        }

        @Override // com.bytedance.jedi.model.guava.cache.LocalCache.WeakValueReference, com.bytedance.jedi.model.guava.cache.LocalCache.ValueReference
        public final ValueReference<K, V> b(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102) {
            return new WeightedWeakValueReference(r100, r101, r102, this.f251172b);
        }

        public WeightedWeakValueReference(ReferenceQueue<V> r100, V r101, ReferenceEntry<K, V> r102, int r103) {
            super(r100, r101, r102);
            this.f251172b = r103;
        }
    }

    public static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnonymousClass1 f251173a;

        /* JADX INFO: renamed from: com.bytedance.jedi.model.guava.cache.LocalCache$WriteQueue$1, reason: invalid class name */
        public class AnonymousClass1 extends AbstractReferenceEntry<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ReferenceEntry<K, V> f251174a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public ReferenceEntry<K, V> f251175b;

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final void setWriteTime(long r100) {
            }

            public AnonymousClass1() {
                this.f251174a = this;
                this.f251175b = this;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.f251174a;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.f251175b;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final void setNextInWriteQueue(ReferenceEntry<K, V> r100) {
                this.f251174a = r100;
            }

            @Override // com.bytedance.jedi.model.guava.cache.LocalCache.AbstractReferenceEntry, com.bytedance.jedi.model.guava.cache.ReferenceEntry
            public final void setPreviousInWriteQueue(ReferenceEntry<K, V> r100) {
                this.f251175b = r100;
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            ReferenceEntry<K, V> r100 = this.f251173a.f251174a;
        L3:
            AnonymousClass1 r101 = this.f251173a;
            if (r100 == r101) goto L6;
            ReferenceEntry<K, V> r102 = r100.getNextInWriteQueue();
            Logger r103 = LocalCache.f251093u;
            NullEntry r104 = NullEntry.INSTANCE;
            r100.setNextInWriteQueue(r104);
            r100.setPreviousInWriteQueue(r104);
            r100 = r102;
            goto L3
        L6:
            r101.f251174a = r101;
            r101.f251175b = r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            AnonymousClass1 r100 = this.f251173a;
            if (r100.f251174a != r100) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<ReferenceEntry<K, V>> iterator() {
            AnonymousClass1 r100 = this.f251173a;
            final ReferenceEntry<K, V> r101 = r100.f251174a;
            if (r101 != r100) goto L6;
            r101 = null;
        L6:
            return new AnonymousClass2(this, r101);
        }

        @Override // java.util.Queue
        public final Object peek() {
            AnonymousClass1 r100 = this.f251173a;
            ReferenceEntry<K, V> r101 = r100.f251174a;
            if (r101 != r100) goto L6;
            return null;
        L6:
            return r101;
        }

        @Override // java.util.Queue
        public final Object poll() {
            AnonymousClass1 r100 = this.f251173a;
            ReferenceEntry<K, V> r101 = r100.f251174a;
            if (r101 != r100) goto L5;
            return null;
        L5:
            remove(r101);
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            ReferenceEntry<K, V> r100 = this.f251173a.f251174a;
            int r101 = 0;
        L4:
            if (r100 == this.f251173a) goto L6;
            r101 = r101 + 1;
            r100 = r100.getNextInWriteQueue();
            goto L4
        L6:
            return r101;
        }

        public WriteQueue() {
            this.f251173a = new AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object r100) {
            if (((ReferenceEntry) r100).getNextInWriteQueue() == NullEntry.INSTANCE) goto L5;
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
        @Override // java.util.Queue
        public final boolean offer(Object r100) {
            ReferenceEntry<K, V> r101 = (ReferenceEntry) r100;
            ReferenceEntry<K, V> r102 = r101.getPreviousInWriteQueue();
            ReferenceEntry<K, V> r103 = r101.getNextInWriteQueue();
            Logger r104 = LocalCache.f251093u;
            r102.setNextInWriteQueue(r103);
            r103.setPreviousInWriteQueue(r102);
            ReferenceEntry<K, V> r105 = this.f251173a.f251175b;
            r105.setNextInWriteQueue(r101);
            r101.setPreviousInWriteQueue(r105);
            AnonymousClass1 r106 = this.f251173a;
            r101.setNextInWriteQueue(r106);
            r106.f251175b = r101;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object r100) {
            ReferenceEntry r101 = (ReferenceEntry) r100;
            ReferenceEntry<K, V> r102 = r101.getPreviousInWriteQueue();
            ReferenceEntry<K, V> r103 = r101.getNextInWriteQueue();
            Logger r104 = LocalCache.f251093u;
            r102.setNextInWriteQueue(r103);
            r103.setPreviousInWriteQueue(r102);
            NullEntry r105 = NullEntry.INSTANCE;
            r101.setNextInWriteQueue(r105);
            r101.setPreviousInWriteQueue(r105);
            if (r103 == r105) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public final class WriteThroughEntry implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f251177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f251178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LocalCache f251179c;

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.f251177a.hashCode() ^ this.f251178b.hashCode();
        }

        public final String toString() {
            return this.f251177a + ContainerUtils.KEY_VALUE_DELIMITER + this.f251178b;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f251177a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f251178b;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(@NullableDecl Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            if (this.f251177a.equals(r101.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.f251178b.equals(r101.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r100) {
            V r101 = (V) this.f251179c.put(this.f251177a, r100);
            this.f251178b = r100;
            return r101;
        }

        public WriteThroughEntry(LocalCache r100, K r101, V r102) {
            this.f251179c = r100;
            this.f251177a = r101;
            this.f251178b = r102;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.jedi.model.guava.cache.LocalCache$1] */
    static {
        f251093u = Logger.getLogger(LocalCache.class.getName());
        f251094v = new AnonymousClass1();
        f251095w = new AnonymousClass2();
    }

    public final boolean b() {
        if (this.f251104i < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        if (this.f251106k <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Segment<K, V>[] r100 = this.f251098c;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].clear();
        r102 = r102 + 1;
        goto L3
    }

    public final boolean d() {
        if (this.f251107l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r100 = this.f251115t;
        if (r100 != null) goto L7;
        EntrySet r101 = new EntrySet(this, this);
        this.f251115t = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        Segment<K, V>[] r100 = this.f251098c;
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102].count != 0) goto L7;
        r101 = r101 + ((long) r100[r102].modCount);
        r102 = r102 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r101 == 0) goto L21;
        int r103 = 0;
    L13:
        if (r103 >= r100.length) goto L19;
        if (r100[r103].count != 0) goto L16;
        r101 = r101 - ((long) r100[r103].modCount);
        r103 = r103 + 1;
        goto L13
    L16:
        return false;
    L19:
        if (r101 == 0) goto L27;
        return false;
    L27:
        return true;
    L21:
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> r100 = this.f251113r;
        if (r100 != null) goto L7;
        KeySet r101 = new KeySet(this, this);
        this.f251113r = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Segment<K, V>[] r100 = this.f251098c;
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101 = r101 + ((long) Math.max(0, r100[r102].count));
        r102 = r102 + 1;
        goto L4
    L7:
        if (r101 <= SieveCacheKt.NodeLinkMask) goto L10;
        return Integer.MAX_VALUE;
    L10:
        if (r101 >= SieveCacheKt.NodeMetaAndPreviousMask) goto L13;
        return Integer.MIN_VALUE;
    L13:
        return (int) r101;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> r100 = this.f251114s;
        if (r100 != null) goto L7;
        Values r101 = new Values(this, this);
        this.f251114s = r101;
        return r101;
    L7:
        return r100;
    }

    public final boolean g() {
        if (d() == false) goto L5;
        return true;
    L5:
        if (this.f251108m <= 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r100 = false;
        goto L8
    }

    public final boolean i() {
        if (c() == false) goto L5;
    L8:
        return true;
    L5:
        if (b() == true) goto L8;
        return false;
    }

    public LocalCache(CacheBuilder<? super K, ? super V> r110) {
        int r100 = r110.f251085b;
        if (r100 != (-1)) goto L5;
        r100 = 4;
    L5:
        this.f251099d = Math.min(r100, 65536);
        Strength r101 = Strength.STRONG;
        MoreObjects.a(r101);
        this.f251102g = r101;
        MoreObjects.a(r101);
        this.f251103h = r101;
        MoreObjects.a(r101);
        Equivalence<Object> r102 = r101.defaultEquivalence();
        MoreObjects.a(r102);
        this.f251100e = r102;
        MoreObjects.a(r101);
        Equivalence<Object> r103 = r101.defaultEquivalence();
        MoreObjects.a(r103);
        this.f251101f = r103;
        long r104 = 0;
        if (r110.f251088e != 0) goto L8;
    L11:
        long r105 = 0;
    L12:
        this.f251104i = r105;
        CacheBuilder.OneWeigher r106 = CacheBuilder.OneWeigher.INSTANCE;
        MoreObjects.a(r106);
        CacheBuilder.OneWeigher r107 = r106;
        this.f251105j = r107;
        long r108 = r110.f251089f;
        if (r108 != (-1)) goto L15;
        r108 = 0;
    L15:
        this.f251106k = r108;
        long r109 = r110.f251088e;
        if (r109 != (-1)) goto L18;
        r109 = 0;
    L18:
        this.f251107l = r109;
        long r111 = r110.f251090g;
        if (r111 == (-1)) goto L22;
        r104 = r111;
    L22:
        this.f251108m = r104;
        CacheBuilder.NullListener r112 = CacheBuilder.NullListener.INSTANCE;
        MoreObjects.a(r112);
        CacheBuilder.NullListener r113 = r112;
        this.f251110o = r113;
        if (r113 != r112) goto L25;
        ConcurrentLinkedQueue r114 = (Queue<RemovalNotification<K, V>>) f251095w;
    L26:
        this.f251109n = r114;
        int r115 = 0;
        int r116 = 1;
        if (g() == false) goto L29;
    L32:
        boolean r117 = true;
    L33:
        if (r117 == false) goto L35;
        Ticker r118 = Ticker.f251082a;
    L36:
        this.f251111p = r118;
        if (i() == false) goto L39;
    L42:
        boolean r119 = true;
    L44:
        if (d() == false) goto L46;
    L49:
        boolean r120 = true;
    L50:
        this.f251112q = EntryFactory.getFactory(r101, r119, r120);
        int r121 = r110.f251084a;
        if (r121 != (-1)) goto L53;
        r121 = 16;
    L53:
        int r122 = Math.min(r121, 1073741824);
        if (b() == false) goto L60;
        if (r107 == r106) goto L57;
        boolean r123 = true;
    L58:
        if (r123 == true) goto L60;
        r122 = (int) Math.min(r122, r105);
        goto L60
    L57:
        r123 = false;
    L60:
        int r124 = 1;
        int r125 = 0;
    L62:
        if (r124 >= this.f251099d) goto L68;
        if (b() == false) goto L67;
        if ((r124 * 20) > this.f251104i) goto L68;
    L67:
        r125 = r125 + 1;
        r124 = r124 << 1;
    L68:
        this.f251097b = 32 - r125;
        this.f251096a = r124 - 1;
        this.f251098c = new Segment[r124];
        int r126 = r122 / r124;
        if ((r126 * r124) >= r122) goto L71;
        r126 = r126 + 1;
    L71:
        if (r116 >= r126) goto L74;
        r116 = r116 << 1;
        goto L71
    L74:
        if (b() == false) goto L82;
        long r127 = this.f251104i;
        long r128 = r124;
        long r129 = (r127 / r128) + 1;
        long r130 = r127 % r128;
    L76:
        Segment<K, V>[] r131 = this.f251098c;
        if (r115 >= r131.length) goto L85;
        if (r115 != r130) goto L81;
        r129 = r129 - 1;
    L81:
        r131[r115] = new Segment(this, r116, r129);
        r115 = r115 + 1;
        goto L76
    L85:
        return;
    L82:
        Segment<K, V>[] r132 = this.f251098c;
        if (r115 >= r132.length) goto L96;
        r132[r115] = new Segment(this, r116, -1);
        r115 = r115 + 1;
        goto L82
    L96:
        return;
    L46:
        if (g() == true) goto L49;
        r120 = false;
        goto L50
    L39:
        if (c() == true) goto L42;
        r119 = false;
        goto L44
    L35:
        r118 = CacheBuilder.f251083h;
        goto L36
    L29:
        if (c() == true) goto L32;
        r117 = false;
        goto L33
    L25:
        r114 = new ConcurrentLinkedQueue();
        goto L26
    L8:
        if (r110.f251089f == 0) goto L11;
        r105 = r110.f251086c;
        goto L12
    }

    public static ArrayList a(Collection r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator r102 = r100.iterator();
        r102.getClass();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next());
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@NullableDecl Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = e(r100);
        return h(r101).containsKey(r100, r101);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@NullableDecl Object r210) {
        if (r210 != null) goto L5;
        return false;
    L5:
        long r100 = this.f251111p.a();
        Segment<K, V>[] r101 = this.f251098c;
        long r102 = -1;
        int r103 = 0;
    L7:
        if (r103 >= 3) goto L28;
        int r104 = r101.length;
        long r110 = 0;
        int r111 = 0;
    L9:
        if (r111 >= r104) goto L24;
        Segment<K, V> r112 = r101[r111];
        int r113 = r112.count;
        AtomicReferenceArray<ReferenceEntry<K, V>> r114 = r112.table;
        int r115 = 0;
    L12:
        if (r115 >= r114.length()) goto L23;
        ReferenceEntry<K, V> r105 = r114.get(r115);
    L14:
        if (r105 == null) goto L22;
        Segment<K, V>[] r116 = r101;
        V r106 = r112.getLiveValue(r105, r100);
        long r117 = r100;
        if (r106 == null) goto L21;
        if (this.f251101f.equivalent(r210, r106) == false) goto L21;
        return true;
    L21:
        r105 = r105.getNext();
        r101 = r116;
        r100 = r117;
        goto L14
    L22:
        r115 = r115 + 1;
        goto L12
    L23:
        r110 = r110 + ((long) r112.modCount);
        r111 = r111 + 1;
        r100 = r100;
        goto L9
    L24:
        long r118 = r100;
        Segment<K, V>[] r119 = r101;
        if (r110 == r102) goto L38;
        r103 = r103 + 1;
        r102 = r110;
        r101 = r119;
        r100 = r118;
        goto L7
    L38:
        return false;
    L28:
        return false;
    }

    public final int e(@NullableDecl Object r100) {
        int r101 = this.f251100e.hash(r100);
        int r102 = r101 + ((r101 << 15) ^ (-12931));
        int r103 = r102 ^ (r102 >>> 10);
        int r104 = r103 + (r103 << 3);
        int r105 = r104 ^ (r104 >>> 6);
        int r106 = r105 + ((r105 << 2) + (r105 << 14));
        return r106 ^ (r106 >>> 16);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = e(r100);
        return h(r101).get(r100, r101);
    }

    public final Segment<K, V> h(int r100) {
        return this.f251098c[(r100 >>> this.f251097b) & this.f251096a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r100) {
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L4
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(@NullableDecl Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = e(r100);
        return h(r101).remove(r100, r101);
    }

    public final boolean f(ReferenceEntry<K, V> r100, long r101) {
        r100.getClass();
        if (c() == false) goto L8;
        if ((r101 - r100.getAccessTime()) < this.f251106k) goto L8;
        return true;
    L8:
        if (d() == true) goto L10;
        return false;
    L10:
        if ((r101 - r100.getWriteTime()) < this.f251107l) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public final V getOrDefault(@NullableDecl Object r100, @NullableDecl V r101) {
        V r102 = get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = e(r100);
        return h(r102).put(r100, r102, r101, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final V putIfAbsent(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = e(r100);
        return h(r102).put(r100, r102, r101, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(@NullableDecl Object r100, @NullableDecl Object r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        int r102 = e(r100);
        return h(r102).remove(r100, r102, r101);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final V replace(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = e(r100);
        return h(r102).replace(r100, r102, r101);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(K r100, @NullableDecl V r101, V r102) {
        r100.getClass();
        r102.getClass();
        if (r101 != null) goto L6;
        return false;
    L6:
        int r103 = e(r100);
        return h(r103).replace(r100, r103, r101, r102);
    }
}
