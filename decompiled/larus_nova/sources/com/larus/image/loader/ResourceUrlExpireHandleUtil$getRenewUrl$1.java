package com.larus.image.loader;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.image.loader.ResourceUrlExpireHandleUtil", f = "ResourceUrlExpireHandleUtil.kt", i = {0, 1}, l = {22, 35}, m = "getRenewUrl", n = {"originUrl", "originUrl"}, s = {"L$0", "L$0"})
public final class ResourceUrlExpireHandleUtil$getRenewUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceUrlExpireHandleUtil this$0;

    public ResourceUrlExpireHandleUtil$getRenewUrl$1(ResourceUrlExpireHandleUtil r100, Continuation<? super ResourceUrlExpireHandleUtil$getRenewUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
