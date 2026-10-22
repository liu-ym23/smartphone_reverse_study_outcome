package com.larus.audio;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.network.NetConnectionTypeProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements m58.w {
    public a0() {
    }

    @Override // m58.w
    public final String getCurrentNetworkStatus() {
        NetConnectionTypeProvider.NetworkStatus r100 = NetConnectionTypeProvider.f360084a;
        return NetConnectionTypeProvider.f360084a.toString();
    }

    @Override // m58.w
    public final String getNetworkAccessType() {
        return NetworkUtils.getNetworkAccessType(NetworkUtils.getNetworkTypeFast(AppHost.f326268a.getApplication()));
    }

    @Override // m58.w
    public final int o() {
        NetConnectionTypeProvider.NetworkStatus r100 = NetConnectionTypeProvider.f360084a;
        return NetConnectionTypeProvider.f360084a.getValue();
    }
}
