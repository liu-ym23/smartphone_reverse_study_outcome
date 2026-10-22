package com.bytedance.ee.permission.define;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/permission/define/IPermissionApi$ERequestMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IPermissionApi$ERequestMethod extends Enum<IPermissionApi$ERequestMethod> {
    public static final IPermissionApi$ERequestMethod GET = null;
    public static final IPermissionApi$ERequestMethod POST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IPermissionApi$ERequestMethod[] f243026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243027b = null;

    public static EnumEntries<IPermissionApi$ERequestMethod> getEntries() {
        return f243027b;
    }

    static {
        IPermissionApi$ERequestMethod r100 = new IPermissionApi$ERequestMethod("GET", 0);
        GET = r100;
        IPermissionApi$ERequestMethod r101 = new IPermissionApi$ERequestMethod("POST", 1);
        POST = r101;
        IPermissionApi$ERequestMethod[] r102 = {r100, r101};
        f243026a = r102;
        f243027b = EnumEntriesKt.enumEntries(r102);
    }

    public static IPermissionApi$ERequestMethod[] values() {
        return (IPermissionApi$ERequestMethod[]) f243026a.clone();
    }

    public static IPermissionApi$ERequestMethod valueOf(String r100) {
        return (IPermissionApi$ERequestMethod) a.a(IPermissionApi$ERequestMethod.class, r100);
    }

    public IPermissionApi$ERequestMethod(String r100, int r101) {
        super(r100, r101);
    }
}
