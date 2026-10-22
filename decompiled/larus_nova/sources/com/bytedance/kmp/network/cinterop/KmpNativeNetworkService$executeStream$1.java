package com.bytedance.kmp.network.cinterop;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.KmpNativeNetworkService", f = "KmpNativeNetworkService.kt", i = {0, 0, 0, 0, 0, 0}, l = {356, 181}, m = "executeStream", n = {"request", "callback", "nativeRequest", NotificationCompat.CATEGORY_CALL, "$this$withLock_u24default$iv", "requestId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
final class KmpNativeNetworkService$executeStream$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNativeNetworkService this$0;

    public KmpNativeNetworkService$executeStream$1(KmpNativeNetworkService r100, Continuation<? super KmpNativeNetworkService$executeStream$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.L(null, null, this);
    }
}
