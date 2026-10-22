package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T, R> f218853a = null;

    static {
        f218853a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        KnowledgeAIControlInfoResult r101 = (KnowledgeAIControlInfoResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        KnowledgeAIControlInfoResponse r102 = (KnowledgeAIControlInfoResponse) r101.data;
        if (r102 == null) goto L5;
        return r102;
    L5:
        return new KnowledgeAIControlInfoResponse(null, false, 3, null);
    }
}
