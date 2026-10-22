package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ReadApkFileUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HuaweiMobileServicesUtil {
    public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";
    private static final int HMS_VERSION_CODE_NOMDM = 20500000;
    private static final String TAG = "HuaweiMobileServicesUtil";

    public HuaweiMobileServicesUtil() {
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context r100) {
        return "";
    }

    public static String getErrorString(int r100) {
        return HuaweiApiAvailability.getInstance().getErrorString(r100);
    }

    private static String getHMSPackageName(Context r100) {
        String r101 = HMSPackageManager.getInstance(r100).getHMSPackageName();
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return "com.huawei.hwid";
    L6:
        return r101;
    }

    public static Context getRemoteContext(Context r100) {
        return r100.createPackageContext(getHMSPackageName(r100), 2);
    L4:
        return null;
    }

    public static Resources getRemoteResource(Context r100) {
        return r100.getPackageManager().getResourcesForApplication(getHMSPackageName(r100));
    L4:
        return null;
    }

    public static int isHuaweiMobileServicesAvailable(Context r100) {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(r100);
    }

    public static boolean isUserRecoverableError(int r100) {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(r100);
    }

    public static void setApplication(Application r100) {
        ActivityMgr.INST.init(r100);
    }

    public static int isHuaweiMobileServicesAvailable(Context r110, int r111) {
        Checker.checkNonNull(r110, "context must not be null.");
        if (HMSPackageManager.getInstance(r110).isUseOldCertificate() == false) goto L6;
        HMSLog.e(TAG, "The CP uses the old certificate to terminate the connection.");
        return 13;
    L6:
        PackageManagerHelper r100 = new PackageManagerHelper(r110);
        String r101 = HMSPackageManager.getInstance(r110).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(r101) == false) goto L10;
        HMSLog.w(TAG, "hmsPackageName is empty, Service is invalid.");
        return 1;
    L10:
        HMSLog.i(TAG, "hmsPackageName is " + r101);
        PackageManagerHelper.PackageStates r102 = HMSPackageManager.getInstance(r110).getHMSPackageStatesForMultiService();
        PackageManagerHelper.PackageStates r103 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
        if (r103.equals(r102) == false) goto L14;
        HMSLog.w(TAG, "HMS is not installed");
        return 1;
    L14:
        String r104 = ReadApkFileUtil.getHmsPath(r110);
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 5) goto L29;
        if (r100.getPackageVersionCode(r101) >= HMS_VERSION_CODE_NOMDM) goto L29;
        if (ReadApkFileUtil.isCertFound(r104) == false) goto L29;
        String r112 = r100.getPackageSignature(r101);
        if ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(r112) == false) goto L23;
    L27:
        return 2;
    L23:
        if ("3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(r112) == true) goto L27;
        if ("3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(r112) == true) goto L27;
        return 9;
    L29:
        if (PackageManagerHelper.PackageStates.SPOOF.equals(r102) == false) goto L33;
        HMSLog.i(TAG, "HMS is spoofed");
        return 9;
    L33:
        if (PackageManagerHelper.PackageStates.DISABLED.equals(r102) == false) goto L37;
        HMSLog.i(TAG, "HMS is disabled");
        return 3;
    L37:
        if (r103.equals(r102) == false) goto L45;
        String r105 = r100.getPackageSignature(r101);
        if ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(r105) == true) goto L45;
        if ("3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(r105) == true) goto L45;
        if ("3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(r105) == true) goto L45;
        return 9;
    L45:
        HMSLog.i(TAG, "connect versionCode:" + HMSPackageManager.getInstance(r110).getHmsMultiServiceVersion());
        if (HMSPackageManager.getInstance(r110).isApkUpdateNecessary(r111) == false) goto L49;
        HMSLog.i(TAG, "The current version does not meet the minimum version requirements");
        return 2;
    L49:
        return 0;
    }

    public static void showErrorNotification(int r100, Context r101) {
        HuaweiApiAvailability.getInstance().showErrorNotification(r101, r100);
    }

    public static Dialog getErrorDialog(int r100, Activity r101, int r102) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(r101, r100, r102, null);
    }

    public static boolean showErrorDialogFragment(int r100, Activity r101, int r102) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(r101, r100, r102, null);
    }

    public static Dialog getErrorDialog(int r100, Activity r101, int r102, DialogInterface.OnCancelListener r103) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(r101, r100, r102, r103);
    }

    public static boolean popupErrDlgFragment(int r100, Activity r101, int r102, DialogInterface.OnCancelListener r103) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(r101, r100, r102, r103);
    }

    public static boolean popupErrDlgFragment(int r100, Activity r101, Fragment r102, int r103, DialogInterface.OnCancelListener r110) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(r101, r100, r102, r103, r110);
    }
}
