package com.larus.avlink.gallery.executor;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaSyncExecutor", f = "MediaSyncExecutor.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2}, l = {438, 479, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_MC_REUSE}, m = "checkAllDeletedMedia", n = {"deletedFiles", "deletedFiles", "toDelete", "deletedPaths", "metadata", "currentFilePath", "deletedFiles", "deletedPaths", "uniqIdsToDelete"}, s = {"L$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2"})
final class MediaSyncExecutor$checkAllDeletedMedia$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaSyncExecutor this$0;

    public MediaSyncExecutor$checkAllDeletedMedia$1(MediaSyncExecutor r100, Continuation<? super MediaSyncExecutor$checkAllDeletedMedia$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MediaSyncExecutor.a(this.this$0, null, this);
    }
}
