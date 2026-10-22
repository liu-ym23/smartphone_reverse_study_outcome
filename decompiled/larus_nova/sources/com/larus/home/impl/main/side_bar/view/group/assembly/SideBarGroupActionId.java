package com.larus.home.impl.main.side_bar.view.group.assembly;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/assembly/SideBarGroupActionId;", "", "<init>", "(Ljava/lang/String;I)V", "ARCHIVE_TIME_GROUP", "COLLAPSE_ALL_PROJECTS", "EXPAND_ALL_PROJECTS", "CREATE_BLANK_PROJECT", "CREATE_GROUP_CHAT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarGroupActionId extends Enum<SideBarGroupActionId> {
    public static final SideBarGroupActionId ARCHIVE_TIME_GROUP = null;
    public static final SideBarGroupActionId COLLAPSE_ALL_PROJECTS = null;
    public static final SideBarGroupActionId CREATE_BLANK_PROJECT = null;
    public static final SideBarGroupActionId CREATE_GROUP_CHAT = null;
    public static final SideBarGroupActionId EXPAND_ALL_PROJECTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarGroupActionId[] f345142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345143b = null;

    public static EnumEntries<SideBarGroupActionId> getEntries() {
        return f345143b;
    }

    static {
        SideBarGroupActionId r100 = new SideBarGroupActionId("ARCHIVE_TIME_GROUP", 0);
        ARCHIVE_TIME_GROUP = r100;
        SideBarGroupActionId r101 = new SideBarGroupActionId("COLLAPSE_ALL_PROJECTS", 1);
        COLLAPSE_ALL_PROJECTS = r101;
        SideBarGroupActionId r102 = new SideBarGroupActionId("EXPAND_ALL_PROJECTS", 2);
        EXPAND_ALL_PROJECTS = r102;
        SideBarGroupActionId r103 = new SideBarGroupActionId("CREATE_BLANK_PROJECT", 3);
        CREATE_BLANK_PROJECT = r103;
        SideBarGroupActionId r104 = new SideBarGroupActionId("CREATE_GROUP_CHAT", 4);
        CREATE_GROUP_CHAT = r104;
        SideBarGroupActionId[] r105 = {r100, r101, r102, r103, r104};
        f345142a = r105;
        f345143b = EnumEntriesKt.enumEntries(r105);
    }

    public static SideBarGroupActionId[] values() {
        return (SideBarGroupActionId[]) f345142a.clone();
    }

    public static SideBarGroupActionId valueOf(String r100) {
        return (SideBarGroupActionId) r27.a.a(SideBarGroupActionId.class, r100);
    }

    public SideBarGroupActionId(String r100, int r101) {
        super(r100, r101);
    }
}
