package com.obric.aiagent.messenger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.ObricPccServiceImpl", f = "ObricPccServiceImpl.kt", i = {0}, l = {82}, m = "initInternal", n = {"errMsg"}, s = {"L$0"})
public final class ObricPccServiceImpl$initInternal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricPccServiceImpl this$0;

    public ObricPccServiceImpl$initInternal$1(ObricPccServiceImpl r100, Continuation<? super ObricPccServiceImpl$initInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ObricPccServiceImpl r101 = this.this$0;
        int r102 = ObricPccServiceImpl.f384772q;
        return r101.f(this);
    }
}
