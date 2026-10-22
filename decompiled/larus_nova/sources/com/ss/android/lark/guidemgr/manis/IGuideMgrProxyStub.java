package com.ss.android.lark.guidemgr.manis;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes36.dex */
public final class IGuideMgrProxyStub extends Binder implements IInterface, IGuideMgrProxy {
    public final GuideMgrProxyImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void fetchFromMainProcess() {
        this.base.fetchFromMainProcess();
    }

    public IGuideMgrProxyStub(Context r100) {
        this.base = new GuideMgrProxyImpl(r100);
        attachInterface(this, IGuideMgrProxyProxy.DESCRIPTOR);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void onGuideChanged(String r100) {
        this.base.onGuideChanged(r100);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void registerOnGuideChangeListener(IGuideMgrProxy.a r100) {
        this.base.registerOnGuideChangeListener(r100);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public boolean report(String r100) {
        return this.base.report(r100);
    }

    public static IGuideMgrProxyProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof IGuideMgrProxyProxy) == false) goto L12;
        return (IGuideMgrProxyProxy) r102;
    L12:
        return new IGuideMgrProxyProxy(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        boolean r104 = report(r101.readString());
        r102.writeNoException();
        r102.writeInt(r104 ? 1 : 0);
        return true;
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        fetchFromMainProcess();
        r102.writeNoException();
        return true;
    L7:
        if (r100 != 3) goto L9;
        r101.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        registerOnGuideChangeListener(OnGuideChangeListenerStub.asInterface(r101.readStrongBinder()));
        r102.writeNoException();
        return true;
    L9:
        if (r100 != 4) goto L11;
        r101.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        onGuideChanged(r101.readString());
        r102.writeNoException();
        return true;
    L11:
        if (r100 != 1598968902) goto L13;
        r102.writeString(IGuideMgrProxyProxy.DESCRIPTOR);
        return true;
    L13:
        return super.onTransact(r100, r101, r102, r103);
    }
}
