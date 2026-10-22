package com.bytedance.ee.bear.quoto;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class j implements NetService.c {
    public /* synthetic */ j() {
    }

    public final Result parse(String r2) {
        return (QuotaInfoResult) JSON.parseObject(r2, QuotaInfoResult.class);
    }
}
