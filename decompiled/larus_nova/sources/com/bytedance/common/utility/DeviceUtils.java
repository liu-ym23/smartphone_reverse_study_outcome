package com.bytedance.common.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.alipay.sdk.m.c.a;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.utility.device.SystemPropertiesUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class DeviceUtils {
    private static final Map<String, String> SYSTEM_PROPERTIES_CACHE = null;
    private static Boolean isEmui = null;
    private static int mIsFoldableScreen = -1;
    private static boolean sIsMiui;
    private static boolean sIsMiuiInited;
    private static String sName;
    private static String sVersion;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        SYSTEM_PROPERTIES_CACHE = new HashMap();
    }

    public static String getManufacturer() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.trim();
    }

    public static boolean isEmui() {
        Boolean r100 = isEmui;
        if (r100 != null) goto L5;
        boolean r101 = false;
        Method r102 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L14
        r102.setAccessible(true);     // Catch: Throwable -> L14
        Object r103 = r102.invoke(null, new Object[]{a.f25238a});     // Catch: Throwable -> L14
        if ((r103 instanceof String) == true) goto L10;
    L16:
        isEmui = Boolean.valueOf(r101);
        return r101;
    L10:
        if (StringUtils.isEmpty((String) r103) == true) goto L16;
        if ("unknown".equals((String) r103) == true) goto L16;
        r101 = true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L5:
        return r100.booleanValue();
    }

    public static boolean isFlyme() {
        return Build.DISPLAY.startsWith("Flyme");
    }

    public static boolean isHuawei() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.toUpperCase(Locale.getDefault()).contains(SystemUtils.PRODUCT_HUAWEI) == false) goto L7;
        return true;
    }

    public static boolean isMiui() {
        if (sIsMiuiInited == true) goto L10;
        if (INVOKESTATIC_com_bytedance_common_utility_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("miui.os.Build") == null) goto L8;
        sIsMiui = true;     // Catch: Exception -> L11
    L8:
        sIsMiuiInited = true;
    L10:
        return sIsMiui;
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isSamsung() {
        if (SmEditTextLeakOpt.SAMSUNG.equalsIgnoreCase(Build.BRAND) == false) goto L5;
        return true;
    L5:
        if (SmEditTextLeakOpt.SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isVivo() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        String r101 = Build.MODEL;
        if (TextUtils.isEmpty(r101) == false) goto L10;
    L12:
        String r102 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return false;
    L15:
        if (r102.toLowerCase(Locale.getDefault()).contains(DimLocationCheckUtil.VIVO) == false) goto L19;
        return true;
    L19:
        return false;
    L10:
        if (r101.toLowerCase(Locale.getDefault()).contains(DimLocationCheckUtil.VIVO) == false) goto L12;
        return true;
    L5:
        if (r100.toLowerCase(Locale.getDefault()).contains(DimLocationCheckUtil.VIVO) == false) goto L7;
        return true;
    }

    public static boolean isHuawei_Os_3x() {
        if (isHuawei() == false) goto L14;
        String r100 = getSystemProperty(a.f25238a);
        if ("EmotionUI 3".equals(r100) == false) goto L7;
    L13:
        return true;
    L7:
        if ("EmotionUI_3.1".contains(r100) == true) goto L13;
        if ("EmotionUI_3.0".contains(r100) == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_utility_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_common_utility_DeviceUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static boolean check(String r100) {
        String r101 = sName;
        if (r101 != null) goto L5;
        String r102 = getProp("ro.miui.ui.version.name");
        sVersion = r102;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        sName = "MIUI";
    L38:
        return sName.equals(r100);
    L9:
        String r103 = getProp(a.f25238a);
        sVersion = r103;
        if (TextUtils.isEmpty(r103) == true) goto L12;
        sName = "EMUI";
        goto L38
    L12:
        String r104 = getProp("ro.build.version.opporom");
        sVersion = r104;
        if (TextUtils.isEmpty(r104) == true) goto L15;
        sName = "OPPO";
        goto L38
    L15:
        String r105 = getProp("ro.vivo.os.version");
        sVersion = r105;
        if (TextUtils.isEmpty(r105) == true) goto L18;
        sName = "VIVO";
        goto L38
    L18:
        String r106 = getProp("ro.smartisan.version");
        sVersion = r106;
        if (TextUtils.isEmpty(r106) == true) goto L21;
        sName = "SMARTISAN";
        goto L38
    L21:
        String r107 = getProp("ro.gn.sv.version");
        sVersion = r107;
        if (TextUtils.isEmpty(r107) == true) goto L24;
        sName = RomUtils.ROM_GIONEE;
        goto L38
    L24:
        String r108 = getProp("ro.lenovo.lvp.version");
        sVersion = r108;
        if (TextUtils.isEmpty(r108) == true) goto L28;
        sName = RomUtils.ROM_LENOVO;
        goto L38
    L28:
        if (getManufacturer().toLowerCase(Locale.getDefault()).contains(SmEditTextLeakOpt.SAMSUNG) == false) goto L31;
        sName = SmEditTextLeakOpt.SAMSUNG;
        goto L38
    L31:
        if (getManufacturer().toLowerCase(Locale.getDefault()).contains("zte") == false) goto L33;
        sName = "zte";
        goto L38
    L33:
        String r109 = Build.DISPLAY;
        sVersion = r109;
        if (r109.toUpperCase(Locale.getDefault()).contains("FLYME") == false) goto L36;
        sName = "FLYME";
        goto L38
    L36:
        sVersion = "unknown";
        sName = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
        goto L38
    L5:
        return r101.equals(r100);
    }

    private static boolean checkHuaweiFoldableList(String r100) {
        if (TextUtils.equals(r100, "HWTAH") == false) goto L6;
        return true;
    L6:
        if (TextUtils.equals(r100, "unknownRLI") == false) goto L9;
        return true;
    L9:
        if (TextUtils.equals(r100, "unknownRHA") == false) goto L12;
        return true;
    L12:
        if (TextUtils.equals(r100, "HWTAH-C") == false) goto L14;
        return true;
    L14:
        return false;
    }

    private static boolean checkSamsungFoldableList(String r100) {
        if (TextUtils.equals(r100, "winner") == false) goto L6;
        return true;
    L6:
        if (TextUtils.equals(r100, "zodiac") == false) goto L8;
        return true;
    L8:
        return false;
    }

    private static String getDeviceType(Context r100) {
        String r101 = getSystemPropertyInSp(r100, com.larksuite.framework.utils.DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L6:
        return "phone";
    L5:
        if (r101.equals("tablet") == false) goto L6;
        return r101;
    }

    public static int getNavigationBarHeight(Context r100) {
        if (hasNavBar((Activity) r100) == true) goto L5;
        return 0;
    L5:
        return getInternalDimensionSize(r100, CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT);
    }

    public static String getProp(String r100) {
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(com_bytedance_common_utility_DeviceUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r100).getInputStream(), "UTF-8"), 1024);     // Catch: Throwable -> L13 IOException -> L20
    L35:
        String r103 = r102.readLine();     // Catch: Throwable -> L10 IOException -> L12
        r102.close();     // Catch: Throwable -> L10 IOException -> L12
        r102.close();     // Catch: IOException -> L7
    L9:
        return r103;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L10:
        th = th;
        r101 = r102;
    L14:
        if (r101 != null) goto L27;
    L19:
        throw th;
    L27:
        r101.close();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        if (r102 != null) goto L31;
    L26:
        return null;
    L31:
        r102.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L20:
        r102 = null;
    L13:
        th = th;
        goto L14
    }

    public static int getScreenHeight(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        r102.getDefaultDisplay().getMetrics(r101);
        int r103 = r102.getDefaultDisplay().getOrientation();
        if (r103 == 1) goto L9;
        if (r103 == 3) goto L9;
        return r101.heightPixels;
    L9:
        return r101.widthPixels;
    }

    public static int getScreenWidth(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        r102.getDefaultDisplay().getMetrics(r101);
        int r103 = r102.getDefaultDisplay().getOrientation();
        if (r103 == 1) goto L9;
        if (r103 == 3) goto L9;
        return r101.widthPixels;
    L9:
        return r101.heightPixels;
    }

    public static String getSystemProperty(String r100) {
        return SystemPropertiesUtils.getSystemProperty(r100);
    }

    public static boolean hasNavBar(Activity r100) {
        if (Settings.Global.getInt(r100.getContentResolver(), "force_fsg_nav_bar", 0) == 0) goto L6;
        return false;
    L6:
        if (isEmui() == true) goto L8;
    L15:
        Display r101 = r100.getWindowManager().getDefaultDisplay();
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getRealMetrics(r102);
        int r103 = r102.heightPixels;
        int r104 = r102.widthPixels;
        DisplayMetrics r105 = new DisplayMetrics();
        r101.getMetrics(r105);
        int r106 = r105.heightPixels;
        if ((r104 - r105.widthPixels) <= 0) goto L18;
    L19:
        return true;
    L18:
        if ((r103 - r106) > 0) goto L19;
        return false;
    L8:
        if (isHuawei_Os_3x() == true) goto L13;
        if (Settings.Global.getInt(r100.getContentResolver(), "navigationbar_is_min", 0) == 0) goto L15;
        return false;
    L13:
        if (Settings.System.getInt(r100.getContentResolver(), "navigationbar_is_min", 0) == 0) goto L15;
        return false;
    }

    public static boolean isFoldableScreenV2(Context r100) {
        int r101 = mIsFoldableScreen;
        if (r101 <= (-1)) goto L7;
        if (r101 <= 0) goto L23;
        return true;
    L23:
        return false;
    L7:
        mIsFoldableScreen = 0;
        if (isSamsung() == false) goto L13;
        if (checkSamsungFoldableList(Build.DEVICE) == false) goto L13;
        mIsFoldableScreen = 1;
    L20:
        if (mIsFoldableScreen <= 0) goto L24;
        return true;
    L24:
        return false;
    L13:
        if (isHuawei() == false) goto L20;
        if (checkHuaweiFoldableList(Build.DEVICE) == false) goto L17;
    L18:
        mIsFoldableScreen = 1;
        goto L20
    L17:
        if (isHwFoldableDevice(r100) == false) goto L20;
        goto L18
    }

    private static boolean isHwFoldableDevice(Context r100) {
        if (r100 == null) goto L15;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (r100.getPackageManager() == null) goto L16;
        if (r100.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    public static boolean isPad(Context r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getResources() != null) goto L6;
        return false;
    L6:
        if (r100.getResources().getConfiguration() != null) goto L9;
        return false;
    L9:
        return "tablet".equals(getDeviceType(r100));
    }

    private static Process com_bytedance_common_utility_DeviceUtils_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static int getInternalDimensionSize(Context r100, String r101) {
        int r102 = Resources.getSystem().getIdentifier(r101, "dimen", "android");     // Catch: Resources.NotFoundException -> L11
        if (r102 <= 0) goto L10;
        int r103 = r100.getResources().getDimensionPixelSize(r102);     // Catch: Resources.NotFoundException -> L11
        int r104 = Resources.getSystem().getDimensionPixelSize(r102);     // Catch: Resources.NotFoundException -> L11
        if (r104 < r103) goto L8;
        return r104;
    L8:
        return Math.round((r103 * INVOKEVIRTUAL_com_bytedance_common_utility_DeviceUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) / INVOKEVIRTUAL_com_bytedance_common_utility_DeviceUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density);
    L10:
        return 0;
    }

    public static String getSystemPropertyInSp(Context r100, String r101) {
        Map<String, String> r102 = SYSTEM_PROPERTIES_CACHE;
        monitor-enter(r102);
        String r103 = r102.get(r101);     // Catch: Throwable -> L16
        if (StringUtils.isEmpty(r103) == true) goto L21;
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r103;
    L21:
        SharedPreferences r104 = r100.getSharedPreferences("system_properties_cache", 0);     // Catch: Exception -> L12 Throwable -> L16
        r103 = r104.getString(r101, null);     // Catch: Exception -> L12 Throwable -> L16
        if (StringUtils.isEmpty(r103) == false) goto L14;
        r103 = getSystemProperty(r101);     // Catch: Exception -> L12 Throwable -> L16
        if (StringUtils.isEmpty(r103) == true) goto L14;
        SharedPreferences.Editor r105 = r104.edit();     // Catch: Exception -> L12 Throwable -> L16
        r105.putString(r101, r103);     // Catch: Exception -> L12 Throwable -> L16
        r105.apply();     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Logger.e("DeviceUtils", "getSystemProperties in sp error", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static void setMiuiStatusBarDarkMode(boolean r100, Window r101) {
        Class<?> r102 = r101.getClass();     // Catch: Throwable -> L8
        Class r103 = INVOKESTATIC_com_bytedance_common_utility_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        int r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r103);     // Catch: Throwable -> L8
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L8
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Throwable -> L8
        Object[] r107 = new Object[2];     // Catch: Throwable -> L8
        if (r100 == false) goto L5;
        int r108 = r104;
    L6:
        r107[0] = Integer.valueOf(r108);     // Catch: Throwable -> L8
        r107[1] = Integer.valueOf(r104);     // Catch: Throwable -> L8
        r106.invoke(r101, r107);     // Catch: Throwable -> L8
        return;
    L5:
        r108 = 0;
    L8:
        th = move-exception;
        th.printStackTrace();
    }
}
