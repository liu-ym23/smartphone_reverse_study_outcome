package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoStableFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEVideoStableFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f455820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f455821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f455822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f455823d;

    public class a implements Parcelable.Creator<VEVideoStableFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoStableFilterParam createFromParcel(Parcel r100) {
            return new VEVideoStableFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoStableFilterParam[] newArray(int r100) {
            return new VEVideoStableFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final String toString() {
        return "VEVideoStableFilterParam{ptsMatrix=" + this.f455820a + ", videoStabMatrix='" + this.f455821b + "', filterType=" + this.filterType + "', filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + "', width=" + this.f455822c + "', height=" + this.f455823d + "'}";
    }

    public VEVideoStableFilterParam() {
        this.filterName = "video stable filter";
        this.filterType = 27;
        this.filterDurationType = 1;
        this.f455820a = "";
        this.f455821b = "";
        this.f455822c = 0;
        this.f455823d = 0;
    }

    public VEVideoStableFilterParam(Parcel r100) {
        super(r100);
        this.f455820a = r100.readString();
        this.f455821b = r100.readString();
        this.f455822c = r100.readInt();
        this.f455823d = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f455820a);
        r100.writeString(this.f455821b);
        r100.writeInt(this.f455822c);
        r100.writeInt(this.f455823d);
    }
}
