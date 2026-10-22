package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager", f = "AlignAndScrollManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE}, m = "makeHighLightOnHeight", n = {"position", "height", "position", "height", "position", "height", "position", "height", "success"}, s = {"I$0", "I$1", "I$0", "I$1", "I$0", "I$1", "I$0", "I$1", "Z$0"})
public final class AlignAndScrollManager$makeHighLightOnHeight$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$makeHighLightOnHeight$1(AlignAndScrollManager r100, Continuation<? super AlignAndScrollManager$makeHighLightOnHeight$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(0, 0, this);
    }
}
