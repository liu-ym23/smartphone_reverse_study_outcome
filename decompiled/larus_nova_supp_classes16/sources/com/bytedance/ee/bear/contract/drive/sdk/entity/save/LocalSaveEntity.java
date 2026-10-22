package com.bytedance.ee.bear.contract.drive.sdk.entity.save;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LocalSaveEntity implements NonProguard, Parcelable {
    public static final Parcelable.Creator<LocalSaveEntity> CREATOR = null;
    private static final String TAG = "LocalSaveEntity";
    private String appId;
    private String authExtra;
    private String bizContentProviderAuthority;
    private String dataVersion;
    private String fileId;
    private String fileName;
    private String fileType;
    private String localFilePath;

    public class a implements Parcelable.Creator<LocalSaveEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocalSaveEntity createFromParcel(Parcel r2) {
            return new LocalSaveEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LocalSaveEntity[] newArray(int r1) {
            return new LocalSaveEntity[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "LocalSaveEntity{appId='" + this.appId + "', fileId='" + b.g(this.fileId) + "', dataVersion='" + this.dataVersion + "', localFilePath='" + this.localFilePath + "', authExtra='" + this.authExtra + "', fileName='" + this.fileName + "', fileType='" + this.fileType + "', bizContentProviderAuthority='" + this.bizContentProviderAuthority + "'}";
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAuthExtra() {
        return this.authExtra;
    }

    public String getBizContentProviderAuthority() {
        return this.bizContentProviderAuthority;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getLocalFilePath() {
        return this.localFilePath;
    }

    public LocalSaveEntity(Parcel r2) {
        this.appId = "";
        this.fileId = "";
        this.dataVersion = "";
        this.authExtra = "";
        this.fileName = "";
        readFromParcel(r2);
    }

    private void readFromParcel(Parcel r2) {
        this.appId = r2.readString();
        this.fileId = r2.readString();
        this.fileName = r2.readString();
        this.dataVersion = r2.readString();
        this.localFilePath = r2.readString();
        this.fileType = r2.readString();
        this.bizContentProviderAuthority = r2.readString();
        this.authExtra = r2.readString();
    }

    public void setAuthExtra(String r1) {
        this.authExtra = r1;
    }

    public void setBizContentProviderAuthority(String r1) {
        this.bizContentProviderAuthority = r1;
    }

    public void setDataVersion(String r1) {
        this.dataVersion = r1;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public void setFileType(String r1) {
        this.fileType = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.appId);
        r1.writeString(this.fileId);
        r1.writeString(this.fileName);
        r1.writeString(this.dataVersion);
        r1.writeString(this.localFilePath);
        r1.writeString(this.fileType);
        r1.writeString(this.bizContentProviderAuthority);
        r1.writeString(this.authExtra);
    }

    public LocalSaveEntity(String r2, String r3, String r4) {
        this.dataVersion = "";
        this.authExtra = "";
        this.fileName = "";
        this.appId = r2;
        this.fileId = r3;
        this.localFilePath = r4;
    }
}
