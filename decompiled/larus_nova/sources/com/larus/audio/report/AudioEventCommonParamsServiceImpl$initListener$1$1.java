package com.larus.audio.report;

import android.media.AudioDeviceCallback;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.report.AudioEventCommonParamsServiceImpl$initListener$1$1", f = "AudioEventCommonParamsServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioEventCommonParamsServiceImpl$initListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioManager $audioManager;
    final /* synthetic */ AudioEventCommonParamsServiceImpl $this_runCatching;
    int label;

    public AudioEventCommonParamsServiceImpl$initListener$1$1(AudioManager r100, AudioEventCommonParamsServiceImpl r101, Continuation<? super AudioEventCommonParamsServiceImpl$initListener$1$1> r102) {
        this.$audioManager = r100;
        this.$this_runCatching = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AudioEventCommonParamsServiceImpl$initListener$1$1(this.$audioManager, this.$this_runCatching, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AudioEventCommonParamsServiceImpl$initListener$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        AudioManager r101 = this.$audioManager;
        if (r101 == null) goto L8;
        r101.registerAudioDeviceCallback((AudioDeviceCallback) this.$this_runCatching.f289803f.getValue(), new Handler(Looper.getMainLooper()));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
