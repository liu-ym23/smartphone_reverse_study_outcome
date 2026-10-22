package com.obric.assistant.cocreationreview.modules.memory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/DiffType;", "", "<init>", "(Ljava/lang/String;I)V", "EQUAL", "INSERT", "DELETE", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DiffType extends Enum<DiffType> {
    public static final DiffType DELETE = null;
    public static final DiffType EQUAL = null;
    public static final DiffType INSERT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiffType[] f387395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387396b = null;

    public static EnumEntries<DiffType> getEntries() {
        return f387396b;
    }

    static {
        DiffType r100 = new DiffType("EQUAL", 0);
        EQUAL = r100;
        DiffType r101 = new DiffType("INSERT", 1);
        INSERT = r101;
        DiffType r102 = new DiffType("DELETE", 2);
        DELETE = r102;
        DiffType[] r103 = {r100, r101, r102};
        f387395a = r103;
        f387396b = EnumEntriesKt.enumEntries(r103);
    }

    public static DiffType[] values() {
        return (DiffType[]) f387395a.clone();
    }

    public static DiffType valueOf(String r100) {
        return (DiffType) r27.a.a(DiffType.class, r100);
    }

    public DiffType(String r100, int r101) {
        super(r100, r101);
    }
}
