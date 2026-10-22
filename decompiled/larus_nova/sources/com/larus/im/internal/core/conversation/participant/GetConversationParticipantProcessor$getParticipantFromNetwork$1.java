package com.larus.im.internal.core.conversation.participant;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.participant.GetConversationParticipantProcessor", f = "GetConversationParticipantProcessor.kt", i = {0, 1}, l = {55, 56, 67}, m = "getParticipantFromNetwork", n = {"conversationId", "conversationId"}, s = {"L$0", "L$0"})
final class GetConversationParticipantProcessor$getParticipantFromNetwork$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetConversationParticipantProcessor this$0;

    public GetConversationParticipantProcessor$getParticipantFromNetwork$1(GetConversationParticipantProcessor r100, Continuation<? super GetConversationParticipantProcessor$getParticipantFromNetwork$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GetConversationParticipantProcessor.c(this.this$0, this);
    }
}
