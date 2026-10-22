package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;

/* JADX INFO: loaded from: classes23.dex */
public interface IAccountAccessor extends IInterface {

    public static abstract class Stub extends zzb implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        public static IAccountAccessor asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if ((r101 instanceof IAccountAccessor) == false) goto L10;
            return (IAccountAccessor) r101;
        L10:
            return new zzw(r100);
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 2) goto L9;
            Account r104 = zzb();
            r102.writeNoException();
            int r105 = com.google.android.gms.internal.common.h.f274647a;
            if (r104 != null) goto L7;
            r102.writeInt(0);
        L8:
            return true;
        L7:
            r102.writeInt(1);
            r104.writeToParcel(r102, 1);
            goto L8
        L9:
            return false;
        }
    }

    Account zzb() throws RemoteException;
}
