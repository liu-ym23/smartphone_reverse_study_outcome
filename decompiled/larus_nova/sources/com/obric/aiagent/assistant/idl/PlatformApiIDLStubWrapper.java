package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class PlatformApiIDLStubWrapper extends IPlatformApiIDL.Stub {
    boolean log;
    final IPlatformApiIDL.Stub origin;

    public PlatformApiIDLStubWrapper(IPlatformApiIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public PlatformApiIDLStubWrapper(IPlatformApiIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public boolean moveTaskToDisplay(int r210, int r211, boolean r212) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("PlatformApiIDLStub", "moveTaskToDisplay(" + r210 + ", " + r211 + ", " + r212 + ")", e);
        IPCException r101 = new IPCException(e);
        long r213 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r213 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("PlatformApiIDLStub", "moveTaskToDisplay(" + r210 + ", " + r211 + ", " + r212 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("PlatformApiIDLStub", "moveTaskToDisplay", r101, r102, r213);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r111 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("PlatformApiIDLStub", "moveTaskToDisplay(" + r210 + ", " + r211 + ", " + r212 + ")");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.moveTaskToDisplay(r210, r211, r212);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("PlatformApiIDLStub", "moveTaskToDisplay = " + r112);     // Catch: Exception -> L11
    L9:
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r114 = Math.max(0, r214 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("PlatformApiIDLStub", "moveTaskToDisplay(" + r210 + ", " + r211 + ", " + r212 + ") = " + r112, r114);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("PlatformApiIDLStub", "moveTaskToDisplay", r114, r214);     // Catch: Exception -> L11
        return r112;
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public List<String> getTasksPackages(int r210, boolean r211, boolean r212, int r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r100 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("PlatformApiIDLStub", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);
        IPCException r101 = new IPCException(e);
        long r214 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r214 - r110) / 1000;
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("PlatformApiIDLStub", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r101, r111);
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("PlatformApiIDLStub", "getTasksPackages", r101, r111, r214);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("PlatformApiIDLStub", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L11
    L6:
        List<String> r113 = this.origin.getTasksPackages(r210, r211, r212, r213);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("PlatformApiIDLStub", "getTasksPackages = " + r113);     // Catch: Exception -> L11
    L9:
        long r215 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r104 = Math.max(0, r215 - r110) / 1000;     // Catch: Exception -> L11
        int r115 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("PlatformApiIDLStub", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = " + r113, r104);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("PlatformApiIDLStub", "getTasksPackages", r104, r215);     // Catch: Exception -> L11
        return r113;
    }
}
