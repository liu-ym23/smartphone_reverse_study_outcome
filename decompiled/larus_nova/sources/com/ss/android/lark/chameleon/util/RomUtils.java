package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.net.NetError;
import f06.b;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class RomUtils {
    private static final String[] ROM_360_KEY = null;
    private static final String[] ROM_COOLPAD_KEY = null;
    private static final String[] ROM_GIONEE_KEY = null;
    private static final String[] ROM_GOOGLE_KEY = null;
    private static final String[] ROM_HTC_KEY = null;
    private static final String[] ROM_HUAWEI_KEY = null;
    private static final String[] ROM_LEECO_KEY = null;
    private static final String[] ROM_LENOVO_KEY = null;
    private static final String[] ROM_LG_KEY = null;
    private static final String[] ROM_MEIZU_KEY = null;
    private static final String[] ROM_MOTOROLA_KEY = null;
    private static final String[] ROM_NUBIA_KEY = null;
    private static final String[] ROM_ONEPLUS_KEY = null;
    private static final String[] ROM_OPPO_KEY = null;
    private static final String[] ROM_SAMSUNG_KEY = null;
    private static final String[] ROM_SMARTISAN_KEY = null;
    private static final String[] ROM_SONY_KEY = null;
    private static final String[] ROM_VIVO_KEY = null;
    private static final String[] ROM_XIAOMI_KEY = null;
    private static final String[] ROM_ZTE_KEY = null;
    private static final String TAG = "RomUtils";
    private static final String UNKNOWN = "unknown";
    private static final String VERSION_PROPERTY_360 = "ro.build.uiversion";
    public static final String VERSION_PROPERTY_HARMONY = "hw_sc.build.platform.version";
    private static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    private static final String VERSION_PROPERTY_NAME_XIAOMI = "ro.miui.ui.version.name";
    private static final String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    private static final String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    private static final String VERSION_PROPERTY_OPPO = "ro.build.version.opporom";
    private static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    private static RomInfo bean;
    private static String mHarmonyVersion;
    private static boolean mHasIsHarmonyOsCache;
    private static boolean mIsHarmonyOs;
    private static boolean sCanSetStatusBar;

    public static class RomInfo {
        private String name;
        RomType romType;
        private String version;

        public String toString() {
            return "RomInfo{name=" + this.name + ", version=" + this.version + i.f25855d;
        }

        public RomInfo() {
            this.name = "";
            this.version = "";
            this.romType = RomType.UNKNOWN;
        }

        public String getBaseVersion() {
            if (RomUtils.isMiui() == false) goto L7;
            return this.name + "_" + this.version.split("_")[0];
        L7:
            return this.name + "_" + this.version;
        }

        public String getIncrementalVersion() {
            if (RomUtils.isMiui() == false) goto L8;
            String[] r100 = this.version.split("_");
            if (r100.length <= 1) goto L8;
            return r100[1];
        L8:
            return "";
        }

        public String getName() {
            return this.name;
        }

        public RomType getRomType() {
            return this.romType;
        }

        public String getVersion() {
            return this.version;
        }

        public static /* synthetic */ String access$000(RomInfo r100) {
            return r100.name;
        }

        public static /* synthetic */ String access$002(RomInfo r100, String r101) {
            r100.name = r101;
            return r101;
        }

        public static /* synthetic */ String access$102(RomInfo r100, String r101) {
            r100.version = r101;
            return r101;
        }
    }

    public static final enum RomType extends Enum<RomType> {
        private static final /* synthetic */ RomType[] $VALUES = null;
        public static final RomType ROM_360 = null;
        public static final RomType ROM_COOLPAD = null;
        public static final RomType ROM_EMUI = null;
        public static final RomType ROM_FLYME = null;
        public static final RomType ROM_GIONEE = null;
        public static final RomType ROM_GOOGLE = null;
        public static final RomType ROM_HTC = null;
        public static final RomType ROM_LEECO = null;
        public static final RomType ROM_LENOVO = null;
        public static final RomType ROM_LG = null;
        public static final RomType ROM_MIUI = null;
        public static final RomType ROM_MOTOROLA = null;
        public static final RomType ROM_NUBIA = null;
        public static final RomType ROM_ONEPLUS = null;
        public static final RomType ROM_OPPO = null;
        public static final RomType ROM_SAMSUNG = null;
        public static final RomType ROM_SMARTISAN = null;
        public static final RomType ROM_SONY = null;
        public static final RomType ROM_VIVO = null;
        public static final RomType ROM_ZTE = null;
        public static final RomType UNKNOWN = null;
        private int value;

        static {
            RomType r100 = new RomType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            RomType r101 = new RomType("ROM_EMUI", 1, 1);
            ROM_EMUI = r101;
            RomType r102 = new RomType("ROM_VIVO", 2, 2);
            ROM_VIVO = r102;
            RomType r103 = new RomType("ROM_MIUI", 3, 3);
            ROM_MIUI = r103;
            RomType r104 = new RomType("ROM_OPPO", 4, 4);
            ROM_OPPO = r104;
            RomType r105 = new RomType("ROM_LEECO", 5, 5);
            ROM_LEECO = r105;
            RomType r110 = new RomType("ROM_360", 6, 6);
            ROM_360 = r110;
            RomType r111 = new RomType("ROM_ZTE", 7, 7);
            ROM_ZTE = r111;
            RomType r112 = new RomType("ROM_ONEPLUS", 8, 8);
            ROM_ONEPLUS = r112;
            RomType r113 = new RomType("ROM_NUBIA", 9, 9);
            ROM_NUBIA = r113;
            RomType r114 = new RomType("ROM_COOLPAD", 10, 10);
            ROM_COOLPAD = r114;
            RomType r115 = new RomType("ROM_LG", 11, 11);
            ROM_LG = r115;
            RomType r106 = new RomType("ROM_GOOGLE", 12, 12);
            ROM_GOOGLE = r106;
            RomType r107 = new RomType("ROM_SAMSUNG", 13, 13);
            ROM_SAMSUNG = r107;
            RomType r108 = new RomType("ROM_FLYME", 14, 14);
            ROM_FLYME = r108;
            RomType r109 = new RomType("ROM_LENOVO", 15, 15);
            ROM_LENOVO = r109;
            RomType r116 = new RomType("ROM_SMARTISAN", 16, 16);
            ROM_SMARTISAN = r116;
            RomType r117 = new RomType("ROM_HTC", 17, 17);
            ROM_HTC = r117;
            RomType r118 = new RomType("ROM_SONY", 18, 18);
            ROM_SONY = r118;
            RomType r119 = new RomType("ROM_GIONEE", 19, 19);
            ROM_GIONEE = r119;
            RomType r120 = new RomType("ROM_MOTOROLA", 20, 20);
            ROM_MOTOROLA = r120;
            $VALUES = new RomType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
        }

        public static RomType[] values() {
            return (RomType[]) $VALUES.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static RomType forNumber(int r100) {
            switch(r100) {
                case 0: goto L46;
                case 1: goto L44;
                case 2: goto L42;
                case 3: goto L40;
                case 4: goto L38;
                case 5: goto L36;
                case 6: goto L34;
                case 7: goto L32;
                case 8: goto L30;
                case 9: goto L28;
                case 10: goto L26;
                case 11: goto L24;
                case 12: goto L22;
                case 13: goto L20;
                case 14: goto L18;
                case 15: goto L16;
                case 16: goto L14;
                case 17: goto L12;
                case 18: goto L10;
                case 19: goto L8;
                case 20: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return ROM_MOTOROLA;
        L8:
            return ROM_GIONEE;
        L10:
            return ROM_SONY;
        L12:
            return ROM_HTC;
        L14:
            return ROM_SMARTISAN;
        L16:
            return ROM_LENOVO;
        L18:
            return ROM_FLYME;
        L20:
            return ROM_SAMSUNG;
        L22:
            return ROM_GOOGLE;
        L24:
            return ROM_LG;
        L26:
            return ROM_COOLPAD;
        L28:
            return ROM_NUBIA;
        L30:
            return ROM_ONEPLUS;
        L32:
            return ROM_ZTE;
        L34:
            return ROM_360;
        L36:
            return ROM_LEECO;
        L38:
            return ROM_OPPO;
        L40:
            return ROM_MIUI;
        L42:
            return ROM_VIVO;
        L44:
            return ROM_EMUI;
        L46:
            return UNKNOWN;
        }

        public static RomType valueOf(String r100) {
            return (RomType) a.a(RomType.class, r100);
        }

        public static RomType valueOf(int r100) {
            return forNumber(r100);
        }

        private RomType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean isTNTSupported() {
        Integer r100 = (Integer) INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.SmtPCUtils").getDeclaredMethod("getProductType", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.intValue() != 1) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    static {
        ROM_HUAWEI_KEY = new String[]{com.ss.android.socialbase.appdownloader.util.RomUtils.BRAND_HUAWEI};
        ROM_VIVO_KEY = new String[]{DimLocationCheckUtil.VIVO};
        ROM_XIAOMI_KEY = new String[]{DimLocationCheckUtil.XIAOMI};
        ROM_OPPO_KEY = new String[]{AppConstants.CHANNEL_OPPO};
        ROM_LEECO_KEY = new String[]{"leeco", "letv"};
        ROM_360_KEY = new String[]{AppConstants.CHANNEL_360, "qiku"};
        ROM_ZTE_KEY = new String[]{"zte"};
        ROM_ONEPLUS_KEY = new String[]{"oneplus"};
        ROM_NUBIA_KEY = new String[]{"nubia"};
        ROM_COOLPAD_KEY = new String[]{"coolpad", "yulong"};
        ROM_LG_KEY = new String[]{"lg", "lge"};
        ROM_GOOGLE_KEY = new String[]{"google"};
        ROM_SAMSUNG_KEY = new String[]{SmEditTextLeakOpt.SAMSUNG};
        ROM_MEIZU_KEY = new String[]{"meizu"};
        ROM_LENOVO_KEY = new String[]{"lenovo"};
        ROM_SMARTISAN_KEY = new String[]{"smartisan"};
        ROM_HTC_KEY = new String[]{"htc"};
        ROM_SONY_KEY = new String[]{"sony"};
        ROM_GIONEE_KEY = new String[]{"gionee", "amigo"};
        ROM_MOTOROLA_KEY = new String[]{"motorola"};
        bean = null;
        sCanSetStatusBar = true;
    }

    private static String getBrand() {
        String r100 = Build.BRAND;     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100.toLowerCase();
    L6:
        return "unknown";
    L11:
        return "unknown";
    }

    public static String getDeviceModel() {
        return Build.MODEL.trim();
    }

    public static String getDeviceName() {
        return Build.BRAND + " " + Build.MODEL;
    }

    public static String getDeviceOS() {
        return "Android " + Build.VERSION.RELEASE;
    }

    private static String getManufacturer() {
        String r100 = Build.MANUFACTURER;     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100.toLowerCase();
    L6:
        return "unknown";
    L11:
        return "unknown";
    }

    public static RomInfo getRomInfo() {
        RomInfo r100 = bean;
        if (r100 == null) goto L5;
        return r100;
    L5:
        bean = new RomInfo();
        String r101 = getBrand();
        String r102 = getManufacturer();
        String[] r103 = ROM_HUAWEI_KEY;
        if (isRightRom(r101, r102, r103) == false) goto L13;
        RomInfo.access$002(bean, r103[0]);
        bean.romType = RomType.ROM_EMUI;
        String r104 = getRomVersion("ro.build.version.emui");
        String[] r105 = r104.split("_");
        if (r105.length <= 1) goto L10;
        RomInfo.access$102(bean, r105[1]);
    L12:
        return bean;
    L10:
        RomInfo.access$102(bean, r104);
        goto L12
    L13:
        String[] r106 = ROM_VIVO_KEY;
        if (isRightRom(r101, r102, r106) == false) goto L17;
        RomInfo.access$002(bean, r106[0]);
        bean.romType = RomType.ROM_VIVO;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_VIVO));
        return bean;
    L17:
        String[] r107 = ROM_XIAOMI_KEY;
        if (isRightRom(r101, r102, r107) == false) goto L21;
        RomInfo.access$002(bean, r107[0]);
        bean.romType = RomType.ROM_MIUI;
        String r108 = getRomVersion(VERSION_PROPERTY_NAME_XIAOMI);
        String r109 = getRomVersion(VERSION_PROPERTY_XIAOMI);
        RomInfo.access$102(bean, r108 + "_" + r109);
        return bean;
    L21:
        String[] r110 = ROM_OPPO_KEY;
        if (isRightRom(r101, r102, r110) == false) goto L25;
        RomInfo.access$002(bean, r110[0]);
        bean.romType = RomType.ROM_OPPO;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_OPPO));
        return bean;
    L25:
        String[] r111 = ROM_LEECO_KEY;
        if (isRightRom(r101, r102, r111) == false) goto L29;
        RomInfo.access$002(bean, r111[0]);
        bean.romType = RomType.ROM_LEECO;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_LEECO));
        return bean;
    L29:
        String[] r112 = ROM_360_KEY;
        if (isRightRom(r101, r102, r112) == false) goto L33;
        RomInfo.access$002(bean, r112[0]);
        bean.romType = RomType.ROM_360;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_360));
        return bean;
    L33:
        String[] r113 = ROM_ZTE_KEY;
        if (isRightRom(r101, r102, r113) == false) goto L37;
        RomInfo.access$002(bean, r113[0]);
        bean.romType = RomType.ROM_ZTE;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_ZTE));
        return bean;
    L37:
        String[] r114 = ROM_ONEPLUS_KEY;
        if (isRightRom(r101, r102, r114) == false) goto L41;
        RomInfo.access$002(bean, r114[0]);
        bean.romType = RomType.ROM_ONEPLUS;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_ONEPLUS));
        return bean;
    L41:
        String[] r115 = ROM_NUBIA_KEY;
        if (isRightRom(r101, r102, r115) == false) goto L45;
        RomInfo.access$002(bean, r115[0]);
        bean.romType = RomType.ROM_NUBIA;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_NUBIA));
        return bean;
    L45:
        String[] r116 = ROM_COOLPAD_KEY;
        if (isRightRom(r101, r102, r116) == false) goto L48;
        RomInfo.access$002(bean, r116[0]);
        bean.romType = RomType.ROM_COOLPAD;
    L79:
        RomInfo.access$102(bean, getRomVersion(""));
        return bean;
    L48:
        String[] r117 = ROM_LG_KEY;
        if (isRightRom(r101, r102, r117) == false) goto L51;
        RomInfo.access$002(bean, r117[0]);
        bean.romType = RomType.ROM_LG;
        goto L79
    L51:
        String[] r118 = ROM_GOOGLE_KEY;
        if (isRightRom(r101, r102, r118) == false) goto L54;
        RomInfo.access$002(bean, r118[0]);
        bean.romType = RomType.ROM_GOOGLE;
        goto L79
    L54:
        String[] r119 = ROM_SAMSUNG_KEY;
        if (isRightRom(r101, r102, r119) == false) goto L57;
        RomInfo.access$002(bean, r119[0]);
        bean.romType = RomType.ROM_SAMSUNG;
        goto L79
    L57:
        String[] r120 = ROM_MEIZU_KEY;
        if (isRightRom(r101, r102, r120) == false) goto L60;
        RomInfo.access$002(bean, r120[0]);
        bean.romType = RomType.ROM_FLYME;
        goto L79
    L60:
        String[] r121 = ROM_LENOVO_KEY;
        if (isRightRom(r101, r102, r121) == false) goto L63;
        RomInfo.access$002(bean, r121[0]);
        bean.romType = RomType.ROM_LENOVO;
        goto L79
    L63:
        String[] r122 = ROM_SMARTISAN_KEY;
        if (isRightRom(r101, r102, r122) == false) goto L66;
        RomInfo.access$002(bean, r122[0]);
        bean.romType = RomType.ROM_SMARTISAN;
        goto L79
    L66:
        String[] r123 = ROM_HTC_KEY;
        if (isRightRom(r101, r102, r123) == false) goto L69;
        RomInfo.access$002(bean, r123[0]);
        bean.romType = RomType.ROM_HTC;
        goto L79
    L69:
        String[] r124 = ROM_SONY_KEY;
        if (isRightRom(r101, r102, r124) == false) goto L72;
        RomInfo.access$002(bean, r124[0]);
        bean.romType = RomType.ROM_SONY;
        goto L79
    L72:
        String[] r125 = ROM_GIONEE_KEY;
        if (isRightRom(r101, r102, r125) == false) goto L75;
        RomInfo.access$002(bean, r125[0]);
        bean.romType = RomType.ROM_GIONEE;
        goto L79
    L75:
        String[] r126 = ROM_MOTOROLA_KEY;
        if (isRightRom(r101, r102, r126) == false) goto L78;
        RomInfo.access$002(bean, r126[0]);
        bean.romType = RomType.ROM_MOTOROLA;
        goto L79
    L78:
        RomInfo.access$002(bean, r102);
        goto L79
    }

    public static int getVmType() {
        if ((System.getProperty("java.vm.version").charAt(0) - '0') >= 2) goto L5;
        return 2;
    L5:
        return 1;
    }

    public static boolean is360() {
        return ROM_360_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isAndroidQOrHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 29) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isCoolpad() {
        return ROM_COOLPAD_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isFlyme() {
        return ROM_MEIZU_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isGionee() {
        return ROM_GIONEE_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isGoogle() {
        return ROM_GOOGLE_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isHarmonyOs() {
        if (mHasIsHarmonyOsCache == true) goto L10;
        Class r100 = INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L7
        mIsHarmonyOs = "Harmony".equalsIgnoreCase(r100.getMethod("getOsBrand", new Class[0]).invoke(r100, new Object[0]).toString());     // Catch: Throwable -> L7
    L8:
        mHasIsHarmonyOsCache = true;
    L7:
        mIsHarmonyOs = false;
    L10:
        return mIsHarmonyOs;
    }

    public static boolean isHtc() {
        return ROM_HTC_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isHuawei() {
        return ROM_HUAWEI_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isLeeco() {
        return ROM_LEECO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isLenovo() {
        return ROM_LENOVO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isLg() {
        return ROM_LG_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isMiui() {
        return ROM_XIAOMI_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isMotorola() {
        return ROM_MOTOROLA_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isNubia() {
        return ROM_NUBIA_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isOneplus() {
        return ROM_ONEPLUS_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isOppo() {
        return ROM_OPPO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isSamsung() {
        return ROM_SAMSUNG_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isSmartisan() {
        if (ROM_SMARTISAN_KEY[0].equals(RomInfo.access$000(getRomInfo())) == false) goto L5;
    L6:
        return true;
    L5:
        if (isTNTSupported() == true) goto L6;
        return false;
    }

    public static boolean isSony() {
        return ROM_SONY_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isVivo() {
        return ROM_VIVO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isZte() {
        return ROM_ZTE_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    private RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getHarmonyVersion() {
        if (isHarmonyOs() == true) goto L7;
        return "unknown";
    L7:
        if (mHarmonyVersion != null) goto L10;
        mHarmonyVersion = getRomVersion("hw_sc.build.platform.version");
    L10:
        return mHarmonyVersion;
    }

    public static RomType getRomType() {
        return getRomInfo().romType;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static View INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_RomUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private static String getRomVersion(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = getSystemProperty(r100);
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L19:
        String r102 = Build.DISPLAY;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r102) == true) goto L16;
        r101 = r102.toLowerCase();     // Catch: Throwable -> L14
    L16:
        if (TextUtils.isEmpty(r101) == false) goto L18;
        return "unknown";
    L18:
        return r101;
    L9:
        if (r101.equals("unknown") == false) goto L16;
    L5:
        r101 = "";
        goto L7
    }

    private static String getSystemProperty(String r100) {
        String r101 = getSystemPropertyByReflect(r100);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        String r102 = getSystemPropertyByShell(r100);
        if (TextUtils.isEmpty(r102) == true) goto L9;
        return r102;
    L9:
        return getSystemPropertyByStream(r100);
    }

    private static String getSystemPropertyByReflect(String r100) {
        Class r101 = INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r101, new Object[]{r100, ""});
    L5:
        return "";
    }

    private static String getSystemPropertyByShell(String r100) {
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(com_ss_android_lark_chameleon_util_RomUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r100).getInputStream()), 1024);     // Catch: Throwable -> L13 IOException -> L17
        String r103 = r102.readLine();     // Catch: Throwable -> L10 IOException -> L12
        if (r103 != null) goto L30;
        r102.close();     // Catch: IOException -> L23
    L25:
        return "";
    L30:
        r102.close();     // Catch: IOException -> L22
    L7:
        return r103;
    L12:
        r101 = r102;
    L10:
        th = th;
        r101 = r102;
    L14:
        if (r101 != null) goto L28;
    L16:
        throw th;
    L28:
        r101.close();     // Catch: IOException -> L24
        goto L16
    L13:
        th = th;
    L36:
        return "";
    L18:
        if (r101 == null) goto L35;
        r101.close();     // Catch: IOException -> L23
        goto L25
    L35:
        return "";
    }

    private static String getSystemPropertyByStream(String r100) {
        Properties r101 = new Properties();     // Catch: Exception -> L5
        r101.load(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(Environment.getRootDirectory(), "build.prop")));     // Catch: Exception -> L5
        return r101.getProperty(r100, "");
    L5:
        return "";
    }

    public static boolean isTargetQOrHigher(Context r100) {
        if (r100.getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }

    private static Process com_ss_android_lark_chameleon_util_RomUtils_java_lang_Runtime_exec(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
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

    public static boolean setFlymeStatusBarDarkMode(boolean r100, Window r101) {
        WindowManager.LayoutParams r102 = r101.getAttributes();     // Catch: Throwable -> L8
        Field r103 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L8
        if (r100 == false) goto L5;
        r103.set(r102, Integer.valueOf(r103.getInt(r102) | 512));     // Catch: Throwable -> L8
    L6:
        r101.setAttributes(r102);     // Catch: Throwable -> L8
        return true;
    L5:
        r103.set(r102, Integer.valueOf(r103.getInt(r102) & NetError.ERR_TTNET_FT_INVALID_STREAM));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean setMiuiStatusBarDarkMode(boolean r100, Window r101) {
        Class<?> r102 = r101.getClass();     // Catch: Throwable -> L9
        Class r103 = INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L9
        int r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r103);     // Catch: Throwable -> L9
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L9
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Throwable -> L9
        Object[] r107 = new Object[2];     // Catch: Throwable -> L9
        if (r100 == false) goto L6;
        int r108 = r104;
    L7:
        r107[0] = Integer.valueOf(r108);     // Catch: Throwable -> L9
        r107[1] = Integer.valueOf(r104);     // Catch: Throwable -> L9
        r106.invoke(r101, r107);     // Catch: Throwable -> L9
        return true;
    L6:
        r108 = 0;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean trySetStatusBarDarkOnLight(Context r100, Window r101) {
        return setStatusBarDarkMode(true, r100, r101);
    }

    public static boolean trySetStatusBarLightOnDark(Context r100, Window r101) {
        return setStatusBarDarkMode(false, r100, r101);
    }

    private static boolean isRightRom(String r100, String r101, String... r102) {
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L12;
        String r105 = r102[r104];
        if (r100.contains(r105) == true) goto L10;
        if (r101.contains(r105) == true) goto L16;
        r104 = r104 + 1;
        goto L3
    L16:
        return true;
    L10:
        return true;
    L12:
        return false;
    }

    private static boolean setStatusBarDarkMode(boolean r100, Context r101, Window r102) {
        int r103 = Build.VERSION.SDK_INT;
        boolean r104 = false;
        if (r101 == null) goto L33;
        if (r102 == null) goto L33;
    L31:
        th = move-exception;
        th.printStackTrace();
        goto L33
    L7:
        if (sCanSetStatusBar == true) goto L11;
        r102.clearFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L31
        return false;
    L11:
        if (isMiui() == false) goto L17;
        if (r103 < 23) goto L14;
    L23:
        if (r103 < 23) goto L29;
        View r105 = INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_RomUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102);     // Catch: Throwable -> L31
        int r106 = r105.getSystemUiVisibility();     // Catch: Throwable -> L31
        if (r100 == false) goto L27;
        r105.setSystemUiVisibility(r106 | 8192);     // Catch: Throwable -> L31
    L28:
        r104 = true;
        goto L29
    L27:
        r105.setSystemUiVisibility(r106 & (-8193));     // Catch: Throwable -> L31
    L29:
        r102.clearFlags(67108864);     // Catch: Throwable -> L31
        r102.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L31
        goto L33
    L14:
        if (setMiuiStatusBarDarkMode(r100, r102) == false) goto L23;
    L15:
        r104 = true;
        goto L23
    L17:
        if (isFlyme() == false) goto L23;
        if (r103 >= 23) goto L20;
        return false;
    L20:
        if (setFlymeStatusBarDarkMode(r100, r102) == false) goto L23;
    L33:
        return r104;
    }
}
