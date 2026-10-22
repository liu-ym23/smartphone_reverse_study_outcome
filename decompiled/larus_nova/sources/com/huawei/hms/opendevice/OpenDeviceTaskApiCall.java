package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* JADX INFO: loaded from: classes23.dex */
public class OpenDeviceTaskApiCall extends TaskApiCall<OpenDeviceHmsClient, OdidResult> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 2;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50002300;
    }

    public OpenDeviceTaskApiCall(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void doExecute(OpenDeviceHmsClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<OdidResult> r110) {
        if (r101 != null) goto L5;
        r110.setException(new ApiException(new Status(1)));
        return;
    L5:
        HiAnalyticsClient.reportExit(r100.getContext(), getUri(), getTransactionId(), r101.getStatusCode(), r101.getErrorCode(), 61300300);
        if (r101.getErrorCode() != 0) goto L8;
        HMSLog.i("OpenDeviceTaskApiCall", "onResult, success");
        OdidResp r103 = new OdidResp();
        JsonUtil.jsonToEntity(r102, r103);
        OdidResult r104 = new OdidResult();
        r104.setId(r103.getId());
        r104.setStatus(new Status(0));
        r110.setResult(r104);
        return;
    L8:
        HMSLog.i("OpenDeviceTaskApiCall", "onResult, returnCode: " + r101.getErrorCode());
        r110.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<OdidResult> r103) {
        doExecute((OpenDeviceHmsClient) r100, r101, r102, r103);
    }
}
