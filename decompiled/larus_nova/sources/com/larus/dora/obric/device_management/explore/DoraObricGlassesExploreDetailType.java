package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreDetailType;", "", "<init>", "(Ljava/lang/String;I)V", "INTRODUCTION", "BASIC_LIST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesExploreDetailType extends Enum<DoraObricGlassesExploreDetailType> {
    public static final DoraObricGlassesExploreDetailType BASIC_LIST = null;
    public static final DoraObricGlassesExploreDetailType INTRODUCTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGlassesExploreDetailType[] f339474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339475b = null;

    public static EnumEntries<DoraObricGlassesExploreDetailType> getEntries() {
        return f339475b;
    }

    static {
        DoraObricGlassesExploreDetailType r100 = new DoraObricGlassesExploreDetailType("INTRODUCTION", 0);
        INTRODUCTION = r100;
        DoraObricGlassesExploreDetailType r101 = new DoraObricGlassesExploreDetailType("BASIC_LIST", 1);
        BASIC_LIST = r101;
        DoraObricGlassesExploreDetailType[] r102 = {r100, r101};
        f339474a = r102;
        f339475b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraObricGlassesExploreDetailType[] values() {
        return (DoraObricGlassesExploreDetailType[]) f339474a.clone();
    }

    public static DoraObricGlassesExploreDetailType valueOf(String r100) {
        return (DoraObricGlassesExploreDetailType) r27.a.a(DoraObricGlassesExploreDetailType.class, r100);
    }

    public DoraObricGlassesExploreDetailType(String r100, int r101) {
        super(r100, r101);
    }
}
