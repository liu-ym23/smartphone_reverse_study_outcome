package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f274522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f274523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f274524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f274525e;

    static {
        CREATOR = new f();
    }

    public RootTelemetryConfiguration(int r100, boolean r101, boolean r102, int r103, int r104) {
        this.f274521a = r100;
        this.f274522b = r101;
        this.f274523c = r102;
        this.f274524d = r103;
        this.f274525e = r104;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeInt(r100, 1, this.f274521a);
        SafeParcelWriter.writeBoolean(r100, 2, this.f274522b);
        SafeParcelWriter.writeBoolean(r100, 3, this.f274523c);
        SafeParcelWriter.writeInt(r100, 4, this.f274524d);
        SafeParcelWriter.writeInt(r100, 5, this.f274525e);
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }
}
