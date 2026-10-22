package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.settings.sound.DoraAmbientVolumeSettingsNotifier;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$handleAtomicFuncCallbackPayload$1", f = "DoraServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AVUNSYNC_DURATION_MS}, m = "invokeSuspend", n = {}, s = {})
final class DoraServiceImpl$handleAtomicFuncCallbackPayload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $adaptiveVolumeRequestId;
    final /* synthetic */ DoraDevice $currentDevice;
    private /* synthetic */ Object L$0;
    int label;

    public DoraServiceImpl$handleAtomicFuncCallbackPayload$1(DoraDevice r100, Long r101, Continuation<? super DoraServiceImpl$handleAtomicFuncCallbackPayload$1> r102) {
        this.$currentDevice = r100;
        this.$adaptiveVolumeRequestId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraServiceImpl$handleAtomicFuncCallbackPayload$1 r102 = new DoraServiceImpl$handleAtomicFuncCallbackPayload$1(this.$currentDevice, this.$adaptiveVolumeRequestId, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraServiceImpl$handleAtomicFuncCallbackPayload$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Long r104 = this.$adaptiveVolumeRequestId;
        if (Result.m9456isSuccessimpl(r103) == false) goto L20;
        Unit r105 = (Unit) r103;
        FLogger.f375446a.i("DoraServiceImpl", "atomicFuncCallback: adaptive-volume state notified, requestId=" + r104);
    L20:
        Long r106 = this.$adaptiveVolumeRequestId;
        Throwable r107 = Result.m9452exceptionOrNullimpl(r103);
        if (r107 == null) goto L24;
        FLogger.f375446a.e("DoraServiceImpl", "atomicFuncCallback: adaptive-volume state notification failed, requestId=" + r106, r107);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r108 = (CoroutineScope) this.L$0;
        DoraDevice r109 = this.$currentDevice;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L15
        DoraAmbientVolumeSettingsNotifier r111 = DoraAmbientVolumeSettingsNotifier.f334888a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r111.c(r109, this) != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
