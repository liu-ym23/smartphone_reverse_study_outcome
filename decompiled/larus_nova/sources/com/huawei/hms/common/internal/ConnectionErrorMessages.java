package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: classes23.dex */
public class ConnectionErrorMessages {
    public ConnectionErrorMessages() {
    }

    private static boolean a(Context r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (Util.isAvailableLibExist(r100) == false) goto L8;
        if (AvailableUtil.isInstallerLibExist(r100) == false) goto L8;
        return true;
    }

    public static String getErrorDialogButtonMessage(Activity r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ResourceLoaderUtil.getmContext() != null) goto L9;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
    L9:
        if (r101 == 1) goto L20;
        if (r101 == 2) goto L15;
        return ResourceLoaderUtil.getString("hms_confirm");
    L15:
        if (a(r100) == false) goto L18;
        return ResourceLoaderUtil.getString("hms_update");
    L18:
        return ResourceLoaderUtil.getString("hms_confirm");
    L20:
        if (a(r100) == false) goto L23;
        return ResourceLoaderUtil.getString("hms_install");
    L23:
        return ResourceLoaderUtil.getString("hms_confirm");
    }

    public static String getErrorMessage(Activity r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ResourceLoaderUtil.getmContext() != null) goto L9;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
    L9:
        if (r101 == 1) goto L14;
        if (r101 == 2) goto L14;
        return null;
    L14:
        if (a(r100) == false) goto L18;
        return ResourceLoaderUtil.getString("hms_update_title");
    L18:
        return r100.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), new Object[]{Util.getAppName(r100, r100.getPackageName())});
    }

    public static String getErrorTitle(Activity r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ResourceLoaderUtil.getmContext() != null) goto L9;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
    L9:
        if (r101 == 1) goto L27;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L21;
        if (r101 == 9) goto L18;
        HMSLog.e("HuaweiApiAvailability", "Unexpected error code " + r101);
        return null;
    L18:
        HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
        return null;
    L21:
        return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
    L23:
        if (a(r100) == true) goto L25;
        return null;
    L25:
        return ResourceLoaderUtil.getString("hms_update_message");
    L27:
        if (a(r100) == true) goto L29;
        return null;
    L29:
        return ResourceLoaderUtil.getString("hms_install_message");
    }
}
