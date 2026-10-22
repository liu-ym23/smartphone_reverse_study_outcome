package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final v<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = null;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient i<K, V, E, S> entryHelper;

    @CheckForNull
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;

    @CheckForNull
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;

    @CheckForNull
    transient Collection<V> values;

    public static abstract class AbstractSerializationProxy<K, V> extends g0<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        @Override // com.google.common.collect.g0, com.google.common.collect.k0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.g0, com.google.common.collect.k0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.g0, com.google.common.collect.k0, com.google.common.collect.o0
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        public void readEntries(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        L2:
            Object r101 = r100.readObject();
            if (r101 == null) goto L4;
            Object r102 = r100.readObject();
            this.delegate.put((K) r101, (V) r102);
            goto L2
        }

        public MapMaker readMapMaker(ObjectInputStream r100) throws IOException {
            int r101 = r100.readInt();
            MapMaker r102 = new MapMaker();
            int r103 = r102.f275203b;
            boolean r104 = false;
            if (r103 != (-1)) goto L5;
            boolean r105 = true;
        L6:
            com.google.common.base.m.q(r105, "initial capacity was already set to %s", r103);
            if (r101 < 0) goto L9;
            boolean r106 = true;
        L10:
            com.google.common.base.m.b(r106);
            r102.f275203b = r101;
            r102.d(this.keyStrength);
            Strength r107 = this.valueStrength;
            Strength r108 = r102.f275206e;
            if (r108 != null) goto L13;
            boolean r109 = true;
        L14:
            com.google.common.base.m.s(r109, "Value strength was already set to %s", r108);
            r107.getClass();
            r102.f275206e = r107;
            if (r107 == Strength.STRONG) goto L17;
            r102.f275202a = true;
        L17:
            Equivalence<Object> r110 = this.keyEquivalence;
            Equivalence<Object> r111 = r102.f275207f;
            if (r111 != null) goto L20;
            boolean r112 = true;
        L21:
            com.google.common.base.m.s(r112, "key equivalence was already set to %s", r111);
            r110.getClass();
            r102.f275207f = r110;
            r102.f275202a = true;
            int r113 = this.concurrencyLevel;
            int r114 = r102.f275204c;
            if (r114 != (-1)) goto L24;
            boolean r115 = true;
        L25:
            com.google.common.base.m.q(r115, "concurrency level was already set to %s", r114);
            if (r113 <= 0) goto L28;
            r104 = true;
        L28:
            com.google.common.base.m.b(r104);
            r102.f275204c = r113;
            return r102;
        L24:
            r115 = false;
            goto L25
        L20:
            r112 = false;
            goto L21
        L13:
            r109 = false;
            goto L14
        L9:
            r106 = false;
            goto L10
        L5:
            r105 = false;
            goto L6
        }

        public void writeMapTo(ObjectOutputStream r100) throws IOException {
            r100.writeInt(this.delegate.size());
            Iterator<Map.Entry<K, V>> r101 = this.delegate.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry<K, V> r102 = r101.next();
            r100.writeObject(r102.getKey());
            r100.writeObject(r102.getValue());
            goto L4
        L6:
            r100.writeObject(null);
        }

        public AbstractSerializationProxy(Strength r100, Strength r101, Equivalence<Object> r102, Equivalence<Object> r103, int r104, ConcurrentMap<K, V> r105) {
            this.keyStrength = r100;
            this.valueStrength = r101;
            this.keyEquivalence = r102;
            this.valueEquivalence = r103;
            this.concurrencyLevel = r104;
            this.delegate = r105;
        }
    }

    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final MapMakerInternalMap<K, V, E, S> map;
        int modCount;
        final AtomicInteger readCount;

        @CheckForNull
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public abstract E castForTesting(h<K, V, ?> r100);

        public void maybeClearReferenceQueues() {
        }

        public void maybeDrainReferenceQueues() {
        }

        public abstract S self();

        public void clear() {
            if (this.count == 0) goto L14;
            lock();
            AtomicReferenceArray<E> r100 = this.table;     // Catch: Throwable -> L11
            int r101 = 0;
        L7:
            if (r101 >= r100.length()) goto L9;
            r100.set(r101, null);     // Catch: Throwable -> L11
            r101 = r101 + 1;     // Catch: Throwable -> L11
            goto L7
        L9:
            maybeClearReferenceQueues();     // Catch: Throwable -> L11
            this.readCount.set(0);     // Catch: Throwable -> L11
            this.modCount++;     // Catch: Throwable -> L11
            this.count = 0;     // Catch: Throwable -> L11
            unlock();
            return;
        L11:
            th = move-exception;
            unlock();
            throw th;
        }

        public void expand() {
            AtomicReferenceArray<E> r100 = this.table;
            int r101 = r100.length();
            if (r101 < 1073741824) goto L5;
            return;
        L5:
            int r102 = this.count;
            AtomicReferenceArray<E> r103 = newEntryArray(r101 << 1);
            this.threshold = (r103.length() * 3) / 4;
            int r104 = r103.length() - 1;
            int r105 = 0;
        L6:
            if (r105 >= r101) goto L26;
            E r106 = r100.get(r105);
            if (r106 == null) goto L25;
            h r107 = r106.getNext();
            int r108 = r106.getHash() & r104;
            if (r107 != null) goto L12;
            r103.set(r108, r106);
            goto L25
        L12:
            h r109 = r106;
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
            h r112 = copyEntry(r106, (h) r103.get(r111));
            if (r112 == null) goto L23;
            r103.set(r111, r112);
        L24:
            r106 = r106.getNext();
            goto L19
        L23:
            r102 = r102 - 1;
        L25:
            r105 = r105 + 1;
            goto L6
        L26:
            this.table = r103;
            this.count = r102;
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            runCleanup();
            return;
        }

        public void runLockedCleanup() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public void preWriteCleanup() {
            runLockedCleanup();
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public static <K, V, E extends h<K, V, E>> boolean isCollected(E r100) {
            if (r100.getValue() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> r100) {
        L3:
            if (r100.poll() != null) goto L3;
        }

        public boolean containsValue(Object r100) {
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L18;
            AtomicReferenceArray<E> r101 = this.table;     // Catch: Throwable -> L20
            int r102 = r101.length();     // Catch: Throwable -> L20
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L18;
            E r104 = r101.get(r103);     // Catch: Throwable -> L20
        L7:
            if (r104 == null) goto L17;
            V r105 = getLiveValue(r104);     // Catch: Throwable -> L20
            if (r105 != null) goto L12;
        L15:
            r104 = r104.getNext();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.valueEquivalence().equivalent(r100, r105) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r103 = r103 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        public void drainKeyReferenceQueue(ReferenceQueue<K> r100) {
            int r101 = 0;
        L3:
            Reference<? extends K> r102 = r100.poll();
            if (r102 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r103 = this.map;
            r103.reclaimKey((h) r102);
            r101 = r101 + 1;
            if (r101 != 16) goto L3;
            return;
        }

        public void drainValueReferenceQueue(ReferenceQueue<V> r100) {
            int r101 = 0;
        L3:
            Reference<? extends V> r102 = r100.poll();
            if (r102 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r103 = this.map;
            r103.reclaimValue((v) r102);
            r101 = r101 + 1;
            if (r101 != 16) goto L3;
            return;
        }

        @CheckForNull
        public E getFirst(int r100) {
            AtomicReferenceArray<E> r101 = this.table;
            return r101.get(r100 & (r101.length() - 1));
        }

        @CheckForNull
        public V getLiveValue(E r100) {
            if (r100.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r101 = (V) r100.getValue();
            if (r101 != null) goto L10;
            tryDrainReferenceQueues();
            return null;
        L10:
            return r101;
        }

        @CheckForNull
        public V getLiveValueForTesting(h<K, V, ?> r100) {
            return getLiveValue(castForTesting(r100));
        }

        public v<K, V, E> getWeakValueReferenceForTesting(h<K, V, ?> r100) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> r100) {
            this.threshold = (r100.length() * 3) / 4;
            this.table = r100;
        }

        public AtomicReferenceArray<E> newEntryArray(int r100) {
            return new AtomicReferenceArray(r100);
        }

        public boolean removeEntryForTesting(E r100) {
            int r101 = r100.getHash();
            AtomicReferenceArray<E> r102 = this.table;
            int r103 = r101 & (r102.length() - 1);
            E r104 = r102.get(r103);
            h r105 = r104;
        L3:
            if (r105 == null) goto L8;
            if (r105 == r100) goto L5;
            r105 = r105.getNext();
            goto L3
        L5:
            this.modCount++;
            h r106 = removeFromChain(r104, r105);
            int r107 = this.count - 1;
            r102.set(r103, (E) r106);
            this.count = r107;
            return true;
        L8:
            return false;
        }

        public boolean removeTableEntryForTesting(h<K, V, ?> r100) {
            return removeEntryForTesting(castForTesting(r100));
        }

        public Segment(MapMakerInternalMap<K, V, E, S> r100, int r101) {
            this.readCount = new AtomicInteger();
            this.map = r100;
            initTable(newEntryArray(r101));
        }

        public boolean containsKey(Object r100, int r101) {
            boolean r102 = false;
            if (this.count == 0) goto L11;
            h r103 = getLiveEntry(r100, r101);     // Catch: Throwable -> L13
            if (r103 == null) goto L9;
            if (r103.getValue() == null) goto L9;
            r102 = true;
        L9:
            postReadCleanup();
            return r102;
        L11:
            postReadCleanup();
            return false;
        L13:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        @CheckForNull
        public E copyEntry(E r100, E r101) {
            return (E) this.map.entryHelper.e(self(), r100, r101);
        }

        public E copyForTesting(h<K, V, ?> r100, @CheckForNull h<K, V, ?> r101) {
            return (E) this.map.entryHelper.e(self(), castForTesting(r100), castForTesting(r101));
        }

        @CheckForNull
        public V get(Object r100, int r101) {
            h r102 = getLiveEntry(r100, r101);     // Catch: Throwable -> L11
            if (r102 != null) goto L6;
            postReadCleanup();
            return null;
        L6:
            V r103 = (V) r102.getValue();
            if (r103 != null) goto L9;
            tryDrainReferenceQueues();     // Catch: Throwable -> L11
        L9:
            postReadCleanup();
            return r103;
        L11:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        @CheckForNull
        public E getEntry(Object r100, int r101) {
            if (this.count == 0) goto L16;
            E r102 = (E) getFirst(r101);
        L5:
            if (r102 == null) goto L23;
            if (r102.getHash() != r101) goto L15;
            Object r103 = r102.getKey();
            if (r103 != null) goto L13;
            tryDrainReferenceQueues();
            goto L15
        L13:
            if (this.map.keyEquivalence.equivalent(r100, r103) == false) goto L15;
            return r102;
        L15:
            r102 = (E) r102.getNext();
            goto L5
        L23:
            return null;
        L16:
            return null;
        }

        @CheckForNull
        public E getLiveEntry(Object r100, int r101) {
            return (E) getEntry(r100, r101);
        }

        public v<K, V, E> newWeakValueReferenceForTesting(h<K, V, ?> r100, V r101) {
            throw new AssertionError();
        }

        public boolean reclaimKey(E r100, int r101) {
            lock();
            AtomicReferenceArray<E> r102 = this.table;     // Catch: Throwable -> L13
            int r103 = r101 & (r102.length() - 1);     // Catch: Throwable -> L13
            E r104 = r102.get(r103);     // Catch: Throwable -> L13
            h r105 = r104;
        L4:
            if (r105 == null) goto L11;
            if (r105 == r100) goto L6;
            r105 = r105.getNext();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            h r106 = removeFromChain(r104, r105);     // Catch: Throwable -> L13
            int r107 = this.count - 1;     // Catch: Throwable -> L13
            r102.set(r103, (E) r106);     // Catch: Throwable -> L13
            this.count = r107;     // Catch: Throwable -> L13
            unlock();
            return true;
        L11:
            unlock();
            return false;
        L13:
            th = move-exception;
            unlock();
            throw th;
        }

        @CheckForNull
        public V remove(Object r100, int r101) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r102 = this.table;     // Catch: Throwable -> L25
            int r103 = (r102.length() - 1) & r101;     // Catch: Throwable -> L25
            E r104 = r102.get(r103);     // Catch: Throwable -> L25
            h r105 = r104;
        L5:
            if (r105 == null) goto L23;
            Object r106 = r105.getKey();     // Catch: Throwable -> L25
            if (r105.getHash() != r101) goto L21;
            if (r106 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r100, r106) == false) goto L21;
            V r107 = (V) r105.getValue();
            if (r107 == null) goto L15;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            h r108 = removeFromChain(r104, r105);     // Catch: Throwable -> L25
            int r109 = this.count - 1;     // Catch: Throwable -> L25
            r102.set(r103, (E) r108);     // Catch: Throwable -> L25
            this.count = r109;     // Catch: Throwable -> L25
            unlock();
            return r107;
        L15:
            if (isCollected(r105) == true) goto L16;
            unlock();
            return null;
        L21:
            r105 = r105.getNext();     // Catch: Throwable -> L25
            goto L5
        L23:
            unlock();
            return null;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        @CheckForNull
        public E removeFromChain(E r100, E r101) {
            int r102 = this.count;
            E r103 = (E) r101.getNext();
        L3:
            if (r100 == r101) goto L9;
            h r104 = copyEntry(r100, r103);
            if (r104 == null) goto L7;
            r103 = (E) r104;
        L8:
            r100 = (E) r100.getNext();
            goto L3
        L7:
            r102 = r102 - 1;
            goto L8
        L9:
            this.count = r102;
            return r103;
        }

        @CheckForNull
        public E removeFromChainForTesting(h<K, V, ?> r100, h<K, V, ?> r101) {
            return (E) removeFromChain(castForTesting(r100), castForTesting(r101));
        }

        public void setTableEntryForTesting(int r100, h<K, V, ?> r101) {
            this.table.set(r100, (E) castForTesting(r101));
        }

        public void setValue(E r100, V r101) {
            this.map.entryHelper.d(self(), r100, r101);
        }

        public void setValueForTesting(h<K, V, ?> r100, V r101) {
            this.map.entryHelper.d(self(), castForTesting(r100), r101);
        }

        public void setWeakValueReferenceForTesting(h<K, V, ?> r100, v<K, V, ? extends h<K, V, ?>> r101) {
            throw new AssertionError();
        }

        public boolean clearValueForTesting(K r100, int r110, v<K, V, ? extends h<K, V, ?>> r111) {
            lock();
            AtomicReferenceArray<E> r101 = this.table;     // Catch: Throwable -> L22
            int r102 = (r101.length() - 1) & r110;     // Catch: Throwable -> L22
            E r103 = r101.get(r102);     // Catch: Throwable -> L22
            h r104 = r103;
        L5:
            if (r104 == null) goto L20;
            Object r105 = r104.getKey();     // Catch: Throwable -> L22
            if (r104.getHash() != r110) goto L18;
            if (r105 == null) goto L18;
            if (this.map.keyEquivalence.equivalent(r100, r105) == false) goto L18;
            if (((u) r104).getValueReference() != r111) goto L16;
            r101.set(r102, (E) removeFromChain(r103, r104));     // Catch: Throwable -> L22
            unlock();
            return true;
        L16:
            unlock();
            return false;
        L18:
            r104 = r104.getNext();     // Catch: Throwable -> L22
            goto L5
        L20:
            unlock();
            return false;
        L22:
            th = move-exception;
            unlock();
            throw th;
        }

        public E newEntryForTesting(K r100, int r101, @CheckForNull h<K, V, ?> r102) {
            return (E) this.map.entryHelper.f(self(), r100, r101, castForTesting(r102));
        }

        public boolean reclaimValue(K r100, int r110, v<K, V, E> r111) {
            lock();
            AtomicReferenceArray<E> r101 = this.table;     // Catch: Throwable -> L22
            int r102 = (r101.length() - 1) & r110;     // Catch: Throwable -> L22
            E r103 = r101.get(r102);     // Catch: Throwable -> L22
            h r104 = r103;
        L5:
            if (r104 == null) goto L20;
            Object r105 = r104.getKey();     // Catch: Throwable -> L22
            if (r104.getHash() != r110) goto L18;
            if (r105 == null) goto L18;
            if (this.map.keyEquivalence.equivalent(r100, r105) == false) goto L18;
            if (((u) r104).getValueReference() != r111) goto L16;
            this.modCount++;     // Catch: Throwable -> L22
            h r106 = removeFromChain(r103, r104);     // Catch: Throwable -> L22
            int r112 = this.count - 1;     // Catch: Throwable -> L22
            r101.set(r102, (E) r106);     // Catch: Throwable -> L22
            this.count = r112;     // Catch: Throwable -> L22
            unlock();
            return true;
        L16:
            unlock();
            return false;
        L18:
            r104 = r104.getNext();     // Catch: Throwable -> L22
            goto L5
        L20:
            unlock();
            return false;
        L22:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean remove(Object r100, int r110, Object r111) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r101 = this.table;     // Catch: Throwable -> L25
            int r102 = (r101.length() - 1) & r110;     // Catch: Throwable -> L25
            E r103 = r101.get(r102);     // Catch: Throwable -> L25
            h r104 = r103;
        L4:
            boolean r105 = false;
            if (r104 == null) goto L23;
            Object r106 = r104.getKey();     // Catch: Throwable -> L25
            if (r104.getHash() != r110) goto L21;
            if (r106 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r100, r106) == false) goto L21;
            if (this.map.valueEquivalence().equivalent(r111, r104.getValue()) == false) goto L15;
            r105 = true;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            h r107 = removeFromChain(r103, r104);     // Catch: Throwable -> L25
            int r112 = this.count - 1;     // Catch: Throwable -> L25
            r101.set(r102, (E) r107);     // Catch: Throwable -> L25
            this.count = r112;     // Catch: Throwable -> L25
            unlock();
            return r105;
        L15:
            if (isCollected(r104) == true) goto L16;
            unlock();
            return false;
        L21:
            r104 = r104.getNext();     // Catch: Throwable -> L25
            goto L4
        L23:
            unlock();
            return false;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        @CheckForNull
        public V replace(K r100, int r101, V r110) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r102 = this.table;     // Catch: Throwable -> L25
            int r103 = (r102.length() - 1) & r101;     // Catch: Throwable -> L25
            E r104 = r102.get(r103);     // Catch: Throwable -> L25
            h r105 = r104;
        L5:
            if (r105 == null) goto L23;
            Object r106 = r105.getKey();     // Catch: Throwable -> L25
            if (r105.getHash() != r101) goto L21;
            if (r106 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r100, r106) == false) goto L21;
            V r107 = (V) r105.getValue();
            if (r107 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L25
            setValue(r105, r110);     // Catch: Throwable -> L25
            unlock();
            return r107;
        L14:
            if (isCollected(r105) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L25
            h r108 = removeFromChain(r104, r105);     // Catch: Throwable -> L25
            int r109 = this.count - 1;     // Catch: Throwable -> L25
            r102.set(r103, (E) r108);     // Catch: Throwable -> L25
            this.count = r109;     // Catch: Throwable -> L25
        L16:
            unlock();
            return null;
        L21:
            r105 = r105.getNext();     // Catch: Throwable -> L25
            goto L5
        L23:
            unlock();
            return null;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        @CheckForNull
        public V put(K r100, int r110, V r111, boolean r112) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L29
            int r101 = this.count + 1;     // Catch: Throwable -> L29
            if (r101 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L29
            r101 = this.count + 1;     // Catch: Throwable -> L29
        L6:
            AtomicReferenceArray<E> r102 = this.table;     // Catch: Throwable -> L29
            int r103 = (r102.length() - 1) & r110;     // Catch: Throwable -> L29
            E r104 = r102.get(r103);     // Catch: Throwable -> L29
            h r105 = r104;
        L8:
            if (r105 == null) goto L26;
            Object r106 = r105.getKey();     // Catch: Throwable -> L29
            if (r105.getHash() != r110) goto L25;
            if (r106 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r100, r106) == false) goto L25;
            V r107 = (V) r105.getValue();
            if (r107 != null) goto L19;
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r105, r111);     // Catch: Throwable -> L29
            this.count = this.count;     // Catch: Throwable -> L29
            unlock();
            return null;
        L19:
            if (r112 == false) goto L22;
            unlock();
            return r107;
        L22:
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r105, r111);     // Catch: Throwable -> L29
            unlock();
            return r107;
        L25:
            r105 = r105.getNext();     // Catch: Throwable -> L29
            goto L8
        L26:
            this.modCount++;     // Catch: Throwable -> L29
            h r108 = this.map.entryHelper.f(self(), r100, r110, r104);     // Catch: Throwable -> L29
            setValue(r108, r111);     // Catch: Throwable -> L29
            r102.set(r103, (E) r108);     // Catch: Throwable -> L29
            this.count = r101;     // Catch: Throwable -> L29
            unlock();
            return null;
        L29:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean replace(K r100, int r110, V r111, V r112) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L29
            AtomicReferenceArray<E> r101 = this.table;     // Catch: Throwable -> L29
            int r102 = (r101.length() - 1) & r110;     // Catch: Throwable -> L29
            E r103 = r101.get(r102);     // Catch: Throwable -> L29
            h r104 = r103;
        L5:
            if (r104 == null) goto L27;
            Object r105 = r104.getKey();     // Catch: Throwable -> L29
            if (r104.getHash() != r110) goto L25;
            if (r105 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r100, r105) == false) goto L25;
            Object r106 = r104.getValue();     // Catch: Throwable -> L29
            if (r106 != null) goto L19;
            if (isCollected(r104) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L29
            h r107 = removeFromChain(r103, r104);     // Catch: Throwable -> L29
            int r113 = this.count - 1;     // Catch: Throwable -> L29
            r101.set(r102, (E) r107);     // Catch: Throwable -> L29
            this.count = r113;     // Catch: Throwable -> L29
        L16:
            unlock();
            return false;
        L19:
            if (this.map.valueEquivalence().equivalent(r111, r106) == false) goto L23;
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r104, r112);     // Catch: Throwable -> L29
            unlock();
            return true;
        L23:
            unlock();
            return false;
        L25:
            r104 = r104.getNext();     // Catch: Throwable -> L29
            goto L5
        L27:
            unlock();
            return false;
        L29:
            th = move-exception;
            unlock();
            throw th;
        }
    }

    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        private Object readResolve() {
            return this.delegate;
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            this.delegate = readMapMaker(r100).c();
            readEntries(r100);
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            r100.defaultWriteObject();
            writeMapTo(r100);
        }

        public SerializationProxy(Strength r100, Strength r101, Equivalence<Object> r102, Equivalence<Object> r103, int r104, ConcurrentMap<K, V> r105) {
            super(r100, r101, r102, r103, r104, r105);
        }
    }

    public static abstract enum Strength extends Enum<Strength> {
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Strength[] f275209a = null;

        public Strength() {
            throw null;
        }

        public abstract Equivalence<Object> defaultEquivalence();

        static {
            final String r100 = "STRONG";
            final int r101 = 0;
            Strength r102 = new AnonymousClass1(r100, r101);
            STRONG = r102;
            final String r103 = "WEAK";
            final int r104 = 1;
            Strength r105 = new AnonymousClass2(r103, r104);
            WEAK = r105;
            f275209a = new Strength[]{r102, r105};
        }

        public static Strength[] values() {
            return (Strength[]) f275209a.clone();
        }

        public static Strength valueOf(String r100) {
            return (Strength) r27.a.a(Strength.class, r100);
        }

        public Strength(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h castForTesting(h r100) {
            return castForTesting(r100);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K> castForTesting(h<K, MapMaker.Dummy, ?> r100) {
            return (m) r100;
        }

        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        @CheckForNull
        public /* bridge */ /* synthetic */ h castForTesting(@CheckForNull h r100) {
            return castForTesting(r100);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        @CheckForNull
        public n<K, V> castForTesting(@CheckForNull h<K, V, ?> r100) {
            return (n) r100;
        }

        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        public static /* synthetic */ ReferenceQueue access$500(StrongKeyWeakValueSegment r100) {
            return r100.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        @CheckForNull
        public /* bridge */ /* synthetic */ h castForTesting(@CheckForNull h r100) {
            return castForTesting(r100);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> r100) {
            return castForTesting(r100).f275228c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        @CheckForNull
        public o<K, V> castForTesting(@CheckForNull h<K, V, ?> r100) {
            return (o) r100;
        }

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> r100, int r101) {
            super(r100, r101);
            this.queueForValues = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> r100, V r101) {
            return new w(this.queueForValues, r101, castForTesting(r100));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> r100, v<K, V, ? extends h<K, V, ?>> r101) {
            o<K, V> r102 = castForTesting(r100);
            v<K, V, o<K, V>> r103 = r102.f275228c;
            r102.f275228c = r101;
            r103.clear();
        }
    }

    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        public static /* synthetic */ ReferenceQueue access$800(WeakKeyDummyValueSegment r100) {
            return r100.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h castForTesting(h r100) {
            return castForTesting(r100);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K> castForTesting(h<K, MapMaker.Dummy, ?> r100) {
            return (r) r100;
        }

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> r100, int r101) {
            super(r100, r101);
            this.queueForKeys = new ReferenceQueue();
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        public static /* synthetic */ ReferenceQueue access$1200(WeakKeyStrongValueSegment r100) {
            return r100.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h castForTesting(h r100) {
            return castForTesting(r100);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s<K, V> castForTesting(h<K, V, ?> r100) {
            return (s) r100;
        }

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> r100, int r101) {
            super(r100, r101);
            this.queueForKeys = new ReferenceQueue();
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        public static /* synthetic */ ReferenceQueue access$1500(WeakKeyWeakValueSegment r100) {
            return r100.queueForValues;
        }

        public static /* synthetic */ ReferenceQueue access$1600(WeakKeyWeakValueSegment r100) {
            return r100.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        @CheckForNull
        public /* bridge */ /* synthetic */ h castForTesting(@CheckForNull h r100) {
            return castForTesting(r100);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> r100) {
            return castForTesting(r100).f275237b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        @CheckForNull
        public t<K, V> castForTesting(@CheckForNull h<K, V, ?> r100) {
            return (t) r100;
        }

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> r100, int r101) {
            super(r100, r101);
            this.queueForKeys = new ReferenceQueue();
            this.queueForValues = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> r100, V r101) {
            return new w(this.queueForValues, r101, castForTesting(r100));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> r100, v<K, V, ? extends h<K, V, ?>> r101) {
            t<K, V> r102 = castForTesting(r100);
            v<K, V, t<K, V>> r103 = r102.f275237b;
            r102.f275237b = r101;
            r103.clear();
        }
    }

    public class a implements v<Object, Object, d> {
        public a() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public final void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        @CheckForNull
        public final Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        @CheckForNull
        public final /* bridge */ /* synthetic */ h getEntry() {
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap.v
        public final v a(ReferenceQueue r100, u r101) {
            d r102 = (d) r101;
            return this;
        }
    }

    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f275210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f275211b;

        @Override // com.google.common.collect.MapMakerInternalMap.h
        @CheckForNull
        public E getNext() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int getHash() {
            return this.f275211b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final K getKey() {
            return this.f275210a;
        }

        public b(K r100, int r101) {
            this.f275210a = r100;
            this.f275211b = r101;
        }
    }

    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f275212a;

        @Override // com.google.common.collect.MapMakerInternalMap.h
        @CheckForNull
        public E getNext() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int getHash() {
            return this.f275212a;
        }

        public c(ReferenceQueue<K> r100, K r101, int r102) {
            super(r101, r100);
            this.f275212a = r102;
        }
    }

    public static final class d implements h<Object, Object, d> {
        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final h getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getValue() {
            throw new AssertionError();
        }

        public d() {
            throw new AssertionError();
        }
    }

    public final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        @Override // java.util.Iterator
        public final Object next() {
            return c();
        }

        public e(MapMakerInternalMap r100) {
            super(r100);
        }
    }

    public final class f extends l<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f275213a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f275213a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return this.f275213a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new e(this.f275213a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f275213a.size();
        }

        public f(MapMakerInternalMap r100) {
            this.f275213a = r100;
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
            Object r103 = this.f275213a.get(r102);
            if (r103 != null) goto L11;
            return false;
        L11:
            if (this.f275213a.valueEquivalence().equivalent(r101.getValue(), r103) == false) goto L15;
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
            if (this.f275213a.remove(r102, r101.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public abstract class g<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f275214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public Segment<K, V, E, S> f275216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @CheckForNull
        public AtomicReferenceArray<E> f275217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @CheckForNull
        public E f275218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @CheckForNull
        public MapMakerInternalMap<K, V, E, S>.x f275219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @CheckForNull
        public MapMakerInternalMap<K, V, E, S>.x f275220g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f275221h;

        public final void a() {
            this.f275219f = null;
            E r100 = this.f275218e;
            if (r100 == null) goto L10;
        L4:
            E r101 = (E) r100.getNext();
            this.f275218e = r101;
            if (r101 == null) goto L10;
            if (b(r101) == true) goto L8;
            r100 = this.f275218e;
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
            int r103 = this.f275214a;
            if (r103 < 0) goto L22;
            Segment<K, V, E, S>[] r104 = this.f275221h.segments;
            this.f275214a = r103 - 1;
            Segment<K, V, E, S> r105 = r104[r103];
            this.f275216c = r105;
            if (r105.count == 0) goto L16;
            AtomicReferenceArray<E> r106 = this.f275216c.table;
            this.f275217d = r106;
            this.f275215b = r106.length() - 1;
            if (d() == false) goto L16;
            return;
        L22:
            return;
        L10:
            r102 = false;
            goto L11
        }

        public final MapMakerInternalMap<K, V, E, S>.x c() {
            MapMakerInternalMap<K, V, E, S>.x r100 = this.f275219f;
            if (r100 == null) goto L7;
            this.f275220g = r100;
            a();
            return this.f275220g;
        L7:
            throw new NoSuchElementException();
        }

        public final boolean d() {
        L2:
            int r100 = this.f275215b;
            boolean r101 = false;
            if (r100 < 0) goto L18;
            AtomicReferenceArray<E> r102 = this.f275217d;
            this.f275215b = r100 - 1;
            E r103 = r102.get(r100);
            this.f275218e = r103;
            if (r103 == null) goto L2;
            if (b(r103) == true) goto L17;
            E r104 = this.f275218e;
            if (r104 == null) goto L16;
        L10:
            E r105 = (E) r104.getNext();
            this.f275218e = r105;
            if (r105 == null) goto L16;
            if (b(r105) == true) goto L14;
            r104 = this.f275218e;
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
            if (this.f275219f == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f275220g == null) goto L5;
            boolean r100 = true;
        L6:
            com.google.common.collect.o.e(r100);
            this.f275221h.remove(this.f275220g.f275241a);
            this.f275220g = null;
            return;
        L5:
            r100 = false;
            goto L6
        }

        public g(MapMakerInternalMap r100) {
            this.f275221h = r100;
            this.f275214a = r100.segments.length - 1;
            this.f275215b = -1;
            a();
        }

        public final boolean b(E r100) {
            Object r101 = r100.getKey();     // Catch: Throwable -> L9
            Object r102 = this.f275221h.getLiveValue(r100);     // Catch: Throwable -> L9
            if (r102 == null) goto L7;
            this.f275219f = new x(this.f275221h, r101, r102);     // Catch: Throwable -> L9
            this.f275216c.postReadCleanup();
            return true;
        L7:
            this.f275216c.postReadCleanup();
            return false;
        L9:
            th = move-exception;
            this.f275216c.postReadCleanup();
            throw th;
        }
    }

    public interface h<K, V, E extends h<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        Strength a();

        Strength b();

        S c(MapMakerInternalMap<K, V, E, S> r100, int r101);

        void d(S r100, E r101, V r102);

        E e(S r100, E r101, @CheckForNull E r102);

        E f(S r100, K r101, int r102, @CheckForNull E r103);
    }

    public final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        @Override // java.util.Iterator
        public final K next() {
            return c().f275241a;
        }

        public j(MapMakerInternalMap r100) {
            super(r100);
        }
    }

    public final class k extends l<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f275222a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f275222a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return this.f275222a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new j(this.f275222a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f275222a.size();
        }

        public k(MapMakerInternalMap r100) {
            this.f275222a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r100) {
            return this.f275222a.containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r100) {
            if (this.f275222a.remove(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static abstract class l<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return MapMakerInternalMap.access$1800(this).toArray();
        }

        public l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] r100) {
            return (T[]) MapMakerInternalMap.access$1800(this).toArray(r100);
        }
    }

    public static class m<K> extends b<K, MapMaker.Dummy, m<K>> {

        public static final class a<K> implements i<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f275223a = null;

            public a() {
            }

            static {
                f275223a = new a();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Segment c(MapMakerInternalMap r100, int r101) {
                return new StrongKeyDummyValueSegment(r100, r101);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final /* bridge */ /* synthetic */ void d(Segment r100, h r101, MapMaker.Dummy r102) {
                StrongKeyDummyValueSegment r103 = (StrongKeyDummyValueSegment) r100;
                m r104 = (m) r101;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final h e(Segment r100, h r101, @CheckForNull h r102) {
                StrongKeyDummyValueSegment r103 = (StrongKeyDummyValueSegment) r100;
                m r104 = (m) r101;
                m r105 = (m) r102;
                K r106 = r104.f275210a;
                int r107 = r104.f275211b;
                if (r105 != null) goto L6;
                return new m(r106, r107);
            L6:
                return new b(r106, r107, r105);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final h f(Segment r100, Object r101, int r102, @CheckForNull h r103) {
                StrongKeyDummyValueSegment r104 = (StrongKeyDummyValueSegment) r100;
                m r105 = (m) r103;
                if (r105 != null) goto L6;
                return new m(r101, r102);
            L6:
                return new b(r101, r102, r105);
            }
        }

        public static final class b<K> extends m<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final m<K> f275224c;

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            public final h getNext() {
                return this.f275224c;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.m, com.google.common.collect.MapMakerInternalMap.h
            public final Object getValue() {
                return MapMaker.Dummy.VALUE;
            }

            public b(K r100, int r101, m<K> r102) {
                super(r100, r101);
                this.f275224c = r102;
            }
        }

        public m() {
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            return MapMaker.Dummy.VALUE;
        }

        public m(Object r100, int r101) {
            super(r100, r101);
        }
    }

    public static class n<K, V> extends b<K, V, n<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public volatile V f275225c;

        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f275226a = null;

            public a() {
            }

            static {
                f275226a = new a();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Segment c(MapMakerInternalMap r100, int r101) {
                return new StrongKeyStrongValueSegment(r100, r101);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final void d(Segment r100, h r101, Object r102) {
                StrongKeyStrongValueSegment r103 = (StrongKeyStrongValueSegment) r100;
                ((n) r101).f275225c = r102;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final h e(Segment r100, h r101, @CheckForNull h r102) {
                StrongKeyStrongValueSegment r103 = (StrongKeyStrongValueSegment) r100;
                n r104 = (n) r101;
                n r105 = (n) r102;
                K r106 = r104.f275210a;
                int r107 = r104.f275211b;
                if (r105 != null) goto L5;
                n r108 = new n(r106, r107);
            L6:
                r108.f275225c = r104.f275225c;
                return r108;
            L5:
                r108 = new b(r106, r107, r105);
                goto L6
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final h f(Segment r100, Object r101, int r102, @CheckForNull h r103) {
                StrongKeyStrongValueSegment r104 = (StrongKeyStrongValueSegment) r100;
                n r105 = (n) r103;
                if (r105 != null) goto L6;
                return new n(r101, r102);
            L6:
                return new b(r101, r102, r105);
            }
        }

        public static final class b<K, V> extends n<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final n<K, V> f275227d;

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            public final h getNext() {
                return this.f275227d;
            }

            public b(K r100, int r101, n<K, V> r102) {
                super(r100, r101);
                this.f275227d = r102;
            }
        }

        public n() {
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        @CheckForNull
        public final V getValue() {
            return this.f275225c;
        }

        public n(Object r100, int r101) {
            super(r100, r101);
            this.f275225c = null;
        }
    }

    public static class o<K, V> extends b<K, V, o<K, V>> implements u<K, V, o<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile v<K, V, o<K, V>> f275228c;

        public static final class a<K, V> implements i<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f275229a = null;

            public a() {
            }

            static {
                f275229a = new a();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Segment c(MapMakerInternalMap r100, int r101) {
                return new StrongKeyWeakValueSegment(r100, r101);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final void d(Segment r100, h r101, Object r102) {
                o r103 = (o) r101;
                v<K, V, o<K, V>> r104 = r103.f275228c;
                r103.f275228c = new w(StrongKeyWeakValueSegment.access$500((StrongKeyWeakValueSegment) r100), r102, r103);
                r104.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            @CheckForNull
            public final h e(Segment r100, h r101, @CheckForNull h r102) {
                StrongKeyWeakValueSegment r103 = (StrongKeyWeakValueSegment) r100;
                o r104 = (o) r101;
                o r105 = (o) r102;
                if (Segment.isCollected(r104) == false) goto L5;
                return null;
            L5:
                K r106 = r104.f275210a;
                int r107 = r104.f275211b;
                if (r105 != null) goto L8;
                o r108 = new o(r106, r107);
            L9:
                r108.f275228c = r104.f275228c.a(StrongKeyWeakValueSegment.access$500(r103), r108);
                return r108;
            L8:
                r108 = new b(r106, r107, r105);
                goto L9
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final h f(Segment r100, Object r101, int r102, @CheckForNull h r103) {
                StrongKeyWeakValueSegment r104 = (StrongKeyWeakValueSegment) r100;
                o r105 = (o) r103;
                if (r105 != null) goto L6;
                return new o(r101, r102);
            L6:
                return new b(r101, r102, r105);
            }
        }

        public static final class b<K, V> extends o<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final o<K, V> f275230d;

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            public final h getNext() {
                return this.f275230d;
            }

            public b(K r100, int r101, o<K, V> r102) {
                super(r100, r101);
                this.f275230d = r102;
            }
        }

        public o() {
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        @CheckForNull
        public final V getValue() {
            return this.f275228c.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public final v<K, V, o<K, V>> getValueReference() {
            return this.f275228c;
        }

        public o(Object r100, int r101) {
            super(r100, r101);
            this.f275228c = MapMakerInternalMap.unsetWeakValueReference();
        }
    }

    public final class p extends MapMakerInternalMap<K, V, E, S>.g<V> {
        @Override // java.util.Iterator
        public final V next() {
            return c().f275242b;
        }

        public p(MapMakerInternalMap r100) {
            super(r100);
        }
    }

    public final class q extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f275231a;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f275231a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return this.f275231a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new p(this.f275231a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f275231a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return MapMakerInternalMap.access$1800(this).toArray();
        }

        public q(MapMakerInternalMap r100) {
            this.f275231a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object r100) {
            return this.f275231a.containsValue(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final <T> T[] toArray(T[] r100) {
            return (T[]) MapMakerInternalMap.access$1800(this).toArray(r100);
        }
    }

    public static class r<K> extends c<K, MapMaker.Dummy, r<K>> {

        public static final class a<K> implements i<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f275232a = null;

            public a() {
            }

            static {
                f275232a = new a();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Segment c(MapMakerInternalMap r100, int r101) {
                return new WeakKeyDummyValueSegment(r100, r101);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final /* bridge */ /* synthetic */ void d(Segment r100, h r101, MapMaker.Dummy r102) {
                WeakKeyDummyValueSegment r103 = (WeakKeyDummyValueSegment) r100;
                r r104 = (r) r101;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            @CheckForNull
            public final h e(Segment r100, h r101, @CheckForNull h r102) {
                WeakKeyDummyValueSegment r103 = (WeakKeyDummyValueSegment) r100;
                r r104 = (r) r101;
                r r105 = (r) r102;
                K r106 = r104.get();
                if (r106 != null) goto L6;
                return null;
            L6:
                return g(r103, r106, r104.f275212a, r105);
            }

            public static r g(WeakKeyDummyValueSegment r100, Object r101, int r102, @CheckForNull r r103) {
                if (r103 != null) goto L5;
                return new r(WeakKeyDummyValueSegment.access$800(r100), r101, r102);
            L5:
                return new b(WeakKeyDummyValueSegment.access$800(r100), r101, r102, r103);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final /* bridge */ /* synthetic */ h f(Segment r100, Object r101, int r102, @CheckForNull h r103) {
                return g((WeakKeyDummyValueSegment) r100, r101, r102, (r) r103);
            }
        }

        public static final class b<K> extends r<K> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final r<K> f275233b;

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            public final h getNext() {
                return this.f275233b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.r, com.google.common.collect.MapMakerInternalMap.h
            public final Object getValue() {
                return MapMaker.Dummy.VALUE;
            }

            public b(ReferenceQueue r100, Object r101, int r102, r r103) {
                super(r100, r101, r102);
                this.f275233b = r103;
            }
        }

        public r() {
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            return MapMaker.Dummy.VALUE;
        }

        public r(ReferenceQueue r100, Object r101, int r102) {
            super(r100, r101, r102);
        }
    }

    public static class s<K, V> extends c<K, V, s<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public volatile V f275234b;

        public static final class a<K, V> implements i<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f275235a = null;

            public a() {
            }

            static {
                f275235a = new a();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Segment c(MapMakerInternalMap r100, int r101) {
                return new WeakKeyStrongValueSegment(r100, r101);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final void d(Segment r100, h r101, Object r102) {
                WeakKeyStrongValueSegment r103 = (WeakKeyStrongValueSegment) r100;
                ((s) r101).f275234b = r102;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            @CheckForNull
            public final h e(Segment r100, h r101, @CheckForNull h r102) {
                WeakKeyStrongValueSegment r103 = (WeakKeyStrongValueSegment) r100;
                s r104 = (s) r101;
                s r105 = (s) r102;
                K r106 = r104.get();
                if (r106 != null) goto L5;
                return null;
            L5:
                s r107 = g(r103, r106, r104.f275212a, r105);
                r107.f275234b = r104.f275234b;
                return r107;
            }

            public static s g(WeakKeyStrongValueSegment r100, Object r101, int r102, @CheckForNull s r103) {
                if (r103 != null) goto L5;
                return new s(WeakKeyStrongValueSegment.access$1200(r100), r101, r102);
            L5:
                return new b(WeakKeyStrongValueSegment.access$1200(r100), r101, r102, r103);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final /* bridge */ /* synthetic */ h f(Segment r100, Object r101, int r102, @CheckForNull h r103) {
                return g((WeakKeyStrongValueSegment) r100, r101, r102, (s) r103);
            }
        }

        public static final class b<K, V> extends s<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final s<K, V> f275236c;

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            public final h getNext() {
                return this.f275236c;
            }

            public b(ReferenceQueue r100, Object r101, int r102, s r103) {
                super(r100, r101, r102);
                this.f275236c = r103;
            }
        }

        public s() {
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        @CheckForNull
        public final V getValue() {
            return this.f275234b;
        }

        public s(ReferenceQueue r100, Object r101, int r102) {
            super(r100, r101, r102);
            this.f275234b = null;
        }
    }

    public static class t<K, V> extends c<K, V, t<K, V>> implements u<K, V, t<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile v<K, V, t<K, V>> f275237b;

        public static final class a<K, V> implements i<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f275238a = null;

            public a() {
            }

            static {
                f275238a = new a();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final Segment c(MapMakerInternalMap r100, int r101) {
                return new WeakKeyWeakValueSegment(r100, r101);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final void d(Segment r100, h r101, Object r102) {
                t r103 = (t) r101;
                v<K, V, t<K, V>> r104 = r103.f275237b;
                r103.f275237b = new w(WeakKeyWeakValueSegment.access$1500((WeakKeyWeakValueSegment) r100), r102, r103);
                r104.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            @CheckForNull
            public final h e(Segment r100, h r101, @CheckForNull h r102) {
                WeakKeyWeakValueSegment r103 = (WeakKeyWeakValueSegment) r100;
                t r104 = (t) r101;
                t r105 = (t) r102;
                K r106 = r104.get();
                if (r106 != null) goto L6;
            L7:
                return null;
            L6:
                if (Segment.isCollected(r104) == true) goto L7;
                int r107 = r104.f275212a;
                if (r105 != null) goto L11;
                t r108 = new t(WeakKeyWeakValueSegment.access$1600(r103), r106, r107);
            L12:
                r108.f275237b = r104.f275237b.a(WeakKeyWeakValueSegment.access$1500(r103), r108);
                return r108;
            L11:
                r108 = new b(WeakKeyWeakValueSegment.access$1600(r103), r106, r107, r105);
                goto L12
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public final h f(Segment r100, Object r101, int r102, @CheckForNull h r103) {
                WeakKeyWeakValueSegment r104 = (WeakKeyWeakValueSegment) r100;
                t r105 = (t) r103;
                if (r105 != null) goto L6;
                return new t(WeakKeyWeakValueSegment.access$1600(r104), r101, r102);
            L6:
                return new b(WeakKeyWeakValueSegment.access$1600(r104), r101, r102, r105);
            }
        }

        public static final class b<K, V> extends t<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final t<K, V> f275239c;

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            public final h getNext() {
                return this.f275239c;
            }

            public b(ReferenceQueue<K> r100, K r101, int r102, t<K, V> r103) {
                super(r100, r101, r102);
                this.f275239c = r103;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f275237b.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public final v<K, V, t<K, V>> getValueReference() {
            return this.f275237b;
        }

        public t(ReferenceQueue<K> r100, K r101, int r102) {
            super(r100, r101, r102);
            this.f275237b = MapMakerInternalMap.unsetWeakValueReference();
        }
    }

    public interface u<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        v<K, V, E> getValueReference();
    }

    public interface v<K, V, E extends h<K, V, E>> {
        v a(ReferenceQueue r100, u r101);

        void clear();

        @CheckForNull
        V get();

        E getEntry();
    }

    public static final class w<K, V, E extends h<K, V, E>> extends WeakReference<V> implements v<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f275240a;

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public final E getEntry() {
            return this.f275240a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public final v a(ReferenceQueue r100, u r101) {
            return new w(r100, get(), r101);
        }

        public w(ReferenceQueue<V> r100, V r101, E r102) {
            super(r101, r100);
            this.f275240a = r102;
        }
    }

    public final class x extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f275241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f275242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f275243c;

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public final int hashCode() {
            return this.f275241a.hashCode() ^ this.f275242b.hashCode();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public final K getKey() {
            return this.f275241a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public final V getValue() {
            return this.f275242b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public final boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            if (this.f275241a.equals(r101.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.f275242b.equals(r101.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public final V setValue(V r100) {
            V r101 = (V) this.f275243c.put(this.f275241a, r100);
            this.f275242b = r100;
            return r101;
        }

        public x(MapMakerInternalMap r100, K r101, V r102) {
            this.f275243c = r100;
            this.f275241a = r101;
            this.f275242b = r102;
        }
    }

    public static int rehash(int r100) {
        int r101 = r100 + ((r100 << 15) ^ (-12931));
        int r102 = r101 ^ (r101 >>> 10);
        int r103 = r102 + (r102 << 3);
        int r104 = r103 ^ (r103 >>> 6);
        int r105 = r104 + ((r104 << 2) + (r104 << 14));
        return r105 ^ (r105 >>> 16);
    }

    static {
        UNSET_WEAK_VALUE_REFERENCE = new a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V, E, S>[] r100 = this.segments;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].clear();
        r102 = r102 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r100 = this.entrySet;
        if (r100 != null) goto L7;
        f r101 = new f(this);
        this.entrySet = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] r100 = this.segments;
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
        if (r101 == 0) goto L22;
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
        if (r101 != 0) goto L27;
        return true;
    L27:
        return false;
    L22:
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r100 = this.keySet;
        if (r100 != null) goto L7;
        k r101 = new k(this);
        this.keySet = r101;
        return r101;
    L7:
        return r100;
    }

    public Strength keyStrength() {
        return this.entryHelper.a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Segment<K, V, E, S>[] r100 = this.segments;
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101 = r101 + ((long) r100[r102].count);
        r102 = r102 + 1;
        goto L4
    L7:
        return Ints.c(r101);
    }

    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.b().defaultEquivalence();
    }

    public Strength valueStrength() {
        return this.entryHelper.b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r100 = this.values;
        if (r100 != null) goto L7;
        q r101 = new q(this);
        this.values = r101;
        return r101;
    L7:
        return r100;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.a(), this.entryHelper.b(), this.keyEquivalence, this.entryHelper.b().defaultEquivalence(), this.concurrencyLevel, this);
    }

    public static <K, V, E extends h<K, V, E>> v<K, V, E> unsetWeakValueReference() {
        return (v<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    public static ArrayList access$1800(Collection r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterators.a(r101, r100.iterator());
        return r101;
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends h<K, V, ?>, ?> create(MapMaker r100) {
        Strength r101 = r100.a();
        Strength r102 = Strength.STRONG;
        if (r101 != r102) goto L9;
        if (r100.b() != r102) goto L9;
        return new MapMakerInternalMap(r100, n.a.f275226a);
    L9:
        if (r100.a() == r102) goto L11;
    L14:
        Strength r103 = r100.a();
        Strength r104 = Strength.WEAK;
        if (r103 != r104) goto L21;
        if (r100.b() != r102) goto L21;
        return new MapMakerInternalMap(r100, s.a.f275235a);
    L21:
        if (r100.a() != r104) goto L27;
        if (r100.b() != r104) goto L27;
        return new MapMakerInternalMap(r100, t.a.f275238a);
    L27:
        throw new AssertionError();
    L11:
        if (r100.b() != Strength.WEAK) goto L14;
        return new MapMakerInternalMap(r100, o.a.f275229a);
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends h<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker r100) {
        Strength r101 = r100.a();
        Strength r102 = Strength.STRONG;
        if (r101 == r102) goto L5;
    L8:
        Strength r103 = r100.a();
        Strength r104 = Strength.WEAK;
        if (r103 != r104) goto L15;
        if (r100.b() != r102) goto L15;
        return new MapMakerInternalMap(r100, r.a.f275232a);
    L15:
        if (r100.b() != r104) goto L19;
        throw new IllegalArgumentException("Map cannot have both weak and dummy values");
    L19:
        throw new AssertionError();
    L5:
        if (r100.b() != r102) goto L8;
        return new MapMakerInternalMap(r100, m.a.f275223a);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = hash(r100);
        return segmentFor(r101).containsKey(r100, r101);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        Segment<K, V, E, S>[] r100 = this.segments;
        long r101 = -1;
        int r102 = 0;
    L7:
        if (r102 >= 3) goto L28;
        int r103 = r100.length;
        long r104 = 0;
        int r111 = 0;
    L9:
        if (r111 >= r103) goto L25;
        Segment<K, V, E, S> r112 = r100[r111];
        int r113 = r112.count;
        AtomicReferenceArray<E> r114 = r112.table;
        int r115 = 0;
    L12:
        if (r115 >= r114.length()) goto L23;
        E r116 = r114.get(r115);
    L14:
        if (r116 == null) goto L22;
        V r117 = r112.getLiveValue(r116);
        if (r117 == null) goto L21;
        if (valueEquivalence().equivalent(r110, r117) == false) goto L21;
        return true;
    L21:
        r116 = r116.getNext();
        goto L14
    L22:
        r115 = r115 + 1;
        goto L12
    L23:
        r104 = r104 + ((long) r112.modCount);
        r111 = r111 + 1;
        goto L9
    L25:
        if (r104 == r101) goto L38;
        r102 = r102 + 1;
        r101 = r104;
        goto L7
    L38:
        return false;
    L28:
        return false;
    }

    public Segment<K, V, E, S> createSegment(int r100) {
        return this.entryHelper.c(this, r100);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = hash(r100);
        return segmentFor(r101).get(r100, r101);
    }

    @CheckForNull
    public E getEntry(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = hash(r100);
        return (E) segmentFor(r101).getEntry(r100, r101);
    }

    @CheckForNull
    public V getLiveValue(E r100) {
        if (r100.getKey() != null) goto L7;
        return null;
    L7:
        return (V) r100.getValue();
    }

    public int hash(Object r100) {
        return rehash(this.keyEquivalence.hash(r100));
    }

    public boolean isLiveForTesting(h<K, V, ?> r100) {
        if (segmentFor(r100.getHash()).getLiveValueForTesting(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int r100) {
        return new Segment[r100];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L4
    }

    public void reclaimKey(E r100) {
        int r101 = r100.getHash();
        segmentFor(r101).reclaimKey(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(v<K, V, E> r100) {
        h r101 = r100.getEntry();
        int r102 = r101.getHash();
        segmentFor(r102).reclaimValue(r101.getKey(), r102, r100);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = hash(r100);
        return segmentFor(r101).remove(r100, r101);
    }

    public Segment<K, V, E, S> segmentFor(int r100) {
        return this.segments[(r100 >>> this.segmentShift) & this.segmentMask];
    }

    public MapMakerInternalMap(MapMaker r100, i<K, V, E, S> r101) {
        int r102 = r100.f275204c;
        if (r102 != (-1)) goto L5;
        r102 = 4;
    L5:
        this.concurrencyLevel = Math.min(r102, 65536);
        this.keyEquivalence = (Equivalence) com.google.common.base.j.a(r100.f275207f, r100.a().defaultEquivalence());
        this.entryHelper = r101;
        int r103 = r100.f275203b;
        if (r103 != (-1)) goto L8;
        r103 = 16;
    L8:
        int r104 = Math.min(r103, 1073741824);
        int r105 = 0;
        int r106 = 1;
        int r107 = 1;
        int r108 = 0;
    L10:
        if (r107 >= this.concurrencyLevel) goto L12;
        r108 = r108 + 1;
        r107 = r107 << 1;
        goto L10
    L12:
        this.segmentShift = 32 - r108;
        this.segmentMask = r107 - 1;
        this.segments = newSegmentArray(r107);
        int r109 = r104 / r107;
        if ((r107 * r109) >= r104) goto L15;
        r109 = r109 + 1;
    L15:
        if (r106 >= r109) goto L17;
        r106 = r106 << 1;
    L17:
        Segment<K, V, E, S>[] r110 = this.segments;
        if (r105 >= r110.length) goto L20;
        r110[r105] = createSegment(r106);
        r105 = r105 + 1;
        goto L17
    }

    public E copyEntry(E r100, E r101) {
        return (E) segmentFor(r100.getHash()).copyEntry(r100, r101);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V put(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = hash(r100);
        return segmentFor(r102).put(r100, r102, r101, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public V putIfAbsent(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = hash(r100);
        return segmentFor(r102).put(r100, r102, r101, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        int r102 = hash(r100);
        return segmentFor(r102).remove(r100, r102, r101);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public V replace(K r100, V r101) {
        r100.getClass();
        r101.getClass();
        int r102 = hash(r100);
        return segmentFor(r102).replace(r100, r102, r101);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r100, @CheckForNull V r101, V r102) {
        r100.getClass();
        r102.getClass();
        if (r101 != null) goto L6;
        return false;
    L6:
        int r103 = hash(r100);
        return segmentFor(r103).replace(r100, r103, r101, r102);
    }
}
