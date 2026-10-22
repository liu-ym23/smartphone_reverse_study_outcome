package com.larus.uploader.impl;

import com.ss.bduploader.BDImageXInfo;
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
import mr9.l;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uploader.impl.ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1", f = "ImageXUploaderImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY}, m = "invokeSuspend", n = {}, s = {})
public final class ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l>, Object> {
    final /* synthetic */ BDImageXInfo $info;
    int label;
    final /* synthetic */ ImageXUploaderImpl.ImageXUploadListener this$0;

    public ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1(ImageXUploaderImpl.ImageXUploadListener r100, BDImageXInfo r101, Continuation<? super ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1> r102) {
        this.this$0 = r100;
        this.$info = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1(this.this$0, this.$info, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super l> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super l> r101) {
        return ((ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ImageXUploaderImpl.ImageXUploadListener r103 = this.this$0;
        BDImageXInfo r104 = this.$info;
        this.label = 1;
        r100 = ImageXUploaderImpl.ImageXUploadListener.a(r103, r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
