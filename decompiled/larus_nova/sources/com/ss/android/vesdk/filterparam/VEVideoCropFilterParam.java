package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoCropFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEVideoCropFilterParam> CREATOR = null;
    public float[] cropNodesCoord;

    public class a implements Parcelable.Creator<VEVideoCropFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoCropFilterParam createFromParcel(Parcel r100) {
            return new VEVideoCropFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoCropFilterParam[] newArray(int r100) {
            return new VEVideoCropFilterParam[r100];
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
        return "VEVideoCropFilterParam{cropNodesCoord=" + Arrays.toString(this.cropNodesCoord) + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEVideoCropFilterParam() {
        this.cropNodesCoord = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.filterName = "crop filter";
        this.filterType = 19;
        this.filterDurationType = 1;
    }

    public VEVideoCropFilterParam(Parcel r100) {
        super(r100);
        this.cropNodesCoord = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.cropNodesCoord = r100.createFloatArray();
    }

    public VEVideoCropFilterParam(float[] r100) {
        this();
        if (r100 == null) goto L6;
        this.cropNodesCoord = r100;
        return;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloatArray(this.cropNodesCoord);
    }
}
