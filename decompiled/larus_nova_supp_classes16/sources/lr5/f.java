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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class f extends OkHttpClient implements g {
    public OkHttpClient a;
    public final d b;
    public final a c;

    public class a implements okhttp3.i.c {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final okhttp3.i create(Call r4) {
            OkHttpClient r0 = this.a.a;
            sr5.a.a(r0);
            d r1 = this.a.b;
            okhttp3.i r2 = r0.eventListenerFactory().create(r4);
            r1.getClass();
            if (r4 == null) goto L8;
            if (r2 == null) goto L8;
            d.a r3 = new d.a();
            r3.a = r2;
            r1.a.put(r4, r3);
        L8:
            return this.a.b;
        }
    }

    public okhttp3.b authenticator() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.authenticator();
    }

    public lr5.a b() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return new lr5.a(r0.newBuilder(), Boolean.FALSE);
    }

    public Cache cache() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.cache();
    }

    public okhttp3.c certificatePinner() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.certificatePinner();
    }

    public final int connectTimeoutMillis() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.connectTimeoutMillis();
    }

    public ConnectionPool connectionPool() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.connectionPool();
    }

    public final List<okhttp3.f> connectionSpecs() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.connectionSpecs();
    }

    public final okhttp3.h cookieJar() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.cookieJar();
    }

    public final Dispatcher dispatcher() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.dispatcher();
    }

    public Dns dns() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.dns();
    }

    public final boolean followRedirects() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.followRedirects();
    }

    public boolean followSslRedirects() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.followSslRedirects();
    }

    public HostnameVerifier hostnameVerifier() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.hostnameVerifier();
    }

    public final List<Interceptor> interceptors() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.interceptors();
    }

    public final List<Interceptor> networkInterceptors() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.networkInterceptors();
    }

    public final OkHttpClient.Builder newBuilder() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.newBuilder();
    }

    public final int pingIntervalMillis() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.pingIntervalMillis();
    }

    public List<Protocol> protocols() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.protocols();
    }

    public final Proxy proxy() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.proxy();
    }

    public okhttp3.b proxyAuthenticator() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.proxyAuthenticator();
    }

    public final ProxySelector proxySelector() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.proxySelector();
    }

    public final int readTimeoutMillis() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.readTimeoutMillis();
    }

    public boolean retryOnConnectionFailure() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.retryOnConnectionFailure();
    }

    public SocketFactory socketFactory() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.socketFactory();
    }

    public SSLSocketFactory sslSocketFactory() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.sslSocketFactory();
    }

    public final int writeTimeoutMillis() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return r0.writeTimeoutMillis();
    }

    public f() {
        this.b = new d();
        this.c = new a(this);
    }

    public final okhttp3.i.c eventListenerFactory() {
        return this.c;
    }
}
