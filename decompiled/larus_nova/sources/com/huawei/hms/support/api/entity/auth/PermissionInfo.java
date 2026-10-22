package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class PermissionInfo implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = null;

    @Packed
    private String appID;

    @Packed
    private String packageName;

    @Packed
    private String permission;

    public class a implements Parcelable.Creator<PermissionInfo> {
        public a() {
        }

        public PermissionInfo a(Parcel r100) {
            return new PermissionInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PermissionInfo createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PermissionInfo[] newArray(int r100) {
            return a(r100);
        }

        public PermissionInfo[] a(int r100) {
            return new PermissionInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.appID, this.packageName, this.permission});
    }

    static {
        CREATOR = new a();
    }

    public PermissionInfo() {
    }

    public String getAppID() {
        return this.appID;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPermission() {
        return this.permission;
    }

    public PermissionInfo(Parcel r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        this.appID = r100.readString();
        this.packageName = r100.readString();
        this.permission = r100.readString();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PermissionInfo) == true) goto L8;
        return false;
    L8:
        PermissionInfo r101 = (PermissionInfo) r100;
        if (Objects.equal(this.appID, r101.appID) == true) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equal(this.packageName, r101.packageName) == false) goto L15;
        if (Objects.equal(this.permission, r101.permission) == false) goto L15;
        return true;
    }

    public void setAppID(String r100) {
        this.appID = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setPermission(String r100) {
        this.permission = r100;
    }

    public PermissionInfo setPermissionUri(String r100) {
        this.permission = r100;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.writeString(this.appID);
        r100.writeString(this.packageName);
        r100.writeString(this.permission);
    }

    public PermissionInfo(String r100, String r101, String r102) {
        this.appID = r100;
        this.packageName = r101;
        this.permission = r102;
    }
}
