package com.bytedance.ee.bear.quoto;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class j implements NetService.c {
    public /* synthetic */ j() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        return (QuotaInfoResult) JSON.parseObject(r100, QuotaInfoResult.class);
    }
}
