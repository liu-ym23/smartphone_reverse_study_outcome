package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreActionStateType;", "", "<init>", "(Ljava/lang/String;I)V", "NATURAL_WAKE", "DIARY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesExploreActionStateType extends Enum<DoraObricGlassesExploreActionStateType> {
    public static final DoraObricGlassesExploreActionStateType DIARY = null;
    public static final DoraObricGlassesExploreActionStateType NATURAL_WAKE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGlassesExploreActionStateType[] f339460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339461b = null;

    public static EnumEntries<DoraObricGlassesExploreActionStateType> getEntries() {
        return f339461b;
    }

    static {
        DoraObricGlassesExploreActionStateType r100 = new DoraObricGlassesExploreActionStateType("NATURAL_WAKE", 0);
        NATURAL_WAKE = r100;
        DoraObricGlassesExploreActionStateType r101 = new DoraObricGlassesExploreActionStateType("DIARY", 1);
        DIARY = r101;
        DoraObricGlassesExploreActionStateType[] r102 = {r100, r101};
        f339460a = r102;
        f339461b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraObricGlassesExploreActionStateType[] values() {
        return (DoraObricGlassesExploreActionStateType[]) f339460a.clone();
    }

    public static DoraObricGlassesExploreActionStateType valueOf(String r100) {
        return (DoraObricGlassesExploreActionStateType) r27.a.a(DoraObricGlassesExploreActionStateType.class, r100);
    }

    public DoraObricGlassesExploreActionStateType(String r100, int r101) {
        super(r100, r101);
    }
}
