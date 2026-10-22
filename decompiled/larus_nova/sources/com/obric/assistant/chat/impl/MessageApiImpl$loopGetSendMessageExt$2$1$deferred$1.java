package com.obric.assistant.chat.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/chat/impl/MessageApiImpl$GetExtTaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1", f = "MessageApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MessageApiImpl.b>, Object> {
    final /* synthetic */ bda.b $callback;
    final /* synthetic */ Map<String, String> $originExt;
    final /* synthetic */ bda.b.a $queryData;
    int label;

    public MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1(bda.b.a r100, bda.b r101, Map<String, String> r102, Continuation<? super MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1> r103) {
        this.$queryData = r100;
        this.$callback = r101;
        this.$originExt = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1(this.$queryData, this.$callback, this.$originExt, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super MessageApiImpl.b> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super MessageApiImpl.b> r101) {
        return ((MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        bda.b.a r101 = this.$queryData;
        if (r101 == null) goto L7;
        bda.b.a r102 = new bda.b.a(r101.f18700a, r101.f18701b);
    L9:
        return new MessageApiImpl.b(this.$callback.getExt(this.$originExt, r102), System.currentTimeMillis());
    L7:
        r102 = null;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
