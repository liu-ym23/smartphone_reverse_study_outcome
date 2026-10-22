package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.hwid.SignOutResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class ad extends TaskApiCall<u, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    private void a(ResponseErrorCode r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append("headerErrorCode:" + r100.getErrorCode());
        as.b("[HUAWEIIDSDK]HuaweiIdSignOutTaskApiCall", r102.toString(), true);
    }

    public ad(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(u r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        if (r101 != null) goto L5;
        as.b("[HUAWEIIDSDK]HuaweiIdSignOutTaskApiCall", "response is null.", true);
        r103.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L5:
        a(r101, r102);
        int r104 = r101.getErrorCode();
        if (TextUtils.isEmpty(r102) == false) goto L18;
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
    L14:
        if (r100 == null) goto L20;
        HiAnalyticsClient.reportExit(r100.getContext(), CommonNaming.signout, getTransactionId(), ar.a(r104), r104);
        return;
    L20:
        return;
    L18:
        SignOutResult r105 = new SignOutResult().fromJson(r102);     // Catch: JSONException -> L12
        r104 = r105.getStatus().getStatusCode();     // Catch: JSONException -> L12
        if (r105.isSuccess() == false) goto L10;
        r103.setResult(null);     // Catch: JSONException -> L12
    L17:
        goto L14
    L10:
        r103.setException(new ApiException(r105.getStatus()));     // Catch: JSONException -> L12
    L12:
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        goto L14
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((u) r100, r101, r102, r103);
    }
}
