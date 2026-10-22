package se7;

import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements Client.Provider {
    public g() {
    }

    @Override // com.bytedance.retrofit2.client.Client.Provider
    public final Client get() {
        return new SsRetrofitClient();
    }
}
