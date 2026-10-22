package n4a;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes32.dex */
public final class h0 implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f517307o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Charset f517308p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f517309q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static PThreadPoolExecutor f517310r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c f517311s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f517312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f517313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f517314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f517315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f517316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f517317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f517318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f517319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Writer f517320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f517321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, f> f517322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f517323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f517324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f517325n;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f517326a;

        public a() {
            this.f517326a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "disklrucache#" + this.f517326a.getAndIncrement());
        }
    }

    public class b implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h0 f517327a;

        public b(h0 r100) {
            this.f517327a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            h0 r100 = this.f517327a;
            monitor-enter(r100);
            h0 r101 = this.f517327a;     // Catch: Throwable -> L13
            if (r101.f517320i != null) goto L8;
        L6:
            monitor-exit(r100);     // Catch: Throwable -> L13
            return null;
        L8:
            r101.q();     // Catch: Throwable -> L13
            if (this.f517327a.n() == false) goto L6;
            this.f517327a.m();     // Catch: Throwable -> L13
            this.f517327a.f517323l = 0;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }
    }

    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public final void write(int r100) throws IOException {
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f517328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f517329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f517330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h0 f517331d;

        public class a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f517332a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                this.f517332a.f517330c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                this.f517332a.f517330c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                this.f517332a.f517330c = true;
            }

            public a(d r100, PolarisFileOutputStreamWrapper r101) {
                this.f517332a = r100;
                super(r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                this.f517332a.f517330c = true;
            }
        }

        public final OutputStream a() throws IOException {
            h0 r100 = this.f517331d;
            if (r100.f517318g <= 0) goto L27;
            monitor-enter(r100);
            f r101 = this.f517328a;     // Catch: Throwable -> L23
            if (r101.f517337d != this) goto L22;
            if (r101.f517336c == true) goto L10;
            this.f517329b[0] = true;     // Catch: Throwable -> L23
        L10:
            PolarisFileWrapper r102 = r101.d(0);     // Catch: Throwable -> L23
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L13 Throwable -> L23
        L15:
            a r104 = new a(this, r103);     // Catch: Throwable -> L23
            monitor-exit(r100);     // Catch: Throwable -> L23
            return r104;
        L13:
            this.f517331d.f517312a.mkdirs();     // Catch: Throwable -> L23
            r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L18 Throwable -> L23
        L20:
            return h0.f517311s;
        L22:
            throw new IllegalStateException();     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.f517331d.f517318g);
        }

        public d(h0 r100, f r101) {
            this.f517331d = r100;
            this.f517328a = r101;
            if (r101.f517336c == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f517329b = r102;
            return;
        L5:
            r102 = new boolean[r100.f517318g];
            goto L6
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream[] f517333a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r100 = this.f517333a;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L11;
            InputStream r103 = r100[r102];
            if (r103 == null) goto L10;
            r103.close();     // Catch: RuntimeException -> L8 Exception -> L12
        L8:
            e = move-exception;
            throw e;
        L10:
            r102 = r102 + 1;
            goto L3
        }

        public e(InputStream[] r100) {
            this.f517333a = r100;
        }
    }

    public final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f517334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f517335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f517336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f517337d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h0 f517338e;

        public final String b() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f517335b;
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
            return new PolarisFileWrapper(this.f517338e.f517312a, this.f517334a + "." + r100);
        }

        public final PolarisFileWrapper d(int r100) {
            return new PolarisFileWrapper(this.f517338e.f517312a, this.f517334a + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        public f(h0 r100, String r101) {
            this.f517338e = r100;
            this.f517334a = r101;
            this.f517335b = new long[r100.f517318g];
        }

        public static void c(f r100, String[] r101) throws IOException {
            if (r101.length != r100.f517338e.f517318g) goto L13;
            int r102 = 0;
        L14:
            if (r102 >= r101.length) goto L9;
            r100.f517335b[r102] = CastLongProtector.parseLong(r101[r102]);     // Catch: NumberFormatException -> L10
            r102 = r102 + 1;
            goto L14
        L9:
            return;
        L11:
            throw new IOException("unexpected journal line: " + Arrays.toString(r101));
        L13:
            throw new IOException("unexpected journal line: " + Arrays.toString(r101));
        }
    }

    static {
        f517307o = PatternProtector.compile("[a-z0-9_-]{1,120}");
        f517308p = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
        a r100 = new a();
        f517309q = r100;
        f517310r = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r100);
        f517311s = new c();
    }

    public h0(PolarisFileWrapper r100, long r101) {
        this.f517319h = 0;
        this.f517321j = 1000;
        this.f517322k = new LinkedHashMap(0, 0.75f, true);
        this.f517324m = 0;
        this.f517325n = new b(this);
        this.f517312a = r100;
        this.f517316e = 1;
        this.f517313b = new PolarisFileWrapper(r100, "journal");
        this.f517314c = new PolarisFileWrapper(r100, "journal.tmp");
        this.f517315d = new PolarisFileWrapper(r100, "journal.bkp");
        this.f517318g = 1;
        this.f517317f = r101;
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

    public static void d(PolarisFileWrapper r100, PolarisFileWrapper r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        c(r101);
    L5:
        if (r100.renameTo(r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void g(File r100) throws IOException {
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L10;
        g(r104);
    L10:
        if (r104.delete() == false) goto L13;
        r103 = r103 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: ".concat(String.valueOf(r104)));
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: ".concat(String.valueOf(r100)));
    }

    public static void i(String r100) {
        if (f517307o.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");
    }

    public static ThreadPoolExecutor j() {
        PThreadPoolExecutor r100 = f517310r;     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
    L6:
        f517310r = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f517309q);     // Catch: Throwable -> L8
    L11:
        return f517310r;
    L5:
        if (r100.isShutdown() == false) goto L11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f517320i != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f517322k.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        d r101 = ((f) r100.next()).f517337d;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        e(r101.f517331d, r101, false);     // Catch: Throwable -> L16
        goto L9
    L13:
        q();     // Catch: Throwable -> L16
        this.f517320i.close();     // Catch: Throwable -> L16
        this.f517320i = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void m() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f517320i;     // Catch: Throwable -> L26
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L26
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f517314c), f517308p));     // Catch: Throwable -> L26
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L23
        r101.write("\n");     // Catch: Throwable -> L23
        r101.write("1");     // Catch: Throwable -> L23
        r101.write("\n");     // Catch: Throwable -> L23
        r101.write(Integer.toString(this.f517316e));     // Catch: Throwable -> L23
        r101.write("\n");     // Catch: Throwable -> L23
        r101.write(Integer.toString(this.f517318g));     // Catch: Throwable -> L23
        r101.write("\n");     // Catch: Throwable -> L23
        r101.write("\n");     // Catch: Throwable -> L23
        Iterator<f> r102 = this.f517322k.values().iterator();     // Catch: Throwable -> L23
    L8:
        if (r102.hasNext() == false) goto L17;
        f r103 = r102.next();     // Catch: Throwable -> L23
        if (r103.f517337d == null) goto L14;
        StringBuilder r104 = new StringBuilder("DIRTY ");     // Catch: Throwable -> L23
        r104.append(r103.f517334a);     // Catch: Throwable -> L23
        r104.append('\n');     // Catch: Throwable -> L23
    L15:
        r101.write(r104.toString());     // Catch: Throwable -> L23
        goto L8
    L14:
        r104 = new StringBuilder("CLEAN ");     // Catch: Throwable -> L23
        r104.append(r103.f517334a);     // Catch: Throwable -> L23
        r104.append(r103.b());     // Catch: Throwable -> L23
        r104.append('\n');     // Catch: Throwable -> L23
        goto L15
    L17:
        r101.close();     // Catch: Throwable -> L26
        if (this.f517313b.exists() == false) goto L20;
        d(this.f517313b, this.f517315d, true);     // Catch: Throwable -> L26
    L20:
        d(this.f517314c, this.f517313b, false);     // Catch: Throwable -> L26
        this.f517315d.delete();     // Catch: Throwable -> L26
        this.f517320i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f517313b, true), f517308p));     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final boolean n() {
        int r100 = this.f517323l;
        if (r100 >= 2000) goto L5;
        return false;
    L5:
        if (r100 < this.f517322k.size()) goto L10;
        return true;
    L10:
        return false;
    }

    public final void p() {
        if (this.f517320i == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final void q() throws IOException {
    L3:
        if (this.f517319h > this.f517317f) goto L8;
        if (this.f517322k.size() > this.f517321j) goto L8;
        return;
    L8:
        h(this.f517322k.entrySet().iterator().next().getKey());
        goto L3
    }

    public final void k() throws IOException {
        i0 r100 = new i0(new PolarisFileInputStreamWrapper(this.f517313b), f517308p);
        String r101 = r100.a();     // Catch: Throwable -> L57
        String r102 = r100.a();     // Catch: Throwable -> L57
        String r103 = r100.a();     // Catch: Throwable -> L57
        String r104 = r100.a();     // Catch: Throwable -> L57
        String r105 = r100.a();     // Catch: Throwable -> L57
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L56;
        if ("1".equals(r102) == false) goto L56;
        if (Integer.toString(this.f517316e).equals(r103) == false) goto L56;
        if (Integer.toString(this.f517318g).equals(r104) == false) goto L56;
        if ("".equals(r105) == false) goto L56;
        int r106 = 0;
    L65:
        String r107 = r100.a();     // Catch: EOFException -> L50 Throwable -> L57
        int r108 = r107.indexOf(32);     // Catch: EOFException -> L50 Throwable -> L57
        if (r108 == (-1)) goto L49;
        int r109 = r108 + 1;
        int r110 = r107.indexOf(32, r109);     // Catch: EOFException -> L50 Throwable -> L57
        if (r110 != (-1)) goto L25;
        String r111 = r107.substring(r109);     // Catch: EOFException -> L50 Throwable -> L57
        if (r108 == 6) goto L23;
    L26:
        f r112 = this.f517322k.get(r111);     // Catch: EOFException -> L50 Throwable -> L57
        if (r112 != null) goto L30;
        r112 = new f(this, r111);     // Catch: EOFException -> L50 Throwable -> L57
        this.f517322k.put(r111, r112);     // Catch: EOFException -> L50 Throwable -> L57
    L30:
        if (r110 == (-1)) goto L35;
        if (r108 != 5) goto L35;
        if (r107.startsWith("CLEAN") == false) goto L35;
        String[] r113 = r107.substring(r110 + 1).split(" ");     // Catch: EOFException -> L50 Throwable -> L57
        r112.f517336c = true;     // Catch: EOFException -> L50 Throwable -> L57
        r112.f517337d = null;     // Catch: EOFException -> L50 Throwable -> L57
        f.c(r112, r113);     // Catch: EOFException -> L50 Throwable -> L57
    L45:
        r106 = r106 + 1;     // Catch: EOFException -> L50 Throwable -> L57
    L35:
        if (r110 != (-1)) goto L40;
        if (r108 != 5) goto L40;
        if (r107.startsWith("DIRTY") == false) goto L40;
        r112.f517337d = new d(this, r112);     // Catch: EOFException -> L50 Throwable -> L57
    L40:
        if (r110 != (-1)) goto L47;
        if (r108 != 4) goto L47;
        if (r107.startsWith("READ") == true) goto L45;
    L47:
        throw new IOException("unexpected journal line: ".concat(r107));     // Catch: EOFException -> L50 Throwable -> L57
    L23:
        if (r107.startsWith("REMOVE") == false) goto L26;
        this.f517322k.remove(r111);     // Catch: EOFException -> L50 Throwable -> L57
        goto L45
    L25:
        r111 = r107.substring(r109, r110);     // Catch: EOFException -> L50 Throwable -> L57
        goto L26
    L49:
        throw new IOException("unexpected journal line: ".concat(r107));     // Catch: EOFException -> L50 Throwable -> L57
    L50:
        this.f517323l = r106 - this.f517322k.size();     // Catch: Throwable -> L57
        r100.close();     // Catch: Exception -> L62 RuntimeException -> L53
        return;
    L53:
        e = move-exception;
        throw e;
    L78:
        return;
    L56:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        r100.close();     // Catch: Exception -> L63 RuntimeException -> L60
    L60:
        e = move-exception;
        throw e;
    L59:
        throw th;
    }

    public final void l() throws IOException {
        c(this.f517314c);
        Iterator<f> r100 = this.f517322k.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        f r101 = r100.next();
        int r102 = 0;
        if (r101.f517337d == null) goto L8;
        r101.f517337d = null;
    L12:
        if (r102 >= this.f517318g) goto L14;
        c(r101.a(r102));
        c(r101.d(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f517318g) goto L4;
        this.f517319h += r101.f517335b[r102];
        r102 = r102 + 1;
        goto L8
    }

    public final synchronized e a(String r100) throws IOException {
        monitor-enter(this);
        p();     // Catch: Throwable -> L34
        i(r100);     // Catch: Throwable -> L34
        f r101 = this.f517322k.get(r100);     // Catch: Throwable -> L34
        if (r101 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r101.f517336c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        InputStream[] r102 = new InputStream[this.f517318g];     // Catch: Throwable -> L34
        int r103 = 0;
        int r104 = 0;
    L40:
        if (r104 >= this.f517318g) goto L18;
        r102[r104] = new PolarisFileInputStreamWrapper(r101.a(r104));     // Catch: FileNotFoundException -> L37 Throwable -> L34
        r104 = r104 + 1;
        goto L40
    L18:
        this.f517323l++;     // Catch: Throwable -> L34
        this.f517320i.append("READ " + r100 + '\n');     // Catch: Throwable -> L34
        if (n() == false) goto L21;
        j().submit(this.f517325n);     // Catch: Throwable -> L34
    L21:
        e r105 = new e(r102);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r105;
    L25:
        if (r103 >= this.f517318g) goto L32;
        InputStream r106 = r102[r103];     // Catch: Throwable -> L34
        if (r106 == null) goto L32;
        r106.close();     // Catch: Exception -> L38 RuntimeException -> L30 Throwable -> L34
    L30:
        e = move-exception;
        throw e;     // Catch: Throwable -> L34
    L29:
        r103 = r103 + 1;
    L32:
        monitor-exit(this);
        return null;
    L34:
        th = move-exception;
        throw th;
    }

    public final d f(String r100) throws IOException {
        monitor-enter(this);
        p();     // Catch: Throwable -> L14
        i(r100);     // Catch: Throwable -> L14
        f r101 = this.f517322k.get(r100);     // Catch: Throwable -> L14
        if (r101 != null) goto L7;
        r101 = new f(this, r100);     // Catch: Throwable -> L14
        this.f517322k.put(r100, r101);     // Catch: Throwable -> L14
    L10:
        d r102 = new d(this, r101);     // Catch: Throwable -> L14
        r101.f517337d = r102;     // Catch: Throwable -> L14
        this.f517320i.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L14
        this.f517320i.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r102;
    L7:
        if (r101.f517337d == null) goto L10;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(String r100) throws IOException {
        monitor-enter(this);
        p();     // Catch: Throwable -> L26
        i(r100);     // Catch: Throwable -> L26
        f r101 = this.f517322k.get(r100);     // Catch: Throwable -> L26
        if (r101 != null) goto L6;
    L24:
        monitor-exit(this);
        return;
    L6:
        if (r101.f517337d != null) goto L24;
        int r102 = 0;
    L10:
        if (r102 >= this.f517318g) goto L19;
        PolarisFileWrapper r103 = r101.a(r102);     // Catch: Throwable -> L26
        if (r103.exists() == false) goto L18;
        if (r103.delete() == true) goto L18;
        throw new IOException("failed to delete ".concat(String.valueOf(r103)));     // Catch: Throwable -> L26
    L18:
        long r104 = this.f517319h;     // Catch: Throwable -> L26
        long[] r105 = r101.f517335b;     // Catch: Throwable -> L26
        this.f517319h = r104 - r105[r102];     // Catch: Throwable -> L26
        r105[r102] = 0;     // Catch: Throwable -> L26
        r102 = r102 + 1;     // Catch: Throwable -> L26
        goto L10
    L19:
        this.f517323l++;     // Catch: Throwable -> L26
        this.f517320i.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L26
        this.f517322k.remove(r100);     // Catch: Throwable -> L26
        if (n() == false) goto L22;
        j().submit(this.f517325n);     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public static h0 b(PolarisFileWrapper r100, long r101) throws IOException {
        if (r101 <= 0) goto L18;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "journal.bkp");
        if (r102.exists() == false) goto L10;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, "journal");
        if (r103.exists() == false) goto L9;
        r102.delete();
        goto L10
    L9:
        d(r102, r103, false);
    L10:
        h0 r104 = new h0(r100, r101);
        if (r104.f517313b.exists() == true) goto L19;
    L15:
        r100.mkdirs();
        h0 r105 = new h0(r100, r101);
        r105.m();
        return r105;
    L19:
        r104.k();     // Catch: Throwable -> L14
        r104.l();     // Catch: Throwable -> L14
        r104.f517320i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r104.f517313b, true), f517308p));     // Catch: Throwable -> L14
        return r104;
    L14:
        r104.close();
        g(r104.f517312a);
        goto L15
    L18:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void e(h0 r100, d r110, boolean r111) throws IOException {
        monitor-enter(r100);
        f r101 = r110.f517328a;     // Catch: Throwable -> L44
        if (r101.f517337d != r110) goto L43;
        int r102 = 0;
        if (r111 == false) goto L21;
        if (r101.f517336c == true) goto L21;
        int r103 = 0;
    L11:
        if (r103 >= r100.f517318g) goto L21;
        if (r110.f517329b[r103] == false) goto L18;
        if (r101.d(r103).exists() == false) goto L16;
        r103 = r103 + 1;     // Catch: Throwable -> L44
        goto L11
    L16:
        e(r110.f517331d, r110, false);     // Catch: Throwable -> L44
    L40:
        monitor-exit(r100);
        return;
    L18:
        e(r110.f517331d, r110, false);     // Catch: Throwable -> L44
        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(r103)));     // Catch: Throwable -> L44
    L21:
        if (r102 >= r100.f517318g) goto L29;
        PolarisFileWrapper r112 = r101.d(r102);     // Catch: Throwable -> L44
        if (r111 == true) goto L25;
        c(r112);     // Catch: Throwable -> L44
    L28:
        r102 = r102 + 1;     // Catch: Throwable -> L44
        goto L21
    L25:
        if (r112.exists() == false) goto L28;
        PolarisFileWrapper r104 = r101.a(r102);     // Catch: Throwable -> L44
        r112.renameTo(r104);     // Catch: Throwable -> L44
        long r105 = r101.f517335b[r102];     // Catch: Throwable -> L44
        long r106 = r104.length();     // Catch: Throwable -> L44
        r101.f517335b[r102] = r106;     // Catch: Throwable -> L44
        r100.f517319h = (r100.f517319h - r105) + r106;     // Catch: Throwable -> L44
        goto L28
    L29:
        r100.f517323l++;     // Catch: Throwable -> L44
        r101.f517337d = null;     // Catch: Throwable -> L44
        if ((r101.f517336c | r111) == false) goto L34;
        r101.f517336c = true;     // Catch: Throwable -> L44
        r100.f517320i.write("CLEAN " + r101.f517334a + r101.b() + '\n');     // Catch: Throwable -> L44
        if (r111 == false) goto L35;
        r100.f517324m++;     // Catch: Throwable -> L44
        r101.getClass();     // Catch: Throwable -> L44
    L35:
        r100.f517320i.flush();     // Catch: Throwable -> L44
        if (r100.f517319h <= r100.f517317f) goto L38;
    L39:
        j().submit(r100.f517325n);     // Catch: Throwable -> L44
        goto L40
    L38:
        if (r100.n() == false) goto L40;
    L34:
        r100.f517322k.remove(r101.f517334a);     // Catch: Throwable -> L44
        r100.f517320i.write("REMOVE " + r101.f517334a + '\n');     // Catch: Throwable -> L44
        goto L35
    L43:
        throw new IllegalStateException();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
