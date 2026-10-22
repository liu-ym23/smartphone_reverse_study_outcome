package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;

/* JADX INFO: loaded from: classes23.dex */
public abstract class zzac extends zzb implements IGmsCallbacks {
    public zzac() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        int r104 = r101.readInt();
        IBinder r105 = r101.readStrongBinder();
        Bundle r106 = (Bundle) com.google.android.gms.internal.common.h.a(r101, Bundle.CREATOR);
        com.google.android.gms.internal.common.h.b(r101);
        onPostInitComplete(r104, r105, r106);
    L13:
        r102.writeNoException();
        return true;
    L5:
        if (r100 != 2) goto L7;
        int r107 = r101.readInt();
        Bundle r108 = (Bundle) com.google.android.gms.internal.common.h.a(r101, Bundle.CREATOR);
        com.google.android.gms.internal.common.h.b(r101);
        zzb(r107, r108);
        goto L13
    L7:
        if (r100 == 3) goto L10;
        return false;
    L10:
        int r109 = r101.readInt();
        IBinder r110 = r101.readStrongBinder();
        zzk r111 = (zzk) com.google.android.gms.internal.common.h.a(r101, zzk.CREATOR);
        com.google.android.gms.internal.common.h.b(r101);
        zzc(r109, r110, r111);
        goto L13
    }
}
