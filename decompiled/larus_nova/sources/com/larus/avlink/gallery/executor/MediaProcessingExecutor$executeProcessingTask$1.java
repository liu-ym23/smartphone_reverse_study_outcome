package com.larus.avlink.gallery.executor;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaProcessingExecutor", f = "MediaProcessingExecutor.kt", i = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 423, 423, 423, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 305, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 423, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, 402, 423, 414, 423, 423}, m = "executeProcessingTask", n = {"task", "taskType", "uniqId", DyPayConstant.KEY_START_TIME, "task", "taskType", "task", "taskType", "task", "taskType", "task", "taskType", "uniqId", "metadata", DyPayConstant.KEY_START_TIME, "task", "taskType", "uniqId", "metadata", DyPayConstant.KEY_START_TIME, "task", "taskType", "uniqId", "metadata", "result", "duration", "algorithms", "processedFile", "task", "taskType", "task", "taskType", "task", "taskType", "metadata", "duration", "algorithms", "task", "taskType", "uniqId", "metadata", "result", "duration", "algorithms", "task", "taskType", "task", "taskType", "task", "taskType", "task", "taskType"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class MediaProcessingExecutor$executeProcessingTask$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaProcessingExecutor this$0;

    public MediaProcessingExecutor$executeProcessingTask$1(MediaProcessingExecutor r100, Continuation<? super MediaProcessingExecutor$executeProcessingTask$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MediaProcessingExecutor r101 = this.this$0;
        int r102 = MediaProcessingExecutor.f292540k;
        return r101.b(null, this);
    }
}
