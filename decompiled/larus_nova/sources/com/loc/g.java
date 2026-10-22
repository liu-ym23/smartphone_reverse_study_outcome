package com.loc;

import android.content.Context;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.HashMap;
import java.util.Locale;
import n4a.c4;
import n4a.d5;
import n4a.f5;
import n4a.j4;
import n4a.v4;
import n4a.w4;
import n4a.y3;
import n4a.z4;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static g f380062e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f380063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f380064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f380065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f380066d;

    public g(Context r100) {
        this.f380063a = null;
        String r101 = c4.f517206a;
        this.f380064b = 30000;
        this.f380065c = false;
        this.f380066d = 0;
        z4.a.f517980a.a(r100);     // Catch: Throwable -> L6
    L4:
        this.f380063a = r100;
        c.c();
    }

    public final String a(Context r100, double r110, double r111) {
        HashMap r101 = new HashMap(16);     // Catch: Throwable -> L25
        y3 r102 = new y3(r100, c4.k());     // Catch: Throwable -> L25
        r101.clear();     // Catch: Throwable -> L25
        r101.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L25
        r101.put("Connection", HTTP.KEEP_ALIVE);     // Catch: Throwable -> L25
        r101.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L25
        HashMap r103 = new HashMap(16);     // Catch: Throwable -> L25
        r103.put("custom", "26260A1F00020002");     // Catch: Throwable -> L25
        r103.put("key", v4.g(r100));     // Catch: Throwable -> L25
        int r104 = this.f380066d;     // Catch: Throwable -> L25
        if (r104 == 0) goto L7;
        if (r104 == 1) goto L10;
        if (r104 != 2) goto L7;
        String r105 = "en";
    L9:
        r103.put("language", r105);     // Catch: Throwable -> L25
    L12:
        if (j4.J(this.f380063a) == false) goto L14;
        String r106 = "coarseLoc";
    L15:
        r103.put("curLocationType", r106);     // Catch: Throwable -> L25
        String r107 = w4.a();     // Catch: Throwable -> L25
        String r108 = w4.b(r100, r107, f5.l(r103));     // Catch: Throwable -> L25
        r103.put("ts", r107);     // Catch: Throwable -> L25
        r103.put("scode", r108);     // Catch: Throwable -> L25
        r102.v(("output=json&radius=1000&extensions=all&location=" + r111 + "," + r110).getBytes("UTF-8"));     // Catch: Throwable -> L25
        r102.f517972w = false;     // Catch: Throwable -> L25
        r102.f517969t = true;     // Catch: Throwable -> L25
        r102.f517970u = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", "loc", 3});     // Catch: Throwable -> L25
        r102.f517971v = r103;     // Catch: Throwable -> L25
        r102.f517963n = r101;     // Catch: Throwable -> L25
        r102.f379925b = d5.a(r100);     // Catch: Throwable -> L25
        r102.f379924a = 30000;     // Catch: Throwable -> L25
        r102.f517966q = "http://dualstack-arestapi.amap.com/v3/geocode/regeo";     // Catch: Throwable -> L21
        r102.f517965p = "http://restsdk.amap.com/v3/geocode/regeo";     // Catch: Throwable -> L21
        if (this.f380065c == false) goto L19;
        r102.b(bo.c.f379951b);     // Catch: Throwable -> L21
    L19:
        goto L23
    L29:
        return new String(c.a(r102).f517453a, XML.CHARSET_UTF8);
    L21:
        th = move-exception;
        c4.g(th, "LocNetManager", UGCMonitor.TYPE_POST);     // Catch: Throwable -> L25
        goto L23
    L14:
        r106 = "fineLoc";
        goto L15
    L10:
        r105 = "zh-CN";
    L7:
        r103.remove("language");     // Catch: Throwable -> L25
    L23:
        return null;
    }

    public final y3 b(Context r110, byte[] r111, String r112, String r113, boolean r114) {
        HashMap r100 = new HashMap(16);     // Catch: Throwable -> L24
        y3 r101 = new y3(r110, c4.k());     // Catch: Throwable -> L24
        r100.put("Content-Type", "application/octet-stream");     // Catch: Throwable -> L26
        r100.put("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L26
        r100.put("gzipped", "1");     // Catch: Throwable -> L26
        r100.put("Connection", HTTP.KEEP_ALIVE);     // Catch: Throwable -> L26
        r100.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L26
        r100.put("KEY", v4.g(r110));     // Catch: Throwable -> L26
        r100.put("enginever", c4.f517206a);     // Catch: Throwable -> L26
        String r102 = w4.a();     // Catch: Throwable -> L26
        String r103 = w4.b(r110, r102, "key=" + v4.g(r110));     // Catch: Throwable -> L26
        r100.put("ts", r102);     // Catch: Throwable -> L26
        r100.put("scode", r103);     // Catch: Throwable -> L26
        if (CastDoubleProtector.valueOf(c4.f517206a).doubleValue() < 5.3d) goto L7;
        r100.put("aps_s_src", "openapi");     // Catch: Throwable -> L26
    L7:
        r100.put("encr", "1");     // Catch: Throwable -> L26
        r101.f517963n = r100;     // Catch: Throwable -> L26
        String r104 = "loc";
        if (r114 == true) goto L10;
        r104 = "locf";
    L10:
        r101.f517972w = true;     // Catch: Throwable -> L26
        r101.f517970u = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", r104, 3});     // Catch: Throwable -> L26
        r101.f517969t = r114;     // Catch: Throwable -> L26
        r101.f517965p = r112;     // Catch: Throwable -> L26
        r101.f517966q = r113;     // Catch: Throwable -> L26
        r101.f517967r = f5.n(r111);     // Catch: Throwable -> L26
        r101.f379925b = d5.a(r110);     // Catch: Throwable -> L26
        HashMap r115 = new HashMap(16);     // Catch: Throwable -> L26
        r115.put(BdpAppEventConstant.PARAMS_OUTPUT, "bin");     // Catch: Throwable -> L26
        r115.put("policy", AMap3DTileBuildType.AIRPORT_TERMINAL);     // Catch: Throwable -> L26
        int r116 = this.f380066d;     // Catch: Throwable -> L26
        if (r116 == 0) goto L19;
        if (r116 == 1) goto L17;
        if (r116 != 2) goto L19;
        String r117 = "language:en";
    L18:
        r115.put("custom", r117);     // Catch: Throwable -> L26
    L20:
        r101.f517971v = r115;     // Catch: Throwable -> L26
        r101.f379924a = this.f380064b;     // Catch: Throwable -> L26
        if (this.f380065c == false) goto L31;
        r101.b(bo.c.f379951b);     // Catch: Throwable -> L26
        return r101;
    L31:
        return r101;
    L17:
        r117 = "language:cn";
    L19:
        r115.remove("custom");     // Catch: Throwable -> L26
    L33:
        return r101;
    L24:
        return null;
    }
}
