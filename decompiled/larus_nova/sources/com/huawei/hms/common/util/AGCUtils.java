package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public class AGCUtils {
    public AGCUtils() {
    }

    private static String a(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L23;
        HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
        return "";
    L23:
        ApplicationInfo r102 = r101.getPackageInfo(r100.getPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r102 == null) goto L16;
        Bundle r103 = r102.metaData;     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r103 == null) goto L16;
        Object r104 = r103.get(Constants.HUAWEI_HMS_CLIENT_APPID);     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r104 == null) goto L16;
        String r105 = String.valueOf(r104);     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r105.startsWith("appid=") == true) goto L15;
        return r105;
    L15:
        return r105.substring(6);
    L16:
        HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");     // Catch: RuntimeException -> L18 AndroidException -> L21
        return "";
    L21:
        HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
        return "";
    L18:
        e = move-exception;
        HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e);
        return "";
    }

    private static String b(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L23;
        HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
        return "";
    L23:
        ApplicationInfo r102 = r101.getPackageInfo(r100.getPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r102 == null) goto L16;
        Bundle r103 = r102.metaData;     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r103 == null) goto L16;
        Object r104 = r103.get("com.huawei.hms.client.cpid");     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r104 == null) goto L16;
        String r105 = String.valueOf(r104);     // Catch: RuntimeException -> L18 AndroidException -> L21
        if (r105.startsWith("cpid=") == true) goto L15;
        return r105;
    L15:
        return r105.substring(5);
    L16:
        HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");     // Catch: RuntimeException -> L18 AndroidException -> L21
        return "";
    L21:
        HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
        return "";
    L18:
        e = move-exception;
        HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e);
        return "";
    }

    private static boolean c(Context r100) {
        return r100.getPackageName().equals(HMSPackageManager.getInstance(r100).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context r100) {
        if (r100 != null) goto L7;
        HMSLog.w("AGCUtils", "getAppId context is null");
        return "";
    L7:
        if (c(r100) == false) goto L11;
        String r101 = a(r100, "client/app_id");
        if (TextUtils.isEmpty(r101) == true) goto L26;
        return r101;
    L26:
        AGConnectInstance r102 = AGConnectInstance.getInstance();     // Catch: NullPointerException -> L17
        if (r102.getContext() == r100) goto L15;
        r102 = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(r100));     // Catch: NullPointerException -> L17
    L15:
        r101 = r102.getOptions().getString("client/app_id");     // Catch: NullPointerException -> L17
    L19:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        return r101;
    L21:
        String r103 = a(r100);
        if (TextUtils.isEmpty(r103) == true) goto L25;
        return r103;
    L25:
        return a(r100, "client/app_id");
    L17:
        HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        goto L19
    L11:
        r101 = null;
        goto L26
    }

    public static String getCpId(Context r100) {
        if (r100 != null) goto L7;
        HMSLog.w("AGCUtils", "getCpId context is null");
        return "";
    L7:
        if (c(r100) == true) goto L9;
        AGConnectInstance r101 = AGConnectInstance.getInstance();     // Catch: NullPointerException -> L15
        if (r101.getContext() == r100) goto L13;
        r101 = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(r100));     // Catch: NullPointerException -> L15
    L13:
        String r102 = r101.getOptions().getString("client/cp_id");     // Catch: NullPointerException -> L15
    L17:
        if (TextUtils.isEmpty(r102) == true) goto L19;
        return r102;
    L19:
        String r103 = b(r100);
        if (TextUtils.isEmpty(r103) == true) goto L23;
        return r103;
    L23:
        return a(r100, "client/cp_id");
    L15:
        HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
        r102 = null;
        goto L17
    L9:
        return a(r100, "client/cp_id");
    }

    private static String a(Context r100, String r101) {
        InputStream r102 = null;
        AGConnectOptionsBuilder r103 = new AGConnectOptionsBuilder();     // Catch: Throwable -> L5 NullPointerException -> L7 IOException -> L9
        r102 = r100.getResources().getAssets().open("agconnect-services.json");     // Catch: Throwable -> L5 NullPointerException -> L7 IOException -> L9
        r103.setInputStream(r102);     // Catch: Throwable -> L5 NullPointerException -> L7 IOException -> L9
        String r104 = r103.build(r100).getString(r101);     // Catch: Throwable -> L5 NullPointerException -> L7 IOException -> L9
    L12:
        IOUtils.closeQuietly(r102);
        if (TextUtils.isEmpty(r104) == true) goto L15;
        return r104;
    L15:
        HMSLog.e("AGCUtils", "The " + r101 + " is null.");
        return "";
    L5:
        th = move-exception;
        IOUtils.closeQuietly(r102);
        throw th;
    L9:
        e = move-exception;
        HMSLog.e("AGCUtils", "Get " + r101 + " failed: " + e);     // Catch: Throwable -> L5
    L11:
        r104 = "";
    L7:
        e = move-exception;
        HMSLog.e("AGCUtils", "Get " + r101 + " with AGConnectServicesConfig failed: " + e);     // Catch: Throwable -> L5
        goto L11
    }
}
