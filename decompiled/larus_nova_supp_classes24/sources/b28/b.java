package b28;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import hvc.g;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.i;
import okhttp3.internal.http.RealInterceptorChain;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements Call {
    public final OkHttpClient a;
    public final a b;
    public i c;
    public final boolean d;
    public final Request e;
    public boolean f;
    public final x18.d g;
    public final b28.a h;
    public final d i;

    public class a extends okio.c {
        public final /* synthetic */ b m;

        public final void m() {
            this.m.cancel();
        }

        public a(b r1) {
            this.m = r1;
        }
    }

    /* JADX INFO: renamed from: b28.b$b, reason: collision with other inner class name */
    public final class C0005b extends cvc.b {
        public final Callback b;
        public final /* synthetic */ b c;

        public final void a() {
            this.c.b.j();
            Response r1 = this.c.b();     // Catch: IOException -> L10 Throwable -> L22
            b r2 = this.c;     // Catch: IOException -> L10 Throwable -> L22
            if (r2.i.c == false) goto L6;
            this.b.onFailure(r2, new IOException("Canceled"));     // Catch: IOException -> L8 Throwable -> L22
        L27:
        L20:
            this.c.h.d(this);
            return;
        L6:
            this.b.onResponse(r2, r1);     // Catch: IOException -> L8 Throwable -> L22
        L8:
            e = move-exception;
            boolean r3 = true;
            IOException r4 = e;
        L13:
            if (this.c.b.k() == true) goto L15;
            IOException r5 = r4;
        L16:
            if (r3 == false) goto L18;
            g.a.m(4, "Callback failure for " + b.a(this.c), r5);     // Catch: Throwable -> L22
            goto L20
        L18:
            b r0 = this.c;     // Catch: Throwable -> L22
            r0.c.callFailed(r0, r5);     // Catch: Throwable -> L22
            this.b.onFailure(this.c, r5);     // Catch: Throwable -> L22
            goto L20
        L15:
            InterruptedIOException r6 = new InterruptedIOException("timeout");     // Catch: Throwable -> L22
            r6.initCause(r4);     // Catch: Throwable -> L22
            r5 = r6;
        L22:
            th = move-exception;
            this.c.h.d(this);
            throw th;
        L10:
            e = move-exception;
            r3 = false;
            r4 = e;
            goto L13
        }

        static {
        }

        public C0005b(b r3, Callback r4) {
            this.c = r3;
            super("OkRustCallLark HttpClient %s", new Object[]{r3.e.url().redact()});
            this.b = r4;
        }
    }

    public final Response b() throws IOException {
        ArrayList r1 = new ArrayList();
        r1.addAll(this.a.interceptors());
        r1.add(new evc.a(this.a.cookieJar()));
        if (this.d == true) goto L5;
        r1.addAll(this.a.networkInterceptors());
    L5:
        r1.add(this.i);
        return new RealInterceptorChain(r1, null, null, null, 0, this.e, this, this.c, this.a.connectTimeoutMillis(), this.a.readTimeoutMillis(), this.a.writeTimeoutMillis()).proceed(this.e);
    }

    public final void cancel() {
        this.i.c = true;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Call m0clone() {
        return c(this.g, this.e, this.d);
    }

    public final Response execute() throws IOException {
        Request r2 = this.e;     // Catch: Throwable -> L8 IOException -> L10
        String r3 = r2.url().host();     // Catch: Throwable -> L8 IOException -> L10
        String r4 = r2.url().encodedPath();     // Catch: Throwable -> L8 IOException -> L10
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L13;
        FLogger.a.i("OkHttp3CallLancet", "execute drop " + r3 + r4);     // Catch: Throwable -> L8 IOException -> L10
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L10
        throw new IOException("[NetGuard] dropped " + r2.url());     // Catch: Throwable -> L8 IOException -> L10
    L13:
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L15:
        if (this.f == true) goto L36;
        this.f = true;     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        this.b.j();
        this.c.callStart(this);
        this.h.b(this);     // Catch: IOException -> L25 Throwable -> L32
        Response r0 = b();     // Catch: IOException -> L25 Throwable -> L32
        if (r0 == null) goto L24;
        b28.a r1 = this.h;
        r1.e(r1.g, this);
        return r0;
    L24:
        throw new IOException("Canceled");     // Catch: IOException -> L25 Throwable -> L32
    L32:
        th = move-exception;
        b28.a r5 = this.h;
        r5.e(r5.g, this);
        throw th;
    L25:
        e = move-exception;
        if (this.b.k() == true) goto L29;
        IOException r6 = e;
    L30:
        this.c.callFailed(this, r6);     // Catch: Throwable -> L32
        throw r6;     // Catch: Throwable -> L32
    L29:
        InterruptedIOException r7 = new InterruptedIOException("timeout");     // Catch: Throwable -> L32
        r7.initCause(e);     // Catch: Throwable -> L32
        r6 = r7;
        goto L30
    L36:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L37
    L10:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("OkHttp3CallLancet", "execute intercept failed, fallback to origin: " + th.getMessage());
        goto L13
    }

    public final boolean isCanceled() {
        return this.i.c;
    }

    public final boolean isExecuted() {
        return this.f;
    }

    public final Request request() {
        return this.e;
    }

    public final j0 timeout() {
        return this.b;
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m0clone();
    }

    public static String a(b r2) {
        r2.getClass();
        StringBuilder r0 = new StringBuilder();
        if (r2.i.c == false) goto L5;
        String r1 = "canceled ";
    L6:
        r0.append(r1);
        if (r2.d == false) goto L9;
        String r3 = "web socket";
    L10:
        r0.append(r3);
        r0.append(" to ");
        r0.append(r2.e.url().redact());
        return r0.toString();
    L9:
        r3 = "call";
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    public final void enqueue(Callback r8) {
        Request r0 = request();
        String r1 = r0.url().host();
        String r2 = r0.url().encodedPath();
        if (com.obric.assistant.network.okhttp.a.c(r1, r2) == false) goto L7;
        FLogger.a.i("OkHttp3CallLancet", "enqueue drop " + r1 + r2);
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r1, r2), r1, r2);
        if (r8 == null) goto L20;
        r8.onFailure(this, new IOException("[NetGuard] dropped " + r0.url()));
        return;
    L20:
        return;
    L7:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f == true) goto L15;
        this.f = true;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.c.callStart(this);
        this.h.a(new C0005b(this, r8));
        return;
    L15:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L16
    }

    public b(x18.d r3, Request r4, boolean r5) {
        this.g = r3;
        this.a = r3.c;
        this.e = r4;
        this.d = r5;
        this.i = new d(r5);
        this.h = r3.d();
        a r6 = new a(this);
        this.b = r6;
        r6.h(r3.c.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    public static b c(x18.d r1, Request r2, boolean r3) {
        b r0 = new b(r1, r2, r3);
        r0.c = r1.c.eventListenerFactory().create(r0);
        return r0;
    }
}
