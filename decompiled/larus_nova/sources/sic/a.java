package sic;

import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import nic.c;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements c {
    public a() {
    }

    @Override // nic.c
    public final String a(tic.a r110, Map<String, String> r111, int r112) {
        String r100 = "";
        if (r110 != null) goto L5;
        return "";
    L5:
        String r113 = r110.f546363a;
        String r101 = b.f542258a;
        if (r112 == 0) goto L13;
        if (r112 != 1) goto L28;
        StringBuilder r114 = new StringBuilder();
        r114.append(b.f542259b);
        r114.append("?action=GetPlayInfo&video_id=");
        r114.append(r113);
        if (TextUtils.isEmpty(null) == true) goto L12;
        r114.append("&ptoken=null");
    L12:
        r100 = r114.toString();
    L28:
        if (TextUtils.isEmpty(r100) == true) goto L54;
        StringBuilder r115 = new StringBuilder();
        r115.append(r100);
        if (r111 == null) goto L45;
        Iterator<Map.Entry<String, String>> r116 = r111.entrySet().iterator();
    L33:
        if (r116.hasNext() == false) goto L45;
        Map.Entry<String, String> r102 = r116.next();
        r115.append(String.format("&%s=%s", new Object[]{r102.getKey(), URLEncoder.encode(r102.getValue(), "UTF-8")}));     // Catch: UnsupportedEncodingException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L45:
        r115.append(String.format("&device_type=%s", new Object[]{URLEncoder.encode(Build.MODEL, "UTF-8")}));     // Catch: UnsupportedEncodingException -> L41
    L44:
        return r115.toString();
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L54:
        return r100;
    L13:
        HashMap r117 = new HashMap();
        r117.put("version", "1");
        r117.put("user", "toutiao");
        r117.put("video", r113);
        r117.put("vtype", "mp4");
        String r103 = String.valueOf(System.currentTimeMillis() / 1000);
        r117.put("ts", r103);
        TreeSet r104 = new TreeSet(r117.keySet());
        StringBuilder r105 = new StringBuilder();
        Iterator r106 = r104.iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        String r107 = (String) r106.next();
        String r118 = (String) r117.get(r107);
        r105.append(r107);
        r105.append(r118);
        goto L15
    L17:
        r105.append("17601e2231500d8c3389dd5d6afd08de");
        String r119 = DigestUtils.md5Hex(r105.toString());
        ArrayList r108 = new ArrayList();
        r108.add("1");
        r108.add("toutiao");
        r108.add(r103);
        r108.add(r119);
        r108.add("mp4");
        r108.add(r113);
        r105.delete(0, r105.length());
        r105.append(b.f542258a);
        Iterator r120 = r108.iterator();
    L19:
        if (r120.hasNext() == false) goto L21;
        r105.append((String) r120.next());
        r105.append(HTTP.URL_DEFAULT);
        goto L19
    L21:
        r100 = r105.substring(0, r105.length() - 1);
        if (StringUtils.isEmpty(r100) == true) goto L28;
        StringBuilder r121 = new StringBuilder();
        r121.append(r100);
        r121.append("?play_type=1");
        if (StringUtils.isEmpty(null) == true) goto L26;
        r121.append("&category=null");
    L26:
        r100 = r121.toString();
        goto L28
    }
}
