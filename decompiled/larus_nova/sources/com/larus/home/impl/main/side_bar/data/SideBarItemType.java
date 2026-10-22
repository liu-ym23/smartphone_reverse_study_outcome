package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/SideBarItemType;", "", "<init>", "(Ljava/lang/String;I)V", "CONVERSATION", "COMPONENT", "SHOW_ALL", "DIVIDER", "BOTTOM_SPACE", "CASE", "CASE_MORE", "HUMAN_FEED", "QUICK_ACCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarItemType extends Enum<SideBarItemType> {
    public static final SideBarItemType BOTTOM_SPACE = null;
    public static final SideBarItemType CASE = null;
    public static final SideBarItemType CASE_MORE = null;
    public static final SideBarItemType COMPONENT = null;
    public static final SideBarItemType CONVERSATION = null;
    public static final SideBarItemType DIVIDER = null;
    public static final SideBarItemType HUMAN_FEED = null;
    public static final SideBarItemType QUICK_ACCESS = null;
    public static final SideBarItemType SHOW_ALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarItemType[] f344461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344462b = null;

    public static EnumEntries<SideBarItemType> getEntries() {
        return f344462b;
    }

    static {
        SideBarItemType r100 = new SideBarItemType("CONVERSATION", 0);
        CONVERSATION = r100;
        SideBarItemType r101 = new SideBarItemType("COMPONENT", 1);
        COMPONENT = r101;
        SideBarItemType r102 = new SideBarItemType("SHOW_ALL", 2);
        SHOW_ALL = r102;
        SideBarItemType r103 = new SideBarItemType("DIVIDER", 3);
        DIVIDER = r103;
        SideBarItemType r104 = new SideBarItemType("BOTTOM_SPACE", 4);
        BOTTOM_SPACE = r104;
        SideBarItemType r105 = new SideBarItemType("CASE", 5);
        CASE = r105;
        SideBarItemType r110 = new SideBarItemType("CASE_MORE", 6);
        CASE_MORE = r110;
        SideBarItemType r111 = new SideBarItemType("HUMAN_FEED", 7);
        HUMAN_FEED = r111;
        SideBarItemType r112 = new SideBarItemType("QUICK_ACCESS", 8);
        QUICK_ACCESS = r112;
        SideBarItemType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f344461a = r113;
        f344462b = EnumEntriesKt.enumEntries(r113);
    }

    public static SideBarItemType[] values() {
        return (SideBarItemType[]) f344461a.clone();
    }

    public static SideBarItemType valueOf(String r100) {
        return (SideBarItemType) r27.a.a(SideBarItemType.class, r100);
    }

    public SideBarItemType(String r100, int r101) {
        super(r100, r101);
    }
}
