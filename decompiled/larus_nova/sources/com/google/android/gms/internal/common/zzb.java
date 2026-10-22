package com.google.android.gms.internal.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes23.dex */
public class zzb extends Binder implements IInterface {
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    public boolean zza(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        return false;
    }

    public zzb(String r100) {
        attachInterface(this, r100);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 > 16777215) goto L5;
        r101.enforceInterface(getInterfaceDescriptor());
    L10:
        return zza(r100, r101, r102, r103);
    L5:
        if (super.onTransact(r100, r101, r102, r103) == false) goto L10;
        return true;
    }
}
