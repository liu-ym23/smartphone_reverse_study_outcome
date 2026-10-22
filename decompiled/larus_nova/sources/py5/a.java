package py5;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f531033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ny5.a f531034b;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        this.f531034b.position(this.f531033a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long r100 = this.f531034b.length() - this.f531034b.position();
        if (r100 <= Integer.MAX_VALUE) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return (int) r100;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f531034b.read();
    }

    public a(ny5.a r100) {
        this.f531034b = r100;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r100) {
        monitor-enter(this);
        this.f531033a = r100;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return this.f531034b.read(r100);
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        return this.f531034b.skip(r100);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        return this.f531034b.read(r100, r101, r102);
    }
}
