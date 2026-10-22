package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;

/* JADX INFO: loaded from: classes23.dex */
public abstract class zzz extends zzb implements zzaa {
    public zzz() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzaa zzg(IBinder r100) {
        IInterface r101 = r100.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if ((r101 instanceof zzaa) == false) goto L7;
        return (zzaa) r101;
    L7:
        return new zzy(r100);
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        IObjectWrapper r104 = zzd();
        r102.writeNoException();
        com.google.android.gms.internal.common.h.d(r102, r104);
    L10:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    L8:
        int r105 = zzc();
        r102.writeNoException();
        r102.writeInt(r105);
        goto L10
    }
}
