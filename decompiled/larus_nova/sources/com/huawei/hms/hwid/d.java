package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.support.account.request.AccountAuthParams;

/* JADX INFO: loaded from: classes23.dex */
public class d extends AbstractClientBuilder<c, AccountAuthParams> {
    public d() {
    }

    public c a(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        return new c(r100, r101, r102, r103);
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public /* synthetic */ AnyClient buildClient(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        return a(r100, r101, r102, r103);
    }
}
