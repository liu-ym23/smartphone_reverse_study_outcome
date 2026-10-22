package q95;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f532100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f532101b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() throws IOException {
        monitor-enter(this);
        int r100 = (int) Math.max(this.f532100a - ((long) this.f532101b), ((FilterInputStream) this).in.available());
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() throws IOException {
        monitor-enter(this);
        int r100 = super.read();     // Catch: Throwable -> L6
        a(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(int r100) throws IOException {
        if (r100 < 0) goto L5;
        this.f532101b += r100;
        return;
    L5:
        if ((this.f532100a - ((long) this.f532101b)) > 0) goto L8;
        return;
    L8:
        throw new IOException("Failed to read all expected data, expected: " + this.f532100a + ", but read: " + this.f532101b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    public b(InputStream r100, long r101) {
        super(r100);
        this.f532100a = r101;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] r100, int r101, int r102) throws IOException {
        monitor-enter(this);
        int r103 = super.read(r100, r101, r102);     // Catch: Throwable -> L6
        a(r103);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }
}
