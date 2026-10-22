package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {776, 777}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
public final class ByteChannelSequentialBase$writeAvailableSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$writeAvailableSuspend$1(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$writeAvailableSuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ByteChannelSequentialBase r101 = this.this$0;
        AtomicLongFieldUpdater r102 = ByteChannelSequentialBase.f492003b;
        return r101.b0(null, this);
    }
}
