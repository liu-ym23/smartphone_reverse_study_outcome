package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class DriveFileItemEntity implements Parcelable, NonProguard {
    public static final Parcelable.Creator<DriveFileItemEntity> CREATOR = null;
    private String extra;
    private boolean hasCache;
    private String mountNodePoint;
    private String mountPoint;
    private String name;
    private String objToken;
    private String subType;
    private String url;

    public class a implements Parcelable.Creator<DriveFileItemEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveFileItemEntity createFromParcel(Parcel r100) {
            return new DriveFileItemEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveFileItemEntity[] newArray(int r100) {
            return new DriveFileItemEntity[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public DriveFileItemEntity() {
        this.mountNodePoint = "";
        this.mountPoint = "";
        this.extra = "";
    }

    public String getExtra() {
        return this.extra;
    }

    public String getMountNodePoint() {
        return this.mountNodePoint;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public String getName() {
        return this.name;
    }

    public String getObjToken() {
        return this.objToken;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isHasCache() {
        return this.hasCache;
    }

    public DriveFileItemEntity(Parcel r100) {
        this.mountNodePoint = "";
        this.mountPoint = "";
        this.extra = "";
        this.name = r100.readString();
        this.objToken = r100.readString();
        this.subType = r100.readString();
        this.url = r100.readString();
        this.mountNodePoint = r100.readString();
        this.mountPoint = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.hasCache = r101;
        this.extra = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setHasCache(boolean r100) {
        this.hasCache = r100;
    }

    public void setMountNodePoint(String r100) {
        this.mountNodePoint = r100;
    }

    public void setMountPoint(String r100) {
        this.mountPoint = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setObjToken(String r100) {
        this.objToken = r100;
    }

    public void setSubType(String r100) {
        this.subType = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.name);
        r100.writeString(this.objToken);
        r100.writeString(this.subType);
        r100.writeString(this.url);
        r100.writeString(this.mountNodePoint);
        r100.writeString(this.mountPoint);
        r100.writeByte(this.hasCache ? 1 : 0);
        r100.writeString(this.extra);
    }
}
