package com.huawei.hms.api;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.HuaweiApiCallable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HuaweiApiAvailability {
    public static final String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
    private static final Map<String, Integer> API_MAP = null;
    public static final String APPID_HMS = "C10132067";
    public static final String APPID_HMS_TV = "C100636709";
    public static final String HMS_API_NAME_GAME = "HuaweiGame.API";
    public static final String HMS_API_NAME_IAP = "HuaweiIap.API";
    public static final String HMS_API_NAME_ID = "HuaweiID.API";
    public static final String HMS_API_NAME_OD = "HuaweiOpenDevice.API";
    public static final String HMS_API_NAME_PAY = "HuaweiPay.API";
    public static final String HMS_API_NAME_PPS = "HuaweiPPSkit.API";
    public static final String HMS_API_NAME_PUSH = "HuaweiPush.API";
    public static final String HMS_API_NAME_SNS = "HuaweiSns.API";
    public static final int HMS_JSON_VERSION_MIN = 30000000;
    public static final int HMS_SDK_VERSION_CODE = 61300301;
    public static final String HMS_SDK_VERSION_NAME = "6.13.0.301";
    public static final int HMS_VERSION_CODE_GAME = 20503000;
    public static final int HMS_VERSION_CODE_IAP = 20700300;
    public static final int HMS_VERSION_CODE_ID = 30000000;
    public static final int HMS_VERSION_CODE_KIT_UPDATE = 40000000;
    public static final int HMS_VERSION_CODE_MIN = 20503000;
    public static final int HMS_VERSION_CODE_OD = 20601000;
    public static final int HMS_VERSION_CODE_PAY = 20503000;
    public static final int HMS_VERSION_CODE_PPS = 20700300;
    public static final int HMS_VERSION_CODE_PUSH = 20503000;
    public static final int HMS_VERSION_CODE_SNS = 20503000;
    public static final int HMS_VERSION_MAX = 20600000;
    public static final int HMS_VERSION_MIN = 20503000;
    public static final int NOTICE_VERSION_CODE = 20600000;
    public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";
    public static final String SERVICES_PACKAGE = "com.huawei.hwid";
    public static final String SERVICES_PACKAGE_TV = "com.huawei.hwid.tv";
    public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    public static final String SERVICES_SIGNATURE_CAR = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static final String SERVICES_SIGNATURE_TV = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static int servicesVersionCode = 30000100;

    public HuaweiApiAvailability() {
    }

    public abstract Task<Void> checkApiAccessible(HuaweiApi<?> r100, HuaweiApi<?>... r101);

    public abstract Task<Void> checkApiAccessible(HuaweiApiCallable r100, HuaweiApiCallable... r101);

    public abstract PendingIntent getErrPendingIntent(Context r100, int r101, int r102);

    public abstract PendingIntent getErrPendingIntent(Context r100, ConnectionResult r101);

    public abstract Dialog getErrorDialog(Activity r100, int r101, int r102);

    public abstract Dialog getErrorDialog(Activity r100, int r101, int r102, DialogInterface.OnCancelListener r103);

    public abstract String getErrorString(int r100);

    public abstract Task<Void> getHuaweiServicesReady(Activity r100);

    public abstract Intent getResolveErrorIntent(Activity r100, int r101);

    public abstract PendingIntent getResolveErrorPendingIntent(Activity r100, int r101);

    public abstract int isHuaweiMobileNoticeAvailable(Context r100);

    public abstract int isHuaweiMobileServicesAvailable(Context r100);

    public abstract int isHuaweiMobileServicesAvailable(Context r100, int r101);

    public abstract boolean isUserResolvableError(int r100);

    public abstract boolean isUserResolvableError(int r100, PendingIntent r101);

    public abstract void popupErrNotification(Context r100, ConnectionResult r101);

    public abstract void resolveError(Activity r100, int r101, int r102);

    public abstract void resolveError(Activity r100, int r101, int r102, PendingIntent r103);

    public abstract boolean showErrorDialogFragment(Activity r100, int r101, int r102);

    public abstract boolean showErrorDialogFragment(Activity r100, int r101, int r102, DialogInterface.OnCancelListener r103);

    public abstract boolean showErrorDialogFragment(Activity r100, int r101, Fragment r102, int r103, DialogInterface.OnCancelListener r104);

    public abstract void showErrorNotification(Context r100, int r101);

    static {
        HashMap r100 = new HashMap();
        API_MAP = r100;
        r100.put(HMS_API_NAME_ID, 30000000);
        r100.put(HMS_API_NAME_SNS, 20503000);
        r100.put(HMS_API_NAME_PAY, 20503000);
        r100.put(HMS_API_NAME_PUSH, 20503000);
        r100.put(HMS_API_NAME_GAME, 20503000);
        r100.put(HMS_API_NAME_OD, Integer.valueOf(HMS_VERSION_CODE_OD));
        r100.put(HMS_API_NAME_IAP, 20700300);
        r100.put(HMS_API_NAME_PPS, 20700300);
    }

    public static HuaweiApiAvailability getInstance() {
        return HuaweiApiAvailabilityImpl.getInstance();
    }

    public static Map<String, Integer> getApiMap() {
        return API_MAP;
    }

    public static int getServicesVersionCode() {
        return servicesVersionCode;
    }

    public static void setServicesVersionCode(int r100) {
        servicesVersionCode = r100;
    }
}
