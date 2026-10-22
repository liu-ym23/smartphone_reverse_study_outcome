package com.obric.assistant.activation.presentation.runtime.session.client;

import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        final IObricInteractorBridgeService r101 = (IObricInteractorBridgeService) r100;
        Intrinsics.checkNotNullParameter(r101, "service");
        InteractionSessionProxyClient.g("flushPendingEvents", new f(r101));
        return Unit.INSTANCE;
    }
}
