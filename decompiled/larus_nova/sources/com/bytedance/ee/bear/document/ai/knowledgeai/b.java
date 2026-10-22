package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIShowBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements tb5.i<KnowledgeAIShowBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.inline.ai.api.knowledgeai.d f218846a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public b(com.ss.android.lark.inline.ai.api.knowledgeai.d r100) {
        Intrinsics.checkNotNullParameter(r100, "knowledgeAIViewModel");
        this.f218846a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        KnowledgeAIShowBean r102 = (KnowledgeAIShowBean) r100;
        if (r102 == null) goto L6;
        this.f218846a.e(new com.ss.android.lark.inline.ai.api.knowledgeai.e.C5050e(r102));
        return;
    }
}
