package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: classes23.dex */
public class aa extends TaskApiCall<u, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40000300;
    }

    private void a(ResponseErrorCode r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append("headerErrorCode:" + r100.getErrorCode());
        as.b("[HUAWEIIDSDK]HuaweiIdDeleteAuthInfoTaskApiCall", r102.toString(), true);
    }

    public aa(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(u r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        if (r101 != null) goto L5;
        as.b("[HUAWEIIDSDK]HuaweiIdDeleteAuthInfoTaskApiCall", "response is null.", true);
        r103.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L5:
        a(r101, r102);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        return;
    L8:
        if (r101.getErrorCode() != 0) goto L10;
        r103.setResult(null);
        return;
    L10:
        r103.setException(new ApiException(new Status(r101.getErrorCode())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((u) r100, r101, r102, r103);
    }
}
