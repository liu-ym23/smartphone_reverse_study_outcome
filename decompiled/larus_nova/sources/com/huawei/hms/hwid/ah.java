package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* JADX INFO: loaded from: classes23.dex */
public class ah extends AbstractClientBuilder<ai, Api.ApiOptions.NoOptions> {
    public ah() {
    }

    public ai a(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        return new ai(r100, r101, r102, r103);
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public /* synthetic */ AnyClient buildClient(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        return a(r100, r101, r102, r103);
    }
}
