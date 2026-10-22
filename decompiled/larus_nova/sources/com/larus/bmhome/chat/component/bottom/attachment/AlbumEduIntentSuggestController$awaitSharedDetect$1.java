package com.larus.bmhome.chat.component.bottom.attachment;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController", f = "AlbumEduIntentSuggestController.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP}, m = "awaitSharedDetect", n = {"imageKey", "sharedTask"}, s = {"L$0", "L$1"})
final class AlbumEduIntentSuggestController$awaitSharedDetect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumEduIntentSuggestController this$0;

    public AlbumEduIntentSuggestController$awaitSharedDetect$1(AlbumEduIntentSuggestController r100, Continuation<? super AlbumEduIntentSuggestController$awaitSharedDetect$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AlbumEduIntentSuggestController.a(this.this$0, null, this);
    }
}
