package com.obric.aiagent.assistant.idl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class r implements com.obric.aiagent.ipc.utils.g.b<IAgentTaskAppIDL> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.obric.aiagent.ipc.utils.g.b<IAgentTaskAppIDL> f384570a;

    public r(com.obric.assistant.special_input.instruction.b r100) {
        this.f384570a = r100;
    }

    @Override // com.obric.aiagent.ipc.utils.g.b
    public final void a(IAgentTaskAppIDL r100) {
        IAgentTaskAppIDL r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "inst");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.e(IAgentTaskAppIDL.class, this);
        this.f384570a.a(r101);
    }
}
