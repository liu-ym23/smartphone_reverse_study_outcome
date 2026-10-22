package q95;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends FilterInputStream {
    public final long a;
    public int b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() throws IOException {
        monitor-enter(this);
        int r1 = (int) Math.max(this.a - ((long) this.b), ((FilterInputStream) this).in.available());
        monitor-exit(this);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() throws IOException {
        monitor-enter(this);
        int r0 = super.read();     // Catch: Throwable -> L6
        a(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(int r5) throws IOException {
        if (r5 < 0) goto L5;
        this.b += r5;
        return;
    L5:
        if ((this.a - ((long) this.b)) > 0) goto L8;
        return;
    L8:
        throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    public b(InputStream r1, long r2) {
        super(r1);
        this.a = r2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] r1, int r2, int r3) throws IOException {
        monitor-enter(this);
        int r4 = super.read(r1, r2, r3);     // Catch: Throwable -> L6
        a(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }
}
