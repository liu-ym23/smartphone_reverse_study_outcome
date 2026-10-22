package com.ss.android.lark.resource.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes37.dex */
public final class IProxyPushResourceDownloadProgressListenerStub extends Binder implements IInterface, a {
    public final a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IProxyPushResourceDownloadProgressListenerStub(a r100) {
        this.base = r100;
        attachInterface(this, IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
    }

    public static IProxyPushResourceDownloadProgressListenerProxy asInterface(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface(IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
        if (r101 == null) goto L12;
        if ((r101 instanceof IProxyPushResourceDownloadProgressListenerProxy) == false) goto L12;
        return (IProxyPushResourceDownloadProgressListenerProxy) r101;
    L12:
        return new IProxyPushResourceDownloadProgressListenerProxy(r100);
    }

    @Override // qpc.b
    public void onPushDownloadProgress(String r100, int r101, long r110, long r111) {
        this.base.onPushDownloadProgress(r100, r101, r110, r111);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
        if (r110 != 1) goto L5;
        r111.enforceInterface(IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
        onPushDownloadProgress(r111.readString(), r111.readInt(), r111.readLong(), r111.readLong());
        r112.writeNoException();
        return true;
    L5:
        if (r110 != 1598968902) goto L7;
        r112.writeString(IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r110, r111, r112, r113);
    }
}
