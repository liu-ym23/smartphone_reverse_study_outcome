package com.ss.android.lark.officesdk.utils;

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
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.net.NetError;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes37.dex */
public final class RomUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f437185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f437186b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f437187c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f437188d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f437189e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f437190f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f437191g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f437192h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f437193i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f437194j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f437195k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f437196l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f437197m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f437198n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f437199o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f437200p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f437201q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f437202r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f437203s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f437204t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static a f437205u;

    public static final enum RomType extends Enum<RomType> {
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RomType[] f437206a = null;
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
            f437206a = new RomType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
        }

        public static RomType[] values() {
            return (RomType[]) f437206a.clone();
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
            return (RomType) r27.a.a(RomType.class, r100);
        }

        public static RomType valueOf(int r100) {
            return forNumber(r100);
        }

        public RomType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f437207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f437208b;

        public final String toString() {
            return "RomInfo{name=" + this.f437207a + ", version=" + this.f437208b + i.f25855d;
        }

        public a() {
            this.f437207a = "";
            this.f437208b = "";
            RomType r100 = RomType.UNKNOWN;
        }
    }

    static {
        f437185a = new String[]{com.ss.android.socialbase.appdownloader.util.RomUtils.BRAND_HUAWEI};
        f437186b = new String[]{DimLocationCheckUtil.VIVO};
        f437187c = new String[]{DimLocationCheckUtil.XIAOMI};
        f437188d = new String[]{AppConstants.CHANNEL_OPPO};
        f437189e = new String[]{"leeco", "letv"};
        f437190f = new String[]{AppConstants.CHANNEL_360, "qiku"};
        f437191g = new String[]{"zte"};
        f437192h = new String[]{"oneplus"};
        f437193i = new String[]{"nubia"};
        f437194j = new String[]{"coolpad", "yulong"};
        f437195k = new String[]{"lg", "lge"};
        f437196l = new String[]{"google"};
        f437197m = new String[]{SmEditTextLeakOpt.SAMSUNG};
        f437198n = new String[]{"meizu"};
        f437199o = new String[]{"lenovo"};
        f437200p = new String[]{"smartisan"};
        f437201q = new String[]{"htc"};
        f437202r = new String[]{"sony"};
        f437203s = new String[]{"gionee", "amigo"};
        f437204t = new String[]{"motorola"};
        f437205u = null;
    }

    public static a c() {
        String r100 = "unknown";
        a r101 = f437205u;
        if (r101 == null) goto L5;
        return r101;
    L5:
        f437205u = new a();
        String r102 = Build.BRAND;     // Catch: Throwable -> L91
        if (TextUtils.isEmpty(r102) == true) goto L10;
        String r103 = r102.toLowerCase();     // Catch: Throwable -> L91
    L92:
        String r104 = Build.MANUFACTURER;     // Catch: Throwable -> L90
        if (TextUtils.isEmpty(r104) == true) goto L14;
        r100 = r104.toLowerCase();     // Catch: Throwable -> L90
    L14:
        String[] r105 = f437185a;
        if (e(r103, r100, r105) == false) goto L22;
        a r106 = f437205u;
        r106.f437207a = r105[0];
        RomType r107 = RomType.UNKNOWN;
        r106.getClass();
        String r108 = d(com.alipay.sdk.m.c.a.f25238a);
        String[] r109 = r108.split("_");
        if (r109.length <= 1) goto L19;
        f437205u.f437208b = r109[1];
    L21:
        return f437205u;
    L19:
        f437205u.f437208b = r108;
        goto L21
    L22:
        String[] r110 = f437186b;
        if (e(r103, r100, r110) == false) goto L26;
        a r111 = f437205u;
        r111.f437207a = r110[0];
        RomType r112 = RomType.UNKNOWN;
        r111.getClass();
        f437205u.f437208b = d("ro.vivo.os.build.display.id");
        return f437205u;
    L26:
        String[] r113 = f437187c;
        if (e(r103, r100, r113) == false) goto L30;
        a r114 = f437205u;
        r114.f437207a = r113[0];
        RomType r115 = RomType.UNKNOWN;
        r114.getClass();
        String r116 = d("ro.miui.ui.version.name");
        String r117 = d("ro.build.version.incremental");
        f437205u.f437208b = r116 + "_" + r117;
        return f437205u;
    L30:
        String[] r118 = f437188d;
        if (e(r103, r100, r118) == false) goto L34;
        a r119 = f437205u;
        r119.f437207a = r118[0];
        RomType r120 = RomType.UNKNOWN;
        r119.getClass();
        f437205u.f437208b = d("ro.build.version.opporom");
        return f437205u;
    L34:
        String[] r121 = f437189e;
        if (e(r103, r100, r121) == false) goto L38;
        a r122 = f437205u;
        r122.f437207a = r121[0];
        RomType r123 = RomType.UNKNOWN;
        r122.getClass();
        f437205u.f437208b = d("ro.letv.release.version");
        return f437205u;
    L38:
        String[] r124 = f437190f;
        if (e(r103, r100, r124) == false) goto L42;
        a r125 = f437205u;
        r125.f437207a = r124[0];
        RomType r126 = RomType.UNKNOWN;
        r125.getClass();
        f437205u.f437208b = d("ro.build.uiversion");
        return f437205u;
    L42:
        String[] r127 = f437191g;
        if (e(r103, r100, r127) == false) goto L46;
        a r128 = f437205u;
        r128.f437207a = r127[0];
        RomType r129 = RomType.UNKNOWN;
        r128.getClass();
        f437205u.f437208b = d("ro.build.MiFavor_version");
        return f437205u;
    L46:
        String[] r130 = f437192h;
        if (e(r103, r100, r130) == false) goto L50;
        a r131 = f437205u;
        r131.f437207a = r130[0];
        RomType r132 = RomType.UNKNOWN;
        r131.getClass();
        f437205u.f437208b = d("ro.rom.version");
        return f437205u;
    L50:
        String[] r133 = f437193i;
        if (e(r103, r100, r133) == false) goto L54;
        a r134 = f437205u;
        r134.f437207a = r133[0];
        RomType r135 = RomType.UNKNOWN;
        r134.getClass();
        f437205u.f437208b = d("ro.build.rom.id");
        return f437205u;
    L54:
        String[] r136 = f437194j;
        if (e(r103, r100, r136) == false) goto L57;
        a r137 = f437205u;
        r137.f437207a = r136[0];
        RomType r138 = RomType.UNKNOWN;
        r137.getClass();
    L88:
        f437205u.f437208b = d("");
        return f437205u;
    L57:
        String[] r139 = f437195k;
        if (e(r103, r100, r139) == false) goto L60;
        a r140 = f437205u;
        r140.f437207a = r139[0];
        RomType r141 = RomType.UNKNOWN;
        r140.getClass();
        goto L88
    L60:
        String[] r142 = f437196l;
        if (e(r103, r100, r142) == false) goto L63;
        a r143 = f437205u;
        r143.f437207a = r142[0];
        RomType r144 = RomType.UNKNOWN;
        r143.getClass();
        goto L88
    L63:
        String[] r145 = f437197m;
        if (e(r103, r100, r145) == false) goto L66;
        a r146 = f437205u;
        r146.f437207a = r145[0];
        RomType r147 = RomType.UNKNOWN;
        r146.getClass();
        goto L88
    L66:
        String[] r148 = f437198n;
        if (e(r103, r100, r148) == false) goto L69;
        a r149 = f437205u;
        r149.f437207a = r148[0];
        RomType r150 = RomType.UNKNOWN;
        r149.getClass();
        goto L88
    L69:
        String[] r151 = f437199o;
        if (e(r103, r100, r151) == false) goto L72;
        a r152 = f437205u;
        r152.f437207a = r151[0];
        RomType r153 = RomType.UNKNOWN;
        r152.getClass();
        goto L88
    L72:
        String[] r154 = f437200p;
        if (e(r103, r100, r154) == false) goto L75;
        a r155 = f437205u;
        r155.f437207a = r154[0];
        RomType r156 = RomType.UNKNOWN;
        r155.getClass();
        goto L88
    L75:
        String[] r157 = f437201q;
        if (e(r103, r100, r157) == false) goto L78;
        a r158 = f437205u;
        r158.f437207a = r157[0];
        RomType r159 = RomType.UNKNOWN;
        r158.getClass();
        goto L88
    L78:
        String[] r160 = f437202r;
        if (e(r103, r100, r160) == false) goto L81;
        a r161 = f437205u;
        r161.f437207a = r160[0];
        RomType r162 = RomType.UNKNOWN;
        r161.getClass();
        goto L88
    L81:
        String[] r163 = f437203s;
        if (e(r103, r100, r163) == false) goto L84;
        a r164 = f437205u;
        r164.f437207a = r163[0];
        RomType r165 = RomType.UNKNOWN;
        r164.getClass();
        goto L88
    L84:
        String[] r166 = f437204t;
        if (e(r103, r100, r166) == false) goto L87;
        a r167 = f437205u;
        r167.f437207a = r166[0];
        RomType r168 = RomType.UNKNOWN;
        r167.getClass();
        goto L88
    L87:
        f437205u.f437207a = r100;
    L10:
        r103 = "unknown";
        goto L92
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static String d(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L39;
        Class r102 = a("android.os.SystemProperties");     // Catch: Exception -> L6
        String r103 = (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, ""});     // Catch: Exception -> L6
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L10;
        r101 = r103;
        goto L39
    L10:
        BufferedReader r104 = null;
        BufferedReader r105 = new BufferedReader(new InputStreamReader(b(Runtime.getRuntime(), "getprop ".concat(r100)).getInputStream()), 1024);     // Catch: Throwable -> L22 IOException -> L26
        goto L27
    L66:
        String r106 = r105.readLine();     // Catch: Throwable -> L19 IOException -> L21
        if (r106 != null) goto L58;
        r105.close();     // Catch: IOException -> L30
    L62:
        goto L31
    L58:
        r105.close();     // Catch: IOException -> L16
    L33:
        if (TextUtils.isEmpty(r106) == true) goto L60;
        r101 = r106;
        goto L39
    L60:
        Properties r107 = new Properties();     // Catch: Exception -> L37
        r107.load(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(Environment.getRootDirectory(), "build.prop")));     // Catch: Exception -> L37
        r101 = r107.getProperty(r100, "");     // Catch: Exception -> L37
        goto L39
    L21:
        r104 = r105;
    L19:
        th = th;
        r104 = r105;
    L23:
        if (r104 != null) goto L56;
    L25:
        throw th;
    L56:
        r104.close();     // Catch: IOException -> L51
    L22:
        th = th;
    L31:
        r106 = "";
    L27:
        if (r104 == null) goto L31;
        r104.close();     // Catch: IOException -> L30
    L6:
        r103 = "";
    L39:
        if (TextUtils.isEmpty(r101) == false) goto L41;
    L54:
        String r108 = Build.DISPLAY;     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r108) == true) goto L48;
        r101 = r108.toLowerCase();     // Catch: Throwable -> L46
    L48:
        if (TextUtils.isEmpty(r101) == false) goto L50;
        return "unknown";
    L50:
        return r101;
    L41:
        if (r101.equals("unknown") == false) goto L48;
        goto L54
    }

    public static Process b(Runtime r110, String r111) {
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

    public static boolean f(boolean r100, Window r101) {
        Class<?> r102 = r101.getClass();     // Catch: Throwable -> L9
        Class r103 = a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L9
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

    public static boolean e(String r100, String r101, String... r102) {
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

    public static boolean g(boolean r100, Context r101, Window r102) {
        int r103 = Build.VERSION.SDK_INT;
        boolean r104 = false;
        if (r102 != null) goto L44;
    L41:
        return r104;
    L44:
    L39:
        th = move-exception;
        th.printStackTrace();
        goto L41
    L6:
        if (f437187c[0].equals(c().f437207a) == false) goto L12;
        if (r103 >= 23) goto L26;
        if (f(r100, r102) == false) goto L26;
    L23:
        r104 = true;
    L26:
        if (Build.VERSION.SDK_INT < 23) goto L37;
        View r105 = r102.getDecorView();     // Catch: Throwable -> L39
        if (com.larus.home.impl.utils.c.f346345e == false) goto L32;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L39
        Thread r106 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L39
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L32;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");     // Catch: Throwable -> L39
    L32:
        int r107 = r105.getSystemUiVisibility();     // Catch: Throwable -> L39
        if (r100 == false) goto L35;
        r105.setSystemUiVisibility(r107 | 8192);     // Catch: Throwable -> L39
    L36:
        r104 = true;
        goto L37
    L35:
        r105.setSystemUiVisibility(r107 & (-8193));     // Catch: Throwable -> L39
    L37:
        r102.clearFlags(67108864);     // Catch: Throwable -> L39
        r102.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L39
        goto L41
    L12:
        if (f437198n[0].equals(c().f437207a) == false) goto L26;
        if (r103 >= 23) goto L42;
        return false;
    L42:
        WindowManager.LayoutParams r108 = r102.getAttributes();     // Catch: Throwable -> L20
        Field r109 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L20
        if (r100 == false) goto L17;
        r109.set(r108, Integer.valueOf(r109.getInt(r108) | 512));     // Catch: Throwable -> L20
    L18:
        r102.setAttributes(r108);     // Catch: Throwable -> L20
        boolean r110 = true;
    L22:
        if (r110 == false) goto L26;
    L17:
        r109.set(r108, Integer.valueOf(r109.getInt(r108) & NetError.ERR_TTNET_FT_INVALID_STREAM));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L39
        r110 = false;
        goto L22
    }
}
