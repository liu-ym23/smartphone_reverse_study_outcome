package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.screen.doubletab.DoubleTabRootShellWidget$DoubleTabRootShellContent$4$1", f = "DoubleTabChromeUi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoubleTabRootShellWidget$DoubleTabRootShellContent$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.kmp.voice_setting.voice.component.y3 $doubleTabState;
    final /* synthetic */ com.larus.kmp.voice_setting.voice.component.u4 $entryAbility;
    final /* synthetic */ com.larus.kmp.voice_setting.voice.component.p $rootShellState;
    int label;

    public DoubleTabRootShellWidget$DoubleTabRootShellContent$4$1(com.larus.kmp.voice_setting.voice.component.p r100, com.larus.kmp.voice_setting.voice.component.y3 r101, com.larus.kmp.voice_setting.voice.component.u4 r102, Continuation<? super DoubleTabRootShellWidget$DoubleTabRootShellContent$4$1> r103) {
        this.$rootShellState = r100;
        this.$doubleTabState = r101;
        this.$entryAbility = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoubleTabRootShellWidget$DoubleTabRootShellContent$4$1(this.$rootShellState, this.$doubleTabState, this.$entryAbility, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoubleTabRootShellWidget$DoubleTabRootShellContent$4$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        if (this.$rootShellState.f352449a == false) goto L12;
        if ((!this.$doubleTabState.f352636i.f352570a.isEmpty()) == false) goto L12;
        com.larus.kmp.voice_setting.voice.component.u4 r101 = this.$entryAbility;
        if (r101 == null) goto L12;
        r101.onVisible();
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
