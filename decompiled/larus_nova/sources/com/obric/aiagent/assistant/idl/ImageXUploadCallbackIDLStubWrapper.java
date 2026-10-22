package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class ImageXUploadCallbackIDLStubWrapper extends IImageXUploadCallbackIDL.Stub {
    boolean log;
    final IImageXUploadCallbackIDL.Stub origin;

    public ImageXUploadCallbackIDLStubWrapper(IImageXUploadCallbackIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    public ImageXUploadCallbackIDLStubWrapper(IImageXUploadCallbackIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r310, String r311, String r312, String r313, String r314) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L23:
        e = e;
        String r100 = "onResult(";
        String r210 = ")";
        long r101 = 0;
        String r102 = r314;
    L25:
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;
        com.obric.aiagent.ipc.utils.h.b("ImageXUploadCallbackIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + r210, e);
        IPCException r104 = new IPCException(e);
        long r211 = SystemClock.elapsedRealtimeNanos();
        long r105 = Math.max(r101, r211 - r110) / 1000;
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;
        com.obric.aiagent.ipc.utils.i.c("ImageXUploadCallbackIDLStub", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + ") = fail", r104, r105);
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("ImageXUploadCallbackIDLStub", "onResult", r104, r105, r211);
        throw r104;
    L4:
        if (this.log == false) goto L6;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L23
        com.obric.aiagent.ipc.utils.h.c("ImageXUploadCallbackIDLStub", "onResult(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r314 + ")");     // Catch: Exception -> L23
    L6:
        r210 = ")";
        this.origin.onResult(r310, r311, r312, r313, r314);     // Catch: Exception -> L21
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.h.d("ImageXUploadCallbackIDLStub", "onResult = void");     // Catch: Exception -> L21
    L11:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L21
        long r109 = Math.max(0, r212 - r110) / 1000;     // Catch: Exception -> L21
        int r111 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L21
        r100 = "onResult(";
        StringBuilder r112 = new StringBuilder(r100);     // Catch: Exception -> L19
        r112.append(r310);     // Catch: Exception -> L19
        r112.append(", ");     // Catch: Exception -> L19
        r112.append(r311);     // Catch: Exception -> L19
        r112.append(", ");     // Catch: Exception -> L19
        r112.append(r312);     // Catch: Exception -> L19
        r112.append(", ");     // Catch: Exception -> L19
        r112.append(r313);     // Catch: Exception -> L19
        r112.append(", ");     // Catch: Exception -> L19
        r102 = r314;
        r101 = 0;
        r112.append(r102);     // Catch: Exception -> L17
        r112.append(") = void");     // Catch: Exception -> L17
        com.obric.aiagent.ipc.utils.i.d("ImageXUploadCallbackIDLStub", r112.toString(), r109);     // Catch: Exception -> L17
        IPCAnomalyTrace.f384709a.e("ImageXUploadCallbackIDLStub", "onResult", r109, r212);     // Catch: Exception -> L17
        return;
    L17:
        e = e;
    L19:
        e = e;
        r102 = r314;
        r101 = 0;
    L21:
        e = e;
        r102 = r314;
        r101 = 0;
        r100 = "onResult(";
        goto L25
    }
}
