package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarEmptyState;", "", "<init>", "(Ljava/lang/String;I)V", "ERROR", "EMPTY", "OK", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SidebarEmptyState extends Enum<SidebarEmptyState> {
    public static final SidebarEmptyState EMPTY = null;
    public static final SidebarEmptyState ERROR = null;
    public static final SidebarEmptyState OK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SidebarEmptyState[] f241261a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f241262b = null;

    public static EnumEntries<SidebarEmptyState> getEntries() {
        return f241262b;
    }

    static {
        SidebarEmptyState r100 = new SidebarEmptyState("ERROR", 0);
        ERROR = r100;
        SidebarEmptyState r101 = new SidebarEmptyState("EMPTY", 1);
        EMPTY = r101;
        SidebarEmptyState r102 = new SidebarEmptyState("OK", 2);
        OK = r102;
        SidebarEmptyState[] r103 = {r100, r101, r102};
        f241261a = r103;
        f241262b = EnumEntriesKt.enumEntries(r103);
    }

    public static SidebarEmptyState[] values() {
        return (SidebarEmptyState[]) f241261a.clone();
    }

    public static SidebarEmptyState valueOf(String r100) {
        return (SidebarEmptyState) r27.a.a(SidebarEmptyState.class, r100);
    }

    public SidebarEmptyState(String r100, int r101) {
        super(r100, r101);
    }
}
