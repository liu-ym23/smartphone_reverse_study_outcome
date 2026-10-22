package com.bytedance.frameworks.baselib.netx.chunk;

import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f244804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f244805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f244806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f244807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f244808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f244809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f244810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f244811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f244812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f244813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f244814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f244815l;

    @Override // java.io.InputStream
    public final synchronized int available() throws IOException {
        monitor-enter(this);
        a();     // Catch: Throwable -> L15
        int r100 = this.f244809f - this.f244808e;
        if (r100 <= 0) goto L9;
        monitor-exit(this);
        return r100;
    L9:
        int r101 = d(false);     // Catch: Throwable -> L15
        if (r101 >= 0) goto L13;
        monitor-exit(this);
        return 0;
    L13:
        monitor-exit(this);
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f244814k == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        InputStream r100 = this.f244804a;     // Catch: Throwable -> L18
        if (r100 != null) goto L21;
    L15:
        this.f244814k = true;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L21:
        StreamParser.safeClose(r100);     // Catch: Throwable -> L12
    L14:
        this.f244804a = null;     // Catch: Throwable -> L18
        goto L15
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        goto L14
    }

    @Override // java.io.InputStream
    public final synchronized int read() throws IOException {
        monitor-enter(this);
        a();     // Catch: Throwable -> L14
        if (this.f244808e >= this.f244809f) goto L6;
    L10:
        byte[] r100 = this.f244807d;     // Catch: Throwable -> L14
        int r101 = this.f244808e;     // Catch: Throwable -> L14
        this.f244808e = r101 + 1;     // Catch: Throwable -> L14
        int r102 = r100[r101] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r102;
    L6:
        if (d(true) > 0) goto L10;
        monitor-exit(this);
        return -1;
    L14:
        th = move-exception;
        throw th;
    }

    public final void a() throws IOException {
        if (this.f244814k == true) goto L6;
        return;
    L6:
        throw new IOException("stream is closed");
    }

    public final int e() throws IOException {
        if (this.f244815l != 5) goto L6;
        return -1;
    L6:
        if (this.f244808e < this.f244809f) goto L9;
        this.f244809f = 0;
        this.f244808e = 0;
    L9:
        if (this.f244815l == 5) goto L10;
        b(32);
        if (this.f244810g == true) goto L16;
        System.currentTimeMillis();     // Catch: IOException -> L29
        InputStream r100 = this.f244804a;     // Catch: IOException -> L29
        byte[] r101 = this.f244811h;     // Catch: IOException -> L29
        int r102 = this.f244813j;     // Catch: IOException -> L29
        int r103 = r100.read(r101, r102, r101.length - r102);     // Catch: IOException -> L29
        System.currentTimeMillis();     // Catch: IOException -> L29
    L17:
        if (r103 < 0) goto L28;
        if (this.f244810g == true) goto L21;
        this.f244813j += r103;
    L21:
        this.f244810g = c(true);
        int r104 = this.f244809f;
        if (r104 <= 0) goto L9;
        if (this.f244815l == 2) goto L9;
        return r104 - this.f244808e;
    L28:
        throw new IOException("Premature EOF");
    L16:
        r103 = this.f244813j - this.f244812i;
    L29:
        e = move-exception;
        throw e;
    L10:
        return -1;
    }

    public a(InputStream r100) {
        this.f244807d = new byte[4096];
        this.f244810g = false;
        this.f244811h = new byte[10240];
        this.f244804a = r100;
    }

    public final void b(int r100) {
        int r101 = this.f244813j;
        int r102 = r101 + r100;
        byte[] r103 = this.f244811h;
        if (r102 <= r103.length) goto L14;
        int r104 = this.f244812i;
        int r105 = r101 - r104;
        int r106 = r100 + r105;
        if (r106 <= r103.length) goto L10;
        byte[] r107 = new byte[r106];
        if (r105 <= 0) goto L9;
        System.arraycopy(r103, r104, r107, 0, r105);
    L9:
        this.f244811h = r107;
    L12:
        this.f244813j = r105;
        this.f244812i = 0;
        return;
    L10:
        if (r105 <= 0) goto L12;
        System.arraycopy(r103, r104, r103, 0, r105);
        goto L12
    }

    public final boolean c(boolean r110) throws IOException {
    L2:
        int r100 = this.f244815l;
        if (r100 == 5) goto L88;
        if (r100 != 1) goto L7;
        int r101 = this.f244812i;
    L57:
        int r102 = this.f244813j;
        if (r101 >= r102) goto L67;
        if (this.f244811h[r101] == 10) goto L67;
        r101 = r101 + 1;
        if ((r101 - this.f244812i) < 2050) goto L57;
        throw new IOException("Chunk header too long");
    L67:
        if (r101 >= r102) goto L68;
        byte[] r103 = this.f244811h;
        int r104 = this.f244812i;
        String r105 = new String(r103, r104, (r101 - r104) + 1, "US-ASCII");
        int r106 = 0;
    L71:
        if (r106 < r105.length()) goto L73;
    L91:
        int r107 = CastIntegerProtector.parseInt(r105.substring(0, r106), 10);     // Catch: NumberFormatException -> L86
        this.f244805b = r107;     // Catch: NumberFormatException -> L86
        this.f244812i = r101 + 1;
        this.f244806c = 0;
        if (r107 > 0) goto L79;
        this.f244815l = 4;
        goto L2
    L79:
        this.f244815l = 2;
        byte[] r108 = this.f244807d;
        if (r108.length >= r107) goto L2;
        int r109 = this.f244809f;
        int r111 = this.f244808e;
        int r112 = r109 - r111;
        byte[] r113 = new byte[r107 + r112];
        if (r112 <= 0) goto L84;
        System.arraycopy(r108, r111, r113, 0, r112);
    L84:
        this.f244807d = r113;
        this.f244808e = 0;
        this.f244809f = r112;
    L87:
        throw new IOException("Bogus chunk size");
    L73:
        if (Character.digit(r105.charAt(r106), 10) == (-1)) goto L91;
        r106 = r106 + 1;
        goto L71
    L68:
        return false;
    L7:
        if (r100 != 2) goto L8;
        int r114 = this.f244812i;
        int r115 = this.f244813j;
        if (r114 >= r115) goto L44;
        int r116 = Math.min(this.f244805b - this.f244806c, r115 - r114);
        byte[] r117 = this.f244807d;
        int r118 = r117.length;
        int r119 = this.f244809f;
        if (r118 >= (r119 + r116)) goto L52;
        int r120 = this.f244808e;
        int r121 = r119 - r120;
        int r122 = r121 + r116;
        if (r117.length >= r122) goto L50;
        byte[] r123 = new byte[r122];
        System.arraycopy(r117, r120, r123, 0, r121);
        this.f244807d = r123;
    L51:
        this.f244808e = 0;
        this.f244809f = r121;
        goto L52
    L50:
        System.arraycopy(r117, r120, r117, 0, r121);
    L52:
        System.arraycopy(this.f244811h, this.f244812i, this.f244807d, this.f244809f, r116);
        this.f244812i += r116;
        this.f244809f += r116;
        int r124 = this.f244806c + r116;
        this.f244806c = r124;
        if ((this.f244805b - r124) > 0) goto L55;
        this.f244815l = 3;
        goto L2
    L55:
        return false;
    L44:
        return false;
    L8:
        if (r100 != 3) goto L9;
        int r125 = this.f244812i;
        if (r125 >= this.f244813j) goto L34;
        if (this.f244811h[r125] != 10) goto L41;
        this.f244812i = r125 + 1;
        this.f244815l = 1;
        if (r110 == false) goto L2;
        return true;
    L41:
        throw new IOException("missing LF");
    L34:
        return false;
    L9:
        if (r100 != 4) goto L2;
        int r126 = this.f244812i;
    L12:
        int r127 = this.f244813j;
        if (r126 >= r127) goto L18;
        if (this.f244811h[r126] == 10) goto L18;
        r126 = r126 + 1;
    L18:
        if (r126 >= r127) goto L19;
        if (r126 == this.f244812i) goto L22;
        this.f244812i = r126 + 1;
        goto L2
    L22:
        this.f244815l = 5;
        InputStream r128 = this.f244804a;
        if (r128 != null) goto L89;
    L30:
        return false;
    L89:
        StreamParser.safeClose(r128);     // Catch: Throwable -> L27
    L29:
        this.f244804a = null;
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L19:
        return false;
    L88:
        return false;
    }

    public final int d(boolean r100) throws IOException {
        if (this.f244815l != 5) goto L6;
        return -1;
    L6:
        if (this.f244808e < this.f244809f) goto L8;
        this.f244809f = 0;
        this.f244808e = 0;
    L8:
        if (r100 == true) goto L10;
        int r101 = this.f244804a.available();
        if (r101 <= 0) goto L33;
        b(r101);
        int r102 = this.f244804a.read(this.f244811h, this.f244813j, r101);     // Catch: IOException -> L30
        if (r102 < 0) goto L43;
        this.f244813j += r102;
        c(false);
        goto L33
    L43:
        return -1;
    L30:
        e = move-exception;
        throw e;
    L33:
        return this.f244809f - this.f244808e;
    L10:
        if (this.f244815l == 5) goto L42;
        b(32);
        InputStream r103 = this.f244804a;     // Catch: IOException -> L21
        byte[] r104 = this.f244811h;     // Catch: IOException -> L21
        int r105 = this.f244813j;     // Catch: IOException -> L21
        int r106 = r103.read(r104, r105, r104.length - r105);     // Catch: IOException -> L21
        if (r106 < 0) goto L20;
        this.f244813j += r106;
        c(false);
        int r107 = this.f244809f;
        if (r107 <= 0) goto L10;
        return r107 - this.f244808e;
    L20:
        throw new IOException("Premature EOF");
    L21:
        e = move-exception;
        throw e;
    L42:
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] r100, int r101, int r102) throws IOException {
        monitor-enter(this);
        a();     // Catch: Throwable -> L48
        if (r101 < 0) goto L47;
        if (r101 > r100.length) goto L47;
        if (r102 < 0) goto L47;
        int r103 = r101 + r102;     // Catch: Throwable -> L48
        if (r103 > r100.length) goto L47;
        if (r103 < 0) goto L47;
        int r104 = 0;
        if (r102 != 0) goto L15;
        monitor-exit(this);
        return 0;
    L15:
        int r105 = this.f244809f - this.f244808e;     // Catch: Throwable -> L48
        if (r105 <= 0) goto L18;
    L41:
        if (r105 >= r102) goto L43;
        r102 = r105;
    L43:
        System.arraycopy(this.f244807d, this.f244808e, r100, r101, r102);     // Catch: Throwable -> L48
        this.f244808e += r102;     // Catch: Throwable -> L48
        monitor-exit(this);
        return r102;
    L18:
        if (this.f244815l != 2) goto L36;
        int r106 = this.f244805b - this.f244806c;
        if (r106 >= r102) goto L23;
        r102 = r106;
    L23:
        if (r102 > 0) goto L51;
    L33:
        monitor-exit(this);
        return r104;
    L51:
        r104 = this.f244804a.read(r100, r101, r102);     // Catch: IOException -> L31 Throwable -> L48
        if (r104 <= 0) goto L30;
        int r107 = this.f244806c + r104;     // Catch: Throwable -> L48
        this.f244806c = r107;     // Catch: Throwable -> L48
        if (r107 < this.f244805b) goto L33;
        this.f244815l = 3;     // Catch: Throwable -> L48
        goto L33
    L30:
        throw new IOException("Premature EOF");     // Catch: Throwable -> L48
    L31:
        e = move-exception;
        throw e;     // Catch: Throwable -> L48
    L36:
        r105 = d(true);     // Catch: Throwable -> L48
        if (r105 >= 0) goto L41;
        monitor-exit(this);
        return -1;
    L47:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }
}
