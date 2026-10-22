package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384541a = 0;

    static {
        new LinkedHashMap();
    }

    public static IAgentPrivacyIDL a(IAgentPrivacyIDL r100) {
        if (r100 != null) goto L4;
        com.obric.aiagent.ipc.utils.e.b("IAgentPrivacyIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentPrivacyIDLIpcWrapper) == false) goto L7;
        AgentPrivacyIDLIpcWrapper r101 = new AgentPrivacyIDLIpcWrapper(((AgentPrivacyIDLIpcWrapper) r100).origin, true);
    L8:
        AgentPrivacyIDLIpcWrapper r102 = r101;
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.d(IAgentPrivacyIDL.class, r102);
        return r102;
    L7:
        r101 = new AgentPrivacyIDLIpcWrapper(r100, true);
        goto L8
    }
}
