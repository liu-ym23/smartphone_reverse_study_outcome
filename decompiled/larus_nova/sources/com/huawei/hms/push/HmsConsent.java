package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ConsentTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableConsentReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.utils.JsonUtil;

/* JADX INFO: loaded from: classes23.dex */
public class HmsConsent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f277554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277555b;

    public Task<Void> consentOff() {
        return a(false);
    }

    public Task<Void> consentOn() {
        return a(true);
    }

    private HmsConsent(Context r100) {
        Preconditions.checkNotNull(r100);
        this.f277555b = r100;
        Api r101 = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if ((r100 instanceof Activity) == false) goto L5;
        this.f277554a = new HuaweiApi((Activity) r100, r101, null, new PushClientBuilder());
    L6:
        this.f277554a.setKitSdkVersion(61300300);
        return;
    L5:
        this.f277554a = new HuaweiApi(r100, r101, null, new PushClientBuilder());
        goto L6
    }

    private Task<Void> a(boolean r100) {
        String r101 = PushBiUtil.reportEntry(this.f277555b, PushNaming.PUSH_CONSENT);
    L10:
        e = move-exception;
        TaskCompletionSource r102 = new TaskCompletionSource();
        r102.setException(e);
        int r103 = e.getStatusCode();
        TaskCompletionSource r104 = r102;
    L12:
        PushBiUtil.reportExit(this.f277555b, PushNaming.PUSH_CONSENT, r101, r103);
        return r104.getTask();
    L9:
        r104 = new TaskCompletionSource();
        ErrorEnum r105 = ErrorEnum.ERROR_INTERNAL_ERROR;
        r104.setException(r105.toApiException());
        r103 = r105.getExternalCode();
        goto L12
    L4:
        if (d.d(this.f277555b) == false) goto L8;
        EnableConsentReq r106 = new EnableConsentReq();     // Catch: Exception -> L9 ApiException -> L10
        r106.setPackageName(this.f277555b.getPackageName());     // Catch: Exception -> L9 ApiException -> L10
        r106.setEnable(r100);     // Catch: Exception -> L9 ApiException -> L10
        return this.f277554a.doWrite(new ConsentTask(PushNaming.PUSH_CONSENT, JsonUtil.createJsonString(r106), r101));
    L8:
        throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();     // Catch: Exception -> L9 ApiException -> L10
    }

    public static HmsConsent getInstance(Context r100) {
        return new HmsConsent(r100);
    }
}
