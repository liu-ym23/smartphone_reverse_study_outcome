package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.ResourceAccessPipeline", f = "ResourceAccessPipeline.kt", i = {}, l = {71, 71}, m = "handleResult", n = {}, s = {})
public final class ResourceAccessPipeline$handleResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceAccessPipeline this$0;

    public ResourceAccessPipeline$handleResult$1(ResourceAccessPipeline r100, Continuation<? super ResourceAccessPipeline$handleResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ResourceAccessPipeline r101 = this.this$0;
        ResourceAccessPipeline r102 = ResourceAccessPipeline.f313574a;
        return r101.b(null, null, null, this);
    }
}
