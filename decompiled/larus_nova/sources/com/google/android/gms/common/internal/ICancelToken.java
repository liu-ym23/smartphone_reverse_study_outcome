package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;

/* JADX INFO: loaded from: classes23.dex */
public interface ICancelToken extends IInterface {

    public static abstract class Stub extends zzb implements ICancelToken {
        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        public static ICancelToken asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if ((r101 instanceof ICancelToken) == false) goto L10;
            return (ICancelToken) r101;
        L10:
            return new zzx(r100);
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 2) goto L6;
            cancel();
            return true;
        L6:
            return false;
        }
    }

    void cancel() throws RemoteException;
}
