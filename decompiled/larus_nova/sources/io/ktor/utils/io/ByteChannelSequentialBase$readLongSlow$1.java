package io.ktor.utils.io;

import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME}, m = "readLongSlow", n = {"this"}, s = {"L$0"})
final class ByteChannelSequentialBase$readLongSlow$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$readLongSlow$1(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$readLongSlow$1> r101) {
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
        ByteChannelSequentialBase$readLongSlow$1 r104 = this;
    L6:
        Object r105 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L12;
        if (r107 != 1) goto L10;
        r101 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r105);
    L15:
        r101.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r105);
        r104.L$0 = r101;
        r104.label = 1;
        if (r101.Q(8, r104) != r106) goto L15;
        return r106;
    L5:
        r104 = new ByteChannelSequentialBase$readLongSlow$1(r101, this);
        goto L6
    }
}
