package rv5;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes19.dex */
public class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f539483a;

    public void a(IOException r100) {
        throw null;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        this.f539483a.reset();     // Catch: Throwable -> L6 IOException -> L8
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        a(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f539483a.available();
    L4:
        e = move-exception;
        a(e);
        throw e;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f539483a.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        a(e);
        throw e;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f539483a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f539483a.read();
    L4:
        e = move-exception;
        a(e);
        throw e;
    }

    public c(InputStream r100) {
        this.f539483a = r100;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r100) {
        monitor-enter(this);
        this.f539483a.mark(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return this.f539483a.read(r100);
    L4:
        e = move-exception;
        a(e);
        throw e;
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        return this.f539483a.skip(r100);
    L4:
        e = move-exception;
        a(e);
        throw e;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        return this.f539483a.read(r100, r101, r102);
    L4:
        e = move-exception;
        a(e);
        throw e;
    }
}
