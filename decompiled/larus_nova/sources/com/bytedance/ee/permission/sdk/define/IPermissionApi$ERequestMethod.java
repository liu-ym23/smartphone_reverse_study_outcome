package com.bytedance.ee.permission.sdk.define;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/ee/permission/sdk/define/IPermissionApi$ERequestMethod", "", "Lcom/bytedance/ee/permission/sdk/define/IPermissionApi$ERequestMethod;", "GET", "POST", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final enum IPermissionApi$ERequestMethod extends Enum<IPermissionApi$ERequestMethod> {
    public static final IPermissionApi$ERequestMethod GET = null;
    public static final IPermissionApi$ERequestMethod POST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IPermissionApi$ERequestMethod[] f243045a = null;

    public static IPermissionApi$ERequestMethod valueOf(String r100) {
        return (IPermissionApi$ERequestMethod) a.a(IPermissionApi$ERequestMethod.class, r100);
    }

    public static IPermissionApi$ERequestMethod[] values() {
        return (IPermissionApi$ERequestMethod[]) f243045a.clone();
    }

    static {
        IPermissionApi$ERequestMethod r100 = new IPermissionApi$ERequestMethod("GET", 0);
        GET = r100;
        IPermissionApi$ERequestMethod r101 = new IPermissionApi$ERequestMethod("POST", 1);
        POST = r101;
        f243045a = new IPermissionApi$ERequestMethod[]{r100, r101};
    }

    public IPermissionApi$ERequestMethod(String r100, int r101) {
        super(r100, r101);
    }
}
