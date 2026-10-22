package com.ss.android.lark.passport.signinsdk_api.entity;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public class LoginInfo implements Serializable {
    private String avatarKey;
    private String avatarUrl;
    private String idpType;
    private String session;
    private Map<String, SessionInfo> sessionInfoMap;
    private String sessionUuid;
    private String tenantCode;
    private String tenantIconUrl;
    private String tenantId;
    private String tenantName;
    private String userId;
    private String userName;
    private String userNameEn;

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, this.tenantId, this.session});
    }

    public String toString() {
        return "userId:" + this.userId + ", tenantId:" + this.tenantId + ", idpType:" + this.idpType;
    }

    public LoginInfo() {
        this.sessionInfoMap = new HashMap();
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getIdpType() {
        return this.idpType;
    }

    public String getSession() {
        return this.session;
    }

    public Map<String, SessionInfo> getSessionInfoMap() {
        return this.sessionInfoMap;
    }

    public String getSessionUuid() {
        return this.sessionUuid;
    }

    public String getTenantCode() {
        return this.tenantCode;
    }

    public String getTenantIconUrl() {
        return this.tenantIconUrl;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        LoginInfo r101 = (LoginInfo) r100;
        if (Objects.equals(this.userId, r101.userId) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.tenantId, r101.tenantId) == false) goto L17;
        if (Objects.equals(this.session, r101.session) == false) goto L17;
        return true;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setIdpType(String r100) {
        this.idpType = r100;
    }

    public void setSession(String r100) {
        this.session = r100;
    }

    public void setSessionInfoMap(Map<String, SessionInfo> r100) {
        this.sessionInfoMap = r100;
    }

    public void setSessionUuid(String r100) {
        this.sessionUuid = r100;
    }

    public void setTenantCode(String r100) {
        Log.i("LoginInfo", "tenantCode=" + r100);
        this.tenantCode = r100;
    }

    public void setTenantIconUrl(String r100) {
        this.tenantIconUrl = r100;
    }

    public void setTenantId(String r100) {
        Log.i("LoginInfo", "tenantId=" + r100);
        this.tenantId = r100;
    }

    public void setTenantName(String r100) {
        this.tenantName = r100;
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

    public static LoginInfo fromUser(User r100, Locale r101, String r102) {
        LoginInfo r103 = new LoginInfo();
        r103.session = r100.getSession();
        r103.sessionInfoMap = r100.getSessionWithDomainMap();
        r103.userId = r100.userId;
        r103.userName = r100.localizedDisplayName(r101);
        r103.userNameEn = r100.getUserNameEn();
        r103.avatarUrl = r100.avatarUrl;
        r103.avatarKey = r100.avatarKey;
        com.ss.android.lark.passport.signinsdk_api.account.Tenant r104 = r100.tenant;
        r103.tenantId = r104.tenantId;
        r103.tenantName = r104.localizedName(r101);
        r103.tenantIconUrl = r100.getTenantIconUrl();
        r103.tenantCode = r100.getTenantCode();
        r103.idpType = r102;
        return r103;
    }
}
