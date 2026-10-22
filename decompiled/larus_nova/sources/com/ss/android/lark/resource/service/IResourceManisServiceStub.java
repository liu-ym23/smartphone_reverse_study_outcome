package com.ss.android.lark.resource.service;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.resource.service.impl.ResourceManisServiceImpl;
import com.suite.lark.platform.service.resourcerepository.api.Resource;

/* JADX INFO: loaded from: classes37.dex */
public final class IResourceManisServiceStub extends Binder implements IInterface, IResourceManisService {
    public final ResourceManisServiceImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IResourceManisServiceStub(Context r100) {
        this.base = new ResourceManisServiceImpl(r100);
        attachInterface(this, IResourceManisServiceProxy.DESCRIPTOR);
    }

    public static IResourceManisServiceProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(IResourceManisServiceProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof IResourceManisServiceProxy) == false) goto L12;
        return (IResourceManisServiceProxy) r102;
    L12:
        return new IResourceManisServiceProxy(r100, r101);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public String getAvatarPath(String r100, String r101, int r102, float r103) {
        return this.base.getAvatarPath(r100, r101, r102, r103);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
        if (r110 != 1) goto L5;
        r111.enforceInterface(IResourceManisServiceProxy.DESCRIPTOR);
        String r100 = r111.readString();
        String r101 = r111.readString();
        String r102 = r111.readString();
        String r103 = r111.readString();
        String r104 = r111.readString();
        if (r111.readInt() != 0) goto L28;
        boolean r105 = false;
    L29:
        Resource r114 = getEncryptImage(r100, r101, r102, r103, r104, r105);
        r112.writeNoException();
        if (r114 == null) goto L32;
        r112.writeInt(1);
        r114.writeToParcel(r112, 1);
    L33:
        return true;
    L32:
        r112.writeInt(0);
        goto L33
    L28:
        r105 = true;
        goto L29
    L5:
        if (r110 != 2) goto L7;
        r111.enforceInterface(IResourceManisServiceProxy.DESCRIPTOR);
        String r106 = r111.readString();
        String r107 = r111.readString();
        String r108 = r111.readString();
        String r109 = r111.readString();
        String r115 = r111.readString();
        if (r111.readInt() != 0) goto L19;
        boolean r116 = false;
    L20:
        Resource r117 = getEncryptImage(r106, r107, r108, r109, r115, r116, r111.readInt());
        r112.writeNoException();
        if (r117 == null) goto L23;
        r112.writeInt(1);
        r117.writeToParcel(r112, 1);
    L24:
        return true;
    L23:
        r112.writeInt(0);
        goto L24
    L19:
        r116 = true;
        goto L20
    L7:
        if (r110 != 3) goto L9;
        r111.enforceInterface(IResourceManisServiceProxy.DESCRIPTOR);
        String r118 = getAvatarPath(r111.readString(), r111.readString(), r111.readInt(), r111.readFloat());
        r112.writeNoException();
        r112.writeString(r118);
        return true;
    L9:
        if (r110 != 1598968902) goto L11;
        r112.writeString(IResourceManisServiceProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r110, r111, r112, r113);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r100, String r101, String r110, String r111, String r112, boolean r113) {
        return this.base.getEncryptImage(r100, r101, r110, r111, r112, r113);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r100, String r110, String r111, String r112, String r113, boolean r114, int r115) {
        return this.base.getEncryptImage(r100, r110, r111, r112, r113, r114, r115);
    }
}
