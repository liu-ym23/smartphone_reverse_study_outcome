package com.bytedance.ee.bear.bitable.homepage.tabchoose;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements NetService.c<BitableTabChooseResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f213092a;

    public a() {
        this.f213092a = new Gson();
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 != null) goto L16;
    L14:
        tt5.a.d("BitableRecommendDataFetcher", "parse data with null json");
        return new BitableTabChooseResponse();
    L16:
        BitableTabChooseResponse r101 = (BitableTabChooseResponse) this.f213092a.fromJson(r100, BitableTabChooseResponse.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L7;
        BitableTabData r102 = (BitableTabData) r101.data;     // Catch: Throwable -> L11
    L8:
        if (r102 == null) goto L13;
        b.a(r102);     // Catch: Throwable -> L11
    L13:
        if (r101 == null) goto L14;
        return r101;
    L7:
        r102 = null;
    L11:
        th = move-exception;
        tt5.a.e("BitableRecommendDataFetcher", "parse data error", th, false);
        r101 = new BitableTabChooseResponse();
        goto L13
    }
}
