package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T, R> implements Function {
    public static final k<T, R> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object apply(Object r4) {
        KnowledgeAIControlInfoResult r5 = (KnowledgeAIControlInfoResult) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        KnowledgeAIControlInfoResponse r6 = (KnowledgeAIControlInfoResponse) r5.data;
        if (r6 == null) goto L5;
        return r6;
    L5:
        return new KnowledgeAIControlInfoResponse(null, false, 3, null);
    }
}
