package com.bytedance.ee.bear.document.icon;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f219992a = null;

    static {
        f219992a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        return (DocIconNetResult) JSON.parseObject(r100, DocIconNetResult.class);
    }
}
