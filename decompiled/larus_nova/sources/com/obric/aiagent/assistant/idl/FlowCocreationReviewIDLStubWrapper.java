package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes4.dex */
class FlowCocreationReviewIDLStubWrapper extends IFlowCocreationReviewIDL.Stub {
    boolean log;
    final IFlowCocreationReviewIDL.Stub origin;

    public FlowCocreationReviewIDLStubWrapper(IFlowCocreationReviewIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public FlowCocreationReviewIDLStubWrapper(IFlowCocreationReviewIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniUserStop(String r210, long r211, String r212, long r213, String r310, String r311) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L37:
        e = e;
        String r100 = ", ";
        String r214 = "FlowCocreationReviewIDLStub";
        String r215 = ")";
        String r111 = r212;
        String r112 = r310;
        String r113 = "logOmniUserStop(";
        String r114 = r311;
    L39:
        int r101 = com.obric.aiagent.ipc.utils.h.f384747a;
        String r102 = r214;
        com.obric.aiagent.ipc.utils.h.b(r102, r113 + r210 + r100 + r211 + r100 + r111 + r100 + r213 + r100 + r112 + r100 + r114 + r215, e);
        IPCException r103 = new IPCException(e);
        long r104 = SystemClock.elapsedRealtimeNanos();
        long r105 = Math.max(0, r104 - r110) / 1000;
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r102, r113 + r210 + r100 + r211 + r100 + r111 + r100 + r213 + r100 + r112 + r100 + r114 + ") = fail", r103, r105);
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowCocreationReviewIDLStub", "logOmniUserStop", r103, r105, r104);
        throw r103;
    L4:
        if (this.log == false) goto L6;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L37
        com.obric.aiagent.ipc.utils.h.c("FlowCocreationReviewIDLStub", "logOmniUserStop(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ", " + r310 + ", " + r311 + ")");     // Catch: Exception -> L37
    L6:
        r114 = r311;
        r215 = ")";
        this.origin.logOmniUserStop(r210, r211, r212, r213, r310, r311);     // Catch: Exception -> L35
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.h.d("FlowCocreationReviewIDLStub", "logOmniUserStop = void");     // Catch: Exception -> L35
    L11:
        long r109 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L35
        long r115 = Math.max(0, r109 - r110) / 1000;     // Catch: Exception -> L35
        int r116 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L35
        StringBuilder r117 = new StringBuilder("logOmniUserStop(");     // Catch: Exception -> L33
        r117.append(r210);     // Catch: Exception -> L33
        r100 = ", ";
        r117.append(r100);     // Catch: Exception -> L31
        r117.append(r211);     // Catch: Exception -> L31
        r117.append(r100);     // Catch: Exception -> L31
        r117.append(r212);     // Catch: Exception -> L29
        r117.append(r100);     // Catch: Exception -> L29
        r117.append(r213);     // Catch: Exception -> L29
        r117.append(r100);     // Catch: Exception -> L29
        r117.append(r310);     // Catch: Exception -> L25
        r117.append(r100);     // Catch: Exception -> L25
        r117.append(r114);     // Catch: Exception -> L25
        r117.append(") = void");     // Catch: Exception -> L25
        com.obric.aiagent.ipc.utils.i.d("FlowCocreationReviewIDLStub", r117.toString(), r115);     // Catch: Exception -> L25
        r100 = r100;
        r112 = r310;
        r111 = r212;
        r214 = "FlowCocreationReviewIDLStub";
        r113 = "logOmniUserStop(";
        IPCAnomalyTrace.f384709a.e("FlowCocreationReviewIDLStub", "logOmniUserStop", r115, r109);     // Catch: Exception -> L23
        return;
    L23:
        e = e;
    L25:
        e = e;
        r112 = r310;
    L27:
        r111 = r212;
    L28:
        r214 = "FlowCocreationReviewIDLStub";
        r113 = "logOmniUserStop(";
    L29:
        e = e;
        r112 = r310;
    L31:
        e = e;
        r111 = r212;
        r112 = r310;
        r100 = r100;
    L33:
        e = e;
        r111 = r212;
        r112 = r310;
        r100 = ", ";
    L35:
        e = e;
        r111 = r212;
        r112 = r310;
        r100 = ", ";
        r214 = "FlowCocreationReviewIDLStub";
        r113 = "logOmniUserStop(";
        goto L39
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniStep(String r210, long r211, String r310, int r311, String r312, String r313, boolean r314, boolean r315, long r316, String r317) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L63;
        String r212 = "logOmniStep(";
        String r100 = ")";
        String r111 = ", ";
        String r101 = "FlowCocreationReviewIDLStub";
    L19:
        String r112 = r101;
        String r113 = r111;
        String r213 = r100;
        String r214 = r212;
        this.origin.logOmniStep(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317);     // Catch: Exception -> L55
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.h.d(r112, "logOmniStep = void");     // Catch: Exception -> L55
    L24:
        long r102 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L55
        long r103 = Math.max(0, r102 - r110) / 1000;     // Catch: Exception -> L55
        int r104 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L55
        String r114 = r214;
        StringBuilder r105 = new StringBuilder(r114);     // Catch: Exception -> L52
        r210 = r210;
        r112 = r112;
        r105.append(r210);     // Catch: Exception -> L50
        r113 = r113;
        r105.append(r113);     // Catch: Exception -> L48
        r105.append(r211);     // Catch: Exception -> L46
        r105.append(r113);     // Catch: Exception -> L46
        String r115 = r310;
        r105.append(r115);     // Catch: Exception -> L44
        r105.append(r113);     // Catch: Exception -> L44
        r105.append(r311);     // Catch: Exception -> L44
        r105.append(r113);     // Catch: Exception -> L44
        r105.append(r312);     // Catch: Exception -> L44
        r105.append(r113);     // Catch: Exception -> L44
        r105.append(r313);     // Catch: Exception -> L44
        r105.append(r113);     // Catch: Exception -> L44
        r105.append(r314);     // Catch: Exception -> L44
        r105.append(r113);     // Catch: Exception -> L44
        r105.append(r315);     // Catch: Exception -> L44
        r105.append(r113);     // Catch: Exception -> L44
        r105.append(r316);     // Catch: Exception -> L44
        r105.append(r113);     // Catch: Exception -> L44
        r317 = r317;
        r105.append(r317);     // Catch: Exception -> L42
        r105.append(") = void");     // Catch: Exception -> L42
        com.obric.aiagent.ipc.utils.i.d(r112, r105.toString(), r103);     // Catch: Exception -> L42
        r211 = r211;
        IPCAnomalyTrace.f384709a.e("FlowCocreationReviewIDLStub", "logOmniStep", r103, r102);     // Catch: Exception -> L40
        return;
    L40:
        e = e;
    L61:
        int r106 = com.obric.aiagent.ipc.utils.h.f384747a;
        StringBuilder r107 = new StringBuilder(r114);
        r107.append(r210);
        r107.append(r113);
        r107.append(r211);
        r107.append(r113);
        r107.append(r115);
        r107.append(r113);
        r107.append(r311);
        r107.append(r113);
        r107.append(r312);
        r107.append(r113);
        r107.append(r313);
        r107.append(r113);
        r107.append(r314);
        r107.append(r113);
        r107.append(r315);
        r107.append(r113);
        r107.append(r316);
        r107.append(r113);
        r107.append(r317);
        r107.append(r213);
        com.obric.aiagent.ipc.utils.h.b(r112, r107.toString(), e);
        IPCException r108 = new IPCException(e);
        long r116 = SystemClock.elapsedRealtimeNanos();
        long r109 = Math.max(0, r116 - r110) / 1000;
        int r117 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c(r112, r114 + r210 + r113 + r211 + r113 + r115 + r113 + r311 + r113 + r312 + r113 + r313 + r113 + r314 + r113 + r315 + r113 + r316 + r113 + r317 + ") = fail", r108, r109);
        IPCAnomalyTrace r118 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FlowCocreationReviewIDLStub", "logOmniStep", r108, r109, r116);
        throw r108;
    L42:
        e = e;
    L43:
        r211 = r211;
    L44:
        e = e;
    L45:
        r317 = r317;
    L46:
        e = e;
        r115 = r310;
    L48:
        e = e;
        r211 = r211;
        r115 = r310;
        r317 = r317;
    L50:
        e = e;
        r211 = r211;
        r115 = r310;
        r317 = r317;
        r113 = r113;
    L52:
        e = e;
    L54:
        r115 = r310;
    L55:
        e = e;
        r114 = r214;
    L57:
        e = e;
    L58:
        r213 = r100;
        r317 = r317;
        r211 = r211;
        r210 = r210;
        r114 = r212;
        r112 = r101;
        r115 = r310;
        r113 = r111;
        goto L61
    L63:
        int r119 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L16
        StringBuilder r120 = new StringBuilder("logOmniStep(");     // Catch: Exception -> L16
        r120.append(r210);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r211);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r310);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r311);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r312);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r313);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r314);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r315);     // Catch: Exception -> L16
        r120.append(", ");     // Catch: Exception -> L16
        r120.append(r316);     // Catch: Exception -> L14
        r120.append(", ");     // Catch: Exception -> L14
        r120.append(r317);     // Catch: Exception -> L14
        r212 = "logOmniStep(";
        r100 = ")";
        r120.append(r100);     // Catch: Exception -> L12
        r111 = ", ";
        r101 = "FlowCocreationReviewIDLStub";
        com.obric.aiagent.ipc.utils.h.c(r101, r120.toString());     // Catch: Exception -> L57
    L12:
        e = e;
    L13:
        r111 = ", ";
        r101 = "FlowCocreationReviewIDLStub";
    L14:
        e = e;
    L15:
        r212 = "logOmniStep(";
        r100 = ")";
    L16:
        e = e;
    L59:
        e = e;
        r114 = "logOmniStep(";
        r317 = r317;
        r211 = r211;
        r210 = r210;
        r112 = "FlowCocreationReviewIDLStub";
        r213 = ")";
        r115 = r310;
        r113 = ", ";
        goto L61
    }
}
