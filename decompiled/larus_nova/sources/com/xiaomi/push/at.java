package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<a<au>> f463151a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f463152b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f463153c = null;

    public static class a<T> extends FutureTask<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f463154a;

        public boolean a() {
            if (j.m9295a(q.m9304a()) == false) goto L5;
        L10:
            return true;
        L5:
            if (isDone() == true) goto L7;
        L9:
            return false;
        L7:
            if (Math.abs(SystemClock.elapsedRealtime() - this.f463154a) <= 1800000) goto L9;
            goto L9
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f463154a = SystemClock.elapsedRealtime();
            super.run();
        }

        public a(Callable<T> r100) {
            super(r100);
        }
    }

    public static final class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f463155a;

        public b(InputStream r100) {
            super(r100);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r100, int r101, int r102) {
            if (this.f463155a == true) goto L7;
            int r103 = super.read(r100, r101, r102);
            if (r103 == (-1)) goto L7;
            return r103;
        L7:
            this.f463155a = true;
            return -1;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f463156a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, String> f251a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", new Object[]{Integer.valueOf(this.f463156a), this.f251a.toString()});
        }
    }

    static {
        f463151a = new AtomicReference(a());
        f250a = PatternProtector.compile("([^\\s;]+)(.*)");
        f463152b = PatternProtector.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
        f463153c = PatternProtector.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static au m8812a() {
        AtomicReference<a<au>> r100 = f463151a;
        a<au> r101 = r100.get();
        if (r101 != null) goto L15;
    L12:
        return null;
    L15:
        if (r101.a() == false) goto L8;
        r101 = a();     // Catch: Exception -> L14
        r100.set(r101);     // Catch: Exception -> L14
    L8:
        if (r101.isDone() == true) goto L10;
        r101.run();     // Catch: Exception -> L14
    L10:
        return r101.get();
    }

    public static void b() {
        f463151a.set(a());
    }

    private static a<au> a() {
        return new a(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8818a() {
        b();
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_xiaomi_push_at_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public static String a(Map<String, String> r100) {
        if (r100 != null) goto L5;
    L24:
        return null;
    L5:
        if (r100.size() <= 0) goto L24;
        StringBuffer r101 = new StringBuffer();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L20;
        Map.Entry<String, String> r103 = r102.next();
        if (r103.getKey() == null) goto L8;
        if (r103.getValue() == null) goto L8;
        r101.append(URLEncoder.encode(r103.getKey(), "UTF-8"));     // Catch: UnsupportedEncodingException -> L16
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: UnsupportedEncodingException -> L16
        r101.append(URLEncoder.encode(r103.getValue(), "UTF-8"));     // Catch: UnsupportedEncodingException -> L16
        r101.append("&");     // Catch: UnsupportedEncodingException -> L16
    L16:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Failed to convert from params map to string: " + e);
        com.xiaomi.channel.commonutils.logger.b.m8718a("map: " + r100.toString());
        return null;
    L20:
        if (r101.length() <= 0) goto L23;
        r101 = r101.deleteCharAt(r101.length() - 1);
    L23:
        return r101.toString();
    }

    public static boolean b(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L5;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == true) goto L15;
        return false;
    L15:
        if (c(r100) == false) goto L21;
        return true;
    L21:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        r102 = m8819a(r100);
        goto L13
    L18:
        NetworkCapabilities r103 = r101.getNetworkCapabilities(r101.getActiveNetwork());     // Catch: Exception -> L10
        if (r103 == null) goto L12;
        r102 = r103.hasCapability(16);     // Catch: Exception -> L10
        goto L13
    }

    public static boolean c(Context r100) {
        au r101 = m8812a();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.m8823a() == false) goto L7;
        return true;
    }

    public static boolean d(Context r100) {
        au r101 = m8812a();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (1 != r101.a()) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e(Context r100) {
        au r101 = m8813a(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.a() == 0) goto L9;
        return false;
    L9:
        if (20 != r101.b()) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean f(Context r100) {
        au r101 = m8813a(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.a() == 0) goto L9;
        return false;
    L9:
        if (13 != r101.b()) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean g(Context r100) {
        au r101 = m8813a(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.a() == 0) goto L8;
        return false;
    L8:
        String r102 = r101.m8824b();
        if ("TD-SCDMA".equalsIgnoreCase(r102) == false) goto L11;
    L18:
        return true;
    L11:
        if ("CDMA2000".equalsIgnoreCase(r102) == true) goto L18;
        if ("WCDMA".equalsIgnoreCase(r102) == true) goto L18;
        switch(r101.b()) {
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L17;
        };
    L17:
        return false;
    }

    public static boolean h(Context r100) {
        au r101 = m8813a(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.a() == 0) goto L8;
        return false;
    L8:
        int r102 = r101.b();
        if (r102 != 1) goto L11;
    L19:
        return true;
    L11:
        if (r102 == 2) goto L19;
        if (r102 == 4) goto L19;
        if (r102 == 7) goto L19;
        if (r102 == 11) goto L19;
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Object m8814a(Context r100) {
        if (r100 != null) goto L4;
        r100 = q.m9304a();
    L4:
        ConnectivityManager.NetworkCallback r101 = null;
        if (r100 != null) goto L7;
        return null;
    L7:
        if (j.m9295a(r100) == true) goto L21;
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L13
        NetworkRequest r103 = new NetworkRequest.Builder().build();     // Catch: Throwable -> L13
        ConnectivityManager.NetworkCallback r104 = new AnonymousClass1();     // Catch: Throwable -> L13
        r102.registerNetworkCallback(r103, r104);     // Catch: Throwable -> L11
        return r104;
    L11:
        th = th;
        r101 = r104;
    L14:
        com.xiaomi.channel.commonutils.logger.b.m8718a("exception occurred in adding network callback :" + th);
        return r101;
    L13:
        th = th;
        goto L14
    L21:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m8815a(Context r100) {
        if (d(r100) == false) goto L6;
        return "wifi";
    L6:
        au r101 = m8812a();
        if (r101 != null) goto L11;
        return "";
    L11:
        return (r101.m8822a() + "-" + r101.m8824b()).toLowerCase();
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        new String();
        return String.format("%s&key=%s", new Object[]{r100, az.a(String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[]{r100}))});
    L6:
        return null;
    }

    public static int a(Context r100) {
        au r101 = m8812a();
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8819a(Context r100) {
        if (a(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static URL m8817a(String r100) {
        return new URL(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static au m8813a(Context r100) {
        return m8812a();
    }

    public static void a(Context r100, Object r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L14;
    L8:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("exception occurred in removing network callback :" + th);
        return;
    L5:
        if ((r101 instanceof ConnectivityManager.NetworkCallback) == false) goto L15;
        ((ConnectivityManager) r100.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) r101);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L14:
        return;
    }

    public static String a(Context r100, URL r101) {
        return a(r100, r101, false, null, "UTF-8", null);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m8816a(Context r100, URL r101) {
        return (HttpURLConnection) INVOKEVIRTUAL_com_xiaomi_push_at_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101);
    }

    public static ar a(Context r100, String r101, Map<String, String> r102) {
        return a(r100, r101, "POST", null, a(r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String r100, Map<String, String> r101, File r102, String r110) {
        if (r102.exists() == true) goto L5;
        return null;
    L5:
        String r103 = r102.getName();
        HttpURLConnection r104 = (HttpURLConnection) INVOKEVIRTUAL_com_xiaomi_push_at_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));     // Catch: Throwable -> L35 IOException -> L39
        r104.setReadTimeout(15000);     // Catch: Throwable -> L35 IOException -> L39
        r104.setConnectTimeout(10000);     // Catch: Throwable -> L35 IOException -> L39
        r104.setDoInput(true);     // Catch: Throwable -> L35 IOException -> L39
        r104.setDoOutput(true);     // Catch: Throwable -> L35 IOException -> L39
        r104.setUseCaches(false);     // Catch: Throwable -> L35 IOException -> L39
        r104.setRequestMethod("POST");     // Catch: Throwable -> L35 IOException -> L39
        r104.setRequestProperty("Connection", HTTP.KEEP_ALIVE);     // Catch: Throwable -> L35 IOException -> L39
        r104.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");     // Catch: Throwable -> L35 IOException -> L39
        if (r101 == null) goto L12;
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();     // Catch: Throwable -> L35 IOException -> L39
    L10:
        if (r105.hasNext() == false) goto L12;
        Map.Entry<String, String> r106 = r105.next();     // Catch: Throwable -> L35 IOException -> L39
        r104.setRequestProperty(r106.getKey(), r106.getValue());     // Catch: Throwable -> L35 IOException -> L39
    L12:
        r104.setFixedLengthStreamingMode(((r103.length() + 77) + ((int) r102.length())) + r110.length());     // Catch: Throwable -> L35 IOException -> L39
        DataOutputStream r107 = new DataOutputStream(r104.getOutputStream());     // Catch: Throwable -> L35 IOException -> L39
        r107.writeBytes("--*****\r\n");     // Catch: Throwable -> L35 IOException -> L39
        r107.writeBytes("Content-Disposition: form-data; name=\"" + r110 + "\";filename=\"" + r102.getName() + "\"\r\n");     // Catch: Throwable -> L35 IOException -> L39
        r107.writeBytes("\r\n");     // Catch: Throwable -> L35 IOException -> L39
        PolarisFileInputStreamWrapper r111 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L35 IOException -> L39
    L47:
        byte[] r108 = new byte[1024];     // Catch: Throwable -> L29 IOException -> L32
    L15:
        int r109 = r111.read(r108);     // Catch: Throwable -> L29 IOException -> L32
        if (r109 == (-1)) goto L18;
        r107.write(r108, 0, r109);     // Catch: Throwable -> L29 IOException -> L32
        r107.flush();     // Catch: Throwable -> L29 IOException -> L32
        goto L15
    L18:
        r107.writeBytes("\r\n");     // Catch: Throwable -> L29 IOException -> L32
        r107.writeBytes(HttpClient.ENDFLAG);     // Catch: Throwable -> L29 IOException -> L32
        r107.writeBytes("*****");     // Catch: Throwable -> L29 IOException -> L32
        r107.writeBytes(HttpClient.ENDFLAG);     // Catch: Throwable -> L29 IOException -> L32
        r107.writeBytes("\r\n");     // Catch: Throwable -> L29 IOException -> L32
        r107.flush();     // Catch: Throwable -> L29 IOException -> L32
        StringBuffer r112 = new StringBuffer();     // Catch: Throwable -> L29 IOException -> L32
        BufferedReader r113 = new BufferedReader(new InputStreamReader(new b(r104.getInputStream())));     // Catch: Throwable -> L29 IOException -> L32
    L50:
        String r114 = r113.readLine();     // Catch: Throwable -> L25 IOException -> L27
        if (r114 == null) goto L22;
        r112.append(r114);     // Catch: Throwable -> L25 IOException -> L27
        goto L50
    L22:
        String r115 = r112.toString();     // Catch: Throwable -> L25 IOException -> L27
        v.a(r111);
        v.a(r113);
        return r115;
    L27:
        e = e;
    L42:
        throw new IOException("IOException:" + e.getClass().getSimpleName());     // Catch: Throwable -> L43
    L25:
        th = th;
    L38:
        throw new IOException(th.getMessage());     // Catch: Throwable -> L43
    L32:
        e = e;
    L29:
        th = th;
    L43:
        th = move-exception;
        v.a(null);
        v.a(r102);
        throw th;
    L39:
        e = e;
    L35:
        th = th;
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ar a(Context r100, String r101, String r102, Map<String, String> r103, String r110) {
        ar r104 = new ar();
        HttpURLConnection r105 = m8816a(r100, m8817a(r101));     // Catch: Throwable -> L44 IOException -> L48
        r105.setConnectTimeout(10000);     // Catch: Throwable -> L44 IOException -> L48
        r105.setReadTimeout(15000);     // Catch: Throwable -> L44 IOException -> L48
        String r106 = r102;
        if (r102 != 0) goto L6;
        r106 = "GET";
    L6:
        r105.setRequestMethod(r106);     // Catch: Throwable -> L44 IOException -> L48
        int r107 = 0;
        if (r103 == null) goto L12;
        boolean r108 = DownloadHelper.GZIP.equalsIgnoreCase(r103.get("Content-Encoding"));     // Catch: Throwable -> L44 IOException -> L48
        Iterator<String> r109 = r103.keySet().iterator();     // Catch: Throwable -> L44 IOException -> L48
    L10:
        if (r109.hasNext() == false) goto L14;
        String r111 = r109.next();     // Catch: Throwable -> L44 IOException -> L48
        r105.setRequestProperty(r111, r103.get(r111));     // Catch: Throwable -> L44 IOException -> L48
    L14:
        if (TextUtils.isEmpty(r110) == true) goto L25;
        r105.setDoOutput(true);     // Catch: Throwable -> L44 IOException -> L48
        byte[] r112 = r110.getBytes();     // Catch: Throwable -> L44 IOException -> L48
        if (r108 == false) goto L18;
        OutputStream r113 = new GZIPOutputStream(r105.getOutputStream());     // Catch: Throwable -> L44 IOException -> L48
    L60:
        r113.write(r112, 0, r112.length);     // Catch: Throwable -> L21 IOException -> L23
        r113.flush();     // Catch: Throwable -> L21 IOException -> L23
        r113.close();     // Catch: Throwable -> L21 IOException -> L23
    L23:
        e = e;
    L51:
        throw new IOException("err while request " + r101 + ":" + e.getClass().getSimpleName());     // Catch: Throwable -> L52
    L21:
        th = th;
    L47:
        throw new IOException(th.getMessage());     // Catch: Throwable -> L52
    L18:
        r113 = r105.getOutputStream();     // Catch: Throwable -> L44 IOException -> L48
    L25:
        r104.f463150a = r105.getResponseCode();     // Catch: Throwable -> L44 IOException -> L48
        com.xiaomi.channel.commonutils.logger.b.m8718a("Http POST Response Code: " + r104.f463150a);     // Catch: Throwable -> L44 IOException -> L48
    L26:
        String r114 = r105.getHeaderFieldKey(r107);     // Catch: Throwable -> L44 IOException -> L48
        String r115 = r105.getHeaderField(r107);     // Catch: Throwable -> L44 IOException -> L48
        if (r114 != null) goto L42;
        if (r115 != null) goto L42;
        BufferedReader r116 = new BufferedReader(new InputStreamReader(new b(r105.getInputStream())));     // Catch: IOException -> L31 Throwable -> L44
    L62:
        String r117 = r116.readLine();     // Catch: Throwable -> L38 IOException -> L40
        StringBuffer r118 = new StringBuffer();     // Catch: Throwable -> L38 IOException -> L40
        String r119 = System.getProperty("line.separator");     // Catch: Throwable -> L38 IOException -> L40
    L33:
        if (r117 == null) goto L35;
        r118.append(r117);     // Catch: Throwable -> L38 IOException -> L40
        r118.append(r119);     // Catch: Throwable -> L38 IOException -> L40
        r117 = r116.readLine();     // Catch: Throwable -> L38 IOException -> L40
        goto L33
    L35:
        r104.f248a = r118.toString();     // Catch: Throwable -> L38 IOException -> L40
        r116.close();     // Catch: Throwable -> L38 IOException -> L40
        v.a(null);
        v.a(null);
        return r104;
    L40:
        e = e;
    L38:
        th = th;
    L31:
        r116 = new BufferedReader(new InputStreamReader(new b(r105.getErrorStream())));     // Catch: Throwable -> L44 IOException -> L48
    L42:
        r104.f249a.put(r114, r115);     // Catch: Throwable -> L44 IOException -> L48
        r107 = (r107 + 1) + 1;
        goto L26
    L12:
        r108 = false;
    L48:
        e = e;
    L44:
        th = th;
    L52:
        th = move-exception;
        v.a(null);
        v.a(r102);
        throw th;
    }

    public static InputStream a(Context r100, URL r101, boolean r102, String r110, String r111) {
        return a(r100, r101, r102, r110, r111, null, null);
    }

    public static String a(Context r100, URL r101, boolean r102, String r103, String r104, String r105) {
        InputStream r106 = a(r100, r101, r102, r103, r105);     // Catch: Throwable -> L12
        StringBuilder r107 = new StringBuilder(1024);     // Catch: Throwable -> L10
        BufferedReader r108 = new BufferedReader(new InputStreamReader(r106, r104));     // Catch: Throwable -> L10
        char[] r109 = new char[4096];     // Catch: Throwable -> L10
    L4:
        int r110 = r108.read(r109);     // Catch: Throwable -> L10
        if ((-1) == r110) goto L8;
        r107.append(r109, 0, r110);     // Catch: Throwable -> L10
        goto L4
    L8:
        v.a(r106);
        return r107.toString();
    L10:
        th = th;
    L14:
        v.a(r106);
        throw th;
    L12:
        th = th;
        r106 = null;
        goto L14
    }

    public static InputStream a(Context r100, URL r101, boolean r102, String r103, String r104, Map<String, String> r105, c r106) {
        if (r100 == null) goto L49;
        if (r101 == null) goto L47;
        if (r102 == true) goto L6;
        URL r107 = new URL(a(r101.toString()));
    L50:
        HttpURLConnection.setFollowRedirects(true);     // Catch: Throwable -> L40 IOException -> L43
        HttpURLConnection r108 = m8816a(r100, r107);     // Catch: Throwable -> L40 IOException -> L43
        r108.setConnectTimeout(10000);     // Catch: Throwable -> L40 IOException -> L43
        r108.setReadTimeout(15000);     // Catch: Throwable -> L40 IOException -> L43
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r108.setRequestProperty("User-Agent", r103);     // Catch: Throwable -> L40 IOException -> L43
    L11:
        if (r104 == null) goto L13;
        r108.setRequestProperty("Cookie", r104);     // Catch: Throwable -> L40 IOException -> L43
    L13:
        if (r105 == null) goto L18;
        Iterator<String> r109 = r105.keySet().iterator();     // Catch: Throwable -> L40 IOException -> L43
    L16:
        if (r109.hasNext() == false) goto L18;
        String r110 = r109.next();     // Catch: Throwable -> L40 IOException -> L43
        r108.setRequestProperty(r110, r105.get(r110));     // Catch: Throwable -> L40 IOException -> L43
    L18:
        if (r106 != null) goto L20;
    L38:
        return new b(r108.getInputStream());
    L20:
        if (r101.getProtocol().equals("http") == false) goto L22;
    L23:
        r106.f463156a = r108.getResponseCode();     // Catch: Throwable -> L40 IOException -> L43
        if (r106.f251a != null) goto L26;
        r106.f251a = new HashMap();     // Catch: Throwable -> L40 IOException -> L43
    L26:
        int r111 = 0;
    L27:
        String r112 = r108.getHeaderFieldKey(r111);     // Catch: Throwable -> L40 IOException -> L43
        String r113 = r108.getHeaderField(r111);     // Catch: Throwable -> L40 IOException -> L43
        if (r112 != null) goto L32;
        if (r113 == null) goto L38;
    L32:
        if (TextUtils.isEmpty(r112) == true) goto L37;
        if (TextUtils.isEmpty(r113) == true) goto L37;
        r106.f251a.put(r112, r113);     // Catch: Throwable -> L40 IOException -> L43
    L37:
        r111 = r111 + 1;     // Catch: Throwable -> L40 IOException -> L43
        goto L27
    L22:
        if (r101.getProtocol().equals("https") == false) goto L38;
    L43:
        e = move-exception;
        throw new IOException("IOException:".concat(e.getClass().getSimpleName()));
    L40:
        th = move-exception;
        throw new IOException(th.getMessage());
    L6:
        r107 = r101;
        goto L50
    L47:
        throw new IllegalArgumentException("url");
    L49:
        throw new IllegalArgumentException(PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
