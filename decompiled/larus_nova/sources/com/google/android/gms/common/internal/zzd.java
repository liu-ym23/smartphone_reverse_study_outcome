package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes23.dex */
public final class zzd extends zzac {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private BaseGmsClient f274574zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final int f274575zzb;

    public zzd(BaseGmsClient r100, int r101) {
        this.f274574zza = r100;
        this.f274575zzb = r101;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int r100, Bundle r101) {
        new Exception();
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int r100, IBinder r101, Bundle r102) {
        Preconditions.checkNotNull(this.f274574zza, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f274574zza.onPostInitHandler(r100, r101, r102, this.f274575zzb);
        this.f274574zza = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int r100, IBinder r101, zzk r102) {
        BaseGmsClient r103 = this.f274574zza;
        Preconditions.checkNotNull(r103, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(r102);
        BaseGmsClient.zzj(r103, r102);
        onPostInitComplete(r100, r101, r102.f274576a);
    }
}
