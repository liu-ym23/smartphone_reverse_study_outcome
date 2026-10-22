package com.obric.assistant.dora;

import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.dora.DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1", f = "DoraMainProcessBridgeService.kt", i = {0}, l = {106}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDoraMainProcessConnectCallback $callback;
    final /* synthetic */ String $requestId;
    final /* synthetic */ DoraDeviceInfo $safeDeviceInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraMainProcessBridgeService this$0;

    public DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1(DoraMainProcessBridgeService r100, DoraDeviceInfo r101, String r102, IDoraMainProcessConnectCallback r103, Continuation<? super DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1> r104) {
        this.this$0 = r100;
        this.$safeDeviceInfo = r101;
        this.$requestId = r102;
        this.$callback = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1 r102 = new DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1(this.this$0, this.$safeDeviceInfo, this.$requestId, this.$callback, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);
    L11:
        DoraMainProcessConnectResult r104 = (DoraMainProcessConnectResult) r100;
        IDoraMainProcessConnectCallback r105 = this.$callback;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
        if (r105 == null) goto L15;
        r105.onConnectResult(r104);     // Catch: Throwable -> L18
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L18
    L20:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L24;
        FLogger.f375446a.e("DoraMainProcessBridge", "checkBindAndConnectIfNecessaryAsync callback failed: " + r109.getMessage());
    L24:
        return Unit.INSTANCE;
    L15:
        r107 = null;
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        DoraMainProcessBridgeService r112 = this.this$0;
        DoraDeviceInfo r113 = this.$safeDeviceInfo;
        String r114 = this.$requestId;
        this.L$0 = r111;
        this.label = 1;
        r100 = DoraMainProcessBridgeService.a(r112, r113, r114, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
