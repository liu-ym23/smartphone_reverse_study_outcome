package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* JADX INFO: loaded from: classes23.dex */
public class OpenDeviceHmsClientBuilder extends AbstractClientBuilder<OpenDeviceHmsClient, OpenDeviceOptions> {
    public OpenDeviceHmsClientBuilder() {
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public OpenDeviceHmsClient buildClient(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        return new OpenDeviceHmsClient(r100, r101, r102, r103);
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public /* bridge */ /* synthetic */ AnyClient buildClient(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        return buildClient(r100, r101, r102, r103);
    }
}
