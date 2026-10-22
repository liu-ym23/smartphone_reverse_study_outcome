package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.hwid.StartAssistLoginResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class o extends TaskApiCall<c, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 14;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }

    public o(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(c r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        as.b("AccountStartAssistLoginTaskApiCall", "AccountStartAssistLoginTaskApiCall doExecute", true);
        if (r101 != null) goto L6;
        as.b("AccountStartAssistLoginTaskApiCall", "response is null.", true);
        r103.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        int r104 = r101.getErrorCode();
        if (r104 == 0) goto L13;
        if (CommonCode.Resolution.HAS_RESOLUTION.equals(r101.getResolution()) == false) goto L13;
        as.b("AccountStartAssistLoginTaskApiCall", "apk version is low or is not exist.", true);
        Status r105 = new Status(r104, r101.getErrorReason());
        ao.a(r101, r105);
        r103.setException(new ResolvableApiException(r105));
        return;
    L13:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        r103.setException(new ApiException(new Status(r104, r101.getErrorReason())));
    L25:
        if (r100 == null) goto L31;
        HiAnalyticsClient.reportExit(r100.getContext(), getUri(), getTransactionId(), ar.a(r104), r104);
        return;
    L31:
        return;
    L15:
        if (SliceInitService.DEFAULT_SWITCH.equals(r102) == false) goto L29;
        as.b("AccountStartAssistLoginTaskApiCall", "signIn complete, body is null", true);
        r103.setException(new ApiException(new Status(r104, r101.getErrorReason())));
        return;
    L29:
        StartAssistLoginResult r106 = new StartAssistLoginResult().fromJson(r102);     // Catch: JSONException -> L23
        if (r106.isSuccess() == false) goto L21;
        r103.setResult(null);     // Catch: JSONException -> L23
    L28:
        goto L25
    L21:
        r103.setException(new ApiException(r106.getStatus()));     // Catch: JSONException -> L23
    L23:
        as.c("AccountStartAssistLoginTaskApiCall", "tartAssistLogin complete, but parser json exception", true);
        r103.setException(new ApiException(new Status(r104, r101.getErrorReason())));
        goto L25
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((c) r100, r101, r102, r103);
    }
}
