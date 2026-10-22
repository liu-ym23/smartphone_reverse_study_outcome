package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T> f218852a = null;

    static {
        f218852a = new j();
    }

    public j() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        Object r101 = null;
        kotlin.Result.Companion r102 = kotlin.Result.Companion;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
        KnowledgeAIControlInfoResult r103 = null;
    L7:
        Object r104 = kotlin.Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (kotlin.Result.m9455isFailureimpl(r104) == true) goto L15;
        r101 = r104;
    L15:
        KnowledgeAIControlInfoResult r105 = (KnowledgeAIControlInfoResult) r101;
        if (r105 == null) goto L18;
        return r105;
    L18:
        return new KnowledgeAIControlInfoResult();
    L6:
        r103 = (KnowledgeAIControlInfoResult) JSON.parseObject(r100, KnowledgeAIControlInfoResult.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        kotlin.Result.Companion r106 = kotlin.Result.Companion;
        r104 = kotlin.Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
