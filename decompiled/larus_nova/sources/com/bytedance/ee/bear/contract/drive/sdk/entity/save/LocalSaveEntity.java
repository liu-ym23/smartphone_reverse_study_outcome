package com.bytedance.ee.bear.contract.drive.sdk.entity.save;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;

/* JADX INFO: loaded from: classes16.dex */
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
        public final LocalSaveEntity createFromParcel(Parcel r100) {
            return new LocalSaveEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LocalSaveEntity[] newArray(int r100) {
            return new LocalSaveEntity[r100];
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

    public LocalSaveEntity(Parcel r100) {
        this.appId = "";
        this.fileId = "";
        this.dataVersion = "";
        this.authExtra = "";
        this.fileName = "";
        readFromParcel(r100);
    }

    private void readFromParcel(Parcel r100) {
        this.appId = r100.readString();
        this.fileId = r100.readString();
        this.fileName = r100.readString();
        this.dataVersion = r100.readString();
        this.localFilePath = r100.readString();
        this.fileType = r100.readString();
        this.bizContentProviderAuthority = r100.readString();
        this.authExtra = r100.readString();
    }

    public void setAuthExtra(String r100) {
        this.authExtra = r100;
    }

    public void setBizContentProviderAuthority(String r100) {
        this.bizContentProviderAuthority = r100;
    }

    public void setDataVersion(String r100) {
        this.dataVersion = r100;
    }

    public void setFileName(String r100) {
        this.fileName = r100;
    }

    public void setFileType(String r100) {
        this.fileType = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.appId);
        r100.writeString(this.fileId);
        r100.writeString(this.fileName);
        r100.writeString(this.dataVersion);
        r100.writeString(this.localFilePath);
        r100.writeString(this.fileType);
        r100.writeString(this.bizContentProviderAuthority);
        r100.writeString(this.authExtra);
    }

    public LocalSaveEntity(String r100, String r101, String r102) {
        this.dataVersion = "";
        this.authExtra = "";
        this.fileName = "";
        this.appId = r100;
        this.fileId = r101;
        this.localFilePath = r102;
    }
}
