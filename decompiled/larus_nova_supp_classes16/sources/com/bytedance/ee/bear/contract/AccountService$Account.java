package com.bytedance.ee.bear.contract;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.ss.android.lark.passport.signinsdk_api.account.I18Name;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final AccountService$Account createFromParcel(Parcel r2) {
            return new AccountService$Account(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AccountService$Account[] newArray(int r1) {
            return new AccountService$Account[r1];
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
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 != null) goto L8;
        return false;
    L8:
        String r1 = r0.getUserId();
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.uid, r1) == false) goto L15;
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
        if (DiagramData$RESULT.FAIL.equals(this.tenantId) == false) goto L5;
    L8:
        return true;
    L5:
        if (isSmallB() == true) goto L8;
        return false;
    }

    public boolean isSmallB() {
        if (DiagramData$RESULT.FAIL.equals(this.tenantId) == false) goto L6;
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

    public AccountService$Account(Parcel r4) {
        this.uid = r4.readString();
        this.userName = r4.readString();
        this.organization = r4.readString();
        this.email = r4.readString();
        this.mobile = r4.readString();
        this.avatarUrl = r4.readString();
        this.openId = r4.readString();
        this.token = r4.readString();
        this.tenantId = r4.readString();
        this.tenantName = r4.readString();
        this.state = r4.readInt();
        this.cnName = r4.readString();
        this.enName = r4.readString();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.canCreateSheet = r0;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.canCross = r2;
        this.departmentId = r4.readString();
        this.domain = r4.readString();
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.isSingleproduct = r3;
        this.tenantTag = r4.readString();
        if (r4.readByte() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.isManager = r5;
        if (r4.readByte() != 0) goto L22;
        r1 = false;
    L22:
        this.isSuperAdmin = r1;
        this.displayName = r4.readString();
        this.i18Name = r4.readParcelable(I18Name.class.getClassLoader());
        this.i18DisplayName = r4.readParcelable(I18Name.class.getClassLoader());
        return;
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public boolean isDocOwner(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return r2.equals(this.uid);
    }

    public boolean isSameTenant(String r2) {
        if (TextUtils.isEmpty(this.tenantId) == false) goto L7;
        return false;
    L7:
        return this.tenantId.equals(r2);
    }

    public String localizedDisplayName(Locale r3) {
        if (TextUtils.equals(this.displayName, this.userName) == true) goto L5;
        if (r3 == null) goto L8;
        String r0 = a(this.i18DisplayName, r3);
        if (TextUtils.isEmpty(r0) == true) goto L13;
        return r0;
    L13:
        return localizedName(r3);
    L8:
        return this.displayName;
    L5:
        return localizedName(r3);
    }

    public String localizedName(Locale r2) {
        if (r2 == null) goto L4;
        String r3 = a(this.i18Name, r2);
        if (TextUtils.isEmpty(r3) == true) goto L9;
        return r3;
    L9:
        return this.userName;
    L4:
        return this.userName;
    }

    public static String a(I18Name r1, Locale r2) {
        if (r1 == null) goto L17;
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.equals(Locale.CHINESE) == false) goto L10;
        return r1.zhCn;
    L10:
        if (r2.equals(Locale.ENGLISH) == false) goto L14;
        return r1.enUs;
    L14:
        if (r2.equals(Locale.JAPANESE) == true) goto L16;
        return null;
    L16:
        return r1.jaJp;
    L17:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.uid);
        r2.writeString(this.userName);
        r2.writeString(this.organization);
        r2.writeString(this.email);
        r2.writeString(this.mobile);
        r2.writeString(this.avatarUrl);
        r2.writeString(this.openId);
        r2.writeString(this.token);
        r2.writeString(this.tenantId);
        r2.writeString(this.tenantName);
        r2.writeInt(this.state);
        r2.writeString(this.cnName);
        r2.writeString(this.enName);
        r2.writeByte(this.canCreateSheet ? 1 : 0);
        r2.writeByte(this.canCross ? 1 : 0);
        r2.writeString(this.departmentId);
        r2.writeString(this.domain);
        r2.writeByte(this.isSingleproduct ? 1 : 0);
        r2.writeString(this.tenantTag);
        r2.writeByte(this.isManager ? 1 : 0);
        r2.writeByte(this.isSuperAdmin ? 1 : 0);
        r2.writeString(this.displayName);
        r2.writeParcelable(this.i18Name, r3);
        r2.writeParcelable(this.i18DisplayName, r3);
    }
}
