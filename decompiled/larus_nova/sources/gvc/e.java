package gvc;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.ttnet.TTConfigManager;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes42.dex */
public final class e implements Closeable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final PThreadPoolExecutor f482885x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f482886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC6073e f482887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, o> f482888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f482889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f482890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f482891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f482892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PThreadScheduledThreadPoolExecutor f482893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PThreadPoolExecutor f482894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r.a f482895j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f482896k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f482897l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f482898m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f482899n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f482900o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f482901p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f482902q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final s f482903r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final s f482904s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Socket f482905t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p f482906u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f482907v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Set<Integer> f482908w;

    public class a extends cvc.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f482909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ErrorCode f482910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f482911d;

        @Override // cvc.b
        public final void a() {
            e r100 = this.f482911d;     // Catch: IOException -> L4
            int r101 = this.f482909b;     // Catch: IOException -> L4
            ErrorCode r102 = this.f482910c;     // Catch: IOException -> L4
            r100.f482906u.g(r101, r102);     // Catch: IOException -> L4
            return;
        L4:
            this.f482911d.b();
        }

        public a(e r100, Object[] r101, int r102, ErrorCode r103) {
            this.f482911d = r100;
            this.f482909b = r102;
            this.f482910c = r103;
            super("OkHttp %s stream %d", r101);
        }
    }

    public class b extends cvc.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f482912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f482913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f482914d;

        @Override // cvc.b
        public final void a() {
            this.f482914d.f482906u.j(this.f482912b, this.f482913c);     // Catch: IOException -> L4
            return;
        L4:
            this.f482914d.b();
        }

        public b(e r100, Object[] r101, int r102, long r103) {
            this.f482914d = r100;
            this.f482912b = r102;
            this.f482913c = r103;
            super("OkHttp Window Update %s stream %d", r101);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Socket f482915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f482916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BufferedSource f482917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BufferedSink f482918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AbstractC6073e f482919e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final r.a f482920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f482921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f482922h;

        public c() {
            this.f482919e = AbstractC6073e.f482924a;
            this.f482920f = r.f482997a;
            this.f482921g = true;
        }
    }

    public final class d extends cvc.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f482923b;

        @Override // cvc.b
        public final void a() {
            if (TTConfigManager.inst().getAppResume() == true) goto L5;
            return;
        L5:
            e r100 = this.f482923b;
            monitor-enter(r100);
            e r101 = this.f482923b;     // Catch: Throwable -> L18
            long r102 = r101.f482897l;     // Catch: Throwable -> L18
            long r103 = r101.f482896k;     // Catch: Throwable -> L18
            if (r102 >= r103) goto L10;
            boolean r104 = true;
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L18
            if (r104 == false) goto L23;
            r101.b();
            return;
        L23:
            r101.f482906u.f(false, 1, 0);     // Catch: IOException -> L16
            return;
        L16:
            r101.b();
            return;
        L10:
            r101.f482896k = r103 + 1;     // Catch: Throwable -> L18
            r104 = false;
        L18:
            th = move-exception;
            throw th;
        }

        public d(e r100) {
            this.f482923b = r100;
            super("OkHttp %s ping", new Object[]{r100.f482889d});
        }
    }

    /* JADX INFO: renamed from: gvc.e$e, reason: collision with other inner class name */
    public static abstract class AbstractC6073e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f482924a = null;

        /* JADX INFO: renamed from: gvc.e$e$a */
        public static class a extends AbstractC6073e {
            public a() {
            }

            @Override // gvc.e.AbstractC6073e
            public final void b(o r100) throws IOException {
                r100.c(ErrorCode.REFUSED_STREAM);
            }
        }

        public AbstractC6073e() {
        }

        public void a(e r100) {
        }

        public abstract void b(o r100) throws IOException;

        static {
            f482924a = new a();
        }
    }

    public final class f extends cvc.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f482925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f482926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f482927d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f482928e;

        @Override // cvc.b
        public final void a() {
            e r100 = this.f482928e;
            boolean r101 = this.f482925b;
            int r102 = this.f482926c;
            int r103 = this.f482927d;
            r100.getClass();
            r100.f482906u.f(r101, r102, r103);     // Catch: IOException -> L5
            return;
        L5:
            r100.b();
        }

        public f(e r100, int r101, int r102) {
            this.f482928e = r100;
            super("OkHttp %s ping %08x%08x", new Object[]{r100.f482889d, Integer.valueOf(r101), Integer.valueOf(r102)});
            this.f482925b = true;
            this.f482926c = r101;
            this.f482927d = r102;
        }
    }

    public class g extends cvc.b implements n.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f482929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f482930c;

        @Override // cvc.b
        public final void a() {
            ErrorCode r100 = ErrorCode.INTERNAL_ERROR;
            this.f482929b.c(this);     // Catch: Throwable -> L11 IOException -> L13
        L5:
            if (this.f482929b.b(false, this) == true) goto L5;
            ErrorCode r101 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L11 IOException -> L13
            ErrorCode r102 = ErrorCode.CANCEL;     // Catch: IOException -> L23 Throwable -> L18
            this.f482930c.a(r101, r102);     // Catch: IOException -> L22
        L25:
        L18:
            th = th;
        L28:
            this.f482930c.a(r101, r100);     // Catch: IOException -> L24
        L20:
            cvc.c.e(this.f482929b);
            throw th;
        L14:
            ErrorCode r103 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L18
            this.f482930c.a(r103, r103);     // Catch: IOException -> L22
            goto L25
        L13:
            r101 = r100;
        L11:
            th = th;
            r101 = r100;
        L16:
            cvc.c.e(this.f482929b);
        }

        public g(e r100, n r101) {
            this.f482930c = r100;
            super("OkHttp %s", new Object[]{r100.f482889d});
            this.f482929b = r101;
        }
    }

    public final synchronized int d() {
        monitor-enter(this);
        s r100 = this.f482904s;     // Catch: Throwable -> L10
        if ((r100.f482998a & 16) == 0) goto L7;
        int r101 = r100.f482999b[4];     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = Integer.MAX_VALUE;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        TimeUnit r100 = TimeUnit.SECONDS;
        SynchronousQueue r101 = new SynchronousQueue();
        byte[] r102 = cvc.c.f465513a;
        f482885x = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r100, r101, new cvc.d("OkHttp Http2Connection", true));
    }

    public final void b() {
        ErrorCode r100 = ErrorCode.PROTOCOL_ERROR;     // Catch: IOException -> L4
        a(r100, r100);     // Catch: IOException -> L4
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public e(c r210) {
        this.f482888c = new LinkedHashMap();
        this.f482896k = 0;
        this.f482897l = 0;
        this.f482898m = 0;
        this.f482899n = 0;
        this.f482900o = 0;
        this.f482901p = 0;
        s r100 = new s();
        this.f482903r = r100;
        s r101 = new s();
        this.f482904s = r101;
        this.f482908w = new LinkedHashSet();
        this.f482895j = r210.f482920f;
        boolean r102 = r210.f482921g;
        this.f482886a = r102;
        this.f482887b = r210.f482919e;
        if (r102 == false) goto L5;
        int r103 = 1;
    L6:
        this.f482891f = r103;
        if (r102 == false) goto L10;
        this.f482891f = r103 + 2;
    L10:
        if (r102 == false) goto L12;
        r100.b(7, 16777216);
    L12:
        String r104 = r210.f482916b;
        this.f482889d = r104;
        PThreadScheduledThreadPoolExecutor r105 = new PThreadScheduledThreadPoolExecutor(1, new cvc.d(cvc.c.l("OkHttp %s Writer", new Object[]{r104}), false));
        this.f482893h = r105;
        if (r210.f482922h == 0) goto L15;
        d r106 = new d(this);
        long r110 = r210.f482922h;
        r105.scheduleAtFixedRate(r106, r110, r110, TimeUnit.MILLISECONDS);
    L15:
        this.f482894i = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new cvc.d(cvc.c.l("OkHttp %s Push Observer", new Object[]{r104}), true));
        r101.b(7, 65535);
        r101.b(5, 16384);
        this.f482902q = r101.a();
        this.f482905t = r210.f482915a;
        this.f482906u = new p(r210.f482918d, r102);
        this.f482907v = new g(this, new n(r210.f482917c, r102));
        return;
    L5:
        r103 = 2;
        goto L6
    }

    public final synchronized o c(int r100) {
        monitor-enter(this);
        Map<Integer, o> r101 = this.f482888c;     // Catch: Throwable -> L6
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L6
        o r103 = (o) r102.get(Integer.valueOf(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(cvc.b r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f482892g == true) goto L6;
        this.f482894i.execute(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized o f(int r100) {
        monitor-enter(this);
        o r101 = this.f482888c.remove(Integer.valueOf(r100));     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final void g(ErrorCode r100) throws IOException {
        p r101 = this.f482906u;
        monitor-enter(r101);
        monitor-enter(this);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.f482892g == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L19
        return;
    L11:
        this.f482892g = true;     // Catch: Throwable -> L16
        int r102 = this.f482890e;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.f482906u.d(r102, r100, cvc.c.f465513a);     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(long r100) {
        monitor-enter(this);
        long r101 = this.f482901p + r100;     // Catch: Throwable -> L8
        this.f482901p = r101;     // Catch: Throwable -> L8
        if (r101 < (this.f482903r.a() / 2)) goto L6;
        k(0, this.f482901p);     // Catch: Throwable -> L8
        this.f482901p = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void a(ErrorCode r100, ErrorCode r101) throws IOException {
        o[] r102 = null;
        g(r100);     // Catch: IOException -> L5
        e = null;
    L6:
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L8:
        if (this.f482888c.isEmpty() == true) goto L10;
        r102 = (o[]) ((LinkedHashMap) this.f482888c).values().toArray(new o[this.f482888c.size()]);     // Catch: Throwable -> L33
        ((LinkedHashMap) this.f482888c).clear();     // Catch: Throwable -> L33
    L10:
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r102 == null) goto L40;
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L40;
        r102[r104].c(r101);     // Catch: IOException -> L17
    L20:
        r104 = r104 + 1;
    L17:
        e = move-exception;
        if (e == null) goto L20;
        e = e;
    L40:
        this.f482906u.close();     // Catch: IOException -> L23
    L44:
        this.f482905t.close();     // Catch: IOException -> L28
    L29:
        this.f482893h.shutdown();
        this.f482894i.shutdown();
        if (e != null) goto L32;
        return;
    L32:
        throw e;
    L28:
        e = e;
    L23:
        e = move-exception;
        if (e != null) goto L44;
        e = e;
    L5:
        e = e;
        goto L6
    }

    public final void j(int r100, ErrorCode r101) {
        this.f482893h.execute(new a(this, new Object[]{this.f482889d, Integer.valueOf(r100)}, r100, r101));     // Catch: RejectedExecutionException -> L4
        return;
    }

    public final void k(int r100, long r110) {
        this.f482893h.execute(new b(this, new Object[]{this.f482889d, Integer.valueOf(r100)}, r100, r110));     // Catch: RejectedExecutionException -> L4
        return;
    }

    public final void i(int r100, boolean r110, Buffer r111, long r112) throws IOException {
        if (r112 != 0) goto L7;
        this.f482906u.b(r110, r100, r111, 0);
        return;
    L7:
        if (r112 <= 0) goto L31;
        monitor-enter(this);
    L32:
        long r101 = this.f482902q;     // Catch: Throwable -> L25 InterruptedException -> L27
        if (r101 > 0) goto L16;
        if (this.f482888c.containsKey(Integer.valueOf(r100)) == false) goto L15;
        wait();     // Catch: Throwable -> L25 InterruptedException -> L27
        goto L32
    L15:
        throw new IOException("stream closed");     // Catch: Throwable -> L25 InterruptedException -> L27
    L16:
        int r102 = Math.min((int) Math.min(r112, r101), this.f482906u.f482987d);     // Catch: Throwable -> L25
        long r103 = r102;
        this.f482902q -= r103;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        r112 = r112 - r103;
        p r104 = this.f482906u;
        if (r110 == true) goto L21;
    L23:
        boolean r105 = false;
    L24:
        r104.b(r105, r100, r111, r102);
        goto L7
    L21:
        if (r112 != 0) goto L23;
        r105 = true;
    L27:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L25
        throw new InterruptedIOException();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
