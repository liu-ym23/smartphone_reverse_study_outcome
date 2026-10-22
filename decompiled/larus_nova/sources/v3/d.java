package v3;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f552786a = null;

    static {
        f552786a = new d();
    }

    public d() {
    }

    public static WifiInfo a(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static List b(WifiManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, "java.util.List", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, null, r111, false);
        return (List) r112.f474983b;
    L6:
        List<ScanResult> r113 = r110.getScanResults();
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, r113, r111, true);
        return r113;
    }

    public static boolean c(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102302);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102302, "android/net/wifi/WifiManager", "startScan", r110, r111, "boolean", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Boolean) r106.f474983b).booleanValue();
    L21:
        return r110.startScan();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean d(ScanResult r100) {
        String r101 = r100.capabilities;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (StringsKt.contains(r101, "WEP", true) == false) goto L8;
        return true;
    L8:
        if (StringsKt.contains(r101, "WPA", true) == false) goto L10;
        return true;
    L10:
        if (StringsKt.contains(r101, "SAE", true) == false) goto L12;
        return true;
    L12:
        if (StringsKt.contains(r101, "EAP", true) == false) goto L14;
        return true;
    L14:
        if (StringsKt.contains(r101, "OWE", true) == true) goto L22;
        return false;
    L22:
        return true;
    }

    public static String e(String r100) {
        if (r100 == null) goto L20;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L21;
        String r102 = r100.toLowerCase(Locale.ROOT);
        if (r102 != null) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r102, "02:00:00:00:00:00") == false) goto L14;
    L16:
        r101 = false;
    L17:
        if (r101 == true) goto L19;
        return null;
    L19:
        return r102;
    L14:
        if (Intrinsics.areEqual(r102, com.alipay.sdk.m.u.c.f25806a) == true) goto L16;
    L21:
        return null;
    L20:
        return null;
    }

    public static WifiManager g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        Object r102 = r100.getSystemService("wifi");
        if ((r102 instanceof WifiManager) == true) goto L11;
        return null;
    L11:
        return (WifiManager) r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e f(Context r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        WifiManager r100 = g(r210);
        if (r100 != null) goto L118;
        return null;
    L118:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(a(r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        WifiInfo r110 = (WifiInfo) r102;
        if (r110 != null) goto L15;
        return null;
    L15:
        ArrayList r103 = new ArrayList();
        boolean r111 = false;
        Object[] r112 = new Object[0];
        f06.b r113 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(101000);
        if (r104 == null) goto L18;
        f06.a[] r105 = r104.f479473i;
    L19:
        f06.a[] r114 = r105;
        int r106 = r114.length;
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L28;
        f06.a r108 = r114[r107];
        int r115 = r107;
        int r116 = r106;
        f06.a[] r212 = r114;
        f06.d r109 = r108.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r110, r112, "java.lang.String", r113);     // Catch: Exception -> L113
        if (r109.f474982a == true) goto L30;
        r103.add(r108);     // Catch: Exception -> L113
    L30:
        if (r109.f474982a == false) goto L32;
        String r117 = (String) r109.f474983b;
    L34:
        if (r117 == null) goto L47;
        String r118 = StringsKt.trim(r117).toString();
        if (r118 == null) goto L47;
        String r119 = StringsKt.removeSurrounding(r118, "\"");
        if (r119 == null) goto L47;
        if ((!StringsKt.isBlank(r119)) == true) goto L42;
    L44:
        boolean r120 = false;
    L45:
        if (r120 == false) goto L47;
        String r121 = r119;
    L48:
        if (r121 != null) goto L51;
        return null;
    L51:
        ArrayList r122 = new ArrayList();
        Object[] r123 = new Object[0];
        f06.b r124 = new f06.b();
        g06.a r125 = ApiHookConfig.f245611b.get(101100);
        if (r125 == null) goto L54;
        f06.a[] r126 = r125.f479473i;
    L55:
        f06.a[] r127 = r126;
        int r128 = r127.length;
        int r129 = 0;
    L57:
        if (r129 >= r128) goto L64;
        f06.a r130 = r127[r129];
        int r213 = r129;
        int r214 = r128;
        f06.a[] r215 = r127;
        f06.d r131 = r130.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r110, r123, "java.lang.String", r124);     // Catch: Exception -> L112
        if (r131.f474982a == true) goto L61;
        r122.add(r130);     // Catch: Exception -> L112
        goto L63
    L61:
        Boolean r132 = null;
    L66:
        if (r131.f474982a == false) goto L68;
        String r133 = (String) r131.f474983b;
    L69:
        String r134 = e(r133);
        if (r211 == true) goto L72;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L75
        Object r136 = Result.m9449constructorimpl(b(r100));     // Catch: Throwable -> L75
    L77:
        List r137 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r136) == false) goto L80;
        r136 = r137;
    L80:
        Iterator r138 = ((List) r136).iterator();
    L82:
        if (r138.hasNext() == false) goto L92;
        Object r139 = r138.next();
        ScanResult r140 = (ScanResult) r139;
        if (Intrinsics.areEqual(r140.SSID, r121) == false) goto L89;
        if (r134 == null) goto L88;
        d r141 = f552786a;
        String r142 = r140.BSSID;
        r141.getClass();
        if (Intrinsics.areEqual(e(r142), r134) == false) goto L89;
    L88:
        boolean r143 = true;
    L90:
        if (r143 == false) goto L82;
    L93:
        ScanResult r144 = (ScanResult) r139;
        int r145 = r110.getRssi();
        if ((-126) > r145) goto L97;
        if (r145 >= 0) goto L97;
        boolean r146 = true;
    L98:
        if (r146 == true) goto L100;
        Double r147 = r132;
    L101:
        Integer r148 = Integer.valueOf(r110.getFrequency());
        if (r148.intValue() <= 0) goto L104;
        r111 = true;
    L104:
        if (r111 == false) goto L106;
        Integer r149 = r148;
    L108:
        if (r144 == null) goto L111;
        r132 = Boolean.valueOf(d(r144));
    L111:
        return new e(r121, r134, r132, r147, r149);
    L106:
        r149 = r132;
        goto L108
    L100:
        r147 = Double.valueOf(WifiManager.calculateSignalLevel(r145, 101));
    L97:
        r146 = false;
    L89:
        r143 = false;
        goto L90
    L92:
        r139 = r132;
    L75:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L77
    L72:
        return new e(r121, r134, null, null, null);
    L68:
        r133 = r110.getBSSID();
    L63:
        r129 = r213 + 1;
        r128 = r214;
        r127 = r215;
        goto L57
    L64:
        r132 = null;
        r131 = new f06.d(false, null);
        goto L66
    L54:
        r126 = ApiHookConfig.f245613d;
        goto L55
    L42:
        if (Intrinsics.areEqual(r119, "<unknown ssid>") == true) goto L44;
        r120 = true;
    L47:
        r121 = null;
        goto L48
    L32:
        r117 = r110.getSSID();
    L27:
        r107 = r115 + 1;
        r106 = r116;
        r114 = r212;
        goto L21
    L28:
        r109 = new f06.d(false, null);
        goto L30
    L18:
        r105 = ApiHookConfig.f245613d;
    L7:
        th = move-exception;
        Result.Companion r151 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
