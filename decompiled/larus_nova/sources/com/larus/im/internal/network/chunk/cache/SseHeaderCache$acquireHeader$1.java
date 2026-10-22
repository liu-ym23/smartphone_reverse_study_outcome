package com.larus.im.internal.network.chunk.cache;

import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.chunk.cache.SseHeaderCache", f = "SseHeaderCache.kt", i = {0, 0, 0}, l = {243}, m = "acquireHeader", n = {b.f276353c, "token", "cachedKey"}, s = {"L$0", "L$1", "L$2"})
public final class SseHeaderCache$acquireHeader$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SseHeaderCache this$0;

    public SseHeaderCache$acquireHeader$1(SseHeaderCache r100, Continuation<? super SseHeaderCache$acquireHeader$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
