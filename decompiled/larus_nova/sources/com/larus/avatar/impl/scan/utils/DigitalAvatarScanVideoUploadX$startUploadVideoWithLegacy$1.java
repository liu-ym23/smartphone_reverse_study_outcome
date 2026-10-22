package com.larus.avatar.impl.scan.utils;

import com.larus.bmhome.chat.input.ChatInputService;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.scan.utils.DigitalAvatarScanVideoUploadX$startUploadVideoWithLegacy$1", f = "DigitalAvatarScanVideoUploadX.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarScanVideoUploadX$startUploadVideoWithLegacy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.q $tryFileUploadParam;
    int label;

    public DigitalAvatarScanVideoUploadX$startUploadVideoWithLegacy$1(com.larus.bmhome.chat.component.bottom.multimodal.upload.q r100, Continuation<? super DigitalAvatarScanVideoUploadX$startUploadVideoWithLegacy$1> r101) {
        this.$tryFileUploadParam = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DigitalAvatarScanVideoUploadX$startUploadVideoWithLegacy$1(this.$tryFileUploadParam, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DigitalAvatarScanVideoUploadX$startUploadVideoWithLegacy$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ye8.c r103 = ChatInputService.f303327b.g();
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r104 = this.$tryFileUploadParam;
        this.label = 1;
        if (r103.b(r104, this) != r101) goto L12;
        return r101;
    }
}
