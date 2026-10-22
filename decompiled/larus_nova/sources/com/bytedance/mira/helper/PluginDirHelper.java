package com.bytedance.mira.helper;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.mira.Mira;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class PluginDirHelper {
    public static final String VERSION_PREFIX = "version-";
    private static File sBaseDir;

    public PluginDirHelper() {
    }

    private static void init() {
        if (sBaseDir != null) goto L6;
        PolarisFileWrapper r100 = new PolarisFileWrapper(Mira.getAppContext().getFilesDir(), n.KEY_PLUGINS);
        sBaseDir = r100;
        ensureDirExists(r100);
        return;
    }

    public static String getBaseDir() {
        init();
        return sBaseDir.getPath();
    }

    public static String getDownloadDir() {
        return ensureDirExists(new PolarisFileWrapper(Mira.getAppContext().getFilesDir(), ".patchs"));
    }

    public static String getInternalReleaseDir() {
        return ensureDirExists(new PolarisFileWrapper(Mira.getAppContext().getFilesDir(), ".internal"));
    }

    public static String getPushDir() {
        Context r100 = Mira.getAppContext();
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L15;
        File r101 = r100.getExternalFilesDir(".patchs");     // Catch: Exception -> L9
        if (r101 == null) goto L16;
        return ensureDirExists(r101);
    L16:
        return null;
    L15:
        return null;
    }

    private static String buildPath(String... r100) {
        init();
        File r101 = sBaseDir;
        if (r100 == null) goto L13;
        if (r100.length <= 0) goto L13;
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        String r104 = r100[r103];
        if (TextUtils.isEmpty(r104) == true) goto L11;
        r101 = new PolarisFileWrapper(r101, r104);
    L11:
        r103 = r103 + 1;
    L13:
        return ensureDirExists(r101);
    }

    public static String ensureDirExists(File r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.exists() == true) goto L7;
        r100.mkdirs();
    L7:
        return r100.getPath();
    }

    public static String getBackupDir(String r100) {
        return buildPath(new String[]{r100, "backup"});
    }

    public static String getBackupFile(String r100) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, "backup"}), "base-1.apk").getPath();
    }

    public static String getBackupNativeLibraryDir(String r100) {
        return buildPath(new String[]{r100, "backup", "lib"});
    }

    public static String getDataDir(String r100) {
        return buildPath(new String[]{r100, "data"});
    }

    public static String getPackageDir(String r100) {
        return buildPath(new String[]{r100});
    }

    public static String getClassDefCacheDir(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "cache", "class-def"})).getPath();
    }

    public static String getDalvikCacheDir(String r100, int r101) {
        if (OSUtil.isAndroidOHigher() == false) goto L7;
        return buildPath(new String[]{r100, VERSION_PREFIX + r101, "apk", "oat", Dex2OatHelper.getCurrentInstructionSet()});
    L7:
        return buildPath(new String[]{r100, VERSION_PREFIX + r101, "dalvik-cache"});
    }

    public static String getMainFestFile(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "main-fest"}), "android.opt.local.xml").getPath();
    }

    public static String getMainFestTmpFile(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "main-fest"}), "android.opt.local.xml.tmp").getPath();
    }

    public static String getNativeLibraryDir(String r100, int r101) {
        return buildPath(new String[]{r100, VERSION_PREFIX + r101, "lib"});
    }

    public static String getPackageVersionDir(String r100, int r101) {
        return buildPath(new String[]{r100, VERSION_PREFIX + r101});
    }

    public static String getPluginInfoCacheFile(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "cache", "plugin-info"}), "base-1.xml").getPath();
    }

    public static String getSecondaryDexesDir(String r100, int r101) {
        return buildPath(new String[]{r100, VERSION_PREFIX + r101, "secondary-dexes"});
    }

    public static String getSourceDir(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "apk"})).getPath();
    }

    public static String getSourceFile(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "apk"}), "base-1.apk").getPath();
    }

    public static String getTempDalvikCacheDir(String r100, int r101) {
        if (OSUtil.isAndroidOHigher() == false) goto L7;
        return buildPath(new String[]{r100, VERSION_PREFIX + r101, "apk", "temp", "oat", Dex2OatHelper.getCurrentInstructionSet()});
    L7:
        return buildPath(new String[]{r100, VERSION_PREFIX + r101, "dalvik-cache"});
    }

    public static String getTempPluginInfoCacheFile(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "cache", "plugin-info"}), "base-1.xml.tmp").getPath();
    }

    public static String getTempSourceDir(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "apk", "temp"})).getPath();
    }

    public static String getTempSourceFile(String r100, int r101) {
        return new PolarisFileWrapper(buildPath(new String[]{r100, VERSION_PREFIX + r101, "apk", "temp"}), "base-1.apk").getPath();
    }

    public static boolean isPackageVersionDirExists(String r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(getBaseDir());
        String r103 = File.separator;
        r102.append(r103);
        r102.append(r100);
        r102.append(r103);
        r102.append(VERSION_PREFIX);
        r102.append(r101);
        return new PolarisFileWrapper(r102.toString()).exists();
    }
}
