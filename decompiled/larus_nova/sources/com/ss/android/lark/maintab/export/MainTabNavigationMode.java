package com.ss.android.lark.maintab.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/maintab/export/MainTabNavigationMode;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM_MODE", "LEFT_NARROW_MODE", "LEFT_WIDE_MODE", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MainTabNavigationMode extends Enum<MainTabNavigationMode> {
    public static final MainTabNavigationMode BOTTOM_MODE = null;
    public static final MainTabNavigationMode LEFT_NARROW_MODE = null;
    public static final MainTabNavigationMode LEFT_WIDE_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MainTabNavigationMode[] f431587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431588b = null;

    public static EnumEntries<MainTabNavigationMode> getEntries() {
        return f431588b;
    }

    static {
        MainTabNavigationMode r100 = new MainTabNavigationMode("BOTTOM_MODE", 0);
        BOTTOM_MODE = r100;
        MainTabNavigationMode r101 = new MainTabNavigationMode("LEFT_NARROW_MODE", 1);
        LEFT_NARROW_MODE = r101;
        MainTabNavigationMode r102 = new MainTabNavigationMode("LEFT_WIDE_MODE", 2);
        LEFT_WIDE_MODE = r102;
        MainTabNavigationMode[] r103 = {r100, r101, r102};
        f431587a = r103;
        f431588b = EnumEntriesKt.enumEntries(r103);
    }

    public static MainTabNavigationMode[] values() {
        return (MainTabNavigationMode[]) f431587a.clone();
    }

    public static MainTabNavigationMode valueOf(String r100) {
        return (MainTabNavigationMode) r27.a.a(MainTabNavigationMode.class, r100);
    }

    public MainTabNavigationMode(String r100, int r101) {
        super(r100, r101);
    }
}
