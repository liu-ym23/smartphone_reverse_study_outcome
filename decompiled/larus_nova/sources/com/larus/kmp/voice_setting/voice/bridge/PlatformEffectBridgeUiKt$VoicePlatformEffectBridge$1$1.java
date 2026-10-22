package com.larus.kmp.voice_setting.voice.bridge;

import androidx.compose.runtime.State;
import com.larus.kmp.voice_setting.voice.component.VoicePlatformEffectKind;
import com.larus.kmp.voice_setting.voice.component.l5;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.bridge.PlatformEffectBridgeUiKt$VoicePlatformEffectBridge$1$1", f = "PlatformEffectBridgeUi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PlatformEffectBridgeUiKt$VoicePlatformEffectBridge$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t $bridgeState;
    final /* synthetic */ State<Function1<l5, Boolean>> $currentOnConsumeEffect$delegate;
    final /* synthetic */ l5 $effectData;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public PlatformEffectBridgeUiKt$VoicePlatformEffectBridge$1$1(t r100, l5 r101, State<? extends Function1<? super l5, Boolean>> r102, Continuation<? super PlatformEffectBridgeUiKt$VoicePlatformEffectBridge$1$1> r103) {
        this.$bridgeState = r100;
        this.$effectData = r101;
        this.$currentOnConsumeEffect$delegate = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PlatformEffectBridgeUiKt$VoicePlatformEffectBridge$1$1(this.$bridgeState, this.$effectData, this.$currentOnConsumeEffect$delegate, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PlatformEffectBridgeUiKt$VoicePlatformEffectBridge$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        if (this.$bridgeState.f351906a == false) goto L17;
        l5 r101 = this.$effectData;
        if (r101.f352356b == 0) goto L17;
        VoicePlatformEffectKind r102 = r101.f352355a;
        switch(PlatformEffectBridgeUiKt.a.f351847a[r102.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L12;
            case 18: goto L12;
            case 19: goto L12;
            case 20: goto L12;
            default: goto L11;
        };
    L12:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L17;
        this.$currentOnConsumeEffect$delegate.getValue().invoke(this.$effectData);
        goto L17
    L13:
        r103 = true;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
