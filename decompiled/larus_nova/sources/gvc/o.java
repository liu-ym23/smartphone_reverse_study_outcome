package gvc;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.j0;

/* JADX INFO: loaded from: classes42.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f482961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f482962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f482963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f482964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque<Headers> f482965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f482966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f482967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f482968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f482969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f482970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ErrorCode f482971k;

    public final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Buffer f482972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f482973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f482974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f482975d;

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            o r100 = this.f482975d;
            monitor-enter(r100);
        L26:
            th = move-exception;
            throw th;
        L5:
            if (this.f482973b == false) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L26
            return;
        L8:
            monitor-exit(r100);     // Catch: Throwable -> L26
            if (this.f482975d.f482968h.f482974c == false) goto L12;
        L17:
            o r101 = this.f482975d;
            monitor-enter(r101);
            this.f482973b = true;     // Catch: Throwable -> L23
            monitor-exit(r101);     // Catch: Throwable -> L23
            this.f482975d.f482964d.f482906u.flush();
            this.f482975d.a();
            return;
        L23:
            th = move-exception;
            throw th;
        L12:
            if (this.f482972a.size() > 0) goto L14;
            o r102 = this.f482975d;
            r102.f482964d.i(r102.f482963c, true, null, 0);
        L14:
            if (this.f482972a.size() <= 0) goto L17;
            a(true);
            goto L14
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            o r100 = this.f482975d;
            monitor-enter(r100);
            this.f482975d.b();     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
        L7:
            if (this.f482972a.size() <= 0) goto L9;
            a(false);
            this.f482975d.f482964d.f482906u.flush();
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // okio.Sink
        public final j0 timeout() {
            return this.f482975d.f482970j;
        }

        static {
        }

        public a(o r100) {
            this.f482975d = r100;
            this.f482972a = new Buffer();
        }

        public final void a(boolean r110) throws IOException {
            o r100 = this.f482975d;
            monitor-enter(r100);
            this.f482975d.f482970j.j();     // Catch: Throwable -> L33
        L36:
            o r101 = this.f482975d;     // Catch: Throwable -> L30
            if (r101.f482962b > 0) goto L15;
            if (this.f482974c == true) goto L15;
            if (this.f482973b == true) goto L15;
            if (r101.f482971k != null) goto L15;
            r101.j();     // Catch: Throwable -> L30
        L15:
            r101.f482970j.n();     // Catch: Throwable -> L33
            this.f482975d.b();     // Catch: Throwable -> L33
            long r102 = Math.min(this.f482975d.f482962b, this.f482972a.size());     // Catch: Throwable -> L33
            o r103 = this.f482975d;     // Catch: Throwable -> L33
            r103.f482962b -= r102;     // Catch: Throwable -> L33
            monitor-exit(r100);     // Catch: Throwable -> L33
            r103.f482970j.j();
            o r104 = this.f482975d;     // Catch: Throwable -> L27
            e r105 = r104.f482964d;     // Catch: Throwable -> L27
            int r106 = r104.f482963c;     // Catch: Throwable -> L27
            if (r110 == true) goto L21;
        L23:
            boolean r107 = false;
        L24:
            r105.i(r106, r107, this.f482972a, r102);     // Catch: Throwable -> L27
            this.f482975d.f482970j.n();
            return;
        L21:
            if (r102 != this.f482972a.size()) goto L23;
            r107 = true;
        L27:
            th = move-exception;
            this.f482975d.f482970j.n();
            throw th;
        L30:
            th = move-exception;
            this.f482975d.f482970j.n();     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        }

        @Override // okio.Sink
        public final void write(Buffer r100, long r101) throws IOException {
            this.f482972a.write(r100, r101);
        L4:
            if (this.f482972a.size() < 16384) goto L6;
            a(false);
            goto L4
        }
    }

    public final class b implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Buffer f482976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Buffer f482977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f482978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f482979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f482980e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ o f482981f;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            o r100 = this.f482981f;
            monitor-enter(r100);
            this.f482979d = true;     // Catch: Throwable -> L15
            long r101 = this.f482977b.size();     // Catch: Throwable -> L15
            this.f482977b.clear();     // Catch: Throwable -> L15
            if (((ArrayDeque) this.f482981f.f482965e).isEmpty() == true) goto L8;
            this.f482981f.getClass();     // Catch: Throwable -> L15
        L8:
            this.f482981f.notifyAll();     // Catch: Throwable -> L15
            monitor-exit(r100);     // Catch: Throwable -> L15
            if (r101 <= 0) goto L13;
            this.f482981f.f482964d.h(r101);
        L13:
            this.f482981f.a();
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public final j0 timeout() {
            return this.f482981f.f482969i;
        }

        static {
        }

        public b(o r100, long r101) {
            this.f482981f = r100;
            this.f482976a = new Buffer();
            this.f482977b = new Buffer();
            this.f482978c = r101;
        }

        @Override // okio.Source
        public final long read(Buffer r110, long r111) throws IOException {
            if (r111 < 0) goto L50;
        L4:
            o r100 = this.f482981f;
            monitor-enter(r100);
            this.f482981f.f482969i.j();     // Catch: Throwable -> L46
            o r101 = this.f482981f;     // Catch: Throwable -> L43
            ErrorCode r102 = r101.f482971k;     // Catch: Throwable -> L43
            if (r102 != null) goto L12;
            r102 = null;
        L12:
            if (this.f482979d == true) goto L42;
            if (((ArrayDeque) r101.f482965e).isEmpty() == true) goto L17;
            this.f482981f.getClass();     // Catch: Throwable -> L43
        L17:
            if (this.f482977b.size() > 0) goto L18;
            if (this.f482980e == true) goto L30;
            if (r102 != null) goto L30;
            this.f482981f.j();     // Catch: Throwable -> L43
            this.f482981f.f482969i.n();     // Catch: Throwable -> L46
            monitor-exit(r100);     // Catch: Throwable -> L46
        L30:
            long r112 = -1;
        L31:
            this.f482981f.f482969i.n();     // Catch: Throwable -> L46
            monitor-exit(r100);     // Catch: Throwable -> L46
            if (r112 == (-1)) goto L37;
            this.f482981f.f482964d.h(r112);
            return r112;
        L37:
            if (r102 != null) goto L40;
            return -1;
        L40:
            throw new StreamResetException(r102);
        L18:
            Buffer r103 = this.f482977b;     // Catch: Throwable -> L43
            r112 = r103.read(r110, Math.min(r111, r103.size()));     // Catch: Throwable -> L43
            o r113 = this.f482981f;     // Catch: Throwable -> L43
            long r104 = r113.f482961a + r112;     // Catch: Throwable -> L43
            r113.f482961a = r104;     // Catch: Throwable -> L43
            if (r102 != null) goto L31;
            if (r104 < (r113.f482964d.f482903r.a() / 2)) goto L31;
            o r114 = this.f482981f;     // Catch: Throwable -> L43
            r114.f482964d.k(r114.f482963c, r114.f482961a);     // Catch: Throwable -> L43
            this.f482981f.f482961a = 0;     // Catch: Throwable -> L43
            goto L31
        L42:
            throw new IOException("stream closed");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            this.f482981f.f482969i.n();     // Catch: Throwable -> L46
            throw th;     // Catch: Throwable -> L46
        L46:
            th = move-exception;
            throw th;
        L50:
            throw new IllegalArgumentException("byteCount < 0: " + r111);
        }
    }

    public class c extends okio.c {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ o f482982m;

        @Override // okio.c
        public final void m() {
            o r100 = this.f482982m;
            ErrorCode r101 = ErrorCode.CANCEL;
            if (r100.d(r101) == false) goto L6;
            r100.f482964d.j(r100.f482963c, r101);
        L6:
            e r102 = this.f482982m.f482964d;
            monitor-enter(r102);
            long r103 = r102.f482899n;     // Catch: Throwable -> L16
            long r104 = r102.f482898m;     // Catch: Throwable -> L16
            if (r103 >= r104) goto L12;
            monitor-exit(r102);     // Catch: Throwable -> L16
            return;
        L12:
            r102.f482898m = r104 + 1;     // Catch: Throwable -> L16
            r102.f482900o = System.nanoTime() + C.NANOS_PER_SECOND;     // Catch: Throwable -> L16
            monitor-exit(r102);     // Catch: Throwable -> L16
            r102.f482893h.execute(new f(r102, new Object[]{r102.f482889d}));     // Catch: RejectedExecutionException -> L19
            return;
        L24:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public final void n() throws IOException {
            if (k() == true) goto L6;
            return;
        L6:
            throw l(null);
        }

        public c(o r100) {
            this.f482982m = r100;
        }

        @Override // okio.c
        public final IOException l(IOException r100) {
            SocketTimeoutException r101 = new SocketTimeoutException("timeout");
            if (r100 == null) goto L5;
            r101.initCause(r100);
        L5:
            return r101;
        }
    }

    public final void a() throws IOException {
        monitor-enter(this);
        b r100 = this.f482967g;     // Catch: Throwable -> L20
        if (r100.f482980e == false) goto L6;
    L12:
        boolean r101 = false;
    L13:
        boolean r102 = f();     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r101 == false) goto L17;
        c(ErrorCode.CANCEL);
        return;
    L17:
        if (r102 == true) goto L26;
        this.f482964d.f(this.f482963c);
        return;
    L26:
        return;
    L6:
        if (r100.f482979d == false) goto L12;
        a r103 = this.f482968h;     // Catch: Throwable -> L20
        if (r103.f482974c == false) goto L10;
    L11:
        r101 = true;
        goto L13
    L10:
        if (r103.f482973b == false) goto L12;
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean f() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.f482971k == null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        b r100 = this.f482967g;     // Catch: Throwable -> L23
        if (r100.f482980e == false) goto L11;
    L12:
        a r101 = this.f482968h;     // Catch: Throwable -> L23
        if (r101.f482974c == false) goto L15;
    L16:
        if (this.f482966f == false) goto L20;
        monitor-exit(this);
        return false;
    L20:
        monitor-exit(this);
        return true;
    L15:
        if (r101.f482973b == false) goto L20;
    L11:
        if (r100.f482979d == false) goto L20;
        goto L12
    }

    public final void g() {
        monitor-enter(this);
        this.f482967g.f482980e = true;     // Catch: Throwable -> L8
        boolean r100 = f();     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r100 == true) goto L13;
        this.f482964d.f(this.f482963c);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void b() throws IOException {
        a r100 = this.f482968h;
        if (r100.f482973b == true) goto L14;
        if (r100.f482974c == true) goto L12;
        if (this.f482971k != null) goto L10;
        return;
    L10:
        throw new StreamResetException(this.f482971k);
    L12:
        throw new IOException("stream finished");
    L14:
        throw new IOException("stream closed");
    }

    public final boolean e() {
        if ((this.f482963c & 1) != 1) goto L5;
        boolean r100 = true;
    L7:
        if (this.f482964d.f482886a == r100) goto L11;
        return false;
    L11:
        return true;
    L5:
        r100 = false;
        goto L7
    }

    public final void j() throws InterruptedIOException {
        wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        ThreadMethodProxy.currentThread().interrupt();
        throw new InterruptedIOException();
    }

    static {
    }

    public final void c(ErrorCode r100) throws IOException {
        if (d(r100) == true) goto L5;
        return;
    L5:
        e r101 = this.f482964d;
        int r102 = this.f482963c;
        r101.f482906u.g(r102, r100);
    }

    public final boolean d(ErrorCode r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f482971k == null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L17
        return false;
    L8:
        if (this.f482967g.f482980e == true) goto L10;
    L13:
        this.f482971k = r100;     // Catch: Throwable -> L17
        notifyAll();     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        this.f482964d.f(this.f482963c);
        return true;
    L10:
        if (this.f482968h.f482974c == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L17
        return false;
    }

    public final void h(List<gvc.a> r100) {
        monitor-enter(this);
        this.f482966f = true;     // Catch: Throwable -> L9
        Deque<Headers> r101 = this.f482965e;     // Catch: Throwable -> L9
        ArrayDeque r102 = (ArrayDeque) r101;     // Catch: Throwable -> L9
        r102.add(cvc.c.v(r100));     // Catch: Throwable -> L9
        boolean r103 = f();     // Catch: Throwable -> L9
        notifyAll();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        if (r103 == true) goto L14;
        this.f482964d.f(this.f482963c);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void i(ErrorCode r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f482971k != null) goto L6;
        this.f482971k = r100;     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public o(int r100, e r101, boolean r102, boolean r103, @Nullable Headers r104) {
        this.f482961a = 0;
        ArrayDeque r105 = new ArrayDeque();
        this.f482965e = r105;
        this.f482969i = new c(this);
        this.f482970j = new c(this);
        this.f482971k = null;
        if (r101 == null) goto L21;
        this.f482963c = r100;
        this.f482964d = r101;
        this.f482962b = r101.f482904s.a();
        b r106 = new b(this, r101.f482903r.a());
        this.f482967g = r106;
        a r107 = new a(this);
        this.f482968h = r107;
        r106.f482980e = r103;
        r107.f482974c = r102;
        if (r104 == null) goto L8;
        r105.add(r104);
    L8:
        if (e() == false) goto L14;
        if (r104 == null) goto L14;
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
    L14:
        if (e() == true) goto L19;
        if (r104 == null) goto L18;
        return;
    L18:
        throw new IllegalStateException("remotely-initiated streams should have headers");
    L19:
        return;
    L21:
        throw new NullPointerException("connection == null");
    }
}
