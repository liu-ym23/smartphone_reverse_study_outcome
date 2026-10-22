package com.ttnet.org.chromium.net;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UploadDataProvider implements Closeable {
    public UploadDataProvider() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract long getLength() throws IOException;

    public abstract void read(UploadDataSink r100, ByteBuffer r101) throws IOException;

    public abstract void rewind(UploadDataSink r100) throws IOException;
}
