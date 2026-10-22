package kvc;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.l;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements WebSocket, kvc.d.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List<Protocol> f506309v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f506310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebSocketListener f506311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Random f506312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f506313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l f506315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RunnableC6617a f506316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kvc.d f506317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public kvc.e f506318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PThreadScheduledThreadPoolExecutor f506319j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f506320k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayDeque<ByteString> f506321l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayDeque<Object> f506322m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f506323n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f506324o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScheduledFuture<?> f506325p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f506326q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f506327r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f506328s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f506329t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f506330u;

    /* JADX INFO: renamed from: kvc.a$a, reason: collision with other inner class name */
    public class RunnableC6617a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f506331a;

        @Override // java.lang.Runnable
        public final void run() {
        L14:
            if (this.f506331a.h() == true) goto L14;
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        L7:
            e = move-exception;
            this.f506331a.b(e, null);     // Catch: Throwable -> L5
        }

        public RunnableC6617a(a r100) {
            this.f506331a = r100;
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f506332a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f506332a.cancel();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f506332a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f506333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteString f506334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f506335c;

        public c(int r100, ByteString r101) {
            this.f506333a = r100;
            this.f506334b = r101;
            this.f506335c = 60000;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f506336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteString f506337b;

        public d(int r100, ByteString r101) {
            this.f506336a = r100;
            this.f506337b = r101;
        }
    }

    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f506338a;

        public final void a() {
            a r100 = this.f506338a;
            monitor-enter(r100);
        L22:
            th = move-exception;
            throw th;
        L5:
            if (r100.f506328s == false) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L22
            return;
        L8:
            kvc.e r101 = r100.f506318i;     // Catch: Throwable -> L22
            if (r100.f506330u == false) goto L11;
            int r102 = r100.f506329t;     // Catch: Throwable -> L22
        L12:
            r100.f506329t++;     // Catch: Throwable -> L22
            r100.f506330u = true;     // Catch: Throwable -> L22
            monitor-exit(r100);     // Catch: Throwable -> L22
            if (r102 == (-1)) goto L26;
            r100.b(new SocketTimeoutException("sent ping but didn't receive pong within " + r100.f506313d + "ms (after " + (r102 - 1) + " successful ping/pongs)"), null);
            return;
        L26:
            r101.a(9, ByteString.EMPTY);     // Catch: IOException -> L19
            return;
        L19:
            e = move-exception;
            r100.b(e, null);
            return;
        L11:
            r102 = -1;
            goto L12
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

        public e(a r100) {
            this.f506338a = r100;
        }
    }

    public static abstract class f implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f506339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f506340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BufferedSink f506341c;

        public f(BufferedSource r100, BufferedSink r101) {
            this.f506339a = true;
            this.f506340b = r100;
            this.f506341c = r101;
        }
    }

    public final boolean h() throws IOException {
        monitor-enter(this);
    L70:
        th = move-exception;
        throw th;
    L4:
        if (this.f506328s == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L70
        return false;
    L7:
        kvc.e r100 = this.f506318i;     // Catch: Throwable -> L70
        ByteString r101 = this.f506321l.poll();     // Catch: Throwable -> L70
        int r102 = -1;
        f r103 = null;
        if (r101 != null) goto L19;
        Object r104 = this.f506322m.poll();     // Catch: Throwable -> L70
        if ((r104 instanceof c) == false) goto L16;
        int r105 = this.f506326q;     // Catch: Throwable -> L70
        String r106 = this.f506327r;     // Catch: Throwable -> L70
        if (r105 == (-1)) goto L14;
        f r107 = this.f506320k;     // Catch: Throwable -> L70
        this.f506320k = null;     // Catch: Throwable -> L70
        this.f506319j.shutdown();     // Catch: Throwable -> L70
        r103 = r107;
    L15:
        r102 = r105;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L70
        if (r101 == null) goto L27;
        r100.a(10, r101);     // Catch: Throwable -> L67
    L60:
        cvc.c.e(r103);
        return true;
    L27:
        if ((r104 instanceof d) == false) goto L41;
        ByteString r108 = ((d) r104).f506337b;     // Catch: Throwable -> L67
        int r109 = ((d) r104).f506336a;     // Catch: Throwable -> L67
        long r110 = r108.size();     // Catch: Throwable -> L67
        if (r100.f506363h == true) goto L39;
        r100.f506363h = true;     // Catch: Throwable -> L67
        kvc.e.a r111 = r100.f506362g;     // Catch: Throwable -> L67
        r111.f506366a = r109;     // Catch: Throwable -> L67
        r111.f506367b = r110;     // Catch: Throwable -> L67
        r111.f506368c = true;     // Catch: Throwable -> L67
        r111.f506369d = false;     // Catch: Throwable -> L67
        BufferedSink r112 = Okio.buffer(r111);     // Catch: Throwable -> L67
        r112.write(r108);     // Catch: Throwable -> L67
        r112.close();     // Catch: Throwable -> L67
        monitor-enter(this);     // Catch: Throwable -> L67
        this.f506323n -= (long) r108.size();     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L39:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");     // Catch: Throwable -> L67
    L41:
        if ((r104 instanceof c) == false) goto L66;
        c r113 = (c) r104;     // Catch: Throwable -> L67
        int r114 = r113.f506333a;     // Catch: Throwable -> L67
        ByteString r115 = r113.f506334b;     // Catch: Throwable -> L67
        r100.getClass();     // Catch: Throwable -> L67
        ByteString r116 = ByteString.EMPTY;     // Catch: Throwable -> L67
        if (r114 != 0) goto L45;
        if (r115 != null) goto L45;
    L74:
        r100.a(8, r116);     // Catch: Throwable -> L62
        r100.f506360e = true;     // Catch: Throwable -> L67
        if (r103 == null) goto L60;
        this.f506311b.onClosed(this, r102, r106);     // Catch: Throwable -> L67
        goto L60
    L62:
        th = move-exception;
        r100.f506360e = true;     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L67
    L45:
        if (r114 == 0) goto L51;
        String r117 = kvc.c.a(r114);     // Catch: Throwable -> L67
        if (r117 == null) goto L51;
        throw new IllegalArgumentException(r117);     // Catch: Throwable -> L67
    L51:
        Buffer r118 = new Buffer();     // Catch: Throwable -> L67
        r118.writeShort(r114);     // Catch: Throwable -> L67
        if (r115 == null) goto L54;
        r118.write(r115);     // Catch: Throwable -> L67
    L54:
        r116 = r118.readByteString();     // Catch: Throwable -> L67
        goto L74
    L66:
        throw new AssertionError();     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        cvc.c.e(r103);
        throw th;
    L14:
        this.f506325p = this.f506319j.schedule(new b(this), ((c) r104).f506335c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L70
        goto L15
    L16:
        if (r104 != null) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L70
        return false;
    L20:
        r106 = null;
        goto L21
    L19:
        r104 = null;
        goto L20
    }

    @Override // okhttp3.WebSocket
    public final synchronized long queueSize() {
        monitor-enter(this);
        long r100 = this.f506323n;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f506309v = Collections.singletonList(Protocol.HTTP_1_1);
    }

    @Override // okhttp3.WebSocket
    public final void cancel() {
        this.f506315f.a(-1);
    }

    public final void d() throws IOException {
    L3:
        if (this.f506326q != (-1)) goto L39;
        kvc.d r100 = this.f506317h;
        r100.b();
        if (r100.f506351h == true) goto L6;
        int r101 = r100.f506348e;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L15;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r101));
    L15:
        if (r100.f506347d == true) goto L38;
        long r102 = r100.f506349f;
        if (r102 <= 0) goto L22;
        r100.f506345b.readFully(r100.f506353j, r102);
        if (r100.f506344a == true) goto L22;
        r100.f506353j.readAndWriteUnsafe(r100.f506355l);
        r100.f506355l.b(r100.f506353j.size() - r100.f506349f);
        kvc.c.b(r100.f506355l, r100.f506354k);
        r100.f506355l.close();
    L22:
        if (r100.f506350g == true) goto L23;
    L27:
        if (r100.f506347d == true) goto L33;
        r100.b();
        if (r100.f506351h == false) goto L33;
        r100.a();
    L33:
        if (r100.f506348e == 0) goto L15;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(r100.f506348e));
    L23:
        if (r101 == 1) goto L24;
        kvc.d.a r103 = r100.f506346c;
        a r104 = (a) r103;
        r104.f506311b.onMessage(r104, r100.f506353j.readByteString());
        goto L3
    L24:
        kvc.d.a r105 = r100.f506346c;
        a r106 = (a) r105;
        r106.f506311b.onMessage(r106, r100.f506353j.readUtf8());
        goto L3
    L38:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    L6:
        r100.a();
        goto L3
    }

    @Override // okhttp3.WebSocket
    public final Request request() {
        return this.f506310a;
    }

    public final void a(Response r100) throws ProtocolException {
        if (r100.code() != 101) goto L18;
        String r101 = r100.header("Connection");
        if ("Upgrade".equalsIgnoreCase(r101) == false) goto L16;
        String r102 = r100.header("Upgrade");
        if ("websocket".equalsIgnoreCase(r102) == false) goto L14;
        String r103 = r100.header("Sec-WebSocket-Accept");
        String r104 = ByteString.encodeUtf8(this.f506314e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (r104.equals(r103) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r104 + "' but was '" + r103 + "'");
    L14:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r102 + "'");
    L16:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r101 + "'");
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r100.code() + " " + r100.message() + "'");
    }

    public final synchronized void f(ByteString r100) {
        monitor-enter(this);
        this.f506330u = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public final boolean send(String r100) {
        if (r100 == null) goto L6;
        return g(ByteString.encodeUtf8(r100), 1);
    L6:
        throw new NullPointerException("text == null");
    }

    @Override // okhttp3.WebSocket
    public final boolean send(ByteString r100) {
        if (r100 == null) goto L6;
        return g(r100, 2);
    L6:
        throw new NullPointerException("bytes == null");
    }

    public final void b(Exception r100, @Nullable Response r101) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f506328s == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L7:
        this.f506328s = true;     // Catch: Throwable -> L20
        f r102 = this.f506320k;     // Catch: Throwable -> L20
        this.f506320k = null;     // Catch: Throwable -> L20
        ScheduledFuture<?> r103 = this.f506325p;     // Catch: Throwable -> L20
        if (r103 == null) goto L10;
        r103.cancel(false);     // Catch: Throwable -> L20
    L10:
        PThreadScheduledThreadPoolExecutor r104 = this.f506319j;     // Catch: Throwable -> L20
        if (r104 == null) goto L13;
        r104.shutdown();     // Catch: Throwable -> L20
    L13:
        monitor-exit(this);     // Catch: Throwable -> L20
        this.f506311b.onFailure(this, r100, r101);     // Catch: Throwable -> L17
        cvc.c.e(r102);
        return;
    L17:
        th = move-exception;
        cvc.c.e(r102);
        throw th;
    }

    public final void c(String r110, f r111) throws IOException {
        monitor-enter(this);
        this.f506320k = r111;     // Catch: Throwable -> L11
        this.f506318i = new kvc.e(r111.f506339a, r111.f506341c, this.f506312c);     // Catch: Throwable -> L11
        byte[] r100 = cvc.c.f465513a;     // Catch: Throwable -> L11
        PThreadScheduledThreadPoolExecutor r101 = new PThreadScheduledThreadPoolExecutor(1, new cvc.d(r110, false));     // Catch: Throwable -> L11
        this.f506319j = r101;     // Catch: Throwable -> L11
        long r102 = this.f506313d;     // Catch: Throwable -> L11
        if (r102 == 0) goto L7;
        r101.scheduleAtFixedRate(new e(this), r102, r102, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
    L7:
        if (this.f506322m.isEmpty() == true) goto L13;
        PThreadScheduledThreadPoolExecutor r112 = this.f506319j;     // Catch: Throwable -> L11
        if (r112 == null) goto L13;
        r112.execute(this.f506316g);     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        this.f506317h = new kvc.d(r111.f506339a, r111.f506340b, this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public final boolean close(int r100, String r101) {
        monitor-enter(this);
        String r102 = kvc.c.a(r100);     // Catch: Throwable -> L12
        if (r102 != null) goto L29;
        if (r101 == null) goto L14;
        ByteString r103 = ByteString.encodeUtf8(r101);     // Catch: Throwable -> L12
        if (r103.size() > 123) goto L11;
    L16:
        if (this.f506328s == false) goto L18;
    L25:
        monitor-exit(this);
        return false;
    L18:
        if (this.f506324o == true) goto L25;
        this.f506324o = true;     // Catch: Throwable -> L12
        this.f506322m.add(new c(r100, r103));     // Catch: Throwable -> L12
        PThreadScheduledThreadPoolExecutor r104 = this.f506319j;     // Catch: Throwable -> L12
        if (r104 == null) goto L23;
        r104.execute(this.f506316g);     // Catch: Throwable -> L12
    L23:
        monitor-exit(this);
        return true;
    L11:
        throw new IllegalArgumentException("reason.size() > 123: ".concat(r101));     // Catch: Throwable -> L12
    L14:
        r103 = null;
        goto L16
    L29:
        throw new IllegalArgumentException(r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final void e(int r100, String r101) {
        if (r100 == (-1)) goto L30;
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (this.f506326q != (-1)) goto L25;
        this.f506326q = r100;     // Catch: Throwable -> L26
        this.f506327r = r101;     // Catch: Throwable -> L26
        f r102 = null;
        if (this.f506324o == true) goto L10;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L26
        this.f506311b.onClosing(this, r100, r101);     // Catch: Throwable -> L21
        if (r102 == null) goto L19;
        this.f506311b.onClosed(this, r100, r101);     // Catch: Throwable -> L21
    L19:
        cvc.c.e(r102);
        return;
    L21:
        th = move-exception;
        cvc.c.e(r102);
        throw th;
    L10:
        if (this.f506322m.isEmpty() == false) goto L15;
        f r103 = this.f506320k;     // Catch: Throwable -> L26
        this.f506320k = null;     // Catch: Throwable -> L26
        ScheduledFuture<?> r104 = this.f506325p;     // Catch: Throwable -> L26
        if (r104 == null) goto L14;
        r104.cancel(false);     // Catch: Throwable -> L26
    L14:
        this.f506319j.shutdown();     // Catch: Throwable -> L26
        r102 = r103;
        goto L15
    L25:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L26
    L30:
        throw new IllegalArgumentException();
    }

    public final synchronized boolean g(ByteString r100, int r101) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f506328s == false) goto L6;
    L19:
        monitor-exit(this);
        return false;
    L6:
        if (this.f506324o == true) goto L19;
        if ((this.f506323n + ((long) r100.size())) <= 16777216) goto L13;
        close(1001, null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L13:
        this.f506323n += (long) r100.size();     // Catch: Throwable -> L21
        this.f506322m.add(new d(r101, r100));     // Catch: Throwable -> L21
        PThreadScheduledThreadPoolExecutor r102 = this.f506319j;     // Catch: Throwable -> L21
        if (r102 == null) goto L16;
        r102.execute(this.f506316g);     // Catch: Throwable -> L21
    L16:
        monitor-exit(this);
        return true;
    }

    public a(Request r100, WebSocketListener r101, Random r102, long r103) {
        this.f506321l = new ArrayDeque();
        this.f506322m = new ArrayDeque();
        this.f506326q = -1;
        if ("GET".equals(r100.method()) == false) goto L7;
        this.f506310a = r100;
        this.f506311b = r101;
        this.f506312c = r102;
        this.f506313d = r103;
        byte[] r104 = new byte[16];
        r102.nextBytes(r104);
        this.f506314e = ByteString.of(r104).base64();
        this.f506316g = new RunnableC6617a(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r100.method());
    }
}
