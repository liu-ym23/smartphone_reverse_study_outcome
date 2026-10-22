package com.larus.bmhome.chat.component.bottom.voice.service;

import com.larus.bmhome.chat.component.bottom.voice.d0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService$observeAudioData$2", f = "VoiceMixInputService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceMixInputService$observeAudioData$2 extends SuspendLambda implements Function3<FlowCollector<? super byte[]>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public VoiceMixInputService$observeAudioData$2(Continuation<? super VoiceMixInputService$observeAudioData$2> r100) {
        super(3, r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super byte[]> r100, Throwable r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super byte[]> r100, Throwable r101, Continuation<? super Unit> r102) {
        VoiceMixInputService$observeAudioData$2 r103 = new VoiceMixInputService$observeAudioData$2(r102);
        r103.L$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Throwable r101 = (Throwable) this.L$0;
        int r102 = d0.f300410d;
        d0.a.a("catch observeAudioData " + r101.getMessage());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
