package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.r;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.larus.bmhome.music.applet.MusicAppletPage;

/* JADX INFO: loaded from: classes23.dex */
public class SendUpStreamTask extends TaskApiCall<PushClient, BaseVoidTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277669b;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }

    private void a(PushClient r100, ResponseErrorCode r101) {
        HMSLog.i("SendUpStreamTask", "receive upstream, msgId :" + this.f277669b + " , packageName = " + this.f277668a + " , errorCode = " + r101.getErrorCode());
        Intent r102 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        r102.setPackage(this.f277668a);
        Bundle r103 = new Bundle();
        r103.putString(MusicAppletPage.KEY_MESSAGE_ID, this.f277669b);
        r103.putInt("error", r101.getErrorCode());
        if (ErrorEnum.SUCCESS.getInternalCode() != r101.getErrorCode()) goto L5;
        r103.putString("message_type", "sent_message");
    L7:
        if (new r().a(r100.getContext(), r103, r102) == false) goto L9;
        HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
        PushBiUtil.reportExit(r100.getContext(), getUri(), r101);
        return;
    L9:
        HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
        PushBiUtil.reportExit(r100.getContext(), getUri(), r101.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
        return;
    L5:
        r103.putString("message_type", "send_error");
        goto L7
    }

    public void doExecute(PushClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<BaseVoidTask> r103) {
        if (r101.getErrorCode() != 0) goto L5;
        HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
        r103.setResult(null);
    L9:
        a(r100, r101);
        return;
    L5:
        HMSLog.e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + r101.getErrorCode());
        ErrorEnum r104 = ErrorEnum.fromCode(r101.getErrorCode());
        if (r104 == ErrorEnum.ERROR_UNKNOWN) goto L8;
        r103.setException(r104.toApiException());
        goto L9
    L8:
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        goto L9
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<BaseVoidTask> r103) {
        doExecute((PushClient) r100, r101, r102, r103);
    }

    public SendUpStreamTask(String r100, String r101, String r102, String r103, String r104) {
        super(r100, r101, r102);
        this.f277668a = r103;
        this.f277669b = r104;
    }
}
