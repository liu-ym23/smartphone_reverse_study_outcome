package com.huawei.hms.push.plugin.notification;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.NotificationEnableReq;
import com.huawei.hms.support.api.entity.push.NotificationEnableResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* JADX INFO: loaded from: classes23.dex */
public class b extends TaskApiCall<PushClient, NotificationStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NotificationEnableReq f277657b;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 5;
    }

    private Intent a(ResponseErrorCode r100) {
        Parcelable r101 = r100.getParcelable();
        if (r101 != null) goto L7;
        return new Intent();
    L7:
        if ((r101 instanceof Intent) == false) goto L11;
        return (Intent) r101;
    L11:
        return new Intent();
    }

    private void a(ResponseErrorCode r100, TaskCompletionSource<NotificationStatus> r101) {
        ErrorEnum r102 = ErrorEnum.fromCode(r100.getErrorCode());
        if (r102 == ErrorEnum.ERROR_UNKNOWN) goto L5;
        r101.setException(r102.toApiException());
        return;
    L5:
        r101.setException(new ApiException(new Status(r100.getErrorCode(), r100.getErrorReason())));
    }

    public b(String r100, NotificationEnableReq r101, Context r102, String r103) {
        super(r100, JsonUtil.createJsonString(r101), r103);
        this.f277656a = r102;
        this.f277657b = r101;
    }

    public void a(PushClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<NotificationStatus> r103) {
        if (r101.getErrorCode() == 0) goto L5;
        HMSLog.e("HmsNotificationManagerEx", "Notification Enable failed, ErrorCode:" + r101.getErrorCode());
        a(r101, r103);
        return;
    L5:
        ErrorEnum r104 = ErrorEnum.fromCode(((NotificationEnableResp) JsonUtil.jsonToEntity(r102, new NotificationEnableResp())).getRetCode());
        if (r104 == ErrorEnum.SUCCESS) goto L8;
        r103.setException(r104.toApiException());
        HMSLog.e("HmsNotificationManagerEx", "Notification Enable failed, StatusCode:" + r104.getExternalCode());
        return;
    L8:
        NotificationStatus r105 = new NotificationStatus();
        r105.setRetCode(r104.getExternalCode());
        r105.getStatus().setIntent(a(r101));
        r103.setResult(r105);
        new PushPreferences(this.f277656a, "hwpush_local_config").saveLong("notification_request_time", Long.valueOf(System.currentTimeMillis()));
        PushBiUtil.reportExit(r100.getContext(), getUri(), r101);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<NotificationStatus> r103) {
        a((PushClient) r100, r101, r102, r103);
    }
}
