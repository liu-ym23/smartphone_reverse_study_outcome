package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    static {
        new LinkedHashMap();
    }

    public static final IAgentSkillManagerIDL a(KClass<IAgentSkillManagerIDL> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        return (IAgentSkillManagerIDL) com.obric.aiagent.ipc.utils.g.b(IAgentSkillManagerIDL.class);
    }

    public static IAgentSkillManagerIDL c(IAgentSkillManagerIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentSkillManagerIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentSkillManagerIDLIpcWrapper) == false) goto L7;
        AgentSkillManagerIDLIpcWrapper r101 = new AgentSkillManagerIDLIpcWrapper(((AgentSkillManagerIDLIpcWrapper) r100).origin, true);
    L8:
        AgentSkillManagerIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentSkillManagerIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentSkillManagerIDLIpcWrapper(r100, true);
        goto L8
    }

    public static void b(KClass r100, boolean r101, com.obric.aiagent.ipc.utils.g.b r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "action");
        if (r101 == false) goto L5;
        com.obric.aiagent.ipc.utils.g r103 = com.obric.aiagent.ipc.utils.g.f384740a;
        m r104 = new m(r102);
        r103.getClass();
        com.obric.aiagent.ipc.utils.g.a(IAgentSkillManagerIDL.class, r104, true);
        return;
    L5:
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.a(IAgentSkillManagerIDL.class, r102, true);
    }
}
