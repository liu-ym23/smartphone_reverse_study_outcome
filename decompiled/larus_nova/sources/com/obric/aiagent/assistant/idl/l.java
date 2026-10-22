package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384546a = 0;

    static {
        new LinkedHashMap();
    }

    public static IAgentSettingsIDL a(IAgentSettingsIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentSettingsIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentSettingsIDLIpcWrapper) == false) goto L7;
        AgentSettingsIDLIpcWrapper r101 = new AgentSettingsIDLIpcWrapper(((AgentSettingsIDLIpcWrapper) r100).origin, true);
    L8:
        AgentSettingsIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentSettingsIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentSettingsIDLIpcWrapper(r100, true);
        goto L8
    }
}
