package com.larus.bmhome.social.userchat.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatConversationRequestModel", f = "ChatConversationRequestModel.kt", i = {0, 0, 0, 1, 1, 1, 2, 4}, l = {136, 140, 147, 151, 157, 158}, m = "getBotFromDbAndServer", n = {"botId", "scene", "botLiveData", "scene", "botLiveData", "botCache", "botLiveData", "botLiveData"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0"})
public final class ChatConversationRequestModel$getBotFromDbAndServer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatConversationRequestModel this$0;

    public ChatConversationRequestModel$getBotFromDbAndServer$1(ChatConversationRequestModel r100, Continuation<? super ChatConversationRequestModel$getBotFromDbAndServer$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ChatConversationRequestModel r101 = this.this$0;
        int r102 = ChatConversationRequestModel.f314048r;
        return r101.b(null, null, null, this);
    }
}
