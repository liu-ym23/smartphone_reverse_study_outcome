package com.larus.audio.call.play;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/audio/call/play/AVInnerPlayerAdapter$asyncDispatch$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.call.play.AVInnerPlayerAdapter$linkPlayerCallback$1$onFirstFrame$$inlined$asyncDispatch$1", f = "AVInnerPlayerAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AVInnerPlayerAdapter$linkPlayerCallback$1$onFirstFrame$$inlined$asyncDispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $content$inlined;
    final /* synthetic */ String $queryRound$inlined;
    final /* synthetic */ String $sectionId$inlined;
    int label;
    final /* synthetic */ AVInnerPlayerAdapter this$0;

    public AVInnerPlayerAdapter$linkPlayerCallback$1$onFirstFrame$$inlined$asyncDispatch$1(Continuation r100, AVInnerPlayerAdapter r101, byte[] r102, String r103, String r104) {
        this.this$0 = r101;
        this.$content$inlined = r102;
        this.$queryRound$inlined = r103;
        this.$sectionId$inlined = r104;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AVInnerPlayerAdapter$linkPlayerCallback$1$onFirstFrame$$inlined$asyncDispatch$1(r101, this.this$0, this.$content$inlined, this.$queryRound$inlined, this.$sectionId$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AVInnerPlayerAdapter$linkPlayerCallback$1$onFirstFrame$$inlined$asyncDispatch$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.this$0.f289275a.f289330g.invoke(this.$content$inlined, this.$queryRound$inlined, this.$sectionId$inlined);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
