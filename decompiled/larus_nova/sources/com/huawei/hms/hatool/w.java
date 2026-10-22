package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.larus.utils.logger.FLogger;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public abstract class w {

    public static class a extends Exception {
        public a(String r100) {
            super(r100);
        }
    }

    public static n0 a(String r100, byte[] r101, Map<String, String> r102) {
        return a(r100, r101, r102, "POST");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.BufferedOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    public static n0 a(String r100, byte[] r101, Map<String, String> r102, String r103) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r104 = null;
        int r105 = -102;
        HttpURLConnection r106 = a(r100, r101.length, r102, r103);     // Catch: Throwable -> L39 IOException -> L41 UnknownHostException -> L49 ConnectException -> L57 SSLHandshakeException -> L65 SSLPeerUnverifiedException -> L73 SecurityException -> L81 a -> L89
    L126:
        if (r106 != null) goto L14;
        n0 r107 = new n0(-101, "");     // Catch: Throwable -> L30 IOException -> L32 UnknownHostException -> L33 ConnectException -> L34 SSLHandshakeException -> L35 SSLPeerUnverifiedException -> L36 SecurityException -> L37 a -> L38
        k1.a(null);
        k1.a(null);
        if (r106 == null) goto L13;
        k1.a(r106);
    L13:
        return r107;
    L14:
        r102 = r106.getOutputStream();     // Catch: Throwable -> L30 IOException -> L32 UnknownHostException -> L33 ConnectException -> L34 SSLHandshakeException -> L35 SSLPeerUnverifiedException -> L36 SecurityException -> L37 a -> L38
        ?? r108 = new BufferedOutputStream(r102);     // Catch: Throwable -> L28 IOException -> L111 UnknownHostException -> L112 ConnectException -> L113 SSLHandshakeException -> L114 SSLPeerUnverifiedException -> L115 SecurityException -> L116 a -> L117
        r108.write(r101);     // Catch: Throwable -> L26 IOException -> L104 UnknownHostException -> L105 ConnectException -> L106 SSLHandshakeException -> L107 SSLPeerUnverifiedException -> L108 SecurityException -> L109 a -> L110
        r108.flush();     // Catch: Throwable -> L26 IOException -> L104 UnknownHostException -> L105 ConnectException -> L106 SSLHandshakeException -> L107 SSLPeerUnverifiedException -> L108 SecurityException -> L109 a -> L110
        int r109 = r106.getResponseCode();     // Catch: Throwable -> L26 IOException -> L104 UnknownHostException -> L105 ConnectException -> L106 SSLHandshakeException -> L107 SSLPeerUnverifiedException -> L108 SecurityException -> L109 a -> L110
        n0 r110 = new n0(r109, b(r106));     // Catch: IOException -> L20 UnknownHostException -> L21 ConnectException -> L22 SSLHandshakeException -> L23 SSLPeerUnverifiedException -> L24 SecurityException -> L25 Throwable -> L26 a -> L110
        k1.a(r108);
        k1.a(r102);
        k1.a(r106);
        return r110;
    L25:
        r105 = r109;
    L22:
        r105 = r109;
    L21:
        r105 = r109;
    L23:
        r105 = r109;
    L24:
        r105 = r109;
    L20:
        r105 = r109;
        goto L43
    L26:
        th = th;
    L100:
        k1.a(r108);
        k1.a(r102);
        if (r106 == null) goto L103;
        k1.a(r106);
    L103:
        throw th;
    L91:
        HttpURLConnection r111 = r106;
        v.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");     // Catch: Throwable -> L97
        n0 r112 = new n0(-101, "");     // Catch: Throwable -> L97
        k1.a(r108);
        k1.a(r102);
        if (r111 == null) goto L96;
        k1.a(r111);
    L96:
        return r112;
    L83:
        HttpURLConnection r113 = r106;
        v.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");     // Catch: Throwable -> L97
        n0 r114 = new n0(r105, "");     // Catch: Throwable -> L97
        k1.a(r108);
        k1.a(r102);
        if (r113 == null) goto L88;
        k1.a(r113);
    L88:
        return r114;
    L59:
        HttpURLConnection r115 = r106;
        v.f("hmsSdk", "Network is unreachable or Connection refused");     // Catch: Throwable -> L97
        n0 r116 = new n0(r105, "");     // Catch: Throwable -> L97
        k1.a(r108);
        k1.a(r102);
        if (r115 == null) goto L64;
        k1.a(r115);
    L64:
        return r116;
    L51:
        HttpURLConnection r117 = r106;
        v.f("hmsSdk", "No address associated with hostname or No network");     // Catch: Throwable -> L97
        n0 r118 = new n0(r105, "");     // Catch: Throwable -> L97
        k1.a(r108);
        k1.a(r102);
        if (r117 == null) goto L56;
        k1.a(r117);
    L56:
        return r118;
    L67:
        HttpURLConnection r119 = r106;
        v.f("hmsSdk", "Chain validation failed,Certificate expired");     // Catch: Throwable -> L97
        n0 r120 = new n0(r105, "");     // Catch: Throwable -> L97
        k1.a(r108);
        k1.a(r102);
        if (r119 == null) goto L72;
        k1.a(r119);
    L72:
        return r120;
    L75:
        HttpURLConnection r121 = r106;
        v.f("hmsSdk", "Certificate has not been verified,Request is restricted!");     // Catch: Throwable -> L97
        n0 r122 = new n0(r105, "");     // Catch: Throwable -> L97
        k1.a(r108);
        k1.a(r102);
        if (r121 == null) goto L80;
        k1.a(r121);
    L80:
        return r122;
    L43:
        HttpURLConnection r123 = r106;
        v.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");     // Catch: Throwable -> L97
        n0 r124 = new n0(r105, "");     // Catch: Throwable -> L97
        k1.a(r108);
        k1.a(r102);
        if (r123 == null) goto L48;
        k1.a(r123);
    L48:
        return r124;
    L28:
        th = th;
    L99:
        r108 = r104;
    L90:
        r108 = 0;
    L82:
        r108 = 0;
    L58:
        r108 = 0;
    L50:
        r108 = 0;
    L66:
        r108 = 0;
    L74:
        r108 = 0;
    L42:
        r108 = 0;
    L38:
        r102 = 0;
    L37:
        r102 = 0;
    L34:
        r102 = 0;
    L33:
        r102 = 0;
    L35:
        r102 = 0;
    L36:
        r102 = 0;
    L32:
        r102 = 0;
    L30:
        th = th;
        r102 = 0;
    L97:
        th = th;
        r106 = null;
        r104 = r103;
    L89:
        r106 = null;
        r102 = 0;
    L81:
        r106 = null;
        r102 = 0;
    L57:
        r106 = null;
        r102 = 0;
    L49:
        r106 = null;
        r102 = 0;
    L65:
        r106 = null;
        r102 = 0;
    L73:
        r106 = null;
        r102 = 0;
    L41:
        r106 = null;
        r102 = 0;
    L39:
        th = th;
        r106 = null;
        r102 = 0;
        goto L99
    L5:
        return new n0(-100, "");
    }

    private static HttpURLConnection a(String r100, int r101, Map<String, String> r102, String r103) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        v.b("hmsSdk", "CreateConnection: invalid urlPath.");
        return null;
    L6:
        HttpURLConnection r104 = (HttpURLConnection) INVOKEVIRTUAL_com_huawei_hms_hatool_w_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));
        a(r104);
        r104.setRequestMethod(r103);
        r104.setConnectTimeout(15000);
        r104.setReadTimeout(15000);
        r104.setDoOutput(true);
        r104.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        r104.setRequestProperty("Content-Length", String.valueOf(r101));
        r104.setRequestProperty("Connection", "close");
        if (r102 != null) goto L9;
    L20:
        return r104;
    L9:
        if (r102.size() < 1) goto L20;
        Iterator<Map.Entry<String, String>> r105 = r102.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L20;
        Map.Entry<String, String> r106 = r105.next();
        String r107 = r106.getKey();
        if (r107 == null) goto L13;
        if (TextUtils.isEmpty(r107) == true) goto L13;
        r104.setRequestProperty(r107, r106.getValue());
        goto L13
    }

    private static void a(HttpURLConnection r100) {
        if ((r100 instanceof HttpsURLConnection) == false) goto L17;
        HttpsURLConnection r101 = (HttpsURLConnection) r100;
        SecureSSLSocketFactory r102 = SecureSSLSocketFactory.getInstance(q0.i());     // Catch: IllegalAccessException -> L7 IOException -> L8 GeneralSecurityException -> L9 KeyStoreException -> L10 NoSuchAlgorithmException -> L11
    L13:
        if (r102 == null) goto L16;
        r101.setSSLSocketFactory(r102);
        r101.setHostnameVerifier(new StrictHostnameVerifier());
        return;
    L16:
        throw new a("No ssl socket factory set");
    L8:
        String r103 = "getSocketFactory(): IO Exception!";
    L12:
        v.f("hmsSdk", r103);
        r102 = null;
    L7:
        r103 = "getSocketFactory(): Illegal Access Exception ";
    L10:
        r103 = "getSocketFactory(): Key Store exception";
    L11:
        r103 = "getSocketFactory(): Algorithm Exception!";
    L9:
        r103 = "getSocketFactory(): General Security Exception";
        goto L12
    }

    private static String b(HttpURLConnection r100) {
        InputStream r101 = null;
        r101 = r100.getInputStream();     // Catch: Throwable -> L6 IOException -> L8
        String r102 = k1.a(r101);     // Catch: Throwable -> L6 IOException -> L8
        k1.a(r101);
        return r102;
    L6:
        th = move-exception;
        k1.a(r101);
        throw th;
    L10:
        v.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + r100.getResponseCode());     // Catch: Throwable -> L6
        k1.a(r101);
        return "";
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_huawei_hms_hatool_w_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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
}
