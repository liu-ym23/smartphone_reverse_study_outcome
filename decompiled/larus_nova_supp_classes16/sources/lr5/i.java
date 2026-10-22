package lr5;

import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends f {
    public nr5.a d;

    @Override // lr5.f
    public final okhttp3.b authenticator() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport authenticator setting");
        return super.authenticator();
    }

    @Override // lr5.f
    public final Cache cache() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport cache setting");
        return super.cache();
    }

    @Override // lr5.f
    public final okhttp3.c certificatePinner() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport certificatePinner setting");
        return super.certificatePinner();
    }

    @Override // lr5.f
    public final ConnectionPool connectionPool() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport connectionPool setting");
        return super.connectionPool();
    }

    @Override // lr5.f
    public final Dns dns() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport dns setting");
        return super.dns();
    }

    @Override // lr5.f
    public final boolean followSslRedirects() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport followSslRedirects setting");
        return super.followSslRedirects();
    }

    @Override // lr5.f
    public final HostnameVerifier hostnameVerifier() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport hostnameVerifier setting");
        return super.hostnameVerifier();
    }

    @Override // lr5.f
    public final List<Protocol> protocols() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport protocols setting");
        return super.protocols();
    }

    @Override // lr5.f
    public final okhttp3.b proxyAuthenticator() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport proxyAuthenticator setting");
        return super.proxyAuthenticator();
    }

    @Override // lr5.f
    public final boolean retryOnConnectionFailure() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport retryOnConnectionFailure setting");
        return super.retryOnConnectionFailure();
    }

    @Override // lr5.f
    public final SocketFactory socketFactory() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport socketFactory setting");
        return super.socketFactory();
    }

    @Override // lr5.f
    public final SSLSocketFactory sslSocketFactory() {
        tt5.a.k("eenet_RustOkHttpClientWrapper", "rust channel nonsupport sslSocketFactory setting");
        return super.sslSocketFactory();
    }

    public i(OkHttpClient r1) {
        this.a = r1.newBuilder().build();
    }

    @Override // lr5.g
    public final f a(OkHttpClient r2) {
        return new i(r2);
    }

    public final Call newCall(Request r3) {
        sr5.a.a(this.a);
        nr5.b r0 = new nr5.b(this, r3, false);
        r0.f = this.c.create(r0);
        return r0;
    }
}
