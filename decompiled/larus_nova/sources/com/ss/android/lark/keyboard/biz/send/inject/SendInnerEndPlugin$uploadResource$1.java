package com.ss.android.lark.keyboard.biz.send.inject;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin", f = "SendInnerEndPlugin.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 210}, m = "uploadResource", n = {"chatId", "uploadId", "entity"}, s = {"L$0", "L$1", "L$2"})
final class SendInnerEndPlugin$uploadResource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public SendInnerEndPlugin$uploadResource$1(SendInnerEndPlugin r100, Continuation<? super SendInnerEndPlugin$uploadResource$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SendInnerEndPlugin.j(this.this$0, null, null, null, null, this);
    }
}
