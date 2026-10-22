package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.libra.CallBack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f464120a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, m> f961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f464121b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m9293a() {
        if (f961a == null) goto L5;
        return;
    L5:
        HashMap r100 = new HashMap();
        f961a = r100;
        r100.put("CN", m.f464124a);
        Map<String, m> r101 = f961a;
        m r102 = m.f464126c;
        r101.put("FI", r102);
        f961a.put("SE", r102);
        f961a.put("NO", r102);
        f961a.put("FO", r102);
        f961a.put("EE", r102);
        f961a.put("LV", r102);
        f961a.put("LT", r102);
        f961a.put("BY", r102);
        f961a.put("MD", r102);
        f961a.put("UA", r102);
        f961a.put("PL", r102);
        f961a.put("CZ", r102);
        f961a.put("SK", r102);
        f961a.put("HU", r102);
        f961a.put("DE", r102);
        f961a.put("AT", r102);
        f961a.put("CH", r102);
        f961a.put("LI", r102);
        f961a.put("GB", r102);
        f961a.put("IE", r102);
        f961a.put("NL", r102);
        f961a.put("BE", r102);
        f961a.put("LU", r102);
        f961a.put("FR", r102);
        f961a.put("RO", r102);
        f961a.put("BG", r102);
        f961a.put("RS", r102);
        f961a.put("MK", r102);
        f961a.put("AL", r102);
        f961a.put("GR", r102);
        f961a.put("SI", r102);
        f961a.put("HR", r102);
        f961a.put("IT", r102);
        f961a.put(CallBack.EVENT_SLEEP_MODE, r102);
        f961a.put("MT", r102);
        f961a.put("ES", r102);
        f961a.put("PT", r102);
        f961a.put("AD", r102);
        f961a.put("CY", r102);
        f961a.put("DK", r102);
        f961a.put("IS", r102);
        f961a.put("UK", r102);
        f961a.put("EL", r102);
        f961a.put("RU", m.f464127d);
        f961a.put("IN", m.f464128e);
    }

    public static String b() {
        String r100 = p.a("ro.miui.region", "");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = p.a("persist.sys.oppo.region", "");
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = p.a("ro.oppo.regionmark", "");
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        r100 = p.a("ro.vendor.oplus.regionmark", "");
    L12:
        if (TextUtils.isEmpty(r100) == false) goto L15;
        r100 = p.a("ro.hw.country", "");
    L15:
        if (TextUtils.isEmpty(r100) == false) goto L18;
        r100 = p.a("ro.csc.countryiso_code", "");
    L18:
        if (TextUtils.isEmpty(r100) == false) goto L21;
        r100 = m9297b(p.a("ro.product.country.region", ""));
    L21:
        if (TextUtils.isEmpty(r100) == false) goto L24;
        r100 = p.a("gsm.vivo.countrycode", "");
    L24:
        if (TextUtils.isEmpty(r100) == false) goto L27;
        r100 = p.a("persist.sys.oem.region", "");
    L27:
        if (TextUtils.isEmpty(r100) == false) goto L30;
        r100 = p.a("ro.product.locale.region", "");
    L30:
        if (TextUtils.isEmpty(r100) == false) goto L33;
        r100 = p.a("persist.sys.country", "");
    L33:
        if (TextUtils.isEmpty(r100) == true) goto L36;
        com.xiaomi.channel.commonutils.logger.b.m8718a("get region from system, region = " + r100);
    L36:
        if (TextUtils.isEmpty(r100) == false) goto L39;
        String r101 = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.m8718a("locale.default.country = " + r101);
        return r101;
    L39:
        return r100;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m9299c() {
        if (f464121b >= 0) goto L6;
        f464121b = !m9301e() ? 1 : 0;
    L6:
        if (f464121b > 0) goto L10;
        return false;
    L10:
        return true;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public static boolean m9300d() {
        return !m.f464124a.name().equalsIgnoreCase(a(b()).name());
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public static boolean m9301e() {
        String r100 = "";
        r100 = p.a("ro.miui.ui.version.code", "");     // Catch: Exception -> L6
    L5:
        return !TextUtils.isEmpty(r100);
    }

    public static int a() {
        if (f464120a != 0) goto L21;
        int r100 = 1;
        if (TextUtils.isEmpty(m9292a("ro.miui.ui.version.code")) == true) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L15;
        r100 = 2;
    L15:
        f464120a = r100;     // Catch: Throwable -> L17
    L19:
        com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f464120a);
        goto L21
    L8:
        if (TextUtils.isEmpty(m9292a("ro.miui.ui.version.name")) == false) goto L11;
        r101 = false;
    L17:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
        f464120a = 0;
    L21:
        return f464120a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m9298b() {
        if (a() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static String c() {
        return m9292a("ro.miui.ui.version.name");
    }

    public static String d() {
        return m9292a(DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS);
    }

    public static String e() {
        return m9292a(PlatformConst.PROP_MANUFACTURER);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9291a() {
        int r100 = q.a();
        if (m9294a() == false) goto L15;
        if (r100 > 0) goto L6;
        return "";
    L6:
        if (r100 >= 2) goto L10;
        return "alpha";
    L10:
        if (r100 >= 3) goto L13;
        return "development";
    L13:
        return "stable";
    L15:
        return "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9294a() {
        if (a() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String a(Bundle r100) {
        StringBuilder r101 = new StringBuilder("Bundle[");
        if (r100 != null) goto L5;
        r101.append("null");
    L46:
        r101.append("]");
        return r101.toString();
    L5:
        Iterator<String> r102 = r100.keySet().iterator();
        boolean r103 = true;
    L7:
        if (r102.hasNext() == false) goto L46;
        String r104 = r102.next();
        if (r103 == true) goto L11;
        r101.append(", ");
    L11:
        r101.append(r104);
        r101.append(com.alipay.sdk.m.n.a.f25612h);
        Object r105 = r100.get(r104);
        if ((r105 instanceof int[]) == false) goto L15;
        r101.append(Arrays.toString((int[]) r105));
    L45:
        r103 = false;
        goto L7
    L15:
        if ((r105 instanceof byte[]) == false) goto L18;
        r101.append(Arrays.toString((byte[]) r105));
        goto L45
    L18:
        if ((r105 instanceof boolean[]) == false) goto L21;
        r101.append(Arrays.toString((boolean[]) r105));
        goto L45
    L21:
        if ((r105 instanceof short[]) == false) goto L24;
        r101.append(Arrays.toString((short[]) r105));
        goto L45
    L24:
        if ((r105 instanceof long[]) == false) goto L27;
        r101.append(Arrays.toString((long[]) r105));
        goto L45
    L27:
        if ((r105 instanceof float[]) == false) goto L30;
        r101.append(Arrays.toString((float[]) r105));
        goto L45
    L30:
        if ((r105 instanceof double[]) == false) goto L33;
        r101.append(Arrays.toString((double[]) r105));
        goto L45
    L33:
        if ((r105 instanceof String[]) == false) goto L36;
        r101.append(Arrays.toString((String[]) r105));
        goto L45
    L36:
        if ((r105 instanceof CharSequence[]) == false) goto L39;
        r101.append(Arrays.toString((CharSequence[]) r105));
        goto L45
    L39:
        if ((r105 instanceof Parcelable[]) == false) goto L42;
        r101.append(Arrays.toString((Parcelable[]) r105));
        goto L45
    L42:
        if ((r105 instanceof Bundle) == false) goto L44;
        r101.append(a((Bundle) r105));
        goto L45
    L44:
        r101.append(r105);
        goto L45
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static String m9297b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        String[] r101 = r100.split("-");
        if (r101.length > 0) goto L7;
        return r100;
    L7:
        return r101[0];
    L8:
        return r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9292a(String r100) {
        return (String) av.a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, new Object[]{r100, ""});
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e);     // Catch: Throwable -> L8
    L7:
        return null;
    }

    private static m b(String r100) {
        m9293a();
        return f961a.get(r100.toUpperCase());
    }

    public static String a(Intent r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString() + " " + a(r100.getExtras());
    }

    public static int b(Context r100) {
        return r100.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
    L5:
        return 0;
    }

    public static int a(Context r100) {
        String r101 = m9292a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L8:
        return 0;
    L5:
        if (TextUtils.isDigitsOnly(r101) == false) goto L8;
        return CastIntegerProtector.parseInt(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9295a(Context r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (m9296a(r100.getPackageName()) == false) goto L6;
        return true;
    }

    public static m a(String r100) {
        m r101 = b(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return m.f464125b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9296a(String r100) {
        return "com.xiaomi.xmsf".equals(r100);
    }
}
