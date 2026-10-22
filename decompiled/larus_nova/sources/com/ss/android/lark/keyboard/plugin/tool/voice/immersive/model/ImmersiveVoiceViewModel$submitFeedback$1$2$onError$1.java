package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.larksuite.framework.callback.Entity.ErrorResult;
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

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$submitFeedback$1$2$onError$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImmersiveVoiceViewModel$submitFeedback$1$2$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ErrorResult $err;
    final /* synthetic */ Function1<ErrorResult, Unit> $onError;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ImmersiveVoiceViewModel$submitFeedback$1$2$onError$1(Function1<? super ErrorResult, Unit> r100, ErrorResult r101, Continuation<? super ImmersiveVoiceViewModel$submitFeedback$1$2$onError$1> r102) {
        this.$onError = r100;
        this.$err = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ImmersiveVoiceViewModel$submitFeedback$1$2$onError$1(this.$onError, this.$err, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ImmersiveVoiceViewModel$submitFeedback$1$2$onError$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.$onError.invoke(this.$err);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
