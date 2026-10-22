package com.larus.avlink.gallery.thumbnail;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.ThumbnailManager", f = "ThumbnailManager.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_LIVE_OPEN_TIME}, m = "updateMetaData", n = {"imageUuid"}, s = {"J$0"})
final class ThumbnailManager$updateMetaData$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailManager this$0;

    public ThumbnailManager$updateMetaData$1(ThumbnailManager r100, Continuation<? super ThumbnailManager$updateMetaData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ThumbnailManager r101 = this.this$0;
        ThumbnailManager r102 = ThumbnailManager.f292763a;
        return r101.u(null, null, this);
    }
}
