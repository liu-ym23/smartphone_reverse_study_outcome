package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes23.dex */
public final class zzq extends zza {
    public final int zze() throws RemoteException {
        Parcel r100 = zzB(6, zza());
        int r101 = r100.readInt();
        r100.recycle();
        return r101;
    }

    public zzq(IBinder r100) {
        super(r100, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int zzf(IObjectWrapper r100, String r101, boolean r102) throws RemoteException {
        Parcel r103 = zza();
        com.google.android.gms.internal.common.h.d(r103, r100);
        r103.writeString(r101);
        r103.writeInt(r102 ? 1 : 0);
        Parcel r104 = zzB(3, r103);
        int r105 = r104.readInt();
        r104.recycle();
        return r105;
    }

    public final int zzg(IObjectWrapper r100, String r101, boolean r102) throws RemoteException {
        Parcel r103 = zza();
        com.google.android.gms.internal.common.h.d(r103, r100);
        r103.writeString(r101);
        r103.writeInt(r102 ? 1 : 0);
        Parcel r104 = zzB(5, r103);
        int r105 = r104.readInt();
        r104.recycle();
        return r105;
    }

    public final IObjectWrapper zzh(IObjectWrapper r100, String r101, int r102) throws RemoteException {
        Parcel r103 = zza();
        com.google.android.gms.internal.common.h.d(r103, r100);
        r103.writeString(r101);
        r103.writeInt(r102);
        Parcel r104 = zzB(2, r103);
        IObjectWrapper r105 = IObjectWrapper.Stub.asInterface(r104.readStrongBinder());
        r104.recycle();
        return r105;
    }

    public final IObjectWrapper zzj(IObjectWrapper r100, String r101, int r102) throws RemoteException {
        Parcel r103 = zza();
        com.google.android.gms.internal.common.h.d(r103, r100);
        r103.writeString(r101);
        r103.writeInt(r102);
        Parcel r104 = zzB(4, r103);
        IObjectWrapper r105 = IObjectWrapper.Stub.asInterface(r104.readStrongBinder());
        r104.recycle();
        return r105;
    }

    public final IObjectWrapper zzi(IObjectWrapper r100, String r101, int r102, IObjectWrapper r103) throws RemoteException {
        Parcel r104 = zza();
        com.google.android.gms.internal.common.h.d(r104, r100);
        r104.writeString(r101);
        r104.writeInt(r102);
        com.google.android.gms.internal.common.h.d(r104, r103);
        Parcel r105 = zzB(8, r104);
        IObjectWrapper r106 = IObjectWrapper.Stub.asInterface(r105.readStrongBinder());
        r105.recycle();
        return r106;
    }

    public final IObjectWrapper zzk(IObjectWrapper r100, String r101, boolean r102, long r103) throws RemoteException {
        Parcel r104 = zza();
        com.google.android.gms.internal.common.h.d(r104, r100);
        r104.writeString(r101);
        r104.writeInt(r102 ? 1 : 0);
        r104.writeLong(r103);
        Parcel r105 = zzB(7, r104);
        IObjectWrapper r106 = IObjectWrapper.Stub.asInterface(r105.readStrongBinder());
        r105.recycle();
        return r106;
    }
}
