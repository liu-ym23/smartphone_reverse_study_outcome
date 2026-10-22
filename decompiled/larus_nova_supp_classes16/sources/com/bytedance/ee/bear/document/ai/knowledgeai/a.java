package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIRecommendBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements tb5.i<KnowledgeAIRecommendBean> {
    public final com.ss.android.lark.inline.ai.api.knowledgeai.d a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public a(com.ss.android.lark.inline.ai.api.knowledgeai.d r2) {
        Intrinsics.checkNotNullParameter(r2, "knowledgeAIViewModel");
        this.a = r2;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r2, tb5.m r3) {
        KnowledgeAIRecommendBean r4 = (KnowledgeAIRecommendBean) r2;
        if (r4 == null) goto L6;
        this.a.e(new com.ss.android.lark.inline.ai.api.knowledgeai.e.c(r4));
        return;
    }
}
