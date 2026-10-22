package com.bytedance.ee.lark.infra.network.larkbrand.net;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum MiniEnvType extends Enum<MiniEnvType> {
    public static final MiniEnvType PRE_RELEASE = null;
    public static final MiniEnvType RELEASE = null;
    public static final MiniEnvType STAGING = null;
    public static final MiniEnvType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MiniEnvType[] f242803a = null;
    private String status;

    static {
        MiniEnvType r100 = new MiniEnvType("RELEASE", 0, "online");
        RELEASE = r100;
        MiniEnvType r101 = new MiniEnvType("STAGING", 1, "staging");
        STAGING = r101;
        MiniEnvType r102 = new MiniEnvType("PRE_RELEASE", 2, "pre_release");
        PRE_RELEASE = r102;
        MiniEnvType r103 = new MiniEnvType("UNKNOWN", 3, "unknown");
        UNKNOWN = r103;
        f242803a = new MiniEnvType[]{r100, r101, r102, r103};
    }

    public static MiniEnvType[] values() {
        return (MiniEnvType[]) f242803a.clone();
    }

    public String getValue() {
        return this.status;
    }

    public static MiniEnvType forNumber(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return UNKNOWN;
    L11:
        return PRE_RELEASE;
    L13:
        return STAGING;
    L15:
        return RELEASE;
    }

    public static MiniEnvType valueOf(String r100) {
        return (MiniEnvType) a.a(MiniEnvType.class, r100);
    }

    public MiniEnvType(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
