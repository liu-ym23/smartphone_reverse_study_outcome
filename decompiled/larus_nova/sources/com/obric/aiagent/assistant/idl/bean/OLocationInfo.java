package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OLocationInfo;", "Landroid/os/Parcelable;", "longitude", "", "latitude", "<init>", "(DD)V", "getLongitude", "()D", "getLatitude", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OLocationInfo implements Parcelable {
    public static final Parcelable.Creator<OLocationInfo> CREATOR = null;
    private final double latitude;
    private final double longitude;

    public static final class a implements Parcelable.Creator<OLocationInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OLocationInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new OLocationInfo(r100.readDouble(), r100.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        public final OLocationInfo[] newArray(int r100) {
            return new OLocationInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ OLocationInfo copy$default(OLocationInfo r100, double r101, double r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.longitude;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.latitude;
    L9:
        return r100.copy(r101, r102);
    }

    public final double component1() {
        return this.longitude;
    }

    public final double component2() {
        return this.latitude;
    }

    public final OLocationInfo copy(double r100, double r101) {
        return new OLocationInfo(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OLocationInfo) == true) goto L8;
        return false;
    L8:
        OLocationInfo r101 = (OLocationInfo) r100;
        if (Double.compare(this.longitude, r101.longitude) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.latitude, r101.latitude) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.longitude);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.latitude);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "OLocationInfo(longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeDouble(this.longitude);
        r100.writeDouble(this.latitude);
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public OLocationInfo(double r100, double r101) {
        this.longitude = r100;
        this.latitude = r101;
    }
}
