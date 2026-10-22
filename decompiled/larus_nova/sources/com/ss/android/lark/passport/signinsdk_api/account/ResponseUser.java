package com.ss.android.lark.passport.signinsdk_api.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public class ResponseUser implements Serializable {

    @JSONField(name = "current_env")
    private String currentEnv;

    @JSONField(name = "device_login_id")
    private String deviceLoginId;

    @JSONField(name = a.KEY_IS_ANONYMOUS)
    private boolean isAnonymous;

    @JSONField(name = "is_new_active")
    public boolean isNewActive;

    @JSONField(name = "logout_token")
    private String logoutToken;
    private Map<String, SessionInfo> sessionMap;

    @JSONField(name = "session_uuid")
    private String sessionUuid;

    @JSONField(name = "suite_session_key_with_domains")
    private Map<String, SessionInfo> sessionWithDomainMap;

    @JSONField(alternateNames = {"slSession"}, name = "sl_session")
    private String slSession;

    @JSONField(name = "suite_session_key")
    private String suiteSessionKey;

    @JSONField(name = "user")
    private User user;

    public ResponseUser() {
        this.sessionMap = new HashMap();
    }

    public String getCurrentEnv() {
        return this.currentEnv;
    }

    public String getDeviceLoginId() {
        return this.deviceLoginId;
    }

    public String getLogoutToken() {
        return this.logoutToken;
    }

    public String getSession() {
        return this.suiteSessionKey;
    }

    public Map<String, SessionInfo> getSessionMap() {
        return this.sessionMap;
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

    public String getSuiteSessionKey() {
        return this.suiteSessionKey;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    public void setCurrentEnv(String r100) {
        this.currentEnv = r100;
    }

    public void setDeviceLoginId(String r100) {
        this.deviceLoginId = r100;
    }

    public void setLogoutToken(String r100) {
        this.logoutToken = r100;
    }

    public void setSession(String r100) {
        this.suiteSessionKey = r100;
    }

    public void setSessionMap(Map<String, SessionInfo> r100) {
        this.sessionMap = r100;
    }

    public void setSessionUuid(String r100) {
        this.sessionUuid = r100;
    }

    public void setSessionWithDomainMap(Map<String, SessionInfo> r100) {
        this.sessionWithDomainMap = r100;
    }

    public void setSlSession(String r100) {
        this.slSession = r100;
    }

    public void setSuiteSessionKey(String r100) {
        this.suiteSessionKey = r100;
    }

    public void setUser(User r100) {
        this.user = r100;
    }

    public ResponseUser(String r100, String r101) {
        this(r100, r101, null);
    }

    public ResponseUser(String r100, String r101, Map<String, SessionInfo> r102) {
        this.sessionMap = new HashMap();
        this.suiteSessionKey = r101;
        if (r102 == null) goto L11;
        Iterator<Map.Entry<String, SessionInfo>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, SessionInfo> r104 = r103.next();
        SessionInfo r105 = r104.getValue();
        if (r105 == null) goto L7;
        r105.setHostUrl(r104.getKey());
        this.sessionMap.put(r104.getKey(), r105);
        goto L7
    L17:
        return;
    }
}
