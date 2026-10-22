package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes23.dex */
public final class zzae extends zza implements zzag {
    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzi() throws RemoteException {
        Parcel r100 = zzB(7, zza());
        int r101 = com.google.android.gms.internal.common.h.f274647a;
        if (r100.readInt() == 0) goto L5;
        boolean r102 = true;
    L6:
        r100.recycle();
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzg() throws RemoteException {
        Parcel r100 = zzB(9, zza());
        int r101 = com.google.android.gms.internal.common.h.f274647a;
        if (r100.readInt() == 0) goto L5;
        boolean r102 = true;
    L6:
        r100.recycle();
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    public zzae(IBinder r100) {
        super(r100, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final zzq zze(zzo r100) throws RemoteException {
        Parcel r101 = zza();
        com.google.android.gms.internal.common.h.c(r101, r100);
        Parcel r102 = zzB(6, r101);
        zzq r103 = (zzq) com.google.android.gms.internal.common.h.a(r102, zzq.CREATOR);
        r102.recycle();
        return r103;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final zzq zzf(zzo r100) throws RemoteException {
        Parcel r101 = zza();
        com.google.android.gms.internal.common.h.c(r101, r100);
        Parcel r102 = zzB(8, r101);
        zzq r103 = (zzq) com.google.android.gms.internal.common.h.a(r102, zzq.CREATOR);
        r102.recycle();
        return r103;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzh(zzs r100, IObjectWrapper r101) throws RemoteException {
        Parcel r102 = zza();
        com.google.android.gms.internal.common.h.c(r102, r100);
        com.google.android.gms.internal.common.h.d(r102, r101);
        Parcel r103 = zzB(5, r102);
        if (r103.readInt() == 0) goto L5;
        boolean r104 = true;
    L6:
        r103.recycle();
        return r104;
    L5:
        r104 = false;
        goto L6
    }
}
