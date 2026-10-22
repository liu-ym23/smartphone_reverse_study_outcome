package com.huawei.hms.support.hwid.request;

import com.huawei.hms.hwid.ap;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import com.huawei.hms.support.feature.request.AbstractAuthParamsHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class HuaweiIdAuthParamsHelper extends AbstractAuthParamsHelper {
    public HuaweiIdAuthParamsHelper setDialogAuth() {
        return this;
    }

    public HuaweiIdAuthParams createParams() {
        return new HuaweiIdAuthParams(this.signInScopes, this.permissionSet);
    }

    public HuaweiIdAuthParamsHelper setAccessToken() {
        PermissionInfo r100 = new PermissionInfo();
        r100.setPermissionUri(CommonConstant.LocalPermission.ACCESS_TOKEN);
        this.permissionSet.add(r100);
        return this;
    }

    public HuaweiIdAuthParamsHelper setAuthorizationCode() {
        PermissionInfo r100 = new PermissionInfo();
        r100.setPermissionUri(CommonConstant.LocalPermission.SERVICE_AUTH_CODE);
        this.permissionSet.add(r100);
        return this;
    }

    public HuaweiIdAuthParamsHelper setEmail() {
        return setScope(AbstractAuthParams.EMAIL);
    }

    public HuaweiIdAuthParamsHelper setId() {
        return setScope(AbstractAuthParams.OPENID);
    }

    public HuaweiIdAuthParamsHelper setIdToken() {
        PermissionInfo r100 = new PermissionInfo().setPermissionUri(CommonConstant.PERMISSION.IDTOKEN);
        this.permissionSet.add(r100);
        return this;
    }

    public HuaweiIdAuthParamsHelper setProfile() {
        return setScope(AbstractAuthParams.PROFILE);
    }

    public HuaweiIdAuthParamsHelper setUid() {
        this.permissionSet.add(AbstractAuthParams.UID_DYNAMIC_PERMISSION);
        return this;
    }

    public HuaweiIdAuthParamsHelper setMobileNumber() {
        setAccessToken();
        setId();
        return setScope(new Scope(CommonConstant.SCOPE.SCOPE_MOBILE_NUMBER));
    }

    public HuaweiIdAuthParamsHelper setShippingAddress() {
        setAccessToken();
        setId();
        return setScope(new Scope(CommonConstant.SCOPE.SCOPE_ACCOUNT_SHIPPING_ADDRESS));
    }

    public HuaweiIdAuthParamsHelper() {
    }

    public HuaweiIdAuthParamsHelper(HuaweiIdAuthParams r100) {
        this.signInScopes.addAll(r100.getRequestScopeList());
        this.permissionSet.addAll(r100.getPermissionInfos());
    }

    public HuaweiIdAuthParamsHelper setIncludeGranted(boolean r100) {
        if (r100 == true) goto L4;
        PermissionInfo r101 = new PermissionInfo();
        r101.setPermissionUri(CommonConstant.IncludeGranted.NON_INCLUDE_GRANTED);
        this.permissionSet.add(r101);
    L4:
        return this;
    }

    public HuaweiIdAuthParamsHelper setScope(Scope r100) {
        this.signInScopes.add(r100);
        return this;
    }

    public HuaweiIdAuthParamsHelper setScopeList(List<Scope> r100) {
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
}
