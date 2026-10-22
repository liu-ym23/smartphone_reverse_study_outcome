package com.obric.aiagent.messenger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.ObricPccServiceImpl", f = "ObricPccServiceImpl.kt", i = {}, l = {212}, m = "openSecuritySessionInternal", n = {}, s = {})
final class ObricPccServiceImpl$openSecuritySessionInternal$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricPccServiceImpl this$0;

    public ObricPccServiceImpl$openSecuritySessionInternal$1(ObricPccServiceImpl r100, Continuation<? super ObricPccServiceImpl$openSecuritySessionInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ObricPccServiceImpl.e(this.this$0, this);
    }
}
