package pta;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jta.g;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530684a = null;

    public static class a extends e<String> {
        public a() {
        }

        @Override // pta.e
        public final String a(Object[] r110) {
            Context r100 = (Context) r110[0];
            String r101 = "";
            if (r100 == null) goto L71;
            d.a r102 = d.f530685a;
            int r103 = Build.VERSION.SDK_INT;
            if (r103 < 29) goto L7;
        L12:
            boolean r104 = true;
        L13:
            if (r104 == true) goto L15;
        L20:
            g r105 = g.f500367a;
            WifiInfo r106 = c.c((WifiManager) r100.getApplicationContext().getSystemService("wifi"));     // Catch: Exception -> L25
            String r107 = c.b(r106);     // Catch: Exception -> L25
            if (((ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L27;
            if (r107 == null) goto L27;
        L28:
            if (r106 == null) goto L34;
            f06.c r108 = new f06.c();
            Object[] r109 = new Object[0];
            f06.b r111 = new f06.b();
            f06.d r112 = r108.b(101700, "android/net/wifi/WifiInfo", "getMacAddress", r106, r109, "java.lang.String", r111);
            if (r112.f474982a == false) goto L32;
            r108.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r106, r109, null, r111, false);
            r101 = (String) r112.f474983b;
            goto L34
        L32:
            String r113 = r106.getMacAddress();
            r108.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r106, r109, r113, r111, true);
            r101 = r113;
        L34:
            if ("02:00:00:00:00:00".equals(r101) == false) goto L36;
        L57:
            Enumeration<NetworkInterface> r114 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L54
            String r115 = c.p();     // Catch: Exception -> L54
        L38:
            if (r114.hasMoreElements() == false) goto L75;
            NetworkInterface r116 = r114.nextElement();     // Catch: Exception -> L54
            byte[] r117 = c.l(r116);     // Catch: Exception -> L54
            if (r117 == null) goto L38;
            if (r117.length == 0) goto L38;
            StringBuilder r118 = new StringBuilder();     // Catch: Exception -> L54
            int r119 = r117.length;     // Catch: Exception -> L54
            int r120 = 0;
        L46:
            if (r120 >= r119) goto L49;
            r118.append(String.format("%02X:", new Object[]{Byte.valueOf(r117[r120])}));     // Catch: Exception -> L54
            r120 = r120 + 1;     // Catch: Exception -> L54
            goto L46
        L49:
            if (r118.length() <= 0) goto L51;
            r118.deleteCharAt(r118.length() - 1);     // Catch: Exception -> L54
        L51:
            String r121 = r118.toString();     // Catch: Exception -> L54
            if (r116.getName().equals(r115) == false) goto L38;
            return r121;
        L75:
            return r101;
        L54:
            e = move-exception;
            e.printStackTrace();
            return r101;
        L36:
            if (TextUtils.isEmpty(r101) == true) goto L57;
            return r101;
        L27:
            r106 = null;
        L25:
            e = move-exception;
            e.printStackTrace();
            goto L27
        L15:
            if (r100.getApplicationInfo().targetSdkVersion < 29) goto L17;
            boolean r122 = true;
        L18:
            if (r122 == false) goto L20;
            return "";
        L17:
            r122 = false;
            goto L18
        L7:
            if (r103 == 28) goto L9;
        L11:
            r104 = false;
            goto L13
        L9:
            if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L11;
        L71:
            return "";
        }
    }

    static {
        f530684a = new a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String d() {
        ArrayList r100 = new ArrayList();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101200);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r103;
        f06.d r107 = r106.preInvoke(101200, "android/os/Build", "getSerial", Build.class, r110, "java.lang.String", r111);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return Build.getSerial();
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r103 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String p() {
        Class r100 = a();     // Catch: Exception -> L5
        return (String) r100.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r100, new Object[]{"wifi.interface", "wlan0"});
    L5:
        e = move-exception;
        e.printStackTrace();
        return "wlan0";
    }

    public static String b(WifiInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101000);
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
        f06.d r106 = r105.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getSSID();
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

    public static WifiInfo c(WifiManager r110) {
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

    public static String e(ContentResolver r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, "android_id"};
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = Settings.Secure.getString(r110, "android_id");
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r113, r111, true);
        return r113;
    }

    public static String f(SubscriptionInfo r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getIccId();
        r100.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, r113, r111, true);
        return r113;
    }

    public static List g(SubscriptionManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102008);
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
        f06.d r106 = r105.preInvoke(102008, "android/telephony/SubscriptionManager", "getActiveSubscriptionInfoList", r110, r111, "java.util.List", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (List) r106.f474983b;
    L21:
        return r110.getActiveSubscriptionInfoList();
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

    public static String h(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getDeviceId();
        r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, r113, r111, true);
        return r113;
    }

    public static String k(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimSerialNumber();
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, r113, r111, true);
        return r113;
    }

    public static byte[] l(NetworkInterface r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, "byte[]", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, null, r111, false);
        return (byte[]) r112.f474983b;
    L6:
        byte[] r113 = r110.getHardwareAddress();
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, r113, r111, true);
        return r113;
    }

    public static JSONArray o(Context r100) throws JSONException {
        g r101 = g.f500367a;
        boolean r102 = g.f500371e;
        JSONArray r103 = new JSONArray();
        TelephonyManager r104 = (TelephonyManager) r100.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 26) goto L28;
        r103.put(m(n(r100, 0), 0, "unknown"));
        r103.put(m(n(r100, 1), 1, "unknown"));
    L21:
        return r103;
    L28:
        r103.put(m(j(r104, 0), 0, "meid"));     // Catch: Exception -> L6
    L26:
        r103.put(m(j(r104, 1), 1, "meid"));     // Catch: Exception -> L10
    L24:
        r103.put(m(i(r104, 0), 0, "imei"));     // Catch: Exception -> L14
    L22:
        r103.put(m(i(r104, 1), 1, "imei"));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static String q(Context r210) {
        if (r210 != null) goto L5;
        return null;
    L5:
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L8;
    L10:
        g r101 = g.f500367a;
        if (r100 >= 26) goto L13;
    L17:
        String r102 = null;
    L19:
        if (StringUtils.isEmpty(r102) == false) goto L21;
    L22:
        ArrayList r103 = new ArrayList();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(102002);
        if (r104 == null) goto L25;
        f06.a[] r105 = r104.f479473i;
    L26:
        f06.a[] r112 = r105;
        int r113 = r112.length;
        int r106 = 0;
    L28:
        if (r106 >= r113) goto L35;
        f06.a r107 = r112[r106];
        int r114 = r106;
        int r115 = r113;
        f06.a[] r211 = r112;
        f06.d r108 = r107.preInvoke(102002, "android/os/Build", "SERIAL", Build.class, r110, "java.lang.String", r111);     // Catch: Exception -> L49
        if (r108.f474982a == true) goto L37;
        r103.add(r107);     // Catch: Exception -> L49
    L37:
        if (r108.f474982a == false) goto L39;
        String r109 = (String) r108.f474983b;
    L40:
        r102 = r109;
    L42:
        if (StringUtils.isEmpty(r102) == false) goto L44;
        return "";
    L44:
        if (TextUtils.equals(r102, "unknown") == true) goto L57;
        return r102;
    L57:
        return "";
    L39:
        r109 = Build.SERIAL;
    L34:
        r106 = r114 + 1;
        r113 = r115;
        r112 = r211;
        goto L28
    L35:
        r108 = new f06.d(false, null);
        goto L37
    L25:
        r105 = ApiHookConfig.f245613d;
        goto L26
    L21:
        if (TextUtils.equals(r102, "unknown") == false) goto L42;
    L13:
        if (r210.getApplicationInfo().targetSdkVersion < 26) goto L17;
        r102 = d();     // Catch: SecurityException -> L16
    L8:
        if (r210.getApplicationInfo().targetSdkVersion < 26) goto L10;
        g r116 = g.f500367a;
        goto L10
    }

    public static String[] r(Context r100) {
        if (r100 == null) goto L34;
        d.a r101 = d.f530685a;
        int r102 = Build.VERSION.SDK_INT;
        int r103 = 0;
        if (r102 < 30) goto L7;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L35;
        g r105 = g.f500367a;
        if (r102 < 22) goto L36;
        List r106 = g(SubscriptionManager.from(r100));     // Catch: Throwable -> L29
        if (r106 != null) goto L20;
    L26:
        return null;
    L20:
        if (r106.isEmpty() == true) goto L26;
        String[] r107 = new String[r106.size()];     // Catch: Throwable -> L29
    L24:
        if (r103 >= r106.size()) goto L37;
        r107[r103] = f((SubscriptionInfo) ListProtector.get(r106, r103));     // Catch: Throwable -> L29
        r103 = r103 + 1;     // Catch: Throwable -> L29
        goto L24
    L37:
        return r107;
    L36:
        return new String[]{k((TelephonyManager) r100.getSystemService("phone"))};
    L29:
        th = move-exception;
        th.printStackTrace();
        return null;
    L35:
        return null;
    L7:
        if (r102 == 29) goto L9;
    L11:
        r104 = false;
        goto L13
    L9:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L11;
    L34:
        return null;
    }

    public static String i(TelephonyManager r110, int r111) throws JSONException {
        f06.c r100 = new f06.c();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(101601, "android/telephony/TelephonyManager", "getImei", r110, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(101601, "android/telephony/TelephonyManager", "getImei", r110, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = r110.getImei(r111);
        r100.a(101601, "android/telephony/TelephonyManager", "getImei", r110, r101, r114, r112, true);
        return r114;
    }

    public static String j(TelephonyManager r110, int r111) throws JSONException {
        f06.c r100 = new f06.c();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(101602, "android/telephony/TelephonyManager", "getMeid", r110, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(101602, "android/telephony/TelephonyManager", "getMeid", r110, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = r110.getMeid(r111);
        r100.a(101602, "android/telephony/TelephonyManager", "getMeid", r110, r101, r114, r112, true);
        return r114;
    }

    public static String n(Context r110, int r111) {
        Object r100 = null;
        TelephonyManager r112 = (TelephonyManager) r110.getSystemService("phone");     // Catch: Exception -> L24
        Class<?> r101 = r112.getClass();     // Catch: Exception -> L24
        Method[] r102 = TelephonyManager.class.getDeclaredMethods();     // Catch: Exception -> L17
        int r103 = r102.length;     // Catch: Exception -> L17
        Class<?>[] r104 = null;
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L20;
        Method r106 = r102[r105];     // Catch: Exception -> L15
        if ("getDeviceId".equals(r106.getName()) == false) goto L14;
        r104 = r106.getParameterTypes();     // Catch: Exception -> L15
        if (r104.length < 1) goto L14;
    L14:
        r105 = r105 + 1;
    L15:
        e = e;
    L19:
        e.printStackTrace();     // Catch: Exception -> L24
        e.getMessage();     // Catch: Exception -> L24
    L20:
        Method r107 = r101.getMethod("getDeviceId", r104);     // Catch: Exception -> L24
        if (r111 < 0) goto L27;
        r100 = r107.invoke(r112, new Object[]{Integer.valueOf(r111)});     // Catch: Exception -> L24
    L27:
        return (String) r100;
    L17:
        e = e;
        r104 = null;
    L24:
        e = move-exception;
        e.printStackTrace();
        e.getMessage();
        goto L27
    }

    public static JSONObject m(String r100, int r101, String r102) throws JSONException {
        JSONObject r103 = new JSONObject();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r103.put("id", r100);
        r103.put("slot_index", r101);
        r103.put("type", r102);
    L5:
        return r103;
    }
}
