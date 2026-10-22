package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;

/* JADX INFO: loaded from: classes6.dex */
class ImageXUploadCallbackIDLIpcWrapper implements IImageXUploadCallbackIDL {
    boolean log;
    final IImageXUploadCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public ImageXUploadCallbackIDLIpcWrapper(IImageXUploadCallbackIDL r100) throws RemoteException {
        this(r100, true);
    }

    public ImageXUploadCallbackIDLIpcWrapper(IImageXUploadCallbackIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r310, String r311, String r312, String r313, String r314) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
    L26:
        e = e;
        String r100 = "onResult(";
        String r210 = ")";
        long r101 = 0;
        String r102 = r314;
    L28:
        int r103 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.h.b("IImageXUploadCallbackIDLIPC", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + r210, e);     // Catch: Throwable -> L30
        IPCException r104 = new IPCException(e);     // Catch: Throwable -> L30
        long r211 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L30
        long r105 = Math.max(r101, r211 - r110) / 1000;     // Catch: Throwable -> L30
        int r106 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.i.a("IImageXUploadCallbackIDLIPC", r100 + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r102 + ") = fail", r104, r105);     // Catch: Throwable -> L30
        IPCAnomalyTrace r107 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L30
        IPCAnomalyTrace.b("IImageXUploadCallbackIDLIPC", "onResult", r104, r105, r211);     // Catch: Throwable -> L30
        return;
    L4:
        if (this.log == false) goto L7;
        int r108 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L26 Throwable -> L30
        com.obric.aiagent.ipc.utils.h.a("IImageXUploadCallbackIDLIPC", "onResult(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r314 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L7:
        if (this.log == false) goto L9;
        int r109 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L26 Throwable -> L30
        com.obric.aiagent.ipc.utils.h.a("IImageXUploadCallbackIDLIPC", "onResult(" + r310 + ", " + r311 + ", " + r312 + ", " + r313 + ", " + r314 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L9:
        r210 = ")";
        this.origin.onResult(r310, r311, r312, r313, r314);     // Catch: Exception -> L24 Throwable -> L30
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.h.d("IImageXUploadCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L24 Throwable -> L30
    L14:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24 Throwable -> L30
        long r111 = Math.max(0, r212 - r110) / 1000;     // Catch: Exception -> L24 Throwable -> L30
        int r112 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L24 Throwable -> L30
        r100 = "onResult(";
        StringBuilder r113 = new StringBuilder(r100);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r310);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r311);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r312);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r113.append(r313);     // Catch: Exception -> L22 Throwable -> L30
        r113.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r102 = r314;
        r101 = 0;
        r113.append(r102);     // Catch: Exception -> L20 Throwable -> L30
        r113.append(") = void");     // Catch: Exception -> L20 Throwable -> L30
        com.obric.aiagent.ipc.utils.i.b("IImageXUploadCallbackIDLIPC", r113.toString(), r111);     // Catch: Exception -> L20 Throwable -> L30
        IPCAnomalyTrace.f384709a.c("IImageXUploadCallbackIDLIPC", "onResult", r111, r212);     // Catch: Exception -> L20 Throwable -> L30
        return;
    L20:
        e = e;
    L22:
        e = e;
        r102 = r314;
        r101 = 0;
    L24:
        e = e;
        r102 = r314;
        r101 = 0;
        r100 = "onResult(";
        goto L28
    }
}
