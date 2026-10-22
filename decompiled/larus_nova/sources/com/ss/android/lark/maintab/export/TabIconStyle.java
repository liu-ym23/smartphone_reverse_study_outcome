package com.ss.android.lark.maintab.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabIconStyle;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CENTER", "FULL", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabIconStyle extends Enum<TabIconStyle> {
    public static final TabIconStyle CENTER = null;
    public static final TabIconStyle FULL = null;
    public static final TabIconStyle UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabIconStyle[] f431599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431600b = null;

    public static EnumEntries<TabIconStyle> getEntries() {
        return f431600b;
    }

    static {
        TabIconStyle r100 = new TabIconStyle("UNKNOWN", 0);
        UNKNOWN = r100;
        TabIconStyle r101 = new TabIconStyle("CENTER", 1);
        CENTER = r101;
        TabIconStyle r102 = new TabIconStyle("FULL", 2);
        FULL = r102;
        TabIconStyle[] r103 = {r100, r101, r102};
        f431599a = r103;
        f431600b = EnumEntriesKt.enumEntries(r103);
    }

    public static TabIconStyle[] values() {
        return (TabIconStyle[]) f431599a.clone();
    }

    public static TabIconStyle valueOf(String r100) {
        return (TabIconStyle) r27.a.a(TabIconStyle.class, r100);
    }

    public TabIconStyle(String r100, int r101) {
        super(r100, r101);
    }
}
