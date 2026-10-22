package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import com.larus.platform.service.FlowDriveSdkService;
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

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1", f = "LegacyMultimodalDataProcessor.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_READ_FIRST_PKT_TIME}, m = "invokeSuspend", n = {}, s = {})
public final class LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    public LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1(String r100, Continuation<? super LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1> r101) {
        this.$token = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1 r102 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1(this.$token, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl((String) r100);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r103) == false) goto L23;
        return null;
    L23:
        return r103;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = (CoroutineScope) this.L$0;
        String r105 = this.$token;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        FlowDriveSdkService r107 = FlowDriveSdkService.f365704a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = r107.b(r105, this);     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
