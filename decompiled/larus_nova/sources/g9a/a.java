package g9a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.apm.d;
import com.bytedance.apm.util.m;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import i9a.b;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import x8a.c;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    static {
        new ArrayList();
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        int r101 = r100.lastIndexOf(".");
        if (r101 != (-1)) goto L11;
        return r100.concat("-cloudMsg.zip");
    L11:
        return r100.substring(0, r101) + "-cloudMsg.zip";
    }

    public static void b(i9a.a r110) {
        h9a.a r100 = r110.f488813i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.a().size() != 0) goto L8;
        return;
    L8:
        if (r110.f488821b == false) goto L11;
    L27:
        boolean r101 = false;
    L29:
        if (r101 == true) goto L32;
        return;
    L32:
        if (r110.f488815k == true) goto L35;
        r110.f488819o = r110.f488813i.a();
    L51:
        String r102 = j9a.a.f497829a;
        int r103 = 0;
        boolean r104 = false;
    L53:
        if (r103 >= r110.f488819o.size()) goto L77;
        PolarisFileWrapper r105 = new PolarisFileWrapper((String) ListProtector.get(r110.f488819o, r103));
        if (r105.exists() == false) goto L75;
        if (r103 >= (r110.f488819o.size() - 1)) goto L60;
        int r106 = 1;
    L62:
        if (r110.f488818n == false) goto L64;
        r106 = r110.f488823d;
    L64:
        boolean r107 = j9a.a.a(j9a.a.f497829a, r105, r106, r110.f488812h, r110.f488822c, r110.f488824e, r110.f488825f, r110.f488826g);
        if (r107 == true) goto L67;
    L69:
        if (r103 != 0) goto L71;
        r104 = r107;
        goto L75
    L71:
        if (r104 == false) goto L74;
        if (r107 == false) goto L74;
        r104 = true;
    L74:
        r104 = false;
        goto L75
    L67:
        if (r110.f488815k == false) goto L69;
        r105.delete();
        goto L69
    L60:
        r106 = 2;
    L75:
        r103 = r103 + 1;
        goto L53
    L77:
        if (r110.f488817m == false) goto L101;
        if (r104 == false) goto L102;
        Iterator<String> r111 = r110.f488813i.a().iterator();
    L81:
        if (r111.hasNext() == false) goto L104;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r111.next());
        if (r108.exists() == false) goto L81;
        r108.delete();
        goto L81
    L104:
        return;
    L102:
        return;
    L101:
        return;
    L35:
        if (r110.f488813i.a().size() != 1) goto L37;
    L47:
        PolarisFileWrapper r109 = new PolarisFileWrapper((String) ListProtector.get(r110.f488813i.a(), 0));
        PolarisFileWrapper r112 = new PolarisFileWrapper(r109.getParent(), a(r109.getName()));
        if (r112.exists() == false) goto L50;
        r112.delete();
    L50:
        com.monitor.cloudmessage.utils.a.b(r112.getAbsolutePath(), (String[]) r110.f488813i.a().toArray(new String[r110.f488813i.a().size()]));
        ArrayList r113 = new ArrayList(1);
        r113.add(r112.getAbsolutePath());
        r110.f488819o = r113;
        goto L51
    L37:
        if (r110.f488816l == true) goto L47;
        ArrayList r114 = new ArrayList();
        Iterator<String> r115 = r110.f488813i.a().iterator();
    L41:
        if (r115.hasNext() == false) goto L46;
        String r116 = r115.next();
        PolarisFileWrapper r117 = new PolarisFileWrapper(r116);
        PolarisFileWrapper r118 = new PolarisFileWrapper(r117.getParent(), a(r117.getName()));
        if (r118.exists() == false) goto L45;
        r118.delete();
    L45:
        com.monitor.cloudmessage.utils.a.b(r118.getAbsolutePath(), new String[]{r116});
        r114.add(r118.getAbsolutePath());
        goto L41
    L46:
        r110.f488819o = r114;
        goto L51
    L11:
        if (r110.f488814j == false) goto L13;
    L15:
        Context r119 = c.b().getContext();
        if (r119 != null) goto L86;
    L25:
        boolean r120 = false;
    L26:
        if (r120 == false) goto L27;
        r101 = true;
        goto L29
    L86:
        NetworkInfo r121 = ((ConnectivityManager) r119.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L23
        if (r121 == null) goto L25;
        if (r121.isConnected() == false) goto L25;
        r120 = true;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L13:
        if ((System.currentTimeMillis() - r110.f488820a) >= 0) goto L15;
        goto L15
    }

    public static void c(b r110) {
        if (d.j() == false) goto L6;
        ps3.b.a(new String[]{"uploadInfo=" + r110});
    L6:
        if (TextUtils.isEmpty(r110.f488822c) == false) goto L8;
        return;
    L8:
        String r100 = j9a.a.f497829a;
        int r101 = r110.f488823d;
        String r102 = r110.f488822c;
        String r103 = r110.f488824e;
        long r104 = r110.f488825f;
        HashMap<String, String> r105 = r110.f488826g;
        HttpURLConnection r111 = null;
        DataOutputStream r112 = null;
        HttpURLConnection r106 = m.a(r100);     // Catch: Throwable -> L49
        r106.setReadTimeout(30000);     // Catch: Throwable -> L47
        r106.setConnectTimeout(30000);     // Catch: Throwable -> L47
        r106.setDoInput(true);     // Catch: Throwable -> L47
        r106.setDoOutput(true);     // Catch: Throwable -> L47
        r106.setUseCaches(false);     // Catch: Throwable -> L47
        r106.setRequestMethod("POST");     // Catch: Throwable -> L47
        r106.setRequestProperty("Charset", "UTF-8");     // Catch: Throwable -> L47
        r106.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L47
        r106.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + j9a.a.f497831c);     // Catch: Throwable -> L47
        Map<String, String> r107 = j9a.a.f497830b;     // Catch: Throwable -> L47
        if (r107 != null) goto L14;
    L24:
        r106.connect();     // Catch: Throwable -> L47
        DataOutputStream r108 = new DataOutputStream(r106.getOutputStream());     // Catch: Throwable -> L47
        StringBuffer r113 = new StringBuffer();     // Catch: Throwable -> L45
        r113.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L45
        String r114 = j9a.a.f497831c;     // Catch: Throwable -> L45
        r113.append(r114);     // Catch: Throwable -> L45
        r113.append("\r\n");     // Catch: Throwable -> L45
        r113.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r101 + "\r\n" + HttpClient.ENDFLAG + r114 + "\r\n");     // Catch: Throwable -> L45
        r113.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r102 + "\r\n" + HttpClient.ENDFLAG + r114 + "\r\n");     // Catch: Throwable -> L45
        r113.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r103 + "\r\n" + HttpClient.ENDFLAG + r114 + "\r\n");     // Catch: Throwable -> L45
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L45
        r109.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L45
        c.b();     // Catch: Throwable -> L45
        r109.append("");     // Catch: Throwable -> L45
        r109.append("\r\n");     // Catch: Throwable -> L45
        r109.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L45
        r109.append(r114);     // Catch: Throwable -> L45
        r109.append("\r\n");     // Catch: Throwable -> L45
        r113.append(r109.toString());     // Catch: Throwable -> L45
        StringBuilder r115 = new StringBuilder();     // Catch: Throwable -> L45
        r115.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L45
        c.b();     // Catch: Throwable -> L45
        r115.append("");     // Catch: Throwable -> L45
        r115.append("\r\n");     // Catch: Throwable -> L45
        r115.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L45
        r115.append(r114);     // Catch: Throwable -> L45
        r115.append("\r\n");     // Catch: Throwable -> L45
        r113.append(r115.toString());     // Catch: Throwable -> L45
        r113.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r104 + "\r\n" + HttpClient.ENDFLAG + r114 + "\r\n");     // Catch: Throwable -> L45
        if (r101 != 2) goto L28;
    L33:
        r108.write(r113.toString().getBytes());     // Catch: Throwable -> L45
        j9a.a.b(r108, r105);     // Catch: Throwable -> L45
        r113.setLength(0);     // Catch: Throwable -> L45
    L34:
        StringBuilder r116 = new StringBuilder();     // Catch: Throwable -> L45
        r116.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L45
        c.b();     // Catch: Throwable -> L45
        r116.append("");     // Catch: Throwable -> L45
        r116.append("\r\n");     // Catch: Throwable -> L45
        r116.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L45
        r116.append(r114);     // Catch: Throwable -> L45
        r116.append("\r\n");     // Catch: Throwable -> L45
        r113.append(r116.toString());     // Catch: Throwable -> L45
        r108.write(r113.toString().getBytes());     // Catch: Throwable -> L45
        r108.flush();     // Catch: Throwable -> L45
        r108.close();     // Catch: Throwable -> L45
        if (r106.getResponseCode() != 200) goto L42;
        r106.disconnect();
        r108.close();     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L42:
        r106.disconnect();
        r108.close();     // Catch: Throwable -> L57
    L70:
        return;
    L28:
        if (r101 == 3) goto L33;
        if (r101 != 0) goto L34;
        if (r105 == null) goto L34;
        if (r105.isEmpty() == true) goto L34;
    L45:
        th = th;
        r112 = r108;
    L48:
        DataOutputStream r117 = r112;
        r111 = r106;
        DataOutputStream r118 = r117;
    L76:
        th.printStackTrace();     // Catch: Throwable -> L60
        if (r111 == null) goto L54;
        r111.disconnect();
    L54:
        if (r118 == null) goto L94;
        r118.close();     // Catch: Throwable -> L57
        goto L70
    L94:
        return;
    L60:
        th = move-exception;
        if (r111 == null) goto L64;
        r111.disconnect();
    L64:
        if (r118 == null) goto L96;
        r118.close();     // Catch: Throwable -> L67
        throw th;
    L67:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L96:
        throw th;
    L14:
        if (((HashMap) r107).isEmpty() == true) goto L24;
        Iterator r119 = ((HashMap) r107).entrySet().iterator();     // Catch: Throwable -> L47
    L17:
        if (r119.hasNext() == false) goto L24;
        Map.Entry r120 = (Map.Entry) r119.next();     // Catch: Throwable -> L47
        String r121 = (String) r120.getKey();     // Catch: Throwable -> L47
        String r122 = (String) r120.getValue();     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r121) == true) goto L17;
        if (TextUtils.isEmpty(r122) == true) goto L17;
        r106.setRequestProperty(r121, r122);     // Catch: Throwable -> L47
    L47:
        th = th;
    L57:
        th = move-exception;
        th.printStackTrace();
        return;
    L49:
        th = th;
        r118 = null;
        goto L76
    }
}
