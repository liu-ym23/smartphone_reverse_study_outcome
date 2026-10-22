package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import du5.b;

/* JADX INFO: loaded from: classes16.dex */
public class SpaceThirdPartyOpenEntity extends BaseSpaceOpenEntity {
    public static final Parcelable.Creator<SpaceThirdPartyOpenEntity> CREATOR = null;
    private String docToken;
    private int hostType;
    private int index;

    public class a implements Parcelable.Creator<SpaceThirdPartyOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceThirdPartyOpenEntity createFromParcel(Parcel r100) {
            return new SpaceThirdPartyOpenEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceThirdPartyOpenEntity[] newArray(int r100) {
            return new SpaceThirdPartyOpenEntity[r100];
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

    public SpaceThirdPartyOpenEntity(Parcel r100) {
        super(r100);
        this.index = r100.readInt();
        this.docToken = r100.readString();
        this.hostType = r100.readInt();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity
    public void readFromParcel(Parcel r100) {
        super.readFromParcel(r100);
        this.index = r100.readInt();
        this.docToken = r100.readString();
        this.hostType = r100.readInt();
    }

    public void setDocToken(String r100) {
        this.docToken = r100;
    }

    public void setHostType(int r100) {
        this.hostType = r100;
    }

    public void setIndex(int r100) {
        this.index = r100;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.index);
        r100.writeString(this.docToken);
        r100.writeInt(this.hostType);
    }

    public SpaceThirdPartyOpenEntity(String r100, String r101, String r102) {
        super(r100, r101, r102);
        setBizType(5);
    }

    public SpaceThirdPartyOpenEntity(String r100, String r101, String r102, DriveBizScene r103, DriveWatermarkScene r104) {
        super(r100, r101, r102);
        setBizType(5);
        setBizScene(r103);
        setWatermarkScene(r104);
    }
}
