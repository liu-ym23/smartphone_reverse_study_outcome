package com.larus.dora.impl.ota.connector;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.connector.DoraOTAFakeConnector$startDataTransfer$1", f = "DoraOTAFakeConnector.kt", i = {0}, l = {22}, m = "invokeSuspend", n = {RXScreenCaptureService.KEY_INDEX}, s = {"I$0"})
final class DoraOTAFakeConnector$startDataTransfer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $callback;
    int I$0;
    int label;

    public DoraOTAFakeConnector$startDataTransfer$1(h r100, Continuation<? super DoraOTAFakeConnector$startDataTransfer$1> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraOTAFakeConnector$startDataTransfer$1(this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraOTAFakeConnector$startDataTransfer$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0035 -> B:14:0x0038). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        int r103 = this.I$0;
        ResultKt.throwOnFailure(r100);
        DoraOTAFakeConnector$startDataTransfer$1 r104 = this;
    L14:
        r103 = r103 + 1;
    L10:
        if (r103 >= 101) goto L15;
        r104.$callback.b(0, r103);
        r104.I$0 = r103;
        r104.label = 1;
        if (DelayKt.delay(1000, r104) != r101) goto L14;
        return r101;
    L15:
        r104.$callback.onSuccess(0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r104 = this;
        r103 = 0;
        goto L10
    }
}
