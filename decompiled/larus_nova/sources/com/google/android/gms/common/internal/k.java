package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes23.dex */
public final class k extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f274546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f274547h;

    @Override // com.google.android.gms.common.internal.c
    public final boolean f() {
        IBinder r100 = this.f274546g;     // Catch: RemoteException -> L19
        Preconditions.checkNotNull(r100);     // Catch: RemoteException -> L19
        String r101 = r100.getInterfaceDescriptor();     // Catch: RemoteException -> L19
        if (this.f274547h.getServiceDescriptor().equals(r101) == true) goto L8;
        this.f274547h.getServiceDescriptor();
        return false;
    L8:
        IInterface r102 = this.f274547h.createServiceInterface(this.f274546g);
        if (r102 != null) goto L11;
        return false;
    L11:
        if (BaseGmsClient.zzn(this.f274547h, 2, 4, r102) == false) goto L13;
    L14:
        BaseGmsClient.zzg(this.f274547h, null);
        BaseGmsClient r103 = this.f274547h;
        Bundle r104 = r103.getConnectionHint();
        if (BaseGmsClient.zzb(r103) == null) goto L17;
        BaseGmsClient.zzb(this.f274547h).onConnected(r104);
    L17:
        return true;
    L13:
        if (BaseGmsClient.zzn(this.f274547h, 3, 4, r102) == true) goto L14;
        return false;
    L24:
        return false;
    }

    @Override // com.google.android.gms.common.internal.c
    public final void e(ConnectionResult r100) {
        if (BaseGmsClient.zzc(this.f274547h) == null) goto L5;
        BaseGmsClient.zzc(this.f274547h).onConnectionFailed(r100);
    L5:
        this.f274547h.onConnectionFailed(r100);
    }

    public k(BaseGmsClient r100, int r101, IBinder r102, Bundle r103) {
        this.f274547h = r100;
        super(r100, r101, r103);
        this.f274546g = r102;
    }
}
