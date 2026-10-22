package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384528a = 0;

    static {
        new LinkedHashMap();
    }

    public static IAgentMessageIDL a(IAgentMessageIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentMessageIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentMessageIDLIpcWrapper) == false) goto L7;
        AgentMessageIDLIpcWrapper r101 = new AgentMessageIDLIpcWrapper(((AgentMessageIDLIpcWrapper) r100).origin, true);
    L8:
        AgentMessageIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentMessageIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentMessageIDLIpcWrapper(r100, true);
        goto L8
    }
}
