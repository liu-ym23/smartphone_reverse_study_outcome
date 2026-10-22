package com.larus.home.impl.main.side_bar.feed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/SideBarFeedCardType;", "", "<init>", "(Ljava/lang/String;I)V", "GROUP_HEADER", "CONVERSATION", "QUICK_ACCESS", "SHOW_ALL", "PROJECT", "PROJECT_EMPTY_ACTION", "PROJECT_CONVERSATION_TITLE", "DATE_HEADER", "HUMAN_FEED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarFeedCardType extends Enum<SideBarFeedCardType> {
    public static final SideBarFeedCardType CONVERSATION = null;
    public static final SideBarFeedCardType DATE_HEADER = null;
    public static final SideBarFeedCardType GROUP_HEADER = null;
    public static final SideBarFeedCardType HUMAN_FEED = null;
    public static final SideBarFeedCardType PROJECT = null;
    public static final SideBarFeedCardType PROJECT_CONVERSATION_TITLE = null;
    public static final SideBarFeedCardType PROJECT_EMPTY_ACTION = null;
    public static final SideBarFeedCardType QUICK_ACCESS = null;
    public static final SideBarFeedCardType SHOW_ALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarFeedCardType[] f344551a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344552b = null;

    public static EnumEntries<SideBarFeedCardType> getEntries() {
        return f344552b;
    }

    static {
        SideBarFeedCardType r100 = new SideBarFeedCardType("GROUP_HEADER", 0);
        GROUP_HEADER = r100;
        SideBarFeedCardType r101 = new SideBarFeedCardType("CONVERSATION", 1);
        CONVERSATION = r101;
        SideBarFeedCardType r102 = new SideBarFeedCardType("QUICK_ACCESS", 2);
        QUICK_ACCESS = r102;
        SideBarFeedCardType r103 = new SideBarFeedCardType("SHOW_ALL", 3);
        SHOW_ALL = r103;
        SideBarFeedCardType r104 = new SideBarFeedCardType("PROJECT", 4);
        PROJECT = r104;
        SideBarFeedCardType r105 = new SideBarFeedCardType("PROJECT_EMPTY_ACTION", 5);
        PROJECT_EMPTY_ACTION = r105;
        SideBarFeedCardType r110 = new SideBarFeedCardType("PROJECT_CONVERSATION_TITLE", 6);
        PROJECT_CONVERSATION_TITLE = r110;
        SideBarFeedCardType r111 = new SideBarFeedCardType("DATE_HEADER", 7);
        DATE_HEADER = r111;
        SideBarFeedCardType r112 = new SideBarFeedCardType("HUMAN_FEED", 8);
        HUMAN_FEED = r112;
        SideBarFeedCardType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f344551a = r113;
        f344552b = EnumEntriesKt.enumEntries(r113);
    }

    public static SideBarFeedCardType[] values() {
        return (SideBarFeedCardType[]) f344551a.clone();
    }

    public static SideBarFeedCardType valueOf(String r100) {
        return (SideBarFeedCardType) a.a(SideBarFeedCardType.class, r100);
    }

    public SideBarFeedCardType(String r100, int r101) {
        super(r100, r101);
    }
}
