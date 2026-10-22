package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    private final MemoryChunkPool mPool;
    private final PooledByteStreams mPooledByteStreams;

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream() {
        return new MemoryPooledByteBufferOutputStream(this.mPool);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public /* bridge */ /* synthetic */ PooledByteBufferOutputStream newOutputStream() {
        return newOutputStream();
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        Preconditions.checkArgument(r101);
        CloseableReference r102 = CloseableReference.of(this.mPool.get(r100), this.mPool);
        MemoryPooledByteBuffer r103 = new MemoryPooledByteBuffer(r102, r100);     // Catch: Throwable -> L9
        r102.close();
        return r103;
    L9:
        th = move-exception;
        r102.close();
        throw th;
    L4:
        r101 = false;
        goto L5
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream(int r100) {
        return new MemoryPooledByteBufferOutputStream(this.mPool, r100);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(byte[] r100) {
        MemoryPooledByteBufferOutputStream r101 = new MemoryPooledByteBufferOutputStream(this.mPool, r100.length);
        r101.write(r100, 0, r100.length);     // Catch: Throwable -> L6 IOException -> L8
        MemoryPooledByteBuffer r102 = r101.toByteBuffer();     // Catch: Throwable -> L6 IOException -> L8
        r101.close();
        return r102;
    L8:
        e = move-exception;
        throw Throwables.propagate(e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r101.close();
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public /* bridge */ /* synthetic */ PooledByteBufferOutputStream newOutputStream(int r100) {
        return newOutputStream(r100);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream r100) throws IOException {
        MemoryPooledByteBufferOutputStream r101 = new MemoryPooledByteBufferOutputStream(this.mPool);
        MemoryPooledByteBuffer r102 = newByteBuf(r100, r101);     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        r101.close();
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public /* bridge */ /* synthetic */ PooledByteBuffer newByteBuffer(int r100) {
        return newByteBuffer(r100);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public /* bridge */ /* synthetic */ PooledByteBuffer newByteBuffer(InputStream r100) throws IOException {
        return newByteBuffer(r100);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public /* bridge */ /* synthetic */ PooledByteBuffer newByteBuffer(byte[] r100) {
        return newByteBuffer(r100);
    }

    public MemoryPooledByteBufferFactory(MemoryChunkPool r100, PooledByteStreams r101) {
        this.mPool = r100;
        this.mPooledByteStreams = r101;
    }

    public MemoryPooledByteBuffer newByteBuf(InputStream r100, MemoryPooledByteBufferOutputStream r101) throws IOException {
        this.mPooledByteStreams.copy(r100, r101);
        return r101.toByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream r100, int r101) throws IOException {
        MemoryPooledByteBufferOutputStream r102 = new MemoryPooledByteBufferOutputStream(this.mPool, r101);
        MemoryPooledByteBuffer r103 = newByteBuf(r100, r102);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public /* bridge */ /* synthetic */ PooledByteBuffer newByteBuffer(InputStream r100, int r101) throws IOException {
        return newByteBuffer(r100, r101);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream r100, int r101, String r102) throws IOException {
        MemoryPooledByteBufferOutputStream r103 = new MemoryPooledByteBufferOutputStream(this.mPool, r101);
    L9:
        th = move-exception;
        r103.close();
        throw th;
    L4:
        if (this.mPooledByteStreams.copy(r100, r103, r102) != (-1)) goto L6;
        MemoryPooledByteBuffer r104 = null;
    L7:
        r103.close();
        return r104;
    L6:
        r104 = r103.toByteBuffer();     // Catch: Throwable -> L9
        goto L7
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public /* bridge */ /* synthetic */ PooledByteBuffer newByteBuffer(InputStream r100, int r101, String r102) throws IOException {
        return newByteBuffer(r100, r101, r102);
    }
}
