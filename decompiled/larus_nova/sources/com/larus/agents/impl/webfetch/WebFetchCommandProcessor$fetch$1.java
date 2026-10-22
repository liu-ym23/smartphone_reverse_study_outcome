package com.larus.agents.impl.webfetch;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.webfetch.WebFetchCommandProcessor", f = "WebFetchCommandProcessor.kt", i = {}, l = {126}, m = "fetch", n = {}, s = {})
public final class WebFetchCommandProcessor$fetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebFetchCommandProcessor this$0;

    public WebFetchCommandProcessor$fetch$1(WebFetchCommandProcessor r100, Continuation<? super WebFetchCommandProcessor$fetch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        WebFetchCommandProcessor r101 = this.this$0;
        int r102 = WebFetchCommandProcessor.f286802i;
        return r101.b(null, this);
    }
}
