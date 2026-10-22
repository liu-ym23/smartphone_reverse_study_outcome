package com.larus.dora.obric.onboarding;

import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1", f = "ObricDoraGOnboardingFragmentUiStateV2.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {})
final class ObricDoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricDoraGOnboardingFragmentV2Binding $binding;
    int label;

    public ObricDoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1(ObricDoraGOnboardingFragmentV2Binding r100, Continuation<? super ObricDoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1> r101) {
        this.$binding = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricDoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1(this.$binding, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricDoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ObricDoraGOnboardingFragmentV2Binding r103 = this.$binding;
        if (r103 == null) goto L15;
        int r104 = com.larus.utils.j0.f375426a;
        String r105 = com.larus.utils.j0.d(R.string.larus_dora_g_onboard_try_later_cn);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r105, "topText");
        w.a(r103, r105, true);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(4000, this) != r101) goto L11;
        return r101;
    }
}
