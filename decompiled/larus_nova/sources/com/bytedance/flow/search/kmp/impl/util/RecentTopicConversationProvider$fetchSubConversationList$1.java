package com.bytedance.flow.search.kmp.impl.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.util.RecentTopicConversationProvider", f = "ImportServices.android.kt", i = {}, l = {63}, m = "fetchSubConversationList", n = {}, s = {})
public final class RecentTopicConversationProvider$fetchSubConversationList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecentTopicConversationProvider this$0;

    public RecentTopicConversationProvider$fetchSubConversationList$1(RecentTopicConversationProvider r100, Continuation<? super RecentTopicConversationProvider$fetchSubConversationList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        RecentTopicConversationProvider r101 = this.this$0;
        RecentTopicConversationProvider r102 = RecentTopicConversationProvider.f243662a;
        return r101.a(this);
    }
}
