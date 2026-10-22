package com.huawei.hms.hwid;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* JADX INFO: loaded from: classes23.dex */
public class al extends TaskApiCall<ai, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50005300;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        as.b("StartConsentTaskApiCall", "startConsent getApiLevel8", true);
        return 8;
    }

    private boolean a(ResponseErrorCode r100, Integer r101) {
        if (r101 != null) goto L10;
        if (r100.getStatusCode() == 0) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (r101.intValue() == 0) goto L15;
        return false;
    L15:
        return true;
    }

    public al(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public void a(ai r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        ag r104 = ag.b(r102);
        Integer r105 = r104.a();
        String r106 = r104.b();
        if (r105 != null) goto L6;
        r105 = Integer.valueOf(r101.getErrorCode());
        r106 = r101.getErrorReason();
    L6:
        if (a(r101, r104.a()) == false) goto L8;
        r103.setResult(null);
    L9:
        if (r100 == null) goto L12;
        HiAnalyticsClient.reportExit(r100.getContext(), getUri(), getTransactionId(), ar.a(r105.intValue()), r105.intValue());
        return;
    L12:
        return;
    L8:
        r103.setException(new ApiException(new Status(r105.intValue(), r106)));
        goto L9
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<Void> r103) {
        a((ai) r100, r101, r102, r103);
    }
}
