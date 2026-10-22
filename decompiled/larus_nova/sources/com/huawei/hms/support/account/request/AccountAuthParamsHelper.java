package com.huawei.hms.support.account.request;

import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import com.huawei.hms.support.feature.request.AbstractAuthParamsHelper;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AccountAuthParamsHelper extends AbstractAuthParamsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f277696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f277697d;

    public AccountAuthParamsHelper setDialogAuth() {
        return this;
    }

    public AccountAuthParamsHelper setForceRefresh() {
        this.f277696c = true;
        return this;
    }

    public AccountAuthParamsHelper setNeedConsent() {
        this.f277697d = true;
        return this;
    }

    public AccountAuthParams createParams() {
        JSONObject r100 = new JSONObject();
        r100.put("sessionId", this.f277694a);     // Catch: JSONException -> L6
        r100.put(CommonConstant.RequestParams.KEY_ID_TOKEN_SIGN_ALG, this.f277695b);     // Catch: JSONException -> L6
        r100.put(CommonConstant.RequestParams.KEY_ID_FORCE_REFRESH, this.f277696c);     // Catch: JSONException -> L6
        r100.put(CommonConstant.RequestParams.KEY_ID_NEED_CONSENT, this.f277697d);     // Catch: JSONException -> L6
        return new AccountAuthParams(this.signInScopes, this.permissionSet, r100.toString());
    L6:
        e = move-exception;
        as.d("AccountAuthParamsHelper", "JSONException：".concat(e.getClass().getSimpleName()), true);
        return new AccountAuthParams(this.signInScopes, this.permissionSet);
    }

    public AccountAuthParamsHelper setAccessToken() {
        PermissionInfo r100 = new PermissionInfo();
        r100.setPermissionUri(CommonConstant.LocalPermission.ACCESS_TOKEN);
        this.permissionSet.add(r100);
        return this;
    }

    public AccountAuthParamsHelper setAssistToken() {
        PermissionInfo r100 = new PermissionInfo();
        r100.setPermissionUri(CommonConstant.PERMISSION.ASSIST_TOKEN);
        this.permissionSet.add(r100);
        Scope r101 = new Scope(CommonConstant.SCOPE.SCOPE_ASSIST_TOKEN);
        this.signInScopes.add(r101);
        return this;
    }

    public AccountAuthParamsHelper setAuthorizationCode() {
        PermissionInfo r100 = new PermissionInfo();
        r100.setPermissionUri(CommonConstant.LocalPermission.SERVICE_AUTH_CODE);
        this.permissionSet.add(r100);
        return this;
    }

    public AccountAuthParamsHelper setCarrierId() {
        PermissionInfo r100 = new PermissionInfo();
        r100.setPermissionUri(CommonConstant.LocalPermission.CARRIER_ID);
        this.permissionSet.add(r100);
        return this;
    }

    public AccountAuthParamsHelper setEmail() {
        return setScope(AbstractAuthParams.EMAIL);
    }

    public AccountAuthParamsHelper setForceLogout() {
        PermissionInfo r100 = new PermissionInfo();
        r100.setPermissionUri(CommonConstant.LocalPermission.SETFORCELOGOUT);
        this.permissionSet.add(r100);
        return this;
    }

    public AccountAuthParamsHelper setId() {
        return setScope(AbstractAuthParams.OPENID);
    }

    public AccountAuthParamsHelper setIdToken() {
        PermissionInfo r100 = new PermissionInfo().setPermissionUri(CommonConstant.PERMISSION.IDTOKEN);
        this.permissionSet.add(r100);
        return this;
    }

    public AccountAuthParamsHelper setProfile() {
        return setScope(AbstractAuthParams.PROFILE);
    }

    public AccountAuthParamsHelper setUid() {
        this.permissionSet.add(AbstractAuthParams.UID_DYNAMIC_PERMISSION);
        return this;
    }

    public AccountAuthParamsHelper() {
        this.f277694a = "";
        this.f277695b = 2;
        this.f277696c = false;
        this.f277697d = false;
    }

    public AccountAuthParamsHelper setMobileNumber() {
        setAccessToken();
        setId();
        return setScope(new Scope(CommonConstant.SCOPE.SCOPE_MOBILE_NUMBER));
    }

    public AccountAuthParamsHelper(AccountAuthParams r100) {
        this.f277694a = "";
        this.f277695b = 2;
        this.f277696c = false;
        this.f277697d = false;
        this.signInScopes.addAll(r100.getRequestScopeList());
        this.permissionSet.addAll(r100.getPermissionInfos());
    }

    public AccountAuthParamsHelper setIdTokenSignAlg(int r100) {
        this.f277695b = r100;
        return this;
    }

    public AccountAuthParamsHelper setScope(Scope r100) {
        this.signInScopes.add(r100);
        return this;
    }

    public AccountAuthParamsHelper setScopeList(List<Scope> r100) {
        if (ap.b(r100).booleanValue() == false) goto L12;
        Iterator<Scope> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L12;
        Scope r102 = r101.next();
        if (r102 == null) goto L6;
        if (r102.getScopeUri() == null) goto L6;
        this.signInScopes.add(r102);
    L12:
        return this;
    }

    public AccountAuthParamsHelper setSessionId(String r100) {
        this.f277694a = r100;
        return this;
    }
}
