package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class m extends TaskApiCall<c, AuthAccount> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    public m(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(c r100, ResponseErrorCode r101, String r102, TaskCompletionSource<AuthAccount> r110) {
        if (r101 != null) goto L6;
        as.b("[AccountSDK]AccountSignInTaskApiCall", "response is null.", true);
        r110.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        as.b("[AccountSDK]AccountSignInTaskApiCall", "ResponseErrorCode.status:" + r101.getErrorCode(), true);
        int r103 = r101.getErrorCode();
        if (r103 == 0) goto L13;
        if (CommonCode.Resolution.HAS_RESOLUTION.equals(r101.getResolution()) == false) goto L13;
        as.b("[AccountSDK]AccountSignInTaskApiCall", "apk version is low or is not exist.", true);
        Status r104 = new Status(r103, r101.getErrorReason());
        ao.a(r101, r104);
        r110.setException(new ResolvableApiException(r104));
        return;
    L13:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn complete, response is null, failed", true);
        r110.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
    L28:
        AuthAccount r105 = null;
    L29:
        g.a().a(r105, null);
        if (r100 == null) goto L37;
        HiAnalyticsClient.reportExit(r100.getContext(), getUri(), getTransactionId(), ar.a(r103), r103);
        return;
    L37:
        return;
    L15:
        if (SliceInitService.DEFAULT_SWITCH.equals(r102) == false) goto L34;
        as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn complete, body is null", true);
        r110.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        return;
    L34:
        AccountAuthResult r106 = new AccountAuthResult().fromJson(r102);     // Catch: JSONException -> L25
        r103 = r106.getStatus().getStatusCode();     // Catch: JSONException -> L25
        if (r106.isSuccess() == false) goto L23;
        as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn success", true);     // Catch: JSONException -> L25
        new e(r100.getContext()).a();     // Catch: JSONException -> L25
        r105 = r106.getAccount();     // Catch: JSONException -> L25
        r110.setResult(r106.getAccount());     // Catch: JSONException -> L33
    L26:
        as.c("[AccountSDK]AccountSignInTaskApiCall", "signIn complete, but parser json exception", true);
        r110.setException(new ApiException(new Status(r103, r101.getErrorReason())));
        goto L29
    L23:
        as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn failed", true);     // Catch: JSONException -> L25
        r110.setException(new ApiException(r106.getStatus()));     // Catch: JSONException -> L25
    L25:
        r105 = null;
        goto L26
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<AuthAccount> r103) {
        a((c) r100, r101, r102, r103);
    }
}
