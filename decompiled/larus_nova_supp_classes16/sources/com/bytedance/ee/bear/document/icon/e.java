package com.bytedance.ee.bear.document.icon;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T extends Result> implements NetService.c {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r2) {
        return (DocIconNetResult) JSON.parseObject(r2, DocIconNetResult.class);
    }
}
