package com.bytedance.kmp.network.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.websocket.NativeRawWsService", f = "NativeRawWsService.kt", i = {0, 0, 0, 1, 2}, l = {138, 113, 114}, m = "sendMsg", n = {"msg", "$this$withLock_u24default$iv", "id", "id", "id"}, s = {"L$0", "L$1", "I$0", "I$0", "I$0"})
final class NativeRawWsService$sendMsg$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public NativeRawWsService$sendMsg$1(b r100, Continuation<? super NativeRawWsService$sendMsg$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
