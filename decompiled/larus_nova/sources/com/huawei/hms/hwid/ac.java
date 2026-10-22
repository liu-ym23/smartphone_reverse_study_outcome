package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.utils.Util;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class ac extends TaskApiCall<u, AuthHuaweiId> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    public ac(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(u r110, ResponseErrorCode r111, String r112, TaskCompletionSource<AuthHuaweiId> r210) {
        if (r111 != null) goto L6;
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "response is null.", true);
        r210.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "ResponseErrorCode.status:" + r111.getErrorCode(), true);
        int r100 = r111.getErrorCode();
        if (TextUtils.isEmpty(r112) == false) goto L26;
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "signIn complete, response is null, failed", true);
        r210.setException(new ApiException(new Status(r111.getErrorCode(), r111.getErrorReason())));
        int r113 = r100;
        AuthHuaweiId r101 = null;
    L19:
        y.a().a(r101, null);
        if (r110 == null) goto L22;
        HiAnalyticsClient.reportExit(r110.getContext(), CommonNaming.silentSignIn, getTransactionId(), Util.getAppId(r110.getContext()), ar.a(r113), r113, 61100301);
    L22:
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "report: api=hwid.silentSignInversion=61100301", true);
        return;
    L26:
        HuaweiIdAuthResult r102 = new HuaweiIdAuthResult().fromJson(r112);     // Catch: JSONException -> L15
        r100 = r102.getStatus().getStatusCode();     // Catch: JSONException -> L15
        if (r102.isSuccess() == false) goto L13;
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "signIn success", true);     // Catch: JSONException -> L15
        new w(r110.getContext()).a();     // Catch: JSONException -> L15
        r101 = r102.getHuaweiId();     // Catch: JSONException -> L15
        r210.setResult(r102.getHuaweiId());     // Catch: JSONException -> L24
    L25:
    L17:
        r113 = r100;
    L16:
        as.c("[HUAWEIIDSDK]SignInTaskApiCall", "signIn complete, but parser json exception", true);
        r210.setException(new ApiException(new Status(r111.getErrorCode(), r111.getErrorReason())));
        goto L17
    L13:
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "signIn failed", true);     // Catch: JSONException -> L15
        r210.setException(new ApiException(r102.getStatus()));     // Catch: JSONException -> L15
        r101 = null;
    L15:
        r101 = null;
        goto L16
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<AuthHuaweiId> r103) {
        a((u) r100, r101, r102, r103);
    }
}
