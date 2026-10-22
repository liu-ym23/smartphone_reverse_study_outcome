package com.larus.im.internal.stream;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.stream.PendingHandler", f = "PendingHandler.kt", i = {0, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 207}, m = "isCurCvsMsgStreaming", n = {"cvsId", "cvsId", "curCvsMsg", "isReceiveStreamMsg"}, s = {"L$0", "L$0", "L$1", "I$0"})
final class PendingHandler$isCurCvsMsgStreaming$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PendingHandler this$0;

    public PendingHandler$isCurCvsMsgStreaming$1(PendingHandler r100, Continuation<? super PendingHandler$isCurCvsMsgStreaming$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return PendingHandler.b(this.this$0, null, this);
    }
}
