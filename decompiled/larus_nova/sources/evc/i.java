package evc;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTNetUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements Interceptor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f474514g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f474515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile StreamAllocation f474516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f474517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f474518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f474519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f474520f;

    static {
        f474514g = cvc.c.o(new String[]{"Accept", "Accept-Charset", "Accept-Encoding", "Accept-Language", "Authorization", "Cache-Control", "Connection", "Content-Length", "Content-Type", "Host", DownloadHelper.IF_MATCH, "If-Modified-Since", "If-None-Match", "If-Range", "If-Unmodified-Since", "Origin", "Pragma", "Proxy-Authorization", "Proxy-Connection", "Range", AppConstants.HTTP_H_REFERER, "Transfer-Encoding", "User-Agent"});
    }

    public i(OkHttpClient r100) {
        this.f474519e = -1;
        this.f474520f = false;
        this.f474515a = r100;
    }

    public final okhttp3.a a(HttpUrl r110) {
        if (r110.isHttps() == false) goto L5;
        SSLSocketFactory r100 = this.f474515a.sslSocketFactory();
        SSLSocketFactory r101 = r100;
        HostnameVerifier r102 = this.f474515a.hostnameVerifier();
        okhttp3.c r103 = this.f474515a.certificatePinner();
    L7:
        return new okhttp3.a(r110.host(), r110.port(), this.f474515a.dns(), this.f474515a.socketFactory(), r101, r102, r103, this.f474515a.proxyAuthenticator(), this.f474515a.proxy(), this.f474515a.protocols(), this.f474515a.connectionSpecs(), this.f474515a.proxySelector(), this.f474515a.ttnetDns());
    L5:
        r101 = null;
        r102 = null;
        r103 = null;
        goto L7
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r110) throws IOException {
        Request r100 = r110.request();
        RealInterceptorChain r111 = (RealInterceptorChain) r110;
        Call r101 = r111.call();
        okhttp3.i r102 = r111.eventListener();
        StreamAllocation r103 = new StreamAllocation(this.f474515a.connectionPool(), a(r100.url()), r101, r102, this.f474517c);
        this.f474516b = r103;
        Response r104 = null;
        int r105 = 0;
    L4:
        if (this.f474518d == true) goto L46;
        Response r106 = r111.proceed(r100, r103, null, null);     // Catch: Throwable -> L27 IOException -> L29 RouteException -> L38
    L6:
        if (r104 == null) goto L50;
        r106 = r106.newBuilder().priorResponse(r104.newBuilder().body(null).build()).build();
    L50:
        Request r112 = b(r106, r103.route(), r101, r102);     // Catch: IOException -> L24
        if (r112 == null) goto L10;
        cvc.c.e(r106.body());
        int r113 = r105 + 1;
        if (r113 > 20) goto L22;
        r112.body();
        if (e(r106, r112.url()) == true) goto L18;
        r103.release();
        r103 = new StreamAllocation(this.f474515a.connectionPool(), a(r112.url()), r101, r102, this.f474517c);
        this.f474516b = r103;
    L19:
        r104 = r106;
        r100 = r112;
        r105 = r113;
        goto L4
    L18:
        if (r103.codec() == null) goto L19;
        throw new IllegalStateException("Closing the body of " + r106 + " didn't close its backing stream. Bad interceptor?");
    L22:
        r103.release();
        throw new ProtocolException("Too many follow-up requests: " + r113);
    L10:
        r103.release();
        return r106;
    L24:
        e = move-exception;
        r103.release();
        throw e;
    L27:
        th = move-exception;
        r103.streamFailed(null);
        r103.release();
        throw th;
    L29:
        e = move-exception;
        if ((e instanceof ConnectionShutdownException) == true) goto L33;
        boolean r107 = true;
    L35:
        if (c(e, r103, r107, r100) == true) goto L4;
        throw e;     // Catch: Throwable -> L27
    L33:
        r107 = false;
    L38:
        e = move-exception;
        if (c(e.getLastConnectException(), r103, false, r100) == true) goto L4;
        throw e.getFirstConnectException();     // Catch: Throwable -> L27
    L46:
        r103.release();
        throw new IOException("Canceled#Reason=" + this.f474519e);
    }

    public static int d(Response r100, int r101) {
        String r102 = r100.header("Retry-After");
        if (r102 != null) goto L6;
        return r101;
    L6:
        if (r102.matches("\\d+") == true) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return CastIntegerProtector.valueOf(r102).intValue();
    }

    public static boolean e(Response r100, HttpUrl r101) {
        HttpUrl r102 = r100.request().url();
        if (r102.host().equals(r101.host()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r102.port() != r101.port()) goto L9;
        if (r102.scheme().equals(r101.scheme()) == false) goto L9;
        return true;
    }

    public final boolean f(IOException r100, Request r101) {
        if (this.f474520f == false) goto L5;
        return false;
    L5:
        this.f474520f = true;
        int r102 = TTNetUtils.convertExceptionToErrorCode(r100);
        if (TTConfigManager.inst().shouldRetryForceHttpdnsOnError(r100, r101, r102) == false) goto L26;
        this.f474516b.resetRouteSelector(r102);
        if (lvc.a.f510978b == null) goto L10;
    L19:
        lvc.a r103 = lvc.a.f510978b;
        r103.getClass();
        if (r101.url() != null) goto L22;
    L25:
        return true;
    L22:
        if (TextUtils.isEmpty(r101.url().host()) == true) goto L25;
        String r104 = r101.url().host();
        r103.f510979a.add(r104);
        goto L25
    L10:
        monitor-enter(lvc.a.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (lvc.a.f510978b != null) goto L14;
        lvc.a.f510978b = new lvc.a();     // Catch: Throwable -> L16
    L14:
        monitor-exit(lvc.a.class);     // Catch: Throwable -> L16
        goto L19
    L26:
        return false;
    }

    public final Request b(Response r110, Route r111, Call r112, okhttp3.i r210) throws IOException {
        if (r110 == null) goto L143;
        int r100 = r110.code();
        String r101 = r110.request().method();
        RequestBody r102 = null;
        boolean r103 = false;
        if (r100 == 307) goto L49;
        if (r100 == 308) goto L49;
        if (r100 != 401) goto L10;
        this.f474515a.authenticator().getClass();
        return null;
    L10:
        if (r100 == 503) goto L37;
        if (r100 == 407) goto L31;
        if (r100 == 408) goto L18;
        switch(r100) {
            case 300: goto L49;
            case 301: goto L49;
            case 302: goto L49;
            case 303: goto L49;
            default: goto L16;
        };
    L16:
        return null;
    L18:
        if (this.f474515a.retryOnConnectionFailure() == true) goto L20;
        return null;
    L20:
        r110.request().body();
        if (r110.priorResponse() == null) goto L26;
        if (r110.priorResponse().code() != 408) goto L26;
        return null;
    L26:
        if (d(r110, 0) <= 0) goto L29;
        return null;
    L29:
        return r110.request();
    L31:
        if (r111.proxy().type() != Proxy.Type.HTTP) goto L35;
        this.f474515a.proxyAuthenticator().getClass();
        return null;
    L35:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L37:
        if (r110.priorResponse() == null) goto L42;
        if (r110.priorResponse().code() != 503) goto L42;
        return null;
    L42:
        if (d(r110, Integer.MAX_VALUE) == 0) goto L44;
        return null;
    L44:
        return r110.request();
    L49:
        if (this.f474515a.followRedirects() == true) goto L51;
        return null;
    L51:
        String r104 = r110.header("Location");
        if (r104 != null) goto L54;
        return null;
    L54:
        HttpUrl r105 = r110.request().url().resolve(r104);
        if (r105 != null) goto L58;
        return null;
    L58:
        if (r105.scheme().equals(r110.request().url().scheme()) == false) goto L60;
    L62:
        Request.Builder r106 = r110.request().newBuilder();
        if (f.b(r101) == false) goto L90;
        if (r101.equals(OpenNetMethod.PROPFIND) == true) goto L74;
        if (r100 == 308) goto L70;
        if (r100 == 307) goto L70;
        boolean r113 = false;
    L71:
        if (r113 == true) goto L74;
        boolean r114 = false;
    L75:
        if (r100 == 308) goto L79;
        if (r100 == 307) goto L79;
        boolean r107 = false;
    L80:
        if (r107 == false) goto L82;
    L84:
        if (r114 == false) goto L86;
        r102 = r110.request().body();
    L86:
        r106.method(r101, r102);
    L87:
        if (r114 == true) goto L90;
        r106.removeHeader("Transfer-Encoding");
        r106.removeHeader("Content-Length");
        r106.removeHeader("Content-Type");
        goto L90
    L82:
        if ((!r101.equals(OpenNetMethod.PROPFIND)) == false) goto L84;
        r106.method("GET", null);
    L79:
        r107 = true;
    L70:
        r113 = true;
    L74:
        r114 = true;
    L90:
        if (e(r110, r105) == true) goto L92;
        r106.removeHeader("Authorization");
    L92:
        Request r108 = r110.request();
        if (r108 == null) goto L141;
        if (TextUtils.isEmpty(r105.host()) == true) goto L141;
        if (this.f474515a.enableBoe() == true) goto L141;
        if (r108.isHttps() == true) goto L106;
        if (r108.originUrl() != null) goto L104;
    L108:
        boolean r109 = false;
    L109:
        if (r109 == false) goto L114;
        g(r112, r108, r105, true, r106, r210);
        if (TTConfigManager.inCookieHostList(r105.host()) == false) goto L141;
        r106.addHeader("x-metasec-ok-bypass-downgrade-cookie", "1");
        goto L141
    L114:
        if (TTConfigManager.inst().getRedirectRequestControlConfig().f523952f.get() == true) goto L141;
        if (r108.url().host().equals(r105.host()) == true) goto L141;
        if (r108.originUrl() != null) goto L120;
    L122:
        String r115 = r105.host();
        if (TextUtils.isEmpty(r115) == true) goto L138;
        Iterator<String> r116 = TTConfigManager.inst().getRedirectRequestControlConfig().f523948b.iterator();
    L127:
        if (r116.hasNext() == false) goto L137;
        String r117 = r116.next();
        if (r115.equals(r117) == true) goto L136;
        if (r117.startsWith(".") == true) goto L135;
        r117 = ".".concat(r117);
    L135:
        if (r115.toLowerCase().endsWith(r117.toLowerCase()) == false) goto L127;
    L136:
        r103 = true;
        goto L138
    L137:
        TTConfigManager.inst();
        r103 = TTConfigManager.inCookieHostList(r115);
    L138:
        if (r103 == true) goto L141;
        g(r112, r108, r105, false, r106, r210);
        goto L141
    L120:
        if (r105.host().equals(r108.originUrl().host()) == false) goto L122;
    L104:
        if (r108.originUrl().isHttps() == false) goto L108;
    L106:
        if (r105.isHttps() == true) goto L108;
        r109 = true;
    L141:
        return r106.url(r105).build();
    L60:
        if (this.f474515a.followSslRedirects() == true) goto L62;
        return null;
    L143:
        throw new IllegalStateException();
    }

    public final boolean c(IOException r100, StreamAllocation r101, boolean r102, Request r103) {
        r101.streamFailed(r100);
        boolean r104 = false;
        if (this.f474515a.retryOnConnectionFailure() == true) goto L5;
        return false;
    L5:
        if (r102 == false) goto L10;
        r103.body();
        if ((r100 instanceof FileNotFoundException) == false) goto L10;
        return false;
    L10:
        if ((r100 instanceof ProtocolException) == false) goto L13;
    L27:
        if (r104 == true) goto L31;
        return f(r100, r103);
    L31:
        if (this.f474516b.hasMoreRoutes() == false) goto L33;
        return true;
    L33:
        return f(r100, r103);
    L13:
        if ((r100 instanceof InterruptedIOException) == false) goto L19;
        if ((r100 instanceof SocketTimeoutException) == false) goto L27;
        if (r102 == true) goto L27;
    L26:
        r104 = true;
        goto L27
    L19:
        if ((r100 instanceof SSLHandshakeException) == false) goto L24;
        if ((r100.getCause() instanceof CertificateException) == true) goto L27;
    L24:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L26;
        goto L26
    }

    public static void g(Call r100, Request r110, HttpUrl r111, boolean r112, Request.Builder r113, okhttp3.i r114) {
        TTConfigManager.a r101 = TTConfigManager.inst().getRedirectRequestControlConfig();
        ArrayList r102 = new ArrayList();
        boolean r103 = false;
        boolean r104 = true;
        if (r101.f523954h.get() == false) goto L5;
        Iterator<Map.Entry<String, List<String>>> r105 = r110.headers().toMultimap().entrySet().iterator();
    L45:
        if (r105.hasNext() == false) goto L72;
        String r106 = r105.next().getKey();
        List<String> r107 = r101.f523955i;
        List<String> r108 = r101.f523956j;
        if (TextUtils.isEmpty(r106) == true) goto L66;
        Iterator r109 = ((ArrayList) r107).iterator();
    L51:
        if (r109.hasNext() == false) goto L55;
        if (r106.equalsIgnoreCase((String) r109.next()) == false) goto L51;
    L55:
        Iterator r115 = ((ArrayList) r108).iterator();
    L57:
        if (r115.hasNext() == false) goto L61;
        if (r106.equalsIgnoreCase((String) r115.next()) == false) goto L57;
    L67:
        boolean r116 = false;
    L68:
        if (r116 == true) goto L45;
        r102.add(r106);
        goto L45
    L61:
        Iterator<String> r117 = f474514g.iterator();
    L63:
        if (r117.hasNext() == false) goto L67;
        if (r106.equalsIgnoreCase(r117.next()) == false) goto L63;
    L66:
        r116 = true;
    L72:
        if (r102.isEmpty() == false) goto L74;
        return;
    L74:
        boolean r118 = r104 | r112;
        if (r118 == false) goto L81;
        Iterator r119 = r102.iterator();
    L78:
        if (r119.hasNext() == false) goto L81;
        r113.removeHeader((String) r119.next());
    L81:
        if (r101.f523951e.get() == false) goto L100;
        return;
    L100:
        JSONObject r120 = new JSONObject();     // Catch: JSONException -> L97
        r120.put("src", "ttok");     // Catch: JSONException -> L97
        if (r101.f523953g.get() == false) goto L87;
        r120.put("origin_url", r110.url());     // Catch: JSONException -> L97
        r120.put("rect_url", r111.url());     // Catch: JSONException -> L97
    L87:
        r120.put("origin_host", r110.url().scheme() + "://" + r110.url().host());     // Catch: JSONException -> L97
        r120.put("rect_host", r111.scheme() + "://" + r111.host());     // Catch: JSONException -> L97
        r120.put("origin_path", r110.url().encodedPath());     // Catch: JSONException -> L97
        r120.put("rect_path", r111.encodedPath());     // Catch: JSONException -> L97
        JSONArray r121 = new JSONArray();     // Catch: JSONException -> L97
        Iterator r122 = r102.iterator();     // Catch: JSONException -> L97
    L89:
        if (r122.hasNext() == false) goto L91;
        r121.put((String) r122.next());     // Catch: JSONException -> L97
        goto L89
    L91:
        r120.put("scy_headers", r121);     // Catch: JSONException -> L97
        r120.put("remove_scy_header", r118);     // Catch: JSONException -> L97
        r120.put(GearStrategyConsts.EV_DOWNGRADE_TYPE, r112);     // Catch: JSONException -> L97
        if (r101.f523954h.get() == false) goto L94;
        r120.put("ctl_ver", "v2");     // Catch: JSONException -> L97
    L94:
        if (r114 == null) goto L127;
        r114.callInSecureRedirect(r100, r120);     // Catch: JSONException -> L97
        return;
    L127:
        return;
    L97:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r101.f523949c.get() == true) goto L23;
        String r123 = r111.host();
        if (TextUtils.isEmpty(r123) == true) goto L21;
        Iterator<String> r124 = TTConfigManager.inst().getRedirectRequestControlConfig().f523950d.iterator();
    L11:
        if (r124.hasNext() == false) goto L21;
        String r125 = r124.next();
        if (r123.equals(r125) == true) goto L20;
        if (r125.startsWith(".") == true) goto L19;
        r125 = ".".concat(r125);
    L19:
        if (r123.toLowerCase().endsWith(r125.toLowerCase()) == false) goto L11;
    L20:
        boolean r126 = true;
    L22:
        if (r126 == true) goto L23;
    L25:
        if (TextUtils.isEmpty(r110.header("x-tt-token")) == true) goto L28;
        r102.add("x-tt-token");
    L28:
        if (TextUtils.isEmpty(r110.header("Cookie")) == true) goto L31;
        r102.add("Cookie");
    L31:
        if (TextUtils.isEmpty(r110.header("Cookie2")) == true) goto L34;
        r102.add("Cookie2");
    L34:
        if (TextUtils.isEmpty(r110.header(CronetHttpURLConnection.SS_COOKIE)) == true) goto L36;
        r102.add(CronetHttpURLConnection.SS_COOKIE);
    L36:
        Iterator<String> r127 = r101.f523947a.iterator();
    L38:
        if (r127.hasNext() == false) goto L42;
        String r128 = r127.next();
        if (TextUtils.isEmpty(r110.header(r128)) == true) goto L38;
        r102.add(r128);
        goto L38
    L42:
        r104 = r103;
    L21:
        r126 = false;
    L23:
        r103 = true;
        goto L25
    }
}
