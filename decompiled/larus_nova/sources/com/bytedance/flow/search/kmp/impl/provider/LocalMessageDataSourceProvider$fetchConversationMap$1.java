package com.bytedance.flow.search.kmp.impl.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.provider.LocalMessageDataSourceProvider", f = "LocalMessageDataSourceProvider.kt", i = {0}, l = {242}, m = "fetchConversationMap", n = {"conversationIds"}, s = {"L$0"})
public final class LocalMessageDataSourceProvider$fetchConversationMap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalMessageDataSourceProvider this$0;

    public LocalMessageDataSourceProvider$fetchConversationMap$1(LocalMessageDataSourceProvider r100, Continuation<? super LocalMessageDataSourceProvider$fetchConversationMap$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LocalMessageDataSourceProvider r101 = this.this$0;
        int r102 = LocalMessageDataSourceProvider.f243630c;
        return r101.d(null, this);
    }
}
