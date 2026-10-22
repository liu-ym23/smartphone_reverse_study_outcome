package com.bytedance.ee.lark.infra.storage.sp.base;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum AppBaseStorage$StorageType extends Enum<AppBaseStorage$StorageType> {
    public static final AppBaseStorage$StorageType APP_ENGINE = null;
    public static final AppBaseStorage$StorageType APP_SANDBOX = null;
    public static final AppBaseStorage$StorageType APP_SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppBaseStorage$StorageType[] f242813a = null;

    static {
        AppBaseStorage$StorageType r100 = new AppBaseStorage$StorageType("APP_SANDBOX", 0);
        APP_SANDBOX = r100;
        AppBaseStorage$StorageType r101 = new AppBaseStorage$StorageType("APP_ENGINE", 1);
        APP_ENGINE = r101;
        AppBaseStorage$StorageType r102 = new AppBaseStorage$StorageType("APP_SHARE", 2);
        APP_SHARE = r102;
        f242813a = new AppBaseStorage$StorageType[]{r100, r101, r102};
    }

    public static AppBaseStorage$StorageType[] values() {
        return (AppBaseStorage$StorageType[]) f242813a.clone();
    }

    public static AppBaseStorage$StorageType valueOf(String r100) {
        return (AppBaseStorage$StorageType) a.a(AppBaseStorage$StorageType.class, r100);
    }

    public AppBaseStorage$StorageType(String r100, int r101) {
        super(r100, r101);
    }
}
