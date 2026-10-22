package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    private static final String TAG = "NativeMemoryChunk";
    private boolean mIsClosed;
    private final long mNativePtr;
    private final int mSize;

    private static native long nativeAllocate(int r100);

    private static native void nativeCopyFromByteArray(long r100, byte[] r101, int r102, int r103);

    private static native void nativeCopyToByteArray(long r100, byte[] r101, int r102, int r103);

    private static native void nativeFree(long r100);

    private static native void nativeMemcpy(long r100, long r101, int r102);

    private static native byte nativeReadByte(long r100);

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsClosed == true) goto L6;
        this.mIsClosed = true;     // Catch: Throwable -> L8
        nativeFree(this.mNativePtr);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @Nullable
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r100 = this.mIsClosed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0;
        this.mIsClosed = true;
    }

    public void finalize() throws Throwable {
        if (isClosed() == false) goto L5;
        return;
    L5:
        Integer.toHexString(System.identityHashCode(this));
        close();     // Catch: Throwable -> L9
        super.finalize();
        return;
    L9:
        th = move-exception;
        super.finalize();
        throw th;
    }

    static {
        ImagePipelineNativeLoader.load();
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        return this.mNativePtr;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.mSize;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.mNativePtr;
    }

    public NativeMemoryChunk(int r100) {
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101);
        this.mSize = r100;
        this.mNativePtr = nativeAllocate(r100);
        this.mIsClosed = false;
        return;
    L5:
        r101 = false;
        goto L6
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
        byte r104 = nativeReadByte(this.mNativePtr + ((long) r100));     // Catch: Throwable -> L18
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
        if ((r101 instanceof NativeMemoryChunk) == false) goto L7;
        Preconditions.checkState(!isClosed());
        Preconditions.checkState(!r101.isClosed());
        MemoryChunkUtil.checkBounds(r100, r101.getSize(), r102, r103, this.mSize);
        nativeMemcpy(r101.getNativePtr() + ((long) r102), this.mNativePtr + ((long) r100), r103);
        return;
    L7:
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int r100, MemoryChunk r101, int r102, int r103) {
        Preconditions.checkNotNull(r101);
        if (r101.getUniqueId() != getUniqueId()) goto L6;
        Integer.toHexString(System.identityHashCode(this));
        Integer.toHexString(System.identityHashCode(r101));
        Long.toHexString(this.mNativePtr);
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
        nativeCopyToByteArray(this.mNativePtr + ((long) r100), r101, r102, r105);     // Catch: Throwable -> L10
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
        nativeCopyFromByteArray(this.mNativePtr + ((long) r100), r101, r102, r105);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r105;
    L6:
        r104 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
