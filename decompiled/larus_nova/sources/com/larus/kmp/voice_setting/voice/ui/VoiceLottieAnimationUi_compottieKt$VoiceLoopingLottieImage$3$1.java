package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.runtime.MutableState;
import io.github.alexzhirkevich.compottie.LottieCompositionResult;
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
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.ui.VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$3$1", f = "VoiceLottieAnimationUi.compottie.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $assetPath;
    final /* synthetic */ LottieCompositionResult $result;
    final /* synthetic */ MutableState<Boolean> $useFallbackAfterFailure$delegate;
    int label;

    public VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$3$1(LottieCompositionResult r100, String r101, MutableState<Boolean> r102, Continuation<? super VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$3$1> r103) {
        this.$result = r100;
        this.$assetPath = r101;
        this.$useFallbackAfterFailure$delegate = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$3$1(this.$result, this.$assetPath, this.$useFallbackAfterFailure$delegate, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r100);
        if (this.$result.isFailure() == false) goto L14;
        StringBuilder r101 = new StringBuilder("[lottie:failed] asset=");
        r101.append(this.$assetPath);
        r101.append(" error=");
        Throwable r102 = this.$result.getError();
        if (r102 == null) goto L9;
        String r103 = r102.getMessage();
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        r101.append(r103);
        VoiceLottieAnimationUi_compottieKt.b(r101.toString());
        this.$useFallbackAfterFailure$delegate.setValue(Boolean.TRUE);
        goto L14
    L9:
        r103 = null;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
