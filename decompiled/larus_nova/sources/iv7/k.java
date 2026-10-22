package iv7;

import androidx.collection.SieveCacheKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes23.dex */
public final class k extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f495956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f495957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f495958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f495959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f495960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f495961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f495962g;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f495962g = true;
        this.f495956a.close();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long r100 = this.f495961f - this.f495958c;
        long r101 = this.f495959d - r100;
        if (r101 <= SieveCacheKt.NodeLinkMask) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return (int) r101;
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        long r100 = this.f495957b;
        if (r100 < 0) goto L7;
        this.f495956a.seek(r100);
        this.f495961f = this.f495957b;
        return;
    L7:
        throw new IOException("mark not set");
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (available() > 0) goto L6;
        return -1;
    L6:
        this.f495961f++;
        return this.f495956a.read();
    }

    public final void finalize() throws IOException {
        close();
    }

    public k(File r100) throws IOException {
        long r101 = r100.length();
        RandomAccessFile r102 = new RandomAccessFile(r100, "r");
        this.f495957b = -1;
        this.f495956a = r102;
        this.f495960e = r102.length();
        a(0, r101);
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        this.f495957b = this.f495961f;
    }

    @Override // java.io.InputStream
    public final int read(@Nonnull byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        if (r100 > 0) goto L5;
        return 0;
    L5:
        int r101 = available();
        if (r101 > 0) goto L8;
        return 0;
    L8:
        long r102 = (int) Math.min(r101, r100);
        long r103 = this.f495961f + r102;
        this.f495961f = r103;
        this.f495956a.seek(r103);
        return r102;
    }

    public final void a(long r100, long r110) throws IOException {
        if (this.f495962g == true) goto L26;
        if (r100 < 0) goto L24;
        if (r110 < 0) goto L22;
        long r101 = r100 + r110;
        if (r101 > this.f495960e) goto L20;
        if (r101 < 0) goto L18;
        this.f495958c = r100;
        this.f495959d = r110;
        if (r100 == this.f495961f) goto L15;
        this.f495956a.seek(r100);
        this.f495961f = r100;
    L15:
        this.f495957b = -1;
        return;
    L18:
        throw new IllegalArgumentException("Insane input size not supported");
    L20:
        throw new IllegalArgumentException("Read range exceeds file length, file length = " + this.f495960e + ", receive offset = " + r100 + ", length = " + r110);
    L22:
        throw new IllegalArgumentException("rangeLength must be >= 0");
    L24:
        throw new IllegalArgumentException("rangeOffset must be >= 0");
    L26:
        throw new IllegalArgumentException("raf is closed");
    }

    @Override // java.io.InputStream
    public final int read(@Nonnull byte[] r100, int r101, int r102) throws IOException {
        if (r102 > 0) goto L5;
        return 0;
    L5:
        int r103 = available();
        if (r103 > 0) goto L9;
        return -1;
    L9:
        int r104 = this.f495956a.read(r100, r101, Math.min(r102, r103));
        this.f495961f += (long) r104;
        return r104;
    }
}
