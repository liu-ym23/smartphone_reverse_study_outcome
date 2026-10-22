package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;
import nw7.c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import ow7.b;

/* JADX INFO: loaded from: classes23.dex */
public class UserInfo implements Parcelable, Serializable {
    public static final String ADDRESS = "address";
    public static final String AGE = "age";
    public static final String AGEGROUPFLAG = "ageGroupFlag";
    public static final String BIRTHDATE = "birthDate";
    public static final String CITY = "city";
    public static final String CLOUDACCOUNT = "cloudAccount";
    public static final Parcelable.Creator<UserInfo> CREATOR = null;
    public static final String CTFCODE = "ctfCode";
    public static final String CTFTYPE = "ctfType";
    public static final String CTFVERIFYFLAG = "ctfVerifyFlag";
    public static final String FIRSTNAME = "firstName";
    public static final String GENDER = "gender";
    public static final String GUARDIAN_ACCOUNT = "guardianAccount";
    public static final String GUARDIAN_USER_ID = "guardianUserID";
    public static final String HEADPICTUREURL = "headPictureURL";
    public static final String INVITER = "Inviter";
    public static final String INVITER_USERID = "InviterUserID";
    public static final String LANGUAGECODE = "languageCode";
    public static final String LASTNAME = "lastName";
    public static final String LOGIN_NOTICE = "loginnotice";
    public static final String LOGIN_USER_NAME = "loginUserName";
    public static final String LOGIN_USER_NAME_FLAG = "loginUserNameFlag";
    public static final String NATIONALCODE = "nationalCode";
    public static final String NICKNAME = "nickName";
    public static final String OCCUPATION = "occupation";
    public static final String PASSWORDANWSER = "passwordAnswer";
    public static final String PASSWORDPROMPT = "passwordPrompt";
    public static final String PROVINCE = "province";
    public static final String RESET_PASSWD_MODE = "resetPasswdMode";
    public static final String SERVICEFLAG = "ServiceFlag";
    public static final String TWO_STEP_TIME = "twoStepTime";
    public static final String TWO_STEP_VERIFY = "twoStepVerify";
    public static final String UNIQUE_NICKNAME = "uniquelyNickname";
    public static final String UPDATE_TIME = "updateTime";
    public static final String USERSIGN = "userSignature";
    public static final String USERSTATE = "userState";
    public static final String USERVALID_STATUS = "userValidStatus";
    public static final String USER_STATUS_FLAGS = "userStatusFlags";
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f276593J;
    private String K;
    private String L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f276594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f276595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f276596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f276597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f276598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f276599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f276600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f276601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f276602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f276603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f276604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f276605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f276606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f276607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f276608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f276609p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f276610q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f276611r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f276612s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f276613t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f276614u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f276615v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f276616w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f276617x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f276618y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f276619z;

    public class a implements Parcelable.Creator<UserInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo createFromParcel(Parcel r100) {
            UserInfo r101 = new UserInfo();
            UserInfo.a(r101, r100.readString());
            UserInfo.c(r101, r100.readString());
            UserInfo.n(r101, r100.readString());
            UserInfo.y(r101, r100.readString());
            UserInfo.G(r101, r100.readString());
            UserInfo.H(r101, r100.readString());
            UserInfo.I(r101, r100.readString());
            UserInfo.J(r101, r100.readString());
            UserInfo.K(r101, r100.readString());
            UserInfo.L(r101, r100.readString());
            UserInfo.b(r101, r100.readString());
            UserInfo.d(r101, r100.readString());
            UserInfo.e(r101, r100.readString());
            UserInfo.f(r101, r100.readString());
            UserInfo.g(r101, r100.readString());
            UserInfo.h(r101, r100.readString());
            UserInfo.i(r101, r100.readString());
            UserInfo.j(r101, r100.readString());
            UserInfo.k(r101, r100.readString());
            UserInfo.l(r101, r100.readString());
            UserInfo.m(r101, r100.readString());
            UserInfo.o(r101, r100.readString());
            UserInfo.p(r101, r100.readString());
            UserInfo.q(r101, r100.readString());
            UserInfo.r(r101, r100.readString());
            UserInfo.s(r101, r100.readString());
            UserInfo.t(r101, r100.readString());
            UserInfo.u(r101, r100.readString());
            UserInfo.v(r101, r100.readString());
            UserInfo.w(r101, r100.readString());
            UserInfo.x(r101, r100.readString());
            UserInfo.z(r101, r100.readString());
            UserInfo.A(r101, r100.readString());
            UserInfo.B(r101, r100.readString());
            UserInfo.C(r101, r100.readString());
            UserInfo.D(r101, r100.readString());
            UserInfo.E(r101, r100.readString());
            UserInfo.F(r101, r100.readString());
            return r101;
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

    static {
        CREATOR = new a();
    }

    public int getUserType() {
        if (TextUtils.isEmpty(this.E) == false) goto L5;
        return 0;
    L5:
        if (TextUtils.isEmpty(this.F) == true) goto L11;
        return 1;
    L11:
        return 0;
    }

    public String toString() {
        return "UserInfo [mNickName=" + c.a(this.f276594a) + ", mUniqueNickName=" + c.a(this.f276595b) + ", mLanguageCode=" + this.f276596c + ", mFirstName=" + c.a(this.f276597d) + ", mLastName=" + c.a(this.f276598e) + ", mUserState=" + this.f276599f + ", mGender=" + this.f276600g + ", mBirthDate=" + this.f276601h + ", mAddress=" + c.a(this.f276602i) + ", mOccupation=" + this.f276603j + ", mHeadPictureUrl=" + this.f276604k + ", mNationalCode=" + this.f276605l + ", mProvince=" + this.f276606m + ", mCity=" + this.f276607n + ", mPasswordPrompt=" + c.a(this.f276608o) + ", mscrtdanws=" + this.f276609p + ", mCloudAccount=" + this.f276610q + ", mServiceFlag=" + this.f276611r + ", mUserValidStatus=" + this.f276612s + ", mInviterUserId=" + c.a(this.f276613t) + ", mInviter=" + c.a(this.f276614u) + ", mUpdateTime=" + this.f276615v + ", mLoginUserName=" + c.a(this.f276616w) + ", mLoginUserNameFlag=" + this.f276617x + ", muserStatusFlags=" + this.f276618y + ", mtwoStepVerify=" + this.f276619z + ", mtwoStepTime=" + this.A + ", mResetPasswdMode=" + this.B + ", mUserSign=" + this.C + ", mLoginNotice=" + this.D + ", mGuardianUserId=" + c.a(this.E) + ", mGuardianAccount=" + c.a(this.F) + ", mCtfType=" + this.G + ", mCtfVerifyFlag=" + this.H + ", mCtfCode=" + this.I + ", mAgegroupflag=" + this.L + ", mServiceCountryCode=" + this.f276593J + ", userType=" + getUserType() + "]";
    }

    public UserInfo() {
    }

    public String getAddress() {
        return this.f276602i;
    }

    public String getAge() {
        return this.K;
    }

    public String getAgegroupflag() {
        return this.L;
    }

    public String getBirthDate() {
        return this.f276601h;
    }

    public String getCity() {
        return this.f276607n;
    }

    public String getCloudAccount() {
        return this.f276610q;
    }

    public String getCtfCode() {
        return this.I;
    }

    public String getCtfType() {
        return this.G;
    }

    public String getCtfVerifyFlag() {
        return this.H;
    }

    public String getFirstName() {
        return this.f276597d;
    }

    public String getGender() {
        return this.f276600g;
    }

    public String getGuardianAccount() {
        return this.F;
    }

    public String getGuardianUserId() {
        return this.E;
    }

    public String getHeadPictureUrl() {
        return this.f276604k;
    }

    public String getInviter() {
        return this.f276614u;
    }

    public String getInviterUserId() {
        return this.f276613t;
    }

    public String getLanguageCode() {
        return this.f276596c;
    }

    public String getLastName() {
        return this.f276598e;
    }

    public String getLoginNotice() {
        return this.D;
    }

    public String getLoginUserName() {
        return this.f276616w;
    }

    public String getLoginUserNameFlag() {
        return this.f276617x;
    }

    public String getNationalCode() {
        return this.f276605l;
    }

    public String getNickName() {
        return this.f276594a;
    }

    public String getOccupation() {
        return this.f276603j;
    }

    public String getPasswordAnwser() {
        return this.f276609p;
    }

    public String getPasswordPrompt() {
        return this.f276608o;
    }

    public String getProvince() {
        return this.f276606m;
    }

    public String getResetPasswdMode() {
        return this.B;
    }

    public String getServiceCountryCode() {
        return this.f276593J;
    }

    public String getServiceFlag() {
        return this.f276611r;
    }

    public String getUniqueNickName() {
        return this.f276595b;
    }

    public String getUpdateTime() {
        return this.f276615v;
    }

    public String getUserSign() {
        return this.C;
    }

    public String getUserState() {
        return this.f276599f;
    }

    public String getUserValidStatus() {
        return this.f276612s;
    }

    public String gettwoStepTime() {
        return this.A;
    }

    public String gettwoStepVerify() {
        return this.f276619z;
    }

    public String getuserStatusFlags() {
        return this.f276618y;
    }

    public boolean isObjectEquals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof UserInfo) == true) goto L8;
        return false;
    L8:
        if (this != r100) goto L10;
        return true;
    L10:
        UserInfo r101 = (UserInfo) r100;
        if (b.a(getNickName(), r101.getNickName()) == true) goto L14;
        return false;
    L14:
        if (b.a(getLoginUserName(), r101.getLoginUserName()) == true) goto L17;
        return false;
    L17:
        if (b.a(getLoginUserNameFlag(), r101.getLoginUserNameFlag()) == true) goto L20;
        return false;
    L20:
        if (b.a(getGender(), r101.getGender()) == true) goto L23;
        return false;
    L23:
        if (b.a(getBirthDate(), r101.getBirthDate()) == true) goto L26;
        return false;
    L26:
        if (b.a(getNationalCode(), r101.getNationalCode()) == true) goto L28;
        return false;
    L28:
        return true;
    }

    public void setAddress(String r100) {
        this.f276602i = r100;
    }

    public void setAge(String r100) {
        this.K = r100;
    }

    public void setAgegroupflag(String r100) {
        this.L = r100;
    }

    public void setBirthDate(String r100) {
        this.f276601h = r100;
    }

    public void setCity(String r100) {
        this.f276607n = r100;
    }

    public void setCloudAccount(String r100) {
        this.f276610q = r100;
    }

    public void setCtfCode(String r100) {
        this.I = r100;
    }

    public void setCtfType(String r100) {
        this.G = r100;
    }

    public void setCtfVerifyFlag(String r100) {
        this.H = r100;
    }

    public void setFirstName(String r100) {
        this.f276597d = r100;
    }

    public void setGender(String r100) {
        this.f276600g = r100;
    }

    public void setGuardianAccount(String r100) {
        this.F = r100;
    }

    public void setGuardianUserId(String r100) {
        this.E = r100;
    }

    public void setHeadPictureUrl(String r100) {
        this.f276604k = r100;
    }

    public void setInviter(String r100) {
        this.f276614u = r100;
    }

    public void setInviterUserId(String r100) {
        this.f276613t = r100;
    }

    public void setLanguageCode(String r100) {
        this.f276596c = r100;
    }

    public void setLastName(String r100) {
        this.f276598e = r100;
    }

    public void setLoginNotice(String r100) {
        this.D = r100;
    }

    public void setLoginUserName(String r100) {
        this.f276616w = r100;
    }

    public void setLoginUserNameFlag(String r100) {
        this.f276617x = r100;
    }

    public void setNationalCode(String r100) {
        this.f276605l = r100;
    }

    public void setNickName(String r100) {
        this.f276594a = r100;
    }

    public void setOccupation(String r100) {
        this.f276603j = r100;
    }

    public void setPasswordAnwser(String r100) {
        this.f276609p = r100;
    }

    public void setPasswordPrompt(String r100) {
        this.f276608o = r100;
    }

    public void setProvince(String r100) {
        this.f276606m = r100;
    }

    public void setResetPasswdMode(String r100) {
        this.B = r100;
    }

    public void setServiceCountryCode(String r100) {
        this.f276593J = r100;
    }

    public void setServiceFlag(String r100) {
        this.f276611r = r100;
    }

    public void setUniqueNickName(String r100) {
        this.f276595b = r100;
    }

    public void setUpdateTime(String r100) {
        this.f276615v = r100;
    }

    public void setUserSign(String r100) {
        this.C = r100;
    }

    public void setUserState(String r100) {
        this.f276599f = r100;
    }

    public void setUserValidStatus(String r100) {
        this.f276612s = r100;
    }

    public void settwoStepTime(String r100) {
        this.A = r100;
    }

    public void settwoStepVerify(String r100) {
        this.f276619z = r100;
    }

    public void setuserStatusFlags(String r100) {
        this.f276618y = r100;
    }

    public static /* synthetic */ String A(UserInfo r100, String r101) {
        r100.I = r101;
        return r101;
    }

    public static /* synthetic */ String B(UserInfo r100, String r101) {
        r100.G = r101;
        return r101;
    }

    public static /* synthetic */ String C(UserInfo r100, String r101) {
        r100.H = r101;
        return r101;
    }

    public static /* synthetic */ String D(UserInfo r100, String r101) {
        r100.f276593J = r101;
        return r101;
    }

    public static /* synthetic */ String E(UserInfo r100, String r101) {
        r100.K = r101;
        return r101;
    }

    public static /* synthetic */ String F(UserInfo r100, String r101) {
        r100.L = r101;
        return r101;
    }

    public static /* synthetic */ String G(UserInfo r100, String r101) {
        r100.f276597d = r101;
        return r101;
    }

    public static /* synthetic */ String H(UserInfo r100, String r101) {
        r100.f276600g = r101;
        return r101;
    }

    public static /* synthetic */ String I(UserInfo r100, String r101) {
        r100.f276604k = r101;
        return r101;
    }

    public static /* synthetic */ String J(UserInfo r100, String r101) {
        r100.f276596c = r101;
        return r101;
    }

    public static /* synthetic */ String K(UserInfo r100, String r101) {
        r100.f276598e = r101;
        return r101;
    }

    public static /* synthetic */ String L(UserInfo r100, String r101) {
        r100.f276605l = r101;
        return r101;
    }

    public static /* synthetic */ String a(UserInfo r100, String r101) {
        r100.f276602i = r101;
        return r101;
    }

    public static /* synthetic */ String b(UserInfo r100, String r101) {
        r100.f276594a = r101;
        return r101;
    }

    public static /* synthetic */ String c(UserInfo r100, String r101) {
        r100.f276601h = r101;
        return r101;
    }

    public static /* synthetic */ String d(UserInfo r100, String r101) {
        r100.f276595b = r101;
        return r101;
    }

    public static /* synthetic */ String e(UserInfo r100, String r101) {
        r100.f276603j = r101;
        return r101;
    }

    public static /* synthetic */ String f(UserInfo r100, String r101) {
        r100.f276609p = r101;
        return r101;
    }

    public static /* synthetic */ String g(UserInfo r100, String r101) {
        r100.f276608o = r101;
        return r101;
    }

    public static /* synthetic */ String h(UserInfo r100, String r101) {
        r100.f276606m = r101;
        return r101;
    }

    public static /* synthetic */ String i(UserInfo r100, String r101) {
        r100.f276611r = r101;
        return r101;
    }

    public static /* synthetic */ String j(UserInfo r100, String r101) {
        r100.f276599f = r101;
        return r101;
    }

    public static /* synthetic */ String k(UserInfo r100, String r101) {
        r100.f276612s = r101;
        return r101;
    }

    public static /* synthetic */ String l(UserInfo r100, String r101) {
        r100.f276613t = r101;
        return r101;
    }

    public static /* synthetic */ String m(UserInfo r100, String r101) {
        r100.f276614u = r101;
        return r101;
    }

    public static /* synthetic */ String n(UserInfo r100, String r101) {
        r100.f276607n = r101;
        return r101;
    }

    public static /* synthetic */ String o(UserInfo r100, String r101) {
        r100.f276615v = r101;
        return r101;
    }

    public static /* synthetic */ String p(UserInfo r100, String r101) {
        r100.f276616w = r101;
        return r101;
    }

    public static /* synthetic */ String q(UserInfo r100, String r101) {
        r100.f276617x = r101;
        return r101;
    }

    public static /* synthetic */ String r(UserInfo r100, String r101) {
        r100.f276618y = r101;
        return r101;
    }

    public static /* synthetic */ String s(UserInfo r100, String r101) {
        r100.f276619z = r101;
        return r101;
    }

    public static void setUserInfoIntag(XmlSerializer r100, UserInfo r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        ow7.c.a(r100, UNIQUE_NICKNAME, r101.getUniqueNickName());
        ow7.c.a(r100, "nickName", r101.getNickName());
        ow7.c.a(r100, LANGUAGECODE, r101.getLanguageCode());
        ow7.c.a(r100, FIRSTNAME, r101.getFirstName());
        ow7.c.a(r100, LASTNAME, r101.getLastName());
        ow7.c.a(r100, USERSTATE, r101.getUserState());
        ow7.c.a(r100, "gender", r101.getGender());
        ow7.c.a(r100, BIRTHDATE, r101.getBirthDate());
        ow7.c.a(r100, "address", r101.getAddress());
        ow7.c.a(r100, OCCUPATION, r101.getOccupation());
        ow7.c.a(r100, HEADPICTUREURL, r101.getHeadPictureUrl());
        ow7.c.a(r100, NATIONALCODE, r101.getNationalCode());
        ow7.c.a(r100, "province", r101.getProvince());
        ow7.c.a(r100, "city", r101.getCity());
        ow7.c.a(r100, PASSWORDPROMPT, r101.getPasswordPrompt());
        ow7.c.a(r100, PASSWORDANWSER, r101.getPasswordAnwser());
        ow7.c.a(r100, CLOUDACCOUNT, r101.getCloudAccount());
        ow7.c.a(r100, SERVICEFLAG, r101.getServiceFlag());
        ow7.c.a(r100, USERVALID_STATUS, r101.getUserValidStatus());
        ow7.c.a(r100, INVITER, r101.getInviter());
        ow7.c.a(r100, INVITER_USERID, r101.getInviterUserId());
        ow7.c.a(r100, UPDATE_TIME, r101.getUpdateTime());
        ow7.c.a(r100, LOGIN_USER_NAME, r101.getLoginUserName());
        ow7.c.a(r100, LOGIN_USER_NAME_FLAG, r101.getLoginUserNameFlag());
        ow7.c.a(r100, USERSIGN, r101.getUserSign());
        ow7.c.a(r100, CTFCODE, r101.getCtfCode());
        ow7.c.a(r100, CTFTYPE, r101.getCtfType());
        ow7.c.a(r100, CTFVERIFYFLAG, r101.getCtfVerifyFlag());
        ow7.c.a(r100, "srvNationalCode", r101.getServiceCountryCode());
        ow7.c.a(r100, "age", r101.getAge());
        ow7.c.a(r100, AGEGROUPFLAG, r101.getAgegroupflag());
        return;
    L8:
        return;
    }

    public static /* synthetic */ String t(UserInfo r100, String r101) {
        r100.A = r101;
        return r101;
    }

    public static /* synthetic */ String u(UserInfo r100, String r101) {
        r100.B = r101;
        return r101;
    }

    public static /* synthetic */ String v(UserInfo r100, String r101) {
        r100.D = r101;
        return r101;
    }

    public static /* synthetic */ String w(UserInfo r100, String r101) {
        r100.C = r101;
        return r101;
    }

    public static /* synthetic */ String x(UserInfo r100, String r101) {
        r100.E = r101;
        return r101;
    }

    public static /* synthetic */ String y(UserInfo r100, String r101) {
        r100.f276610q = r101;
        return r101;
    }

    public static /* synthetic */ String z(UserInfo r100, String r101) {
        r100.F = r101;
        return r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276602i);
        r100.writeString(this.f276601h);
        r100.writeString(this.f276607n);
        r100.writeString(this.f276610q);
        r100.writeString(this.f276597d);
        r100.writeString(this.f276600g);
        r100.writeString(this.f276604k);
        r100.writeString(this.f276596c);
        r100.writeString(this.f276598e);
        r100.writeString(this.f276605l);
        r100.writeString(this.f276594a);
        r100.writeString(this.f276595b);
        r100.writeString(this.f276603j);
        r100.writeString(this.f276609p);
        r100.writeString(this.f276608o);
        r100.writeString(this.f276606m);
        r100.writeString(this.f276611r);
        r100.writeString(this.f276599f);
        r100.writeString(this.f276612s);
        r100.writeString(this.f276613t);
        r100.writeString(this.f276614u);
        r100.writeString(this.f276615v);
        r100.writeString(this.f276616w);
        r100.writeString(this.f276617x);
        r100.writeString(this.f276618y);
        r100.writeString(this.f276619z);
        r100.writeString(this.A);
        r100.writeString(this.B);
        r100.writeString(this.D);
        r100.writeString(this.C);
        r100.writeString(this.E);
        r100.writeString(this.F);
        r100.writeString(this.I);
        r100.writeString(this.H);
        r100.writeString(this.G);
        r100.writeString(this.f276593J);
        r100.writeString(this.K);
        r100.writeString(this.L);
    }

    public static void getUserInfoIntag(XmlPullParser r100, UserInfo r101, String r102) {
        if (r100 == null) goto L121;
        if (r101 == null) goto L122;
        if (r102 != null) goto L7;
        return;
    L7:
        if ("nickName".equals(r102) == false) goto L10;
        r101.setNickName(r100.nextText());
    L52:
        if ("gender".equals(r102) == false) goto L55;
        r101.setGender(r100.nextText());
    L88:
        if (INVITER.equals(r102) == false) goto L91;
        r101.setInviter(r100.nextText());
        return;
    L91:
        if (UPDATE_TIME.equals(r102) == false) goto L94;
        r101.setUpdateTime(r100.nextText());
        return;
    L94:
        if (LOGIN_USER_NAME.equals(r102) == false) goto L97;
        r101.setLoginUserName(r100.nextText());
        return;
    L97:
        if (LOGIN_USER_NAME_FLAG.equals(r102) == false) goto L100;
        r101.setLoginUserNameFlag(r100.nextText());
        return;
    L100:
        if (USER_STATUS_FLAGS.equals(r102) == false) goto L103;
        r101.setuserStatusFlags(r100.nextText());
        return;
    L103:
        if (TWO_STEP_VERIFY.equals(r102) == false) goto L106;
        r101.settwoStepVerify(r100.nextText());
        return;
    L106:
        if (TWO_STEP_TIME.equals(r102) == false) goto L109;
        r101.settwoStepTime(r100.nextText());
        return;
    L109:
        if (RESET_PASSWD_MODE.equals(r102) == false) goto L112;
        r101.setResetPasswdMode(r100.nextText());
        return;
    L112:
        if (USERSIGN.equals(r102) == false) goto L115;
        r101.setUserSign(r100.nextText());
        return;
    L115:
        if (LOGIN_NOTICE.equals(r102) == false) goto L118;
        r101.setLoginNotice(r100.nextText());
        return;
    L118:
        if ("srvNationalCode".equals(r102) == false) goto L133;
        r101.setServiceCountryCode(r100.nextText());
        return;
    L133:
        return;
    L55:
        if (BIRTHDATE.equals(r102) == false) goto L58;
        r101.setBirthDate(r100.nextText());
        goto L88
    L58:
        if ("address".equals(r102) == false) goto L61;
        r101.setAddress(r100.nextText());
        goto L88
    L61:
        if (OCCUPATION.equals(r102) == false) goto L64;
        r101.setOccupation(r100.nextText());
        goto L88
    L64:
        if (HEADPICTUREURL.equals(r102) == false) goto L67;
        r101.setHeadPictureUrl(r100.nextText());
        goto L88
    L67:
        if (NATIONALCODE.equals(r102) == false) goto L70;
        r101.setNationalCode(r100.nextText());
        goto L88
    L70:
        if ("province".equals(r102) == false) goto L73;
        r101.setProvince(r100.nextText());
        goto L88
    L73:
        if ("city".equals(r102) == false) goto L76;
        r101.setCity(r100.nextText());
        goto L88
    L76:
        if (PASSWORDPROMPT.equals(r102) == false) goto L79;
        r101.setPasswordPrompt(r100.nextText());
        goto L88
    L79:
        if (PASSWORDANWSER.equals(r102) == false) goto L82;
        r101.setPasswordAnwser(r100.nextText());
        goto L88
    L82:
        if (CLOUDACCOUNT.equals(r102) == false) goto L85;
        r101.setCloudAccount(r100.nextText());
        goto L88
    L85:
        if (SERVICEFLAG.equals(r102) == false) goto L88;
        r101.setServiceFlag(r100.nextText());
        goto L88
    L10:
        if (UNIQUE_NICKNAME.equals(r102) == false) goto L13;
        r101.setUniqueNickName(r100.nextText());
        goto L52
    L13:
        if (LANGUAGECODE.equals(r102) == false) goto L16;
        r101.setLanguageCode(r100.nextText());
        goto L52
    L16:
        if (FIRSTNAME.equals(r102) == false) goto L19;
        r101.setFirstName(r100.nextText());
        goto L52
    L19:
        if (LASTNAME.equals(r102) == false) goto L22;
        r101.setLastName(r100.nextText());
        goto L52
    L22:
        if (USERSTATE.equals(r102) == false) goto L25;
        r101.setUserState(r100.nextText());
        goto L52
    L25:
        if (GUARDIAN_ACCOUNT.equals(r102) == false) goto L28;
        r101.setGuardianAccount(r100.nextText());
        goto L52
    L28:
        if (GUARDIAN_USER_ID.equals(r102) == false) goto L31;
        r101.setGuardianUserId(r100.nextText());
        goto L52
    L31:
        if (CTFCODE.equals(r102) == false) goto L34;
        r101.setCtfCode(r100.nextText());
        goto L52
    L34:
        if (CTFTYPE.equals(r102) == false) goto L37;
        r101.setCtfType(r100.nextText());
        goto L52
    L37:
        if (CTFVERIFYFLAG.equals(r102) == false) goto L40;
        r101.setCtfVerifyFlag(r100.nextText());
        goto L52
    L40:
        if (USERVALID_STATUS.equals(r102) == false) goto L43;
        r101.setUserValidStatus(r100.nextText());
        goto L52
    L43:
        if (INVITER_USERID.equals(r102) == false) goto L46;
        r101.setInviterUserId(r100.nextText());
        goto L52
    L46:
        if ("age".equals(r102) == false) goto L49;
        r101.setAge(r100.nextText());
        goto L52
    L49:
        if (AGEGROUPFLAG.equals(r102) == false) goto L52;
        r101.setAgegroupflag(r100.nextText());
        goto L52
    L122:
        return;
    }
}
