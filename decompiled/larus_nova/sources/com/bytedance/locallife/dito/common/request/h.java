package com.bytedance.locallife.dito.common.request;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f257671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f257672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f257673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f257674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f257675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f257676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f257677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f257678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f257679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f257680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f257681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f257682l;

    @Override // java.io.InputStream
    public final synchronized int available() throws IOException {
        monitor-enter(this);
        a();     // Catch: Throwable -> L15
        int r100 = this.f257676f - this.f257675e;
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
        if (this.f257681k == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        InputStream r100 = this.f257671a;     // Catch: Throwable -> L18
        if (r100 != null) goto L24;
    L15:
        this.f257681k = true;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L24:
        r100.close();     // Catch: Throwable -> L12 Exception -> L21
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
    L14:
        this.f257671a = null;     // Catch: Throwable -> L18
        goto L15
    }

    @Override // java.io.InputStream
    public final synchronized int read() throws IOException {
        monitor-enter(this);
        a();     // Catch: Throwable -> L14
        if (this.f257675e >= this.f257676f) goto L6;
    L10:
        byte[] r100 = this.f257674d;     // Catch: Throwable -> L14
        int r101 = this.f257675e;     // Catch: Throwable -> L14
        this.f257675e = r101 + 1;     // Catch: Throwable -> L14
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
        if (this.f257681k == true) goto L6;
        return;
    L6:
        throw new IOException("stream is closed");
    }

    public final int e() throws IOException {
        if (this.f257682l != 5) goto L6;
        return -1;
    L6:
        if (this.f257675e < this.f257676f) goto L9;
        this.f257676f = 0;
        this.f257675e = 0;
    L9:
        if (this.f257682l == 5) goto L10;
        b(32);
        if (this.f257677g == true) goto L16;
        InputStream r100 = this.f257671a;     // Catch: IOException -> L29
        byte[] r101 = this.f257678h;     // Catch: IOException -> L29
        int r102 = this.f257680j;     // Catch: IOException -> L29
        int r103 = r100.read(r101, r102, r101.length - r102);     // Catch: IOException -> L29
    L17:
        if (r103 < 0) goto L28;
        if (this.f257677g == true) goto L21;
        this.f257680j += r103;
    L21:
        this.f257677g = c(true);
        int r104 = this.f257676f;
        if (r104 <= 0) goto L9;
        if (this.f257682l == 2) goto L9;
        return r104 - this.f257675e;
    L28:
        throw new IOException("Premature EOF");
    L16:
        r103 = this.f257680j - this.f257679i;
    L29:
        e = move-exception;
        throw e;
    L10:
        return -1;
    }

    public h(InputStream r100) {
        this.f257674d = new byte[4096];
        this.f257677g = false;
        this.f257678h = new byte[10240];
        this.f257671a = r100;
    }

    public final void b(int r100) {
        int r101 = this.f257680j;
        int r102 = r101 + r100;
        byte[] r103 = this.f257678h;
        if (r102 <= r103.length) goto L14;
        int r104 = this.f257679i;
        int r105 = r101 - r104;
        int r106 = r100 + r105;
        if (r106 <= r103.length) goto L10;
        byte[] r107 = new byte[r106];
        if (r105 <= 0) goto L9;
        System.arraycopy(r103, r104, r107, 0, r105);
    L9:
        this.f257678h = r107;
    L12:
        this.f257680j = r105;
        this.f257679i = 0;
        return;
    L10:
        if (r105 <= 0) goto L12;
        System.arraycopy(r103, r104, r103, 0, r105);
        goto L12
    }

    public final boolean c(boolean r110) throws IOException {
    L2:
        int r100 = this.f257682l;
        if (r100 == 5) goto L101;
        if (r100 != 1) goto L7;
        int r101 = this.f257679i;
    L70:
        int r102 = this.f257680j;
        if (r101 >= r102) goto L80;
        if (this.f257678h[r101] == 10) goto L80;
        r101 = r101 + 1;
        if ((r101 - this.f257679i) < 2050) goto L70;
        throw new IOException("Chunk header too long");
    L80:
        if (r101 >= r102) goto L81;
        byte[] r103 = this.f257678h;
        int r104 = this.f257679i;
        String r105 = new String(r103, r104, (r101 - r104) + 1, "US-ASCII");
        int r106 = 0;
    L84:
        if (r106 < r105.length()) goto L86;
    L103:
        int r107 = CastIntegerProtector.parseInt(r105.substring(0, r106), 16);     // Catch: NumberFormatException -> L99
        this.f257672b = r107;     // Catch: NumberFormatException -> L99
        this.f257679i = r101 + 1;
        this.f257673c = 0;
        if (r107 > 0) goto L92;
        this.f257682l = 4;
        goto L2
    L92:
        this.f257682l = 2;
        byte[] r108 = this.f257674d;
        if (r108.length >= r107) goto L2;
        int r109 = this.f257676f;
        int r111 = this.f257675e;
        int r112 = r109 - r111;
        byte[] r113 = new byte[r107 + r112];
        if (r112 <= 0) goto L97;
        System.arraycopy(r108, r111, r113, 0, r112);
    L97:
        this.f257674d = r113;
        this.f257675e = 0;
        this.f257676f = r112;
    L100:
        throw new IOException("Bogus chunk size");
    L86:
        if (Character.digit(r105.charAt(r106), 16) == (-1)) goto L103;
        r106 = r106 + 1;
        goto L84
    L81:
        return false;
    L7:
        if (r100 != 2) goto L9;
        int r114 = this.f257679i;
        int r115 = this.f257680j;
        if (r114 >= r115) goto L57;
        int r116 = Math.min(this.f257672b - this.f257673c, r115 - r114);
        byte[] r117 = this.f257674d;
        int r118 = r117.length;
        int r119 = this.f257676f;
        if (r118 >= (r119 + r116)) goto L65;
        int r120 = this.f257675e;
        int r121 = r119 - r120;
        int r122 = r121 + r116;
        if (r117.length >= r122) goto L63;
        byte[] r123 = new byte[r122];
        System.arraycopy(r117, r120, r123, 0, r121);
        this.f257674d = r123;
    L64:
        this.f257675e = 0;
        this.f257676f = r121;
        goto L65
    L63:
        System.arraycopy(r117, r120, r117, 0, r121);
    L65:
        System.arraycopy(this.f257678h, this.f257679i, this.f257674d, this.f257676f, r116);
        this.f257679i += r116;
        this.f257676f += r116;
        int r124 = this.f257673c + r116;
        this.f257673c = r124;
        if ((this.f257672b - r124) > 0) goto L68;
        this.f257682l = 3;
        goto L2
    L68:
        return false;
    L57:
        return false;
    L9:
        if (r100 != 3) goto L10;
        int r125 = this.f257679i;
        int r126 = r125 + 1;
        if (r126 >= this.f257680j) goto L43;
        byte[] r127 = this.f257678h;
        if (r127[r125] != 13) goto L54;
        if (r127[r126] != 10) goto L52;
        this.f257679i = r125 + 2;
        this.f257682l = 1;
        if (r110 == false) goto L2;
        return true;
    L52:
        throw new IOException("missing LF");
    L54:
        throw new IOException("missing CR");
    L43:
        return false;
    L10:
        if (r100 != 4) goto L2;
        int r128 = this.f257679i;
    L13:
        int r129 = this.f257680j;
        if (r128 >= r129) goto L19;
        if (this.f257678h[r128] == 10) goto L19;
        r128 = r128 + 1;
    L19:
        if (r128 >= r129) goto L20;
        int r130 = this.f257679i;
        if (r128 == r130) goto L40;
        if (this.f257678h[r128 - 1] != 13) goto L38;
        if (r128 == (r130 + 1)) goto L27;
        this.f257679i = r128 + 1;
        goto L2
    L27:
        this.f257682l = 5;
        InputStream r131 = this.f257671a;
        if (r131 != null) goto L105;
    L35:
        return false;
    L105:
        r131.close();     // Catch: Throwable -> L32 Exception -> L102
    L32:
        th = move-exception;
        th.printStackTrace();
    L34:
        this.f257671a = null;
        goto L35
    L38:
        throw new IOException("LF should be proceeded by CR");
    L40:
        throw new IOException("LF should be proceeded by CR");
    L20:
        return false;
    L101:
        return false;
    }

    public final int d(boolean r100) throws IOException {
        if (this.f257682l != 5) goto L6;
        return -1;
    L6:
        if (this.f257675e < this.f257676f) goto L8;
        this.f257676f = 0;
        this.f257675e = 0;
    L8:
        if (r100 == true) goto L10;
        int r101 = this.f257671a.available();
        if (r101 <= 0) goto L33;
        b(r101);
        int r102 = this.f257671a.read(this.f257678h, this.f257680j, r101);     // Catch: IOException -> L30
        if (r102 < 0) goto L43;
        this.f257680j += r102;
        c(false);
        goto L33
    L43:
        return -1;
    L30:
        e = move-exception;
        throw e;
    L33:
        return this.f257676f - this.f257675e;
    L10:
        if (this.f257682l == 5) goto L42;
        b(32);
        InputStream r103 = this.f257671a;     // Catch: IOException -> L21
        byte[] r104 = this.f257678h;     // Catch: IOException -> L21
        int r105 = this.f257680j;     // Catch: IOException -> L21
        int r106 = r103.read(r104, r105, r104.length - r105);     // Catch: IOException -> L21
        if (r106 < 0) goto L20;
        this.f257680j += r106;
        c(false);
        int r107 = this.f257676f;
        if (r107 <= 0) goto L10;
        return r107 - this.f257675e;
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
        int r105 = this.f257676f - this.f257675e;     // Catch: Throwable -> L48
        if (r105 <= 0) goto L18;
    L41:
        if (r105 >= r102) goto L43;
        r102 = r105;
    L43:
        System.arraycopy(this.f257674d, this.f257675e, r100, r101, r102);     // Catch: Throwable -> L48
        this.f257675e += r102;     // Catch: Throwable -> L48
        monitor-exit(this);
        return r102;
    L18:
        if (this.f257682l != 2) goto L36;
        int r106 = this.f257672b - this.f257673c;
        if (r106 >= r102) goto L23;
        r102 = r106;
    L23:
        if (r102 > 0) goto L51;
    L33:
        monitor-exit(this);
        return r104;
    L51:
        r104 = this.f257671a.read(r100, r101, r102);     // Catch: IOException -> L31 Throwable -> L48
        if (r104 <= 0) goto L30;
        int r107 = this.f257673c + r104;     // Catch: Throwable -> L48
        this.f257673c = r107;     // Catch: Throwable -> L48
        if (r107 < this.f257672b) goto L33;
        this.f257682l = 3;     // Catch: Throwable -> L48
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
