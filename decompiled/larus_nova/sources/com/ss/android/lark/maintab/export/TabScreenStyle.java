package com.ss.android.lark.maintab.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabScreenStyle;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "TAB_FULL_WITH_AUTO_SPLIT", "FULLSCREEN", "FULLSCREEN_IMMERSIVE", "PAGE_FULL_WITH_AUTO_SPLIT", "ONLY_TAB_FULL_WITH_ALL_PAGE_FULL", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabScreenStyle extends Enum<TabScreenStyle> {
    public static final TabScreenStyle DEFAULT = null;
    public static final TabScreenStyle FULLSCREEN = null;
    public static final TabScreenStyle FULLSCREEN_IMMERSIVE = null;
    public static final TabScreenStyle ONLY_TAB_FULL_WITH_ALL_PAGE_FULL = null;
    public static final TabScreenStyle PAGE_FULL_WITH_AUTO_SPLIT = null;
    public static final TabScreenStyle TAB_FULL_WITH_AUTO_SPLIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabScreenStyle[] f431601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431602b = null;

    public static EnumEntries<TabScreenStyle> getEntries() {
        return f431602b;
    }

    static {
        TabScreenStyle r100 = new TabScreenStyle("DEFAULT", 0);
        DEFAULT = r100;
        TabScreenStyle r101 = new TabScreenStyle("TAB_FULL_WITH_AUTO_SPLIT", 1);
        TAB_FULL_WITH_AUTO_SPLIT = r101;
        TabScreenStyle r102 = new TabScreenStyle("FULLSCREEN", 2);
        FULLSCREEN = r102;
        TabScreenStyle r103 = new TabScreenStyle("FULLSCREEN_IMMERSIVE", 3);
        FULLSCREEN_IMMERSIVE = r103;
        TabScreenStyle r104 = new TabScreenStyle("PAGE_FULL_WITH_AUTO_SPLIT", 4);
        PAGE_FULL_WITH_AUTO_SPLIT = r104;
        TabScreenStyle r105 = new TabScreenStyle("ONLY_TAB_FULL_WITH_ALL_PAGE_FULL", 5);
        ONLY_TAB_FULL_WITH_ALL_PAGE_FULL = r105;
        TabScreenStyle[] r110 = {r100, r101, r102, r103, r104, r105};
        f431601a = r110;
        f431602b = EnumEntriesKt.enumEntries(r110);
    }

    public static TabScreenStyle[] values() {
        return (TabScreenStyle[]) f431601a.clone();
    }

    public static TabScreenStyle valueOf(String r100) {
        return (TabScreenStyle) r27.a.a(TabScreenStyle.class, r100);
    }

    public TabScreenStyle(String r100, int r101) {
        super(r100, r101);
    }
}
