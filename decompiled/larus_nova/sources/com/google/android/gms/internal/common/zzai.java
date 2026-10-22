package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes23.dex */
@NullMarked
final class zzai extends zzag {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    static final zzag f274658zza = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f274659c;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    final transient Object[] f274660zzb;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f274659c;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzb() {
        return this.f274659c;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] zzg() {
        return this.f274660zzb;
    }

    static {
        f274658zza = new zzai(new Object[0], 0);
    }

    @Override // java.util.List
    public final Object get(int r100) {
        m.a(r100, this.f274659c);
        Object r101 = this.f274660zzb[r100];
        r101.getClass();
        return r101;
    }

    public zzai(Object[] r100, int r101) {
        this.f274660zzb = r100;
        this.f274659c = r101;
    }

    @Override // com.google.android.gms.internal.common.zzag, com.google.android.gms.internal.common.zzac
    public final int zza(Object[] r100, int r101) {
        System.arraycopy(this.f274660zzb, 0, r100, 0, this.f274659c);
        return this.f274659c;
    }
}
