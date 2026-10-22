package com.tt.refer.common.base;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum AppType extends Enum<AppType> {
    public static final AppType BlockitApp = null;
    public static final AppType BotApp = null;
    public static final AppType CardAPP = null;
    public static final AppType DynamicComponent = null;
    public static final AppType FlattenBlockitApp = null;
    public static final AppType GadgetAPP = null;
    public static final AppType GadgetGame = null;
    public static final AppType NativeApp = null;
    public static final AppType UnKnown = null;
    public static final AppType WebAPP = null;
    public static final AppType WebGadgetAPP = null;
    public static final AppType WebGadgetGame = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppType[] f461914a = null;

    static {
        AppType r100 = new AppType("UnKnown", 0);
        UnKnown = r100;
        AppType r101 = new AppType("GadgetAPP", 1);
        GadgetAPP = r101;
        AppType r102 = new AppType("GadgetGame", 2);
        GadgetGame = r102;
        AppType r103 = new AppType("WebGadgetAPP", 3);
        WebGadgetAPP = r103;
        AppType r104 = new AppType("WebGadgetGame", 4);
        WebGadgetGame = r104;
        AppType r105 = new AppType("WebAPP", 5);
        WebAPP = r105;
        AppType r110 = new AppType("CardAPP", 6);
        CardAPP = r110;
        AppType r111 = new AppType("BlockitApp", 7);
        BlockitApp = r111;
        AppType r112 = new AppType("BotApp", 8);
        BotApp = r112;
        AppType r113 = new AppType("DynamicComponent", 9);
        DynamicComponent = r113;
        AppType r114 = new AppType("FlattenBlockitApp", 10);
        FlattenBlockitApp = r114;
        AppType r115 = new AppType("NativeApp", 11);
        NativeApp = r115;
        f461914a = new AppType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static AppType[] values() {
        return (AppType[]) f461914a.clone();
    }

    public static AppType valueOf(String r100) {
        return (AppType) a.a(AppType.class, r100);
    }

    public AppType(String r100, int r101) {
        super(r100, r101);
    }
}
