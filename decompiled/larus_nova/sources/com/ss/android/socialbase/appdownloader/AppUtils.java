package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.alipay.sdk.m.u.i;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public final class AppUtils {

    public static class AppInfo {
        private Drawable icon;
        private boolean isSystem;
        private String name;
        private String packageName;
        private String packagePath;
        private int versionCode;
        private String versionName;

        public String toString() {
            return "{\n  pkg name: " + getPackageName() + "\n  app icon: " + getIcon() + "\n  app name: " + getName() + "\n  app path: " + getPackagePath() + "\n  app v name: " + getVersionName() + "\n  app v code: " + getVersionCode() + "\n  is system: " + isSystem() + i.f25855d;
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public String getName() {
            return this.name;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getPackagePath() {
            return this.packagePath;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public boolean isSystem() {
            return this.isSystem;
        }

        public void setIcon(Drawable r100) {
            this.icon = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setPackageName(String r100) {
            this.packageName = r100;
        }

        public void setPackagePath(String r100) {
            this.packagePath = r100;
        }

        public void setSystem(boolean r100) {
            this.isSystem = r100;
        }

        public void setVersionCode(int r100) {
            this.versionCode = r100;
        }

        public void setVersionName(String r100) {
            this.versionName = r100;
        }

        public AppInfo(String r100, String r101, Drawable r102, String r103, String r104, int r105, boolean r106) {
            setName(r101);
            setIcon(r102);
            setPackageName(r100);
            setPackagePath(r103);
            setVersionName(r104);
            setVersionCode(r105);
            setSystem(r106);
        }
    }

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static AppInfo getAppInfo() {
        return getAppInfo(DownloadComponentManager.getAppContext().getPackageName());
    }

    public static int getAppVersionCode() {
        return getAppVersionCode(DownloadComponentManager.getAppContext().getPackageName());
    }

    public static String getAppVersionName() {
        return getAppVersionName(DownloadComponentManager.getAppContext().getPackageName());
    }

    public static AppInfo getApkInfo(String r100) {
        if (isSpace(r100) == false) goto L5;
        return null;
    L5:
        PackageManager r101 = DownloadComponentManager.getAppContext().getPackageManager();
        if (r101 != null) goto L8;
        return null;
    L8:
        PackageInfo r102 = r101.getPackageArchiveInfo(r100, 0);
        if (r102 != null) goto L11;
        return null;
    L11:
        ApplicationInfo r103 = r102.applicationInfo;
        r103.sourceDir = r100;
        r103.publicSourceDir = r100;
        return getBean(r101, r102);
    }

    public static AppInfo getAppInfo(String r100) {
        PackageManager r101 = DownloadComponentManager.getAppContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        return getBean(r101, r101.getPackageInfo(r100, 0));
    L8:
        return null;
    }

    public static int getAppVersionCode(String r100) {
        if (isSpace(r100) == false) goto L17;
        return -1;
    L17:
        PackageManager r101 = DownloadComponentManager.getAppContext().getPackageManager();     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L16
        if (r101 != null) goto L8;
        return -1;
    L8:
        PackageInfo r102 = r101.getPackageInfo(r100, 0);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L16
        if (r102 == null) goto L19;
        return r102.versionCode;
        goto L15
    L19:
        return -1;
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        return -1;
    }

    public static String getAppVersionName(String r100) {
        if (isSpace(r100) == false) goto L19;
        return "";
    L19:
        PackageManager r101 = DownloadComponentManager.getAppContext().getPackageManager();     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L16
        if (r101 != null) goto L8;
        return "";
    L8:
        PackageInfo r102 = r101.getPackageInfo(r100, 0);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L16
        if (r102 == null) goto L21;
        return r102.versionName;
    L21:
        return null;
    L16:
        e = move-exception;
        e.printStackTrace();
        return "";
    L13:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private static boolean isSpace(String r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        int r101 = r100.length();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (Character.isWhitespace(r100.charAt(r102)) == false) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static AppInfo getApkInfo(File r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isFile() == true) goto L6;
        return null;
    L6:
        if (r100.exists() == true) goto L9;
        return null;
    L9:
        return getApkInfo(r100.getAbsolutePath());
    }

    private static AppInfo getBean(PackageManager r100, PackageInfo r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        ApplicationInfo r101 = r110.applicationInfo;
        String r102 = r110.packageName;
        String r103 = r101.loadLabel(r100).toString();
        Drawable r104 = r101.loadIcon(r100);
        String r105 = r101.sourceDir;
        String r106 = r110.versionName;
        int r107 = r110.versionCode;
        if ((r101.flags & 1) == 0) goto L8;
        boolean r108 = true;
    L10:
        return new AppInfo(r102, r103, r104, r105, r106, r107, r108);
    L8:
        r108 = false;
        goto L10
    }
}
