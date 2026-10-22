package com.google.android.gms.common;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
abstract class zzj extends zzz {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final int f274616zza;

    public final int hashCode() {
        return this.f274616zza;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.f274616zza;
    }

    public abstract byte[] zzf();

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(zzf());
    }

    public zzj(byte[] r100) {
        if (r100.length != 25) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101);
        this.f274616zza = Arrays.hashCode(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static byte[] zze(String r100) {
        return r100.getBytes("ISO-8859-1");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r100 instanceof zzaa) == false) goto L15;
        zzaa r101 = (zzaa) r100;     // Catch: RemoteException -> L16
        if (r101.zzc() == this.f274616zza) goto L10;
        return false;
    L10:
        IObjectWrapper r102 = r101.zzd();     // Catch: RemoteException -> L16
        if (r102 != null) goto L13;
        return false;
    L13:
        byte[] r103 = (byte[]) ObjectWrapper.unwrap(r102);     // Catch: RemoteException -> L16
        return Arrays.equals(zzf(), r103);
    }
}
