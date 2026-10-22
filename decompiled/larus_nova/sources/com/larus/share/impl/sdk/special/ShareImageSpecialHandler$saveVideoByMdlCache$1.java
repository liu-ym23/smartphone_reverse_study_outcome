package com.larus.share.impl.sdk.special;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.share.impl.sdk.special.ShareImageSpecialHandler", f = "ShareImageSpecialHandler.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS}, m = "saveVideoByMdlCache", n = {"cacheKey", "targetPath"}, s = {"L$0", "L$1"})
final class ShareImageSpecialHandler$saveVideoByMdlCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareImageSpecialHandler this$0;

    public ShareImageSpecialHandler$saveVideoByMdlCache$1(ShareImageSpecialHandler r100, Continuation<? super ShareImageSpecialHandler$saveVideoByMdlCache$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ShareImageSpecialHandler.e(this.this$0, null, null, null, this);
    }
}
