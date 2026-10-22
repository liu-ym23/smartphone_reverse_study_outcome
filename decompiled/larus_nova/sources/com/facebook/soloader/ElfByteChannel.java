package com.facebook.soloader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* JADX INFO: loaded from: classes23.dex */
public interface ElfByteChannel extends ByteChannel {
    long position() throws IOException;

    ElfByteChannel position(long r100) throws IOException;

    @Override // java.nio.channels.ReadableByteChannel
    int read(ByteBuffer r100) throws IOException;

    int read(ByteBuffer r100, long r101) throws IOException;

    long size() throws IOException;

    ElfByteChannel truncate(long r100) throws IOException;

    @Override // java.nio.channels.WritableByteChannel
    int write(ByteBuffer r100) throws IOException;
}
