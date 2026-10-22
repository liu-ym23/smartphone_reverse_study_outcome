package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384537a = 0;

    static {
        new LinkedHashMap();
    }

    public static IAgentNetworkIDL a(IAgentNetworkIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentNetworkIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentNetworkIDLIpcWrapper) == false) goto L7;
        AgentNetworkIDLIpcWrapper r101 = new AgentNetworkIDLIpcWrapper(((AgentNetworkIDLIpcWrapper) r100).origin, true);
    L8:
        AgentNetworkIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentNetworkIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentNetworkIDLIpcWrapper(r100, true);
        goto L8
    }
}
