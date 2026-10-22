package com.huawei.hms.hwid;

import android.app.PendingIntent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* JADX INFO: loaded from: classes23.dex */
public class j extends TaskApiCall<c, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 16;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }

    private void a(ResponseErrorCode r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("headerErrorCode:" + r100.getErrorCode());
        as.b("AccountLogoutTaskApiCall", r101.toString(), true);
    }

    private void a(c r100, ResponseErrorCode r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        HiAnalyticsClient.reportExit(r100.getContext(), AccountNaming.logout, getTransactionId(), ar.a(r101.getErrorCode()), r101.getErrorCode());
        return;
    L8:
        return;
    }

    public j(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(c r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        as.b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall doExecute", true);
        if (r101 != null) goto L6;
        as.b("AccountLogoutTaskApiCall", "response is null.", true);
        r103.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        a(r101);
        if (r101.getErrorCode() == 0) goto L17;
        if (CommonCode.Resolution.HAS_RESOLUTION.equals(r101.getResolution()) == false) goto L11;
        as.b("AccountLogoutTaskApiCall", "hms apk version is low or is not exist.", true);
        PendingIntent r104 = (PendingIntent) r101.getParcelable();
        r103.setException(new ResolvableApiException(new Status(r101.getErrorCode(), r101.getErrorReason(), r104)));
    L14:
        r103.setResult(null);
        a(r100, r101);
        return;
    L11:
        as.b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall callback.", true);
        if (r101.getErrorCode() == 2031) goto L14;
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        goto L14
    L17:
        if (TextUtils.isEmpty(r102) == false) goto L20;
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        a(r100, r101);
        return;
    L20:
        r103.setResult(null);
        a(r100, r101);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((c) r100, r101, r102, r103);
    }
}
