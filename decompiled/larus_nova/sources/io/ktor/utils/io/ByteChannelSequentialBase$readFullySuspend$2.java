package io.ktor.utils.io;

import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION}, m = "readFullySuspend", n = {"this", "dst", "offset", "length", "written"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
public final class ByteChannelSequentialBase$readFullySuspend$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$readFullySuspend$2(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$readFullySuspend$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ByteChannelSequentialBase r101 = this.this$0;
        AtomicLongFieldUpdater r102 = ByteChannelSequentialBase.f492003b;
        return r101.Y(null, 0, 0, this);
    }
}
