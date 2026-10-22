package com.larus.uaigc.lynx.pocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.lynx.pocket.PocketDataCache", f = "PocketDataCache.kt", i = {0}, l = {53}, m = "getCacheOrFetchPocketData", n = {"oldCache"}, s = {"L$0"})
public final class PocketDataCache$getCacheOrFetchPocketData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PocketDataCache this$0;

    public PocketDataCache$getCacheOrFetchPocketData$1(PocketDataCache r100, Continuation<? super PocketDataCache$getCacheOrFetchPocketData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
