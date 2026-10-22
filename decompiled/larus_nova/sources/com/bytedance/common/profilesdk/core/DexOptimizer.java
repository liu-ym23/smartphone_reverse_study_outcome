package com.bytedance.common.profilesdk.core;

import android.os.Build;
import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.common.profilesdk.util.CmdUtils;
import com.bytedance.common.profilesdk.util.FileUtils;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.common.profilesdk.util.PathUtils;
import com.bytedance.common.profilesdk.util.VersionUtils;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class DexOptimizer {
    public static boolean compileAllSecondaryDex() {
        Logger.d("Compiling Secondary Dex with PMS");
        String[] r100 = getBgDexoptOptions(true, true);
        int r101 = 0;
    L4:
        if (r101 >= 5) goto L9;
        if (CmdUtils.execCmd(r100) == true) goto L7;
        Logger.d("pms compile try again");
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L9:
        EnsureManager.ensureNotReachHere(Arrays.toString(r100));
        return false;
    }

    public static boolean compilePrimaryDex() {
        Logger.d("Compiling Primary Dex with PMS");
        boolean r100 = false;
        String[] r101 = getBgDexoptOptions(false, true);
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L13;
        long r103 = FileUtils.getCreationTime(AppContext.getPackageImagePath());
        CmdUtils.execCmd(r101);
        if (FileUtils.getCreationTime(AppContext.getPackageImagePath()) <= r103) goto L8;
        boolean r104 = true;
    L9:
        EnsureManager.ensureTrue(r104, "Failed to update image");
        if (r104 == true) goto L11;
        r102 = r102 + 1;
        goto L4
    L11:
        Logger.d("Image update -> " + AppContext.getPackageImagePath());
        r100 = true;
        goto L13
    L8:
        r104 = false;
    L13:
        EnsureManager.ensureTrue(r100, Arrays.toString(r101));
        return r100;
    }

    public static String getOatFileExtension() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return Dex2OatHelper.ODEX_SUFFIX;
    L5:
        return Dex2OatHelper.DEX_SUFFIX;
    }

    private static void cleanupOatFiles(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L5;
        r101.delete();
    L5:
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 26) goto L8;
        String r103 = Dex2OatHelper.ODEX_SUFFIX;
    L9:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.replace(r103, Dex2OatHelper.ART_SUFFIX));
        if (r104.exists() == false) goto L12;
        r104.delete();
    L12:
        if (r102 < 26) goto L17;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100.replace(Dex2OatHelper.ODEX_SUFFIX, Dex2OatHelper.VDEX_SUFFIX));
        if (r105.exists() == false) goto L18;
        r105.delete();
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r103 = Dex2OatHelper.DEX_SUFFIX;
        goto L9
    }

    public static String[] getBgDexoptOptions(boolean r100, boolean r101) {
        ArrayList r102 = new ArrayList();
        r102.add("cmd");
        r102.add("package");
        r102.add("compile");
        if (r101 == false) goto L5;
        r102.add("-f");
    L5:
        r102.add("-r");
        r102.add("bg-dexopt");
        if (r100 == false) goto L8;
        r102.add("--secondary-dex");
    L8:
        r102.add(AppContext.getPackageName());
        return (String[]) r102.toArray(new String[r102.size()]);
    }

    public static boolean moveOatFiles(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L6;
        renameFile(r102, r101);
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L8;
        String r103 = Dex2OatHelper.ODEX_SUFFIX;
    L9:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.replace(r103, Dex2OatHelper.ART_SUFFIX));
        if (r104.exists() == false) goto L12;
        boolean r105 = renameFile(r104, r101.replace(r103, Dex2OatHelper.ART_SUFFIX));
    L13:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100.replace(r103, Dex2OatHelper.VDEX_SUFFIX));
        if (r106.exists() == false) goto L16;
        renameFile(r106, r101.replace(r103, Dex2OatHelper.VDEX_SUFFIX));
    L16:
        return r105;
    L12:
        r105 = false;
        goto L13
    L8:
        r103 = Dex2OatHelper.DEX_SUFFIX;
        goto L9
    }

    public static boolean renameFile(File r100, String r101) {
        boolean r102 = r100.renameTo(new PolarisFileWrapper(r101));
        Logger.d("renameResult : " + r102 + " from " + r100 + ", to " + r101);
        return r102;
    }

    public static boolean replaceOat(String r100, String r101) {
        boolean r102 = moveOatFiles(r100, r101);
        cleanupOatFiles(r101 + ".temp");
        return r102;
    }

    public static boolean compileFully(String r100, String r101, String r102, String r103) {
        List<String> r104 = CompileOptionsProvider.getCompileOptions(r100, r101, r102, r103);
        if (new Dex2oat.Builder().addOptions(r104).build().run() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean makeImage(String r100, String r101, String r102, String r103) {
        if (VersionUtils.supportDex2oat() == true) goto L5;
        return false;
    L5:
        String r104 = r101 + File.separator + "temp" + getOatFileExtension();
        if (compileFully(r100, r104, r102, r103) == true) goto L10;
        Logger.d("Failed to compile image");
        return false;
    L10:
        return replaceOat(r104, PathUtils.getOatFilePath(r100, r101));
    }
}
