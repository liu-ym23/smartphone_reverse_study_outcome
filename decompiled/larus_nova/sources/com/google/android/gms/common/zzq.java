package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f274626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f274627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f274628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f274629d;

    static {
        CREATOR = new h();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeBoolean(r100, 1, this.f274626a);
        SafeParcelWriter.writeString(r100, 2, this.f274627b, false);
        SafeParcelWriter.writeInt(r100, 3, this.f274628c);
        SafeParcelWriter.writeInt(r100, 4, this.f274629d);
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }

    public zzq(boolean r100, String r101, int r102, int r103) {
        this.f274626a = r100;
        this.f274627b = r101;
        this.f274628c = l.a(r102) - 1;
        this.f274629d = c.a(r103) - 1;
    }
}
