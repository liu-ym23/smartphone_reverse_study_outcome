package com.larus.uaigc.chat.block.create;

import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1", f = "RichMediaCreationClickServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1 extends SuspendLambda implements Function1<Continuation<? super Message>, Object> {
    final /* synthetic */ Message $message;
    int label;

    public RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1(Message r100, Continuation<? super RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1> r101) {
        this.$message = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1(this.$message, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Message> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Message> r100) {
        return ((RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return this.$message;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
