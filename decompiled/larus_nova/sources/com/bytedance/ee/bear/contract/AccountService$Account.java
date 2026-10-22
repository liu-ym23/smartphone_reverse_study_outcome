package com.bytedance.ee.bear.contract;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.lark.passport.signinsdk_api.account.I18Name;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes16.dex */
public class AccountService$Account implements Parcelable, Serializable {
    public static final Parcelable.Creator<AccountService$Account> CREATOR = null;
    public static final int STATE_HAVE_LOGIN = 1;
    public static final int STATE_LOCAL_LOGIN = -1;
    public String avatarUrl;
    public boolean canCreateSheet;
    public boolean canCross;
    public String cnName;
    public String departmentId;
    public String displayName;
    public String domain;
    public String email;
    public String enName;
    public I18Name i18DisplayName;
    public I18Name i18Name;
    public boolean isManager;
    public boolean isSingleproduct;
    public boolean isSuperAdmin;
    public String mobile;
    public String openId;
    public String organization;
    public int state;
    public String tenantId;
    public String tenantName;
    public String tenantTag;
    public String token;
    public String uid;
    public String userName;

    public class a implements Parcelable.Creator<AccountService$Account> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AccountService$Account createFromParcel(Parcel r100) {
            return new AccountService$Account(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AccountService$Account[] newArray(int r100) {
            return new AccountService$Account[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public boolean hasLogin() {
        if (TextUtils.isEmpty(this.token) == true) goto L5;
        return true;
    L5:
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r100 != null) goto L8;
        return false;
    L8:
        String r101 = r100.getUserId();
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.uid, r101) == false) goto L15;
        return true;
    L15:
        if (eu5.c.d() == true) goto L17;
    L21:
        return false;
    L17:
        if (TextUtils.equals("absent_user", this.uid) == true) goto L21;
        throw new IllegalStateException("Warning: Account is not foreground, check out why it remains living.");
    }

    public boolean isConsumer() {
        if ("0".equals(this.tenantId) == false) goto L5;
    L8:
        return true;
    L5:
        if (isSmallB() == true) goto L8;
        return false;
    }

    public boolean isSmallB() {
        if ("0".equals(this.tenantId) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.tenantTag, "2") == false) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "Account{uid='" + this.uid + "', state=" + this.state + '}';
    }

    public AccountService$Account() {
    }

    public AccountService$Account(Parcel r100) {
        this.uid = r100.readString();
        this.userName = r100.readString();
        this.organization = r100.readString();
        this.email = r100.readString();
        this.mobile = r100.readString();
        this.avatarUrl = r100.readString();
        this.openId = r100.readString();
        this.token = r100.readString();
        this.tenantId = r100.readString();
        this.tenantName = r100.readString();
        this.state = r100.readInt();
        this.cnName = r100.readString();
        this.enName = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.canCreateSheet = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.canCross = r103;
        this.departmentId = r100.readString();
        this.domain = r100.readString();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isSingleproduct = r104;
        this.tenantTag = r100.readString();
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.isManager = r105;
        if (r100.readByte() != 0) goto L22;
        r101 = false;
    L22:
        this.isSuperAdmin = r101;
        this.displayName = r100.readString();
        this.i18Name = (I18Name) r100.readParcelable(I18Name.class.getClassLoader());
        this.i18DisplayName = (I18Name) r100.readParcelable(I18Name.class.getClassLoader());
        return;
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public boolean isDocOwner(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.equals(this.uid);
    }

    public boolean isSameTenant(String r100) {
        if (TextUtils.isEmpty(this.tenantId) == false) goto L7;
        return false;
    L7:
        return this.tenantId.equals(r100);
    }

    public String localizedDisplayName(Locale r100) {
        if (TextUtils.equals(this.displayName, this.userName) == true) goto L5;
        if (r100 == null) goto L8;
        String r101 = a(this.i18DisplayName, r100);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        return r101;
    L13:
        return localizedName(r100);
    L8:
        return this.displayName;
    L5:
        return localizedName(r100);
    }

    public String localizedName(Locale r100) {
        if (r100 == null) goto L4;
        String r101 = a(this.i18Name, r100);
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return r101;
    L9:
        return this.userName;
    L4:
        return this.userName;
    }

    public static String a(I18Name r100, Locale r101) {
        if (r100 == null) goto L17;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.equals(Locale.CHINESE) == false) goto L10;
        return r100.zhCn;
    L10:
        if (r101.equals(Locale.ENGLISH) == false) goto L14;
        return r100.enUs;
    L14:
        if (r101.equals(Locale.JAPANESE) == true) goto L16;
        return null;
    L16:
        return r100.jaJp;
    L17:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.uid);
        r100.writeString(this.userName);
        r100.writeString(this.organization);
        r100.writeString(this.email);
        r100.writeString(this.mobile);
        r100.writeString(this.avatarUrl);
        r100.writeString(this.openId);
        r100.writeString(this.token);
        r100.writeString(this.tenantId);
        r100.writeString(this.tenantName);
        r100.writeInt(this.state);
        r100.writeString(this.cnName);
        r100.writeString(this.enName);
        r100.writeByte(this.canCreateSheet ? 1 : 0);
        r100.writeByte(this.canCross ? 1 : 0);
        r100.writeString(this.departmentId);
        r100.writeString(this.domain);
        r100.writeByte(this.isSingleproduct ? 1 : 0);
        r100.writeString(this.tenantTag);
        r100.writeByte(this.isManager ? 1 : 0);
        r100.writeByte(this.isSuperAdmin ? 1 : 0);
        r100.writeString(this.displayName);
        r100.writeParcelable(this.i18Name, r101);
        r100.writeParcelable(this.i18DisplayName, r101);
    }
}
