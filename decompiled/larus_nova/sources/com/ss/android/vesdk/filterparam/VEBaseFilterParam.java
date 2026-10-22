package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.vesdk.j0;

/* JADX INFO: loaded from: classes40.dex */
public class VEBaseFilterParam implements Parcelable {
    public static final Parcelable.Creator<VEBaseFilterParam> CREATOR = null;
    public j0 callback;
    public int filterDurationType;
    public String filterName;
    public int filterType;
    public int renderType;

    public class a implements Parcelable.Creator<VEBaseFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEBaseFilterParam createFromParcel(Parcel r100) {
            return new VEBaseFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEBaseFilterParam[] newArray(int r100) {
            return new VEBaseFilterParam[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "VEBaseFilterParam{filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + ", filterEngineType = " + this.renderType + '}';
    }

    public VEBaseFilterParam() {
        this.filterDurationType = 0;
        this.renderType = 0;
    }

    public TEBundle getBundle() {
        TEBundle r100 = TEBundle.obtain();
        r100.setString("FilterName", this.filterName);
        r100.setInt("FilterType", this.filterType);
        r100.setInt("FilterDurType", this.filterDurationType);
        return r100;
    }

    public VEBaseFilterParam(Parcel r100) {
        this.filterDurationType = 0;
        this.renderType = 0;
        this.filterType = r100.readInt();
        this.filterName = r100.readString();
        this.filterDurationType = r100.readInt();
        this.renderType = r100.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.filterType);
        r100.writeString(this.filterName);
        r100.writeInt(this.filterDurationType);
        r100.writeInt(this.renderType);
    }
}
