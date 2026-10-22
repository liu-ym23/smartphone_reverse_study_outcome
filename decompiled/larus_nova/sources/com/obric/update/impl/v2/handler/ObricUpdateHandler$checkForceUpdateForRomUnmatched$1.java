package com.obric.update.impl.v2.handler;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.update.impl.v2.handler.ObricUpdateHandler", f = "ObricUpdateHandler.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW}, m = "checkForceUpdateForRomUnmatched", n = {}, s = {})
public final class ObricUpdateHandler$checkForceUpdateForRomUnmatched$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricUpdateHandler this$0;

    public ObricUpdateHandler$checkForceUpdateForRomUnmatched$1(ObricUpdateHandler r100, Continuation<? super ObricUpdateHandler$checkForceUpdateForRomUnmatched$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(this);
    }
}
