package com.ss.android.lark.dynamicconfig.interfaces;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.dynamicconfig.service.impl.DynamicManisServiceImpl;

/* JADX INFO: loaded from: classes35.dex */
public final class IDynamicManisServiceStub extends Binder implements IInterface, IDynamicManisService {
    public final DynamicManisServiceImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IDynamicManisServiceStub(Context r100) {
        this.base = new DynamicManisServiceImpl(r100);
        attachInterface(this, IDynamicManisServiceProxy.DESCRIPTOR);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService
    public String getDynamicDomain(String r100) {
        return this.base.getDynamicDomain(r100);
    }

    public static IDynamicManisServiceProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(IDynamicManisServiceProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof IDynamicManisServiceProxy) == false) goto L12;
        return (IDynamicManisServiceProxy) r102;
    L12:
        return new IDynamicManisServiceProxy(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IDynamicManisServiceProxy.DESCRIPTOR);
        String r104 = getDynamicDomain(r101.readString());
        r102.writeNoException();
        r102.writeString(r104);
        return true;
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString(IDynamicManisServiceProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }
}
