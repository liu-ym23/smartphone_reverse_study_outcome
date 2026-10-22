package com.larus.avlink.gallery.executor;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaSyncExecutor", f = "MediaSyncExecutor.kt", i = {1, 1, 1, 1, 1, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, 411, 420}, m = "checkAndDeleteBatch", n = {"toDelete", "deletedFiles", "deletedPaths", "metadata", "currentFilePath", "deletedFiles", "deletedPaths", "uniqIdsToDelete"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2"})
final class MediaSyncExecutor$checkAndDeleteBatch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaSyncExecutor this$0;

    public MediaSyncExecutor$checkAndDeleteBatch$1(MediaSyncExecutor r100, Continuation<? super MediaSyncExecutor$checkAndDeleteBatch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MediaSyncExecutor.b(this.this$0, null, this);
    }
}
