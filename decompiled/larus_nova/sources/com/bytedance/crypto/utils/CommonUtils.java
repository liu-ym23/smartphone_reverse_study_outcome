package com.bytedance.crypto.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CommonUtils {
    public static final String TAG = "CommonUtils";
    private static final HashMap<String, String> assistantAppMap = null;

    static {
        assistantAppMap = new AnonymousClass1();
    }

    public CommonUtils() {
    }

    public static boolean containsAssistantApp(String r100) {
        return assistantAppMap.containsKey(r100);
    }

    public static String getAssistantAppPkgName(String r100) {
        return assistantAppMap.get(r100);
    }

    public static List<byte[]> getContextSignature(Context r100) {
        if (r100 != null) goto L31;
        LogUtils.e(TAG, "Context is null");
        return null;
    L31:
        PackageManager r101 = r100.getPackageManager();     // Catch: Exception -> L28
        if (r101 != null) goto L10;
        LogUtils.e(TAG, "getPackageManager failed");     // Catch: Exception -> L28
        return null;
    L10:
        PackageInfo r102 = r101.getPackageInfo(r100.getPackageName(), AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: Exception -> L28
        if (r102 == null) goto L26;
        SigningInfo r103 = r102.signingInfo;     // Catch: Exception -> L28
        if (r103 == null) goto L26;
        Signature[] r104 = r103.getApkContentsSigners();     // Catch: Exception -> L28
        if (r104 != null) goto L18;
    L24:
        LogUtils.e(TAG, "getApkContentsSigners failed");     // Catch: Exception -> L28
        return null;
    L18:
        if (r104.length == 0) goto L24;
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L28
        int r106 = r104.length;     // Catch: Exception -> L28
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L23;
        r105.add(r104[r107].toByteArray());     // Catch: Exception -> L28
        r107 = r107 + 1;     // Catch: Exception -> L28
        goto L21
    L23:
        return r105;
    L26:
        LogUtils.e(TAG, "getPackageInfo failed");     // Catch: Exception -> L28
        return null;
    L28:
        e = move-exception;
        LogUtils.d(TAG, "getContextSignature failed, exception: " + e.getMessage());
        return null;
    }
}
