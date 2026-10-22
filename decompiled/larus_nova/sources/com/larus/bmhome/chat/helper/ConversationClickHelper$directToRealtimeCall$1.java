package com.larus.bmhome.chat.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ConversationClickHelper", f = "ConversationClickHelper.kt", i = {0, 0, 0, 0}, l = {188}, m = "directToRealtimeCall", n = {"data", "argPosition", "recommendFromString", "conversationId"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class ConversationClickHelper$directToRealtimeCall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationClickHelper this$0;

    public ConversationClickHelper$directToRealtimeCall$1(ConversationClickHelper r100, Continuation<? super ConversationClickHelper$directToRealtimeCall$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ConversationClickHelper.a(this.this$0, null, null, null, this);
    }
}
