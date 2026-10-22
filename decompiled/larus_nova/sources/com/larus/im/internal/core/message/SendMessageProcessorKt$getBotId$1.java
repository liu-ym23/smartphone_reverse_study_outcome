package com.larus.im.internal.core.message;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.SendMessageProcessorKt", f = "SendMessageProcessor.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP}, m = "getBotId", n = {}, s = {})
final class SendMessageProcessorKt$getBotId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public SendMessageProcessorKt$getBotId$1(Continuation<? super SendMessageProcessorKt$getBotId$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return w.a(null, null, null, this);
    }
}
