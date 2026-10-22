package com.bytedance.kmp.network.websocket;

import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.websocket.NativeRawWsService", f = "NativeRawWsService.kt", i = {0, 0, 0, 0, 0, 1, 2, 2}, l = {138, 71, 170}, m = MiPushClient.COMMAND_REGISTER, n = {"info", "listener", "clientId", "client", "$this$withLock_u24default$iv", "clientId", "clientId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$0", "L$1"})
final class NativeRawWsService$register$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public NativeRawWsService$register$1(b r100, Continuation<? super NativeRawWsService$register$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
