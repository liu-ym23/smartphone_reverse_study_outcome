package com.bytedance.ee.bear.middleground.docsdk.v2;

/* JADX INFO: loaded from: classes18.dex */
final enum SDKV2Plugins$Level extends Enum<SDKV2Plugins$Level> {
    public static final SDKV2Plugins$Level At = null;
    public static final SDKV2Plugins$Level InsertNewBlock = null;
    public static final SDKV2Plugins$Level Toolbar = null;
    public static final SDKV2Plugins$Level ToolbarV2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SDKV2Plugins$Level[] f232393a = null;

    static {
        SDKV2Plugins$Level r100 = new SDKV2Plugins$Level("Toolbar", 0);
        Toolbar = r100;
        SDKV2Plugins$Level r101 = new SDKV2Plugins$Level("ToolbarV2", 1);
        ToolbarV2 = r101;
        SDKV2Plugins$Level r102 = new SDKV2Plugins$Level("At", 2);
        At = r102;
        SDKV2Plugins$Level r103 = new SDKV2Plugins$Level("InsertNewBlock", 3);
        InsertNewBlock = r103;
        f232393a = new SDKV2Plugins$Level[]{r100, r101, r102, r103};
    }

    public static SDKV2Plugins$Level[] values() {
        return (SDKV2Plugins$Level[]) f232393a.clone();
    }

    public static SDKV2Plugins$Level valueOf(String r100) {
        return (SDKV2Plugins$Level) r27.a.a(SDKV2Plugins$Level.class, r100);
    }

    public SDKV2Plugins$Level(String r100, int r101) {
        super(r100, r101);
    }
}
