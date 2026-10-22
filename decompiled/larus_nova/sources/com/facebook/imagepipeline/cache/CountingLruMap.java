package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class CountingLruMap<K, V> {
    private final LinkedHashMap<K, V> mMap;
    private int mSizeInBytes;
    private final ValueDescriptor<V> mValueDescriptor;

    public synchronized ArrayList<V> clear() {
        monitor-enter(this);
        ArrayList<V> r100 = new ArrayList(this.mMap.values());     // Catch: Throwable -> L6
        this.mMap.clear();     // Catch: Throwable -> L6
        this.mSizeInBytes = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getCount() {
        monitor-enter(this);
        int r100 = this.mMap.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized K getFirstKey() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mMap.isEmpty() == false) goto L6;
        K r100 = null;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = this.mMap.keySet().iterator().next();     // Catch: Throwable -> L9
        goto L7
    }

    public synchronized ArrayList<K> getKeys() {
        monitor-enter(this);
        ArrayList<K> r100 = new ArrayList(this.mMap.keySet());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getSizeInBytes() {
        monitor-enter(this);
        int r100 = this.mSizeInBytes;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<V> getValues() {
        monitor-enter(this);
        ArrayList<V> r100 = new ArrayList(this.mMap.values());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public LinkedHashMap<K, V> getMap() {
        return this.mMap;
    }

    public CountingLruMap(ValueDescriptor<V> r100) {
        this.mMap = new LinkedHashMap();
        this.mSizeInBytes = 0;
        this.mValueDescriptor = r100;
    }

    private int getValueSizeInBytes(V r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return this.mValueDescriptor.getSizeInBytes(r100);
    }

    public synchronized boolean contains(K r100) {
        monitor-enter(this);
        boolean r101 = this.mMap.containsKey(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized V get(K r100) {
        monitor-enter(this);
        V r101 = this.mMap.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> r100) {
        monitor-enter(this);
        ArrayList<Map.Entry<K, V>> r101 = new ArrayList(this.mMap.entrySet().size());     // Catch: Throwable -> L14
        Iterator<Map.Entry<K, V>> r102 = this.mMap.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<K, V> r103 = r102.next();     // Catch: Throwable -> L14
        if (r100 == null) goto L10;
        if (r100.apply(r103.getKey()) == false) goto L4;
    L10:
        r101.add(r103);     // Catch: Throwable -> L14
        goto L4
    L12:
        monitor-exit(this);
        return r101;
    L14:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized V remove(K r100) {
        monitor-enter(this);
        V r101 = this.mMap.remove(r100);     // Catch: Throwable -> L6
        this.mSizeInBytes -= getValueSizeInBytes(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<V> removeAll(@Nullable Predicate<K> r100) {
        monitor-enter(this);
        ArrayList<V> r101 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<Map.Entry<K, V>> r102 = this.mMap.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<K, V> r103 = r102.next();     // Catch: Throwable -> L14
        if (r100 == null) goto L10;
        if (r100.apply(r103.getKey()) == false) goto L4;
    L10:
        r101.add(r103.getValue());     // Catch: Throwable -> L14
        this.mSizeInBytes -= getValueSizeInBytes(r103.getValue());     // Catch: Throwable -> L14
        r102.remove();     // Catch: Throwable -> L14
        goto L4
    L12:
        monitor-exit(this);
        return r101;
    L14:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized V put(K r100, V r101) {
        monitor-enter(this);
        V r102 = this.mMap.remove(r100);     // Catch: Throwable -> L6
        this.mSizeInBytes -= getValueSizeInBytes(r102);     // Catch: Throwable -> L6
        this.mMap.put(r100, r101);     // Catch: Throwable -> L6
        this.mSizeInBytes += getValueSizeInBytes(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }
}
