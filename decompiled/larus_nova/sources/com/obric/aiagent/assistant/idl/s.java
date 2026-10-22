package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class s {
    static {
        new LinkedHashMap();
    }

    public static final IAgentTaskAppIDL a(KClass<IAgentTaskAppIDL> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        return (IAgentTaskAppIDL) com.obric.aiagent.ipc.utils.g.b(IAgentTaskAppIDL.class);
    }

    public static IAgentTaskAppIDL b(IAgentTaskAppIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentTaskAppIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentTaskAppIDLIpcWrapper) == false) goto L7;
        AgentTaskAppIDLIpcWrapper r101 = new AgentTaskAppIDLIpcWrapper(((AgentTaskAppIDLIpcWrapper) r100).origin, true);
    L8:
        AgentTaskAppIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentTaskAppIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentTaskAppIDLIpcWrapper(r100, true);
        goto L8
    }
}
