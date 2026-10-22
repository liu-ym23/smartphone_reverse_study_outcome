package com.facebook.imagepipeline.memory;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface MemoryChunk {
    void close();

    void copy(int r100, MemoryChunk r101, int r102, int r103);

    @Nullable
    ByteBuffer getByteBuffer();

    long getNativePtr() throws UnsupportedOperationException;

    int getSize();

    long getUniqueId();

    boolean isClosed();

    byte read(int r100);

    int read(int r100, byte[] r101, int r102, int r103);

    int write(int r100, byte[] r101, int r102, int r103);
}
