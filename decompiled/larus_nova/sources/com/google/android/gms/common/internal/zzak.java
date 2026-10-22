package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274573a;

    static {
        CREATOR = new g();
    }

    public zzak(int r100) {
        this.f274573a = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = this.f274573a;
        int r103 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeInt(r100, 1, r102);
        SafeParcelWriter.finishObjectHeader(r100, r103);
    }
}
