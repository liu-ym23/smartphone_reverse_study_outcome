package pp7;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream[] f530211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f530212b;

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f530211a[this.f530212b].available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int r100 = this.f530212b;
        IOException r101 = null;
        int r102 = 0;
    L3:
        InputStream[] r103 = this.f530211a;
        if (r102 >= r103.length) goto L12;
        r103[r102].close();     // Catch: IOException -> L7
    L11:
        r102 = r102 + 1;
    L7:
        e = move-exception;
        if (r102 == r100) goto L10;
        if (r101 != null) goto L11;
    L10:
        r101 = e;
        goto L11
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
    L2:
        int r100 = this.f530211a[this.f530212b].read();
        if (r100 != (-1)) goto L9;
        boolean r101 = true;
        int r102 = this.f530212b + 1;
        if (r102 >= this.f530211a.length) goto L7;
        this.f530212b = r102;
    L8:
        if (r101 == true) goto L2;
    L7:
        r101 = false;
    L9:
        return r100;
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public a(InputStream[] r100) {
        if (r100.length < 2) goto L7;
        this.f530211a = r100;
        this.f530212b = 0;
        return;
    L7:
        throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        int r101 = (int) r100;
        int r102 = read(new byte[r101], 0, r101);
        if (r102 >= 0) goto L7;
        return -1;
    L7:
        return r102;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
    L2:
        int r103 = this.f530211a[this.f530212b].read(r100, r101, r102);
        if (r103 != (-1)) goto L9;
        boolean r104 = true;
        int r105 = this.f530212b + 1;
        if (r105 >= this.f530211a.length) goto L7;
        this.f530212b = r105;
    L8:
        if (r104 == true) goto L2;
    L7:
        r104 = false;
    L9:
        return r103;
    }
}
