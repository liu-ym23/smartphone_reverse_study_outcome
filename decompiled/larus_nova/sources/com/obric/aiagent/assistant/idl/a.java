package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    static {
        new LinkedHashMap();
    }

    public static final IAgentAppIntentIDL a(KClass<IAgentAppIntentIDL> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        return (IAgentAppIntentIDL) com.obric.aiagent.ipc.utils.g.b(IAgentAppIntentIDL.class);
    }

    public static IAgentAppIntentIDL b(IAgentAppIntentIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentAppIntentIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentAppIntentIDLIpcWrapper) == false) goto L7;
        AgentAppIntentIDLIpcWrapper r101 = new AgentAppIntentIDLIpcWrapper(((AgentAppIntentIDLIpcWrapper) r100).origin, true);
    L8:
        AgentAppIntentIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentAppIntentIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentAppIntentIDLIpcWrapper(r100, true);
        goto L8
    }
}
