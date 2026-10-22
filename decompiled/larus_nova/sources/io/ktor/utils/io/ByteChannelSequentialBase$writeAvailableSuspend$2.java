package io.ktor.utils.io;

import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PCDN_WATCH_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PCDN_H2P_CACHE}, m = "writeAvailableSuspend", n = {"this", "src", "offset", "length"}, s = {"L$0", "L$1", "I$0", "I$1"})
public final class ByteChannelSequentialBase$writeAvailableSuspend$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$writeAvailableSuspend$2(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$writeAvailableSuspend$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ByteChannelSequentialBase r101 = this.this$0;
        AtomicLongFieldUpdater r102 = ByteChannelSequentialBase.f492003b;
        return r101.c0(null, 0, 0, this);
    }
}
