package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.crash.util.p;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CrashUploader {

    public static final enum CompressType extends Enum<CompressType> {
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CompressType[] f203348a = null;
        final int nativeInt;

        static {
            CompressType r100 = new CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CompressType r101 = new CompressType("GZIP", 1, 1);
            GZIP = r101;
            CompressType r102 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r102;
            f203348a = new CompressType[]{r100, r101, r102};
        }

        public static CompressType[] values() {
            return (CompressType[]) f203348a.clone();
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) r27.a.a(CompressType.class, r100);
        }

        public CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static byte[] c(HttpURLConnection r100) {
        InputStream r101 = null;
        InputStream r102 = r100.getInputStream();     // Catch: Throwable -> L20 Exception -> L23
    L33:
    L18:
        th = th;
        r101 = r102;
    L21:
        com.bytedance.crash.util.g.a(r101);
        throw th;
    L5:
        if (DownloadHelper.GZIP.equalsIgnoreCase(r100.getContentEncoding()) == true) goto L27;
        byte[] r103 = d.a(r102);     // Catch: Throwable -> L18 Exception -> L26
    L16:
        com.bytedance.crash.util.g.a(r102);
        return r103;
    L27:
        GZIPInputStream r104 = new GZIPInputStream(r102);     // Catch: Throwable -> L11
        r103 = d.a(r104);     // Catch: Throwable -> L9
        com.bytedance.crash.util.i.a(r104);     // Catch: Throwable -> L18 Exception -> L26
    L9:
        Throwable th10 = th;
    L13:
        com.bytedance.crash.util.i.a(r104);     // Catch: Throwable -> L18 Exception -> L26
        throw th10;     // Catch: Throwable -> L18 Exception -> L26
    L11:
        th = move-exception;
        th10 = th;
        r104 = null;
    L24:
        com.bytedance.crash.util.g.a(r102);
        return null;
    L23:
        r102 = null;
    L20:
        th = th;
        goto L21
    }

    public static HttpURLConnection d(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return (HttpURLConnection) r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static boolean h(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L10:
        return false;
    L5:
        if (com.bytedance.crash.util.j.g(r101) == true) goto L10;
        return a(r100, r101.toString().getBytes(), CompressType.GZIP, true).a();
    L9:
        boolean r102 = zg4.i.f572087c;
        goto L10
    }

    public static k a(String r110, byte[] r111, CompressType r112, boolean r113) throws IOException {
        if (r110 == null) goto L45;
        if (r111 == null) goto L45;
        boolean r100 = zg4.i.f572087c;
        int r101 = r111.length;
        byte[] r102 = null;
        if (CompressType.GZIP != r112) goto L18;
        if (r101 <= 128) goto L18;
        ByteArrayOutputStream r114 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r103 = new GZIPOutputStream(r114);
        r103.write(r111);     // Catch: Throwable -> L10
        r103.close();
        r111 = r114.toByteArray();
    L12:
        String r115 = DownloadHelper.GZIP;
    L13:
        String r104 = r115;
    L26:
        if (r111 == null) goto L28;
        if (r113 == false) goto L31;
        ((zg4.i.a) zg4.i.f572088d).getClass();
        r102 = EncryptorUtil.b(r111, r111.length);
    L31:
        if (r102 != null) goto L33;
        String r105 = r110;
        byte[] r106 = r111;
    L43:
        return b(r105, r106, r104, "POST", true, r113);
    L33:
        if (TextUtils.isEmpty(new URL(r110).getQuery()) == false) goto L38;
        if (r110.endsWith("?") == true) goto L40;
        r110 = r110.concat("?");
    L40:
        r105 = r110 + "tt_data=a";
        r106 = r102;
        goto L43
    L38:
        if (r110.endsWith("&") == true) goto L40;
        r110 = r110.concat("&");
        goto L40
    L28:
        return new k(202);
    L10:
        boolean r116 = zg4.i.f572087c;     // Catch: Throwable -> L14
        r103.close();
        r111 = null;
    L14:
        th = move-exception;
        r103.close();
        throw th;
    L18:
        if (CompressType.DEFLATER != r112) goto L25;
        if (r101 <= 128) goto L25;
        ByteArrayOutputStream r117 = new ByteArrayOutputStream(8192);
        Deflater r107 = new Deflater();
        r107.setInput(r111);
        r107.finish();
        byte[] r118 = new byte[8192];
    L22:
        if (r107.finished() == true) goto L24;
        r117.write(r118, 0, r107.deflate(r118));
        goto L22
    L24:
        r107.end();
        r111 = r117.toByteArray();
        r115 = "deflate";
    L25:
        r104 = null;
    L45:
        return new k(201);
    }

    public static boolean f(String r100, String r101, String r102, PolarisFileWrapper r103) {
        c r104 = new c(r100, false);     // Catch: IOException -> L15
        r104.e("data", r102, false);     // Catch: IOException -> L15
        r104.e("header", r101, false);     // Catch: IOException -> L15
        r104.b(r103);     // Catch: IOException -> L15
        r104.f("coredump");     // Catch: IOException -> L15
        k r105 = r104.g();     // Catch: Exception -> L11
        JSONObject r106 = r105.f203385c;     // Catch: Exception -> L11
        if (r106 != null) goto L8;
        return false;
    L8:
        if ("success".equals(JSONObjectProtectorUtils.getString(r106, "message")) == true) goto L22;
        r105.toString();     // Catch: Exception -> L11
        boolean r107 = zg4.i.f572087c;     // Catch: Exception -> L11
        return false;
    L22:
        return true;
    L11:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        boolean r108 = zg4.i.f572087c;
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        boolean r109 = zg4.i.f572087c;
        return false;
    }

    public static k g(String r100, String r101, String r102, List<File> r103) {
        p.d("upload crashType " + r100);
        p.d("upload url " + r101);
        Iterator<File> r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        p.d("upload attachments " + r104.next().getAbsolutePath());
        goto L4
    L6:
        boolean r105 = zg4.i.f572087c;
        long r106 = i.b(new URL(r101));     // Catch: IOException -> L27
        if (r106 < 0) goto L10;
        if (r106 <= 0) goto L31;
        return new k(214);
    L31:
        if (TextUtils.isEmpty(new URL(r101).getQuery()) == false) goto L21;
        if (r101.endsWith("?") == true) goto L23;
        r101 = r101.concat("?");     // Catch: Throwable -> L30
    L23:
        r101 = r101 + "have_dump=true&encrypt=true";     // Catch: Throwable -> L30
        goto L25
    L21:
        if (r101.endsWith("&") == true) goto L23;
        r101 = r101.concat("&");     // Catch: Throwable -> L30
    L25:
        c r107 = new c(r101, true);     // Catch: IOException -> L27
        r107.e("json", r102, true);     // Catch: IOException -> L27
        r107.c(r103);     // Catch: IOException -> L27
        r107.f(r100);     // Catch: IOException -> L27
        k r108 = r107.g();     // Catch: IOException -> L27
        p.e("uploadCrashLogWithAttachment:" + r100 + " success");     // Catch: IOException -> L27
        return r108;
    L10:
        return new k(213);
    L27:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        boolean r109 = zg4.i.f572087c;
        return new k(207);
    }

    public static boolean e(String r100, int r101, String r102, String r103, List<String> r104) {
        boolean r105 = zg4.i.f572087c;
        c r106 = new c(r100, false);     // Catch: IOException -> L20
        r106.e("aid", String.valueOf(r101), false);     // Catch: IOException -> L20
        r106.e("device_id", r102, false);     // Catch: IOException -> L20
        r106.e("os", "Android", false);     // Catch: IOException -> L20
        r106.e("process_name", r103, false);     // Catch: IOException -> L20
        Iterator r107 = ((ArrayList) r104).iterator();     // Catch: IOException -> L20
    L6:
        if (r107.hasNext() == false) goto L10;
        PolarisFileWrapper r108 = new PolarisFileWrapper((String) r107.next());     // Catch: IOException -> L20
        if (r108.exists() == false) goto L6;
        HashMap r109 = new HashMap();     // Catch: IOException -> L20
        r109.put("logtype", CloudControlInf.ALOG);     // Catch: IOException -> L20
        r109.put("scene", "npth");     // Catch: IOException -> L20
        r106.d(r108.getName(), r109);     // Catch: IOException -> L20
        r106.a(r108);     // Catch: IOException -> L20
        goto L6
    L10:
        r106.f(CloudControlInf.ALOG);     // Catch: IOException -> L20
        JSONObject r110 = r106.g().f203385c;     // Catch: Exception -> L23
        if (r110 != null) goto L14;
        return false;
    L14:
        if (r110.optInt(LKBaseResponseModel.ERROR_NO_KEY, -1) != 200) goto L19;
        return true;
    L19:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static k b(String r100, byte[] r101, String r110, String r111, boolean r112, boolean r113) {
        p.e("executeRequest:upload:" + r100);
        HttpURLConnection r102 = null;
        DataOutputStream r103 = null;
        SSLContext.getInstance("TLS").init(null, null, null);     // Catch: Throwable -> L50
    L67:
        URL r104 = new URL(r100);     // Catch: Throwable -> L53
        long r105 = i.b(r104);     // Catch: Throwable -> L53
        if (r105 < 0) goto L8;
        if (r105 > 0) goto L11;
        HttpURLConnection r106 = d(r104);     // Catch: Throwable -> L53
        r106.setDoOutput(r112);     // Catch: Throwable -> L41
        if (r113 == false) goto L17;
        r106.setRequestProperty("Content-Type", DownloadNetworkFactory.ContentType.TT_DATA);     // Catch: Throwable -> L41
    L18:
        if (r110 == null) goto L20;
        r106.setRequestProperty("Content-Encoding", r110);     // Catch: Throwable -> L41
    L20:
        r106.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L41
        r106.setRequestMethod(r111);     // Catch: Throwable -> L41
        if (r101 != null) goto L23;
    L32:
        int r107 = r106.getResponseCode();     // Catch: Throwable -> L41
        k r114 = new k(0);     // Catch: Throwable -> L41
        r114.f203384b = r107;     // Catch: Throwable -> L41
        r114.f203387e = r106.getHeaderFields();     // Catch: Throwable -> L41
        if (r107 != 200) goto L38;
        byte[] r108 = c(r106);     // Catch: Throwable -> L41
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L41
        r115 = new JSONObject(new String(r108));     // Catch: Throwable -> L51
    L37:
        p.e("uploadEvent:upload:" + r115);     // Catch: Throwable -> L41
        r114.b(r115);     // Catch: Throwable -> L41
        r114.f203386d = r108;     // Catch: Throwable -> L41
        i.s(r104, r114);     // Catch: Throwable -> L41
    L70:
        r106.disconnect();     // Catch: Exception -> L52
    L40:
        return r114;
    L38:
        i.s(r104, r114);     // Catch: Throwable -> L41
        r114.f203383a = 207;     // Catch: Throwable -> L41
        goto L70
    L23:
        if (r101.length <= 0) goto L32;
        DataOutputStream r116 = new DataOutputStream(r106.getOutputStream());     // Catch: Throwable -> L29
        r116.write(r101);     // Catch: Throwable -> L27
        r116.flush();     // Catch: Throwable -> L27
        com.bytedance.crash.util.g.a(r116);     // Catch: Throwable -> L41
    L27:
        th = th;
        r103 = r116;
    L30:
        com.bytedance.crash.util.g.a(r103);     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L29:
        th = th;
        goto L30
    L17:
        r106.setRequestProperty("Content-Type", "application/json; charset=utf-8");     // Catch: Throwable -> L41
    L41:
        r102 = r106;
        goto L60
    L11:
        return new k(214);
    L8:
        return new k(213);
    L60:
        k r109 = new k(207);     // Catch: Throwable -> L46
        if (r102 != null) goto L56;
    L45:
        return r109;
    L56:
        r102.disconnect();     // Catch: Exception -> L54
    L46:
        th = move-exception;
        if (r102 != null) goto L68;
    L49:
        throw th;
    L68:
        r102.disconnect();     // Catch: Exception -> L55
        goto L49
    }
}
