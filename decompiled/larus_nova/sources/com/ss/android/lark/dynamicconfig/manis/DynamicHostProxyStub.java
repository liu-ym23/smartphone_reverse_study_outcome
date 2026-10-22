package com.ss.android.lark.dynamicconfig.manis;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class DynamicHostProxyStub extends Binder implements IInterface, DynamicHostProxy {
    public final DynamicHostProxyImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getDocMainDomain() {
        return this.base.getDocMainDomain();
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getMainDomain() {
        return this.base.getMainDomain();
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public List<String> getMainDomains() {
        return this.base.getMainDomains();
    }

    public DynamicHostProxyStub(Context r100) {
        this.base = new DynamicHostProxyImpl(r100);
        attachInterface(this, DynamicHostProxyProxy.DESCRIPTOR);
    }

    public static DynamicHostProxyProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(DynamicHostProxyProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof DynamicHostProxyProxy) == false) goto L12;
        return (DynamicHostProxyProxy) r102;
    L12:
        return new DynamicHostProxyProxy(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(DynamicHostProxyProxy.DESCRIPTOR);
        String r104 = getMainDomain();
        r102.writeNoException();
        r102.writeString(r104);
        return true;
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(DynamicHostProxyProxy.DESCRIPTOR);
        List<String> r105 = getMainDomains();
        r102.writeNoException();
        r102.writeList(r105);
        return true;
    L7:
        if (r100 != 3) goto L9;
        r101.enforceInterface(DynamicHostProxyProxy.DESCRIPTOR);
        String r106 = getDocMainDomain();
        r102.writeNoException();
        r102.writeString(r106);
        return true;
    L9:
        if (r100 != 1598968902) goto L11;
        r102.writeString(DynamicHostProxyProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r100, r101, r102, r103);
    }
}
