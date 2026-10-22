package com.bytedance.env.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/env/api/AccessKeyType;", "", "INHOUSE", "ONLINE", "BOE", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final enum AccessKeyType extends Enum<AccessKeyType> {
    public static final AccessKeyType BOE = null;
    public static final AccessKeyType INHOUSE = null;
    public static final AccessKeyType ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccessKeyType[] f243172a = null;

    static {
        AccessKeyType r100 = new AccessKeyType("INHOUSE", 0);
        INHOUSE = r100;
        AccessKeyType r101 = new AccessKeyType("ONLINE", 1);
        ONLINE = r101;
        AccessKeyType r102 = new AccessKeyType("BOE", 2);
        BOE = r102;
        f243172a = new AccessKeyType[]{r100, r101, r102};
    }

    public static AccessKeyType valueOf(String r100) {
        return (AccessKeyType) r27.a.a(AccessKeyType.class, r100);
    }

    public static AccessKeyType[] values() {
        return (AccessKeyType[]) f243172a.clone();
    }

    public AccessKeyType(String r100, int r101) {
        super(r100, r101);
    }
}
