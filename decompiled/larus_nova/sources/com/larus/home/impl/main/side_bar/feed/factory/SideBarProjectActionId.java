package com.larus.home.impl.main.side_bar.feed.factory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/factory/SideBarProjectActionId;", "", "<init>", "(Ljava/lang/String;I)V", "PIN", "EDIT_NAME", "CREATE_CONVERSATION", "HIDE_CONVERSATIONS", "REMOVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarProjectActionId extends Enum<SideBarProjectActionId> {
    public static final SideBarProjectActionId CREATE_CONVERSATION = null;
    public static final SideBarProjectActionId EDIT_NAME = null;
    public static final SideBarProjectActionId HIDE_CONVERSATIONS = null;
    public static final SideBarProjectActionId PIN = null;
    public static final SideBarProjectActionId REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarProjectActionId[] f344705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344706b = null;

    public static EnumEntries<SideBarProjectActionId> getEntries() {
        return f344706b;
    }

    static {
        SideBarProjectActionId r100 = new SideBarProjectActionId("PIN", 0);
        PIN = r100;
        SideBarProjectActionId r101 = new SideBarProjectActionId("EDIT_NAME", 1);
        EDIT_NAME = r101;
        SideBarProjectActionId r102 = new SideBarProjectActionId("CREATE_CONVERSATION", 2);
        CREATE_CONVERSATION = r102;
        SideBarProjectActionId r103 = new SideBarProjectActionId("HIDE_CONVERSATIONS", 3);
        HIDE_CONVERSATIONS = r103;
        SideBarProjectActionId r104 = new SideBarProjectActionId("REMOVE", 4);
        REMOVE = r104;
        SideBarProjectActionId[] r105 = {r100, r101, r102, r103, r104};
        f344705a = r105;
        f344706b = EnumEntriesKt.enumEntries(r105);
    }

    public static SideBarProjectActionId[] values() {
        return (SideBarProjectActionId[]) f344705a.clone();
    }

    public static SideBarProjectActionId valueOf(String r100) {
        return (SideBarProjectActionId) a.a(SideBarProjectActionId.class, r100);
    }

    public SideBarProjectActionId(String r100, int r101) {
        super(r100, r101);
    }
}
