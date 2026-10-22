package com.huawei.hms.common.api;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class AvailabilityException extends Exception {
    private static final String TAG = "AvailabilityException";
    private String message;

    public AvailabilityException() {
        this.message = null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    private ConnectionResult generateConnectionResult(int r100) {
        HMSLog.i(TAG, "The availability check result is: " + r100);
        setMessage(r100);
        return new ConnectionResult(r100);
    }

    private void setMessage(int r100) {
        if (r100 == 21) goto L16;
        if (r100 != 0) goto L6;
        this.message = "success";
        return;
    L6:
        if (r100 != 1) goto L8;
        this.message = "SERVICE_MISSING";
        return;
    L8:
        if (r100 != 2) goto L10;
        this.message = "SERVICE_VERSION_UPDATE_REQUIRED";
        return;
    L10:
        if (r100 == 3) goto L12;
        this.message = "INTERNAL_ERROR";
        return;
    L12:
        this.message = "SERVICE_DISABLED";
        return;
    L16:
        this.message = "ANDROID_VERSION_UNSUPPORT";
    }

    public ConnectionResult getConnectionResult(HuaweiApiCallable r100) {
        if (r100 != null) goto L4;
    L8:
        HMSLog.e(TAG, "The huaweiApi is null.");
        return generateConnectionResult(8);
    L4:
        if (r100.getHuaweiApi() == null) goto L8;
        Context r101 = r100.getHuaweiApi().getContext();
        return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(r101, 30000000));
    }

    public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> r100) {
        if (r100 != null) goto L5;
        HMSLog.e(TAG, "The huaweiApi is null.");
        return generateConnectionResult(8);
    L5:
        Context r101 = r100.getContext();
        return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(r101, 30000000));
    }
}
