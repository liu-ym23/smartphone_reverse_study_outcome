package com.larus.cache;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
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

/* JADX INFO: loaded from: classes4.dex */
public final class f implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f321254o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f321255p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f321256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f321257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f321258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f321259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f321260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f321261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f321262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f321263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Writer f321264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<String, d> f321265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f321266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f321267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PThreadPoolExecutor f321268m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f321269n;

    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f321270a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            f r100 = this.f321270a;
            monitor-enter(r100);
            f r101 = this.f321270a;     // Catch: Throwable -> L13
            if (r101.f321264i != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L13
            return null;
        L8:
            r101.n();     // Catch: Throwable -> L13
            if (this.f321270a.f() == false) goto L11;
            this.f321270a.k();     // Catch: Throwable -> L13
            this.f321270a.f321266k = 0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L13
            return null;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public a(f r100) {
            this.f321270a = r100;
        }
    }

    public class b extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r100) throws IOException {
        }

        public b() {
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f321271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f321272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f321273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f321274d;

        public final class a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f321275a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                this.f321275a.f321273c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                this.f321275a.f321273c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                this.f321275a.f321273c = true;
            }

            public a(c r100, PolarisFileOutputStreamWrapper r101) {
                this.f321275a = r100;
                super(r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                this.f321275a.f321273c = true;
            }
        }

        public final void a() throws IOException {
            f.a(this.f321274d, this, false);
        }

        public final OutputStream b() throws IOException {
            f r100 = this.f321274d;
            if (r100.f321262g <= 0) goto L27;
            monitor-enter(r100);
            d r101 = this.f321271a;     // Catch: Throwable -> L23
            if (r101.f321279d != this) goto L22;
            if (r101.f321278c == true) goto L10;
            this.f321272b[0] = true;     // Catch: Throwable -> L23
        L10:
            PolarisFileWrapper r102 = r101.b(0);     // Catch: Throwable -> L23
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L13 Throwable -> L23
        L15:
            a r104 = new a(this, r103);     // Catch: Throwable -> L23
            monitor-exit(r100);     // Catch: Throwable -> L23
            return r104;
        L13:
            this.f321274d.f321256a.mkdirs();     // Catch: Throwable -> L23
            r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L18 Throwable -> L23
        L20:
            return f.f321255p;
        L22:
            throw new IOException("currentEditor changed");     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.f321274d.f321262g);
        }

        public c(f r100, d r101) {
            this.f321274d = r100;
            this.f321271a = r101;
            if (r101.f321278c == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f321272b = r102;
            return;
        L5:
            r102 = new boolean[r100.f321262g];
            goto L6
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f321276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f321277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f321278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f321279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f f321280e;

        public final String c() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f321277b;
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
            File r101 = this.f321280e.f321256a;
            StringBuilder r102 = new StringBuilder();
            r102.append(this.f321276a);
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
            File r101 = this.f321280e.f321256a;
            StringBuilder r102 = new StringBuilder();
            r102.append(this.f321276a);
            String r103 = DefaultDiskStorage.FileType.TEMP;
            if (r100 <= 1) goto L5;
            r103 = "." + r100 + DefaultDiskStorage.FileType.TEMP;
        L5:
            r102.append(r103);
            return new PolarisFileWrapper(r101, r102.toString());
        }

        public d(f r100, String r101) {
            this.f321280e = r100;
            this.f321276a = r101;
            this.f321277b = new long[r100.f321262g];
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream[] f321281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File[] f321282b;

        public final String a() throws IOException {
            InputStream r100 = this.f321281a[0];
            Pattern r101 = f.f321254o;
            InputStreamReader r102 = new InputStreamReader(r100, StandardCharsets.UTF_8);
            StringWriter r103 = new StringWriter();     // Catch: Throwable -> L19
            char[] r104 = new char[1024];     // Catch: Throwable -> L13
        L6:
            int r105 = r102.read(r104);     // Catch: Throwable -> L13
            if (r105 == (-1)) goto L9;
            r103.write(r104, 0, r105);     // Catch: Throwable -> L13
            goto L6
        L9:
            String r106 = r103.toString();     // Catch: Throwable -> L13
            r103.close();     // Catch: Throwable -> L19
            r102.close();
            return r106;
        L13:
            th = move-exception;
            r103.close();     // Catch: Throwable -> L16
        L18:
            throw th;     // Catch: Throwable -> L19
        L16:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            r102.close();
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r100 = this.f321281a;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            com.larus.utils.g.a(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public e(InputStream[] r100, File[] r101) {
            this.f321281a = r100;
            this.f321282b = r101;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f321264i != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f321265j.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        c r101 = ((d) r100.next()).f321279d;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        r101.a();     // Catch: Throwable -> L16
        goto L9
    L13:
        n();     // Catch: Throwable -> L16
        this.f321264i.close();     // Catch: Throwable -> L16
        this.f321264i = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public void delete() throws IOException {
        delete(false);
    }

    public final synchronized void flush() throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        n();     // Catch: Throwable -> L6
        this.f321264i.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.f321264i != null) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void k() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f321264i;     // Catch: Throwable -> L24
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f321258c), StandardCharsets.US_ASCII));     // Catch: Throwable -> L24
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("1");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f321260e));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f321262g));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        Iterator<d> r102 = this.f321265j.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r102.hasNext() == false) goto L15;
        d r103 = r102.next();     // Catch: Throwable -> L21
        if (r103.f321279d != null) goto L12;
        r101.write("CLEAN " + r103.f321276a + r103.c() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r101.write("DIRTY " + r103.f321276a + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r101.close();     // Catch: Throwable -> L24
        if (this.f321257b.exists() == false) goto L18;
        m(this.f321257b, this.f321259d, true);     // Catch: Throwable -> L24
    L18:
        m(this.f321258c, this.f321257b, false);     // Catch: Throwable -> L24
        this.f321259d.delete();     // Catch: Throwable -> L24
        this.f321264i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f321257b, true), StandardCharsets.US_ASCII));     // Catch: Throwable -> L24
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
        f321254o = PatternProtector.compile("[a-zA-Z0-9\\._-]+");
        f321255p = new b();
    }

    public final void b() {
        if (this.f321264i == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final boolean f() {
        int r100 = this.f321266k;
        if (r100 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r100 < this.f321265j.size()) goto L7;
        return true;
    }

    public final void h() throws IOException {
        c(this.f321258c);
        Iterator<d> r100 = this.f321265j.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        d r101 = r100.next();
        int r102 = 0;
        if (r101.f321279d == null) goto L8;
        r101.f321279d = null;
    L12:
        if (r102 >= this.f321262g) goto L14;
        c(r101.a(r102));
        c(r101.b(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f321262g) goto L4;
        this.f321263h += r101.f321277b[r102];
        r102 = r102 + 1;
        goto L8
    }

    public final void i() throws IOException {
        g r100 = new g(new PolarisFileInputStreamWrapper(this.f321257b), StandardCharsets.US_ASCII);
        String r101 = r100.a();     // Catch: Throwable -> L26
        String r102 = r100.a();     // Catch: Throwable -> L26
        String r103 = r100.a();     // Catch: Throwable -> L26
        String r104 = r100.a();     // Catch: Throwable -> L26
        String r105 = r100.a();     // Catch: Throwable -> L26
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L25;
        if ("1".equals(r102) == false) goto L25;
        if (Integer.toString(this.f321260e).equals(r103) == false) goto L25;
        if (Integer.toString(this.f321262g).equals(r104) == false) goto L25;
        if ("".equals(r105) == false) goto L25;
        boolean r106 = false;
        int r107 = 0;
    L29:
        j(r100.a());     // Catch: EOFException -> L16 Throwable -> L26
        r107 = r107 + 1;
        goto L29
    L16:
        this.f321266k = r107 - this.f321265j.size();     // Catch: Throwable -> L26
        if (r100.f321287e != (-1)) goto L19;
        r106 = true;
    L19:
        if (r106 == false) goto L21;
        k();     // Catch: Throwable -> L26
    L22:
        com.larus.utils.g.a(r100);
        return;
    L21:
        this.f321264i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f321257b, true), StandardCharsets.US_ASCII));     // Catch: Throwable -> L26
    L25:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        com.larus.utils.g.a(r100);
        throw th;
    }

    public final void n() throws IOException {
    L3:
        if (this.f321263h <= this.f321261f) goto L5;
        l(this.f321265j.entrySet().iterator().next().getKey());
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
        if (f321254o.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-zA-Z0-9\\._-]+: \"" + r100 + "\"");
    }

    public final c d(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L14
        p(r100);     // Catch: Throwable -> L14
        d r101 = this.f321265j.get(r100);     // Catch: Throwable -> L14
        if (r101 != null) goto L7;
        r101 = new d(this, r100);     // Catch: Throwable -> L14
        this.f321265j.put(r100, r101);     // Catch: Throwable -> L14
    L11:
        c r102 = new c(this, r101);     // Catch: Throwable -> L14
        r101.f321279d = r102;     // Catch: Throwable -> L14
        this.f321264i.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L14
        this.f321264i.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
    L13:
        return r102;
    L7:
        r102 = r101.f321279d;     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        monitor-exit(this);
    L14:
        th = move-exception;
        throw th;
    }

    public void delete(boolean r100) throws IOException {
        close();
        r.e(this.f321256a, r100);
    }

    public final synchronized e e(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L32
        p(r100);     // Catch: Throwable -> L32
        d r101 = this.f321265j.get(r100);     // Catch: Throwable -> L32
        if (r101 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r101.f321278c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        int r102 = this.f321262g;     // Catch: Throwable -> L32
        InputStream[] r103 = new InputStream[r102];     // Catch: Throwable -> L32
        File[] r104 = new File[r102];     // Catch: Throwable -> L32
        int r105 = 0;
        int r106 = 0;
    L36:
        if (r106 >= this.f321262g) goto L18;
        r103[r106] = new PolarisFileInputStreamWrapper(r101.a(r106));     // Catch: FileNotFoundException -> L35 Throwable -> L32
        r104[r106] = r101.a(r106);     // Catch: FileNotFoundException -> L35 Throwable -> L32
        r106 = r106 + 1;
        goto L36
    L18:
        this.f321266k++;     // Catch: Throwable -> L32
        this.f321264i.append("READ " + r100 + '\n');     // Catch: Throwable -> L32
        if (f() == false) goto L21;
        this.f321268m.submit(this.f321269n);     // Catch: Throwable -> L32
    L21:
        e r107 = new e(r103, r104);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r107;
    L25:
        if (r105 >= this.f321262g) goto L30;
        InputStream r108 = r103[r105];     // Catch: Throwable -> L32
        if (r108 == null) goto L30;
        com.larus.utils.g.a(r108);     // Catch: Throwable -> L32
        r105 = r105 + 1;
    L30:
        monitor-exit(this);
        return null;
    L32:
        th = move-exception;
        throw th;
    }

    public final void j(String r100) throws IOException {
        int r101 = r100.indexOf(32);
        if (r101 == (-1)) goto L47;
        int r102 = r101 + 1;
        int r103 = r100.indexOf(32, r102);
        if (r103 != (-1)) goto L12;
        String r104 = r100.substring(r102);
        if (r101 == 6) goto L9;
    L13:
        d r105 = this.f321265j.get(r104);
        if (r105 != null) goto L17;
        r105 = new d(this, r104);
        this.f321265j.put(r104, r105);
    L17:
        if (r103 == (-1)) goto L32;
        if (r101 != 5) goto L32;
        if (r100.startsWith("CLEAN") == false) goto L32;
        String[] r106 = r100.substring(r103 + 1).split(" ");
        r105.f321278c = true;
        r105.f321279d = null;
        if (r106.length != r105.f321280e.f321262g) goto L31;
        int r107 = 0;
    L48:
        if (r107 >= r106.length) goto L52;
        r105.f321277b[r107] = CastLongProtector.parseLong(r106[r107]);     // Catch: NumberFormatException -> L28
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
        r105.f321279d = new c(this, r105);
        return;
    L37:
        if (r103 != (-1)) goto L45;
        if (r101 != 4) goto L45;
        if (r100.startsWith("READ") == false) goto L45;
        FLogger.f375446a.d("DiskLruCache", "This work was already done by calling lruEntries.get()");
        return;
    L45:
        throw new IOException("unexpected journal line: ".concat(r100));
    L9:
        if (r100.startsWith("REMOVE") == false) goto L13;
        this.f321265j.remove(r104);
        return;
    L12:
        r104 = r100.substring(r102, r103);
        goto L13
    L47:
        throw new IOException("unexpected journal line: ".concat(r100));
    }

    public final synchronized boolean l(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L25
        p(r100);     // Catch: Throwable -> L25
        d r101 = this.f321265j.get(r100);     // Catch: Throwable -> L25
        int r102 = 0;
        if (r101 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (r101.f321279d != null) goto L23;
    L9:
        if (r102 >= this.f321262g) goto L18;
        PolarisFileWrapper r103 = r101.a(r102);     // Catch: Throwable -> L25
        if (r103.exists() == false) goto L17;
        if (r103.delete() == true) goto L17;
        throw new IOException("failed to delete " + r103);     // Catch: Throwable -> L25
    L17:
        long r104 = this.f321263h;     // Catch: Throwable -> L25
        long[] r105 = r101.f321277b;     // Catch: Throwable -> L25
        this.f321263h = r104 - r105[r102];     // Catch: Throwable -> L25
        r105[r102] = 0;     // Catch: Throwable -> L25
        r102 = r102 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.f321266k++;     // Catch: Throwable -> L25
        this.f321264i.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L25
        this.f321265j.remove(r100);     // Catch: Throwable -> L25
        if (f() == false) goto L21;
        this.f321268m.submit(this.f321269n);     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        throw th;
    }

    public f(File r110, int r111, long r112) {
        this.f321263h = 0;
        this.f321265j = new LinkedHashMap(0, 0.75f, true);
        this.f321267l = 0;
        this.f321269n = new a(this);
        this.f321256a = r110;
        this.f321260e = r111;
        this.f321257b = new PolarisFileWrapper(r110, "journal");
        this.f321258c = new PolarisFileWrapper(r110, "journal.tmp");
        this.f321259d = new PolarisFileWrapper(r110, "journal.bkp");
        this.f321262g = 1;
        this.f321261f = r112;
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new com.larus.cache.e());
        this.f321268m = r100;
        r100.allowCoreThreadTimeOut(true);
    }

    public static void a(f r100, c r110, boolean r111) throws IOException {
        monitor-enter(r100);
        d r101 = r110.f321271a;     // Catch: Throwable -> L46
        if (r101.f321279d != r110) goto L45;
        int r102 = 0;
        if (r111 == false) goto L23;
        if (r101.f321278c == true) goto L23;
        int r103 = 0;
    L11:
        if (r103 >= r100.f321262g) goto L23;
        if (r110.f321272b[r103] == false) goto L20;
        if (r101.b(r103).exists() == false) goto L16;
        r103 = r103 + 1;
        goto L11
    L16:
        r110.a();     // Catch: Throwable -> L46
        monitor-exit(r100);
        return;
    L20:
        r110.a();     // Catch: Throwable -> L46
        throw new IOException("Newly created entry didn't create value for index " + r103);     // Catch: Throwable -> L46
    L23:
        if (r102 >= r100.f321262g) goto L31;
        PolarisFileWrapper r112 = r101.b(r102);     // Catch: Throwable -> L46
        if (r111 == true) goto L27;
        c(r112);     // Catch: Throwable -> L46
    L30:
        r102 = r102 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r112.exists() == false) goto L30;
        PolarisFileWrapper r104 = r101.a(r102);     // Catch: Throwable -> L46
        r.q(r112, r104);     // Catch: Throwable -> L46
        long r105 = r101.f321277b[r102];     // Catch: Throwable -> L46
        long r106 = r104.length();     // Catch: Throwable -> L46
        r101.f321277b[r102] = r106;     // Catch: Throwable -> L46
        r100.f321263h = (r100.f321263h - r105) + r106;     // Catch: Throwable -> L46
        goto L30
    L31:
        r100.f321266k++;     // Catch: Throwable -> L46
        r101.f321279d = null;     // Catch: Throwable -> L46
        if ((r101.f321278c | r111) == false) goto L36;
        r101.f321278c = true;     // Catch: Throwable -> L46
        r100.f321264i.write("CLEAN " + r101.f321276a + r101.c() + '\n');     // Catch: Throwable -> L46
        if (r111 == false) goto L37;
        r100.f321267l++;     // Catch: Throwable -> L46
        r101.getClass();     // Catch: Throwable -> L46
    L37:
        r100.f321264i.flush();     // Catch: Throwable -> L46
        if (r100.f321263h <= r100.f321261f) goto L40;
    L41:
        r100.f321268m.submit(r100.f321269n);     // Catch: Throwable -> L46
    L42:
        monitor-exit(r100);
        return;
    L40:
        if (r100.f() == false) goto L42;
    L36:
        r100.f321265j.remove(r101.f321276a);     // Catch: Throwable -> L46
        r100.f321264i.write("REMOVE " + r101.f321276a + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IOException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public static f g(File r100, int r101, long r102) throws IOException {
        if (r102 <= 0) goto L19;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, "journal.bkp");
        if (r103.exists() == false) goto L10;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100, "journal");
        if (r104.exists() == false) goto L9;
        r103.delete();
        goto L10
    L9:
        m(r103, r104, false);
    L10:
        f r105 = new f(r100, r101, r102);
        if (r105.f321257b.exists() == true) goto L20;
    L16:
        r100.mkdirs();
        f r106 = new f(r100, r101, r102);
        r106.k();
        return r106;
    L20:
        r105.i();     // Catch: IOException -> L14
        r105.h();     // Catch: IOException -> L14
        return r105;
    L14:
        e = move-exception;
        System.out.println("DiskLruCache " + r100 + " is corrupt: " + e.getMessage() + ", removing");
        r105.delete();
        goto L16
    L19:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void m(PolarisFileWrapper r100, PolarisFileWrapper r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        c(r101);
    L5:
        if (r.q(r100, r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }
}
