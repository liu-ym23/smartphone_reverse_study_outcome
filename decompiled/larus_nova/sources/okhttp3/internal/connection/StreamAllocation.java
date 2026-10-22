package okhttp3.internal.connection;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.l;
import okhttp3.ttnet.TTConfigManager;

/* JADX INFO: loaded from: classes5.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final okhttp3.a address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private int canceledReason;
    private evc.c codec;
    private d connection;
    private final ConnectionPool connectionPool;
    public final i eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private f.a routeSelection;
    private final f routeSelector;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a extends WeakReference<StreamAllocation> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f523875a;

        public a(StreamAllocation r100, Object r101) {
            super(r100);
            this.f523875a = r101;
        }
    }

    public synchronized d connection() {
        monitor-enter(this);
        d r100 = this.connection;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private Socket releaseIfNoNewStreams() {
        d r100 = this.connection;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.f523891k == true) goto L7;
        return null;
    L7:
        return deallocate(false, false, true);
    }

    private e routeDatabase() {
        return cvc.a.f465511a.b(this.connectionPool);
    }

    public evc.c codec() {
        ConnectionPool r100 = this.connectionPool;
        monitor-enter(r100);
        evc.c r101 = this.codec;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasMoreRoutes() {
        if (this.route != null) goto L12;
        f.a r100 = this.routeSelection;
        if (r100 == null) goto L9;
        if (r100.a() == true) goto L12;
    L9:
        if (this.routeSelector.b() == true) goto L12;
        return false;
    L12:
        return true;
    }

    public void noNewStreams() {
        ConnectionPool r100 = this.connectionPool;
        monitor-enter(r100);
        d r101 = this.connection;     // Catch: Throwable -> L12
        Socket r102 = deallocate(true, false, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r101 = null;
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L12
        cvc.c.f(r102);
        if (r101 == null) goto L17;
        this.eventListener.connectionReleased(this.call, r101);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void release() {
        ConnectionPool r100 = this.connectionPool;
        monitor-enter(r100);
        d r101 = this.connection;     // Catch: Throwable -> L12
        Socket r102 = deallocate(false, true, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r101 = null;
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L12
        cvc.c.f(r102);
        if (r101 == null) goto L17;
        OkHttpClient.a r103 = cvc.a.f465511a;
        Call r104 = this.call;
        r103.getClass();
        ((l) r104).d(null);
        this.eventListener.connectionReleased(this.call, r101);
        this.eventListener.callEnd(this.call);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public String toString() {
        d r100 = connection();
        if (r100 == null) goto L6;
        return r100.toString();
    L6:
        return this.address.toString();
    }

    static {
    }

    public Route route() {
        return this.route;
    }

    private void release(d r100) {
        int r101 = ((ArrayList) r100.f523894n).size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        if (((Reference) ListProtector.get(r100.f523894n, r102)).get() == this) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        ListProtector.remove(r100.f523894n, r102);
        return;
    L10:
        throw new IllegalStateException();
    }

    public void cancel(int r100) {
        ConnectionPool r101 = this.connectionPool;
        monitor-enter(r101);
        this.canceled = true;     // Catch: Throwable -> L12
        this.canceledReason = r100;     // Catch: Throwable -> L12
        evc.c r102 = this.codec;     // Catch: Throwable -> L12
        d r103 = this.connection;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.cancel();
        return;
    L9:
        if (r103 == null) goto L18;
        cvc.c.f(r103.f523884d);
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public Socket releaseAndAcquire(d r100) {
        if (this.codec != null) goto L9;
        if (((ArrayList) this.connection.f523894n).size() != 1) goto L9;
        Reference r101 = (Reference) ListProtector.get(this.connection.f523894n, 0);
        Socket r102 = deallocate(true, false, false);
        this.connection = r100;
        ((ArrayList) r100.f523894n).add(r101);
        return r102;
    L9:
        throw new IllegalStateException();
    }

    public void resetRouteSelector(int r100) {
        f r101 = this.routeSelector;
        okhttp3.a r102 = r101.f523897a;
        r101.d(r102.f523801a, r102.f523808h);
        r101.f523905i.clear();
        ((ArrayList) r101.f523906j).clear();
        r101.f523901e = r100;
        r101.f523902f = null;
        this.routeSelection = null;
    }

    public void streamFailed(IOException r100) {
        ConnectionPool r101 = this.connectionPool;
        monitor-enter(r101);
        d r102 = null;
        if ((r100 instanceof StreamResetException) == false) goto L14;
        ErrorCode r103 = ((StreamResetException) r100).errorCode;     // Catch: Throwable -> L31
        if (r103 != ErrorCode.REFUSED_STREAM) goto L12;
        int r104 = this.refusedStreamCount + 1;     // Catch: Throwable -> L31
        this.refusedStreamCount = r104;     // Catch: Throwable -> L31
        if (r104 <= 1) goto L33;
        this.route = null;     // Catch: Throwable -> L31
    L30:
        boolean r105 = true;
    L34:
        d r106 = this.connection;     // Catch: Throwable -> L31
        Socket r107 = deallocate(r105, false, true);     // Catch: Throwable -> L31
        if (this.connection == null) goto L37;
    L40:
        monitor-exit(r101);     // Catch: Throwable -> L31
        cvc.c.f(r107);
        if (r102 == null) goto L49;
        this.eventListener.connectionReleased(this.call, r102);
        return;
    L49:
        return;
    L37:
        if (this.reportedAcquired == false) goto L40;
        r102 = r106;
    L33:
        r105 = false;
        goto L34
    L12:
        if (r103 == ErrorCode.CANCEL) goto L33;
        this.route = null;     // Catch: Throwable -> L31
        goto L30
    L14:
        d r108 = this.connection;     // Catch: Throwable -> L31
        if (r108 == null) goto L33;
        if (r108.f523888h == null) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L24;
        if ((r100 instanceof ConnectionShutdownException) == false) goto L33;
    L24:
        if (r108.f523892l != 0) goto L30;
        Route r110 = this.route;     // Catch: Throwable -> L31
        if (r110 == null) goto L29;
        if (r100 == null) goto L29;
        this.routeSelector.a(r110, r100);     // Catch: Throwable -> L31
    L29:
        this.route = null;     // Catch: Throwable -> L31
        goto L30
    L19:
        r109 = false;
    L31:
        th = move-exception;
        throw th;
    }

    public void acquire(d r100, boolean r101) {
        if (this.connection != null) goto L7;
        this.connection = r100;
        this.reportedAcquired = r101;
        List<Reference<StreamAllocation>> r102 = r100.f523894n;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new a(this, this.callStackTrace));
        return;
    L7:
        throw new IllegalStateException();
    }

    private Socket deallocate(boolean r100, boolean r101, boolean r102) {
        if (r102 == false) goto L6;
        this.codec = null;
    L6:
        if (r101 == false) goto L8;
        this.released = true;
    L8:
        d r103 = this.connection;
        if (r103 == null) goto L26;
        if (r100 == false) goto L13;
        r103.f523891k = true;
    L13:
        if (this.codec == null) goto L15;
        return null;
    L15:
        if (this.released == false) goto L17;
    L18:
        release(r103);
        if (((ArrayList) this.connection.f523894n).isEmpty() == false) goto L23;
        this.connection.f523895o = System.nanoTime();
        OkHttpClient.a r104 = cvc.a.f465511a;
        ConnectionPool r105 = this.connectionPool;
        d r106 = this.connection;
        r104.getClass();
        if (r105.connectionBecameIdle(r106) == false) goto L23;
        Socket r107 = this.connection.f523885e;
    L24:
        this.connection = null;
        return r107;
    L23:
        r107 = null;
        goto L24
    L17:
        if (r103.f523891k == true) goto L18;
        return null;
    L26:
        return null;
    }

    public evc.c newStream(OkHttpClient r100, Interceptor.Chain r101, boolean r110) {
        int r102 = r101.connectTimeoutMillis();
        int r103 = r101.readTimeoutMillis();
        int r104 = r101.writeTimeoutMillis();
        int r105 = r100.pingIntervalMillis();
        Call r106 = this.call;
        if (r106 == null) goto L23;
        if (r106.request() == null) goto L23;
        if (this.call.request().url() == null) goto L23;
        if (this.call.request().url().host() == null) goto L23;
        r105 = r100.pingIntervalMillisWithHostPort(this.call.request().url().host(), this.call.request().url().port());
    L23:
        evc.c r107 = findHealthyConnection(r102, r103, r104, r105, r100.retryOnConnectionFailure(), r110).i(r100, r101, this);     // Catch: IOException -> L20
        ConnectionPool r108 = this.connectionPool;     // Catch: IOException -> L20
        monitor-enter(r108);     // Catch: IOException -> L20
        this.codec = r107;     // Catch: Throwable -> L17
        monitor-exit(r108);     // Catch: Throwable -> L17
        return r107;
    L17:
        th = move-exception;
        throw th;     // Catch: IOException -> L20
    L20:
        e = move-exception;
        throw new RouteException(e);
    }

    public void streamFinished(boolean r100, evc.c r101, long r102, IOException r103) {
        this.eventListener.responseBodyEnd(this.call, r102);
        ConnectionPool r104 = this.connectionPool;
        monitor-enter(r104);
        if (r101 == null) goto L24;
    L25:
        th = move-exception;
        throw th;
    L6:
        if (r101 != this.codec) goto L24;
        if (r100 == true) goto L10;
        this.connection.f523892l++;     // Catch: Throwable -> L25
    L10:
        d r105 = this.connection;     // Catch: Throwable -> L25
        Socket r106 = deallocate(r100, false, true);     // Catch: Throwable -> L25
        if (this.connection == null) goto L13;
        r105 = null;
    L13:
        boolean r107 = this.released;     // Catch: Throwable -> L25
        monitor-exit(r104);     // Catch: Throwable -> L25
        cvc.c.f(r106);
        if (r105 == null) goto L18;
        this.eventListener.connectionReleased(this.call, r105);
    L18:
        if (r103 == null) goto L20;
        OkHttpClient.a r108 = cvc.a.f465511a;
        Call r109 = this.call;
        r108.getClass();
        this.eventListener.callFailed(this.call, ((l) r109).d(r103));
        return;
    L20:
        if (r107 == false) goto L30;
        OkHttpClient.a r110 = cvc.a.f465511a;
        Call r111 = this.call;
        r110.getClass();
        ((l) r111).d(null);
        this.eventListener.callEnd(this.call);
        return;
    L30:
        return;
    L24:
        throw new IllegalStateException("expected " + this.codec + " but was " + r101);     // Catch: Throwable -> L25
    }

    public StreamAllocation(ConnectionPool r100, okhttp3.a r101, Call r102, i r103, Object r104) {
        this.canceledReason = -1;
        this.connectionPool = r100;
        this.address = r101;
        this.call = r102;
        this.eventListener = r103;
        this.routeSelector = new f(r101, routeDatabase(), r102, r103);
        this.callStackTrace = r104;
    }

    private d findConnection(int r210, int r211, int r212, int r213, boolean r214) throws IOException {
        ConnectionPool r100 = this.connectionPool;
        monitor-enter(r100);
    L108:
        th = move-exception;
        throw th;
    L5:
        if (this.released == true) goto L107;
        if (this.codec != null) goto L105;
        if (this.canceled == true) goto L103;
        d r101 = this.connection;     // Catch: Throwable -> L108
        Socket r102 = releaseIfNoNewStreams();     // Catch: Throwable -> L108
        d r103 = this.connection;     // Catch: Throwable -> L108
        Socket r104 = null;
        if (r103 == null) goto L13;
        r101 = null;
    L15:
        if (this.reportedAcquired == true) goto L17;
        r101 = null;
    L17:
        boolean r105 = false;
        if (r103 != null) goto L23;
        OkHttpClient.a r106 = cvc.a.f465511a;     // Catch: Throwable -> L108
        ConnectionPool r110 = this.connectionPool;     // Catch: Throwable -> L108
        okhttp3.a r111 = this.address;     // Catch: Throwable -> L108
        r106.getClass();     // Catch: Throwable -> L108
        r110.get(r111, this, null);     // Catch: Throwable -> L108
        d r107 = this.connection;     // Catch: Throwable -> L108
        if (r107 == null) goto L22;
        r103 = r107;
        boolean r112 = true;
        Route r108 = null;
    L25:
        monitor-exit(r100);     // Catch: Throwable -> L108
        cvc.c.f(r102);
        if (r101 == null) goto L29;
        this.eventListener.connectionReleased(this.call, r101);
    L29:
        if (r112 == false) goto L31;
        this.eventListener.connectionAcquired(this.call, r103);
    L31:
        if (r103 == null) goto L34;
        this.route = this.connection.f523883c;
        return r103;
    L34:
        if (r108 != null) goto L45;
        f.a r109 = this.routeSelection;
        if (r109 != null) goto L38;
    L39:
        this.routeSelection = this.routeSelector.c();
        if (TTConfigManager.inst().getReconnctTimeout() > 0) goto L42;
    L43:
        this.routeSelection.f523909c = false;
    L44:
        boolean r113 = true;
    L46:
        ConnectionPool r114 = this.connectionPool;
        monitor-enter(r114);
    L99:
        th = move-exception;
        throw th;
    L49:
        if (this.canceled == true) goto L98;
        if (r113 == false) goto L57;
        f.a r115 = this.routeSelection;     // Catch: Throwable -> L99
        r115.getClass();     // Catch: Throwable -> L99
        ArrayList r116 = new ArrayList(r115.f523907a);     // Catch: Throwable -> L99
        int r117 = r116.size();     // Catch: Throwable -> L99
        int r118 = 0;
    L52:
        if (r118 >= r117) goto L57;
        Route r119 = (Route) r116.get(r118);     // Catch: Throwable -> L99
        OkHttpClient.a r120 = cvc.a.f465511a;     // Catch: Throwable -> L99
        ConnectionPool r121 = this.connectionPool;     // Catch: Throwable -> L99
        okhttp3.a r122 = this.address;     // Catch: Throwable -> L99
        r120.getClass();     // Catch: Throwable -> L99
        r121.get(r122, this, r119);     // Catch: Throwable -> L99
        d r123 = this.connection;     // Catch: Throwable -> L99
        if (r123 != null) goto L55;
        r118 = r118 + 1;     // Catch: Throwable -> L99
        goto L52
    L55:
        this.route = r119;     // Catch: Throwable -> L99
        r103 = r123;
        r112 = true;
    L57:
        if (r112 == true) goto L65;
        if (r108 != null) goto L64;
        f.a r124 = this.routeSelection;     // Catch: Throwable -> L99
        if (r124.a() == false) goto L63;
        List<Route> r125 = r124.f523907a;     // Catch: Throwable -> L99
        int r126 = r124.f523908b;     // Catch: Throwable -> L99
        r124.f523908b = r126 + 1;     // Catch: Throwable -> L99
        r108 = (Route) ListProtector.get(r125, r126);     // Catch: Throwable -> L99
        goto L64
    L63:
        throw new NoSuchElementException();     // Catch: Throwable -> L99
    L64:
        this.route = r108;     // Catch: Throwable -> L99
        this.refusedStreamCount = 0;     // Catch: Throwable -> L99
        r103 = new d(this.connectionPool, r108);     // Catch: Throwable -> L99
        acquire(r103, false);     // Catch: Throwable -> L99
    L65:
        monitor-exit(r114);     // Catch: Throwable -> L99
        if (r112 == false) goto L69;
        this.eventListener.connectionAcquired(this.call, r103);
        return r103;
    L69:
        f.a r127 = this.routeSelection;
        if (r127 != null) goto L72;
    L74:
        int r128 = r210;
    L76:
        if (this.routeSelection == null) goto L78;
    L84:
        r103.c(r128, r211, r212, r213, r214, this.call, this.eventListener);
        routeDatabase().a(r103.f523883c);
        ConnectionPool r129 = this.connectionPool;
        monitor-enter(r129);
        this.reportedAcquired = true;     // Catch: Throwable -> L94
        OkHttpClient.a r130 = cvc.a.f465511a;     // Catch: Throwable -> L94
        ConnectionPool r131 = this.connectionPool;     // Catch: Throwable -> L94
        r130.getClass();     // Catch: Throwable -> L94
        r131.put(r103);     // Catch: Throwable -> L94
        if (r103.f523888h == null) goto L89;
        r105 = true;
    L89:
        if (r105 == false) goto L91;
        OkHttpClient.a r132 = cvc.a.f465511a;     // Catch: Throwable -> L94
        ConnectionPool r133 = this.connectionPool;     // Catch: Throwable -> L94
        okhttp3.a r134 = this.address;     // Catch: Throwable -> L94
        r132.getClass();     // Catch: Throwable -> L94
        r104 = r133.deduplicate(r134, this);     // Catch: Throwable -> L94
        r103 = this.connection;     // Catch: Throwable -> L94
    L91:
        monitor-exit(r129);     // Catch: Throwable -> L94
        cvc.c.f(r104);
        this.eventListener.connectionAcquired(this.call, r103);
        return r103;
    L94:
        th = move-exception;
        throw th;
    L78:
        if (this.route == null) goto L84;
        if (TTConfigManager.inst().isIpReconnQuickTestEnable() == false) goto L84;
        if (TTConfigManager.inst().getReconnctTimeout() <= 0) goto L84;
        r128 = TTConfigManager.inst().getReconnctTimeout();
        goto L84
    L72:
        if (r127.f523909c == false) goto L74;
        r128 = TTConfigManager.inst().getReconnctTimeout();
        goto L76
    L98:
        throw new IOException("Canceled#Reason=" + this.canceledReason);     // Catch: Throwable -> L99
    L42:
        if (TTConfigManager.inst().isIpReconnQuickTestEnable() == true) goto L44;
    L38:
        if (r109.a() == false) goto L39;
    L45:
        r113 = false;
        goto L46
    L22:
        r108 = this.route;     // Catch: Throwable -> L108
    L24:
        r112 = false;
        goto L25
    L23:
        r108 = null;
        goto L24
    L13:
        r103 = null;
        goto L15
    L103:
        throw new IOException("Canceled#Reason=" + this.canceledReason);     // Catch: Throwable -> L108
    L105:
        throw new IllegalStateException("codec != null");     // Catch: Throwable -> L108
    L107:
        throw new IllegalStateException("released");     // Catch: Throwable -> L108
    }

    private d findHealthyConnection(int r100, int r101, int r102, int r103, boolean r104, boolean r105) throws IOException {
    L2:
        d r106 = findConnection(r100, r101, r102, r103, r104);
        ConnectionPool r107 = this.connectionPool;
        monitor-enter(r107);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r106.f523892l == 0) goto L7;
    L15:
        monitor-exit(r107);     // Catch: Throwable -> L13
        if (r106.h(r105) == true) goto L19;
        noNewStreams();
        goto L2
    L19:
        return r106;
    L7:
        if (r106.f523888h == null) goto L9;
        boolean r108 = true;
    L10:
        if (r108 == true) goto L15;
        monitor-exit(r107);     // Catch: Throwable -> L13
        return r106;
    L9:
        r108 = false;
        goto L10
    }
}
