package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final BaseSpaceOpenEntity createFromParcel(Parcel r2) {
            return new BaseSpaceOpenEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BaseSpaceOpenEntity[] newArray(int r1) {
            return new BaseSpaceOpenEntity[r1];
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

    public BaseSpaceOpenEntity(Parcel r2) {
        super(r2);
        this.mountNodeToken = "";
        this.mountPoint = "";
        this.businessId = "";
        this.version = "";
        this.dataVersion = "";
        this.mountNodeToken = r2.readString();
        this.mountPoint = r2.readString();
        this.businessId = r2.readString();
        this.version = r2.readString();
        this.dataVersion = r2.readString();
    }

    public void readFromParcel(Parcel r2) {
        this.mountNodeToken = r2.readString();
        this.mountPoint = r2.readString();
        this.businessId = r2.readString();
        this.version = r2.readString();
        this.dataVersion = r2.readString();
    }

    public void setBusinessId(String r1) {
        this.businessId = r1;
    }

    public void setDataVersion(String r1) {
        this.dataVersion = r1;
    }

    public void setMountNodeToken(String r1) {
        this.mountNodeToken = r1;
    }

    public void setMountPoint(String r1) {
        this.mountPoint = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeString(this.mountNodeToken);
        r1.writeString(this.mountPoint);
        r1.writeString(this.businessId);
        r1.writeString(this.version);
        r1.writeString(this.dataVersion);
    }

    public BaseSpaceOpenEntity(String r7, String r8, String r9) {
        super(r7, r8, r9, null, null);
        this.mountNodeToken = "";
        this.mountPoint = "";
        this.businessId = "";
        this.version = "";
        this.dataVersion = "";
    }
}
