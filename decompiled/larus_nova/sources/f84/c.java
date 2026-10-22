package f84;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.t;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import f06.d;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o0 f475869a;

    public List<SubscriptionInfo> c() {
        if (Build.VERSION.SDK_INT < 22) goto L24;
        SubscriptionManager r100 = SubscriptionManager.from(this.f475869a.getContext());
        ArrayList r110 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102008);
        if (r101 == null) goto L7;
        f06.a[] r102 = r101.f479473i;
    L8:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L17;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.a[] r210 = r113;
        d r106 = r105.preInvoke(102008, "android/telephony/SubscriptionManager", "getActiveSubscriptionInfoList", r100, r111, "java.util.List", r112);     // Catch: Exception -> L25
        if (r106.f474982a == true) goto L19;
        r110.add(r105);     // Catch: Exception -> L25
    L19:
        if (r106.f474982a == false) goto L22;
        return (List) r106.f474983b;
    L22:
        return r100.getActiveSubscriptionInfoList();
    L16:
        r104 = r114 + 1;
        r103 = r115;
        r113 = r210;
        goto L10
    L17:
        r106 = new d(false, null);
        goto L19
    L7:
        r102 = ApiHookConfig.f245613d;
        goto L8
    L24:
        return null;
    }

    public WifiInfo d() {
        WifiManager r100 = (WifiManager) this.f475869a.getContext().getApplicationContext().getSystemService("wifi");
        ArrayList r110 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r113 = r105;
        int r114 = r104;
        f06.a[] r115 = r103;
        d r107 = r106.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r100, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r110.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L20;
        return (WifiInfo) r107.f474983b;
    L20:
        return r100.getConnectionInfo();
    L14:
        r105 = r113 + 1;
        r104 = r114;
        r103 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public String f() {
        TelephonyManager r100 = this.f475869a.N;
        f06.c r101 = new f06.c();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r101.b(101600, "android/telephony/TelephonyManager", "getDeviceId", r100, r110, "java.lang.String", r111);
        if (r112.f474982a == false) goto L5;
        r101.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r100, r110, null, r111, false);
        return (String) r112.f474983b;
    L5:
        String r113 = r100.getDeviceId();
        r101.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r100, r110, r113, r111, true);
        return r113;
    }

    public String m() {
        return this.f475869a.N.getNetworkOperator();
    }

    public String n() {
        return this.f475869a.N.getNetworkOperatorName();
    }

    public String p() {
        if (Build.VERSION.SDK_INT < 26) goto L26;
        if (this.f475869a.getContext().getApplicationInfo().targetSdkVersion < 26) goto L35;
        ArrayList r100 = new ArrayList();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101200);
        if (r101 == null) goto L9;
        f06.a[] r102 = r101.f479473i;
    L10:
        f06.a[] r112 = r102;
        int r103 = r112.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L19;
        f06.a r105 = r112[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r115 = r112;
        d r106 = r105.preInvoke(101200, "android/os/Build", "getSerial", Build.class, r110, "java.lang.String", r111);     // Catch: Exception -> L28
        if (r106.f474982a == true) goto L21;
        r100.add(r105);     // Catch: Exception -> L28
    L21:
        if (r106.f474982a == false) goto L24;
        return (String) r106.f474983b;
    L24:
        return Build.getSerial();
    L18:
        r104 = r113 + 1;
        r103 = r114;
        r112 = r115;
        goto L12
    L19:
        r106 = new d(false, null);
        goto L21
    L9:
        r102 = ApiHookConfig.f245613d;
        goto L10
    L35:
        return "";
    L26:
        return "";
    }

    public String q() {
        return this.f475869a.N.getSimCountryIso();
    }

    public String r() {
        return a(this.f475869a.N);
    L4:
        t.a("getSSN , no permission, ignore");
        return "";
    }

    public String e() {
        return Locale.getDefault().getCountry();
    }

    public Enumeration<NetworkInterface> l() {
        return NetworkInterface.getNetworkInterfaces();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public c() {
    }

    public static String a(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimSerialNumber();
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, r113, r111, true);
        return r113;
    }

    public static byte[] b(NetworkInterface r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, "byte[]", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, null, r111, false);
        return (byte[]) r112.f474983b;
    L6:
        byte[] r113 = r110.getHardwareAddress();
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, r113, r111, true);
        return r113;
    }

    public byte[] g(NetworkInterface r100) {
        return b(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return new byte[0];
    }

    public String h(SubscriptionInfo r110) {
        if (Build.VERSION.SDK_INT < 22) goto L9;
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L7;
        r100.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L7:
        String r113 = r110.getIccId();
        r100.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, r113, r111, true);
        return r113;
    L9:
        return "";
    }

    public String i(int r110) {
        TelephonyManager r100 = this.f475869a.N;
        f06.c r101 = new f06.c();
        Object[] r111 = {Integer.valueOf(r110)};
        f06.b r112 = new f06.b();
        d r113 = r101.b(101601, "android/telephony/TelephonyManager", "getImei", r100, r111, "java.lang.String", r112);
        if (r113.f474982a == false) goto L5;
        r101.a(101601, "android/telephony/TelephonyManager", "getImei", r100, r111, null, r112, false);
        return (String) r113.f474983b;
    L5:
        String r114 = r100.getImei(r110);
        r101.a(101601, "android/telephony/TelephonyManager", "getImei", r100, r111, r114, r112, true);
        return r114;
    }

    public String j(WifiInfo r110) {
        if (r110 == null) goto L8;
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(101700, "android/net/wifi/WifiInfo", "getMacAddress", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getMacAddress();
        r100.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r110, r101, r113, r111, true);
        return r113;
    L8:
        return "";
    }

    public String k(int r110) {
        TelephonyManager r100 = this.f475869a.N;
        f06.c r101 = new f06.c();
        Object[] r111 = {Integer.valueOf(r110)};
        f06.b r112 = new f06.b();
        d r113 = r101.b(101602, "android/telephony/TelephonyManager", "getMeid", r100, r111, "java.lang.String", r112);
        if (r113.f474982a == false) goto L5;
        r101.a(101602, "android/telephony/TelephonyManager", "getMeid", r100, r111, null, r112, false);
        return (String) r113.f474983b;
    L5:
        String r114 = r100.getMeid(r110);
        r101.a(101602, "android/telephony/TelephonyManager", "getMeid", r100, r111, r114, r112, true);
        return r114;
    }

    public String o(WifiInfo r110) {
        if (r110 == null) goto L22;
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101000);
        if (r101 == null) goto L6;
        f06.a[] r102 = r101.f479473i;
    L7:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L16;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L24
        if (r106.f474982a == true) goto L18;
        r100.add(r105);     // Catch: Exception -> L24
    L18:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getSSID();
    L15:
        r104 = r114 + 1;
        r103 = r115;
        goto L9
    L16:
        r106 = new d(false, null);
        goto L18
    L6:
        r102 = ApiHookConfig.f245613d;
        goto L7
    L22:
        return "";
    }
}
