package com.obric.aiagent.assistant.idl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    static {
        new LinkedHashMap();
    }

    public static final IAgentIDL a(IAgentIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AgentIDLIpcWrapper) == false) goto L7;
        return new AgentIDLIpcWrapper(((AgentIDLIpcWrapper) r100).origin, false);
    L7:
        return new AgentIDLIpcWrapper(r100, false);
    }
}
