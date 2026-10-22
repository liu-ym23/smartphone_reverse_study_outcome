package com.bytedance.ee.bear.lark.sidebar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/lark/sidebar/SidebarCommonMoreId;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SHARE_WITH_ME", "FAVORITES", "SORT", "FILTER", "STYLE", "TEMPLATE", "OFFLINE", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SidebarCommonMoreId extends Enum<SidebarCommonMoreId> {
    public static final SidebarCommonMoreId FAVORITES = null;
    public static final SidebarCommonMoreId FILTER = null;
    public static final SidebarCommonMoreId OFFLINE = null;
    public static final SidebarCommonMoreId SHARE_WITH_ME = null;
    public static final SidebarCommonMoreId SORT = null;
    public static final SidebarCommonMoreId STYLE = null;
    public static final SidebarCommonMoreId TEMPLATE = null;
    public static final /* synthetic */ SidebarCommonMoreId[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SidebarCommonMoreId> getEntries() {
        return b;
    }

    static {
        SidebarCommonMoreId r0 = new SidebarCommonMoreId("SHARE_WITH_ME", 0);
        SHARE_WITH_ME = r0;
        SidebarCommonMoreId r1 = new SidebarCommonMoreId("FAVORITES", 1);
        FAVORITES = r1;
        SidebarCommonMoreId r3 = new SidebarCommonMoreId("SORT", 2);
        SORT = r3;
        SidebarCommonMoreId r5 = new SidebarCommonMoreId("FILTER", 3);
        FILTER = r5;
        SidebarCommonMoreId r7 = new SidebarCommonMoreId("STYLE", 4);
        STYLE = r7;
        SidebarCommonMoreId r9 = new SidebarCommonMoreId("TEMPLATE", 5);
        TEMPLATE = r9;
        SidebarCommonMoreId r11 = new SidebarCommonMoreId("OFFLINE", 6);
        OFFLINE = r11;
        SidebarCommonMoreId[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static SidebarCommonMoreId[] values() {
        return (SidebarCommonMoreId[]) a.clone();
    }

    public static SidebarCommonMoreId valueOf(String r1) {
        return (SidebarCommonMoreId) r27.a.a(SidebarCommonMoreId.class, r1);
    }

    public SidebarCommonMoreId(String r1, int r2) {
        super(r1, r2);
    }
}
