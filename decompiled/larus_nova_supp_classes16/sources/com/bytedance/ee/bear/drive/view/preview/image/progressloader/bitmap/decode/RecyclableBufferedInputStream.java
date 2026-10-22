package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class RecyclableBufferedInputStream extends FilterInputStream {
    public volatile byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;

    public static class InvalidMarkException extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String r1) {
            super(r1);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() throws IOException {
        monitor-enter(this);
        InputStream r0 = ((FilterInputStream) this).in;     // Catch: Throwable -> L12
        if (this.a == null) goto L10;
        if (r0 == null) goto L10;
        int r1 = (this.b - this.e) + r0.available();
        monitor-exit(this);
        return r1;
    L10:
        b();     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a = null;
        InputStream r1 = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (r1 == null) goto L6;
        r1.close();
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() throws IOException {
        monitor-enter(this);
        byte[] r0 = this.a;     // Catch: Throwable -> L29
        InputStream r1 = ((FilterInputStream) this).in;     // Catch: Throwable -> L29
        if (r0 == null) goto L27;
        if (r1 == null) goto L27;
        if (this.e < this.b) goto L13;
        if (a(r1, r0) != (-1)) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        if (r0 == this.a) goto L19;
        r0 = this.a;     // Catch: Throwable -> L29
        if (r0 != null) goto L19;
        b();     // Catch: Throwable -> L29
        throw null;     // Catch: Throwable -> L29
    L19:
        int r2 = this.b;     // Catch: Throwable -> L29
        int r3 = this.e;     // Catch: Throwable -> L29
        if ((r2 - r3) <= 0) goto L25;
        this.e = r3 + 1;     // Catch: Throwable -> L29
        int r4 = r0[r3] & 255;
        monitor-exit(this);
        return r4;
    L25:
        monitor-exit(this);
        return -1;
    L27:
        b();     // Catch: Throwable -> L29
        throw null;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.a == null) goto L13;
        int r0 = this.d;     // Catch: Throwable -> L14
        if ((-1) == r0) goto L11;
        this.e = r0;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        throw new InvalidMarkException("Mark has been invalidated");     // Catch: Throwable -> L14
    L13:
        throw new IOException("Stream is closed");     // Catch: Throwable -> L14
    }

    public static void b() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int r2) {
        monitor-enter(this);
        this.c = Math.max(this.c, r2);     // Catch: Throwable -> L6
        this.d = this.e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long r10) throws IOException {
        monitor-enter(this);
        byte[] r0 = this.a;     // Catch: Throwable -> L43
        InputStream r1 = ((FilterInputStream) this).in;     // Catch: Throwable -> L43
        if (r0 != null) goto L7;
        b();     // Catch: Throwable -> L43
        throw null;     // Catch: Throwable -> L43
    L7:
        if (r10 >= 1) goto L11;
        monitor-exit(this);
        return 0;
    L11:
        if (r1 == null) goto L39;
        int r2 = this.b;     // Catch: Throwable -> L43
        int r3 = this.e;     // Catch: Throwable -> L43
        long r4 = r2 - r3;     // Catch: Throwable -> L43
        if (r4 < r10) goto L17;
        this.e = (int) (((long) r3) + r10);     // Catch: Throwable -> L43
        monitor-exit(this);
        return r10;
    L17:
        this.e = r2;     // Catch: Throwable -> L43
        if (this.d == (-1)) goto L36;
        if (r10 > this.c) goto L36;
        if (a(r1, r0) != (-1)) goto L25;
        monitor-exit(this);
        return r4;
    L25:
        int r5 = this.b;     // Catch: Throwable -> L43
        int r6 = this.e;     // Catch: Throwable -> L43
        long r7 = r10 - r4;     // Catch: Throwable -> L43
        if ((r5 - r6) < r7) goto L30;
        this.e = (int) (((long) r6) + r7);     // Catch: Throwable -> L43
        monitor-exit(this);
        return r10;
    L30:
        long r8 = (r4 + ((long) r5)) - ((long) r6);
        this.e = r5;     // Catch: Throwable -> L43
        monitor-exit(this);
        return r8;
    L36:
        long r9 = r4 + r1.skip(r10 - r4);
        monitor-exit(this);
        return r9;
    L39:
        b();     // Catch: Throwable -> L43
        throw null;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    public RecyclableBufferedInputStream(InputStream r1, byte[] r2) {
        super(r1);
        this.d = -1;
        if (r2.length == 0) goto L7;
        this.a = r2;
        return;
    L7:
        throw new IllegalArgumentException("buffer is null or empty");
    }

    public final int a(InputStream r6, byte[] r7) throws IOException {
        int r0 = this.d;
        if (r0 == (-1)) goto L25;
        int r3 = this.e - r0;
        int r4 = this.c;
        if (r3 >= r4) goto L25;
        if (r0 == 0) goto L9;
    L17:
        if (r0 <= 0) goto L19;
        System.arraycopy(r7, r0, r7, 0, r7.length - r0);
    L19:
        int r1 = this.e - this.d;
        this.e = r1;
        this.d = 0;
        this.b = 0;
        int r8 = r6.read(r7, r1, r7.length - r1);
        int r9 = this.e;
        if (r8 <= 0) goto L23;
        r9 = r9 + r8;
    L23:
        this.b = r9;
        return r8;
    L9:
        if (r4 <= r7.length) goto L17;
        if (this.b != r7.length) goto L17;
        int r2 = r7.length * 2;
        if (r2 > r4) goto L16;
        r4 = r2;
    L16:
        tt5.a.b("BufferedIs", "allocate buffer of length: " + r4);
        byte[] r5 = new byte[r4];
        System.arraycopy(r7, 0, r5, 0, r7.length);
        this.a = r5;
        r7 = r5;
    L25:
        int r10 = r6.read(r7);
        if (r10 <= 0) goto L28;
        this.d = -1;
        this.e = 0;
        this.b = r10;
    L28:
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] r7, int r8, int r9) throws IOException {
        monitor-enter(this);
        byte[] r0 = this.a;     // Catch: Throwable -> L69
        if (r0 == null) goto L67;
        if (r9 != 0) goto L10;
        monitor-exit(this);
        return 0;
    L10:
        InputStream r2 = ((FilterInputStream) this).in;     // Catch: Throwable -> L69
        if (r2 == null) goto L65;
        int r3 = this.e;     // Catch: Throwable -> L69
        int r4 = this.b;     // Catch: Throwable -> L69
        if (r3 >= r4) goto L25;
        int r5 = r4 - r3;     // Catch: Throwable -> L69
        if (r5 < r9) goto L17;
        r5 = r9;
    L17:
        System.arraycopy(r0, r3, r7, r8, r5);     // Catch: Throwable -> L69
        this.e += r5;     // Catch: Throwable -> L69
        if (r5 != r9) goto L20;
    L23:
        monitor-exit(this);
        return r5;
    L20:
        if (r2.available() == 0) goto L23;
        r8 = r8 + r5;
        int r6 = r9 - r5;
    L26:
        int r10 = -1;
        if (this.d != (-1)) goto L38;
        if (r6 < r0.length) goto L38;
        int r11 = r2.read(r7, r8, r6);     // Catch: Throwable -> L69
        if (r11 == (-1)) goto L32;
    L55:
        r6 = r6 - r11;
        if (r6 == 0) goto L57;
        if (r2.available() == 0) goto L61;
        r8 = r8 + r11;
        goto L26
    L61:
        int r12 = r9 - r6;
        monitor-exit(this);
        return r12;
    L57:
        monitor-exit(this);
        return r9;
    L32:
        if (r6 == r9) goto L35;
        r10 = r9 - r6;
    L35:
        monitor-exit(this);
        return r10;
    L38:
        if (a(r2, r0) == (-1)) goto L39;
        if (r0 == this.a) goto L51;
        r0 = this.a;     // Catch: Throwable -> L69
        if (r0 != null) goto L51;
        b();     // Catch: Throwable -> L69
        throw null;     // Catch: Throwable -> L69
    L51:
        int r13 = this.b;     // Catch: Throwable -> L69
        int r14 = this.e;     // Catch: Throwable -> L69
        r11 = r13 - r14;     // Catch: Throwable -> L69
        if (r11 < r6) goto L54;
        r11 = r6;
    L54:
        System.arraycopy(r0, r14, r7, r8, r11);     // Catch: Throwable -> L69
        this.e += r11;     // Catch: Throwable -> L69
        goto L55
    L39:
        if (r6 == r9) goto L42;
        r10 = r9 - r6;
    L42:
        monitor-exit(this);
        return r10;
    L25:
        r6 = r9;
        goto L26
    L65:
        b();     // Catch: Throwable -> L69
        throw null;     // Catch: Throwable -> L69
    L67:
        b();     // Catch: Throwable -> L69
        throw null;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        throw th;
    }
}
