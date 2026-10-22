package com.huawei.hms.push.task;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class BaseVoidTask extends TaskApiCall<PushClient, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 30000000;
    }

    public BaseVoidTask(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void doExecute(PushClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        if (r101.getErrorCode() != 0) goto L5;
        HMSLog.i("BaseVoidTask", "Operate succeed");
        r103.setResult(null);
    L9:
        PushBiUtil.reportExit(r100.getContext(), getUri(), r101);
        return;
    L5:
        HMSLog.e("BaseVoidTask", "Operate failed with ret=" + r101.getErrorCode());
        ErrorEnum r104 = ErrorEnum.fromCode(r101.getErrorCode());
        if (r104 == ErrorEnum.ERROR_UNKNOWN) goto L8;
        r103.setException(r104.toApiException());
        goto L9
    L8:
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        goto L9
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        doExecute((PushClient) r100, r101, r102, r103);
    }
}
