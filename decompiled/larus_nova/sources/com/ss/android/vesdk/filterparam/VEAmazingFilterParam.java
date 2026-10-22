package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAmazingFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEAmazingFilterParam> CREATOR = null;
    public String algorithmResultDir;
    public int amazingEngineType;
    public int flag;
    public int order;
    public String param;
    public String path;

    public class a implements Parcelable.Creator<VEAmazingFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAmazingFilterParam createFromParcel(Parcel r100) {
            return new VEAmazingFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAmazingFilterParam[] newArray(int r100) {
            return new VEAmazingFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEAmazingFilterParam{order=" + this.order + ", path='" + this.path + "', param='" + this.param + "', amazingEngineType=" + this.amazingEngineType + ", flag =" + this.flag + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + ", algorithmResultDir=" + this.algorithmResultDir + '}';
    }

    public VEAmazingFilterParam() {
        this.filterName = "amzing filter";
        this.filterType = 22;
        this.filterDurationType = 0;
        this.order = 0;
        this.path = "";
        this.param = "";
        this.amazingEngineType = 0;
        this.flag = 0;
        this.algorithmResultDir = "";
    }

    public VEAmazingFilterParam(Parcel r100) {
        super(r100);
        this.order = r100.readInt();
        this.path = r100.readString();
        this.param = r100.readString();
        this.amazingEngineType = r100.readInt();
        this.flag = r100.readInt();
        this.algorithmResultDir = r100.readString();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.order);
        r100.writeString(this.path);
        r100.writeString(this.param);
        r100.writeInt(this.amazingEngineType);
        r100.writeInt(this.flag);
        r100.writeString(this.algorithmResultDir);
    }
}
