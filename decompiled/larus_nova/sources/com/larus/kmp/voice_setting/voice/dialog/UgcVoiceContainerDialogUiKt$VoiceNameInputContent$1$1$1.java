package com.larus.kmp.voice_setting.voice.dialog;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.SoftwareKeyboardController;
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
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.dialog.UgcVoiceContainerDialogUiKt$VoiceNameInputContent$1$1$1", f = "UgcVoiceContainerDialogUi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UgcVoiceContainerDialogUiKt$VoiceNameInputContent$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    int label;

    public UgcVoiceContainerDialogUiKt$VoiceNameInputContent$1$1$1(FocusRequester r100, SoftwareKeyboardController r101, Continuation<? super UgcVoiceContainerDialogUiKt$VoiceNameInputContent$1$1$1> r102) {
        this.$focusRequester = r100;
        this.$keyboardController = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UgcVoiceContainerDialogUiKt$VoiceNameInputContent$1$1$1(this.$focusRequester, this.$keyboardController, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((UgcVoiceContainerDialogUiKt$VoiceNameInputContent$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        FocusRequester.m4489requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
        SoftwareKeyboardController r101 = this.$keyboardController;
        if (r101 == null) goto L8;
        r101.show();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
