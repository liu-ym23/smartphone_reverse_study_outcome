package j9a;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.apm.util.m;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.monitor.cloudmessage.utils.b;
import java.io.DataOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import x8a.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f497829a = "https://mon.zijieapi.com/monitor/collect/c/cloudcontrol/file";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f497830b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f497831c = null;

    static {
        f497830b = new HashMap();
        f497831c = "cloudMessage" + UUID.randomUUID().toString();
    }

    public static void b(DataOutputStream r100, HashMap<String, String> r101) throws Throwable {
        if (c.b().f562946d != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.size() == 0) goto L13;
        r100.write("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
        r100.write(b.b(r101).getBytes());
        r100.write("\r\n".getBytes());
        r100.write((HttpClient.ENDFLAG + f497831c + "\r\n").getBytes());
        r100.flush();
        return;
    L13:
        return;
    L5:
        if (c.b().f562946d.size() == 0) goto L7;
        r100.write("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
        r100.write(b.b(c.b().f562946d).getBytes());
        r100.write("\r\n".getBytes());
        r100.write((HttpClient.ENDFLAG + f497831c + "\r\n").getBytes());
        r100.flush();
        goto L7
    }

    public static boolean a(String r110, File r111, int r112, String r113, String r114, String r115, long r210, HashMap r211) {
        if (TextUtils.isEmpty(r110) == true) goto L77;
        if (r111.exists() == false) goto L77;
        HttpURLConnection r100 = null;
        DataOutputStream r101 = null;
        HttpURLConnection r102 = m.a(r110);     // Catch: Throwable -> L55
        r102.setReadTimeout(30000);     // Catch: Throwable -> L53
        r102.setConnectTimeout(30000);     // Catch: Throwable -> L53
        r102.setDoInput(true);     // Catch: Throwable -> L53
        r102.setDoOutput(true);     // Catch: Throwable -> L53
        r102.setUseCaches(false);     // Catch: Throwable -> L53
        r102.setRequestMethod("POST");     // Catch: Throwable -> L53
        r102.setRequestProperty("Charset", "UTF-8");     // Catch: Throwable -> L53
        r102.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L53
        r102.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + f497831c);     // Catch: Throwable -> L53
        Map<String, String> r103 = f497830b;     // Catch: Throwable -> L53
        if (r103 != null) goto L12;
    L22:
        r102.connect();     // Catch: Throwable -> L53
        DataOutputStream r104 = new DataOutputStream(r102.getOutputStream());     // Catch: Throwable -> L53
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L51
        r105.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L51
        String r116 = f497831c;     // Catch: Throwable -> L51
        r105.append(r116);     // Catch: Throwable -> L51
        r105.append("\r\n");     // Catch: Throwable -> L51
        r105.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r112 + "\r\n" + HttpClient.ENDFLAG + r116 + "\r\n");     // Catch: Throwable -> L51
        r105.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r114 + "\r\n" + HttpClient.ENDFLAG + r116 + "\r\n");     // Catch: Throwable -> L51
        r105.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r115 + "\r\n" + HttpClient.ENDFLAG + r116 + "\r\n");     // Catch: Throwable -> L51
        r105.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r210 + "\r\n" + HttpClient.ENDFLAG + r116 + "\r\n");     // Catch: Throwable -> L51
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L51
        r117.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L51
        c.b();     // Catch: Throwable -> L51
        r117.append("");     // Catch: Throwable -> L51
        r117.append("\r\n");     // Catch: Throwable -> L51
        r117.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L51
        r117.append(r116);     // Catch: Throwable -> L51
        r117.append("\r\n");     // Catch: Throwable -> L51
        r105.append(r117.toString());     // Catch: Throwable -> L51
        StringBuilder r118 = new StringBuilder();     // Catch: Throwable -> L51
        r118.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L51
        c.b();     // Catch: Throwable -> L51
        r118.append("");     // Catch: Throwable -> L51
        r118.append("\r\n");     // Catch: Throwable -> L51
        r118.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L51
        r118.append(r116);     // Catch: Throwable -> L51
        r118.append("\r\n");     // Catch: Throwable -> L51
        r105.append(r118.toString());     // Catch: Throwable -> L51
        StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L51
        r119.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L51
        c.b();     // Catch: Throwable -> L51
        r119.append("");     // Catch: Throwable -> L51
        r119.append("\r\n");     // Catch: Throwable -> L51
        r119.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L51
        r119.append(r116);     // Catch: Throwable -> L51
        r119.append("\r\n");     // Catch: Throwable -> L51
        r105.append(r119.toString());     // Catch: Throwable -> L51
        if (r112 != 2) goto L26;
    L31:
        r104.write(r105.toString().getBytes());     // Catch: Throwable -> L51
        b(r104, r211);     // Catch: Throwable -> L51
        r105.setLength(0);     // Catch: Throwable -> L51
    L32:
        r105.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + r113 + "\"; filename=\"" + r111.getName() + "\"\r\n");     // Catch: Throwable -> L51
        r105.append("Content-Type: text/plain\r\n");     // Catch: Throwable -> L51
        r105.append("\r\n");     // Catch: Throwable -> L51
        r104.write(r105.toString().getBytes());     // Catch: Throwable -> L51
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r111);     // Catch: Throwable -> L51
        byte[] r107 = new byte[1024];     // Catch: Throwable -> L51
    L33:
        int r108 = r106.read(r107);     // Catch: Throwable -> L51
        if (r108 == (-1)) goto L36;
        r104.write(r107, 0, r108);     // Catch: Throwable -> L51
        goto L33
    L36:
        r106.close();     // Catch: Throwable -> L51
        r104.write("\r\n".getBytes());     // Catch: Throwable -> L51
        r104.write((HttpClient.ENDFLAG + f497831c + HttpClient.ENDFLAG + "\r\n").getBytes());     // Catch: Throwable -> L51
        r104.flush();     // Catch: Throwable -> L51
        r104.close();     // Catch: Throwable -> L51
        if (r102.getResponseCode() != 200) goto L45;
        r102.disconnect();
        r104.close();     // Catch: Throwable -> L42
    L44:
        return true;
    L42:
        th = move-exception;
        th.printStackTrace();
        goto L44
    L45:
        r102.disconnect();
        r104.close();     // Catch: Throwable -> L48
    L50:
        return false;
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L50
    L26:
        if (r112 == 3) goto L31;
        if (r112 != 0) goto L32;
        if (r211 == null) goto L32;
        if (r211.isEmpty() == true) goto L32;
    L51:
        th = th;
        r101 = r104;
    L54:
        DataOutputStream r109 = r101;
        r100 = r102;
    L78:
        th.printStackTrace();     // Catch: Throwable -> L66
        if (r100 == null) goto L60;
        r100.disconnect();
    L60:
        if (r109 != null) goto L86;
    L65:
        return false;
    L86:
        r109.close();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
    L66:
        th = move-exception;
        if (r100 == null) goto L70;
        r100.disconnect();
    L70:
        if (r109 == null) goto L103;
        r109.close();     // Catch: Throwable -> L73
        throw th;
    L73:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L103:
        throw th;
    L12:
        if (((HashMap) r103).isEmpty() == true) goto L22;
        Iterator r120 = ((HashMap) r103).entrySet().iterator();     // Catch: Throwable -> L53
    L15:
        if (r120.hasNext() == false) goto L22;
        Map.Entry r121 = (Map.Entry) r120.next();     // Catch: Throwable -> L53
        String r122 = (String) r121.getKey();     // Catch: Throwable -> L53
        String r123 = (String) r121.getValue();     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(r122) == true) goto L15;
        if (TextUtils.isEmpty(r123) == true) goto L15;
        r102.setRequestProperty(r122, r123);     // Catch: Throwable -> L53
    L53:
        th = th;
    L55:
        th = th;
        r109 = null;
    L77:
        throw new IllegalArgumentException("url and file not be null ");
    }
}
