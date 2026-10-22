package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = null;

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final String f274455zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final int f274456zzb;
    private final long zzc;

    static {
        CREATOR = new b();
    }

    public Feature(String r100, int r101, long r102) {
        this.f274455zza = r100;
        this.f274456zzb = r101;
        this.zzc = r102;
    }

    public Feature(String r100, long r101) {
        this.f274455zza = r100;
        this.zzc = r101;
        this.f274456zzb = -1;
    }

    public String getName() {
        return this.f274455zza;
    }

    public long getVersion() {
        long r100 = this.zzc;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.f274456zzb;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{getName(), Long.valueOf(getVersion())});
    }

    public final String toString() {
        Objects.ToStringHelper r100 = Objects.toStringHelper(this);
        r100.add("name", getName());
        r100.add("version", Long.valueOf(getVersion()));
        return r100.toString();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof Feature) == false) goto L16;
        Feature r101 = (Feature) r100;
        if (getName() == null) goto L9;
        if (getName().equals(r101.getName()) == false) goto L9;
    L13:
        if (getVersion() != r101.getVersion()) goto L16;
        return true;
    L9:
        if (getName() != null) goto L16;
        if (r101.getName() == null) goto L13;
    L16:
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeString(r100, 1, getName(), false);
        SafeParcelWriter.writeInt(r100, 2, this.f274456zzb);
        SafeParcelWriter.writeLong(r100, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }
}
