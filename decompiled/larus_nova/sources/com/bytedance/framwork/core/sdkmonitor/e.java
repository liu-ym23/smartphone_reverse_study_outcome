package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
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

    public static boolean d(Context r100) {
        if (r100 != null) goto L14;
        return false;
    L14:
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r101 == null) goto L16;
        if (r101.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static byte[] e(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[8192];
    L3:
        int r103 = r100.read(r102);
        if ((-1) == r103) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    L6:
        r100.close();
        return r101.toByteArray();
    }

    public static byte[] b(byte[] r100, Map<String, String> r101) throws IOException {
        if (r100.length <= 128) goto L13;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r103 = new GZIPOutputStream(r102);
        r103.write(r100);     // Catch: Throwable -> L7 IOException -> L9
        r103.close();
        byte[] r104 = r102.toByteArray();
        ((HashMap) r101).put("Content-Encoding", DownloadHelper.GZIP);
        return r104;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r103.close();
        throw th;
    L13:
        return r100;
    }

    public static ff7.b c(String r100, byte[] r101, boolean r102) throws Throwable {
        InputStream r103 = null;
        LinkedList r104 = new LinkedList();     // Catch: Throwable -> L65
        if (r102 == false) goto L6;
        URL r105 = new URL(ay5.a.f(r100, r104));     // Catch: Throwable -> L65
    L7:
        HttpURLConnection r106 = (HttpURLConnection) a(r105);     // Catch: Throwable -> L65
        if (r102 == true) goto L79;
    L20:
        r106.setDoOutput(true);     // Catch: Throwable -> L18
        r106.setRequestProperty("Content-Type", "application/json; charset=utf-8");     // Catch: Throwable -> L18
        r106.setRequestProperty("Content-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L18
        r106.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L18
        r106.setRequestMethod("POST");     // Catch: Throwable -> L18
        if (r101 != null) goto L23;
    L33:
        int r107 = r106.getResponseCode();     // Catch: Throwable -> L18
        if (r107 != 200) goto L64;
        InputStream r108 = r106.getInputStream();     // Catch: Throwable -> L18
        String r109 = r106.getContentEncoding();     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r109) == false) goto L39;
    L48:
        byte[] r110 = e(r108);     // Catch: Throwable -> L61
    L49:
        Map<String, List<String>> r111 = r106.getHeaderFields();     // Catch: Throwable -> L61
        HashMap r112 = new HashMap();     // Catch: Throwable -> L61
        Iterator<Map.Entry<String, List<String>>> r113 = r111.entrySet().iterator();     // Catch: Throwable -> L61
    L51:
        if (r113.hasNext() == false) goto L57;
        Map.Entry<String, List<String>> r114 = r113.next();     // Catch: Throwable -> L61
        String r115 = r114.getKey();     // Catch: Throwable -> L61
        List<String> r116 = r114.getValue();     // Catch: Throwable -> L61
        if (r116 == null) goto L51;
        if (hy5.b.a(r116) == true) goto L51;
        r112.put(r115, r116.get(0));     // Catch: Throwable -> L61
        goto L51
    L57:
        ff7.b r117 = new ff7.b(r107, r112, r110);     // Catch: Throwable -> L61
        xu3.c.a(r108);
        r106.disconnect();     // Catch: Exception -> L73
    L60:
        return r117;
    L39:
        if (r109.equalsIgnoreCase(DownloadHelper.GZIP) == false) goto L48;
        GZIPInputStream r118 = new GZIPInputStream(r108);     // Catch: Throwable -> L45
        r110 = e(r118);     // Catch: Throwable -> L43
        xu3.c.a(r118);     // Catch: Throwable -> L61
    L43:
        th = th;
        r103 = r118;
    L46:
        xu3.c.a(r103);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L45:
        th = th;
    L61:
        Throwable th10 = th;
        r103 = r108;
    L89:
        throw th10;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        xu3.c.a(r103);
        if (r106 != null) goto L77;
    L72:
        throw th;
    L77:
        r106.disconnect();     // Catch: Exception -> L74
        goto L72
    L64:
        throw new HttpResponseException(r107, r106.getResponseMessage());     // Catch: Throwable -> L18
    L23:
        if (r101.length <= 0) goto L33;
        DataOutputStream r119 = new DataOutputStream(r106.getOutputStream());     // Catch: Throwable -> L29
        r119.write(r101);     // Catch: Throwable -> L27
        r119.flush();     // Catch: Throwable -> L27
        xu3.c.a(r119);     // Catch: Throwable -> L18
    L27:
        th = th;
    L31:
        xu3.c.a(r119);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L29:
        th = th;
        r119 = null;
        goto L31
    L79:
    L18:
        th10 = th;
        goto L89
    L10:
        if (r104.isEmpty() == true) goto L20;
        Iterator r120 = r104.iterator();     // Catch: Throwable -> L18
    L13:
        if (r120.hasNext() == false) goto L20;
        Pair r121 = (Pair) r120.next();     // Catch: Throwable -> L18
        if (r121 == null) goto L13;
        r106.setRequestProperty((String) r121.first, (String) r121.second);     // Catch: Throwable -> L18
        goto L13
    L6:
        r105 = new URL(r100);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L89
    }
}
