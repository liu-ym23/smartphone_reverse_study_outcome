package com.google.common.util.concurrent;

import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class AtomicLongMap<K> implements Serializable {

    @CheckForNull
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.j(this.map, new AnonymousClass1(this)));
    }

    public Map<K, Long> asMap() {
        Map<K, Long> r100 = this.asMap;
        if (r100 != null) goto L6;
        Map<K, Long> r101 = createAsMap();
        this.asMap = r101;
        return r101;
    L6:
        return r100;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> r100 = this.map.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        AtomicLong r101 = r100.next().getValue();
        if (r101 == null) goto L4;
        if (r101.get() != 0) goto L4;
        r100.remove();
        goto L4
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        Iterator<AtomicLong> r100 = this.map.values().iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.next().get();
        goto L4
    L6:
        return r101;
    }

    public String toString() {
        return this.map.toString();
    }

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> r100) {
        r100.getClass();
        this.map = r100;
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> r100) {
        AtomicLongMap<K> r101 = create();
        r101.putAll(r100);
        return r101;
    }

    public boolean containsKey(Object r100) {
        return this.map.containsKey(r100);
    }

    public long decrementAndGet(K r100) {
        return addAndGet(r100, -1);
    }

    public long get(K r100) {
        AtomicLong r101 = this.map.get(r100);
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.get();
    }

    public long getAndDecrement(K r100) {
        return getAndAdd(r100, -1);
    }

    public long getAndIncrement(K r100) {
        return getAndAdd(r100, 1);
    }

    public long incrementAndGet(K r100) {
        return addAndGet(r100, 1);
    }

    public void putAll(Map<? extends K, ? extends Long> r100) {
        Iterator<Map.Entry<? extends K, ? extends Long>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends Long> r102 = r101.next();
        put(r102.getKey(), r102.getValue().longValue());
        goto L4
    }

    public long remove(K r100) {
        AtomicLong r101 = this.map.get(r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        long r102 = r101.get();
        if (r102 == 0) goto L9;
        if (r101.compareAndSet(r102, 0) == false) goto L5;
    L9:
        this.map.remove(r100, r101);
        return r102;
    }

    public boolean removeIfZero(K r100) {
        return remove(r100, 0);
    }

    public long addAndGet(K r100, long r101) {
    L2:
        AtomicLong r102 = this.map.get(r100);
        if (r102 != null) goto L7;
        r102 = this.map.putIfAbsent(r100, new AtomicLong(r101));
        if (r102 != null) goto L7;
        return r101;
    L7:
        long r103 = r102.get();
        if (r103 == 0) goto L10;
        long r104 = r103 + r101;
        if (r102.compareAndSet(r103, r104) == false) goto L7;
        return r104;
    L10:
        if (this.map.replace(r100, r102, new AtomicLong(r101)) == false) goto L2;
        return r101;
    }

    public long getAndAdd(K r100, long r101) {
    L2:
        AtomicLong r102 = this.map.get(r100);
        if (r102 != null) goto L7;
        r102 = this.map.putIfAbsent(r100, new AtomicLong(r101));
        if (r102 != null) goto L7;
        return 0;
    L7:
        long r103 = r102.get();
        if (r103 == 0) goto L10;
        if (r102.compareAndSet(r103, r103 + r101) == false) goto L7;
        return r103;
    L10:
        if (this.map.replace(r100, r102, new AtomicLong(r101)) == false) goto L2;
        return 0;
    }

    public long put(K r100, long r101) {
    L2:
        AtomicLong r102 = this.map.get(r100);
        if (r102 != null) goto L7;
        r102 = this.map.putIfAbsent(r100, new AtomicLong(r101));
        if (r102 != null) goto L7;
        return 0;
    L7:
        long r103 = r102.get();
        if (r103 == 0) goto L10;
        if (r102.compareAndSet(r103, r101) == false) goto L7;
        return r103;
    L10:
        if (this.map.replace(r100, r102, new AtomicLong(r101)) == false) goto L2;
        return 0;
    }

    public long putIfAbsent(K r100, long r101) {
    L2:
        AtomicLong r102 = this.map.get(r100);
        if (r102 != null) goto L7;
        r102 = this.map.putIfAbsent(r100, new AtomicLong(r101));
        if (r102 != null) goto L7;
        return 0;
    L7:
        long r103 = r102.get();
        if (r103 != 0) goto L12;
        if (this.map.replace(r100, r102, new AtomicLong(r101)) == false) goto L2;
        return 0;
    L12:
        return r103;
    }

    public boolean remove(K r100, long r101) {
        AtomicLong r102 = this.map.get(r100);
        if (r102 != null) goto L5;
        return false;
    L5:
        long r103 = r102.get();
        if (r103 == r101) goto L9;
        return false;
    L9:
        if (r103 != 0) goto L11;
    L14:
        this.map.remove(r100, r102);
        return true;
    L11:
        if (r102.compareAndSet(r103, 0) == true) goto L14;
        return false;
    }

    public boolean replace(K r100, long r101, long r102) {
        if (r101 == 0) goto L5;
        AtomicLong r103 = this.map.get(r100);
        if (r103 != null) goto L12;
        return false;
    L12:
        return r103.compareAndSet(r101, r102);
    L5:
        if (putIfAbsent(r100, r102) != 0) goto L13;
        return true;
    L13:
        return false;
    }
}
