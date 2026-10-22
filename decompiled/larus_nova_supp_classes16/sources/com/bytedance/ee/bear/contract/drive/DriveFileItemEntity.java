package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final DriveFileItemEntity createFromParcel(Parcel r2) {
            return new DriveFileItemEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveFileItemEntity[] newArray(int r1) {
            return new DriveFileItemEntity[r1];
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

    public DriveFileItemEntity(Parcel r2) {
        this.mountNodePoint = "";
        this.mountPoint = "";
        this.extra = "";
        this.name = r2.readString();
        this.objToken = r2.readString();
        this.subType = r2.readString();
        this.url = r2.readString();
        this.mountNodePoint = r2.readString();
        this.mountPoint = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.hasCache = r0;
        this.extra = r2.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setHasCache(boolean r1) {
        this.hasCache = r1;
    }

    public void setMountNodePoint(String r1) {
        this.mountNodePoint = r1;
    }

    public void setMountPoint(String r1) {
        this.mountPoint = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setObjToken(String r1) {
        this.objToken = r1;
    }

    public void setSubType(String r1) {
        this.subType = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.name);
        r1.writeString(this.objToken);
        r1.writeString(this.subType);
        r1.writeString(this.url);
        r1.writeString(this.mountNodePoint);
        r1.writeString(this.mountPoint);
        r1.writeByte(this.hasCache ? 1 : 0);
        r1.writeString(this.extra);
    }
}
