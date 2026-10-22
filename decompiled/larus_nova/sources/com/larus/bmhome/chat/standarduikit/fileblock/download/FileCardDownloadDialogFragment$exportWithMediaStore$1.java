package com.larus.bmhome.chat.standarduikit.fileblock.download;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment", f = "FileCardDownloadDialogFragment.kt", i = {0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME}, m = "exportWithMediaStore", n = {"fileName", "resolver", "values", "targetUri"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class FileCardDownloadDialogFragment$exportWithMediaStore$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCardDownloadDialogFragment this$0;

    public FileCardDownloadDialogFragment$exportWithMediaStore$1(FileCardDownloadDialogFragment r100, Continuation<? super FileCardDownloadDialogFragment$exportWithMediaStore$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FileCardDownloadDialogFragment.T90(this.this$0, null, null, this);
    }
}
