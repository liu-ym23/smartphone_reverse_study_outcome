package com.larksuite.framework.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public class ApkUtil {
    private static final String FORMAT_VERSION_WITH_ALCHEMY = "%s-omega%s";
    private static final String META_DATA_KEY_ALCHEMY_VERSION_CODE = "ALCHEMY_VERSION_CODE";
    private static final String META_DATA_KEY_UPDATE_VERSION_CODE = "UPDATE_VERSION_CODE";
    private static final String TAG = "ApkUtil";
    private static int sUpdateVersionCode = -1;
    private static int sVersionCode = -1;
    private static String sVersionName;

    public ApkUtil() {
    }

    public static String getAppAlchemyVersionName(Context r100) {
        String r101 = getAppVersionName(r100);
        int r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.getInt(META_DATA_KEY_ALCHEMY_VERSION_CODE, -1);     // Catch: Exception -> L7
        if (r102 < 0) goto L12;
        return String.format(FORMAT_VERSION_WITH_ALCHEMY, new Object[]{r101, Integer.valueOf(r102)});
    L12:
        return r101;
    L7:
        e = move-exception;
        Log.w(TAG, "get alchemy version error", e);
        return r101;
    }

    public static int getAppVersionCode(Context r100) {
        int r101 = sVersionCode;
        if (r101 == (-1)) goto L11;
        return r101;
    L11:
        sVersionCode = 8020000;     // Catch: Exception -> L8
        return 8020000;
    L8:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static String getAppVersionName(Context r100) {
        String r101 = "";
        String r102 = sVersionName;
        if (r102 == null) goto L18;
        return r102;
    L18:
    L15:
        e = e;
    L16:
        Log.w(TAG, "get version name exception", e);
        return r101;
    L6:
        if (TextUtils.isEmpty("8.2.0-alpha1") == true) goto L9;
        sVersionName = "8.2.0-alpha1";     // Catch: Exception -> L15
        return "8.2.0-alpha1";
    L9:
        String r103 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 128).versionName;     // Catch: Exception -> L15
        sVersionName = r103;     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r103) == false) goto L21;
        return "";
    L21:
        return r103;
    L13:
        e = move-exception;
        r101 = r103;
        e = e;
        goto L16
    }

    public static int getUpdateVersionCode(Context r100) {
        int r101 = sUpdateVersionCode;
        if (r101 == (-1)) goto L13;
        return r101;
    L13:
        int r102 = getAppVersionCode(r100);     // Catch: Exception -> L10
        int r103 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.getInt(META_DATA_KEY_UPDATE_VERSION_CODE, r102);     // Catch: Exception -> L10
        if (r103 != r102) goto L8;
        Log.e(TAG, "getUpdateVersionCode failed, will use version code as fallback value.");     // Catch: Exception -> L10
    L8:
        sUpdateVersionCode = r103;     // Catch: Exception -> L10
        return r103;
    L10:
        e = move-exception;
        Log.e(TAG, e);
        return getAppVersionCode(r100);
    }

    public static Drawable getApkIcon(String r100, Context r101) {
        PackageManager r102 = r101.getPackageManager();
        PackageInfo r103 = r102.getPackageArchiveInfo(r100, 0);
        if (r103 == null) goto L9;
        ApplicationInfo r104 = r103.applicationInfo;
        if (r104 == null) goto L11;
        r104.sourceDir = r100;
        r104.publicSourceDir = r100;
        return r104.loadIcon(r102);
    L11:
        return null;
    L9:
        return null;
    }

    public static String getApkPackageName(Context r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageArchiveInfo(r101, 1);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.applicationInfo.packageName;
    }
}
