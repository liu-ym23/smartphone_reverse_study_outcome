package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes23.dex */
public final class zzab extends zza implements IGmsCallbacks {
    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int r100, Bundle r101) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int r100, IBinder r101, zzk r102) throws RemoteException {
        throw null;
    }

    public zzab(IBinder r100) {
        super(r100, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int r100, IBinder r101, Bundle r102) throws RemoteException {
        Parcel r103 = zza();
        r103.writeInt(r100);
        r103.writeStrongBinder(r101);
        com.google.android.gms.internal.common.h.c(r103, r102);
        zzC(1, r103);
    }
}
