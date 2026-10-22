package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class FlowCocreationReviewIDLIpcWrapper implements IFlowCocreationReviewIDL {
    boolean log;
    final IFlowCocreationReviewIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowCocreationReviewIDLIpcWrapper(IFlowCocreationReviewIDL r100) throws RemoteException {
        this(r100, true);
    }

    public FlowCocreationReviewIDLIpcWrapper(IFlowCocreationReviewIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniUserStop(String r210, long r211, String r212, long r213, String r310, String r311) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = e;
        String r100 = ", ";
        String r214 = "IFlowCocreationReviewIDLIPC";
        String r215 = ")";
        String r111 = r212;
        String r112 = r310;
        String r113 = "logOmniUserStop(";
        String r114 = r311;
    L42:
        int r101 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L44
        String r102 = r214;
        com.obric.aiagent.ipc.utils.h.b(r102, r113 + r210 + r100 + r211 + r100 + r111 + r100 + r213 + r100 + r112 + r100 + r114 + r215, e);     // Catch: Throwable -> L44
        IPCException r103 = new IPCException(e);     // Catch: Throwable -> L44
        long r104 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L44
        long r105 = Math.max(0, r104 - r110) / 1000;     // Catch: Throwable -> L44
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L44
        com.obric.aiagent.ipc.utils.i.a(r102, r113 + r210 + r100 + r211 + r100 + r111 + r100 + r213 + r100 + r112 + r100 + r114 + ") = fail", r103, r105);     // Catch: Throwable -> L44
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L44
        IPCAnomalyTrace.b("IFlowCocreationReviewIDLIPC", "logOmniUserStop", r103, r105, r104);     // Catch: Throwable -> L44
        return;
    L4:
        if (this.log == false) goto L7;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L44
        com.obric.aiagent.ipc.utils.h.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ", " + r310 + ", " + r311 + ")");     // Catch: Exception -> L40 Throwable -> L44
    L7:
        if (this.log == false) goto L9;
        int r109 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L40 Throwable -> L44
        com.obric.aiagent.ipc.utils.h.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ", " + r310 + ", " + r311 + ")");     // Catch: Exception -> L40 Throwable -> L44
    L9:
        r114 = r311;
        r215 = ")";
        this.origin.logOmniUserStop(r210, r211, r212, r213, r310, r311);     // Catch: Exception -> L38 Throwable -> L44
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.h.d("IFlowCocreationReviewIDLIPC", "logOmniUserStop = void");     // Catch: Exception -> L38 Throwable -> L44
    L14:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L38 Throwable -> L44
        long r116 = Math.max(0, r115 - r110) / 1000;     // Catch: Exception -> L38 Throwable -> L44
        int r117 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L38 Throwable -> L44
        StringBuilder r118 = new StringBuilder("logOmniUserStop(");     // Catch: Exception -> L36 Throwable -> L44
        r118.append(r210);     // Catch: Exception -> L36 Throwable -> L44
        r100 = ", ";
        r118.append(r100);     // Catch: Exception -> L34 Throwable -> L44
        r118.append(r211);     // Catch: Exception -> L34 Throwable -> L44
        r118.append(r100);     // Catch: Exception -> L34 Throwable -> L44
        r118.append(r212);     // Catch: Exception -> L32 Throwable -> L44
        r118.append(r100);     // Catch: Exception -> L32 Throwable -> L44
        r118.append(r213);     // Catch: Exception -> L32 Throwable -> L44
        r118.append(r100);     // Catch: Exception -> L32 Throwable -> L44
        r118.append(r310);     // Catch: Exception -> L28 Throwable -> L44
        r118.append(r100);     // Catch: Exception -> L28 Throwable -> L44
        r118.append(r114);     // Catch: Exception -> L28 Throwable -> L44
        r118.append(") = void");     // Catch: Exception -> L28 Throwable -> L44
        com.obric.aiagent.ipc.utils.i.b("IFlowCocreationReviewIDLIPC", r118.toString(), r116);     // Catch: Exception -> L28 Throwable -> L44
        r100 = r100;
        r112 = r310;
        r111 = r212;
        r214 = "IFlowCocreationReviewIDLIPC";
        r113 = "logOmniUserStop(";
        IPCAnomalyTrace.f384709a.c("IFlowCocreationReviewIDLIPC", "logOmniUserStop", r116, r115);     // Catch: Exception -> L26 Throwable -> L44
        return;
    L26:
        e = e;
    L28:
        e = e;
        r112 = r310;
    L30:
        r111 = r212;
    L31:
        r214 = "IFlowCocreationReviewIDLIPC";
        r113 = "logOmniUserStop(";
    L32:
        e = e;
        r112 = r310;
    L34:
        e = e;
        r111 = r212;
        r112 = r310;
        r100 = r100;
    L36:
        e = e;
        r111 = r212;
        r112 = r310;
        r100 = ", ";
    L38:
        e = e;
        r111 = r212;
        r112 = r310;
        r100 = ", ";
        r214 = "IFlowCocreationReviewIDLIPC";
        r113 = "logOmniUserStop(";
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniStep(String r210, long r211, String r212, int r213, String r310, String r311, boolean r312, boolean r313, long r314, String r315) throws RemoteException {
        String r110 = r210;
        r211 = r211;
        r212 = r212;
        String r100 = ", ";
        String r111 = ")";
        long r112 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L82;
        long r101 = r314;
        String r102 = "IFlowCocreationReviewIDLIPC";
    L20:
        if (this.log == true) goto L86;
        String r103 = r315;
        String r113 = "logOmniStep(";
        String r104 = r111;
    L31:
        String r214 = r104;
        String r114 = r102;
        this.origin.logOmniStep(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315);     // Catch: Exception -> L67 Throwable -> L79
        if (this.log == false) goto L36;
        com.obric.aiagent.ipc.utils.h.d(r114, "logOmniStep = void");     // Catch: Exception -> L67 Throwable -> L79
    L36:
        long r105 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L67 Throwable -> L79
        long r106 = Math.max(0, r105 - r112) / 1000;     // Catch: Exception -> L67 Throwable -> L79
        int r107 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L67 Throwable -> L79
        String r108 = r113;
        StringBuilder r109 = new StringBuilder(r108);     // Catch: Exception -> L65 Throwable -> L79
        r110 = r210;
        String r115 = r108;
        r109.append(r110);     // Catch: Exception -> L62 Throwable -> L79
        r100 = ", ";
        r109.append(r100);     // Catch: Exception -> L60 Throwable -> L79
        r109.append(r211);     // Catch: Exception -> L58 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L58 Throwable -> L79
        r212 = r212;
        r109.append(r212);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r213);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r310);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r311);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r312);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r313);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r314);     // Catch: Exception -> L56 Throwable -> L79
        r109.append(r100);     // Catch: Exception -> L56 Throwable -> L79
        r315 = r315;
        r109.append(r315);     // Catch: Exception -> L54 Throwable -> L79
        r109.append(") = void");     // Catch: Exception -> L54 Throwable -> L79
        com.obric.aiagent.ipc.utils.i.b(r114, r109.toString(), r106);     // Catch: Exception -> L54 Throwable -> L79
        r211 = r211;
        IPCAnomalyTrace.f384709a.c("IFlowCocreationReviewIDLIPC", "logOmniStep", r106, r105);     // Catch: Exception -> L52 Throwable -> L79
        return;
    L52:
        e = e;
    L77:
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L79
        StringBuilder r117 = new StringBuilder(r115);     // Catch: Throwable -> L79
        r117.append(r110);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r211);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r212);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r213);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r310);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r311);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r312);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r313);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r314);     // Catch: Throwable -> L79
        r117.append(r100);     // Catch: Throwable -> L79
        r117.append(r315);     // Catch: Throwable -> L79
        r117.append(r214);     // Catch: Throwable -> L79
        com.obric.aiagent.ipc.utils.h.b(r114, r117.toString(), e);     // Catch: Throwable -> L79
        IPCException r118 = new IPCException(e);     // Catch: Throwable -> L79
        long r119 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L79
        long r120 = Math.max(0, r119 - r112) / 1000;     // Catch: Throwable -> L79
        int r121 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L79
        com.obric.aiagent.ipc.utils.i.a(r114, r115 + r110 + r100 + r211 + r100 + r212 + r100 + r213 + r100 + r310 + r100 + r311 + r100 + r312 + r100 + r313 + r100 + r314 + r100 + r315 + ") = fail", r118, r120);     // Catch: Throwable -> L79
        IPCAnomalyTrace r122 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L79
        IPCAnomalyTrace.b("IFlowCocreationReviewIDLIPC", "logOmniStep", r118, r120, r119);     // Catch: Throwable -> L79
        return;
    L54:
        e = e;
    L55:
        r211 = r211;
    L56:
        e = e;
    L57:
        r315 = r315;
    L58:
        e = e;
        r212 = r212;
    L60:
        e = e;
        r211 = r211;
        r212 = r212;
        r315 = r315;
    L62:
        e = e;
    L64:
        r100 = ", ";
    L65:
        e = e;
        r110 = r210;
        r115 = r108;
    L67:
        e = e;
        r110 = r210;
        r115 = r113;
    L69:
        e = e;
    L70:
        r214 = r104;
        r315 = r103;
        r115 = r113;
    L72:
        r114 = r102;
        goto L77
    L86:
        int r123 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L28 Throwable -> L79
        StringBuilder r124 = new StringBuilder("logOmniStep(");     // Catch: Exception -> L28 Throwable -> L79
        r124.append(r110);     // Catch: Exception -> L28 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r124.append(r211);     // Catch: Exception -> L28 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r124.append(r212);     // Catch: Exception -> L28 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r124.append(r213);     // Catch: Exception -> L28 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r124.append(r310);     // Catch: Exception -> L28 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r124.append(r311);     // Catch: Exception -> L28 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r124.append(r312);     // Catch: Exception -> L26 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L26 Throwable -> L79
        r124.append(r313);     // Catch: Exception -> L26 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L26 Throwable -> L79
        r124.append(r101);     // Catch: Exception -> L26 Throwable -> L79
        r124.append(", ");     // Catch: Exception -> L26 Throwable -> L79
        r103 = r315;
        r113 = "logOmniStep(";
        r104 = r111;
        r124.append(r103);     // Catch: Exception -> L69 Throwable -> L79
        r124.append(r104);     // Catch: Exception -> L69 Throwable -> L79
        com.obric.aiagent.ipc.utils.h.a(r102, r124.toString());     // Catch: Exception -> L69 Throwable -> L79
    L26:
        e = e;
        r315 = r315;
        r115 = "logOmniStep(";
        r214 = r111;
    L28:
        e = e;
        r103 = r315;
        r113 = "logOmniStep(";
        r104 = r111;
    L73:
        e = e;
    L74:
        r315 = r315;
        r211 = r211;
        r110 = r110;
        r214 = r111;
        r115 = "logOmniStep(";
        goto L72
    L82:
        int r125 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L17 Throwable -> L79
        StringBuilder r126 = new StringBuilder("logOmniStep(");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r110);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r211);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r212);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r213);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r310);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r311);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r312);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r126.append(r313);     // Catch: Exception -> L17 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r101 = r314;
        r126.append(r101);     // Catch: Exception -> L15 Throwable -> L79
        r126.append(", ");     // Catch: Exception -> L15 Throwable -> L79
        r126.append(r315);     // Catch: Exception -> L15 Throwable -> L79
        r126.append(r111);     // Catch: Exception -> L12 Throwable -> L79
        r111 = r111;
        r102 = "IFlowCocreationReviewIDLIPC";
        com.obric.aiagent.ipc.utils.h.a(r102, r126.toString());     // Catch: Exception -> L73 Throwable -> L79
    L12:
        e = e;
        r111 = r111;
    L14:
        r102 = "IFlowCocreationReviewIDLIPC";
    L15:
        e = e;
    L17:
        e = e;
    L75:
        e = e;
        r315 = r315;
        r211 = r211;
        r110 = r110;
        r114 = "IFlowCocreationReviewIDLIPC";
        r214 = r111;
        r100 = ", ";
        r115 = "logOmniStep(";
    }
}
