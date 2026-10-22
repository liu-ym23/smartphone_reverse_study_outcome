package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes23.dex */
public final class zzx extends zza implements ICancelToken {
    @Override // com.google.android.gms.common.internal.ICancelToken
    public final void cancel() throws RemoteException {
        zzD(2, zza());
    }

    public zzx(IBinder r100) {
        super(r100, "com.google.android.gms.common.internal.ICancelToken");
    }
}
