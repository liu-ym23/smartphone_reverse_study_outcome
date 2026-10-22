package com.gyf.barlibrary;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum BarHide extends Enum<BarHide> {
    private static final /* synthetic */ BarHide[] $VALUES = null;
    public static final BarHide FLAG_HIDE_BAR = null;
    public static final BarHide FLAG_HIDE_NAVIGATION_BAR = null;
    public static final BarHide FLAG_HIDE_STATUS_BAR = null;
    public static final BarHide FLAG_SHOW_BAR = null;

    static {
        BarHide r100 = new BarHide("FLAG_HIDE_STATUS_BAR", 0);
        FLAG_HIDE_STATUS_BAR = r100;
        BarHide r101 = new BarHide("FLAG_HIDE_NAVIGATION_BAR", 1);
        FLAG_HIDE_NAVIGATION_BAR = r101;
        BarHide r102 = new BarHide("FLAG_HIDE_BAR", 2);
        FLAG_HIDE_BAR = r102;
        BarHide r103 = new BarHide("FLAG_SHOW_BAR", 3);
        FLAG_SHOW_BAR = r103;
        $VALUES = new BarHide[]{r100, r101, r102, r103};
    }

    public static BarHide[] values() {
        return (BarHide[]) $VALUES.clone();
    }

    public static BarHide valueOf(String r100) {
        return (BarHide) a.a(BarHide.class, r100);
    }

    private BarHide(String r100, int r101) {
        super(r100, r101);
    }
}
