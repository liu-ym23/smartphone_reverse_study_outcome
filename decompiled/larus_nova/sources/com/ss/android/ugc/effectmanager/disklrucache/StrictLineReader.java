package com.ss.android.ugc.effectmanager.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes40.dex */
class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f454372in;
    private int pos;

    private void fillBuf() throws IOException {
        InputStream r100 = this.f454372in;
        byte[] r101 = this.buf;
        int r102 = r100.read(r101, 0, r101.length);
        if (r102 == (-1)) goto L7;
        this.pos = 0;
        this.end = r102;
        return;
    L7:
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r100 = this.f454372in;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L7;
        this.buf = null;     // Catch: Throwable -> L9
        this.f454372in.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public boolean hasUnterminatedLine() {
        if (this.end != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public String readLine() throws IOException {
        InputStream r100 = this.f454372in;
        monitor-enter(r100);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L38;
        if (this.pos < this.end) goto L9;
        fillBuf();     // Catch: Throwable -> L39
    L9:
        int r101 = this.pos;     // Catch: Throwable -> L39
    L11:
        if (r101 == this.end) goto L24;
        byte[] r102 = this.buf;     // Catch: Throwable -> L39
        if (r102[r101] == 10) goto L14;
        r101 = r101 + 1;     // Catch: Throwable -> L39
        goto L11
    L14:
        int r103 = this.pos;     // Catch: Throwable -> L39
        if (r101 == r103) goto L19;
        int r104 = r101 - 1;     // Catch: Throwable -> L39
        if (r102[r104] != 13) goto L19;
    L20:
        String r105 = new String(r102, r103, r104 - r103, this.charset.name());     // Catch: Throwable -> L39
        this.pos = r101 + 1;     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L39
        return r105;
    L19:
        r104 = r101;
        goto L20
    L24:
        final int r106 = (this.end - this.pos) + 80;     // Catch: Throwable -> L39
        ByteArrayOutputStream r107 = new AnonymousClass1(this, r106);     // Catch: Throwable -> L39
    L25:
        byte[] r108 = this.buf;     // Catch: Throwable -> L39
        int r109 = this.pos;     // Catch: Throwable -> L39
        r107.write(r108, r109, this.end - r109);     // Catch: Throwable -> L39
        this.end = -1;     // Catch: Throwable -> L39
        fillBuf();     // Catch: Throwable -> L39
        int r110 = this.pos;     // Catch: Throwable -> L39
    L27:
        if (r110 == this.end) goto L25;
        byte[] r111 = this.buf;     // Catch: Throwable -> L39
        if (r111[r110] == 10) goto L30;
        r110 = r110 + 1;     // Catch: Throwable -> L39
        goto L27
    L30:
        int r112 = this.pos;     // Catch: Throwable -> L39
        if (r110 == r112) goto L33;
        r107.write(r111, r112, r110 - r112);     // Catch: Throwable -> L39
    L33:
        this.pos = r110 + 1;     // Catch: Throwable -> L39
        String r113 = r107.toString();     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L39
        return r113;
    L38:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L39
    }

    public static /* synthetic */ Charset access$000(StrictLineReader r100) {
        return r100.charset;
    }

    public StrictLineReader(InputStream r100, Charset r101) {
        this(r100, 8192, r101);
    }

    public StrictLineReader(InputStream r100, int r101, Charset r102) {
        if (r100 == null) goto L15;
        if (r102 == null) goto L15;
        if (r101 < 0) goto L13;
        if (r102.equals(Util.US_ASCII) == false) goto L11;
        this.f454372in = r100;
        this.charset = r102;
        this.buf = new byte[r101];
        return;
    L11:
        throw new IllegalArgumentException("Unsupported encoding");
    L13:
        throw new IllegalArgumentException("capacity <= 0");
    L15:
        throw null;
    }
}
