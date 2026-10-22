package com.huawei.hms.push.task;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class AttributionReportTask extends BaseVoidTask {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60900100;
    }

    public AttributionReportTask(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask
    public void doExecute(PushClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        if (r101.getErrorCode() != 0) goto L5;
        HMSLog.i("AnalysisReportTask", "analysis report task,Operate succeed");
        r103.setResult(null);
    L12:
        PushBiUtil.reportExit(r100.getContext(), getUri(), r101);
        return;
    L5:
        HMSLog.e("AnalysisReportTask", "analysis report task,Operate failed with ret=" + r101.getErrorCode());
        ErrorEnum r104 = ErrorEnum.fromCode(r101.getErrorCode());
        if (r104 != ErrorEnum.ERROR_UNKNOWN) goto L9;
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        goto L12
    L9:
        if (r104 != ErrorEnum.ERROR_NOT_IN_SERVICE) goto L11;
        new PushPreferences(r100.getContext(), "hwpush_local_config").saveLong("analysis_last_failed_time", Long.valueOf(System.currentTimeMillis()));
        r103.setException(r104.toApiException());
        goto L12
    L11:
        r103.setException(r104.toApiException());
        goto L12
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        doExecute((PushClient) r100, r101, r102, r103);
    }
}
