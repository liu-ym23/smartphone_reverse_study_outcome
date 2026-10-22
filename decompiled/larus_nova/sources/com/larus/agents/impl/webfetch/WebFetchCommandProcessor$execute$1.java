package com.larus.agents.impl.webfetch;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.webfetch.WebFetchCommandProcessor", f = "WebFetchCommandProcessor.kt", i = {0, 0, 1, 1, 2, 2}, l = {87, 96, 109}, m = "execute", n = {"entry", "acquired", "entry", "acquired", "entry", "acquired"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class WebFetchCommandProcessor$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebFetchCommandProcessor this$0;

    public WebFetchCommandProcessor$execute$1(WebFetchCommandProcessor r100, Continuation<? super WebFetchCommandProcessor$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return WebFetchCommandProcessor.a(this.this$0, null, this);
    }
}
