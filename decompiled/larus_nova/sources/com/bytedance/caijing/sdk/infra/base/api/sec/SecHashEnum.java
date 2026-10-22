package com.bytedance.caijing.sdk.infra.base.api.sec;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum SecHashEnum extends Enum<SecHashEnum> {
    public static final SecHashEnum HASH_ALG_NONE = null;
    public static final SecHashEnum HASH_ALG_SM3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecHashEnum[] f202247a = null;

    static {
        SecHashEnum r100 = new SecHashEnum("HASH_ALG_NONE", 0);
        HASH_ALG_NONE = r100;
        SecHashEnum r101 = new SecHashEnum("HASH_ALG_SM3", 1);
        HASH_ALG_SM3 = r101;
        f202247a = new SecHashEnum[]{r100, r101};
    }

    public static SecHashEnum[] values() {
        return (SecHashEnum[]) f202247a.clone();
    }

    public static SecHashEnum valueOf(String r100) {
        return (SecHashEnum) a.a(SecHashEnum.class, r100);
    }

    public SecHashEnum(String r100, int r101) {
        super(r100, r101);
    }
}
