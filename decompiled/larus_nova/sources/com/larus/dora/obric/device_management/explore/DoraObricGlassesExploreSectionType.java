package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreSectionType;", "", "<init>", "(Ljava/lang/String;I)V", "WAKEUP", "MEMORY", "MORE", "BASIC", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesExploreSectionType extends Enum<DoraObricGlassesExploreSectionType> {
    public static final DoraObricGlassesExploreSectionType BASIC = null;
    public static final DoraObricGlassesExploreSectionType MEMORY = null;
    public static final DoraObricGlassesExploreSectionType MORE = null;
    public static final DoraObricGlassesExploreSectionType WAKEUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGlassesExploreSectionType[] f339486a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339487b = null;

    public static EnumEntries<DoraObricGlassesExploreSectionType> getEntries() {
        return f339487b;
    }

    static {
        DoraObricGlassesExploreSectionType r100 = new DoraObricGlassesExploreSectionType("WAKEUP", 0);
        WAKEUP = r100;
        DoraObricGlassesExploreSectionType r101 = new DoraObricGlassesExploreSectionType("MEMORY", 1);
        MEMORY = r101;
        DoraObricGlassesExploreSectionType r102 = new DoraObricGlassesExploreSectionType("MORE", 2);
        MORE = r102;
        DoraObricGlassesExploreSectionType r103 = new DoraObricGlassesExploreSectionType("BASIC", 3);
        BASIC = r103;
        DoraObricGlassesExploreSectionType[] r104 = {r100, r101, r102, r103};
        f339486a = r104;
        f339487b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraObricGlassesExploreSectionType[] values() {
        return (DoraObricGlassesExploreSectionType[]) f339486a.clone();
    }

    public static DoraObricGlassesExploreSectionType valueOf(String r100) {
        return (DoraObricGlassesExploreSectionType) r27.a.a(DoraObricGlassesExploreSectionType.class, r100);
    }

    public DoraObricGlassesExploreSectionType(String r100, int r101) {
        super(r100, r101);
    }
}
