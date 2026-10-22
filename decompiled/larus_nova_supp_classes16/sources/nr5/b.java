package nr5;

import ak5.g;
import android.os.SystemClock;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.lark.sdk.LarkRequest;
import com.bytedance.lark.sdk.api.LarkProxyApi;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lr5.i;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Request;
import okhttp3.Response;
import okio.c;
import okio.j0;
import or5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Call {
    public final i a;
    public final nr5.a b;
    public final se6.i c;
    public final LarkProxyApi d;
    public final a e;
    public okhttp3.i f;
    public final Request g;
    public final boolean h;
    public long i;
    public final or5.b j;
    public boolean k;

    public class a extends c {
        public final /* synthetic */ b m;

        public final void m() {
            this.m.cancel();
        }

        public a(b r1) {
            this.m = r1;
        }
    }

    /* JADX INFO: renamed from: nr5.b$b, reason: collision with other inner class name */
    public final class C0263b extends cvc.b {
        public final Callback b;
        public final /* synthetic */ b c;

        public final void a() {
            this.c.e.j();
            Response r2 = this.c.a();     // Catch: Throwable -> L5
            b r3 = this.c;     // Catch: Throwable -> L5
            r3.f.callEnd(r3);     // Catch: Throwable -> L5
            this.b.onResponse(this.c, r2);     // Catch: Throwable -> L5
            this.c.b(null, r2);     // Catch: Throwable -> L5
        L15:
            this.c.b.e(this);
            return;
        L5:
            th = move-exception;
        L17:
            th = move-exception;
            this.c.b.e(this);
            throw th;
        L7:
            if ((th instanceof IOException) == false) goto L12;
            IOException r4 = th;     // Catch: Throwable -> L17
            if (this.c.e.k() == true) goto L11;
            IOException r5 = r4;
        L13:
            tt5.a.d("eenet_RustCall", "error: " + r5.getMessage());     // Catch: Throwable -> L17
            this.c.b(th, null);     // Catch: Throwable -> L17
            b r0 = this.c;     // Catch: Throwable -> L17
            r0.f.callFailed(r0, r5);     // Catch: Throwable -> L17
            this.b.onFailure(this.c, r5);     // Catch: Throwable -> L17
            goto L15
        L11:
            InterruptedIOException r6 = new InterruptedIOException("timeout");     // Catch: Throwable -> L17
            r6.initCause(r4);     // Catch: Throwable -> L17
            r5 = r6;
            goto L13
        L12:
            r5 = new IOException(th);     // Catch: Throwable -> L17
            goto L13
        }

        public C0263b(b r3, Callback r4) {
            this.c = r3;
            super("eenet_RustCall_RustNet %s", new Object[]{r3.g.url().redact()});
            this.b = r4;
        }
    }

    public final synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r0 = this.k;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final Response a() throws IOException {
        LinkedList r1 = new LinkedList();
        r1.addAll(this.a.interceptors());
        if (qr5.a.b.get() == false) goto L5;
        r1.add(new or5.c(this.a.proxy(), this.a.proxySelector(), this.d));
    L5:
        r1.add(new or5.a(this.a.cookieJar()));
        r1.addAll(this.a.networkInterceptors());
        r1.add(this.j);
        return new d(r1, 0, this.g, this, this.a.connectTimeoutMillis(), this.a.readTimeoutMillis(), this.a.writeTimeoutMillis()).proceed(this.g);
    }

    public final void cancel() {
        or5.b r0 = this.j;
        if (r0.g == false) goto L6;
        return;
    L6:
        if (r0.e == true) goto L14;
        r0.e = true;
        LarkRequest r1 = r0.d;
        if (r1 == null) goto L12;
        long r2 = r1.g;
        r0.a.d(r2);
        return;
    L12:
        return;
    }

    public final Object clone() throws CloneNotSupportedException {
        i r0 = this.a;
        b r3 = new b(r0, this.g, this.h);
        r3.f = r0.c.create(r3);
        return r3;
    }

    public final Response execute() throws IOException {
        Request r2 = this.g;     // Catch: Throwable -> L8 IOException -> L10
        String r3 = r2.url().host();     // Catch: Throwable -> L8 IOException -> L10
        String r4 = r2.url().encodedPath();     // Catch: Throwable -> L8 IOException -> L10
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L14;
        FLogger.a.i("OkHttp3CallLancet", "execute drop " + r3 + r4);     // Catch: Throwable -> L8 IOException -> L10
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L10
        throw new IOException("[NetGuard] dropped " + r2.url());     // Catch: Throwable -> L8 IOException -> L10
    L14:
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L16:
        if (this.k == true) goto L34;
        this.k = true;     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        this.i = SystemClock.elapsedRealtime();
        this.e.j();
        this.f.callStart(this);
        this.b.b(this);     // Catch: IOException -> L23 Throwable -> L30
        Response r5 = a();     // Catch: IOException -> L23 Throwable -> L30
        b(null, r5);     // Catch: IOException -> L23 Throwable -> L30
        this.f.callEnd(this);     // Catch: IOException -> L23 Throwable -> L30
        nr5.a r0 = this.b;
        r0.d(r0.g, this, false);
        return r5;
    L30:
        th = move-exception;
        nr5.a r6 = this.b;
        r6.d(r6.g, this, false);
        throw th;
    L23:
        e = move-exception;
        if (this.e.k() == true) goto L27;
        IOException r7 = e;
    L28:
        b(r7, null);     // Catch: Throwable -> L30
        this.f.callFailed(this, r7);     // Catch: Throwable -> L30
        tt5.a.d("eenet_RustCall", "error: " + r7.getMessage());     // Catch: Throwable -> L30
        throw r7;     // Catch: Throwable -> L30
    L27:
        InterruptedIOException r8 = new InterruptedIOException("timeout");     // Catch: Throwable -> L30
        r8.initCause(e);     // Catch: Throwable -> L30
        r7 = r8;
        goto L28
    L34:
        throw new RustIOException(new IllegalStateException("Already Executed"), RustIOException.REQUEST_EENET_INNER_ERROR);     // Catch: Throwable -> L35
    L10:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("OkHttp3CallLancet", "execute intercept failed, fallback to origin: " + th.getMessage());
        goto L14
    }

    public final boolean isCanceled() {
        return this.j.e;
    }

    public final Request request() {
        return this.g;
    }

    public final j0 timeout() {
        return this.e;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Call m522clone() {
        i r0 = this.a;
        b r3 = new b(r0, this.g, this.h);
        r3.f = r0.c.create(r3);
        return r3;
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
        if (this.k == true) goto L15;
        this.k = true;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.i = SystemClock.elapsedRealtime();
        this.f.callStart(this);
        this.b.a(new C0263b(this, r8));
        return;
    L15:
        throw new IllegalStateException("eenet_RustCall:Already Executed");     // Catch: Throwable -> L16
    }

    public final void b(Throwable r12, Response r13) {
        g r0 = rr5.b.a;
        if (r0 != null) goto L5;
        return;
    L5:
        long r6 = SystemClock.elapsedRealtime() - this.i;
        if ((r12 instanceof RustIOException) == false) goto L11;
        kr5.a r14 = ((RustIOException) r12).getRequestCallInfo();
        if (r14 != null) goto L10;
        r14 = pr5.a.a(this.g);
    L10:
        r0.a(r6, r14, -1, r12);
        tt5.a.h("eenet_RustCall", "rustCall xRequestId: " + r14.h);
        return;
    L11:
        if (r13 == null) goto L14;
        r0.a(r6, pr5.a.b(r13), 0, null);
        return;
    L14:
        if ((r12 instanceof Throwable) == false) goto L19;
        g r5 = r0;
        r5.a(r6, pr5.a.a(this.g), -1, new RustIOException(r12, RustIOException.REQUEST_EENET_UNKNOWN));
        return;
    }

    public b(i r7, Request r8, boolean r9) {
        this.a = r7;
        if (r7.d != null) goto L16;
        Dispatcher r0 = r7.dispatcher();
        nr5.a r1 = new nr5.a(r0.executorService());
        int r2 = r0.getMaxRequests();
        monitor-enter(r1);
        if (r2 < 1) goto L12;
        r1.a = r2;     // Catch: Throwable -> L13
        r1.f();     // Catch: Throwable -> L13
        monitor-exit(r1);
        r1.j(r0.getMaxRequestsPerHost());
        r1.i((Runnable) Reflect.on(r0).get("idleCallback", new Class[]{Runnable.class}));
        r7.d = r1;
        goto L16
    L12:
        throw new IllegalArgumentException("max < 1: " + r2);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        this.b = r7.d;
        Map r3 = com.bytedance.lark.sdk.d.e;
        com.bytedance.lark.sdk.d r4 = com.bytedance.lark.sdk.d.f.a;
        se6.i r5 = (se6.i) ((HashMap) r4.c).get(se6.i.class);
        this.c = r5;
        this.d = (LarkProxyApi) ((HashMap) r4.c).get(LarkProxyApi.class);
        this.g = r8;
        this.h = r9;
        a r10 = new a(this);
        this.e = r10;
        r10.h(r7.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.j = new or5.b(r7, r5);
        this.f = r7.c.create(this);
    }
}
