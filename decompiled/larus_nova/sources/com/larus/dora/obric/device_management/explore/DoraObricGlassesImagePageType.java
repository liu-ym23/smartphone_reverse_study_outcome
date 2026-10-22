package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImagePageType;", "", "<init>", "(Ljava/lang/String;I)V", "EXPLORE", "DETAIL", "BASIC_DETAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesImagePageType extends Enum<DoraObricGlassesImagePageType> {
    public static final DoraObricGlassesImagePageType BASIC_DETAIL = null;
    public static final DoraObricGlassesImagePageType DETAIL = null;
    public static final DoraObricGlassesImagePageType EXPLORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGlassesImagePageType[] f339488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339489b = null;

    public static EnumEntries<DoraObricGlassesImagePageType> getEntries() {
        return f339489b;
    }

    static {
        DoraObricGlassesImagePageType r100 = new DoraObricGlassesImagePageType("EXPLORE", 0);
        EXPLORE = r100;
        DoraObricGlassesImagePageType r101 = new DoraObricGlassesImagePageType("DETAIL", 1);
        DETAIL = r101;
        DoraObricGlassesImagePageType r102 = new DoraObricGlassesImagePageType("BASIC_DETAIL", 2);
        BASIC_DETAIL = r102;
        DoraObricGlassesImagePageType[] r103 = {r100, r101, r102};
        f339488a = r103;
        f339489b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraObricGlassesImagePageType[] values() {
        return (DoraObricGlassesImagePageType[]) f339488a.clone();
    }

    public static DoraObricGlassesImagePageType valueOf(String r100) {
        return (DoraObricGlassesImagePageType) r27.a.a(DoraObricGlassesImagePageType.class, r100);
    }

    public DoraObricGlassesImagePageType(String r100, int r101) {
        super(r100, r101);
    }
}
