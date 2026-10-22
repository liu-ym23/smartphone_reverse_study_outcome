package io.ktor.websocket;

import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL}, m = "sendCloseSequence", n = {"this", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "reasonToSend"}, s = {"L$0", "L$1", "L$2"})
public final class DefaultWebSocketSessionImpl$sendCloseSequence$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    public DefaultWebSocketSessionImpl$sendCloseSequence$1(DefaultWebSocketSessionImpl r100, Continuation<? super DefaultWebSocketSessionImpl$sendCloseSequence$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DefaultWebSocketSessionImpl r101 = this.this$0;
        AtomicReferenceFieldUpdater r102 = DefaultWebSocketSessionImpl.f492142k;
        return r101.d(null, null, this);
    }
}
