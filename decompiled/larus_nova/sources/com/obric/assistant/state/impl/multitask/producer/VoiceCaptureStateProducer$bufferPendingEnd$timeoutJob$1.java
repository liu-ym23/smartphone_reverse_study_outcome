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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.VoiceCaptureStateProducer$bufferPendingEnd$timeoutJob$1", f = "VoiceCaptureStateProducer.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
final class VoiceCaptureStateProducer$bufferPendingEnd$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ VoiceCaptureStateProducer this$0;

    public VoiceCaptureStateProducer$bufferPendingEnd$timeoutJob$1(VoiceCaptureStateProducer r100, String r101, String r102, Continuation<? super VoiceCaptureStateProducer$bufferPendingEnd$timeoutJob$1> r103) {
        this.this$0 = r100;
        this.$key = r101;
        this.$sessionId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoiceCaptureStateProducer$bufferPendingEnd$timeoutJob$1(this.this$0, this.$key, this.$sessionId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceCaptureStateProducer$bufferPendingEnd$timeoutJob$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        if (this.this$0.f393150c.remove(this.$key) == null) goto L15;
        FLogger.f375446a.w("VoiceCaptureStateProducer", "bufferPendingEnd: timeout, discarding pending End for key=" + this.$key + ", sessionId=" + this.$sessionId);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r101) goto L12;
        return r101;
    }
}
