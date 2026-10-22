package com.larus.home.impl.main.side_bar.view.group.assembly;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/assembly/SideBarGroupToggleId;", "", "<init>", "(Ljava/lang/String;I)V", "SOCIAL_INDEPENDENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarGroupToggleId extends Enum<SideBarGroupToggleId> {
    public static final SideBarGroupToggleId SOCIAL_INDEPENDENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarGroupToggleId[] f345149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345150b = null;

    public static EnumEntries<SideBarGroupToggleId> getEntries() {
        return f345150b;
    }

    static {
        SideBarGroupToggleId r100 = new SideBarGroupToggleId();
        SOCIAL_INDEPENDENT = r100;
        SideBarGroupToggleId[] r101 = {r100};
        f345149a = r101;
        f345150b = EnumEntriesKt.enumEntries(r101);
    }

    public SideBarGroupToggleId() {
        super("SOCIAL_INDEPENDENT", 0);
    }

    public static SideBarGroupToggleId[] values() {
        return (SideBarGroupToggleId[]) f345149a.clone();
    }

    public static SideBarGroupToggleId valueOf(String r100) {
        return (SideBarGroupToggleId) r27.a.a(SideBarGroupToggleId.class, r100);
    }
}
