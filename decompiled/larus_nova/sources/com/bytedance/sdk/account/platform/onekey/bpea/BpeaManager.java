package com.bytedance.sdk.account.platform.onekey.bpea;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class BpeaManager {
    private static final String ONEKEY_SDK_BPEA_CERT_NAME = "bpea-account_onekey_request_api";
    public static final String getConnectionInfo = "getConnectionInfo";
    public static final String getNetworkOperatorName = "getNetworkOperatorName";
    public static final String getNetworkType = "getNetworkType";
    public static final String getSimOperator = "getSimOperator";
    private static IBpeaAPI iBpeaAPI = null;
    private static boolean open = true;

    public BpeaManager() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static IBpeaAPI getInstance() {
        if (iBpeaAPI != null) goto L18;
        monitor-enter(BpeaManager.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (iBpeaAPI == null) goto L21;
    L12:
        monitor-exit(BpeaManager.class);     // Catch: Throwable -> L14
        goto L18
    L21:
        iBpeaAPI = (IBpeaAPI) INVOKESTATIC_com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.sdk.account.adapter.bpea.OnekeyBpeaAdapter").newInstance();     // Catch: Exception -> L10 Throwable -> L14
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L18:
        return iBpeaAPI;
    }

    public static boolean isUsable() {
        if (getInstance() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static WifiInfo com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
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
        d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
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
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(102021, "android/telephony/TelephonyManager", getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }

    public static void setOpen(boolean r100) {
        open = r100;
    }

    public static Object directInvoke(Context r100, String r101, String r102, Object... r103) {
        int r104 = r101.hashCode();     // Catch: Throwable -> L65
        byte r105 = 0;
        if (r104 == 3649301) goto L11;
        if (r104 == 106642798) goto L8;
    L13:
        byte r106 = -1;
    L14:
        if (r106 == 0) goto L33;
        if (r106 != 1) goto L70;
        if (r100 == null) goto L71;
        WifiManager r107 = (WifiManager) r100.getSystemService(r101);     // Catch: Throwable -> L65
        if (r107 != null) goto L23;
        return null;
    L23:
        if (r102.hashCode() == 977831330) goto L26;
    L28:
        r105 = -1;
    L29:
        if (r105 == 0) goto L32;
        return null;
    L32:
        return com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_android_net_wifi_WifiManager_getConnectionInfo(r107);
    L26:
        if (r102.equals(getConnectionInfo) == false) goto L28;
    L71:
        return null;
    L70:
        return null;
    L33:
        if (r100 == null) goto L74;
        TelephonyManager r108 = (TelephonyManager) r100.getSystemService(r101);     // Catch: Throwable -> L65
        if (r108 == null) goto L75;
        int r109 = r102.hashCode();     // Catch: Throwable -> L65
        if (r109 == (-332211353)) goto L52;
        if (r109 == (-170276507)) goto L49;
        if (r109 == 1714085202) goto L46;
    L54:
        r105 = -1;
    L55:
        if (r105 == 0) goto L64;
        if (r105 == 1) goto L62;
        if (r105 == 2) goto L60;
        return null;
    L60:
        return r108.getNetworkOperatorName();
    L62:
        return com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_android_telephony_TelephonyManager_getSimOperator(r108);
    L64:
        return Integer.valueOf(r108.getNetworkType());
    L46:
        if (r102.equals(getNetworkType) == false) goto L54;
    L49:
        if (r102.equals(getSimOperator) == false) goto L54;
        r105 = 1;
        goto L55
    L52:
        if (r102.equals(getNetworkOperatorName) == false) goto L54;
        r105 = 2;
        goto L55
    L75:
        return null;
    L74:
        return null;
    L8:
        if (r101.equals("phone") == false) goto L13;
        r106 = 0;
        goto L14
    L11:
        if (r101.equals("wifi") == false) goto L13;
        r106 = 1;
    L65:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Object invokeDeviceInfoApi(Context r100, String r101, String r102, Object... r110) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return null;
    L8:
        if (isUsable() == false) goto L14;
        if (open == false) goto L14;
        return getInstance().invokeDeviceInfoApi(r100, r101, r102, ONEKEY_SDK_BPEA_CERT_NAME, r110);
    L14:
        return directInvoke(r100, r101, r102, r110);
    }
}
