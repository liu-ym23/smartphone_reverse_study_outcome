package io.ktor.utils.io;

import androidx.camera.video.AudioStats;
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
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {180}, m = "writeDouble$suspendImpl", n = {"$this", "d"}, s = {"L$0", "D$0"})
final class ByteChannelSequentialBase$writeDouble$1 extends ContinuationImpl {
    double D$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$writeDouble$1(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$writeDouble$1> r101) {
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
        ByteChannelSequentialBase$writeDouble$1 r104 = this;
    L6:
        Object r105 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L12;
        if (r107 != 1) goto L10;
        r102 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r105);
    L15:
        r102.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r105);
        r104.L$0 = r102;
        r104.D$0 = AudioStats.AUDIO_AMPLITUDE_NONE;
        r104.label = 1;
        if (r102.P(8, r104) != r106) goto L15;
        return r106;
    L5:
        r104 = new ByteChannelSequentialBase$writeDouble$1(r102, this);
        goto L6
    }
}
