package com.larus.kmp.voice_setting.voice.ui;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mrc.e0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/github/alexzhirkevich/compottie/LottieCompositionSpec;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.ui.VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$result$1$1", f = "VoiceLottieAnimationUi.compottie.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$result$1$1 extends SuspendLambda implements Function1<Continuation<? super io.github.alexzhirkevich.compottie.x>, Object> {
    final /* synthetic */ String $assetPath;
    Object L$0;
    int label;

    public VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$result$1$1(String r100, Continuation<? super VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$result$1$1> r101) {
        this.$assetPath = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$result$1$1(this.$assetPath, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super io.github.alexzhirkevich.compottie.x> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super io.github.alexzhirkevich.compottie.x> r100) {
        return ((VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$result$1$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        io.github.alexzhirkevich.compottie.x.a r103 = (io.github.alexzhirkevich.compottie.x.a) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        String r104 = StringsKt.decodeToString((byte[]) r100);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "jsonString");
        Intrinsics.checkNotNullParameter(r104, "jsonString");
        return new io.github.alexzhirkevich.compottie.c(r104);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        io.github.alexzhirkevich.compottie.x.a r105 = io.github.alexzhirkevich.compottie.x.f491614a;
        int r106 = e0.f515088a;
        String r107 = "files/" + this.$assetPath;
        this.L$0 = r105;
        this.label = 1;
        Intrinsics.checkNotNullParameter(r107, "path");
        Object r108 = org.jetbrains.compose.resources.v.f525876a.a("composeResources/flowkmp.business.flow_voice_setting.kmp_impl.generated.resources/" + r107);
        if (r108 != r101) goto L11;
        return r101;
    L11:
        r103 = r105;
        r100 = r108;
        goto L12
    }
}
