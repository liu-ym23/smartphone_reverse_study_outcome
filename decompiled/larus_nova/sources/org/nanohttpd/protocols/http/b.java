package org.nanohttpd.protocols.http;

import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.byted.cast.proxy.CastProxyMonitor;
import com.byted.cast.proxy.ErrorCode;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.net.ssl.SSLException;
import org.nanohttpd.protocols.http.request.Method;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;

/* JADX INFO: loaded from: classes42.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NanoHTTPD f526181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final twc.d f526182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OutputStream f526183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BufferedInputStream f526184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f526185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f526186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f526187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Method f526188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, List<String>> f526189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f526190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public rwc.c f526191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f526192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f526193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f526194n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Socket f526195o;

    public final void e() throws IOException {
        Response r100 = null;
        byte[] r101 = new byte[8192];     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        boolean r102 = false;
        this.f526185e = 0;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526186f = 0;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526184d.mark(8192);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        int r103 = this.f526184d.read(r101, 0, 8192);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L59 SSLException -> L61
    L6:
        if (r103 == (-1)) goto L57;
    L7:
        if (r103 <= 0) goto L13;
        int r104 = this.f526186f + r103;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526186f = r104;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        int r105 = f(r101, r104);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526185e = r105;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        if (r105 > 0) goto L13;
        BufferedInputStream r106 = this.f526184d;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        int r107 = this.f526186f;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        r103 = r106.read(r101, r107, 8192 - r107);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L13:
        if (this.f526185e >= this.f526186f) goto L15;
        this.f526184d.reset();     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526184d.skip(this.f526185e);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L15:
        this.f526189i = new HashMap();     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        Map<String, String> r108 = this.f526190j;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        if (r108 != null) goto L18;
        this.f526190j = new HashMap();     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L19:
        BufferedReader r109 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r101, 0, this.f526186f)));     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        HashMap r110 = new HashMap();     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        c(r109, r110, this.f526189i, this.f526190j);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        String r111 = this.f526192l;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        if (r111 == null) goto L28;
        ((HashMap) this.f526190j).put("remote-addr", r111);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        ((HashMap) this.f526190j).put("http-client-ip", this.f526192l);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L28:
        Method r112 = Method.lookup((String) r110.get(e.f25671s));     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526188h = r112;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        if (r112 == null) goto L56;
        this.f526187g = (String) r110.get("uri");     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526191k = new rwc.c(this.f526190j);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        String r113 = (String) ((HashMap) this.f526190j).get(WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        if ("HTTP/1.1".equals(this.f526193m) == false) goto L36;
        if (r113 != null) goto L34;
    L35:
        r102 = true;
        goto L36
    L34:
        if (r113.matches("(?i).*close.*") == false) goto L35;
    L36:
        r100 = this.f526181a.handle(this);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        if (r100 == null) goto L54;
        if ((r100 instanceof ds7.a) == true) goto L47;
        String r114 = (String) ((HashMap) this.f526190j).get("accept-encoding");     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        this.f526191k.a(r100);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        r100.q(this.f526188h);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        if (r114 != null) goto L44;
    L45:
        r100.r();     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L46:
        r100.p(r102);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        r100.k(this.f526183c);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        goto L47
    L44:
        if (r114.contains(DownloadHelper.GZIP) == true) goto L46;
    L47:
        if (r102 == false) goto L52;
        if (r100.g() == true) goto L52;
    L67:
        NanoHTTPD.safeClose(r100);
        this.f526182b.clear();
        return;
    L52:
        throw new SocketException("NanoHttpd Shutdown");     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L54:
        throw new NanoHTTPD.ResponseException(Status.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L56:
        throw new NanoHTTPD.ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Syntax error. HTTP verb " + ((String) r110.get(e.f25671s)) + " unhandled.");     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L18:
        ((HashMap) r108).clear();     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        goto L19
    L57:
        NanoHTTPD.safeClose(this.f526184d);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        NanoHTTPD.safeClose(this.f526183c);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        throw new SocketException("NanoHttpd Shutdown");     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L61:
        e = move-exception;
        throw e;     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L59:
        NanoHTTPD.safeClose(this.f526184d);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        NanoHTTPD.safeClose(this.f526183c);     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
        throw new SocketException("NanoHttpd Shutdown");     // Catch: Throwable -> L22 NanoHTTPD.ResponseException -> L24 IOException -> L26 SSLException -> L65 SocketTimeoutException -> L69 SocketException -> L72
    L24:
        e = move-exception;
        Response.h(e.getStatus(), "text/plain", e.getMessage()).k(this.f526183c);     // Catch: Throwable -> L22
        NanoHTTPD.safeClose(this.f526183c);     // Catch: Throwable -> L22
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_HTTP_SESSION_RESPONSE_ERROR, "ResponseException: " + e, "request is " + this.f526194n);     // Catch: Throwable -> L22
    L69:
        e = move-exception;
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_HTTP_SESSION_SOCKET_TIMEOUT_ERROR, "SocketTimeoutException: " + e, "request is " + this.f526194n);     // Catch: Throwable -> L22
        throw e;     // Catch: Throwable -> L22
    L65:
        e = move-exception;
        Response.h(Status.INTERNAL_ERROR, "text/plain", "SSL PROTOCOL FAILURE: " + e.getMessage()).k(this.f526183c);     // Catch: Throwable -> L22
        NanoHTTPD.safeClose(this.f526183c);     // Catch: Throwable -> L22
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_HTTP_SESSION_SSL_ERROR, "SSLException: " + e, "request is " + this.f526194n);     // Catch: Throwable -> L22
    L72:
        e = move-exception;
        if ("NanoHttpd Shutdown".equals(e.getMessage()) == true) goto L76;
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_HTTP_SESSION_SOCKET_ERROR, "SocketException: " + e, "request is " + this.f526194n);     // Catch: Throwable -> L22
    L76:
        throw e;     // Catch: Throwable -> L22
    L26:
        e = move-exception;
        Response.h(Status.INTERNAL_ERROR, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e.getMessage()).k(this.f526183c);     // Catch: Throwable -> L22
        NanoHTTPD.safeClose(this.f526183c);     // Catch: Throwable -> L22
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_HTTP_SESSION_IO_ERROR, "IOException: " + e, "request is " + this.f526194n);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        NanoHTTPD.safeClose(null);
        this.f526182b.clear();
        throw th;
    }

    @Override // org.nanohttpd.protocols.http.c
    public final String a() {
        return this.f526194n;
    }

    @Override // org.nanohttpd.protocols.http.c
    public final Socket b() {
        return this.f526195o;
    }

    @Override // org.nanohttpd.protocols.http.c
    public final Map<String, String> getHeaders() {
        return this.f526190j;
    }

    @Override // org.nanohttpd.protocols.http.c
    public final String getUri() {
        return this.f526187g;
    }

    public static void d(String r100, Map r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        StringTokenizer r102 = new StringTokenizer(r100, "&");
    L6:
        if (r102.hasMoreTokens() == false) goto L15;
        String r103 = r102.nextToken();
        int r104 = r103.indexOf(61);
        if (r104 < 0) goto L10;
        String r105 = NanoHTTPD.decodePercent(r103.substring(0, r104)).trim();
        String r106 = NanoHTTPD.decodePercent(r103.substring(r104 + 1));
    L11:
        List r107 = (List) r101.get(r105);
        if (r107 != null) goto L14;
        r107 = new ArrayList();
        r101.put(r105, r107);
    L14:
        r107.add(r106);
        goto L6
    L10:
        r105 = NanoHTTPD.decodePercent(r103).trim();
        r106 = "";
        goto L11
    }

    public static int f(byte[] r100, int r101) {
        int r102 = 0;
    L3:
        int r103 = r102 + 1;
        if (r103 >= r101) goto L23;
        byte r104 = r100[r102];
        if (r104 == 13) goto L8;
    L17:
        if (r104 != 10) goto L22;
        if (r100[r103] != 10) goto L22;
        return r102 + 2;
    L22:
        r102 = r103;
        goto L3
    L8:
        if (r100[r103] != 10) goto L17;
        int r105 = r102 + 3;
        if (r105 >= r101) goto L17;
        if (r100[r102 + 2] != 13) goto L17;
        if (r100[r105] != 10) goto L17;
        return r102 + 4;
    L23:
        return 0;
    }

    public final void c(BufferedReader r100, Map<String, String> r101, Map<String, List<String>> r110, Map<String, String> r111) throws NanoHTTPD.ResponseException {
        String r102 = r100.readLine();     // Catch: IOException -> L45
        if (r102 != null) goto L5;
        return;
    L5:
        StringBuilder r103 = new StringBuilder();     // Catch: IOException -> L45
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r103.append(r102);     // Catch: IOException -> L45
        r103.append("\n");     // Catch: IOException -> L45
    L9:
        StringTokenizer r104 = new StringTokenizer(r102);     // Catch: IOException -> L45
        if (r104.hasMoreTokens() == true) goto L18;
        String r105 = r100.readLine();     // Catch: IOException -> L45
    L12:
        if (r105 == null) goto L16;
        if (r105.trim().isEmpty() == true) goto L16;
        r103.append(r105);     // Catch: IOException -> L45
        r103.append("\n");     // Catch: IOException -> L45
        r105 = r100.readLine();     // Catch: IOException -> L45
    L16:
        this.f526194n = r103.toString();     // Catch: IOException -> L45
        throw new NanoHTTPD.ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");     // Catch: IOException -> L45
    L18:
        HashMap r106 = (HashMap) r101;     // Catch: IOException -> L45
        r106.put(e.f25671s, r104.nextToken());     // Catch: IOException -> L45
        if (r104.hasMoreTokens() == true) goto L27;
        String r107 = r100.readLine();     // Catch: IOException -> L45
    L21:
        if (r107 == null) goto L25;
        if (r107.trim().isEmpty() == true) goto L25;
        r103.append(r107);     // Catch: IOException -> L45
        r103.append("\n");     // Catch: IOException -> L45
        r107 = r100.readLine();     // Catch: IOException -> L45
    L25:
        this.f526194n = r103.toString();     // Catch: IOException -> L45
        throw new NanoHTTPD.ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");     // Catch: IOException -> L45
    L27:
        String r108 = r104.nextToken();     // Catch: IOException -> L45
        NanoHTTPD.decodePercent(r108);     // Catch: IOException -> L45
        int r109 = r108.indexOf(63);     // Catch: IOException -> L45
        if (r109 < 0) goto L30;
        d(r108.substring(r109 + 1), r110);     // Catch: IOException -> L45
        String r112 = NanoHTTPD.decodePercent(r108.substring(0, r109));     // Catch: IOException -> L45
    L32:
        if (r104.hasMoreTokens() == false) goto L34;
        this.f526193m = r104.nextToken();     // Catch: IOException -> L45
    L35:
        String r113 = r100.readLine();     // Catch: IOException -> L45
    L36:
        if (r113 == null) goto L43;
        if (r113.trim().isEmpty() == true) goto L43;
        r103.append(r113);     // Catch: IOException -> L45
        r103.append("\n");     // Catch: IOException -> L45
        int r114 = r113.indexOf(58);     // Catch: IOException -> L45
        if (r114 < 0) goto L42;
        r111.put(r113.substring(0, r114).trim().toLowerCase(Locale.US), r113.substring(r114 + 1).trim());     // Catch: IOException -> L45
    L42:
        r113 = r100.readLine();     // Catch: IOException -> L45
    L43:
        r106.put("uri", r112);     // Catch: IOException -> L45
        this.f526194n = r103.toString();     // Catch: IOException -> L45
        return;
    L34:
        this.f526193m = "HTTP/1.1";     // Catch: IOException -> L45
        NanoHTTPD.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");     // Catch: IOException -> L45
        goto L35
    L30:
        r112 = NanoHTTPD.decodePercent(r108);     // Catch: IOException -> L45
    L45:
        e = move-exception;
        throw new NanoHTTPD.ResponseException(Status.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
    }

    public b(NanoHTTPD r100, twc.a r101, InputStream r102, OutputStream r103, InetAddress r104, Socket r105) {
        this.f526181a = r100;
        this.f526182b = r101;
        this.f526184d = new BufferedInputStream(r102, 8192);
        this.f526183c = r103;
        if (r104 != null) goto L5;
    L12:
        this.f526190j = new HashMap();
        this.f526195o = r105;
        return;
    L5:
        if (r104.isLoopbackAddress() == false) goto L7;
    L10:
        String r106 = "127.0.0.1";
    L11:
        this.f526192l = r106;
        goto L12
    L7:
        if (r104.isAnyLocalAddress() == true) goto L10;
        r106 = r104.getHostAddress().toString();
        goto L11
    }
}
