package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes23.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int r100, IBinder r101, Bundle r102) throws RemoteException;

    void zzb(int r100, Bundle r101) throws RemoteException;

    void zzc(int r100, IBinder r101, zzk r102) throws RemoteException;
}
