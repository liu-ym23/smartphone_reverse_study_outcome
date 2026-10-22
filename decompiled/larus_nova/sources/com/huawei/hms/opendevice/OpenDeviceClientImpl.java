package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

/* JADX INFO: loaded from: classes23.dex */
public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final OpenDeviceHmsClientBuilder f277523a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api<OpenDeviceOptions> f277524b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static OpenDeviceOptions f277525c;

    static {
        f277523a = new OpenDeviceHmsClientBuilder();
        f277524b = new Api(HuaweiApiAvailability.HMS_API_NAME_OD);
        f277525c = new OpenDeviceOptions();
    }

    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public Task<OdidResult> getOdid() {
        String r100 = HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.GET_ODID, 61300300);
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.GET_ODID, JsonUtil.createJsonString(null), r100));
    }

    public OpenDeviceClientImpl(Context r100) {
        super(r100, f277524b, f277525c, f277523a);
        super.setKitSdkVersion(61300300);
    }
}
