package com.larus.chat.gallery.impl.preview.toolbar.action;

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

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.DownloadAction$downloadImageViaCreationRecord$3", f = "DownloadAction.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA}, m = "invokeSuspend", n = {}, s = {})
final class DownloadAction$downloadImageViaCreationRecord$3 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $downloadUrl;
    final /* synthetic */ String $imageUri;
    final /* synthetic */ String $subScene;
    int label;

    public DownloadAction$downloadImageViaCreationRecord$3(String r100, String r101, String r102, Continuation<? super DownloadAction$downloadImageViaCreationRecord$3> r103) {
        this.$downloadUrl = r100;
        this.$subScene = r101;
        this.$imageUri = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new DownloadAction$downloadImageViaCreationRecord$3(this.$downloadUrl, this.$subScene, this.$imageUri, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super String> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super String> r100) {
        return ((DownloadAction$downloadImageViaCreationRecord$3) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L11:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        IUgcAIGCService.Companion r102 = IUgcAIGCService.f373945a;
        String r111 = this.$downloadUrl;
        String r103 = this.$subScene;
        String r104 = this.$imageUri;
        this.label = 1;
        r110 = r102.D(r111, "Creation", r103, "image", true, r104, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
