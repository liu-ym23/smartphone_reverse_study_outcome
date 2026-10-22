package com.bytedance.sdk.open.aweme.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public class AppUtil {
    private static final String TAG = "AppUtil";

    public AppUtil() {
    }

    public static String buildComponentClassName(String r100, String r101) {
        return r100 + "." + r101;
    }

    public static int getPlatformSDKVersion(Context r100, String r101, String r102) {
        if (r100 != null) goto L7;
        LogUtils.w(TAG, new Object[]{"getPlatformSDKVersion: context is null"});
        return -1;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        LogUtils.w(TAG, new Object[]{"getPlatformSDKVersion: platformPackageName is " + r101});
        return -1;
    L11:
        if (isAppInstalled(r100, r101) == true) goto L25;
        LogUtils.w(TAG, new Object[]{"getPlatformSDKVersion: app has not installed " + r101});
        return -1;
    L25:
        ActivityInfo r103 = r100.getPackageManager().getActivityInfo(new ComponentName(r101, r102), 128);     // Catch: PackageManager.NameNotFoundException -> L22
        if (r103 != null) goto L17;
        LogUtils.w(TAG, new Object[]{"getPlatformSDKVersion: appInfo is null"});     // Catch: PackageManager.NameNotFoundException -> L22
    L24:
        return -1;
    L17:
        Bundle r104 = r103.metaData;     // Catch: PackageManager.NameNotFoundException -> L22
        if (r104 != null) goto L21;
        LogUtils.w(TAG, new Object[]{"getPlatformSDKVersion: appInfo.metaData is null"});     // Catch: PackageManager.NameNotFoundException -> L22
        goto L24
    L21:
        return r104.getInt(ParamKeyConstants.META_PLATFORM_SDK_VERSION, -1);
    L22:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"getPlatformSDKVersion: fail to getActivityInfo", e});
        goto L24
    }

    public static boolean isAppInstalled(Context r100, String r101) {
        if (r100 != null) goto L7;
        LogUtils.w(TAG, new Object[]{"isAppInstalled: context is null"});
        return false;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        LogUtils.w(TAG, new Object[]{"isAppInstalled: platformPackageName is " + r101});
        return false;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L21;
    L19:
        return false;
    L21:
    L17:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"isAppInstalled: fail to getPackageInfo", e});
        goto L19
    L14:
        if (r100.getPackageManager().getPackageInfo(r101, 0) != null) goto L23;
        LogUtils.w(TAG, new Object[]{"isAppInstalled: packageInfo is null"});     // Catch: Exception -> L17
        goto L19
    L23:
        return true;
    }

    public static boolean isAppSupportAPI(Context r100, String r101, String r102, int r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        return false;
    L10:
        if (isAppInstalled(r100, r101) == true) goto L12;
        return false;
    L12:
        Intent r104 = new Intent();
        r104.setComponent(new ComponentName(r101, r102));
        ActivityInfo r105 = r104.resolveActivityInfo(r100.getPackageManager(), 65536);
        int r106 = getPlatformSDKVersion(r100, r101, r102);
        if (r105 != null) goto L15;
        return false;
    L15:
        if (r105.exported == false) goto L22;
        if (r106 < r103) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    }
}
