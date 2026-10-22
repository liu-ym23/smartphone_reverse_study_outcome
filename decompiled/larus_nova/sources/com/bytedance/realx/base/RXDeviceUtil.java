package com.bytedance.realx.base;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class RXDeviceUtil {
    private static final String KEY_COLOROS_VERSION_NAME = "ro.build.version.opporom";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_HARMONYOS_VERSION_NAME = "hw_sc.build.platform.version";
    private static final String KEY_MAGICUI_VERSION = "ro.build.version.magic";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_NUBIA_VERSION_CODE = "ro.build.nubia.rom.code";
    private static final String KEY_NUBIA_VERSION_NAME = "ro.build.nubia.rom.name";
    private static final String KEY_ONEPLUS_VERSION_NAME = "ro.rom.version";
    private static final String KEY_VIVO_VERSION = "ro.vivo.os.version";
    private static final String KEY_VIVO_VERSION_NAME = "ro.vivo.os.name";
    private static String customOS = "";
    private static String customOSVersion = "";

    public RXDeviceUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean isHarmonyOS() {
        Class r100 = INVOKESTATIC_com_bytedance_realx_base_RXDeviceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.system.BuildEx");     // Catch: Exception -> L6
        return !TextUtils.isEmpty((String) r100.getMethod("getOsBrand", new Class[0]).invoke(r100, new Object[0]));
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean isMagicUI() {
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_realx_base_RXDeviceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String deleteSpaceAndToUpperCase(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return r100.replaceAll(" ", "").toUpperCase();
    }

    public static String getCustomOSVersion(String r100) {
        if (TextUtils.isEmpty(customOS) == false) goto L6;
        setCustomOSInfo(r100);
    L6:
        return customOSVersion;
    }

    public static String getPhoneSystem(String r100) {
        if (TextUtils.isEmpty(customOS) == false) goto L6;
        setCustomOSInfo(r100);
    L6:
        return customOS + "_" + customOSVersion;
    }

    private static String getSystemPropertyValue(String r100) {
        Class r101 = INVOKESTATIC_com_bytedance_realx_base_RXDeviceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static void setCustomOSInfo(String r100) {
        String r101 = deleteSpaceAndToUpperCase(r100);     // Catch: Exception -> L62
        switch(r101.hashCode()) {
            case -1881642058: goto L34;
            case -1706170181: goto L31;
            case -602397472: goto L28;
            case 2432928: goto L25;
            case 2634924: goto L22;
            case 68924490: goto L19;
            case 73239724: goto L16;
            case 74632627: goto L13;
            case 77852109: goto L10;
            case 2141820391: goto L7;
            default: goto L36;
        };     // Catch: Exception -> L62
    L36:
        byte r102 = -1;
    L38:
        switch(r102) {
            case 0: goto L57;
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L42;
            case 8: goto L41;
            case 9: goto L40;
            default: goto L60;
        };
    L40:
        customOS = getSystemPropertyValue(KEY_NUBIA_VERSION_NAME);     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_NUBIA_VERSION_CODE);     // Catch: Exception -> L62
        return;
    L41:
        customOS = "Flyme";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_FLYME_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L42:
        customOS = "HydrogenOS";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_ONEPLUS_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L43:
        customOS = "Funtouch";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_VIVO_VERSION);     // Catch: Exception -> L62
        return;
    L44:
        customOS = "ColorOS";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_COLOROS_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L45:
        customOS = "MIUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_MIUI_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L60:
        customOS = "Android";     // Catch: Exception -> L62
        customOSVersion = Build.VERSION.RELEASE;     // Catch: Exception -> L62
        return;
    L47:
        if (TextUtils.isEmpty(getSystemPropertyValue(KEY_MAGICUI_VERSION)) == true) goto L50;
        customOS = "MagicUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_MAGICUI_VERSION);     // Catch: Exception -> L62
        return;
    L50:
        if (isHarmonyOS() == false) goto L55;
        customOS = "HarmonyOS";     // Catch: Exception -> L62
        if (TextUtils.isEmpty(getSystemPropertyValue("hw_sc.build.platform.version")) == true) goto L54;
        customOSVersion = getSystemPropertyValue("hw_sc.build.platform.version");     // Catch: Exception -> L62
        return;
    L54:
        customOSVersion = "";     // Catch: Exception -> L62
        return;
    L55:
        customOS = "EMUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue("ro.build.version.emui");     // Catch: Exception -> L62
        return;
    L57:
        if (isHarmonyOS() == false) goto L59;
        customOSVersion = getSystemPropertyValue("hw_sc.build.platform.version");     // Catch: Exception -> L62
        customOS = "HarmonyOS";     // Catch: Exception -> L62
        return;
    L59:
        customOS = "EMUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue("ro.build.version.emui");     // Catch: Exception -> L62
        return;
    L7:
        if (r101.equals(SystemUtils.PRODUCT_HUAWEI) == false) goto L36;
        r102 = 0;
        goto L38
    L10:
        if (r101.equals("REDMI") == false) goto L36;
        r102 = 3;
        goto L38
    L13:
        if (r101.equals(RomUtils.ROM_NUBIA) == false) goto L36;
        r102 = 9;
        goto L38
    L16:
        if (r101.equals("MEIZU") == false) goto L36;
        r102 = 8;
        goto L38
    L19:
        if (r101.equals(SystemUtils.PRODUCT_HONOR) == false) goto L36;
        r102 = 1;
        goto L38
    L22:
        if (r101.equals("VIVO") == false) goto L36;
        r102 = 6;
        goto L38
    L25:
        if (r101.equals("OPPO") == false) goto L36;
        r102 = 5;
        goto L38
    L28:
        if (r101.equals(RomUtils.ROM_ONEPLUS) == false) goto L36;
        r102 = 7;
        goto L38
    L31:
        if (r101.equals("XIAOMI") == false) goto L36;
        r102 = 2;
        goto L38
    L34:
        if (r101.equals("REALME") == false) goto L36;
        r102 = 4;
    L62:
        e = move-exception;
        e.printStackTrace();
    }
}
