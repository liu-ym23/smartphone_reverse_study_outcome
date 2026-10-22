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
import com.huawei.hms.support.api.hwid.RevokeAccessResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class h extends TaskApiCall<c, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    public h(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(c r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r110) {
        as.b("AccountCancelAuthorizationTaskApiCall", "AccountCancelAuthorizationTaskApiCall doExecute", true);
        f.a();
        if (r101 != null) goto L6;
        as.b("AccountCancelAuthorizationTaskApiCall", "response is null.", true);
        r110.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        int r103 = r101.getErrorCode();
        if (r103 == 0) goto L13;
        if (CommonCode.Resolution.HAS_RESOLUTION.equals(r101.getResolution()) == false) goto L13;
        as.b("AccountCancelAuthorizationTaskApiCall", "apk version is low or is not exist.", true);
        Status r104 = new Status(r103, r101.getErrorReason());
        ao.a(r101, r104);
        r110.setException(new ResolvableApiException(r104));
        return;
    L13:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        r110.setException(new ApiException(new Status(r103, r101.getErrorReason())));
    L26:
        if (r100 == null) goto L32;
        HiAnalyticsClient.reportExit(r100.getContext(), getUri(), getTransactionId(), ar.a(r103), r103);
        return;
    L32:
        return;
    L15:
        if (SliceInitService.DEFAULT_SWITCH.equals(r102) == false) goto L30;
        as.b("AccountCancelAuthorizationTaskApiCall", "CancelAuthorization complete, body is null", true);
        r110.setException(new ApiException(new Status(r103, r101.getErrorReason())));
        return;
    L30:
        RevokeAccessResult r105 = new RevokeAccessResult().fromJson(r102);     // Catch: JSONException -> L23
        if (r105.isSuccess() == true) goto L21;
        Status r106 = r105.getStatus();     // Catch: JSONException -> L23
        r110.setException(new ApiException(new Status(r106.getStatusCode(), r106.getStatusMessage())));     // Catch: JSONException -> L23
    L29:
        goto L26
    L21:
        r110.setResult(null);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        as.b("AccountCancelAuthorizationTaskApiCall", "JSONException:".concat(e.getClass().getSimpleName()), true);
        Status r107 = new Status(r103, r101.getErrorReason());
        ao.a(r101, r107);
        r110.setException(new ApiException(r107));
        goto L26
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((c) r100, r101, r102, r103);
    }
}
