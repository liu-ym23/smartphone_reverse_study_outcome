package com.larus.avlink.gallery.thumbnail;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.ThumbnailManager", f = "ThumbnailManager.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME}, m = "getLocalThumbnailList", n = {}, s = {})
final class ThumbnailManager$getLocalThumbnailList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailManager this$0;

    public ThumbnailManager$getLocalThumbnailList$1(ThumbnailManager r100, Continuation<? super ThumbnailManager$getLocalThumbnailList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ThumbnailManager.a(this.this$0, this);
    }
}
