package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {
    CloseableReference<MemoryChunk> mBufRef;
    private final int mSize;

    @Override // com.facebook.common.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        CloseableReference.closeSafely(this.mBufRef);     // Catch: Throwable -> L6
        this.mBufRef = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void ensureValid() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new PooledByteBuffer.ClosedException();     // Catch: Throwable -> L9
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    @Nullable
    public synchronized ByteBuffer getByteBuffer() {
        monitor-enter(this);
        ByteBuffer r100 = this.mBufRef.get().getByteBuffer();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long getNativePtr() throws UnsupportedOperationException {
        monitor-enter(this);
        ensureValid();     // Catch: Throwable -> L6
        long r100 = this.mBufRef.get().getNativePtr();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r100 = !CloseableReference.isValid(this.mBufRef);
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        monitor-enter(this);
        ensureValid();     // Catch: Throwable -> L6
        int r100 = this.mSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte read(int r100) {
        monitor-enter(this);
        ensureValid();     // Catch: Throwable -> L14
        boolean r101 = true;
        if (r100 < 0) goto L6;
        boolean r102 = true;
    L7:
        Preconditions.checkArgument(r102);     // Catch: Throwable -> L14
        if (r100 < this.mSize) goto L11;
        r101 = false;
    L11:
        Preconditions.checkArgument(r101);     // Catch: Throwable -> L14
        byte r103 = this.mBufRef.get().read(r100);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r103;
    L6:
        r102 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> r100, int r101) {
        Preconditions.checkNotNull(r100);
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Preconditions.checkArgument(r102);
        this.mBufRef = r100.clone();
        this.mSize = r101;
        return;
    L5:
        if (r101 > r100.get().getSize()) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int read(int r100, byte[] r101, int r102, int r103) {
        monitor-enter(this);
        ensureValid();     // Catch: Throwable -> L10
        if ((r100 + r103) > this.mSize) goto L6;
        boolean r104 = true;
    L7:
        Preconditions.checkArgument(r104);     // Catch: Throwable -> L10
        int r105 = this.mBufRef.get().read(r100, r101, r102, r103);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r105;
    L6:
        r104 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
