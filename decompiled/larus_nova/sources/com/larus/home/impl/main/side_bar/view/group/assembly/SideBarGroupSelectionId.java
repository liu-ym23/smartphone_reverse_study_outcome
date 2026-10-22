package com.larus.home.impl.main.side_bar.view.group.assembly;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/assembly/SideBarGroupSelectionId;", "", "<init>", "(Ljava/lang/String;I)V", "GROUP_POLICY", "SORT_POLICY", "ARCHIVE_FILTER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarGroupSelectionId extends Enum<SideBarGroupSelectionId> {
    public static final SideBarGroupSelectionId ARCHIVE_FILTER = null;
    public static final SideBarGroupSelectionId GROUP_POLICY = null;
    public static final SideBarGroupSelectionId SORT_POLICY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarGroupSelectionId[] f345147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345148b = null;

    public static EnumEntries<SideBarGroupSelectionId> getEntries() {
        return f345148b;
    }

    static {
        SideBarGroupSelectionId r100 = new SideBarGroupSelectionId("GROUP_POLICY", 0);
        GROUP_POLICY = r100;
        SideBarGroupSelectionId r101 = new SideBarGroupSelectionId("SORT_POLICY", 1);
        SORT_POLICY = r101;
        SideBarGroupSelectionId r102 = new SideBarGroupSelectionId("ARCHIVE_FILTER", 2);
        ARCHIVE_FILTER = r102;
        SideBarGroupSelectionId[] r103 = {r100, r101, r102};
        f345147a = r103;
        f345148b = EnumEntriesKt.enumEntries(r103);
    }

    public static SideBarGroupSelectionId[] values() {
        return (SideBarGroupSelectionId[]) f345147a.clone();
    }

    public static SideBarGroupSelectionId valueOf(String r100) {
        return (SideBarGroupSelectionId) r27.a.a(SideBarGroupSelectionId.class, r100);
    }

    public SideBarGroupSelectionId(String r100, int r101) {
        super(r100, r101);
    }
}
