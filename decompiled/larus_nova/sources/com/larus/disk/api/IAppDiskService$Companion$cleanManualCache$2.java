package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.api.IAppDiskService$Companion", f = "IAppDiskService.kt", i = {0}, l = {43}, m = "cleanManualCache", n = {"operationId"}, s = {"L$0"})
public final class IAppDiskService$Companion$cleanManualCache$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IAppDiskService.Companion this$0;

    public IAppDiskService$Companion$cleanManualCache$2(IAppDiskService.Companion r100, Continuation<? super IAppDiskService$Companion$cleanManualCache$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
