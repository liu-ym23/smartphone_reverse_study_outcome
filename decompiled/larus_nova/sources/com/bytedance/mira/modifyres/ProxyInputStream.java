package com.bytedance.mira.modifyres;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes21.dex */
public abstract class ProxyInputStream extends FilterInputStream {
    public static final int EOF = -1;

    public void afterRead(int r100) throws IOException {
    }

    public void beforeRead(int r100) throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r100 = 1;
        beforeRead(1);     // Catch: IOException -> L9
        int r101 = ((FilterInputStream) this).in.read();     // Catch: IOException -> L9
        if (r101 != (-1)) goto L7;
        r100 = -1;
    L7:
        afterRead(r100);     // Catch: IOException -> L9
        return r101;
    L9:
        e = move-exception;
        handleIOException(e);
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        ((FilterInputStream) this).in.reset();     // Catch: Throwable -> L5 IOException -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        e = move-exception;
        handleIOException(e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        handleIOException(e);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return super.available();
    L4:
        e = move-exception;
        handleIOException(e);
        return 0;
    }

    public ProxyInputStream(InputStream r100) {
        super(r100);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r100) {
        monitor-enter(this);
        ((FilterInputStream) this).in.mark(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100) throws IOException {
        if (r100 != null) goto L11;
        int r101 = 0;
    L7:
        beforeRead(r101);     // Catch: IOException -> L4
        int r102 = ((FilterInputStream) this).in.read(r100);     // Catch: IOException -> L4
        afterRead(r102);     // Catch: IOException -> L4
        return r102;
    L4:
        e = move-exception;
        handleIOException(e);
        return -1;
    L11:
        r101 = r100.length;     // Catch: IOException -> L4
        goto L7
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        return ((FilterInputStream) this).in.skip(r100);
    L4:
        e = move-exception;
        handleIOException(e);
        return 0;
    }

    public void handleIOException(IOException r100) throws IOException {
        throw r100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        beforeRead(r102);     // Catch: IOException -> L4
        int r103 = ((FilterInputStream) this).in.read(r100, r101, r102);     // Catch: IOException -> L4
        afterRead(r103);     // Catch: IOException -> L4
        return r103;
    L4:
        e = move-exception;
        handleIOException(e);
        return -1;
    }
}
