package gbb;

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
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
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
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes35.dex */
public class e implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f480771o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f480772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f480773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f480774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f480775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f480776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f480777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f480778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f480779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Writer f480780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<String, d> f480781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f480782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f480783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PThreadPoolExecutor f480784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f480785n;

    public class a extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r100) throws IOException {
        }

        public a() {
        }
    }

    public final class b implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f480786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f480787b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            e r100 = this.f480787b;
            monitor-enter(r100);
            e r101 = this.f480787b;     // Catch: Throwable -> L13
            if (r101.f480780i != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L13
            return null;
        L8:
            r101.n(this.f480786a);     // Catch: Throwable -> L13
            if (this.f480787b.f() == false) goto L11;
            this.f480787b.k();     // Catch: Throwable -> L13
            this.f480787b.f480782k = 0;     // Catch: Throwable -> L13
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

        public b(e r100, long r101) {
            this.f480787b = r100;
            this.f480786a = r101;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f480788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f480789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f480790c;

        public final void a() throws IOException {
            e.a(this.f480790c, this, false);
        }

        public final PolarisFileWrapper b() throws IOException {
            e r100 = this.f480790c;
            monitor-enter(r100);
            d r101 = this.f480788a;     // Catch: Throwable -> L16
            if (r101.f480794d != this) goto L15;
            if (r101.f480793c == true) goto L9;
            this.f480789b[0] = true;     // Catch: Throwable -> L16
        L9:
            PolarisFileWrapper r102 = r101.b(0);     // Catch: Throwable -> L16
            if (this.f480790c.f480772a.exists() == true) goto L12;
            this.f480790c.f480772a.mkdirs();     // Catch: Throwable -> L16
        L12:
            monitor-exit(r100);     // Catch: Throwable -> L16
            return r102;
        L15:
            throw new IllegalStateException();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        public c(e r100, d r101) {
            this.f480790c = r100;
            this.f480788a = r101;
            if (r101.f480793c == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f480789b = r102;
            return;
        L5:
            r102 = new boolean[r100.f480778g];
            goto L6
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f480791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f480792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f480793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f480794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f480795e;

        public final String c() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f480792b;
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
            return new PolarisFileWrapper(this.f480795e.f480772a, this.f480791a + "." + r100);
        }

        public final PolarisFileWrapper b(int r100) {
            return new PolarisFileWrapper(this.f480795e.f480772a, this.f480791a + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        public d(e r100, String r101) {
            this.f480795e = r100;
            this.f480791a = r101;
            this.f480792b = new long[r100.f480778g];
        }
    }

    /* JADX INFO: renamed from: gbb.e$e, reason: collision with other inner class name */
    public final class C6005e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream[] f480796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f480797b;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r100 = this.f480796a;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            g.a(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public C6005e(InputStream[] r100, d r101) {
            this.f480796a = r100;
            this.f480797b = r101;
        }
    }

    public static class f implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f480798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Charset f480799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f480800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f480801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f480802e;

        public class a extends ByteArrayOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f480803a;

            @Override // java.io.ByteArrayOutputStream
            public final String toString() {
                int r100 = ((ByteArrayOutputStream) this).count;
                if (r100 > 0) goto L5;
            L12:
                return new String(((ByteArrayOutputStream) this).buf, 0, r100, this.f480803a.f480799b.name());
            L9:
                e = move-exception;
                throw new AssertionError(e);
            L5:
                if (((ByteArrayOutputStream) this).buf[r100 - 1] != 13) goto L12;
                r100 = r100 - 1;
                goto L12
            }

            public a(f r100, int r101) {
                this.f480803a = r100;
                super(r101);
            }
        }

        public final String a() throws IOException {
            InputStream r100 = this.f480798a;
            monitor-enter(r100);
            byte[] r101 = this.f480800c;     // Catch: Throwable -> L47
            if (r101 == null) goto L46;
            if (this.f480801d < this.f480802e) goto L13;
            int r102 = this.f480798a.read(r101, 0, r101.length);     // Catch: Throwable -> L47
            if (r102 == (-1)) goto L12;
            this.f480801d = 0;     // Catch: Throwable -> L47
            this.f480802e = r102;     // Catch: Throwable -> L47
            goto L13
        L12:
            throw new EOFException();     // Catch: Throwable -> L47
        L13:
            int r103 = this.f480801d;     // Catch: Throwable -> L47
        L15:
            if (r103 == this.f480802e) goto L28;
            byte[] r104 = this.f480800c;     // Catch: Throwable -> L47
            if (r104[r103] == 10) goto L18;
            r103 = r103 + 1;     // Catch: Throwable -> L47
            goto L15
        L18:
            int r105 = this.f480801d;     // Catch: Throwable -> L47
            if (r103 == r105) goto L23;
            int r106 = r103 - 1;     // Catch: Throwable -> L47
            if (r104[r106] != 13) goto L23;
        L24:
            String r107 = new String(r104, r105, r106 - r105, this.f480799b.name());     // Catch: Throwable -> L47
            this.f480801d = r103 + 1;     // Catch: Throwable -> L47
            monitor-exit(r100);     // Catch: Throwable -> L47
            return r107;
        L23:
            r106 = r103;
            goto L24
        L28:
            a r108 = new a(this, (this.f480802e - this.f480801d) + 80);     // Catch: Throwable -> L47
        L29:
            byte[] r109 = this.f480800c;     // Catch: Throwable -> L47
            int r110 = this.f480801d;     // Catch: Throwable -> L47
            r108.write(r109, r110, this.f480802e - r110);     // Catch: Throwable -> L47
            this.f480802e = -1;     // Catch: Throwable -> L47
            InputStream r111 = this.f480798a;     // Catch: Throwable -> L47
            byte[] r112 = this.f480800c;     // Catch: Throwable -> L47
            int r113 = r111.read(r112, 0, r112.length);     // Catch: Throwable -> L47
            if (r113 == (-1)) goto L44;
            this.f480801d = 0;     // Catch: Throwable -> L47
            this.f480802e = r113;     // Catch: Throwable -> L47
            int r114 = 0;
        L33:
            if (r114 == this.f480802e) goto L29;
            byte[] r115 = this.f480800c;     // Catch: Throwable -> L47
            if (r115[r114] == 10) goto L36;
            r114 = r114 + 1;     // Catch: Throwable -> L47
            goto L33
        L36:
            int r116 = this.f480801d;     // Catch: Throwable -> L47
            if (r114 == r116) goto L39;
            r108.write(r115, r116, r114 - r116);     // Catch: Throwable -> L47
        L39:
            this.f480801d = r114 + 1;     // Catch: Throwable -> L47
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
            InputStream r100 = this.f480798a;
            monitor-enter(r100);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.f480800c == null) goto L7;
            this.f480800c = null;     // Catch: Throwable -> L9
            this.f480798a.close();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
        }

        public f(PolarisFileInputStreamWrapper r100, Charset r101) {
            if (r101 == null) goto L11;
            if (r101.equals(g.f480804a) == false) goto L9;
            this.f480798a = r100;
            this.f480799b = r101;
            this.f480800c = new byte[8192];
            return;
        L9:
            throw new IllegalArgumentException("Unsupported encoding");
        L11:
            throw null;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Charset f480804a = null;

        static {
            f480804a = Charset.forName("US-ASCII");
            Charset.forName("UTF-8");
        }

        public static void a(Closeable r100) {
            if (r100 != null) goto L10;
            return;
        L10:
            r100.close();     // Catch: Exception -> L5 RuntimeException -> L7
        L13:
            return;
        L7:
            e = move-exception;
            throw e;
        L5:
            e = move-exception;
            Log.d("DiskLruCache", "closeQuietly = " + e);
        }

        public static void b(File r100) throws IOException {
            File[] r101 = r100.listFiles();
            if (r101 == null) goto L16;
            int r102 = r101.length;
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L14;
            File r104 = r101[r103];
            if (r104.isDirectory() == false) goto L10;
            b(r104);
        L10:
            if (r104.delete() == false) goto L13;
            r103 = r103 + 1;
            goto L5
        L13:
            throw new IOException("failed to delete file: " + r104);
        L14:
            return;
        L16:
            throw new IOException("not a readable directory: " + r100);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f480780i != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f480781j.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        c r101 = ((d) r100.next()).f480794d;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        r101.a();     // Catch: Throwable -> L16
        goto L9
    L13:
        n(this.f480777f);     // Catch: Throwable -> L16
        this.f480780i.close();     // Catch: Throwable -> L16
        this.f480780i = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void k() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f480780i;     // Catch: Throwable -> L24
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f480774c), g.f480804a));     // Catch: Throwable -> L24
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("1");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f480776e));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f480778g));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        Iterator<d> r102 = this.f480781j.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r102.hasNext() == false) goto L15;
        d r103 = r102.next();     // Catch: Throwable -> L21
        if (r103.f480794d != null) goto L12;
        r101.write("CLEAN " + r103.f480791a + r103.c() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r101.write("DIRTY " + r103.f480791a + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r101.close();     // Catch: Throwable -> L24
        if (this.f480773b.exists() == false) goto L18;
        m(this.f480773b, this.f480775d, true);     // Catch: Throwable -> L24
    L18:
        m(this.f480774c, this.f480773b, false);     // Catch: Throwable -> L24
        this.f480775d.delete();     // Catch: Throwable -> L24
        this.f480780i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f480773b, true), g.f480804a));     // Catch: Throwable -> L24
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
        f480771o = PatternProtector.compile("[a-z0-9_-]{1,64}");
        new a();
    }

    public final boolean f() {
        int r100 = this.f480782k;
        if (r100 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r100 < this.f480781j.size()) goto L7;
        return true;
    }

    public final void h() throws IOException {
        b(this.f480774c);
        Iterator<d> r100 = this.f480781j.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        d r101 = r100.next();
        int r102 = 0;
        if (r101.f480794d == null) goto L8;
        r101.f480794d = null;
    L12:
        if (r102 >= this.f480778g) goto L14;
        b(r101.a(r102));
        b(r101.b(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f480778g) goto L4;
        this.f480779h += r101.f480792b[r102];
        r102 = r102 + 1;
        goto L8
    }

    public final void i() throws IOException {
        f r100 = new f(new PolarisFileInputStreamWrapper(this.f480773b), g.f480804a);
        String r101 = r100.a();     // Catch: Throwable -> L21
        String r102 = r100.a();     // Catch: Throwable -> L21
        String r103 = r100.a();     // Catch: Throwable -> L21
        String r104 = r100.a();     // Catch: Throwable -> L21
        String r105 = r100.a();     // Catch: Throwable -> L21
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L20;
        if ("1".equals(r102) == false) goto L20;
        if (Integer.toString(this.f480776e).equals(r103) == false) goto L20;
        if (Integer.toString(this.f480778g).equals(r104) == false) goto L20;
        if ("".equals(r105) == false) goto L20;
        int r106 = 0;
    L24:
        j(r100.a());     // Catch: EOFException -> L16 Throwable -> L21
        r106 = r106 + 1;
        goto L24
    L16:
        this.f480782k = r106 - this.f480781j.size();     // Catch: Throwable -> L21
        g.a(r100);
        return;
    L20:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        g.a(r100);
        throw th;
    }

    public void delete() throws IOException {
        close();
        g.b(this.f480772a);
    }

    public File e() {
        return this.f480772a;
    }

    public static void b(PolarisFileWrapper r100) throws IOException {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void p(String r100) {
        if (f480771o.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + r100 + "\"");
    }

    public final c c(String r100) throws IOException {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f480780i == null) goto L21;
        p(r100);     // Catch: Throwable -> L18
        d r101 = this.f480781j.get(r100);     // Catch: Throwable -> L18
        if (r101 != null) goto L10;
        r101 = new d(this, r100);     // Catch: Throwable -> L18
        this.f480781j.put(r100, r101);     // Catch: Throwable -> L18
    L14:
        c r102 = new c(this, r101);     // Catch: Throwable -> L18
        r101.f480794d = r102;     // Catch: Throwable -> L18
        this.f480780i.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L18
        this.f480780i.flush();     // Catch: Throwable -> L18
        monitor-exit(this);
        return r102;
    L10:
        if (r101.f480794d == null) goto L14;
        Log.e("DiskLruCache", "Another edit is in progress, " + r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return null;
    L21:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L18
    }

    public synchronized C6005e d(String r100) throws IOException {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L4:
        if (this.f480780i == null) goto L37;
        p(r100);     // Catch: Throwable -> L34
        d r101 = this.f480781j.get(r100);     // Catch: Throwable -> L34
        if (r101 != null) goto L11;
        monitor-exit(this);
        return null;
    L11:
        if (r101.f480793c == true) goto L14;
        monitor-exit(this);
        return null;
    L14:
        InputStream[] r102 = new InputStream[this.f480778g];     // Catch: Throwable -> L34
        int r103 = 0;
        int r104 = 0;
    L41:
        if (r104 >= this.f480778g) goto L20;
        r102[r104] = new PolarisFileInputStreamWrapper(r101.a(r104));     // Catch: FileNotFoundException -> L40 Throwable -> L34
        r104 = r104 + 1;
        goto L41
    L20:
        this.f480782k++;     // Catch: Throwable -> L34
        this.f480780i.append("READ " + r100 + '\n');     // Catch: Throwable -> L34
        if (f() == false) goto L23;
        this.f480784m.submit(this.f480785n);     // Catch: Throwable -> L34
    L23:
        C6005e r105 = new C6005e(r102, r101);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r105;
    L27:
        if (r103 >= this.f480778g) goto L32;
        InputStream r106 = r102[r103];     // Catch: Throwable -> L34
        if (r106 == null) goto L32;
        g.a(r106);     // Catch: Throwable -> L34
        r103 = r103 + 1;
    L32:
        monitor-exit(this);
        return null;
    L37:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L34
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
        d r105 = this.f480781j.get(r104);
        if (r105 != null) goto L17;
        r105 = new d(this, r104);
        this.f480781j.put(r104, r105);
    L17:
        if (r103 == (-1)) goto L32;
        if (r101 != 5) goto L32;
        if (r100.startsWith("CLEAN") == false) goto L32;
        String[] r106 = r100.substring(r103 + 1).split(" ");
        r105.f480793c = true;
        r105.f480794d = null;
        if (r106.length != r105.f480795e.f480778g) goto L31;
        int r107 = 0;
    L48:
        if (r107 >= r106.length) goto L52;
        r105.f480792b[r107] = CastLongProtector.parseLong(r106[r107]);     // Catch: NumberFormatException -> L28
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
        r105.f480794d = new c(this, r105);
        return;
    L37:
        if (r103 != (-1)) goto L45;
        if (r101 != 4) goto L45;
        if (r100.startsWith("READ") == false) goto L45;
        Log.d("DiskLruCache", "This work was already done by calling lruEntries.get()");
        return;
    L45:
        throw new IOException("unexpected journal line: ".concat(r100));
    L9:
        if (r100.startsWith("REMOVE") == false) goto L13;
        this.f480781j.remove(r104);
        return;
    L12:
        r104 = r100.substring(r102, r103);
        goto L13
    L47:
        throw new IOException("unexpected journal line: ".concat(r100));
    }

    public synchronized void l(String r100) throws IOException {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.f480780i == null) goto L31;
        p(r100);     // Catch: Throwable -> L28
        d r101 = this.f480781j.get(r100);     // Catch: Throwable -> L28
        if (r101 != null) goto L8;
    L26:
        monitor-exit(this);
        return;
    L8:
        if (r101.f480794d != null) goto L26;
        int r102 = 0;
    L12:
        if (r102 >= this.f480778g) goto L21;
        PolarisFileWrapper r103 = r101.a(r102);     // Catch: Throwable -> L28
        if (r103.exists() == false) goto L20;
        if (r103.delete() == true) goto L20;
        throw new IOException("failed to delete " + r103);     // Catch: Throwable -> L28
    L20:
        long r104 = this.f480779h;     // Catch: Throwable -> L28
        long[] r105 = r101.f480792b;     // Catch: Throwable -> L28
        this.f480779h = r104 - r105[r102];     // Catch: Throwable -> L28
        r105[r102] = 0;     // Catch: Throwable -> L28
        r102 = r102 + 1;     // Catch: Throwable -> L28
        goto L12
    L21:
        this.f480782k++;     // Catch: Throwable -> L28
        this.f480780i.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L28
        this.f480781j.remove(r100);     // Catch: Throwable -> L28
        if (f() == false) goto L24;
        this.f480784m.submit(this.f480785n);     // Catch: Throwable -> L28
    L24:
        monitor-exit(this);
        return;
    L31:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L28
    }

    public final void n(long r100) throws IOException {
    L3:
        if (this.f480779h <= r100) goto L5;
        l(this.f480781j.entrySet().iterator().next().getKey());
        goto L3
    }

    public e(File r110, int r111, long r112) {
        this.f480779h = 0;
        this.f480781j = new LinkedHashMap(0, 0.75f, true);
        this.f480783l = 0;
        this.f480784m = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("/DiskLruCache"));
        this.f480785n = new b(this, this.f480777f);
        this.f480772a = r110;
        this.f480776e = r111;
        this.f480773b = new PolarisFileWrapper(r110, "journal");
        this.f480774c = new PolarisFileWrapper(r110, "journal.tmp");
        this.f480775d = new PolarisFileWrapper(r110, "journal.bkp");
        this.f480778g = 1;
        this.f480777f = r112;
    }

    public static void a(e r100, c r110, boolean r111) throws IOException {
        monitor-enter(r100);
        d r101 = r110.f480788a;     // Catch: Throwable -> L46
        if (r101.f480794d != r110) goto L45;
        int r102 = 0;
        if (r111 == false) goto L23;
        if (r101.f480793c == true) goto L23;
        int r103 = 0;
    L11:
        if (r103 >= r100.f480778g) goto L23;
        if (r110.f480789b[r103] == false) goto L20;
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
        if (r102 >= r100.f480778g) goto L31;
        PolarisFileWrapper r112 = r101.b(r102);     // Catch: Throwable -> L46
        if (r111 == true) goto L27;
        b(r112);     // Catch: Throwable -> L46
    L30:
        r102 = r102 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r112.exists() == false) goto L30;
        PolarisFileWrapper r104 = r101.a(r102);     // Catch: Throwable -> L46
        r112.renameTo(r104);     // Catch: Throwable -> L46
        long r105 = r101.f480792b[r102];     // Catch: Throwable -> L46
        long r106 = r104.length();     // Catch: Throwable -> L46
        r101.f480792b[r102] = r106;     // Catch: Throwable -> L46
        r100.f480779h = (r100.f480779h - r105) + r106;     // Catch: Throwable -> L46
        goto L30
    L31:
        r100.f480782k++;     // Catch: Throwable -> L46
        r101.f480794d = null;     // Catch: Throwable -> L46
        if ((r101.f480793c | r111) == false) goto L36;
        r101.f480793c = true;     // Catch: Throwable -> L46
        r100.f480780i.write("CLEAN " + r101.f480791a + r101.c() + '\n');     // Catch: Throwable -> L46
        if (r111 == false) goto L37;
        r100.f480783l++;     // Catch: Throwable -> L46
        r101.getClass();     // Catch: Throwable -> L46
    L37:
        r100.f480780i.flush();     // Catch: Throwable -> L46
        if (r100.f480779h <= r100.f480777f) goto L40;
    L41:
        r100.f480784m.submit(r100.f480785n);     // Catch: Throwable -> L46
    L42:
        monitor-exit(r100);
        return;
    L40:
        if (r100.f() == false) goto L42;
    L36:
        r100.f480781j.remove(r101.f480791a);     // Catch: Throwable -> L46
        r100.f480780i.write("REMOVE " + r101.f480791a + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public static e g(PolarisFileWrapper r100, int r101, long r102) throws IOException {
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
        e r105 = new e(r100, r101, r102);
        if (r105.f480773b.exists() == true) goto L20;
    L16:
        r100.mkdirs();
        e r106 = new e(r100, r101, r102);
        r106.k();
        return r106;
    L20:
        r105.i();     // Catch: IOException -> L14
        r105.h();     // Catch: IOException -> L14
        r105.f480780i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r105.f480773b, true), g.f480804a));     // Catch: IOException -> L14
        return r105;
    L14:
        e = move-exception;
        Log.e("DiskLruCache " + r100 + " is corrupt: " + e.getMessage() + ", removing");
        r105.delete();
        goto L16
    L19:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void m(PolarisFileWrapper r100, PolarisFileWrapper r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        b(r101);
    L5:
        if (r100.renameTo(r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }
}
