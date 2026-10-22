package com.obric.assistant.state.impl.multitask.producer;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1", f = "SelfUpdateDownloadStateProducer.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ SelfUpdateDownloadStateProducer this$0;

    public SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1(SelfUpdateDownloadStateProducer r100, int r101, Continuation<? super SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1> r102) {
        this.this$0 = r100;
        this.$state = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1(this.this$0, this.$state, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        SelfUpdateDownloadStateProducer r103 = this.this$0;
        int r104 = this.$state;
        this.label = 1;
        if (r104 == 2) goto L11;
        r103.f393136f = false;
        r103.a("state_changed");
        Object r105 = Unit.INSTANCE;
    L18:
        if (r105 != r101) goto L21;
        return r101;
    L11:
        if (r103.f393136f == false) goto L13;
        FLogger.f375446a.i("SelfUpdateDownloadStateProducer", "ignore downloading after max hold timeout until state exits");
        r105 = Unit.INSTANCE;
        goto L18
    L13:
        r105 = r103.b(this);
        if (r105 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r105 = Unit.INSTANCE;
        goto L18
    }
}
