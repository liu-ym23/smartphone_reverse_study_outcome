package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* JADX INFO: loaded from: classes23.dex */
public class f extends TaskApiCall<PushClient, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DeleteTokenReq f277531a;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        if (this.f277531a.isMultiSender() == false) goto L6;
        return 50004300;
    L6:
        return 30000000;
    }

    public f(String r100, DeleteTokenReq r101, String r102) {
        super(r100, JsonUtil.createJsonString(r101), r102);
        this.f277531a = r101;
    }

    public void a(PushClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        if (r101.getErrorCode() == 0) goto L8;
        HMSLog.e(HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + r101.getErrorCode());
        ErrorEnum r104 = ErrorEnum.fromCode(r101.getErrorCode());
        if (r104 == ErrorEnum.ERROR_UNKNOWN) goto L7;
        r103.setException(r104.toApiException());
        return;
    L7:
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        return;
    L8:
        ErrorEnum r105 = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(r102, new DeleteTokenResp())).getRetCode());
        if (r105 == ErrorEnum.SUCCESS) goto L11;
        r103.setException(r105.toApiException());
        return;
    L11:
        r103.setResult(null);
        h.a(r100.getContext(), getUri(), r101);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((PushClient) r100, r101, r102, r103);
    }
}
