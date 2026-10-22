package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    static {
        new LinkedHashMap();
    }

    public static final IAgentDMStateManagerIDL a(KClass<IAgentDMStateManagerIDL> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        return (IAgentDMStateManagerIDL) com.obric.aiagent.ipc.utils.g.b(IAgentDMStateManagerIDL.class);
    }

    public static IAgentDMStateManagerIDL c(IAgentDMStateManagerIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentDMStateManagerIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentDMStateManagerIDLIpcWrapper) == false) goto L7;
        AgentDMStateManagerIDLIpcWrapper r101 = new AgentDMStateManagerIDLIpcWrapper(((AgentDMStateManagerIDLIpcWrapper) r100).origin, true);
    L8:
        AgentDMStateManagerIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentDMStateManagerIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentDMStateManagerIDLIpcWrapper(r100, true);
        goto L8
    }

    public static void b(KClass r100, com.obric.aiagent.ipc.utils.g.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.a(IAgentDMStateManagerIDL.class, r101, true);
    }
}
