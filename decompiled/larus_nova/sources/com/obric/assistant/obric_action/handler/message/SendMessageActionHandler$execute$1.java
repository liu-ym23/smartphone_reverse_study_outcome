package com.obric.assistant.obric_action.handler.message;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.message.SendMessageActionHandler", f = "SendMessageActionHandler.kt", i = {0, 0}, l = {76}, m = "execute", n = {"params", "content"}, s = {"L$0", "L$1"})
final class SendMessageActionHandler$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendMessageActionHandler this$0;

    public SendMessageActionHandler$execute$1(SendMessageActionHandler r100, Continuation<? super SendMessageActionHandler$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
