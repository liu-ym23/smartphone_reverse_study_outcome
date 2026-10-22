package com.huawei.hms.support.sms;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.hwid.ah;
import com.huawei.hms.hwid.aj;

/* JADX INFO: loaded from: classes23.dex */
public class ReadSmsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api<Api.ApiOptions.NoOptions> f277819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ah f277820b = null;

    public ReadSmsManager() {
    }

    static {
        f277819a = new Api(HuaweiApiAvailability.HMS_API_NAME_ID);
        f277820b = new ah();
    }

    public static Task<Void> start(Activity r100) {
        return new aj(r100, f277819a, null, f277820b).a();
    }

    public static Task<Void> start(Context r100) {
        return new aj(r100, f277819a, null, f277820b).a();
    }

    public static Task<Void> startConsent(Activity r100, String r101) {
        return new aj(r100, f277819a, null, f277820b).a(r101);
    }
}
