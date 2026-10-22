package com.bytedance.ee.bear.middleground.docsdk.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
final enum SDKV2Plugins$Level extends Enum<SDKV2Plugins$Level> {
    public static final SDKV2Plugins$Level At = null;
    public static final SDKV2Plugins$Level InsertNewBlock = null;
    public static final SDKV2Plugins$Level Toolbar = null;
    public static final SDKV2Plugins$Level ToolbarV2 = null;
    public static final /* synthetic */ SDKV2Plugins$Level[] a = null;

    static {
        SDKV2Plugins$Level r0 = new SDKV2Plugins$Level("Toolbar", 0);
        Toolbar = r0;
        SDKV2Plugins$Level r1 = new SDKV2Plugins$Level("ToolbarV2", 1);
        ToolbarV2 = r1;
        SDKV2Plugins$Level r3 = new SDKV2Plugins$Level("At", 2);
        At = r3;
        SDKV2Plugins$Level r5 = new SDKV2Plugins$Level("InsertNewBlock", 3);
        InsertNewBlock = r5;
        a = new SDKV2Plugins$Level[]{r0, r1, r3, r5};
    }

    public static SDKV2Plugins$Level[] values() {
        return (SDKV2Plugins$Level[]) a.clone();
    }

    public static SDKV2Plugins$Level valueOf(String r1) {
        return (SDKV2Plugins$Level) r27.a.a(SDKV2Plugins$Level.class, r1);
    }

    public SDKV2Plugins$Level(String r1, int r2) {
        super(r1, r2);
    }
}
