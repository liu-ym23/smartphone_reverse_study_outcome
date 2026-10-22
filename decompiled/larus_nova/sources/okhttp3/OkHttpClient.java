package okhttp3;

import android.text.TextUtils;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: classes5.dex */
public class OkHttpClient implements Cloneable, Call.a {
    static final List<f> DEFAULT_CONNECTION_SPECS = null;
    static final List<Protocol> DEFAULT_PROTOCOLS = null;
    final b authenticator;

    @Nullable
    final Cache cache;
    final int callTimeout;
    final jvc.c certificateChainCleaner;
    final c certificatePinner;
    final int connectTimeout;
    final ConnectionPool connectionPool;
    final List<f> connectionSpecs;
    final h cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final boolean enableBoe;
    final i.c eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;

    @Nullable
    final dvc.i internalCache;
    final List<Interceptor> networkInterceptors;
    final int pingInterval;
    final List<Protocol> protocols;

    @Nullable
    final Proxy proxy;
    final b proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final TTNetDns ttnetDns;
    final int writeTimeout;

    public static final class Builder {
        b authenticator;

        @Nullable
        Cache cache;
        int callTimeout;

        @Nullable
        jvc.c certificateChainCleaner;
        c certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<f> connectionSpecs;
        h cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        boolean enableBoe;
        i.c eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;

        @Nullable
        dvc.i internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;

        @Nullable
        Proxy proxy;
        b proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;

        @Nullable
        SSLSocketFactory sslSocketFactory;

        @Nullable
        TTNetDns ttnetDns;
        int writeTimeout;

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = i.factory(i.NONE);
            ProxySelector r100 = ProxySelector.getDefault();
            this.proxySelector = r100;
            if (r100 != null) goto L5;
            this.proxySelector = new ivc.a();
        L5:
            this.cookieJar = h.f523873a;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = jvc.d.f500646a;
            this.certificatePinner = c.f523814c;
            b.a r101 = b.f523813a;
            this.proxyAuthenticator = r101;
            this.authenticator = r101;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
            this.ttnetDns = null;
            this.enableBoe = false;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder(OkHttpClient r100) {
            ArrayList r101 = new ArrayList();
            this.interceptors = r101;
            ArrayList r102 = new ArrayList();
            this.networkInterceptors = r102;
            this.dispatcher = r100.dispatcher;
            this.proxy = r100.proxy;
            this.protocols = r100.protocols;
            this.connectionSpecs = r100.connectionSpecs;
            r101.addAll(r100.interceptors);
            r102.addAll(r100.networkInterceptors);
            this.eventListenerFactory = r100.eventListenerFactory;
            this.proxySelector = r100.proxySelector;
            this.cookieJar = r100.cookieJar;
            this.internalCache = r100.internalCache;
            this.cache = r100.cache;
            this.socketFactory = r100.socketFactory;
            this.sslSocketFactory = r100.sslSocketFactory;
            this.certificateChainCleaner = r100.certificateChainCleaner;
            this.hostnameVerifier = r100.hostnameVerifier;
            this.certificatePinner = r100.certificatePinner;
            this.proxyAuthenticator = r100.proxyAuthenticator;
            this.authenticator = r100.authenticator;
            this.connectionPool = r100.connectionPool;
            this.dns = r100.dns;
            this.followSslRedirects = r100.followSslRedirects;
            this.followRedirects = r100.followRedirects;
            this.retryOnConnectionFailure = r100.retryOnConnectionFailure;
            this.callTimeout = r100.callTimeout;
            this.connectTimeout = r100.connectTimeout;
            this.readTimeout = r100.readTimeout;
            this.writeTimeout = r100.writeTimeout;
            this.pingInterval = r100.pingInterval;
            this.ttnetDns = r100.ttnetDns;
            this.enableBoe = r100.enableBoe;
        }

        public Builder addInterceptor(Interceptor r100) {
            if (r100 == null) goto L6;
            this.interceptors.add(r100);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addNetworkInterceptor(Interceptor r100) {
            if (r100 == null) goto L6;
            this.networkInterceptors.add(r100);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder authenticator(b r100) {
            if (r100 == null) goto L6;
            this.authenticator = r100;
            return this;
        L6:
            throw new NullPointerException("authenticator == null");
        }

        public Builder cache(@Nullable Cache r100) {
            this.cache = r100;
            this.internalCache = null;
            return this;
        }

        public Builder callTimeout(Duration r100) {
            this.callTimeout = cvc.c.d("timeout", r100.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder certificatePinner(c r100) {
            if (r100 == null) goto L6;
            this.certificatePinner = r100;
            return this;
        L6:
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder connectTimeout(Duration r100) {
            this.connectTimeout = cvc.c.d("timeout", r100.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectionPool(ConnectionPool r100) {
            if (r100 == null) goto L6;
            this.connectionPool = r100;
            return this;
        L6:
            throw new NullPointerException("connectionPool == null");
        }

        public Builder connectionSpecs(List<f> r100) {
            this.connectionSpecs = cvc.c.n(r100);
            return this;
        }

        public Builder cookieJar(h r100) {
            if (r100 == null) goto L6;
            this.cookieJar = r100;
            return this;
        L6:
            throw new NullPointerException("cookieJar == null");
        }

        public Builder dispatcher(Dispatcher r100) {
            if (r100 == null) goto L6;
            this.dispatcher = r100;
            return this;
        L6:
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder dns(Dns r100) {
            if (r100 == null) goto L6;
            this.dns = r100;
            return this;
        L6:
            throw new NullPointerException("dns == null");
        }

        public Builder enableBoe(boolean r100) {
            this.enableBoe = r100;
            return this;
        }

        public Builder eventListener(i r100) {
            if (r100 == null) goto L6;
            this.eventListenerFactory = i.factory(r100);
            return this;
        L6:
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(i.c r100) {
            if (r100 == null) goto L6;
            this.eventListenerFactory = r100;
            return this;
        L6:
            throw new NullPointerException("eventListenerFactory == null");
        }

        public Builder followRedirects(boolean r100) {
            this.followRedirects = r100;
            return this;
        }

        public Builder followSslRedirects(boolean r100) {
            this.followSslRedirects = r100;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier r100) {
            if (r100 == null) goto L6;
            this.hostnameVerifier = r100;
            return this;
        L6:
            throw new NullPointerException("hostnameVerifier == null");
        }

        public Builder pingInterval(Duration r100) {
            this.pingInterval = cvc.c.d("timeout", r100.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder protocols(List<Protocol> r100) {
            ArrayList r101 = new ArrayList(r100);
            Protocol r102 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (r101.contains(r102) == true) goto L10;
            if (r101.contains(Protocol.HTTP_1_1) == true) goto L10;
            throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + r101);
        L10:
            if (r101.contains(r102) == false) goto L17;
            if (r101.size() <= 1) goto L17;
            throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + r101);
        L17:
            if (r101.contains(Protocol.HTTP_1_0) == true) goto L25;
            if (r101.contains(null) == true) goto L23;
            r101.remove(Protocol.SPDY_3);
            this.protocols = Collections.unmodifiableList(r101);
            return this;
        L23:
            throw new IllegalArgumentException("protocols must not contain null");
        L25:
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + r101);
        }

        public Builder proxy(@Nullable Proxy r100) {
            this.proxy = r100;
            return this;
        }

        public Builder proxyAuthenticator(b r100) {
            if (r100 == null) goto L6;
            this.proxyAuthenticator = r100;
            return this;
        L6:
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder proxySelector(ProxySelector r100) {
            if (r100 == null) goto L6;
            this.proxySelector = r100;
            return this;
        L6:
            throw new NullPointerException("proxySelector == null");
        }

        public Builder readTimeout(Duration r100) {
            this.readTimeout = cvc.c.d("timeout", r100.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean r100) {
            this.retryOnConnectionFailure = r100;
            return this;
        }

        public void setInternalCache(@Nullable dvc.i r100) {
            this.internalCache = r100;
            this.cache = null;
        }

        public Builder socketFactory(SocketFactory r100) {
            if (r100 == null) goto L6;
            this.socketFactory = r100;
            return this;
        L6:
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory r100) {
            if (r100 == null) goto L10;
            this.sslSocketFactory = r100;
            hvc.g r101 = hvc.g.f487396a;
            X509TrustManager r102 = r101.p(r100);
            if (r102 == null) goto L8;
            this.certificateChainCleaner = r101.d(r102);
            return this;
        L8:
            throw new IllegalStateException("Unable to extract the trust manager on " + r101 + ", sslSocketFactory is " + r100.getClass());
        L10:
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder ttnetDns(TTNetDns r100) {
            if (r100 == null) goto L6;
            this.ttnetDns = r100;
            return this;
        L6:
            throw new NullPointerException("ttnetDns == null");
        }

        public Builder writeTimeout(Duration r100) {
            this.writeTimeout = cvc.c.d("timeout", r100.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder callTimeout(long r100, TimeUnit r101) {
            this.callTimeout = cvc.c.d("timeout", r100, r101);
            return this;
        }

        public Builder connectTimeout(long r100, TimeUnit r101) {
            this.connectTimeout = cvc.c.d("timeout", r100, r101);
            return this;
        }

        public Builder pingInterval(long r100, TimeUnit r101) {
            this.pingInterval = cvc.c.d(VideoThumbInfo.KEY_INTERVAL, r100, r101);
            return this;
        }

        public Builder readTimeout(long r100, TimeUnit r101) {
            this.readTimeout = cvc.c.d("timeout", r100, r101);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory r100, X509TrustManager r101) {
            if (r100 == null) goto L9;
            if (r101 == null) goto L7;
            this.sslSocketFactory = r100;
            this.certificateChainCleaner = hvc.g.f487396a.d(r101);
            return this;
        L7:
            throw new NullPointerException("trustManager == null");
        L9:
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder writeTimeout(long r100, TimeUnit r101) {
            this.writeTimeout = cvc.c.d("timeout", r100, r101);
            return this;
        }
    }

    public static class a extends cvc.a {
        public a() {
        }

        public final int a(Response.Builder r100) {
            return r100.code;
        }

        public final okhttp3.internal.connection.e b(ConnectionPool r100) {
            return r100.routeDatabase;
        }
    }

    static {
        DEFAULT_PROTOCOLS = cvc.c.o(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        DEFAULT_CONNECTION_SPECS = cvc.c.o(new f[]{f.f523840e, f.f523842g});
        cvc.a.f465511a = new a();
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public dvc.i internalCache() {
        Cache r100 = this.cache;
        if (r100 == null) goto L6;
        return r100.internalCache;
    L6:
        return this.internalCache;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public b authenticator() {
        return this.authenticator;
    }

    @Nullable
    public Cache cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public c certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public List<f> connectionSpecs() {
        return this.connectionSpecs;
    }

    public h cookieJar() {
        return this.cookieJar;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public boolean enableBoe() {
        return this.enableBoe;
    }

    public i.c eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public b proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public TTNetDns ttnetDns() {
        return this.ttnetDns;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public OkHttpClient(Builder r100) {
        this.dispatcher = r100.dispatcher;
        this.proxy = r100.proxy;
        this.protocols = r100.protocols;
        List<f> r101 = r100.connectionSpecs;
        this.connectionSpecs = r101;
        this.interceptors = cvc.c.n(r100.interceptors);
        this.networkInterceptors = cvc.c.n(r100.networkInterceptors);
        this.eventListenerFactory = r100.eventListenerFactory;
        this.proxySelector = r100.proxySelector;
        this.cookieJar = r100.cookieJar;
        this.cache = r100.cache;
        this.internalCache = r100.internalCache;
        this.socketFactory = r100.socketFactory;
        Iterator<f> r102 = r101.iterator();
    L3:
        boolean r103 = false;
    L5:
        if (r102.hasNext() == false) goto L11;
        f r104 = r102.next();
        if (r103 == true) goto L10;
        if (r104.f523843a == false) goto L3;
    L10:
        r103 = true;
        goto L5
    L11:
        SSLSocketFactory r105 = r100.sslSocketFactory;
        if (r105 != null) goto L27;
        if (r103 == false) goto L27;
        TrustManagerFactory r106 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: GeneralSecurityException -> L24
        r106.init(null);     // Catch: GeneralSecurityException -> L24
        TrustManager[] r107 = r106.getTrustManagers();     // Catch: GeneralSecurityException -> L24
        if (r107.length != 1) goto L23;
        TrustManager r108 = r107[0];     // Catch: GeneralSecurityException -> L24
        if ((r108 instanceof X509TrustManager) == false) goto L23;
        X509TrustManager r109 = (X509TrustManager) r108;     // Catch: GeneralSecurityException -> L24
        this.sslSocketFactory = newSslSocketFactory(r109);
        this.certificateChainCleaner = hvc.g.f487396a.d(r109);
    L28:
        SSLSocketFactory r110 = this.sslSocketFactory;
        if (r110 == null) goto L31;
        hvc.g.f487396a.f(r110);
    L31:
        this.hostnameVerifier = r100.hostnameVerifier;
        c r111 = r100.certificatePinner;
        jvc.c r112 = this.certificateChainCleaner;
        if (cvc.c.k(r111.f523816b, r112) == true) goto L35;
        r111 = new c(r111.f523815a, r112);
    L35:
        this.certificatePinner = r111;
        this.proxyAuthenticator = r100.proxyAuthenticator;
        this.authenticator = r100.authenticator;
        this.connectionPool = r100.connectionPool;
        this.dns = r100.dns;
        this.followSslRedirects = r100.followSslRedirects;
        this.followRedirects = r100.followRedirects;
        this.retryOnConnectionFailure = r100.retryOnConnectionFailure;
        this.callTimeout = r100.callTimeout;
        this.connectTimeout = r100.connectTimeout;
        this.readTimeout = r100.readTimeout;
        this.writeTimeout = r100.writeTimeout;
        this.pingInterval = r100.pingInterval;
        this.ttnetDns = r100.ttnetDns;
        this.enableBoe = r100.enableBoe;
        if (this.interceptors.contains(null) == true) goto L43;
        if (this.networkInterceptors.contains(null) == true) goto L41;
        return;
    L41:
        throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
    L43:
        throw new IllegalStateException("Null interceptor: " + this.interceptors);
    L23:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r107));     // Catch: GeneralSecurityException -> L24
    L24:
        e = move-exception;
        throw cvc.c.a("No System TLS", e);
    L27:
        this.sslSocketFactory = r105;
        this.certificateChainCleaner = r100.certificateChainCleaner;
        goto L28
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager r100) {
        SSLContext r101 = hvc.g.f487396a.i();     // Catch: GeneralSecurityException -> L4
        r101.init(null, new TrustManager[]{r100}, null);     // Catch: GeneralSecurityException -> L4
        return r101.getSocketFactory();
    L4:
        e = move-exception;
        throw cvc.c.a("No System TLS", e);
    }

    public Call newCall(Request r100) {
        return l.c(this, r100, false);
    }

    public WebSocket newWebSocket(Request r100, WebSocketListener r101) {
        kvc.a r102 = new kvc.a(r100, r101, new Random(), this.pingInterval);
        OkHttpClient r103 = newBuilder().eventListener(i.NONE).protocols(kvc.a.f506309v).build();
        Request r104 = r102.f506310a.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", r102.f506314e).header("Sec-WebSocket-Version", "13").build();
        cvc.a.f465511a.getClass();
        l r105 = l.c(r103, r104, true);
        r102.f506315f = r105;
        r105.f523939c.f524076c = 0;
        r105.enqueue(new kvc.b(r102, r104));
        return r102;
    }

    public int pingIntervalMillisWithHostPort(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (TTConfigManager.inst().getPingKeepAliveHosts().contains(r100 + ":" + r101) == false) goto L9;
        return TTConfigManager.inst().getPingKeepAliveInterval();
    L9:
        return this.pingInterval;
    }
}
