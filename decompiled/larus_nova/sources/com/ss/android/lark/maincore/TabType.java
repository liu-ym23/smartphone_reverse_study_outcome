package com.ss.android.lark.maincore;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum TabType extends Enum<TabType> {
    public static final TabType Main = null;
    public static final TabType Navigation = null;
    public static final TabType Others = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabType[] f431577a = null;

    static {
        TabType r100 = new TabType("Main", 0);
        Main = r100;
        TabType r101 = new TabType("Navigation", 1);
        Navigation = r101;
        TabType r102 = new TabType("Others", 2);
        Others = r102;
        f431577a = new TabType[]{r100, r101, r102};
    }

    public static TabType[] values() {
        return (TabType[]) f431577a.clone();
    }

    public static TabType valueOf(String r100) {
        return (TabType) a.a(TabType.class, r100);
    }

    public TabType(String r100, int r101) {
        super(r100, r101);
    }
}
