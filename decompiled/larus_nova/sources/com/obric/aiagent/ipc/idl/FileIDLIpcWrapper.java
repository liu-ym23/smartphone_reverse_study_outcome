package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class FileIDLIpcWrapper implements IFileIDL {
    boolean log;
    final IFileIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FileIDLIpcWrapper(IFileIDL r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r110 = false;
    L14:
        e = move-exception;
        int r111 = h.f384747a;     // Catch: Throwable -> L17
        h.b("IFileIDLIPC", "deleteFile(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = i.f384748a;     // Catch: Throwable -> L17
        i.a("IFileIDLIPC", "deleteFile(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFileIDLIPC", "deleteFile", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "deleteFile(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "deleteFile(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.deleteFile(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFileIDLIPC", "deleteFile = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFileIDLIPC", "deleteFile(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFileIDLIPC", "deleteFile", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listAllFile(FilePath r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        List r110 = null;
    L14:
        e = move-exception;
        int r111 = h.f384747a;     // Catch: Throwable -> L17
        h.b("IFileIDLIPC", "listAllFile(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = i.f384748a;     // Catch: Throwable -> L17
        i.a("IFileIDLIPC", "listAllFile(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFileIDLIPC", "listAllFile", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "listAllFile(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "listAllFile(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.listAllFile(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFileIDLIPC", "listAllFile = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFileIDLIPC", "listAllFile(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFileIDLIPC", "listAllFile", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listDir(FilePath r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        List r110 = null;
    L14:
        e = move-exception;
        int r111 = h.f384747a;     // Catch: Throwable -> L17
        h.b("IFileIDLIPC", "listDir(" + r210 + ")", e);     // Catch: Throwable -> L17
        IPCException r112 = new IPCException(e);     // Catch: Throwable -> L17
        long r113 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r101 = Math.max(0, r113 - r100) / 1000;     // Catch: Throwable -> L17
        int r102 = i.f384748a;     // Catch: Throwable -> L17
        i.a("IFileIDLIPC", "listDir(" + r210 + ") = fail", r112, r101);     // Catch: Throwable -> L17
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFileIDLIPC", "listDir", r112, r101, r113);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r114 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "listDir(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r115 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "listDir(" + r210 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.listDir(r210);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r116 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFileIDLIPC", "listDir = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r117 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r118 = Math.max(0, r117 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r104 = i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFileIDLIPC", "listDir(" + r210 + ") = " + r110, r118);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFileIDLIPC", "listDir", r118, r117);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }

    public FileIDLIpcWrapper(IFileIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r210, int r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
        ParcelFileDescriptor r110 = null;
    L14:
        e = move-exception;
        int r111 = h.f384747a;     // Catch: Throwable -> L17
        h.b("IFileIDLIPC", "openFile(" + r210 + ", " + r211 + ")", e);     // Catch: Throwable -> L17
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L17
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r102 = Math.max(0, r212 - r100) / 1000;     // Catch: Throwable -> L17
        int r103 = i.f384748a;     // Catch: Throwable -> L17
        i.a("IFileIDLIPC", "openFile(" + r210 + ", " + r211 + ") = fail", r101, r102);     // Catch: Throwable -> L17
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFileIDLIPC", "openFile", r101, r102, r212);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r112 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "openFile(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r113 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFileIDLIPC", "openFile(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r110 = this.origin.openFile(r210, r211);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r114 = h.f384747a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFileIDLIPC", "openFile = " + r110);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r213 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r115 = Math.max(0, r213 - r100) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r105 = i.f384748a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFileIDLIPC", "openFile(" + r210 + ", " + r211 + ") = " + r110, r115);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IFileIDLIPC", "openFile", r115, r213);     // Catch: Exception -> L14 Throwable -> L17
        return r110;
    L16:
        return r110;
    }
}
