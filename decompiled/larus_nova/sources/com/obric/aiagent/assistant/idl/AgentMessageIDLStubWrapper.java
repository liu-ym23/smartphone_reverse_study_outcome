package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class AgentMessageIDLStubWrapper extends IAgentMessageIDL.Stub {
    boolean log;
    final IAgentMessageIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
    public PicInfo getScreenPicInfo() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentMessageIDLStub", "getScreenPicInfo()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentMessageIDLStub", "getScreenPicInfo() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentMessageIDLStub", "getScreenPicInfo", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentMessageIDLStub", "getScreenPicInfo()");     // Catch: Exception -> L11
    L6:
        PicInfo r112 = this.origin.getScreenPicInfo();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentMessageIDLStub", "getScreenPicInfo = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentMessageIDLStub", "getScreenPicInfo() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentMessageIDLStub", "getScreenPicInfo", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public AgentMessageIDLStubWrapper(IAgentMessageIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public AgentMessageIDLStubWrapper(IAgentMessageIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
