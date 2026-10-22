package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIRecommendBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements tb5.i<KnowledgeAIRecommendBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.inline.ai.api.knowledgeai.d f218845a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public a(com.ss.android.lark.inline.ai.api.knowledgeai.d r100) {
        Intrinsics.checkNotNullParameter(r100, "knowledgeAIViewModel");
        this.f218845a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        KnowledgeAIRecommendBean r102 = (KnowledgeAIRecommendBean) r100;
        if (r102 == null) goto L6;
        this.f218845a.e(new com.ss.android.lark.inline.ai.api.knowledgeai.e.c(r102));
        return;
    }
}
