package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class AgentTaskAppIDLStubWrapper extends IAgentTaskAppIDL.Stub {
    boolean log;
    final IAgentTaskAppIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean shouldShowAddTaskManagerIconGuide() throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.h.b("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide()", e);
        IPCException r101 = new IPCException(e);
        long r110 = SystemClock.elapsedRealtimeNanos();
        long r111 = Math.max(0, r110 - r100) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide() = fail", r101, r111);
        IPCAnomalyTrace r102 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide", r101, r111, r110);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.h.c("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide()");     // Catch: Exception -> L11
    L6:
        boolean r112 = this.origin.shouldShowAddTaskManagerIconGuide();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide = " + r112);     // Catch: Exception -> L11
    L9:
        long r114 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r114 - r100) / 1000;     // Catch: Exception -> L11
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide() = " + r112, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide", r115, r114);     // Catch: Exception -> L11
        return r112;
    }

    public AgentTaskAppIDLStubWrapper(IAgentTaskAppIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void addTaskManagerShortcut(PendingIntent r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "addTaskManagerShortcut", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.addTaskManagerShortcut(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentTaskAppIDLStub", "addTaskManagerShortcut = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r210 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentTaskAppIDLStub", "addTaskManagerShortcut", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public List<ShortcutRecommendItem> getShortcutRecommendItems(int r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "getShortcutRecommendItems", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        List<ShortcutRecommendItem> r113 = this.origin.getShortcutRecommendItems(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentTaskAppIDLStub", "getShortcutRecommendItems = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentTaskAppIDLStub", "getShortcutRecommendItems", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean hasShortcutForMessage(String r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "hasShortcutForMessage", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.hasShortcutForMessage(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.d("AgentTaskAppIDLStub", "hasShortcutForMessage = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentTaskAppIDLStub", "hasShortcutForMessage", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    public AgentTaskAppIDLStubWrapper(IAgentTaskAppIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void openEventTaskDetailPage(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "openEventTaskDetailPage", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.openEventTaskDetailPage(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentTaskAppIDLStub", "openEventTaskDetailPage = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentTaskAppIDLStub", "openEventTaskDetailPage", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void runShortcutTaskFromRecommendPanel(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.runShortcutTaskFromRecommendPanel(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel", r113, r112);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void testRunConditionTask(String r210, String r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("AgentTaskAppIDLStub", "testRunConditionTask(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "testRunConditionTask(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "testRunConditionTask", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r105 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.h.c("AgentTaskAppIDLStub", "testRunConditionTask(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.testRunConditionTask(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.h.d("AgentTaskAppIDLStub", "testRunConditionTask = void");     // Catch: Exception -> L11
    L9:
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r113 = Math.max(0, r112 - r100) / 1000;     // Catch: Exception -> L11
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "testRunConditionTask(" + r210 + ", " + r211 + ") = void", r113);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("AgentTaskAppIDLStub", "testRunConditionTask", r113, r112);     // Catch: Exception -> L11
    }
}
