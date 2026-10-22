package com.larus.cache;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f321283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f321284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f321285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f321286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f321287e;

    /* JADX INFO: loaded from: classes26.dex */
    public class a extends ByteArrayOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f321288a;

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int r100 = ((ByteArrayOutputStream) this).count;
            if (r100 > 0) goto L5;
        L12:
            return new String(((ByteArrayOutputStream) this).buf, 0, r100, this.f321288a.f321284b.name());
        L9:
            e = move-exception;
            throw new AssertionError(e);
        L5:
            if (((ByteArrayOutputStream) this).buf[r100 - 1] != 13) goto L12;
            r100 = r100 - 1;
            goto L12
        }

        public a(g r100, int r101) {
            this.f321288a = r100;
            super(r101);
        }
    }

    public final String a() throws IOException {
        InputStream r100 = this.f321283a;
        monitor-enter(r100);
        byte[] r101 = this.f321285c;     // Catch: Throwable -> L47
        if (r101 == null) goto L46;
        if (this.f321286d < this.f321287e) goto L13;
        int r102 = this.f321283a.read(r101, 0, r101.length);     // Catch: Throwable -> L47
        if (r102 == (-1)) goto L12;
        this.f321286d = 0;     // Catch: Throwable -> L47
        this.f321287e = r102;     // Catch: Throwable -> L47
        goto L13
    L12:
        throw new EOFException();     // Catch: Throwable -> L47
    L13:
        int r103 = this.f321286d;     // Catch: Throwable -> L47
    L15:
        if (r103 == this.f321287e) goto L28;
        byte[] r104 = this.f321285c;     // Catch: Throwable -> L47
        if (r104[r103] == 10) goto L18;
        r103 = r103 + 1;     // Catch: Throwable -> L47
        goto L15
    L18:
        int r105 = this.f321286d;     // Catch: Throwable -> L47
        if (r103 == r105) goto L23;
        int r106 = r103 - 1;     // Catch: Throwable -> L47
        if (r104[r106] != 13) goto L23;
    L24:
        String r107 = new String(r104, r105, r106 - r105, this.f321284b.name());     // Catch: Throwable -> L47
        this.f321286d = r103 + 1;     // Catch: Throwable -> L47
        monitor-exit(r100);     // Catch: Throwable -> L47
        return r107;
    L23:
        r106 = r103;
        goto L24
    L28:
        a r108 = new a(this, (this.f321287e - this.f321286d) + 80);     // Catch: Throwable -> L47
    L29:
        byte[] r109 = this.f321285c;     // Catch: Throwable -> L47
        int r110 = this.f321286d;     // Catch: Throwable -> L47
        r108.write(r109, r110, this.f321287e - r110);     // Catch: Throwable -> L47
        this.f321287e = -1;     // Catch: Throwable -> L47
        InputStream r111 = this.f321283a;     // Catch: Throwable -> L47
        byte[] r112 = this.f321285c;     // Catch: Throwable -> L47
        int r113 = r111.read(r112, 0, r112.length);     // Catch: Throwable -> L47
        if (r113 == (-1)) goto L44;
        this.f321286d = 0;     // Catch: Throwable -> L47
        this.f321287e = r113;     // Catch: Throwable -> L47
        int r114 = 0;
    L33:
        if (r114 == this.f321287e) goto L29;
        byte[] r115 = this.f321285c;     // Catch: Throwable -> L47
        if (r115[r114] == 10) goto L36;
        r114 = r114 + 1;     // Catch: Throwable -> L47
        goto L33
    L36:
        int r116 = this.f321286d;     // Catch: Throwable -> L47
        if (r114 == r116) goto L39;
        r108.write(r115, r116, r114 - r116);     // Catch: Throwable -> L47
    L39:
        this.f321286d = r114 + 1;     // Catch: Throwable -> L47
        String r117 = r108.toString();     // Catch: Throwable -> L47
        monitor-exit(r100);     // Catch: Throwable -> L47
        return r117;
    L44:
        throw new EOFException();     // Catch: Throwable -> L47
    L46:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream r100 = this.f321283a;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f321285c == null) goto L7;
        this.f321285c = null;     // Catch: Throwable -> L9
        this.f321283a.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public g(PolarisFileInputStreamWrapper r100, Charset r101) {
        if (r101 == null) goto L11;
        if (r101.equals(StandardCharsets.US_ASCII) == false) goto L9;
        this.f321283a = r100;
        this.f321284b = r101;
        this.f321285c = new byte[8192];
        return;
    L9:
        throw new IllegalArgumentException("Unsupported encoding");
    L11:
        throw null;
    }
}
