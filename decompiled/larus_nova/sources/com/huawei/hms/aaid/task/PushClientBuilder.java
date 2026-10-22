package com.huawei.hms.aaid.task;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public class PushClientBuilder extends AbstractClientBuilder<PushClient, Api.ApiOptions.NoOptions> {
    public PushClientBuilder() {
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public PushClient buildClient(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        r101.setApiName(Arrays.asList(new String[]{HuaweiApiAvailability.HMS_API_NAME_PUSH, "Core.API"}));
        return new PushClient(r100, r101, r102, r103);
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public /* bridge */ /* synthetic */ AnyClient buildClient(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        return buildClient(r100, r101, r102, r103);
    }
}
