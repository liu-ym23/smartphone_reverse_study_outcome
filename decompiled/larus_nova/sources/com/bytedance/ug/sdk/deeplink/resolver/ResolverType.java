package com.bytedance.ug.sdk.deeplink.resolver;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum ResolverType extends Enum<ResolverType> {
    public static final ResolverType TYPE_APP_LINK = null;
    public static final ResolverType TYPE_DEEP_LINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResolverType[] f271065a = null;

    static {
        ResolverType r100 = new ResolverType("TYPE_APP_LINK", 0);
        TYPE_APP_LINK = r100;
        ResolverType r101 = new ResolverType("TYPE_DEEP_LINK", 1);
        TYPE_DEEP_LINK = r101;
        f271065a = new ResolverType[]{r100, r101};
    }

    public static ResolverType[] values() {
        return (ResolverType[]) f271065a.clone();
    }

    public static ResolverType valueOf(String r100) {
        return (ResolverType) a.a(ResolverType.class, r100);
    }

    public ResolverType(String r100, int r101) {
        super(r100, r101);
    }
}
