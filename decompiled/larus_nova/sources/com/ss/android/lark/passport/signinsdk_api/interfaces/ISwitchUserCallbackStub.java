package com.ss.android.lark.passport.signinsdk_api.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.passport.signinsdk_api.entity.SessionResult;

/* JADX INFO: loaded from: classes37.dex */
public final class ISwitchUserCallbackStub extends Binder implements IInterface, ILoginManisService.a {
    public final ILoginManisService.a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public ISwitchUserCallbackStub(ILoginManisService.a r100) {
        this.base = r100;
        attachInterface(this, ISwitchUserCallbackProxy.DESCRIPTOR);
    }

    public static ISwitchUserCallbackProxy asInterface(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface(ISwitchUserCallbackProxy.DESCRIPTOR);
        if (r101 == null) goto L12;
        if ((r101 instanceof ISwitchUserCallbackProxy) == false) goto L12;
        return (ISwitchUserCallbackProxy) r101;
    L12:
        return new ISwitchUserCallbackProxy(r100);
    }

    @Override // com.ss.android.lark.passport.signinsdk_api.interfaces.ILoginManisService.a
    public void onSuccess(SessionResult r100) {
        this.base.onSuccess(r100);
    }

    @Override // com.ss.android.lark.passport.signinsdk_api.interfaces.ILoginManisService.a
    public void onError(int r100, String r101) {
        this.base.onError(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(ISwitchUserCallbackProxy.DESCRIPTOR);
        if (r101.readInt() == 0) goto L17;
        SessionResult r104 = SessionResult.CREATOR.createFromParcel(r101);
    L18:
        onSuccess(r104);
        r102.writeNoException();
        return true;
    L17:
        r104 = null;
        goto L18
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(ISwitchUserCallbackProxy.DESCRIPTOR);
        onError(r101.readInt(), r101.readString());
        r102.writeNoException();
        return true;
    L7:
        if (r100 != 1598968902) goto L9;
        r102.writeString(ISwitchUserCallbackProxy.DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r100, r101, r102, r103);
    }
}
