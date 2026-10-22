package com.larus.dora.obric.device_v2;

import com.larus.dora.impl.onboarding.q0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_v2.ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1", f = "ObricDoraGOnboardingDialogFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1 extends SuspendLambda implements Function2<q0, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1(Continuation<? super ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1 r102 = new ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(q0 r100, Continuation<? super Boolean> r101) {
        return ((ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(q0 r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return Boxing.boxBoolean(!(((q0) this.L$0) instanceof q0.c));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
