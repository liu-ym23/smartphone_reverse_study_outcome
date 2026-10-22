package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes23.dex */
public final class zzw extends zza implements IAccountAccessor {
    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() throws RemoteException {
        Parcel r100 = zzB(2, zza());
        Account r101 = (Account) com.google.android.gms.internal.common.h.a(r100, Account.CREATOR);
        r100.recycle();
        return r101;
    }

    public zzw(IBinder r100) {
        super(r100, "com.google.android.gms.common.internal.IAccountAccessor");
    }
}
