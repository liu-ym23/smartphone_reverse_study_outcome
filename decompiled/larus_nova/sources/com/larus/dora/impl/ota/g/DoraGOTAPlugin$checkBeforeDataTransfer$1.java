package com.larus.dora.impl.ota.g;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAPlugin", f = "DoraGOTAPlugin.kt", i = {}, l = {191}, m = "checkBeforeDataTransfer", n = {}, s = {})
public final class DoraGOTAPlugin$checkBeforeDataTransfer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGOTAPlugin this$0;

    public DoraGOTAPlugin$checkBeforeDataTransfer$1(DoraGOTAPlugin r100, Continuation<? super DoraGOTAPlugin$checkBeforeDataTransfer$1> r101) {
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
