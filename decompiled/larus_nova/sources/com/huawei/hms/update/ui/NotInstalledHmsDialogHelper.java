package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;

/* JADX INFO: loaded from: classes23.dex */
public class NotInstalledHmsDialogHelper {
    public NotInstalledHmsDialogHelper() {
    }

    private static void a(Context r100) {
        if (ResourceLoaderUtil.getmContext() != null) goto L6;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
        return;
    }

    public static String getAppName(Activity r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return a(r100, r100.getPackageName());
    }

    public static int getConfirmResId(Activity r100) {
        Checker.checkNonNull(r100, "activity must not be null");
        a(r100);
        return ResourceLoaderUtil.getStringId("hms_confirm");
    }

    public static AlertDialog.Builder getDialogBuilder(Activity r100) {
        Checker.checkNonNull(r100, "activity must not be null");
        a(r100);
        int r101 = ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints");
        String r102 = a(r100, r100.getPackageName());
        return new AlertDialog.Builder(r100, UIUtil.getDialogThemeId(r100)).setMessage(r100.getString(r101, new Object[]{r102}));
    }

    private static String a(Context r100, String r101) {
        if (r100 != null) goto L6;
        HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, context is null.");
        return "";
    L6:
        PackageManager r102 = r100.getPackageManager();
        if (r102 != null) goto L20;
        HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get 'PackageManager' instance.");
        return "";
    L20:
    L18:
        HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get app name.");
        return "";
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        r101 = r100.getPackageName();     // Catch: Throwable -> L18
    L13:
        CharSequence r103 = r102.getApplicationLabel(r102.getApplicationInfo(r101, 128));     // Catch: Throwable -> L18
        if (r103 == null) goto L22;
        return r103.toString();
    L22:
        return "";
    }
}
