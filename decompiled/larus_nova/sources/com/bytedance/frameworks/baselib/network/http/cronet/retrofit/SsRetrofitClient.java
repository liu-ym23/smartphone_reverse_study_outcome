package com.bytedance.frameworks.baselib.network.http.cronet.retrofit;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.HttpClient;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import lx5.b;

/* JADX INFO: loaded from: classes19.dex */
public class SsRetrofitClient implements Client {
    private Context mContext;

    public SsRetrofitClient(Context r100) {
        this.mContext = r100;
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r100) throws IOException {
        b r101 = HttpClient.getHttpClient(this.mContext, r100.getUrl());
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.newSsCall(r100);
    }
}
