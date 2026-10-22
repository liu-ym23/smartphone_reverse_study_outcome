package com.google.android.gms.internal.common;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
final class zzaf extends zzag {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    final transient int f274655zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    final transient int f274656zzb;
    final /* synthetic */ zzag zzc;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f274656zzb;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzb() {
        return (this.zzc.zzc() + this.f274655zza) + this.f274656zzb;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        return this.zzc.zzc() + this.f274655zza;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.common.zzac
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // java.util.List
    public final Object get(int r100) {
        m.a(r100, this.f274656zzb);
        return this.zzc.get(r100 + this.f274655zza);
    }

    @Override // com.google.android.gms.internal.common.zzag, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int r100, int r101) {
        return zzh(r100, r101);
    }

    @Override // com.google.android.gms.internal.common.zzag
    public final zzag zzh(int r100, int r101) {
        m.b(r100, r101, this.f274656zzb);
        int r102 = this.f274655zza;
        return this.zzc.zzh(r100 + r102, r101 + r102);
    }

    public zzaf(zzag r100, int r101, int r102) {
        this.zzc = r100;
        this.f274655zza = r101;
        this.f274656zzb = r102;
    }
}
