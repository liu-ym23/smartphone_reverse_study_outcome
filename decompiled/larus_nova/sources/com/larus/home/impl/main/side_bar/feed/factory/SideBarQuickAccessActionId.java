package com.larus.home.impl.main.side_bar.feed.factory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/factory/SideBarQuickAccessActionId;", "", "<init>", "(Ljava/lang/String;I)V", "UNPIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarQuickAccessActionId extends Enum<SideBarQuickAccessActionId> {
    public static final SideBarQuickAccessActionId UNPIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarQuickAccessActionId[] f344709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344710b = null;

    public static EnumEntries<SideBarQuickAccessActionId> getEntries() {
        return f344710b;
    }

    static {
        SideBarQuickAccessActionId r100 = new SideBarQuickAccessActionId();
        UNPIN = r100;
        SideBarQuickAccessActionId[] r101 = {r100};
        f344709a = r101;
        f344710b = EnumEntriesKt.enumEntries(r101);
    }

    public SideBarQuickAccessActionId() {
        super("UNPIN", 0);
    }

    public static SideBarQuickAccessActionId[] values() {
        return (SideBarQuickAccessActionId[]) f344709a.clone();
    }

    public static SideBarQuickAccessActionId valueOf(String r100) {
        return (SideBarQuickAccessActionId) a.a(SideBarQuickAccessActionId.class, r100);
    }
}
