package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.e;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.bduploader.UploadKeys;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* JADX INFO: loaded from: classes23.dex */
public class WebViewSSLCheckThread extends Thread {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f278127i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f278128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HostnameVerifier f278129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f278130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private X509HostnameVerifier f278131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SslErrorHandler f278132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f278133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Callback f278134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f278135h;

    public interface Callback {
        void onCancel(Context r100, String r101);

        void onProceed(Context r100, String r101);
    }

    public static class a implements okhttp3.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f278136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f278137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f278138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f278139d;

        @Override // okhttp3.Callback
        public void onFailure(Call r100, IOException r101) {
            e.b(WebViewSSLCheckThread.a(), "onFailure , IO Exception : " + r101.getMessage());
            Callback r102 = this.f278136a;
            if (r102 == null) goto L5;
            r102.onCancel(this.f278137b, this.f278138c);
            return;
        L5:
            this.f278139d.cancel();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call r100, Response r101) throws IOException {
            e.b(WebViewSSLCheckThread.a(), "onResponse . proceed");
            Callback r102 = this.f278136a;
            if (r102 == null) goto L5;
            r102.onProceed(this.f278137b, this.f278138c);
            return;
        L5:
            this.f278139d.proceed();
        }

        public a(Callback r100, Context r101, String r102, SslErrorHandler r103) {
            this.f278136a = r100;
            this.f278137b = r101;
            this.f278138c = r102;
            this.f278139d = r103;
        }
    }

    private void e() throws IOException {
        HttpsURLConnection r100 = null;
        URLConnection r101 = INVOKEVIRTUAL_com_huawei_secure_android_common_ssl_WebViewSSLCheckThread_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(this.f278133f));     // Catch: Throwable -> L13
        if ((r101 instanceof HttpsURLConnection) == false) goto L10;
        HttpsURLConnection r102 = (HttpsURLConnection) r101;     // Catch: Throwable -> L13
        r102.setSSLSocketFactory(this.f278128a);     // Catch: Throwable -> L8
        r102.setHostnameVerifier(this.f278129b);     // Catch: Throwable -> L8
        r102.setRequestMethod("GET");     // Catch: Throwable -> L8
        r102.setConnectTimeout(10000);     // Catch: Throwable -> L8
        r102.setReadTimeout(20000);     // Catch: Throwable -> L8
        r102.connect();     // Catch: Throwable -> L8
        r100 = r102;
    L8:
        Throwable th10 = th;
    L15:
        if (r102 == null) goto L17;
        r102.disconnect();
    L17:
        throw th10;
    L10:
        if (r100 == null) goto L22;
        r100.disconnect();
        return;
    L22:
        return;
    L13:
        th = move-exception;
        r102 = null;
        th10 = th;
        goto L15
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com_huawei_secure_android_common_ssl_WebViewSSLCheckThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        f278127i = "WebViewSSLCheckThread";
    }

    private void b() throws Exception {
        this.f278130c.setHostnameVerifier(this.f278131d);
        org.apache.http.conn.ssl.SSLSocketFactory r100 = this.f278130c;
        if ((r100 instanceof SecureApacheSSLSocketFactory) == false) goto L5;
        ((SecureApacheSSLSocketFactory) r100).setContext(this.f278135h);
    L5:
        BasicHttpParams r101 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(r101, 30000);
        HttpConnectionParams.setSoTimeout(r101, 30000);
        SchemeRegistry r102 = new SchemeRegistry();
        r102.register(new Scheme("https", this.f278130c, UploadKeys.KeyIsGetVideoMeta));
        r102.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        DefaultHttpClient r103 = new DefaultHttpClient(new ThreadSafeClientConnManager(r101, r102), r101);
        HttpGet r104 = new HttpGet();
        r104.setURI(new URI(this.f278133f));
        HttpResponse r105 = r103.execute(r104);
        e.c(f278127i, "status code is : " + r105.getStatusLine().getStatusCode());
    }

    private void c() {
        String r100 = f278127i;
        e.c(r100, "callbackCancel: ");
        Callback r101 = this.f278134g;
        if (r101 == null) goto L7;
        r101.onCancel(this.f278135h, this.f278133f);
        return;
    L7:
        if (this.f278132e == null) goto L10;
        e.c(r100, "callbackCancel 2: ");
        this.f278132e.cancel();
        return;
    }

    private void d() {
        e.c(f278127i, "callbackProceed: ");
        Callback r100 = this.f278134g;
        if (r100 == null) goto L6;
        r100.onProceed(this.f278135h, this.f278133f);
        return;
    L6:
        SslErrorHandler r101 = this.f278132e;
        if (r101 == null) goto L10;
        r101.proceed();
        return;
    }

    public void com_huawei_secure_android_common_ssl_WebViewSSLCheckThread__run$___twin___() {
        super.run();
        if (this.f278130c == null) goto L20;
        if (this.f278131d == null) goto L20;
        if (this.f278132e != null) goto L9;
    L17:
        e.b(f278127i, "sslErrorHandler or url is null");
        c();
        return;
    L9:
        if (TextUtils.isEmpty(this.f278133f) == true) goto L17;
        b();     // Catch: Exception -> L14
        d();
        return;
    L14:
        e = move-exception;
        e.b(f278127i, "run: exception : " + e.getMessage());
        c();
        return;
    L20:
        if (this.f278128a != null) goto L22;
    L29:
        c();
        return;
    L22:
        if (this.f278129b == null) goto L29;
        e();     // Catch: Exception -> L26
        d();
        return;
    L26:
        e = move-exception;
        e.b(f278127i, "exception : " + e.getMessage());
        c();
    }

    public WebViewSSLCheckThread() {
    }

    public static /* synthetic */ String a() {
        return f278127i;
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f278131d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f278130c;
    }

    public Callback getCallback() {
        return this.f278134g;
    }

    public Context getContext() {
        return this.f278135h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f278129b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f278132e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f278128a;
    }

    public String getUrl() {
        return this.f278133f;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_huawei_secure_android_common_ssl_WebViewSSLCheckThread_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_huawei_secure_android_common_ssl_WebViewSSLCheckThread_com_larus_apm_impl_protector_RunnableLancet_run(WebViewSSLCheckThread r100) {
        r100.com_huawei_secure_android_common_ssl_WebViewSSLCheckThread__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier r100) {
        this.f278131d = r100;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory r100) {
        this.f278130c = r100;
    }

    public void setCallback(Callback r100) {
        this.f278134g = r100;
    }

    public void setContext(Context r100) {
        this.f278135h = r100;
    }

    public void setHostnameVerifier(HostnameVerifier r100) {
        this.f278129b = r100;
    }

    public void setSslErrorHandler(SslErrorHandler r100) {
        this.f278132e = r100;
    }

    public void setSslSocketFactory(SSLSocketFactory r100) {
        this.f278128a = r100;
    }

    public void setUrl(String r100) {
        this.f278133f = r100;
    }

    public WebViewSSLCheckThread(SslErrorHandler r100, String r101, Context r102) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(r100);
        setUrl(r101);
        setContext(r102);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(r102)));
        setHostnameVerifier(new StrictHostnameVerifier());
        setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory(null, new c(r102)));     // Catch: UnrecoverableKeyException -> L5
    L7:
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return;
    L5:
        e = move-exception;
        e.b(f278127i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e.getMessage());
        goto L7
    }

    public static void checkServerCertificateWithOK(SslErrorHandler r100, String r101, Context r102) {
        checkServerCertificateWithOK(r100, r101, r102, null);
    }

    public WebViewSSLCheckThread(SslErrorHandler r100, String r101, SSLSocketFactory r102, HostnameVerifier r103) {
        setSslErrorHandler(r100);
        setUrl(r101);
        setSslSocketFactory(r102);
        setHostnameVerifier(r103);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler r100, String r101, Context r102, Callback r103) {
        if (r100 != null) goto L4;
    L13:
        e.b(f278127i, "checkServerCertificateWithOK: handler or url or context is null");
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (r102 == null) goto L13;
        OkHttpClient.Builder r104 = new OkHttpClient.Builder();
        SecureSSLSocketFactoryNew r105 = new SecureSSLSocketFactoryNew(new c(r102));     // Catch: Exception -> L10
        r105.setContext(r102);     // Catch: Exception -> L10
        r104.sslSocketFactory(r105, new c(r102));     // Catch: Exception -> L10
        r104.hostnameVerifier(new StrictHostnameVerifier());     // Catch: Exception -> L10
        r104.build().newCall(new Request.Builder().url(r101).build()).enqueue(new a(r103, r102, r101, r100));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.b(f278127i, "checkServerCertificateWithOK: exception : " + e.getMessage());
        r100.cancel();
    }

    public WebViewSSLCheckThread(SslErrorHandler r100, String r101, org.apache.http.conn.ssl.SSLSocketFactory r102, X509HostnameVerifier r103) {
        setSslErrorHandler(r100);
        setUrl(r101);
        setApacheSSLSocketFactory(r102);
        setApacheHostnameVerifier(r103);
    }

    public WebViewSSLCheckThread(SslErrorHandler r100, String r101, org.apache.http.conn.ssl.SSLSocketFactory r102, X509HostnameVerifier r103, Callback r104, Context r105) {
        this.f278132e = r100;
        this.f278133f = r101;
        this.f278130c = r102;
        this.f278131d = r103;
        this.f278134g = r104;
        this.f278135h = r105;
    }
}
