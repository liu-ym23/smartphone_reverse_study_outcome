package com.larus.im.internal.network.link.impl.sami.protocol;

import gd9.e;
import gd9.t;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/depend/FlowNetResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.link.impl.sami.protocol.SamiApiChannel$requestCallEnd$2", f = "SamiApiChannel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SamiApiChannel$requestCallEnd$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    final /* synthetic */ String $callId;
    private /* synthetic */ Object L$0;
    int label;

    public SamiApiChannel$requestCallEnd$2(String r100, Continuation<? super SamiApiChannel$requestCallEnd$2> r101) {
        this.$callId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        SamiApiChannel$requestCallEnd$2 r102 = new SamiApiChannel$requestCallEnd$2(this.$callId, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super e> r101) {
        return ((SamiApiChannel$requestCallEnd$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$callId;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        SamiApiChannel.a r104 = new SamiApiChannel.a(r102);     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(t.a.a(SamiApiChannel.f349490a, "/alice/call/end", r104, null, null, 28));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r105) == false) goto L17;
        return null;
    L17:
        return r105;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
