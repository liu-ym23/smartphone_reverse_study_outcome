package com.huawei.hms.push.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.SubscribeResult;
import com.huawei.hms.push.b;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* JADX INFO: loaded from: classes23.dex */
public class SubscribeNotificationTask extends TaskApiCall<PushClient, SubscribeResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f277670a;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 6;
    }

    private void a(ResponseErrorCode r100, TaskCompletionSource<SubscribeResult> r101) {
        ErrorEnum r102 = ErrorEnum.fromCode(r100.getErrorCode());
        if (r102 == ErrorEnum.ERROR_UNKNOWN) goto L5;
        r101.setException(r102.toApiException());
        return;
    L5:
        r101.setException(new ApiException(new Status(r100.getErrorCode(), r100.getErrorReason())));
    }

    private boolean a(PushClient r100, ResponseErrorCode r101) {
        Parcelable r102 = r101.getParcelable();
        if ((r102 instanceof Intent) == true) goto L6;
        HMSLog.e("SubscribeNotificationTask", "not instance of intent");
        return false;
    L6:
        Intent r103 = (Intent) r102;
        r103.putExtra("app_token", BaseUtils.getLocalToken(r100.getContext(), null));
        this.f277670a.startActivityForResult(r103, 1001);
        return true;
    }

    public SubscribeNotificationTask(Activity r100, String r101, SubscribeNotificationReq r102, String r103) {
        super(r101, JsonUtil.createJsonString(r102), r103);
        this.f277670a = r100;
    }

    public void doExecute(PushClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<SubscribeResult> r103) {
        if (r101.getErrorCode() == 0) goto L5;
        HMSLog.e("SubscribeNotificationTask", "Notification subscribe failed, error code: " + r101.getErrorCode());
        a(r101, r103);
    L15:
        PushBiUtil.reportExit(r100.getContext(), getUri(), r101);
        return;
    L5:
        SubscribeNotificationResp r104 = (SubscribeNotificationResp) JsonUtil.jsonToEntity(r102, new SubscribeNotificationResp());
        ErrorEnum r105 = ErrorEnum.fromCode(r104.getRetCode());
        if (r105 == ErrorEnum.SUCCESS) goto L9;
        r103.setException(r105.toApiException());
        HMSLog.e("PushLogSC3004", "Notification Subscription failed, StatusCode:" + r105.getExternalCode());
        goto L15
    L9:
        if (r101.hasResolution() == true) goto L12;
        SubscribeResult r106 = new SubscribeResult();
        r106.setSubscribedItems(b.a(r104.getSubscribeResults()));
        r103.setResult(r106);
        goto L15
    L12:
        if (a(r100, r101) == false) goto L14;
        r103.setResult(new SubscribeResult());
        goto L15
    L14:
        r103.setException(ErrorEnum.ERROR_PUSH_INTERNAL_ERROR.toApiException());
        goto L15
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<SubscribeResult> r103) {
        doExecute((PushClient) r100, r101, r102, r103);
    }
}
