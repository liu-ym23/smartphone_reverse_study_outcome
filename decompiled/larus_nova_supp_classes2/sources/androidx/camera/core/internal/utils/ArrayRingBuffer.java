package androidx.camera.core.internal.utils;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ArrayRingBuffer<T> implements RingBuffer<T> {
    private static final String TAG = "ZslRingBuffer";
    private final ArrayDeque<T> mBuffer;
    private final Object mLock;
    final RingBuffer.OnRemoveCallback<T> mOnRemoveCallback;
    private final int mRingBufferCapacity;

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public T dequeue() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        T r1 = this.mBuffer.removeLast();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public boolean isEmpty() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mBuffer.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public int getMaxCapacity() {
        return this.mRingBufferCapacity;
    }

    public ArrayRingBuffer(int r2) {
        this(r2, null);
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public void enqueue(T r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mBuffer.size() < this.mRingBufferCapacity) goto L7;
        T r1 = dequeue();     // Catch: Throwable -> L15
    L8:
        this.mBuffer.addFirst(r4);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        RingBuffer.OnRemoveCallback<T> r5 = this.mOnRemoveCallback;
        if (r5 == null) goto L20;
        if (r1 == null) goto L21;
        r5.onRemove(r1);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public ArrayRingBuffer(int r2, RingBuffer.OnRemoveCallback<T> r3) {
        this.mLock = new Object();
        this.mRingBufferCapacity = r2;
        this.mBuffer = new ArrayDeque(r2);
        this.mOnRemoveCallback = r3;
    }
}
