package com.ss.android.lark.guidemgr.manis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes36.dex */
public final class OnGuideChangeListenerStub extends Binder implements IInterface, IGuideMgrProxy.a {
    public final IGuideMgrProxy.a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public OnGuideChangeListenerStub(IGuideMgrProxy.a r100) {
        this.base = r100;
        attachInterface(this, OnGuideChangeListenerProxy.DESCRIPTOR);
    }

    public static OnGuideChangeListenerProxy asInterface(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface(OnGuideChangeListenerProxy.DESCRIPTOR);
        if (r101 == null) goto L12;
        if ((r101 instanceof OnGuideChangeListenerProxy) == false) goto L12;
        return (OnGuideChangeListenerProxy) r101;
    L12:
        return new OnGuideChangeListenerProxy(r100);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy.a
    public void onGuideChanged(String r100) {
        this.base.onGuideChanged(r100);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(OnGuideChangeListenerProxy.DESCRIPTOR);
        onGuideChanged(r101.readString());
        r102.writeNoException();
        return true;
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString(OnGuideChangeListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }
}
