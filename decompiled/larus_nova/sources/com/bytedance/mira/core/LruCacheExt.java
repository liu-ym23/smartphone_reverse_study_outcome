package com.bytedance.mira.core;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public class LruCacheExt<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public V create(K r100) {
        return null;
    }

    public final synchronized int createCount() {
        monitor-enter(this);
        int r100 = this.createCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void entryRemoved(boolean r100, K r101, V r102, V r103) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        monitor-enter(this);
        int r100 = this.evictionCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int hitCount() {
        monitor-enter(this);
        int r100 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int maxSize() {
        monitor-enter(this);
        int r100 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int missCount() {
        monitor-enter(this);
        int r100 = this.missCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Map<K, V> origin() {
        monitor-enter(this);
        LinkedHashMap<K, V> r100 = this.map;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Set<K> originKeySet() {
        monitor-enter(this);
        Set<K> r100 = this.map.keySet();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int putCount() {
        monitor-enter(this);
        int r100 = this.putCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int size() {
        monitor-enter(this);
        int r100 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int sizeOf(K r100, V r101) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        monitor-enter(this);
        LinkedHashMap r100 = new LinkedHashMap(this.map);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r100 = this.hitCount;     // Catch: Throwable -> L10
        int r101 = this.missCount + r100;     // Catch: Throwable -> L10
        if (r101 == 0) goto L6;
        int r102 = (r100 * 100) / r101;     // Catch: Throwable -> L10
    L7:
        String r103 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(r102)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r103;
    L6:
        r102 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public LruCacheExt(int r100) {
        if (r100 <= 0) goto L7;
        this.maxSize = r100;
        this.map = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void trimToSize(int r100) {
    L2:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.size < 0) goto L24;
        if (this.map.isEmpty() == false) goto L10;
        if (this.size != 0) goto L24;
    L10:
        if (this.size <= r100) goto L11;
        Iterator<Map.Entry<K, V>> r101 = this.map.entrySet().iterator();     // Catch: Throwable -> L25
        Map.Entry<K, V> r102 = null;
    L15:
        if (r101.hasNext() == false) goto L17;
        r102 = r101.next();     // Catch: Throwable -> L25
        goto L15
    L17:
        if (r102 == null) goto L18;
        K r103 = r102.getKey();     // Catch: Throwable -> L25
        V r104 = r102.getValue();     // Catch: Throwable -> L25
        this.map.remove(r103);     // Catch: Throwable -> L25
        this.size -= safeSizeOf(r103, r104);     // Catch: Throwable -> L25
        this.evictionCount++;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        entryRemoved(true, r103, r104, null);
        goto L2
    L18:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L24:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L25
    }

    public final V get(K r100) {
        if (r100 == null) goto L33;
        monitor-enter(this);
        V r101 = this.map.get(r100);     // Catch: Throwable -> L29
        if (r101 == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        return r101;
    L9:
        this.missCount++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        V r102 = create(r100);
        if (r102 != null) goto L15;
        return null;
    L15:
        monitor-enter(this);
        this.createCount++;     // Catch: Throwable -> L26
        V r103 = this.map.put(r100, r102);     // Catch: Throwable -> L26
        if (r103 == null) goto L19;
        this.map.put(r100, r103);     // Catch: Throwable -> L26
    L20:
        monitor-exit(this);     // Catch: Throwable -> L26
        if (r103 == null) goto L24;
        entryRemoved(false, r100, r102, r103);
        return r103;
    L24:
        trimToSize(this.maxSize);
        return r102;
    L19:
        this.size += safeSizeOf(r100, r102);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    L33:
        throw new NullPointerException("key == null");
    }

    public final V remove(K r100) {
        if (r100 == null) goto L15;
        monitor-enter(this);
        V r101 = this.map.remove(r100);     // Catch: Throwable -> L11
        if (r101 == null) goto L7;
        this.size -= safeSizeOf(r100, r101);     // Catch: Throwable -> L11
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r101 == null) goto L10;
        entryRemoved(false, r100, r101, null);
    L10:
        return r101;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new NullPointerException("key == null");
    }

    public void resize(int r100) {
        if (r100 <= 0) goto L12;
        monitor-enter(this);
        this.maxSize = r100;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        trimToSize(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K r100, V r101) {
        int r102 = sizeOf(r100, r101);
        if (r102 < 0) goto L6;
        return r102;
    L6:
        throw new IllegalStateException("Negative size: " + r100 + ContainerUtils.KEY_VALUE_DELIMITER + r101);
    }

    public final V put(K r100, V r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        monitor-enter(this);
        this.putCount++;     // Catch: Throwable -> L13
        this.size += safeSizeOf(r100, r101);     // Catch: Throwable -> L13
        V r102 = this.map.put(r100, r101);     // Catch: Throwable -> L13
        if (r102 == null) goto L8;
        this.size -= safeSizeOf(r100, r102);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        entryRemoved(false, r100, r102, r101);
    L11:
        trimToSize(this.maxSize);
        return r102;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new NullPointerException("key == null || value == null");
    }
}
