package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public final UserInfo createFromParcel(Parcel r2) {
            return new UserInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo[] newArray(int r1) {
            return new UserInfo[r1];
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

    public UserInfo(Parcel r4) {
        boolean r0 = true;
        this.ownerType = 1;
        this.isExternal = false;
        this.department = "";
        this.getGroupDescription = "";
        this.avatarUrl = r4.readString();
        this.avatarKey = r4.readString();
        this.userName = r4.readString();
        this.userId = r4.readString();
        if (r4.readByte() != 0) goto L6;
        r0 = false;
    L6:
        this.isRegistered = r0;
        this.ownerType = r4.readInt();
        this.department = r4.readString();
        this.getGroupDescription = r4.readString();
        this.errorCode = r4.readInt();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L26;
        UserInfo r6 = (UserInfo) r5;
        int r2 = this.ownerType;
        int r3 = r6.ownerType;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L13;
    L16:
        if (r2 == r3) goto L19;
        boolean r4 = false;
    L20:
        if (r4 == true) goto L22;
    L24:
        return false;
    L22:
        if (TextUtils.equals(this.userId, r6.userId) == false) goto L24;
        return true;
    L19:
        r4 = true;
    L13:
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L16;
        goto L16
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setDepartment(String r1) {
        this.department = r1;
    }

    public void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public void setExternal(boolean r1) {
        this.isExternal = r1;
    }

    public void setGetGroupDescription(String r1) {
        this.getGroupDescription = r1;
    }

    public void setOwnerType(int r1) {
        this.ownerType = r1;
    }

    public void setRegistered(boolean r1) {
        this.isRegistered = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }

    public void setUserName(String r1) {
        this.userName = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.avatarUrl);
        r1.writeString(this.avatarKey);
        r1.writeString(this.userName);
        r1.writeString(this.userId);
        r1.writeByte(this.isRegistered ? 1 : 0);
        r1.writeInt(this.ownerType);
        r1.writeByte(this.isExternal ? 1 : 0);
        r1.writeString(this.department);
        r1.writeString(this.getGroupDescription);
        r1.writeInt(this.errorCode);
    }
}
