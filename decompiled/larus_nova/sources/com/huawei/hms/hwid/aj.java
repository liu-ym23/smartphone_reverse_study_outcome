package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class aj extends HuaweiApi<Api.ApiOptions.NoOptions> {
    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    private af b() {
        return new af(getContext().getPackageName());
    }

    public Task<Void> a() {
        String r100 = b().a();
        if (TextUtils.isEmpty(r100) == false) goto L7;
        TaskCompletionSource r101 = new TaskCompletionSource();
        r101.setException(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
        return r101.getTask();
    L7:
        return doWrite(new ak(CommonNaming.startSmsRetriever, r100, HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startSmsRetriever, 60900100)));
    }

    public Task<Void> a(String r100) {
        as.b("ReadSmsService", "startConsent enter", true);
        if (r100 != null) goto L5;
    L8:
        JSONObject r101 = new JSONObject();
        r101.put("packageName", getContext().getPackageName());     // Catch: JSONException -> L11
        r101.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, r100);     // Catch: JSONException -> L11
    L13:
        if (TextUtils.isEmpty(r101.toString()) == false) goto L16;
        TaskCompletionSource r102 = new TaskCompletionSource();
        r102.setException(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
        return r102.getTask();
    L16:
        String r103 = HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startConsent, 60900100);
        return doWrite(new al(CommonNaming.startConsent, r101.toString(), r103));
    L11:
        as.d("ReadSmsService", "toJson failed", true);
        goto L13
    L5:
        if (r100.length() <= 120) goto L8;
        TaskCompletionSource r104 = new TaskCompletionSource();
        r104.setException(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
        return r104.getTask();
    }

    public aj(Activity r100, Api<Api.ApiOptions.NoOptions> r101, Api.ApiOptions.NoOptions r102, AbstractClientBuilder r103) {
        super(r100, r101, r102, r103);
    }

    public aj(Context r100, Api<Api.ApiOptions.NoOptions> r101, Api.ApiOptions.NoOptions r102, AbstractClientBuilder r103) {
        super(r100, r101, r102, r103);
    }
}
