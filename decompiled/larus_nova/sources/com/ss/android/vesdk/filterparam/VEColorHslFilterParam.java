package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class VEColorHslFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEColorHslFilterParam> CREATOR = null;
    public ArrayList<HslParam> hslParamArrayList;
    public int type;
    public int version;

    public class a implements Parcelable.Creator<VEColorHslFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEColorHslFilterParam createFromParcel(Parcel r100) {
            return new VEColorHslFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEColorHslFilterParam[] newArray(int r100) {
            return new VEColorHslFilterParam[r100];
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
        return "VEColorHslFilterParam{, version = " + this.version + "]', type = " + this.type + "]'}";
    }

    public VEColorHslFilterParam() {
        this.filterName = "color_adjust_hsl";
        this.filterType = 36;
        this.filterDurationType = 1;
        this.hslParamArrayList = new ArrayList();
        this.version = 1;
        this.type = 0;
    }

    public VEColorHslFilterParam(Parcel r100) {
        super(r100);
        this.version = r100.readInt();
        this.type = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.version);
        r100.writeInt(this.type);
    }
}
