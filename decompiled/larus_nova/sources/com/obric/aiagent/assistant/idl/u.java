package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class u {
    static {
        new LinkedHashMap();
    }

    public static final IAgentVoiceInteractionIDL a(KClass<IAgentVoiceInteractionIDL> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        return (IAgentVoiceInteractionIDL) com.obric.aiagent.ipc.utils.g.b(IAgentVoiceInteractionIDL.class);
    }

    public static IAgentVoiceInteractionIDL b(IAgentVoiceInteractionIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentVoiceInteractionIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentVoiceInteractionIDLIpcWrapper) == false) goto L7;
        AgentVoiceInteractionIDLIpcWrapper r101 = new AgentVoiceInteractionIDLIpcWrapper(((AgentVoiceInteractionIDLIpcWrapper) r100).origin, true);
    L8:
        AgentVoiceInteractionIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentVoiceInteractionIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentVoiceInteractionIDLIpcWrapper(r100, true);
        goto L8
    }
}
