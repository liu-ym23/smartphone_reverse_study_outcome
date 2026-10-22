package com.larus.bmhome.chat.list.cell.send_file;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.send_file.SendFileCell", f = "SendFileCell.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME}, m = "requireFileUrlByTosKey", n = {"fileUri"}, s = {"L$0"})
public final class SendFileCell$requireFileUrlByTosKey$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendFileCell this$0;

    public SendFileCell$requireFileUrlByTosKey$1(SendFileCell r100, Continuation<? super SendFileCell$requireFileUrlByTosKey$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        SendFileCell r101 = this.this$0;
        int r102 = SendFileCell.f305852i;
        return r101.s(null, this);
    }
}
