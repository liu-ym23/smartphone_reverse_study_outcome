package com.bytedance.crash.upload;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f203356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f203357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f203358c;

    public static class a extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f203359a;

        public a(OutputStream r100) {
            super(r100);
            this.f203359a = 0;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(int r100) throws IOException {
            this.f203359a++;
            ((FilterOutputStream) this).out.write(r100);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] r100, int r101, int r102) throws IOException {
            this.f203359a += (long) r102;
            ((FilterOutputStream) this).out.write(r100, r101, r102);
        }
    }

    public static class b extends DataOutputStream {
        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        public final void a() throws IOException {
            super.close();
        }

        public b(a r100) {
            super(r100);
        }
    }

    public static class c extends GZIPOutputStream {
        @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
        public final void finish() {
        }

        public final void a() throws IOException {
            super.close();
        }

        public final void b() throws IOException {
            super.finish();
        }

        public c(a r100) throws IOException {
            super(r100);
        }
    }

    public static byte[] a(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[8192];
    L3:
        int r103 = r100.read(r102);
        if ((-1) == r103) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    L6:
        r100.close();
        byte[] r104 = r101.toByteArray();     // Catch: Throwable -> L10
        com.bytedance.crash.util.g.a(r101);
        return r104;
    L10:
        th = move-exception;
        com.bytedance.crash.util.g.a(r101);
        throw th;
    }

    public d(OutputStream r100, boolean r101) throws IOException {
        a r102 = new a(r100);
        this.f203357b = r102;
        if (r101 == false) goto L5;
        this.f203356a = new c(r102);
    L6:
        this.f203358c = r101;
        return;
    L5:
        this.f203356a = new b(r102);
        goto L6
    }
}
