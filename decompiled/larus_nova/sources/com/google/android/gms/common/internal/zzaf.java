package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zzb;

/* JADX INFO: loaded from: classes23.dex */
public abstract class zzaf extends zzb implements zzag {
    public static zzag zzb(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if ((r101 instanceof zzag) == false) goto L10;
        return (zzag) r101;
    L10:
        return new zzae(r100);
    }
}
