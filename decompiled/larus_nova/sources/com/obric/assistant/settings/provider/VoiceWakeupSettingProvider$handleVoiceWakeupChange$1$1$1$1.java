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
@DebugMetadata(c = "com.obric.assistant.settings.provider.VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1", f = "VoiceWakeupSettingProvider.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $currentContext;
    final /* synthetic */ com.obric.assistant.settings.spi.b $host;
    int label;

    public VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1(Context r100, com.obric.assistant.settings.spi.b r101, Continuation<? super VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1> r102) {
        this.$currentContext = r100;
        this.$host = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1(this.$currentContext, this.$host, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        final Context r104 = this.$currentContext;
        VoicePrintScene r105 = VoicePrintScene.VOICE_WAKE_UP;
        final com.obric.assistant.settings.spi.b r106 = this.$host;
        Function0 r107 = new d2(r104, r106);
        Function0 r108 = new e2(r106);
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
