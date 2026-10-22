package dvc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes42.dex */
public final class e implements Closeable, Flushable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f470240u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileSystem f470241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f470242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f470243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f470244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PolarisFileWrapper f470245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f470246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f470247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f470248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f470249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BufferedSink f470250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, c> f470251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f470252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f470253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f470254n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f470255o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f470256p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f470257q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f470258r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Executor f470259s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f470260t;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f470261a;

        public final void a() {
            e r100 = this.f470261a;
            monitor-enter(r100);
            e r101 = this.f470261a;     // Catch: Throwable -> L22
            if (r101.f470254n == true) goto L7;
            boolean r102 = true;
        L9:
            if ((r102 | r101.f470255o) == false) goto L25;
            monitor-exit(r100);     // Catch: Throwable -> L22
            return;
        L25:
            r101.p();     // Catch: IOException -> L14 Throwable -> L22
        L27:
        L19:
            e r103 = this.f470261a;     // Catch: Throwable -> L22
            r103.f470257q = true;     // Catch: Throwable -> L22
            r103.f470250j = Okio.buffer(Okio.blackhole());     // Catch: Throwable -> L22
        L20:
            monitor-exit(r100);     // Catch: Throwable -> L22
            return;
        L16:
            if (this.f470261a.h() == false) goto L20;
            this.f470261a.l();     // Catch: IOException -> L19 Throwable -> L22
            this.f470261a.f470252l = 0;     // Catch: IOException -> L19 Throwable -> L22
        L14:
            this.f470261a.f470256p = true;     // Catch: Throwable -> L22
            goto L27
        L7:
            r102 = false;
        L22:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100) {
            this.f470261a = r100;
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f470262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f470263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f470264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f470265d;

        public class a extends h {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f470266c;

            @Override // dvc.h
            public final void a() {
                e r100 = this.f470266c.f470265d;
                monitor-enter(r100);
                this.f470266c.c();     // Catch: Throwable -> L7
                monitor-exit(r100);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public a(b r100, Sink r101) {
                this.f470266c = r100;
                super(r101);
            }
        }

        public final void a() throws IOException {
            e r100 = this.f470265d;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f470264c == true) goto L13;
            if (this.f470262a.f470272f != this) goto L9;
            this.f470265d.b(this, false);     // Catch: Throwable -> L14
        L9:
            this.f470264c = true;     // Catch: Throwable -> L14
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L13:
            throw new IllegalStateException();     // Catch: Throwable -> L14
        }

        public final void b() throws IOException {
            e r100 = this.f470265d;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f470264c == true) goto L13;
            if (this.f470262a.f470272f != this) goto L9;
            this.f470265d.b(this, true);     // Catch: Throwable -> L14
        L9:
            this.f470264c = true;     // Catch: Throwable -> L14
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L13:
            throw new IllegalStateException();     // Catch: Throwable -> L14
        }

        public final void c() {
            if (this.f470262a.f470272f != this) goto L16;
            int r100 = 0;
        L5:
            e r101 = this.f470265d;
            if (r100 >= r101.f470248h) goto L9;
            r101.f470241a.delete(this.f470262a.f470270d[r100]);     // Catch: IOException -> L11
        L8:
            r100 = r100 + 1;
            goto L5
        L9:
            this.f470262a.f470272f = null;
            return;
        }

        public final Sink d(int r100) {
            e r101 = this.f470265d;
            monitor-enter(r101);
        L24:
            th = move-exception;
            throw th;
        L5:
            if (this.f470264c == true) goto L23;
            c r102 = this.f470262a;     // Catch: Throwable -> L24
            if (r102.f470272f == this) goto L12;
            Sink r103 = Okio.blackhole();     // Catch: Throwable -> L24
            monitor-exit(r101);     // Catch: Throwable -> L24
            return r103;
        L12:
            if (r102.f470271e == true) goto L14;
            this.f470263b[r100] = true;     // Catch: Throwable -> L24
        L14:
            File r104 = r102.f470270d[r100];     // Catch: Throwable -> L24
            a r105 = new a(this, this.f470265d.f470241a.sink(r104));     // Catch: Throwable -> L24
            monitor-exit(r101);     // Catch: Throwable -> L24
            return r105;
        L21:
            return Okio.blackhole();
        L23:
            throw new IllegalStateException();     // Catch: Throwable -> L24
        }

        public b(e r100, c r101) {
            this.f470265d = r100;
            this.f470262a = r101;
            if (r101.f470271e == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f470263b = r102;
            return;
        L5:
            r102 = new boolean[r100.f470248h];
            goto L6
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f470267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f470268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final File[] f470269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File[] f470270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f470271e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f470272f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f470273g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e f470274h;

        public final d a() {
            if (Thread.holdsLock(this.f470274h) == false) goto L20;
            Source[] r100 = new Source[this.f470274h.f470248h];
            this.f470268b.clone();
            int r101 = 0;
            int r102 = 0;
        L24:
            e r103 = this.f470274h;     // Catch: FileNotFoundException -> L10
            if (r102 >= r103.f470248h) goto L8;
            r100[r102] = r103.f470241a.source(this.f470269c[r102]);     // Catch: FileNotFoundException -> L10
            r102 = r102 + 1;     // Catch: FileNotFoundException -> L10
            goto L24
        L8:
            return new d(r103, this.f470267a, this.f470273g, r100);
        L11:
            e r104 = this.f470274h;
            if (r101 >= r104.f470248h) goto L22;
            Source r105 = r100[r101];
            if (r105 == null) goto L22;
            cvc.c.e(r105);
            r101 = r101 + 1;
        L22:
            r104.n(this);     // Catch: IOException -> L21
            return null;
        L27:
            return null;
        L20:
            throw new AssertionError();
        }

        public c(e r100, String r101) {
            this.f470274h = r100;
            this.f470267a = r101;
            int r102 = r100.f470248h;
            this.f470268b = new long[r102];
            this.f470269c = new File[r102];
            this.f470270d = new File[r102];
            StringBuilder r103 = new StringBuilder(r101);
            r103.append('.');
            int r104 = r103.length();
            int r105 = 0;
        L4:
            if (r105 >= r100.f470248h) goto L6;
            r103.append(r105);
            this.f470269c[r105] = new PolarisFileWrapper(r100.f470242b, r103.toString());
            r103.append(DefaultDiskStorage.FileType.TEMP);
            this.f470270d[r105] = new PolarisFileWrapper(r100.f470242b, r103.toString());
            r103.setLength(r104);
            r105 = r105 + 1;
            goto L4
        }
    }

    public final class d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f470275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f470276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Source[] f470277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f470278d;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            Source[] r100 = this.f470277c;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            cvc.c.e(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public d(e r100, String r101, long r102, Source[] r103) {
            this.f470278d = r100;
            this.f470275a = r101;
            this.f470276b = r102;
            this.f470277c = r103;
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f470254n == true) goto L6;
    L17:
        this.f470255o = true;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (this.f470255o == true) goto L17;
        c[] r100 = (c[]) this.f470251k.values().toArray(new c[this.f470251k.size()]);     // Catch: Throwable -> L20
        int r101 = r100.length;     // Catch: Throwable -> L20
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L14;
        b r103 = r100[r102].f470272f;     // Catch: Throwable -> L20
        if (r103 == null) goto L13;
        r103.a();     // Catch: Throwable -> L20
    L13:
        r102 = r102 + 1;     // Catch: Throwable -> L20
        goto L9
    L14:
        p();     // Catch: Throwable -> L20
        this.f470250j.close();     // Catch: Throwable -> L20
        this.f470250j = null;     // Catch: Throwable -> L20
        this.f470255o = true;     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public final synchronized void e() throws IOException {
        monitor-enter(this);
        g();     // Catch: Throwable -> L9
        c[] r100 = (c[]) this.f470251k.values().toArray(new c[this.f470251k.size()]);     // Catch: Throwable -> L9
        int r101 = r100.length;     // Catch: Throwable -> L9
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L6;
        n(r100[r102]);     // Catch: Throwable -> L9
        r102 = r102 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        this.f470256p = false;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Flushable
    public final synchronized void flush() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f470254n == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        a();     // Catch: Throwable -> L10
        p();     // Catch: Throwable -> L10
        this.f470250j.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r100 = this.f470255o;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void l() throws IOException {
        monitor-enter(this);
        BufferedSink r100 = this.f470250j;     // Catch: Throwable -> L28
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L28
    L6:
        BufferedSink r101 = Okio.buffer(this.f470241a.sink(this.f470244d));     // Catch: Throwable -> L28
        r101.writeUtf8("libcore.io.DiskLruCache").writeByte(10);     // Catch: Throwable -> L16
        r101.writeUtf8("1").writeByte(10);     // Catch: Throwable -> L16
        r101.writeDecimalLong(this.f470246f).writeByte(10);     // Catch: Throwable -> L16
        r101.writeDecimalLong(this.f470248h).writeByte(10);     // Catch: Throwable -> L16
        r101.writeByte(10);     // Catch: Throwable -> L16
        Iterator<c> r102 = this.f470251k.values().iterator();     // Catch: Throwable -> L16
    L8:
        int r103 = 0;
        if (r102.hasNext() == false) goto L20;
        c r104 = r102.next();     // Catch: Throwable -> L16
        if (r104.f470272f != null) goto L12;
        r101.writeUtf8("CLEAN").writeByte(32);     // Catch: Throwable -> L16
        r101.writeUtf8(r104.f470267a);     // Catch: Throwable -> L16
        long[] r105 = r104.f470268b;     // Catch: Throwable -> L16
        int r106 = r105.length;     // Catch: Throwable -> L16
    L14:
        if (r103 >= r106) goto L18;
        r101.writeByte(32).writeDecimalLong(r105[r103]);     // Catch: Throwable -> L16
        r103 = r103 + 1;     // Catch: Throwable -> L16
        goto L14
    L18:
        r101.writeByte(10);     // Catch: Throwable -> L16
        goto L8
    L12:
        r101.writeUtf8("DIRTY").writeByte(32);     // Catch: Throwable -> L16
        r101.writeUtf8(r104.f470267a);     // Catch: Throwable -> L16
        r101.writeByte(10);     // Catch: Throwable -> L16
        goto L8
    L20:
        r101.close();     // Catch: Throwable -> L28
        if (this.f470241a.exists(this.f470243c) == false) goto L23;
        this.f470241a.rename(this.f470243c, this.f470245e);     // Catch: Throwable -> L28
    L23:
        this.f470241a.rename(this.f470244d, this.f470243c);     // Catch: Throwable -> L28
        this.f470241a.delete(this.f470245e);     // Catch: Throwable -> L28
        this.f470250j = Okio.buffer(new f(this, this.f470241a.appendingSink(this.f470243c)));     // Catch: Throwable -> L28
        this.f470253m = false;     // Catch: Throwable -> L28
        this.f470257q = false;     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    static {
        f470240u = PatternProtector.compile("[a-z0-9_-]{1,120}");
    }

    public final synchronized void g() throws IOException {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.f470254n == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.f470241a.exists(this.f470245e) == false) goto L16;
        if (this.f470241a.exists(this.f470243c) == false) goto L13;
        this.f470241a.delete(this.f470245e);     // Catch: Throwable -> L31
        goto L16
    L13:
        this.f470241a.rename(this.f470245e, this.f470243c);     // Catch: Throwable -> L31
    L16:
        if (this.f470241a.exists(this.f470243c) == true) goto L36;
    L28:
        l();     // Catch: Throwable -> L31
        this.f470254n = true;     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L36:
        j();     // Catch: IOException -> L20 Throwable -> L31
        i();     // Catch: IOException -> L20 Throwable -> L31
        this.f470254n = true;     // Catch: IOException -> L20 Throwable -> L31
        monitor-exit(this);
        return;
    L20:
        e = move-exception;
        hvc.g.f487396a.m(5, "DiskLruCache " + this.f470242b + " is corrupt: " + e.getMessage() + ", removing", e);     // Catch: Throwable -> L31
        delete();     // Catch: Throwable -> L25
        this.f470255o = false;     // Catch: Throwable -> L31
        goto L28
    L25:
        th = move-exception;
        this.f470255o = false;     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    }

    public final boolean h() {
        int r100 = this.f470252l;
        if (r100 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r100 < this.f470251k.size()) goto L7;
        return true;
    }

    public final void i() throws IOException {
        this.f470241a.delete(this.f470244d);
        Iterator<c> r100 = this.f470251k.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        c r101 = r100.next();
        int r102 = 0;
        if (r101.f470272f == null) goto L8;
        r101.f470272f = null;
    L12:
        if (r102 >= this.f470248h) goto L14;
        this.f470241a.delete(r101.f470269c[r102]);
        this.f470241a.delete(r101.f470270d[r102]);
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f470248h) goto L4;
        this.f470249i += r101.f470268b[r102];
        r102 = r102 + 1;
        goto L8
    }

    public final void j() throws IOException {
        BufferedSource r100 = Okio.buffer(this.f470241a.source(this.f470243c));
        String r101 = r100.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r102 = r100.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r103 = r100.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r104 = r100.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r105 = r100.readUtf8LineStrict();     // Catch: Throwable -> L24
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L23;
        if ("1".equals(r102) == false) goto L23;
        if (Integer.toString(this.f470246f).equals(r103) == false) goto L23;
        if (Integer.toString(this.f470248h).equals(r104) == false) goto L23;
        if ("".equals(r105) == false) goto L23;
        int r106 = 0;
    L28:
        k(r100.readUtf8LineStrict());     // Catch: EOFException -> L16 Throwable -> L24
        r106 = r106 + 1;
        goto L28
    L16:
        this.f470252l = r106 - this.f470251k.size();     // Catch: Throwable -> L24
        if (r100.exhausted() == true) goto L19;
        l();     // Catch: Throwable -> L24
    L20:
        cvc.c.e(r100);
        return;
    L19:
        this.f470250j = Okio.buffer(new f(this, this.f470241a.appendingSink(this.f470243c)));     // Catch: Throwable -> L24
    L23:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        cvc.c.e(r100);
        throw th;
    }

    public final void p() throws IOException {
    L3:
        if (this.f470249i <= this.f470247g) goto L5;
        n(this.f470251k.values().iterator().next());
        goto L3
    L5:
        this.f470256p = false;
    }

    public void delete() throws IOException {
        close();
        this.f470241a.deleteContents(this.f470242b);
    }

    public static void q(String r100) {
        if (f470240u.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");
    }

    public final synchronized d f(String r100) throws IOException {
        monitor-enter(this);
        g();     // Catch: Throwable -> L19
        a();     // Catch: Throwable -> L19
        q(r100);     // Catch: Throwable -> L19
        c r101 = this.f470251k.get(r100);     // Catch: Throwable -> L19
        if (r101 != null) goto L6;
    L17:
        monitor-exit(this);
        return null;
    L6:
        if (r101.f470271e == false) goto L17;
        d r102 = r101.a();     // Catch: Throwable -> L19
        if (r102 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        this.f470252l++;     // Catch: Throwable -> L19
        this.f470250j.writeUtf8("READ").writeByte(32).writeUtf8(r100).writeByte(10);     // Catch: Throwable -> L19
        if (h() == false) goto L15;
        this.f470259s.execute(this.f470260t);     // Catch: Throwable -> L19
    L15:
        monitor-exit(this);
        return r102;
    L19:
        th = move-exception;
        throw th;
    }

    public final void k(String r100) throws IOException {
        int r101 = r100.indexOf(32);
        if (r101 == (-1)) goto L46;
        int r102 = r101 + 1;
        int r103 = r100.indexOf(32, r102);
        if (r103 != (-1)) goto L12;
        String r104 = r100.substring(r102);
        if (r101 == 6) goto L9;
    L13:
        c r105 = this.f470251k.get(r104);
        if (r105 != null) goto L17;
        r105 = new c(this, r104);
        this.f470251k.put(r104, r105);
    L17:
        if (r103 == (-1)) goto L32;
        if (r101 != 5) goto L32;
        if (r100.startsWith("CLEAN") == false) goto L32;
        String[] r106 = r100.substring(r103 + 1).split(" ");
        r105.f470271e = true;
        r105.f470272f = null;
        if (r106.length != r105.f470274h.f470248h) goto L31;
        int r107 = 0;
    L47:
        if (r107 >= r106.length) goto L51;
        r105.f470268b[r107] = CastLongProtector.parseLong(r106[r107]);     // Catch: NumberFormatException -> L28
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
        r105.f470272f = new b(this, r105);
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
        this.f470251k.remove(r104);
        return;
    L12:
        r104 = r100.substring(r102, r103);
        goto L13
    L46:
        throw new IOException("unexpected journal line: ".concat(r100));
    }

    public final synchronized boolean m(String r100) throws IOException {
        monitor-enter(this);
        g();     // Catch: Throwable -> L14
        a();     // Catch: Throwable -> L14
        q(r100);     // Catch: Throwable -> L14
        c r101 = this.f470251k.get(r100);     // Catch: Throwable -> L14
        if (r101 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        n(r101);     // Catch: Throwable -> L14
        if (this.f470249i > this.f470247g) goto L11;
        this.f470256p = false;     // Catch: Throwable -> L14
    L11:
        monitor-exit(this);
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    public final void n(c r100) throws IOException {
        b r101 = r100.f470272f;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        int r102 = 0;
    L7:
        if (r102 >= this.f470248h) goto L9;
        this.f470241a.delete(r100.f470269c[r102]);
        long r103 = this.f470249i;
        long[] r104 = r100.f470268b;
        this.f470249i = r103 - r104[r102];
        r104[r102] = 0;
        r102 = r102 + 1;
        goto L7
    L9:
        this.f470252l++;
        this.f470250j.writeUtf8("REMOVE").writeByte(32).writeUtf8(r100.f470267a).writeByte(10);
        this.f470251k.remove(r100.f470267a);
        if (h() == false) goto L14;
        this.f470259s.execute(this.f470260t);
        return;
    }

    public final synchronized void b(b r110, boolean r111) throws IOException {
        monitor-enter(this);
        c r100 = r110.f470262a;     // Catch: Throwable -> L50
        if (r100.f470272f != r110) goto L49;
        int r101 = 0;
        if (r111 == true) goto L8;
    L22:
        int r112 = 0;
    L24:
        if (r112 >= this.f470248h) goto L32;
        File r102 = r100.f470270d[r112];     // Catch: Throwable -> L50
        if (r111 == true) goto L28;
        this.f470241a.delete(r102);     // Catch: Throwable -> L50
    L31:
        r112 = r112 + 1;     // Catch: Throwable -> L50
        goto L24
    L28:
        if (this.f470241a.exists(r102) == false) goto L31;
        File r103 = r100.f470269c[r112];     // Catch: Throwable -> L50
        this.f470241a.rename(r102, r103);     // Catch: Throwable -> L50
        long r104 = r100.f470268b[r112];     // Catch: Throwable -> L50
        long r105 = this.f470241a.size(r103);     // Catch: Throwable -> L50
        r100.f470268b[r112] = r105;     // Catch: Throwable -> L50
        this.f470249i = (this.f470249i - r104) + r105;     // Catch: Throwable -> L50
        goto L31
    L32:
        this.f470252l++;     // Catch: Throwable -> L50
        r100.f470272f = null;     // Catch: Throwable -> L50
        if ((r100.f470271e | r111) == false) goto L40;
        r100.f470271e = true;     // Catch: Throwable -> L50
        this.f470250j.writeUtf8("CLEAN").writeByte(32);     // Catch: Throwable -> L50
        this.f470250j.writeUtf8(r100.f470267a);     // Catch: Throwable -> L50
        BufferedSink r113 = this.f470250j;     // Catch: Throwable -> L50
        long[] r106 = r100.f470268b;     // Catch: Throwable -> L50
        int r107 = r106.length;     // Catch: Throwable -> L50
    L35:
        if (r101 >= r107) goto L37;
        r113.writeByte(32).writeDecimalLong(r106[r101]);     // Catch: Throwable -> L50
        r101 = r101 + 1;     // Catch: Throwable -> L50
        goto L35
    L37:
        this.f470250j.writeByte(10);     // Catch: Throwable -> L50
        if (r111 == false) goto L41;
        long r114 = this.f470258r;     // Catch: Throwable -> L50
        this.f470258r = 1 + r114;     // Catch: Throwable -> L50
        r100.f470273g = r114;     // Catch: Throwable -> L50
    L41:
        this.f470250j.flush();     // Catch: Throwable -> L50
        if (this.f470249i <= this.f470247g) goto L44;
    L45:
        this.f470259s.execute(this.f470260t);     // Catch: Throwable -> L50
    L46:
        monitor-exit(this);
        return;
    L44:
        if (h() == false) goto L46;
    L40:
        this.f470251k.remove(r100.f470267a);     // Catch: Throwable -> L50
        this.f470250j.writeUtf8("REMOVE").writeByte(32);     // Catch: Throwable -> L50
        this.f470250j.writeUtf8(r100.f470267a);     // Catch: Throwable -> L50
        this.f470250j.writeByte(10);     // Catch: Throwable -> L50
        goto L41
    L8:
        if (r100.f470271e == true) goto L22;
        int r108 = 0;
    L11:
        if (r108 >= this.f470248h) goto L22;
        if (r110.f470263b[r108] == false) goto L20;
        if (this.f470241a.exists(r100.f470270d[r108]) == false) goto L16;
        r108 = r108 + 1;
        goto L11
    L16:
        r110.a();     // Catch: Throwable -> L50
        monitor-exit(this);
        return;
    L20:
        r110.a();     // Catch: Throwable -> L50
        throw new IllegalStateException("Newly created entry didn't create value for index " + r108);     // Catch: Throwable -> L50
    L49:
        throw new IllegalStateException();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    }

    public final synchronized b d(String r100, long r101) throws IOException {
        monitor-enter(this);
        g();     // Catch: Throwable -> L33
        a();     // Catch: Throwable -> L33
        q(r100);     // Catch: Throwable -> L33
        c r102 = this.f470251k.get(r100);     // Catch: Throwable -> L33
        if (r101 == (-1)) goto L11;
        if (r102 != null) goto L8;
    L9:
        monitor-exit(this);
        return null;
    L8:
        if (r102.f470273g != r101) goto L9;
    L11:
        if (r102 == null) goto L17;
        if (r102.f470272f == null) goto L17;
        monitor-exit(this);
        return null;
    L17:
        if (this.f470256p == false) goto L19;
    L30:
        this.f470259s.execute(this.f470260t);     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L19:
        if (this.f470257q == true) goto L30;
        this.f470250j.writeUtf8("DIRTY").writeByte(32).writeUtf8(r100).writeByte(10);     // Catch: Throwable -> L33
        this.f470250j.flush();     // Catch: Throwable -> L33
        if (this.f470253m == false) goto L25;
        monitor-exit(this);
        return null;
    L25:
        if (r102 != null) goto L27;
        r102 = new c(this, r100);     // Catch: Throwable -> L33
        this.f470251k.put(r100, r102);     // Catch: Throwable -> L33
    L27:
        b r103 = new b(this, r102);     // Catch: Throwable -> L33
        r102.f470272f = r103;     // Catch: Throwable -> L33
        monitor-exit(this);
        return r103;
    L33:
        th = move-exception;
        throw th;
    }

    public static e c(FileSystem r110, File r111, int r112, int r113, long r114) {
        if (r114 <= 0) goto L10;
        if (r113 <= 0) goto L8;
        TimeUnit r100 = TimeUnit.SECONDS;
        LinkedBlockingQueue r101 = new LinkedBlockingQueue();
        byte[] r102 = cvc.c.f465513a;
        return new e(r110, r111, r112, r113, r114, new PThreadPoolExecutor(0, 1, 60, r100, r101, new cvc.d("OkHttp DiskLruCache", true)));
    L8:
        throw new IllegalArgumentException("valueCount <= 0");
    L10:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public e(FileSystem r100, File r101, int r102, int r110, long r111, PThreadPoolExecutor r112) {
        this.f470249i = 0;
        this.f470251k = new LinkedHashMap(0, 0.75f, true);
        this.f470258r = 0;
        this.f470260t = new a(this);
        this.f470241a = r100;
        this.f470242b = r101;
        this.f470246f = r102;
        this.f470243c = new PolarisFileWrapper(r101, "journal");
        this.f470244d = new PolarisFileWrapper(r101, "journal.tmp");
        this.f470245e = new PolarisFileWrapper(r101, "journal.bkp");
        this.f470248h = r110;
        this.f470247g = r111;
        this.f470259s = r112;
    }
}
