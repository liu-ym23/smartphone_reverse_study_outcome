package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class AgentMessageIDLIpcWrapper implements IAgentMessageIDL {
    boolean log;
    final IAgentMessageIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
    public PicInfo getScreenPicInfo() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        PicInfo r110 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("IAgentMessageIDLIPC", "getScreenPicInfo()", e);     // Catch: Throwable -> L17
        IPCException r111 = new IPCException(e);     // Catch: Throwable -> L17
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r112 - r100) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentMessageIDLIPC", "getScreenPicInfo() = fail", r111, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentMessageIDLIPC", "getScreenPicInfo", r111, r101, r112);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.h.a("IAgentMessageIDLIPC", "getScreenPicInfo()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.a("IAgentMessageIDLIPC", "getScreenPicInfo()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.getScreenPicInfo();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IAgentMessageIDLIPC", "getScreenPicInfo = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentMessageIDLIPC", "getScreenPicInfo() = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IAgentMessageIDLIPC", "getScreenPicInfo", r115, r114);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public AgentMessageIDLIpcWrapper(IAgentMessageIDL r100) throws RemoteException {
        this(r100, true);
    }

    public AgentMessageIDLIpcWrapper(IAgentMessageIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }
}
