package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class HarmonyUtils {
    private static String sHarmonyApiVersion;
    private static String sHarmonyBuildVersion;
    private static String sHarmonyReleaseType;
    private static String sHarmonyVersion;
    private static Boolean sPureModeEnabled;

    public HarmonyUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean checkPureModeEnabled() {
        if (sPureModeEnabled != null) goto L13;
        sPureModeEnabled = Boolean.FALSE;
        if ("156".equals(systemPropertiesExGet("ro.config.hw_optb", "0")) == true) goto L8;
    L10:
        boolean r100 = false;
    L11:
        sPureModeEnabled = Boolean.valueOf(r100);     // Catch: Exception -> L14
        goto L13
    L8:
        if ("true".equals(systemPropertiesExGet("hw_mc.pure_mode.enable", "false")) == false) goto L10;
        r100 = true;
    L13:
        return sPureModeEnabled.booleanValue();
    }

    public static String getHarmonyApiVersion() {
        if (sHarmonyApiVersion != null) goto L6;
        sHarmonyApiVersion = getHarmonySystemVersion("getApiVersion");
    L6:
        return sHarmonyApiVersion;
    }

    public static String getHarmonyBuildVersion() {
        if (sHarmonyBuildVersion != null) goto L6;
        sHarmonyBuildVersion = getHarmonySystemVersion("getBuildVersion");
    L6:
        return sHarmonyBuildVersion;
    }

    public static String getHarmonyDisplayVersion() {
        String r100 = Build.DISPLAY;
        if (TextUtils.isEmpty(r100) == true) goto L17;
        String[] r101 = r100.split(" ");
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L17;
        String r104 = r101[r103];
        if (Pattern.matches("[0-9].*", r104) == false) goto L16;
        char[] r105 = r104.toCharArray();
        int r106 = 0;
    L10:
        if (r106 >= r105.length) goto L16;
        if (r105[r106] == '(') goto L14;
        r106 = r106 + 1;
        goto L10
    L14:
        return r104.substring(0, r106);
    L16:
        r103 = r103 + 1;
    L17:
        return r100;
    }

    public static String getHarmonyReleaseType() {
        if (sHarmonyReleaseType != null) goto L6;
        sHarmonyReleaseType = getHarmonySystemVersion("getReleaseType");
    L6:
        return sHarmonyReleaseType;
    }

    public static String getHarmonyVersion() {
        if (sHarmonyVersion != null) goto L6;
        Class r100 = INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_HarmonyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L7
        sHarmonyVersion = r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{"hw_sc.build.platform.version"}).toString();     // Catch: Throwable -> L7
    L6:
        return sHarmonyVersion;
    }

    public static String getOsBrand() {
        Class r100 = INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_HarmonyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L4
        return (String) r100.getMethod("getOsBrand", new Class[0]).invoke(r100, new Object[0]);
    L4:
        return "";
    }

    public static boolean checkPureEnhancedModeEnabled() {
        if (checkPureModeEnabled() == true) goto L5;
        return false;
    L5:
        if (isHarmonyOs3(getHarmonyVersion(), getHarmonyApiVersion()) == true) goto L7;
        return false;
    L7:
        if (userHandleExGet(Process.myUid()) != 0) goto L13;
        return true;
    L13:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_HarmonyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String getHarmonySystemVersion(String r100) {
        Class r101 = INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_HarmonyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("ohos.system.version.SystemVersion");     // Catch: Throwable -> L4
        return r101.getMethod(r100, new Class[0]).invoke(r101, new Object[0]).toString();
    L4:
        return null;
    }

    public static boolean isPureEnhancedModeOpened(Context r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (readPureEnhancedModeState(r100) != 0) goto L8;
        if (checkPureEnhancedModeEnabled() == false) goto L8;
        return true;
    }

    public static boolean isPureModeOpened(Context r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (readPureModeState(r100) != 0) goto L8;
        if (checkPureModeEnabled() == false) goto L8;
        return true;
    }

    public static int readPureEnhancedModeState(Context r100) {
        if (r100 != null) goto L5;
    L8:
        return 1;
    L5:
        if (Settings.Secure.getInt(r100.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) goto L8;
        return 0;
    }

    public static int readPureModeState(Context r100) {
        if (r100 != null) goto L5;
        return 1;
    L5:
        if (isHarmonyOs3(getHarmonyVersion(), getHarmonyApiVersion()) == false) goto L11;
        if (Settings.Secure.getInt(r100.getContentResolver(), "pure_mode_state", 1) != 0) goto L9;
        return 0;
    L9:
        return 1;
    L11:
        return Settings.Secure.getInt(r100.getContentResolver(), "pure_mode_state", 0);
    }

    private static int userHandleExGet(int r100) {
        Class r101 = INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_HarmonyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.os.UserHandleEx");     // Catch: Throwable -> L5
        return ((Integer) r101.getMethod("getUserId", new Class[]{Integer.TYPE}).invoke(r101, new Object[]{Integer.valueOf(r100)})).intValue();
    L5:
        th = move-exception;
        th.printStackTrace();
        return 1;
    }

    private static boolean isHarmonyOs3(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L10;
        if (CastIntegerProtector.parseInt(r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0]) < 3) goto L10;
        return true;
    L10:
        return false;
    }

    private static String systemPropertiesExGet(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_HarmonyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.os.SystemPropertiesEx");     // Catch: Throwable -> L4
        return (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, "unknown"});
    L4:
        return r101;
    }
}
