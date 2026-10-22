package com.larus.audio.utils;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes24.dex */
public final class o0 implements Closeable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f290095p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f290096q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f290097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f290098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f290099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f290100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f290101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f290102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f290103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f290104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f290105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Writer f290106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, d> f290107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f290108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f290109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PThreadPoolExecutor f290110n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f290111o;

    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f290112a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            o0 r100 = this.f290112a;
            monitor-enter(r100);
            o0 r101 = this.f290112a;     // Catch: Throwable -> L16
            if (r101.f290106j != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L16
            return null;
        L8:
            r101.n();     // Catch: Throwable -> L16
            this.f290112a.m();     // Catch: Throwable -> L16
            o0 r102 = this.f290112a;     // Catch: Throwable -> L16
            if (r102.f290108l < 2000) goto L11;
            boolean r103 = true;
        L12:
            if (r103 == false) goto L14;
            r102.j();     // Catch: Throwable -> L16
            this.f290112a.f290108l = 0;     // Catch: Throwable -> L16
        L14:
            monitor-exit(r100);     // Catch: Throwable -> L16
            return null;
        L11:
            r103 = false;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public a(o0 r100) {
            this.f290112a = r100;
        }
    }

    public class b extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r100) throws IOException {
        }

        public b() {
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f290113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f290114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f290115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o0 f290116d;

        public final class a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f290117a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                this.f290117a.f290115c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                this.f290117a.f290115c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                this.f290117a.f290115c = true;
            }

            public a(c r100, PolarisFileOutputStreamWrapper r101) {
                this.f290117a = r100;
                super(r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                this.f290117a.f290115c = true;
            }
        }

        public final void a() throws IOException {
            o0.a(this.f290116d, this, false);
        }

        public final OutputStream b() throws IOException {
            o0 r100 = this.f290116d;
            if (r100.f290104h <= 0) goto L27;
            monitor-enter(r100);
            d r101 = this.f290113a;     // Catch: Throwable -> L23
            if (r101.f290121d != this) goto L22;
            if (r101.f290120c == true) goto L10;
            this.f290114b[0] = true;     // Catch: Throwable -> L23
        L10:
            PolarisFileWrapper r102 = r101.b(0);     // Catch: Throwable -> L23
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102, true);     // Catch: FileNotFoundException -> L13 Throwable -> L23
        L15:
            a r104 = new a(this, r103);     // Catch: Throwable -> L23
            monitor-exit(r100);     // Catch: Throwable -> L23
            return r104;
        L13:
            this.f290116d.f290097a.mkdirs();     // Catch: Throwable -> L23
            r103 = new PolarisFileOutputStreamWrapper(r102, true);     // Catch: FileNotFoundException -> L18 Throwable -> L23
        L20:
            return o0.f290096q;
        L22:
            throw new IOException("currentEditor changed");     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.f290116d.f290104h);
        }

        public c(o0 r100, d r101) {
            this.f290116d = r100;
            this.f290113a = r101;
            if (r101.f290120c == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f290114b = r102;
            return;
        L5:
            r102 = new boolean[r100.f290104h];
            goto L6
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f290118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f290119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f290120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f290121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o0 f290122e;

        public final String c() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f290119b;
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            long r104 = r101[r103];
            r100.append(' ');
            r100.append(r104);
            r103 = r103 + 1;
            goto L3
        L6:
            return r100.toString();
        }

        public final PolarisFileWrapper a(int r100) {
            File r101 = this.f290122e.f290097a;
            StringBuilder r102 = new StringBuilder();
            r102.append(this.f290118a);
            if (r100 <= 1) goto L5;
            String r103 = "." + r100;
        L6:
            r102.append(r103);
            return new PolarisFileWrapper(r101, r102.toString());
        L5:
            r103 = "";
            goto L6
        }

        public final PolarisFileWrapper b(int r100) {
            File r101 = this.f290122e.f290097a;
            StringBuilder r102 = new StringBuilder();
            r102.append(this.f290118a);
            String r103 = DefaultDiskStorage.FileType.TEMP;
            if (r100 <= 1) goto L5;
            r103 = "." + r100 + DefaultDiskStorage.FileType.TEMP;
        L5:
            r102.append(r103);
            return new PolarisFileWrapper(r101, r102.toString());
        }

        public d(o0 r100, String r101) {
            this.f290122e = r100;
            this.f290118a = r101;
            this.f290119b = new long[r100.f290104h];
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream[] f290123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File[] f290124b;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r100 = this.f290123a;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            k0.a(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public e(InputStream[] r100, File[] r101) {
            this.f290123a = r100;
            this.f290124b = r101;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f290106j != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f290107k.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        c r101 = ((d) r100.next()).f290121d;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        r101.a();     // Catch: Throwable -> L16
        goto L9
    L13:
        n();     // Catch: Throwable -> L16
        m();     // Catch: Throwable -> L16
        this.f290106j.close();     // Catch: Throwable -> L16
        this.f290106j = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public void delete() throws IOException {
        delete(false);
    }

    public final synchronized void j() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f290106j;     // Catch: Throwable -> L24
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f290099c), StandardCharsets.US_ASCII));     // Catch: Throwable -> L24
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("1");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f290101e));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f290104h));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        Iterator<d> r102 = this.f290107k.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r102.hasNext() == false) goto L15;
        d r103 = r102.next();     // Catch: Throwable -> L21
        if (r103.f290121d != null) goto L12;
        r101.write("CLEAN " + r103.f290118a + r103.c() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r101.write("DIRTY " + r103.f290118a + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r101.close();     // Catch: Throwable -> L24
        if (this.f290098b.exists() == false) goto L18;
        l(this.f290098b, this.f290100d, true);     // Catch: Throwable -> L24
    L18:
        l(this.f290099c, this.f290098b, false);     // Catch: Throwable -> L24
        this.f290100d.delete();     // Catch: Throwable -> L24
        this.f290106j = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f290098b, true), StandardCharsets.US_ASCII));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    static {
        f290095p = PatternProtector.compile("[a-zA-Z0-9\\._-]+");
        f290096q = new b();
    }

    public final void b() {
        if (this.f290106j == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final void g() throws IOException {
        c(this.f290099c);
        Iterator<d> r100 = this.f290107k.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        d r101 = r100.next();
        int r102 = 0;
        if (r101.f290121d == null) goto L8;
        r101.f290121d = null;
    L12:
        if (r102 >= this.f290104h) goto L14;
        c(r101.a(r102));
        c(r101.b(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f290104h) goto L4;
        this.f290105i += r101.f290119b[r102];
        r102 = r102 + 1;
        goto L8
    }

    public final void h() throws IOException {
        b1 r100 = new b1(new PolarisFileInputStreamWrapper(this.f290098b), StandardCharsets.US_ASCII);
        String r101 = r100.a();     // Catch: Throwable -> L26
        String r102 = r100.a();     // Catch: Throwable -> L26
        String r103 = r100.a();     // Catch: Throwable -> L26
        String r104 = r100.a();     // Catch: Throwable -> L26
        String r105 = r100.a();     // Catch: Throwable -> L26
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L25;
        if ("1".equals(r102) == false) goto L25;
        if (Integer.toString(this.f290101e).equals(r103) == false) goto L25;
        if (Integer.toString(this.f290104h).equals(r104) == false) goto L25;
        if ("".equals(r105) == false) goto L25;
        boolean r106 = false;
        int r107 = 0;
    L29:
        i(r100.a());     // Catch: EOFException -> L16 Throwable -> L26
        r107 = r107 + 1;
        goto L29
    L16:
        this.f290108l = r107 - this.f290107k.size();     // Catch: Throwable -> L26
        if (r100.f290023e != (-1)) goto L19;
        r106 = true;
    L19:
        if (r106 == false) goto L21;
        j();     // Catch: Throwable -> L26
    L22:
        k0.a(r100);
        return;
    L21:
        this.f290106j = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f290098b, true), StandardCharsets.US_ASCII));     // Catch: Throwable -> L26
    L25:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        k0.a(r100);
        throw th;
    }

    public final void m() throws IOException {
    L3:
        if (this.f290107k.size() <= this.f290103g) goto L5;
        k(this.f290107k.entrySet().iterator().next().getKey());
        goto L3
    }

    public final void n() throws IOException {
    L3:
        if (this.f290105i <= this.f290102f) goto L5;
        k(this.f290107k.entrySet().iterator().next().getKey());
        goto L3
    }

    public static void c(PolarisFileWrapper r100) throws IOException {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void p(String r100) {
        if (f290095p.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-zA-Z0-9\\._-]+: \"" + r100 + "\"");
    }

    public final c d(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L14
        p(r100);     // Catch: Throwable -> L14
        d r101 = this.f290107k.get(r100);     // Catch: Throwable -> L14
        if (r101 != null) goto L7;
        r101 = new d(this, r100);     // Catch: Throwable -> L14
        this.f290107k.put(r100, r101);     // Catch: Throwable -> L14
    L11:
        c r102 = new c(this, r101);     // Catch: Throwable -> L14
        r101.f290121d = r102;     // Catch: Throwable -> L14
        this.f290106j.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L14
        this.f290106j.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
    L13:
        return r102;
    L7:
        r102 = r101.f290121d;     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        monitor-exit(this);
    L14:
        th = move-exception;
        throw th;
    }

    public void delete(boolean r100) throws IOException {
        close();
        p0.b(this.f290097a, r100);
    }

    public final synchronized e e(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L34
        p(r100);     // Catch: Throwable -> L34
        d r101 = this.f290107k.get(r100);     // Catch: Throwable -> L34
        if (r101 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r101.f290120c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        int r102 = this.f290104h;     // Catch: Throwable -> L34
        InputStream[] r103 = new InputStream[r102];     // Catch: Throwable -> L34
        File[] r104 = new File[r102];     // Catch: Throwable -> L34
        int r105 = 0;
        int r106 = 0;
    L39:
        if (r106 >= this.f290104h) goto L18;
        r103[r106] = new PolarisFileInputStreamWrapper(r101.a(r106));     // Catch: FileNotFoundException -> L37 Throwable -> L34
        r104[r106] = r101.a(r106);     // Catch: FileNotFoundException -> L37 Throwable -> L34
        r106 = r106 + 1;
        goto L39
    L18:
        this.f290108l++;     // Catch: Throwable -> L34
        this.f290106j.append("READ " + r100 + '\n');     // Catch: Throwable -> L34
        if (this.f290108l < 2000) goto L21;
        r105 = 1;
    L21:
        if (r105 == 0) goto L23;
        this.f290110n.submit(this.f290111o);     // Catch: Throwable -> L34
    L23:
        e r107 = new e(r103, r104);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r107;
    L27:
        if (r105 >= this.f290104h) goto L32;
        InputStream r108 = r103[r105];     // Catch: Throwable -> L34
        if (r108 == null) goto L32;
        k0.a(r108);     // Catch: Throwable -> L34
        r105 = r105 + 1;
    L32:
        monitor-exit(this);
        return null;
    L34:
        th = move-exception;
        throw th;
    }

    public final void i(String r100) throws IOException {
        int r101 = r100.indexOf(32);
        if (r101 == (-1)) goto L47;
        int r102 = r101 + 1;
        int r103 = r100.indexOf(32, r102);
        if (r103 != (-1)) goto L12;
        String r104 = r100.substring(r102);
        if (r101 == 6) goto L9;
    L13:
        d r105 = this.f290107k.get(r104);
        if (r105 != null) goto L17;
        r105 = new d(this, r104);
        this.f290107k.put(r104, r105);
    L17:
        if (r103 == (-1)) goto L32;
        if (r101 != 5) goto L32;
        if (r100.startsWith("CLEAN") == false) goto L32;
        String[] r106 = r100.substring(r103 + 1).split(" ");
        r105.f290120c = true;
        r105.f290121d = null;
        if (r106.length != r105.f290122e.f290104h) goto L31;
        int r107 = 0;
    L48:
        if (r107 >= r106.length) goto L52;
        r105.f290119b[r107] = CastLongProtector.parseLong(r106[r107]);     // Catch: NumberFormatException -> L28
        r107 = r107 + 1;
        goto L48
    L52:
        return;
    L29:
        throw new IOException("unexpected journal line: " + Arrays.toString(r106));
    L31:
        throw new IOException("unexpected journal line: " + Arrays.toString(r106));
    L32:
        if (r103 != (-1)) goto L37;
        if (r101 != 5) goto L37;
        if (r100.startsWith("DIRTY") == false) goto L37;
        r105.f290121d = new c(this, r105);
        return;
    L37:
        if (r103 != (-1)) goto L45;
        if (r101 != 4) goto L45;
        if (r100.startsWith("READ") == false) goto L45;
        c68.b.a("AudioDiskLruCache", "This work was already done by calling lruEntries.get()");
        return;
    L45:
        throw new IOException("unexpected journal line: ".concat(r100));
    L9:
        if (r100.startsWith("REMOVE") == false) goto L13;
        this.f290107k.remove(r104);
        return;
    L12:
        r104 = r100.substring(r102, r103);
        goto L13
    L47:
        throw new IOException("unexpected journal line: ".concat(r100));
    }

    public final synchronized void k(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L28
        p(r100);     // Catch: Throwable -> L28
        d r101 = this.f290107k.get(r100);     // Catch: Throwable -> L28
        if (r101 != null) goto L6;
    L26:
        monitor-exit(this);
        return;
    L6:
        if (r101.f290121d != null) goto L26;
        boolean r102 = false;
        int r103 = 0;
    L10:
        if (r103 >= this.f290104h) goto L19;
        PolarisFileWrapper r104 = r101.a(r103);     // Catch: Throwable -> L28
        if (r104.exists() == false) goto L18;
        if (r104.delete() == true) goto L18;
        throw new IOException("failed to delete " + r104);     // Catch: Throwable -> L28
    L18:
        long r105 = this.f290105i;     // Catch: Throwable -> L28
        long[] r106 = r101.f290119b;     // Catch: Throwable -> L28
        this.f290105i = r105 - r106[r103];     // Catch: Throwable -> L28
        r106[r103] = 0;     // Catch: Throwable -> L28
        r103 = r103 + 1;     // Catch: Throwable -> L28
        goto L10
    L19:
        this.f290108l++;     // Catch: Throwable -> L28
        this.f290106j.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L28
        this.f290107k.remove(r100);     // Catch: Throwable -> L28
        if (this.f290108l < 2000) goto L22;
        r102 = true;
    L22:
        if (r102 == false) goto L24;
        this.f290110n.submit(this.f290111o);     // Catch: Throwable -> L28
    L24:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public o0(PolarisFileWrapper r110, int r111) {
        this.f290105i = 0;
        this.f290107k = new LinkedHashMap(0, 0.75f, true);
        this.f290109m = 0;
        this.f290111o = new a(this);
        this.f290097a = r110;
        this.f290101e = 0;
        this.f290098b = new PolarisFileWrapper(r110, "journal");
        this.f290099c = new PolarisFileWrapper(r110, "journal.tmp");
        this.f290100d = new PolarisFileWrapper(r110, "journal.bkp");
        this.f290104h = 1;
        this.f290102f = 52428800;
        this.f290103g = r111;
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new n0());
        this.f290110n = r100;
        r100.allowCoreThreadTimeOut(true);
    }

    public static o0 f(PolarisFileWrapper r100, int r101) throws IOException {
        if (r101 <= 0) goto L18;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "journal.bkp");
        if (r102.exists() == false) goto L9;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, "journal");
        if (r103.exists() == false) goto L8;
        r102.delete();
        goto L9
    L8:
        l(r102, r103, false);
    L9:
        o0 r104 = new o0(r100, r101);
        if (r104.f290098b.exists() == true) goto L19;
    L15:
        r100.mkdirs();
        o0 r105 = new o0(r100, r101);
        r105.j();
        return r105;
    L19:
        r104.h();     // Catch: IOException -> L13
        r104.g();     // Catch: IOException -> L13
        return r104;
    L13:
        e = move-exception;
        int r106 = c68.b.f22600a;
        c68.b.b("AudioDiskLruCache", "DiskLruCache " + r100 + " is corrupt: " + e.getMessage() + ", removing");
        r104.delete();
        goto L15
    L18:
        throw new IllegalArgumentException("maxItemSize <= 0");
    }

    public static void a(o0 r100, c r101, boolean r110) throws IOException {
        monitor-enter(r100);
        d r102 = r101.f290113a;     // Catch: Throwable -> L51
        if (r102.f290121d != r101) goto L50;
        boolean r103 = false;
        if (r110 == true) goto L8;
    L22:
        int r104 = 0;
    L24:
        if (r104 >= r100.f290104h) goto L32;
        PolarisFileWrapper r105 = r102.b(r104);     // Catch: Throwable -> L51
        if (r110 == true) goto L28;
        c(r105);     // Catch: Throwable -> L51
    L31:
        r104 = r104 + 1;     // Catch: Throwable -> L51
        goto L24
    L28:
        if (r105.exists() == false) goto L31;
        PolarisFileWrapper r106 = r102.a(r104);     // Catch: Throwable -> L51
        p0.c(r105, r106);     // Catch: Throwable -> L51
        long r107 = r102.f290119b[r104];     // Catch: Throwable -> L51
        long r108 = r106.length();     // Catch: Throwable -> L51
        r102.f290119b[r104] = r108;     // Catch: Throwable -> L51
        r100.f290105i = (r100.f290105i - r107) + r108;     // Catch: Throwable -> L51
        goto L31
    L32:
        r100.f290108l++;     // Catch: Throwable -> L51
        r102.f290121d = null;     // Catch: Throwable -> L51
        if ((r102.f290120c | r110) == false) goto L37;
        r102.f290120c = true;     // Catch: Throwable -> L51
        r100.f290106j.write("CLEAN " + r102.f290118a + r102.c() + '\n');     // Catch: Throwable -> L51
        if (r110 == false) goto L38;
        r100.f290109m++;     // Catch: Throwable -> L51
        r102.getClass();     // Catch: Throwable -> L51
    L38:
        r100.f290106j.flush();     // Catch: Throwable -> L51
        if (r100.f290105i <= r100.f290102f) goto L41;
    L46:
        r100.f290110n.submit(r100.f290111o);     // Catch: Throwable -> L51
    L47:
        monitor-exit(r100);
        return;
    L41:
        if (r100.f290108l < 2000) goto L43;
        r103 = true;
    L43:
        if (r103 == true) goto L46;
        if (r100.f290107k.size() <= r100.f290103g) goto L47;
    L37:
        r100.f290107k.remove(r102.f290118a);     // Catch: Throwable -> L51
        r100.f290106j.write("REMOVE " + r102.f290118a + '\n');     // Catch: Throwable -> L51
        goto L38
    L8:
        if (r102.f290120c == true) goto L22;
        int r109 = 0;
    L11:
        if (r109 >= r100.f290104h) goto L22;
        if (r101.f290114b[r109] == false) goto L20;
        if (r102.b(r109).exists() == false) goto L16;
        r109 = r109 + 1;
        goto L11
    L16:
        r101.a();     // Catch: Throwable -> L51
        monitor-exit(r100);
        return;
    L20:
        r101.a();     // Catch: Throwable -> L51
        throw new IOException("Newly created entry didn't create value for index " + r109);     // Catch: Throwable -> L51
    L50:
        throw new IOException();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    public static void l(PolarisFileWrapper r100, PolarisFileWrapper r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        c(r101);
    L5:
        if (p0.c(r100, r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }
}
