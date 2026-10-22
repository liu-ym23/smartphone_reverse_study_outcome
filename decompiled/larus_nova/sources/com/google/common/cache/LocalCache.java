package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
public final class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Logger f274766w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f274767x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b f274768y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f274770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Segment<K, V>[] f274771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f274772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Equivalence<Object> f274773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Equivalence<Object> f274774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Strength f274775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Strength f274776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f274777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.common.cache.m<K, V> f274778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f274779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f274780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f274781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Queue<RemovalNotification<K, V>> f274782n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.google.common.cache.l<K, V> f274783o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.google.common.base.v f274784p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final EntryFactory f274785q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.google.common.cache.b f274786r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @CheckForNull
    public final CacheLoader<? super K, V> f274787s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @CheckForNull
    public j f274788t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @CheckForNull
    public t f274789u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @CheckForNull
    public g f274790v;

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
        public static final /* synthetic */ EntryFactory[] f274791a = null;
        static final EntryFactory[] factories = null;

        public EntryFactory() {
            throw null;
        }

        public abstract <K, V> com.google.common.cache.k<K, V> newEntry(Segment<K, V> r100, K r101, int r102, @CheckForNull com.google.common.cache.k<K, V> r103);

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
            f274791a = new EntryFactory[]{r102, r105, r108, r111, r114, r117, r120, r123};
            factories = new EntryFactory[]{r102, r105, r108, r111, r114, r117, r120, r123};
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) f274791a.clone();
        }

        public static EntryFactory valueOf(String r100) {
            return (EntryFactory) r27.a.a(EntryFactory.class, r100);
        }

        public <K, V> void copyAccessEntry(com.google.common.cache.k<K, V> r100, com.google.common.cache.k<K, V> r101) {
            r101.setAccessTime(r100.getAccessTime());
            com.google.common.cache.k<K, V> r102 = r100.getPreviousInAccessQueue();
            Logger r103 = LocalCache.f274766w;
            r102.setNextInAccessQueue(r101);
            r101.setPreviousInAccessQueue(r102);
            com.google.common.cache.k<K, V> r104 = r100.getNextInAccessQueue();
            r101.setNextInAccessQueue(r104);
            r104.setPreviousInAccessQueue(r101);
            NullEntry r105 = NullEntry.INSTANCE;
            r100.setNextInAccessQueue(r105);
            r100.setPreviousInAccessQueue(r105);
        }

        public <K, V> void copyWriteEntry(com.google.common.cache.k<K, V> r100, com.google.common.cache.k<K, V> r101) {
            r101.setWriteTime(r100.getWriteTime());
            com.google.common.cache.k<K, V> r102 = r100.getPreviousInWriteQueue();
            Logger r103 = LocalCache.f274766w;
            r102.setNextInWriteQueue(r101);
            r101.setPreviousInWriteQueue(r102);
            com.google.common.cache.k<K, V> r104 = r100.getNextInWriteQueue();
            r101.setNextInWriteQueue(r104);
            r104.setPreviousInWriteQueue(r101);
            NullEntry r105 = NullEntry.INSTANCE;
            r100.setNextInWriteQueue(r105);
            r100.setPreviousInWriteQueue(r105);
        }

        public EntryFactory(String r100, int r101, a r102) {
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

        public <K, V> com.google.common.cache.k<K, V> copyEntry(Segment<K, V> r100, com.google.common.cache.k<K, V> r101, com.google.common.cache.k<K, V> r102, K r103) {
            return newEntry(r100, r103, r101.getHash(), r102);
        }
    }

    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements com.google.common.cache.g<K, V> {
        private static final long serialVersionUID = 1;

        @CheckForNull
        transient com.google.common.cache.g<K, V> autoDelegate;

        private Object readResolve() {
            return this.autoDelegate;
        }

        public LoadingSerializationProxy(LocalCache<K, V> r100) {
            super(r100);
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            CacheBuilder<K, V> r101 = recreateCacheBuilder();
            CacheLoader<? super K, V> r102 = this.loader;
            r101.a();
            this.autoDelegate = new LocalLoadingCache(r101, r102);
        }

        @Override // com.google.common.cache.g, com.google.common.base.g
        public V apply(K r100) {
            return this.autoDelegate.apply(r100);
        }

        @Override // com.google.common.cache.g
        public V get(K r100) throws ExecutionException {
            return this.autoDelegate.get(r100);
        }

        @Override // com.google.common.cache.g
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r100) throws ExecutionException {
            return this.autoDelegate.getAll(r100);
        }

        @Override // com.google.common.cache.g
        public V getUnchecked(K r100) {
            return this.autoDelegate.getUnchecked(r100);
        }

        @Override // com.google.common.cache.g
        public void refresh(K r100) {
            this.autoDelegate.refresh(r100);
        }
    }

    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements com.google.common.cache.g<K, V> {
        private static final long serialVersionUID = 1;

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }

        private void readObject(ObjectInputStream r100) throws InvalidObjectException {
            throw new InvalidObjectException("Use LoadingSerializationProxy");
        }

        @Override // com.google.common.cache.g, com.google.common.base.g
        public final V apply(K r100) {
            return getUnchecked(r100);
        }

        @Override // com.google.common.cache.g
        public V get(K r100) throws ExecutionException {
            LocalCache<K, V> r101 = this.localCache;
            CacheLoader<? super K, V> r102 = r101.f274787s;
            r100.getClass();
            int r103 = r101.e(r100);
            return r101.i(r103).get(r100, r103, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.cache.g
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r100) throws ExecutionException {
            LocalCache<K, V> r101 = this.localCache;
            r101.getClass();
            LinkedHashMap r102 = new LinkedHashMap();
            LinkedHashSet r103 = new LinkedHashSet();
            Iterator<? extends K> r104 = r100.iterator();
            int r105 = 0;
            int r106 = 0;
        L4:
            if (r104.hasNext() == false) goto L33;
            K r107 = r104.next();
            V r108 = r101.get(r107);
            if (r102.containsKey(r107) == true) goto L4;
            r102.put(r107, r108);
            if (r108 == null) goto L9;
            r105 = r105 + 1;
            goto L4
        L9:
            r106 = r106 + 1;
            r103.add(r107);
            goto L4
        L33:
        L28:
            th = move-exception;
            r101.f274786r.a(r105);
            r101.f274786r.d(r106);
            throw th;
        L12:
            if (r103.isEmpty() == false) goto L31;
        L25:
            ImmutableMap<K, V> r109 = ImmutableMap.copyOf(r102);     // Catch: Throwable -> L28
            r101.f274786r.a(r105);
            r101.f274786r.d(r106);
            return r109;
        L31:
            Map<K, V> r110 = r101.g(Collections.unmodifiableSet(r103), r101.f274787s);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
            Iterator r111 = r103.iterator();     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        L15:
            if (r111.hasNext() == false) goto L25;
            Object r112 = r111.next();     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
            V r113 = r110.get(r112);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
            if (r113 == null) goto L20;
            r102.put(r112, r113);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
            goto L15
        L20:
            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + r112);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        L21:
            Iterator r114 = r103.iterator();     // Catch: Throwable -> L28
        L23:
            if (r114.hasNext() == false) goto L25;
            Object r115 = r114.next();     // Catch: Throwable -> L28
            r106 = r106 - 1;     // Catch: Throwable -> L28
            CacheLoader<? super K, V> r116 = r101.f274787s;     // Catch: Throwable -> L28
            r115.getClass();     // Catch: Throwable -> L28
            int r117 = r101.e(r115);     // Catch: Throwable -> L28
            r102.put(r115, r101.i(r117).get(r115, r117, r116));     // Catch: Throwable -> L28
            goto L23
        }

        @Override // com.google.common.cache.g
        public V getUnchecked(K r100) {
            return get(r100);
        L4:
            e = move-exception;
            throw new UncheckedExecutionException(e.getCause());
        }

        @Override // com.google.common.cache.g
        public void refresh(K r100) {
            LocalCache<K, V> r101 = this.localCache;
            r101.getClass();
            r100.getClass();
            int r102 = r101.e(r100);
            r101.i(r102).refresh(r100, r102, r101.f274787s, false);
        }

        public LocalLoadingCache(CacheBuilder<? super K, ? super V> r100, CacheLoader<? super K, V> r101) {
            r101.getClass();
            super(new LocalCache(r100, r101), null);
        }
    }

    public static class LocalManualCache<K, V> implements com.google.common.cache.c<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        public class a extends CacheLoader<Object, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callable f274792a;

            public a(Callable r100) {
                this.f274792a = r100;
            }

            @Override // com.google.common.cache.CacheLoader
            public final V load(Object r100) throws Exception {
                return (V) this.f274792a.call();
            }
        }

        @Override // com.google.common.cache.c
        public void cleanUp() {
            Segment<K, V>[] r100 = this.localCache.f274771c;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            r100[r102].cleanUp();
            r102 = r102 + 1;
            goto L3
        }

        @Override // com.google.common.cache.c
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // com.google.common.cache.c
        public long size() {
            Segment<K, V>[] r100 = this.localCache.f274771c;
            int r101 = r100.length;
            long r102 = 0;
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            r102 = r102 + ((long) Math.max(0, r100[r103].count));
            r103 = r103 + 1;
            goto L3
        L5:
            return r102;
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.e stats() {
            com.google.common.cache.a r100 = new com.google.common.cache.a();
            r100.f(this.localCache.f274786r);
            Segment<K, V>[] r101 = this.localCache.f274771c;
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            r100.f(r101[r103].statsCounter);
            r103 = r103 + 1;
            goto L3
        L6:
            return r100.snapshot();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        @Override // com.google.common.cache.c
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> r100) {
            this(new LocalCache(r100, null));
        }

        private void readObject(ObjectInputStream r100) throws InvalidObjectException {
            throw new InvalidObjectException("Use ManualSerializationProxy");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.cache.c
        public ImmutableMap<K, V> getAllPresent(Iterable<?> r100) {
            LocalCache<K, V> r101 = this.localCache;
            r101.getClass();
            ImmutableMap.b r102 = ImmutableMap.builder();
            Iterator<?> r103 = r100.iterator();
            int r104 = 0;
            int r105 = 0;
        L4:
            if (r103.hasNext() == false) goto L9;
            Object r106 = r103.next();
            V r107 = r101.get(r106);
            if (r107 == null) goto L7;
            r102.e(r106, r107);
            r104 = r104 + 1;
            goto L4
        L7:
            r105 = r105 + 1;
            goto L4
        L9:
            r101.f274786r.a(r104);
            r101.f274786r.d(r105);
            return r102.c();
        }

        @Override // com.google.common.cache.c
        @CheckForNull
        public V getIfPresent(Object r100) {
            LocalCache<K, V> r101 = this.localCache;
            r101.getClass();
            r100.getClass();
            int r102 = r101.e(r100);
            V r103 = r101.i(r102).get(r100, r102);
            if (r103 != null) goto L5;
            r101.f274786r.d(1);
        L6:
            return r103;
        L5:
            r101.f274786r.a(1);
            goto L6
        }

        @Override // com.google.common.cache.c
        public void invalidate(Object r100) {
            r100.getClass();
            this.localCache.remove(r100);
        }

        @Override // com.google.common.cache.c
        public void invalidateAll(Iterable<?> r100) {
            LocalCache<K, V> r101 = this.localCache;
            r101.getClass();
            Iterator<?> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r101.remove(r102.next());
            goto L4
        }

        @Override // com.google.common.cache.c
        public void putAll(Map<? extends K, ? extends V> r100) {
            this.localCache.putAll(r100);
        }

        public LocalManualCache(LocalCache<K, V> r100) {
            this.localCache = r100;
        }

        public /* synthetic */ LocalManualCache(LocalCache r100, a r101) {
            this(r100);
        }

        @Override // com.google.common.cache.c
        public V get(K r100, Callable<? extends V> r101) throws ExecutionException {
            r101.getClass();
            LocalCache<K, V> r102 = this.localCache;
            a r103 = new a(r101);
            r102.getClass();
            r100.getClass();
            int r104 = r102.e(r100);
            return r102.i(r104).get(r100, r104, r103);
        }

        @Override // com.google.common.cache.c
        public void put(K r100, V r101) {
            this.localCache.put(r100, r101);
        }
    }

    public static class ManualSerializationProxy<K, V> extends com.google.common.cache.f<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @CheckForNull
        transient com.google.common.cache.c<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final com.google.common.cache.l<? super K, ? super V> removalListener;

        @CheckForNull
        final com.google.common.base.v ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final com.google.common.cache.m<K, V> weigher;

        public ManualSerializationProxy() {
            throw null;
        }

        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> r100 = new CacheBuilder();
            Strength r101 = this.keyStrength;
            Strength r102 = r100.f274752g;
            boolean r103 = true;
            if (r102 != null) goto L5;
            boolean r104 = true;
        L6:
            com.google.common.base.m.s(r104, "Key strength was already set to %s", r102);
            r101.getClass();
            r100.f274752g = r101;
            Strength r105 = this.valueStrength;
            Strength r106 = r100.f274753h;
            if (r106 != null) goto L9;
            boolean r107 = true;
        L10:
            com.google.common.base.m.s(r107, "Value strength was already set to %s", r106);
            r105.getClass();
            r100.f274753h = r105;
            Equivalence<Object> r108 = this.keyEquivalence;
            Equivalence<Object> r109 = r100.f274757l;
            if (r109 != null) goto L13;
            boolean r110 = true;
        L14:
            com.google.common.base.m.s(r110, "key equivalence was already set to %s", r109);
            r108.getClass();
            r100.f274757l = r108;
            Equivalence<Object> r111 = this.valueEquivalence;
            Equivalence<Object> r112 = r100.f274758m;
            if (r112 != null) goto L17;
            boolean r113 = true;
        L18:
            com.google.common.base.m.s(r113, "value equivalence was already set to %s", r112);
            r111.getClass();
            r100.f274758m = r111;
            int r114 = this.concurrencyLevel;
            int r115 = r100.f274748c;
            if (r115 != (-1)) goto L21;
            boolean r116 = true;
        L22:
            com.google.common.base.m.q(r116, "concurrency level was already set to %s", r115);
            if (r114 <= 0) goto L25;
            boolean r117 = true;
        L26:
            com.google.common.base.m.b(r117);
            r100.f274748c = r114;
            com.google.common.cache.l<? super K, ? super V> r118 = this.removalListener;
            if (r100.f274759n != null) goto L29;
            boolean r119 = true;
        L30:
            com.google.common.base.m.o(r119);
            r118.getClass();
            r100.f274759n = r118;
            r100.f274746a = false;
            long r120 = this.expireAfterWriteNanos;
            if (r120 <= 0) goto L41;
            TimeUnit r121 = TimeUnit.NANOSECONDS;
            long r122 = r100.f274754i;
            if (r122 != (-1)) goto L35;
            boolean r123 = true;
        L36:
            com.google.common.base.m.r(r123, "expireAfterWrite was already set to %s ns", r122);
            if (r120 < 0) goto L39;
            boolean r124 = true;
        L40:
            com.google.common.base.m.g(r124, "duration cannot be negative: %s %s", r120, r121);
            r100.f274754i = r121.toNanos(r120);
            goto L41
        L39:
            r124 = false;
            goto L40
        L35:
            r123 = false;
        L41:
            long r125 = this.expireAfterAccessNanos;
            if (r125 <= 0) goto L52;
            TimeUnit r126 = TimeUnit.NANOSECONDS;
            long r127 = r100.f274755j;
            if (r127 != (-1)) goto L46;
            boolean r128 = true;
        L47:
            com.google.common.base.m.r(r128, "expireAfterAccess was already set to %s ns", r127);
            if (r125 < 0) goto L50;
            boolean r129 = true;
        L51:
            com.google.common.base.m.g(r129, "duration cannot be negative: %s %s", r125, r126);
            r100.f274755j = r126.toNanos(r125);
            goto L52
        L50:
            r129 = false;
            goto L51
        L46:
            r128 = false;
        L52:
            com.google.common.cache.m<K, V> r130 = this.weigher;
            if (r130 != CacheBuilder.OneWeigher.INSTANCE) goto L55;
            long r131 = this.maxWeight;
            if (r131 == (-1)) goto L99;
            long r132 = r100.f274749d;
            if (r132 != (-1)) goto L85;
            boolean r133 = true;
        L86:
            com.google.common.base.m.r(r133, "maximum size was already set to %s", r132);
            long r134 = r100.f274750e;
            if (r134 != (-1)) goto L89;
            boolean r135 = true;
        L90:
            com.google.common.base.m.r(r135, "maximum weight was already set to %s", r134);
            if (r100.f274751f != null) goto L93;
            boolean r136 = true;
        L94:
            com.google.common.base.m.p(r136, "maximum size can not be combined with weigher");
            if (r131 < 0) goto L97;
            boolean r137 = true;
        L98:
            com.google.common.base.m.c(r137, "maximum size must not be negative");
            r100.f274749d = r131;
            goto L99
        L97:
            r137 = false;
            goto L98
        L93:
            r136 = false;
            goto L94
        L89:
            r135 = false;
            goto L90
        L85:
            r133 = false;
        L99:
            com.google.common.base.v r138 = this.ticker;
            if (r138 != null) goto L102;
        L106:
            return r100;
        L102:
            if (r100.f274760o == null) goto L105;
            r103 = false;
        L105:
            com.google.common.base.m.o(r103);
            r138.getClass();
            r100.f274760o = r138;
            goto L106
        L55:
            if (r100.f274751f != null) goto L57;
            boolean r139 = true;
        L58:
            com.google.common.base.m.o(r139);
            if (r100.f274746a == false) goto L65;
            long r140 = r100.f274749d;
            if (r140 != (-1)) goto L63;
            boolean r141 = true;
        L64:
            com.google.common.base.m.r(r141, "weigher can not be combined with maximum size (%s provided)", r140);
            goto L65
        L63:
            r141 = false;
        L65:
            r130.getClass();
            r100.f274751f = r130;
            long r142 = this.maxWeight;
            if (r142 == (-1)) goto L99;
            long r143 = r100.f274750e;
            if (r143 != (-1)) goto L70;
            boolean r144 = true;
        L71:
            com.google.common.base.m.r(r144, "maximum weight was already set to %s", r143);
            long r145 = r100.f274749d;
            if (r145 != (-1)) goto L74;
            boolean r146 = true;
        L75:
            com.google.common.base.m.r(r146, "maximum size was already set to %s", r145);
            if (r142 < 0) goto L78;
            boolean r147 = true;
        L79:
            com.google.common.base.m.c(r147, "maximum weight must not be negative");
            r100.f274750e = r142;
            goto L99
        L78:
            r147 = false;
            goto L79
        L74:
            r146 = false;
            goto L75
        L70:
            r144 = false;
            goto L71
        L57:
            r139 = false;
            goto L58
        L29:
            r119 = false;
            goto L30
        L25:
            r117 = false;
            goto L26
        L21:
            r116 = false;
            goto L22
        L17:
            r113 = false;
            goto L18
        L13:
            r110 = false;
            goto L14
        L9:
            r107 = false;
            goto L10
        L5:
            r104 = false;
            goto L6
        }

        @Override // com.google.common.cache.f, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        private Object readResolve() {
            return this.delegate;
        }

        @Override // com.google.common.cache.f, com.google.common.collect.o0
        public com.google.common.cache.c<K, V> delegate() {
            return this.delegate;
        }

        public ManualSerializationProxy(LocalCache<K, V> r110) {
            Strength r100 = r110.f274775g;
            Strength r101 = r110.f274776h;
            Equivalence<Object> r102 = r110.f274773e;
            Equivalence<Object> r103 = r110.f274774f;
            long r104 = r110.f274780l;
            long r105 = r110.f274779k;
            long r106 = r110.f274777i;
            com.google.common.cache.m<K, V> r111 = r110.f274778j;
            int r112 = r110.f274772d;
            com.google.common.cache.l<K, V> r113 = r110.f274783o;
            com.google.common.base.v r114 = r110.f274784p;
            CacheLoader<? super K, V> r115 = r110.f274787s;
            this.keyStrength = r100;
            this.valueStrength = r101;
            this.keyEquivalence = r102;
            this.valueEquivalence = r103;
            this.expireAfterWriteNanos = r104;
            this.expireAfterAccessNanos = r105;
            this.maxWeight = r106;
            this.weigher = r111;
            this.concurrencyLevel = r112;
            this.removalListener = r113;
            if (r114 != com.google.common.base.v.f274741a) goto L5;
        L6:
            r114 = null;
        L7:
            this.ticker = r114;
            this.loader = r115;
            return;
        L5:
            if (r114 != CacheBuilder.f274744s) goto L7;
            goto L6
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            CacheBuilder<K, V> r101 = recreateCacheBuilder();
            r101.a();
            if (r101.f274756k != (-1)) goto L5;
            boolean r102 = true;
        L6:
            com.google.common.base.m.p(r102, "refreshAfterWrite requires a LoadingCache");
            this.delegate = new LocalManualCache(r101);
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final enum NullEntry extends Enum<NullEntry> implements com.google.common.cache.k<Object, Object> {
        public static final NullEntry INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NullEntry[] f274793a = null;

        @Override // com.google.common.cache.k
        public long getAccessTime() {
            return 0;
        }

        @Override // com.google.common.cache.k
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.k
        @CheckForNull
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.k
        @CheckForNull
        public com.google.common.cache.k<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.k
        @CheckForNull
        public s<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.k
        public long getWriteTime() {
            return 0;
        }

        @Override // com.google.common.cache.k
        public void setAccessTime(long r100) {
        }

        @Override // com.google.common.cache.k
        public void setNextInAccessQueue(com.google.common.cache.k<Object, Object> r100) {
        }

        @Override // com.google.common.cache.k
        public void setNextInWriteQueue(com.google.common.cache.k<Object, Object> r100) {
        }

        @Override // com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.common.cache.k<Object, Object> r100) {
        }

        @Override // com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.common.cache.k<Object, Object> r100) {
        }

        @Override // com.google.common.cache.k
        public void setValueReference(s<Object, Object> r100) {
        }

        @Override // com.google.common.cache.k
        public void setWriteTime(long r100) {
        }

        static {
            NullEntry r100 = new NullEntry();
            INSTANCE = r100;
            f274793a = new NullEntry[]{r100};
        }

        public NullEntry() {
            super("INSTANCE", 0);
        }

        public static NullEntry[] values() {
            return (NullEntry[]) f274793a.clone();
        }

        public static NullEntry valueOf(String r100) {
            return (NullEntry) r27.a.a(NullEntry.class, r100);
        }
    }

    public static class Segment<K, V> extends ReentrantLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f274794a = 0;
        final Queue<com.google.common.cache.k<K, V>> accessQueue;
        volatile int count;

        @CheckForNull
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount;
        final Queue<com.google.common.cache.k<K, V>> recencyQueue;
        final com.google.common.cache.b statsCounter;

        @CheckForNull
        volatile AtomicReferenceArray<com.google.common.cache.k<K, V>> table;
        int threshold;
        long totalWeight;

        @CheckForNull
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<com.google.common.cache.k<K, V>> writeQueue;

        public void drainKeyReferenceQueue() {
            int r100 = 0;
        L3:
            Reference<? extends K> r101 = this.keyReferenceQueue.poll();
            if (r101 == null) goto L7;
            com.google.common.cache.k<K, V> r102 = (com.google.common.cache.k) r101;
            LocalCache<K, V> r103 = this.map;
            r103.getClass();
            int r104 = r102.getHash();
            r103.i(r104).reclaimKey(r102, r104);
            r100 = r100 + 1;
            if (r100 != 16) goto L3;
            return;
        }

        public void drainValueReferenceQueue() {
            int r100 = 0;
        L3:
            Reference<? extends V> r101 = this.valueReferenceQueue.poll();
            if (r101 == null) goto L7;
            s<K, V> r102 = (s) r101;
            LocalCache<K, V> r103 = this.map;
            r103.getClass();
            com.google.common.cache.k<K, V> r104 = r102.getEntry();
            int r105 = r104.getHash();
            r103.i(r105).reclaimValue(r104.getKey(), r105, r102);
            r100 = r100 + 1;
            if (r100 != 16) goto L3;
            return;
        }

        public void cleanUp() {
            runLockedCleanup(this.map.f274784p.a());
            runUnlockedCleanup();
        }

        public void clear() {
            if (this.count == 0) goto L30;
            lock();
            preWriteCleanup(this.map.f274784p.a());     // Catch: Throwable -> L27
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r100 = this.table;     // Catch: Throwable -> L27
            int r101 = 0;
        L7:
            if (r101 >= r100.length()) goto L21;
            com.google.common.cache.k<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L27
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
            Strength r100 = this.map.f274775g;
            Strength r101 = Strength.STRONG;
            boolean r102 = true;
            if (r100 == r101) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L9;
            clearKeyReferenceQueue();
        L9:
            if (this.map.f274776h != r101) goto L12;
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
            com.google.common.cache.k<K, V> r100 = this.recencyQueue.poll();
            if (r100 == null) goto L7;
            if (this.accessQueue.contains(r100) == false) goto L2;
            this.accessQueue.add(r100);
            goto L2
        }

        public void drainReferenceQueues() {
            Strength r100 = this.map.f274775g;
            Strength r101 = Strength.STRONG;
            boolean r102 = true;
            if (r100 == r101) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L9;
            drainKeyReferenceQueue();
        L9:
            if (this.map.f274776h != r101) goto L12;
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
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r100 = this.table;
            int r101 = r100.length();
            if (r101 < 1073741824) goto L5;
            return;
        L5:
            int r102 = this.count;
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r103 = newEntryArray(r101 << 1);
            this.threshold = (r103.length() * 3) / 4;
            int r104 = r103.length() - 1;
            int r105 = 0;
        L6:
            if (r105 >= r101) goto L26;
            com.google.common.cache.k<K, V> r106 = r100.get(r105);
            if (r106 == null) goto L25;
            com.google.common.cache.k<K, V> r107 = r106.getNext();
            int r108 = r106.getHash() & r104;
            if (r107 != null) goto L12;
            r103.set(r108, r106);
            goto L25
        L12:
            com.google.common.cache.k<K, V> r109 = r106;
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
            com.google.common.cache.k<K, V> r112 = copyEntry(r106, r103.get(r111));
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

        public com.google.common.cache.k<K, V> getNextEvictable() {
            Iterator<com.google.common.cache.k<K, V>> r100 = this.accessQueue.iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            com.google.common.cache.k<K, V> r101 = r100.next();
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
            RemovalNotification<K, V> r101 = r100.f274782n.poll();
            if (r101 == null) goto L18;
            r100.f274783o.onRemoval(r101);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            LocalCache.f274766w.log(Level.WARNING, "Exception thrown by removal listener", th);
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
            long r100 = this.map.f274784p.a();     // Catch: Throwable -> L20
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r101 = this.table;     // Catch: Throwable -> L20
            int r102 = r101.length();     // Catch: Throwable -> L20
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L18;
            com.google.common.cache.k<K, V> r104 = r101.get(r103);     // Catch: Throwable -> L20
        L7:
            if (r104 == null) goto L17;
            V r105 = getLiveValue(r104, r100);     // Catch: Throwable -> L20
            if (r105 != null) goto L12;
        L15:
            r104 = r104.getNext();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.f274774f.equivalent(r110, r105) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r103 = r103 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        public void evictEntries(com.google.common.cache.k<K, V> r100) {
            if (this.map.b() == true) goto L5;
            return;
        L5:
            drainRecencyQueue();
            if (r100.getValueReference().getWeight() <= this.maxSegmentWeight) goto L13;
            if (removeEntry(r100, r100.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        L13:
            if (this.totalWeight <= this.maxSegmentWeight) goto L19;
            com.google.common.cache.k<K, V> r101 = getNextEvictable();
            if (removeEntry(r101, r101.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        }

        public void expireEntries(long r100) {
            drainRecencyQueue();
        L3:
            com.google.common.cache.k<K, V> r101 = this.writeQueue.peek();
            if (r101 == null) goto L12;
            if (this.map.f(r101, r100) == false) goto L12;
            if (removeEntry(r101, r101.getHash(), RemovalCause.EXPIRED) == true) goto L3;
            throw new AssertionError();
        L12:
            com.google.common.cache.k<K, V> r102 = this.accessQueue.peek();
            if (r102 == null) goto L21;
            if (this.map.f(r102, r100) == false) goto L31;
            if (removeEntry(r102, r102.getHash(), RemovalCause.EXPIRED) == true) goto L12;
            throw new AssertionError();
        L31:
            return;
        }

        public com.google.common.cache.k<K, V> getFirst(int r100) {
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r101 = this.table;
            return r101.get(r100 & (r101.length() - 1));
        }

        public void initTable(AtomicReferenceArray<com.google.common.cache.k<K, V>> r100) {
            int r101 = (r100.length() * 3) / 4;
            this.threshold = r101;
            if (this.map.f274778j == CacheBuilder.OneWeigher.INSTANCE) goto L5;
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

        public AtomicReferenceArray<com.google.common.cache.k<K, V>> newEntryArray(int r100) {
            return new AtomicReferenceArray(r100);
        }

        public void preWriteCleanup(long r100) {
            runLockedCleanup(r100);
        }

        public void removeCollectedEntry(com.google.common.cache.k<K, V> r100) {
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
            com.google.common.cache.k<K, V> r103 = getLiveEntry(r100, r101, this.map.f274784p.a());     // Catch: Throwable -> L15
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

        @CheckForNull
        public com.google.common.cache.k<K, V> copyEntry(com.google.common.cache.k<K, V> r100, com.google.common.cache.k<K, V> r101) {
            K r102 = r100.getKey();
            if (r102 != null) goto L5;
            return null;
        L5:
            s<K, V> r103 = r100.getValueReference();
            V r104 = r103.get();
            if (r104 == null) goto L8;
        L10:
            com.google.common.cache.k<K, V> r105 = this.map.f274785q.copyEntry(this, r100, r101, r102);
            r105.setValueReference(r103.c(this.valueReferenceQueue, r104, r105));
            return r105;
        L8:
            if (r103.isActive() == false) goto L10;
            return null;
        }

        @CheckForNull
        public V get(Object r110, int r111) {
        L16:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L14;
            long r100 = this.map.f274784p.a();     // Catch: Throwable -> L16
            com.google.common.cache.k<K, V> r101 = getLiveEntry(r110, r111, r100);     // Catch: Throwable -> L16
            if (r101 != null) goto L8;
            postReadCleanup();
            return null;
        L8:
            V r102 = r101.getValueReference().get();     // Catch: Throwable -> L16
            if (r102 == null) goto L13;
            recordRead(r101, r100);     // Catch: Throwable -> L16
            V r112 = scheduleRefresh(r101, r101.getKey(), r111, r102, r100, this.map.f274787s);     // Catch: Throwable -> L16
            postReadCleanup();
            return r112;
        L13:
            tryDrainReferenceQueues();     // Catch: Throwable -> L16
        L14:
            postReadCleanup();
            return null;
        }

        @CheckForNull
        public com.google.common.cache.k<K, V> getEntry(Object r100, int r101) {
            com.google.common.cache.k<K, V> r102 = getFirst(r101);
        L3:
            if (r102 == null) goto L14;
            if (r102.getHash() != r101) goto L13;
            K r103 = r102.getKey();
            if (r103 != null) goto L11;
            tryDrainReferenceQueues();
            goto L13
        L11:
            if (this.map.f274773e.equivalent(r100, r103) == false) goto L13;
            return r102;
        L13:
            r102 = r102.getNext();
            goto L3
        L14:
            return null;
        }

        public V getLiveValue(com.google.common.cache.k<K, V> r100, long r101) {
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

        public boolean reclaimKey(com.google.common.cache.k<K, V> r110, int r111) {
            lock();
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r100 = this.table;     // Catch: Throwable -> L13
            int r101 = (r100.length() - 1) & r111;     // Catch: Throwable -> L13
            com.google.common.cache.k<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L13
            com.google.common.cache.k<K, V> r103 = r102;
        L4:
            if (r103 == null) goto L11;
            if (r103 == r110) goto L6;
            r103 = r103.getNext();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            com.google.common.cache.k<K, V> r112 = removeValueFromChain(r102, r103, r103.getKey(), r111, r103.getValueReference().get(), r103.getValueReference(), RemovalCause.COLLECTED);     // Catch: Throwable -> L13
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

        public void recordLockedRead(com.google.common.cache.k<K, V> r100, long r101) {
            if (this.map.c() == false) goto L5;
            r100.setAccessTime(r101);
        L5:
            this.accessQueue.add(r100);
        }

        public void recordRead(com.google.common.cache.k<K, V> r100, long r101) {
            if (this.map.c() == false) goto L5;
            r100.setAccessTime(r101);
        L5:
            this.recencyQueue.add(r100);
        }

        @CheckForNull
        public V remove(Object r110, int r111) {
            lock();
            preWriteCleanup(this.map.f274784p.a());     // Catch: Throwable -> L25
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r100 = this.table;     // Catch: Throwable -> L25
            int r101 = (r100.length() - 1) & r111;     // Catch: Throwable -> L25
            com.google.common.cache.k<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L25
            com.google.common.cache.k<K, V> r103 = r102;
        L5:
            if (r103 == null) goto L21;
            K r104 = r103.getKey();     // Catch: Throwable -> L25
            if (r103.getHash() != r111) goto L23;
            if (r104 == null) goto L23;
            if (this.map.f274773e.equivalent(r110, r104) == false) goto L23;
            s<K, V> r105 = r103.getValueReference();     // Catch: Throwable -> L25
            V r112 = r105.get();     // Catch: Throwable -> L25
            if (r112 == null) goto L16;
            RemovalCause r106 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L25
        L14:
            RemovalCause r113 = r106;
            this.modCount++;     // Catch: Throwable -> L25
            com.google.common.cache.k<K, V> r114 = removeValueFromChain(r102, r103, r104, r111, r112, r105, r113);     // Catch: Throwable -> L25
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

        @CheckForNull
        public com.google.common.cache.k<K, V> removeEntryFromChain(com.google.common.cache.k<K, V> r100, com.google.common.cache.k<K, V> r101) {
            int r102 = this.count;
            com.google.common.cache.k<K, V> r103 = r101.getNext();
        L3:
            if (r100 == r101) goto L9;
            com.google.common.cache.k<K, V> r104 = copyEntry(r100, r103);
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

        public V get(K r110, int r111, CacheLoader<? super K, V> r112) throws ExecutionException {
            r110.getClass();
            r112.getClass();
        L22:
            e = move-exception;
            Throwable r113 = e.getCause();     // Catch: Throwable -> L20
            if ((r113 instanceof Error) == true) goto L31;
            if ((r113 instanceof RuntimeException) == true) goto L28;
            throw e;     // Catch: Throwable -> L20
        L28:
            throw new UncheckedExecutionException(r113);     // Catch: Throwable -> L20
        L31:
            throw new ExecutionError((Error) r113);     // Catch: Throwable -> L20
        L4:
            if (this.count == 0) goto L17;
            com.google.common.cache.k<K, V> r100 = getEntry(r110, r111);     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r100 == null) goto L17;
            long r101 = this.map.f274784p.a();     // Catch: Throwable -> L20 ExecutionException -> L22
            V r102 = getLiveValue(r100, r101);     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r102 == null) goto L12;
            recordRead(r100, r101);     // Catch: Throwable -> L20 ExecutionException -> L22
            this.statsCounter.a(1);     // Catch: Throwable -> L20 ExecutionException -> L22
            V r114 = scheduleRefresh(r100, r110, r111, r102, r101, r112);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r114;
        L12:
            s<K, V> r103 = r100.getValueReference();     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r103.isLoading() == false) goto L17;
            V r115 = waitForLoadingValue(r100, r110, r103);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r115;
        L17:
            V r116 = lockedGetOrLoad(r110, r111, r112);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r116;
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        @CheckForNull
        public com.google.common.cache.k<K, V> getLiveEntry(Object r100, int r101, long r102) {
            com.google.common.cache.k<K, V> r103 = getEntry(r100, r101);
            if (r103 != null) goto L6;
            return null;
        L6:
            if (this.map.f(r103, r102) == false) goto L9;
            tryExpireEntries(r102);
            return null;
        L9:
            return r103;
        }

        @CheckForNull
        public k<K, V> insertLoadingValueReference(K r100, int r110, boolean r111) {
            lock();
            long r101 = this.map.f274784p.a();     // Catch: Throwable -> L25
            preWriteCleanup(r101);     // Catch: Throwable -> L25
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r102 = this.table;     // Catch: Throwable -> L25
            int r103 = (r102.length() - 1) & r110;     // Catch: Throwable -> L25
            com.google.common.cache.k<K, V> r104 = (com.google.common.cache.k) r102.get(r103);     // Catch: Throwable -> L25
            com.google.common.cache.k r105 = r104;
        L4:
            if (r105 == null) goto L22;
            Object r106 = r105.getKey();     // Catch: Throwable -> L25
            if (r105.getHash() != r110) goto L21;
            if (r106 == null) goto L21;
            if (this.map.f274773e.equivalent(r100, r106) == false) goto L21;
            s<K, V> r107 = r105.getValueReference();     // Catch: Throwable -> L25
            if (r107.isLoading() == true) goto L19;
            if (r111 == true) goto L14;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            k<K, V> r112 = new k(r107);     // Catch: Throwable -> L25
            r105.setValueReference(r112);     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r112;
        L14:
            if ((r101 - r105.getWriteTime()) >= this.map.f274781m) goto L16;
        L19:
            unlock();
            postWriteCleanup();
            return null;
        L21:
            r105 = r105.getNext();     // Catch: Throwable -> L25
            goto L4
        L22:
            this.modCount++;     // Catch: Throwable -> L25
            k<K, V> r113 = new k();     // Catch: Throwable -> L25
            com.google.common.cache.k<K, V> r108 = newEntry(r100, r110, r104);     // Catch: Throwable -> L25
            r108.setValueReference(r113);     // Catch: Throwable -> L25
            r102.set(r103, r108);     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r113;
        L25:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public V lockedGetOrLoad(K r110, int r111, CacheLoader<? super K, V> r210) throws ExecutionException {
            lock();
            long r100 = this.map.f274784p.a();     // Catch: Throwable -> L48
            preWriteCleanup(r100);     // Catch: Throwable -> L48
            int r112 = this.count - 1;     // Catch: Throwable -> L48
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r113 = this.table;     // Catch: Throwable -> L48
            int r114 = r111 & (r113.length() - 1);     // Catch: Throwable -> L48
            com.google.common.cache.k<K, V> r115 = r113.get(r114);     // Catch: Throwable -> L48
            com.google.common.cache.k<K, V> r116 = r115;
        L4:
            k<K, V> r117 = null;
            if (r116 == null) goto L25;
            K r101 = r116.getKey();     // Catch: Throwable -> L48
            if (r116.getHash() != r111) goto L24;
            if (r101 == null) goto L24;
            if (this.map.f274773e.equivalent(r110, r101) == false) goto L24;
            s<K, V> r118 = r116.getValueReference();     // Catch: Throwable -> L48
            if (r118.isLoading() == false) goto L14;
            boolean r102 = false;
            s<K, V> r103 = r118;
        L27:
            if (r102 == false) goto L32;
            r117 = new k();     // Catch: Throwable -> L48
            if (r116 != null) goto L31;
            r116 = newEntry(r110, r111, r115);     // Catch: Throwable -> L48
            r116.setValueReference(r117);     // Catch: Throwable -> L48
            r113.set(r114, r116);     // Catch: Throwable -> L48
            goto L32
        L31:
            r116.setValueReference(r117);     // Catch: Throwable -> L48
        L32:
            unlock();
            postWriteCleanup();
            if (r102 == false) goto L47;
            monitor-enter(r116);     // Catch: Throwable -> L43
            V r104 = loadSync(r110, r111, r117, r210);     // Catch: Throwable -> L40
            monitor-exit(r116);     // Catch: Throwable -> L40
            this.statsCounter.d(1);
            return r104;
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            this.statsCounter.d(1);
            throw th;
        L47:
            return waitForLoadingValue(r116, r110, r103);
        L14:
            V r105 = r118.get();     // Catch: Throwable -> L48
            if (r105 != null) goto L18;
            enqueueNotification(r101, r111, r105, r118.getWeight(), RemovalCause.COLLECTED);     // Catch: Throwable -> L48
        L20:
            this.writeQueue.remove(r116);     // Catch: Throwable -> L48
            this.accessQueue.remove(r116);     // Catch: Throwable -> L48
            this.count = r112;     // Catch: Throwable -> L48
            r103 = r118;
        L26:
            r102 = true;
            goto L27
        L18:
            if (this.map.f(r116, r100) == false) goto L21;
            enqueueNotification(r101, r111, r105, r118.getWeight(), RemovalCause.EXPIRED);     // Catch: Throwable -> L48
            goto L20
        L21:
            recordLockedRead(r116, r100);     // Catch: Throwable -> L48
            this.statsCounter.a(1);     // Catch: Throwable -> L48
            unlock();
            postWriteCleanup();
            return r105;
        L24:
            r116 = r116.getNext();     // Catch: Throwable -> L48
            goto L4
        L25:
            r103 = null;
        L48:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public com.google.common.cache.k<K, V> newEntry(K r100, int r101, @CheckForNull com.google.common.cache.k<K, V> r102) {
            EntryFactory r103 = this.map.f274785q;
            r100.getClass();
            return r103.newEntry(this, r100, r101, r102);
        }

        public boolean reclaimValue(K r110, int r111, s<K, V> r112) {
            lock();
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r100 = this.table;     // Catch: Throwable -> L28
            int r101 = (r100.length() - 1) & r111;     // Catch: Throwable -> L28
            com.google.common.cache.k<K, V> r102 = r100.get(r101);     // Catch: Throwable -> L28
            com.google.common.cache.k<K, V> r103 = r102;
        L5:
            if (r103 == null) goto L24;
            K r104 = r103.getKey();     // Catch: Throwable -> L28
            if (r103.getHash() != r111) goto L22;
            if (r104 == null) goto L22;
            if (this.map.f274773e.equivalent(r110, r104) == false) goto L22;
            if (r103.getValueReference() != r112) goto L18;
            this.modCount++;     // Catch: Throwable -> L28
            com.google.common.cache.k<K, V> r113 = removeValueFromChain(r102, r103, r104, r111, r112.get(), r112, RemovalCause.COLLECTED);     // Catch: Throwable -> L28
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

        public void recordWrite(com.google.common.cache.k<K, V> r100, int r101, long r102) {
            drainRecencyQueue();
            this.totalWeight += (long) r101;
            if (this.map.c() == false) goto L6;
            r100.setAccessTime(r102);
        L6:
            if (this.map.h() == false) goto L8;
            r100.setWriteTime(r102);
        L8:
            this.accessQueue.add(r100);
            this.writeQueue.add(r100);
        }

        public boolean remove(Object r110, int r111, Object r112) {
            lock();
            preWriteCleanup(this.map.f274784p.a());     // Catch: Throwable -> L28
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r100 = this.table;     // Catch: Throwable -> L28
            boolean r101 = true;
            int r102 = (r100.length() - 1) & r111;     // Catch: Throwable -> L28
            com.google.common.cache.k<K, V> r103 = r100.get(r102);     // Catch: Throwable -> L28
            com.google.common.cache.k<K, V> r104 = r103;
        L5:
            if (r104 == null) goto L24;
            K r105 = r104.getKey();     // Catch: Throwable -> L28
            if (r104.getHash() != r111) goto L26;
            if (r105 == null) goto L26;
            if (this.map.f274773e.equivalent(r110, r105) == false) goto L26;
            s<K, V> r113 = r104.getValueReference();     // Catch: Throwable -> L28
            V r106 = r113.get();     // Catch: Throwable -> L28
            if (this.map.f274774f.equivalent(r112, r106) == false) goto L14;
            RemovalCause r114 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L28
        L18:
            this.modCount++;     // Catch: Throwable -> L28
            com.google.common.cache.k<K, V> r115 = removeValueFromChain(r103, r104, r105, r111, r106, r113, r114);     // Catch: Throwable -> L28
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

        public boolean removeEntry(com.google.common.cache.k<K, V> r110, int r111, RemovalCause r112) {
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r100 = this.table;
            int r101 = (r100.length() - 1) & r111;
            com.google.common.cache.k<K, V> r102 = r100.get(r101);
            com.google.common.cache.k<K, V> r103 = r102;
        L3:
            if (r103 == null) goto L8;
            if (r103 == r110) goto L5;
            r103 = r103.getNext();
            goto L3
        L5:
            this.modCount++;
            com.google.common.cache.k<K, V> r113 = removeValueFromChain(r102, r103, r103.getKey(), r111, r103.getValueReference().get(), r103.getValueReference(), r112);
            int r114 = this.count - 1;
            r100.set(r101, r113);
            this.count = r114;
            return true;
        L8:
            return false;
        }

        public boolean removeLoadingValue(K r100, int r110, k<K, V> r111) {
            lock();
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r101 = this.table;     // Catch: Throwable -> L23
            int r102 = (r101.length() - 1) & r110;     // Catch: Throwable -> L23
            com.google.common.cache.k<K, V> r103 = r101.get(r102);     // Catch: Throwable -> L23
            com.google.common.cache.k<K, V> r104 = r103;
        L5:
            if (r104 == null) goto L19;
            K r105 = r104.getKey();     // Catch: Throwable -> L23
            if (r104.getHash() != r110) goto L21;
            if (r105 == null) goto L21;
            if (this.map.f274773e.equivalent(r100, r105) == false) goto L21;
            if (r104.getValueReference() != r111) goto L19;
            if (r111.isActive() == false) goto L16;
            r104.setValueReference(r111.f274820a);     // Catch: Throwable -> L23
        L17:
            unlock();
            postWriteCleanup();
            return true;
        L16:
            r101.set(r102, removeEntryFromChain(r103, r104));     // Catch: Throwable -> L23
        L21:
            r104 = r104.getNext();     // Catch: Throwable -> L23
        L19:
            unlock();
            postWriteCleanup();
            return false;
        L23:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        @CheckForNull
        public V replace(K r110, int r111, V r210) {
            lock();
            long r100 = this.map.f274784p.a();     // Catch: Throwable -> L24
            preWriteCleanup(r100);     // Catch: Throwable -> L24
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r112 = this.table;     // Catch: Throwable -> L24
            int r113 = r111 & (r112.length() - 1);     // Catch: Throwable -> L24
            com.google.common.cache.k<K, V> r101 = r112.get(r113);     // Catch: Throwable -> L24
            com.google.common.cache.k<K, V> r114 = r101;
        L5:
            if (r114 == null) goto L16;
            K r102 = r114.getKey();     // Catch: Throwable -> L24
            if (r114.getHash() != r111) goto L22;
            if (r102 == null) goto L22;
            if (this.map.f274773e.equivalent(r110, r102) == false) goto L22;
            s<K, V> r115 = r114.getValueReference();     // Catch: Throwable -> L24
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
            com.google.common.cache.k<K, V> r103 = removeValueFromChain(r101, r114, r102, r111, r116, r115, RemovalCause.COLLECTED);     // Catch: Throwable -> L24
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

        public V waitForLoadingValue(com.google.common.cache.k<K, V> r100, K r101, s<K, V> r102) throws ExecutionException {
            if (r102.isLoading() == false) goto L16;
            com.google.common.base.m.s(!Thread.holdsLock(r100), "Recursive load of: %s", r101);
            V r103 = r102.b();     // Catch: Throwable -> L12
            if (r103 == null) goto L11;
            recordRead(r100, this.map.f274784p.a());     // Catch: Throwable -> L12
            this.statsCounter.d(1);
            return r103;
        L11:
            throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + r101 + ".");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            this.statsCounter.d(1);
            throw th;
        L16:
            throw new AssertionError();
        }

        public Segment(LocalCache<K, V> r100, int r101, long r102, com.google.common.cache.b r103) {
            this.readCount = new AtomicInteger();
            this.map = r100;
            this.maxSegmentWeight = r102;
            r103.getClass();
            this.statsCounter = r103;
            initTable(newEntryArray(r101));
            Strength r104 = r100.f274775g;
            Strength r105 = Strength.STRONG;
            boolean r106 = true;
            if (r104 == r105) goto L5;
            boolean r107 = true;
        L6:
            ReferenceQueue<V> r108 = null;
            if (r107 == false) goto L9;
            ReferenceQueue<K> r109 = new ReferenceQueue();
        L10:
            this.keyReferenceQueue = r109;
            if (r100.f274776h != r105) goto L14;
            r106 = false;
        L14:
            if (r106 == false) goto L16;
            r108 = new ReferenceQueue();
        L16:
            this.valueReferenceQueue = r108;
            if (r100.j() == false) goto L19;
            Queue<com.google.common.cache.k<K, V>> r110 = new ConcurrentLinkedQueue();
        L20:
            this.recencyQueue = r110;
            if (r100.d() == false) goto L23;
            Queue<com.google.common.cache.k<K, V>> r111 = new c0();
        L24:
            this.writeQueue = r111;
            if (r100.j() == false) goto L27;
            Queue<com.google.common.cache.k<K, V>> r112 = new e();
        L28:
            this.accessQueue = r112;
            return;
        L27:
            r112 = LocalCache.f274768y;
            goto L28
        L23:
            r111 = LocalCache.f274768y;
            goto L24
        L19:
            r110 = LocalCache.f274768y;
            goto L20
        L9:
            r109 = null;
            goto L10
        L5:
            r107 = false;
            goto L6
        }

        public V getAndRecordStats(K r100, int r101, k<K, V> r102, ListenableFuture<V> r103) throws ExecutionException {
            V r104 = (V) Uninterruptibles.getUninterruptibly(r103);
            if (r104 == null) goto L10;
            this.statsCounter.c(r102.f274822c.a(TimeUnit.NANOSECONDS));     // Catch: Throwable -> L7
            storeLoadedValue(r100, r101, r102, r104);     // Catch: Throwable -> L7
            return r104;
        L10:
            throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + r100 + ".");     // Catch: Throwable -> L7
        L7:
            th = th;
        L13:
            if (r104 != null) goto L15;
            this.statsCounter.e(r102.f274822c.a(TimeUnit.NANOSECONDS));
            removeLoadingValue(r100, r101, r102);
        L15:
            throw th;
        L11:
            th = th;
            r104 = null;
            goto L13
        }

        public ListenableFuture<V> loadAsync(final K r100, final int r101, final k<K, V> r110, CacheLoader<? super K, V> r111) {
            final ListenableFuture<V> r112 = r110.d(r100, r111);
            r112.addListener(new com.google.common.cache.i(this, r100, r101, r110, r112), MoreExecutors.directExecutor());
            return r112;
        }

        public V loadSync(K r100, int r101, k<K, V> r102, CacheLoader<? super K, V> r103) throws ExecutionException {
            return getAndRecordStats(r100, r101, r102, r102.d(r100, r103));
        }

        @CheckForNull
        public V put(K r110, int r111, V r112, boolean r113) {
            lock();
            long r100 = this.map.f274784p.a();     // Catch: Throwable -> L31
            preWriteCleanup(r100);     // Catch: Throwable -> L31
            if ((this.count + 1) <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L31
        L6:
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r114 = this.table;     // Catch: Throwable -> L31
            int r115 = r111 & (r114.length() - 1);     // Catch: Throwable -> L31
            com.google.common.cache.k<K, V> r101 = r114.get(r115);     // Catch: Throwable -> L31
            com.google.common.cache.k<K, V> r116 = r101;
        L8:
            if (r116 == null) goto L29;
            K r102 = r116.getKey();     // Catch: Throwable -> L31
            if (r116.getHash() != r111) goto L28;
            if (r102 == null) goto L28;
            if (this.map.f274773e.equivalent(r110, r102) == false) goto L28;
            s<K, V> r103 = r116.getValueReference();     // Catch: Throwable -> L31
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
            com.google.common.cache.k<K, V> r118 = newEntry(r110, r111, r101);     // Catch: Throwable -> L31
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

        @CheckForNull
        public V refresh(K r100, int r101, CacheLoader<? super K, V> r102, boolean r103) {
            k<K, V> r104 = insertLoadingValueReference(r100, r101, r103);
            if (r104 != null) goto L5;
            return null;
        L5:
            ListenableFuture<V> r105 = loadAsync(r100, r101, r104, r102);
            if (r105.isDone() == true) goto L11;
        L9:
            return null;
        L11:
            return (V) Uninterruptibles.getUninterruptibly(r105);
        }

        public boolean replace(K r110, int r111, V r210, V r211) {
            lock();
            long r100 = this.map.f274784p.a();     // Catch: Throwable -> L27
            preWriteCleanup(r100);     // Catch: Throwable -> L27
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r112 = this.table;     // Catch: Throwable -> L27
            int r113 = r111 & (r112.length() - 1);     // Catch: Throwable -> L27
            com.google.common.cache.k<K, V> r101 = r112.get(r113);     // Catch: Throwable -> L27
            com.google.common.cache.k<K, V> r114 = r101;
        L5:
            if (r114 == null) goto L16;
            K r102 = r114.getKey();     // Catch: Throwable -> L27
            if (r114.getHash() != r111) goto L25;
            if (r102 == null) goto L25;
            if (this.map.f274773e.equivalent(r110, r102) == false) goto L25;
            s<K, V> r115 = r114.getValueReference();     // Catch: Throwable -> L27
            V r103 = r115.get();     // Catch: Throwable -> L27
            if (r103 != null) goto L19;
            if (r115.isActive() == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L27
            com.google.common.cache.k<K, V> r104 = removeValueFromChain(r101, r114, r102, r111, r103, r115, RemovalCause.COLLECTED);     // Catch: Throwable -> L27
            int r105 = this.count - 1;     // Catch: Throwable -> L27
            r112.set(r113, r104);     // Catch: Throwable -> L27
            this.count = r105;     // Catch: Throwable -> L27
            goto L16
        L19:
            if (this.map.f274774f.equivalent(r210, r103) == false) goto L23;
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

        public void setValue(com.google.common.cache.k<K, V> r100, K r101, V r102, long r103) {
            s<K, V> r104 = r100.getValueReference();
            int r105 = this.map.f274778j.weigh(r101, r102);
            if (r105 < 0) goto L5;
            boolean r106 = true;
        L6:
            com.google.common.base.m.p(r106, "Weights must be non-negative");
            r100.setValueReference(this.map.f274776h.referenceValue(this, r100, r102, r105));
            recordWrite(r100, r105, r103);
            r104.a(r102);
            return;
        L5:
            r106 = false;
            goto L6
        }

        public boolean storeLoadedValue(K r110, int r111, k<K, V> r112, V r113) {
            lock();
            long r100 = this.map.f274784p.a();     // Catch: Throwable -> L33
            preWriteCleanup(r100);     // Catch: Throwable -> L33
            int r101 = this.count + 1;     // Catch: Throwable -> L33
            if (r101 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L33
            r101 = this.count + 1;     // Catch: Throwable -> L33
        L6:
            int r114 = r101;
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r115 = this.table;     // Catch: Throwable -> L33
            int r116 = r111 & (r115.length() - 1);     // Catch: Throwable -> L33
            com.google.common.cache.k<K, V> r102 = r115.get(r116);     // Catch: Throwable -> L33
            com.google.common.cache.k<K, V> r117 = r102;
        L7:
            if (r117 == null) goto L30;
            K r103 = r117.getKey();     // Catch: Throwable -> L33
            if (r117.getHash() != r111) goto L29;
            if (r103 == null) goto L29;
            if (this.map.f274773e.equivalent(r110, r103) == false) goto L29;
            s<K, V> r104 = r117.getValueReference();     // Catch: Throwable -> L33
            V r105 = r104.get();     // Catch: Throwable -> L33
            if (r112 == r104) goto L22;
            if (r105 == null) goto L17;
        L19:
            enqueueNotification(r110, r111, r113, 0, RemovalCause.REPLACED);     // Catch: Throwable -> L33
            unlock();
            postWriteCleanup();
            return false;
        L17:
            if (r104 == LocalCache.f274767x) goto L19;
        L22:
            this.modCount++;     // Catch: Throwable -> L33
            if (r112.isActive() == false) goto L28;
            if (r105 != null) goto L26;
            RemovalCause r106 = RemovalCause.COLLECTED;     // Catch: Throwable -> L33
        L27:
            enqueueNotification(r110, r111, r105, r112.getWeight(), r106);     // Catch: Throwable -> L33
            r114 = r114 - 1;     // Catch: Throwable -> L33
            goto L28
        L26:
            r106 = RemovalCause.REPLACED;     // Catch: Throwable -> L33
        L28:
            setValue(r117, r110, r113, r100);     // Catch: Throwable -> L33
            this.count = r114;     // Catch: Throwable -> L33
            evictEntries(r117);     // Catch: Throwable -> L33
        L31:
            unlock();
            postWriteCleanup();
            return true;
        L29:
            r117 = r117.getNext();     // Catch: Throwable -> L33
            goto L7
        L30:
            this.modCount++;     // Catch: Throwable -> L33
            com.google.common.cache.k<K, V> r118 = newEntry(r110, r111, r102);     // Catch: Throwable -> L33
            setValue(r118, r110, r113, r100);     // Catch: Throwable -> L33
            r115.set(r116, r118);     // Catch: Throwable -> L33
            this.count = r114;     // Catch: Throwable -> L33
            evictEntries(r118);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public void enqueueNotification(@CheckForNull K r100, int r101, @CheckForNull V r102, int r103, RemovalCause r104) {
            this.totalWeight -= (long) r103;
            if (r104.wasEvicted() == false) goto L6;
            this.statsCounter.b();
        L6:
            if (this.map.f274782n == LocalCache.f274768y) goto L9;
            this.map.f274782n.offer(RemovalNotification.create(r100, r102, r104));
            return;
        }

        public V scheduleRefresh(com.google.common.cache.k<K, V> r100, K r101, int r102, V r110, long r111, CacheLoader<? super K, V> r112) {
            if (this.map.f274781m <= 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == true) goto L8;
        L14:
            return r110;
        L8:
            if ((r111 - r100.getWriteTime()) <= this.map.f274781m) goto L14;
            if (r100.getValueReference().isLoading() == true) goto L14;
            V r104 = refresh(r101, r102, r112, true);
            if (r104 == null) goto L14;
            return r104;
        L5:
            r103 = false;
            goto L6
        }

        @CheckForNull
        public com.google.common.cache.k<K, V> removeValueFromChain(com.google.common.cache.k<K, V> r100, com.google.common.cache.k<K, V> r101, @CheckForNull K r102, int r110, V r111, s<K, V> r112, RemovalCause r113) {
            enqueueNotification(r102, r110, r111, r112.getWeight(), r113);
            this.writeQueue.remove(r101);
            this.accessQueue.remove(r101);
            if (r112.isLoading() == false) goto L7;
            r112.a(null);
            return r100;
        L7:
            return removeEntryFromChain(r100, r101);
        }
    }

    public static abstract enum Strength extends Enum<Strength> {
        public static final Strength SOFT = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Strength[] f274795a = null;

        public Strength() {
            throw null;
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> s<K, V> referenceValue(Segment<K, V> r100, com.google.common.cache.k<K, V> r101, V r102, int r103);

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
            f274795a = new Strength[]{r102, r105, r108};
        }

        public static Strength[] values() {
            return (Strength[]) f274795a.clone();
        }

        public static Strength valueOf(String r100) {
            return (Strength) r27.a.a(Strength.class, r100);
        }

        public Strength(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public class a implements s<Object, Object> {
        public a() {
        }

        @Override // com.google.common.cache.LocalCache.s
        public final void a(Object r100) {
        }

        @Override // com.google.common.cache.LocalCache.s
        @CheckForNull
        public final Object b() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final s<Object, Object> c(ReferenceQueue<Object> r100, @CheckForNull Object r101, com.google.common.cache.k<Object, Object> r102) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        @CheckForNull
        public final Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        @CheckForNull
        public final com.google.common.cache.k<Object, Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isLoading() {
            return false;
        }
    }

    public static final class a0<K, V> extends p<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274796b;

        @Override // com.google.common.cache.LocalCache.p, com.google.common.cache.LocalCache.s
        public final int getWeight() {
            return this.f274796b;
        }

        public a0(V r100, int r101) {
            super(r100);
            this.f274796b = r101;
        }
    }

    public class b extends AbstractQueue<Object> {
        @Override // java.util.Queue
        public final boolean offer(Object r100) {
            return true;
        }

        @Override // java.util.Queue
        @CheckForNull
        public final Object peek() {
            return null;
        }

        @Override // java.util.Queue
        @CheckForNull
        public final Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        public b() {
        }
    }

    public static final class b0<K, V> extends x<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274797b;

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public final int getWeight() {
            return this.f274797b;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public final s<K, V> c(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102) {
            return new b0(r100, r101, r102, this.f274797b);
        }

        public b0(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102, int r103) {
            super(r100, r101, r102);
            this.f274797b = r103;
        }
    }

    public abstract class c<T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalCache f274798a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f274798a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return this.f274798a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f274798a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        public c(LocalCache r100) {
            this.f274798a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final <E> E[] toArray(E[] r100) {
            return (E[]) LocalCache.a(this).toArray(r100);
        }
    }

    public static final class c0<K, V> extends AbstractQueue<com.google.common.cache.k<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f274799a;

        public class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.google.common.cache.k<K, V> f274800a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public com.google.common.cache.k<K, V> f274801b;

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final void setWriteTime(long r100) {
            }

            public a() {
                this.f274800a = this;
                this.f274801b = this;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final com.google.common.cache.k<K, V> getNextInWriteQueue() {
                return this.f274800a;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
                return this.f274801b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final void setNextInWriteQueue(com.google.common.cache.k<K, V> r100) {
                this.f274800a = r100;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final void setPreviousInWriteQueue(com.google.common.cache.k<K, V> r100) {
                this.f274801b = r100;
            }
        }

        public class b extends com.google.common.collect.g<com.google.common.cache.k<K, V>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c0 f274802b;

            @Override // com.google.common.collect.g
            @CheckForNull
            public final Object a(Object r100) {
                com.google.common.cache.k<K, V> r101 = ((com.google.common.cache.k) r100).getNextInWriteQueue();
                if (r101 != this.f274802b.f274799a) goto L6;
                return null;
            L6:
                return r101;
            }

            public b(c0 r100, com.google.common.cache.k r101) {
                this.f274802b = r100;
                super(r101);
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            com.google.common.cache.k<K, V> r100 = this.f274799a.f274800a;
        L3:
            a r101 = this.f274799a;
            if (r100 == r101) goto L6;
            com.google.common.cache.k<K, V> r102 = r100.getNextInWriteQueue();
            Logger r103 = LocalCache.f274766w;
            NullEntry r104 = NullEntry.INSTANCE;
            r100.setNextInWriteQueue(r104);
            r100.setPreviousInWriteQueue(r104);
            r100 = r102;
            goto L3
        L6:
            r101.f274800a = r101;
            r101.f274801b = r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            a r100 = this.f274799a;
            if (r100.f274800a != r100) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<com.google.common.cache.k<K, V>> iterator() {
            a r100 = this.f274799a;
            com.google.common.cache.k<K, V> r101 = r100.f274800a;
            if (r101 != r100) goto L6;
            r101 = null;
        L6:
            return new b(this, r101);
        }

        @Override // java.util.Queue
        @CheckForNull
        public final Object peek() {
            a r100 = this.f274799a;
            com.google.common.cache.k<K, V> r101 = r100.f274800a;
            if (r101 != r100) goto L6;
            return null;
        L6:
            return r101;
        }

        @Override // java.util.Queue
        @CheckForNull
        public final Object poll() {
            a r100 = this.f274799a;
            com.google.common.cache.k<K, V> r101 = r100.f274800a;
            if (r101 != r100) goto L5;
            return null;
        L5:
            remove(r101);
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            com.google.common.cache.k<K, V> r100 = this.f274799a.f274800a;
            int r101 = 0;
        L4:
            if (r100 == this.f274799a) goto L6;
            r101 = r101 + 1;
            r100 = r100.getNextInWriteQueue();
            goto L4
        L6:
            return r101;
        }

        public c0() {
            this.f274799a = new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object r100) {
            if (((com.google.common.cache.k) r100).getNextInWriteQueue() == NullEntry.INSTANCE) goto L5;
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
            com.google.common.cache.k<K, V> r101 = (com.google.common.cache.k) r100;
            com.google.common.cache.k<K, V> r102 = r101.getPreviousInWriteQueue();
            com.google.common.cache.k<K, V> r103 = r101.getNextInWriteQueue();
            Logger r104 = LocalCache.f274766w;
            r102.setNextInWriteQueue(r103);
            r103.setPreviousInWriteQueue(r102);
            com.google.common.cache.k<K, V> r105 = this.f274799a.f274801b;
            r105.setNextInWriteQueue(r101);
            r101.setPreviousInWriteQueue(r105);
            a r106 = this.f274799a;
            r101.setNextInWriteQueue(r106);
            r106.f274801b = r101;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object r100) {
            com.google.common.cache.k r101 = (com.google.common.cache.k) r100;
            com.google.common.cache.k<K, V> r102 = r101.getPreviousInWriteQueue();
            com.google.common.cache.k<K, V> r103 = r101.getNextInWriteQueue();
            Logger r104 = LocalCache.f274766w;
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

    public static abstract class d<K, V> implements com.google.common.cache.k<K, V> {
        public d() {
        }

        @Override // com.google.common.cache.k
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public s<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public void setAccessTime(long r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public void setNextInAccessQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public void setNextInWriteQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public void setValueReference(s<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public void setWriteTime(long r100) {
            throw new UnsupportedOperationException();
        }
    }

    public final class d0 implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f274803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f274804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LocalCache f274805c;

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.f274803a.hashCode() ^ this.f274804b.hashCode();
        }

        public final String toString() {
            return this.f274803a + ContainerUtils.KEY_VALUE_DELIMITER + this.f274804b;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f274803a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f274804b;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            if (this.f274803a.equals(r101.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.f274804b.equals(r101.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r100) {
            V r101 = (V) this.f274805c.put(this.f274803a, r100);
            this.f274804b = r100;
            return r101;
        }

        public d0(LocalCache r100, K r101, V r102) {
            this.f274805c = r100;
            this.f274803a = r101;
            this.f274804b = r102;
        }
    }

    public static final class e<K, V> extends AbstractQueue<com.google.common.cache.k<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f274806a;

        public class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.google.common.cache.k<K, V> f274807a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public com.google.common.cache.k<K, V> f274808b;

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final void setAccessTime(long r100) {
            }

            public a() {
                this.f274807a = this;
                this.f274808b = this;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final com.google.common.cache.k<K, V> getNextInAccessQueue() {
                return this.f274807a;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
                return this.f274808b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final void setNextInAccessQueue(com.google.common.cache.k<K, V> r100) {
                this.f274807a = r100;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
            public final void setPreviousInAccessQueue(com.google.common.cache.k<K, V> r100) {
                this.f274808b = r100;
            }
        }

        public class b extends com.google.common.collect.g<com.google.common.cache.k<K, V>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f274809b;

            @Override // com.google.common.collect.g
            @CheckForNull
            public final Object a(Object r100) {
                com.google.common.cache.k<K, V> r101 = ((com.google.common.cache.k) r100).getNextInAccessQueue();
                if (r101 != this.f274809b.f274806a) goto L6;
                return null;
            L6:
                return r101;
            }

            public b(e r100, com.google.common.cache.k r101) {
                this.f274809b = r100;
                super(r101);
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            com.google.common.cache.k<K, V> r100 = this.f274806a.f274807a;
        L3:
            a r101 = this.f274806a;
            if (r100 == r101) goto L6;
            com.google.common.cache.k<K, V> r102 = r100.getNextInAccessQueue();
            Logger r103 = LocalCache.f274766w;
            NullEntry r104 = NullEntry.INSTANCE;
            r100.setNextInAccessQueue(r104);
            r100.setPreviousInAccessQueue(r104);
            r100 = r102;
            goto L3
        L6:
            r101.f274807a = r101;
            r101.f274808b = r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            a r100 = this.f274806a;
            if (r100.f274807a != r100) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<com.google.common.cache.k<K, V>> iterator() {
            a r100 = this.f274806a;
            com.google.common.cache.k<K, V> r101 = r100.f274807a;
            if (r101 != r100) goto L6;
            r101 = null;
        L6:
            return new b(this, r101);
        }

        @Override // java.util.Queue
        @CheckForNull
        public final Object peek() {
            a r100 = this.f274806a;
            com.google.common.cache.k<K, V> r101 = r100.f274807a;
            if (r101 != r100) goto L6;
            return null;
        L6:
            return r101;
        }

        @Override // java.util.Queue
        @CheckForNull
        public final Object poll() {
            a r100 = this.f274806a;
            com.google.common.cache.k<K, V> r101 = r100.f274807a;
            if (r101 != r100) goto L5;
            return null;
        L5:
            remove(r101);
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            com.google.common.cache.k<K, V> r100 = this.f274806a.f274807a;
            int r101 = 0;
        L4:
            if (r100 == this.f274806a) goto L6;
            r101 = r101 + 1;
            r100 = r100.getNextInAccessQueue();
            goto L4
        L6:
            return r101;
        }

        public e() {
            this.f274806a = new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object r100) {
            if (((com.google.common.cache.k) r100).getNextInAccessQueue() == NullEntry.INSTANCE) goto L5;
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
            com.google.common.cache.k<K, V> r101 = (com.google.common.cache.k) r100;
            com.google.common.cache.k<K, V> r102 = r101.getPreviousInAccessQueue();
            com.google.common.cache.k<K, V> r103 = r101.getNextInAccessQueue();
            Logger r104 = LocalCache.f274766w;
            r102.setNextInAccessQueue(r103);
            r103.setPreviousInAccessQueue(r102);
            com.google.common.cache.k<K, V> r105 = this.f274806a.f274808b;
            r105.setNextInAccessQueue(r101);
            r101.setPreviousInAccessQueue(r105);
            a r106 = this.f274806a;
            r101.setNextInAccessQueue(r106);
            r106.f274808b = r101;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object r100) {
            com.google.common.cache.k r101 = (com.google.common.cache.k) r100;
            com.google.common.cache.k<K, V> r102 = r101.getPreviousInAccessQueue();
            com.google.common.cache.k<K, V> r103 = r101.getNextInAccessQueue();
            Logger r104 = LocalCache.f274766w;
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

    public final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        @Override // java.util.Iterator
        public final Object next() {
            return c();
        }

        public f(LocalCache r100) {
            super(r100);
        }
    }

    public final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalCache f274810b;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new f(this.f274810b);
        }

        public g(LocalCache r100) {
            this.f274810b = r100;
            super(r100);
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
            Object r103 = this.f274810b.get(r102);
            if (r103 != null) goto L11;
            return false;
        L11:
            if (this.f274810b.f274774f.equivalent(r101.getValue(), r103) == false) goto L15;
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
            if (this.f274810b.remove(r102, r101.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public abstract class h<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public Segment<K, V> f274813c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @CheckForNull
        public AtomicReferenceArray<com.google.common.cache.k<K, V>> f274814d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @CheckForNull
        public com.google.common.cache.k<K, V> f274815e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @CheckForNull
        public LocalCache<K, V>.d0 f274816f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @CheckForNull
        public LocalCache<K, V>.d0 f274817g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ LocalCache f274818h;

        public final void a() {
            this.f274816f = null;
            com.google.common.cache.k<K, V> r100 = this.f274815e;
            if (r100 == null) goto L10;
        L4:
            com.google.common.cache.k<K, V> r101 = r100.getNext();
            this.f274815e = r101;
            if (r101 == null) goto L10;
            if (b(r101) == true) goto L8;
            r100 = this.f274815e;
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
            int r103 = this.f274811a;
            if (r103 < 0) goto L22;
            Segment<K, V>[] r104 = this.f274818h.f274771c;
            this.f274811a = r103 - 1;
            Segment<K, V> r105 = r104[r103];
            this.f274813c = r105;
            if (r105.count == 0) goto L16;
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r106 = this.f274813c.table;
            this.f274814d = r106;
            this.f274812b = r106.length() - 1;
            if (d() == false) goto L16;
            return;
        L22:
            return;
        L10:
            r102 = false;
            goto L11
        }

        public final LocalCache<K, V>.d0 c() {
            LocalCache<K, V>.d0 r100 = this.f274816f;
            if (r100 == null) goto L7;
            this.f274817g = r100;
            a();
            return this.f274817g;
        L7:
            throw new NoSuchElementException();
        }

        public final boolean d() {
        L2:
            int r100 = this.f274812b;
            boolean r101 = false;
            if (r100 < 0) goto L18;
            AtomicReferenceArray<com.google.common.cache.k<K, V>> r102 = this.f274814d;
            this.f274812b = r100 - 1;
            com.google.common.cache.k<K, V> r103 = r102.get(r100);
            this.f274815e = r103;
            if (r103 == null) goto L2;
            if (b(r103) == true) goto L17;
            com.google.common.cache.k<K, V> r104 = this.f274815e;
            if (r104 == null) goto L16;
        L10:
            com.google.common.cache.k<K, V> r105 = r104.getNext();
            this.f274815e = r105;
            if (r105 == null) goto L16;
            if (b(r105) == true) goto L14;
            r104 = this.f274815e;
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
            if (this.f274816f == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f274817g == null) goto L5;
            boolean r100 = true;
        L6:
            com.google.common.base.m.o(r100);
            this.f274818h.remove(this.f274817g.f274803a);
            this.f274817g = null;
            return;
        L5:
            r100 = false;
            goto L6
        }

        public h(LocalCache r100) {
            this.f274818h = r100;
            this.f274811a = r100.f274771c.length - 1;
            this.f274812b = -1;
            a();
        }

        public final boolean b(com.google.common.cache.k<K, V> r100) {
            long r101 = this.f274818h.f274784p.a();     // Catch: Throwable -> L18
            K r102 = r100.getKey();     // Catch: Throwable -> L18
            LocalCache r103 = this.f274818h;     // Catch: Throwable -> L18
            r103.getClass();     // Catch: Throwable -> L18
            V r104 = null;
            if (r100.getKey() == null) goto L12;
            V r105 = r100.getValueReference().get();     // Catch: Throwable -> L18
            if (r105 == null) goto L12;
            if (r103.f(r100, r101) == true) goto L12;
            r104 = r105;
        L12:
            if (r104 == null) goto L16;
            this.f274816f = new d0(this.f274818h, r102, r104);     // Catch: Throwable -> L18
            this.f274813c.postReadCleanup();
            return true;
        L16:
            this.f274813c.postReadCleanup();
            return false;
        L18:
            th = move-exception;
            this.f274813c.postReadCleanup();
            throw th;
        }
    }

    public final class i extends LocalCache<K, V>.h<K> {
        @Override // java.util.Iterator
        public final K next() {
            return c().f274803a;
        }

        public i(LocalCache r100) {
            super(r100);
        }
    }

    public final class j extends LocalCache<K, V>.c<K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalCache f274819b;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new i(this.f274819b);
        }

        public j(LocalCache r100) {
            this.f274819b = r100;
            super(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r100) {
            return this.f274819b.containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r100) {
            if (this.f274819b.remove(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static class k<K, V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile s<K, V> f274820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SettableFuture<V> f274821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.common.base.r f274822c;

        @Override // com.google.common.cache.LocalCache.s
        public final s<K, V> c(ReferenceQueue<V> r100, @CheckForNull V r101, com.google.common.cache.k<K, V> r102) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final com.google.common.cache.k<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isLoading() {
            return true;
        }

        public k() {
            this(LocalCache.f274767x);
        }

        @Override // com.google.common.cache.LocalCache.s
        public final V b() throws ExecutionException {
            return (V) Uninterruptibles.getUninterruptibly(this.f274821b);
        }

        @Override // com.google.common.cache.LocalCache.s
        public final V get() {
            return this.f274820a.get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public final int getWeight() {
            return this.f274820a.getWeight();
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isActive() {
            return this.f274820a.isActive();
        }

        public k(s<K, V> r100) {
            this.f274821b = SettableFuture.create();
            this.f274822c = new com.google.common.base.r();
            this.f274820a = r100;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final void a(@CheckForNull V r100) {
            if (r100 == null) goto L4;
            this.f274821b.set(r100);
            return;
        L4:
            this.f274820a = LocalCache.f274767x;
        }

        public final ListenableFuture<V> d(K r100, CacheLoader<? super K, V> r101) {
            com.google.common.base.r r102 = this.f274822c;     // Catch: Throwable -> L9
            com.google.common.base.m.p(!r102.f274736b, "This stopwatch is already running.");     // Catch: Throwable -> L9
            r102.f274736b = true;     // Catch: Throwable -> L9
            r102.f274735a.getClass();     // Catch: Throwable -> L9
            r102.f274738d = System.nanoTime();     // Catch: Throwable -> L9
            V r103 = this.f274820a.get();     // Catch: Throwable -> L9
            if (r103 != null) goto L11;
            V r104 = r101.load(r100);     // Catch: Throwable -> L9
            if (this.f274821b.set(r104) == false) goto L8;
            return this.f274821b;
        L8:
            return Futures.immediateFuture(r104);
        L11:
            ListenableFuture<V> r105 = r101.reload(r100, r103);     // Catch: Throwable -> L9
            if (r105 != null) goto L16;
            return Futures.immediateFuture(null);
        L16:
            return Futures.transform(r105, new com.google.common.cache.h(this), MoreExecutors.directExecutor());
        L9:
            th = move-exception;
            if (this.f274821b.setException(th) == false) goto L20;
            ListenableFuture<V> r106 = this.f274821b;
        L22:
            if ((th instanceof InterruptedException) == false) goto L24;
            ThreadMethodProxy.currentThread().interrupt();
        L24:
            return r106;
        L20:
            r106 = Futures.immediateFailedFuture(th);
            goto L22
        }
    }

    public static class l<K, V> extends SoftReference<V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.common.cache.k<K, V> f274823a;

        @Override // com.google.common.cache.LocalCache.s
        public final void a(V r100) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final V b() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public final com.google.common.cache.k<K, V> getEntry() {
            return this.f274823a;
        }

        public l(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102) {
            super(r101, r100);
            this.f274823a = r102;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> c(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102) {
            return new l(r100, r101, r102);
        }
    }

    public static final class m<K, V> extends o<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f274824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274826g;

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final long getAccessTime() {
            return this.f274824e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f274825f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f274826g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setAccessTime(long r100) {
            this.f274824e = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setNextInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274825f = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setPreviousInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274826g = r100;
        }

        public m(K r100, int r101, @CheckForNull com.google.common.cache.k<K, V> r102) {
            super(r100, r101, r102);
            this.f274824e = Long.MAX_VALUE;
            NullEntry r103 = NullEntry.INSTANCE;
            this.f274825f = r103;
            this.f274826g = r103;
        }
    }

    public static final class n<K, V> extends o<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f274827e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274828f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274829g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile long f274830h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274831i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274832j;

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final long getAccessTime() {
            return this.f274827e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f274828f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f274831i;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f274829g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f274832j;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final long getWriteTime() {
            return this.f274830h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setAccessTime(long r100) {
            this.f274827e = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setNextInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274828f = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setNextInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274831i = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setPreviousInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274829g = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setPreviousInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274832j = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setWriteTime(long r100) {
            this.f274830h = r100;
        }

        public n(K r100, int r101, @CheckForNull com.google.common.cache.k<K, V> r102) {
            super(r100, r101, r102);
            this.f274827e = Long.MAX_VALUE;
            NullEntry r103 = NullEntry.INSTANCE;
            this.f274828f = r103;
            this.f274829g = r103;
            this.f274830h = Long.MAX_VALUE;
            this.f274831i = r103;
            this.f274832j = r103;
        }
    }

    public static class o<K, V> extends d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f274833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public final com.google.common.cache.k<K, V> f274835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile s<K, V> f274836d;

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final int getHash() {
            return this.f274834b;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final K getKey() {
            return this.f274833a;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNext() {
            return this.f274835c;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final s<K, V> getValueReference() {
            return this.f274836d;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setValueReference(s<K, V> r100) {
            this.f274836d = r100;
        }

        public o(K r100, int r101, @CheckForNull com.google.common.cache.k<K, V> r102) {
            this.f274836d = LocalCache.f274767x;
            this.f274833a = r100;
            this.f274834b = r101;
            this.f274835c = r102;
        }
    }

    public static class p<K, V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f274837a;

        @Override // com.google.common.cache.LocalCache.s
        public final void a(V r100) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public final s<K, V> c(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final com.google.common.cache.k<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final V b() {
            return this.f274837a;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final V get() {
            return this.f274837a;
        }

        public p(V r100) {
            this.f274837a = r100;
        }
    }

    public static final class q<K, V> extends o<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f274838e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274840g;

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f274839f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f274840g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final long getWriteTime() {
            return this.f274838e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setNextInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274839f = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setPreviousInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274840g = r100;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.k
        public final void setWriteTime(long r100) {
            this.f274838e = r100;
        }

        public q(K r100, int r101, @CheckForNull com.google.common.cache.k<K, V> r102) {
            super(r100, r101, r102);
            this.f274838e = Long.MAX_VALUE;
            NullEntry r103 = NullEntry.INSTANCE;
            this.f274839f = r103;
            this.f274840g = r103;
        }
    }

    public final class r extends LocalCache<K, V>.h<V> {
        @Override // java.util.Iterator
        public final V next() {
            return c().f274804b;
        }

        public r(LocalCache r100) {
            super(r100);
        }
    }

    public interface s<K, V> {
        void a(@CheckForNull V r100);

        V b() throws ExecutionException;

        s<K, V> c(ReferenceQueue<V> r100, @CheckForNull V r101, com.google.common.cache.k<K, V> r102);

        @CheckForNull
        V get();

        @CheckForNull
        com.google.common.cache.k<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();
    }

    public final class t extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalCache f274841a;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f274841a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return this.f274841a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new r(this.f274841a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f274841a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        public t(LocalCache r100) {
            this.f274841a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object r100) {
            return this.f274841a.containsValue(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final <E> E[] toArray(E[] r100) {
            return (E[]) LocalCache.a(this).toArray(r100);
        }
    }

    public static final class u<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f274842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274844f;

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final long getAccessTime() {
            return this.f274842d;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f274843e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f274844f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setAccessTime(long r100) {
            this.f274842d = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setNextInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274843e = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setPreviousInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274844f = r100;
        }

        public u(ReferenceQueue<K> r100, K r101, int r102, @CheckForNull com.google.common.cache.k<K, V> r103) {
            super(r100, r101, r102, r103);
            this.f274842d = Long.MAX_VALUE;
            NullEntry r104 = NullEntry.INSTANCE;
            this.f274843e = r104;
            this.f274844f = r104;
        }
    }

    public static final class v<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f274845d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274846e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274847f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile long f274848g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274849h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274850i;

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final long getAccessTime() {
            return this.f274845d;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f274846e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f274849h;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f274847f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f274850i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final long getWriteTime() {
            return this.f274848g;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setAccessTime(long r100) {
            this.f274845d = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setNextInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274846e = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setNextInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274849h = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setPreviousInAccessQueue(com.google.common.cache.k<K, V> r100) {
            this.f274847f = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setPreviousInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274850i = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setWriteTime(long r100) {
            this.f274848g = r100;
        }

        public v(ReferenceQueue<K> r100, K r101, int r102, @CheckForNull com.google.common.cache.k<K, V> r103) {
            super(r100, r101, r102, r103);
            this.f274845d = Long.MAX_VALUE;
            NullEntry r104 = NullEntry.INSTANCE;
            this.f274846e = r104;
            this.f274847f = r104;
            this.f274848g = Long.MAX_VALUE;
            this.f274849h = r104;
            this.f274850i = r104;
        }
    }

    public static class w<K, V> extends WeakReference<K> implements com.google.common.cache.k<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f274851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public final com.google.common.cache.k<K, V> f274852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile s<K, V> f274853c;

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.k<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.k<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public final K getKey() {
            return get();
        }

        @Override // com.google.common.cache.k
        public final int getHash() {
            return this.f274851a;
        }

        @Override // com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNext() {
            return this.f274852b;
        }

        @Override // com.google.common.cache.k
        public final s<K, V> getValueReference() {
            return this.f274853c;
        }

        public void setAccessTime(long r100) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(com.google.common.cache.k<K, V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.k
        public final void setValueReference(s<K, V> r100) {
            this.f274853c = r100;
        }

        public void setWriteTime(long r100) {
            throw new UnsupportedOperationException();
        }

        public w(ReferenceQueue<K> r100, K r101, int r102, @CheckForNull com.google.common.cache.k<K, V> r103) {
            super(r101, r100);
            this.f274853c = LocalCache.f274767x;
            this.f274851a = r102;
            this.f274852b = r103;
        }
    }

    public static class x<K, V> extends WeakReference<V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.common.cache.k<K, V> f274854a;

        @Override // com.google.common.cache.LocalCache.s
        public final void a(V r100) {
        }

        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public final V b() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public final com.google.common.cache.k<K, V> getEntry() {
            return this.f274854a;
        }

        public x(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102) {
            super(r101, r100);
            this.f274854a = r102;
        }

        public s<K, V> c(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102) {
            return new x(r100, r101, r102);
        }
    }

    public static final class y<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f274855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274856e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.cache.k<K, V> f274857f;

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f274856e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f274857f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final long getWriteTime() {
            return this.f274855d;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setNextInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274856e = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setPreviousInWriteQueue(com.google.common.cache.k<K, V> r100) {
            this.f274857f = r100;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.k
        public final void setWriteTime(long r100) {
            this.f274855d = r100;
        }

        public y(ReferenceQueue<K> r100, K r101, int r102, @CheckForNull com.google.common.cache.k<K, V> r103) {
            super(r100, r101, r102, r103);
            this.f274855d = Long.MAX_VALUE;
            NullEntry r104 = NullEntry.INSTANCE;
            this.f274856e = r104;
            this.f274857f = r104;
        }
    }

    public static final class z<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274858b;

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public final int getWeight() {
            return this.f274858b;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public final s<K, V> c(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102) {
            return new z(r100, r101, r102, this.f274858b);
        }

        public z(ReferenceQueue<V> r100, V r101, com.google.common.cache.k<K, V> r102, int r103) {
            super(r100, r101, r102);
            this.f274858b = r103;
        }
    }

    static {
        f274766w = Logger.getLogger(LocalCache.class.getName());
        f274767x = new a();
        f274768y = new b();
    }

    public final boolean b() {
        if (this.f274777i < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        if (this.f274779k <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Segment<K, V>[] r100 = this.f274771c;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].clear();
        r102 = r102 + 1;
        goto L3
    }

    public final boolean d() {
        if (this.f274780l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        g r100 = this.f274790v;
        if (r100 != null) goto L7;
        g r101 = new g(this);
        this.f274790v = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        Segment<K, V>[] r100 = this.f274771c;
        int r101 = r100.length;
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L9;
        Segment<K, V> r104 = r100[r103];
        if (r104.count != 0) goto L6;
        r102 = r102 + ((long) r104.modCount);
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L9:
        if (r102 == 0) goto L20;
        int r105 = r100.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L17;
        Segment<K, V> r107 = r100[r106];
        if (r107.count != 0) goto L14;
        r102 = r102 - ((long) r107.modCount);
        r106 = r106 + 1;
        goto L11
    L14:
        return false;
    L17:
        if (r102 != 0) goto L25;
        return true;
    L25:
        return false;
    L20:
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        j r100 = this.f274788t;
        if (r100 != null) goto L7;
        j r101 = new j(this);
        this.f274788t = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Segment<K, V>[] r100 = this.f274771c;
        int r101 = r100.length;
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        r102 = r102 + ((long) Math.max(0, r100[r103].count));
        r103 = r103 + 1;
        goto L3
    L6:
        return Ints.c(r102);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        t r100 = this.f274789u;
        if (r100 != null) goto L7;
        t r101 = new t(this);
        this.f274789u = r101;
        return r101;
    L7:
        return r100;
    }

    public final boolean h() {
        if (d() == false) goto L5;
        return true;
    L5:
        if (this.f274781m <= 0) goto L7;
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

    public final boolean j() {
        if (c() == false) goto L5;
    L8:
        return true;
    L5:
        if (b() == true) goto L8;
        return false;
    }

    public static ArrayList a(Collection r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterators.a(r101, r100.iterator());
        return r101;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = e(r100);
        return i(r101).containsKey(r100, r101);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object r210) {
        if (r210 != null) goto L5;
        return false;
    L5:
        long r100 = this.f274784p.a();
        Segment<K, V>[] r101 = this.f274771c;
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
        AtomicReferenceArray<com.google.common.cache.k<K, V>> r114 = r112.table;
        int r115 = 0;
    L12:
        if (r115 >= r114.length()) goto L23;
        com.google.common.cache.k<K, V> r105 = r114.get(r115);
    L14:
        if (r105 == null) goto L22;
        Segment<K, V>[] r116 = r101;
        V r106 = r112.getLiveValue(r105, r100);
        long r117 = r100;
        if (r106 == null) goto L21;
        if (this.f274774f.equivalent(r210, r106) == false) goto L21;
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

    public final int e(@CheckForNull Object r100) {
        int r101 = this.f274773e.hash(r100);
        int r102 = r101 + ((r101 << 15) ^ (-12931));
        int r103 = r102 ^ (r102 >>> 10);
        int r104 = r103 + (r103 << 3);
        int r105 = r104 ^ (r104 >>> 6);
        int r106 = r105 + ((r105 << 2) + (r105 << 14));
        return r106 ^ (r106 >>> 16);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final V get(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = e(r100);
        return i(r101).get(r100, r101);
    }

    public final Segment<K, V> i(int r100) {
        return this.f274771c[(r100 >>> this.f274770b) & this.f274769a];
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
    @CheckForNull
    public final V remove(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = e(r100);
        return i(r101).remove(r100, r101);
    }

    public LocalCache(CacheBuilder<? super K, ? super V> r110, @CheckForNull CacheLoader<? super K, V> r210) {
        int r100 = r110.f274748c;
        if (r100 != (-1)) goto L5;
        r100 = 4;
    L5:
        this.f274772d = Math.min(r100, 65536);
        Strength r101 = r110.f274752g;
        Strength r102 = Strength.STRONG;
        Strength r103 = (Strength) com.google.common.base.j.a(r101, r102);
        this.f274775g = r103;
        this.f274776h = (Strength) com.google.common.base.j.a(r110.f274753h, r102);
        this.f274773e = (Equivalence) com.google.common.base.j.a(r110.f274757l, ((Strength) com.google.common.base.j.a(r110.f274752g, r102)).defaultEquivalence());
        this.f274774f = (Equivalence) com.google.common.base.j.a(r110.f274758m, ((Strength) com.google.common.base.j.a(r110.f274753h, r102)).defaultEquivalence());
        long r104 = 0;
        if (r110.f274754i != 0) goto L8;
    L14:
        long r105 = 0;
    L15:
        this.f274777i = r105;
        com.google.common.cache.m<? super Object, ? super Object> r106 = r110.f274751f;
        CacheBuilder.OneWeigher r107 = CacheBuilder.OneWeigher.INSTANCE;
        com.google.common.cache.m<K, V> r108 = (com.google.common.cache.m) com.google.common.base.j.a(r106, r107);
        this.f274778j = r108;
        long r111 = r110.f274755j;
        if (r111 != (-1)) goto L18;
        r111 = 0;
    L18:
        this.f274779k = r111;
        long r112 = r110.f274754i;
        if (r112 != (-1)) goto L21;
        r112 = 0;
    L21:
        this.f274780l = r112;
        long r113 = r110.f274756k;
        if (r113 == (-1)) goto L25;
        r104 = r113;
    L25:
        this.f274781m = r104;
        com.google.common.cache.l<? super Object, ? super Object> r109 = r110.f274759n;
        CacheBuilder.NullListener r114 = CacheBuilder.NullListener.INSTANCE;
        com.google.common.cache.l<K, V> r115 = (com.google.common.cache.l) com.google.common.base.j.a(r109, r114);
        this.f274783o = r115;
        if (r115 != r114) goto L28;
        Queue<RemovalNotification<K, V>> r116 = f274768y;
    L29:
        this.f274782n = r116;
        int r117 = 1;
        if (h() == false) goto L32;
    L35:
        boolean r118 = true;
    L36:
        com.google.common.base.v r119 = r110.f274760o;
        if (r119 != null) goto L43;
        if (r118 == false) goto L41;
        com.google.common.base.v r120 = com.google.common.base.v.f274741a;
    L42:
        r119 = r120;
        goto L43
    L41:
        r120 = CacheBuilder.f274744s;
    L43:
        this.f274784p = r119;
        if (j() == false) goto L46;
    L49:
        boolean r121 = true;
    L51:
        if (d() == false) goto L53;
    L56:
        boolean r122 = true;
    L57:
        this.f274785q = EntryFactory.getFactory(r103, r121, r122);
        this.f274786r = r110.f274761p.get();
        this.f274787s = r210;
        int r123 = r110.f274747b;
        if (r123 != (-1)) goto L60;
        r123 = 16;
    L60:
        int r124 = Math.min(r123, 1073741824);
        if (b() == false) goto L67;
        if (r108 == r107) goto L64;
        boolean r125 = true;
    L65:
        if (r125 == true) goto L67;
        r124 = (int) Math.min(r124, r105);
        goto L67
    L64:
        r125 = false;
    L67:
        int r126 = 1;
        int r127 = 0;
    L69:
        if (r126 >= this.f274772d) goto L75;
        if (b() == false) goto L74;
        if ((r126 * 20) > this.f274777i) goto L75;
    L74:
        r127 = r127 + 1;
        r126 = r126 << 1;
    L75:
        this.f274770b = 32 - r127;
        this.f274769a = r126 - 1;
        this.f274771c = new Segment[r126];
        int r128 = r124 / r126;
        if ((r128 * r126) >= r124) goto L78;
        r128 = r128 + 1;
    L78:
        if (r117 >= r128) goto L81;
        r117 = r117 << 1;
        goto L78
    L81:
        if (b() == false) goto L89;
        long r129 = this.f274777i;
        long r130 = r126;
        long r131 = r129 % r130;
        long r132 = (r129 / r130) + 1;
        int r133 = 0;
    L83:
        Segment<K, V>[] r134 = this.f274771c;
        if (r133 >= r134.length) goto L93;
        if (r133 != r131) goto L88;
        r132 = r132 - 1;
    L88:
        long r135 = r132;
        r134[r133] = new Segment(this, r117, r135, r110.f274761p.get());
        r133 = r133 + 1;
        r132 = r135;
        goto L83
    L93:
        return;
    L89:
        int r136 = 0;
    L90:
        Segment<K, V>[] r137 = this.f274771c;
        if (r136 >= r137.length) goto L104;
        r137[r136] = new Segment(this, r117, -1, r110.f274761p.get());
        r136 = r136 + 1;
        goto L90
    L104:
        return;
    L53:
        if (h() == true) goto L56;
        r122 = false;
        goto L57
    L46:
        if (c() == true) goto L49;
        r121 = false;
        goto L51
    L32:
        if (c() == true) goto L35;
        r118 = false;
        goto L36
    L28:
        r116 = new ConcurrentLinkedQueue();
        goto L29
    L8:
        if (r110.f274755j == 0) goto L14;
        if (r110.f274751f != null) goto L13;
        r105 = r110.f274749d;
        goto L15
    L13:
        r105 = r110.f274750e;
        goto L15
    }

    public final boolean f(com.google.common.cache.k<K, V> r100, long r101) {
        r100.getClass();
        if (c() == false) goto L8;
        if ((r101 - r100.getAccessTime()) < this.f274779k) goto L8;
        return true;
    L8:
        if (d() == true) goto L10;
        return false;
    L10:
        if ((r101 - r100.getWriteTime()) < this.f274780l) goto L14;
        return true;
    L14:
        return false;
    }

    @CheckForNull
    public final Map<K, V> g(Set<? extends K> r100, CacheLoader<? super K, V> r101) throws ExecutionException {
        r101.getClass();
        r100.getClass();
        com.google.common.base.r r102 = new com.google.common.base.r();
        boolean r103 = true;
        com.google.common.base.m.p(!r102.f274736b, "This stopwatch is already running.");
        r102.f274736b = true;
        r102.f274735a.getClass();
        r102.f274738d = System.nanoTime();
        boolean r104 = false;
        Map<? super K, V> r105 = r101.loadAll(r100);     // Catch: Throwable -> L21 Error -> L23 Exception -> L26 RuntimeException -> L29 InterruptedException -> L32 CacheLoader.UnsupportedLoadingOperationException -> L36
        if (r105 == null) goto L19;
        r102.b();
        Iterator<Map.Entry<K, V>> r106 = r105.entrySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L14;
        Map.Entry<K, V> r107 = r106.next();
        K r108 = r107.getKey();
        V r109 = r107.getValue();
        if (r108 == null) goto L13;
        if (r109 == null) goto L13;
        put(r108, r109);
    L13:
        r104 = true;
        goto L7
    L14:
        if (r104 == true) goto L17;
        this.f274786r.c(r102.a(TimeUnit.NANOSECONDS));
        return r105;
    L17:
        this.f274786r.e(r102.a(TimeUnit.NANOSECONDS));
        throw new CacheLoader.InvalidCacheLoadException(r101 + " returned null keys or values from loadAll");
    L19:
        this.f274786r.e(r102.a(TimeUnit.NANOSECONDS));
        throw new CacheLoader.InvalidCacheLoadException(r101 + " returned null map from loadAll");
    L21:
        th = th;
        r103 = false;
    L39:
        if (r103 == true) goto L41;
        this.f274786r.e(r102.a(TimeUnit.NANOSECONDS));
    L41:
        throw th;
    L32:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L21
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    L29:
        e = move-exception;
        throw new UncheckedExecutionException(e);     // Catch: Throwable -> L21
    L26:
        e = move-exception;
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    L36:
        e = move-exception;
        throw e;     // Catch: Throwable -> L38
    L38:
        th = th;
    L23:
        e = move-exception;
        throw new ExecutionError(e);     // Catch: Throwable -> L21
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object r100, @CheckForNull V r101) {
        V r102 = get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final V put(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = e(r100);
        return i(r102).put(r100, r102, r101, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public final V putIfAbsent(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = e(r100);
        return i(r102).put(r100, r102, r101, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        int r102 = e(r100);
        return i(r102).remove(r100, r102, r101);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public final V replace(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = e(r100);
        return i(r102).replace(r100, r102, r101);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(K r100, @CheckForNull V r101, V r102) {
        r100.getClass();
        r102.getClass();
        if (r101 != null) goto L6;
        return false;
    L6:
        int r103 = e(r100);
        return i(r103).replace(r100, r103, r101, r102);
    }
}
