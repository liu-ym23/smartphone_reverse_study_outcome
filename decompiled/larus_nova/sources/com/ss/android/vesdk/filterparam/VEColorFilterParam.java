package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEColorFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEColorFilterParam> CREATOR = null;
    public float intensity;
    public String leftFilterPath;
    public float position;
    public String rightFilterPath;
    public float rightIntensity;
    public boolean useFilterResIntensity;
    public boolean useFilterV3;

    public class a implements Parcelable.Creator<VEColorFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEColorFilterParam createFromParcel(Parcel r100) {
            return new VEColorFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEColorFilterParam[] newArray(int r100) {
            return new VEColorFilterParam[r100];
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
        return "VEColorFilterParam{leftFilterPath='" + this.leftFilterPath + "', rightFilterPath='" + this.rightFilterPath + "', position=" + this.position + ", intensity=" + this.intensity + ", rightIntensity=" + this.rightIntensity + ", useFilterResIntensity=" + this.useFilterResIntensity + ", useFilterV3=" + this.useFilterV3 + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEColorFilterParam() {
        this.filterName = "color filter";
        this.filterType = 7;
        this.filterDurationType = 1;
        this.leftFilterPath = "";
        this.rightFilterPath = "";
        this.position = 1.0f;
        this.intensity = 1.0f;
        this.rightIntensity = 1.0f;
        this.useFilterResIntensity = false;
        this.useFilterV3 = false;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setString("left filter", this.leftFilterPath);
        r100.setString("right filter", this.rightFilterPath);
        r100.setFloat("left filter intensity", this.intensity);
        r100.setFloat("right filter intensity", this.rightIntensity);
        r100.setBool("use filter res intensity", this.useFilterResIntensity);
        r100.setBool("filter use v3", this.useFilterV3);
        r100.setFloat("filter position", this.position);
        return r100;
    }

    public VEColorFilterParam(Parcel r100) {
        super(r100);
        this.leftFilterPath = r100.readString();
        this.rightFilterPath = r100.readString();
        this.position = r100.readFloat();
        this.intensity = r100.readFloat();
        this.rightIntensity = r100.readFloat();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.useFilterResIntensity = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.useFilterV3 = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.leftFilterPath);
        r100.writeString(this.rightFilterPath);
        r100.writeFloat(this.position);
        r100.writeFloat(this.intensity);
        r100.writeFloat(this.rightIntensity);
        r100.writeByte(this.useFilterResIntensity ? 1 : 0);
        r100.writeByte(this.useFilterV3 ? 1 : 0);
    }
}
