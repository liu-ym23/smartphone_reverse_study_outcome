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

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f520186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nr5.a f520187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final se6.i f520188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarkProxyApi f520189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f520190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public okhttp3.i f520191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Request f520192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f520193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f520194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final or5.b f520195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f520196k;

    public class a extends c {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b f520197m;

        @Override // okio.c
        public final void m() {
            this.f520197m.cancel();
        }

        public a(b r100) {
            this.f520197m = r100;
        }
    }

    /* JADX INFO: renamed from: nr5.b$b, reason: collision with other inner class name */
    public final class C6965b extends cvc.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Callback f520198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f520199c;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // cvc.b
        public final void a() {
            this.f520199c.f520190e.j();
            Response r100 = this.f520199c.a();     // Catch: Throwable -> L5
            b r101 = this.f520199c;     // Catch: Throwable -> L5
            r101.f520191f.callEnd(r101);     // Catch: Throwable -> L5
            this.f520198b.onResponse(this.f520199c, r100);     // Catch: Throwable -> L5
            this.f520199c.b(null, r100);     // Catch: Throwable -> L5
        L15:
            this.f520199c.f520187b.e(this);
            return;
        L5:
            th = move-exception;
        L17:
            th = move-exception;
            this.f520199c.f520187b.e(this);
            throw th;
        L7:
            if ((th instanceof IOException) == false) goto L12;
            IOException r102 = th;     // Catch: Throwable -> L17
            if (this.f520199c.f520190e.k() == true) goto L11;
            IOException r103 = r102;
        L13:
            tt5.a.d("eenet_RustCall", "error: " + r103.getMessage());     // Catch: Throwable -> L17
            this.f520199c.b(th, null);     // Catch: Throwable -> L17
            b r104 = this.f520199c;     // Catch: Throwable -> L17
            r104.f520191f.callFailed(r104, r103);     // Catch: Throwable -> L17
            this.f520198b.onFailure(this.f520199c, r103);     // Catch: Throwable -> L17
            goto L15
        L11:
            InterruptedIOException r105 = new InterruptedIOException("timeout");     // Catch: Throwable -> L17
            r105.initCause(r102);     // Catch: Throwable -> L17
            r103 = r105;
            goto L13
        L12:
            r103 = new IOException(th);     // Catch: Throwable -> L17
            goto L13
        }

        public C6965b(b r100, Callback r101) {
            this.f520199c = r100;
            super("eenet_RustCall_RustNet %s", new Object[]{r100.f520192g.url().redact()});
            this.f520198b = r101;
        }
    }

    @Override // okhttp3.Call
    public final synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r100 = this.f520196k;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final Response a() throws IOException {
        LinkedList r100 = new LinkedList();
        r100.addAll(this.f520186a.interceptors());
        if (qr5.a.f534619b.get() == false) goto L5;
        r100.add(new or5.c(this.f520186a.proxy(), this.f520186a.proxySelector(), this.f520189d));
    L5:
        r100.add(new or5.a(this.f520186a.cookieJar()));
        r100.addAll(this.f520186a.networkInterceptors());
        r100.add(this.f520195j);
        return new d(r100, 0, this.f520192g, this, this.f520186a.connectTimeoutMillis(), this.f520186a.readTimeoutMillis(), this.f520186a.writeTimeoutMillis()).proceed(this.f520192g);
    }

    @Override // okhttp3.Call
    public final void cancel() {
        or5.b r100 = this.f520195j;
        if (r100.f524940g == false) goto L6;
        return;
    L6:
        if (r100.f524938e == true) goto L14;
        r100.f524938e = true;
        LarkRequest r101 = r100.f524937d;
        if (r101 == null) goto L12;
        long r102 = r101.f254058g;
        r100.f524934a.d(r102);
        return;
    L12:
        return;
    }

    public final Object clone() throws CloneNotSupportedException {
        i r100 = this.f520186a;
        b r101 = new b(r100, this.f520192g, this.f520193h);
        r101.f520191f = r100.f510431c.create(r101);
        return r101;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // okhttp3.Call
    public final Response execute() throws IOException {
        Request r100 = this.f520192g;     // Catch: Throwable -> L8 IOException -> L10
        String r101 = r100.url().host();     // Catch: Throwable -> L8 IOException -> L10
        String r102 = r100.url().encodedPath();     // Catch: Throwable -> L8 IOException -> L10
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L14;
        FLogger.f375446a.i("OkHttp3CallLancet", "execute drop " + r101 + r102);     // Catch: Throwable -> L8 IOException -> L10
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L10
        throw new IOException("[NetGuard] dropped " + r100.url());     // Catch: Throwable -> L8 IOException -> L10
    L14:
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L16:
        if (this.f520196k == true) goto L34;
        this.f520196k = true;     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        this.f520194i = SystemClock.elapsedRealtime();
        this.f520190e.j();
        this.f520191f.callStart(this);
        this.f520187b.b(this);     // Catch: IOException -> L23 Throwable -> L30
        Response r103 = a();     // Catch: IOException -> L23 Throwable -> L30
        b(null, r103);     // Catch: IOException -> L23 Throwable -> L30
        this.f520191f.callEnd(this);     // Catch: IOException -> L23 Throwable -> L30
        nr5.a r104 = this.f520187b;
        r104.d(r104.f520185g, this, false);
        return r103;
    L30:
        th = move-exception;
        nr5.a r105 = this.f520187b;
        r105.d(r105.f520185g, this, false);
        throw th;
    L23:
        e = move-exception;
        if (this.f520190e.k() == true) goto L27;
        IOException r106 = e;
    L28:
        b(r106, null);     // Catch: Throwable -> L30
        this.f520191f.callFailed(this, r106);     // Catch: Throwable -> L30
        tt5.a.d("eenet_RustCall", "error: " + r106.getMessage());     // Catch: Throwable -> L30
        throw r106;     // Catch: Throwable -> L30
    L27:
        InterruptedIOException r107 = new InterruptedIOException("timeout");     // Catch: Throwable -> L30
        r107.initCause(e);     // Catch: Throwable -> L30
        r106 = r107;
        goto L28
    L34:
        throw new RustIOException(new IllegalStateException("Already Executed"), RustIOException.REQUEST_EENET_INNER_ERROR);     // Catch: Throwable -> L35
    L10:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("OkHttp3CallLancet", "execute intercept failed, fallback to origin: " + th.getMessage());
        goto L14
    }

    @Override // okhttp3.Call
    public final boolean isCanceled() {
        return this.f520195j.f524938e;
    }

    @Override // okhttp3.Call
    public final Request request() {
        return this.f520192g;
    }

    @Override // okhttp3.Call
    public final j0 timeout() {
        return this.f520190e;
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: clone */
    public final Call mo7964clone() {
        i r100 = this.f520186a;
        b r101 = new b(r100, this.f520192g, this.f520193h);
        r101.f520191f = r100.f510431c.create(r101);
        return r101;
    }

    @Override // okhttp3.Call
    public final void enqueue(Callback r100) {
        Request r101 = request();
        String r102 = r101.url().host();
        String r103 = r101.url().encodedPath();
        if (com.obric.assistant.network.okhttp.a.c(r102, r103) == false) goto L7;
        FLogger.f375446a.i("OkHttp3CallLancet", "enqueue drop " + r102 + r103);
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r102, r103), r102, r103);
        if (r100 == null) goto L20;
        r100.onFailure(this, new IOException("[NetGuard] dropped " + r101.url()));
        return;
    L20:
        return;
    L7:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f520196k == true) goto L15;
        this.f520196k = true;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.f520194i = SystemClock.elapsedRealtime();
        this.f520191f.callStart(this);
        this.f520187b.a(new C6965b(this, r100));
        return;
    L15:
        throw new IllegalStateException("eenet_RustCall:Already Executed");     // Catch: Throwable -> L16
    }

    public final void b(Throwable r110, Response r111) {
        rr5.a r100 = rr5.b.f539032a;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = SystemClock.elapsedRealtime() - this.f520194i;
        if ((r110 instanceof RustIOException) == false) goto L11;
        kr5.a r112 = ((RustIOException) r110).getRequestCallInfo();
        if (r112 != null) goto L10;
        r112 = pr5.a.a(this.f520192g);
    L10:
        ((g) r100).a(r101, r112, -1, r110);
        tt5.a.h("eenet_RustCall", "rustCall xRequestId: " + r112.f505716h);
        return;
    L11:
        if (r111 == null) goto L14;
        ((g) r100).a(r101, pr5.a.b(r111), 0, null);
        return;
    L14:
        if ((r110 instanceof Throwable) == false) goto L19;
        g r102 = (g) r100;
        r102.a(r101, pr5.a.a(this.f520192g), -1, new RustIOException(r110, RustIOException.REQUEST_EENET_UNKNOWN));
        return;
    }

    public b(i r100, Request r101, boolean r102) {
        this.f520186a = r100;
        if (r100.f510433d != null) goto L16;
        Dispatcher r103 = r100.dispatcher();
        nr5.a r104 = new nr5.a(r103.executorService());
        int r105 = r103.getMaxRequests();
        monitor-enter(r104);
        if (r105 < 1) goto L12;
        r104.f520179a = r105;     // Catch: Throwable -> L13
        r104.f();     // Catch: Throwable -> L13
        monitor-exit(r104);
        r104.j(r103.getMaxRequestsPerHost());
        r104.i((Runnable) Reflect.on(r103).get("idleCallback", new Class[]{Runnable.class}));
        r100.f510433d = r104;
        goto L16
    L12:
        throw new IllegalArgumentException("max < 1: " + r105);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        this.f520187b = r100.f510433d;
        Map<Long, se6.b> r106 = com.bytedance.lark.sdk.d.f254138e;
        com.bytedance.lark.sdk.d r107 = com.bytedance.lark.sdk.d.f.f254166a;
        se6.i r108 = (se6.i) ((HashMap) r107.f254155c).get(se6.i.class);
        this.f520188c = r108;
        this.f520189d = (LarkProxyApi) ((HashMap) r107.f254155c).get(LarkProxyApi.class);
        this.f520192g = r101;
        this.f520193h = r102;
        a r109 = new a(this);
        this.f520190e = r109;
        r109.h(r100.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f520195j = new or5.b(r100, r108);
        this.f520191f = r100.f510431c.create(this);
    }
}
