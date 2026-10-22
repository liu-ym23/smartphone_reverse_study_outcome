package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.ss.android.lark.passport.signinsdk_api.account.config.AccountSecurityConfig;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes37.dex */
public class User implements Serializable, Parcelable {
    public static final Parcelable.Creator<User> CREATOR = null;

    @JSONField(name = "account_security_config")
    public AccountSecurityConfig accountSecurityConfig;

    @JSONField(name = "avatar_key")
    public String avatarKey;

    @JSONField(name = "avatar_url")
    public String avatarUrl;

    @JSONField(name = "user_env")
    public String configEnv;

    @JSONField(name = "create_time")
    public long createTime;
    private String currentEnv;
    private String deviceLoginId;

    @JSONField(name = IGoogleService.ResponseKey.DISPLAY_NAME)
    public String displayName;

    @JSONField(name = "en_name")
    public String enName;

    @JSONField(name = "exclude_login")
    private boolean excludeLogin;

    @JSONField(name = "i18n_display_names")
    public I18Name i18DisplayName;

    @JSONField(name = "i18n_names")
    public I18Name i18Name;
    private boolean isAnonymous;

    @JSONField(name = "is_guest")
    public boolean isGuest;

    @JSONField(name = "is_idp")
    public boolean isIdp;
    private boolean isNewActive;
    private boolean isSessionValid;
    private boolean isSessionValidOrForeground;

    @JSONField(name = "is_tenant_creator")
    public boolean isTenantCreator;
    private long lastUseTimestamp;

    @JSONField(name = "lean_mode_info")
    public LeanModeInfo leanModeInfo;

    @JSONField(name = "login_credential_id")
    private String loginCredentialId;
    private String logoutToken;
    public String name;
    private String session;
    private String sessionUuid;

    @JSONField(name = "suite_session_key_with_domains")
    private Map<String, SessionInfo> sessionWithDomainMap;
    private String slSession;
    private int status;
    public Tenant tenant;

    @JSONField(name = "tenant_tag")
    private int tenantTag;

    @JSONField(name = "user_custom_attr")
    public JSONArray userCustomAttr;

    @JSONField(name = MapBundleKey.MapObjKey.OBJ_GEO)
    public String userGeo;

    @JSONField(alternateNames = {"id"}, name = "user_id")
    public String userId;

    @JSONField(name = Scraps.INNER_UNIT)
    public String userUnit;

    public class a implements Parcelable.Creator<User> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final User createFromParcel(Parcel r100) {
            return new User(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final User[] newArray(int r100) {
            return new User[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String a() {
        if (TextUtils.isEmpty(this.userUnit) == false) goto L6;
        return "";
    L6:
        String r100 = this.userUnit;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 93912099: goto L30;
            case 93912675: goto L26;
            case 96855691: goto L22;
            case 96855972: goto L18;
            case 878174793: goto L14;
            case 886218363: goto L10;
            default: goto L33;
        };
    L33:
        String r102 = "feishu";
        switch(r101) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L36;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L36;
            default: goto L38;
        };
    L36:
        r102 = "lark";
    L38:
        return r102;
    L10:
        if (r100.equals("larksgaws") == false) goto L33;
        r101 = 5;
        goto L33
    L14:
        if (r100.equals("larkjpaws") == false) goto L33;
        r101 = 4;
        goto L33
    L18:
        if (r100.equals("eu_nc") == false) goto L33;
        r101 = 3;
        goto L33
    L22:
        if (r100.equals("eu_ea") == false) goto L33;
        r101 = 2;
        goto L33
    L26:
        if (r100.equals(EnvConst$UNIT.BOE_VA) == false) goto L33;
        r101 = 1;
        goto L33
    L30:
        if (r100.equals(EnvConst$UNIT.BOE_CN) == false) goto L33;
        r101 = 0;
        goto L33
    }

    public String getTenantBrand() {
        Tenant r100 = this.tenant;
        if (r100 != null) goto L7;
        return a();
    L7:
        if (TextUtils.isEmpty(r100.getTenantBrand()) == true) goto L11;
        return this.tenant.getTenantBrand();
    L11:
        return a();
    }

    public String getTenantCode() {
        Tenant r100 = this.tenant;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.tenantDomain;
    }

    public String getTenantGeo() {
        Tenant r100 = this.tenant;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTenantGeo();
    }

    public String getTenantIconUrl() {
        Tenant r100 = this.tenant;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.iconUrl;
    }

    public String getTenantId() {
        Tenant r100 = this.tenant;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.tenantId;
    }

    public String getTenantName() {
        Tenant r100 = this.tenant;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.name;
    }

    public int getTenantTag() {
        Tenant r100 = this.tenant;
        if (r100 == null) goto L7;
        return r100.tag;
    L7:
        return this.tenantTag;
    }

    public JSONArray getUserCustomAttr() {
        JSONArray r100 = this.userCustomAttr;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new JSONArray();
    }

    public String getUserGeo() {
        if (TextUtils.isEmpty(this.userGeo) == false) goto L5;
        String r100 = "";
        if (TextUtils.isEmpty(this.userUnit) == true) goto L45;
        String r101 = this.userUnit;
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
            case 93912099: goto L33;
            case 93912675: goto L29;
            case 96855691: goto L25;
            case 96855972: goto L21;
            case 878174793: goto L17;
            case 886218363: goto L13;
            default: goto L36;
        };
    L36:
        switch(r102) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            default: goto L45;
        };
    L38:
        r100 = EnvConst$GEO.SG;
        goto L45
    L39:
        r100 = EnvConst$GEO.JP;
        goto L45
    L40:
        r100 = "cn";
        goto L45
    L41:
        r100 = EnvConst$GEO.US;
        goto L45
    L42:
        r100 = EnvConst$GEO.BOE_US;
        goto L45
    L43:
        r100 = EnvConst$GEO.BOE_CN;
        goto L45
    L13:
        if (r101.equals("larksgaws") == false) goto L36;
        r102 = 5;
        goto L36
    L17:
        if (r101.equals("larkjpaws") == false) goto L36;
        r102 = 4;
        goto L36
    L21:
        if (r101.equals("eu_nc") == false) goto L36;
        r102 = 3;
        goto L36
    L25:
        if (r101.equals("eu_ea") == false) goto L36;
        r102 = 2;
        goto L36
    L29:
        if (r101.equals(EnvConst$UNIT.BOE_VA) == false) goto L36;
        r102 = 1;
        goto L36
    L33:
        if (r101.equals(EnvConst$UNIT.BOE_CN) == false) goto L36;
        r102 = 0;
    L45:
        return r100;
    L5:
        return this.userGeo;
    }

    public String getUserNameEn() {
        I18Name r100 = this.i18Name;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.enUs;
    }

    public boolean hasValidSession() {
        if (TextUtils.isEmpty(this.session) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.isAnonymous == true) goto L9;
        if (this.isSessionValid == false) goto L9;
        return true;
    }

    public boolean hasValidSessionOrForeground() {
        if (TextUtils.isEmpty(this.session) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.isAnonymous == true) goto L9;
        if (this.isSessionValidOrForeground == false) goto L9;
        return true;
    }

    public boolean isC() {
        return "0".equals(getTenantId());
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("userId:");
        r100.append(this.userId);
        r100.append(", avatarKey:");
        String r101 = this.avatarKey;
        String r102 = "null";
        if (r101 != null) goto L6;
        String r103 = "null";
    L12:
        r100.append(r103);
        r100.append(", tenantId:");
        r100.append(getTenantId());
        r100.append(", tenantCode:");
        r100.append(getTenantCode());
        r100.append(", configEnv:");
        r100.append(this.configEnv);
        r100.append(", tenantTag:");
        r100.append(this.tenantTag);
        r100.append(", userCustomAttr:");
        r100.append(this.userCustomAttr);
        r100.append(", leanModeInfo:");
        LeanModeInfo r104 = this.leanModeInfo;
        if (r104 == null) goto L16;
        r102 = r104.toString();
    L16:
        r100.append(r102);
        return r100.toString();
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r103 = "empty";
        goto L12
    L9:
        if (r101.length() > 24) goto L11;
        r103 = "less 24";
        goto L12
    L11:
        String r105 = r101.substring(0, 12);
        String r106 = r101.substring(r101.length() - 12);
        r103 = r105 + new Regex("[\\s\\S]").replace(r101.substring(12, r101.length() - 12), "*") + r106;
        goto L12
    }

    public User() {
        this.isTenantCreator = false;
        this.isSessionValid = true;
        this.isSessionValidOrForeground = true;
        this.isNewActive = false;
        this.tenantTag = 0;
    }

    public boolean isSmallB() {
        if (isC() == false) goto L5;
        return false;
    L5:
        int r100 = getTenantTag();
        if (r100 != 1) goto L8;
    L9:
        return true;
    L8:
        if (r100 == 2) goto L9;
        return false;
    }

    public String getConfigEnv() {
        return this.configEnv;
    }

    public String getCurrentEnv() {
        return this.currentEnv;
    }

    public String getDeviceLoginId() {
        return this.deviceLoginId;
    }

    public long getLastUseTimestamp() {
        return this.lastUseTimestamp;
    }

    public String getLoginCredentialId() {
        return this.loginCredentialId;
    }

    public String getLogoutToken() {
        return this.logoutToken;
    }

    public String getSession() {
        return this.session;
    }

    public String getSessionUuid() {
        return this.sessionUuid;
    }

    public Map<String, SessionInfo> getSessionWithDomainMap() {
        return this.sessionWithDomainMap;
    }

    public String getSlSession() {
        return this.slSession;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.name;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isExcludeLogin() {
        return this.excludeLogin;
    }

    public boolean isIdp() {
        return this.isIdp;
    }

    public boolean isNewActive() {
        return this.isNewActive;
    }

    public User(Parcel r100) {
        boolean r101 = false;
        this.isTenantCreator = false;
        this.isSessionValid = true;
        this.isSessionValidOrForeground = true;
        this.isNewActive = false;
        this.tenantTag = 0;
        this.userId = r100.readString();
        this.name = r100.readString();
        this.i18Name = (I18Name) r100.readParcelable(I18Name.class.getClassLoader());
        this.displayName = r100.readString();
        this.i18DisplayName = (I18Name) r100.readParcelable(I18Name.class.getClassLoader());
        this.status = r100.readInt();
        this.tenant = (Tenant) r100.readParcelable(Tenant.class.getClassLoader());
        this.avatarUrl = r100.readString();
        this.avatarKey = r100.readString();
        this.createTime = r100.readLong();
        this.loginCredentialId = r100.readString();
        this.userUnit = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.excludeLogin = r102;
        this.configEnv = r100.readString();
        this.lastUseTimestamp = r100.readLong();
        this.session = r100.readString();
        this.slSession = r100.readString();
        this.currentEnv = r100.readString();
        this.logoutToken = r100.readString();
        this.deviceLoginId = r100.readString();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.isAnonymous = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isSessionValid = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.isSessionValidOrForeground = r105;
        this.userGeo = r100.readString();
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.isIdp = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.isGuest = r107;
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.isTenantCreator = r108;
        if (r100.readByte() == 0) goto L33;
        r101 = true;
    L33:
        this.isNewActive = r101;
        this.tenantTag = r100.readInt();
        this.enName = r100.readString();
        HashMap r109 = new HashMap();
        this.sessionWithDomainMap = r109;
        r100.readMap(r109, getClass().getClassLoader());
        String r110 = r100.readString();
        Intrinsics.checkNotNullParameter(r110, "str");
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L36
        Object r112 = Result.m9449constructorimpl(JSON.parseArray(r110));     // Catch: Throwable -> L36
    L39:
        if (Result.m9455isFailureimpl(r112) == false) goto L41;
        r112 = null;
    L41:
        JSONArray r113 = (JSONArray) r112;
        if (r113 != null) goto L44;
        r113 = new JSONArray();
    L44:
        this.userCustomAttr = r113;
        this.leanModeInfo = (LeanModeInfo) r100.readParcelable(LeanModeInfo.class.getClassLoader());
        return;
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
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

    public String localizedDisplayName(Locale r100) {
        if (Objects.equals(this.displayName, this.name) == true) goto L5;
        if (r100 == null) goto L8;
        String r101 = this.displayName;
        if (this.i18DisplayName != null) goto L12;
    L24:
        if (r101 == null) goto L28;
        if (r101.length() == 0) goto L28;
        return r101;
    L28:
        return localizedName(r100);
    L12:
        if (r100.getLanguage().equals(Locale.CHINESE.getLanguage()) == false) goto L17;
        if (TextUtils.isEmpty(this.i18DisplayName.zhCn) == true) goto L24;
        r101 = this.i18DisplayName.zhCn;
        goto L24
    L17:
        if (r100.getLanguage().equals(Locale.JAPANESE.getLanguage()) == false) goto L22;
        if (TextUtils.isEmpty(this.i18DisplayName.jaJp) == true) goto L22;
        r101 = this.i18DisplayName.jaJp;
    L22:
        if (TextUtils.isEmpty(this.i18DisplayName.enUs) == true) goto L24;
        r101 = this.i18DisplayName.enUs;
        goto L24
    L8:
        return this.displayName;
    L5:
        return localizedName(r100);
    }

    public String localizedName(Locale r100) {
        if (r100 == null) goto L4;
        String r101 = this.name;
        if (this.i18Name != null) goto L8;
        return r101;
    L8:
        if (r100.getLanguage().equals(Locale.CHINESE.getLanguage()) == false) goto L13;
        if (TextUtils.isEmpty(this.i18Name.zhCn) == false) goto L23;
        return r101;
    L23:
        return this.i18Name.zhCn;
    L13:
        if (r100.getLanguage().equals(Locale.JAPANESE.getLanguage()) == false) goto L18;
        if (TextUtils.isEmpty(this.i18Name.jaJp) == true) goto L18;
        return this.i18Name.jaJp;
    L18:
        if (TextUtils.isEmpty(this.i18Name.enUs) == false) goto L20;
        return r101;
    L20:
        return this.i18Name.enUs;
    L4:
        return this.name;
    }

    public void mergeWithResponseUser(ResponseUser r100) {
        setSession(r100.getSession());
        if (TextUtils.isEmpty(r100.getSlSession()) == true) goto L5;
        setSlSession(r100.getSlSession());
    L5:
        setSessionUuid(r100.getSessionUuid());
        setLogoutToken(r100.getLogoutToken());
        setCurrentEnv(r100.getCurrentEnv());
        setAnonymous(r100.isAnonymous());
        setDeviceLoginId(r100.getDeviceLoginId());
        this.isNewActive = r100.isNewActive;
        Map<String, SessionInfo> r101 = r100.getSessionWithDomainMap();
        if (r101 == null) goto L13;
        Iterator<Map.Entry<String, SessionInfo>> r102 = r101.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, SessionInfo> r103 = r102.next();
        if (r103.getValue() == null) goto L9;
        r103.getValue().setHostUrl(r103.getKey());
    L13:
        setSessionWithDomainMap(r100.getSessionWithDomainMap());
    }

    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    public void setConfigEnv(String r100) {
        this.configEnv = r100;
    }

    public void setCurrentEnv(String r100) {
        this.currentEnv = r100;
    }

    public void setDeviceLoginId(String r100) {
        this.deviceLoginId = r100;
    }

    public void setExcludeLogin(boolean r100) {
        this.excludeLogin = r100;
    }

    public void setIdp(boolean r100) {
        this.isIdp = r100;
    }

    public void setLastUseTimestamp(long r100) {
        this.lastUseTimestamp = r100;
    }

    public void setLoginCredentialId(String r100) {
        this.loginCredentialId = r100;
    }

    public void setLogoutToken(String r100) {
        this.logoutToken = r100;
    }

    public void setSession(String r100) {
        this.session = r100;
    }

    public void setSessionUuid(String r100) {
        this.sessionUuid = r100;
    }

    public void setSessionValid(boolean r100) {
        this.isSessionValid = r100;
    }

    public void setSessionValidOrForeground(boolean r100) {
        this.isSessionValidOrForeground = r100;
    }

    public void setSessionWithDomainMap(Map<String, SessionInfo> r100) {
        this.sessionWithDomainMap = r100;
    }

    public void setSlSession(String r100) {
        this.slSession = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setTenantBrand(String r100) {
        if (this.tenant != null) goto L5;
        this.tenant = new Tenant();
    L5:
        this.tenant.setTenantBrand(r100);
    }

    public void setTenantName(String r100) {
        if (this.tenant != null) goto L5;
        this.tenant = new Tenant();
    L5:
        this.tenant.name = r100;
    }

    public void setTenantTag(int r100) {
        this.tenantTag = r100;
        Tenant r101 = this.tenant;
        if (r101 == null) goto L6;
        r101.tag = r100;
        return;
    }

    public void setUserGeo(String r100) {
        this.userGeo = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.userId);
        r100.writeString(this.name);
        r100.writeParcelable(this.i18Name, r101);
        r100.writeString(this.displayName);
        r100.writeParcelable(this.i18DisplayName, r101);
        r100.writeInt(this.status);
        r100.writeParcelable(this.tenant, r101);
        r100.writeString(this.avatarUrl);
        r100.writeString(this.avatarKey);
        r100.writeLong(this.createTime);
        r100.writeString(this.loginCredentialId);
        r100.writeString(this.userUnit);
        r100.writeByte(this.excludeLogin ? 1 : 0);
        r100.writeString(this.configEnv);
        r100.writeLong(this.lastUseTimestamp);
        r100.writeString(this.session);
        r100.writeString(this.slSession);
        r100.writeString(this.currentEnv);
        r100.writeString(this.logoutToken);
        r100.writeString(this.deviceLoginId);
        r100.writeByte(this.isAnonymous ? 1 : 0);
        r100.writeByte(this.isSessionValid ? 1 : 0);
        r100.writeByte(this.isSessionValidOrForeground ? 1 : 0);
        r100.writeString(this.userGeo);
        r100.writeByte(this.isIdp ? 1 : 0);
        r100.writeByte(this.isGuest ? 1 : 0);
        r100.writeByte(this.isTenantCreator ? 1 : 0);
        r100.writeByte(this.isNewActive ? 1 : 0);
        r100.writeInt(this.tenantTag);
        r100.writeString(this.enName);
        r100.writeMap(this.sessionWithDomainMap);
        r100.writeString(getUserCustomAttr().toJSONString());
        r100.writeParcelable(this.leanModeInfo, r101);
    }
}
