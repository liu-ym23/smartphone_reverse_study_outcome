package com.bytedance.flow_audio.impl.business.asr.viewModel;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.viewModel.VoiceInputViewModel$updateAmplitude$1", f = "VoiceInputViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceInputViewModel$updateAmplitude$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ double $nextAmplitude;
    int label;
    final /* synthetic */ VoiceInputViewModel this$0;

    public VoiceInputViewModel$updateAmplitude$1(VoiceInputViewModel r100, double r101, Continuation<? super VoiceInputViewModel$updateAmplitude$1> r102) {
        this.this$0 = r100;
        this.$nextAmplitude = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new VoiceInputViewModel$updateAmplitude$1(this.this$0, this.$nextAmplitude, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((VoiceInputViewModel$updateAmplitude$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        VoiceInputViewModel r101 = this.this$0;
        int r102 = VoiceInputViewModel.f244025m;
        Iterator<T> r103 = r101.f244031g.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        ((lw5.g) r103.next()).S2();
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
