package com.obric.assistant.remote_card_container;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$init$1", f = "RemoteCardImpl.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL}, m = "isMessageValid", n = {"messageId"}, s = {"L$0"})
public final class RemoteCardImpl$init$1$isMessageValid$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteCardImpl.AnonymousClass1 this$0;

    public RemoteCardImpl$init$1$isMessageValid$1(RemoteCardImpl.AnonymousClass1 r100, Continuation<? super RemoteCardImpl$init$1$isMessageValid$1> r101) {
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
