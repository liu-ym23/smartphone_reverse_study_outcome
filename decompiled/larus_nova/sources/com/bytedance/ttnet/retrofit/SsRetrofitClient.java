package com.bytedance.ttnet.retrofit;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.HttpClient;
import java.io.IOException;
import lx5.b;

/* JADX INFO: loaded from: classes3.dex */
public class SsRetrofitClient implements Client {
    public SsRetrofitClient() {
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r100) throws IOException {
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == false) goto L5;
        boolean r101 = ((BaseRequestContext) r100.getExtraInfo()).force_use_okhttp;
    L6:
        b r102 = HttpClient.getHttpClient(r100.getUrl(), r101);
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.newSsCall(r100);
    L5:
        r101 = false;
        goto L6
    }
}
