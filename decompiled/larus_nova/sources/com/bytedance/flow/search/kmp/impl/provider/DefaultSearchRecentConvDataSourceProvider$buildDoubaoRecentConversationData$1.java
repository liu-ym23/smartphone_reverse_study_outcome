package com.bytedance.flow.search.kmp.impl.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.provider.DefaultSearchRecentConvDataSourceProvider", f = "DefaultSearchRecentConvDataSourceProvider.kt", i = {0, 0, 0}, l = {537}, m = "buildDoubaoRecentConversationData", n = {"preview", "domain", "conversation"}, s = {"L$0", "L$1", "L$2"})
public final class DefaultSearchRecentConvDataSourceProvider$buildDoubaoRecentConversationData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultSearchRecentConvDataSourceProvider this$0;

    public DefaultSearchRecentConvDataSourceProvider$buildDoubaoRecentConversationData$1(DefaultSearchRecentConvDataSourceProvider r100, Continuation<? super DefaultSearchRecentConvDataSourceProvider$buildDoubaoRecentConversationData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DefaultSearchRecentConvDataSourceProvider r101 = this.this$0;
        int r102 = DefaultSearchRecentConvDataSourceProvider.f243622h;
        return r101.b(null, null, null, this);
    }
}
