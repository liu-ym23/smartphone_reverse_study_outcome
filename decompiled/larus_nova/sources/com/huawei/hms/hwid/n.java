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
import com.huawei.hms.support.api.hwid.SignOutResult;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class n extends TaskApiCall<c, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    private void a(ResponseErrorCode r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append("headerErrorCode:" + r100.getErrorCode());
        as.b("[AccountSDK]AccountSignOutTaskApiCall", r102.toString(), true);
    }

    public n(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(c r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        if (r101 != null) goto L6;
        as.b("[AccountSDK]AccountSignOutTaskApiCall", "response is null.", true);
        r103.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        a(r101, r102);
        int r104 = r101.getErrorCode();
        if (r104 == 0) goto L13;
        if (CommonCode.Resolution.HAS_RESOLUTION.equals(r101.getResolution()) == false) goto L13;
        as.b("[AccountSDK]AccountSignOutTaskApiCall", "apk version is low or is not exist.", true);
        Status r105 = new Status(r104, r101.getErrorReason());
        ao.a(r101, r105);
        r103.setException(new ResolvableApiException(r105));
        return;
    L13:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        r103.setException(new ApiException(new Status(r104, r101.getErrorReason())));
        return;
    L15:
        if (SliceInitService.DEFAULT_SWITCH.equals(r102) == false) goto L28;
        as.b("[AccountSDK]AccountSignOutTaskApiCall", "SignOut complete, body is null", true);
        r103.setException(new ApiException(new Status(r104, r101.getErrorReason())));
        return;
    L28:
        SignOutResult r106 = new SignOutResult().fromJson(r102);     // Catch: JSONException -> L23
        if (r106.isSuccess() == false) goto L21;
        r103.setResult(null);     // Catch: JSONException -> L23
    L27:
        return;
    L21:
        r103.setException(new ApiException(r106.getStatus()));     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        as.b("[AccountSDK]AccountSignOutTaskApiCall", "JSONException:".concat(e.getClass().getSimpleName()), true);
        r103.setException(new ApiException(new Status(r104, r101.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((c) r100, r101, r102, r103);
    }
}
