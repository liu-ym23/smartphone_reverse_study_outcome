package com.larksuite.component.blockit.sub_process;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes24.dex */
public final class IP0SubProcessStub extends Binder implements IInterface, IP0SubProcess {
    public final P0SubProcessImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IP0SubProcessStub(Context r100) {
        this.base = new P0SubProcessImpl(r100);
        attachInterface(this, IP0SubProcessProxy.DESCRIPTOR);
    }

    @Override // com.larksuite.component.blockit.sub_process.IP0SubProcess
    public void triggerRefresh(String r100) {
        this.base.triggerRefresh(r100);
    }

    public static IP0SubProcessProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(IP0SubProcessProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof IP0SubProcessProxy) == false) goto L12;
        return (IP0SubProcessProxy) r102;
    L12:
        return new IP0SubProcessProxy(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IP0SubProcessProxy.DESCRIPTOR);
        triggerRefresh(r101.readString());
        r102.writeNoException();
        return true;
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString(IP0SubProcessProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }
}
