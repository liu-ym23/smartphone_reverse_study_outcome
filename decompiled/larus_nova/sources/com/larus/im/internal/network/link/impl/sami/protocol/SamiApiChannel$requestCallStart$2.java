package com.larus.im.internal.network.link.impl.sami.protocol;

import gd9.e;
import gd9.t;
import java.util.Map;
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
@DebugMetadata(c = "com.larus.im.internal.network.link.impl.sami.protocol.SamiApiChannel$requestCallStart$2", f = "SamiApiChannel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SamiApiChannel$requestCallStart$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ String $localCallId;
    final /* synthetic */ String $requestType;
    private /* synthetic */ Object L$0;
    int label;

    public SamiApiChannel$requestCallStart$2(String r100, String r101, String r102, String r103, Map<String, String> r104, Continuation<? super SamiApiChannel$requestCallStart$2> r105) {
        this.$conversationId = r100;
        this.$botId = r101;
        this.$localCallId = r102;
        this.$requestType = r103;
        this.$headers = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        SamiApiChannel$requestCallStart$2 r101 = new SamiApiChannel$requestCallStart$2(this.$conversationId, this.$botId, this.$localCallId, this.$requestType, this.$headers, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super e> r101) {
        return ((SamiApiChannel$requestCallStart$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        String r112 = this.$conversationId;
        String r100 = this.$botId;
        String r101 = this.$localCallId;
        String r102 = this.$requestType;
        Map<String, String> r103 = this.$headers;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        SamiApiChannel.b r105 = new SamiApiChannel.b(r112, r100, r101, r102);     // Catch: Throwable -> L7
        Object r113 = Result.m9449constructorimpl(t.a.a(SamiApiChannel.f349490a, "/alice/call/start", r105, r103, null, 24));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r113) == false) goto L17;
        return null;
    L17:
        return r113;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
