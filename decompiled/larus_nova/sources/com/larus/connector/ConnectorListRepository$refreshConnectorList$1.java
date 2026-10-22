package com.larus.connector;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.connector.ConnectorListRepository", f = "ConnectorListRepository.kt", i = {}, l = {78}, m = "refreshConnectorList", n = {}, s = {})
public final class ConnectorListRepository$refreshConnectorList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectorListRepository this$0;

    public ConnectorListRepository$refreshConnectorList$1(ConnectorListRepository r100, Continuation<? super ConnectorListRepository$refreshConnectorList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
