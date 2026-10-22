package com.ss.android.lark.passport.signinsdk_api.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.signinsdk_api.account.config.AccountSecurityConfig;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public class TenantInfo implements Serializable {
    private AccountSecurityConfig accountSecurityConfig;
    private String avatarUrl;
    private int badgeCount;
    private String chatterAvatarKey;
    private String configEnv;
    private boolean isCurrentUser;
    private boolean isIdp;
    private boolean isSessionValid;
    private final boolean isToCUnRegistered;
    private long lastUseTimestamp;
    private int status;
    private String suitFullDomain;
    private String tenantCode;
    private String tenantId;
    private String tenantName;
    private int tenantTag;
    private String unitLeague;
    private boolean upgradeEnabled;
    private String userAvatarUrl;
    private String userId;
    private String userName;
    private String userNameEn;
    private String userUnit;

    public static class PendingUser implements Serializable {

        @JSONField(name = "user_env")
        public String configEnv;
        public String tenantIconUrl;
        public String tenantId;
        public String tenantName;
        public String userName;
        public String userUnit;

        public PendingUser() {
        }
    }

    public boolean isToCUnRegistered() {
        return false;
    }

    public void setActive(boolean r100) {
    }

    public boolean canSwitchTo() {
        int r100 = this.status;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 3) goto L8;
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, Integer.valueOf(this.badgeCount), Boolean.valueOf(this.isCurrentUser), this.userName, this.userNameEn, this.chatterAvatarKey, this.avatarUrl, this.tenantId, this.tenantName, this.tenantCode, Boolean.FALSE, this.userUnit, Integer.valueOf(this.tenantTag), this.accountSecurityConfig, Boolean.valueOf(this.isIdp)});
    }

    public boolean isFrozen() {
        if (this.status != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNewUser() {
        if (this.status != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public void setUpgradeEnabled() {
        this.upgradeEnabled = this.upgradeEnabled;
    }

    public String toString() {
        return "TenantInfo{userId='" + this.userId + "', tenantId='" + this.tenantId + "', userUnit='" + this.userUnit + "', tenantTag='" + this.tenantTag + "', isIdp='" + this.isIdp + "', status='" + this.status + ", isSessionValid='" + isSessionValid() + "', isNewUser='" + isNewUser() + "', canSwitchTo='" + canSwitchTo() + "'}";
    }

    public TenantInfo() {
        this.isCurrentUser = false;
        this.upgradeEnabled = false;
        this.isToCUnRegistered = false;
    }

    public AccountSecurityConfig getAccountSecurityConfig() {
        return this.accountSecurityConfig;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public String getChatterAvatarKey() {
        return this.chatterAvatarKey;
    }

    public String getConfigEnv() {
        return this.configEnv;
    }

    public long getLastUseTimestamp() {
        return this.lastUseTimestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSuitFullDomain() {
        return this.suitFullDomain;
    }

    public String getTenantCode() {
        return this.tenantCode;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public int getTenantTag() {
        return this.tenantTag;
    }

    public String getUnitLeague() {
        return this.unitLeague;
    }

    public String getUserAvatarUrl() {
        return this.userAvatarUrl;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserNameEn() {
        return this.userNameEn;
    }

    public String getUserUnit() {
        return this.userUnit;
    }

    public boolean isCurrentUser() {
        return this.isCurrentUser;
    }

    public boolean isIdp() {
        return this.isIdp;
    }

    public boolean isSessionValid() {
        return this.isSessionValid;
    }

    public boolean isUpgradeEnabled() {
        return this.upgradeEnabled;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L43:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L43;
        TenantInfo r101 = (TenantInfo) r100;
        if (this.badgeCount == r101.badgeCount) goto L13;
    L41:
        return false;
    L13:
        if (this.isCurrentUser != r101.isCurrentUser) goto L41;
        if (this.tenantTag != r101.tenantTag) goto L41;
        if (this.isIdp != r101.isIdp) goto L41;
        if (this.status != r101.status) goto L41;
        if (Objects.equals(this.userId, r101.userId) == false) goto L41;
        if (Objects.equals(this.userName, r101.userName) == false) goto L41;
        if (Objects.equals(this.userNameEn, r101.userNameEn) == false) goto L41;
        if (Objects.equals(this.chatterAvatarKey, r101.chatterAvatarKey) == false) goto L41;
        if (Objects.equals(this.avatarUrl, r101.avatarUrl) == false) goto L41;
        if (Objects.equals(this.tenantId, r101.tenantId) == false) goto L41;
        if (Objects.equals(this.tenantName, r101.tenantName) == false) goto L41;
        if (Objects.equals(this.tenantCode, r101.tenantCode) == false) goto L41;
        if (Objects.equals(this.userUnit, r101.userUnit) == false) goto L41;
        if (Objects.equals(this.accountSecurityConfig, r101.accountSecurityConfig) == false) goto L41;
        return true;
    }

    public void setAccountSecurityConfig(AccountSecurityConfig r100) {
        this.accountSecurityConfig = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setBadgeCount(int r100) {
        this.badgeCount = r100;
    }

    public void setChatterAvatarKey(String r100) {
        this.chatterAvatarKey = r100;
    }

    public void setConfigEnv(String r100) {
        this.configEnv = r100;
    }

    public void setCurrentUser(boolean r100) {
        this.isCurrentUser = r100;
    }

    public void setIdp(boolean r100) {
        this.isIdp = r100;
    }

    public void setSessionValid(boolean r100) {
        this.isSessionValid = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setSuitFullDomain(String r100) {
        this.suitFullDomain = r100;
    }

    public void setTenantCode(String r100) {
        this.tenantCode = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setTenantName(String r100) {
        this.tenantName = r100;
    }

    public void setTenantTag(int r100) {
        this.tenantTag = r100;
    }

    public void setUnitLeague(String r100) {
        this.unitLeague = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setUserName(String r100) {
        this.userName = r100;
    }

    public void setUserNameEn(String r100) {
        this.userNameEn = r100;
    }

    public void setUserUnit(String r100) {
        this.userUnit = r100;
    }

    public static TenantInfo fromUser(User r210, Locale r211, boolean r212, boolean r213) {
        Tenant r100 = r210.tenant;
        if (r100 == null) goto L5;
        String r101 = r100.localizedName(r211);
    L6:
        String r102 = r210.userId;
        String r103 = r210.localizedDisplayName(r211);
        I18Name r104 = r210.i18Name;
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        String r106 = r210.getTenantId();
        String r107 = r210.getTenantCode();
        String r110 = r210.avatarKey;
        String r111 = r210.getTenantIconUrl();
        String r112 = r210.configEnv;
        String r113 = r210.userUnit;
        int r114 = r210.getTenantTag();
        AccountSecurityConfig r115 = r210.accountSecurityConfig;
        boolean r108 = r210.isIdp;
        String r116 = r210.avatarUrl;
        Tenant r109 = r210.tenant;
        if (r109 != null) goto L13;
        String r214 = "";
    L15:
        return new TenantInfo(r102, r103, r105, r106, r101, r107, r110, r111, 0, r212, r112, r113, r114, r115, r108, r116, r214, "", r210.getStatus(), r213, r210.getLastUseTimestamp());
    L13:
        r214 = r109.suiteFullDomain;
        goto L15
    L9:
        r105 = r104.enUs;
        goto L10
    L5:
        r101 = "";
        goto L6
    }

    public TenantInfo(String r210, String r211, String r212, String r213, String r214, String r215, String r310, String r311, int r312, boolean r313, boolean r314, String r315, String r316, int r317, AccountSecurityConfig r318, boolean r319, String r410, String r411, String r412, long r413) {
        this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r315, r316, r317, r318, r319, r410, r411, r412, 0, false, r413);
    }

    public TenantInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111, int r112, boolean r113, String r114, String r115, int r116, AccountSecurityConfig r117, boolean r118, String r119, String r210, String r211, int r212, boolean r213, long r214) {
        this.upgradeEnabled = false;
        this.isToCUnRegistered = false;
        this.userId = r100;
        this.userName = r101;
        this.userNameEn = r102;
        this.tenantId = r103;
        this.tenantName = r104;
        this.tenantCode = r105;
        this.chatterAvatarKey = r110;
        this.avatarUrl = r111;
        this.badgeCount = r112;
        this.isCurrentUser = r113;
        this.configEnv = r114;
        this.userUnit = r115;
        this.tenantTag = r116;
        this.accountSecurityConfig = r117;
        this.isIdp = r118;
        this.userAvatarUrl = r119;
        this.suitFullDomain = r210;
        this.unitLeague = r211;
        this.status = r212;
        this.isSessionValid = r213;
        this.lastUseTimestamp = r214;
    }
}
