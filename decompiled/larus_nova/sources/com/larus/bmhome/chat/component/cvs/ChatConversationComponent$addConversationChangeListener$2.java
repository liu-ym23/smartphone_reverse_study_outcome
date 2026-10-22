package com.larus.bmhome.chat.component.cvs;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/chat/component/cvs/ChatConversationVMState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$addConversationChangeListener$2", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$addConversationChangeListener$2 extends SuspendLambda implements Function2<ChatConversationVMState, Continuation<? super Unit>, Object> {
    final /* synthetic */ y.a<wc9.e> $listener;
    /* synthetic */ Object L$0;
    int label;

    public ChatConversationComponent$addConversationChangeListener$2(y.a<wc9.e> r100, Continuation<? super ChatConversationComponent$addConversationChangeListener$2> r101) {
        this.$listener = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChatConversationComponent$addConversationChangeListener$2 r102 = new ChatConversationComponent$addConversationChangeListener$2(this.$listener, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ChatConversationVMState r100, Continuation<? super Unit> r101) {
        return ((ChatConversationComponent$addConversationChangeListener$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ChatConversationVMState r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        wc9.e r101 = ((ChatConversationVMState) this.L$0).getConversation();
        if (r101 == null) goto L8;
        this.$listener.c(r101);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
