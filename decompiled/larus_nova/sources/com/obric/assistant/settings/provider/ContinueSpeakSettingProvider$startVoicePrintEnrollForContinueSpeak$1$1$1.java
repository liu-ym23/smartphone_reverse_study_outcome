package com.obric.assistant.settings.provider;

import android.content.Context;
import com.obric.assistant.settings.VoicePrintScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1", f = "ContinueSpeakSettingProvider.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
final class ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ com.obric.assistant.settings.spi.b $host;
    int label;

    public ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1(Context r100, com.obric.assistant.settings.spi.b r101, Continuation<? super ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1> r102) {
        this.$context = r100;
        this.$host = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1(this.$context, this.$host, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ega.c r103 = ega.c.f472616a;
        Context r104 = this.$context;
        VoicePrintScene r105 = VoicePrintScene.NOISE_REDUCTION;
        final com.obric.assistant.settings.spi.b r106 = this.$host;
        Function0 r107 = new s0(r106);
        Function0 r108 = new t0();
        r103.getClass();
        ega.c.b(r104, r105, r107, r108);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(300, this) != r101) goto L11;
        return r101;
    }
}
