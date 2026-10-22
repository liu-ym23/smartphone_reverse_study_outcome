package com.ss.android.lark.security.compliance.infra.util;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes38.dex */
public final class ILogMonitorServiceStub extends Binder implements IInterface, ILogMonitorService {
    public final LogMonitorServiceImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.ss.android.lark.security.compliance.infra.util.ILogMonitorService
    public int getMsgId() {
        return this.base.getMsgId();
    }

    @Override // com.ss.android.lark.security.compliance.infra.util.ILogMonitorService
    public String getTraceId() {
        return this.base.getTraceId();
    }

    public ILogMonitorServiceStub(Context r100) {
        this.base = new LogMonitorServiceImpl(r100);
        attachInterface(this, ILogMonitorServiceProxy.DESCRIPTOR);
    }

    public static ILogMonitorServiceProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(ILogMonitorServiceProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof ILogMonitorServiceProxy) == false) goto L12;
        return (ILogMonitorServiceProxy) r102;
    L12:
        return new ILogMonitorServiceProxy(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(ILogMonitorServiceProxy.DESCRIPTOR);
        String r104 = getTraceId();
        r102.writeNoException();
        r102.writeString(r104);
        return true;
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(ILogMonitorServiceProxy.DESCRIPTOR);
        int r105 = getMsgId();
        r102.writeNoException();
        r102.writeInt(r105);
        return true;
    L7:
        if (r100 != 1598968902) goto L9;
        r102.writeString(ILogMonitorServiceProxy.DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r100, r101, r102, r103);
    }
}
