package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {41, 42}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
public final class ByteChannelSequentialJVM$writeAvailableSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialJVM this$0;

    public ByteChannelSequentialJVM$writeAvailableSuspend$1(ByteChannelSequentialJVM r100, Continuation<? super ByteChannelSequentialJVM$writeAvailableSuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ByteChannelSequentialJVM r101 = this.this$0;
        int r102 = ByteChannelSequentialJVM.f492009g;
        return r101.m0(null, this);
    }
}
