package com.ss.android.lark.image.service;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.image.impl.ImageManisService;

/* JADX INFO: loaded from: classes36.dex */
public final class IImageManisServiceStub extends Binder implements IInterface, IImageManisService {
    public final ImageManisService base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IImageManisServiceStub(Context r100) {
        this.base = new ImageManisService(r100);
        attachInterface(this, IImageManisServiceProxy.DESCRIPTOR);
    }

    public static IImageManisServiceProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(IImageManisServiceProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof IImageManisServiceProxy) == false) goto L12;
        return (IImageManisServiceProxy) r102;
    L12:
        return new IImageManisServiceProxy(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IImageManisServiceProxy.DESCRIPTOR);
        String r104 = r101.readString();
        boolean r105 = false;
        if (r101.readInt() != 0) goto L13;
        boolean r106 = false;
    L15:
        if (r101.readInt() == 0) goto L18;
        r105 = true;
    L18:
        uploadEncryptImage(r104, r106, r105, UploadEncryptImageCallbackStub.asInterface(r101.readStrongBinder()));
        r102.writeNoException();
        return true;
    L13:
        r106 = true;
        goto L15
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString(IImageManisServiceProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.image.service.IImageManisService
    public void uploadEncryptImage(String r100, boolean r101, boolean r102, IImageManisService.a r103) {
        this.base.uploadEncryptImage(r100, r101, r102, r103);
    }
}
