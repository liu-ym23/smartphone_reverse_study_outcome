package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class a0 {
    public static Map<String, String> b(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        HashMap r108 = new HashMap(16);
        r108.put("key", v4.g(r100));
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r108.put("keywords", r101);
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r108.put("types", r102);
    L9:
        if (TextUtils.isEmpty(r105) == true) goto L14;
        if (TextUtils.isEmpty(r106) == true) goto L14;
        r108.put("location", r106 + "," + r105);
    L14:
        if (TextUtils.isEmpty(r103) == true) goto L17;
        r108.put("city", r103);
    L17:
        if (TextUtils.isEmpty(r104) == true) goto L20;
        r108.put("offset", r104);
    L20:
        if (TextUtils.isEmpty(r107) == true) goto L22;
        r108.put("radius", r107);
    L22:
        return r108;
    }

    public a0(Context r100) {
        z4.a.f517980a.a(r100);     // Catch: Throwable -> L6
    L4:
        com.loc.c.c();
    }

    public static String a(Context r100, String r101, Map r102) {
        HashMap r103 = new HashMap(16);     // Catch: Throwable -> L9
        x3 r104 = new x3();     // Catch: Throwable -> L9
        r103.clear();     // Catch: Throwable -> L9
        r103.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L9
        r103.put("Connection", HTTP.KEEP_ALIVE);     // Catch: Throwable -> L9
        r103.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L9
        String r105 = w4.a();     // Catch: Throwable -> L9
        String r106 = w4.b(r100, r105, f5.l(r102));     // Catch: Throwable -> L9
        HashMap r107 = (HashMap) r102;     // Catch: Throwable -> L9
        r107.put("ts", r105);     // Catch: Throwable -> L9
        r107.put("scode", r106);     // Catch: Throwable -> L9
        r104.f517920l = r102;     // Catch: Throwable -> L9
        r104.f517919k = r103;     // Catch: Throwable -> L9
        r104.f517921m = r101;     // Catch: Throwable -> L9
        r104.f379925b = d5.a(r100);     // Catch: Throwable -> L9
        String r108 = c4.f517206a;     // Catch: Throwable -> L9
        r104.f379924a = 30000;     // Catch: Throwable -> L9
        goto L7
    L13:
        return new String(com.loc.c.a(r104).f517453a, XML.CHARSET_UTF8);
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceNetManager", UGCMonitor.TYPE_POST);     // Catch: Throwable -> L9
    L7:
        return null;
    }
}
