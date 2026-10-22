package lr5;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes16.dex */
public abstract class f extends OkHttpClient implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OkHttpClient f510429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f510430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f510431c;

    public class a implements okhttp3.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f510432a;

        public a(f r100) {
            this.f510432a = r100;
        }

        @Override // okhttp3.i.c
        public final okhttp3.i create(Call r100) {
            OkHttpClient r101 = this.f510432a.f510429a;
            sr5.a.a(r101);
            d r102 = this.f510432a.f510430b;
            okhttp3.i r103 = r101.eventListenerFactory().create(r100);
            r102.getClass();
            if (r100 == null) goto L8;
            if (r103 == null) goto L8;
            d.a r104 = new d.a();
            r104.f510409a = r103;
            r102.f510408a.put(r100, r104);
        L8:
            return this.f510432a.f510430b;
        }
    }

    @Override // okhttp3.OkHttpClient
    public okhttp3.b authenticator() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.authenticator();
    }

    public lr5.a b() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return new lr5.a(r100.newBuilder(), Boolean.FALSE);
    }

    @Override // okhttp3.OkHttpClient
    public Cache cache() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.cache();
    }

    @Override // okhttp3.OkHttpClient
    public okhttp3.c certificatePinner() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.certificatePinner();
    }

    @Override // okhttp3.OkHttpClient
    public final int connectTimeoutMillis() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.connectTimeoutMillis();
    }

    @Override // okhttp3.OkHttpClient
    public ConnectionPool connectionPool() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.connectionPool();
    }

    @Override // okhttp3.OkHttpClient
    public final List<okhttp3.f> connectionSpecs() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.connectionSpecs();
    }

    @Override // okhttp3.OkHttpClient
    public final okhttp3.h cookieJar() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.cookieJar();
    }

    @Override // okhttp3.OkHttpClient
    public final Dispatcher dispatcher() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.dispatcher();
    }

    @Override // okhttp3.OkHttpClient
    public Dns dns() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.dns();
    }

    @Override // okhttp3.OkHttpClient
    public final boolean followRedirects() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.followRedirects();
    }

    @Override // okhttp3.OkHttpClient
    public boolean followSslRedirects() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.followSslRedirects();
    }

    @Override // okhttp3.OkHttpClient
    public HostnameVerifier hostnameVerifier() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.hostnameVerifier();
    }

    @Override // okhttp3.OkHttpClient
    public final List<Interceptor> interceptors() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.interceptors();
    }

    @Override // okhttp3.OkHttpClient
    public final List<Interceptor> networkInterceptors() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.networkInterceptors();
    }

    @Override // okhttp3.OkHttpClient
    public final OkHttpClient.Builder newBuilder() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.newBuilder();
    }

    @Override // okhttp3.OkHttpClient
    public final int pingIntervalMillis() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.pingIntervalMillis();
    }

    @Override // okhttp3.OkHttpClient
    public List<Protocol> protocols() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.protocols();
    }

    @Override // okhttp3.OkHttpClient
    public final Proxy proxy() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.proxy();
    }

    @Override // okhttp3.OkHttpClient
    public okhttp3.b proxyAuthenticator() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.proxyAuthenticator();
    }

    @Override // okhttp3.OkHttpClient
    public final ProxySelector proxySelector() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.proxySelector();
    }

    @Override // okhttp3.OkHttpClient
    public final int readTimeoutMillis() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.readTimeoutMillis();
    }

    @Override // okhttp3.OkHttpClient
    public boolean retryOnConnectionFailure() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.retryOnConnectionFailure();
    }

    @Override // okhttp3.OkHttpClient
    public SocketFactory socketFactory() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.socketFactory();
    }

    @Override // okhttp3.OkHttpClient
    public SSLSocketFactory sslSocketFactory() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.sslSocketFactory();
    }

    @Override // okhttp3.OkHttpClient
    public final int writeTimeoutMillis() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return r100.writeTimeoutMillis();
    }

    public f() {
        this.f510430b = new d();
        this.f510431c = new a(this);
    }

    @Override // okhttp3.OkHttpClient
    public final okhttp3.i.c eventListenerFactory() {
        return this.f510431c;
    }
}
