package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes16.dex */
public final class RecyclableBufferedInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f224968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f224969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f224970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f224971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f224972e;

    public static class InvalidMarkException extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String r100) {
            super(r100);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() throws IOException {
        monitor-enter(this);
        InputStream r100 = ((FilterInputStream) this).in;     // Catch: Throwable -> L12
        if (this.f224968a == null) goto L10;
        if (r100 == null) goto L10;
        int r101 = (this.f224969b - this.f224972e) + r100.available();
        monitor-exit(this);
        return r101;
    L10:
        b();     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f224968a = null;
        InputStream r100 = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() throws IOException {
        monitor-enter(this);
        byte[] r100 = this.f224968a;     // Catch: Throwable -> L29
        InputStream r101 = ((FilterInputStream) this).in;     // Catch: Throwable -> L29
        if (r100 == null) goto L27;
        if (r101 == null) goto L27;
        if (this.f224972e < this.f224969b) goto L13;
        if (a(r101, r100) != (-1)) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        if (r100 == this.f224968a) goto L19;
        r100 = this.f224968a;     // Catch: Throwable -> L29
        if (r100 != null) goto L19;
        b();     // Catch: Throwable -> L29
        throw null;     // Catch: Throwable -> L29
    L19:
        int r102 = this.f224969b;     // Catch: Throwable -> L29
        int r103 = this.f224972e;     // Catch: Throwable -> L29
        if ((r102 - r103) <= 0) goto L25;
        this.f224972e = r103 + 1;     // Catch: Throwable -> L29
        int r104 = r100[r103] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r104;
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
        if (this.f224968a == null) goto L13;
        int r100 = this.f224971d;     // Catch: Throwable -> L14
        if ((-1) == r100) goto L11;
        this.f224972e = r100;     // Catch: Throwable -> L14
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
    public final synchronized void mark(int r100) {
        monitor-enter(this);
        this.f224970c = Math.max(this.f224970c, r100);     // Catch: Throwable -> L6
        this.f224971d = this.f224972e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long r110) throws IOException {
        monitor-enter(this);
        byte[] r100 = this.f224968a;     // Catch: Throwable -> L43
        InputStream r101 = ((FilterInputStream) this).in;     // Catch: Throwable -> L43
        if (r100 != null) goto L7;
        b();     // Catch: Throwable -> L43
        throw null;     // Catch: Throwable -> L43
    L7:
        if (r110 >= 1) goto L11;
        monitor-exit(this);
        return 0;
    L11:
        if (r101 == null) goto L39;
        int r102 = this.f224969b;     // Catch: Throwable -> L43
        int r103 = this.f224972e;     // Catch: Throwable -> L43
        long r104 = r102 - r103;     // Catch: Throwable -> L43
        if (r104 < r110) goto L17;
        this.f224972e = (int) (((long) r103) + r110);     // Catch: Throwable -> L43
        monitor-exit(this);
        return r110;
    L17:
        this.f224972e = r102;     // Catch: Throwable -> L43
        if (this.f224971d == (-1)) goto L36;
        if (r110 > this.f224970c) goto L36;
        if (a(r101, r100) != (-1)) goto L25;
        monitor-exit(this);
        return r104;
    L25:
        int r105 = this.f224969b;     // Catch: Throwable -> L43
        int r106 = this.f224972e;     // Catch: Throwable -> L43
        long r107 = r110 - r104;     // Catch: Throwable -> L43
        if ((r105 - r106) < r107) goto L30;
        this.f224972e = (int) (((long) r106) + r107);     // Catch: Throwable -> L43
        monitor-exit(this);
        return r110;
    L30:
        long r108 = (r104 + ((long) r105)) - ((long) r106);
        this.f224972e = r105;     // Catch: Throwable -> L43
        monitor-exit(this);
        return r108;
    L36:
        long r109 = r104 + r101.skip(r110 - r104);
        monitor-exit(this);
        return r109;
    L39:
        b();     // Catch: Throwable -> L43
        throw null;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    public RecyclableBufferedInputStream(InputStream r100, byte[] r101) {
        super(r100);
        this.f224971d = -1;
        if (r101.length == 0) goto L7;
        this.f224968a = r101;
        return;
    L7:
        throw new IllegalArgumentException("buffer is null or empty");
    }

    public final int a(InputStream r100, byte[] r101) throws IOException {
        int r102 = this.f224971d;
        if (r102 == (-1)) goto L25;
        int r103 = this.f224972e - r102;
        int r104 = this.f224970c;
        if (r103 >= r104) goto L25;
        if (r102 == 0) goto L9;
    L17:
        if (r102 <= 0) goto L19;
        System.arraycopy(r101, r102, r101, 0, r101.length - r102);
    L19:
        int r105 = this.f224972e - this.f224971d;
        this.f224972e = r105;
        this.f224971d = 0;
        this.f224969b = 0;
        int r106 = r100.read(r101, r105, r101.length - r105);
        int r107 = this.f224972e;
        if (r106 <= 0) goto L23;
        r107 = r107 + r106;
    L23:
        this.f224969b = r107;
        return r106;
    L9:
        if (r104 <= r101.length) goto L17;
        if (this.f224969b != r101.length) goto L17;
        int r108 = r101.length * 2;
        if (r108 > r104) goto L16;
        r104 = r108;
    L16:
        tt5.a.b("BufferedIs", "allocate buffer of length: " + r104);
        byte[] r109 = new byte[r104];
        System.arraycopy(r101, 0, r109, 0, r101.length);
        this.f224968a = r109;
        r101 = r109;
    L25:
        int r110 = r100.read(r101);
        if (r110 <= 0) goto L28;
        this.f224971d = -1;
        this.f224972e = 0;
        this.f224969b = r110;
    L28:
        return r110;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] r100, int r101, int r102) throws IOException {
        monitor-enter(this);
        byte[] r103 = this.f224968a;     // Catch: Throwable -> L69
        if (r103 == null) goto L67;
        if (r102 != 0) goto L10;
        monitor-exit(this);
        return 0;
    L10:
        InputStream r104 = ((FilterInputStream) this).in;     // Catch: Throwable -> L69
        if (r104 == null) goto L65;
        int r105 = this.f224972e;     // Catch: Throwable -> L69
        int r106 = this.f224969b;     // Catch: Throwable -> L69
        if (r105 >= r106) goto L25;
        int r107 = r106 - r105;     // Catch: Throwable -> L69
        if (r107 < r102) goto L17;
        r107 = r102;
    L17:
        System.arraycopy(r103, r105, r100, r101, r107);     // Catch: Throwable -> L69
        this.f224972e += r107;     // Catch: Throwable -> L69
        if (r107 != r102) goto L20;
    L23:
        monitor-exit(this);
        return r107;
    L20:
        if (r104.available() == 0) goto L23;
        r101 = r101 + r107;
        int r108 = r102 - r107;
    L26:
        int r109 = -1;
        if (this.f224971d != (-1)) goto L38;
        if (r108 < r103.length) goto L38;
        int r110 = r104.read(r100, r101, r108);     // Catch: Throwable -> L69
        if (r110 == (-1)) goto L32;
    L55:
        r108 = r108 - r110;
        if (r108 == 0) goto L57;
        if (r104.available() == 0) goto L61;
        r101 = r101 + r110;
        goto L26
    L61:
        int r111 = r102 - r108;
        monitor-exit(this);
        return r111;
    L57:
        monitor-exit(this);
        return r102;
    L32:
        if (r108 == r102) goto L35;
        r109 = r102 - r108;
    L35:
        monitor-exit(this);
        return r109;
    L38:
        if (a(r104, r103) == (-1)) goto L39;
        if (r103 == this.f224968a) goto L51;
        r103 = this.f224968a;     // Catch: Throwable -> L69
        if (r103 != null) goto L51;
        b();     // Catch: Throwable -> L69
        throw null;     // Catch: Throwable -> L69
    L51:
        int r112 = this.f224969b;     // Catch: Throwable -> L69
        int r113 = this.f224972e;     // Catch: Throwable -> L69
        r110 = r112 - r113;     // Catch: Throwable -> L69
        if (r110 < r108) goto L54;
        r110 = r108;
    L54:
        System.arraycopy(r103, r113, r100, r101, r110);     // Catch: Throwable -> L69
        this.f224972e += r110;     // Catch: Throwable -> L69
        goto L55
    L39:
        if (r108 == r102) goto L42;
        r109 = r102 - r108;
    L42:
        monitor-exit(this);
        return r109;
    L25:
        r108 = r102;
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
