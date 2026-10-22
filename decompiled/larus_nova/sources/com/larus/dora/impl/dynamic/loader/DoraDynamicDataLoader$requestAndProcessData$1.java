package com.larus.dora.impl.dynamic.loader;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DoraDynamicDataLoader", f = "DoraDynamicDataLoader.kt", i = {0, 0}, l = {245}, m = "requestAndProcessData", n = {"key", "callback"}, s = {"L$0", "L$1"})
final class DoraDynamicDataLoader$requestAndProcessData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public DoraDynamicDataLoader$requestAndProcessData$1(a r100, Continuation<? super DoraDynamicDataLoader$requestAndProcessData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, null, null, null, null, null, this);
    }
}
