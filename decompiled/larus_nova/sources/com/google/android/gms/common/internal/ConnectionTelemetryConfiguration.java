package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RootTelemetryConfiguration f274497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f274498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f274499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f274500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f274501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f274502f;

    static {
        CREATOR = new o();
    }

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration r100, boolean r101, boolean r102, int[] r103, int r104, int[] r105) {
        this.f274497a = r100;
        this.f274498b = r101;
        this.f274499c = r102;
        this.f274500d = r103;
        this.f274501e = r104;
        this.f274502f = r105;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeParcelable(r100, 1, this.f274497a, r101, false);
        SafeParcelWriter.writeBoolean(r100, 2, this.f274498b);
        SafeParcelWriter.writeBoolean(r100, 3, this.f274499c);
        SafeParcelWriter.writeIntArray(r100, 4, this.f274500d, false);
        SafeParcelWriter.writeInt(r100, 5, this.f274501e);
        SafeParcelWriter.writeIntArray(r100, 6, this.f274502f, false);
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }
}
