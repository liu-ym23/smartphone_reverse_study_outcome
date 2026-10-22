package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f199774a = null;

    public q() {
    }

    static {
        f199774a = new String[]{"GET", "POST"};
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

    public static d84.a b(int r100, String r101, HashMap<String, String> r102, byte[] r110) throws RangersHttpException {
        int r103 = t.f199790a;
        d84.a r104 = null;
        BufferedReader r105 = null;
        r104 = null;
        r104 = null;
        HttpURLConnection r106 = (HttpURLConnection) a(new URL(r101));     // Catch: Throwable -> L59
        if (r100 != 0) goto L7;
        r106.setDoOutput(false);     // Catch: Throwable -> L59
    L10:
        r106.setRequestMethod(f199774a[r100]);     // Catch: Throwable -> L59
        if (r102 != null) goto L13;
    L23:
        r106.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L59
        if (r110 != null) goto L26;
    L29:
        DataOutputStream r107 = null;
    L30:
        int r108 = r106.getResponseCode();     // Catch: Throwable -> L57
        if (r108 != 200) goto L56;
        if (r106.getContentLength() >= 10240) goto L46;
        InputStream r109 = r106.getInputStream();     // Catch: Throwable -> L57
        if (DownloadHelper.GZIP.equalsIgnoreCase(r106.getContentEncoding()) == false) goto L37;
        BufferedReader r111 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r109)));     // Catch: Throwable -> L57
    L95:
        StringBuilder r112 = new StringBuilder(r109.available());     // Catch: Throwable -> L44
    L39:
        String r113 = r111.readLine();     // Catch: Throwable -> L44
        if (r113 == null) goto L42;
        r112.append(r113);     // Catch: Throwable -> L44
        r112.append("\n");     // Catch: Throwable -> L44
        goto L39
    L42:
        JSONObject r114 = new JSONObject(r112.toString());     // Catch: Throwable -> L44
        r114.put("HttpCode", 200);     // Catch: Throwable -> L44
        r114.put("Set-Cookie", r106.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L44
        d84.a r115 = new d84.a(r101, r108, i84.j.b(r106.getHeaderFields()), r114.toString());     // Catch: Throwable -> L44
        r105 = r111;
    L48:
        if (r107 != null) goto L93;
    L52:
        if (r105 != null) goto L86;
    L54:
        r104 = r115;
    L69:
        int r116 = t.f199790a;
        return r104;
    L86:
        r105.close();     // Catch: IOException -> L81
        goto L54
    L93:
        r107.close();     // Catch: IOException -> L51
    L44:
        RangersHttpException th10 = th;
    L90:
        t.e(th10);     // Catch: Throwable -> L73
        if ((th10 instanceof RangersHttpException) == true) goto L72;
        if (r107 != null) goto L84;
    L67:
        if (r111 == null) goto L69;
        r111.close();     // Catch: IOException -> L82
        goto L69
    L84:
        r107.close();     // Catch: IOException -> L66
        goto L67
    L72:
        throw th10;     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        if (r107 != null) goto L101;
    L78:
        if (r111 == null) goto L111;
        r111.close();     // Catch: IOException -> L83
        throw th;
    L112:
        throw th;
    L111:
        throw th;
    L101:
        r107.close();     // Catch: IOException -> L77
        goto L78
    L37:
        r111 = new BufferedReader(new InputStreamReader(r109));     // Catch: Throwable -> L57
        goto L95
    L46:
        t.e(null);     // Catch: Throwable -> L57
        r115 = null;
        goto L48
    L56:
        throw new RangersHttpException(r108, r106.getResponseMessage());     // Catch: Throwable -> L57
    L26:
        if (r110.length <= 0) goto L29;
        r107 = new DataOutputStream(r106.getOutputStream());     // Catch: Throwable -> L59
        r107.write(r110);     // Catch: Throwable -> L57
        r107.flush();     // Catch: Throwable -> L57
        r107.close();     // Catch: Throwable -> L57
    L57:
        th10 = th;
        r111 = null;
        goto L90
    L13:
        if (r102.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r117 = r102.entrySet().iterator();     // Catch: Throwable -> L59
    L16:
        if (r117.hasNext() == false) goto L23;
        Map.Entry<String, String> r118 = r117.next();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r118.getKey()) == true) goto L22;
        if (TextUtils.isEmpty(r118.getValue()) == true) goto L22;
        r106.addRequestProperty(r118.getKey(), r118.getValue());     // Catch: Throwable -> L59
    L22:
        t.e(null);     // Catch: Throwable -> L59
        goto L16
    L7:
        if (r100 != 1) goto L9;
        r106.setDoOutput(true);     // Catch: Throwable -> L59
        goto L10
    L9:
        t.e(null);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        th10 = th;
        r107 = null;
        r111 = null;
        goto L90
    }
}
