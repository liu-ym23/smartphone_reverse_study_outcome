package com.bytedance.kmp.performance.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/performance/api/KPerfStatus;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_FRAME", "SECOND_FRAME", "SCROLLING", "IDLE", "performance_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KPerfStatus extends Enum<KPerfStatus> {
    public static final KPerfStatus FIRST_FRAME = null;
    public static final KPerfStatus IDLE = null;
    public static final KPerfStatus SCROLLING = null;
    public static final KPerfStatus SECOND_FRAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KPerfStatus[] f252590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252591b = null;

    public static EnumEntries<KPerfStatus> getEntries() {
        return f252591b;
    }

    static {
        KPerfStatus r100 = new KPerfStatus("FIRST_FRAME", 0);
        FIRST_FRAME = r100;
        KPerfStatus r101 = new KPerfStatus("SECOND_FRAME", 1);
        SECOND_FRAME = r101;
        KPerfStatus r102 = new KPerfStatus("SCROLLING", 2);
        SCROLLING = r102;
        KPerfStatus r103 = new KPerfStatus("IDLE", 3);
        IDLE = r103;
        KPerfStatus[] r104 = {r100, r101, r102, r103};
        f252590a = r104;
        f252591b = EnumEntriesKt.enumEntries(r104);
    }

    public static KPerfStatus[] values() {
        return (KPerfStatus[]) f252590a.clone();
    }

    public static KPerfStatus valueOf(String r100) {
        return (KPerfStatus) r27.a.a(KPerfStatus.class, r100);
    }

    public KPerfStatus(String r100, int r101) {
        super(r100, r101);
    }
}
