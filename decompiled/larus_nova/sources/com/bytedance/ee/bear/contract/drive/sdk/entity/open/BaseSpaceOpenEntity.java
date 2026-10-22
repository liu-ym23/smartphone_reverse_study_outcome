package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class BaseSpaceOpenEntity extends BaseOpenEntity {
    public static final Parcelable.Creator<BaseSpaceOpenEntity> CREATOR = null;
    private String businessId;
    private String dataVersion;
    private String mountNodeToken;
    private String mountPoint;
    private String version;

    public class a implements Parcelable.Creator<BaseSpaceOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseSpaceOpenEntity createFromParcel(Parcel r100) {
            return new BaseSpaceOpenEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BaseSpaceOpenEntity[] newArray(int r100) {
            return new BaseSpaceOpenEntity[r100];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public String getMountNodeToken() {
        return this.mountNodeToken;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity
    public String getMountPoint() {
        return this.mountPoint;
    }

    public String getVersion() {
        return this.version;
    }

    public BaseSpaceOpenEntity(Parcel r100) {
        super(r100);
        this.mountNodeToken = "";
        this.mountPoint = "";
        this.businessId = "";
        this.version = "";
        this.dataVersion = "";
        this.mountNodeToken = r100.readString();
        this.mountPoint = r100.readString();
        this.businessId = r100.readString();
        this.version = r100.readString();
        this.dataVersion = r100.readString();
    }

    public void readFromParcel(Parcel r100) {
        this.mountNodeToken = r100.readString();
        this.mountPoint = r100.readString();
        this.businessId = r100.readString();
        this.version = r100.readString();
        this.dataVersion = r100.readString();
    }

    public void setBusinessId(String r100) {
        this.businessId = r100;
    }

    public void setDataVersion(String r100) {
        this.dataVersion = r100;
    }

    public void setMountNodeToken(String r100) {
        this.mountNodeToken = r100;
    }

    public void setMountPoint(String r100) {
        this.mountPoint = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.mountNodeToken);
        r100.writeString(this.mountPoint);
        r100.writeString(this.businessId);
        r100.writeString(this.version);
        r100.writeString(this.dataVersion);
    }

    public BaseSpaceOpenEntity(String r100, String r101, String r102) {
        super(r100, r101, r102, null, null);
        this.mountNodeToken = "";
        this.mountPoint = "";
        this.businessId = "";
        this.version = "";
        this.dataVersion = "";
    }
}
