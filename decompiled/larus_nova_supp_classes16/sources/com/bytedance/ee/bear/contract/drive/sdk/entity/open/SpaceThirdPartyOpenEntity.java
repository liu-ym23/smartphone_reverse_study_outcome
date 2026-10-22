package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SpaceThirdPartyOpenEntity extends BaseSpaceOpenEntity {
    public static final Parcelable.Creator<SpaceThirdPartyOpenEntity> CREATOR = null;
    private String docToken;
    private int hostType;
    private int index;

    public class a implements Parcelable.Creator<SpaceThirdPartyOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceThirdPartyOpenEntity createFromParcel(Parcel r2) {
            return new SpaceThirdPartyOpenEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceThirdPartyOpenEntity[] newArray(int r1) {
            return new SpaceThirdPartyOpenEntity[r1];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity
    public String toString() {
        return "SpaceThirdPartyOpenEntity{index=" + this.index + ", docToken='" + b.i(this.docToken) + "', hostType=" + this.hostType + "} " + super.toString();
    }

    public String getDocToken() {
        return this.docToken;
    }

    public int getHostType() {
        return this.hostType;
    }

    public int getIndex() {
        return this.index;
    }

    public SpaceThirdPartyOpenEntity(Parcel r2) {
        super(r2);
        this.index = r2.readInt();
        this.docToken = r2.readString();
        this.hostType = r2.readInt();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity
    public void readFromParcel(Parcel r2) {
        super.readFromParcel(r2);
        this.index = r2.readInt();
        this.docToken = r2.readString();
        this.hostType = r2.readInt();
    }

    public void setDocToken(String r1) {
        this.docToken = r1;
    }

    public void setHostType(int r1) {
        this.hostType = r1;
    }

    public void setIndex(int r1) {
        this.index = r1;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeInt(this.index);
        r1.writeString(this.docToken);
        r1.writeInt(this.hostType);
    }

    public SpaceThirdPartyOpenEntity(String r1, String r2, String r3) {
        super(r1, r2, r3);
        setBizType(5);
    }

    public SpaceThirdPartyOpenEntity(String r1, String r2, String r3, DriveBizScene r4, DriveWatermarkScene r5) {
        super(r1, r2, r3);
        setBizType(5);
        setBizScene(r4);
        setWatermarkScene(r5);
    }
}
