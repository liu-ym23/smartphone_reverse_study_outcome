package com.larus.im.internal.core.message;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.FtsSearchMessageProcessor", f = "FtsSearchMessageProcessor.kt", i = {}, l = {97}, m = "resolveConversationSearchScope", n = {}, s = {})
public final class FtsSearchMessageProcessor$resolveConversationSearchScope$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FtsSearchMessageProcessor this$0;

    public FtsSearchMessageProcessor$resolveConversationSearchScope$1(FtsSearchMessageProcessor r100, Continuation<? super FtsSearchMessageProcessor$resolveConversationSearchScope$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FtsSearchMessageProcessor r101 = this.this$0;
        List<Integer> r102 = FtsSearchMessageProcessor.f347740f;
        return r101.h(this);
    }
}
