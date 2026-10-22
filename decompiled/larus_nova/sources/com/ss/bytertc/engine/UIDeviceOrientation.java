package com.ss.bytertc.engine;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum UIDeviceOrientation extends Enum<UIDeviceOrientation> {
    private static final /* synthetic */ UIDeviceOrientation[] $VALUES = null;
    public static final UIDeviceOrientation LandscapeLeft = null;
    public static final UIDeviceOrientation LandscapeRight = null;
    public static final UIDeviceOrientation Portrait = null;
    public static final UIDeviceOrientation PortraitUpsidedown = null;
    private int value;

    static {
        UIDeviceOrientation r100 = new UIDeviceOrientation("Portrait", 0, 0);
        Portrait = r100;
        UIDeviceOrientation r101 = new UIDeviceOrientation("LandscapeLeft", 1, 90);
        LandscapeLeft = r101;
        UIDeviceOrientation r102 = new UIDeviceOrientation("PortraitUpsidedown", 2, 180);
        PortraitUpsidedown = r102;
        UIDeviceOrientation r103 = new UIDeviceOrientation("LandscapeRight", 3, 270);
        LandscapeRight = r103;
        $VALUES = new UIDeviceOrientation[]{r100, r101, r102, r103};
    }

    public static UIDeviceOrientation[] values() {
        return (UIDeviceOrientation[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static UIDeviceOrientation valueOf(String r100) {
        return (UIDeviceOrientation) a.a(UIDeviceOrientation.class, r100);
    }

    private UIDeviceOrientation(String r100, int r101) {
        super(r100, r101);
        this.value = 0;
    }

    private UIDeviceOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
