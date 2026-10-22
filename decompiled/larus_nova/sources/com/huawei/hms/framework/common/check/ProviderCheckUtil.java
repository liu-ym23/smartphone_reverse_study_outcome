package com.huawei.hms.framework.common.check;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;

/* JADX INFO: loaded from: classes23.dex */
public class ProviderCheckUtil {
    private static final String TAG = "ProviderCheckUtil";

    public ProviderCheckUtil() {
    }

    public static boolean isValid(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        PackageManager r101 = ContextHolder.getAppContext().getPackageManager();
        ProviderInfo r102 = r101.resolveContentProvider(r100.getAuthority(), 0);
        if (r102 == null) goto L16;
        ApplicationInfo r103 = r102.applicationInfo;
        if (r103 == null) goto L16;
        String r104 = r103.packageName;
        Logger.v(TAG, "Target provider service's package name is : " + r104);
        if (r104 != null) goto L15;
        Logger.w(TAG, "Invalid packageName");
        return false;
    L15:
        return checkSignaturesMatch(r101, r104);
    L16:
        Logger.w(TAG, "Invalid param");
        return false;
    }

    private static boolean checkSignaturesMatch(PackageManager r100, String r101) {
        if (r100.checkSignatures("com.huawei.hwid", r101) != 0) goto L7;
        Logger.v(TAG, "Valid Provider");
        return true;
    L7:
        if (r100.checkSignatures("com.huawei.hwid.tv", r101) != 0) goto L10;
        Logger.v(TAG, "Valid Provider in tv");
        return true;
    L10:
        return false;
    }
}
