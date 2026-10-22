package com.bytedance.ee.bear.basesdk.apisupport;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.ee.bear.basesdk.SdkManisServiceImpl;

/* JADX INFO: loaded from: classes15.dex */
public final class ISdkManisServiceStub extends Binder implements IInterface, ISdkManisService {
    public final SdkManisServiceImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.ISdkManisService
    public void checkAndInit() {
        this.base.checkAndInit();
    }

    public ISdkManisServiceStub(Context r100) {
        this.base = new SdkManisServiceImpl(r100);
        attachInterface(this, ISdkManisServiceProxy.DESCRIPTOR);
    }

    public static ISdkManisServiceProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(ISdkManisServiceProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof ISdkManisServiceProxy) == false) goto L12;
        return (ISdkManisServiceProxy) r102;
    L12:
        return new ISdkManisServiceProxy(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(ISdkManisServiceProxy.DESCRIPTOR);
        checkAndInit();
        r102.writeNoException();
        return true;
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString(ISdkManisServiceProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }
}
