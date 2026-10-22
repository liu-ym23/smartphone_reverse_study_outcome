package com.bytedance.mira.oat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.util.FileUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class Dex2OatHelper {
    public static final String APK_SUFFIX = ".apk";
    public static final String ART_SUFFIX = ".art";
    public static final String DEX_SUFFIX = ".dex";
    private static final String OAT_SP_NAME = "plugin_oat_info";
    public static final String ODEX_SUFFIX = ".odex";
    public static final String VDEX_SUFFIX = ".vdex";
    public static final String ZIP_SUFFIX = ".zip";

    public static class Dex2OatCompMode {
        public static int FASTER_ONLY_VERIFY = 1;
        public static int FASTEST_NONE = 0;
        public static int SLOWLY_ALL = 3;

        public Dex2OatCompMode() {
        }
    }

    public Dex2OatHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isOatRightVersion(int r100) {
        if (r100 >= 21) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 26) goto L7;
        return true;
    }

    public static String getCurrentInstructionSet() {
        return (String) MethodUtils.invokeStaticMethod(INVOKESTATIC_com_bytedance_mira_oat_Dex2OatHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_oat_Dex2OatHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String getOatFileExtension(String r100) {
        String r101 = r100.substring(r100.lastIndexOf("."));
        if (Build.VERSION.SDK_INT < 26) goto L5;
        String r102 = ODEX_SUFFIX;
    L7:
        if (DEX_SUFFIX.equals(r101) == false) goto L10;
        return r101;
    L10:
        if (".zip".equals(r101) == false) goto L12;
    L16:
        return r102;
    L12:
        if (".apk".equals(r101) == true) goto L16;
        return r100.concat(r102);
    L5:
        r102 = DEX_SUFFIX;
        goto L7
    }

    public static String getOatFileName(String r100) {
        String r101 = r100.substring(r100.lastIndexOf(HTTP.URL_DEFAULT) + 1);
        String r102 = r101.substring(r101.lastIndexOf("."));
        if (Build.VERSION.SDK_INT < 26) goto L5;
        String r103 = ODEX_SUFFIX;
    L7:
        if (DEX_SUFFIX.equals(r102) == false) goto L10;
        return r101;
    L10:
        if (".zip".equals(r102) == true) goto L16;
        if (".apk".equals(r102) == true) goto L16;
        return r101.concat(r103);
    L16:
        return r101.replace(r102, r103);
    L5:
        r103 = DEX_SUFFIX;
        goto L7
    }

    public static SharedPreferences getOatSharedPreferences(Context r100) {
        return r100.getApplicationContext().getSharedPreferences(OAT_SP_NAME, 0);
    }

    public static boolean execFastDex2OatCmd(String r100, String r101) {
        return execDex2OatCmd(r100, r101, Dex2OatCompMode.FASTER_ONLY_VERIFY);
    }

    public static boolean execFullDex2OatCmd(String r100, String r101) {
        return execDex2OatCmd(r100, r101, Dex2OatCompMode.SLOWLY_ALL);
    }

    public static boolean fastDex2Oat(String r100, String r101) {
        if (isOatRightVersion(Build.VERSION.SDK_INT) == true) goto L6;
        return false;
    L6:
        String r102 = r100 + File.separator + getOatFileName(r101);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == false) goto L13;
        if (ShareElfFile.checkElfFile(r103) == false) goto L13;
        return true;
    L13:
        return execFastDex2OatCmd(r101, r102);
    }

    private static void replaceOat(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L6;
        FileUtils.renameFile(r102, r101);
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L8;
        String r103 = ODEX_SUFFIX;
    L9:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.replace(r103, ART_SUFFIX));
        if (r104.exists() == false) goto L12;
        FileUtils.renameFile(r104, r101.replace(r103, ART_SUFFIX));
    L12:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100.replace(r103, VDEX_SUFFIX));
        if (r105.exists() == false) goto L16;
        FileUtils.renameFile(r105, r101.replace(r103, VDEX_SUFFIX));
        return;
    L16:
        return;
    L8:
        r103 = DEX_SUFFIX;
        goto L9
    }

    private static boolean execDex2OatCmd(String r100, String r101, int r102) {
        String r103 = new PolarisFileWrapper(r101).getParent() + File.separator + "compFully" + getOatFileExtension(r100);
        CmdUtil.execCmd(getDex2OatCommandAndParams(r100, r103, r102));
        replaceOat(r103, r101);
        return true;
    }

    public static String[] getDex2OatCommandAndParams(String r100, String r101, int r102) {
        ArrayList r103 = new ArrayList();
        r103.add("dex2oat");
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 24) goto L5;
        r103.add("--runtime-arg");
        r103.add("-classpath");
        r103.add("--runtime-arg");
        r103.add("&");
    L5:
        r103.add("--instruction-set=" + getCurrentInstructionSet());
        if (r102 != Dex2OatCompMode.FASTER_ONLY_VERIFY) goto L12;
        if (r104 <= 25) goto L10;
        r103.add("--compiler-filter=quicken");
    L18:
        r103.add("--dex-file=" + r100);
        r103.add("--oat-file=" + r101);
        return (String[]) r103.toArray(new String[r103.size()]);
    L10:
        r103.add("--compiler-filter=interpret-only");
        goto L18
    L12:
        if (r102 != Dex2OatCompMode.SLOWLY_ALL) goto L18;
        r103.add("--compiler-filter=speed");
        if (r104 < 24) goto L18;
        if (r104 >= 28) goto L18;
        r103.add("--app-image-file=" + r101.substring(0, r101.lastIndexOf(".")) + ART_SUFFIX);
        goto L18
    }
}
