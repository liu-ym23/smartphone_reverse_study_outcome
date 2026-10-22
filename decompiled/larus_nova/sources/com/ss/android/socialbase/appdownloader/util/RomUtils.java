package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class RomUtils {
    public static final String BRAND_HONOR = "honor";
    public static final String BRAND_HUAWEI = "huawei";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
    private static final String KEY_VERSION_MAGICUI = "ro.build.version.magic";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_ONEPLUS = "ro.rom.version";
    private static String KEY_VERSION_OPPO = "";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String MARKET_PKG_NAME_EMUI = "com.huawei.appmarket";
    public static final String MARKET_PKG_NAME_GIONEE = "com.gionee.aora.market";
    public static final String MARKET_PKG_NAME_LENOVO = "com.lenovo.leos.appstore";
    public static final String MARKET_PKG_NAME_MAGICUI = "com.hihonor.appmarket";
    public static final String MARKET_PKG_NAME_MEIZU = "com.meizu.mstore";
    public static final String MARKET_PKG_NAME_MIUI = "com.xiaomi.market";
    public static final String MARKET_PKG_NAME_NUBIA = "cn.nubia.neostore";
    public static String MARKET_PKG_NAME_OPPO = "";
    public static final String MARKET_PKG_NAME_OPPO1 = "com.heytap.market";
    public static final String MARKET_PKG_NAME_QIKU = "";
    public static final String MARKET_PKG_NAME_SAMSUNG = "com.sec.android.app.samsungapps";
    public static final String MARKET_PKG_NAME_SMARTISAN = "com.smartisanos.appstore";
    public static final String MARKET_PKG_NAME_VIVO = "com.bbk.appstore";
    public static final String MARKET_PKG_NAME_ZTE = "zte.com.market";
    public static final String OS_ANDROID = "android";
    public static final String OS_HARMONY = "harmony";
    public static final String[] PACKAGE_INSTALLERS = null;
    public static final String PACKAGE_INSTALLER_ANDROID = "com.android.packageinstaller";
    public static final String PACKAGE_INSTALLER_GOOGLE = "com.google.android.packageinstaller";
    public static final String PACKAGE_INSTALLER_SAMSUNG = "com.samsung.android.packageinstaller";
    public static final String PACKAGE_INSTALLER_XIAOMI = "com.miui.packageinstaller";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_GIONEE = "QIONEE";
    public static final String ROM_LENOVO = "LENOVO";
    public static final String ROM_MAGICUI = "MAGICUI";
    public static final String ROM_MEIZU = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_NUBIA = "NUBIA";
    public static final String ROM_ONEPLUS = "ONEPLUS";
    public static String ROM_OPPO = null;
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "SAMSUNG";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final String ROM_ZTE = "ZTE";
    private static Boolean isHarmony;
    public static String sMarketPackageName;
    private static String sMiuiVersion;
    private static String sName;
    private static String sPackageInstaller;
    private static String sVersion;

    public RomUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        PACKAGE_INSTALLERS = new String[]{PACKAGE_INSTALLER_GOOGLE, PACKAGE_INSTALLER_ANDROID, PACKAGE_INSTALLER_SAMSUNG, PACKAGE_INSTALLER_XIAOMI};
        isHarmony = null;
    }

    private static void ensureOPPO() {
        if (TextUtils.isEmpty(ROM_OPPO) == false) goto L6;
        DownloadComponentManager.ensureOPPO();
        ROM_OPPO = DownloadConstants.UPPER_OPPO;
        KEY_VERSION_OPPO = "ro.build.version." + DownloadConstants.LOWER_OPPO + "rom";
        MARKET_PKG_NAME_OPPO = "com." + DownloadConstants.LOWER_OPPO + ".market";
        return;
    }

    public static String getDisplay() {
        String r100 = Build.DISPLAY;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.trim();
    }

    public static String getManufacturer() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.trim();
    }

    public static String getMarketPackageName() {
        if (sMarketPackageName != null) goto L6;
        check("");
    L6:
        return sMarketPackageName;
    }

    public static String getName() {
        if (sName != null) goto L6;
        check("");
    L6:
        return sName;
    }

    public static String getVersion() {
        if (sVersion != null) goto L6;
        check("");
    L6:
        return sVersion;
    }

    private static void initMiuiVersion() {
        if (sMiuiVersion != null) goto L15;
        sMiuiVersion = getProp(KEY_VERSION_MIUI);     // Catch: Exception -> L6
    L8:
        String r100 = sMiuiVersion;
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        sMiuiVersion = r100;
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static boolean isEmui() {
        if (check("EMUI") == false) goto L5;
    L8:
        return true;
    L5:
        if (check(ROM_MAGICUI) == true) goto L8;
        return false;
    }

    public static boolean isFlyme() {
        return check("FLYME");
    }

    public static boolean isGionee() {
        return check(ROM_GIONEE);
    }

    public static boolean isHarmony() {
        if (isHarmony != null) goto L6;
        isHarmony = Boolean.valueOf(HarmonyUtils.getOsBrand().equals(OS_HARMONY));
    L6:
        return isHarmony.booleanValue();
    }

    public static boolean isHonorDevice() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        String r101 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L11:
        return false;
    L9:
        if (r101.toLowerCase().startsWith(BRAND_HONOR) == false) goto L11;
    L10:
        return true;
    L5:
        if (r100.toLowerCase().startsWith(BRAND_HONOR) == true) goto L10;
        goto L6
    }

    public static boolean isHuaWeiDevice() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        String r101 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L11:
        return false;
    L9:
        if (r101.toLowerCase().startsWith(BRAND_HUAWEI) == false) goto L11;
    L10:
        return true;
    L5:
        if (r100.toLowerCase().startsWith(BRAND_HUAWEI) == true) goto L10;
        goto L6
    }

    public static boolean isLenovo() {
        return check(ROM_LENOVO);
    }

    public static boolean isMagicui() {
        return check(ROM_MAGICUI);
    }

    public static boolean isMiui() {
        return check("MIUI");
    }

    public static boolean isNubia() {
        return check(ROM_NUBIA);
    }

    public static boolean isOnePlus() {
        return check(ROM_ONEPLUS);
    }

    public static boolean isQiku() {
        if (check("QIKU") == false) goto L5;
    L8:
        return true;
    L5:
        if (check(AppConstants.CHANNEL_360) == true) goto L8;
        return false;
    }

    public static boolean isSamsung() {
        return check("SAMSUNG");
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    public static boolean isZTE() {
        return check(ROM_ZTE);
    }

    public static boolean aboveMiuiV12() {
        initMiuiVersion();
        if (isMiui() == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(sMiuiVersion) == false) goto L7;
    L8:
        return true;
    L7:
        if ("V12".compareTo(sMiuiVersion.toUpperCase()) <= 0) goto L8;
        return false;
    }

    public static String getOs() {
        if (isHarmony() == false) goto L5;
        return OS_HARMONY;
    L5:
        return "android";
    }

    public static boolean isMiuiV10() {
        initMiuiVersion();
        return "V10".equals(sMiuiVersion);
    }

    public static boolean isMiuiV11() {
        initMiuiVersion();
        return "V11".equals(sMiuiVersion);
    }

    public static boolean isMiuiV12() {
        initMiuiVersion();
        return "V12".equals(sMiuiVersion);
    }

    public static boolean isMiuiV7() {
        initMiuiVersion();
        return "V7".equals(sMiuiVersion);
    }

    public static boolean isMiuiV8() {
        initMiuiVersion();
        return "V8".equals(sMiuiVersion);
    }

    public static boolean isMiuiV9() {
        initMiuiVersion();
        return "V9".equals(sMiuiVersion);
    }

    public static boolean isOppo() {
        ensureOPPO();
        return check(ROM_OPPO);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean check(String r100) {
        ensureOPPO();
        String r101 = sName;
        if (r101 != null) goto L5;
        String r102 = getProp(KEY_VERSION_MIUI);
        sVersion = r102;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        sName = "MIUI";
        sMarketPackageName = MARKET_PKG_NAME_MIUI;
        sMiuiVersion = sVersion;
    L60:
        return sName.equals(r100);
    L9:
        String r103 = getProp("ro.build.version.emui");
        sVersion = r103;
        if (TextUtils.isEmpty(r103) == false) goto L12;
        String r104 = getProp(KEY_VERSION_MAGICUI);
        sVersion = r104;
        if (TextUtils.isEmpty(r104) == true) goto L22;
        sName = ROM_MAGICUI;
        sMarketPackageName = MARKET_PKG_NAME_MAGICUI;
        goto L60
    L22:
        String r105 = getProp(KEY_VERSION_OPPO);
        sVersion = r105;
        if (TextUtils.isEmpty(r105) == true) goto L28;
        sName = ROM_OPPO;
        if (AppUtils.getAppVersionCode(MARKET_PKG_NAME_OPPO) <= (-1)) goto L27;
        sMarketPackageName = MARKET_PKG_NAME_OPPO;
        goto L60
    L27:
        sMarketPackageName = MARKET_PKG_NAME_OPPO1;
        goto L60
    L28:
        String r106 = getProp(KEY_VERSION_VIVO);
        sVersion = r106;
        if (TextUtils.isEmpty(r106) == true) goto L31;
        sName = "VIVO";
        sMarketPackageName = MARKET_PKG_NAME_VIVO;
        goto L60
    L31:
        String r107 = getProp(KEY_VERSION_SMARTISAN);
        sVersion = r107;
        if (TextUtils.isEmpty(r107) == true) goto L34;
        sName = "SMARTISAN";
        sMarketPackageName = MARKET_PKG_NAME_SMARTISAN;
        goto L60
    L34:
        String r108 = getProp(KEY_VERSION_GIONEE);
        sVersion = r108;
        if (TextUtils.isEmpty(r108) == true) goto L37;
        sName = ROM_GIONEE;
        sMarketPackageName = MARKET_PKG_NAME_GIONEE;
        goto L60
    L37:
        String r109 = getProp(KEY_VERSION_LENOVO);
        sVersion = r109;
        if (TextUtils.isEmpty(r109) == true) goto L41;
        sName = ROM_LENOVO;
        sMarketPackageName = MARKET_PKG_NAME_LENOVO;
        goto L60
    L41:
        if (getManufacturer().toUpperCase().contains("SAMSUNG") == false) goto L44;
        sName = "SAMSUNG";
        sMarketPackageName = MARKET_PKG_NAME_SAMSUNG;
        goto L60
    L44:
        if (getManufacturer().toUpperCase().contains(ROM_ZTE) == false) goto L47;
        sName = ROM_ZTE;
        sMarketPackageName = MARKET_PKG_NAME_ZTE;
        goto L60
    L47:
        if (getManufacturer().toUpperCase().contains(ROM_NUBIA) == false) goto L50;
        sName = ROM_NUBIA;
        sMarketPackageName = MARKET_PKG_NAME_NUBIA;
        goto L60
    L50:
        if (getDisplay().toUpperCase().contains("FLYME") == false) goto L53;
        sName = "FLYME";
        sMarketPackageName = MARKET_PKG_NAME_MEIZU;
        sVersion = getDisplay();
        goto L60
    L53:
        if (getManufacturer().toUpperCase().contains(ROM_ONEPLUS) == false) goto L58;
        sName = ROM_ONEPLUS;
        sVersion = getProp(KEY_VERSION_ONEPLUS);
        if (AppUtils.getAppVersionCode(MARKET_PKG_NAME_OPPO) <= (-1)) goto L57;
        sMarketPackageName = MARKET_PKG_NAME_OPPO;
        goto L60
    L57:
        sMarketPackageName = MARKET_PKG_NAME_OPPO1;
        goto L60
    L58:
        sName = getManufacturer().toUpperCase();
        sMarketPackageName = "";
        sVersion = "";
        goto L60
    L12:
        if (isHonorDevice() == false) goto L14;
        String r110 = ROM_MAGICUI;
    L15:
        sName = r110;
        if (TextUtils.equals(r110, ROM_MAGICUI) == false) goto L18;
        sMarketPackageName = MARKET_PKG_NAME_MAGICUI;
        goto L60
    L18:
        sMarketPackageName = MARKET_PKG_NAME_EMUI;
        goto L60
    L14:
        r110 = "EMUI";
        goto L15
    L5:
        return r101.equals(r100);
    }

    public static String getProp(String r100) {
        return getPropByReflect(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return getPropByCmd(r100);
    }

    public static String getPropByCmd(String r100) {
        BufferedReader r101 = new BufferedReader(new InputStreamReader(com_ss_android_socialbase_appdownloader_util_RomUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r100).getInputStream()), 1024);     // Catch: Throwable -> L7
        String r102 = r101.readLine();     // Catch: Throwable -> L10
        r101.close();     // Catch: Throwable -> L10
        DownloadUtils.safeClose(new Closeable[]{r101});
        return r102;
    L8:
        DownloadUtils.safeClose(new Closeable[]{r101});
        return null;
    L7:
        r101 = null;
        goto L8
    }

    public static String getPropByReflect(String r100) throws Throwable {
        return (String) INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{r100});
    }

    public static String getSysPackageInstaller(Context r100) {
        if (TextUtils.isEmpty(sPackageInstaller) == false) goto L6;
        sPackageInstaller = getValidPackageInstaller(r100);
    L6:
        return sPackageInstaller;
    }

    public static String getValidPackageInstaller(Context r100) {
        if (r100 == null) goto L14;
        PackageManager r101 = r100.getPackageManager();
        String[] r102 = PACKAGE_INSTALLERS;
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L14;
        String r105 = r102[r104];
        if (r101 == null) goto L13;
    L11:
        e = move-exception;
        AppDownloadUtils.addStats("getValidPackageInstaller_2", "Error:" + e);
        goto L13
    L8:
        if (r101.getPackageInfo(r105, 0) == null) goto L13;
        AppDownloadUtils.addStats("getValidPackageInstaller_1", "Get:" + r105);     // Catch: Exception -> L11
        return r105;
    L13:
        r104 = r104 + 1;
    L14:
        AppDownloadUtils.addStats("getValidPackageInstaller_3", "Not get");
        return null;
    }

    private static Process com_ss_android_socialbase_appdownloader_util_RomUtils_java_lang_Runtime_exec(Runtime r110, String r111) {
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
}
