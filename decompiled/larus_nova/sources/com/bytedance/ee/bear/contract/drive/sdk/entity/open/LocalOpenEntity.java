package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public class LocalOpenEntity extends BaseOpenEntity {
    public static final Parcelable.Creator<LocalOpenEntity> CREATOR = null;
    private String bizContentProviderAuthority;
    private String fileType;
    private String localFilePath;
    private String thirdPartyAppID;

    public class a implements Parcelable.Creator<LocalOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocalOpenEntity createFromParcel(Parcel r100) {
            return new LocalOpenEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LocalOpenEntity[] newArray(int r100) {
            return new LocalOpenEntity[r100];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getBizContentProviderAuthority() {
        return this.bizContentProviderAuthority;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getLocalFilePath() {
        return this.localFilePath;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity
    public String getLocalPath() {
        return this.localFilePath;
    }

    public String getThirdPartyAppID() {
        return this.thirdPartyAppID;
    }

    public LocalOpenEntity(Parcel r100) {
        super(r100);
        this.localFilePath = r100.readString();
        this.fileType = r100.readString();
        this.thirdPartyAppID = r100.readString();
        this.bizContentProviderAuthority = r100.readString();
    }

    public void setBizContentProviderAuthority(String r100) {
        this.bizContentProviderAuthority = r100;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.localFilePath);
        r100.writeString(this.fileType);
        r100.writeString(this.thirdPartyAppID);
        r100.writeString(this.bizContentProviderAuthority);
    }

    public LocalOpenEntity(String r100, String r101, ArrayList<BaseMoreMenuAction> r102, String r110) {
        super("", "", r100, r101, r102);
        this.localFilePath = r110;
        setBizType(1);
    }

    public LocalOpenEntity(String r100, String r101, String r102, ArrayList<BaseMoreMenuAction> r110, String r111) {
        super("", "", r100, r102, r110);
        this.localFilePath = r111;
        this.fileType = r101;
        setBizType(1);
    }

    public LocalOpenEntity(String r100, String r101, String r102, String r110, String r111, ArrayList<BaseMoreMenuAction> r112, String r113) {
        super(r100, r101, r110, "", r112);
        this.thirdPartyAppID = r102;
        this.fileType = r111;
        this.localFilePath = r113;
        setBizType(1);
    }

    public LocalOpenEntity(String r100, String r101, String r102, String r110, String r111, String r112, ArrayList<BaseMoreMenuAction> r113, String r114) {
        super(r100, r101, r110, r112, r113);
        this.thirdPartyAppID = r102;
        this.fileType = r111;
        this.localFilePath = r114;
        setBizType(1);
    }
}
