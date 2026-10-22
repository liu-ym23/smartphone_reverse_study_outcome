package com.larus.im.internal.network.stragery.uplink;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/internal/network/stragery/uplink/BaseUplinkStrategy$ResponseInfo;", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.stragery.uplink.MessageSseUplinkStrategy$send$2$info$1$1", f = "MessageSseUplinkStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageSseUplinkStrategy$send$2$info$1$1 extends SuspendLambda implements Function2<BaseUplinkStrategy.c, Continuation<? super BaseUplinkStrategy.c>, Object> {
    final /* synthetic */ String $uniqueKey;
    /* synthetic */ Object L$0;
    int label;

    public MessageSseUplinkStrategy$send$2$info$1$1(String r100, Continuation<? super MessageSseUplinkStrategy$send$2$info$1$1> r101) {
        this.$uniqueKey = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MessageSseUplinkStrategy$send$2$info$1$1 r102 = new MessageSseUplinkStrategy$send$2$info$1$1(this.$uniqueKey, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(BaseUplinkStrategy.c r100, Continuation<? super BaseUplinkStrategy.c> r101) {
        return ((MessageSseUplinkStrategy$send$2$info$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(BaseUplinkStrategy.c r100, Continuation<? super BaseUplinkStrategy.c> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        BaseUplinkStrategy.c r101 = (BaseUplinkStrategy.c) this.L$0;
        com.larus.im.internal.delegate.a.f348188b.i("MessageSseUplinkStrategy", "receive uplink(" + this.$uniqueKey + ") ack from ws channel");
        return r101;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
