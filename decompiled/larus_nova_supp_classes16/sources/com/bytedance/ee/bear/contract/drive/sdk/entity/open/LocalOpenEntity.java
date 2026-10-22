package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final LocalOpenEntity createFromParcel(Parcel r2) {
            return new LocalOpenEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LocalOpenEntity[] newArray(int r1) {
            return new LocalOpenEntity[r1];
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

    public LocalOpenEntity(Parcel r2) {
        super(r2);
        this.localFilePath = r2.readString();
        this.fileType = r2.readString();
        this.thirdPartyAppID = r2.readString();
        this.bizContentProviderAuthority = r2.readString();
    }

    public void setBizContentProviderAuthority(String r1) {
        this.bizContentProviderAuthority = r1;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeString(this.localFilePath);
        r1.writeString(this.fileType);
        r1.writeString(this.thirdPartyAppID);
        r1.writeString(this.bizContentProviderAuthority);
    }

    public LocalOpenEntity(String r7, String r8, ArrayList<BaseMoreMenuAction> r9, String r10) {
        super("", "", r7, r8, r9);
        this.localFilePath = r10;
        setBizType(1);
    }

    public LocalOpenEntity(String r7, String r8, String r9, ArrayList<BaseMoreMenuAction> r10, String r11) {
        super("", "", r7, r9, r10);
        this.localFilePath = r11;
        this.fileType = r8;
        setBizType(1);
    }

    public LocalOpenEntity(String r7, String r8, String r9, String r10, String r11, ArrayList<BaseMoreMenuAction> r12, String r13) {
        super(r7, r8, r10, "", r12);
        this.thirdPartyAppID = r9;
        this.fileType = r11;
        this.localFilePath = r13;
        setBizType(1);
    }

    public LocalOpenEntity(String r7, String r8, String r9, String r10, String r11, String r12, ArrayList<BaseMoreMenuAction> r13, String r14) {
        super(r7, r8, r10, r12, r13);
        this.thirdPartyAppID = r9;
        this.fileType = r11;
        this.localFilePath = r14;
        setBizType(1);
    }
}
