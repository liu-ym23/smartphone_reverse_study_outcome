package com.gyf.barlibrary;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public OSUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY, "");
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.emui", ""));
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_MIUI_VERSION_NAME, ""));
    }

    public static String getEMUIVersion() {
        if (isEMUI() == true) goto L5;
        return "";
    L5:
        return getSystemProperty("ro.build.version.emui", "");
    }

    public static String getFlymeOSVersion() {
        if (isFlymeOS() == true) goto L5;
        return "";
    L5:
        return getSystemProperty(KEY_DISPLAY, "");
    }

    public static String getMIUIVersion() {
        if (isMIUI() == true) goto L5;
        return "";
    L5:
        return getSystemProperty(KEY_MIUI_VERSION_NAME, "");
    }

    public static boolean isEMUI3_0() {
        if (getEMUIVersion().contains("EmotionUI_3.0") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isEMUI3_1() {
        String r100 = getEMUIVersion();
        if ("EmotionUI 3".equals(r100) == false) goto L5;
        return true;
    L5:
        if (r100.contains("EmotionUI_3.1") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isEMUI3_x() {
        if (isEMUI3_0() == false) goto L5;
    L8:
        return true;
    L5:
        if (isEMUI3_1() == true) goto L8;
        return false;
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        String r100 = getFlymeOSVersion();
        if (r100.isEmpty() == true) goto L14;
        if (r100.toLowerCase().contains("os") == false) goto L7;
        int r101 = CastIntegerProtector.valueOf(r100.substring(9, 10)).intValue();     // Catch: NumberFormatException -> L12
    L9:
        if (r101 < 4) goto L15;
        return true;
    L15:
        return false;
    L7:
        r101 = CastIntegerProtector.valueOf(r100.substring(6, 7)).intValue();     // Catch: NumberFormatException -> L12
        goto L9
    L16:
        return false;
    L14:
        return false;
    }

    public static boolean isFlymeOS5() {
        String r100 = getFlymeOSVersion();
        if (r100.isEmpty() == true) goto L14;
        if (r100.toLowerCase().contains("os") == false) goto L7;
        int r101 = CastIntegerProtector.valueOf(r100.substring(9, 10)).intValue();     // Catch: NumberFormatException -> L12
    L9:
        if (r101 != 5) goto L15;
        return true;
    L15:
        return false;
    L7:
        r101 = CastIntegerProtector.valueOf(r100.substring(6, 7)).intValue();     // Catch: NumberFormatException -> L12
        goto L9
    L16:
        return false;
    L14:
        return false;
    }

    public static boolean isMIUI6Later() {
        String r100 = getMIUIVersion();
        if (r100.isEmpty() == false) goto L11;
        return false;
    L11:
        if (CastIntegerProtector.valueOf(r100.substring(1)).intValue() < 6) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_gyf_barlibrary_OSUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String getSystemProperty(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_gyf_barlibrary_OSUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }
}
