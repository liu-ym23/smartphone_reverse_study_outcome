package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class BufferMemoryChunk implements MemoryChunk, Closeable {
    private static final String TAG = "BufferMemoryChunk";
    private ByteBuffer mBuffer;
    private final long mId;
    private final int mSize;

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.mBuffer = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @Nullable
    public synchronized ByteBuffer getByteBuffer() {
        monitor-enter(this);
        ByteBuffer r100 = this.mBuffer;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.mBuffer != null) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.mSize;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.mId;
    }

    public BufferMemoryChunk(int r100) {
        this.mBuffer = ByteBuffer.allocateDirect(r100);
        this.mSize = r100;
        this.mId = System.identityHashCode(this);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int r100) {
        monitor-enter(this);
        boolean r101 = true;
        if (isClosed() == true) goto L6;
        boolean r102 = true;
    L7:
        Preconditions.checkState(r102);     // Catch: Throwable -> L18
        if (r100 < 0) goto L10;
        boolean r103 = true;
    L11:
        Preconditions.checkArgument(r103);     // Catch: Throwable -> L18
        if (r100 < this.mSize) goto L15;
        r101 = false;
    L15:
        Preconditions.checkArgument(r101);     // Catch: Throwable -> L18
        byte r104 = this.mBuffer.get(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r104;
    L10:
        r103 = false;
        goto L11
    L6:
        r102 = false;
    L18:
        th = move-exception;
        throw th;
    }

    private void doCopy(int r100, MemoryChunk r101, int r102, int r103) {
        if ((r101 instanceof BufferMemoryChunk) == false) goto L7;
        Preconditions.checkState(!isClosed());
        Preconditions.checkState(!r101.isClosed());
        MemoryChunkUtil.checkBounds(r100, r101.getSize(), r102, r103, this.mSize);
        this.mBuffer.position(r100);
        r101.getByteBuffer().position(r102);
        byte[] r104 = new byte[r103];
        this.mBuffer.get(r104, 0, r103);
        r101.getByteBuffer().put(r104, 0, r103);
        return;
    L7:
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int r100, MemoryChunk r101, int r102, int r103) {
        Preconditions.checkNotNull(r101);
        if (r101.getUniqueId() != getUniqueId()) goto L6;
        Long.toHexString(getUniqueId());
        Long.toHexString(r101.getUniqueId());
        Preconditions.checkArgument(false);
    L6:
        if (r101.getUniqueId() >= getUniqueId()) goto L19;
        monitor-enter(r101);
        monitor-enter(this);     // Catch: Throwable -> L16
        doCopy(r100, r101, r102, r103);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        monitor-enter(this);
        monitor-enter(r101);     // Catch: Throwable -> L28
        doCopy(r100, r101, r102, r103);     // Catch: Throwable -> L25
        monitor-exit(r101);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int r100, byte[] r101, int r102, int r103) {
        monitor-enter(this);
        Preconditions.checkNotNull(r101);     // Catch: Throwable -> L10
        if (isClosed() == true) goto L6;
        boolean r104 = true;
    L7:
        Preconditions.checkState(r104);     // Catch: Throwable -> L10
        int r105 = MemoryChunkUtil.adjustByteCount(r100, r103, this.mSize);     // Catch: Throwable -> L10
        MemoryChunkUtil.checkBounds(r100, r101.length, r102, r105, this.mSize);     // Catch: Throwable -> L10
        this.mBuffer.position(r100);     // Catch: Throwable -> L10
        this.mBuffer.get(r101, r102, r105);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r105;
    L6:
        r104 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int r100, byte[] r101, int r102, int r103) {
        monitor-enter(this);
        Preconditions.checkNotNull(r101);     // Catch: Throwable -> L10
        if (isClosed() == true) goto L6;
        boolean r104 = true;
    L7:
        Preconditions.checkState(r104);     // Catch: Throwable -> L10
        int r105 = MemoryChunkUtil.adjustByteCount(r100, r103, this.mSize);     // Catch: Throwable -> L10
        MemoryChunkUtil.checkBounds(r100, r101.length, r102, r105, this.mSize);     // Catch: Throwable -> L10
        this.mBuffer.position(r100);     // Catch: Throwable -> L10
        this.mBuffer.put(r101, r102, r105);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r105;
    L6:
        r104 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
