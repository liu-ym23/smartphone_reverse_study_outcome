package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEImageAddFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEImageAddFilterParam> CREATOR = null;
    public float height;
    public String imagePath;
    public float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f455778x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f455779y;

    public class a implements Parcelable.Creator<VEImageAddFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEImageAddFilterParam createFromParcel(Parcel r100) {
            return new VEImageAddFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEImageAddFilterParam[] newArray(int r100) {
            return new VEImageAddFilterParam[r100];
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
        return "VEImageAddFilterParam{imagePath='" + this.imagePath + "', x=" + this.f455778x + ", y=" + this.f455779y + ", width=" + this.width + ", height=" + this.height + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEImageAddFilterParam() {
        this.filterName = "image add filter";
        this.filterType = 21;
        this.imagePath = "";
        this.f455778x = 0.0f;
        this.f455779y = 0.0f;
        this.width = 0.0f;
    }

    public VEImageAddFilterParam(Parcel r100) {
        super(r100);
        this.imagePath = r100.readString();
        this.f455778x = r100.readFloat();
        this.f455779y = r100.readFloat();
        this.width = r100.readFloat();
        this.height = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.imagePath);
        r100.writeFloat(this.f455778x);
        r100.writeFloat(this.f455779y);
        r100.writeFloat(this.width);
        r100.writeFloat(this.height);
    }
}
