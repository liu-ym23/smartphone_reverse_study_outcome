package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface PooledByteBufferFactory {
    PooledByteBuffer newByteBuffer(int r100);

    PooledByteBuffer newByteBuffer(InputStream r100) throws IOException;

    PooledByteBuffer newByteBuffer(InputStream r100, int r101) throws IOException;

    PooledByteBuffer newByteBuffer(InputStream r100, int r101, String r102) throws IOException;

    PooledByteBuffer newByteBuffer(byte[] r100);

    PooledByteBufferOutputStream newOutputStream();

    PooledByteBufferOutputStream newOutputStream(int r100);
}
