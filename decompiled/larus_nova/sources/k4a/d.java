package k4a;

import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements Client.Provider {
    public d() {
    }

    @Override // com.bytedance.retrofit2.client.Client.Provider
    public final Client get() {
        return new SsRetrofitClient();
    }
}
