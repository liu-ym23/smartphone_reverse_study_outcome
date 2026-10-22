package com.bytedance.ee.bear.bitable.homepage.recommend.datasource;

import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendResponse;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements NetService.c<BitableRecommendResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f213019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f213020b;

    public d(String r100) {
        this.f213019a = r100;
        this.f213020b = new Gson();
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 != null) goto L13;
        tt5.a.d("BitableRecommendDataFetcher", "parse data with null json");
        return new BitableRecommendResponse();
    L13:
        BitableRecommendResponse r101 = (BitableRecommendResponse) this.f213020b.fromJson(r100, BitableRecommendResponse.class);     // Catch: Throwable -> L9
        String r102 = this.f213019a;     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.setRequestId(r102);     // Catch: Throwable -> L9
        return r101;
    L9:
        th = move-exception;
        tt5.a.e("BitableRecommendDataFetcher", "parse data error", th, false);
        return new BitableRecommendResponse();
    }
}
