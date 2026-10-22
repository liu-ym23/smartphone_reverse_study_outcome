package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class BucketMap<T> {

    @Nullable
    LinkedEntry<T> mHead;
    protected final SparseArray<LinkedEntry<T>> mMap;

    @Nullable
    LinkedEntry<T> mTail;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.memory.BucketMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LinkedEntry<I> {
        int key;

        @Nullable
        LinkedEntry<I> next;

        @Nullable
        LinkedEntry<I> prev;
        LinkedList<I> value;

        public String toString() {
            return "LinkedEntry(key: " + this.key + ")";
        }

        private LinkedEntry(@Nullable LinkedEntry<I> r100, int r101, LinkedList<I> r102, @Nullable LinkedEntry<I> r103) {
            this.prev = r100;
            this.key = r101;
            this.value = r102;
            this.next = r103;
        }

        public /* synthetic */ LinkedEntry(LinkedEntry r100, int r101, LinkedList r102, LinkedEntry r103, AnonymousClass1 r104) {
            this(r100, r101, r102, r103);
        }
    }

    @Nullable
    public synchronized T removeFromEnd() {
        monitor-enter(this);
        LinkedEntry<T> r100 = this.mTail;     // Catch: Throwable -> L11
        if (r100 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        T r101 = r100.value.pollLast();     // Catch: Throwable -> L11
        maybePrune(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int valueCount() {
        monitor-enter(this);
        LinkedEntry r100 = this.mHead;     // Catch: Throwable -> L12
        int r101 = 0;
    L4:
        if (r100 == null) goto L10;
        LinkedList<I> r102 = r100.value;     // Catch: Throwable -> L12
        if (r102 == 0) goto L8;
        r101 = r101 + r102.size();     // Catch: Throwable -> L12
    L8:
        r100 = r100.next;     // Catch: Throwable -> L12
        goto L4
    L10:
        monitor-exit(this);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public BucketMap() {
        this.mMap = new SparseArray();
    }

    private void maybePrune(LinkedEntry<T> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.value.isEmpty() == false) goto L8;
        prune(r100);
        this.mMap.remove(r100.key);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void moveToFront(LinkedEntry<T> r100) {
        if (this.mHead != r100) goto L5;
        return;
    L5:
        prune(r100);
        LinkedEntry<T> r101 = this.mHead;
        if (r101 != 0) goto L9;
        this.mHead = r100;
        this.mTail = r100;
        return;
    L9:
        r100.next = r101;
        r101.prev = r100;
        this.mHead = r100;
    }

    private synchronized void prune(LinkedEntry<T> r100) {
        monitor-enter(this);
        LinkedEntry r101 = (LinkedEntry<T>) r100.prev;
        LinkedEntry r102 = (LinkedEntry<T>) r100.next;
        if (r101 == null) goto L6;
        r101.next = r102;     // Catch: Throwable -> L16
    L6:
        if (r102 == null) goto L8;
        r102.prev = r101;     // Catch: Throwable -> L16
    L8:
        r100.prev = null;     // Catch: Throwable -> L16
        r100.next = null;     // Catch: Throwable -> L16
        if (r100 != this.mHead) goto L12;
        this.mHead = r102;     // Catch: Throwable -> L16
    L12:
        if (r100 != this.mTail) goto L14;
        this.mTail = r101;     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized T acquire(int r100) {
        monitor-enter(this);
        LinkedEntry<T> r101 = this.mMap.get(r100);     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        T r102 = r101.value.pollFirst();     // Catch: Throwable -> L11
        moveToFront(r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void release(int r100, T r101) {
        monitor-enter(this);
        LinkedEntry<T> r102 = this.mMap.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L6;
        r102 = new LinkedEntry(null, r100, new LinkedList(), null, null);     // Catch: Throwable -> L9
        this.mMap.put(r100, r102);     // Catch: Throwable -> L9
    L6:
        r102.value.addLast(r101);     // Catch: Throwable -> L9
        moveToFront(r102);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
