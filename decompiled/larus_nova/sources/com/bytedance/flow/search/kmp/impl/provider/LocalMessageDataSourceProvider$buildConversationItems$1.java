package com.bytedance.flow.search.kmp.impl.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.provider.LocalMessageDataSourceProvider", f = "LocalMessageDataSourceProvider.kt", i = {0, 0, 0, 0, 0}, l = {201}, m = "buildConversationItems", n = {"keyword", "userId", "userName", "destination$iv$iv", "conv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5"})
public final class LocalMessageDataSourceProvider$buildConversationItems$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalMessageDataSourceProvider this$0;

    public LocalMessageDataSourceProvider$buildConversationItems$1(LocalMessageDataSourceProvider r100, Continuation<? super LocalMessageDataSourceProvider$buildConversationItems$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LocalMessageDataSourceProvider r101 = this.this$0;
        int r102 = LocalMessageDataSourceProvider.f243630c;
        return r101.b(null, null, null, this);
    }
}
