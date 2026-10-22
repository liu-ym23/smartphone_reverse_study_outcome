package com.larus.canvas.core.impl.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasSseChunkParser", f = "CanvasSseChunkParser.kt", i = {0}, l = {53}, m = "withTimeoutOrThrow", n = {"buffer"}, s = {"L$0"})
public final class CanvasSseChunkParser$withTimeoutOrThrow$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CanvasSseChunkParser this$0;

    public CanvasSseChunkParser$withTimeoutOrThrow$1(CanvasSseChunkParser r100, Continuation<? super CanvasSseChunkParser$withTimeoutOrThrow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CanvasSseChunkParser r101 = this.this$0;
        int r102 = CanvasSseChunkParser.f322955b;
        return r101.b(0, null, null, this);
    }
}
