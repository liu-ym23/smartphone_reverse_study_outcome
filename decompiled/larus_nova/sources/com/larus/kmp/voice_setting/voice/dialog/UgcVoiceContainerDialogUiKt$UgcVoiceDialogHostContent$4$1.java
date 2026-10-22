package com.larus.kmp.voice_setting.voice.dialog;

import com.larus.kmp.voice_setting.voice.component.VoiceDialogKind;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.dialog.UgcVoiceContainerDialogUiKt$UgcVoiceDialogHostContent$4$1", f = "UgcVoiceContainerDialogUi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UgcVoiceContainerDialogUiKt$UgcVoiceDialogHostContent$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $nameInputCurrentImeBottomPx;
    final /* synthetic */ b $nameInputImeInsetState;
    final /* synthetic */ com.larus.kmp.voice_setting.voice.component.o1 $state;
    int label;

    public UgcVoiceContainerDialogUiKt$UgcVoiceDialogHostContent$4$1(com.larus.kmp.voice_setting.voice.component.o1 r100, int r101, b r102, Continuation<? super UgcVoiceContainerDialogUiKt$UgcVoiceDialogHostContent$4$1> r103) {
        this.$state = r100;
        this.$nameInputCurrentImeBottomPx = r101;
        this.$nameInputImeInsetState = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UgcVoiceContainerDialogUiKt$UgcVoiceDialogHostContent$4$1(this.$state, this.$nameInputCurrentImeBottomPx, this.$nameInputImeInsetState, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((UgcVoiceContainerDialogUiKt$UgcVoiceDialogHostContent$4$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        if (this.$state.f352411b != VoiceDialogKind.NAME_INPUT) goto L12;
        int r101 = w2.f353217a;
        Pair[] r102 = new Pair[7];
        if (this.$nameInputCurrentImeBottomPx <= 0) goto L9;
        boolean r103 = true;
    L10:
        r102[0] = TuplesKt.to("ime_visible", Boxing.boxBoolean(r103));
        r102[1] = TuplesKt.to("ime_bottom_px", Boxing.boxInt(this.$nameInputCurrentImeBottomPx));
        r102[2] = TuplesKt.to("applied_ime_bottom_px", Boxing.boxInt(this.$nameInputImeInsetState.f352704a));
        r102[3] = TuplesKt.to("ime_gate_ready", Boxing.boxBoolean(this.$nameInputImeInsetState.f352706c));
        r102[4] = TuplesKt.to("content_visible", Boxing.boxBoolean(this.$nameInputImeInsetState.f352705b));
        r102[5] = TuplesKt.to("follow_ime_animation", Boxing.boxBoolean(true));
        r102[6] = TuplesKt.to("background_dialog_kind", this.$state.f352421l.f352335g.name());
        w2.c("name input ime inset changed", "InputDialog", MapsKt.mapOf(r102), 12);
        goto L12
    L9:
        r103 = false;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
