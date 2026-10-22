package com.obric.aiagent.assistant.idl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class t implements com.obric.aiagent.ipc.utils.g.b<IAgentVoiceInteractionIDL> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.obric.aiagent.ipc.utils.g.b<IAgentVoiceInteractionIDL> f384578a;

    public t(com.obric.assistant.utils.a r100) {
        this.f384578a = r100;
    }

    @Override // com.obric.aiagent.ipc.utils.g.b
    public final void a(IAgentVoiceInteractionIDL r100) {
        IAgentVoiceInteractionIDL r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "inst");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        com.obric.aiagent.ipc.utils.g.e(IAgentVoiceInteractionIDL.class, this);
        this.f384578a.a(r101);
    }
}
