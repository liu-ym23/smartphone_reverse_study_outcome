package com.ss.android.lark.image.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.image.entity.EncryptImageData;

/* JADX INFO: loaded from: classes36.dex */
public final class UploadEncryptImageCallbackStub extends Binder implements IInterface, IImageManisService.a {
    public final IImageManisService.a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public UploadEncryptImageCallbackStub(IImageManisService.a r100) {
        this.base = r100;
        attachInterface(this, UploadEncryptImageCallbackProxy.DESCRIPTOR);
    }

    public static UploadEncryptImageCallbackProxy asInterface(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        if (r101 == null) goto L12;
        if ((r101 instanceof UploadEncryptImageCallbackProxy) == false) goto L12;
        return (UploadEncryptImageCallbackProxy) r101;
    L12:
        return new UploadEncryptImageCallbackProxy(r100);
    }

    @Override // com.ss.android.lark.image.service.IImageManisService.a
    public void onError(ErrorResultWrapper r100) {
        this.base.onError(r100);
    }

    @Override // com.ss.android.lark.image.service.IImageManisService.a
    public void onSuccess(EncryptImageData r100) {
        this.base.onSuccess(r100);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        EncryptImageData r104 = null;
        ErrorResultWrapper r105 = null;
        if (r100 != 1) goto L5;
        r101.enforceInterface(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        if (r101.readInt() == 0) goto L20;
        r104 = EncryptImageData.CREATOR.createFromParcel(r101);
    L20:
        onSuccess(r104);
        r102.writeNoException();
        return true;
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        if (r101.readInt() == 0) goto L15;
        r105 = ErrorResultWrapper.CREATOR.createFromParcel(r101);
    L15:
        onError(r105);
        r102.writeNoException();
        return true;
    L7:
        if (r100 != 1598968902) goto L9;
        r102.writeString(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r100, r101, r102, r103);
    }
}
