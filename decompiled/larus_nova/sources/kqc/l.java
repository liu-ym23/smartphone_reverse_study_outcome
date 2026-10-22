package kqc;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public abstract class l extends FilterInputStream {
    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        ((FilterInputStream) this).in.reset();     // Catch: Throwable -> L6 IOException -> L8
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ((FilterInputStream) this).in.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int r100 = ((FilterInputStream) this).in.read();     // Catch: IOException -> L16
        if (r100 == (-1)) goto L5;
        int r101 = 1;
    L6:
        g r102 = (g) this;     // Catch: IOException -> L16
        monitor-enter(r102);     // Catch: IOException -> L16
        if (r101 != (-1)) goto L18;
    L14:
        monitor-exit(r102);     // Catch: IOException -> L16
        return r100;
    L18:
        r102.f505697a += (long) r101;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: IOException -> L16
    L5:
        r101 = -1;
    L16:
        e = move-exception;
        throw e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return super.available();
    L4:
        e = move-exception;
        throw e;
    }

    public l(InputStream r100) {
        super(r100);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int r100) {
        monitor-enter(this);
        ((FilterInputStream) this).in.mark(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        int r101 = ((FilterInputStream) this).in.read(r100);     // Catch: IOException -> L13
        g r102 = (g) this;     // Catch: IOException -> L13
        monitor-enter(r102);     // Catch: IOException -> L13
        if (r101 != (-1)) goto L16;
    L11:
        monitor-exit(r102);     // Catch: IOException -> L13
        return r101;
    L16:
        r102.f505697a += (long) r101;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        return ((FilterInputStream) this).in.skip(r100);
    L4:
        e = move-exception;
        throw e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = ((FilterInputStream) this).in.read(r100, r101, r102);     // Catch: IOException -> L13
        g r104 = (g) this;     // Catch: IOException -> L13
        monitor-enter(r104);     // Catch: IOException -> L13
        if (r103 != (-1)) goto L16;
    L11:
        monitor-exit(r104);     // Catch: IOException -> L13
        return r103;
    L16:
        r104.f505697a += (long) r103;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw e;
    }
}
