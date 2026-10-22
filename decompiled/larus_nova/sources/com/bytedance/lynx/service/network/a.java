package com.bytedance.lynx.service.network;

import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Client.Provider {
    @Override // com.bytedance.retrofit2.client.Client.Provider
    public final Client get() {
        return new SsRetrofitClient();
    }

    public a() {
    }
}
