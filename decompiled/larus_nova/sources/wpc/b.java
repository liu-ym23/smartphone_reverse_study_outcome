package wpc;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f560674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f560675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f560676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f560677d;

    public b(c r100, String r101) {
        this.f560674a = null;
        this.f560675b = null;
        this.f560676c = null;
        this.f560676c = r100;
        this.f560677d = r101;
    }

    public final void b() {
        c r100 = this.f560676c;
        if (r100 != null) goto L62;
        return;
    L62:
        URL r101 = r100.a();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        if ("https".equals(r101.getProtocol().toLowerCase()) == false) goto L13;
        HttpsURLConnection r102 = (HttpsURLConnection) a(r101);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        String r103 = this.f560677d;     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        SSLContext r104 = SSLContext.getInstance("TLS");     // Catch: Exception -> L10 Throwable -> L29
        r104.init(null, new TrustManager[]{new a(r103)}, null);     // Catch: Exception -> L10 Throwable -> L29
        r102.setSSLSocketFactory(r104.getSocketFactory());     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        HttpURLConnection r105 = r102;
    L14:
        this.f560676c.getClass();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r105.setRequestMethod("POST");     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r105.setReadTimeout(60000);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r105.setConnectTimeout(30000);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r105.setInstanceFollowRedirects(true);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r105.setUseCaches(false);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        this.f560676c.getClass();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        this.f560676c.getClass();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r105.setDoOutput(true);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        OutputStreamWriter r106 = new OutputStreamWriter(r105.getOutputStream(), "UTF-8");     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r106.write(this.f560676c.f560679b);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r106.flush();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r106.close();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        r105.connect();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        if (r105.getResponseCode() != 200) goto L20;
        InputStream r107 = r105.getInputStream();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        this.f560675b = r107;     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
        if (r107 == null) goto L26;
        this.f560674a = com.unionpay.utils.b.b(r107);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
    L26:
        InputStream r108 = this.f560675b;     // Catch: Exception -> L57
        if (r108 != null) goto L45;
        return;
    L45:
        r108.close();     // Catch: Exception -> L57
        return;
    L20:
        if (r105.getResponseCode() == 401) goto L26;
        if (r105.getResponseCode() == 404) goto L26;
        r105.getResponseCode();     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
    L10:
        e = move-exception;
        throw new IOException(e.getMessage());     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
    L13:
        r105 = (HttpURLConnection) a(r101);     // Catch: Throwable -> L29 Exception -> L31 IllegalStateException -> L36 IOException -> L41 SSLHandshakeException -> L47
    L47:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        r108 = this.f560675b;     // Catch: Exception -> L57
        if (r108 != null) goto L45;
        return;
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        r108 = this.f560675b;     // Catch: Exception -> L57
        if (r108 != null) goto L45;
        return;
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        r108 = this.f560675b;     // Catch: Exception -> L57
        if (r108 != null) goto L45;
        return;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        r108 = this.f560675b;     // Catch: Exception -> L57
        if (r108 != null) goto L45;
        return;
    L29:
        th = move-exception;
        InputStream r109 = this.f560675b;     // Catch: Exception -> L58
        if (r109 == null) goto L56;
        r109.close();     // Catch: Exception -> L58
    L56:
        throw th;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
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
}
