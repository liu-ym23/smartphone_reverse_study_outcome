package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f274576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Feature[] f274577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f274578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConnectionTelemetryConfiguration f274579d;

    static {
        CREATOR = new n();
    }

    public zzk(Bundle r100, Feature[] r101, int r102, ConnectionTelemetryConfiguration r103) {
        this.f274576a = r100;
        this.f274577b = r101;
        this.f274578c = r102;
        this.f274579d = r103;
    }

    public zzk() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeBundle(r100, 1, this.f274576a, false);
        SafeParcelWriter.writeTypedArray(r100, 2, this.f274577b, r101, false);
        SafeParcelWriter.writeInt(r100, 3, this.f274578c);
        SafeParcelWriter.writeParcelable(r100, 4, this.f274579d, r101, false);
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }
}
