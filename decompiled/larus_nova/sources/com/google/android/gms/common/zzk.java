package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
final class zzk extends zzj {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final byte[] f274617zza;

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzf() {
        return this.f274617zza;
    }

    public zzk(byte[] r100) {
        super(Arrays.copyOfRange(r100, 0, 25));
        this.f274617zza = r100;
    }
}
