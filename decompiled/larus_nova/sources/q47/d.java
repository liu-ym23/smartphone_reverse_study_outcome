package q47;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f531653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f531654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f531655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f531656d;

    public static class a {
        public a() {
        }

        public void a(Throwable r100) {
        }

        public void b(int r100, boolean r101) {
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        super.reset();     // Catch: Throwable -> L10
        int r100 = this.f531654b;     // Catch: Throwable -> L13
        int r101 = this.f531655c;     // Catch: Throwable -> L13
        if (r100 <= r101) goto L7;
        this.f531656d = false;     // Catch: Throwable -> L13
    L7:
        this.f531654b = r101;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        this.f531653a.a(th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();     // Catch: Throwable -> L5
        this.f531653a.b(this.f531654b, this.f531656d);
        return;
    L5:
        th = move-exception;
        this.f531653a.a(th);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.f531653a.b(this.f531654b, this.f531656d);
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int r100 = super.read();     // Catch: Throwable -> L8
        if (r100 != (-1)) goto L6;
        this.f531656d = true;
    L7:
        return r100;
    L6:
        this.f531654b++;
    L8:
        th = move-exception;
        this.f531653a.a(th);
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int r100) {
        monitor-enter(this);
        super.mark(r100);     // Catch: Throwable -> L7
        this.f531655c = this.f531654b;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        this.f531653a.a(th);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long r100) throws IOException {
        long r101 = super.skip(r100);     // Catch: Throwable -> L7
        if (r101 <= 0) goto L6;
        this.f531654b += (int) r101;
    L6:
        return r101;
    L7:
        th = move-exception;
        this.f531653a.a(th);
        throw th;
    }

    public d(InputStream r100, a r101) {
        super(r100);
        this.f531653a = r101;
        this.f531654b = 0;
        this.f531655c = 0;
        this.f531656d = false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = super.read(r100, r101, r102);     // Catch: Throwable -> L7
        if (r103 > 0) goto L5;
        this.f531656d = true;
    L6:
        return r103;
    L5:
        this.f531654b += r103;
    L7:
        th = move-exception;
        this.f531653a.a(th);
        throw th;
    }
}
