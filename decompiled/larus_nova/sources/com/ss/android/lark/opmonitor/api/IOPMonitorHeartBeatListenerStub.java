package com.ss.android.lark.opmonitor.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import byb.a;

/* JADX INFO: loaded from: classes37.dex */
public final class IOPMonitorHeartBeatListenerStub extends Binder implements IInterface, a {
    public final a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IOPMonitorHeartBeatListenerStub(a r100) {
        this.base = r100;
        attachInterface(this, IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
    }

    public static IOPMonitorHeartBeatListenerProxy asInterface(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface(IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
        if (r101 == null) goto L12;
        if ((r101 instanceof IOPMonitorHeartBeatListenerProxy) == false) goto L12;
        return (IOPMonitorHeartBeatListenerProxy) r101;
    L12:
        return new IOPMonitorHeartBeatListenerProxy(r100);
    }

    @Override // byb.a
    public int getCurrentHeartBeatStatus(String r100) {
        return this.base.getCurrentHeartBeatStatus(r100);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
        int r104 = getCurrentHeartBeatStatus(r101.readString());
        r102.writeNoException();
        r102.writeInt(r104);
        return true;
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString(IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }
}
