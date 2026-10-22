package t67;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f544672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f544673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f544674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f544675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f544676e;

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f544672a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f544672a.close();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f544672a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int r100 = this.f544672a.read();
        if (r100 == (-1)) goto L5;
        this.f544673b++;
    L5:
        return r100;
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        a(this.f544676e);
    }

    public b(InputStream r100) {
        this.f544676e = -1;
        if (r100.markSupported() == true) goto L5;
        r100 = new BufferedInputStream(r100, 4096);
    L5:
        this.f544672a = r100;
    }

    public final void a(long r100) throws IOException {
        if (this.f544673b > this.f544675d) goto L9;
        if (r100 < this.f544674c) goto L9;
        this.f544672a.reset();
        c(this.f544674c, r100);
        this.f544673b = r100;
        return;
    L9:
        throw new IOException("Cannot reset");
    }

    public final long b(int r100) {
        long r101 = this.f544673b;
        long r102 = ((long) r100) + r101;
        long r103 = this.f544675d;
        if (r103 >= r102) goto L16;
    L12:
        e = move-exception;
        throw new IllegalStateException("Unable to mark: " + e);
    L5:
        if (this.f544674c < r101) goto L7;
    L9:
        this.f544674c = r101;     // Catch: IOException -> L12
        this.f544672a.mark((int) (r102 - r101));     // Catch: IOException -> L12
    L10:
        this.f544675d = r102;     // Catch: IOException -> L12
        goto L16
    L7:
        if (r101 > r103) goto L9;
        this.f544672a.reset();     // Catch: IOException -> L12
        this.f544672a.mark((int) (r102 - this.f544674c));     // Catch: IOException -> L12
        c(this.f544674c, this.f544673b);     // Catch: IOException -> L12
    L16:
        return this.f544673b;
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        this.f544676e = b(r100);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        int r101 = this.f544672a.read(r100);
        if (r101 == (-1)) goto L5;
        this.f544673b += (long) r101;
    L5:
        return r101;
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        long r101 = this.f544672a.skip(r100);
        this.f544673b += r101;
        return r101;
    }

    public final void c(long r100, long r101) throws IOException {
    L3:
        if (r100 >= r101) goto L11;
        long r102 = this.f544672a.skip(r101 - r100);
        if (r102 != 0) goto L10;
        if (read() == (-1)) goto L16;
        r102 = 1;
        goto L10
    L16:
        return;
    L10:
        r100 = r100 + r102;
        goto L3
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.f544672a.read(r100, r101, r102);
        if (r103 == (-1)) goto L5;
        this.f544673b += (long) r103;
    L5:
        return r103;
    }
}
