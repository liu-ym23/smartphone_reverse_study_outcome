package io.ktor.utils.io;

import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME}, m = "readPacketSuspend", n = {"this", "builder", "remaining"}, s = {"L$0", "L$1", "I$0"})
final class ByteChannelSequentialBase$readPacketSuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$readPacketSuspend$1(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$readPacketSuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ByteChannelSequentialBase r101 = this.this$0;
        AtomicLongFieldUpdater r102 = ByteChannelSequentialBase.f492003b;
        r101.getClass();
        int r103 = this.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r103 - Integer.MIN_VALUE;
        ByteChannelSequentialBase$readPacketSuspend$1 r104 = this;
    L6:
        Object r105 = r104.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 != 0) goto L9;
        ResultKt.throwOnFailure(r105);
        ByteChannelSequentialBase r107 = r101;
        io.ktor.utils.io.core.j r108 = null;
        int r109 = 0;
    L14:
        if (r109 > 0) goto L17;
        r107.R(r109, r108);
        return r108.m();
    L17:
        r107.getClass();
        throw null;
    L9:
        if (r106 != 1) goto L12;
        r109 = r104.I$0;
        r108 = (io.ktor.utils.io.core.j) r104.L$1;
        r107 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r105);
        goto L14
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r104 = new ByteChannelSequentialBase$readPacketSuspend$1(r101, this);
        goto L6
    }
}
