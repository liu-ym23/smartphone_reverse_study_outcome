package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class UserInfo implements BaseJSModel, Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = null;
    public static final int ERROR_CODE_ASKOWNER = 4;
    public static final int GROUP = 2;
    public static final int USER = 1;
    private String avatarKey;
    private String avatarUrl;
    private String department;
    private int errorCode;
    private String getGroupDescription;
    private boolean isExternal;
    private boolean isRegistered;
    private int ownerType;
    private String userId;
    private String userName;

    public class a implements Parcelable.Creator<UserInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo createFromParcel(Parcel r100) {
            return new UserInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo[] newArray(int r100) {
            return new UserInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, Integer.valueOf(this.ownerType)});
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "UserInfo{avatarUrl='" + this.avatarUrl + "', avatarKey='" + this.avatarKey + "', userName='" + this.userName + "', isRegistered=" + this.isRegistered + '}';
    }

    public UserInfo() {
        this.ownerType = 1;
        this.isExternal = false;
        this.department = "";
        this.getGroupDescription = "";
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getDepartment() {
        return this.department;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getGetGroupDescription() {
        return this.getGroupDescription;
    }

    public int getOwnerType() {
        return this.ownerType;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public UserInfo(Parcel r100) {
        boolean r101 = true;
        this.ownerType = 1;
        this.isExternal = false;
        this.department = "";
        this.getGroupDescription = "";
        this.avatarUrl = r100.readString();
        this.avatarKey = r100.readString();
        this.userName = r100.readString();
        this.userId = r100.readString();
        if (r100.readByte() != 0) goto L6;
        r101 = false;
    L6:
        this.isRegistered = r101;
        this.ownerType = r100.readInt();
        this.department = r100.readString();
        this.getGroupDescription = r100.readString();
        this.errorCode = r100.readInt();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L26;
        UserInfo r101 = (UserInfo) r100;
        int r102 = this.ownerType;
        int r103 = r101.ownerType;
        if (r102 == 0) goto L13;
        if (r102 == 1) goto L13;
    L16:
        if (r102 == r103) goto L19;
        boolean r104 = false;
    L20:
        if (r104 == true) goto L22;
    L24:
        return false;
    L22:
        if (TextUtils.equals(this.userId, r101.userId) == false) goto L24;
        return true;
    L19:
        r104 = true;
    L13:
        if (r103 == 0) goto L19;
        if (r103 != 1) goto L16;
        goto L16
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setDepartment(String r100) {
        this.department = r100;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setExternal(boolean r100) {
        this.isExternal = r100;
    }

    public void setGetGroupDescription(String r100) {
        this.getGroupDescription = r100;
    }

    public void setOwnerType(int r100) {
        this.ownerType = r100;
    }

    public void setRegistered(boolean r100) {
        this.isRegistered = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setUserName(String r100) {
        this.userName = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.avatarUrl);
        r100.writeString(this.avatarKey);
        r100.writeString(this.userName);
        r100.writeString(this.userId);
        r100.writeByte(this.isRegistered ? 1 : 0);
        r100.writeInt(this.ownerType);
        r100.writeByte(this.isExternal ? 1 : 0);
        r100.writeString(this.department);
        r100.writeString(this.getGroupDescription);
        r100.writeInt(this.errorCode);
    }
}
