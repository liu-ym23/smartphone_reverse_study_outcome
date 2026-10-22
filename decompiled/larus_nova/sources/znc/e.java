package znc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements Closeable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f573014p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f573015q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f573016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f573017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f573018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f573019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f573020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final znc.b f573021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f573022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f573023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f573024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Writer f573025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, d> f573026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f573027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f573028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PThreadPoolExecutor f573029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f573030o;

    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f573031a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            e r100 = this.f573031a;
            monitor-enter(r100);
            e r101 = this.f573031a;     // Catch: Throwable -> L13
            if (r101.f573025j != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L13
            return null;
        L8:
            r101.n();     // Catch: Throwable -> L13
            if (this.f573031a.f() == false) goto L11;
            this.f573031a.k();     // Catch: Throwable -> L13
            this.f573031a.f573027l = 0;     // Catch: Throwable -> L13
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

        public a(e r100) {
            this.f573031a = r100;
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
        public final d f573032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f573033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f573034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public IOException f573035d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f573036e;

        public class a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f573037a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                e = move-exception;
                c r100 = this.f573037a;
                r100.f573034c = true;
                r100.f573035d = e;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                e = move-exception;
                c r100 = this.f573037a;
                r100.f573034c = true;
                r100.f573035d = e;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                e = move-exception;
                c r101 = this.f573037a;
                r101.f573034c = true;
                r101.f573035d = e;
            }

            public a(c r100, OutputStream r101) {
                this.f573037a = r100;
                super(r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                e = move-exception;
                c r103 = this.f573037a;
                r103.f573034c = true;
                r103.f573035d = e;
            }
        }

        public final void a() throws IOException {
            e.a(this.f573036e, this, false);
        }

        public final void b() throws IOException {
            if (this.f573034c == false) goto L9;
            e.a(this.f573036e, this, false);
            this.f573036e.l(this.f573032a.f573038a);
            StringBuilder r100 = new StringBuilder("commit with error: ");
            r100.append(this.f573032a.f573038a);
            r100.append(" ");
            IOException r101 = this.f573035d;
            if (r101 == null) goto L7;
            String r102 = r101.getMessage();
        L8:
            r100.append(r102);
            Log.e("UniDiskLruCache", r100.toString());
            return;
        L7:
            r102 = "";
            goto L8
        L9:
            e.a(this.f573036e, this, true);
        }

        public final OutputStream c() throws IOException {
            e r100 = this.f573036e;
            if (r100.f573023h <= 0) goto L28;
            monitor-enter(r100);
            d r101 = this.f573032a;     // Catch: Throwable -> L24
            if (r101.f573041d != this) goto L23;
            if (r101.f573040c == true) goto L10;
            this.f573033b[0] = true;     // Catch: Throwable -> L24
        L10:
            PolarisFileWrapper r102 = r101.b(0);     // Catch: Throwable -> L24
            OutputStream r103 = this.f573036e.f573021f.a(r102);     // Catch: FileNotFoundException -> L13 Throwable -> L24
        L16:
            a r104 = new a(this, r103);     // Catch: Throwable -> L24
            monitor-exit(r100);     // Catch: Throwable -> L24
            return r104;
        L13:
            e = move-exception;
            this.f573036e.f573016a.mkdirs();     // Catch: Throwable -> L24
            r103 = this.f573036e.f573021f.a(r102);     // Catch: FileNotFoundException -> L19 Throwable -> L24
        L19:
            Log.e("UniDiskLruCache", "cache file not found:" + this.f573032a.f573038a, e, true);     // Catch: Throwable -> L24
            return e.f573015q;
        L23:
            throw new IllegalStateException();     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;
        L28:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.f573036e.f573023h);
        }

        public c(e r100, d r101) {
            this.f573036e = r100;
            this.f573032a = r101;
            if (r101.f573040c == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f573033b = r102;
            return;
        L5:
            r102 = new boolean[r100.f573023h];
            goto L6
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f573038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f573039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f573040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f573041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f573042e;

        public final String c() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f573039b;
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
            return new PolarisFileWrapper(this.f573042e.f573016a, this.f573038a + "." + r100);
        }

        public final PolarisFileWrapper b(int r100) {
            return new PolarisFileWrapper(this.f573042e.f573016a, this.f573038a + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        public d(e r100, String r101) {
            this.f573042e = r100;
            this.f573038a = r101;
            this.f573039b = new long[r100.f573023h];
        }
    }

    /* JADX INFO: renamed from: znc.e$e, reason: collision with other inner class name */
    public final class C8478e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File[] f573043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f573044b;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        public final String a() throws IOException {
            InputStreamReader r100 = new InputStreamReader(this.f573044b.f573021f.j(this.f573043a[0]), n.f573065b);
            Intrinsics.checkNotNullParameter(r100, "reader");
            StringWriter r101 = new StringWriter();     // Catch: Throwable -> L10
            char[] r102 = new char[1024];     // Catch: Throwable -> L10
        L4:
            int r103 = r100.read(r102);     // Catch: Throwable -> L10
            if (r103 == (-1)) goto L7;
            r101.write(r102, 0, r103);     // Catch: Throwable -> L10
            goto L4
        L7:
            String r104 = r101.toString();     // Catch: Throwable -> L10
            Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L10
            r100.close();
            return r104;
        L10:
            th = move-exception;
            r100.close();
            throw th;
        }

        public C8478e(e r100, File[] r101) {
            this.f573044b = r100;
            this.f573043a = r101;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f573025j != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f573026k.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        c r101 = ((d) r100.next()).f573041d;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        r101.a();     // Catch: Throwable -> L16
        goto L9
    L13:
        n();     // Catch: Throwable -> L16
        this.f573025j.close();     // Catch: Throwable -> L16
        this.f573025j = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void k() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f573025j;     // Catch: Throwable -> L24
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f573018c), n.f573064a));     // Catch: Throwable -> L24
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("1");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f573020e));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f573023h));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        Iterator<d> r102 = this.f573026k.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r102.hasNext() == false) goto L15;
        d r103 = r102.next();     // Catch: Throwable -> L21
        if (r103.f573041d != null) goto L12;
        r101.write("CLEAN " + r103.f573038a + r103.c() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r101.write("DIRTY " + r103.f573038a + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r101.close();     // Catch: Throwable -> L24
        if (this.f573017b.exists() == false) goto L18;
        m(this.f573017b, this.f573019d, true);     // Catch: Throwable -> L24
    L18:
        m(this.f573018c, this.f573017b, false);     // Catch: Throwable -> L24
        this.f573019d.delete();     // Catch: Throwable -> L24
        this.f573025j = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f573017b, true), n.f573064a));     // Catch: Throwable -> L24
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
        f573014p = PatternProtector.compile("[a-z0-9_-]{1,120}");
        f573015q = new b();
    }

    public final void b() {
        if (this.f573025j == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final boolean f() {
        int r100 = this.f573027l;
        if (r100 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r100 < this.f573026k.size()) goto L7;
        return true;
    }

    public final void h() throws IOException {
        c(this.f573018c);
        Iterator<d> r100 = this.f573026k.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        d r101 = r100.next();
        int r102 = 0;
        if (r101.f573041d == null) goto L8;
        r101.f573041d = null;
    L12:
        if (r102 >= this.f573023h) goto L14;
        c(r101.a(r102));
        c(r101.b(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f573023h) goto L4;
        this.f573024i += r101.f573039b[r102];
        r102 = r102 + 1;
        goto L8
    }

    public final void i() throws IOException {
        l r100 = new l(new PolarisFileInputStreamWrapper(this.f573017b), n.f573064a);
        String r101 = r100.a();     // Catch: Throwable -> L26
        String r102 = r100.a();     // Catch: Throwable -> L26
        String r103 = r100.a();     // Catch: Throwable -> L26
        String r104 = r100.a();     // Catch: Throwable -> L26
        String r105 = r100.a();     // Catch: Throwable -> L26
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L25;
        if ("1".equals(r102) == false) goto L25;
        if (Integer.toString(this.f573020e).equals(r103) == false) goto L25;
        if (Integer.toString(this.f573023h).equals(r104) == false) goto L25;
        if ("".equals(r105) == false) goto L25;
        boolean r106 = false;
        int r107 = 0;
    L29:
        j(r100.a());     // Catch: EOFException -> L16 Throwable -> L26
        r107 = r107 + 1;
        goto L29
    L16:
        this.f573027l = r107 - this.f573026k.size();     // Catch: Throwable -> L26
        if (r100.f573053e != (-1)) goto L19;
        r106 = true;
    L19:
        if (r106 == false) goto L21;
        k();     // Catch: Throwable -> L26
    L22:
        n.a(r100);
        return;
    L21:
        this.f573025j = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f573017b, true), n.f573064a));     // Catch: Throwable -> L26
    L25:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        n.a(r100);
        throw th;
    }

    public final void n() throws IOException {
    L3:
        if (this.f573024i <= this.f573022g) goto L5;
        l(this.f573026k.entrySet().iterator().next().getKey());
        goto L3
    }

    public void delete() throws IOException {
        close();
        n.b(this.f573016a);
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
        if (f573014p.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");
    }

    public final c d(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L16
        p(r100);     // Catch: Throwable -> L16
        d r101 = this.f573026k.get(r100);     // Catch: Throwable -> L16
        if (r101 != null) goto L8;
        r101 = new d(this, r100);     // Catch: Throwable -> L16
        this.f573026k.put(r100, r101);     // Catch: Throwable -> L16
    L12:
        c r102 = new c(this, r101);     // Catch: Throwable -> L16
        r101.f573041d = r102;     // Catch: Throwable -> L16
        this.f573025j.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L16
        this.f573025j.flush();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L8:
        if (r101.f573041d == null) goto L12;
        Log.e("UniDiskLruCache", "get edit failed, another edit is in progress, key=" + r100);     // Catch: Throwable -> L16
        monitor-exit(this);
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized C8478e e(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L30
        p(r100);     // Catch: Throwable -> L30
        d r101 = this.f573026k.get(r100);     // Catch: Throwable -> L30
        if (r101 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r101.f573040c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        File[] r102 = new File[this.f573023h];     // Catch: Throwable -> L30
        int r103 = 0;
        PolarisFileInputStreamWrapper r104 = null;
    L34:
    L27:
        n.a(r104);     // Catch: Throwable -> L30
        return null;
    L24:
        th = move-exception;
        n.a(r104);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L15:
        if (r103 >= this.f573023h) goto L18;
        PolarisFileWrapper r105 = r101.a(r103);     // Catch: Throwable -> L24 FileNotFoundException -> L27
        r102[r103] = r105;     // Catch: Throwable -> L24 FileNotFoundException -> L27
        r103 = r103 + 1;
        r104 = new PolarisFileInputStreamWrapper(r105);     // Catch: Throwable -> L24 FileNotFoundException -> L27
        goto L34
    L18:
        n.a(r104);     // Catch: Throwable -> L30
        this.f573027l++;     // Catch: Throwable -> L30
        this.f573025j.append("READ " + r100 + '\n');     // Catch: Throwable -> L30
        if (f() == false) goto L21;
        this.f573029n.submit(this.f573030o);     // Catch: Throwable -> L30
    L21:
        C8478e r106 = new C8478e(this, r102);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r106;
    L30:
        th = move-exception;
        throw th;
    }

    public final void j(String r100) throws IOException {
        int r101 = r100.indexOf(32);
        if (r101 == (-1)) goto L46;
        int r102 = r101 + 1;
        int r103 = r100.indexOf(32, r102);
        if (r103 != (-1)) goto L12;
        String r104 = r100.substring(r102);
        if (r101 == 6) goto L9;
    L13:
        d r105 = this.f573026k.get(r104);
        if (r105 != null) goto L17;
        r105 = new d(this, r104);
        this.f573026k.put(r104, r105);
    L17:
        if (r103 == (-1)) goto L32;
        if (r101 != 5) goto L32;
        if (r100.startsWith("CLEAN") == false) goto L32;
        String[] r106 = r100.substring(r103 + 1).split(" ");
        r105.f573040c = true;
        r105.f573041d = null;
        if (r106.length != r105.f573042e.f573023h) goto L31;
        int r107 = 0;
    L47:
        if (r107 >= r106.length) goto L51;
        r105.f573039b[r107] = CastLongProtector.parseLong(r106[r107]);     // Catch: NumberFormatException -> L28
        r107 = r107 + 1;
        goto L47
    L51:
        return;
    L29:
        throw new IOException("unexpected journal line: " + Arrays.toString(r106));
    L31:
        throw new IOException("unexpected journal line: " + Arrays.toString(r106));
    L32:
        if (r103 != (-1)) goto L37;
        if (r101 != 5) goto L37;
        if (r100.startsWith("DIRTY") == false) goto L37;
        r105.f573041d = new c(this, r105);
        return;
    L37:
        if (r103 != (-1)) goto L44;
        if (r101 != 4) goto L44;
        if (r100.startsWith("READ") == false) goto L44;
        return;
    L44:
        throw new IOException("unexpected journal line: ".concat(r100));
    L9:
        if (r100.startsWith("REMOVE") == false) goto L13;
        this.f573026k.remove(r104);
        return;
    L12:
        r104 = r100.substring(r102, r103);
        goto L13
    L46:
        throw new IOException("unexpected journal line: ".concat(r100));
    }

    public final synchronized boolean l(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L25
        p(r100);     // Catch: Throwable -> L25
        d r101 = this.f573026k.get(r100);     // Catch: Throwable -> L25
        int r102 = 0;
        if (r101 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (r101.f573041d != null) goto L23;
    L9:
        if (r102 >= this.f573023h) goto L18;
        PolarisFileWrapper r103 = r101.a(r102);     // Catch: Throwable -> L25
        if (r103.exists() == false) goto L17;
        if (r103.delete() == true) goto L17;
        throw new IOException("failed to delete " + r103);     // Catch: Throwable -> L25
    L17:
        long r104 = this.f573024i;     // Catch: Throwable -> L25
        long[] r105 = r101.f573039b;     // Catch: Throwable -> L25
        this.f573024i = r104 - r105[r102];     // Catch: Throwable -> L25
        r105[r102] = 0;     // Catch: Throwable -> L25
        r102 = r102 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.f573027l++;     // Catch: Throwable -> L25
        this.f573025j.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L25
        this.f573026k.remove(r100);     // Catch: Throwable -> L25
        if (f() == false) goto L21;
        this.f573029n.submit(this.f573030o);     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        throw th;
    }

    public static void a(e r100, c r110, boolean r111) throws IOException {
        monitor-enter(r100);
        d r101 = r110.f573032a;     // Catch: Throwable -> L46
        if (r101.f573041d != r110) goto L45;
        int r102 = 0;
        if (r111 == false) goto L23;
        if (r101.f573040c == true) goto L23;
        int r103 = 0;
    L11:
        if (r103 >= r100.f573023h) goto L23;
        if (r110.f573033b[r103] == false) goto L20;
        if (r101.b(r103).exists() == false) goto L16;
        r103 = r103 + 1;
        goto L11
    L16:
        r110.a();     // Catch: Throwable -> L46
        monitor-exit(r100);
        return;
    L20:
        r110.a();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index " + r103);     // Catch: Throwable -> L46
    L23:
        if (r102 >= r100.f573023h) goto L31;
        PolarisFileWrapper r112 = r101.b(r102);     // Catch: Throwable -> L46
        if (r111 == true) goto L27;
        c(r112);     // Catch: Throwable -> L46
    L30:
        r102 = r102 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r112.exists() == false) goto L30;
        PolarisFileWrapper r104 = r101.a(r102);     // Catch: Throwable -> L46
        r112.renameTo(r104);     // Catch: Throwable -> L46
        long r105 = r101.f573039b[r102];     // Catch: Throwable -> L46
        long r106 = r104.length();     // Catch: Throwable -> L46
        r101.f573039b[r102] = r106;     // Catch: Throwable -> L46
        r100.f573024i = (r100.f573024i - r105) + r106;     // Catch: Throwable -> L46
        goto L30
    L31:
        r100.f573027l++;     // Catch: Throwable -> L46
        r101.f573041d = null;     // Catch: Throwable -> L46
        if ((r101.f573040c | r111) == false) goto L36;
        r101.f573040c = true;     // Catch: Throwable -> L46
        r100.f573025j.write("CLEAN " + r101.f573038a + r101.c() + '\n');     // Catch: Throwable -> L46
        if (r111 == false) goto L37;
        r100.f573028m++;     // Catch: Throwable -> L46
        r101.getClass();     // Catch: Throwable -> L46
    L37:
        r100.f573025j.flush();     // Catch: Throwable -> L46
        if (r100.f573024i <= r100.f573022g) goto L40;
    L41:
        r100.f573029n.submit(r100.f573030o);     // Catch: Throwable -> L46
    L42:
        monitor-exit(r100);
        return;
    L40:
        if (r100.f() == false) goto L42;
    L36:
        r100.f573026k.remove(r101.f573038a);     // Catch: Throwable -> L46
        r100.f573025j.write("REMOVE " + r101.f573038a + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public static void m(PolarisFileWrapper r100, PolarisFileWrapper r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        c(r101);
    L5:
        if (r100.renameTo(r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public e(PolarisFileWrapper r110, int r111, int r112, long r210, znc.b r211) {
        this.f573024i = 0;
        this.f573026k = new LinkedHashMap(0, 0.75f, true);
        this.f573028m = 0;
        this.f573029n = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("/DiskLruCache"));
        this.f573030o = new a(this);
        this.f573016a = r110;
        this.f573020e = r111;
        this.f573017b = new PolarisFileWrapper(r110, "journal");
        this.f573018c = new PolarisFileWrapper(r110, "journal.tmp");
        this.f573019d = new PolarisFileWrapper(r110, "journal.bkp");
        this.f573023h = r112;
        this.f573022g = r210;
        this.f573021f = r211;
    }

    public static e g(PolarisFileWrapper r100, int r101, int r110, long r111, znc.b r112) throws IOException {
        if (r111 <= 0) goto L24;
        if (r110 <= 0) goto L22;
        if (r112 != null) goto L7;
        r112 = znc.b.a.f573013a;
    L7:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "journal.bkp");
        if (r102.exists() == false) goto L13;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, "journal");
        if (r103.exists() == false) goto L12;
        r102.delete();
        goto L13
    L12:
        m(r102, r103, false);
    L13:
        e r104 = new e(r100, r101, r110, r111, r112);
        if (r104.f573017b.exists() == true) goto L25;
    L19:
        r100.mkdirs();
        e r105 = new e(r100, r101, r110, r111, r112);
        r105.k();
        r112.c(r100);
        return r105;
    L25:
        r104.i();     // Catch: IOException -> L17
        r104.h();     // Catch: IOException -> L17
        r112.c(r100);     // Catch: IOException -> L17
        return r104;
    L17:
        e = move-exception;
        Log.i("DiskLruCache ", r100 + " is corrupt: " + e.getMessage() + ", removing");
        r104.delete();
        goto L19
    L22:
        throw new IllegalArgumentException("valueCount <= 0");
    L24:
        throw new IllegalArgumentException("maxSize <= 0");
    }
}
