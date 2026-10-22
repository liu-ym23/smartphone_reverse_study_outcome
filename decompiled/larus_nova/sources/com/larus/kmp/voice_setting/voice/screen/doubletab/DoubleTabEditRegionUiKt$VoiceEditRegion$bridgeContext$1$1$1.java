package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.runtime.State;
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

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.screen.doubletab.DoubleTabEditRegionUiKt$VoiceEditRegion$bridgeContext$1$1$1", f = "DoubleTabEditRegionUi.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
public final class DoubleTabEditRegionUiKt$VoiceEditRegion$bridgeContext$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<Boolean, Unit>> $currentOnAppBarCollapsedChanged$delegate;
    final /* synthetic */ VoiceEditRegionState $state;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoubleTabEditRegionUiKt$VoiceEditRegion$bridgeContext$1$1$1(VoiceEditRegionState r100, State<? extends Function1<? super Boolean, Unit>> r101, Continuation<? super DoubleTabEditRegionUiKt$VoiceEditRegion$bridgeContext$1$1$1> r102) {
        this.$state = r100;
        this.$currentOnAppBarCollapsedChanged$delegate = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoubleTabEditRegionUiKt$VoiceEditRegion$bridgeContext$1$1$1(this.$state, this.$currentOnAppBarCollapsedChanged$delegate, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoubleTabEditRegionUiKt$VoiceEditRegion$bridgeContext$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        VoiceEditRegionState r103 = this.$state;
        Function1<Boolean, Unit> r104 = this.$currentOnAppBarCollapsedChanged$delegate.getValue();
        this.label = 1;
        if (r103.a(true, r104, this) != r101) goto L12;
        return r101;
    }
}
