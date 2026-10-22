package com.ss.android.lark.preload.v2.condition.clean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/clean/MemoryLow$MemoryState;", "", "<init>", "(Ljava/lang/String;I)V", "CRITICAL", "MODERATE", "LOW", "UNKNOWN", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryLow$MemoryState extends Enum<MemoryLow$MemoryState> {
    public static final MemoryLow$MemoryState CRITICAL = null;
    public static final MemoryLow$MemoryState LOW = null;
    public static final MemoryLow$MemoryState MODERATE = null;
    public static final MemoryLow$MemoryState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryLow$MemoryState[] f438815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438816b = null;

    public static EnumEntries<MemoryLow$MemoryState> getEntries() {
        return f438816b;
    }

    static {
        MemoryLow$MemoryState r100 = new MemoryLow$MemoryState("CRITICAL", 0);
        CRITICAL = r100;
        MemoryLow$MemoryState r101 = new MemoryLow$MemoryState("MODERATE", 1);
        MODERATE = r101;
        MemoryLow$MemoryState r102 = new MemoryLow$MemoryState("LOW", 2);
        LOW = r102;
        MemoryLow$MemoryState r103 = new MemoryLow$MemoryState("UNKNOWN", 3);
        UNKNOWN = r103;
        MemoryLow$MemoryState[] r104 = {r100, r101, r102, r103};
        f438815a = r104;
        f438816b = EnumEntriesKt.enumEntries(r104);
    }

    public static MemoryLow$MemoryState[] values() {
        return (MemoryLow$MemoryState[]) f438815a.clone();
    }

    public static MemoryLow$MemoryState valueOf(String r100) {
        return (MemoryLow$MemoryState) a.a(MemoryLow$MemoryState.class, r100);
    }

    public MemoryLow$MemoryState(String r100, int r101) {
        super(r100, r101);
    }
}
