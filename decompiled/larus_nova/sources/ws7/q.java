package ws7;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.SceneEnv;
import com.dtf.face.log.RecordService;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import me.ele.lancet.base.annotations.Skip;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes22.dex */
public final class q {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f561101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f561102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f561103c;

        public a() {
            this.f561101a = false;
            this.f561102b = "";
        }
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

    public static String d(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return URLEncoder.encode(r100, XML.CHARSET_UTF8).replace(Marker.ANY_NON_NULL_MARKER, "%20").replace("*", "%2A").replace(Constants.WAVE_SEPARATOR, "%7E").replace(HTTP.URL_DEFAULT, "%2F");
    }

    public static String b(String r110, String r210, String r211, String r212, String r213, String r214, Date r215) {
        hs7.a r100 = hs7.a.h();
        long r101 = r100.K;
        if (r101 != (-1)) goto L19;
        AndroidClientConfig r102 = r100.c();
        if (r102 == null) goto L17;
        SceneEnv r103 = r102.getSceneEnv();
        if (r103 == null) goto L17;
        long r104 = Long.parseLong(r103.sysTime);     // Catch: Throwable -> L15
        if (r104 == 0) goto L13;
        r100.K = (r104 / 1000) + 900;     // Catch: Throwable -> L15
    L45:
        goto L17
    L13:
        RecordService.getInstance().recordEvent(3, "ossExpiresException", new String[]{"errMsg", "sysTime is null"});     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        RecordService.getInstance().recordEvent(3, "ossExpiresException", new String[]{"errMsg", RecordService.getStackTraceString(th)});
    L17:
        r101 = r100.K;
    L19:
        if (r101 <= 0) goto L21;
        String r105 = String.valueOf(r101);
    L22:
        String r106 = "PUT\n\n\n" + r105 + "\n/" + r213 + HTTP.URL_DEFAULT + r214 + "?security-token=" + r211;
        SecretKeySpec r107 = new SecretKeySpec(r210.getBytes("UTF-8"), "HmacSHA1");
        Mac r108 = Mac.getInstance("HmacSHA1");
        r108.init(r107);
        String r109 = i.b(r108.doFinal(r106.getBytes("UTF-8")));
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("Expires", r105);
        r111.put("OSSAccessKeyId", r110);
        r111.put("Signature", r109);
        r111.put("security-token", r211);
        if (r111.isEmpty() == false) goto L25;
        String r112 = null;
    L36:
        URI r113 = new URI(r212);
        StringBuilder r114 = new StringBuilder();
        r114.append(String.format("%s://", new Object[]{r113.getScheme()}));
        String r115 = r113.getHost();
        StringBuffer r116 = new StringBuffer();
        r116.append(r213);
        r116.append(".");
        r116.append(r115);
        r114.append(r116.toString());
        if (r113.getPort() == (-1)) goto L39;
        String r117 = String.format(":%s", new Object[]{Integer.valueOf(r113.getPort())});
    L40:
        r114.append(r117);
        r114.append(r113.getPath());
        String r118 = new URI(r114.toString()).toString();
        if (r118.endsWith(HTTP.URL_DEFAULT) == true) goto L44;
        r118 = r118.concat(HTTP.URL_DEFAULT);
    L44:
        return r118 + r214 + "?" + r112;
    L39:
        r117 = "";
        goto L40
    L25:
        StringBuilder r119 = new StringBuilder();
        Iterator r120 = r111.entrySet().iterator();
        boolean r121 = true;
    L27:
        if (r120.hasNext() == false) goto L35;
        Map.Entry r122 = (Map.Entry) r120.next();
        String r123 = (String) r122.getKey();
        String r124 = (String) r122.getValue();
        if (r121 == true) goto L31;
        r119.append("&");
    L31:
        r119.append(d(r123));
        if (r124 == null) goto L34;
        r119.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r119.append(d(r124));
    L34:
        r121 = false;
        goto L27
    L35:
        r112 = r119.toString();
        goto L36
    L21:
        r105 = String.valueOf(r215.getTime() / 1000);
        goto L22
    }

    public static a c(String r110, String r111, String r210, String r211, String r212, String r213, byte[] r214) {
        String r100 = "";
        String r101 = r110.trim();
        if (r101.toLowerCase().startsWith("http") == true) goto L5;
        r101 = "https://".concat(r101);
    L5:
        long r112 = System.currentTimeMillis();
        a r113 = new a();
        if (r214 != null) goto L9;
        r113.f561101a = false;
        r113.f561102b = "OSSFile Empty";
        return r113;
    L9:
        Calendar r102 = Calendar.getInstance();
        r102.add(12, 15);
        Date r103 = r102.getTime();
        StringBuilder r104 = new StringBuilder();
        int r114 = -1;
        String r105 = b(r111, r210, r211, r101, r212, r213, r103);     // Catch: Exception -> L28
        r113.f561103c = r105;     // Catch: Exception -> L26
        HttpURLConnection r106 = (HttpURLConnection) a(new URL(r105));     // Catch: Exception -> L26
        r106.setReadTimeout(15000);     // Catch: Exception -> L26
        r106.setConnectTimeout(15000);     // Catch: Exception -> L26
        r106.setRequestMethod("PUT");     // Catch: Exception -> L26
        r106.setDoOutput(true);     // Catch: Exception -> L26
        r106.setRequestProperty("Content-Type", "");     // Catch: Exception -> L26
        OutputStream r107 = r106.getOutputStream();     // Catch: Exception -> L26
        r107.write(r214);     // Catch: Exception -> L26
        r107.flush();     // Catch: Exception -> L26
        r107.close();     // Catch: Exception -> L26
        int r108 = r106.getResponseCode();     // Catch: Exception -> L26
        if (r108 != 200) goto L14;
        InputStream r109 = r106.getInputStream();     // Catch: Exception -> L24
    L15:
        BufferedReader r115 = new BufferedReader(new InputStreamReader(r109));     // Catch: Exception -> L24
    L16:
        String r116 = r115.readLine();     // Catch: Exception -> L24
        if (r116 == null) goto L19;
        r104.append(r116);     // Catch: Exception -> L24
        goto L16
    L19:
        Map<String, List<String>> r117 = r106.getHeaderFields();     // Catch: Exception -> L24
        if (r117 == null) goto L22;
        r100 = r117.toString();     // Catch: Exception -> L24
    L22:
        r115.close();     // Catch: Exception -> L24
        r109.close();     // Catch: Exception -> L24
        r106.disconnect();     // Catch: Exception -> L24
    L31:
        String r118 = r104.toString();
        if (r108 != 200) goto L34;
        boolean r119 = true;
    L35:
        r113.f561101a = r119;
        r113.f561102b = r118;
        long r120 = System.currentTimeMillis() - r112;
        RecordService r121 = RecordService.getInstance();
        if (r108 != 200) goto L38;
        String r122 = "ossHttpUploadSuccess";
    L39:
        r121.recordEvent(2, r122, new String[]{"presignedUrl", r105, "endPoint", r101, "bucketName", r212, "fileName", r213, "code", String.valueOf(r108), "message", r118, "headerFields", r100, "uploadCost", String.valueOf(r120)});
        return r113;
    L38:
        r122 = "ossHttpUploadFileError";
        goto L39
    L34:
        r119 = false;
        goto L35
    L14:
        r109 = r106.getErrorStream();     // Catch: Exception -> L24
    L24:
        e = e;
        r114 = r108;
    L27:
        Exception r123 = e;
        String r124 = r100;
        r100 = r105;
    L30:
        r104.append(RecordService.getStackTraceString(r123));
        r105 = r100;
        r108 = r114;
        r100 = r124;
    L26:
        e = e;
    L28:
        e = move-exception;
        r123 = e;
        r124 = "";
        goto L30
    }
}
