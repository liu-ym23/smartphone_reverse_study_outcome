package com.larus.avlink.activeSummary;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.activeSummary.SoundPlayManager$startPlayLocalFile$1", f = "SoundPlayManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SoundPlayManager$startPlayLocalFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ boolean $ignoreDoraCall;
    final /* synthetic */ SoundPlayManager.b $listener;
    int label;
    final /* synthetic */ SoundPlayManager this$0;

    public SoundPlayManager$startPlayLocalFile$1(SoundPlayManager r100, String r101, SoundPlayManager.b r102, boolean r103, Continuation<? super SoundPlayManager$startPlayLocalFile$1> r104) {
        this.this$0 = r100;
        this.$filePath = r101;
        this.$listener = r102;
        this.$ignoreDoraCall = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SoundPlayManager$startPlayLocalFile$1(this.this$0, this.$filePath, this.$listener, this.$ignoreDoraCall, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SoundPlayManager$startPlayLocalFile$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        SoundPlayManager r101 = this.this$0;
        String r102 = this.$filePath;
        SoundPlayManager.b r103 = this.$listener;
        boolean r104 = this.$ignoreDoraCall;
        int r105 = SoundPlayManager.f291437f;
        r101.c(r102, r103, r104, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
