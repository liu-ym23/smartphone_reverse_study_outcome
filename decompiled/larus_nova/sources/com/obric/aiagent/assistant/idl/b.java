package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    static {
        new LinkedHashMap();
    }

    public static IAgentAssistantStateIDL a(IAgentAssistantStateIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentAssistantStateIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentAssistantStateIDLIpcWrapper) == false) goto L7;
        AgentAssistantStateIDLIpcWrapper r101 = new AgentAssistantStateIDLIpcWrapper(((AgentAssistantStateIDLIpcWrapper) r100).origin, true);
    L8:
        AgentAssistantStateIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentAssistantStateIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentAssistantStateIDLIpcWrapper(r100, true);
        goto L8
    }
}
