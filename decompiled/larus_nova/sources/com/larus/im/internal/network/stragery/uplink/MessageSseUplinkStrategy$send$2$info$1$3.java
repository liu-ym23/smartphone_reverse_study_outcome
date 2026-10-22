package com.larus.im.internal.network.stragery.uplink;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/internal/network/stragery/uplink/BaseUplinkStrategy$ResponseInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.stragery.uplink.MessageSseUplinkStrategy$send$2$info$1$3", f = "MessageSseUplinkStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageSseUplinkStrategy$send$2$info$1$3 extends SuspendLambda implements Function1<Continuation<? super BaseUplinkStrategy.c>, Object> {
    final /* synthetic */ String $uniqueKey;
    int label;

    public MessageSseUplinkStrategy$send$2$info$1$3(String r100, Continuation<? super MessageSseUplinkStrategy$send$2$info$1$3> r101) {
        this.$uniqueKey = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageSseUplinkStrategy$send$2$info$1$3(this.$uniqueKey, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super BaseUplinkStrategy.c> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super BaseUplinkStrategy.c> r100) {
        return ((MessageSseUplinkStrategy$send$2$info$1$3) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        com.larus.im.internal.delegate.a.f348188b.e("MessageSseUplinkStrategy", "receive uplink(" + this.$uniqueKey + ") ack timeout");
        return new BaseUplinkStrategy.c(0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
