package com.larus.connector;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.connector.ConnectorListRepository", f = "ConnectorListRepository.kt", i = {0}, l = {225}, m = "requestConnectorList", n = {"scene"}, s = {"L$0"})
final class ConnectorListRepository$requestConnectorList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectorListRepository this$0;

    public ConnectorListRepository$requestConnectorList$1(ConnectorListRepository r100, Continuation<? super ConnectorListRepository$requestConnectorList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ConnectorListRepository.a(this.this$0, null, this);
    }
}
