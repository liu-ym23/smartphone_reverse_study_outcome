package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

/* JADX INFO: loaded from: classes23.dex */
public class u extends HmsClient {
    @Override // com.huawei.hms.common.internal.BaseHmsClient
    public int getMinApkVersion() {
        return 30000000;
    }

    public u(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        super(r100, r101, r102, r103);
    }
}
