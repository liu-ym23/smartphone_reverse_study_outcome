package com.larus.photopicker.v2.impl.data;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.MediaRepositoryImpl", f = "MediaRepositoryImpl.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE}, m = "getCurPage", n = {"filter", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class MediaRepositoryImpl$getCurPage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaRepositoryImpl this$0;

    public MediaRepositoryImpl$getCurPage$1(MediaRepositoryImpl r100, Continuation<? super MediaRepositoryImpl$getCurPage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
