package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\bJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/GeoFenceRequest;", "Landroid/os/Parcelable;", "fenceId", "", "longitude", "", "latitude", "radius", "", "<init>", "(Ljava/lang/String;DDI)V", "getFenceId", "()Ljava/lang/String;", "getLongitude", "()D", "getLatitude", "getRadius", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GeoFenceRequest implements Parcelable {
    public static final Parcelable.Creator<GeoFenceRequest> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f397092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f397093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f397094d;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<GeoFenceRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GeoFenceRequest createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GeoFenceRequest(r100.readString(), r100.readDouble(), r100.readDouble(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final GeoFenceRequest[] newArray(int r100) {
            return new GeoFenceRequest[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GeoFenceRequest) == true) goto L8;
        return false;
    L8:
        GeoFenceRequest r101 = (GeoFenceRequest) r100;
        if (Intrinsics.areEqual(this.f397091a, r101.f397091a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f397092b, r101.f397092b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f397093c, r101.f397093c) == 0) goto L18;
        return false;
    L18:
        if (this.f397094d == r101.f397094d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397091a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f397092b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f397093c);
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f397094d;
    }

    public final String toString() {
        return "GeoFenceRequest(fenceId=" + this.f397091a + ", longitude=" + this.f397092b + ", latitude=" + this.f397093c + ", radius=" + this.f397094d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397091a);
        r100.writeDouble(this.f397092b);
        r100.writeDouble(this.f397093c);
        r100.writeInt(this.f397094d);
    }

    public GeoFenceRequest(String r100, double r101, double r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "fenceId");
        this.f397091a = r100;
        this.f397092b = r101;
        this.f397093c = r102;
        this.f397094d = r103;
    }
}
