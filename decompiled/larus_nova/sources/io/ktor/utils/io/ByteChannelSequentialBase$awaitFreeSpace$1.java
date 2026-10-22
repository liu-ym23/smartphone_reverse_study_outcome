package io.ktor.utils.io;

import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_PLAY_STAT_INFO}, m = "awaitFreeSpace$suspendImpl", n = {"$this"}, s = {"L$0"})
final class ByteChannelSequentialBase$awaitFreeSpace$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$awaitFreeSpace$1(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$awaitFreeSpace$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        ByteChannelSequentialBase r102 = this.this$0;
        AtomicLongFieldUpdater r103 = ByteChannelSequentialBase.f492003b;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ByteChannelSequentialBase$awaitFreeSpace$1 r104 = this;
    L6:
        Object r105 = r104.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 != 0) goto L9;
        ResultKt.throwOnFailure(r105);
        r102.getClass();
        throw null;
    L9:
        if (r106 != 1) goto L19;
        ByteChannelSequentialBase r107 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r105);
        if (r107.U() == false) goto L17;
        Throwable r108 = r107.d();
        if (r108 == null) goto L15;
        throw r108;
    L15:
        throw new ClosedWriteChannelException("Channel " + r107 + " is already closed");
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r104 = new ByteChannelSequentialBase$awaitFreeSpace$1(r102, this);
        goto L6
    }
}
