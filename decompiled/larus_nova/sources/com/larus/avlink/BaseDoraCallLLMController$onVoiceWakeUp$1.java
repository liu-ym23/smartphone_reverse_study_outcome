package com.larus.avlink;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.BaseDoraCallLLMController$onVoiceWakeUp$1", f = "BaseDoraCallLLMController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseDoraCallLLMController$onVoiceWakeUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $extra;
    final /* synthetic */ String $kw;
    final /* synthetic */ int $mode;
    final /* synthetic */ int $query;
    final /* synthetic */ int $side;
    final /* synthetic */ int $state;
    final /* synthetic */ int $vuiId;
    int label;
    final /* synthetic */ o this$0;

    public BaseDoraCallLLMController$onVoiceWakeUp$1(o r100, int r101, int r102, int r103, int r104, int r105, String r106, String r107, Continuation<? super BaseDoraCallLLMController$onVoiceWakeUp$1> r108) {
        this.this$0 = r100;
        this.$state = r101;
        this.$mode = r102;
        this.$query = r103;
        this.$side = r104;
        this.$vuiId = r105;
        this.$kw = r106;
        this.$extra = r107;
        super(2, r108);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new BaseDoraCallLLMController$onVoiceWakeUp$1(this.this$0, this.$state, this.$mode, this.$query, this.$side, this.$vuiId, this.$kw, this.$extra, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BaseDoraCallLLMController$onVoiceWakeUp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r110);
        o r111 = this.this$0;
        final int r100 = this.$state;
        final int r101 = this.$mode;
        final int r102 = this.$query;
        final int r103 = this.$side;
        final int r104 = this.$vuiId;
        final String r105 = this.$kw;
        final String r106 = this.$extra;
        Function1 r107 = new p(r100, r101, r102, r103, r104, r105, r106);
        int r108 = o.E;
        r111.W(r107);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
