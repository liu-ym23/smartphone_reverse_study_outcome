package com.huawei.hms.hwid;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.UIUtil;

/* JADX INFO: loaded from: classes23.dex */
public class ae extends TaskApiCall<u, Intent> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    public ae(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    private void a(Parcelable r100, u r110, ResponseErrorCode r111, TaskCompletionSource<Intent> r112) {
        Activity r101 = ActivityMgr.INST.getCurrentActivity();
        if (r101 != null) goto L5;
    L24:
        as.b("NoticeTaskApiCall", "launchNoticeActivity failed, activity is invalid", true);
        return;
    L5:
        if (r101.isFinishing() == true) goto L24;
        if (r101.isDestroyed() == true) goto L24;
        if ((r100 instanceof Intent) == false) goto L15;
        r101.startActivity((Intent) r100);     // Catch: Exception -> L13
        return;
    L13:
        as.d("NoticeTaskApiCall", "Jos Notice startActivity meet exception", true);
        return;
    L15:
        if ((r100 instanceof PendingIntent) == false) goto L33;
        PendingIntent r102 = (PendingIntent) r100;
    L22:
        as.d("NoticeTaskApiCall", "Jos Notice startIntentSender meet exception", true);
        return;
    L18:
        if (UIUtil.isBackground(r110.getContext()) == false) goto L20;
        as.b("NoticeTaskApiCall", "ui isBackground.", true);     // Catch: IntentSender.SendIntentException -> L22
        r112.setException(new ApiException(new Status(r111.getErrorCode(), r111.getErrorReason(), r102)));     // Catch: IntentSender.SendIntentException -> L22
    L26:
        return;
    L20:
        r101.startIntentSender(r102.getIntentSender(), null, 0, 0, 0);     // Catch: IntentSender.SendIntentException -> L22
        goto L26
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Intent> r103) {
        a((u) r100, r101, r102, r103);
    }

    public void a(u r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Intent> r103) {
        if (r101 != null) goto L7;
        as.b("NoticeTaskApiCall", "header is null.", true);
        r103.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L7:
        if (r101.getStatusCode() == 0) goto L9;
    L11:
        as.c("NoticeTaskApiCall", "Jos Notice onResult failed, ErrCode" + r101.getErrorCode(), true);
    L12:
        if (r100 == null) goto L15;
        HiAnalyticsClient.reportExit(r100.getContext(), getUri(), getTransactionId(), r101.getStatusCode(), r101.getErrorCode());
        return;
    L15:
        return;
    L9:
        if (r101.getErrorCode() != 0) goto L11;
        as.b("NoticeTaskApiCall", "Jos Notice onResult success.", true);
        a(r101.getParcelable(), r100, r101, r103);
        goto L12
    }
}
