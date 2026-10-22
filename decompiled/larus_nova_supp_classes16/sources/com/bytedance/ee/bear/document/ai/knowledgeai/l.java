package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T extends Result> implements NetService.c {
    public static final l<T> a = null;

    static {
        a = new l();
    }

    public l() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r3) {
        Object r0 = null;
        kotlin.Result.Companion r1 = kotlin.Result.Companion;     // Catch: Throwable -> L9
        if (r3 != null) goto L6;
        KnowledgeAIScopeItemInfoResult r4 = null;
    L7:
        Object r5 = kotlin.Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (kotlin.Result.isFailure-impl(r5) == true) goto L15;
        r0 = r5;
    L15:
        KnowledgeAIScopeItemInfoResult r2 = (KnowledgeAIScopeItemInfoResult) r0;
        if (r2 == null) goto L18;
        return r2;
    L18:
        return new KnowledgeAIScopeItemInfoResult();
    L6:
        r4 = (KnowledgeAIScopeItemInfoResult) JSON.parseObject(r3, KnowledgeAIScopeItemInfoResult.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        kotlin.Result.Companion r6 = kotlin.Result.Companion;
        r5 = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
