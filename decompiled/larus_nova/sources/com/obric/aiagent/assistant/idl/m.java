package com.obric.aiagent.assistant.idl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class m implements com.obric.aiagent.ipc.utils.g.b<IAgentSkillManagerIDL> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.obric.aiagent.ipc.utils.g.b<IAgentSkillManagerIDL> f384550a;

    public m(com.obric.aiagent.ipc.utils.g.b<IAgentSkillManagerIDL> r100) {
        this.f384550a = r100;
    }

    @Override // com.obric.aiagent.ipc.utils.g.b
    public final void a(IAgentSkillManagerIDL r100) {
        IAgentSkillManagerIDL r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "inst");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.e(IAgentSkillManagerIDL.class, this);
        this.f384550a.a(r101);
    }
}
