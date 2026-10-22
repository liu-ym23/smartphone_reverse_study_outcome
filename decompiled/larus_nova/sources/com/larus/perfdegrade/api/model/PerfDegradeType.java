package com.larus.perfdegrade.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/perfdegrade/api/model/PerfDegradeType;", "", "<init>", "(Ljava/lang/String;I)V", "JANK", "DISK_OCCUPANCY", "SCROLL_JANK", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PerfDegradeType extends Enum<PerfDegradeType> {
    public static final PerfDegradeType DISK_OCCUPANCY = null;
    public static final PerfDegradeType JANK = null;
    public static final PerfDegradeType SCROLL_JANK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerfDegradeType[] f363960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f363961b = null;

    public static EnumEntries<PerfDegradeType> getEntries() {
        return f363961b;
    }

    static {
        PerfDegradeType r100 = new PerfDegradeType("JANK", 0);
        JANK = r100;
        PerfDegradeType r101 = new PerfDegradeType("DISK_OCCUPANCY", 1);
        DISK_OCCUPANCY = r101;
        PerfDegradeType r102 = new PerfDegradeType("SCROLL_JANK", 2);
        SCROLL_JANK = r102;
        PerfDegradeType[] r103 = {r100, r101, r102};
        f363960a = r103;
        f363961b = EnumEntriesKt.enumEntries(r103);
    }

    public static PerfDegradeType[] values() {
        return (PerfDegradeType[]) f363960a.clone();
    }

    public static PerfDegradeType valueOf(String r100) {
        return (PerfDegradeType) a.a(PerfDegradeType.class, r100);
    }

    public PerfDegradeType(String r100, int r101) {
        super(r100, r101);
    }
}
