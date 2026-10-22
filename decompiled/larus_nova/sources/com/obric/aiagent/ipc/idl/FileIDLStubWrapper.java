package com.obric.aiagent.ipc.idl;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class FileIDLStubWrapper extends IFileIDL.Stub {
    boolean log;
    final IFileIDL.Stub origin;

    public FileIDLStubWrapper(IFileIDL.Stub r100) throws RemoteException {
        this(r100, true);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = h.f384747a;
        h.b("FileIDLStub", "deleteFile(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = i.f384748a;
        i.c("FileIDLStub", "deleteFile(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FileIDLStub", "deleteFile", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = h.f384747a;     // Catch: Exception -> L11
        h.c("FileIDLStub", "deleteFile(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        boolean r113 = this.origin.deleteFile(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = h.f384747a;     // Catch: Exception -> L11
        h.d("FileIDLStub", "deleteFile = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = i.f384748a;     // Catch: Exception -> L11
        i.d("FileIDLStub", "deleteFile(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FileIDLStub", "deleteFile", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listAllFile(FilePath r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = h.f384747a;
        h.b("FileIDLStub", "listAllFile(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = i.f384748a;
        i.c("FileIDLStub", "listAllFile(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FileIDLStub", "listAllFile", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = h.f384747a;     // Catch: Exception -> L11
        h.c("FileIDLStub", "listAllFile(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        List r113 = this.origin.listAllFile(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = h.f384747a;     // Catch: Exception -> L11
        h.d("FileIDLStub", "listAllFile = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = i.f384748a;     // Catch: Exception -> L11
        i.d("FileIDLStub", "listAllFile(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FileIDLStub", "listAllFile", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listDir(FilePath r210) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = h.f384747a;
        h.b("FileIDLStub", "listDir(" + r210 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = i.f384748a;
        i.c("FileIDLStub", "listDir(" + r210 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FileIDLStub", "listDir", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = h.f384747a;     // Catch: Exception -> L11
        h.c("FileIDLStub", "listDir(" + r210 + ")");     // Catch: Exception -> L11
    L6:
        List r113 = this.origin.listDir(r210);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = h.f384747a;     // Catch: Exception -> L11
        h.d("FileIDLStub", "listDir = " + r113);     // Catch: Exception -> L11
    L9:
        long r115 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r116 = Math.max(0, r115 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = i.f384748a;     // Catch: Exception -> L11
        i.d("FileIDLStub", "listDir(" + r210 + ") = " + r113, r116);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FileIDLStub", "listDir", r116, r115);     // Catch: Exception -> L11
        return r113;
    }

    public FileIDLStubWrapper(IFileIDL.Stub r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r210, int r211) throws RemoteException {
        long r100 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r110 = h.f384747a;
        h.b("FileIDLStub", "openFile(" + r210 + ", " + r211 + ")", e);
        IPCException r101 = new IPCException(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r102 = Math.max(0, r111 - r100) / 1000;
        int r103 = i.f384748a;
        i.c("FileIDLStub", "openFile(" + r210 + ", " + r211 + ") = fail", r101, r102);
        IPCAnomalyTrace r104 = IPCAnomalyTrace.f384709a;
        IPCAnomalyTrace.d("FileIDLStub", "openFile", r101, r102, r111);
        throw r101;
    L4:
        if (this.log == false) goto L6;
        int r112 = h.f384747a;     // Catch: Exception -> L11
        h.c("FileIDLStub", "openFile(" + r210 + ", " + r211 + ")");     // Catch: Exception -> L11
    L6:
        ParcelFileDescriptor r113 = this.origin.openFile(r210, r211);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r114 = h.f384747a;     // Catch: Exception -> L11
        h.d("FileIDLStub", "openFile = " + r113);     // Catch: Exception -> L11
    L9:
        long r212 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r115 = Math.max(0, r212 - r100) / 1000;     // Catch: Exception -> L11
        int r105 = i.f384748a;     // Catch: Exception -> L11
        i.d("FileIDLStub", "openFile(" + r210 + ", " + r211 + ") = " + r113, r115);     // Catch: Exception -> L11
        IPCAnomalyTrace.f384709a.e("FileIDLStub", "openFile", r115, r212);     // Catch: Exception -> L11
        return r113;
    }
}
