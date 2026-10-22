package com.larus.bmhome.chat.layout.holder.image;

import com.larus.uaigc.service.IUgcAIGCService;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder$doSaveImage$5", f = "ImageScrollAdapter.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME}, m = "invokeSuspend", n = {}, s = {})
final class ScrollImageViewHolder$doSaveImage$5 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ String $subScene;
    int label;

    public ScrollImageViewHolder$doSaveImage$5(String r100, String r101, Continuation<? super ScrollImageViewHolder$doSaveImage$5> r102) {
        this.$imageUrl = r100;
        this.$subScene = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ScrollImageViewHolder$doSaveImage$5(this.$imageUrl, this.$subScene, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super String> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super String> r100) {
        return ((ScrollImageViewHolder$doSaveImage$5) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        IUgcAIGCService.Companion r103 = IUgcAIGCService.f373945a;
        String r104 = this.$imageUrl;
        String r105 = this.$subScene;
        this.label = 1;
        r100 = IUgcAIGCService.a.b(r103, r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
