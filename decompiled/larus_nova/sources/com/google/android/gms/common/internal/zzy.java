package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes23.dex */
public final class zzy extends zza implements zzaa {
    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() throws RemoteException {
        Parcel r100 = zzB(2, zza());
        int r101 = r100.readInt();
        r100.recycle();
        return r101;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() throws RemoteException {
        Parcel r100 = zzB(1, zza());
        IObjectWrapper r101 = IObjectWrapper.Stub.asInterface(r100.readStrongBinder());
        r100.recycle();
        return r101;
    }

    public zzy(IBinder r100) {
        super(r100, "com.google.android.gms.common.internal.ICertData");
    }
}
