package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes23.dex */
public final class zzr extends zza {
    public zzr(IBinder r100) {
        super(r100, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper zze(IObjectWrapper r100, String r101, int r102, IObjectWrapper r103) throws RemoteException {
        Parcel r104 = zza();
        com.google.android.gms.internal.common.h.d(r104, r100);
        r104.writeString(r101);
        r104.writeInt(r102);
        com.google.android.gms.internal.common.h.d(r104, r103);
        Parcel r105 = zzB(2, r104);
        IObjectWrapper r106 = IObjectWrapper.Stub.asInterface(r105.readStrongBinder());
        r105.recycle();
        return r106;
    }

    public final IObjectWrapper zzf(IObjectWrapper r100, String r101, int r102, IObjectWrapper r103) throws RemoteException {
        Parcel r104 = zza();
        com.google.android.gms.internal.common.h.d(r104, r100);
        r104.writeString(r101);
        r104.writeInt(r102);
        com.google.android.gms.internal.common.h.d(r104, r103);
        Parcel r105 = zzB(3, r104);
        IObjectWrapper r106 = IObjectWrapper.Stub.asInterface(r105.readStrongBinder());
        r105.recycle();
        return r106;
    }
}
