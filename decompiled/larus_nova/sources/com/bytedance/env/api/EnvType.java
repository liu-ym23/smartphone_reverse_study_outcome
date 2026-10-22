package com.bytedance.env.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/env/api/EnvType;", "", "PRODUCT", "CANARY", "PPE", "BOE", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final enum EnvType extends Enum<EnvType> {
    public static final EnvType BOE = null;
    public static final EnvType CANARY = null;
    public static final EnvType PPE = null;
    public static final EnvType PRODUCT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvType[] f243173a = null;

    static {
        EnvType r100 = new EnvType("PRODUCT", 0);
        PRODUCT = r100;
        EnvType r101 = new EnvType("CANARY", 1);
        CANARY = r101;
        EnvType r102 = new EnvType("PPE", 2);
        PPE = r102;
        EnvType r103 = new EnvType("BOE", 3);
        BOE = r103;
        f243173a = new EnvType[]{r100, r101, r102, r103};
    }

    public static EnvType valueOf(String r100) {
        return (EnvType) r27.a.a(EnvType.class, r100);
    }

    public static EnvType[] values() {
        return (EnvType[]) f243173a.clone();
    }

    public EnvType(String r100, int r101) {
        super(r100, r101);
    }
}
