package com.obric.aiagent.assistant.idl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements com.obric.aiagent.ipc.utils.g.b<IAgentNetworkIDL> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.obric.aiagent.ipc.utils.g.b<IAgentNetworkIDL> f384533a;

    public i(com.obric.assistant.network.restrict.b r100) {
        this.f384533a = r100;
    }

    @Override // com.obric.aiagent.ipc.utils.g.b
    public final void a(IAgentNetworkIDL r100) {
        IAgentNetworkIDL r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "inst");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.e(IAgentNetworkIDL.class, this);
        this.f384533a.a(r101);
    }
}
