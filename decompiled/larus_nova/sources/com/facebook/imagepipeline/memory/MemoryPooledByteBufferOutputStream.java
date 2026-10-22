package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private CloseableReference<MemoryChunk> mBufRef;
    private int mCount;
    private final MemoryChunkPool mPool;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    private void ensureValid() {
        if (CloseableReference.isValid(this.mBufRef) == false) goto L6;
        return;
    L6:
        throw new InvalidStreamException();
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        return new MemoryPooledByteBuffer(this.mBufRef, this.mCount);
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public int size() {
        return this.mCount;
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public /* bridge */ /* synthetic */ PooledByteBuffer toByteBuffer() {
        return toByteBuffer();
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool r100) {
        this(r100, r100.getMinBufferSize());
    }

    public void realloc(int r100) {
        ensureValid();
        if (r100 > this.mBufRef.get().getSize()) goto L5;
        return;
    L5:
        MemoryChunk r101 = this.mPool.get(r100);
        this.mBufRef.get().copy(0, r101, 0, this.mCount);
        this.mBufRef.close();
        this.mBufRef = CloseableReference.of(r101, this.mPool);
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        write(new byte[]{(byte) r100});
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool r100, int r101) {
        if (r101 <= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        MemoryChunkPool r103 = (MemoryChunkPool) Preconditions.checkNotNull(r100);
        this.mPool = r103;
        this.mCount = 0;
        this.mBufRef = CloseableReference.of(r103.get(r101), r103);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        if (r101 < 0) goto L9;
        if (r102 < 0) goto L9;
        if ((r101 + r102) > r100.length) goto L9;
        ensureValid();
        realloc(this.mCount + r102);
        this.mBufRef.get().write(this.mCount, r100, r101, r102);
        this.mCount += r102;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException("length=" + r100.length + "; regionStart=" + r101 + "; regionLength=" + r102);
    }
}
