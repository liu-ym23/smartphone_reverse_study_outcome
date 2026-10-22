package com.xiaomi.push.service;

import android.content.Context;
import android.content.pm.PackageInstaller;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f464190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f1031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f464191b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f464192a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        byte[] f1032a;

        public a(byte[] r100, int r101) {
            this.f1032a = r100;
            this.f464192a = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f464193a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Bitmap f1033a;

        public b(Bitmap r100, long r101) {
            this.f1033a = r100;
            this.f464193a = r101;
        }
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_xiaomi_push_service_ae_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_xiaomi_push_service_ae_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized void m9344a(Context r110) {
        monitor-enter(ae.class);
        b(r110);     // Catch: Throwable -> L39
        if (f464190a < 62914560) goto L8;
    L42:
        PolarisFileWrapper r100 = new PolarisFileWrapper(a(r110));     // Catch: Throwable -> L35
        if (r100.exists() == true) goto L16;
        com.xiaomi.channel.commonutils.logger.b.m8718a("The pic cache dir do not exists.");     // Catch: Throwable -> L35
        monitor-exit(ae.class);
        return;
    L16:
        File[] r111 = r100.listFiles();     // Catch: Throwable -> L35
        if (r111 == null) goto L33;
        a(r111);     // Catch: Throwable -> L35
        long r101 = f464190a;     // Catch: Throwable -> L35
        int r102 = r111.length - 1;     // Catch: Throwable -> L35
    L20:
        if (r102 < 0) goto L31;
        File r103 = r111[r102];     // Catch: Throwable -> L35
        if (r103 == null) goto L30;
        if (r101 <= 31457280) goto L26;
    L29:
        r101 = r101 - r103.length();     // Catch: Throwable -> L35
        r103.delete();     // Catch: Throwable -> L35
        goto L30
    L26:
        if ((System.currentTimeMillis() - r103.lastModified()) > 864000000) goto L29;
        long r104 = r103.lastModified();     // Catch: Throwable -> L35
    L32:
        f464190a = Math.max(r101, 0);     // Catch: Throwable -> L35
        f464191b = r104;     // Catch: Throwable -> L35
    L37:
        monitor-exit(ae.class);
        return;
    L30:
        r102 = r102 - 1;     // Catch: Throwable -> L35
        goto L20
    L31:
        r104 = 0;
        goto L32
    L33:
        com.xiaomi.channel.commonutils.logger.b.m8718a("The pic cache file list is null.");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Clear pic cache error: " + th);     // Catch: Throwable -> L39
        goto L37
    L8:
        if ((System.currentTimeMillis() - f464191b) >= 1209600000) goto L42;
        monitor-exit(ae.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    private static synchronized void b(Context r110) {
        monitor-enter(ae.class);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (f1031a == false) goto L9;
        monitor-exit(ae.class);
        return;
    L9:
        f464190a = 0;     // Catch: Throwable -> L37
        f464191b = 0;     // Catch: Throwable -> L37
        PolarisFileWrapper r100 = new PolarisFileWrapper(a(r110));     // Catch: Throwable -> L28
        if (r100.exists() == true) goto L16;
        f1031a = true;     // Catch: Throwable -> L37
        com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");     // Catch: Throwable -> L37
        monitor-exit(ae.class);
        return;
    L16:
        File[] r111 = r100.listFiles();     // Catch: Throwable -> L28
        if (r111 == null) goto L25;
        int r101 = r111.length;     // Catch: Throwable -> L28
        int r102 = 0;
    L19:
        if (r102 >= r101) goto L25;
        File r103 = r111[r102];     // Catch: Throwable -> L28
        f464190a += r103.length();     // Catch: Throwable -> L28
        long r104 = f464191b;     // Catch: Throwable -> L28
        if (r104 > 0) goto L23;
        f464191b = r103.lastModified();     // Catch: Throwable -> L28
    L24:
        r102 = r102 + 1;
        goto L19
    L23:
        f464191b = Math.min(r104, r103.lastModified());     // Catch: Throwable -> L28
        goto L24
    L25:
        f1031a = true;     // Catch: Throwable -> L37
        String r112 = "Init pic cache finish.";
    L26:
        com.xiaomi.channel.commonutils.logger.b.b(r112);     // Catch: Throwable -> L37
        monitor-exit(ae.class);
        return;
    L28:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Init pic cache error: " + th);     // Catch: Throwable -> L34
        f1031a = true;     // Catch: Throwable -> L37
        r112 = "Init pic cache finish.";
        goto L26
    L34:
        th = move-exception;
        f1031a = true;     // Catch: Throwable -> L37
        com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    }

    private static void a(File[] r100) {
        if (r100 == null) goto L12;
    L7:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Sort pic cache error: " + th);
        return;
    L4:
        if (r100.length <= 1) goto L13;
        Arrays.sort(r100, new AnonymousClass1());     // Catch: Throwable -> L7
        return;
    L13:
        return;
    }

    private static String a(Context r100) {
        return r100.getCacheDir().getPath() + File.separator + "mipush_icon";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static a a(String r110, boolean r111) {
        PackageInstaller.Session r100 = 0;
        r100 = 0;
        HttpURLConnection r101 = (HttpURLConnection) INVOKEVIRTUAL_com_xiaomi_push_service_ae_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r110));     // Catch: Throwable -> L41 IOException -> L43 SocketTimeoutException -> L49
    L64:
        r101.setConnectTimeout(8000);     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        r101.setReadTimeout(20000);     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        r101.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        r101.connect();     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        int r102 = r101.getContentLength();     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        if (r111 == false) goto L11;
        if (r102 <= 102400) goto L11;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Bitmap size is too big, max size is 102400  contentLen size is " + r102 + " from url " + com.xiaomi.push.ba.a(r110, 3));     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        com.xiaomi.push.v.a(null);
        r101.disconnect();
        return null;
    L11:
        int r103 = r101.getResponseCode();     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        if (r103 == 200) goto L16;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Invalid Http Response Code " + r103 + " received");     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        com.xiaomi.push.v.a(null);
        r101.disconnect();
        return null;
    L16:
        InputStream r104 = r101.getInputStream();     // Catch: Throwable -> L36 IOException -> L38 SocketTimeoutException -> L40
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
        if (r111 == false) goto L20;
        int r112 = 102400;
    L21:
        byte[] r106 = new byte[1024];     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
    L22:
        if (r112 <= 0) goto L27;
        int r107 = r104.read(r106, 0, 1024);     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
        if (r107 == (-1)) goto L27;
        r112 = r112 - r107;     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
        r105.write(r106, 0, r107);     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
    L27:
        if (r112 > 0) goto L31;
        com.xiaomi.channel.commonutils.logger.b.m8718a("length 102400 exhausted.");     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
        a r113 = new a(null, 102400);     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
        com.xiaomi.push.v.a(r104);
        r101.disconnect();
        return r113;
    L31:
        byte[] r114 = r105.toByteArray();     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
        a r108 = new a(r114, r114.length);     // Catch: IOException -> L34 SocketTimeoutException -> L61 Throwable -> L55
        com.xiaomi.push.v.a(r104);
        r101.disconnect();
        return r108;
    L20:
        r112 = 2048000;
    L34:
        e = e;
    L45:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L55
        com.xiaomi.push.v.a(r104);
        if (r101 == null) goto L54;
    L48:
        r101.disconnect();
    L54:
        return null;
    L50:
        com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + r110);     // Catch: Throwable -> L55
        com.xiaomi.push.v.a(r104);
        if (r101 == null) goto L54;
    L40:
        r104 = null;
    L38:
        e = e;
        r104 = null;
    L36:
        th = th;
    L57:
        com.xiaomi.push.v.a(r100);
        if (r101 == null) goto L60;
        r101.disconnect();
    L60:
        throw th;
    L55:
        th = th;
        r100 = "Invalid Http Response Code ";
    L49:
        r104 = null;
        r101 = null;
    L43:
        e = e;
        r104 = null;
        r101 = null;
    L41:
        th = th;
        r101 = null;
        goto L57
    }

    private static synchronized Bitmap b(Context r100, String r101) {
        monitor-enter(ae.class);
        PolarisFileInputStreamWrapper r102 = null;
        Bitmap r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(a(r100), com.xiaomi.push.ba.a(r101));     // Catch: Throwable -> L22
        if (r104.exists() == true) goto L11;
        com.xiaomi.push.v.a(null);     // Catch: Throwable -> L32
        monitor-exit(ae.class);
        return null;
    L11:
        if ((System.currentTimeMillis() - r104.lastModified()) <= 1209600000) goto L16;
        com.xiaomi.channel.commonutils.logger.b.m8718a("The pic cache has expired.");     // Catch: Throwable -> L22
        com.xiaomi.push.v.a(null);     // Catch: Throwable -> L32
        monitor-exit(ae.class);
        return null;
    L16:
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L22
        r103 = BitmapFactory.decodeStream(r105);     // Catch: Throwable -> L20
        r104.setLastModified(System.currentTimeMillis());     // Catch: Throwable -> L20
        com.xiaomi.push.v.a(r105);     // Catch: Throwable -> L32
    L27:
        monitor-exit(ae.class);
        return r103;
    L20:
        th = move-exception;
        Bitmap r106 = r103;
        r102 = r105;
        th = th;
        Bitmap r107 = r106;
    L36:
        com.xiaomi.channel.commonutils.logger.b.d("Load bmp from cache error: " + th);     // Catch: Throwable -> L29
        com.xiaomi.push.v.a(r102);     // Catch: Throwable -> L32
        r103 = r107;
        goto L27
    L29:
        th = move-exception;
        com.xiaomi.push.v.a(r102);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L22:
        th = th;
        r107 = null;
    L32:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap a(Context r100, String r101) {
        Uri r102 = UriProtector.parse(r101);
        ?? r103 = 0;
        r103 = 0;
        InputStream r104 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r102);     // Catch: Throwable -> L14 IOException -> L16
    L29:
        int r105 = a(r100, r104);     // Catch: Throwable -> L10 IOException -> L12
        InputStream r106 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r102);     // Catch: Throwable -> L10 IOException -> L12
        BitmapFactory.Options r107 = new BitmapFactory.Options();     // Catch: IOException -> L8 Throwable -> L21
        r107.inSampleSize = r105;     // Catch: IOException -> L8 Throwable -> L21
        Bitmap r108 = BitmapFactory.decodeStream(r106, null, r107);     // Catch: IOException -> L8 Throwable -> L21
        com.xiaomi.push.v.a(r106);
        com.xiaomi.push.v.a(r104);
        return r108;
    L8:
        e = e;
    L18:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L21
        com.xiaomi.push.v.a(r106);
        com.xiaomi.push.v.a(r104);
        return null;
    L12:
        e = e;
        r106 = null;
    L10:
        th = th;
    L23:
        com.xiaomi.push.v.a(r103);
        com.xiaomi.push.v.a(r104);
        throw th;
    L21:
        th = th;
        r103 = r100;
    L16:
        e = e;
        r106 = null;
        r104 = null;
    L14:
        th = th;
        r104 = null;
        goto L23
    }

    private static int a(Context r100, InputStream r101) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r101, null, r102);
        if (r102.outWidth != (-1)) goto L5;
    L14:
        com.xiaomi.channel.commonutils.logger.b.m8718a("decode dimension failed for bitmap.");
        return 1;
    L5:
        if (r102.outHeight == (-1)) goto L14;
        int r103 = Math.round((INVOKEVIRTUAL_com_xiaomi_push_service_ae_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).densityDpi / 160.0f) * 48.0f);
        int r104 = r102.outWidth;
        if (r104 <= r103) goto L13;
        int r105 = r102.outHeight;
        if (r105 <= r103) goto L13;
        return Math.min(r104 / r103, r105 / r103);
    L13:
        return 1;
    }

    private static void a(Context r100, byte[] r101, String r102) {
        if (r101 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("cannot save small icon cause bitmap is null");
        return;
    L6:
        m9344a(r100);
        BufferedOutputStream r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(a(r100));     // Catch: Throwable -> L26 Exception -> L28
        if (r104.exists() == true) goto L10;
        r104.mkdirs();     // Catch: Throwable -> L26 Exception -> L28
    L10:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, com.xiaomi.push.ba.a(r102));     // Catch: Throwable -> L26 Exception -> L28
        if (r105.exists() == true) goto L13;
        r105.createNewFile();     // Catch: Throwable -> L26 Exception -> L28
    L13:
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L26 Exception -> L28
        BufferedOutputStream r107 = new BufferedOutputStream(r106);     // Catch: Exception -> L24 Throwable -> L34
        r107.write(r101);     // Catch: Throwable -> L20 Exception -> L22
        r107.flush();     // Catch: Throwable -> L20 Exception -> L22
        f464190a += r105.length();     // Catch: Throwable -> L20 Exception -> L22
        long r108 = f464191b;     // Catch: Throwable -> L20 Exception -> L22
        if (r108 > 0) goto L18;
        f464191b = r105.lastModified();     // Catch: Throwable -> L20 Exception -> L22
    L19:
        com.xiaomi.push.v.a(r107);
    L32:
        com.xiaomi.push.v.a(r106);
        return;
    L18:
        f464191b = Math.min(r108, r105.lastModified());     // Catch: Throwable -> L20 Exception -> L22
    L22:
        e = e;
        r103 = r107;
    L30:
        com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);     // Catch: Throwable -> L34
        com.xiaomi.push.v.a(r103);
    L20:
        th = th;
        r103 = r107;
    L35:
        com.xiaomi.push.v.a(r103);
        com.xiaomi.push.v.a(r106);
        throw th;
    L24:
        e = e;
    L34:
        th = th;
        goto L35
    L28:
        e = e;
        r106 = null;
    L26:
        th = th;
        r106 = null;
        goto L35
    }

    public static b a(Context r100, String r101, boolean r102) {
        ByteArrayInputStream r103 = null;
        b r104 = new b(null, 0);
        Bitmap r105 = b(r100, r101);     // Catch: Throwable -> L26 Exception -> L28
        if (r105 == null) goto L8;
        r104.f1033a = r105;     // Catch: Throwable -> L26 Exception -> L28
        com.xiaomi.push.v.a(null);
        return r104;
    L8:
        a r106 = a(r101, r102);     // Catch: Throwable -> L26 Exception -> L28
        if (r106 != null) goto L12;
        com.xiaomi.push.v.a(null);
        return r104;
    L12:
        r104.f464193a = r106.f464192a;     // Catch: Throwable -> L26 Exception -> L28
        byte[] r107 = r106.f1032a;     // Catch: Throwable -> L26 Exception -> L28
        if (r107 != null) goto L15;
    L24:
        a(r100, r106.f1032a, r101);     // Catch: Throwable -> L26 Exception -> L28
    L30:
        com.xiaomi.push.v.a(r103);
        return r104;
    L15:
        if (r102 == false) goto L23;
        ByteArrayInputStream r108 = new ByteArrayInputStream(r107);     // Catch: Throwable -> L26 Exception -> L28
        int r109 = a(r100, r108);     // Catch: Throwable -> L19 Exception -> L21
        BitmapFactory.Options r110 = new BitmapFactory.Options();     // Catch: Throwable -> L19 Exception -> L21
        r110.inSampleSize = r109;     // Catch: Throwable -> L19 Exception -> L21
        r104.f1033a = BitmapFactory.decodeByteArray(r107, 0, r107.length, r110);     // Catch: Throwable -> L19 Exception -> L21
        r103 = r108;
        goto L24
    L21:
        e = e;
        r103 = r108;
    L29:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L26
    L19:
        th = th;
        r103 = r108;
    L32:
        com.xiaomi.push.v.a(r103);
        throw th;
    L23:
        r104.f1033a = BitmapFactory.decodeByteArray(r107, 0, r107.length);     // Catch: Throwable -> L26 Exception -> L28
    L26:
        th = th;
    L28:
        e = e;
        goto L29
    }
}
