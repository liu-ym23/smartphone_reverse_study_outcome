package com.huawei.hms.support.feature.request;

import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractAuthParamsHelper {
    protected Set<PermissionInfo> permissionSet;
    protected Set<Scope> signInScopes;

    public AbstractAuthParamsHelper() {
        this.signInScopes = new HashSet();
        this.permissionSet = new HashSet();
    }

    public AbstractAuthParamsHelper(AbstractAuthParams r100) {
        this.signInScopes = new HashSet();
        this.permissionSet = new HashSet();
        this.signInScopes.addAll(r100.getRequestScopeList());
        this.permissionSet.addAll(r100.getPermissionInfos());
    }
}
