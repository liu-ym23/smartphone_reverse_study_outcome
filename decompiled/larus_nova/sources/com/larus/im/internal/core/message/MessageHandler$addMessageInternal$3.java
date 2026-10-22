package com.larus.im.internal.core.message;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.MessageHandler$addMessageInternal$3", f = "MessageHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MessageHandler$addMessageInternal$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMCallback<Message> $callback;
    final /* synthetic */ Message $message;
    int label;

    public MessageHandler$addMessageInternal$3(IIMCallback<Message> r100, Message r101, Continuation<? super MessageHandler$addMessageInternal$3> r102) {
        this.$callback = r100;
        this.$message = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MessageHandler$addMessageInternal$3(this.$callback, this.$message, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MessageHandler$addMessageInternal$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        IIMCallback<Message> r101 = this.$callback;
        if (r101 == null) goto L8;
        r101.onSuccess(this.$message);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
