package com.ss.android.lark.resource.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes37.dex */
public final class IProxyPushResourceListenerStub extends Binder implements IInterface, b {
    public final b base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IProxyPushResourceListenerStub(b r100) {
        this.base = r100;
        attachInterface(this, IProxyPushResourceListenerProxy.DESCRIPTOR);
    }

    public static IProxyPushResourceListenerProxy asInterface(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface(IProxyPushResourceListenerProxy.DESCRIPTOR);
        if (r101 == null) goto L12;
        if ((r101 instanceof IProxyPushResourceListenerProxy) == false) goto L12;
        return (IProxyPushResourceListenerProxy) r101;
    L12:
        return new IProxyPushResourceListenerProxy(r100);
    }

    @Override // qpc.c
    public void onPushDownloadStatus(String r100, boolean r101) {
        this.base.onPushDownloadStatus(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IProxyPushResourceListenerProxy.DESCRIPTOR);
        String r104 = r101.readString();
        if (r101.readInt() != 0) goto L13;
        boolean r105 = false;
    L14:
        onPushDownloadStatus(r104, r105);
        r102.writeNoException();
        return true;
    L13:
        r105 = true;
        goto L14
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString(IProxyPushResourceListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }
}
