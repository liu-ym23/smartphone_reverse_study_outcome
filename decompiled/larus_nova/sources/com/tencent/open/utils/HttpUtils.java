package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IRequestListener;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class HttpUtils {

    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";
        public final int statusCode;

        public HttpStatusException(int r100) {
            super(ERROR_INFO + r100);
            this.statusCode = r100;
        }

        public HttpStatusException(String r100) {
            super(r100);
            this.statusCode = -1;
        }
    }

    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String r100) {
            super(r100);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f461826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f461827b;

        private a(String r100, int r101) {
            this.f461826a = r100;
            this.f461827b = r101;
        }

        public /* synthetic */ a(String r100, int r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    private HttpUtils() {
    }

    private static Map<String, String> a(Bundle r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
    L25:
        return r101;
    L5:
        if (r100.size() == 0) goto L25;
        Iterator<String> r102 = r100.keySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L25;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof String) == true) goto L16;
        if ((r104 instanceof String[]) == true) goto L16;
        SLog.w("openSDK_LOG.HttpUtils", "parseBundleToMap: the type " + r104.getClass() + " is unsupported");
    L16:
        if ((r104 instanceof String[]) == true) goto L17;
        r101.put(r103, (String) r104);
        goto L9
    L17:
        String[] r105 = (String[]) r104;
        StringBuilder r106 = new StringBuilder();
        int r107 = 0;
    L19:
        if (r107 >= r105.length) goto L23;
        if (r107 == 0) goto L22;
        r106.append(",");
    L22:
        r106.append(r105[r107]);
        r107 = r107 + 1;
        goto L19
    L23:
        r101.put(r103, r106.toString());
        goto L9
    }

    private static Map<String, byte[]> b(Bundle r100) {
        HashMap r101 = new HashMap(0);
        if (r100 != null) goto L5;
    L14:
        return r101;
    L5:
        if (r100.size() == 0) goto L14;
        Iterator<String> r102 = r100.keySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof byte[]) == false) goto L9;
        r101.put(r103, (byte[]) r104);
        goto L9
    }

    public static String encodeUrl(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.size() == 0) goto L21;
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = r100.keySet().iterator();
        boolean r103 = true;
    L8:
        if (r102.hasNext() == false) goto L15;
        String r104 = r102.next();
        if (r103 == false) goto L12;
        r103 = false;
    L13:
        r101.append(URLEncoder.encode(r104));
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(URLEncoder.encode(r100.get(r104)));
        goto L8
    L12:
        r101.append("&");
        goto L13
    L15:
        return r101.toString();
    L21:
        return "";
    }

    public static int getErrorCodeFromException(IOException r100) {
        if ((r100 instanceof CharConversionException) == false) goto L7;
        return -20;
    L7:
        if ((r100 instanceof MalformedInputException) == false) goto L11;
        return -21;
    L11:
        if ((r100 instanceof UnmappableCharacterException) == false) goto L15;
        return -22;
    L15:
        if ((r100 instanceof ClosedChannelException) == false) goto L19;
        return -24;
    L19:
        if ((r100 instanceof EOFException) == false) goto L23;
        return -26;
    L23:
        if ((r100 instanceof FileLockInterruptionException) == false) goto L27;
        return -27;
    L27:
        if ((r100 instanceof FileNotFoundException) == false) goto L31;
        return -28;
    L31:
        if ((r100 instanceof HttpRetryException) == false) goto L35;
        return -29;
    L35:
        if ((r100 instanceof SocketTimeoutException) == false) goto L39;
        return -8;
    L39:
        if ((r100 instanceof InvalidPropertiesFormatException) == false) goto L43;
        return -30;
    L43:
        if ((r100 instanceof MalformedURLException) == false) goto L47;
        return -3;
    L47:
        if ((r100 instanceof InvalidClassException) == false) goto L51;
        return -33;
    L51:
        if ((r100 instanceof InvalidObjectException) == false) goto L55;
        return -34;
    L55:
        if ((r100 instanceof NotActiveException) == false) goto L59;
        return -35;
    L59:
        if ((r100 instanceof NotSerializableException) == false) goto L63;
        return -36;
    L63:
        if ((r100 instanceof OptionalDataException) == false) goto L67;
        return -37;
    L67:
        if ((r100 instanceof StreamCorruptedException) == false) goto L71;
        return -38;
    L71:
        if ((r100 instanceof WriteAbortedException) == false) goto L75;
        return -39;
    L75:
        if ((r100 instanceof ProtocolException) == false) goto L79;
        return -40;
    L79:
        if ((r100 instanceof SSLHandshakeException) == false) goto L83;
        return -41;
    L83:
        if ((r100 instanceof SSLKeyException) == false) goto L87;
        return -42;
    L87:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L91;
        return -43;
    L91:
        if ((r100 instanceof SSLProtocolException) == false) goto L95;
        return -44;
    L95:
        if ((r100 instanceof BindException) == false) goto L99;
        return -45;
    L99:
        if ((r100 instanceof ConnectException) == false) goto L103;
        return -46;
    L103:
        if ((r100 instanceof NoRouteToHostException) == false) goto L107;
        return -47;
    L107:
        if ((r100 instanceof PortUnreachableException) == false) goto L111;
        return -48;
    L111:
        if ((r100 instanceof SyncFailedException) == false) goto L115;
        return -49;
    L115:
        if ((r100 instanceof UTFDataFormatException) == false) goto L119;
        return -50;
    L119:
        if ((r100 instanceof UnknownHostException) == false) goto L123;
        return -51;
    L123:
        if ((r100 instanceof UnknownServiceException) == false) goto L127;
        return -52;
    L127:
        if ((r100 instanceof UnsupportedEncodingException) == false) goto L131;
        return -53;
    L131:
        if ((r100 instanceof ZipException) == false) goto L134;
        return -54;
    L134:
        return -2;
    }

    public static a getProxy(Context r100) {
        AnonymousClass1 r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r102 != null) goto L21;
        return null;
    L21:
        NetworkInfo r103 = r102.getActiveNetworkInfo();     // Catch: Exception -> L10
    L11:
        if (r103 != null) goto L14;
        return null;
    L14:
        if (r103.getType() != 0) goto L20;
        String r104 = b(r100);
        int r105 = a(r100);
        if (TextUtils.isEmpty(r104) == true) goto L20;
        if (r105 < 0) goto L20;
        return new a(r104, r105, r101);
    L20:
        return null;
    L10:
        r103 = null;
        goto L11
    }

    private static int a(Context r100) {
        String r101 = System.getProperty("http.proxyPort");
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L6:
        return -1;
    L9:
        return CastIntegerProtector.parseInt(r101);
    }

    private static String b(Context r100) {
        return System.getProperty("http.proxyHost");
    }

    public static String encodeUrl(Bundle r100) {
        return encodeUrl(a(r100));
    }

    private static com.tencent.open.a.g a(String r100, String r101, Bundle r102) throws IOException {
        if (r102 == null) goto L4;
        Bundle r103 = new Bundle(r102);
    L6:
        if (r101.equalsIgnoreCase("GET") == false) goto L13;
        Map<String, String> r104 = a(r103);
        Bundle r105 = com.tencent.open.log.d.b(r103);
        if (r105 == r103) goto L10;
        SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + r105.toString() + " -- url = " + r100);
    L24:
        return com.tencent.open.a.f.a().a(r100, r104);
    L10:
        SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + r104.toString() + " -- url = " + r100);
        goto L24
    L13:
        if (r101.equalsIgnoreCase("POST") == false) goto L22;
        Map<String, String> r106 = a(r103);
        Map<String, byte[]> r107 = b(r103);
        if (r107 == null) goto L21;
        if (r107.size() == 0) goto L21;
        SLog.w("openSDK_LOG.HttpUtils", "openUrl: has binary " + r107.size());
        return com.tencent.open.a.f.a().a(r100, r106, r107);
    L21:
        return com.tencent.open.a.f.a().b(r100, r106);
    L22:
        SLog.e("openSDK_LOG.HttpUtils", "openUrl: http method " + r101 + " is not supported.");
        throw new IOException("http method is not supported.");
    L4:
        r103 = new Bundle();
        goto L6
    }

    private static void a(Context r100, QQToken r101, String r102) {
        if (r102.indexOf("add_share") <= (-1)) goto L5;
    L18:
        com.tencent.connect.a.a.a(r100, r101, "requireApi", new String[]{r102});
        return;
    L5:
        if (r102.indexOf("upload_pic") > (-1)) goto L18;
        if (r102.indexOf("add_topic") > (-1)) goto L18;
        if (r102.indexOf("set_user_face") > (-1)) goto L18;
        if (r102.indexOf("add_t") > (-1)) goto L18;
        if (r102.indexOf("add_pic_t") > (-1)) goto L18;
        if (r102.indexOf("add_pic_url") > (-1)) goto L18;
        if (r102.indexOf("add_video") > (-1)) goto L18;
    }

    public static JSONObject request(QQToken r210, Context r211, String r212, Bundle r213, String r214) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi request");
        if (m.b(r211) == false) goto L53;
        if (r212.toLowerCase().startsWith("http") == true) goto L7;
        String r100 = j.a().a(r211, "https://openmobile.qq.com/") + r212;
        String r110 = j.a().a(r211, "https://openmobile.qq.com/") + r212;
    L8:
        a(r211, r210, r212);
        long r101 = SystemClock.elapsedRealtime();
        int r102 = i.a(r211, r210.getAppId()).a("Common_HttpRetryCount");
        SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + r102 + "   appid:" + r210.getAppId() + "     url:" + r110);
        if (r102 != 0) goto L11;
        int r103 = 3;
    L12:
        SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + r103 + "   appid:" + r210.getAppId() + "     url:" + r110);
        int r104 = 0;
        JSONObject r111 = null;
        long r112 = r101;
    L13:
        int r113 = r104 + 1;
        com.tencent.open.a.g r105 = a(r100, r214, r213);     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        int r106 = r105.d();     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        SLog.i("openSDK_LOG.HttpUtils", "request statusCode " + r106);     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        if (r106 != 200) goto L26;
        JSONObject r107 = m.d(r105.a());     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        int r108 = JSONObjectProtectorUtils.getInt(r107, "ret");     // Catch: SocketTimeoutException -> L19 JSONException -> L21 IOException -> L34 MalformedURLException -> L37
    L22:
        long r109 = r105.c();     // Catch: SocketTimeoutException -> L19 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
        long r114 = r105.b();     // Catch: SocketTimeoutException -> L19 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
        r111 = r107;
        int r115 = r108;
        long r116 = r109;
    L47:
        com.tencent.open.b.h.a().a(r110, r112, r116, r114, r115);
        return r111;
    L21:
        r108 = -4;
    L19:
        e = e;
        r111 = r107;
    L43:
        e.printStackTrace();
        r115 = -8;
        r116 = 0;
        r114 = 0;
        if (r113 >= r103) goto L50;
        r112 = SystemClock.elapsedRealtime();
        if (r113 >= r103) goto L47;
        r104 = r113;
        r100 = r100;
        goto L13
    L50:
        com.tencent.open.b.h.a().a(r110, r112, 0, 0, -8);
        throw e;
    L26:
        r100 = r100;
        com.tencent.open.b.h.a().a(r110, r112, 0, 0, r106);     // Catch: SocketTimeoutException -> L29 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
        throw new HttpStatusException(r106);     // Catch: SocketTimeoutException -> L29 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
    L29:
        e = e;
        goto L43
    L40:
        e = e;
    L31:
        e = move-exception;
        e.printStackTrace();
        com.tencent.open.b.h.a().a(r110, r112, 0, 0, -4);
        throw e;
    L37:
        e = move-exception;
        e.printStackTrace();
        com.tencent.open.b.h.a().a(r110, r112, 0, 0, -3);
        throw e;
    L34:
        e = move-exception;
        e.printStackTrace();
        com.tencent.open.b.h.a().a(r110, r112, 0, 0, getErrorCodeFromException(e));
        throw e;
    L11:
        r103 = r102;
        goto L12
    L7:
        r100 = r212;
        r110 = r100;
        goto L8
    L53:
        throw new NetworkUnavailableException("network unavailable");
    }

    public static void requestAsync(final QQToken r100, final Context r110, final String r111, final Bundle r112, final String r113, final IRequestListener r114) {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        l.a(new AnonymousClass1(r100, r110, r111, r112, r113, r114));
    }
}
