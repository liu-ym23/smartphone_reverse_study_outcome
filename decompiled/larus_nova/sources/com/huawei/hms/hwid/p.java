package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AssistTokenResult;
import com.huawei.hms.support.account.result.GetAssistTokenResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class p extends TaskApiCall<c, AssistTokenResult> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 14;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }

    private void a(c r100, int r101) {
        if (r100 == null) goto L5;
        HiAnalyticsClient.reportExit(r100.getContext(), AccountNaming.getAssistToken, getTransactionId(), ar.a(r101), r101);
        return;
    }

    public p(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(c r100, ResponseErrorCode r101, String r102, TaskCompletionSource<AssistTokenResult> r103) {
        if (r101 != null) goto L6;
        as.b("[AccountSDK]GetAssistTokenTaskApiCall", "response is null.", true);
        r103.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        int r104 = r101.getErrorCode();
        if (TextUtils.isEmpty(r102) == false) goto L9;
    L18:
        as.b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken complete, response or body is null, failed", true);
        a(r100, r104);
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        return;
    L9:
        if (SliceInitService.DEFAULT_SWITCH.equals(r102) == true) goto L18;
        AssistTokenResult r105 = new AssistTokenResult();     // Catch: JSONException -> L16
        GetAssistTokenResult r106 = new GetAssistTokenResult().fromJson(r102);     // Catch: JSONException -> L16
        if (r106.isSuccess() == false) goto L14;
        as.b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken success", true);     // Catch: JSONException -> L16
        a(r100, r104);     // Catch: JSONException -> L16
        r105.setAssistToken(r106.getAssistToken());     // Catch: JSONException -> L16
        r103.setResult(r105);     // Catch: JSONException -> L16
    L20:
        return;
    L14:
        as.b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken failed", true);     // Catch: JSONException -> L16
        a(r100, r104);     // Catch: JSONException -> L16
        r103.setException(new ApiException(r106.getStatus()));     // Catch: JSONException -> L16
    L16:
        as.d("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken complete, but parser json exception", true);
        a(r100, r104);
        r103.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<AssistTokenResult> r103) {
        a((c) r100, r101, r102, r103);
    }
}
