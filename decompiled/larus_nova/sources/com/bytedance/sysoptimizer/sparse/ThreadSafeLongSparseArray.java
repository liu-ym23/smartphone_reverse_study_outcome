package com.bytedance.sysoptimizer.sparse;

import android.util.LongSparseArray;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadSafeLongSparseArray<E> extends LongSparseArray<E> {
    private final LongSparseArray<E> mOriginArray;
    private final Object mutex;

    @Override // android.util.LongSparseArray
    public void clear() {
        Object r100 = this.mutex;
        monitor-enter(r100);
        this.mOriginArray.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public ThreadSafeLongSparseArray<E> clone() {
        Object r100 = this.mutex;
        monitor-enter(r100);
        ThreadSafeLongSparseArray<E> r101 = new ThreadSafeLongSparseArray(this.mOriginArray.clone());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public int size() {
        Object r100 = this.mutex;
        monitor-enter(r100);
        int r101 = this.mOriginArray.size();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public /* bridge */ /* synthetic */ LongSparseArray clone() {
        return clone();
    }

    @Override // android.util.LongSparseArray
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public ThreadSafeLongSparseArray(LongSparseArray<E> r100) {
        this.mutex = new Object();
        this.mOriginArray = r100;
    }

    @Override // android.util.LongSparseArray
    public void delete(long r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        this.mOriginArray.delete(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public E get(long r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        E r102 = this.mOriginArray.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public int indexOfKey(long r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        int r102 = this.mOriginArray.indexOfKey(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public int indexOfValue(E r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        int r102 = this.mOriginArray.indexOfValue(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public long keyAt(int r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        long r102 = this.mOriginArray.keyAt(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public void remove(long r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        this.mOriginArray.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public void removeAt(int r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        this.mOriginArray.removeAt(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public E valueAt(int r100) {
        Object r101 = this.mutex;
        monitor-enter(r101);
        E r102 = this.mOriginArray.valueAt(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public void append(long r100, E r101) {
        Object r102 = this.mutex;
        monitor-enter(r102);
        this.mOriginArray.append(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public E get(long r100, E r101) {
        Object r102 = this.mutex;
        monitor-enter(r102);
        E r103 = this.mOriginArray.get(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public void put(long r100, E r101) {
        Object r102 = this.mutex;
        monitor-enter(r102);
        this.mOriginArray.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.util.LongSparseArray
    public void setValueAt(int r100, E r101) {
        Object r102 = this.mutex;
        monitor-enter(r102);
        this.mOriginArray.setValueAt(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
