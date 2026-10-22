package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.advance.AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1", f = "AdvanceVoiceInputComponent.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
final class AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.audio.voiceinput.c $asrResult;
    int label;
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1(b r100, com.ss.android.lark.audio.voiceinput.c r101, Continuation<? super AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1> r102) {
        this.this$0 = r100;
        this.$asrResult = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1(this.this$0, this.$asrResult, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L8;
        ResultKt.throwOnFailure(r100);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
        String r102 = this.$asrResult.f409209c;
        boolean r103 = false;
        if (r102 != null) goto L12;
    L14:
        Boxing.boxBoolean(r103);
        this.label = 1;
        throw null;
    L12:
        if (StringsKt.isBlank(r102) == true) goto L14;
        r103 = true;
        goto L14
    }
}
